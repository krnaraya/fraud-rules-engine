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

public class Rules6D95183FF81C3BE8833BC564CE42BA8C_TransactionValidationService extends Rules6D95183FF81C3BE8833BC564CE42BA8C {

    @Override
    public String getName() {
        return super.getName() + ".TransactionValidationService";
    }

    @Override
    public String getPackageName() {
        return super.getName();
    }

    /**
     * With the following expression ID:
     * org.drools.modelcompiler.builder.generator.DRLIdGenerator@2d41a455
     */
    @Override
    public List<org.drools.model.Rule> getRules() {
        return rules;
    }

    public List<Rule> getRulesList() {
        return Arrays.asList(Rules6D95183FF81C3BE8833BC564CE42BA8C_TransactionValidationServiceRuleMethods0.rule_Process_32transactions(),
                             Rules6D95183FF81C3BE8833BC564CE42BA8C_TransactionValidationServiceRuleMethods0.rule_Send_32transactions_32greater_32than_3210_32to_32manual());
    }

    List<org.drools.model.Rule> rules = getRulesList();

    @Override
    public List<org.drools.model.Query> getQueries() {
        return java.util.Collections.emptyList();
    }
}
