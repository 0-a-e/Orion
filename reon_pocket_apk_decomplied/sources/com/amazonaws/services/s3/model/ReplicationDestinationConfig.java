package com.amazonaws.services.s3.model;

public class ReplicationDestinationConfig {
    private String bucketARN;
    private String storageClass;

    public String getBucketARN() {
        return this.bucketARN;
    }

    public void setBucketARN(String str) {
        if (str != null) {
            this.bucketARN = str;
            return;
        }
        throw new IllegalArgumentException("Bucket name cannot be null");
    }

    public ReplicationDestinationConfig withBucketARN(String str) {
        setBucketARN(str);
        return this;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setStorageClass(StorageClass storageClass2) {
        String str;
        if (storageClass2 == null) {
            str = null;
            String str2 = null;
        } else {
            str = storageClass2.toString();
        }
        setStorageClass(str);
    }

    public ReplicationDestinationConfig withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public ReplicationDestinationConfig withStorageClass(StorageClass storageClass2) {
        String str;
        if (storageClass2 == null) {
            str = null;
            String str2 = null;
        } else {
            str = storageClass2.toString();
        }
        setStorageClass(str);
        return this;
    }

    public String getStorageClass() {
        return this.storageClass;
    }
}
