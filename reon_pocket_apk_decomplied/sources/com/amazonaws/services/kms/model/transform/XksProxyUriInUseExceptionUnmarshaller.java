package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyUriInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyUriInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyUriInUseExceptionUnmarshaller() {
        super(XksProxyUriInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyUriInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyUriInUseException xksProxyUriInUseException = (XksProxyUriInUseException) super.unmarshall(jsonErrorResponse);
        xksProxyUriInUseException.setErrorCode("XksProxyUriInUseException");
        return xksProxyUriInUseException;
    }
}
