package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.GlobalTableAlreadyExistsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class GlobalTableAlreadyExistsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public GlobalTableAlreadyExistsExceptionUnmarshaller() {
        super(GlobalTableAlreadyExistsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("GlobalTableAlreadyExistsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        GlobalTableAlreadyExistsException globalTableAlreadyExistsException = (GlobalTableAlreadyExistsException) super.unmarshall(jsonErrorResponse);
        globalTableAlreadyExistsException.setErrorCode("GlobalTableAlreadyExistsException");
        return globalTableAlreadyExistsException;
    }
}
