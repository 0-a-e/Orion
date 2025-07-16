package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Badge.kt */
final class BadgeKt$BadgedBox$2$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ MutableFloatState $greatGrandParentAbsoluteRight$delegate;
    final /* synthetic */ MutableFloatState $greatGrandParentAbsoluteTop$delegate;
    final /* synthetic */ MutableFloatState $layoutAbsoluteLeft$delegate;
    final /* synthetic */ MutableFloatState $layoutAbsoluteTop$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BadgeKt$BadgedBox$2$1(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, MutableFloatState mutableFloatState3, MutableFloatState mutableFloatState4) {
        super(1);
        this.$layoutAbsoluteLeft$delegate = mutableFloatState;
        this.$layoutAbsoluteTop$delegate = mutableFloatState2;
        this.$greatGrandParentAbsoluteRight$delegate = mutableFloatState3;
        this.$greatGrandParentAbsoluteTop$delegate = mutableFloatState4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0020, code lost:
        r4 = r4.getParentLayoutCoordinates();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.ui.layout.LayoutCoordinates r4) {
        /*
            r3 = this;
            androidx.compose.runtime.MutableFloatState r0 = r3.$layoutAbsoluteLeft$delegate
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInWindow(r4)
            float r1 = r1.getLeft()
            androidx.compose.material3.BadgeKt.BadgedBox$lambda$2(r0, r1)
            androidx.compose.runtime.MutableFloatState r0 = r3.$layoutAbsoluteTop$delegate
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInWindow(r4)
            float r1 = r1.getTop()
            androidx.compose.material3.BadgeKt.BadgedBox$lambda$5(r0, r1)
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.getParentLayoutCoordinates()
            if (r4 == 0) goto L_0x002b
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.getParentLayoutCoordinates()
            if (r4 == 0) goto L_0x002b
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.getParentCoordinates()
            goto L_0x002c
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 == 0) goto L_0x0048
            androidx.compose.runtime.MutableFloatState r0 = r3.$greatGrandParentAbsoluteRight$delegate
            androidx.compose.runtime.MutableFloatState r1 = r3.$greatGrandParentAbsoluteTop$delegate
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInWindow(r4)
            float r2 = r2.getRight()
            androidx.compose.material3.BadgeKt.BadgedBox$lambda$8(r0, r2)
            androidx.compose.ui.geometry.Rect r4 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInWindow(r4)
            float r4 = r4.getTop()
            androidx.compose.material3.BadgeKt.BadgedBox$lambda$11(r1, r4)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BadgeKt$BadgedBox$2$1.invoke(androidx.compose.ui.layout.LayoutCoordinates):void");
    }
}
