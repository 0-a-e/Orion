package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

public class ReplicaAlreadyExistsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ReplicaAlreadyExistsException(String str) {
        super(str);
    }
}
