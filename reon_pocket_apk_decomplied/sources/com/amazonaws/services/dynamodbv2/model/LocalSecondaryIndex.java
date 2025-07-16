package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LocalSecondaryIndex implements Serializable {
    private String indexName;
    private List<KeySchemaElement> keySchema;
    private Projection projection;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public LocalSecondaryIndex withIndexName(String str) {
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

    public LocalSecondaryIndex withKeySchema(KeySchemaElement... keySchemaElementArr) {
        if (getKeySchema() == null) {
            this.keySchema = new ArrayList(keySchemaElementArr.length);
        }
        for (KeySchemaElement add : keySchemaElementArr) {
            this.keySchema.add(add);
        }
        return this;
    }

    public LocalSecondaryIndex withKeySchema(Collection<KeySchemaElement> collection) {
        setKeySchema(collection);
        return this;
    }

    public Projection getProjection() {
        return this.projection;
    }

    public void setProjection(Projection projection2) {
        this.projection = projection2;
    }

    public LocalSecondaryIndex withProjection(Projection projection2) {
        this.projection = projection2;
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
            sb.append("Projection: " + getProjection());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31) + (getKeySchema() == null ? 0 : getKeySchema().hashCode())) * 31;
        if (getProjection() != null) {
            i = getProjection().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LocalSecondaryIndex)) {
            return false;
        }
        LocalSecondaryIndex localSecondaryIndex = (LocalSecondaryIndex) obj;
        if ((localSecondaryIndex.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (localSecondaryIndex.getIndexName() != null && !localSecondaryIndex.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((localSecondaryIndex.getKeySchema() == null) ^ (getKeySchema() == null)) {
            return false;
        }
        if (localSecondaryIndex.getKeySchema() != null && !localSecondaryIndex.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        if ((localSecondaryIndex.getProjection() == null) ^ (getProjection() == null)) {
            return false;
        }
        return localSecondaryIndex.getProjection() == null || localSecondaryIndex.getProjection().equals(getProjection());
    }
}
