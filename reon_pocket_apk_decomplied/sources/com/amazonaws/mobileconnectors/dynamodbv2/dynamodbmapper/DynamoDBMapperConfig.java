package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.metrics.RequestMetricCollector;

public class DynamoDBMapperConfig {
    public static final DynamoDBMapperConfig DEFAULT = new DynamoDBMapperConfig(SaveBehavior.UPDATE, ConsistentReads.EVENTUAL, (TableNameOverride) null, (TableNameResolver) null, (ObjectTableNameResolver) null, PaginationLoadingStrategy.LAZY_LOADING, (RequestMetricCollector) null, ConversionSchemas.DEFAULT);
    private final ConsistentReads consistentReads;
    private final ConversionSchema conversionSchema;
    private final ObjectTableNameResolver objectTableNameResolver;
    private final PaginationLoadingStrategy paginationLoadingStrategy;
    private final RequestMetricCollector requestMetricCollector;
    private final SaveBehavior saveBehavior;
    private final TableNameOverride tableNameOverride;
    private final TableNameResolver tableNameResolver;

    public enum ConsistentReads {
        CONSISTENT,
        EVENTUAL
    }

    public interface ObjectTableNameResolver {
        String getTableName(Object obj, DynamoDBMapperConfig dynamoDBMapperConfig);
    }

    public enum PaginationLoadingStrategy {
        LAZY_LOADING,
        ITERATION_ONLY,
        EAGER_LOADING
    }

    public enum SaveBehavior {
        UPDATE,
        UPDATE_SKIP_NULL_ATTRIBUTES,
        CLOBBER,
        APPEND_SET
    }

    public interface TableNameResolver {
        String getTableName(Class<?> cls, DynamoDBMapperConfig dynamoDBMapperConfig);
    }

    public static class Builder {
        private ConsistentReads consistentReads = DynamoDBMapperConfig.DEFAULT.getConsistentReads();
        private ConversionSchema conversionSchema = DynamoDBMapperConfig.DEFAULT.getConversionSchema();
        private ObjectTableNameResolver objectTableNameResolver = DynamoDBMapperConfig.DEFAULT.getObjectTableNameResolver();
        private PaginationLoadingStrategy paginationLoadingStrategy = DynamoDBMapperConfig.DEFAULT.getPaginationLoadingStrategy();
        private RequestMetricCollector requestMetricCollector = DynamoDBMapperConfig.DEFAULT.getRequestMetricCollector();
        private SaveBehavior saveBehavior = DynamoDBMapperConfig.DEFAULT.getSaveBehavior();
        private TableNameOverride tableNameOverride = DynamoDBMapperConfig.DEFAULT.getTableNameOverride();
        private TableNameResolver tableNameResolver = DynamoDBMapperConfig.DEFAULT.getTableNameResolver();

        public SaveBehavior getSaveBehavior() {
            return this.saveBehavior;
        }

        public void setSaveBehavior(SaveBehavior saveBehavior2) {
            this.saveBehavior = saveBehavior2;
        }

        public Builder withSaveBehavior(SaveBehavior saveBehavior2) {
            setSaveBehavior(saveBehavior2);
            return this;
        }

        public ConsistentReads getConsistentReads() {
            return this.consistentReads;
        }

        public void setConsistentReads(ConsistentReads consistentReads2) {
            this.consistentReads = consistentReads2;
        }

        public Builder withConsistentReads(ConsistentReads consistentReads2) {
            setConsistentReads(consistentReads2);
            return this;
        }

        public TableNameOverride getTableNameOverride() {
            return this.tableNameOverride;
        }

        public void setTableNameOverride(TableNameOverride tableNameOverride2) {
            this.tableNameOverride = tableNameOverride2;
        }

        public Builder withTableNameOverride(TableNameOverride tableNameOverride2) {
            setTableNameOverride(tableNameOverride2);
            return this;
        }

        public TableNameResolver getTableNameResolver() {
            return this.tableNameResolver;
        }

        public void setTableNameResolver(TableNameResolver tableNameResolver2) {
            this.tableNameResolver = tableNameResolver2;
        }

        public Builder withTableNameResolver(TableNameResolver tableNameResolver2) {
            setTableNameResolver(tableNameResolver2);
            return this;
        }

        public ObjectTableNameResolver getObjectTableNameResolver() {
            return this.objectTableNameResolver;
        }

