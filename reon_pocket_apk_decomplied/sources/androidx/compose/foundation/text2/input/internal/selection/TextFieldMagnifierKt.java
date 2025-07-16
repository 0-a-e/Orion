package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.foundation.text2.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;J)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.kt */
public final class TextFieldMagnifierKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldMagnifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.foundation.text.Handle[] r0 = androidx.compose.foundation.text.Handle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.Cursor     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionStart     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionEnd     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldMagnifierKt.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-hUlJWOE  reason: not valid java name */
    public static final long m1440calculateSelectionMagnifierCenterAndroidhUlJWOE(TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, long j) {
        int i;
        long r0 = textFieldSelectionState.m1462getHandleDragPositionF1C5BW0();
        if (OffsetKt.m3583isUnspecifiedk4lQ0M(r0) || transformedTextFieldState.getText().length() == 0) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        long r2 = transformedTextFieldState.getText().m1346getSelectionInCharsd9O1mEE();
        Handle draggingHandle = textFieldSelectionState.getDraggingHandle();
        int i2 = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i2 == -1) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        if (i2 == 1 || i2 == 2) {
            i = TextRange.m6042getStartimpl(r2);
        } else if (i2 == 3) {
            i = TextRange.m6037getEndimpl(r2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        float r02 = Offset.m3562getXimpl(r0);
        int lineForOffset = layoutResult.getLineForOffset(i);
        float lineLeft = layoutResult.getLineLeft(lineForOffset);
        float lineRight = layoutResult.getLineRight(lineForOffset);
        float coerceIn = RangesKt.coerceIn(r02, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
        if (Math.abs(r02 - coerceIn) > ((float) (IntSize.m6790getWidthimpl(j) / 2))) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        float lineTop = layoutResult.getLineTop(lineForOffset);
        long Offset = OffsetKt.Offset(coerceIn, ((layoutResult.getLineBottom(lineForOffset) - lineTop) / ((float) 2)) + lineTop);
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null) {
                Offset = TextLayoutStateKt.m1419coerceIn3MmeM6k(Offset, SelectionManagerKt.visibleBounds(textLayoutNodeCoordinates));
            }
        }
        return TextLayoutStateKt.m1421fromTextLayoutToCoreUv8p0NA(textLayoutState, Offset);
    }
}
