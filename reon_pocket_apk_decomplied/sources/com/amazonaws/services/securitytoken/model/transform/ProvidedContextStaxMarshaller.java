package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.ProvidedContext;
import com.amazonaws.util.StringUtils;

class ProvidedContextStaxMarshaller {
    private static ProvidedContextStaxMarshaller instance;

    ProvidedContextStaxMarshaller() {
    }

    public void marshall(ProvidedContext providedContext, Request<?> request, String str) {
        if (providedContext.getProviderArn() != null) {
            request.addParameter(str + "ProviderArn", StringUtils.fromString(providedContext.getProviderArn()));
        }
        if (providedContext.getContextAssertion() != null) {
            request.addParameter(str + "ContextAssertion", StringUtils.fromString(providedContext.getContextAssertion()));
        }
    }

    public static ProvidedContextStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new ProvidedContextStaxMarshaller();
        }
        return instance;
    }
}