        public void setObjectTableNameResolver(ObjectTableNameResolver objectTableNameResolver2) {
            this.objectTableNameResolver = objectTableNameResolver2;
        }

        public Builder withObjectTableNameResolver(ObjectTableNameResolver objectTableNameResolver2) {
            setObjectTableNameResolver(objectTableNameResolver2);
            return this;
        }

        public PaginationLoadingStrategy getPaginationLoadingStrategy() {
            return this.paginationLoadingStrategy;
        }

        public void setPaginationLoadingStrategy(PaginationLoadingStrategy paginationLoadingStrategy2) {
            this.paginationLoadingStrategy = paginationLoadingStrategy2;
        }

        public Builder withPaginationLoadingStrategy(PaginationLoadingStrategy paginationLoadingStrategy2) {
            setPaginationLoadingStrategy(paginationLoadingStrategy2);
            return this;
        }

        public RequestMetricCollector getRequestMetricCollector() {
            return this.requestMetricCollector;
        }

        public void setRequestMetricCollector(RequestMetricCollector requestMetricCollector2) {
            this.requestMetricCollector = requestMetricCollector2;
        }

        public Builder withRequestMetricCollector(RequestMetricCollector requestMetricCollector2) {
            setRequestMetricCollector(requestMetricCollector2);
            return this;
        }

        public ConversionSchema getConversionSchema() {
            return this.conversionSchema;
        }

        public void setConversionSchema(ConversionSchema conversionSchema2) {
            this.conversionSchema = conversionSchema2;
        }

        public Builder withConversionSchema(ConversionSchema conversionSchema2) {
            setConversionSchema(conversionSchema2);
            return this;
        }

        public DynamoDBMapperConfig build() {
            return new DynamoDBMapperConfig(this.saveBehavior, this.consistentReads, this.tableNameOverride, this.tableNameResolver, this.objectTableNameResolver, this.paginationLoadingStrategy, this.requestMetricCollector, this.conversionSchema);
        }
    }

    public static final class TableNameOverride {
        private final String tableNameOverride;
        private final String tableNamePrefix;

        public static TableNameOverride withTableNamePrefix(String str) {
            return new TableNameOverride((String) null, str);
        }

        public static TableNameOverride withTableNameReplacement(String str) {
            return new TableNameOverride(str, (String) null);
        }

        private TableNameOverride(String str, String str2) {
            this.tableNameOverride = str;
            this.tableNamePrefix = str2;
        }

        public TableNameOverride(String str) {
            this(str, (String) null);
        }

        public String getTableName() {
            return this.tableNameOverride;
        }

        public String getTableNamePrefix() {
            return this.tableNamePrefix;
        }
    }

    public static class DefaultTableNameResolver implements TableNameResolver {
        public static final DefaultTableNameResolver INSTANCE = new DefaultTableNameResolver();
        private final DynamoDBReflector reflector = new DynamoDBReflector();

        public String getTableName(Class<?> cls, DynamoDBMapperConfig dynamoDBMapperConfig) {
            String tableName = this.reflector.getTable(cls).tableName();
            if (dynamoDBMapperConfig.getTableNameOverride() == null) {
                return tableName;
            }
            if (dynamoDBMapperConfig.getTableNameOverride().getTableName() != null) {
                return dynamoDBMapperConfig.getTableNameOverride().getTableName();
            }
            return dynamoDBMapperConfig.getTableNameOverride().getTableNamePrefix() + tableName;
        }
    }

    @Deprecated
    public DynamoDBMapperConfig(SaveBehavior saveBehavior2, ConsistentReads consistentReads2, TableNameOverride tableNameOverride2) {
        this(saveBehavior2, consistentReads2, tableNameOverride2, (PaginationLoadingStrategy) null, (RequestMetricCollector) null);
    }

    @Deprecated
    public DynamoDBMapperConfig(SaveBehavior saveBehavior2, ConsistentReads consistentReads2, TableNameOverride tableNameOverride2, PaginationLoadingStrategy paginationLoadingStrategy2) {
        this(saveBehavior2, consistentReads2, tableNameOverride2, paginationLoadingStrategy2, (RequestMetricCollector) null);
    }

