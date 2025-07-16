package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyVpcEndpointServiceInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyVpcEndpointServiceInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyVpcEndpointServiceInUseExceptionUnmarshaller() {
        super(XksProxyVpcEndpointServiceInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyVpcEndpointServiceInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyVpcEndpointServiceInUseException xksProxyVpcEndpointServiceInUseException = (XksProxyVpcEndpointServiceInUseException) super.unmarshall(jsonErrorResponse);
        xksProxyVpcEndpointServiceInUseException.setErrorCode("XksProxyVpcEndpointServiceInUseException");
        return xksProxyVpcEndpointServiceInUseException;
    }
}
