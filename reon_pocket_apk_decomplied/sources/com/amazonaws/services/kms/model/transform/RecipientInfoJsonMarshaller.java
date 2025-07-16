package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.RecipientInfo;
import com.amazonaws.util.json.AwsJsonWriter;
import java.nio.ByteBuffer;

class RecipientInfoJsonMarshaller {
    private static RecipientInfoJsonMarshaller instance;

    RecipientInfoJsonMarshaller() {
    }

    public void marshall(RecipientInfo recipientInfo, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (recipientInfo.getKeyEncryptionAlgorithm() != null) {
            String keyEncryptionAlgorithm = recipientInfo.getKeyEncryptionAlgorithm();
            awsJsonWriter.name("KeyEncryptionAlgorithm");
            awsJsonWriter.value(keyEncryptionAlgorithm);
        }
        if (recipientInfo.getAttestationDocument() != null) {
            ByteBuffer attestationDocument = recipientInfo.getAttestationDocument();
            awsJsonWriter.name("AttestationDocument");
            awsJsonWriter.value(attestationDocument);
        }
        awsJsonWriter.endObject();
    }

    public static RecipientInfoJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RecipientInfoJsonMarshaller();
        }
        return instance;
    }
}
