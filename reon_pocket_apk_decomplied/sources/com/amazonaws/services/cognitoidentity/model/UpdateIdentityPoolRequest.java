package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateIdentityPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean allowClassicFlow;
    private Boolean allowUnauthenticatedIdentities;
    private List<CognitoIdentityProvider> cognitoIdentityProviders;
    private String developerProviderName;
    private String identityPoolId;
    private String identityPoolName;
    private Map<String, String> identityPoolTags;
    private List<String> openIdConnectProviderARNs;
    private List<String> samlProviderARNs;
    private Map<String, String> supportedLoginProviders;

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public UpdateIdentityPoolRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public String getIdentityPoolName() {
        return this.identityPoolName;
    }

    public void setIdentityPoolName(String str) {
        this.identityPoolName = str;
    }

    public UpdateIdentityPoolRequest withIdentityPoolName(String str) {
        this.identityPoolName = str;
        return this;
    }

    public Boolean isAllowUnauthenticatedIdentities() {
        return this.allowUnauthenticatedIdentities;
    }

    public Boolean getAllowUnauthenticatedIdentities() {
        return this.allowUnauthenticatedIdentities;
    }

    public void setAllowUnauthenticatedIdentities(Boolean bool) {
        this.allowUnauthenticatedIdentities = bool;
    }

    public UpdateIdentityPoolRequest withAllowUnauthenticatedIdentities(Boolean bool) {
        this.allowUnauthenticatedIdentities = bool;
        return this;
    }

    public Boolean isAllowClassicFlow() {
        return this.allowClassicFlow;
    }

    public Boolean getAllowClassicFlow() {
        return this.allowClassicFlow;
    }

    public void setAllowClassicFlow(Boolean bool) {
        this.allowClassicFlow = bool;
    }

    public UpdateIdentityPoolRequest withAllowClassicFlow(Boolean bool) {
        this.allowClassicFlow = bool;
        return this;
    }

    public Map<String, String> getSupportedLoginProviders() {
        return this.supportedLoginProviders;
    }

    public void setSupportedLoginProviders(Map<String, String> map) {
        this.supportedLoginProviders = map;
    }

    public UpdateIdentityPoolRequest withSupportedLoginProviders(Map<String, String> map) {
        this.supportedLoginProviders = map;
        return this;
    }

    public UpdateIdentityPoolRequest addSupportedLoginProvidersEntry(String str, String str2) {
        if (this.supportedLoginProviders == null) {
            this.supportedLoginProviders = new HashMap();
        }
        if (!this.supportedLoginProviders.containsKey(str)) {
            this.supportedLoginProviders.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public UpdateIdentityPoolRequest clearSupportedLoginProvidersEntries() {
        this.supportedLoginProviders = null;
        return this;
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
    }

    public UpdateIdentityPoolRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public List<String> getOpenIdConnectProviderARNs() {
        return this.openIdConnectProviderARNs;
    }

    public void setOpenIdConnectProviderARNs(Collection<String> collection) {
        if (collection == null) {
            this.openIdConnectProviderARNs = null;
        } else {
            this.openIdConnectProviderARNs = new ArrayList(collection);
        }
    }

    public UpdateIdentityPoolRequest withOpenIdConnectProviderARNs(String... strArr) {
        if (getOpenIdConnectProviderARNs() == null) {
            this.openIdConnectProviderARNs = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.openIdConnectProviderARNs.add(add);
        }
        return this;
    }

    public UpdateIdentityPoolRequest withOpenIdConnectProviderARNs(Collection<String> collection) {
        setOpenIdConnectProviderARNs(collection);
        return this;
    }

    public List<CognitoIdentityProvider> getCognitoIdentityProviders() {
        return this.cognitoIdentityProviders;
    }

    public void setCognitoIdentityProviders(Collection<CognitoIdentityProvider> collection) {
        if (collection == null) {
            this.cognitoIdentityProviders = null;
        } else {
            this.cognitoIdentityProviders = new ArrayList(collection);
        }
    }

    public UpdateIdentityPoolRequest withCognitoIdentityProviders(CognitoIdentityProvider... cognitoIdentityProviderArr) {
        if (getCognitoIdentityProviders() == null) {
            this.cognitoIdentityProviders = new ArrayList(cognitoIdentityProviderArr.length);
        }
        for (CognitoIdentityProvider add : cognitoIdentityProviderArr) {
            this.cognitoIdentityProviders.add(add);
        }
        return this;
    }

    public UpdateIdentityPoolRequest withCognitoIdentityProviders(Collection<CognitoIdentityProvider> collection) {
        setCognitoIdentityProviders(collection);
        return this;
    }

    public List<String> getSamlProviderARNs() {
        return this.samlProviderARNs;
    }

    public void setSamlProviderARNs(Collection<String> collection) {
        if (collection == null) {
            this.samlProviderARNs = null;
        } else {
            this.samlProviderARNs = new ArrayList(collection);
        }
    }

    public UpdateIdentityPoolRequest withSamlProviderARNs(String... strArr) {
        if (getSamlProviderARNs() == null) {
            this.samlProviderARNs = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.samlProviderARNs.add(add);
        }
        return this;
    }

    public UpdateIdentityPoolRequest withSamlProviderARNs(Collection<String> collection) {
        setSamlProviderARNs(collection);
        return this;
    }

    public Map<String, String> getIdentityPoolTags() {
        return this.identityPoolTags;
    }

    public void setIdentityPoolTags(Map<String, String> map) {
        this.identityPoolTags = map;
    }

    public UpdateIdentityPoolRequest withIdentityPoolTags(Map<String, String> map) {
        this.identityPoolTags = map;
        return this;
    }

    public UpdateIdentityPoolRequest addIdentityPoolTagsEntry(String str, String str2) {
        if (this.identityPoolTags == null) {
            this.identityPoolTags = new HashMap();
        }
        if (!this.identityPoolTags.containsKey(str)) {
            this.identityPoolTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public UpdateIdentityPoolRequest clearIdentityPoolTagsEntries() {
        this.identityPoolTags = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getIdentityPoolName() != null) {
            sb.append("IdentityPoolName: " + getIdentityPoolName() + ",");
        }
        if (getAllowUnauthenticatedIdentities() != null) {
            sb.append("AllowUnauthenticatedIdentities: " + getAllowUnauthenticatedIdentities() + ",");
        }
        if (getAllowClassicFlow() != null) {
            sb.append("AllowClassicFlow: " + getAllowClassicFlow() + ",");
        }
        if (getSupportedLoginProviders() != null) {
            sb.append("SupportedLoginProviders: " + getSupportedLoginProviders() + ",");
        }
        if (getDeveloperProviderName() != null) {
            sb.append("DeveloperProviderName: " + getDeveloperProviderName() + ",");
        }
        if (getOpenIdConnectProviderARNs() != null) {
            sb.append("OpenIdConnectProviderARNs: " + getOpenIdConnectProviderARNs() + ",");
        }
        if (getCognitoIdentityProviders() != null) {
            sb.append("CognitoIdentityProviders: " + getCognitoIdentityProviders() + ",");
        }
        if (getSamlProviderARNs() != null) {
            sb.append("SamlProviderARNs: " + getSamlProviderARNs() + ",");
        }
        if (getIdentityPoolTags() != null) {
            sb.append("IdentityPoolTags: " + getIdentityPoolTags());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        int hashCode = ((((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31) + (getIdentityPoolName() == null ? 0 : getIdentityPoolName().hashCode())) * 31;
        if (getAllowUnauthenticatedIdentities() == null) {
            i = 0;
        } else {
            i = getAllowUnauthenticatedIdentities().hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + (getAllowClassicFlow() == null ? 0 : getAllowClassicFlow().hashCode())) * 31;
        if (getSupportedLoginProviders() == null) {
            i2 = 0;
        } else {
            i2 = getSupportedLoginProviders().hashCode();
        }
        int hashCode3 = (((hashCode2 + i2) * 31) + (getDeveloperProviderName() == null ? 0 : getDeveloperProviderName().hashCode())) * 31;
        if (getOpenIdConnectProviderARNs() == null) {
            i3 = 0;
        } else {
            i3 = getOpenIdConnectProviderARNs().hashCode();
        }
        int i6 = (hashCode3 + i3) * 31;
        if (getCognitoIdentityProviders() == null) {
            i4 = 0;
        } else {
            i4 = getCognitoIdentityProviders().hashCode();
        }
        int hashCode4 = (((i6 + i4) * 31) + (getSamlProviderARNs() == null ? 0 : getSamlProviderARNs().hashCode())) * 31;
        if (getIdentityPoolTags() != null) {
            i5 = getIdentityPoolTags().hashCode();
        }
        return hashCode4 + i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateIdentityPoolRequest)) {
            return false;
        }
        UpdateIdentityPoolRequest updateIdentityPoolRequest = (UpdateIdentityPoolRequest) obj;
        if ((updateIdentityPoolRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getIdentityPoolId() != null && !updateIdentityPoolRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getIdentityPoolName() == null) ^ (getIdentityPoolName() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getIdentityPoolName() != null && !updateIdentityPoolRequest.getIdentityPoolName().equals(getIdentityPoolName())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getAllowUnauthenticatedIdentities() == null) ^ (getAllowUnauthenticatedIdentities() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getAllowUnauthenticatedIdentities() != null && !updateIdentityPoolRequest.getAllowUnauthenticatedIdentities().equals(getAllowUnauthenticatedIdentities())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getAllowClassicFlow() == null) ^ (getAllowClassicFlow() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getAllowClassicFlow() != null && !updateIdentityPoolRequest.getAllowClassicFlow().equals(getAllowClassicFlow())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getSupportedLoginProviders() == null) ^ (getSupportedLoginProviders() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getSupportedLoginProviders() != null && !updateIdentityPoolRequest.getSupportedLoginProviders().equals(getSupportedLoginProviders())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getDeveloperProviderName() == null) ^ (getDeveloperProviderName() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getDeveloperProviderName() != null && !updateIdentityPoolRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getOpenIdConnectProviderARNs() == null) ^ (getOpenIdConnectProviderARNs() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getOpenIdConnectProviderARNs() != null && !updateIdentityPoolRequest.getOpenIdConnectProviderARNs().equals(getOpenIdConnectProviderARNs())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getCognitoIdentityProviders() == null) ^ (getCognitoIdentityProviders() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getCognitoIdentityProviders() != null && !updateIdentityPoolRequest.getCognitoIdentityProviders().equals(getCognitoIdentityProviders())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getSamlProviderARNs() == null) ^ (getSamlProviderARNs() == null)) {
            return false;
        }
        if (updateIdentityPoolRequest.getSamlProviderARNs() != null && !updateIdentityPoolRequest.getSamlProviderARNs().equals(getSamlProviderARNs())) {
            return false;
        }
        if ((updateIdentityPoolRequest.getIdentityPoolTags() == null) ^ (getIdentityPoolTags() == null)) {
            return false;
        }
        return updateIdentityPoolRequest.getIdentityPoolTags() == null || updateIdentityPoolRequest.getIdentityPoolTags().equals(getIdentityPoolTags());
    }
}
