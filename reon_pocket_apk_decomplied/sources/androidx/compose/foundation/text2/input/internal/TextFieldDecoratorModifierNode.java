package androidx.compose.foundation.text2.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001)\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nBO\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0002\u0010\u001bJ\b\u0010N\u001a\u000205H\u0002J\b\u0010O\u001a\u000205H\u0016J\b\u0010P\u001a\u000205H\u0016J\b\u0010Q\u001a\u000205H\u0016J\u0010\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020WH\u0016J\u001a\u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020ZH\u0016ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J\b\u0010]\u001a\u000205H\u0016J*\u0010^\u001a\u0002052\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0016ø\u0001\u0000¢\u0006\u0004\be\u0010fJ\u001a\u0010g\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020ZH\u0016ø\u0001\u0000¢\u0006\u0004\bh\u0010\\J\b\u0010i\u001a\u00020jH\u0002J\b\u0010k\u001a\u000205H\u0002J\b\u0010l\u001a\u000205H\u0002JP\u0010m\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014J\f\u0010n\u001a\u000205*\u00020oH\u0016R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001dR\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001d\"\u0004\b9\u0010\u001fR\u0014\u0010:\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u001dR\u001a\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001fR\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006p"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text2/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text2/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Z)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getFilter", "()Landroidx/compose/foundation/text2/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text2/input/InputTransformation;)V", "inputSessionJob", "Lkotlinx/coroutines/Job;", "isElementFocused", "isFocused", "keyboardActionScope", "androidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "<set-?>", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "onImeActionPerformed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getReadOnly", "setReadOnly", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "getSingleLine", "setSingleLine", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text2/input/internal/TextFieldKeyEventHandler;", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;)V", "getTextFieldState", "()Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;)V", "getTextLayoutState", "()Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text2/input/internal/TextLayoutState;)V", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "disposeInputSession", "onAttach", "onCancelPointerInput", "onDetach", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "requireKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "startInputSession", "startOrDisposeInputSessionOnWindowFocusChange", "updateNode", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements PlatformTextInputModifierNode, SemanticsModifierNode, FocusRequesterModifierNode, FocusEventModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private boolean enabled;
    private InputTransformation filter;
    private Job inputSessionJob;
    private boolean isElementFocused;
    /* access modifiers changed from: private */
    public final TextFieldDecoratorModifierNode$keyboardActionScope$1 keyboardActionScope;
    private KeyboardActions keyboardActions;
    private KeyboardOptions keyboardOptions;
    /* access modifiers changed from: private */
    public final Function1<ImeAction, Unit> onImeActionPerformed;
    private final SuspendingPointerInputModifierNode pointerInputNode = ((SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TextFieldDecoratorModifierNode$pointerInputNode$1(this, (Continuation<? super TextFieldDecoratorModifierNode$pointerInputNode$1>) null))));
    private boolean readOnly;
    private boolean singleLine;
    private final TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    /* access modifiers changed from: private */
    public WindowInfo windowInfo;

    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    public /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final void setTextFieldState(TransformedTextFieldState transformedTextFieldState) {
        this.textFieldState = transformedTextFieldState;
    }

    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    public final void setTextLayoutState(TextLayoutState textLayoutState2) {
        this.textLayoutState = textLayoutState2;
    }

    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    public final void setTextFieldSelectionState(TextFieldSelectionState textFieldSelectionState2) {
        this.textFieldSelectionState = textFieldSelectionState2;
    }

    public final InputTransformation getFilter() {
        return this.filter;
    }

    public final void setFilter(InputTransformation inputTransformation) {
        this.filter = inputTransformation;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public final KeyboardActions getKeyboardActions() {
        return this.keyboardActions;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions2) {
        this.keyboardActions = keyboardActions2;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final void setSingleLine(boolean z) {
        this.singleLine = z;
    }

    public TextFieldDecoratorModifierNode(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActions keyboardActions2, boolean z3) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState2;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.filter = inputTransformation;
        this.enabled = z;
        this.readOnly = z2;
        this.keyboardActions = keyboardActions2;
        this.singleLine = z3;
        KeyboardOptions keyboardOptions3 = null;
        InputTransformation inputTransformation2 = this.filter;
        this.keyboardOptions = TextFieldDecoratorModifierKt.withDefaultsFrom(keyboardOptions2, inputTransformation2 != null ? inputTransformation2.getKeyboardOptions() : keyboardOptions3);
        this.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        this.keyboardActionScope = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.onImeActionPerformed = new TextFieldDecoratorModifierNode$onImeActionPerformed$1(this);
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.windowInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isFocused() {
        /*
            r2 = this;
            boolean r0 = r2.isElementFocused
            if (r0 == 0) goto L_0x0010
            androidx.compose.ui.platform.WindowInfo r0 = r2.windowInfo
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isWindowFocused()
            r1 = 1
            if (r0 != r1) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.isFocused():boolean");
    }

    public final void updateNode(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActions keyboardActions2, boolean z3) {
        TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
        TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState2;
        InputTransformation inputTransformation2 = inputTransformation;
        boolean z4 = z;
        boolean z5 = z2;
        KeyboardOptions keyboardOptions3 = keyboardOptions2;
        boolean z6 = this.enabled;
        boolean z7 = true;
        boolean z8 = z6 && !this.readOnly;
        if (!z4 || z5) {
            z7 = false;
        }
        TransformedTextFieldState transformedTextFieldState3 = this.textFieldState;
        KeyboardOptions keyboardOptions4 = this.keyboardOptions;
        TextFieldSelectionState textFieldSelectionState4 = this.textFieldSelectionState;
        InputTransformation inputTransformation3 = this.filter;
        this.textFieldState = transformedTextFieldState2;
        this.textLayoutState = textLayoutState2;
        this.textFieldSelectionState = textFieldSelectionState3;
        this.filter = inputTransformation2;
        this.enabled = z4;
        this.readOnly = z5;
        this.keyboardOptions = TextFieldDecoratorModifierKt.withDefaultsFrom(keyboardOptions3, inputTransformation2 != null ? inputTransformation.getKeyboardOptions() : null);
        this.keyboardActions = keyboardActions2;
        this.singleLine = z3;
        if (z7 != z8 || !Intrinsics.areEqual((Object) transformedTextFieldState2, (Object) transformedTextFieldState3) || !Intrinsics.areEqual((Object) keyboardOptions3, (Object) keyboardOptions4) || !Intrinsics.areEqual((Object) inputTransformation2, (Object) inputTransformation3)) {
            if (z7 && isFocused()) {
                startInputSession();
            } else if (!z7) {
                disposeInputSession();
            }
        }
        if (z6 != z4) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual((Object) textFieldSelectionState3, (Object) textFieldSelectionState4)) {
            this.pointerInputNode.resetPointerInputHandler();
        }
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextFieldCharSequence untransformedText = this.textFieldState.getUntransformedText();
        long r1 = untransformedText.m1346getSelectionInCharsd9O1mEE();
        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, new AnnotatedString(untransformedText.toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null));
        SemanticsPropertiesKt.m5881setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, r1);
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$1(this), 1, (Object) null);
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$2(this), 1, (Object) null);
        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$3(this), 1, (Object) null);
        SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$4(this), 1, (Object) null);
        SemanticsPropertiesKt.m5877onImeAction9UiTYpY$default(semanticsPropertyReceiver, this.keyboardOptions.m1083getImeActioneUduSuo(), (String) null, new TextFieldDecoratorModifierNode$applySemantics$5(this), 2, (Object) null);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$6(this), 1, (Object) null);
        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$7(this), 1, (Object) null);
        if (!TextRange.m6036getCollapsedimpl(r1)) {
            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$8(this), 1, (Object) null);
            if (this.enabled && !this.readOnly) {
                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$9(this), 1, (Object) null);
            }
        }
        if (this.enabled && !this.readOnly) {
            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$10(this), 1, (Object) null);
        }
    }

    public void onFocusEvent(FocusState focusState) {
        if (this.isElementFocused != focusState.isFocused()) {
            this.isElementFocused = focusState.isFocused();
            this.textFieldSelectionState.setFocused(isFocused());
            if (!focusState.isFocused()) {
                disposeInputSession();
                this.textFieldState.collapseSelectionToMax();
            } else if (this.enabled && !this.readOnly) {
                startInputSession();
            }
        }
    }

    public void onAttach() {
        onObservedReadsChanged();
    }

    public void onDetach() {
        disposeInputSession();
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        this.textLayoutState.setDecoratorNodeCoordinates(layoutCoordinates);
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m1396onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.pointerInputNode.m5707onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    /* renamed from: onPreKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m1397onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return this.textFieldKeyEventHandler.m1401onPreKeyEventMyFupTE(keyEvent, this.textFieldState, this.textFieldSelectionState, (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager()), requireKeyboardController());
    }

    /* renamed from: onKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m1395onKeyEventZmokQxo(KeyEvent keyEvent) {
        return this.textFieldKeyEventHandler.m1400onKeyEvent6ptp14s(keyEvent, this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.enabled && !this.readOnly, this.singleLine, new TextFieldDecoratorModifierNode$onKeyEvent$1(this));
    }

    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new TextFieldDecoratorModifierNode$onObservedReadsChanged$1(this));
    }

    private final void startInputSession() {
        this.inputSessionJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$startInputSession$1(this, (Continuation<? super TextFieldDecoratorModifierNode$startInputSession$1>) null), 3, (Object) null);
    }

    private final void disposeInputSession() {
        Job job = this.inputSessionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.inputSessionJob = null;
    }

    /* access modifiers changed from: private */
    public final void startOrDisposeInputSessionOnWindowFocusChange() {
        WindowInfo windowInfo2 = this.windowInfo;
        if (windowInfo2 != null) {
            if (windowInfo2 == null || !windowInfo2.isWindowFocused() || !this.isElementFocused) {
                disposeInputSession();
            } else {
                startInputSession();
            }
        }
    }

    /* access modifiers changed from: private */
    public final SoftwareKeyboardController requireKeyboardController() {
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (softwareKeyboardController != null) {
            return softwareKeyboardController;
        }
        throw new IllegalStateException("No software keyboard controller".toString());
    }
}
