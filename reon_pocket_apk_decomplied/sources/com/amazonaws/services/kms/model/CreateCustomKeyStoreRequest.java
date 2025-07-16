package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateCustomKeyStoreRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudHsmClusterId;
    private String customKeyStoreName;
    private String customKeyStoreType;
    private String keyStorePassword;
    private String trustAnchorCertificate;
    private XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;
    private String xksProxyConnectivity;
    private String xksProxyUriEndpoint;
    private String xksProxyUriPath;
    private String xksProxyVpcEndpointServiceName;

    public String getCustomKeyStoreName() {
        return this.customKeyStoreName;
    }

    public void setCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
        return this;
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public CreateCustomKeyStoreRequest withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public String getTrustAnchorCertificate() {
        return this.trustAnchorCertificate;
    }

    public void setTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
    }

    public CreateCustomKeyStoreRequest withTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
        return this;
    }

    public String getKeyStorePassword() {
        return this.keyStorePassword;
    }

    public void setKeyStorePassword(String str) {
        this.keyStorePassword = str;
    }

    public CreateCustomKeyStoreRequest withKeyStorePassword(String str) {
        this.keyStorePassword = str;
        return this;
    }

    public String getCustomKeyStoreType() {
        return this.customKeyStoreType;
    }

    public void setCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
        return this;
    }

    public void setCustomKeyStoreType(CustomKeyStoreType customKeyStoreType2) {
        this.customKeyStoreType = customKeyStoreType2.toString();
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreType(CustomKeyStoreType customKeyStoreType2) {
        this.customKeyStoreType = customKeyStoreType2.toString();
        return this;
    }

    public String getXksProxyUriEndpoint() {
        return this.xksProxyUriEndpoint;
    }

    public void setXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
    }

    public CreateCustomKeyStoreRequest withXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
        return this;
    }

    public String getXksProxyUriPath() {
        return this.xksProxyUriPath;
    }

    public void setXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
    }

    public CreateCustomKeyStoreRequest withXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
        return this;
    }

    public String getXksProxyVpcEndpointServiceName() {
        return this.xksProxyVpcEndpointServiceName;
    }

    public void setXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
    }

    public CreateCustomKeyStoreRequest withXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
        return this;
    }

    public XksProxyAuthenticationCredentialType getXksProxyAuthenticationCredential() {
        return this.xksProxyAuthenticationCredential;
    }

    public void setXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
    }

    public CreateCustomKeyStoreRequest withXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
        return this;
    }

    public String getXksProxyConnectivity() {
        return this.xksProxyConnectivity;
    }

    public void setXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
    }

    public CreateCustomKeyStoreRequest withXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
        return this;
    }

    public void setXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
    }

    public CreateCustomKeyStoreRequest withXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCustomKeyStoreName() != null) {
            sb.append("CustomKeyStoreName: " + getCustomKeyStoreName() + ",");
        }
        if (getCloudHsmClusterId() != null) {
            sb.append("CloudHsmClusterId: " + getCloudHsmClusterId() + ",");
        }
        if (getTrustAnchorCertificate() != null) {
            sb.append("TrustAnchorCertificate: " + getTrustAnchorCertificate() + ",");
        }
        if (getKeyStorePassword() != null) {
            sb.append("KeyStorePassword: " + getKeyStorePassword() + ",");
        }
        if (getCustomKeyStoreType() != null) {
            sb.append("CustomKeyStoreType: " + getCustomKeyStoreType() + ",");
        }
        if (getXksProxyUriEndpoint() != null) {
            sb.append("XksProxyUriEndpoint: " + getXksProxyUriEndpoint() + ",");
        }
        if (getXksProxyUriPath() != null) {
            sb.append("XksProxyUriPath: " + getXksProxyUriPath() + ",");
        }
        if (getXksProxyVpcEndpointServiceName() != null) {
            sb.append("XksProxyVpcEndpointServiceName: " + getXksProxyVpcEndpointServiceName() + ",");
        }
        if (getXksProxyAuthenticationCredential() != null) {
            sb.append("XksProxyAuthenticationCredential: " + getXksProxyAuthenticationCredential() + ",");
        }
        if (getXksProxyConnectivity() != null) {
            sb.append("XksProxyConnectivity: " + getXksProxyConnectivity());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int hashCode = ((((getCustomKeyStoreName() == null ? 0 : getCustomKeyStoreName().hashCode()) + 31) * 31) + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode())) * 31;
        if (getTrustAnchorCertificate() == null) {
            i = 0;
        } else {
            i = getTrustAnchorCertificate().hashCode();
        }
        int hashCode2 = (((((((((hashCode + i) * 31) + (getKeyStorePassword() == null ? 0 : getKeyStorePassword().hashCode())) * 31) + (getCustomKeyStoreType() == null ? 0 : getCustomKeyStoreType().hashCode())) * 31) + (getXksProxyUriEndpoint() == null ? 0 : getXksProxyUriEndpoint().hashCode())) * 31) + (getXksProxyUriPath() == null ? 0 : getXksProxyUriPath().hashCode())) * 31;
        if (getXksProxyVpcEndpointServiceName() == null) {
            i2 = 0;
        } else {
            i2 = getXksProxyVpcEndpointServiceName().hashCode();
        }
        int i5 = (hashCode2 + i2) * 31;
        if (getXksProxyAuthenticationCredential() == null) {
            i3 = 0;
        } else {
            i3 = getXksProxyAuthenticationCredential().hashCode();
        }
        int i6 = (i5 + i3) * 31;
        if (getXksProxyConnectivity() != null) {
            i4 = getXksProxyConnectivity().hashCode();
        }
        return i6 + i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateCustomKeyStoreRequest)) {
            return false;
        }
        CreateCustomKeyStoreRequest createCustomKeyStoreRequest = (CreateCustomKeyStoreRequest) obj;
        if ((createCustomKeyStoreRequest.getCustomKeyStoreName() == null) ^ (getCustomKeyStoreName() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCustomKeyStoreName() != null && !createCustomKeyStoreRequest.getCustomKeyStoreName().equals(getCustomKeyStoreName())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getCloudHsmClusterId() == null) ^ (getCloudHsmClusterId() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCloudHsmClusterId() != null && !createCustomKeyStoreRequest.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getTrustAnchorCertificate() == null) ^ (getTrustAnchorCertificate() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getTrustAnchorCertificate() != null && !createCustomKeyStoreRequest.getTrustAnchorCertificate().equals(getTrustAnchorCertificate())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getKeyStorePassword() == null) ^ (getKeyStorePassword() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getKeyStorePassword() != null && !createCustomKeyStoreRequest.getKeyStorePassword().equals(getKeyStorePassword())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getCustomKeyStoreType() == null) ^ (getCustomKeyStoreType() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCustomKeyStoreType() != null && !createCustomKeyStoreRequest.getCustomKeyStoreType().equals(getCustomKeyStoreType())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyUriEndpoint() == null) ^ (getXksProxyUriEndpoint() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyUriEndpoint() != null && !createCustomKeyStoreRequest.getXksProxyUriEndpoint().equals(getXksProxyUriEndpoint())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyUriPath() == null) ^ (getXksProxyUriPath() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyUriPath() != null && !createCustomKeyStoreRequest.getXksProxyUriPath().equals(getXksProxyUriPath())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() == null) ^ (getXksProxyVpcEndpointServiceName() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() != null && !createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName().equals(getXksProxyVpcEndpointServiceName())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyAuthenticationCredential() == null) ^ (getXksProxyAuthenticationCredential() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyAuthenticationCredential() != null && !createCustomKeyStoreRequest.getXksProxyAuthenticationCredential().equals(getXksProxyAuthenticationCredential())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyConnectivity() == null) ^ (getXksProxyConnectivity() == null)) {
            return false;
        }
        return createCustomKeyStoreRequest.getXksProxyConnectivity() == null || createCustomKeyStoreRequest.getXksProxyConnectivity().equals(getXksProxyConnectivity());
    }
}
