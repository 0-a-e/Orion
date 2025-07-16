package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.ProvidedContext;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

class ProvidedContextStaxUnmarshaller implements Unmarshaller<ProvidedContext, StaxUnmarshallerContext> {
    private static ProvidedContextStaxUnmarshaller instance;

    ProvidedContextStaxUnmarshaller() {
    }

    public ProvidedContext unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ProvidedContext providedContext = new ProvidedContext();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i = currentDepth + 3;
        }
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent != 1) {
                if (nextEvent != 2) {
                    if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                        break;
                    }
                } else if (staxUnmarshallerContext.testExpression("ProviderArn", i)) {
                    providedContext.setProviderArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ContextAssertion", i)) {
                    providedContext.setContextAssertion(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return providedContext;
    }

    public static ProvidedContextStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ProvidedContextStaxUnmarshaller();
        }
        return instance;
    }
}
