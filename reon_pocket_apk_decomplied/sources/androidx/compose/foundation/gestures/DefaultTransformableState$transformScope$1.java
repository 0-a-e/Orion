package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"androidx/compose/foundation/gestures/DefaultTransformableState$transformScope$1", "Landroidx/compose/foundation/gestures/TransformScope;", "transformBy", "", "zoomChange", "", "panChange", "Landroidx/compose/ui/geometry/Offset;", "rotationChange", "transformBy-d-4ec7I", "(FJF)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformableState.kt */
public final class DefaultTransformableState$transformScope$1 implements TransformScope {
    final /* synthetic */ DefaultTransformableState this$0;

    DefaultTransformableState$transformScope$1(DefaultTransformableState defaultTransformableState) {
        this.this$0 = defaultTransformableState;
    }

    /* renamed from: transformBy-d-4ec7I  reason: not valid java name */
    public void m353transformByd4ec7I(float f, long j, float f2) {
        this.this$0.getOnTransformation().invoke(Float.valueOf(f), Offset.m3551boximpl(j), Float.valueOf(f2));
    }
}
