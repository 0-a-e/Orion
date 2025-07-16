package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest;
import com.amazonaws.services.dynamodbv2.model.Replica;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

public class CreateGlobalTableRequestMarshaller implements Marshaller<Request<CreateGlobalTableRequest>, CreateGlobalTableRequest> {
    public Request<CreateGlobalTableRequest> marshall(CreateGlobalTableRequest createGlobalTableRequest) {
        if (createGlobalTableRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(createGlobalTableRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.CreateGlobalTable");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (createGlobalTableRequest.getGlobalTableName() != null) {
                    String globalTableName = createGlobalTableRequest.getGlobalTableName();
                    jsonWriter.name("GlobalTableName");
                    jsonWriter.value(globalTableName);
                }
                if (createGlobalTableRequest.getReplicationGroup() != null) {
                    List<Replica> replicationGroup = createGlobalTableRequest.getReplicationGroup();
                    jsonWriter.name("ReplicationGroup");
                    jsonWriter.beginArray();
                    for (Replica next : replicationGroup) {
                        if (next != null) {
                            ReplicaJsonMarshaller.getInstance().marshall(next, jsonWriter);
                        }
                    }
                    jsonWriter.endArray();
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
            throw new AmazonClientException("Invalid argument passed to marshall(CreateGlobalTableRequest)");
        }
    }
}
