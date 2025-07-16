package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyInvalidResponseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyInvalidResponseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyInvalidResponseExceptionUnmarshaller() {
        super(XksProxyInvalidResponseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyInvalidResponseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyInvalidResponseException xksProxyInvalidResponseException = (XksProxyInvalidResponseException) super.unmarshall(jsonErrorResponse);
        xksProxyInvalidResponseException.setErrorCode("XksProxyInvalidResponseException");
        return xksProxyInvalidResponseException;
    }
}
