package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateGlobalSecondaryIndexAction implements Serializable {
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

    public CreateGlobalSecondaryIndexAction withIndexName(String str) {
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

    public CreateGlobalSecondaryIndexAction withKeySchema(KeySchemaElement... keySchemaElementArr) {
        if (getKeySchema() == null) {
            this.keySchema = new ArrayList(keySchemaElementArr.length);
        }
        for (KeySchemaElement add : keySchemaElementArr) {
            this.keySchema.add(add);
        }
        return this;
    }

    public CreateGlobalSecondaryIndexAction withKeySchema(Collection<KeySchemaElement> collection) {
        setKeySchema(collection);
        return this;
    }

    public Projection getProjection() {
        return this.projection;
    }

    public void setProjection(Projection projection2) {
        this.projection = projection2;
    }

    public CreateGlobalSecondaryIndexAction withProjection(Projection projection2) {
        this.projection = projection2;
        return this;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput2) {
        this.provisionedThroughput = provisionedThroughput2;
    }

    public CreateGlobalSecondaryIndexAction withProvisionedThroughput(ProvisionedThroughput provisionedThroughput2) {
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
        if (obj == null || !(obj instanceof CreateGlobalSecondaryIndexAction)) {
            return false;
        }
        CreateGlobalSecondaryIndexAction createGlobalSecondaryIndexAction = (CreateGlobalSecondaryIndexAction) obj;
        if ((createGlobalSecondaryIndexAction.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (createGlobalSecondaryIndexAction.getIndexName() != null && !createGlobalSecondaryIndexAction.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((createGlobalSecondaryIndexAction.getKeySchema() == null) ^ (getKeySchema() == null)) {
            return false;
        }
        if (createGlobalSecondaryIndexAction.getKeySchema() != null && !createGlobalSecondaryIndexAction.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        if ((createGlobalSecondaryIndexAction.getProjection() == null) ^ (getProjection() == null)) {
            return false;
        }
        if (createGlobalSecondaryIndexAction.getProjection() != null && !createGlobalSecondaryIndexAction.getProjection().equals(getProjection())) {
            return false;
        }
        if ((createGlobalSecondaryIndexAction.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        return createGlobalSecondaryIndexAction.getProvisionedThroughput() == null || createGlobalSecondaryIndexAction.getProvisionedThroughput().equals(getProvisionedThroughput());
    }
}
