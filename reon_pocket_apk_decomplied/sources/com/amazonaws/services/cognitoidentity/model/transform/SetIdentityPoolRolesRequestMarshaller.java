package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.RoleMapping;
import com.amazonaws.services.cognitoidentity.model.SetIdentityPoolRolesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

public class SetIdentityPoolRolesRequestMarshaller implements Marshaller<Request<SetIdentityPoolRolesRequest>, SetIdentityPoolRolesRequest> {
    public Request<SetIdentityPoolRolesRequest> marshall(SetIdentityPoolRolesRequest setIdentityPoolRolesRequest) {
        if (setIdentityPoolRolesRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(setIdentityPoolRolesRequest, "AmazonCognitoIdentity");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityService.SetIdentityPoolRoles");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (setIdentityPoolRolesRequest.getIdentityPoolId() != null) {
                    String identityPoolId = setIdentityPoolRolesRequest.getIdentityPoolId();
                    jsonWriter.name("IdentityPoolId");
                    jsonWriter.value(identityPoolId);
                }
                if (setIdentityPoolRolesRequest.getRoles() != null) {
                    Map<String, String> roles = setIdentityPoolRolesRequest.getRoles();
                    jsonWriter.name("Roles");
                    jsonWriter.beginObject();
                    for (Map.Entry next : roles.entrySet()) {
                        String str = (String) next.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (setIdentityPoolRolesRequest.getRoleMappings() != null) {
                    Map<String, RoleMapping> roleMappings = setIdentityPoolRolesRequest.getRoleMappings();
                    jsonWriter.name("RoleMappings");
                    jsonWriter.beginObject();
                    for (Map.Entry next2 : roleMappings.entrySet()) {
                        RoleMapping roleMapping = (RoleMapping) next2.getValue();
                        if (roleMapping != null) {
                            jsonWriter.name((String) next2.getKey());
                            RoleMappingJsonMarshaller.getInstance().marshall(roleMapping, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
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
            throw new AmazonClientException("Invalid argument passed to marshall(SetIdentityPoolRolesRequest)");
        }
    }
}
