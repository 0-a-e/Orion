package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class XksKeyNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public XksKeyNotFoundException(String str) {
        super(str);
    }
}
