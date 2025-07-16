package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.DryRunOperationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class DryRunOperationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DryRunOperationExceptionUnmarshaller() {
        super(DryRunOperationException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("DryRunOperationException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        DryRunOperationException dryRunOperationException = (DryRunOperationException) super.unmarshall(jsonErrorResponse);
        dryRunOperationException.setErrorCode("DryRunOperationException");
        return dryRunOperationException;
    }
}
