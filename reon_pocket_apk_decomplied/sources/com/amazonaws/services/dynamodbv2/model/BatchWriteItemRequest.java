package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchWriteItemRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, List<WriteRequest>> requestItems;
    private String returnConsumedCapacity;
    private String returnItemCollectionMetrics;

    public BatchWriteItemRequest() {
    }

    public BatchWriteItemRequest(Map<String, List<WriteRequest>> map) {
        setRequestItems(map);
    }

    public Map<String, List<WriteRequest>> getRequestItems() {
        return this.requestItems;
    }

    public void setRequestItems(Map<String, List<WriteRequest>> map) {
        this.requestItems = map;
    }

    public BatchWriteItemRequest withRequestItems(Map<String, List<WriteRequest>> map) {
        this.requestItems = map;
        return this;
    }

    public BatchWriteItemRequest addRequestItemsEntry(String str, List<WriteRequest> list) {
        if (this.requestItems == null) {
            this.requestItems = new HashMap();
        }
        if (!this.requestItems.containsKey(str)) {
            this.requestItems.put(str, list);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public BatchWriteItemRequest clearRequestItemsEntries() {
        this.requestItems = null;
        return this;
    }

    public String getReturnConsumedCapacity() {
        return this.returnConsumedCapacity;
    }

    public void setReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
    }

    public BatchWriteItemRequest withReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
        return this;
    }

    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
    }

    public BatchWriteItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
        return this;
    }

    public String getReturnItemCollectionMetrics() {
        return this.returnItemCollectionMetrics;
    }

    public void setReturnItemCollectionMetrics(String str) {
        this.returnItemCollectionMetrics = str;
    }

    public BatchWriteItemRequest withReturnItemCollectionMetrics(String str) {
        this.returnItemCollectionMetrics = str;
        return this;
    }

    public void setReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics2) {
        this.returnItemCollectionMetrics = returnItemCollectionMetrics2.toString();
    }

    public BatchWriteItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics2) {
        this.returnItemCollectionMetrics = returnItemCollectionMetrics2.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRequestItems() != null) {
            sb.append("RequestItems: " + getRequestItems() + ",");
        }
        if (getReturnConsumedCapacity() != null) {
            sb.append("ReturnConsumedCapacity: " + getReturnConsumedCapacity() + ",");
        }
        if (getReturnItemCollectionMetrics() != null) {
            sb.append("ReturnItemCollectionMetrics: " + getReturnItemCollectionMetrics());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((getRequestItems() == null ? 0 : getRequestItems().hashCode()) + 31) * 31;
        if (getReturnConsumedCapacity() == null) {
            i = 0;
        } else {
            i = getReturnConsumedCapacity().hashCode();
        }
        int i3 = (hashCode + i) * 31;
        if (getReturnItemCollectionMetrics() != null) {
            i2 = getReturnItemCollectionMetrics().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchWriteItemRequest)) {
            return false;
        }
        BatchWriteItemRequest batchWriteItemRequest = (BatchWriteItemRequest) obj;
        if ((batchWriteItemRequest.getRequestItems() == null) ^ (getRequestItems() == null)) {
            return false;
        }
        if (batchWriteItemRequest.getRequestItems() != null && !batchWriteItemRequest.getRequestItems().equals(getRequestItems())) {
            return false;
        }
        if ((batchWriteItemRequest.getReturnConsumedCapacity() == null) ^ (getReturnConsumedCapacity() == null)) {
            return false;
        }
        if (batchWriteItemRequest.getReturnConsumedCapacity() != null && !batchWriteItemRequest.getReturnConsumedCapacity().equals(getReturnConsumedCapacity())) {
            return false;
        }
        if ((batchWriteItemRequest.getReturnItemCollectionMetrics() == null) ^ (getReturnItemCollectionMetrics() == null)) {
            return false;
        }
        return batchWriteItemRequest.getReturnItemCollectionMetrics() == null || batchWriteItemRequest.getReturnItemCollectionMetrics().equals(getReturnItemCollectionMetrics());
    }
}
