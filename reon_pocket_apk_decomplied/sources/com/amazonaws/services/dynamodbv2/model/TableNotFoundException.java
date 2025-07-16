package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class TableNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TableNotFoundException(String str) {
        super(str);
    }
}
