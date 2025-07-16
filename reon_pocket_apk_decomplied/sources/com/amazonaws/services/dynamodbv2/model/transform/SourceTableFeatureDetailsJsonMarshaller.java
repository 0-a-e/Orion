package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexInfo;
import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexInfo;
import com.amazonaws.services.dynamodbv2.model.SSEDescription;
import com.amazonaws.services.dynamodbv2.model.SourceTableFeatureDetails;
import com.amazonaws.services.dynamodbv2.model.StreamSpecification;
import com.amazonaws.services.dynamodbv2.model.TimeToLiveDescription;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class SourceTableFeatureDetailsJsonMarshaller {
    private static SourceTableFeatureDetailsJsonMarshaller instance;

    SourceTableFeatureDetailsJsonMarshaller() {
    }

    public void marshall(SourceTableFeatureDetails sourceTableFeatureDetails, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (sourceTableFeatureDetails.getLocalSecondaryIndexes() != null) {
            List<LocalSecondaryIndexInfo> localSecondaryIndexes = sourceTableFeatureDetails.getLocalSecondaryIndexes();
            awsJsonWriter.name("LocalSecondaryIndexes");
            awsJsonWriter.beginArray();
            for (LocalSecondaryIndexInfo next : localSecondaryIndexes) {
                if (next != null) {
                    LocalSecondaryIndexInfoJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (sourceTableFeatureDetails.getGlobalSecondaryIndexes() != null) {
            List<GlobalSecondaryIndexInfo> globalSecondaryIndexes = sourceTableFeatureDetails.getGlobalSecondaryIndexes();
            awsJsonWriter.name("GlobalSecondaryIndexes");
            awsJsonWriter.beginArray();
            for (GlobalSecondaryIndexInfo next2 : globalSecondaryIndexes) {
                if (next2 != null) {
                    GlobalSecondaryIndexInfoJsonMarshaller.getInstance().marshall(next2, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (sourceTableFeatureDetails.getStreamDescription() != null) {
            StreamSpecification streamDescription = sourceTableFeatureDetails.getStreamDescription();
            awsJsonWriter.name("StreamDescription");
            StreamSpecificationJsonMarshaller.getInstance().marshall(streamDescription, awsJsonWriter);
        }
        if (sourceTableFeatureDetails.getTimeToLiveDescription() != null) {
            TimeToLiveDescription timeToLiveDescription = sourceTableFeatureDetails.getTimeToLiveDescription();
            awsJsonWriter.name("TimeToLiveDescription");
            TimeToLiveDescriptionJsonMarshaller.getInstance().marshall(timeToLiveDescription, awsJsonWriter);
        }
        if (sourceTableFeatureDetails.getSSEDescription() != null) {
            SSEDescription sSEDescription = sourceTableFeatureDetails.getSSEDescription();
            awsJsonWriter.name("SSEDescription");
            SSEDescriptionJsonMarshaller.getInstance().marshall(sSEDescription, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static SourceTableFeatureDetailsJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SourceTableFeatureDetailsJsonMarshaller();
        }
        return instance;
    }
}
