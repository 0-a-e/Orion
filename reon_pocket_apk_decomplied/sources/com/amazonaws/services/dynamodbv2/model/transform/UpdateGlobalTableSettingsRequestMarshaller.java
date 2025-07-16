package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsUpdate;
import com.amazonaws.services.dynamodbv2.model.GlobalTableGlobalSecondaryIndexSettingsUpdate;
import com.amazonaws.services.dynamodbv2.model.ReplicaSettingsUpdate;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

public class UpdateGlobalTableSettingsRequestMarshaller implements Marshaller<Request<UpdateGlobalTableSettingsRequest>, UpdateGlobalTableSettingsRequest> {
    public Request<UpdateGlobalTableSettingsRequest> marshall(UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest) {
        if (updateGlobalTableSettingsRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(updateGlobalTableSettingsRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.UpdateGlobalTableSettings");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (updateGlobalTableSettingsRequest.getGlobalTableName() != null) {
                    String globalTableName = updateGlobalTableSettingsRequest.getGlobalTableName();
                    jsonWriter.name("GlobalTableName");
                    jsonWriter.value(globalTableName);
                }
                if (updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityUnits() != null) {
                    Long globalTableProvisionedWriteCapacityUnits = updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityUnits();
                    jsonWriter.name("GlobalTableProvisionedWriteCapacityUnits");
                    jsonWriter.value((Number) globalTableProvisionedWriteCapacityUnits);
                }
                if (updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() != null) {
                    AutoScalingSettingsUpdate globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate = updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate();
                    jsonWriter.name("GlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate");
                    AutoScalingSettingsUpdateJsonMarshaller.getInstance().marshall(globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate, jsonWriter);
                }
                if (updateGlobalTableSettingsRequest.getGlobalTableGlobalSecondaryIndexSettingsUpdate() != null) {
                    List<GlobalTableGlobalSecondaryIndexSettingsUpdate> globalTableGlobalSecondaryIndexSettingsUpdate = updateGlobalTableSettingsRequest.getGlobalTableGlobalSecondaryIndexSettingsUpdate();
                    jsonWriter.name("GlobalTableGlobalSecondaryIndexSettingsUpdate");
                    jsonWriter.beginArray();
                    for (GlobalTableGlobalSecondaryIndexSettingsUpdate next : globalTableGlobalSecondaryIndexSettingsUpdate) {
                        if (next != null) {
                            GlobalTableGlobalSecondaryIndexSettingsUpdateJsonMarshaller.getInstance().marshall(next, jsonWriter);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (updateGlobalTableSettingsRequest.getReplicaSettingsUpdate() != null) {
                    List<ReplicaSettingsUpdate> replicaSettingsUpdate = updateGlobalTableSettingsRequest.getReplicaSettingsUpdate();
                    jsonWriter.name("ReplicaSettingsUpdate");
                    jsonWriter.beginArray();
                    for (ReplicaSettingsUpdate next2 : replicaSettingsUpdate) {
                        if (next2 != null) {
                            ReplicaSettingsUpdateJsonMarshaller.getInstance().marshall(next2, jsonWriter);
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
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateGlobalTableSettingsRequest)");
        }
    }
}
