package org.kie.kogito.test;

import java.util.TimeZone;
import java.util.Optional;
import org.kie.kogito.Application;
import org.kie.kogito.event.DataEvent;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.impl.Sig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.kie.kogito.test.TransactionsModel;

@javax.enterprise.context.ApplicationScoped()
public class TransactionsMessageConsumer_8 {

    private static final Logger LOGGER = LoggerFactory.getLogger("MessageConsumer");

    @javax.inject.Inject()
    @javax.inject.Named("Transactions")
    Process<TransactionsModel> process;

    @javax.inject.Inject()
    Application application;

    @org.eclipse.microprofile.config.inject.ConfigProperty(name = "kogito.messaging.as-cloudevents")
    Optional<Boolean> useCloudEvents = Optional.of(true);

    private ObjectMapper json = new ObjectMapper();

    {
        json.setDateFormat(new StdDateFormat().withColonInTimeZone(true).withTimeZone(TimeZone.getDefault()));
    }

    @javax.annotation.PostConstruct()
    public void configure() {
    }

    @org.eclipse.microprofile.reactive.messaging.Incoming("rawtransactions")
    public void consume(String payload) {
        final String trigger = "rawtransactions";
        try {
            if (useCloudEvents.orElse(true)) {
                final TransactionsMessageDataEvent_8 eventData = json.readValue(payload, TransactionsMessageDataEvent_8.class);
                final TransactionsModel model = new TransactionsModel();
                model.setTransaction(eventData.getData());
                org.kie.kogito.services.uow.UnitOfWorkExecutor.executeInUnitOfWork(application.unitOfWorkManager(), () -> {
                    if (eventData.getKogitoReferenceId() != null) {
                        LOGGER.debug("Received message with reference id '{}' going to use it to send signal '{}'", eventData.getKogitoReferenceId(), trigger);
                        process.instances().findById(eventData.getKogitoReferenceId()).ifPresent(pi -> pi.send(Sig.of("Message-" + trigger, eventData.getData(), eventData.getKogitoProcessinstanceId())));
                    } else {
                        LOGGER.debug("Received message without reference id, staring new process instance with trigger '{}'", trigger);
                        ProcessInstance<TransactionsModel> pi = process.createInstance(model);
                        if (eventData.getKogitoStartFromNode() != null) {
                            pi.startFrom(eventData.getKogitoStartFromNode(), eventData.getKogitoProcessinstanceId());
                        } else {
                            pi.start(trigger, eventData.getKogitoProcessinstanceId());
                        }
                    }
                    return null;
                });
            } else {
                final org.redhat.appdev.Transaction eventData = json.readValue(payload, org.redhat.appdev.Transaction.class);
                final TransactionsModel model = new TransactionsModel();
                model.setTransaction(eventData);
                org.kie.kogito.services.uow.UnitOfWorkExecutor.executeInUnitOfWork(application.unitOfWorkManager(), () -> {
                    LOGGER.debug("Received message without reference id, staring new process instance with trigger '{}'", trigger);
                    ProcessInstance<TransactionsModel> pi = process.createInstance(model);
                    pi.start(trigger, null);
                    return null;
                });
            }
        } catch (Exception e) {
            LOGGER.error("Error when consuming message for process {}", process.id(), e);
        }
    }
}
