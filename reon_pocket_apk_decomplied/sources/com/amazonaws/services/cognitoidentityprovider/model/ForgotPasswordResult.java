package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class ForgotPasswordResult implements Serializable {
    private CodeDeliveryDetailsType codeDeliveryDetails;

    public CodeDeliveryDetailsType getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public void setCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
    }

    public ForgotPasswordResult withCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCodeDeliveryDetails() != null) {
            sb.append("CodeDeliveryDetails: " + getCodeDeliveryDetails());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getCodeDeliveryDetails() == null ? 0 : getCodeDeliveryDetails().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ForgotPasswordResult)) {
            return false;
        }
        ForgotPasswordResult forgotPasswordResult = (ForgotPasswordResult) obj;
        if ((forgotPasswordResult.getCodeDeliveryDetails() == null) ^ (getCodeDeliveryDetails() == null)) {
            return false;
        }
        return forgotPasswordResult.getCodeDeliveryDetails() == null || forgotPasswordResult.getCodeDeliveryDetails().equals(getCodeDeliveryDetails());
    }
}
