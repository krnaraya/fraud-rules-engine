package org.redhat.appdev;

public class TransactionValidationServiceRuleUnitInstance extends org.kie.kogito.rules.units.AbstractRuleUnitInstance<org.redhat.appdev.TransactionValidationService> {

    public TransactionValidationServiceRuleUnitInstance(org.kie.kogito.rules.RuleUnit<org.redhat.appdev.TransactionValidationService> unit, org.redhat.appdev.TransactionValidationService value, org.kie.api.runtime.KieSession session) {
        super(unit, value, session);
    }

    @Override()
    protected void bind(org.kie.api.runtime.KieSession runtime, org.redhat.appdev.TransactionValidationService value) {
        value.getTransaction().subscribe(new org.kie.kogito.rules.units.EntryPointDataProcessor(runtime.getEntryPoint("transaction")));
        runtime.setGlobal("transaction", value.getTransaction());
    }
}
