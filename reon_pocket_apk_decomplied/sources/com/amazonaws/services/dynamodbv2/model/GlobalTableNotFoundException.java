package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class GlobalTableNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public GlobalTableNotFoundException(String str) {
        super(str);
    }
}
