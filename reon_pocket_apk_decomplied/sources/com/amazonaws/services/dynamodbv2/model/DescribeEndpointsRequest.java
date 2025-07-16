package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeEndpointsRequest extends AmazonWebServiceRequest implements Serializable {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "{}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeEndpointsRequest)) {
            return false;
        }
        DescribeEndpointsRequest describeEndpointsRequest = (DescribeEndpointsRequest) obj;
        return true;
    }
}
