package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class ConflictException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ConflictException(String str) {
        super(str);
    }
}
