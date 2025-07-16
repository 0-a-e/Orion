package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyVpcEndpointServiceNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyVpcEndpointServiceNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyVpcEndpointServiceNotFoundExceptionUnmarshaller() {
        super(XksProxyVpcEndpointServiceNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyVpcEndpointServiceNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyVpcEndpointServiceNotFoundException xksProxyVpcEndpointServiceNotFoundException = (XksProxyVpcEndpointServiceNotFoundException) super.unmarshall(jsonErrorResponse);
        xksProxyVpcEndpointServiceNotFoundException.setErrorCode("XksProxyVpcEndpointServiceNotFoundException");
        return xksProxyVpcEndpointServiceNotFoundException;
    }
}
