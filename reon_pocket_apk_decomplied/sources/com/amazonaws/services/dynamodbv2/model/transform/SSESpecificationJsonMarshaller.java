package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.SSESpecification;
import com.amazonaws.util.json.AwsJsonWriter;

class SSESpecificationJsonMarshaller {
    private static SSESpecificationJsonMarshaller instance;

    SSESpecificationJsonMarshaller() {
    }

    public void marshall(SSESpecification sSESpecification, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (sSESpecification.getEnabled() != null) {
            Boolean enabled = sSESpecification.getEnabled();
            awsJsonWriter.name("Enabled");
            awsJsonWriter.value(enabled.booleanValue());
        }
        if (sSESpecification.getSSEType() != null) {
            String sSEType = sSESpecification.getSSEType();
            awsJsonWriter.name("SSEType");
            awsJsonWriter.value(sSEType);
        }
        if (sSESpecification.getKMSMasterKeyId() != null) {
            String kMSMasterKeyId = sSESpecification.getKMSMasterKeyId();
            awsJsonWriter.name("KMSMasterKeyId");
            awsJsonWriter.value(kMSMasterKeyId);
        }
        awsJsonWriter.endObject();
    }

    public static SSESpecificationJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SSESpecificationJsonMarshaller();
        }
        return instance;
    }
}
