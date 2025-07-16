package jp.co.sony.reonpocket.util;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, d2 = {"asArrayList", "", "T", "Landroid/util/SparseArray;", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: SpaceArrayExtension.kt */
public final class SpaceArrayExtensionKt {
    public static final <T> List<T> asArrayList(SparseArray<T> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(sparseArray.valueAt(i));
        }
        return CollectionsKt.toList(arrayList);
    }
}
