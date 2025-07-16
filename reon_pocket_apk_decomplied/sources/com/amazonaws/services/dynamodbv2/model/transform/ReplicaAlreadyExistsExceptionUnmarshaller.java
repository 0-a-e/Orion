package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.ReplicaAlreadyExistsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ReplicaAlreadyExistsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ReplicaAlreadyExistsExceptionUnmarshaller() {
        super(ReplicaAlreadyExistsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ReplicaAlreadyExistsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ReplicaAlreadyExistsException replicaAlreadyExistsException = (ReplicaAlreadyExistsException) super.unmarshall(jsonErrorResponse);
        replicaAlreadyExistsException.setErrorCode("ReplicaAlreadyExistsException");
        return replicaAlreadyExistsException;
    }
}
