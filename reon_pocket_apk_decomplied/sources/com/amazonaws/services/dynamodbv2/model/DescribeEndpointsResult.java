package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeEndpointsResult implements Serializable {
    private List<Endpoint> endpoints;

    public List<Endpoint> getEndpoints() {
        return this.endpoints;
    }

    public void setEndpoints(Collection<Endpoint> collection) {
        if (collection == null) {
            this.endpoints = null;
        } else {
            this.endpoints = new ArrayList(collection);
        }
    }

    public DescribeEndpointsResult withEndpoints(Endpoint... endpointArr) {
        if (getEndpoints() == null) {
            this.endpoints = new ArrayList(endpointArr.length);
        }
        for (Endpoint add : endpointArr) {
            this.endpoints.add(add);
        }
        return this;
    }

    public DescribeEndpointsResult withEndpoints(Collection<Endpoint> collection) {
        setEndpoints(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getEndpoints() != null) {
            sb.append("Endpoints: " + getEndpoints());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getEndpoints() == null ? 0 : getEndpoints().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeEndpointsResult)) {
            return false;
        }
        DescribeEndpointsResult describeEndpointsResult = (DescribeEndpointsResult) obj;
        if ((describeEndpointsResult.getEndpoints() == null) ^ (getEndpoints() == null)) {
            return false;
        }
        return describeEndpointsResult.getEndpoints() == null || describeEndpointsResult.getEndpoints().equals(getEndpoints());
    }
}
