package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksKeyInvalidConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksKeyInvalidConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksKeyInvalidConfigurationExceptionUnmarshaller() {
        super(XksKeyInvalidConfigurationException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksKeyInvalidConfigurationException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksKeyInvalidConfigurationException xksKeyInvalidConfigurationException = (XksKeyInvalidConfigurationException) super.unmarshall(jsonErrorResponse);
        xksKeyInvalidConfigurationException.setErrorCode("XksKeyInvalidConfigurationException");
        return xksKeyInvalidConfigurationException;
    }
}
