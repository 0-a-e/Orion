package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksKeyAlreadyInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksKeyAlreadyInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksKeyAlreadyInUseExceptionUnmarshaller() {
        super(XksKeyAlreadyInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksKeyAlreadyInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksKeyAlreadyInUseException xksKeyAlreadyInUseException = (XksKeyAlreadyInUseException) super.unmarshall(jsonErrorResponse);
        xksKeyAlreadyInUseException.setErrorCode("XksKeyAlreadyInUseException");
        return xksKeyAlreadyInUseException;
    }
}
