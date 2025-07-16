package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyIncorrectAuthenticationCredentialException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyIncorrectAuthenticationCredentialExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyIncorrectAuthenticationCredentialExceptionUnmarshaller() {
        super(XksProxyIncorrectAuthenticationCredentialException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyIncorrectAuthenticationCredentialException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyIncorrectAuthenticationCredentialException xksProxyIncorrectAuthenticationCredentialException = (XksProxyIncorrectAuthenticationCredentialException) super.unmarshall(jsonErrorResponse);
        xksProxyIncorrectAuthenticationCredentialException.setErrorCode("XksProxyIncorrectAuthenticationCredentialException");
        return xksProxyIncorrectAuthenticationCredentialException;
    }
}
