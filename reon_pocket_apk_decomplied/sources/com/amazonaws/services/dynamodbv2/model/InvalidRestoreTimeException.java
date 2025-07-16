package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class InvalidRestoreTimeException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidRestoreTimeException(String str) {
        super(str);
    }
}
