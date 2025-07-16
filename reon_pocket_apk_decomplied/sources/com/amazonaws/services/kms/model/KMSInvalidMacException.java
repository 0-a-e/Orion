package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class KMSInvalidMacException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public KMSInvalidMacException(String str) {
        super(str);
    }
}
