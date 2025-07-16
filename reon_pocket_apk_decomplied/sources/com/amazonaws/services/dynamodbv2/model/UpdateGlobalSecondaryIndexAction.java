package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class UpdateGlobalSecondaryIndexAction implements Serializable {
    private String indexName;
    private ProvisionedThroughput provisionedThroughput;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public UpdateGlobalSecondaryIndexAction withIndexName(String str) {
        this.indexName = str;
        return this;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput2) {
        this.provisionedThroughput = provisionedThroughput2;
    }

    public UpdateGlobalSecondaryIndexAction withProvisionedThroughput(ProvisionedThroughput provisionedThroughput2) {
        this.provisionedThroughput = provisionedThroughput2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + ",");
        }
        if (getProvisionedThroughput() != null) {
            sb.append("ProvisionedThroughput: " + getProvisionedThroughput());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31;
        if (getProvisionedThroughput() != null) {
            i = getProvisionedThroughput().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGlobalSecondaryIndexAction)) {
            return false;
        }
        UpdateGlobalSecondaryIndexAction updateGlobalSecondaryIndexAction = (UpdateGlobalSecondaryIndexAction) obj;
        if ((updateGlobalSecondaryIndexAction.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (updateGlobalSecondaryIndexAction.getIndexName() != null && !updateGlobalSecondaryIndexAction.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((updateGlobalSecondaryIndexAction.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        return updateGlobalSecondaryIndexAction.getProvisionedThroughput() == null || updateGlobalSecondaryIndexAction.getProvisionedThroughput().equals(getProvisionedThroughput());
    }
}
