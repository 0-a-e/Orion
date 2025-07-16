package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GlobalSecondaryIndexInfo implements Serializable {
    private String indexName;
    private List<KeySchemaElement> keySchema;
    private Projection projection;
    private ProvisionedThroughput provisionedThroughput;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public GlobalSecondaryIndexInfo withIndexName(String str) {
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

    public GlobalSecondaryIndexInfo withKeySchema(KeySchemaElement... keySchemaElementArr) {
        if (getKeySchema() == null) {
            this.keySchema = new ArrayList(keySchemaElementArr.length);
        }
        for (KeySchemaElement add : keySchemaElementArr) {
            this.keySchema.add(add);
        }
        return this;
    }

    public GlobalSecondaryIndexInfo withKeySchema(Collection<KeySchemaElement> collection) {
        setKeySchema(collection);
        return this;
    }

    public Projection getProjection() {
        return this.projection;
    }

    public void setProjection(Projection projection2) {
        this.projection = projection2;
    }

    public GlobalSecondaryIndexInfo withProjection(Projection projection2) {
        this.projection = projection2;
        return this;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput2) {
        this.provisionedThroughput = provisionedThroughput2;
    }

    public GlobalSecondaryIndexInfo withProvisionedThroughput(ProvisionedThroughput provisionedThroughput2) {
        this.provisionedThroughput = provisionedThroughput2;
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
        if (getProvisionedThroughput() != null) {
            sb.append("ProvisionedThroughput: " + getProvisionedThroughput());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31) + (getKeySchema() == null ? 0 : getKeySchema().hashCode())) * 31) + (getProjection() == null ? 0 : getProjection().hashCode())) * 31;
        if (getProvisionedThroughput() != null) {
            i = getProvisionedThroughput().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GlobalSecondaryIndexInfo)) {
            return false;
        }
        GlobalSecondaryIndexInfo globalSecondaryIndexInfo = (GlobalSecondaryIndexInfo) obj;
        if ((globalSecondaryIndexInfo.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (globalSecondaryIndexInfo.getIndexName() != null && !globalSecondaryIndexInfo.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((globalSecondaryIndexInfo.getKeySchema() == null) ^ (getKeySchema() == null)) {
            return false;
        }
        if (globalSecondaryIndexInfo.getKeySchema() != null && !globalSecondaryIndexInfo.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        if ((globalSecondaryIndexInfo.getProjection() == null) ^ (getProjection() == null)) {
            return false;
        }
        if (globalSecondaryIndexInfo.getProjection() != null && !globalSecondaryIndexInfo.getProjection().equals(getProjection())) {
            return false;
        }
        if ((globalSecondaryIndexInfo.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        return globalSecondaryIndexInfo.getProvisionedThroughput() == null || globalSecondaryIndexInfo.getProvisionedThroughput().equals(getProvisionedThroughput());
    }
}
