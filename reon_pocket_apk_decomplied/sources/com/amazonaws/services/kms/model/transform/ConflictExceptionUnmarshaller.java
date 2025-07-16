package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.ConflictException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ConflictExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ConflictExceptionUnmarshaller() {
        super(ConflictException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ConflictException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ConflictException conflictException = (ConflictException) super.unmarshall(jsonErrorResponse);
        conflictException.setErrorCode("ConflictException");
        return conflictException;
    }
}
