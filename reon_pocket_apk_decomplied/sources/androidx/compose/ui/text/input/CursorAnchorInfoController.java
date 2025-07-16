package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020\u001dJ6\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010&\u001a\u00020\u001dH\u0002JB\u0010'\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/ui/text/input/CursorAnchorInfoController;", "", "rootPositionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "(Landroidx/compose/ui/input/pointer/PositionCalculator;Landroidx/compose/ui/text/input/InputMethodManager;)V", "androidMatrix", "Landroid/graphics/Matrix;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "decorationBoxBounds", "Landroidx/compose/ui/geometry/Rect;", "hasPendingImmediateRequest", "", "includeCharacterBounds", "includeEditorBounds", "includeInsertionMarker", "includeLineBounds", "innerTextFieldBounds", "lock", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "monitorEnabled", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textFieldToRootTransform", "Lkotlin/Function1;", "", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "invalidate", "requestUpdate", "immediate", "monitor", "updateCursorAnchorInfo", "updateTextLayoutResult", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CursorAnchorInfoController.android.kt */
public final class CursorAnchorInfoController {
    public static final int $stable = 8;
    private final Matrix androidMatrix = new Matrix();
    private final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
    private Rect decorationBoxBounds;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private Rect innerTextFieldBounds;
    private final InputMethodManager inputMethodManager;
    private final Object lock = new Object();
    private final float[] matrix = androidx.compose.ui.graphics.Matrix.m4058constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private boolean monitorEnabled;
    private OffsetMapping offsetMapping;
    private final PositionCalculator rootPositionCalculator;
    private Function1<? super androidx.compose.ui.graphics.Matrix, Unit> textFieldToRootTransform = CursorAnchorInfoController$textFieldToRootTransform$1.INSTANCE;
    private TextFieldValue textFieldValue;
    private TextLayoutResult textLayoutResult;

    public CursorAnchorInfoController(PositionCalculator positionCalculator, InputMethodManager inputMethodManager2) {
        this.rootPositionCalculator = positionCalculator;
        this.inputMethodManager = inputMethodManager2;
    }

    public final void requestUpdate(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        synchronized (this.lock) {
            this.includeInsertionMarker = z3;
            this.includeCharacterBounds = z4;
            this.includeEditorBounds = z5;
            this.includeLineBounds = z6;
            if (z) {
                this.hasPendingImmediateRequest = true;
                if (this.textFieldValue != null) {
                    updateCursorAnchorInfo();
                }
            }
            this.monitorEnabled = z2;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void updateTextLayoutResult(TextFieldValue textFieldValue2, OffsetMapping offsetMapping2, TextLayoutResult textLayoutResult2, Function1<? super androidx.compose.ui.graphics.Matrix, Unit> function1, Rect rect, Rect rect2) {
        synchronized (this.lock) {
            this.textFieldValue = textFieldValue2;
            this.offsetMapping = offsetMapping2;
            this.textLayoutResult = textLayoutResult2;
            this.textFieldToRootTransform = function1;
            this.innerTextFieldBounds = rect;
            this.decorationBoxBounds = rect2;
            if (this.hasPendingImmediateRequest || this.monitorEnabled) {
                updateCursorAnchorInfo();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void invalidate() {
        synchronized (this.lock) {
            this.textFieldValue = null;
            this.offsetMapping = null;
            this.textLayoutResult = null;
            this.textFieldToRootTransform = CursorAnchorInfoController$invalidate$1$1.INSTANCE;
            this.innerTextFieldBounds = null;
            this.decorationBoxBounds = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void updateCursorAnchorInfo() {
        if (this.inputMethodManager.isActive()) {
            this.textFieldToRootTransform.invoke(androidx.compose.ui.graphics.Matrix.m4056boximpl(this.matrix));
            this.rootPositionCalculator.m5198localToScreen58bKbWc(this.matrix);
            AndroidMatrixConversions_androidKt.m3674setFromEL8BTi8(this.androidMatrix, this.matrix);
            InputMethodManager inputMethodManager2 = this.inputMethodManager;
            CursorAnchorInfo.Builder builder2 = this.builder;
            TextFieldValue textFieldValue2 = this.textFieldValue;
            Intrinsics.checkNotNull(textFieldValue2);
            OffsetMapping offsetMapping2 = this.offsetMapping;
            Intrinsics.checkNotNull(offsetMapping2);
            TextLayoutResult textLayoutResult2 = this.textLayoutResult;
            Intrinsics.checkNotNull(textLayoutResult2);
            Matrix matrix2 = this.androidMatrix;
            Rect rect = this.innerTextFieldBounds;
            Intrinsics.checkNotNull(rect);
            Rect rect2 = this.decorationBoxBounds;
            Intrinsics.checkNotNull(rect2);
            inputMethodManager2.updateCursorAnchorInfo(CursorAnchorInfoBuilder_androidKt.build(builder2, textFieldValue2, offsetMapping2, textLayoutResult2, matrix2, rect, rect2, this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds));
            this.hasPendingImmediateRequest = false;
        }
    }
}
