package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class GenerateDataKeyWithoutPlaintextRequestMarshaller implements Marshaller<Request<GenerateDataKeyWithoutPlaintextRequest>, GenerateDataKeyWithoutPlaintextRequest> {
    public Request<GenerateDataKeyWithoutPlaintextRequest> marshall(GenerateDataKeyWithoutPlaintextRequest generateDataKeyWithoutPlaintextRequest) {
        if (generateDataKeyWithoutPlaintextRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(generateDataKeyWithoutPlaintextRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.GenerateDataKeyWithoutPlaintext");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (generateDataKeyWithoutPlaintextRequest.getKeyId() != null) {
                    String keyId = generateDataKeyWithoutPlaintextRequest.getKeyId();
                    jsonWriter.name("KeyId");
                    jsonWriter.value(keyId);
                }
                if (generateDataKeyWithoutPlaintextRequest.getEncryptionContext() != null) {
                    Map<String, String> encryptionContext = generateDataKeyWithoutPlaintextRequest.getEncryptionContext();
                    jsonWriter.name("EncryptionContext");
                    jsonWriter.beginObject();
                    for (Map.Entry next : encryptionContext.entrySet()) {
                        String str = (String) next.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (generateDataKeyWithoutPlaintextRequest.getKeySpec() != null) {
                    String keySpec = generateDataKeyWithoutPlaintextRequest.getKeySpec();
                    jsonWriter.name("KeySpec");
                    jsonWriter.value(keySpec);
                }
                if (generateDataKeyWithoutPlaintextRequest.getNumberOfBytes() != null) {
                    Integer numberOfBytes = generateDataKeyWithoutPlaintextRequest.getNumberOfBytes();
                    jsonWriter.name("NumberOfBytes");
                    jsonWriter.value((Number) numberOfBytes);
                }
                if (generateDataKeyWithoutPlaintextRequest.getGrantTokens() != null) {
                    List<String> grantTokens = generateDataKeyWithoutPlaintextRequest.getGrantTokens();
                    jsonWriter.name("GrantTokens");
                    jsonWriter.beginArray();
                    for (String next2 : grantTokens) {
                        if (next2 != null) {
                            jsonWriter.value(next2);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (generateDataKeyWithoutPlaintextRequest.getDryRun() != null) {
                    Boolean dryRun = generateDataKeyWithoutPlaintextRequest.getDryRun();
                    jsonWriter.name("DryRun");
                    jsonWriter.value(dryRun.booleanValue());
                }
                jsonWriter.endObject();
                jsonWriter.close();
                String stringWriter2 = stringWriter.toString();
                byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
                defaultRequest.setContent(new StringInputStream(stringWriter2));
                defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
                if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                    defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
                }
                return defaultRequest;
            } catch (Throwable th) {
                throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
            }
        } else {
            throw new AmazonClientException("Invalid argument passed to marshall(GenerateDataKeyWithoutPlaintextRequest)");
        }
    }
}
