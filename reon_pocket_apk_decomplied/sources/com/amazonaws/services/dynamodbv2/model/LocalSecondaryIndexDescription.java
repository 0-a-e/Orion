package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LocalSecondaryIndexDescription implements Serializable {
    private String indexArn;
    private String indexName;
    private Long indexSizeBytes;
    private Long itemCount;
    private List<KeySchemaElement> keySchema;
    private Projection projection;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public LocalSecondaryIndexDescription withIndexName(String str) {
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

    public LocalSecondaryIndexDescription withKeySchema(KeySchemaElement... keySchemaElementArr) {
        if (getKeySchema() == null) {
            this.keySchema = new ArrayList(keySchemaElementArr.length);
        }
        for (KeySchemaElement add : keySchemaElementArr) {
            this.keySchema.add(add);
        }
        return this;
    }

    public LocalSecondaryIndexDescription withKeySchema(Collection<KeySchemaElement> collection) {
        setKeySchema(collection);
        return this;
    }

    public Projection getProjection() {
        return this.projection;
    }

    public void setProjection(Projection projection2) {
        this.projection = projection2;
    }

    public LocalSecondaryIndexDescription withProjection(Projection projection2) {
        this.projection = projection2;
        return this;
    }

    public Long getIndexSizeBytes() {
        return this.indexSizeBytes;
    }

    public void setIndexSizeBytes(Long l) {
        this.indexSizeBytes = l;
    }

    public LocalSecondaryIndexDescription withIndexSizeBytes(Long l) {
        this.indexSizeBytes = l;
        return this;
    }

    public Long getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(Long l) {
        this.itemCount = l;
    }

    public LocalSecondaryIndexDescription withItemCount(Long l) {
        this.itemCount = l;
        return this;
    }

    public String getIndexArn() {
        return this.indexArn;
    }

    public void setIndexArn(String str) {
        this.indexArn = str;
    }

    public LocalSecondaryIndexDescription withIndexArn(String str) {
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
        int hashCode = ((((((((((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31) + (getKeySchema() == null ? 0 : getKeySchema().hashCode())) * 31) + (getProjection() == null ? 0 : getProjection().hashCode())) * 31) + (getIndexSizeBytes() == null ? 0 : getIndexSizeBytes().hashCode())) * 31) + (getItemCount() == null ? 0 : getItemCount().hashCode())) * 31;
        if (getIndexArn() != null) {
            i = getIndexArn().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LocalSecondaryIndexDescription)) {
            return false;
        }
        LocalSecondaryIndexDescription localSecondaryIndexDescription = (LocalSecondaryIndexDescription) obj;
        if ((localSecondaryIndexDescription.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (localSecondaryIndexDescription.getIndexName() != null && !localSecondaryIndexDescription.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((localSecondaryIndexDescription.getKeySchema() == null) ^ (getKeySchema() == null)) {
            return false;
        }
        if (localSecondaryIndexDescription.getKeySchema() != null && !localSecondaryIndexDescription.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        if ((localSecondaryIndexDescription.getProjection() == null) ^ (getProjection() == null)) {
            return false;
        }
        if (localSecondaryIndexDescription.getProjection() != null && !localSecondaryIndexDescription.getProjection().equals(getProjection())) {
            return false;
        }
        if ((localSecondaryIndexDescription.getIndexSizeBytes() == null) ^ (getIndexSizeBytes() == null)) {
            return false;
        }
        if (localSecondaryIndexDescription.getIndexSizeBytes() != null && !localSecondaryIndexDescription.getIndexSizeBytes().equals(getIndexSizeBytes())) {
            return false;
        }
        if ((localSecondaryIndexDescription.getItemCount() == null) ^ (getItemCount() == null)) {
            return false;
        }
        if (localSecondaryIndexDescription.getItemCount() != null && !localSecondaryIndexDescription.getItemCount().equals(getItemCount())) {
            return false;
        }
        if ((localSecondaryIndexDescription.getIndexArn() == null) ^ (getIndexArn() == null)) {
            return false;
        }
        return localSecondaryIndexDescription.getIndexArn() == null || localSecondaryIndexDescription.getIndexArn().equals(getIndexArn());
    }
}
