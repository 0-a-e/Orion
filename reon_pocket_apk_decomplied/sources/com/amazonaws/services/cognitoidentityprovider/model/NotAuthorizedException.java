package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class NotAuthorizedException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public NotAuthorizedException(String str) {
        super(str);
    }
}
