package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndex;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndex;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.services.dynamodbv2.model.ProjectionType;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class DynamoDBTableSchemaParser {
    private final Map<Class<?>, TableIndexesInfo> tableIndexesInfoCache = new HashMap();

    DynamoDBTableSchemaParser() {
    }

    /* access modifiers changed from: package-private */
    public CreateTableRequest parseTablePojoToCreateTableRequest(Class<?> cls, DynamoDBMapperConfig dynamoDBMapperConfig, DynamoDBReflector dynamoDBReflector, ItemConverter itemConverter) {
        CreateTableRequest createTableRequest = new CreateTableRequest();
        AttributeDefinition attributeDefinition = null;
        createTableRequest.setTableName(DynamoDBMapper.internalGetTableName(cls, (Object) null, dynamoDBMapperConfig));
        AttributeDefinition keyAttributeDefinition = getKeyAttributeDefinition(dynamoDBReflector.getPrimaryHashKeyGetter(cls), itemConverter);
        createTableRequest.withKeySchema(new KeySchemaElement(keyAttributeDefinition.getAttributeName(), KeyType.HASH));
        Method primaryRangeKeyGetter = dynamoDBReflector.getPrimaryRangeKeyGetter(cls);
        if (primaryRangeKeyGetter != null) {
            attributeDefinition = getKeyAttributeDefinition(primaryRangeKeyGetter, itemConverter);
            createTableRequest.withKeySchema(new KeySchemaElement(attributeDefinition.getAttributeName(), KeyType.RANGE));
        }
        TableIndexesInfo parseTableIndexes = parseTableIndexes(cls, dynamoDBReflector);
        if (!parseTableIndexes.getGlobalSecondaryIndexes().isEmpty()) {
            createTableRequest.setGlobalSecondaryIndexes(parseTableIndexes.getGlobalSecondaryIndexes());
        }
        if (!parseTableIndexes.getLocalSecondaryIndexes().isEmpty()) {
            createTableRequest.setLocalSecondaryIndexes(parseTableIndexes.getLocalSecondaryIndexes());
        }
        HashMap hashMap = new HashMap();
        putAfterCheckConflict(hashMap, keyAttributeDefinition);
        if (primaryRangeKeyGetter != null) {
            putAfterCheckConflict(hashMap, attributeDefinition);
        }
        for (Method keyAttributeDefinition2 : parseTableIndexes.getIndexKeyGetters()) {
            putAfterCheckConflict(hashMap, getKeyAttributeDefinition(keyAttributeDefinition2, itemConverter));
        }
        createTableRequest.setAttributeDefinitions(hashMap.values());
        return createTableRequest;
    }

    /* access modifiers changed from: package-private */
    public TableIndexesInfo parseTableIndexes(Class<?> cls, DynamoDBReflector dynamoDBReflector) {
        TableIndexesInfo tableIndexesInfo;
        Class<?> cls2 = cls;
        DynamoDBReflector dynamoDBReflector2 = dynamoDBReflector;
        synchronized (this.tableIndexesInfoCache) {
            if (!this.tableIndexesInfoCache.containsKey(cls2)) {
                TableIndexesInfo tableIndexesInfo2 = new TableIndexesInfo();
                String primaryHashKeyName = dynamoDBReflector2.getPrimaryHashKeyName(cls2);
                for (Method next : dynamoDBReflector2.getRelevantGetters(cls2)) {
                    if (next.getParameterTypes().length == 0) {
                        String attributeName = dynamoDBReflector2.getAttributeName(next);
                        if (ReflectionUtils.getterOrFieldHasAnnotation(next, DynamoDBIndexHashKey.class)) {
                            DynamoDBIndexHashKey dynamoDBIndexHashKey = (DynamoDBIndexHashKey) ReflectionUtils.getAnnotationFromGetterOrField(next, DynamoDBIndexHashKey.class);
                            String globalSecondaryIndexName = dynamoDBIndexHashKey.globalSecondaryIndexName();
                            String[] globalSecondaryIndexNames = dynamoDBIndexHashKey.globalSecondaryIndexNames();
                            boolean z = (globalSecondaryIndexName == null || globalSecondaryIndexName.length() == 0) ? false : true;
                            boolean z2 = (globalSecondaryIndexNames == null || globalSecondaryIndexNames.length == 0) ? false : true;
                            if (z) {
                                if (z2) {
                                    throw new DynamoDBMappingException("@DynamoDBIndexHashKey annotation on getter " + next + " contains both globalSecondaryIndexName and globalSecondaryIndexNames.");
                                }
                            }
                            if (!z) {
                                if (!z2) {
                                    throw new DynamoDBMappingException("@DynamoDBIndexHashKey annotation on getter " + next + " doesn't contain any index name.");
                                }
                            }
                            if (z) {
                                tableIndexesInfo2.addGsiKeys(globalSecondaryIndexName, attributeName, (String) null);
                            } else if (z2) {
                                for (String access$300 : globalSecondaryIndexNames) {
                                    tableIndexesInfo2.addGsiKeys(access$300, attributeName, (String) null);
                                }
                            }
                            tableIndexesInfo2.addIndexKeyGetter(next);
                        }
                        if (ReflectionUtils.getterOrFieldHasAnnotation(next, DynamoDBIndexRangeKey.class)) {
                            DynamoDBIndexRangeKey dynamoDBIndexRangeKey = (DynamoDBIndexRangeKey) ReflectionUtils.getAnnotationFromGetterOrField(next, DynamoDBIndexRangeKey.class);
                            String globalSecondaryIndexName2 = dynamoDBIndexRangeKey.globalSecondaryIndexName();
                            String[] globalSecondaryIndexNames2 = dynamoDBIndexRangeKey.globalSecondaryIndexNames();
                            String localSecondaryIndexName = dynamoDBIndexRangeKey.localSecondaryIndexName();
                            String[] localSecondaryIndexNames = dynamoDBIndexRangeKey.localSecondaryIndexNames();
                            boolean z3 = (globalSecondaryIndexName2 == null || globalSecondaryIndexName2.length() == 0) ? false : true;
                            boolean z4 = (globalSecondaryIndexNames2 == null || globalSecondaryIndexNames2.length == 0) ? false : true;
                            boolean z5 = (localSecondaryIndexName == null || localSecondaryIndexName.length() == 0) ? false : true;
                            boolean z6 = (localSecondaryIndexNames == null || localSecondaryIndexNames.length == 0) ? false : true;
                            if (z3) {
                                if (z4) {
                                    throw new DynamoDBMappingException("@DynamoDBIndexRangeKey annotation on getter " + next + " contains both globalSecondaryIndexName and globalSecondaryIndexNames.");
                                }
                            }
                            if (z5) {
                                if (z6) {
                                    throw new DynamoDBMappingException("@DynamoDBIndexRangeKey annotation on getter " + next + " contains both localSecondaryIndexName and localSecondaryIndexNames.");
                                }
                            }
                            if (!z3 && !z4 && !z5) {
                                if (!z6) {
                                    throw new DynamoDBMappingException("@DynamoDBIndexRangeKey annotation on getter " + next + " doesn't contain any index name.");
                                }
                            }
                            if (z3) {
                                tableIndexesInfo2.addGsiKeys(globalSecondaryIndexName2, (String) null, attributeName);
                            } else if (z4) {
                                for (String access$3002 : globalSecondaryIndexNames2) {
                                    tableIndexesInfo2.addGsiKeys(access$3002, (String) null, attributeName);
                                }
                            }
                            if (z5) {
                                tableIndexesInfo2.addLsiRangeKey(localSecondaryIndexName, primaryHashKeyName, attributeName);
                            } else if (z6) {
                                for (String access$500 : localSecondaryIndexNames) {
                                    tableIndexesInfo2.addLsiRangeKey(access$500, primaryHashKeyName, attributeName);
                                }
                            }
                            tableIndexesInfo2.addIndexKeyGetter(next);
                        } else {
                            continue;
                        }
                    }
                }
                this.tableIndexesInfoCache.put(cls2, tableIndexesInfo2);
            }
            tableIndexesInfo = this.tableIndexesInfoCache.get(cls2);
        }
        return tableIndexesInfo;
    }

    private static AttributeDefinition getKeyAttributeDefinition(Method method, ItemConverter itemConverter) {
        DynamoDBMapperFieldModel fieldModel = itemConverter.getFieldModel(method);
        String dynamoDBAttributeName = fieldModel.getDynamoDBAttributeName();
        DynamoDBMapperFieldModel.DynamoDBAttributeType dynamoDBAttributeType = fieldModel.getDynamoDBAttributeType();
        if (dynamoDBAttributeType == DynamoDBMapperFieldModel.DynamoDBAttributeType.S || dynamoDBAttributeType == DynamoDBMapperFieldModel.DynamoDBAttributeType.N || dynamoDBAttributeType == DynamoDBMapperFieldModel.DynamoDBAttributeType.B) {
            return new AttributeDefinition(dynamoDBAttributeName, dynamoDBAttributeType.toString());
        }
        throw new DynamoDBMappingException("The key attribute must be in a scalar type (String, Number or Binary).");
    }

    private static void putAfterCheckConflict(Map<String, AttributeDefinition> map, AttributeDefinition attributeDefinition) {
        String attributeName = attributeDefinition.getAttributeName();
        AttributeDefinition attributeDefinition2 = map.get(attributeName);
        if (attributeDefinition2 == null || attributeDefinition2.equals(attributeDefinition)) {
            map.put(attributeName, attributeDefinition);
            return;
        }
        throw new DynamoDBMappingException("Found conflicting definitions for attribute [" + attributeName + "]: " + attributeDefinition2 + " and " + attributeDefinition + InstructionFileId.DOT);
    }

    static class TableIndexesInfo {
        private final Map<String, Set<String>> gsiHashKeyNameToIndexNames = new HashMap();
        private final Map<String, GlobalSecondaryIndex> gsiNameToGsiDefinition = new HashMap();
        private final Map<String, Set<String>> gsiRangeKeyNameToIndexNames = new HashMap();
        private final Set<Method> indexKeyGetters = new HashSet();
        private final Map<String, LocalSecondaryIndex> lsiNameToLsiDefinition = new HashMap();
        private final Map<String, Set<String>> lsiRangeKeyNameToIndexNames = new HashMap();

        TableIndexesInfo() {
        }

        public Set<String> getLsiNamesByIndexRangeKey(String str) {
            Set<String> set = this.lsiRangeKeyNameToIndexNames.get(str);
            return set != null ? Collections.unmodifiableSet(set) : set;
        }

        public Set<String> getGsiNamesByIndexHashKey(String str) {
            Set<String> set = this.gsiHashKeyNameToIndexNames.get(str);
            return set != null ? Collections.unmodifiableSet(set) : set;
        }

        public Set<String> getGsiNamesByIndexRangeKey(String str) {
            Set<String> set = this.gsiRangeKeyNameToIndexNames.get(str);
            return set != null ? Collections.unmodifiableSet(set) : set;
        }

        public Set<String> getAllLsiNames() {
            return Collections.unmodifiableSet(this.lsiNameToLsiDefinition.keySet());
        }

        public Set<String> getAllGsiNames() {
            return Collections.unmodifiableSet(this.gsiNameToGsiDefinition.keySet());
        }

        /* access modifiers changed from: private */
        public void addGsiKeys(String str, String str2, String str3) {
            GlobalSecondaryIndex globalSecondaryIndex;
            if (this.gsiNameToGsiDefinition.containsKey(str)) {
                globalSecondaryIndex = this.gsiNameToGsiDefinition.get(str);
                if (str.equals(globalSecondaryIndex.getIndexName())) {
                    for (KeySchemaElement next : globalSecondaryIndex.getKeySchema()) {
                        String attributeName = next.getAttributeName();
                        String keyType = next.getKeyType();
                        if (KeyType.HASH.toString().equals(keyType)) {
                            if (str2 != null && !str2.equals(attributeName)) {
                                throw new DynamoDBMappingException("Multiple hash keys [" + attributeName + ", " + str2 + "] are found for the GSI [" + str + "]. Each index allows at most one range key attribute.");
                            }
                        } else if (!KeyType.RANGE.toString().equals(keyType)) {
                            throw new IllegalStateException("Found invalid state of an existing GlobalSecondaryIndex object associated with the GSI [" + str + "].");
                        } else if (str3 != null && !str3.equals(attributeName)) {
                            throw new DynamoDBMappingException("Multiple range keys [" + attributeName + ", " + str3 + "] are found for the GSI [" + str + "]. Each index allows at most one range key attribute.");
                        }
                    }
                } else {
                    throw new IllegalStateException("Found invalid state of an existing GlobalSecondaryIndex object associated with the GSI [" + str + "].");
                }
            } else {
                globalSecondaryIndex = new GlobalSecondaryIndex().withIndexName(str).withProjection(new Projection().withProjectionType(ProjectionType.KEYS_ONLY));
                this.gsiNameToGsiDefinition.put(str, globalSecondaryIndex);
            }
            if (str2 != null) {
                if (globalSecondaryIndex.getKeySchema() == null || globalSecondaryIndex.getKeySchema().isEmpty()) {
                    globalSecondaryIndex.withKeySchema(new KeySchemaElement(str2, KeyType.HASH));
                } else {
                    LinkedList linkedList = new LinkedList(globalSecondaryIndex.getKeySchema());
                    linkedList.addFirst(new KeySchemaElement(str2, KeyType.HASH));
                    globalSecondaryIndex.setKeySchema(linkedList);
                }
                mapGsiHashKeyToIndexName(str2, str);
            }
            if (str3 != null) {
                globalSecondaryIndex.withKeySchema(new KeySchemaElement(str3, KeyType.RANGE));
                mapGsiRangeKeyToIndexName(str3, str);
            }
        }

        /* access modifiers changed from: private */
        public void addLsiRangeKey(String str, String str2, String str3) {
            if (str2 == null) {
                throw new IllegalArgumentException("The name of the primary hash key must be specified.");
            } else if (this.lsiNameToLsiDefinition.containsKey(str)) {
                LocalSecondaryIndex localSecondaryIndex = this.lsiNameToLsiDefinition.get(str);
                if (!str.equals(localSecondaryIndex.getIndexName()) || localSecondaryIndex.getKeySchema() == null || localSecondaryIndex.getKeySchema().size() != 2 || !KeyType.RANGE.toString().equals(localSecondaryIndex.getKeySchema().get(1).getKeyType())) {
                    throw new IllegalStateException("Found invalid state of an existing LocalSecondaryIndex object associated with the LSI [" + str + "].");
                }
                String attributeName = localSecondaryIndex.getKeySchema().get(1).getAttributeName();
                if (!attributeName.equals(str3)) {
                    throw new DynamoDBMappingException("Multiple range keys [" + attributeName + ", " + str3 + "] are found for the LSI [" + str + "]. Each index allows at most one range key attribute.");
                }
            } else {
                this.lsiNameToLsiDefinition.put(str, new LocalSecondaryIndex().withIndexName(str).withKeySchema(new KeySchemaElement(str2, KeyType.HASH), new KeySchemaElement(str3, KeyType.RANGE)).withProjection(new Projection().withProjectionType(ProjectionType.KEYS_ONLY)));
                mapLsiRangeKeyToIndexName(str3, str);
            }
        }

        private void mapLsiRangeKeyToIndexName(String str, String str2) {
            mapIndexKeyToIndexName(this.lsiRangeKeyNameToIndexNames, str, str2);
        }

        private void mapGsiHashKeyToIndexName(String str, String str2) {
            mapIndexKeyToIndexName(this.gsiHashKeyNameToIndexNames, str, str2);
        }

        private void mapGsiRangeKeyToIndexName(String str, String str2) {
            mapIndexKeyToIndexName(this.gsiRangeKeyNameToIndexNames, str, str2);
        }

        private void mapIndexKeyToIndexName(Map<String, Set<String>> map, String str, String str2) {
            if (map.get(str) == null) {
                HashSet hashSet = new HashSet();
                hashSet.add(str2);
                map.put(str, hashSet);
                return;
            }
            map.get(str).add(str2);
        }

        /* access modifiers changed from: private */
        public void addIndexKeyGetter(Method method) {
            this.indexKeyGetters.add(method);
        }

        /* access modifiers changed from: private */
        public Set<Method> getIndexKeyGetters() {
            return Collections.unmodifiableSet(this.indexKeyGetters);
        }

        /* access modifiers changed from: private */
        public Collection<LocalSecondaryIndex> getLocalSecondaryIndexes() {
            return Collections.unmodifiableCollection(this.lsiNameToLsiDefinition.values());
        }

        /* access modifiers changed from: private */
        public Collection<GlobalSecondaryIndex> getGlobalSecondaryIndexes() {
            return Collections.unmodifiableCollection(this.gsiNameToGsiDefinition.values());
        }
    }
}
