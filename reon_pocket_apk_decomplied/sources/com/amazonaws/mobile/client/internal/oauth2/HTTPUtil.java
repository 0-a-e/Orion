package com.amazonaws.mobile.client.internal.oauth2;

import com.amazonaws.mobile.client.internal.oauth2.OAuth2Constants;
import com.amazonaws.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OAuth2Client */
class HTTPUtil {
    HTTPUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String httpPost(java.net.URL r5, java.util.Map<java.lang.String, java.lang.String> r6, java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8) throws java.lang.Exception {
        /*
            java.lang.String r0 = "UTF-8"
            if (r5 == 0) goto L_0x0131
            if (r7 == 0) goto L_0x0131
            int r1 = r7.size()
            r2 = 1
            if (r1 < r2) goto L_0x0131
            java.net.URLConnection r5 = r5.openConnection()
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5
            com.amazonaws.http.TLS12SocketFactory.fixTLSPre21(r5)
            r1 = 0
            java.lang.String r3 = "POST"
            r5.setRequestMethod(r3)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r5.setDoOutput(r2)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.util.Set r6 = r6.entrySet()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
        L_0x0027:
            boolean r3 = r6.hasNext()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            if (r3 == 0) goto L_0x0043
            java.lang.Object r3 = r6.next()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r5.addRequestProperty(r4, r3)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            goto L_0x0027
        L_0x0043:
            java.lang.String r6 = "x-amz-user-agent"
            java.lang.String r3 = "AWSMobileClient"
            if (r8 == 0) goto L_0x004b
            r4 = r8
            goto L_0x004c
        L_0x004b:
            r4 = r3
        L_0x004c:
            r5.addRequestProperty(r6, r4)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r6 = "User-Agent"
            if (r8 == 0) goto L_0x0054
            goto L_0x006c
        L_0x0054:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r8.<init>()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r4 = r5.getRequestProperty(r6)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r8.append(r4)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r4 = " "
            r8.append(r4)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r8.append(r3)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
        L_0x006c:
            r5.setRequestProperty(r6, r8)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r6.<init>()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            int r8 = r7.size()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.util.Set r7 = r7.entrySet()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
        L_0x0080:
            boolean r3 = r7.hasNext()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            if (r3 == 0) goto L_0x00b6
            java.lang.Object r3 = r7.next()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r0)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r6.append(r4)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r4 = 61
            r6.append(r4)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r0)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r6.append(r3)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            int r3 = r8 + -1
            if (r8 <= r2) goto L_0x00b4
            r8 = 38
            r6.append(r8)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
        L_0x00b4:
            r8 = r3
            goto L_0x0080
        L_0x00b6:
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.io.DataOutputStream r7 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.io.OutputStream r8 = r5.getOutputStream()     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r7.writeBytes(r6)     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            r7.flush()     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            r5.getHeaderFields()     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            int r6 = r5.getResponseCode()     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r6 < r8) goto L_0x010d
            r8 = 500(0x1f4, float:7.0E-43)
            if (r6 >= r8) goto L_0x010d
            r8 = 400(0x190, float:5.6E-43)
            if (r6 >= r8) goto L_0x00e1
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            goto L_0x00e5
        L_0x00e1:
            java.io.InputStream r5 = r5.getErrorStream()     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
        L_0x00e5:
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            r8.<init>(r5)     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            r5.<init>()     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
        L_0x00f4:
            java.lang.String r8 = r6.readLine()     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            if (r8 == 0) goto L_0x00fe
            r5.append(r8)     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            goto L_0x00f4
        L_0x00fe:
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            r7.close()
            r6.close()
            return r5
        L_0x0109:
            r5 = move-exception
            goto L_0x0119
        L_0x010b:
            r5 = move-exception
            goto L_0x011d
        L_0x010d:
            com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthServiceException r6 = new com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthServiceException     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            java.lang.String r5 = r5.getResponseMessage()     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            throw r6     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
        L_0x0117:
            r5 = move-exception
            r6 = r1
        L_0x0119:
            r1 = r7
            goto L_0x0126
        L_0x011b:
            r5 = move-exception
            r6 = r1
        L_0x011d:
            r1 = r7
            goto L_0x0124
        L_0x011f:
            r5 = move-exception
            r6 = r1
            goto L_0x0126
        L_0x0122:
            r5 = move-exception
            r6 = r1
        L_0x0124:
            throw r5     // Catch:{ all -> 0x0125 }
        L_0x0125:
            r5 = move-exception
        L_0x0126:
            if (r1 == 0) goto L_0x012b
            r1.close()
        L_0x012b:
            if (r6 == 0) goto L_0x0130
            r6.close()
        L_0x0130:
            throw r5
        L_0x0131:
            com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthClientException r5 = new com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthClientException
            java.lang.String r6 = "Invalid http request parameters"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.internal.oauth2.HTTPUtil.httpPost(java.net.URL, java.util.Map, java.util.Map, java.lang.String):java.lang.String");
    }

    public static OAuth2Tokens parseHttpResponse(String str) throws JSONException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid (null) response from Amazon Cognito Auth endpoint");
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR.toString(), (String) null);
        String optString2 = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR_DESCRIPTION.toString(), (String) null);
        String optString3 = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR_URI.toString(), (String) null);
        if (optString == null) {
            String optString4 = jSONObject.optString(OAuth2Constants.TokenResponseFields.EXPIRES_IN.toString());
            return new OAuth2Tokens(jSONObject.getString(OAuth2Constants.TokenResponseFields.ACCESS_TOKEN.toString()), jSONObject.optString(OAuth2Constants.TokenResponseFields.ID_TOKEN.toString(), (String) null), jSONObject.optString(OAuth2Constants.TokenResponseFields.REFRESH_TOKEN.toString(), (String) null), jSONObject.getString(OAuth2Constants.TokenResponseFields.TOKEN_TYPE.toString()), !StringUtils.isBlank(optString4) ? Long.valueOf(Long.parseLong(optString4)) : null, Long.valueOf(System.currentTimeMillis() / 1000), jSONObject.optString(OAuth2Constants.SCOPES, (String) null));
        }
        throw new OAuth2Exception("Failed to exchange code for tokens", optString, optString2, optString3);
    }
}
