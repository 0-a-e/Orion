package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ProjectionJsonUnmarshaller implements Unmarshaller<Projection, JsonUnmarshallerContext> {
    private static ProjectionJsonUnmarshaller instance;

    ProjectionJsonUnmarshaller() {
    }

    public Projection unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        Projection projection = new Projection();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("ProjectionType")) {
                projection.setProjectionType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NonKeyAttributes")) {
                projection.setNonKeyAttributes(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return projection;
    }

    public static ProjectionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ProjectionJsonUnmarshaller();
        }
        return instance;
    }
}
