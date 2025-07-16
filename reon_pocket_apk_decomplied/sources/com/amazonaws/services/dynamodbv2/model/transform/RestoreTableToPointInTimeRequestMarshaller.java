package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Date;

public class RestoreTableToPointInTimeRequestMarshaller implements Marshaller<Request<RestoreTableToPointInTimeRequest>, RestoreTableToPointInTimeRequest> {
    public Request<RestoreTableToPointInTimeRequest> marshall(RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest) {
        if (restoreTableToPointInTimeRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(restoreTableToPointInTimeRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.RestoreTableToPointInTime");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (restoreTableToPointInTimeRequest.getSourceTableName() != null) {
                    String sourceTableName = restoreTableToPointInTimeRequest.getSourceTableName();
                    jsonWriter.name("SourceTableName");
                    jsonWriter.value(sourceTableName);
                }
                if (restoreTableToPointInTimeRequest.getTargetTableName() != null) {
                    String targetTableName = restoreTableToPointInTimeRequest.getTargetTableName();
                    jsonWriter.name("TargetTableName");
                    jsonWriter.value(targetTableName);
                }
                if (restoreTableToPointInTimeRequest.getUseLatestRestorableTime() != null) {
                    Boolean useLatestRestorableTime = restoreTableToPointInTimeRequest.getUseLatestRestorableTime();
                    jsonWriter.name("UseLatestRestorableTime");
                    jsonWriter.value(useLatestRestorableTime.booleanValue());
                }
                if (restoreTableToPointInTimeRequest.getRestoreDateTime() != null) {
                    Date restoreDateTime = restoreTableToPointInTimeRequest.getRestoreDateTime();
                    jsonWriter.name("RestoreDateTime");
                    jsonWriter.value(restoreDateTime);
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
            throw new AmazonClientException("Invalid argument passed to marshall(RestoreTableToPointInTimeRequest)");
        }
    }
}
