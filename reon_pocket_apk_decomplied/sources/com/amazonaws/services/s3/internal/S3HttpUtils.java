package com.amazonaws.services.s3.internal;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.co.sony.reonpocket.data.interactor.UserBehaviorInteractor;

public final class S3HttpUtils {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Pattern ENCODED_CHARACTERS_PATTERN = Pattern.compile(Pattern.quote("+") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("*") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%7E") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%2F") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%3A") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%27") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%28") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%29") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%21") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%5B") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%5D") + UserBehaviorInteractor.AutoRemoveQueue.DELIMIT + Pattern.quote("%24"));

    public static String urlEncode(String str, boolean z) {
        if (str == null) {
            return "";
        }
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(encode);
            StringBuffer stringBuffer = new StringBuffer(encode.length());
            while (matcher.find()) {
                String group = matcher.group(0);
                if ("+".equals(group)) {
                    group = " ";
                } else if ("*".equals(group)) {
                    group = "%2A";
                } else if ("%7E".equals(group)) {
                    group = "~";
                } else if (z && "%2F".equals(group)) {
                    group = "/";
                } else if (z && "%3A".equals(group)) {
                    group = ":";
                } else if (z && "%27".equals(group)) {
                    group = "'";
                } else if (z && "%28".equals(group)) {
                    group = "(";
                } else if (z && "%29".equals(group)) {
                    group = ")";
                } else if (z && "%21".equals(group)) {
                    group = "!";
                } else if (z && "%5B".equals(group)) {
                    group = "[";
                } else if (z && "%5D".equals(group)) {
                    group = "]";
                }
                matcher.appendReplacement(stringBuffer, group);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String urlDecode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
