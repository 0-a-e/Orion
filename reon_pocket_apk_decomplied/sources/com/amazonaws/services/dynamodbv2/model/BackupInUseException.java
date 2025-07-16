package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class BackupInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public BackupInUseException(String str) {
        super(str);
    }
}
