package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class ForbiddenException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ForbiddenException(String str) {
        super(str);
    }
}