    @Deprecated
    public DynamoDBMapperConfig(SaveBehavior saveBehavior2, ConsistentReads consistentReads2, TableNameOverride tableNameOverride2, PaginationLoadingStrategy paginationLoadingStrategy2, RequestMetricCollector requestMetricCollector2) {
        this(saveBehavior2, consistentReads2, tableNameOverride2, (TableNameResolver) null, (ObjectTableNameResolver) null, paginationLoadingStrategy2, requestMetricCollector2, ConversionSchemas.DEFAULT);
    }

    private DynamoDBMapperConfig(SaveBehavior saveBehavior2, ConsistentReads consistentReads2, TableNameOverride tableNameOverride2, TableNameResolver tableNameResolver2, ObjectTableNameResolver objectTableNameResolver2, PaginationLoadingStrategy paginationLoadingStrategy2, RequestMetricCollector requestMetricCollector2, ConversionSchema conversionSchema2) {
        this.saveBehavior = saveBehavior2;
        this.consistentReads = consistentReads2;
        this.tableNameOverride = tableNameOverride2;
        this.tableNameResolver = tableNameResolver2;
        this.objectTableNameResolver = objectTableNameResolver2;
        this.paginationLoadingStrategy = paginationLoadingStrategy2;
        this.requestMetricCollector = requestMetricCollector2;
        this.conversionSchema = conversionSchema2;
    }

    public DynamoDBMapperConfig(SaveBehavior saveBehavior2) {
        this(saveBehavior2, (ConsistentReads) null, (TableNameOverride) null, (TableNameResolver) null, (ObjectTableNameResolver) null, (PaginationLoadingStrategy) null, (RequestMetricCollector) null, ConversionSchemas.DEFAULT);
    }

    public DynamoDBMapperConfig(ConsistentReads consistentReads2) {
        this((SaveBehavior) null, consistentReads2, (TableNameOverride) null, (TableNameResolver) null, (ObjectTableNameResolver) null, (PaginationLoadingStrategy) null, (RequestMetricCollector) null, ConversionSchemas.DEFAULT);
    }

    public DynamoDBMapperConfig(TableNameOverride tableNameOverride2) {
        this((SaveBehavior) null, (ConsistentReads) null, tableNameOverride2, (TableNameResolver) null, (ObjectTableNameResolver) null, (PaginationLoadingStrategy) null, (RequestMetricCollector) null, ConversionSchemas.DEFAULT);
    }

    public DynamoDBMapperConfig(TableNameResolver tableNameResolver2) {
        this((SaveBehavior) null, (ConsistentReads) null, (TableNameOverride) null, tableNameResolver2, (ObjectTableNameResolver) null, (PaginationLoadingStrategy) null, (RequestMetricCollector) null, ConversionSchemas.DEFAULT);
    }

    public DynamoDBMapperConfig(ObjectTableNameResolver objectTableNameResolver2) {
        this((SaveBehavior) null, (ConsistentReads) null, (TableNameOverride) null, (TableNameResolver) null, objectTableNameResolver2, (PaginationLoadingStrategy) null, (RequestMetricCollector) null, ConversionSchemas.DEFAULT);
    }

    public DynamoDBMapperConfig(TableNameResolver tableNameResolver2, ObjectTableNameResolver objectTableNameResolver2) {
        this((SaveBehavior) null, (ConsistentReads) null, (TableNameOverride) null, tableNameResolver2, objectTableNameResolver2, (PaginationLoadingStrategy) null, (RequestMetricCollector) null, ConversionSchemas.DEFAULT);
    }

    public DynamoDBMapperConfig(PaginationLoadingStrategy paginationLoadingStrategy2) {
        this((SaveBehavior) null, (ConsistentReads) null, (TableNameOverride) null, (TableNameResolver) null, (ObjectTableNameResolver) null, paginationLoadingStrategy2, (RequestMetricCollector) null, ConversionSchemas.DEFAULT);
    }

    public DynamoDBMapperConfig(ConversionSchema conversionSchema2) {
        this((SaveBehavior) null, (ConsistentReads) null, (TableNameOverride) null, (TableNameResolver) null, (ObjectTableNameResolver) null, (PaginationLoadingStrategy) null, (RequestMetricCollector) null, conversionSchema2);
    }

