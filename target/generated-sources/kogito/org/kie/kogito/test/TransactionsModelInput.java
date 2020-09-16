package org.kie.kogito.test;

import java.util.Map;
import java.util.HashMap;

@org.kie.internal.kogito.codegen.Generated(value = "kogito-codegen", reference = "Transactions", name = "Transactions", hidden = true)
public class TransactionsModelInput implements org.kie.kogito.Model {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap();
        params.put("transaction", this.transaction);
        return params;
    }

    @Override
    public void fromMap(Map<String, Object> params) {
        fromMap(null, params);
    }

    public void fromMap(String id, Map<String, Object> params) {
        this.transaction = (org.redhat.appdev.Transaction) params.get("transaction");
    }

    @org.kie.internal.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "transaction")
    private org.redhat.appdev.Transaction transaction;

    public org.redhat.appdev.Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(org.redhat.appdev.Transaction transaction) {
        this.transaction = transaction;
    }
}
