package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateCustomKeyStoreRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudHsmClusterId;
    private String customKeyStoreId;
    private String keyStorePassword;
    private String newCustomKeyStoreName;
    private XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;
    private String xksProxyConnectivity;
    private String xksProxyUriEndpoint;
    private String xksProxyUriPath;
    private String xksProxyVpcEndpointServiceName;

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public UpdateCustomKeyStoreRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public String getNewCustomKeyStoreName() {
        return this.newCustomKeyStoreName;
    }

    public void setNewCustomKeyStoreName(String str) {
        this.newCustomKeyStoreName = str;
    }

    public UpdateCustomKeyStoreRequest withNewCustomKeyStoreName(String str) {
        this.newCustomKeyStoreName = str;
        return this;
    }

    public String getKeyStorePassword() {
        return this.keyStorePassword;
    }

    public void setKeyStorePassword(String str) {
        this.keyStorePassword = str;
    }

    public UpdateCustomKeyStoreRequest withKeyStorePassword(String str) {
        this.keyStorePassword = str;
        return this;
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public UpdateCustomKeyStoreRequest withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public String getXksProxyUriEndpoint() {
        return this.xksProxyUriEndpoint;
    }

    public void setXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
    }

    public UpdateCustomKeyStoreRequest withXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
        return this;
    }

    public String getXksProxyUriPath() {
        return this.xksProxyUriPath;
    }

    public void setXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
    }

    public UpdateCustomKeyStoreRequest withXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
        return this;
    }

    public String getXksProxyVpcEndpointServiceName() {
        return this.xksProxyVpcEndpointServiceName;
    }

    public void setXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
    }

    public UpdateCustomKeyStoreRequest withXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
        return this;
    }

    public XksProxyAuthenticationCredentialType getXksProxyAuthenticationCredential() {
        return this.xksProxyAuthenticationCredential;
    }

    public void setXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
    }

    public UpdateCustomKeyStoreRequest withXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
        return this;
    }

    public String getXksProxyConnectivity() {
        return this.xksProxyConnectivity;
    }

    public void setXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
    }

    public UpdateCustomKeyStoreRequest withXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
        return this;
    }

    public void setXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
    }

    public UpdateCustomKeyStoreRequest withXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCustomKeyStoreId() != null) {
            sb.append("CustomKeyStoreId: " + getCustomKeyStoreId() + ",");
        }
        if (getNewCustomKeyStoreName() != null) {
            sb.append("NewCustomKeyStoreName: " + getNewCustomKeyStoreName() + ",");
        }
        if (getKeyStorePassword() != null) {
            sb.append("KeyStorePassword: " + getKeyStorePassword() + ",");
        }
        if (getCloudHsmClusterId() != null) {
            sb.append("CloudHsmClusterId: " + getCloudHsmClusterId() + ",");
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
        int i3 = 0;
        int hashCode = ((((((((((((getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode()) + 31) * 31) + (getNewCustomKeyStoreName() == null ? 0 : getNewCustomKeyStoreName().hashCode())) * 31) + (getKeyStorePassword() == null ? 0 : getKeyStorePassword().hashCode())) * 31) + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode())) * 31) + (getXksProxyUriEndpoint() == null ? 0 : getXksProxyUriEndpoint().hashCode())) * 31) + (getXksProxyUriPath() == null ? 0 : getXksProxyUriPath().hashCode())) * 31;
        if (getXksProxyVpcEndpointServiceName() == null) {
            i = 0;
        } else {
            i = getXksProxyVpcEndpointServiceName().hashCode();
        }
        int i4 = (hashCode + i) * 31;
        if (getXksProxyAuthenticationCredential() == null) {
            i2 = 0;
        } else {
            i2 = getXksProxyAuthenticationCredential().hashCode();
        }
        int i5 = (i4 + i2) * 31;
        if (getXksProxyConnectivity() != null) {
            i3 = getXksProxyConnectivity().hashCode();
        }
        return i5 + i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateCustomKeyStoreRequest)) {
            return false;
        }
        UpdateCustomKeyStoreRequest updateCustomKeyStoreRequest = (UpdateCustomKeyStoreRequest) obj;
        if ((updateCustomKeyStoreRequest.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getCustomKeyStoreId() != null && !updateCustomKeyStoreRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getNewCustomKeyStoreName() == null) ^ (getNewCustomKeyStoreName() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getNewCustomKeyStoreName() != null && !updateCustomKeyStoreRequest.getNewCustomKeyStoreName().equals(getNewCustomKeyStoreName())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getKeyStorePassword() == null) ^ (getKeyStorePassword() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getKeyStorePassword() != null && !updateCustomKeyStoreRequest.getKeyStorePassword().equals(getKeyStorePassword())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getCloudHsmClusterId() == null) ^ (getCloudHsmClusterId() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getCloudHsmClusterId() != null && !updateCustomKeyStoreRequest.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyUriEndpoint() == null) ^ (getXksProxyUriEndpoint() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyUriEndpoint() != null && !updateCustomKeyStoreRequest.getXksProxyUriEndpoint().equals(getXksProxyUriEndpoint())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyUriPath() == null) ^ (getXksProxyUriPath() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyUriPath() != null && !updateCustomKeyStoreRequest.getXksProxyUriPath().equals(getXksProxyUriPath())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() == null) ^ (getXksProxyVpcEndpointServiceName() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() != null && !updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName().equals(getXksProxyVpcEndpointServiceName())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential() == null) ^ (getXksProxyAuthenticationCredential() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential() != null && !updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential().equals(getXksProxyAuthenticationCredential())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyConnectivity() == null) ^ (getXksProxyConnectivity() == null)) {
            return false;
        }
        return updateCustomKeyStoreRequest.getXksProxyConnectivity() == null || updateCustomKeyStoreRequest.getXksProxyConnectivity().equals(getXksProxyConnectivity());
    }
}
