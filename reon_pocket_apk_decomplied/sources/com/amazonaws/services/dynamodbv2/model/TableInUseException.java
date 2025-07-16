package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class TableInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TableInUseException(String str) {
        super(str);
    }
}
