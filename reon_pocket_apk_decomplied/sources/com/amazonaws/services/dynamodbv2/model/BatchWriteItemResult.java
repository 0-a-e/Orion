package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchWriteItemResult implements Serializable {
    private List<ConsumedCapacity> consumedCapacity;
    private Map<String, List<ItemCollectionMetrics>> itemCollectionMetrics;
    private Map<String, List<WriteRequest>> unprocessedItems;

    public Map<String, List<WriteRequest>> getUnprocessedItems() {
        return this.unprocessedItems;
    }

    public void setUnprocessedItems(Map<String, List<WriteRequest>> map) {
        this.unprocessedItems = map;
    }

    public BatchWriteItemResult withUnprocessedItems(Map<String, List<WriteRequest>> map) {
        this.unprocessedItems = map;
        return this;
    }

    public BatchWriteItemResult addUnprocessedItemsEntry(String str, List<WriteRequest> list) {
        if (this.unprocessedItems == null) {
            this.unprocessedItems = new HashMap();
        }
        if (!this.unprocessedItems.containsKey(str)) {
            this.unprocessedItems.put(str, list);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public BatchWriteItemResult clearUnprocessedItemsEntries() {
        this.unprocessedItems = null;
        return this;
    }

    public Map<String, List<ItemCollectionMetrics>> getItemCollectionMetrics() {
        return this.itemCollectionMetrics;
    }

    public void setItemCollectionMetrics(Map<String, List<ItemCollectionMetrics>> map) {
        this.itemCollectionMetrics = map;
    }

    public BatchWriteItemResult withItemCollectionMetrics(Map<String, List<ItemCollectionMetrics>> map) {
        this.itemCollectionMetrics = map;
        return this;
    }

    public BatchWriteItemResult addItemCollectionMetricsEntry(String str, List<ItemCollectionMetrics> list) {
        if (this.itemCollectionMetrics == null) {
            this.itemCollectionMetrics = new HashMap();
        }
        if (!this.itemCollectionMetrics.containsKey(str)) {
            this.itemCollectionMetrics.put(str, list);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public BatchWriteItemResult clearItemCollectionMetricsEntries() {
        this.itemCollectionMetrics = null;
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

    public BatchWriteItemResult withConsumedCapacity(ConsumedCapacity... consumedCapacityArr) {
        if (getConsumedCapacity() == null) {
            this.consumedCapacity = new ArrayList(consumedCapacityArr.length);
        }
        for (ConsumedCapacity add : consumedCapacityArr) {
            this.consumedCapacity.add(add);
        }
        return this;
    }

    public BatchWriteItemResult withConsumedCapacity(Collection<ConsumedCapacity> collection) {
        setConsumedCapacity(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getUnprocessedItems() != null) {
            sb.append("UnprocessedItems: " + getUnprocessedItems() + ",");
        }
        if (getItemCollectionMetrics() != null) {
            sb.append("ItemCollectionMetrics: " + getItemCollectionMetrics() + ",");
        }
        if (getConsumedCapacity() != null) {
            sb.append("ConsumedCapacity: " + getConsumedCapacity());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getUnprocessedItems() == null ? 0 : getUnprocessedItems().hashCode()) + 31) * 31) + (getItemCollectionMetrics() == null ? 0 : getItemCollectionMetrics().hashCode())) * 31;
        if (getConsumedCapacity() != null) {
            i = getConsumedCapacity().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchWriteItemResult)) {
            return false;
        }
        BatchWriteItemResult batchWriteItemResult = (BatchWriteItemResult) obj;
        if ((batchWriteItemResult.getUnprocessedItems() == null) ^ (getUnprocessedItems() == null)) {
            return false;
        }
        if (batchWriteItemResult.getUnprocessedItems() != null && !batchWriteItemResult.getUnprocessedItems().equals(getUnprocessedItems())) {
            return false;
        }
        if ((batchWriteItemResult.getItemCollectionMetrics() == null) ^ (getItemCollectionMetrics() == null)) {
            return false;
        }
        if (batchWriteItemResult.getItemCollectionMetrics() != null && !batchWriteItemResult.getItemCollectionMetrics().equals(getItemCollectionMetrics())) {
            return false;
        }
        if ((batchWriteItemResult.getConsumedCapacity() == null) ^ (getConsumedCapacity() == null)) {
            return false;
        }
        return batchWriteItemResult.getConsumedCapacity() == null || batchWriteItemResult.getConsumedCapacity().equals(getConsumedCapacity());
    }
}
