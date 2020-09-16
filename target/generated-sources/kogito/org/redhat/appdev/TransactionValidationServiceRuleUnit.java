package org.redhat.appdev;

import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.RuleEventListenerConfig;
import org.kie.kogito.rules.units.impl.AbstractRuleUnit;

@javax.inject.Singleton()
public class TransactionValidationServiceRuleUnit extends AbstractRuleUnit<TransactionValidationService> {

    public TransactionValidationServiceRuleUnit() {
        this(new org.kie.kogito.app.Application());
    }

    @javax.inject.Inject()
    public TransactionValidationServiceRuleUnit(org.kie.kogito.Application app) {
        super(app);
    }

    public org.redhat.appdev.TransactionValidationServiceRuleUnitInstance internalCreateInstance(TransactionValidationService value) {
        return new org.redhat.appdev.TransactionValidationServiceRuleUnitInstance(this, value, createLegacySession());
    }

    private KieSession createLegacySession() {
        KieSession ks = app.ruleUnits().ruleRuntimeBuilder().newKieSession(TransactionValidationService.class);
        ((org.drools.core.impl.StatefulKnowledgeSessionImpl) ks).setApplication(app);
        if (app.config() != null && app.config().rule() != null) {
            RuleEventListenerConfig ruleEventListenerConfig = app.config().rule().ruleEventListeners();
            ruleEventListenerConfig.agendaListeners().forEach(ks::addEventListener);
            ruleEventListenerConfig.ruleRuntimeListeners().forEach(ks::addEventListener);
        }
        return ks;
    }
}
