package org.kie.kogito.test;

import java.util.Optional;
import java.util.TimeZone;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.kogito.event.DataEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.github.javaparser.ast.body.MethodDeclaration;

@javax.enterprise.context.ApplicationScoped()
public class TransactionsMessageProducer_3 {

    @javax.inject.Inject()
    @io.smallrye.reactive.messaging.annotations.Channel("manualmodedecisions")
    io.smallrye.reactive.messaging.annotations.Emitter<String> emitter;

    @org.eclipse.microprofile.config.inject.ConfigProperty(name = "kogito.messaging.as-cloudevents")
    Optional<Boolean> useCloudEvents = Optional.of(true);

    private ObjectMapper json = new ObjectMapper();

    {
        json.setDateFormat(new StdDateFormat().withColonInTimeZone(true).withTimeZone(TimeZone.getDefault()));
    }

    @javax.annotation.PostConstruct()
    public void configure() {
    }

    public void produce(ProcessInstance pi, org.redhat.appdev.Transaction eventData) {
        emitter.send(this.marshall(pi, eventData));
    }

    private String marshall(ProcessInstance pi, org.redhat.appdev.Transaction eventData) {
        try {
            if (useCloudEvents.orElse(true)) {
                TransactionsMessageDataEvent_3 event = new TransactionsMessageDataEvent_3("", eventData, pi.getId(), pi.getParentProcessInstanceId(), pi.getRootProcessInstanceId(), pi.getProcessId(), pi.getRootProcessId(), String.valueOf(pi.getState()));
                if (pi.getReferenceId() != null && !pi.getReferenceId().isEmpty()) {
                    event.setKogitoReferenceId(pi.getReferenceId());
                }
                return json.writeValueAsString(event);
            } else {
                return json.writeValueAsString(eventData);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
