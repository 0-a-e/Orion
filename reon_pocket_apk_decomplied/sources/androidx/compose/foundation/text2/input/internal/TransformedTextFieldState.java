package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.foundation.text2.input.CodepointTransformationKt;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u0000 H2\u00020\u0001:\u0002HIB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0013J,\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00130\u001f¢\u0006\u0002\b!H\bJ\u0013\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u000e\u0010&\u001a\u00020%2\u0006\u0010+\u001a\u00020%J\u0018\u0010,\u001a\u00020'2\u0006\u0010(\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\b-\u0010*J\u001b\u0010,\u001a\u00020'2\u0006\u0010+\u001a\u00020%ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u000e\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020%J\u0006\u00102\u001a\u00020\u0013J\u000e\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000205J\"\u00106\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\b\b\u0002\u00107\u001a\u00020\u001d2\b\b\u0002\u00108\u001a\u000209J*\u0010:\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\u0006\u0010(\u001a\u00020'2\b\b\u0002\u00108\u001a\u000209ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0006\u0010=\u001a\u00020\u0013J\u0018\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\bD\u0010AJ\b\u0010E\u001a\u00020FH\u0016J\u0006\u0010G\u001a\u00020\u0013R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006J"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text2/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text2/input/CodepointTransformation;", "(Landroidx/compose/foundation/text2/input/TextFieldState;Landroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/foundation/text2/input/CodepointTransformation;)V", "text", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "transformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState$TransformedText;", "untransformedText", "getUntransformedText", "collapseSelectionToEnd", "", "collapseSelectionToMax", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text2/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text2/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSelectedText", "editUntransformedTextAsUser", "notifyImeOfChanges", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "Lkotlin/ExtensionFunctionType;", "equals", "other", "hashCode", "", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "offset", "mapToTransformed", "mapToTransformed-GEjPoXI", "mapToTransformed--jx7JFs", "(I)J", "placeCursorBeforeCharAt", "transformedOffset", "redo", "replaceAll", "newText", "", "replaceSelectedText", "clearComposition", "undoBehavior", "Landroidx/compose/foundation/text2/input/internal/undo/TextFieldEditUndoBehavior;", "replaceText", "replaceText-Sb-Bc2M", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text2/input/internal/undo/TextFieldEditUndoBehavior;)V", "selectAll", "selectCharsIn", "transformedRange", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "toString", "", "undo", "Companion", "TransformedText", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformedTextFieldState.kt */
public final class TransformedTextFieldState {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CodepointTransformation codepointTransformation;
    /* access modifiers changed from: private */
    public final InputTransformation inputTransformation;
    /* access modifiers changed from: private */
    public final TextFieldState textFieldState;
    private final State<TransformedText> transformedText;

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation2) {
        return Companion.calculateTransformedText(textFieldCharSequence, codepointTransformation2);
    }

    @JvmStatic
    /* renamed from: mapFromTransformed-xdX6-G0  reason: not valid java name */
    private static final long m1422mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m1433mapFromTransformedxdX6G0(j, offsetMappingCalculator);
    }

    @JvmStatic
    /* renamed from: mapToTransformed-xdX6-G0  reason: not valid java name */
    private static final long m1423mapToTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m1434mapToTransformedxdX6G0(j, offsetMappingCalculator);
    }

    public TransformedTextFieldState(TextFieldState textFieldState2, InputTransformation inputTransformation2, CodepointTransformation codepointTransformation2) {
        this.textFieldState = textFieldState2;
        this.inputTransformation = inputTransformation2;
        this.codepointTransformation = codepointTransformation2;
        this.transformedText = codepointTransformation2 != null ? SnapshotStateKt.derivedStateOf(new TransformedTextFieldState$transformedText$1$1(this, codepointTransformation2)) : null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getValue()).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.text2.input.TextFieldCharSequence getText() {
        /*
            r1 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$TransformedText> r0 = r1.transformedText
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0012
            androidx.compose.foundation.text2.input.TextFieldCharSequence r0 = r0.getText()
            if (r0 != 0) goto L_0x0018
        L_0x0012:
            androidx.compose.foundation.text2.input.TextFieldState r0 = r1.textFieldState
            androidx.compose.foundation.text2.input.TextFieldCharSequence r0 = r0.getText()
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.getText():androidx.compose.foundation.text2.input.TextFieldCharSequence");
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getText();
    }

    public final void placeCursorBeforeCharAt(int i) {
        m1429selectCharsIn5zctL8(TextRangeKt.TextRange(i));
    }

    /* renamed from: selectCharsIn-5zc-tL8  reason: not valid java name */
    public final void m1429selectCharsIn5zctL8(long j) {
        m1430selectUntransformedCharsIn5zctL8(m1425mapFromTransformedGEjPoXI(j));
    }

    /* renamed from: selectUntransformedCharsIn-5zc-tL8  reason: not valid java name */
    public final void m1430selectUntransformedCharsIn5zctL8(long j) {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState2.getText();
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        textFieldState2.getMainBuffer$foundation_release().setSelection(TextRange.m6042getStartimpl(j), TextRange.m6037getEndimpl(j));
        if (textFieldState2.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState2.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState2.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState2.commitEditAsUser(text, inputTransformation2, true, textFieldEditUndoBehavior);
        }
    }

    public final void replaceAll(CharSequence charSequence) {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState2.getText();
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        EditCommandKt.deleteAll(mainBuffer$foundation_release);
        EditCommandKt.commitText(mainBuffer$foundation_release, charSequence.toString(), 1);
        if (textFieldState2.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState2.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState2.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState2.commitEditAsUser(text, inputTransformation2, true, textFieldEditUndoBehavior);
        }
    }

    public final void selectAll() {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState2.getText();
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.setSelection(0, mainBuffer$foundation_release.getLength());
        if (textFieldState2.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState2.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState2.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState2.commitEditAsUser(text, inputTransformation2, true, textFieldEditUndoBehavior);
        }
    }

    public final void deleteSelectedText() {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.NeverMerge;
        TextFieldCharSequence text = textFieldState2.getText();
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.delete(TextRange.m6040getMinimpl(mainBuffer$foundation_release.m1370getSelectiond9O1mEE()), TextRange.m6039getMaximpl(mainBuffer$foundation_release.m1370getSelectiond9O1mEE()));
        mainBuffer$foundation_release.setSelection(TextRange.m6040getMinimpl(mainBuffer$foundation_release.m1370getSelectiond9O1mEE()), TextRange.m6040getMinimpl(mainBuffer$foundation_release.m1370getSelectiond9O1mEE()));
        if (textFieldState2.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState2.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState2.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState2.commitEditAsUser(text, inputTransformation2, true, textFieldEditUndoBehavior);
        }
    }

    /* renamed from: replaceText-Sb-Bc2M$default  reason: not valid java name */
    public static /* synthetic */ void m1424replaceTextSbBc2M$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.m1428replaceTextSbBc2M(charSequence, j, textFieldEditUndoBehavior);
    }

    /* renamed from: replaceText-Sb-Bc2M  reason: not valid java name */
    public final void m1428replaceTextSbBc2M(CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldCharSequence text = textFieldState2.getText();
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        long r8 = m1425mapFromTransformedGEjPoXI(j);
        mainBuffer$foundation_release.replace(TextRange.m6040getMinimpl(r8), TextRange.m6039getMaximpl(r8), charSequence);
        int r82 = TextRange.m6040getMinimpl(r8) + charSequence.length();
        mainBuffer$foundation_release.setSelection(r82, r82);
        if (textFieldState2.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState2.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState2.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState2.commitEditAsUser(text, inputTransformation2, true, textFieldEditUndoBehavior);
        }
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.replaceSelectedText(charSequence, z, textFieldEditUndoBehavior);
    }

    public final void replaceSelectedText(CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldCharSequence text = textFieldState2.getText();
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        if (z) {
            mainBuffer$foundation_release.commitComposition();
        }
        long r4 = mainBuffer$foundation_release.m1370getSelectiond9O1mEE();
        mainBuffer$foundation_release.replace(TextRange.m6040getMinimpl(r4), TextRange.m6039getMaximpl(r4), charSequence);
        int r9 = TextRange.m6040getMinimpl(r4) + charSequence.length();
        mainBuffer$foundation_release.setSelection(r9, r9);
        if (textFieldState2.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState2.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState2.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState2.commitEditAsUser(text, inputTransformation2, true, textFieldEditUndoBehavior);
        }
    }

    public final void collapseSelectionToMax() {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState2.getText();
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.setSelection(TextRange.m6039getMaximpl(mainBuffer$foundation_release.m1370getSelectiond9O1mEE()), TextRange.m6039getMaximpl(mainBuffer$foundation_release.m1370getSelectiond9O1mEE()));
        if (textFieldState2.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState2.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState2.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState2.commitEditAsUser(text, inputTransformation2, true, textFieldEditUndoBehavior);
        }
    }

    public final void collapseSelectionToEnd() {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState2.getText();
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.setSelection(TextRange.m6037getEndimpl(mainBuffer$foundation_release.m1370getSelectiond9O1mEE()), TextRange.m6037getEndimpl(mainBuffer$foundation_release.m1370getSelectiond9O1mEE()));
        if (textFieldState2.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState2.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState2.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState2.commitEditAsUser(text, inputTransformation2, true, textFieldEditUndoBehavior);
        }
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState transformedTextFieldState, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        TextFieldState access$getTextFieldState$p = transformedTextFieldState.textFieldState;
        InputTransformation access$getInputTransformation$p = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = access$getTextFieldState$p.getText();
        access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(access$getTextFieldState$p.getMainBuffer$foundation_release());
        if (access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), access$getTextFieldState$p.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) access$getTextFieldState$p.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            access$getTextFieldState$p.commitEditAsUser(text, access$getInputTransformation$p, z, textFieldEditUndoBehavior);
        }
    }

    public final void editUntransformedTextAsUser(boolean z, Function1<? super EditingBuffer, Unit> function1) {
        TextFieldState access$getTextFieldState$p = this.textFieldState;
        InputTransformation access$getInputTransformation$p = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = access$getTextFieldState$p.getText();
        access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(access$getTextFieldState$p.getMainBuffer$foundation_release());
        if (access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), access$getTextFieldState$p.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) access$getTextFieldState$p.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            access$getTextFieldState$p.commitEditAsUser(text, access$getInputTransformation$p, z, textFieldEditUndoBehavior);
        }
    }

    /* renamed from: mapToTransformed--jx7JFs  reason: not valid java name */
    public final long m1426mapToTransformedjx7JFs(int i) {
        TransformedText value;
        OffsetMappingCalculator offsetMapping;
        State<TransformedText> state = this.transformedText;
        if (state == null || (value = state.getValue()) == null || (offsetMapping = value.getOffsetMapping()) == null) {
            return TextRangeKt.TextRange(i);
        }
        return offsetMapping.m1375mapFromSourcejx7JFs(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getValue()).getOffsetMapping();
     */
    /* renamed from: mapToTransformed-GEjPoXI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m1427mapToTransformedGEjPoXI(long r3) {
        /*
            r2 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$TransformedText> r0 = r2.transformedText
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0019
            androidx.compose.foundation.text2.input.internal.OffsetMappingCalculator r0 = r0.getOffsetMapping()
            if (r0 != 0) goto L_0x0013
            goto L_0x0019
        L_0x0013:
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$Companion r1 = Companion
            long r3 = r1.m1434mapToTransformedxdX6G0(r3, r0)
        L_0x0019:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1427mapToTransformedGEjPoXI(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getValue()).getOffsetMapping();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mapFromTransformed(int r3) {
        /*
            r2 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$TransformedText> r0 = r2.transformedText
            if (r0 == 0) goto L_0x001b
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x001b
            androidx.compose.foundation.text2.input.internal.OffsetMappingCalculator r0 = r0.getOffsetMapping()
            if (r0 != 0) goto L_0x0013
            goto L_0x001b
        L_0x0013:
            long r0 = r0.m1374mapFromDestjx7JFs(r3)
            int r3 = androidx.compose.ui.text.TextRange.m6040getMinimpl(r0)
        L_0x001b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.mapFromTransformed(int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getValue()).getOffsetMapping();
     */
    /* renamed from: mapFromTransformed-GEjPoXI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m1425mapFromTransformedGEjPoXI(long r3) {
        /*
            r2 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$TransformedText> r0 = r2.transformedText
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0019
            androidx.compose.foundation.text2.input.internal.OffsetMappingCalculator r0 = r0.getOffsetMapping()
            if (r0 != 0) goto L_0x0013
            goto L_0x0019
        L_0x0013:
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$Companion r1 = Companion
            long r3 = r1.m1433mapFromTransformedxdX6G0(r3, r0)
        L_0x0019:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1425mapFromTransformedGEjPoXI(long):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collectImeNotifications(androidx.compose.foundation.text2.input.TextFieldState.NotifyImeListener r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$collectImeNotifications$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$collectImeNotifications$1 r0 = (androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$collectImeNotifications$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$collectImeNotifications$1 r0 = new androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$collectImeNotifications$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r3) goto L_0x002e
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002e:
            java.lang.Object r5 = r0.L$1
            androidx.compose.foundation.text2.input.TextFieldState$NotifyImeListener r5 = (androidx.compose.foundation.text2.input.TextFieldState.NotifyImeListener) r5
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r5 = (androidx.compose.foundation.text2.input.internal.TransformedTextFieldState) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0075
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r6.<init>(r2, r3)
            r6.initCancellability()
            r2 = r6
            kotlinx.coroutines.CancellableContinuation r2 = (kotlinx.coroutines.CancellableContinuation) r2
            androidx.compose.foundation.text2.input.TextFieldState r3 = r4.textFieldState
            r3.addNotifyImeListener$foundation_release(r5)
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$collectImeNotifications$2$1 r3 = new androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$collectImeNotifications$2$1
            r3.<init>(r4, r5)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2.invokeOnCancellation(r3)
            java.lang.Object r5 = r6.getResult()
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r6) goto L_0x0072
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0072:
            if (r5 != r1) goto L_0x0075
            return r1
        L_0x0075:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.collectImeNotifications(androidx.compose.foundation.text2.input.TextFieldState$NotifyImeListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransformedTextFieldState)) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = (TransformedTextFieldState) obj;
        if (!Intrinsics.areEqual((Object) this.textFieldState, (Object) transformedTextFieldState.textFieldState)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.codepointTransformation, (Object) transformedTextFieldState.codepointTransformation);
    }

    public int hashCode() {
        int hashCode = this.textFieldState.hashCode() * 31;
        CodepointTransformation codepointTransformation2 = this.codepointTransformation;
        return hashCode + (codepointTransformation2 != null ? codepointTransformation2.hashCode() : 0);
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", codepointTransformation=" + this.codepointTransformation + ", transformedText=" + this.transformedText + ", text=\"" + getText() + "\")";
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;)V", "getOffsetMapping", "()Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;", "getText", "()Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TransformedTextFieldState.kt */
    private static final class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public static /* synthetic */ TransformedText copy$default(TransformedText transformedText, TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator, int i, Object obj) {
            if ((i & 1) != 0) {
                textFieldCharSequence = transformedText.text;
            }
            if ((i & 2) != 0) {
                offsetMappingCalculator = transformedText.offsetMapping;
            }
            return transformedText.copy(textFieldCharSequence, offsetMappingCalculator);
        }

        public final TextFieldCharSequence component1() {
            return this.text;
        }

        public final OffsetMappingCalculator component2() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            return new TransformedText(textFieldCharSequence, offsetMappingCalculator);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransformedText)) {
                return false;
            }
            TransformedText transformedText = (TransformedText) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) transformedText.text) && Intrinsics.areEqual((Object) this.offsetMapping, (Object) transformedText.offsetMapping);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + this.text + ", offsetMapping=" + this.offsetMapping + ')';
        }

        public TransformedText(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            this.text = textFieldCharSequence;
            this.offsetMapping = offsetMappingCalculator;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState$Companion;", "", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState$TransformedText;", "untransformedText", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "codepointTransformation", "Landroidx/compose/foundation/text2/input/CodepointTransformation;", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;)J", "mapToTransformed", "mapToTransformed-xdX6-G0", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TransformedTextFieldState.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            CharSequence visualText = CodepointTransformationKt.toVisualText(textFieldCharSequence, codepointTransformation, offsetMappingCalculator);
            TextRange textRange = null;
            if (visualText == textFieldCharSequence) {
                return null;
            }
            long r2 = m1434mapToTransformedxdX6G0(textFieldCharSequence.m1346getSelectionInCharsd9O1mEE(), offsetMappingCalculator);
            TextRange r7 = textFieldCharSequence.m1345getCompositionInCharsMzsxiRA();
            if (r7 != null) {
                textRange = TextRange.m6030boximpl(TransformedTextFieldState.Companion.m1434mapToTransformedxdX6G0(r7.m6046unboximpl(), offsetMappingCalculator));
            }
            return new TransformedText(TextFieldCharSequenceKt.m1347TextFieldCharSequence3r_uNRQ(visualText, r2, textRange), offsetMappingCalculator);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        /* renamed from: mapToTransformed-xdX6-G0  reason: not valid java name */
        public final long m1434mapToTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
            long j2;
            long r0 = offsetMappingCalculator.m1375mapFromSourcejx7JFs(TextRange.m6042getStartimpl(j));
            if (TextRange.m6036getCollapsedimpl(j)) {
                j2 = r0;
            } else {
                j2 = offsetMappingCalculator.m1375mapFromSourcejx7JFs(TextRange.m6037getEndimpl(j));
            }
            int min = Math.min(TextRange.m6040getMinimpl(r0), TextRange.m6040getMinimpl(j2));
            int max = Math.max(TextRange.m6039getMaximpl(r0), TextRange.m6039getMaximpl(j2));
            if (TextRange.m6041getReversedimpl(j)) {
                return TextRangeKt.TextRange(max, min);
            }
            return TextRangeKt.TextRange(min, max);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        /* renamed from: mapFromTransformed-xdX6-G0  reason: not valid java name */
        public final long m1433mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
            long j2;
            long r0 = offsetMappingCalculator.m1374mapFromDestjx7JFs(TextRange.m6042getStartimpl(j));
            if (TextRange.m6036getCollapsedimpl(j)) {
                j2 = r0;
            } else {
                j2 = offsetMappingCalculator.m1374mapFromDestjx7JFs(TextRange.m6037getEndimpl(j));
            }
            int min = Math.min(TextRange.m6040getMinimpl(r0), TextRange.m6040getMinimpl(j2));
            int max = Math.max(TextRange.m6039getMaximpl(r0), TextRange.m6039getMaximpl(j2));
            if (TextRange.m6041getReversedimpl(j)) {
                return TextRangeKt.TextRange(max, min);
            }
            return TextRangeKt.TextRange(min, max);
        }
    }
}
