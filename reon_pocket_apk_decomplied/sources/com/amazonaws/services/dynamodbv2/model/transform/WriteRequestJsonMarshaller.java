package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DeleteRequest;
import com.amazonaws.services.dynamodbv2.model.PutRequest;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazonaws.util.json.AwsJsonWriter;

class WriteRequestJsonMarshaller {
    private static WriteRequestJsonMarshaller instance;

    WriteRequestJsonMarshaller() {
    }

    public void marshall(WriteRequest writeRequest, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (writeRequest.getPutRequest() != null) {
            PutRequest putRequest = writeRequest.getPutRequest();
            awsJsonWriter.name("PutRequest");
            PutRequestJsonMarshaller.getInstance().marshall(putRequest, awsJsonWriter);
        }
        if (writeRequest.getDeleteRequest() != null) {
            DeleteRequest deleteRequest = writeRequest.getDeleteRequest();
            awsJsonWriter.name("DeleteRequest");
            DeleteRequestJsonMarshaller.getInstance().marshall(deleteRequest, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static WriteRequestJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new WriteRequestJsonMarshaller();
        }
        return instance;
    }
}
