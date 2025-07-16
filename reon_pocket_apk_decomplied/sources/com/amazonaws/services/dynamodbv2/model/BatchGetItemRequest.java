package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BatchGetItemRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, KeysAndAttributes> requestItems;
    private String returnConsumedCapacity;

    public BatchGetItemRequest() {
    }

    public BatchGetItemRequest(Map<String, KeysAndAttributes> map) {
        setRequestItems(map);
    }

    public BatchGetItemRequest(Map<String, KeysAndAttributes> map, String str) {
        setRequestItems(map);
        setReturnConsumedCapacity(str);
    }

    public BatchGetItemRequest(Map<String, KeysAndAttributes> map, ReturnConsumedCapacity returnConsumedCapacity2) {
        setRequestItems(map);
        setReturnConsumedCapacity(returnConsumedCapacity2.toString());
    }

    public Map<String, KeysAndAttributes> getRequestItems() {
        return this.requestItems;
    }

    public void setRequestItems(Map<String, KeysAndAttributes> map) {
        this.requestItems = map;
    }

    public BatchGetItemRequest withRequestItems(Map<String, KeysAndAttributes> map) {
        this.requestItems = map;
        return this;
    }

    public BatchGetItemRequest addRequestItemsEntry(String str, KeysAndAttributes keysAndAttributes) {
        if (this.requestItems == null) {
            this.requestItems = new HashMap();
        }
        if (!this.requestItems.containsKey(str)) {
            this.requestItems.put(str, keysAndAttributes);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public BatchGetItemRequest clearRequestItemsEntries() {
        this.requestItems = null;
        return this;
    }

    public String getReturnConsumedCapacity() {
        return this.returnConsumedCapacity;
    }

    public void setReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
    }

    public BatchGetItemRequest withReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
        return this;
    }

    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
    }

    public BatchGetItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRequestItems() != null) {
            sb.append("RequestItems: " + getRequestItems() + ",");
        }
        if (getReturnConsumedCapacity() != null) {
            sb.append("ReturnConsumedCapacity: " + getReturnConsumedCapacity());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getRequestItems() == null ? 0 : getRequestItems().hashCode()) + 31) * 31;
        if (getReturnConsumedCapacity() != null) {
            i = getReturnConsumedCapacity().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchGetItemRequest)) {
            return false;
        }
        BatchGetItemRequest batchGetItemRequest = (BatchGetItemRequest) obj;
        if ((batchGetItemRequest.getRequestItems() == null) ^ (getRequestItems() == null)) {
            return false;
        }
        if (batchGetItemRequest.getRequestItems() != null && !batchGetItemRequest.getRequestItems().equals(getRequestItems())) {
            return false;
        }
        if ((batchGetItemRequest.getReturnConsumedCapacity() == null) ^ (getReturnConsumedCapacity() == null)) {
            return false;
        }
        return batchGetItemRequest.getReturnConsumedCapacity() == null || batchGetItemRequest.getReturnConsumedCapacity().equals(getReturnConsumedCapacity());
    }
}
