package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.ReplicaNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ReplicaNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ReplicaNotFoundExceptionUnmarshaller() {
        super(ReplicaNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ReplicaNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ReplicaNotFoundException replicaNotFoundException = (ReplicaNotFoundException) super.unmarshall(jsonErrorResponse);
        replicaNotFoundException.setErrorCode("ReplicaNotFoundException");
        return replicaNotFoundException;
    }
}
