package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.AttributeTransformer;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ConversionSchema;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeAction;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteRequest;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.PutRequest;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.Select;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.util.VersionInfoUtils;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class DynamoDBMapper {
    static final int BATCH_GET_MAX_RETRY_COUNT_ALL_KEYS = 5;
    private static final int EXPONENTIAL_BACKOFF_OFFSET = 500;
    private static final int EXPONENTIAL_BACKOFF_RANDOMIZATION_OFFSET = 100;
    static final long MAX_BACKOFF_IN_MILLISECONDS = 3000;
    private static final int MAX_BATCH_GET_COUNT = 100;
    static final int MAX_ITEMS_PER_BATCH = 25;
    /* access modifiers changed from: private */
    public static final String NO_RANGE_KEY = new String();
    private static final long THREAD_SLEEP_TWO_SECONDS = 2000;
    private static final String USER_AGENT;
    private static final String USER_AGENT_BATCH_OPERATION;
    private static final Log log;
    private static String userAgentFromConfig = "";
    private final DynamoDBMapperConfig config;
    /* access modifiers changed from: private */
    public final AmazonDynamoDB db;
    /* access modifiers changed from: private */
    public final VersionIncrementor incrementor;
    /* access modifiers changed from: private */
    public final DynamoDBReflector reflector;
    private final S3ClientCache s3cc;
    private final DynamoDBTableSchemaParser schemaParser;
    private final AttributeTransformer transformer;

    static {
        StringBuilder sb = new StringBuilder();
        Class<DynamoDBMapper> cls = DynamoDBMapper.class;
        sb.append(cls.getName());
        sb.append("/");
        sb.append(VersionInfoUtils.getVersion());
        USER_AGENT = sb.toString();
        USER_AGENT_BATCH_OPERATION = cls.getName() + "_batch_operation/" + VersionInfoUtils.getVersion();
        log = LogFactory.getLog((Class<?>) cls);
    }

    /* access modifiers changed from: private */
    public static void setUserAgentFromConfig(String str) {
        synchronized (userAgentFromConfig) {
            userAgentFromConfig = str;
        }
    }

    private static String getUserAgentFromConfig() {
        synchronized (userAgentFromConfig) {
            String str = userAgentFromConfig;
            if (str != null) {
                if (!str.trim().isEmpty()) {
                    String str2 = userAgentFromConfig.trim() + "/";
                    return str2;
                }
            }
            return "";
        }
    }

    public static class Builder {
        private AWSConfiguration awsConfig;
        private DynamoDBMapperConfig config;
        private AmazonDynamoDB dynamoDB;
        private AWSCredentialsProvider s3CredentialProvider;
        private AttributeTransformer transformer;

        protected Builder() {
        }

        public Builder dynamoDBClient(AmazonDynamoDB amazonDynamoDB) {
            this.dynamoDB = amazonDynamoDB;
            return this;
        }

        public Builder dynamoDBMapperConfig(DynamoDBMapperConfig dynamoDBMapperConfig) {
            this.config = dynamoDBMapperConfig;
            return this;
        }

        public Builder attributeTransformer(AttributeTransformer attributeTransformer) {
            this.transformer = attributeTransformer;
            return this;
        }

        public Builder awsCredentialsProviderForS3(AWSCredentialsProvider aWSCredentialsProvider) {
            this.s3CredentialProvider = aWSCredentialsProvider;
            return this;
        }

        public Builder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.awsConfig = aWSConfiguration;
            return this;
        }

        public DynamoDBMapper build() {
            if (this.dynamoDB != null) {
                AWSConfiguration aWSConfiguration = this.awsConfig;
                if (aWSConfiguration != null) {
                    try {
                        this.dynamoDB.setRegion(Region.getRegion(Regions.fromName(aWSConfiguration.optJsonObject("DynamoDBObjectMapper").getString("Region"))));
                        DynamoDBMapper.setUserAgentFromConfig(this.awsConfig.getUserAgent());
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Failed to read Region from AWSConfiguration please check your setup or awsconfiguration.json file", e);
                    }
                }
                AmazonDynamoDB amazonDynamoDB = this.dynamoDB;
                DynamoDBMapperConfig dynamoDBMapperConfig = this.config;
                if (dynamoDBMapperConfig == null) {
                    dynamoDBMapperConfig = DynamoDBMapperConfig.DEFAULT;
                }
                return new DynamoDBMapper(amazonDynamoDB, dynamoDBMapperConfig, this.transformer, this.s3CredentialProvider, this.awsConfig);
            }
            throw new IllegalArgumentException("AmazonDynamoDB client is required please set using .dynamoDBClient(yourClient)");
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private DynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig, AttributeTransformer attributeTransformer, AWSCredentialsProvider aWSCredentialsProvider, AWSConfiguration aWSConfiguration) {
        this.reflector = new DynamoDBReflector();
        this.schemaParser = new DynamoDBTableSchemaParser();
        this.incrementor = new VersionIncrementor();
        this.db = amazonDynamoDB;
        this.config = dynamoDBMapperConfig;
        this.transformer = attributeTransformer;
        if (aWSCredentialsProvider == null) {
            this.s3cc = null;
        } else {
            this.s3cc = new S3ClientCache(aWSCredentialsProvider);
        }
    }

    public DynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
        this(amazonDynamoDB, DynamoDBMapperConfig.DEFAULT, (AttributeTransformer) null, (AWSCredentialsProvider) null);
    }

    public DynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig) {
        this(amazonDynamoDB, dynamoDBMapperConfig, (AttributeTransformer) null, (AWSCredentialsProvider) null);
    }

    public DynamoDBMapper(AmazonDynamoDB amazonDynamoDB, AWSCredentialsProvider aWSCredentialsProvider) {
        this(amazonDynamoDB, DynamoDBMapperConfig.DEFAULT, aWSCredentialsProvider);
    }

    public DynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig, AttributeTransformer attributeTransformer) {
        this(amazonDynamoDB, dynamoDBMapperConfig, attributeTransformer, (AWSCredentialsProvider) null);
    }

    public DynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig, AWSCredentialsProvider aWSCredentialsProvider) {
        this(amazonDynamoDB, dynamoDBMapperConfig, (AttributeTransformer) null, validate(aWSCredentialsProvider));
    }

    private static AWSCredentialsProvider validate(AWSCredentialsProvider aWSCredentialsProvider) {
        if (aWSCredentialsProvider != null) {
            return aWSCredentialsProvider;
        }
        throw new IllegalArgumentException("s3 credentials provider must not be null");
    }

    public DynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig, AttributeTransformer attributeTransformer, AWSCredentialsProvider aWSCredentialsProvider) {
        this.reflector = new DynamoDBReflector();
        this.schemaParser = new DynamoDBTableSchemaParser();
        this.incrementor = new VersionIncrementor();
        this.db = amazonDynamoDB;
        this.config = dynamoDBMapperConfig;
        this.transformer = attributeTransformer;
        if (aWSCredentialsProvider == null) {
            this.s3cc = null;
        } else {
            this.s3cc = new S3ClientCache(aWSCredentialsProvider);
        }
    }

    public <T> T load(Class<T> cls, Object obj, DynamoDBMapperConfig dynamoDBMapperConfig) {
        return load(cls, obj, (Object) null, dynamoDBMapperConfig);
    }

    public <T> T load(Class<T> cls, Object obj) {
        return load(cls, obj, (Object) null, this.config);
    }

    public <T> T load(Class<T> cls, Object obj, Object obj2) {
        return load(cls, obj, obj2, this.config);
    }

    public <T> T load(T t) {
        return load(t, this.config);
    }

    public <T> T load(T t, DynamoDBMapperConfig dynamoDBMapperConfig) {
        Class<?> cls = t.getClass();
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        ItemConverter converter = getConverter(mergeConfig);
        String tableName = getTableName(cls, t, mergeConfig);
        GetItemRequest getItemRequest = (GetItemRequest) new GetItemRequest().withRequestMetricCollector(mergeConfig.getRequestMetricCollector());
        getItemRequest.setKey(getKey(converter, t, cls));
        getItemRequest.setTableName(tableName);
        getItemRequest.setConsistentRead(Boolean.valueOf(mergeConfig.getConsistentReads() == DynamoDBMapperConfig.ConsistentReads.CONSISTENT));
        Map<String, AttributeValue> item = this.db.getItem((GetItemRequest) applyUserAgent(getItemRequest)).getItem();
        if (item == null) {
            return null;
        }
        return privateMarshallIntoObject(converter, toParameters(item, cls, tableName, mergeConfig));
    }

    private <T> Map<String, AttributeValue> getKey(ItemConverter itemConverter, T t) {
        return getKey(itemConverter, t, t.getClass());
    }

    private <T> Map<String, AttributeValue> getKey(ItemConverter itemConverter, T t, Class<T> cls) {
        HashMap hashMap = new HashMap();
        for (Method next : this.reflector.getPrimaryKeyGetters(cls)) {
            AttributeValue convert = itemConverter.convert(next, ReflectionUtils.safeInvoke(next, t, new Object[0]));
            if (convert != null) {
                hashMap.put(this.reflector.getAttributeName(next), convert);
            } else {
                throw new DynamoDBMappingException("Null key found for " + next);
            }
        }
        if (!hashMap.isEmpty()) {
            return hashMap;
        }
        throw new DynamoDBMappingException("Class must be annotated with " + DynamoDBHashKey.class + " and " + DynamoDBRangeKey.class);
    }

    public <T> T load(Class<T> cls, Object obj, Object obj2, DynamoDBMapperConfig dynamoDBMapperConfig) {
        return load(createKeyObject(cls, obj, obj2), mergeConfig(dynamoDBMapperConfig));
    }

    /* access modifiers changed from: package-private */
    public <T> T createKeyObject(Class<T> cls, Object obj, Object obj2) {
        try {
            T newInstance = cls.newInstance();
            boolean z = false;
            boolean z2 = false;
            for (Method next : this.reflector.getPrimaryKeyGetters(cls)) {
                if (ReflectionUtils.getterOrFieldHasAnnotation(next, DynamoDBHashKey.class)) {
                    if (!z) {
                        ReflectionUtils.safeInvoke(this.reflector.getSetter(next), newInstance, obj);
                        z = true;
                    } else {
                        throw new DynamoDBMappingException("Found more than one method annotated with " + DynamoDBHashKey.class + " for class " + cls + ". Use load(Object) for tables with more than a single hash and range key.");
                    }
                } else if (!ReflectionUtils.getterOrFieldHasAnnotation(next, DynamoDBRangeKey.class)) {
                    continue;
                } else if (!z2) {
                    ReflectionUtils.safeInvoke(this.reflector.getSetter(next), newInstance, obj2);
                    z2 = true;
                } else {
                    throw new DynamoDBMappingException("Found more than one method annotated with " + DynamoDBRangeKey.class + " for class " + cls + ". Use load(Object) for tables with more than a single hash and range key.");
                }
            }
            if (!z) {
                throw new DynamoDBMappingException("No method annotated with " + DynamoDBHashKey.class + " for class " + cls + InstructionFileId.DOT);
            } else if (obj2 == null || z2) {
                return newInstance;
            } else {
                throw new DynamoDBMappingException("No method annotated with " + DynamoDBRangeKey.class + " for class " + cls + InstructionFileId.DOT);
            }
        } catch (Exception e) {
            throw new DynamoDBMappingException("Failed to instantiate class", e);
        }
    }

    private Map<String, Condition> getHashKeyEqualsConditions(ItemConverter itemConverter, Object obj) {
        Object safeInvoke;
        HashMap hashMap = new HashMap();
        if (obj == null) {
            return hashMap;
        }
        for (Method next : this.reflector.getRelevantGetters(obj.getClass())) {
            if ((ReflectionUtils.getterOrFieldHasAnnotation(next, DynamoDBHashKey.class) || ReflectionUtils.getterOrFieldHasAnnotation(next, DynamoDBIndexHashKey.class)) && (safeInvoke = ReflectionUtils.safeInvoke(next, obj, new Object[0])) != null) {
                hashMap.put(this.reflector.getAttributeName(next), new Condition().withComparisonOperator(ComparisonOperator.EQ).withAttributeValueList(itemConverter.convert(next, safeInvoke)));
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final String getTableName(Class<?> cls, DynamoDBMapperConfig dynamoDBMapperConfig) {
        return internalGetTableName(cls, (Object) null, dynamoDBMapperConfig);
    }

    /* access modifiers changed from: protected */
    public final String getTableName(Class<?> cls, Object obj, DynamoDBMapperConfig dynamoDBMapperConfig) {
        return internalGetTableName(cls, obj, dynamoDBMapperConfig);
    }

    static String internalGetTableName(Class<?> cls, Object obj, DynamoDBMapperConfig dynamoDBMapperConfig) {
        DynamoDBMapperConfig.ObjectTableNameResolver objectTableNameResolver = dynamoDBMapperConfig.getObjectTableNameResolver();
        if (obj != null && objectTableNameResolver != null) {
            return objectTableNameResolver.getTableName(obj, dynamoDBMapperConfig);
        }
        DynamoDBMapperConfig.TableNameResolver tableNameResolver = dynamoDBMapperConfig.getTableNameResolver();
        if (tableNameResolver == null) {
            tableNameResolver = DynamoDBMapperConfig.DefaultTableNameResolver.INSTANCE;
        }
        return tableNameResolver.getTableName(cls, dynamoDBMapperConfig);
    }

    public <T> T marshallIntoObject(Class<T> cls, Map<String, AttributeValue> map) {
        return privateMarshallIntoObject(getConverter(this.config), toParameters(map, cls, getTableName(cls, this.config), this.config));
    }

    private <T> T privateMarshallIntoObject(ItemConverter itemConverter, AttributeTransformer.Parameters<T> parameters) {
        return itemConverter.unconvert(parameters.getModelClass(), untransformAttributes(parameters));
    }

    public <T> List<T> marshallIntoObjects(Class<T> cls, List<Map<String, AttributeValue>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Map<String, AttributeValue> marshallIntoObject : list) {
            arrayList.add(marshallIntoObject(cls, marshallIntoObject));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final <T> List<T> marshallIntoObjects(List<AttributeTransformer.Parameters<T>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        ItemConverter converter = !list.isEmpty() ? getConverter(list.get(0).getMapperConfig()) : null;
        for (AttributeTransformer.Parameters<T> privateMarshallIntoObject : list) {
            arrayList.add(privateMarshallIntoObject(converter, privateMarshallIntoObject));
        }
        return arrayList;
    }

    public <T> void save(T t) {
        save(t, (DynamoDBSaveExpression) null, this.config);
    }

    public <T> void save(T t, DynamoDBSaveExpression dynamoDBSaveExpression) {
        save(t, dynamoDBSaveExpression, this.config);
    }

    /* access modifiers changed from: package-private */
    public boolean needAutoGenerateAssignableKey(Class<?> cls, Object obj) {
        boolean z = false;
        boolean z2 = false;
        for (Method next : this.reflector.getPrimaryKeyGetters(cls)) {
            if (ReflectionUtils.safeInvoke(next, obj, new Object[0]) == null && this.reflector.isAssignableKey(next)) {
                z2 = true;
            }
            if (ReflectionUtils.getterOrFieldHasAnnotation(next, DynamoDBHashKey.class)) {
                z = true;
            }
        }
        if (z) {
            return z2;
        }
        throw new DynamoDBMappingException("No " + DynamoDBHashKey.class + " annotation found in class " + cls);
    }

    public <T> void save(T t, DynamoDBMapperConfig dynamoDBMapperConfig) {
        save(t, (DynamoDBSaveExpression) null, dynamoDBMapperConfig);
    }

    /* JADX WARNING: type inference failed for: r12v2, types: [com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper$SaveObjectHandler] */
    /* JADX WARNING: type inference failed for: r0v3, types: [com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper$1] */
    /* JADX WARNING: type inference failed for: r0v4, types: [com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper$2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void save(T r10, com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBSaveExpression r11, com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig r12) {
        /*
            r9 = this;
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig r6 = r9.mergeConfig(r12)
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ItemConverter r7 = r9.getConverter(r6)
            java.lang.Class r3 = r10.getClass()
            java.lang.String r5 = r9.getTableName(r3, r10, r6)
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig$SaveBehavior r12 = r6.getSaveBehavior()
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig$SaveBehavior r0 = com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig.SaveBehavior.CLOBBER
            if (r12 == r0) goto L_0x002a
            boolean r12 = r9.needAutoGenerateAssignableKey(r3, r10)
            if (r12 == 0) goto L_0x001f
            goto L_0x002a
        L_0x001f:
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper$2 r12 = new com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper$2
            r0 = r12
            r1 = r9
            r2 = r9
            r4 = r10
            r8 = r11
            r0.<init>(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0034
        L_0x002a:
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper$1 r12 = new com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper$1
            r0 = r12
            r1 = r9
            r2 = r9
            r4 = r10
            r8 = r11
            r0.<init>(r2, r3, r4, r5, r6, r7, r8)
        L_0x0034:
            r12.execute()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper.save(java.lang.Object, com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBSaveExpression, com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig):void");
    }

    protected abstract class SaveObjectHandler {
        protected final Class<?> clazz;
        private final ItemConverter converter;
        private final List<ValueUpdate> inMemoryUpdates;
        private final Map<String, ExpectedAttributeValue> internalExpectedValueAssertions;
        private final Map<String, AttributeValue> key;
        protected final Object object;
        private final DynamoDBMapperConfig saveConfig;
        private final String tableName;
        private final Map<String, AttributeValueUpdate> updateValues;
        protected final String userProvidedConditionOperator;
        protected final Map<String, ExpectedAttributeValue> userProvidedExpectedValueConditions;

        /* access modifiers changed from: protected */
        public abstract void executeLowLevelRequest();

        /* access modifiers changed from: protected */
        public abstract void onKeyAttributeValue(String str, AttributeValue attributeValue);

        /* access modifiers changed from: protected */
        public abstract void onNullNonKeyAttribute(String str);

        public SaveObjectHandler(Class<?> cls, Object obj, String str, DynamoDBMapperConfig dynamoDBMapperConfig, ItemConverter itemConverter, DynamoDBSaveExpression dynamoDBSaveExpression) {
            this.clazz = cls;
            this.object = obj;
            this.tableName = str;
            this.saveConfig = dynamoDBMapperConfig;
            this.converter = itemConverter;
            if (dynamoDBSaveExpression != null) {
                this.userProvidedExpectedValueConditions = dynamoDBSaveExpression.getExpected();
                this.userProvidedConditionOperator = dynamoDBSaveExpression.getConditionalOperator();
            } else {
                this.userProvidedExpectedValueConditions = null;
                this.userProvidedConditionOperator = null;
            }
            this.updateValues = new HashMap();
            this.internalExpectedValueAssertions = new HashMap();
            this.inMemoryUpdates = new LinkedList();
            this.key = new HashMap();
        }

        public void execute() {
            Collection<Method> primaryKeyGetters = DynamoDBMapper.this.reflector.getPrimaryKeyGetters(this.clazz);
            for (Method next : primaryKeyGetters) {
                Object safeInvoke = ReflectionUtils.safeInvoke(next, this.object, new Object[0]);
                String attributeName = DynamoDBMapper.this.reflector.getAttributeName(next);
                if (safeInvoke != null || !DynamoDBMapper.this.reflector.isAssignableKey(next)) {
                    AttributeValue convert = this.converter.convert(next, safeInvoke);
                    if (convert == null) {
                        throw new DynamoDBMappingException("Null or empty value for key: " + next);
                    } else if (convert.getS() == null && convert.getN() == null && convert.getB() == null) {
                        throw new DynamoDBMappingException("Keys must be scalar values (String, Number, or Binary). Got " + convert + " for key " + next);
                    } else {
                        onKeyAttributeValue(attributeName, convert);
                    }
                } else {
                    onAutoGenerateAssignableKey(next, attributeName);
                }
            }
            for (Method next2 : DynamoDBMapper.this.reflector.getRelevantGetters(this.clazz)) {
                if (!primaryKeyGetters.contains(next2)) {
                    Object safeInvoke2 = ReflectionUtils.safeInvoke(next2, this.object, new Object[0]);
                    String attributeName2 = DynamoDBMapper.this.reflector.getAttributeName(next2);
                    if (DynamoDBMapper.this.reflector.isVersionAttributeGetter(next2)) {
                        onVersionAttribute(next2, safeInvoke2, attributeName2);
                    } else {
                        AttributeValue convert2 = this.converter.convert(next2, safeInvoke2);
                        if (convert2 != null) {
                            onNonKeyAttribute(attributeName2, convert2);
                        } else {
                            onNullNonKeyAttribute(attributeName2);
                        }
                    }
                }
            }
            executeLowLevelRequest();
            for (ValueUpdate apply : this.inMemoryUpdates) {
                apply.apply();
            }
        }

        /* access modifiers changed from: protected */
        public void onNonKeyAttribute(String str, AttributeValue attributeValue) {
            this.updateValues.put(str, new AttributeValueUpdate().withValue(attributeValue).withAction("PUT"));
        }

        /* access modifiers changed from: protected */
        public DynamoDBMapperConfig.SaveBehavior getLocalSaveBehavior() {
            return this.saveConfig.getSaveBehavior();
        }

        /* access modifiers changed from: protected */
        public String getTableName() {
            return this.tableName;
        }

        /* access modifiers changed from: protected */
        public Map<String, AttributeValue> getKeyAttributeValues() {
            return this.key;
        }

        /* access modifiers changed from: protected */
        public Map<String, AttributeValueUpdate> getAttributeValueUpdates() {
            return this.updateValues;
        }

        /* access modifiers changed from: protected */
        public Map<String, ExpectedAttributeValue> mergeExpectedAttributeValueConditions() {
            return DynamoDBMapper.mergeExpectedAttributeValueConditions(this.internalExpectedValueAssertions, this.userProvidedExpectedValueConditions, this.userProvidedConditionOperator);
        }

        /* access modifiers changed from: protected */
        public List<ValueUpdate> getInMemoryUpdates() {
            return this.inMemoryUpdates;
        }

        /* access modifiers changed from: protected */
        public UpdateItemResult doUpdateItem() {
            return DynamoDBMapper.this.db.updateItem((UpdateItemRequest) DynamoDBMapper.applyUserAgent((UpdateItemRequest) new UpdateItemRequest().withTableName(getTableName()).withKey(getKeyAttributeValues()).withAttributeUpdates(DynamoDBMapper.this.transformAttributeUpdates(this.clazz, getTableName(), getKeyAttributeValues(), getAttributeValueUpdates(), this.saveConfig)).withExpected(mergeExpectedAttributeValueConditions()).withConditionalOperator(this.userProvidedConditionOperator).withReturnValues(ReturnValue.ALL_NEW).withRequestMetricCollector(this.saveConfig.getRequestMetricCollector())));
        }

        /* access modifiers changed from: protected */
        public PutItemResult doPutItem() {
            Map access$400 = DynamoDBMapper.this.convertToItem(getAttributeValueUpdates());
            DynamoDBMapper dynamoDBMapper = DynamoDBMapper.this;
            return DynamoDBMapper.this.db.putItem((PutItemRequest) DynamoDBMapper.applyUserAgent((PutItemRequest) new PutItemRequest().withTableName(getTableName()).withItem(dynamoDBMapper.transformAttributes(dynamoDBMapper.toParameters((Map<String, AttributeValue>) access$400, this.clazz, getTableName(), this.saveConfig))).withExpected(mergeExpectedAttributeValueConditions()).withConditionalOperator(this.userProvidedConditionOperator).withRequestMetricCollector(this.saveConfig.getRequestMetricCollector())));
        }

        private void onAutoGenerateAssignableKey(Method method, String str) {
            AttributeValue access$700 = DynamoDBMapper.this.getAutoGeneratedKeyAttributeValue(this.converter, method);
            this.updateValues.put(str, new AttributeValueUpdate().withAction("PUT").withValue(access$700));
            this.inMemoryUpdates.add(new ValueUpdate(method, access$700, this.object, this.converter));
            if (getLocalSaveBehavior() != DynamoDBMapperConfig.SaveBehavior.CLOBBER && !this.internalExpectedValueAssertions.containsKey(str)) {
                ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue();
                expectedAttributeValue.setExists(false);
                this.internalExpectedValueAssertions.put(str, expectedAttributeValue);
            }
        }

        private void onVersionAttribute(Method method, Object obj, String str) {
            if (getLocalSaveBehavior() != DynamoDBMapperConfig.SaveBehavior.CLOBBER && !this.internalExpectedValueAssertions.containsKey(str)) {
                ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue();
                AttributeValue convert = this.converter.convert(method, obj);
                expectedAttributeValue.setExists(Boolean.valueOf(convert != null));
                if (convert != null) {
                    expectedAttributeValue.setValue(convert);
                }
                this.internalExpectedValueAssertions.put(str, expectedAttributeValue);
            }
            AttributeValue convert2 = this.converter.convert(method, DynamoDBMapper.this.incrementor.increment(method, obj));
            this.updateValues.put(str, new AttributeValueUpdate().withAction("PUT").withValue(convert2));
            this.inMemoryUpdates.add(new ValueUpdate(method, convert2, this.object, this.converter));
        }
    }

    public void delete(Object obj) {
        delete(obj, (DynamoDBDeleteExpression) null, this.config);
    }

    public void delete(Object obj, DynamoDBDeleteExpression dynamoDBDeleteExpression) {
        delete(obj, dynamoDBDeleteExpression, this.config);
    }

    public void delete(Object obj, DynamoDBMapperConfig dynamoDBMapperConfig) {
        delete(obj, (DynamoDBDeleteExpression) null, dynamoDBMapperConfig);
    }

    public <T> void delete(T t, DynamoDBDeleteExpression dynamoDBDeleteExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        ItemConverter converter = getConverter(mergeConfig);
        Class<?> cls = t.getClass();
        String tableName = getTableName(cls, t, mergeConfig);
        Map<String, AttributeValue> key = getKey(converter, t, cls);
        HashMap hashMap = new HashMap();
        if (mergeConfig.getSaveBehavior() != DynamoDBMapperConfig.SaveBehavior.CLOBBER) {
            Iterator<Method> it = this.reflector.getRelevantGetters(cls).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Method next = it.next();
                if (this.reflector.isVersionAttributeGetter(next)) {
                    boolean z = false;
                    Object safeInvoke = ReflectionUtils.safeInvoke(next, t, new Object[0]);
                    String attributeName = this.reflector.getAttributeName(next);
                    ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue();
                    AttributeValue convert = converter.convert(next, safeInvoke);
                    if (convert != null) {
                        z = true;
                    }
                    expectedAttributeValue.setExists(Boolean.valueOf(z));
                    if (convert != null) {
                        expectedAttributeValue.setValue(convert);
                    }
                    hashMap.put(attributeName, expectedAttributeValue);
                }
            }
        }
        DeleteItemRequest deleteItemRequest = (DeleteItemRequest) new DeleteItemRequest().withKey(key).withTableName(tableName).withExpected(hashMap).withRequestMetricCollector(mergeConfig.getRequestMetricCollector());
        if (dynamoDBDeleteExpression != null) {
            String conditionExpression = dynamoDBDeleteExpression.getConditionExpression();
            if (conditionExpression != null) {
                if (hashMap.isEmpty()) {
                    deleteItemRequest = deleteItemRequest.withConditionExpression(conditionExpression).withExpressionAttributeNames(dynamoDBDeleteExpression.getExpressionAttributeNames()).withExpressionAttributeValues(dynamoDBDeleteExpression.getExpressionAttributeValues());
                } else {
                    throw new AmazonClientException("Condition Expressions cannot be used if a versioned attribute is present");
                }
            }
            deleteItemRequest = deleteItemRequest.withExpected(mergeExpectedAttributeValueConditions(hashMap, dynamoDBDeleteExpression.getExpected(), dynamoDBDeleteExpression.getConditionalOperator())).withConditionalOperator(dynamoDBDeleteExpression.getConditionalOperator());
        }
        this.db.deleteItem((DeleteItemRequest) applyUserAgent(deleteItemRequest));
    }

    public List<FailedBatch> batchDelete(List<? extends Object> list) {
        return batchWrite(Collections.emptyList(), list, this.config);
    }

    public List<FailedBatch> batchDelete(Object... objArr) {
        return batchWrite(Collections.emptyList(), Arrays.asList(objArr), this.config);
    }

    public List<FailedBatch> batchSave(List<? extends Object> list) {
        return batchWrite(list, Collections.emptyList(), this.config);
    }

    public List<FailedBatch> batchSave(Object... objArr) {
        return batchWrite(Arrays.asList(objArr), Collections.emptyList(), this.config);
    }

    public List<FailedBatch> batchWrite(List<? extends Object> list, List<? extends Object> list2) {
        return batchWrite(list, list2, this.config);
    }

    public List<FailedBatch> batchWrite(List<? extends Object> list, List<? extends Object> list2, DynamoDBMapperConfig dynamoDBMapperConfig) {
        Iterator<? extends Object> it;
        Object obj;
        LinkedList linkedList;
        AttributeValue attributeValue;
        String str;
        String str2;
        HashMap hashMap;
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        LinkedList linkedList2 = new LinkedList();
        HashMap hashMap2 = new HashMap();
        ItemConverter converter = getConverter(mergeConfig);
        LinkedList<ValueUpdate> linkedList3 = new LinkedList<>();
        Iterator<? extends Object> it2 = list.iterator();
        while (true) {
            int i = 0;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            Class<?> cls = next.getClass();
            String tableName = getTableName(cls, next, mergeConfig);
            HashMap hashMap3 = new HashMap();
            for (Method next2 : this.reflector.getRelevantGetters(cls)) {
                Object safeInvoke = ReflectionUtils.safeInvoke(next2, next, new Object[i]);
                String attributeName = this.reflector.getAttributeName(next2);
                if (safeInvoke != null || !this.reflector.isAssignableKey(next2)) {
                    linkedList = linkedList2;
                    it = it2;
                    obj = next;
                    str2 = attributeName;
                    hashMap = hashMap3;
                    str = tableName;
                    attributeValue = converter.convert(next2, safeInvoke);
                } else {
                    attributeValue = getAutoGeneratedKeyAttributeValue(converter, next2);
                    ValueUpdate valueUpdate = r1;
                    it = it2;
                    str2 = attributeName;
                    linkedList = linkedList2;
                    hashMap = hashMap3;
                    Object obj2 = next;
                    obj = next;
                    str = tableName;
                    ValueUpdate valueUpdate2 = new ValueUpdate(next2, attributeValue, obj2, converter);
                    linkedList3.add(valueUpdate);
                }
                AttributeValue attributeValue2 = attributeValue;
                if (attributeValue2 != null) {
                    hashMap.put(str2, attributeValue2);
                }
                it2 = it;
                hashMap3 = hashMap;
                tableName = str;
                linkedList2 = linkedList;
                next = obj;
                i = 0;
            }
            String str3 = tableName;
            LinkedList linkedList4 = linkedList2;
            Iterator<? extends Object> it3 = it2;
            HashMap hashMap4 = hashMap3;
            if (!hashMap2.containsKey(str3)) {
                hashMap2.put(str3, new LinkedList());
            }
            ((List) hashMap2.get(str3)).add(new WriteRequest().withPutRequest(new PutRequest().withItem(transformAttributes(toParameters((Map<String, AttributeValue>) hashMap4, cls, str3, mergeConfig)))));
            it2 = it3;
            linkedList2 = linkedList4;
        }
        LinkedList linkedList5 = linkedList2;
        for (Object next3 : list2) {
            String tableName2 = getTableName(next3.getClass(), next3, mergeConfig);
            Map<String, AttributeValue> key = getKey(converter, next3);
            if (!hashMap2.containsKey(tableName2)) {
                hashMap2.put(tableName2, new LinkedList());
            }
            ((List) hashMap2.get(tableName2)).add(new WriteRequest().withDeleteRequest(new DeleteRequest().withKey(key)));
        }
        while (!hashMap2.isEmpty()) {
            HashMap hashMap5 = new HashMap();
            Iterator it4 = hashMap2.entrySet().iterator();
            int i2 = 0;
            while (it4.hasNext() && i2 < 25) {
                Map.Entry entry = (Map.Entry) it4.next();
                hashMap5.put(entry.getKey(), new LinkedList());
                Iterator it5 = ((List) entry.getValue()).iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    int i3 = i2 + 1;
                    if (i2 >= 25) {
                        i2 = i3;
                        break;
                    }
                    ((List) hashMap5.get(entry.getKey())).add((WriteRequest) it5.next());
                    it5.remove();
                    i2 = i3;
                }
                if (!it5.hasNext()) {
                    it4.remove();
                }
            }
            List<FailedBatch> writeOneBatch = writeOneBatch(hashMap5);
            LinkedList linkedList6 = linkedList5;
            if (writeOneBatch != null) {
                linkedList6.addAll(writeOneBatch);
                if (containsThrottlingException(writeOneBatch)) {
                    try {
                        Thread.sleep(THREAD_SLEEP_TWO_SECONDS);
                    } catch (InterruptedException e) {
                        InterruptedException interruptedException = e;
                        Thread.currentThread().interrupt();
                        throw new AmazonClientException(interruptedException.getMessage(), interruptedException);
                    }
                }
            }
            linkedList5 = linkedList6;
        }
        LinkedList linkedList7 = linkedList5;
        for (ValueUpdate apply : linkedList3) {
            apply.apply();
        }
        return linkedList7;
    }

    /* access modifiers changed from: package-private */
    public List<FailedBatch> writeOneBatch(Map<String, List<WriteRequest>> map) {
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        FailedBatch callUntilCompletion = callUntilCompletion(map);
        if (callUntilCompletion != null) {
            if (!(callUntilCompletion.getException() instanceof AmazonServiceException) || !RetryUtils.isRequestEntityTooLargeException((AmazonServiceException) callUntilCompletion.getException())) {
                linkedList.add(callUntilCompletion);
            } else if (computeFailedBatchSize(callUntilCompletion) == 1) {
                linkedList.add(callUntilCompletion);
            } else {
                divideBatch(map, hashMap, hashMap2);
                linkedList.addAll(writeOneBatch(hashMap));
                linkedList.addAll(writeOneBatch(hashMap2));
            }
        }
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public boolean containsThrottlingException(List<FailedBatch> list) {
        for (FailedBatch exception : list) {
            Exception exception2 = exception.getException();
            if ((exception2 instanceof AmazonServiceException) && RetryUtils.isThrottlingException((AmazonServiceException) exception2)) {
                return true;
            }
        }
        return false;
    }

    private void divideBatch(Map<String, List<WriteRequest>> map, Map<String, List<WriteRequest>> map2, Map<String, List<WriteRequest>> map3) {
        for (String next : map.keySet()) {
            List list = map.get(next);
            List subList = list.subList(0, list.size() / 2);
            List subList2 = list.subList(list.size() / 2, list.size());
            map2.put(next, subList);
            map3.put(next, subList2);
        }
    }

    private int computeFailedBatchSize(FailedBatch failedBatch) {
        int i = 0;
        for (String str : failedBatch.getUnprocessedItems().keySet()) {
            i += failedBatch.getUnprocessedItems().get(str).size();
        }
        return i;
    }

    private FailedBatch callUntilCompletion(Map<String, List<WriteRequest>> map) {
        int i = 0;
        while (true) {
            try {
                i++;
                map = this.db.batchWriteItem((BatchWriteItemRequest) applyBatchOperationUserAgent(new BatchWriteItemRequest().withRequestItems(map))).getUnprocessedItems();
                if (map.size() <= 0) {
                    return null;
                }
                pauseExponentially(i);
            } catch (Exception e) {
                FailedBatch failedBatch = new FailedBatch();
                failedBatch.setUnprocessedItems(map);
                failedBatch.setException(e);
                return failedBatch;
            }
        }
    }

    public Map<String, List<Object>> batchLoad(List<Object> list) {
        return batchLoad(list, this.config);
    }

    public Map<String, List<Object>> batchLoad(List<Object> list, DynamoDBMapperConfig dynamoDBMapperConfig) {
        int i;
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        boolean z = mergeConfig.getConsistentReads() == DynamoDBMapperConfig.ConsistentReads.CONSISTENT;
        if (list == null || list.isEmpty()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ItemConverter converter = getConverter(mergeConfig);
        loop0:
        while (true) {
            i = 0;
            for (Object next : list) {
                Class<?> cls = next.getClass();
                String tableName = getTableName(cls, next, mergeConfig);
                hashMap2.put(tableName, cls);
                if (!hashMap.containsKey(tableName)) {
                    hashMap.put(tableName, new KeysAndAttributes().withConsistentRead(Boolean.valueOf(z)).withKeys((Collection<Map<String, AttributeValue>>) new LinkedList()));
                }
                ((KeysAndAttributes) hashMap.get(tableName)).getKeys().add(getKey(converter, next));
                i++;
                if (i == 100) {
                    processBatchGetRequest(hashMap2, hashMap, hashMap3, mergeConfig, converter);
                    hashMap.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            processBatchGetRequest(hashMap2, hashMap, hashMap3, mergeConfig, converter);
        }
        return hashMap3;
    }

    public Map<String, List<Object>> batchLoad(Map<Class<?>, List<KeyPair>> map) {
        return batchLoad(map, this.config);
    }

    public Map<String, List<Object>> batchLoad(Map<Class<?>, List<KeyPair>> map, DynamoDBMapperConfig dynamoDBMapperConfig) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (Class next : map.keySet()) {
                if (map.get(next) != null) {
                    for (KeyPair keyPair : map.get(next)) {
                        arrayList.add(createKeyObject(next, keyPair.getHashKey(), keyPair.getRangeKey()));
                    }
                }
            }
        }
        return batchLoad((List<Object>) arrayList, dynamoDBMapperConfig);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processBatchGetRequest(java.util.Map<java.lang.String, java.lang.Class<?>> r10, java.util.Map<java.lang.String, com.amazonaws.services.dynamodbv2.model.KeysAndAttributes> r11, java.util.Map<java.lang.String, java.util.List<java.lang.Object>> r12, com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig r13, com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ItemConverter r14) {
        /*
            r9 = this;
            com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest r0 = new com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest
            r0.<init>()
            com.amazonaws.metrics.RequestMetricCollector r1 = r13.getRequestMetricCollector()
            com.amazonaws.AmazonWebServiceRequest r0 = r0.withRequestMetricCollector(r1)
            com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest r0 = (com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest) r0
            r0.setRequestItems(r11)
            r11 = 0
            r1 = 0
        L_0x0014:
            if (r11 == 0) goto L_0x002e
            int r1 = r1 + 1
            r9.pauseExponentially(r1)
            r2 = 5
            if (r1 > r2) goto L_0x0026
            java.util.Map r11 = r11.getUnprocessedKeys()
            r0.setRequestItems(r11)
            goto L_0x002e
        L_0x0026:
            com.amazonaws.AmazonClientException r10 = new com.amazonaws.AmazonClientException
            java.lang.String r11 = "Batch Get Item request to server hasn't received any data. Please try again later."
            r10.<init>((java.lang.String) r11)
            throw r10
        L_0x002e:
            com.amazonaws.services.dynamodbv2.AmazonDynamoDB r11 = r9.db
            com.amazonaws.AmazonWebServiceRequest r2 = applyBatchOperationUserAgent(r0)
            com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest r2 = (com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest) r2
            com.amazonaws.services.dynamodbv2.model.BatchGetItemResult r11 = r11.batchGetItem((com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest) r2)
            java.util.Map r2 = r11.getResponses()
            java.util.Set r3 = r2.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0046:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0090
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r12.get(r4)
            if (r5 == 0) goto L_0x005f
            java.lang.Object r5 = r12.get(r4)
            java.util.List r5 = (java.util.List) r5
            goto L_0x0064
        L_0x005f:
            java.util.LinkedList r5 = new java.util.LinkedList
            r5.<init>()
        L_0x0064:
            java.lang.Object r6 = r10.get(r4)
            java.lang.Class r6 = (java.lang.Class) r6
            java.lang.Object r7 = r2.get(r4)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0074:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x008c
            java.lang.Object r8 = r7.next()
            java.util.Map r8 = (java.util.Map) r8
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.AttributeTransformer$Parameters r8 = r9.toParameters((java.util.Map<java.lang.String, com.amazonaws.services.dynamodbv2.model.AttributeValue>) r8, r6, (java.lang.String) r4, (com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig) r13)
            java.lang.Object r8 = r9.privateMarshallIntoObject(r14, r8)
            r5.add(r8)
            goto L_0x0074
        L_0x008c:
            r12.put(r4, r5)
            goto L_0x0046
        L_0x0090:
            java.util.Map r2 = r11.getUnprocessedKeys()
            if (r2 == 0) goto L_0x00a0
            java.util.Map r2 = r11.getUnprocessedKeys()
            int r2 = r2.size()
            if (r2 > 0) goto L_0x0014
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper.processBatchGetRequest(java.util.Map, java.util.Map, java.util.Map, com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig, com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ItemConverter):void");
    }

    private final class ValueUpdate {
        private final ItemConverter converter;
        private final Method method;
        private final AttributeValue newValue;
        private final Object target;

        public ValueUpdate(Method method2, AttributeValue attributeValue, Object obj, ItemConverter itemConverter) {
            this.method = method2;
            this.newValue = attributeValue;
            this.target = obj;
            this.converter = itemConverter;
        }

        public void apply() {
            Method setter = DynamoDBMapper.this.reflector.getSetter(this.method);
            Object unconvert = this.converter.unconvert(this.method, setter, this.newValue);
            ReflectionUtils.safeInvoke(setter, this.target, unconvert);
        }
    }

    /* access modifiers changed from: private */
    public Map<String, AttributeValue> convertToItem(Map<String, AttributeValueUpdate> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            AttributeValue value = ((AttributeValueUpdate) next.getValue()).getValue();
            String action = ((AttributeValueUpdate) next.getValue()).getAction();
            if (value != null && !AttributeAction.DELETE.toString().equals(action)) {
                hashMap.put(str, value);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public AttributeValue getAutoGeneratedKeyAttributeValue(ItemConverter itemConverter, Method method) {
        Class<?> returnType = method.getReturnType();
        if (String.class.isAssignableFrom(returnType)) {
            return itemConverter.convert(method, UUID.randomUUID().toString());
        }
        throw new DynamoDBMappingException("Unsupported type for " + method + ": " + returnType + ".  Only Strings are supported when auto-generating keys.");
    }

    public <T> PaginatedScanList<T> scan(Class<T> cls, DynamoDBScanExpression dynamoDBScanExpression) {
        return scan(cls, dynamoDBScanExpression, this.config);
    }

    public <T> PaginatedScanList<T> scan(Class<T> cls, DynamoDBScanExpression dynamoDBScanExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        ScanRequest createScanRequestFromExpression = createScanRequestFromExpression(cls, dynamoDBScanExpression, mergeConfig);
        return new PaginatedScanList(this, cls, this.db, createScanRequestFromExpression, this.db.scan((ScanRequest) applyUserAgent(createScanRequestFromExpression)), mergeConfig.getPaginationLoadingStrategy(), mergeConfig);
    }

    public <T> PaginatedParallelScanList<T> parallelScan(Class<T> cls, DynamoDBScanExpression dynamoDBScanExpression, int i) {
        return parallelScan(cls, dynamoDBScanExpression, i, this.config);
    }

    public <T> PaginatedParallelScanList<T> parallelScan(Class<T> cls, DynamoDBScanExpression dynamoDBScanExpression, int i, DynamoDBMapperConfig dynamoDBMapperConfig) {
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        return new PaginatedParallelScanList(this, cls, this.db, new ParallelScanTask(this, this.db, createParallelScanRequestsFromExpression(cls, dynamoDBScanExpression, i, mergeConfig)), mergeConfig.getPaginationLoadingStrategy(), mergeConfig);
    }

    public <T> ScanResultPage<T> scanPage(Class<T> cls, DynamoDBScanExpression dynamoDBScanExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        ScanRequest createScanRequestFromExpression = createScanRequestFromExpression(cls, dynamoDBScanExpression, mergeConfig);
        ScanResult scan = this.db.scan((ScanRequest) applyUserAgent(createScanRequestFromExpression));
        ScanResultPage<T> scanResultPage = new ScanResultPage<>();
        scanResultPage.setResults(marshallIntoObjects(toParameters(scan.getItems(), cls, createScanRequestFromExpression.getTableName(), mergeConfig)));
        scanResultPage.setLastEvaluatedKey(scan.getLastEvaluatedKey());
        return scanResultPage;
    }

    public <T> ScanResultPage<T> scanPage(Class<T> cls, DynamoDBScanExpression dynamoDBScanExpression) {
        return scanPage(cls, dynamoDBScanExpression, this.config);
    }

    public <T> PaginatedQueryList<T> query(Class<T> cls, DynamoDBQueryExpression<T> dynamoDBQueryExpression) {
        return query(cls, dynamoDBQueryExpression, this.config);
    }

    public <T> PaginatedQueryList<T> query(Class<T> cls, DynamoDBQueryExpression<T> dynamoDBQueryExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        QueryRequest createQueryRequestFromExpression = createQueryRequestFromExpression(cls, dynamoDBQueryExpression, mergeConfig);
        return new PaginatedQueryList(this, cls, this.db, createQueryRequestFromExpression, this.db.query((QueryRequest) applyUserAgent(createQueryRequestFromExpression)), mergeConfig.getPaginationLoadingStrategy(), mergeConfig);
    }

    public <T> QueryResultPage<T> queryPage(Class<T> cls, DynamoDBQueryExpression<T> dynamoDBQueryExpression) {
        return queryPage(cls, dynamoDBQueryExpression, this.config);
    }

    public <T> QueryResultPage<T> queryPage(Class<T> cls, DynamoDBQueryExpression<T> dynamoDBQueryExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        DynamoDBMapperConfig mergeConfig = mergeConfig(dynamoDBMapperConfig);
        QueryRequest createQueryRequestFromExpression = createQueryRequestFromExpression(cls, dynamoDBQueryExpression, mergeConfig);
        QueryResult query = this.db.query((QueryRequest) applyUserAgent(createQueryRequestFromExpression));
        QueryResultPage<T> queryResultPage = new QueryResultPage<>();
        queryResultPage.setResults(marshallIntoObjects(toParameters(query.getItems(), cls, createQueryRequestFromExpression.getTableName(), mergeConfig)));
        queryResultPage.setLastEvaluatedKey(query.getLastEvaluatedKey());
        return queryResultPage;
    }

    public int count(Class<?> cls, DynamoDBScanExpression dynamoDBScanExpression) {
        return count(cls, dynamoDBScanExpression, this.config);
    }

    public int count(Class<?> cls, DynamoDBScanExpression dynamoDBScanExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        ScanResult scan;
        ScanRequest createScanRequestFromExpression = createScanRequestFromExpression(cls, dynamoDBScanExpression, mergeConfig(dynamoDBMapperConfig));
        createScanRequestFromExpression.setSelect(Select.COUNT);
        int i = 0;
        do {
            scan = this.db.scan((ScanRequest) applyUserAgent(createScanRequestFromExpression));
            i += scan.getCount().intValue();
            createScanRequestFromExpression.setExclusiveStartKey(scan.getLastEvaluatedKey());
        } while (scan.getLastEvaluatedKey() != null);
        return i;
    }

    public <T> int count(Class<T> cls, DynamoDBQueryExpression<T> dynamoDBQueryExpression) {
        return count(cls, dynamoDBQueryExpression, this.config);
    }

    public <T> int count(Class<T> cls, DynamoDBQueryExpression<T> dynamoDBQueryExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        QueryResult query;
        QueryRequest createQueryRequestFromExpression = createQueryRequestFromExpression(cls, dynamoDBQueryExpression, mergeConfig(dynamoDBMapperConfig));
        createQueryRequestFromExpression.setSelect(Select.COUNT);
        int i = 0;
        do {
            query = this.db.query((QueryRequest) applyUserAgent(createQueryRequestFromExpression));
            i += query.getCount().intValue();
            createQueryRequestFromExpression.setExclusiveStartKey(query.getLastEvaluatedKey());
        } while (query.getLastEvaluatedKey() != null);
        return i;
    }

    private DynamoDBMapperConfig mergeConfig(DynamoDBMapperConfig dynamoDBMapperConfig) {
        return dynamoDBMapperConfig != this.config ? new DynamoDBMapperConfig(this.config, dynamoDBMapperConfig) : dynamoDBMapperConfig;
    }

    /* access modifiers changed from: package-private */
    public ScanRequest createScanRequestFromExpression(Class<?> cls, DynamoDBScanExpression dynamoDBScanExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(getTableName(cls, dynamoDBMapperConfig));
        scanRequest.setScanFilter(dynamoDBScanExpression.getScanFilter());
        scanRequest.setLimit(dynamoDBScanExpression.getLimit());
        scanRequest.setExclusiveStartKey(dynamoDBScanExpression.getExclusiveStartKey());
        scanRequest.setTotalSegments(dynamoDBScanExpression.getTotalSegments());
        scanRequest.setSegment(dynamoDBScanExpression.getSegment());
        scanRequest.setConditionalOperator(dynamoDBScanExpression.getConditionalOperator());
        scanRequest.setFilterExpression(dynamoDBScanExpression.getFilterExpression());
        scanRequest.setExpressionAttributeNames(dynamoDBScanExpression.getExpressionAttributeNames());
        scanRequest.setExpressionAttributeValues(dynamoDBScanExpression.getExpressionAttributeValues());
        scanRequest.setRequestMetricCollector(dynamoDBMapperConfig.getRequestMetricCollector());
        return (ScanRequest) applyUserAgent(scanRequest);
    }

    /* access modifiers changed from: package-private */
    public List<ScanRequest> createParallelScanRequestsFromExpression(Class<?> cls, DynamoDBScanExpression dynamoDBScanExpression, int i, DynamoDBMapperConfig dynamoDBMapperConfig) {
        if (i >= 1) {
            if (dynamoDBScanExpression.getExclusiveStartKey() != null) {
                log.info("The ExclusiveStartKey parameter specified in the DynamoDBScanExpression is ignored, since the individual parallel scan request on each segment is applied on a separate key scope.");
            }
            if (!(dynamoDBScanExpression.getSegment() == null && dynamoDBScanExpression.getTotalSegments() == null)) {
                log.info("The Segment and TotalSegments parameters specified in the DynamoDBScanExpression are ignored.");
            }
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < i; i2++) {
                linkedList.add(createScanRequestFromExpression(cls, dynamoDBScanExpression, dynamoDBMapperConfig).withSegment(Integer.valueOf(i2)).withTotalSegments(Integer.valueOf(i)).withExclusiveStartKey((Map<String, AttributeValue>) null));
            }
            return linkedList;
        }
        throw new IllegalArgumentException("Parallel scan should have at least one scan segment.");
    }

    private <T> QueryRequest createQueryRequestFromExpression(Class<T> cls, DynamoDBQueryExpression<T> dynamoDBQueryExpression, DynamoDBMapperConfig dynamoDBMapperConfig) {
        QueryRequest queryRequest = new QueryRequest();
        queryRequest.setConsistentRead(Boolean.valueOf(dynamoDBQueryExpression.isConsistentRead()));
        queryRequest.setTableName(getTableName(cls, dynamoDBQueryExpression.getHashKeyValues(), dynamoDBMapperConfig));
        queryRequest.setIndexName(dynamoDBQueryExpression.getIndexName());
        processKeyConditions(cls, queryRequest, getHashKeyEqualsConditions(getConverter(dynamoDBMapperConfig), dynamoDBQueryExpression.getHashKeyValues()), dynamoDBQueryExpression.getRangeKeyConditions());
        queryRequest.setScanIndexForward(Boolean.valueOf(dynamoDBQueryExpression.isScanIndexForward()));
        queryRequest.setLimit(dynamoDBQueryExpression.getLimit());
        queryRequest.setExclusiveStartKey(dynamoDBQueryExpression.getExclusiveStartKey());
        queryRequest.setQueryFilter(dynamoDBQueryExpression.getQueryFilter());
        queryRequest.setConditionalOperator(dynamoDBQueryExpression.getConditionalOperator());
        queryRequest.setRequestMetricCollector(dynamoDBMapperConfig.getRequestMetricCollector());
        queryRequest.setFilterExpression(dynamoDBQueryExpression.getFilterExpression());
        queryRequest.setExpressionAttributeNames(dynamoDBQueryExpression.getExpressionAttributeNames());
        queryRequest.setExpressionAttributeValues(dynamoDBQueryExpression.getExpressionAttributeValues());
        queryRequest.setKeyConditionExpression(dynamoDBQueryExpression.getKeyConditionExpression());
        return (QueryRequest) applyUserAgent(queryRequest);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processKeyConditions(java.lang.Class<?> r22, com.amazonaws.services.dynamodbv2.model.QueryRequest r23, java.util.Map<java.lang.String, com.amazonaws.services.dynamodbv2.model.Condition> r24, java.util.Map<java.lang.String, com.amazonaws.services.dynamodbv2.model.Condition> r25) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            if (r3 == 0) goto L_0x0385
            boolean r5 = r24.isEmpty()
            if (r5 != 0) goto L_0x0385
            r5 = 1
            if (r4 == 0) goto L_0x003d
            int r6 = r25.size()
            if (r6 > r5) goto L_0x001c
            goto L_0x003d
        L_0x001c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Illegal query expression: Conditions on multiple range keys ("
            r2.<init>(r3)
            java.util.Set r3 = r25.keySet()
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.String r3 = ") are found in the query. DynamoDB service only accepts up to ONE range key condition."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x003d:
            if (r4 == 0) goto L_0x0047
            boolean r7 = r25.isEmpty()
            if (r7 != 0) goto L_0x0047
            r7 = r5
            goto L_0x0048
        L_0x0047:
            r7 = 0
        L_0x0048:
            java.lang.String r8 = r23.getIndexName()
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBReflector r9 = r0.reflector
            java.lang.String r9 = r9.getPrimaryHashKeyName(r1)
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTableSchemaParser r10 = r0.schemaParser
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBReflector r11 = r0.reflector
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTableSchemaParser$TableIndexesInfo r10 = r10.parseTableIndexes(r1, r11)
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.HashSet r12 = new java.util.HashSet
            r12.<init>()
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            if (r7 == 0) goto L_0x00d3
            java.util.Set r15 = r25.keySet()
            java.util.Iterator r15 = r15.iterator()
            r6 = 0
            r16 = 0
        L_0x0076:
            boolean r17 = r15.hasNext()
            if (r17 == 0) goto L_0x00ab
            java.lang.Object r6 = r15.next()
            java.lang.String r6 = (java.lang.String) r6
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBReflector r14 = r0.reflector
            boolean r14 = r14.hasPrimaryRangeKey(r1)
            if (r14 == 0) goto L_0x0098
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBReflector r14 = r0.reflector
            java.lang.String r14 = r14.getPrimaryRangeKeyName(r1)
            boolean r14 = r6.equals(r14)
            if (r14 == 0) goto L_0x0098
            r16 = r5
        L_0x0098:
            java.util.Set r14 = r10.getLsiNamesByIndexRangeKey(r6)
            if (r14 == 0) goto L_0x00a1
            r12.addAll(r14)
        L_0x00a1:
            java.util.Set r14 = r10.getGsiNamesByIndexRangeKey(r6)
            if (r14 == 0) goto L_0x0076
            r13.addAll(r14)
            goto L_0x0076
        L_0x00ab:
            if (r16 != 0) goto L_0x00d6
            boolean r1 = r12.isEmpty()
            if (r1 == 0) goto L_0x00d6
            boolean r1 = r13.isEmpty()
            if (r1 != 0) goto L_0x00ba
            goto L_0x00d6
        L_0x00ba:
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException r1 = new com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "The query contains a condition on a range key ("
            r2.<init>(r3)
            r2.append(r6)
            java.lang.String r3 = ") that is not annotated with either @DynamoDBRangeKey or @DynamoDBIndexRangeKey."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x00d3:
            r6 = 0
            r16 = 0
        L_0x00d6:
            if (r8 == 0) goto L_0x00e0
            boolean r1 = r12.contains(r8)
            if (r1 == 0) goto L_0x00e0
            r1 = r5
            goto L_0x00e1
        L_0x00e0:
            r1 = 0
        L_0x00e1:
            if (r8 == 0) goto L_0x00f1
            if (r7 != 0) goto L_0x00f1
            java.util.Set r14 = r10.getAllLsiNames()
            boolean r14 = r14.contains(r8)
            if (r14 == 0) goto L_0x00f1
            r14 = r5
            goto L_0x00f2
        L_0x00f1:
            r14 = 0
        L_0x00f2:
            if (r1 != 0) goto L_0x00f9
            if (r14 == 0) goto L_0x00f7
            goto L_0x00f9
        L_0x00f7:
            r1 = 0
            goto L_0x00fa
        L_0x00f9:
            r1 = r5
        L_0x00fa:
            if (r8 == 0) goto L_0x0104
            boolean r14 = r13.contains(r8)
            if (r14 == 0) goto L_0x0104
            r14 = r5
            goto L_0x0105
        L_0x0104:
            r14 = 0
        L_0x0105:
            if (r8 == 0) goto L_0x0115
            if (r7 != 0) goto L_0x0115
            java.util.Set r15 = r10.getAllGsiNames()
            boolean r15 = r15.contains(r8)
            if (r15 == 0) goto L_0x0115
            r15 = r5
            goto L_0x0116
        L_0x0115:
            r15 = 0
        L_0x0116:
            if (r14 != 0) goto L_0x011d
            if (r15 == 0) goto L_0x011b
            goto L_0x011d
        L_0x011b:
            r14 = 0
            goto L_0x011e
        L_0x011d:
            r14 = r5
        L_0x011e:
            if (r1 == 0) goto L_0x013c
            if (r14 != 0) goto L_0x0123
            goto L_0x013c
        L_0x0123:
            com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException r1 = new com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid query: Index \""
            r2.<init>(r3)
            r2.append(r8)
            java.lang.String r3 = "\" is annotateded as both a LSI and a GSI for attribute."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x013c:
            java.util.Set r15 = r24.keySet()
            java.util.Iterator r15 = r15.iterator()
            r5 = 0
            r18 = 0
        L_0x0147:
            boolean r19 = r15.hasNext()
            if (r19 == 0) goto L_0x01c4
            java.lang.Object r19 = r15.next()
            r0 = r19
            java.lang.String r0 = (java.lang.String) r0
            boolean r19 = r0.equals(r9)
            r22 = r15
            if (r19 == 0) goto L_0x015f
            r18 = 1
        L_0x015f:
            java.util.Set r15 = r10.getGsiNamesByIndexHashKey(r0)
            if (r15 != 0) goto L_0x0171
            java.util.HashSet r19 = new java.util.HashSet
            r19.<init>()
            r20 = r19
            r19 = r10
            r10 = r20
            goto L_0x0178
        L_0x0171:
            r19 = r10
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>(r15)
        L_0x0178:
            r11.put(r0, r10)
            if (r8 == 0) goto L_0x01bd
            if (r1 == 0) goto L_0x0186
            boolean r10 = r0.equals(r9)
            if (r10 == 0) goto L_0x0186
            goto L_0x0190
        L_0x0186:
            if (r14 == 0) goto L_0x01bd
            if (r15 == 0) goto L_0x01bd
            boolean r10 = r15.contains(r8)
            if (r10 == 0) goto L_0x01bd
        L_0x0190:
            if (r5 != 0) goto L_0x0194
            r5 = r0
            goto L_0x01bd
        L_0x0194:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Ambiguous query expression: More than one hash key EQ conditions ("
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r3 = ", "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") are applicable to the specified index ("
            r2.append(r0)
            r2.append(r8)
            java.lang.String r0 = "). Please provide only one of them in the query expression."
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01bd:
            r0 = r21
            r15 = r22
            r10 = r19
            goto L_0x0147
        L_0x01c4:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r8 == 0) goto L_0x0212
            java.lang.String r6 = "). "
            if (r7 == 0) goto L_0x01eb
            if (r1 != 0) goto L_0x01eb
            if (r14 == 0) goto L_0x01d4
            goto L_0x01eb
        L_0x01d4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Illegal query expression: No range key condition is applicable to the specified index ("
            r1.<init>(r2)
            r1.append(r8)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01eb:
            if (r5 == 0) goto L_0x01fb
            java.lang.Object r1 = r3.get(r5)
            r0.put(r5, r1)
            if (r7 == 0) goto L_0x0381
            r0.putAll(r4)
            goto L_0x0381
        L_0x01fb:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Illegal query expression: No hash key condition is applicable to the specified index ("
            r1.<init>(r2)
            r1.append(r8)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0212:
            if (r7 == 0) goto L_0x02dc
            if (r18 == 0) goto L_0x021b
            if (r16 == 0) goto L_0x021b
            r14 = 0
            goto L_0x02c3
        L_0x021b:
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r1 = r1.iterator()
            r5 = 0
            r7 = 0
        L_0x0225:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x02be
            java.lang.Object r8 = r1.next()
            java.lang.String r8 = (java.lang.String) r8
            boolean r10 = r8.equals(r9)
            if (r10 == 0) goto L_0x024a
            int r10 = r12.size()
            r14 = 1
            if (r10 != r14) goto L_0x024a
            java.util.Iterator r10 = r12.iterator()
            java.lang.Object r10 = r10.next()
            java.lang.String r10 = (java.lang.String) r10
            r14 = 1
            goto L_0x024c
        L_0x024a:
            r10 = 0
            r14 = 0
        L_0x024c:
            java.lang.Object r15 = r11.get(r8)
            java.util.Set r15 = (java.util.Set) r15
            r15.retainAll(r13)
            r22 = r1
            int r1 = r15.size()
            r16 = r5
            r5 = 1
            if (r1 != r5) goto L_0x0274
            if (r14 == 0) goto L_0x0265
            r5 = r8
            r7 = r10
            goto L_0x0267
        L_0x0265:
            r5 = r16
        L_0x0267:
            java.util.Iterator r1 = r15.iterator()
            java.lang.Object r1 = r1.next()
            r10 = r1
            java.lang.String r10 = (java.lang.String) r10
            r14 = 1
            goto L_0x0276
        L_0x0274:
            r5 = r16
        L_0x0276:
            if (r14 == 0) goto L_0x02ba
            if (r5 != 0) goto L_0x027d
            r5 = r8
            r7 = r10
            goto L_0x02ba
        L_0x027d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Ambiguous query expression: Found multiple valid queries: (Hash: \""
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r2 = "\", Range: \""
            r1.append(r2)
            r1.append(r6)
            java.lang.String r3 = "\", Index: \""
            r1.append(r3)
            r1.append(r7)
            java.lang.String r4 = "\") and (Hash: \""
            r1.append(r4)
            r1.append(r8)
            r1.append(r2)
            r1.append(r6)
            r1.append(r3)
            r1.append(r10)
            java.lang.String r2 = "\")."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x02ba:
            r1 = r22
            goto L_0x0225
        L_0x02be:
            r16 = r5
            r14 = r7
            r9 = r16
        L_0x02c3:
            if (r9 == 0) goto L_0x02d4
            java.lang.Object r1 = r3.get(r9)
            r0.put(r9, r1)
            r0.putAll(r4)
            r2.setIndexName(r14)
            goto L_0x0381
        L_0x02d4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Illegal query expression: Cannot infer the index name from the query expression."
            r0.<init>(r1)
            throw r0
        L_0x02dc:
            int r1 = r24.size()
            r4 = 1
            if (r1 <= r4) goto L_0x030b
            if (r18 == 0) goto L_0x02ee
            java.lang.Object r1 = r3.get(r9)
            r0.put(r9, r1)
            goto L_0x0381
        L_0x02ee:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Ambiguous query expression: More than one index hash key EQ conditions ("
            r1.<init>(r2)
            java.util.Set r2 = r24.keySet()
            r1.append(r2)
            java.lang.String r2 = ") are applicable to the query. Please provide only one of them in the query expression, or specify the appropriate index name."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x030b:
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r1 = r1.iterator()
            java.lang.Object r1 = r1.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r18 != 0) goto L_0x037e
            java.lang.Object r4 = r11.get(r1)
            java.util.Set r4 = (java.util.Set) r4
            int r4 = r4.size()
            r5 = 1
            if (r4 != r5) goto L_0x033c
            java.lang.Object r1 = r11.get(r1)
            java.util.Set r1 = (java.util.Set) r1
            java.util.Iterator r1 = r1.iterator()
            java.lang.Object r1 = r1.next()
            java.lang.String r1 = (java.lang.String) r1
            r2.setIndexName(r1)
            goto L_0x037e
        L_0x033c:
            java.lang.Object r0 = r11.get(r1)
            java.util.Set r0 = (java.util.Set) r0
            int r0 = r0.size()
            if (r0 <= r5) goto L_0x0365
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Ambiguous query expression: More than one GSIs ("
            r2.<init>(r3)
            java.lang.Object r1 = r11.get(r1)
            r2.append(r1)
            java.lang.String r1 = ") are applicable to the query. Please specify one of them in your query expression."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0365:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Illegal query expression: No GSI is found in the @DynamoDBIndexHashKey annotation for attribute \""
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = "\"."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x037e:
            r0.putAll(r3)
        L_0x0381:
            r2.setKeyConditions(r0)
            return
        L_0x0385:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Illegal query expression: No hash key condition is found in the query"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper.processKeyConditions(java.lang.Class, com.amazonaws.services.dynamodbv2.model.QueryRequest, java.util.Map, java.util.Map):void");
    }

    /* access modifiers changed from: private */
    public <T> AttributeTransformer.Parameters<T> toParameters(Map<String, AttributeValue> map, Class<T> cls, String str, DynamoDBMapperConfig dynamoDBMapperConfig) {
        return toParameters(map, false, cls, str, dynamoDBMapperConfig);
    }

    private <T> AttributeTransformer.Parameters<T> toParameters(Map<String, AttributeValue> map, boolean z, Class<T> cls, String str, DynamoDBMapperConfig dynamoDBMapperConfig) {
        return new TransformerParameters(this.reflector, map, z, cls, dynamoDBMapperConfig, str);
    }

    /* access modifiers changed from: package-private */
    public final <T> List<AttributeTransformer.Parameters<T>> toParameters(List<Map<String, AttributeValue>> list, Class<T> cls, String str, DynamoDBMapperConfig dynamoDBMapperConfig) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Map<String, AttributeValue> parameters : list) {
            arrayList.add(toParameters(parameters, cls, str, dynamoDBMapperConfig));
        }
        return arrayList;
    }

    private static class TransformerParameters<T> implements AttributeTransformer.Parameters<T> {
        private final Map<String, AttributeValue> attributeValues;
        private String hashKeyName;
        private final DynamoDBMapperConfig mapperConfig;
        private final Class<T> modelClass;
        private final boolean partialUpdate;
        private String rangeKeyName;
        private final DynamoDBReflector reflector;
        private final String tableName;

        public TransformerParameters(DynamoDBReflector dynamoDBReflector, Map<String, AttributeValue> map, boolean z, Class<T> cls, DynamoDBMapperConfig dynamoDBMapperConfig, String str) {
            this.reflector = dynamoDBReflector;
            this.attributeValues = Collections.unmodifiableMap(map);
            this.partialUpdate = z;
            this.modelClass = cls;
            this.mapperConfig = dynamoDBMapperConfig;
            this.tableName = str;
        }

        public Map<String, AttributeValue> getAttributeValues() {
            return this.attributeValues;
        }

        public boolean isPartialUpdate() {
            return this.partialUpdate;
        }

        public Class<T> getModelClass() {
            return this.modelClass;
        }

        public DynamoDBMapperConfig getMapperConfig() {
            return this.mapperConfig;
        }

        public String getTableName() {
            return this.tableName;
        }

        public String getHashKeyName() {
            if (this.hashKeyName == null) {
                this.hashKeyName = this.reflector.getAttributeName(this.reflector.getPrimaryHashKeyGetter(this.modelClass));
            }
            return this.hashKeyName;
        }

        public String getRangeKeyName() {
            if (this.rangeKeyName == null) {
                Method primaryRangeKeyGetter = this.reflector.getPrimaryRangeKeyGetter(this.modelClass);
                if (primaryRangeKeyGetter == null) {
                    this.rangeKeyName = DynamoDBMapper.NO_RANGE_KEY;
                } else {
                    this.rangeKeyName = this.reflector.getAttributeName(primaryRangeKeyGetter);
                }
            }
            if (this.rangeKeyName == DynamoDBMapper.NO_RANGE_KEY) {
                return null;
            }
            return this.rangeKeyName;
        }
    }

    private Map<String, AttributeValue> untransformAttributes(AttributeTransformer.Parameters<?> parameters) {
        AttributeTransformer attributeTransformer = this.transformer;
        if (attributeTransformer != null) {
            return attributeTransformer.untransform(parameters);
        }
        return parameters.getAttributeValues();
    }

    /* access modifiers changed from: private */
    public Map<String, AttributeValue> transformAttributes(AttributeTransformer.Parameters<?> parameters) {
        AttributeTransformer attributeTransformer = this.transformer;
        if (attributeTransformer != null) {
            return attributeTransformer.transform(parameters);
        }
        return parameters.getAttributeValues();
    }

    /* access modifiers changed from: package-private */
    public Map<String, AttributeValueUpdate> transformAttributeUpdates(Class<?> cls, String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2, DynamoDBMapperConfig dynamoDBMapperConfig) {
        Map<String, AttributeValue> convertToItem = convertToItem(map2);
        HashSet hashSet = new HashSet();
        for (Map.Entry next : map.entrySet()) {
            if (!convertToItem.containsKey(next.getKey())) {
                hashSet.add(next.getKey());
                convertToItem.put(next.getKey(), next.getValue());
            }
        }
        AttributeTransformer.Parameters<T> parameters = toParameters(convertToItem, true, cls, str, dynamoDBMapperConfig);
        String hashKeyName = parameters.getHashKeyName();
        if (!convertToItem.containsKey(hashKeyName)) {
            convertToItem.put(hashKeyName, map.get(hashKeyName));
        }
        for (Map.Entry next2 : transformAttributes(parameters).entrySet()) {
            if (!hashSet.contains(next2.getKey())) {
                AttributeValueUpdate attributeValueUpdate = map2.get(next2.getKey());
                if (attributeValueUpdate != null) {
                    attributeValueUpdate.getValue().withB(((AttributeValue) next2.getValue()).getB()).withBS((Collection<ByteBuffer>) ((AttributeValue) next2.getValue()).getBS()).withN(((AttributeValue) next2.getValue()).getN()).withNS((Collection<String>) ((AttributeValue) next2.getValue()).getNS()).withS(((AttributeValue) next2.getValue()).getS()).withSS((Collection<String>) ((AttributeValue) next2.getValue()).getSS());
                } else {
                    map2.put(next2.getKey(), new AttributeValueUpdate((AttributeValue) next2.getValue(), "PUT"));
                }
            }
        }
        return map2;
    }

    /* access modifiers changed from: package-private */
    public ItemConverter getConverter(DynamoDBMapperConfig dynamoDBMapperConfig) {
        return dynamoDBMapperConfig.getConversionSchema().getConverter(new ConversionSchema.Dependencies().with(DynamoDBReflector.class, this.reflector).with(S3ClientCache.class, this.s3cc));
    }

    private void pauseExponentially(int i) {
        if (i != 0) {
            try {
                Thread.sleep(Math.min((long) (Math.pow(2.0d, (double) i) * ((double) ((long) (new Random().nextInt(100) + 500)))), MAX_BACKOFF_IN_MILLISECONDS));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new AmazonClientException(e.getMessage(), e);
            }
        }
    }

    static Map<String, ExpectedAttributeValue> mergeExpectedAttributeValueConditions(Map<String, ExpectedAttributeValue> map, Map<String, ExpectedAttributeValue> map2, String str) {
        if ((map == null || map.isEmpty()) && (map2 == null || map2.isEmpty())) {
            return null;
        }
        if (map == null) {
            return new HashMap(map2);
        }
        if (map2 == null) {
            return new HashMap(map);
        }
        HashMap hashMap = new HashMap(map);
        for (String remove : map2.keySet()) {
            hashMap.remove(remove);
        }
        if (!ConditionalOperator.OR.toString().equals(str) || hashMap.isEmpty()) {
            hashMap.putAll(map2);
            return hashMap;
        }
        throw new IllegalArgumentException("Unable to assert the value of the fields " + hashMap.keySet() + ", since the expected value conditions cannot be combined with user-specified conditions joined by \"OR\". You can use SaveBehavior.CLOBBER to skip the assertion on these fields.");
    }

    static <X extends AmazonWebServiceRequest> X applyUserAgent(X x) {
        RequestClientOptions requestClientOptions = x.getRequestClientOptions();
        requestClientOptions.appendUserAgent(DynamoDBMapper.class.getName() + "/" + getUserAgentFromConfig() + VersionInfoUtils.getVersion());
        return x;
    }

    static <X extends AmazonWebServiceRequest> X applyBatchOperationUserAgent(X x) {
        RequestClientOptions requestClientOptions = x.getRequestClientOptions();
        requestClientOptions.appendUserAgent(DynamoDBMapper.class.getName() + "_batch_operation/" + getUserAgentFromConfig() + VersionInfoUtils.getVersion());
        return x;
    }

    public static class FailedBatch {
        private Exception exception;
        private Map<String, List<WriteRequest>> unprocessedItems;

        public void setUnprocessedItems(Map<String, List<WriteRequest>> map) {
            this.unprocessedItems = map;
        }

        public Map<String, List<WriteRequest>> getUnprocessedItems() {
            return this.unprocessedItems;
        }

        public void setException(Exception exc) {
            this.exception = exc;
        }

        public Exception getException() {
            return this.exception;
        }
    }

    public S3ClientCache getS3ClientCache() {
        return this.s3cc;
    }

    public S3Link createS3Link(String str, String str2) {
        return createS3Link((com.amazonaws.services.s3.model.Region) null, str, str2);
    }

    public S3Link createS3Link(com.amazonaws.services.s3.model.Region region, String str, String str2) {
        if (this.s3cc != null) {
            return new S3Link(this.s3cc, region, str, str2);
        }
        throw new IllegalStateException("Mapper must be constructed with S3 AWS Credentials to create S3Link");
    }

    public CreateTableRequest generateCreateTableRequest(Class<?> cls) {
        return this.schemaParser.parseTablePojoToCreateTableRequest(cls, this.config, this.reflector, getConverter(this.config));
    }
}
