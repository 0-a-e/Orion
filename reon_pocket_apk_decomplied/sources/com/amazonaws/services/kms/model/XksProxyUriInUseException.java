package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class XksProxyUriInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public XksProxyUriInUseException(String str) {
        super(str);
    }
}
