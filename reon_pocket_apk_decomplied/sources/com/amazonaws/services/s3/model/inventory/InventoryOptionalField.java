package com.amazonaws.services.s3.model.inventory;

import com.amazonaws.services.s3.Headers;

public enum InventoryOptionalField {
    Size("Size"),
    LastModifiedDate("LastModifiedDate"),
    StorageClass("StorageClass"),
    ETag(Headers.ETAG),
    IsMultipartUploaded("IsMultipartUploaded"),
    ReplicationStatus("ReplicationStatus");
    
    private final String field;

    private InventoryOptionalField(String str) {
        this.field = str;
    }

    public String toString() {
        return this.field;
    }
}
