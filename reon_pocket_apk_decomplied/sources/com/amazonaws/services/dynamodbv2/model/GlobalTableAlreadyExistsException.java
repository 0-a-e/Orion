package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class GlobalTableAlreadyExistsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public GlobalTableAlreadyExistsException(String str) {
        super(str);
    }
}
