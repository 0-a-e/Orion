package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListKeyRotationsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListKeyRotationsResultJsonUnmarshaller implements Unmarshaller<ListKeyRotationsResult, JsonUnmarshallerContext> {
    private static ListKeyRotationsResultJsonUnmarshaller instance;

    public ListKeyRotationsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListKeyRotationsResult listKeyRotationsResult = new ListKeyRotationsResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Rotations")) {
                listKeyRotationsResult.setRotations(new ListUnmarshaller(RotationsListEntryJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextMarker")) {
                listKeyRotationsResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Truncated")) {
                listKeyRotationsResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listKeyRotationsResult;
    }

    public static ListKeyRotationsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListKeyRotationsResultJsonUnmarshaller();
        }
        return instance;
    }
}
