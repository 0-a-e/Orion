package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class MergeDeveloperIdentitiesRequest extends AmazonWebServiceRequest implements Serializable {
    private String destinationUserIdentifier;
    private String developerProviderName;
    private String identityPoolId;
    private String sourceUserIdentifier;

    public String getSourceUserIdentifier() {
        return this.sourceUserIdentifier;
    }

    public void setSourceUserIdentifier(String str) {
        this.sourceUserIdentifier = str;
    }

    public MergeDeveloperIdentitiesRequest withSourceUserIdentifier(String str) {
        this.sourceUserIdentifier = str;
        return this;
    }

    public String getDestinationUserIdentifier() {
        return this.destinationUserIdentifier;
    }

    public void setDestinationUserIdentifier(String str) {
        this.destinationUserIdentifier = str;
    }

    public MergeDeveloperIdentitiesRequest withDestinationUserIdentifier(String str) {
        this.destinationUserIdentifier = str;
        return this;
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
    }

    public MergeDeveloperIdentitiesRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public MergeDeveloperIdentitiesRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getSourceUserIdentifier() != null) {
            sb.append("SourceUserIdentifier: " + getSourceUserIdentifier() + ",");
        }
        if (getDestinationUserIdentifier() != null) {
            sb.append("DestinationUserIdentifier: " + getDestinationUserIdentifier() + ",");
        }
        if (getDeveloperProviderName() != null) {
            sb.append("DeveloperProviderName: " + getDeveloperProviderName() + ",");
        }
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((getSourceUserIdentifier() == null ? 0 : getSourceUserIdentifier().hashCode()) + 31) * 31;
        if (getDestinationUserIdentifier() == null) {
            i = 0;
        } else {
            i = getDestinationUserIdentifier().hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + (getDeveloperProviderName() == null ? 0 : getDeveloperProviderName().hashCode())) * 31;
        if (getIdentityPoolId() != null) {
            i2 = getIdentityPoolId().hashCode();
        }
        return hashCode2 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MergeDeveloperIdentitiesRequest)) {
            return false;
        }
        MergeDeveloperIdentitiesRequest mergeDeveloperIdentitiesRequest = (MergeDeveloperIdentitiesRequest) obj;
        if ((mergeDeveloperIdentitiesRequest.getSourceUserIdentifier() == null) ^ (getSourceUserIdentifier() == null)) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getSourceUserIdentifier() != null && !mergeDeveloperIdentitiesRequest.getSourceUserIdentifier().equals(getSourceUserIdentifier())) {
            return false;
        }
        if ((mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier() == null) ^ (getDestinationUserIdentifier() == null)) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier() != null && !mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier().equals(getDestinationUserIdentifier())) {
            return false;
        }
        if ((mergeDeveloperIdentitiesRequest.getDeveloperProviderName() == null) ^ (getDeveloperProviderName() == null)) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getDeveloperProviderName() != null && !mergeDeveloperIdentitiesRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if ((mergeDeveloperIdentitiesRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        return mergeDeveloperIdentitiesRequest.getIdentityPoolId() == null || mergeDeveloperIdentitiesRequest.getIdentityPoolId().equals(getIdentityPoolId());
    }
}
