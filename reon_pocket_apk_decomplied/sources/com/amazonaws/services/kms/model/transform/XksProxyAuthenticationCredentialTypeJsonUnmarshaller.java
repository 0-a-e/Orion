package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.XksProxyAuthenticationCredentialType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class XksProxyAuthenticationCredentialTypeJsonUnmarshaller implements Unmarshaller<XksProxyAuthenticationCredentialType, JsonUnmarshallerContext> {
    private static XksProxyAuthenticationCredentialTypeJsonUnmarshaller instance;

    XksProxyAuthenticationCredentialTypeJsonUnmarshaller() {
    }

    public XksProxyAuthenticationCredentialType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType = new XksProxyAuthenticationCredentialType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("AccessKeyId")) {
                xksProxyAuthenticationCredentialType.setAccessKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("RawSecretAccessKey")) {
                xksProxyAuthenticationCredentialType.setRawSecretAccessKey(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return xksProxyAuthenticationCredentialType;
    }

    public static XksProxyAuthenticationCredentialTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new XksProxyAuthenticationCredentialTypeJsonUnmarshaller();
        }
        return instance;
    }
}
