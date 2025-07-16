package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class ProjectionJsonMarshaller {
    private static ProjectionJsonMarshaller instance;

    ProjectionJsonMarshaller() {
    }

    public void marshall(Projection projection, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (projection.getProjectionType() != null) {
            String projectionType = projection.getProjectionType();
            awsJsonWriter.name("ProjectionType");
            awsJsonWriter.value(projectionType);
        }
        if (projection.getNonKeyAttributes() != null) {
            List<String> nonKeyAttributes = projection.getNonKeyAttributes();
            awsJsonWriter.name("NonKeyAttributes");
            awsJsonWriter.beginArray();
            for (String next : nonKeyAttributes) {
                if (next != null) {
                    awsJsonWriter.value(next);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static ProjectionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ProjectionJsonMarshaller();
        }
        return instance;
    }
}
