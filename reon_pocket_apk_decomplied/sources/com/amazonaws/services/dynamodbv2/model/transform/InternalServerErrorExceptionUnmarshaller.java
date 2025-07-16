package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.InternalServerErrorException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InternalServerErrorExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InternalServerErrorExceptionUnmarshaller() {
        super(InternalServerErrorException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InternalServerError");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InternalServerErrorException internalServerErrorException = (InternalServerErrorException) super.unmarshall(jsonErrorResponse);
        internalServerErrorException.setErrorCode("InternalServerError");
        return internalServerErrorException;
    }
}
