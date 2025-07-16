package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/selection/HandlePositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "handleReferencePoint", "Landroidx/compose/foundation/text/selection/HandleReferencePoint;", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "(Landroidx/compose/foundation/text/selection/HandleReferencePoint;Landroidx/compose/foundation/text/selection/OffsetProvider;)V", "prevPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
public final class HandlePositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final HandleReferencePoint handleReferencePoint;
    private final OffsetProvider positionProvider;
    private long prevPosition = Offset.Companion.m3578getZeroF1C5BW0();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidSelectionHandles.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.foundation.text.selection.HandleReferencePoint[] r0 = androidx.compose.foundation.text.selection.HandleReferencePoint.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.selection.HandleReferencePoint r1 = androidx.compose.foundation.text.selection.HandleReferencePoint.TopLeft     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.selection.HandleReferencePoint r1 = androidx.compose.foundation.text.selection.HandleReferencePoint.TopMiddle     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.selection.HandleReferencePoint r1 = androidx.compose.foundation.text.selection.HandleReferencePoint.TopRight     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.HandlePositionProvider.WhenMappings.<clinit>():void");
        }
    }

    public HandlePositionProvider(HandleReferencePoint handleReferencePoint2, OffsetProvider offsetProvider) {
        this.handleReferencePoint = handleReferencePoint2;
        this.positionProvider = offsetProvider;
    }

    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long m1211calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        int i;
        long r3 = this.positionProvider.m1222provideF1C5BW0();
        if (!OffsetKt.m3581isSpecifiedk4lQ0M(r3)) {
            r3 = this.prevPosition;
        }
        this.prevPosition = r3;
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.handleReferencePoint.ordinal()];
        if (i2 == 1) {
            i = 0;
        } else if (i2 == 2) {
            i = IntSize.m6790getWidthimpl(j2) / 2;
        } else if (i2 == 3) {
            i = IntSize.m6790getWidthimpl(j2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        long IntOffset = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3562getXimpl(r3)), MathKt.roundToInt(Offset.m3563getYimpl(r3)));
        return IntOffsetKt.IntOffset((intRect.getLeft() + IntOffset.m6748getXimpl(IntOffset)) - i, intRect.getTop() + IntOffset.m6749getYimpl(IntOffset));
    }
}
