package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

public class Bucket implements Serializable {
    private static final long serialVersionUID = -8646831898339939580L;
    private Date creationDate;
    private String name;
    private Owner owner;

    public Bucket() {
        this.name = null;
        this.owner = null;
        this.creationDate = null;
    }

    public Bucket(String str) {
        this.owner = null;
        this.creationDate = null;
        this.name = str;
    }

    public String toString() {
        return "S3Bucket [name=" + getName() + ", creationDate=" + getCreationDate() + ", owner=" + getOwner() + "]";
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner2) {
        this.owner = owner2;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
