package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest;
import com.amazonaws.transform.Marshaller;
import java.io.ByteArrayInputStream;

public class DescribeEndpointsRequestMarshaller implements Marshaller<Request<DescribeEndpointsRequest>, DescribeEndpointsRequest> {
    public Request<DescribeEndpointsRequest> marshall(DescribeEndpointsRequest describeEndpointsRequest) {
        if (describeEndpointsRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(describeEndpointsRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.DescribeEndpoints");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            defaultRequest.addHeader("Content-Length", "0");
            defaultRequest.setContent(new ByteArrayInputStream(new byte[0]));
            if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.0");
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(DescribeEndpointsRequest)");
    }
}
