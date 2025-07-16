package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GlobalSecondaryIndexDescription implements Serializable {
    private Boolean backfilling;
    private String indexArn;
    private String indexName;
    private Long indexSizeBytes;
    private String indexStatus;
    private Long itemCount;
    private List<KeySchemaElement> keySchema;
    private Projection projection;
    private ProvisionedThroughputDescription provisionedThroughput;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public GlobalSecondaryIndexDescription withIndexName(String str) {
        this.indexName = str;
        return this;
    }

    public List<KeySchemaElement> getKeySchema() {
        return this.keySchema;
    }

    public void setKeySchema(Collection<KeySchemaElement> collection) {
        if (collection == null) {
            this.keySchema = null;
        } else {
            this.keySchema = new ArrayList(collection);
        }
    }

    public GlobalSecondaryIndexDescription withKeySchema(KeySchemaElement... keySchemaElementArr) {
        if (getKeySchema() == null) {
            this.keySchema = new ArrayList(keySchemaElementArr.length);
        }
        for (KeySchemaElement add : keySchemaElementArr) {
            this.keySchema.add(add);
        }
        return this;
    }

    public GlobalSecondaryIndexDescription withKeySchema(Collection<KeySchemaElement> collection) {
        setKeySchema(collection);
        return this;
    }

    public Projection getProjection() {
        return this.projection;
    }

    public void setProjection(Projection projection2) {
        this.projection = projection2;
    }

    public GlobalSecondaryIndexDescription withProjection(Projection projection2) {
        this.projection = projection2;
        return this;
    }

    public String getIndexStatus() {
        return this.indexStatus;
    }

    public void setIndexStatus(String str) {
        this.indexStatus = str;
    }

    public GlobalSecondaryIndexDescription withIndexStatus(String str) {
        this.indexStatus = str;
        return this;
    }

    public void setIndexStatus(IndexStatus indexStatus2) {
        this.indexStatus = indexStatus2.toString();
    }

    public GlobalSecondaryIndexDescription withIndexStatus(IndexStatus indexStatus2) {
        this.indexStatus = indexStatus2.toString();
        return this;
    }

    public Boolean isBackfilling() {
        return this.backfilling;
    }

    public Boolean getBackfilling() {
        return this.backfilling;
    }

    public void setBackfilling(Boolean bool) {
        this.backfilling = bool;
    }

    public GlobalSecondaryIndexDescription withBackfilling(Boolean bool) {
        this.backfilling = bool;
        return this;
    }

    public ProvisionedThroughputDescription getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughputDescription) {
        this.provisionedThroughput = provisionedThroughputDescription;
    }

    public GlobalSecondaryIndexDescription withProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughputDescription) {
        this.provisionedThroughput = provisionedThroughputDescription;
        return this;
    }

    public Long getIndexSizeBytes() {
        return this.indexSizeBytes;
    }

    public void setIndexSizeBytes(Long l) {
        this.indexSizeBytes = l;
    }

    public GlobalSecondaryIndexDescription withIndexSizeBytes(Long l) {
        this.indexSizeBytes = l;
        return this;
    }

    public Long getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(Long l) {
        this.itemCount = l;
    }

    public GlobalSecondaryIndexDescription withItemCount(Long l) {
        this.itemCount = l;
        return this;
    }

    public String getIndexArn() {
        return this.indexArn;
    }

    public void setIndexArn(String str) {
        this.indexArn = str;
    }

    public GlobalSecondaryIndexDescription withIndexArn(String str) {
        this.indexArn = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + ",");
        }
        if (getKeySchema() != null) {
            sb.append("KeySchema: " + getKeySchema() + ",");
        }
        if (getProjection() != null) {
            sb.append("Projection: " + getProjection() + ",");
        }
        if (getIndexStatus() != null) {
            sb.append("IndexStatus: " + getIndexStatus() + ",");
        }
        if (getBackfilling() != null) {
            sb.append("Backfilling: " + getBackfilling() + ",");
        }
        if (getProvisionedThroughput() != null) {
            sb.append("ProvisionedThroughput: " + getProvisionedThroughput() + ",");
        }
        if (getIndexSizeBytes() != null) {
            sb.append("IndexSizeBytes: " + getIndexSizeBytes() + ",");
        }
        if (getItemCount() != null) {
            sb.append("ItemCount: " + getItemCount() + ",");
        }
        if (getIndexArn() != null) {
            sb.append("IndexArn: " + getIndexArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31) + (getKeySchema() == null ? 0 : getKeySchema().hashCode())) * 31) + (getProjection() == null ? 0 : getProjection().hashCode())) * 31) + (getIndexStatus() == null ? 0 : getIndexStatus().hashCode())) * 31) + (getBackfilling() == null ? 0 : getBackfilling().hashCode())) * 31) + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode())) * 31) + (getIndexSizeBytes() == null ? 0 : getIndexSizeBytes().hashCode())) * 31) + (getItemCount() == null ? 0 : getItemCount().hashCode())) * 31;
        if (getIndexArn() != null) {
            i = getIndexArn().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GlobalSecondaryIndexDescription)) {
            return false;
        }
        GlobalSecondaryIndexDescription globalSecondaryIndexDescription = (GlobalSecondaryIndexDescription) obj;
        if ((globalSecondaryIndexDescription.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (globalSecondaryIndexDescription.getIndexName() != null && !globalSecondaryIndexDescription.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((globalSecondaryIndexDescription.getKeySchema() == null) ^ (getKeySchema() == null)) {
            return false;
        }
        if (globalSecondaryIndexDescription.getKeySchema() != null && !globalSecondaryIndexDescription.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        if ((globalSecondaryIndexDescription.getProjection() == null) ^ (getProjection() == null)) {
            return false;
        }
        if (globalSecondaryIndexDescription.getProjection() != null && !globalSecondaryIndexDescription.getProjection().equals(getProjection())) {
            return false;
        }
        if ((globalSecondaryIndexDescription.getIndexStatus() == null) ^ (getIndexStatus() == null)) {
            return false;
        }
        if (globalSecondaryIndexDescription.getIndexStatus() != null && !globalSecondaryIndexDescription.getIndexStatus().equals(getIndexStatus())) {
            return false;
        }
        if ((globalSecondaryIndexDescription.getBackfilling() == null) ^ (getBackfilling() == null)) {
            return false;
        }
        if (globalSecondaryIndexDescription.getBackfilling() != null && !globalSecondaryIndexDescription.getBackfilling().equals(getBackfilling())) {
            return false;
        }
        if ((globalSecondaryIndexDescription.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        if (globalSecondaryIndexDescription.getProvisionedThroughput() != null && !globalSecondaryIndexDescription.getProvisionedThroughput().equals(getProvisionedThroughput())) {
            return false;
        }
        if ((globalSecondaryIndexDescription.getIndexSizeBytes() == null) ^ (getIndexSizeBytes() == null)) {
            return false;
        }
        if (globalSecondaryIndexDescription.getIndexSizeBytes() != null && !globalSecondaryIndexDescription.getIndexSizeBytes().equals(getIndexSizeBytes())) {
            return false;
        }
        if ((globalSecondaryIndexDescription.getItemCount() == null) ^ (getItemCount() == null)) {
            return false;
        }
        if (globalSecondaryIndexDescription.getItemCount() != null && !globalSecondaryIndexDescription.getItemCount().equals(getItemCount())) {
            return false;
        }
        if ((globalSecondaryIndexDescription.getIndexArn() == null) ^ (getIndexArn() == null)) {
            return false;
        }
        return globalSecondaryIndexDescription.getIndexArn() == null || globalSecondaryIndexDescription.getIndexArn().equals(getIndexArn());
    }
}
