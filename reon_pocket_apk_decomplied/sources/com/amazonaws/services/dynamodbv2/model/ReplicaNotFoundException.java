package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class ReplicaNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ReplicaNotFoundException(String str) {
        super(str);
    }
}
