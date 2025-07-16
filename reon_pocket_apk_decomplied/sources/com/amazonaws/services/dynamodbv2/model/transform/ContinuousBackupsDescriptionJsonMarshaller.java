package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ContinuousBackupsDescription;
import com.amazonaws.services.dynamodbv2.model.PointInTimeRecoveryDescription;
import com.amazonaws.util.json.AwsJsonWriter;

class ContinuousBackupsDescriptionJsonMarshaller {
    private static ContinuousBackupsDescriptionJsonMarshaller instance;

    ContinuousBackupsDescriptionJsonMarshaller() {
    }

    public void marshall(ContinuousBackupsDescription continuousBackupsDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (continuousBackupsDescription.getContinuousBackupsStatus() != null) {
            String continuousBackupsStatus = continuousBackupsDescription.getContinuousBackupsStatus();
            awsJsonWriter.name("ContinuousBackupsStatus");
            awsJsonWriter.value(continuousBackupsStatus);
        }
        if (continuousBackupsDescription.getPointInTimeRecoveryDescription() != null) {
            PointInTimeRecoveryDescription pointInTimeRecoveryDescription = continuousBackupsDescription.getPointInTimeRecoveryDescription();
            awsJsonWriter.name("PointInTimeRecoveryDescription");
            PointInTimeRecoveryDescriptionJsonMarshaller.getInstance().marshall(pointInTimeRecoveryDescription, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static ContinuousBackupsDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ContinuousBackupsDescriptionJsonMarshaller();
        }
        return instance;
    }
}
