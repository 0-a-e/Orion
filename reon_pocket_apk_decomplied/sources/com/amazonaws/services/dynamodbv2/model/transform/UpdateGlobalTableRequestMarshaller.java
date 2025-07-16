package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.ReplicaUpdate;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

public class UpdateGlobalTableRequestMarshaller implements Marshaller<Request<UpdateGlobalTableRequest>, UpdateGlobalTableRequest> {
    public Request<UpdateGlobalTableRequest> marshall(UpdateGlobalTableRequest updateGlobalTableRequest) {
        if (updateGlobalTableRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(updateGlobalTableRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.UpdateGlobalTable");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (updateGlobalTableRequest.getGlobalTableName() != null) {
                    String globalTableName = updateGlobalTableRequest.getGlobalTableName();
                    jsonWriter.name("GlobalTableName");
                    jsonWriter.value(globalTableName);
                }
                if (updateGlobalTableRequest.getReplicaUpdates() != null) {
                    List<ReplicaUpdate> replicaUpdates = updateGlobalTableRequest.getReplicaUpdates();
                    jsonWriter.name("ReplicaUpdates");
                    jsonWriter.beginArray();
                    for (ReplicaUpdate next : replicaUpdates) {
                        if (next != null) {
                            ReplicaUpdateJsonMarshaller.getInstance().marshall(next, jsonWriter);
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
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateGlobalTableRequest)");
        }
    }
}
