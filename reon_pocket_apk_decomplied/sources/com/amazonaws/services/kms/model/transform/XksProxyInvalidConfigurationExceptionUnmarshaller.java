package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyInvalidConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyInvalidConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyInvalidConfigurationExceptionUnmarshaller() {
        super(XksProxyInvalidConfigurationException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyInvalidConfigurationException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyInvalidConfigurationException xksProxyInvalidConfigurationException = (XksProxyInvalidConfigurationException) super.unmarshall(jsonErrorResponse);
        xksProxyInvalidConfigurationException.setErrorCode("XksProxyInvalidConfigurationException");
        return xksProxyInvalidConfigurationException;
    }
}
