package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.SourceTableFeatureDetails;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class SourceTableFeatureDetailsJsonUnmarshaller implements Unmarshaller<SourceTableFeatureDetails, JsonUnmarshallerContext> {
    private static SourceTableFeatureDetailsJsonUnmarshaller instance;

    SourceTableFeatureDetailsJsonUnmarshaller() {
    }

    public SourceTableFeatureDetails unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SourceTableFeatureDetails sourceTableFeatureDetails = new SourceTableFeatureDetails();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("LocalSecondaryIndexes")) {
                sourceTableFeatureDetails.setLocalSecondaryIndexes(new ListUnmarshaller(LocalSecondaryIndexInfoJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("GlobalSecondaryIndexes")) {
                sourceTableFeatureDetails.setGlobalSecondaryIndexes(new ListUnmarshaller(GlobalSecondaryIndexInfoJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("StreamDescription")) {
                sourceTableFeatureDetails.setStreamDescription(StreamSpecificationJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TimeToLiveDescription")) {
                sourceTableFeatureDetails.setTimeToLiveDescription(TimeToLiveDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SSEDescription")) {
                sourceTableFeatureDetails.setSSEDescription(SSEDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return sourceTableFeatureDetails;
    }

    public static SourceTableFeatureDetailsJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SourceTableFeatureDetailsJsonUnmarshaller();
        }
        return instance;
    }
}
