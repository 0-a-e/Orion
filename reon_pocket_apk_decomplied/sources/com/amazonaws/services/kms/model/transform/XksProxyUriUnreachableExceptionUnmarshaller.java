package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyUriUnreachableException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyUriUnreachableExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyUriUnreachableExceptionUnmarshaller() {
        super(XksProxyUriUnreachableException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyUriUnreachableException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyUriUnreachableException xksProxyUriUnreachableException = (XksProxyUriUnreachableException) super.unmarshall(jsonErrorResponse);
        xksProxyUriUnreachableException.setErrorCode("XksProxyUriUnreachableException");
        return xksProxyUriUnreachableException;
    }
}
