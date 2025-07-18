package com.amazonaws.services.s3.internal;

import com.amazonaws.Request;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.util.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

public class RestUtils {
    private static final List<String> SIGNED_PARAMETERS = Arrays.asList(new String[]{"acl", "torrent", "logging", FirebaseAnalytics.Param.LOCATION, "policy", "requestPayment", "versioning", "versions", "versionId", TransferService.INTENT_KEY_NOTIFICATION, "uploadId", "uploads", "partNumber", "website", "delete", "lifecycle", "tagging", "cors", "restore", "replication", "accelerate", "inventory", "analytics", "metrics", ResponseHeaderOverrides.RESPONSE_HEADER_CACHE_CONTROL, ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_DISPOSITION, ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_ENCODING, ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_LANGUAGE, ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_TYPE, ResponseHeaderOverrides.RESPONSE_HEADER_EXPIRES});

    public static <T> String makeS3CanonicalString(String str, String str2, Request<T> request, String str3) {
        return makeS3CanonicalString(str, str2, request, str3, (Collection<String>) null);
    }

    public static <T> String makeS3CanonicalString(String str, String str2, Request<T> request, String str3, Collection<String> collection) {
        StringBuilder sb = new StringBuilder();
        sb.append(str + "\n");
        Map<String, String> headers = request.getHeaders();
        TreeMap treeMap = new TreeMap();
        if (headers != null && headers.size() > 0) {
            for (Map.Entry next : headers.entrySet()) {
                String str4 = (String) next.getKey();
                String str5 = (String) next.getValue();
                if (str4 != null) {
                    String lowerCase = StringUtils.lowerCase(str4);
                    if ("content-type".equals(lowerCase) || "content-md5".equals(lowerCase) || "date".equals(lowerCase) || lowerCase.startsWith(Headers.AMAZON_PREFIX)) {
                        treeMap.put(lowerCase, str5);
                    }
                }
            }
        }
        if (treeMap.containsKey(Headers.S3_ALTERNATE_DATE)) {
            treeMap.put("date", "");
        }
        if (str3 != null) {
            treeMap.put("date", str3);
        }
        if (!treeMap.containsKey("content-type")) {
            treeMap.put("content-type", "");
        }
        if (!treeMap.containsKey("content-md5")) {
            treeMap.put("content-md5", "");
        }
        for (Map.Entry next2 : request.getParameters().entrySet()) {
            if (((String) next2.getKey()).startsWith(Headers.AMAZON_PREFIX)) {
                treeMap.put(next2.getKey(), next2.getValue());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String str6 = (String) entry.getKey();
            String str7 = (String) entry.getValue();
            if (str6.startsWith(Headers.AMAZON_PREFIX)) {
                sb.append(str6);
                sb.append(':');
                if (str7 != null) {
                    sb.append(str7);
                }
            } else if (str7 != null) {
                sb.append(str7);
            }
            sb.append("\n");
        }
        sb.append(str2);
        String[] strArr = (String[]) request.getParameters().keySet().toArray(new String[request.getParameters().size()]);
        Arrays.sort(strArr);
        char c = '?';
        for (String str8 : strArr) {
            if (SIGNED_PARAMETERS.contains(str8) || (collection != null && collection.contains(str8))) {
                if (sb.length() == 0) {
                    sb.append(c);
                }
                sb.append(str8);
                String str9 = request.getParameters().get(str8);
                if (str9 != null) {
                    sb.append("=");
                    sb.append(str9);
                }
                c = Typography.amp;
            }
        }
        return sb.toString();
    }
}
