package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldBuffer;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\bH\u0002R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/StateSyncingModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "onValueChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "writeSelectionFromTextFieldValue", "", "(Landroidx/compose/foundation/text2/input/TextFieldState;Lkotlin/jvm/functions/Function1;Z)V", "isFocused", "lastValueWhileFocused", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "observeTextState", "fireOnValueChanged", "onAttach", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onObservedReadsChanged", "update", "value", "updateState", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StateSyncingModifier.kt */
final class StateSyncingModifierNode extends Modifier.Node implements ObserverModifierNode, FocusEventModifierNode {
    private boolean isFocused;
    private TextFieldValue lastValueWhileFocused;
    private Function1<? super TextFieldValue, Unit> onValueChanged;
    /* access modifiers changed from: private */
    public final TextFieldState state;
    private final boolean writeSelectionFromTextFieldValue;

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public StateSyncingModifierNode(TextFieldState textFieldState, Function1<? super TextFieldValue, Unit> function1, boolean z) {
        this.state = textFieldState;
        this.onValueChanged = function1;
        this.writeSelectionFromTextFieldValue = z;
    }

    public final void update(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChanged = function1;
        if (!this.isFocused) {
            updateState(textFieldValue);
        } else {
            this.lastValueWhileFocused = textFieldValue;
        }
    }

    public void onAttach() {
        observeTextState(false);
    }

    public void onFocusEvent(FocusState focusState) {
        if (this.isFocused && !focusState.isFocused()) {
            TextFieldValue textFieldValue = this.lastValueWhileFocused;
            if (textFieldValue != null) {
                updateState(textFieldValue);
            }
            this.lastValueWhileFocused = null;
        }
        this.isFocused = focusState.isFocused();
    }

    public void onObservedReadsChanged() {
        observeTextState$default(this, false, 1, (Object) null);
    }

    private final void updateState(TextFieldValue textFieldValue) {
        TextFieldState textFieldState = this.state;
        TextFieldBuffer startEdit = textFieldState.startEdit(textFieldState.getText());
        startEdit.setTextIfChanged$foundation_release(textFieldValue.getText());
        if (this.writeSelectionFromTextFieldValue) {
            startEdit.m1340selectCharsIn5zctL8(textFieldValue.m6299getSelectiond9O1mEE());
        }
        textFieldState.commitEdit(startEdit);
    }

    static /* synthetic */ void observeTextState$default(StateSyncingModifierNode stateSyncingModifierNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        stateSyncingModifierNode.observeTextState(z);
    }

    private final void observeTextState(boolean z) {
        TextFieldCharSequence textFieldCharSequence;
        TextFieldCharSequence textFieldCharSequence2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new StateSyncingModifierNode$observeTextState$1(objectRef, this));
        if (z) {
            TextFieldCharSequence textFieldCharSequence3 = null;
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("text");
                textFieldCharSequence = null;
            } else {
                textFieldCharSequence = (TextFieldCharSequence) objectRef.element;
            }
            String obj = textFieldCharSequence.toString();
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("text");
                textFieldCharSequence2 = null;
            } else {
                textFieldCharSequence2 = (TextFieldCharSequence) objectRef.element;
            }
            long r5 = textFieldCharSequence2.m1346getSelectionInCharsd9O1mEE();
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("text");
            } else {
                textFieldCharSequence3 = (TextFieldCharSequence) objectRef.element;
            }
            this.onValueChanged.invoke(new TextFieldValue(obj, r5, textFieldCharSequence3.m1345getCompositionInCharsMzsxiRA(), (DefaultConstructorMarker) null));
        }
    }
}
