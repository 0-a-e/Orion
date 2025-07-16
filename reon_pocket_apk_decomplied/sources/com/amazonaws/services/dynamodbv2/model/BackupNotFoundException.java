package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class BackupNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public BackupNotFoundException(String str) {
        super(str);
    }
}
