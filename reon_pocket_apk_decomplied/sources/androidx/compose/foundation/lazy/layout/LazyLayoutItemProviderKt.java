package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0001¨\u0006\u0006"}, d2 = {"findIndexByKey", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "key", "", "lastKnownIndex", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemProvider.kt */
public final class LazyLayoutItemProviderKt {
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r1 = r1.getIndex(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int findIndexByKey(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r1, java.lang.Object r2, int r3) {
        /*
            if (r2 == 0) goto L_0x0022
            int r0 = r1.getItemCount()
            if (r0 != 0) goto L_0x0009
            goto L_0x0022
        L_0x0009:
            int r0 = r1.getItemCount()
            if (r3 >= r0) goto L_0x001a
            java.lang.Object r0 = r1.getKey(r3)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x001a
            return r3
        L_0x001a:
            int r1 = r1.getIndex(r2)
            r2 = -1
            if (r1 == r2) goto L_0x0022
            return r1
        L_0x0022:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt.findIndexByKey(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider, java.lang.Object, int):int");
    }
}
