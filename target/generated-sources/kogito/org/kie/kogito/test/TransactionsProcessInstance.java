package org.kie.kogito.test;

public class TransactionsProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<TransactionsModel> {

    public TransactionsProcessInstance(org.kie.kogito.test.TransactionsProcess process, TransactionsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public TransactionsProcessInstance(org.kie.kogito.test.TransactionsProcess process, TransactionsModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    protected java.util.Map<String, Object> bind(TransactionsModel variables) {
        return variables.toMap();
    }

    protected void unbind(TransactionsModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
