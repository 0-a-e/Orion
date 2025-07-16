package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.XksProxyConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;

class XksProxyConfigurationTypeJsonMarshaller {
    private static XksProxyConfigurationTypeJsonMarshaller instance;

    XksProxyConfigurationTypeJsonMarshaller() {
    }

    public void marshall(XksProxyConfigurationType xksProxyConfigurationType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (xksProxyConfigurationType.getConnectivity() != null) {
            String connectivity = xksProxyConfigurationType.getConnectivity();
            awsJsonWriter.name("Connectivity");
            awsJsonWriter.value(connectivity);
        }
        if (xksProxyConfigurationType.getAccessKeyId() != null) {
            String accessKeyId = xksProxyConfigurationType.getAccessKeyId();
            awsJsonWriter.name("AccessKeyId");
            awsJsonWriter.value(accessKeyId);
        }
        if (xksProxyConfigurationType.getUriEndpoint() != null) {
            String uriEndpoint = xksProxyConfigurationType.getUriEndpoint();
            awsJsonWriter.name("UriEndpoint");
            awsJsonWriter.value(uriEndpoint);
        }
        if (xksProxyConfigurationType.getUriPath() != null) {
            String uriPath = xksProxyConfigurationType.getUriPath();
            awsJsonWriter.name("UriPath");
            awsJsonWriter.value(uriPath);
        }
        if (xksProxyConfigurationType.getVpcEndpointServiceName() != null) {
            String vpcEndpointServiceName = xksProxyConfigurationType.getVpcEndpointServiceName();
            awsJsonWriter.name("VpcEndpointServiceName");
            awsJsonWriter.value(vpcEndpointServiceName);
        }
        awsJsonWriter.endObject();
    }

    public static XksProxyConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new XksProxyConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
