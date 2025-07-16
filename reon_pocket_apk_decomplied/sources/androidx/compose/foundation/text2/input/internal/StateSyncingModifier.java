package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0016J\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\t*\u00020\u0016H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/StateSyncingModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text2/input/internal/StateSyncingModifierNode;", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChanged", "Lkotlin/Function1;", "", "writeSelectionFromTextFieldValue", "", "(Landroidx/compose/foundation/text2/input/TextFieldState;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Z)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StateSyncingModifier.kt */
final class StateSyncingModifier extends ModifierNodeElement<StateSyncingModifierNode> {
    private final Function1<TextFieldValue, Unit> onValueChanged;
    private final TextFieldState state;
    private final TextFieldValue value;
    private final boolean writeSelectionFromTextFieldValue;

    public boolean equals(Object obj) {
        return false;
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public StateSyncingModifier(TextFieldState textFieldState, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z) {
        this.state = textFieldState;
        this.value = textFieldValue;
        this.onValueChanged = function1;
        this.writeSelectionFromTextFieldValue = z;
    }

    public StateSyncingModifierNode create() {
        return new StateSyncingModifierNode(this.state, this.onValueChanged, this.writeSelectionFromTextFieldValue);
    }

    public void update(StateSyncingModifierNode stateSyncingModifierNode) {
        stateSyncingModifierNode.update(this.value, this.onValueChanged);
    }

    public int hashCode() {
        return this.state.hashCode();
    }
}
