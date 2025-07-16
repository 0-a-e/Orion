package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyUriEndpointInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyUriEndpointInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyUriEndpointInUseExceptionUnmarshaller() {
        super(XksProxyUriEndpointInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyUriEndpointInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyUriEndpointInUseException xksProxyUriEndpointInUseException = (XksProxyUriEndpointInUseException) super.unmarshall(jsonErrorResponse);
        xksProxyUriEndpointInUseException.setErrorCode("XksProxyUriEndpointInUseException");
        return xksProxyUriEndpointInUseException;
    }
}
