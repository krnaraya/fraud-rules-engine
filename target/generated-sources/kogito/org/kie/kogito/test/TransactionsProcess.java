package org.kie.kogito.test;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("Transactions")
public class TransactionsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.kie.kogito.test.TransactionsModel> {

    @javax.inject.Inject()
    javax.enterprise.inject.Instance<org.kie.api.runtime.process.WorkItemHandler> handlers;

    org.kie.kogito.app.Application app;

    @javax.inject.Inject()
    org.kie.kogito.test.TransactionsMessageProducer_1 producer_1;

    @javax.inject.Inject()
    org.kie.kogito.test.TransactionsMessageProducer_2 producer_2;

    @javax.inject.Inject()
    org.kie.kogito.test.TransactionsMessageProducer_3 producer_3;

    public TransactionsProcess() {
    }

    @javax.inject.Inject()
    public TransactionsProcess(org.kie.kogito.app.Application app) {
        super(app.config().process());
        this.app = app;
    }

    public org.kie.kogito.test.TransactionsProcessInstance createInstance(org.kie.kogito.test.TransactionsModel value) {
        return new org.kie.kogito.test.TransactionsProcessInstance(this, value, this.createLegacyProcessRuntime());
    }

    public org.kie.kogito.test.TransactionsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.test.TransactionsModel value) {
        return new org.kie.kogito.test.TransactionsProcessInstance(this, value, businessKey, this.createLegacyProcessRuntime());
    }

    public org.kie.kogito.test.TransactionsModel createModel() {
        return new org.kie.kogito.test.TransactionsModel();
    }

    public org.kie.kogito.test.TransactionsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.kie.kogito.test.TransactionsModel) value);
    }

    public org.kie.kogito.test.TransactionsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.kie.kogito.test.TransactionsModel) value);
    }

    public TransactionsProcess configure() {
        super.configure();
        return this;
    }

    protected void registerListeners() {
    }

    public org.kie.api.definition.process.Process legacyProcess() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("Transactions");
        factory.variable("transaction", new ObjectDataType("org.redhat.appdev.Transaction"), "customTags", null);
        factory.name("Process Transactions");
        factory.packageName("org.kie.kogito.test");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode1 = factory.actionNode(1);
        actionNode1.name("Script");
        actionNode1.action(kcontext -> {
            producer_1.produce(kcontext.getProcessInstance(), (org.redhat.appdev.Transaction) kcontext.getVariable("transaction"));
        });
        actionNode1.metaData("UniqueId", "_7A0ECEA4-2B15-4ABE-AE86-66532F191685");
        actionNode1.metaData("TriggerType", "ProduceMessage");
        actionNode1.metaData("x", 118);
        actionNode1.metaData("width", 56);
        actionNode1.metaData("y", 151);
        actionNode1.metaData("TriggerRef", "displaytransactions");
        actionNode1.metaData("MappingVariable", "transaction");
        actionNode1.metaData("MessageType", "org.redhat.appdev.Transaction");
        actionNode1.metaData("height", 56);
        actionNode1.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory endNode2 = factory.endNode(2);
        endNode2.name("automode");
        endNode2.terminate(false);
        endNode2.action(kcontext -> {
            producer_2.produce(kcontext.getProcessInstance(), (org.redhat.appdev.Transaction) kcontext.getVariable("transaction"));
        });
        endNode2.metaData("UniqueId", "_BEB84104-B078-4B6E-A77A-020EFC27C6D5");
        endNode2.metaData("elementname", "automode");
        endNode2.metaData("TriggerType", "ProduceMessage");
        endNode2.metaData("x", 1049);
        endNode2.metaData("width", 56);
        endNode2.metaData("y", 291);
        endNode2.metaData("TriggerRef", "automodedecisions");
        endNode2.metaData("MappingVariable", "transaction");
        endNode2.metaData("MessageType", "org.redhat.appdev.Transaction");
        endNode2.metaData("height", 56);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory endNode3 = factory.endNode(3);
        endNode3.name("manualmode");
        endNode3.terminate(false);
        endNode3.action(kcontext -> {
            producer_3.produce(kcontext.getProcessInstance(), (org.redhat.appdev.Transaction) kcontext.getVariable("transaction"));
        });
        endNode3.metaData("UniqueId", "_94256A21-E031-409D-905E-04FAEAD26BCD");
        endNode3.metaData("elementname", "manualmode");
        endNode3.metaData("TriggerType", "ProduceMessage");
        endNode3.metaData("x", 1049);
        endNode3.metaData("width", 56);
        endNode3.metaData("y", 53);
        endNode3.metaData("TriggerRef", "manualmodedecisions");
        endNode3.metaData("MappingVariable", "transaction");
        endNode3.metaData("MessageType", "org.redhat.appdev.Transaction");
        endNode3.metaData("height", 56);
        endNode3.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode4 = factory.actionNode(4);
        actionNode4.name("Automated Transaction");
        actionNode4.action(kcontext -> {
            org.redhat.appdev.Transaction transaction = (org.redhat.appdev.Transaction) kcontext.getVariable("transaction");
            System.out.println("Sending transaction to auto mode " + transaction);;
        });
        actionNode4.metaData("UniqueId", "_11461EEC-C3D4-4643-ADA8-1D059BF3B88F");
        actionNode4.metaData("elementname", "Automated Transaction");
        actionNode4.metaData("NodeType", "ScriptTask");
        actionNode4.metaData("x", 815);
        actionNode4.metaData("width", 154);
        actionNode4.metaData("y", 268);
        actionNode4.metaData("height", 102);
        actionNode4.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode5 = factory.actionNode(5);
        actionNode5.name("Manual Transaction");
        actionNode5.action(kcontext -> {
            org.redhat.appdev.Transaction transaction = (org.redhat.appdev.Transaction) kcontext.getVariable("transaction");
            System.out.println("Sending transaction to maual mode " + transaction);;
        });
        actionNode5.metaData("UniqueId", "_3B47DBCA-7C7B-40D3-8C5F-2925AE5E1E5E");
        actionNode5.metaData("elementname", "Manual Transaction");
        actionNode5.metaData("NodeType", "ScriptTask");
        actionNode5.metaData("x", 815);
        actionNode5.metaData("width", 154);
        actionNode5.metaData("y", 30);
        actionNode5.metaData("height", 102);
        actionNode5.done();
        org.jbpm.ruleflow.core.factory.SplitFactory splitNode6 = factory.splitNode(6);
        splitNode6.name("Auto or Manual Processing?");
        splitNode6.type(2);
        splitNode6.metaData("UniqueId", "_0F54CA61-A7FF-4EF5-9D15-B7348382A316");
        splitNode6.metaData("elementname", "Auto or Manual Processing?");
        splitNode6.metaData("x", 570);
        splitNode6.metaData("width", 56);
        splitNode6.metaData("y", 151);
        splitNode6.metaData("height", 56);
        splitNode6.constraint(5, "_5A7739B1-8533-47E8-9239-7A04D0918BC1", "DROOLS_DEFAULT", "java", kcontext -> {
            org.redhat.appdev.Transaction transaction = (org.redhat.appdev.Transaction) kcontext.getVariable("transaction");
            {
                return transaction.isFlagged();
            }
        }, 0);
        splitNode6.constraint(4, "_C94BC91D-39CA-4585-A6B8-AD09AAD3C270", "DROOLS_DEFAULT", "java", kcontext -> {
            org.redhat.appdev.Transaction transaction = (org.redhat.appdev.Transaction) kcontext.getVariable("transaction");
            {
                return !transaction.isFlagged();
            }
        }, 0);
        splitNode6.done();
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory ruleSetNode7 = factory.ruleSetNode(7);
        ruleSetNode7.name("Process Transactions");
        ruleSetNode7.inMapping("transaction", "transaction");
        ruleSetNode7.outMapping("transaction", "transaction");
        ruleSetNode7.ruleUnit("org.redhat.appdev.TransactionValidationService", new org.jbpm.workflow.core.node.RuleUnitFactory<org.redhat.appdev.TransactionValidationService>() {

            public org.redhat.appdev.TransactionValidationService bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                org.redhat.appdev.TransactionValidationService unit = new org.redhat.appdev.TransactionValidationService();
                {
                    org.kie.kogito.rules.SingletonStore unit_transaction = unit.getTransaction();
                    unit_transaction.set((org.redhat.appdev.Transaction) (kcontext.getVariable("transaction")));
                }
                org.redhat.appdev.Transaction transaction = (org.redhat.appdev.Transaction) (kcontext.getVariable("transaction"));
                {
                    org.kie.kogito.rules.SingletonStore unit_transaction = unit.getTransaction();
                    unit_transaction.subscribe(org.kie.kogito.rules.DataObserver.ofUpdatable(o -> kcontext.setVariable("transaction", o)));
                }
                return unit;
            }

            public org.kie.kogito.rules.RuleUnit<org.redhat.appdev.TransactionValidationService> unit() {
                return app.ruleUnits().create(org.redhat.appdev.TransactionValidationService.class);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, org.redhat.appdev.TransactionValidationService unit) {
                org.redhat.appdev.Transaction transaction = (org.redhat.appdev.Transaction) (kcontext.getVariable("transaction"));
                {
                    org.kie.kogito.rules.SingletonStore unit_transaction = unit.getTransaction();
                    unit_transaction.subscribe(org.kie.kogito.rules.DataObserver.ofUpdatable(o -> kcontext.setVariable("transaction", o)));
                }
            }
        });
        ruleSetNode7.metaData("UniqueId", "_2BF09609-53A4-4E1C-AA31-44546835C9BA");
        ruleSetNode7.metaData("elementname", "Process Transactions");
        ruleSetNode7.metaData("x", 242);
        ruleSetNode7.metaData("width", 154);
        ruleSetNode7.metaData("y", 128);
        ruleSetNode7.metaData("height", 102);
        ruleSetNode7.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory startNode8 = factory.startNode(8);
        startNode8.name("Start");
        startNode8.interrupting(false);
        startNode8.metaData("TriggerMapping", "transaction");
        startNode8.metaData("UniqueId", "_9FF8C905-21F3-40DE-A64A-F3A893067BA8");
        startNode8.metaData("TriggerType", "ConsumeMessage");
        startNode8.metaData("x", 12);
        startNode8.metaData("width", 56);
        startNode8.metaData("y", 151);
        startNode8.metaData("TriggerRef", "rawtransactions");
        startNode8.metaData("MessageType", "org.redhat.appdev.Transaction");
        startNode8.metaData("height", 56);
        startNode8.done();
        startNode8.trigger("rawtransactions", "transaction", "event");
        factory.connection(8, 1, "_96A7D0E0-C8E2-429B-BEE5-11E0DC28F7C6");
        factory.connection(4, 2, "_062BD02F-0166-4BED-A959-C4143A748EED");
        factory.connection(5, 3, "_97897D82-59F9-4F74-92CB-50DE5DCA342F");
        factory.connection(6, 4, "_C94BC91D-39CA-4585-A6B8-AD09AAD3C270");
        factory.connection(6, 5, "_5A7739B1-8533-47E8-9239-7A04D0918BC1");
        factory.connection(7, 6, "_FF3ADCFE-7AD8-4244-BED3-704724E91E3A");
        factory.connection(1, 7, "_43A83E6F-B1D4-450E-9BE6-7DF1EE0A3735");
        factory.validate();
        return factory.getProcess();
    }

    public void init(@javax.enterprise.event.Observes() io.quarkus.runtime.StartupEvent event) {
        this.activate();
    }
}
