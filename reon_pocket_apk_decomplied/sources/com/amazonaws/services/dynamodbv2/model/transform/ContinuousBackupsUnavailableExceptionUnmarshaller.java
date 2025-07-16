package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.ContinuousBackupsUnavailableException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ContinuousBackupsUnavailableExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ContinuousBackupsUnavailableExceptionUnmarshaller() {
        super(ContinuousBackupsUnavailableException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ContinuousBackupsUnavailableException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ContinuousBackupsUnavailableException continuousBackupsUnavailableException = (ContinuousBackupsUnavailableException) super.unmarshall(jsonErrorResponse);
        continuousBackupsUnavailableException.setErrorCode("ContinuousBackupsUnavailableException");
        return continuousBackupsUnavailableException;
    }
}
