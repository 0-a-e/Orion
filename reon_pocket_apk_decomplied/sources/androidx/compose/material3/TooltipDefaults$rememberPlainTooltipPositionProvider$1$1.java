package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"androidx/compose/material3/TooltipDefaults$rememberPlainTooltipPositionProvider$1$1", "Landroidx/compose/ui/window/PopupPositionProvider;", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
public final class TooltipDefaults$rememberPlainTooltipPositionProvider$1$1 implements PopupPositionProvider {
    final /* synthetic */ int $tooltipAnchorSpacing;

    TooltipDefaults$rememberPlainTooltipPositionProvider$1$1(int i) {
        this.$tooltipAnchorSpacing = i;
    }

    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long m2602calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        int left = intRect.getLeft() + ((intRect.getWidth() - IntSize.m6790getWidthimpl(j2)) / 2);
        int top = (intRect.getTop() - IntSize.m6789getHeightimpl(j2)) - this.$tooltipAnchorSpacing;
        if (top < 0) {
            top = this.$tooltipAnchorSpacing + intRect.getBottom();
        }
        return IntOffsetKt.IntOffset(left, top);
    }
}
