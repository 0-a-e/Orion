package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class XksKeyAlreadyInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public XksKeyAlreadyInUseException(String str) {
        super(str);
    }
}
