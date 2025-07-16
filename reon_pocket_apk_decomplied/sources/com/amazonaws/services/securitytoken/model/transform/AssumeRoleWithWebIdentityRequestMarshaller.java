package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class AssumeRoleWithWebIdentityRequestMarshaller implements Marshaller<Request<AssumeRoleWithWebIdentityRequest>, AssumeRoleWithWebIdentityRequest> {
    public Request<AssumeRoleWithWebIdentityRequest> marshall(AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest) {
        if (assumeRoleWithWebIdentityRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(assumeRoleWithWebIdentityRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter(JsonDocumentFields.ACTION, "AssumeRoleWithWebIdentity");
            defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
            if (assumeRoleWithWebIdentityRequest.getRoleArn() != null) {
                defaultRequest.addParameter("RoleArn", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getRoleArn()));
            }
            if (assumeRoleWithWebIdentityRequest.getRoleSessionName() != null) {
                defaultRequest.addParameter("RoleSessionName", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getRoleSessionName()));
            }
            if (assumeRoleWithWebIdentityRequest.getWebIdentityToken() != null) {
                defaultRequest.addParameter("WebIdentityToken", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getWebIdentityToken()));
            }
            if (assumeRoleWithWebIdentityRequest.getProviderId() != null) {
                defaultRequest.addParameter("ProviderId", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getProviderId()));
            }
            if (assumeRoleWithWebIdentityRequest.getPolicyArns() != null) {
                int i = 1;
                for (PolicyDescriptorType next : assumeRoleWithWebIdentityRequest.getPolicyArns()) {
                    String str = "PolicyArns.member." + i;
                    if (next != null) {
                        PolicyDescriptorTypeStaxMarshaller.getInstance().marshall(next, defaultRequest, str + InstructionFileId.DOT);
                    }
                    i++;
                }
            }
            if (assumeRoleWithWebIdentityRequest.getPolicy() != null) {
                defaultRequest.addParameter("Policy", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getPolicy()));
            }
            if (assumeRoleWithWebIdentityRequest.getDurationSeconds() != null) {
                defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(assumeRoleWithWebIdentityRequest.getDurationSeconds()));
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(AssumeRoleWithWebIdentityRequest)");
    }
}
