package org.kie.kogito.test;

import org.kie.kogito.services.event.AbstractProcessDataEvent;

public class TransactionsMessageDataEvent_1 extends AbstractProcessDataEvent<org.redhat.appdev.Transaction> {

    private String kogitoStartFromNode;

    public TransactionsMessageDataEvent_1() {
        super(null, null, null, null, null, null, null, null, null);
    }

    public TransactionsMessageDataEvent_1(String source, org.redhat.appdev.Transaction body, String kogitoProcessinstanceId, String kogitoParentProcessinstanceId, String kogitoRootProcessinstanceId, String kogitoProcessId, String kogitoRootProcessId, String kogitoProcessinstanceState) {
        super(source, body, kogitoProcessinstanceId, kogitoParentProcessinstanceId, kogitoRootProcessinstanceId, kogitoProcessId, kogitoRootProcessId, kogitoProcessinstanceState, null);
    }

    public void setKogitoStartFromNode(String kogitoStartFromNode) {
        this.kogitoStartFromNode = kogitoStartFromNode;
    }

    public String getKogitoStartFromNode() {
        return this.kogitoStartFromNode;
    }
}