    public DynamoDBMapperConfig(DynamoDBMapperConfig dynamoDBMapperConfig, DynamoDBMapperConfig dynamoDBMapperConfig2) {
        SaveBehavior saveBehavior2;
        ConsistentReads consistentReads2;
        TableNameOverride tableNameOverride2;
        TableNameResolver tableNameResolver2;
        ObjectTableNameResolver objectTableNameResolver2;
        PaginationLoadingStrategy paginationLoadingStrategy2;
        RequestMetricCollector requestMetricCollector2;
        ConversionSchema conversionSchema2;
        if (dynamoDBMapperConfig2 == null) {
            this.saveBehavior = dynamoDBMapperConfig.getSaveBehavior();
            this.consistentReads = dynamoDBMapperConfig.getConsistentReads();
            this.tableNameOverride = dynamoDBMapperConfig.getTableNameOverride();
            this.tableNameResolver = dynamoDBMapperConfig.getTableNameResolver();
            this.objectTableNameResolver = dynamoDBMapperConfig.getObjectTableNameResolver();
            this.paginationLoadingStrategy = dynamoDBMapperConfig.getPaginationLoadingStrategy();
            this.requestMetricCollector = dynamoDBMapperConfig.getRequestMetricCollector();
            this.conversionSchema = dynamoDBMapperConfig.getConversionSchema();
            return;
        }
        if (dynamoDBMapperConfig2.getSaveBehavior() == null) {
            saveBehavior2 = dynamoDBMapperConfig.getSaveBehavior();
        } else {
            saveBehavior2 = dynamoDBMapperConfig2.getSaveBehavior();
        }
        this.saveBehavior = saveBehavior2;
        if (dynamoDBMapperConfig2.getConsistentReads() == null) {
            consistentReads2 = dynamoDBMapperConfig.getConsistentReads();
        } else {
            consistentReads2 = dynamoDBMapperConfig2.getConsistentReads();
        }
        this.consistentReads = consistentReads2;
        if (dynamoDBMapperConfig2.getTableNameOverride() == null) {
            tableNameOverride2 = dynamoDBMapperConfig.getTableNameOverride();
        } else {
            tableNameOverride2 = dynamoDBMapperConfig2.getTableNameOverride();
        }
        this.tableNameOverride = tableNameOverride2;
        if (dynamoDBMapperConfig2.getTableNameResolver() == null) {
            tableNameResolver2 = dynamoDBMapperConfig.getTableNameResolver();
        } else {
            tableNameResolver2 = dynamoDBMapperConfig2.getTableNameResolver();
        }
        this.tableNameResolver = tableNameResolver2;
        if (dynamoDBMapperConfig2.getObjectTableNameResolver() == null) {
            objectTableNameResolver2 = dynamoDBMapperConfig.getObjectTableNameResolver();
        } else {
            objectTableNameResolver2 = dynamoDBMapperConfig2.getObjectTableNameResolver();
        }
        this.objectTableNameResolver = objectTableNameResolver2;
        if (dynamoDBMapperConfig2.getPaginationLoadingStrategy() == null) {
            paginationLoadingStrategy2 = dynamoDBMapperConfig.getPaginationLoadingStrategy();
        } else {
            paginationLoadingStrategy2 = dynamoDBMapperConfig2.getPaginationLoadingStrategy();
        }
        this.paginationLoadingStrategy = paginationLoadingStrategy2;
        if (dynamoDBMapperConfig2.getRequestMetricCollector() == null) {
            requestMetricCollector2 = dynamoDBMapperConfig.getRequestMetricCollector();
        } else {
            requestMetricCollector2 = dynamoDBMapperConfig2.getRequestMetricCollector();
        }
        this.requestMetricCollector = requestMetricCollector2;
        if (dynamoDBMapperConfig2.getConversionSchema() == null) {
            conversionSchema2 = dynamoDBMapperConfig.getConversionSchema();
        } else {
            conversionSchema2 = dynamoDBMapperConfig2.getConversionSchema();
        }
        this.conversionSchema = conversionSchema2;
    }

    public SaveBehavior getSaveBehavior() {
        return this.saveBehavior;
    }

    public ConsistentReads getConsistentReads() {
        return this.consistentReads;
    }

    public TableNameOverride getTableNameOverride() {
        return this.tableNameOverride;
    }

    public TableNameResolver getTableNameResolver() {
        return this.tableNameResolver;
    }

    public ObjectTableNameResolver getObjectTableNameResolver() {
        return this.objectTableNameResolver;
    }

    public PaginationLoadingStrategy getPaginationLoadingStrategy() {
        return this.paginationLoadingStrategy;
    }

    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }

    public ConversionSchema getConversionSchema() {
        return this.conversionSchema;
    }
}
