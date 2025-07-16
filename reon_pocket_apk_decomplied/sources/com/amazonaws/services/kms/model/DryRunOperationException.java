package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class DryRunOperationException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public DryRunOperationException(String str) {
        super(str);
    }
}
