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
import org.drools.model.Model;

public abstract class Rules6D95183FF81C3BE8833BC564CE42BA8C implements Model {

    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtils.getDateFormatMask(),
                                                                                            Locale.ENGLISH);

    @Override
    public String getName() {
        return "org.redhat.appdev";
    }

    public static Date string_2_date(String s) {
        return GregorianCalendar.from(LocalDate.parse(s,
                                                      DATE_TIME_FORMATTER).atStartOfDay(ZoneId.systemDefault()))
                                .getTime();
    }

    @Override
    public List<org.drools.model.EntryPoint> getEntryPoints() {
        return Arrays.asList(D.entryPoint("transaction"));
    }

    @Override
    public List<org.drools.model.Global> getGlobals() {
        return globals;
    }

    @Override
    public List<org.drools.model.TypeMetaData> getTypeMetaDatas() {
        return typeMetaDatas;
    }

    public static final org.drools.model.Global<org.kie.kogito.rules.SingletonStore> var_transaction = D.globalOf(org.kie.kogito.rules.SingletonStore.class,
                                                                                                                  "org.redhat.appdev",
                                                                                                                  "transaction");

    List<org.drools.model.Global> globals = new ArrayList<>();

    List<org.drools.model.TypeMetaData> typeMetaDatas = Collections.emptyList();

    {
        globals.add(var_transaction);
    }
}
