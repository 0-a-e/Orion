package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.GlobalTableNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class GlobalTableNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public GlobalTableNotFoundExceptionUnmarshaller() {
        super(GlobalTableNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("GlobalTableNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        GlobalTableNotFoundException globalTableNotFoundException = (GlobalTableNotFoundException) super.unmarshall(jsonErrorResponse);
        globalTableNotFoundException.setErrorCode("GlobalTableNotFoundException");
        return globalTableNotFoundException;
    }
}
