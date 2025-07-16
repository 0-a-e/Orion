package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.XksProxyConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class XksProxyConfigurationTypeJsonUnmarshaller implements Unmarshaller<XksProxyConfigurationType, JsonUnmarshallerContext> {
    private static XksProxyConfigurationTypeJsonUnmarshaller instance;

    XksProxyConfigurationTypeJsonUnmarshaller() {
    }

    public XksProxyConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        XksProxyConfigurationType xksProxyConfigurationType = new XksProxyConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Connectivity")) {
                xksProxyConfigurationType.setConnectivity(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AccessKeyId")) {
                xksProxyConfigurationType.setAccessKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("UriEndpoint")) {
                xksProxyConfigurationType.setUriEndpoint(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("UriPath")) {
                xksProxyConfigurationType.setUriPath(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("VpcEndpointServiceName")) {
                xksProxyConfigurationType.setVpcEndpointServiceName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return xksProxyConfigurationType;
    }

    public static XksProxyConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new XksProxyConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
