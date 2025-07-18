package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListIdentitiesResult implements Serializable {
    private List<IdentityDescription> identities;
    private String identityPoolId;
    private String nextToken;

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public ListIdentitiesResult withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public List<IdentityDescription> getIdentities() {
        return this.identities;
    }

    public void setIdentities(Collection<IdentityDescription> collection) {
        if (collection == null) {
            this.identities = null;
        } else {
            this.identities = new ArrayList(collection);
        }
    }

    public ListIdentitiesResult withIdentities(IdentityDescription... identityDescriptionArr) {
        if (getIdentities() == null) {
            this.identities = new ArrayList(identityDescriptionArr.length);
        }
        for (IdentityDescription add : identityDescriptionArr) {
            this.identities.add(add);
        }
        return this;
    }

    public ListIdentitiesResult withIdentities(Collection<IdentityDescription> collection) {
        setIdentities(collection);
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListIdentitiesResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getIdentities() != null) {
            sb.append("Identities: " + getIdentities() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31) + (getIdentities() == null ? 0 : getIdentities().hashCode())) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentitiesResult)) {
            return false;
        }
        ListIdentitiesResult listIdentitiesResult = (ListIdentitiesResult) obj;
        if ((listIdentitiesResult.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (listIdentitiesResult.getIdentityPoolId() != null && !listIdentitiesResult.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((listIdentitiesResult.getIdentities() == null) ^ (getIdentities() == null)) {
            return false;
        }
        if (listIdentitiesResult.getIdentities() != null && !listIdentitiesResult.getIdentities().equals(getIdentities())) {
            return false;
        }
        if ((listIdentitiesResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listIdentitiesResult.getNextToken() == null || listIdentitiesResult.getNextToken().equals(getNextToken());
    }
}
