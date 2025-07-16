package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.PointInTimeRecoveryUnavailableException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class PointInTimeRecoveryUnavailableExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public PointInTimeRecoveryUnavailableExceptionUnmarshaller() {
        super(PointInTimeRecoveryUnavailableException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("PointInTimeRecoveryUnavailableException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        PointInTimeRecoveryUnavailableException pointInTimeRecoveryUnavailableException = (PointInTimeRecoveryUnavailableException) super.unmarshall(jsonErrorResponse);
        pointInTimeRecoveryUnavailableException.setErrorCode("PointInTimeRecoveryUnavailableException");
        return pointInTimeRecoveryUnavailableException;
    }
}
