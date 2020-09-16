package org.redhat.appdev;

import java.util.*;
import org.drools.model.*;
import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import java.time.*;
import java.time.format.*;
import java.text.*;
import org.drools.core.util.*;
import org.redhat.appdev.Transaction;
import static org.redhat.appdev.Rules6D95183FF81C3BE8833BC564CE42BA8C.*;

public class Rules6D95183FF81C3BE8833BC564CE42BA8C_TransactionValidationServiceRuleMethods0 {

    /**
     * Rule name: Process transactions
     */
    public static org.drools.model.Rule rule_Process_32transactions() {
        final org.drools.model.Variable<org.redhat.appdev.Transaction> var_$transaction = D.declarationOf(org.redhat.appdev.Transaction.class,
                                                                                                          DomainClassesMetadata6D95183FF81C3BE8833BC564CE42BA8C.org_redhat_appdev_Transaction_Metadata_INSTANCE,
                                                                                                          "$transaction",
                                                                                                          D.entryPoint("transaction"));
        org.drools.model.Rule rule = D.rule("org.redhat.appdev",
                                            "Process transactions").unit(org.redhat.appdev.TransactionValidationService.class)
                                                                   .build(D.pattern(var_$transaction).expr("023B9204ED8291A618964293C2330385",
                                                                                                           (org.redhat.appdev.Transaction _this) -> org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.isFlagged(),
                                                                                                                                                                                                                   false),
                                                                                                           D.alphaIndexedBy(java.lang.Boolean.class,
                                                                                                                            org.drools.model.Index.ConstraintType.EQUAL,
                                                                                                                            DomainClassesMetadata6D95183FF81C3BE8833BC564CE42BA8C.org_redhat_appdev_Transaction_Metadata_INSTANCE.getPropertyIndex("flagged"),
                                                                                                                            (org.redhat.appdev.Transaction _this) -> _this.isFlagged(),
                                                                                                                            false),
                                                                                                           D.reactOn("flagged")).expr("08F85A962F34EBF4FEE32ABDB3D17BC1",
                                                                                                                                      (org.redhat.appdev.Transaction _this) -> org.drools.modelcompiler.util.EvaluationUtil.lessThanNumbers(java.lang.Double.valueOf(_this.getAmount()),
                                                                                                                                                                                                                                            10.0d),
                                                                                                                                      D.alphaIndexedBy(java.lang.Double.class,
                                                                                                                                                       org.drools.model.Index.ConstraintType.LESS_THAN,
                                                                                                                                                       -1,
                                                                                                                                                       (org.redhat.appdev.Transaction _this) -> java.lang.Double.valueOf(_this.getAmount()),
                                                                                                                                                       (double) 10.0d),
                                                                                                                                      D.reactOn("amount")),
                                                                          D.on(var_$transaction).execute((org.redhat.appdev.Transaction $transaction) -> {
                                                                              {
                                                                                  System.out.println("Transaction amount is lower and hence approving the transaction automatically " + $transaction);
                                                                                  $transaction.setFlagged(false);
                                                                              }
                                                                          }));
        return rule;
    }

    /**
     * Rule name: Send transactions greater than 10 to manual
     */
    public static org.drools.model.Rule rule_Send_32transactions_32greater_32than_3210_32to_32manual() {
        final org.drools.model.Variable<org.redhat.appdev.Transaction> var_$transaction = D.declarationOf(org.redhat.appdev.Transaction.class,
                                                                                                          DomainClassesMetadata6D95183FF81C3BE8833BC564CE42BA8C.org_redhat_appdev_Transaction_Metadata_INSTANCE,
                                                                                                          "$transaction",
                                                                                                          D.entryPoint("transaction"));
        org.drools.model.Rule rule = D.rule("org.redhat.appdev",
                                            "Send transactions greater than 10 to manual").unit(org.redhat.appdev.TransactionValidationService.class)
                                                                                          .build(D.pattern(var_$transaction).expr("023B9204ED8291A618964293C2330385",
                                                                                                                                  (org.redhat.appdev.Transaction _this) -> org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.isFlagged(),
                                                                                                                                                                                                                                          false),
                                                                                                                                  D.alphaIndexedBy(java.lang.Boolean.class,
                                                                                                                                                   org.drools.model.Index.ConstraintType.EQUAL,
                                                                                                                                                   DomainClassesMetadata6D95183FF81C3BE8833BC564CE42BA8C.org_redhat_appdev_Transaction_Metadata_INSTANCE.getPropertyIndex("flagged"),
                                                                                                                                                   (org.redhat.appdev.Transaction _this) -> _this.isFlagged(),
                                                                                                                                                   false),
                                                                                                                                  D.reactOn("flagged")).expr("E9D80C06EE76397D629D3294A8B16DDB",
                                                                                                                                                             (org.redhat.appdev.Transaction _this) -> org.drools.modelcompiler.util.EvaluationUtil.greaterOrEqualNumbers(java.lang.Double.valueOf(_this.getAmount()),
                                                                                                                                                                                                                                                                         10.0d),
                                                                                                                                                             D.alphaIndexedBy(java.lang.Double.class,
                                                                                                                                                                              org.drools.model.Index.ConstraintType.GREATER_OR_EQUAL,
                                                                                                                                                                              -1,
                                                                                                                                                                              (org.redhat.appdev.Transaction _this) -> java.lang.Double.valueOf(_this.getAmount()),
                                                                                                                                                                              (double) 10.0d),
                                                                                                                                                             D.reactOn("amount")),
                                                                                                 D.on(var_$transaction).execute((org.redhat.appdev.Transaction $transaction) -> {
                                                                                                     {
                                                                                                         System.out.println("I am sending to manual processing for transactions amounting more than 10.0 " + $transaction);
                                                                                                         $transaction.setFlagged(true);
                                                                                                     }
                                                                                                 }));
        return rule;
    }
}
