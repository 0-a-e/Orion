package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.PointInTimeRecoveryDescription;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;

class PointInTimeRecoveryDescriptionJsonMarshaller {
    private static PointInTimeRecoveryDescriptionJsonMarshaller instance;

    PointInTimeRecoveryDescriptionJsonMarshaller() {
    }

    public void marshall(PointInTimeRecoveryDescription pointInTimeRecoveryDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus() != null) {
            String pointInTimeRecoveryStatus = pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus();
            awsJsonWriter.name("PointInTimeRecoveryStatus");
            awsJsonWriter.value(pointInTimeRecoveryStatus);
        }
        if (pointInTimeRecoveryDescription.getEarliestRestorableDateTime() != null) {
            Date earliestRestorableDateTime = pointInTimeRecoveryDescription.getEarliestRestorableDateTime();
            awsJsonWriter.name("EarliestRestorableDateTime");
            awsJsonWriter.value(earliestRestorableDateTime);
        }
        if (pointInTimeRecoveryDescription.getLatestRestorableDateTime() != null) {
            Date latestRestorableDateTime = pointInTimeRecoveryDescription.getLatestRestorableDateTime();
            awsJsonWriter.name("LatestRestorableDateTime");
            awsJsonWriter.value(latestRestorableDateTime);
        }
        awsJsonWriter.endObject();
    }

    public static PointInTimeRecoveryDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new PointInTimeRecoveryDescriptionJsonMarshaller();
        }
        return instance;
    }
}
