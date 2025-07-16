package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class ContinuousBackupsUnavailableException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ContinuousBackupsUnavailableException(String str) {
        super(str);
    }
}
