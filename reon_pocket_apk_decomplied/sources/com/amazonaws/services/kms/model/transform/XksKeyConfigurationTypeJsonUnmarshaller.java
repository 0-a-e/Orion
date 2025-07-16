package com.amazonaws.services.kms.model.transform;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.kms.model.XksKeyConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class XksKeyConfigurationTypeJsonUnmarshaller implements Unmarshaller<XksKeyConfigurationType, JsonUnmarshallerContext> {
    private static XksKeyConfigurationTypeJsonUnmarshaller instance;

    XksKeyConfigurationTypeJsonUnmarshaller() {
    }

    public XksKeyConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        XksKeyConfigurationType xksKeyConfigurationType = new XksKeyConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals(JsonDocumentFields.POLICY_ID)) {
                xksKeyConfigurationType.setId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return xksKeyConfigurationType;
    }

    public static XksKeyConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new XksKeyConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
