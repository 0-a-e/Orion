package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class PointInTimeRecoveryUnavailableException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public PointInTimeRecoveryUnavailableException(String str) {
        super(str);
    }
}
