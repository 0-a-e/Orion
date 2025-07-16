package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class XksProxyConfigurationType implements Serializable {
    private String accessKeyId;
    private String connectivity;
    private String uriEndpoint;
    private String uriPath;
    private String vpcEndpointServiceName;

    public String getConnectivity() {
        return this.connectivity;
    }

    public void setConnectivity(String str) {
        this.connectivity = str;
    }

    public XksProxyConfigurationType withConnectivity(String str) {
        this.connectivity = str;
        return this;
    }

    public void setConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.connectivity = xksProxyConnectivityType.toString();
    }

    public XksProxyConfigurationType withConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.connectivity = xksProxyConnectivityType.toString();
        return this;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public XksProxyConfigurationType withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public String getUriEndpoint() {
        return this.uriEndpoint;
    }

    public void setUriEndpoint(String str) {
        this.uriEndpoint = str;
    }

    public XksProxyConfigurationType withUriEndpoint(String str) {
        this.uriEndpoint = str;
        return this;
    }

    public String getUriPath() {
        return this.uriPath;
    }

    public void setUriPath(String str) {
        this.uriPath = str;
    }

    public XksProxyConfigurationType withUriPath(String str) {
        this.uriPath = str;
        return this;
    }

    public String getVpcEndpointServiceName() {
        return this.vpcEndpointServiceName;
    }

    public void setVpcEndpointServiceName(String str) {
        this.vpcEndpointServiceName = str;
    }

    public XksProxyConfigurationType withVpcEndpointServiceName(String str) {
        this.vpcEndpointServiceName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getConnectivity() != null) {
            sb.append("Connectivity: " + getConnectivity() + ",");
        }
        if (getAccessKeyId() != null) {
            sb.append("AccessKeyId: " + getAccessKeyId() + ",");
        }
        if (getUriEndpoint() != null) {
            sb.append("UriEndpoint: " + getUriEndpoint() + ",");
        }
        if (getUriPath() != null) {
            sb.append("UriPath: " + getUriPath() + ",");
        }
        if (getVpcEndpointServiceName() != null) {
            sb.append("VpcEndpointServiceName: " + getVpcEndpointServiceName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((getConnectivity() == null ? 0 : getConnectivity().hashCode()) + 31) * 31) + (getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode())) * 31) + (getUriEndpoint() == null ? 0 : getUriEndpoint().hashCode())) * 31) + (getUriPath() == null ? 0 : getUriPath().hashCode())) * 31;
        if (getVpcEndpointServiceName() != null) {
            i = getVpcEndpointServiceName().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof XksProxyConfigurationType)) {
            return false;
        }
        XksProxyConfigurationType xksProxyConfigurationType = (XksProxyConfigurationType) obj;
        if ((xksProxyConfigurationType.getConnectivity() == null) ^ (getConnectivity() == null)) {
            return false;
        }
        if (xksProxyConfigurationType.getConnectivity() != null && !xksProxyConfigurationType.getConnectivity().equals(getConnectivity())) {
            return false;
        }
        if ((xksProxyConfigurationType.getAccessKeyId() == null) ^ (getAccessKeyId() == null)) {
            return false;
        }
        if (xksProxyConfigurationType.getAccessKeyId() != null && !xksProxyConfigurationType.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if ((xksProxyConfigurationType.getUriEndpoint() == null) ^ (getUriEndpoint() == null)) {
            return false;
        }
        if (xksProxyConfigurationType.getUriEndpoint() != null && !xksProxyConfigurationType.getUriEndpoint().equals(getUriEndpoint())) {
            return false;
        }
        if ((xksProxyConfigurationType.getUriPath() == null) ^ (getUriPath() == null)) {
            return false;
        }
        if (xksProxyConfigurationType.getUriPath() != null && !xksProxyConfigurationType.getUriPath().equals(getUriPath())) {
            return false;
        }
        if ((xksProxyConfigurationType.getVpcEndpointServiceName() == null) ^ (getVpcEndpointServiceName() == null)) {
            return false;
        }
        return xksProxyConfigurationType.getVpcEndpointServiceName() == null || xksProxyConfigurationType.getVpcEndpointServiceName().equals(getVpcEndpointServiceName());
    }
}
