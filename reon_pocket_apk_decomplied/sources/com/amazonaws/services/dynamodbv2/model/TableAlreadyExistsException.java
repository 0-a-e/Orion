package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class TableAlreadyExistsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TableAlreadyExistsException(String str) {
        super(str);
    }
}
