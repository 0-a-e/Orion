package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpdateTableRequest extends AmazonWebServiceRequest implements Serializable {
    private List<AttributeDefinition> attributeDefinitions;
    private List<GlobalSecondaryIndexUpdate> globalSecondaryIndexUpdates;
    private ProvisionedThroughput provisionedThroughput;
    private SSESpecification sSESpecification;
    private StreamSpecification streamSpecification;
    private String tableName;

    public UpdateTableRequest() {
    }

    public UpdateTableRequest(String str, ProvisionedThroughput provisionedThroughput2) {
        setTableName(str);
        setProvisionedThroughput(provisionedThroughput2);
    }

    public List<AttributeDefinition> getAttributeDefinitions() {
        return this.attributeDefinitions;
    }

    public void setAttributeDefinitions(Collection<AttributeDefinition> collection) {
        if (collection == null) {
            this.attributeDefinitions = null;
        } else {
            this.attributeDefinitions = new ArrayList(collection);
        }
    }

    public UpdateTableRequest withAttributeDefinitions(AttributeDefinition... attributeDefinitionArr) {
        if (getAttributeDefinitions() == null) {
            this.attributeDefinitions = new ArrayList(attributeDefinitionArr.length);
        }
        for (AttributeDefinition add : attributeDefinitionArr) {
            this.attributeDefinitions.add(add);
        }
        return this;
    }

    public UpdateTableRequest withAttributeDefinitions(Collection<AttributeDefinition> collection) {
        setAttributeDefinitions(collection);
        return this;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public UpdateTableRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput2) {
        this.provisionedThroughput = provisionedThroughput2;
    }

    public UpdateTableRequest withProvisionedThroughput(ProvisionedThroughput provisionedThroughput2) {
        this.provisionedThroughput = provisionedThroughput2;
        return this;
    }

    public List<GlobalSecondaryIndexUpdate> getGlobalSecondaryIndexUpdates() {
        return this.globalSecondaryIndexUpdates;
    }

    public void setGlobalSecondaryIndexUpdates(Collection<GlobalSecondaryIndexUpdate> collection) {
        if (collection == null) {
            this.globalSecondaryIndexUpdates = null;
        } else {
            this.globalSecondaryIndexUpdates = new ArrayList(collection);
        }
    }

    public UpdateTableRequest withGlobalSecondaryIndexUpdates(GlobalSecondaryIndexUpdate... globalSecondaryIndexUpdateArr) {
        if (getGlobalSecondaryIndexUpdates() == null) {
            this.globalSecondaryIndexUpdates = new ArrayList(globalSecondaryIndexUpdateArr.length);
        }
        for (GlobalSecondaryIndexUpdate add : globalSecondaryIndexUpdateArr) {
            this.globalSecondaryIndexUpdates.add(add);
        }
        return this;
    }

    public UpdateTableRequest withGlobalSecondaryIndexUpdates(Collection<GlobalSecondaryIndexUpdate> collection) {
        setGlobalSecondaryIndexUpdates(collection);
        return this;
    }

    public StreamSpecification getStreamSpecification() {
        return this.streamSpecification;
    }

    public void setStreamSpecification(StreamSpecification streamSpecification2) {
        this.streamSpecification = streamSpecification2;
    }

    public UpdateTableRequest withStreamSpecification(StreamSpecification streamSpecification2) {
        this.streamSpecification = streamSpecification2;
        return this;
    }

    public SSESpecification getSSESpecification() {
        return this.sSESpecification;
    }

    public void setSSESpecification(SSESpecification sSESpecification2) {
        this.sSESpecification = sSESpecification2;
    }

    public UpdateTableRequest withSSESpecification(SSESpecification sSESpecification2) {
        this.sSESpecification = sSESpecification2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAttributeDefinitions() != null) {
            sb.append("AttributeDefinitions: " + getAttributeDefinitions() + ",");
        }
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + ",");
        }
        if (getProvisionedThroughput() != null) {
            sb.append("ProvisionedThroughput: " + getProvisionedThroughput() + ",");
        }
        if (getGlobalSecondaryIndexUpdates() != null) {
            sb.append("GlobalSecondaryIndexUpdates: " + getGlobalSecondaryIndexUpdates() + ",");
        }
        if (getStreamSpecification() != null) {
            sb.append("StreamSpecification: " + getStreamSpecification() + ",");
        }
        if (getSSESpecification() != null) {
            sb.append("SSESpecification: " + getSSESpecification());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((((getAttributeDefinitions() == null ? 0 : getAttributeDefinitions().hashCode()) + 31) * 31) + (getTableName() == null ? 0 : getTableName().hashCode())) * 31) + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode())) * 31;
        if (getGlobalSecondaryIndexUpdates() == null) {
            i = 0;
        } else {
            i = getGlobalSecondaryIndexUpdates().hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + (getStreamSpecification() == null ? 0 : getStreamSpecification().hashCode())) * 31;
        if (getSSESpecification() != null) {
            i2 = getSSESpecification().hashCode();
        }
        return hashCode2 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateTableRequest)) {
            return false;
        }
        UpdateTableRequest updateTableRequest = (UpdateTableRequest) obj;
        if ((updateTableRequest.getAttributeDefinitions() == null) ^ (getAttributeDefinitions() == null)) {
            return false;
        }
        if (updateTableRequest.getAttributeDefinitions() != null && !updateTableRequest.getAttributeDefinitions().equals(getAttributeDefinitions())) {
            return false;
        }
        if ((updateTableRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (updateTableRequest.getTableName() != null && !updateTableRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((updateTableRequest.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        if (updateTableRequest.getProvisionedThroughput() != null && !updateTableRequest.getProvisionedThroughput().equals(getProvisionedThroughput())) {
            return false;
        }
        if ((updateTableRequest.getGlobalSecondaryIndexUpdates() == null) ^ (getGlobalSecondaryIndexUpdates() == null)) {
            return false;
        }
        if (updateTableRequest.getGlobalSecondaryIndexUpdates() != null && !updateTableRequest.getGlobalSecondaryIndexUpdates().equals(getGlobalSecondaryIndexUpdates())) {
            return false;
        }
        if ((updateTableRequest.getStreamSpecification() == null) ^ (getStreamSpecification() == null)) {
            return false;
        }
        if (updateTableRequest.getStreamSpecification() != null && !updateTableRequest.getStreamSpecification().equals(getStreamSpecification())) {
            return false;
        }
        if ((updateTableRequest.getSSESpecification() == null) ^ (getSSESpecification() == null)) {
            return false;
        }
        return updateTableRequest.getSSESpecification() == null || updateTableRequest.getSSESpecification().equals(getSSESpecification());
    }
}
