package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001ad\u0010\u000b\u001a\u00020\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u001a,\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u001d"}, d2 = {"addCharacterBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "startOffset", "", "endOffset", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "build", "Landroid/view/inputmethod/CursorAnchorInfo;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "matrix", "Landroid/graphics/Matrix;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "containsInclusive", "x", "", "y", "setInsertionMarker", "selectionStart", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CursorAnchorInfoBuilder.android.kt */
public final class CursorAnchorInfoBuilder_androidKt {
    public static /* synthetic */ CursorAnchorInfo build$default(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        int i2 = i;
        return build(builder, textFieldValue, offsetMapping, textLayoutResult, matrix, rect, rect2, (i2 & 64) != 0 ? true : z, (i2 & 128) != 0 ? true : z2, (i2 & 256) != 0 ? true : z3, (i2 & 512) != 0 ? true : z4);
    }

    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4) {
        CursorAnchorInfo.Builder builder2 = builder;
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        Rect rect3 = rect;
        builder.reset();
        Matrix matrix2 = matrix;
        builder.setMatrix(matrix);
        int r0 = TextRange.m6040getMinimpl(textFieldValue.m6299getSelectiond9O1mEE());
        builder.setSelectionRange(r0, TextRange.m6039getMaximpl(textFieldValue.m6299getSelectiond9O1mEE()));
        OffsetMapping offsetMapping2 = offsetMapping;
        if (z) {
            setInsertionMarker(builder, r0, offsetMapping, textLayoutResult, rect);
        }
        if (z2) {
            TextRange r02 = textFieldValue.m6298getCompositionMzsxiRA();
            int r2 = r02 != null ? TextRange.m6040getMinimpl(r02.m6046unboximpl()) : -1;
            TextRange r03 = textFieldValue.m6298getCompositionMzsxiRA();
            int r4 = r03 != null ? TextRange.m6039getMaximpl(r03.m6046unboximpl()) : -1;
            if (r2 >= 0 && r2 < r4) {
                builder.setComposingText(r2, textFieldValue.getText().subSequence(r2, r4));
                addCharacterBounds(builder, r2, r4, offsetMapping, textLayoutResult, rect);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && z3) {
            Rect rect4 = rect2;
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(builder, rect2);
        }
        if (Build.VERSION.SDK_INT >= 34 && z4) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        if (i < 0) {
            return builder;
        }
        int originalToTransformed = offsetMapping.originalToTransformed(i);
        Rect cursorRect = textLayoutResult.getCursorRect(originalToTransformed);
        float coerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0.0f, (float) IntSize.m6790getWidthimpl(textLayoutResult.m6015getSizeYbymL2g()));
        boolean containsInclusive = containsInclusive(rect, coerceIn, cursorRect.getTop());
        boolean containsInclusive2 = containsInclusive(rect, coerceIn, cursorRect.getBottom());
        int i2 = 1;
        boolean z = textLayoutResult.getBidiRunDirection(originalToTransformed) == ResolvedTextDirection.Rtl;
        if (!containsInclusive && !containsInclusive2) {
            i2 = 0;
        }
        if (!containsInclusive || !containsInclusive2) {
            i2 |= 2;
        }
        builder.setInsertionMarkerLocation(coerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), z ? i2 | 4 : i2);
        return builder;
    }

    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder builder, int i, int i2, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        int i3 = i2;
        OffsetMapping offsetMapping2 = offsetMapping;
        int i4 = i;
        Rect rect2 = rect;
        int originalToTransformed = offsetMapping2.originalToTransformed(i4);
        int originalToTransformed2 = offsetMapping2.originalToTransformed(i3);
        float[] fArr = new float[((originalToTransformed2 - originalToTransformed) * 4)];
        textLayoutResult.getMultiParagraph().m5912fillBoundingBoxes8ffj60Q(TextRangeKt.TextRange(originalToTransformed, originalToTransformed2), fArr, 0);
        while (i4 < i3) {
            int originalToTransformed3 = offsetMapping2.originalToTransformed(i4);
            int i5 = (originalToTransformed3 - originalToTransformed) * 4;
            Rect rect3 = new Rect(fArr[i5], fArr[i5 + 1], fArr[i5 + 2], fArr[i5 + 3]);
            boolean overlaps = rect2.overlaps(rect3);
            if (!containsInclusive(rect2, rect3.getLeft(), rect3.getTop()) || !containsInclusive(rect2, rect3.getRight(), rect3.getBottom())) {
                overlaps |= true;
            }
            builder.addCharacterBounds(i4, rect3.getLeft(), rect3.getTop(), rect3.getRight(), rect3.getBottom(), textLayoutResult.getBidiRunDirection(originalToTransformed3) == ResolvedTextDirection.Rtl ? overlaps | true : overlaps ? 1 : 0);
            i4++;
        }
        return builder;
    }

    private static final boolean containsInclusive(Rect rect, float f, float f2) {
        float left = rect.getLeft();
        if (f <= rect.getRight() && left <= f) {
            return f2 <= rect.getBottom() && rect.getTop() <= f2;
        }
    }
}
