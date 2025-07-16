package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.KMSInvalidMacException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class KMSInvalidMacExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSInvalidMacExceptionUnmarshaller() {
        super(KMSInvalidMacException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("KMSInvalidMacException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        KMSInvalidMacException kMSInvalidMacException = (KMSInvalidMacException) super.unmarshall(jsonErrorResponse);
        kMSInvalidMacException.setErrorCode("KMSInvalidMacException");
        return kMSInvalidMacException;
    }
}
