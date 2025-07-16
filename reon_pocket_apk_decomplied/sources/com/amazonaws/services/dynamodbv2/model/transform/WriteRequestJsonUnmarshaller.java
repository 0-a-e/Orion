package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class WriteRequestJsonUnmarshaller implements Unmarshaller<WriteRequest, JsonUnmarshallerContext> {
    private static WriteRequestJsonUnmarshaller instance;

    WriteRequestJsonUnmarshaller() {
    }

    public WriteRequest unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        WriteRequest writeRequest = new WriteRequest();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("PutRequest")) {
                writeRequest.setPutRequest(PutRequestJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("DeleteRequest")) {
                writeRequest.setDeleteRequest(DeleteRequestJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return writeRequest;
    }

    public static WriteRequestJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new WriteRequestJsonUnmarshaller();
        }
        return instance;
    }
}
