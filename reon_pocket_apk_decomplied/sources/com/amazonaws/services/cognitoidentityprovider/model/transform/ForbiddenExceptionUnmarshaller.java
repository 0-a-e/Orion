package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.ForbiddenException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ForbiddenExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ForbiddenExceptionUnmarshaller() {
        super(ForbiddenException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ForbiddenException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ForbiddenException forbiddenException = (ForbiddenException) super.unmarshall(jsonErrorResponse);
        forbiddenException.setErrorCode("ForbiddenException");
        return forbiddenException;
    }
}
