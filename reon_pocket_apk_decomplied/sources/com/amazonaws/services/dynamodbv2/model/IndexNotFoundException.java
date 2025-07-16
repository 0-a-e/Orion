package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class IndexNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public IndexNotFoundException(String str) {
        super(str);
    }
}
