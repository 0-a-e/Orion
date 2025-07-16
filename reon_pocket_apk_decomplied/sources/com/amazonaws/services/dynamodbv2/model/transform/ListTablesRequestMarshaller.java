package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

public class ListTablesRequestMarshaller implements Marshaller<Request<ListTablesRequest>, ListTablesRequest> {
    public Request<ListTablesRequest> marshall(ListTablesRequest listTablesRequest) {
        if (listTablesRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(listTablesRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.ListTables");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (listTablesRequest.getExclusiveStartTableName() != null) {
                    String exclusiveStartTableName = listTablesRequest.getExclusiveStartTableName();
                    jsonWriter.name("ExclusiveStartTableName");
                    jsonWriter.value(exclusiveStartTableName);
                }
                if (listTablesRequest.getLimit() != null) {
                    Integer limit = listTablesRequest.getLimit();
                    jsonWriter.name("Limit");
                    jsonWriter.value((Number) limit);
                }
                jsonWriter.endObject();
                jsonWriter.close();
                String stringWriter2 = stringWriter.toString();
                byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
                defaultRequest.setContent(new StringInputStream(stringWriter2));
                defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
                if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                    defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.0");
                }
                return defaultRequest;
            } catch (Throwable th) {
                throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
            }
        } else {
            throw new AmazonClientException("Invalid argument passed to marshall(ListTablesRequest)");
        }
    }
}
