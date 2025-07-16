package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ResourceInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ResourceInUseExceptionUnmarshaller() {
        super(ResourceInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ResourceInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ResourceInUseException resourceInUseException = (ResourceInUseException) super.unmarshall(jsonErrorResponse);
        resourceInUseException.setErrorCode("ResourceInUseException");
        return resourceInUseException;
    }
}
