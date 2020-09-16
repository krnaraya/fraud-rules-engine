package org.redhat.appdev;
public class DomainClassesMetadata6D95183FF81C3BE8833BC564CE42BA8C {

    public static final org.drools.model.DomainClassMetadata org_redhat_appdev_Transaction_Metadata_INSTANCE = new org_redhat_appdev_Transaction_Metadata();
    private static class org_redhat_appdev_Transaction_Metadata implements org.drools.model.DomainClassMetadata {

        @Override
        public Class<?> getDomainClass() {
            return org.redhat.appdev.Transaction.class;
        }

        @Override
        public int getPropertiesSize() {
            return 33;
        }

        @Override
        public int getPropertyIndex( String name ) {
            switch(name) {
                case "amount": return 0;
                case "classValue": return 1;
                case "flagged": return 2;
                case "id": return 3;
                case "time": return 4;
                case "v1": return 5;
                case "v10": return 6;
                case "v11": return 7;
                case "v12": return 8;
                case "v13": return 9;
                case "v14": return 10;
                case "v15": return 11;
                case "v16": return 12;
                case "v17": return 13;
                case "v18": return 14;
                case "v19": return 15;
                case "v2": return 16;
                case "v20": return 17;
                case "v21": return 18;
                case "v22": return 19;
                case "v23": return 20;
                case "v24": return 21;
                case "v25": return 22;
                case "v26": return 23;
                case "v27": return 24;
                case "v28": return 25;
                case "v3": return 26;
                case "v4": return 27;
                case "v5": return 28;
                case "v6": return 29;
                case "v7": return 30;
                case "v8": return 31;
                case "v9": return 32;
             }
             throw new RuntimeException("Unknown property '" + name + "' for class class class org.redhat.appdev.Transaction");
        }
    }

    public static final org.drools.model.DomainClassMetadata org_kie_kogito_rules_SingletonStore_Metadata_INSTANCE = new org_kie_kogito_rules_SingletonStore_Metadata();
    private static class org_kie_kogito_rules_SingletonStore_Metadata implements org.drools.model.DomainClassMetadata {

        @Override
        public Class<?> getDomainClass() {
            return org.kie.kogito.rules.SingletonStore.class;
        }

        @Override
        public int getPropertiesSize() {
            return 0;
        }

        @Override
        public int getPropertyIndex( String name ) {
            switch(name) {
             }
             throw new RuntimeException("Unknown property '" + name + "' for class class interface org.kie.kogito.rules.SingletonStore");
        }
    }

}