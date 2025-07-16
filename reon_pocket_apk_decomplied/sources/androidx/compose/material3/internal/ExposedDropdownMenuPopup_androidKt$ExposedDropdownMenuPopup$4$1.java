package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.android.kt */
final class ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$4$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ PopupLayout $popupLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$4$1(PopupLayout popupLayout) {
        super(1);
        this.$popupLayout = popupLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        Intrinsics.checkNotNull(parentLayoutCoordinates);
        long r0 = parentLayoutCoordinates.m5318getSizeYbymL2g();
        long positionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
        this.$popupLayout.setParentBounds(IntRectKt.m6780IntRectVbeCjmY(IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3562getXimpl(positionInWindow)), MathKt.roundToInt(Offset.m3563getYimpl(positionInWindow))), r0));
        this.$popupLayout.updatePosition();
    }
}
