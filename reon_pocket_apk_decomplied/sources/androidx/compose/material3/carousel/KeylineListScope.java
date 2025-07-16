package androidx.compose.material3.carousel;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScope;", "", "add", "", "size", "", "isAnchor", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Keyline.kt */
public interface KeylineListScope {
    void add(float f, boolean z);

    /* renamed from: androidx.compose.material3.carousel.KeylineListScope$-CC  reason: invalid class name */
    /* compiled from: Keyline.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void add$default(KeylineListScope keylineListScope, float f, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                keylineListScope.add(f, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
        }
    }
}
