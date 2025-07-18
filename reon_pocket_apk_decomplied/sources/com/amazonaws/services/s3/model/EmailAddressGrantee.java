package com.amazonaws.services.s3.model;

import androidx.autofill.HintConstants;

public class EmailAddressGrantee implements Grantee {
    private String emailAddress = null;

    public String getTypeIdentifier() {
        return HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS;
    }

    public EmailAddressGrantee(String str) {
        setIdentifier(str);
    }

    public void setIdentifier(String str) {
        this.emailAddress = str;
    }

    public String getIdentifier() {
        return this.emailAddress;
    }

    public int hashCode() {
        String str = this.emailAddress;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmailAddressGrantee emailAddressGrantee = (EmailAddressGrantee) obj;
        String str = this.emailAddress;
        if (str == null) {
            if (emailAddressGrantee.emailAddress != null) {
                return false;
            }
        } else if (!str.equals(emailAddressGrantee.emailAddress)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.emailAddress;
    }
}
