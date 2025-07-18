package com.amazonaws.services.s3.model;

import java.io.Serializable;

public class Owner implements Serializable {
    private static final long serialVersionUID = -8916731456944569115L;
    private String displayName;
    private String id;

    public Owner() {
    }

    public Owner(String str, String str2) {
        this.id = str;
        this.displayName = str2;
    }

    public String toString() {
        return "S3Owner [name=" + getDisplayName() + ",id=" + getId() + "]";
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) obj;
        String id2 = owner.getId();
        String displayName2 = owner.getDisplayName();
        String id3 = getId();
        String displayName3 = getDisplayName();
        if (id2 == null) {
            id2 = "";
        }
        if (displayName2 == null) {
            displayName2 = "";
        }
        if (id3 == null) {
            id3 = "";
        }
        if (displayName3 == null) {
            displayName3 = "";
        }
        if (!id2.equals(id3) || !displayName2.equals(displayName3)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
