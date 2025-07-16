package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0016\u001a\u00020\bHÂ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÂ\u0003J\t\u0010\u0018\u001a\u00020\fHÂ\u0003J\t\u0010\u0019\u001a\u00020\fHÂ\u0003J\t\u0010\u001a\u001a\u00020\u000fHÂ\u0003J\t\u0010\u001b\u001a\u00020\u0011HÂ\u0003J\t\u0010\u001c\u001a\u00020\fHÂ\u0003Je\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0002H\u0016J\f\u0010)\u001a\u00020'*\u00020*H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text2/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text2/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
public final class TextFieldDecoratorModifier extends ModifierNodeElement<TextFieldDecoratorModifierNode> {
    public static final int $stable = 0;
    private final boolean enabled;
    private final InputTransformation filter;
    private final KeyboardActions keyboardActions;
    private final KeyboardOptions keyboardOptions;
    private final boolean readOnly;
    private final boolean singleLine;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;

    private final TransformedTextFieldState component1() {
        return this.textFieldState;
    }

    private final TextLayoutState component2() {
        return this.textLayoutState;
    }

    private final TextFieldSelectionState component3() {
        return this.textFieldSelectionState;
    }

    private final InputTransformation component4() {
        return this.filter;
    }

    private final boolean component5() {
        return this.enabled;
    }

    private final boolean component6() {
        return this.readOnly;
    }

    private final KeyboardOptions component7() {
        return this.keyboardOptions;
    }

    private final KeyboardActions component8() {
        return this.keyboardActions;
    }

    private final boolean component9() {
        return this.singleLine;
    }

    public static /* synthetic */ TextFieldDecoratorModifier copy$default(TextFieldDecoratorModifier textFieldDecoratorModifier, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActions keyboardActions2, boolean z3, int i, Object obj) {
        TextFieldDecoratorModifier textFieldDecoratorModifier2 = textFieldDecoratorModifier;
        int i2 = i;
        return textFieldDecoratorModifier.copy((i2 & 1) != 0 ? textFieldDecoratorModifier2.textFieldState : transformedTextFieldState, (i2 & 2) != 0 ? textFieldDecoratorModifier2.textLayoutState : textLayoutState2, (i2 & 4) != 0 ? textFieldDecoratorModifier2.textFieldSelectionState : textFieldSelectionState2, (i2 & 8) != 0 ? textFieldDecoratorModifier2.filter : inputTransformation, (i2 & 16) != 0 ? textFieldDecoratorModifier2.enabled : z, (i2 & 32) != 0 ? textFieldDecoratorModifier2.readOnly : z2, (i2 & 64) != 0 ? textFieldDecoratorModifier2.keyboardOptions : keyboardOptions2, (i2 & 128) != 0 ? textFieldDecoratorModifier2.keyboardActions : keyboardActions2, (i2 & 256) != 0 ? textFieldDecoratorModifier2.singleLine : z3);
    }

    public final TextFieldDecoratorModifier copy(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActions keyboardActions2, boolean z3) {
        return new TextFieldDecoratorModifier(transformedTextFieldState, textLayoutState2, textFieldSelectionState2, inputTransformation, z, z2, keyboardOptions2, keyboardActions2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldDecoratorModifier)) {
            return false;
        }
        TextFieldDecoratorModifier textFieldDecoratorModifier = (TextFieldDecoratorModifier) obj;
        return Intrinsics.areEqual((Object) this.textFieldState, (Object) textFieldDecoratorModifier.textFieldState) && Intrinsics.areEqual((Object) this.textLayoutState, (Object) textFieldDecoratorModifier.textLayoutState) && Intrinsics.areEqual((Object) this.textFieldSelectionState, (Object) textFieldDecoratorModifier.textFieldSelectionState) && Intrinsics.areEqual((Object) this.filter, (Object) textFieldDecoratorModifier.filter) && this.enabled == textFieldDecoratorModifier.enabled && this.readOnly == textFieldDecoratorModifier.readOnly && Intrinsics.areEqual((Object) this.keyboardOptions, (Object) textFieldDecoratorModifier.keyboardOptions) && Intrinsics.areEqual((Object) this.keyboardActions, (Object) textFieldDecoratorModifier.keyboardActions) && this.singleLine == textFieldDecoratorModifier.singleLine;
    }

    public int hashCode() {
        int hashCode = ((((this.textFieldState.hashCode() * 31) + this.textLayoutState.hashCode()) * 31) + this.textFieldSelectionState.hashCode()) * 31;
        InputTransformation inputTransformation = this.filter;
        return ((((((((((hashCode + (inputTransformation == null ? 0 : inputTransformation.hashCode())) * 31) + UByte$$ExternalSyntheticBackport0.m(this.enabled)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.readOnly)) * 31) + this.keyboardOptions.hashCode()) * 31) + this.keyboardActions.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.singleLine);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "TextFieldDecoratorModifier(textFieldState=" + this.textFieldState + ", textLayoutState=" + this.textLayoutState + ", textFieldSelectionState=" + this.textFieldSelectionState + ", filter=" + this.filter + ", enabled=" + this.enabled + ", readOnly=" + this.readOnly + ", keyboardOptions=" + this.keyboardOptions + ", keyboardActions=" + this.keyboardActions + ", singleLine=" + this.singleLine + ')';
    }

    public TextFieldDecoratorModifier(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActions keyboardActions2, boolean z3) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState2;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.filter = inputTransformation;
        this.enabled = z;
        this.readOnly = z2;
        this.keyboardOptions = keyboardOptions2;
        this.keyboardActions = keyboardActions2;
        this.singleLine = z3;
    }

    public TextFieldDecoratorModifierNode create() {
        return new TextFieldDecoratorModifierNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActions, this.singleLine);
    }

    public void update(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        textFieldDecoratorModifierNode.updateNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActions, this.singleLine);
    }
}
