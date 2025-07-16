package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ)\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0019\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0015¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0000J\u0006\u0010\u0018\u001a\u00020\u0000J\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "currentValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "layoutResultProxy", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;)V", "getCurrentValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getLayoutResultProxy", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "value", "getValue", "deleteIfSelectedOr", "", "Landroidx/compose/ui/text/input/EditCommand;", "or", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "moveCursorDownByPage", "moveCursorUpByPage", "jumpByPagesOffset", "", "pagesAmount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public final class TextFieldPreparedSelection extends BaseTextPreparedSelection<TextFieldPreparedSelection> {
    public static final int $stable = 8;
    private final TextFieldValue currentValue;
    private final TextLayoutResultProxy layoutResultProxy;

    public final TextFieldValue getCurrentValue() {
        return this.currentValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldPreparedSelection(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy, TextPreparedSelectionState textPreparedSelectionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldValue, (i & 2) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, textLayoutResultProxy, (i & 8) != 0 ? new TextPreparedSelectionState() : textPreparedSelectionState);
    }

    public final TextLayoutResultProxy getLayoutResultProxy() {
        return this.layoutResultProxy;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextFieldPreparedSelection(androidx.compose.ui.text.input.TextFieldValue r9, androidx.compose.ui.text.input.OffsetMapping r10, androidx.compose.foundation.text.TextLayoutResultProxy r11, androidx.compose.foundation.text.selection.TextPreparedSelectionState r12) {
        /*
            r8 = this;
            androidx.compose.ui.text.AnnotatedString r1 = r9.getAnnotatedString()
            long r2 = r9.m6299getSelectiond9O1mEE()
            if (r11 == 0) goto L_0x000f
            androidx.compose.ui.text.TextLayoutResult r0 = r11.getValue()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r4 = r0
            r7 = 0
            r0 = r8
            r5 = r10
            r6 = r12
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r8.currentValue = r9
            r8.layoutResultProxy = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.<init>(androidx.compose.ui.text.input.TextFieldValue, androidx.compose.ui.text.input.OffsetMapping, androidx.compose.foundation.text.TextLayoutResultProxy, androidx.compose.foundation.text.selection.TextPreparedSelectionState):void");
    }

    public final TextFieldValue getValue() {
        return TextFieldValue.m6294copy3r_uNRQ$default(this.currentValue, getAnnotatedString(), m1208getSelectiond9O1mEE(), (TextRange) null, 4, (Object) null);
    }

    public final List<EditCommand> deleteIfSelectedOr(Function1<? super TextFieldPreparedSelection, ? extends EditCommand> function1) {
        if (TextRange.m6036getCollapsedimpl(m1208getSelectiond9O1mEE())) {
            EditCommand editCommand = (EditCommand) function1.invoke(this);
            if (editCommand != null) {
                return CollectionsKt.listOf(editCommand);
            }
            return null;
        }
        return CollectionsKt.listOf(new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.m6040getMinimpl(m1208getSelectiond9O1mEE()), TextRange.m6040getMinimpl(m1208getSelectiond9O1mEE())));
    }

    public final TextFieldPreparedSelection moveCursorUpByPage() {
        BaseTextPreparedSelection baseTextPreparedSelection = this;
        if (baseTextPreparedSelection.getText$foundation_release().length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            TextLayoutResultProxy textLayoutResultProxy = this.layoutResultProxy;
            if (textLayoutResultProxy != null) {
                setCursor(jumpByPagesOffset(textLayoutResultProxy, -1));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (TextFieldPreparedSelection) baseTextPreparedSelection;
    }

    public final TextFieldPreparedSelection moveCursorDownByPage() {
        BaseTextPreparedSelection baseTextPreparedSelection = this;
        if (baseTextPreparedSelection.getText$foundation_release().length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            TextLayoutResultProxy textLayoutResultProxy = this.layoutResultProxy;
            if (textLayoutResultProxy != null) {
                setCursor(jumpByPagesOffset(textLayoutResultProxy, 1));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (TextFieldPreparedSelection) baseTextPreparedSelection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r2 == null) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy r6, int r7) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r6.getInnerTextFieldCoordinates()
            if (r0 == 0) goto L_0x0015
            androidx.compose.ui.layout.LayoutCoordinates r1 = r6.getDecorationBoxCoordinates()
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinates.CC.localBoundingBoxOf$default(r1, r0, r3, r4, r2)
        L_0x0013:
            if (r2 != 0) goto L_0x001b
        L_0x0015:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L_0x001b:
            androidx.compose.ui.text.input.OffsetMapping r0 = r5.getOffsetMapping()
            androidx.compose.ui.text.input.TextFieldValue r1 = r5.currentValue
            long r3 = r1.m6299getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m6037getEndimpl(r3)
            int r0 = r0.originalToTransformed(r1)
            androidx.compose.ui.text.TextLayoutResult r1 = r6.getValue()
            androidx.compose.ui.geometry.Rect r0 = r1.getCursorRect(r0)
            float r1 = r0.getLeft()
            float r0 = r0.getTop()
            long r2 = r2.m3595getSizeNHjbRc()
            float r2 = androidx.compose.ui.geometry.Size.m3628getHeightimpl(r2)
            float r7 = (float) r7
            float r2 = r2 * r7
            float r0 = r0 + r2
            androidx.compose.ui.text.input.OffsetMapping r7 = r5.getOffsetMapping()
            androidx.compose.ui.text.TextLayoutResult r6 = r6.getValue()
            long r0 = androidx.compose.ui.geometry.OffsetKt.Offset(r1, r0)
            int r6 = r6.m6014getOffsetForPositionk4lQ0M(r0)
            int r6 = r7.transformedToOriginal(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy, int):int");
    }
}
