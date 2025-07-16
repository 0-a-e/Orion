package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class LegacyErrorUnmarshaller implements Unmarshaller<AmazonServiceException, Node> {
    private final Class<? extends AmazonServiceException> exceptionClass;

    public LegacyErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    protected LegacyErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        this.exceptionClass = cls;
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        String asString = XpathUtils.asString("Response/Errors/Error/Message", node);
        String asString2 = XpathUtils.asString("Response/RequestID", node);
        String asString3 = XpathUtils.asString("Response/Errors/Error/Type", node);
        AmazonServiceException amazonServiceException = (AmazonServiceException) this.exceptionClass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{asString});
        amazonServiceException.setErrorCode(parseErrorCode);
        amazonServiceException.setRequestId(asString2);
        if (asString3 == null) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Unknown);
        } else if ("server".equalsIgnoreCase(asString3)) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
        } else if ("client".equalsIgnoreCase(asString3)) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
        }
        return amazonServiceException;
    }

    public String parseErrorCode(Node node) throws Exception {
        return XpathUtils.asString("Response/Errors/Error/Code", node);
    }

    public String getErrorPropertyPath(String str) {
        return "Response/Errors/Error/" + str;
    }
}
