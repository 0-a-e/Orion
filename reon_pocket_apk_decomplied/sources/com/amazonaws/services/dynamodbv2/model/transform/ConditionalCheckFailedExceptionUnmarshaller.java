package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ConditionalCheckFailedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ConditionalCheckFailedExceptionUnmarshaller() {
        super(ConditionalCheckFailedException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ConditionalCheckFailedException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ConditionalCheckFailedException conditionalCheckFailedException = (ConditionalCheckFailedException) super.unmarshall(jsonErrorResponse);
        conditionalCheckFailedException.setErrorCode("ConditionalCheckFailedException");
        return conditionalCheckFailedException;
    }
}
