package jp.co.sony.reonpocket.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a3\u0010\u0004\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000b\u001a1\u0010\f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"toList", "", "T", "Lorg/json/JSONArray;", "value", "Lorg/json/JSONObject;", "key", "", "hasCheck", "", "nullCheck", "(Lorg/json/JSONObject;Ljava/lang/String;ZZ)Ljava/lang/Object;", "valueOrThrow", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: JSONObjectExtension.kt */
public final class JSONObjectExtensionKt {
    public static /* synthetic */ Object value$default(JSONObject jSONObject, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return value(jSONObject, str, z, z2);
    }

    public static final <T> T value(JSONObject jSONObject, String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        if (((!z || !jSONObject.has(str)) && z) || ((!z2 || jSONObject.isNull(str)) && z2)) {
            return null;
        }
        return jSONObject.get(str);
    }

    public static /* synthetic */ Object valueOrThrow$default(JSONObject jSONObject, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return valueOrThrow(jSONObject, str, z, z2);
    }

    public static final <T> T valueOrThrow(JSONObject jSONObject, String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        T value = value(jSONObject, str, z, z2);
        if (value != null) {
            return value;
        }
        throw new JSONException("not has " + str);
    }

    public static final /* synthetic */ <T> List<T> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        JSONArray jSONArray2 = jSONArray;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.reifiedOperationMarker(1, "T");
            Object obj2 = obj;
            arrayList.add(obj);
        }
        return arrayList;
    }
}
