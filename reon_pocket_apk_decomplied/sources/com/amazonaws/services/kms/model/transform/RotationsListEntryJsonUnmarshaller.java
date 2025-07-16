package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.RotationsListEntry;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class RotationsListEntryJsonUnmarshaller implements Unmarshaller<RotationsListEntry, JsonUnmarshallerContext> {
    private static RotationsListEntryJsonUnmarshaller instance;

    RotationsListEntryJsonUnmarshaller() {
    }

    public RotationsListEntry unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        RotationsListEntry rotationsListEntry = new RotationsListEntry();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("KeyId")) {
                rotationsListEntry.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("RotationDate")) {
                rotationsListEntry.setRotationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("RotationType")) {
                rotationsListEntry.setRotationType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return rotationsListEntry;
    }

    public static RotationsListEntryJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RotationsListEntryJsonUnmarshaller();
        }
        return instance;
    }
}
