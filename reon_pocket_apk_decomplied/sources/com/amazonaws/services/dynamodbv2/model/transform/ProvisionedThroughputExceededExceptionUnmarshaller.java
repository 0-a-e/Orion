package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputExceededException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ProvisionedThroughputExceededExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ProvisionedThroughputExceededExceptionUnmarshaller() {
        super(ProvisionedThroughputExceededException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ProvisionedThroughputExceededException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ProvisionedThroughputExceededException provisionedThroughputExceededException = (ProvisionedThroughputExceededException) super.unmarshall(jsonErrorResponse);
        provisionedThroughputExceededException.setErrorCode("ProvisionedThroughputExceededException");
        return provisionedThroughputExceededException;
    }
}
