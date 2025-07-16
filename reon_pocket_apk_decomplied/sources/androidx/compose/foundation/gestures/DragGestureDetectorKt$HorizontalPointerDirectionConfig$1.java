package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"androidx/compose/foundation/gestures/DragGestureDetectorKt$HorizontalPointerDirectionConfig$1", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "calculateDeltaChange", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "calculateDeltaChange-k-4lQ0M", "(J)F", "calculatePostSlopOffset", "totalPositionChange", "touchSlop", "calculatePostSlopOffset-8S9VItk", "(JF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragGestureDetector.kt */
public final class DragGestureDetectorKt$HorizontalPointerDirectionConfig$1 implements PointerDirectionConfig {
    DragGestureDetectorKt$HorizontalPointerDirectionConfig$1() {
    }

    /* renamed from: calculateDeltaChange-k-4lQ0M  reason: not valid java name */
    public float m380calculateDeltaChangek4lQ0M(long j) {
        return Math.abs(Offset.m3562getXimpl(j));
    }

    /* renamed from: calculatePostSlopOffset-8S9VItk  reason: not valid java name */
    public long m381calculatePostSlopOffset8S9VItk(long j, float f) {
        return OffsetKt.Offset(Offset.m3562getXimpl(j) - (Math.signum(Offset.m3562getXimpl(j)) * f), Offset.m3563getYimpl(j));
    }
}
