package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/AndroidConfig;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "()V", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/Density;", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidScrollable.android.kt */
final class AndroidConfig implements ScrollConfig {
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    /* renamed from: calculateMouseWheelScroll-8xgXZGE  reason: not valid java name */
    public long m342calculateMouseWheelScroll8xgXZGE(Density density, PointerEvent pointerEvent, long j) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        Offset r9 = Offset.m3551boximpl(Offset.Companion.m3578getZeroF1C5BW0());
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            r9 = Offset.m3551boximpl(Offset.m3567plusMKHz9U(r9.m3572unboximpl(), changes.get(i).m5115getScrollDeltaF1C5BW0()));
        }
        return Offset.m3569timestuRUvjQ(r9.m3572unboximpl(), -density.m6550toPx0680j_4(Dp.m6614constructorimpl((float) 64)));
    }
}
