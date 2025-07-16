package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.CreateCustomKeyStoreRequest;
import com.amazonaws.services.kms.model.XksProxyAuthenticationCredentialType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

public class CreateCustomKeyStoreRequestMarshaller implements Marshaller<Request<CreateCustomKeyStoreRequest>, CreateCustomKeyStoreRequest> {
    public Request<CreateCustomKeyStoreRequest> marshall(CreateCustomKeyStoreRequest createCustomKeyStoreRequest) {
        if (createCustomKeyStoreRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(createCustomKeyStoreRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.CreateCustomKeyStore");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (createCustomKeyStoreRequest.getCustomKeyStoreName() != null) {
                    String customKeyStoreName = createCustomKeyStoreRequest.getCustomKeyStoreName();
                    jsonWriter.name("CustomKeyStoreName");
                    jsonWriter.value(customKeyStoreName);
                }
                if (createCustomKeyStoreRequest.getCloudHsmClusterId() != null) {
                    String cloudHsmClusterId = createCustomKeyStoreRequest.getCloudHsmClusterId();
                    jsonWriter.name("CloudHsmClusterId");
                    jsonWriter.value(cloudHsmClusterId);
                }
                if (createCustomKeyStoreRequest.getTrustAnchorCertificate() != null) {
                    String trustAnchorCertificate = createCustomKeyStoreRequest.getTrustAnchorCertificate();
                    jsonWriter.name("TrustAnchorCertificate");
                    jsonWriter.value(trustAnchorCertificate);
                }
                if (createCustomKeyStoreRequest.getKeyStorePassword() != null) {
                    String keyStorePassword = createCustomKeyStoreRequest.getKeyStorePassword();
                    jsonWriter.name("KeyStorePassword");
                    jsonWriter.value(keyStorePassword);
                }
                if (createCustomKeyStoreRequest.getCustomKeyStoreType() != null) {
                    String customKeyStoreType = createCustomKeyStoreRequest.getCustomKeyStoreType();
                    jsonWriter.name("CustomKeyStoreType");
                    jsonWriter.value(customKeyStoreType);
                }
                if (createCustomKeyStoreRequest.getXksProxyUriEndpoint() != null) {
                    String xksProxyUriEndpoint = createCustomKeyStoreRequest.getXksProxyUriEndpoint();
                    jsonWriter.name("XksProxyUriEndpoint");
                    jsonWriter.value(xksProxyUriEndpoint);
                }
                if (createCustomKeyStoreRequest.getXksProxyUriPath() != null) {
                    String xksProxyUriPath = createCustomKeyStoreRequest.getXksProxyUriPath();
                    jsonWriter.name("XksProxyUriPath");
                    jsonWriter.value(xksProxyUriPath);
                }
                if (createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() != null) {
                    String xksProxyVpcEndpointServiceName = createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName();
                    jsonWriter.name("XksProxyVpcEndpointServiceName");
                    jsonWriter.value(xksProxyVpcEndpointServiceName);
                }
                if (createCustomKeyStoreRequest.getXksProxyAuthenticationCredential() != null) {
                    XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential = createCustomKeyStoreRequest.getXksProxyAuthenticationCredential();
                    jsonWriter.name("XksProxyAuthenticationCredential");
                    XksProxyAuthenticationCredentialTypeJsonMarshaller.getInstance().marshall(xksProxyAuthenticationCredential, jsonWriter);
                }
                if (createCustomKeyStoreRequest.getXksProxyConnectivity() != null) {
                    String xksProxyConnectivity = createCustomKeyStoreRequest.getXksProxyConnectivity();
                    jsonWriter.name("XksProxyConnectivity");
                    jsonWriter.value(xksProxyConnectivity);
                }
                jsonWriter.endObject();
                jsonWriter.close();
                String stringWriter2 = stringWriter.toString();
                byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
                defaultRequest.setContent(new StringInputStream(stringWriter2));
                defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
                if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                    defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
                }
                return defaultRequest;
            } catch (Throwable th) {
                throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
            }
        } else {
            throw new AmazonClientException("Invalid argument passed to marshall(CreateCustomKeyStoreRequest)");
        }
    }
}
