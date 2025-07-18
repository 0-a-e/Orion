package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.util.DateUtils;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public class QueryStringSigner extends AbstractAWSSigner implements Signer {
    private Date overriddenDate;

    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        sign(request, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, aWSCredentials);
    }

    public void sign(Request<?> request, SignatureVersion signatureVersion, SigningAlgorithm signingAlgorithm, AWSCredentials aWSCredentials) {
        String str;
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            request.addParameter("AWSAccessKeyId", sanitizeCredentials.getAWSAccessKeyId());
            request.addParameter("SignatureVersion", signatureVersion.toString());
            request.addParameter("Timestamp", getFormattedTimestamp(getTimeOffset(request)));
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            if (signatureVersion.equals(SignatureVersion.V1)) {
                str = calculateStringToSignV1(request.getParameters());
            } else if (signatureVersion.equals(SignatureVersion.V2)) {
                request.addParameter("SignatureMethod", signingAlgorithm.toString());
                str = calculateStringToSignV2(request);
            } else {
                throw new AmazonClientException("Invalid Signature Version specified");
            }
            request.addParameter("Signature", signAndBase64Encode(str, sanitizeCredentials.getAWSSecretKey(), signingAlgorithm));
        }
    }

    private String calculateStringToSignV1(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(map);
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    private String calculateStringToSignV2(Request<?> request) {
        URI endpoint = request.getEndpoint();
        Map<String, String> parameters = request.getParameters();
        return "POST\n" + getCanonicalizedEndpoint(endpoint) + "\n" + getCanonicalizedResourcePath(request) + "\n" + getCanonicalizedQueryString(parameters);
    }

    private String getCanonicalizedResourcePath(Request<?> request) {
        String str = "";
        if (request.getEndpoint().getPath() != null) {
            str = str + request.getEndpoint().getPath();
        }
        if (request.getResourcePath() != null) {
            if (str.length() > 0 && !str.endsWith("/") && !request.getResourcePath().startsWith("/")) {
                str = str + "/";
            }
            str = str + request.getResourcePath();
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        return str.startsWith("//") ? str.substring(1) : str;
    }

    private String getFormattedTimestamp(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = this.overriddenDate;
        if (date != null) {
            return simpleDateFormat.format(date);
        }
        return simpleDateFormat.format(getSignatureDate(j));
    }

    /* access modifiers changed from: package-private */
    public void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    /* access modifiers changed from: protected */
    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addParameter("SecurityToken", aWSSessionCredentials.getSessionToken());
    }
}
