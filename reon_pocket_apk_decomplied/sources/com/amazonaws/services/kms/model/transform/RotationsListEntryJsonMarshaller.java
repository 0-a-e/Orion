package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.RotationsListEntry;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;

class RotationsListEntryJsonMarshaller {
    private static RotationsListEntryJsonMarshaller instance;

    RotationsListEntryJsonMarshaller() {
    }

    public void marshall(RotationsListEntry rotationsListEntry, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (rotationsListEntry.getKeyId() != null) {
            String keyId = rotationsListEntry.getKeyId();
            awsJsonWriter.name("KeyId");
            awsJsonWriter.value(keyId);
        }
        if (rotationsListEntry.getRotationDate() != null) {
            Date rotationDate = rotationsListEntry.getRotationDate();
            awsJsonWriter.name("RotationDate");
            awsJsonWriter.value(rotationDate);
        }
        if (rotationsListEntry.getRotationType() != null) {
            String rotationType = rotationsListEntry.getRotationType();
            awsJsonWriter.name("RotationType");
            awsJsonWriter.value(rotationType);
        }
        awsJsonWriter.endObject();
    }

    public static RotationsListEntryJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RotationsListEntryJsonMarshaller();
        }
        return instance;
    }
}
