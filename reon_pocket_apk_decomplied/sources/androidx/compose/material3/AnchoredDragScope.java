package androidx.compose.material3;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/AnchoredDragScope;", "", "dragTo", "", "newOffset", "", "lastKnownVelocity", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public interface AnchoredDragScope {
    void dragTo(float f, float f2);

    /* renamed from: androidx.compose.material3.AnchoredDragScope$-CC  reason: invalid class name */
    /* compiled from: AnchoredDraggable.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void dragTo$default(AnchoredDragScope anchoredDragScope, float f, float f2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f2 = 0.0f;
                }
                anchoredDragScope.dragTo(f, f2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dragTo");
        }
    }
}
