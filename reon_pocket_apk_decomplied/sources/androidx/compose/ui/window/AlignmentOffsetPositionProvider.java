package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/window/AlignmentOffsetPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getOffset-nOcc-ac", "()J", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Popup.kt */
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final long offset;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment2, j);
    }

    private AlignmentOffsetPositionProvider(Alignment alignment2, long j) {
        this.alignment = alignment2;
        this.offset = j;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public final long m6874getOffsetnOccac() {
        return this.offset;
    }

    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long m6873calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        LayoutDirection layoutDirection2 = layoutDirection;
        long r8 = this.alignment.m3417alignKFBX0sM(IntSize.Companion.m6795getZeroYbymL2g(), intRect.m6774getSizeYbymL2g(), layoutDirection2);
        long r11 = this.alignment.m3417alignKFBX0sM(IntSize.Companion.m6795getZeroYbymL2g(), j2, layoutDirection2);
        long IntOffset = IntOffsetKt.IntOffset(-IntOffset.m6748getXimpl(r11), -IntOffset.m6749getYimpl(r11));
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.m6749getYimpl(this.offset));
        long r2 = intRect.m6776getTopLeftnOccac();
        long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r2) + IntOffset.m6748getXimpl(r8), IntOffset.m6749getYimpl(r2) + IntOffset.m6749getYimpl(r8));
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset3) + IntOffset.m6748getXimpl(IntOffset), IntOffset.m6749getYimpl(IntOffset3) + IntOffset.m6749getYimpl(IntOffset));
        return IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset4) + IntOffset.m6748getXimpl(IntOffset2), IntOffset.m6749getYimpl(IntOffset4) + IntOffset.m6749getYimpl(IntOffset2));
    }
}
