package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchGetItemResult implements Serializable {
    private List<ConsumedCapacity> consumedCapacity;
    private Map<String, List<Map<String, AttributeValue>>> responses;
    private Map<String, KeysAndAttributes> unprocessedKeys;

    public Map<String, List<Map<String, AttributeValue>>> getResponses() {
        return this.responses;
    }

    public void setResponses(Map<String, List<Map<String, AttributeValue>>> map) {
        this.responses = map;
    }

    public BatchGetItemResult withResponses(Map<String, List<Map<String, AttributeValue>>> map) {
        this.responses = map;
        return this;
    }

    public BatchGetItemResult addResponsesEntry(String str, List<Map<String, AttributeValue>> list) {
        if (this.responses == null) {
            this.responses = new HashMap();
        }
        if (!this.responses.containsKey(str)) {
            this.responses.put(str, list);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public BatchGetItemResult clearResponsesEntries() {
        this.responses = null;
        return this;
    }

    public Map<String, KeysAndAttributes> getUnprocessedKeys() {
        return this.unprocessedKeys;
    }

    public void setUnprocessedKeys(Map<String, KeysAndAttributes> map) {
        this.unprocessedKeys = map;
    }

    public BatchGetItemResult withUnprocessedKeys(Map<String, KeysAndAttributes> map) {
        this.unprocessedKeys = map;
        return this;
    }

    public BatchGetItemResult addUnprocessedKeysEntry(String str, KeysAndAttributes keysAndAttributes) {
        if (this.unprocessedKeys == null) {
            this.unprocessedKeys = new HashMap();
        }
        if (!this.unprocessedKeys.containsKey(str)) {
            this.unprocessedKeys.put(str, keysAndAttributes);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public BatchGetItemResult clearUnprocessedKeysEntries() {
        this.unprocessedKeys = null;
        return this;
    }

    public List<ConsumedCapacity> getConsumedCapacity() {
        return this.consumedCapacity;
    }

    public void setConsumedCapacity(Collection<ConsumedCapacity> collection) {
        if (collection == null) {
            this.consumedCapacity = null;
        } else {
            this.consumedCapacity = new ArrayList(collection);
        }
    }

    public BatchGetItemResult withConsumedCapacity(ConsumedCapacity... consumedCapacityArr) {
        if (getConsumedCapacity() == null) {
            this.consumedCapacity = new ArrayList(consumedCapacityArr.length);
        }
        for (ConsumedCapacity add : consumedCapacityArr) {
            this.consumedCapacity.add(add);
        }
        return this;
    }

    public BatchGetItemResult withConsumedCapacity(Collection<ConsumedCapacity> collection) {
        setConsumedCapacity(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getResponses() != null) {
            sb.append("Responses: " + getResponses() + ",");
        }
        if (getUnprocessedKeys() != null) {
            sb.append("UnprocessedKeys: " + getUnprocessedKeys() + ",");
        }
        if (getConsumedCapacity() != null) {
            sb.append("ConsumedCapacity: " + getConsumedCapacity());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getResponses() == null ? 0 : getResponses().hashCode()) + 31) * 31) + (getUnprocessedKeys() == null ? 0 : getUnprocessedKeys().hashCode())) * 31;
        if (getConsumedCapacity() != null) {
            i = getConsumedCapacity().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchGetItemResult)) {
            return false;
        }
        BatchGetItemResult batchGetItemResult = (BatchGetItemResult) obj;
        if ((batchGetItemResult.getResponses() == null) ^ (getResponses() == null)) {
            return false;
        }
        if (batchGetItemResult.getResponses() != null && !batchGetItemResult.getResponses().equals(getResponses())) {
            return false;
        }
        if ((batchGetItemResult.getUnprocessedKeys() == null) ^ (getUnprocessedKeys() == null)) {
            return false;
        }
        if (batchGetItemResult.getUnprocessedKeys() != null && !batchGetItemResult.getUnprocessedKeys().equals(getUnprocessedKeys())) {
            return false;
        }
        if ((batchGetItemResult.getConsumedCapacity() == null) ^ (getConsumedCapacity() == null)) {
            return false;
        }
        return batchGetItemResult.getConsumedCapacity() == null || batchGetItemResult.getConsumedCapacity().equals(getConsumedCapacity());
    }
}
