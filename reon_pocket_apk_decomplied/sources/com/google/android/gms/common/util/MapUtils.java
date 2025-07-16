package com.google.android.gms.common.util;

import com.amazonaws.services.s3.internal.Constants;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class MapUtils {
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String next : hashMap.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str = hashMap.get(next);
            sb.append("\"");
            sb.append(next);
            sb.append("\":");
            if (str == null) {
                sb.append(Constants.NULL_VERSION_ID);
            } else {
                sb.append("\"");
                sb.append(str);
                sb.append("\"");
            }
            z = false;
        }
        sb.append("}");
    }
}
