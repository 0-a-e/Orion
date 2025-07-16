package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0015\u001a\u00020\bHÂ\u0003J\t\u0010\u0016\u001a\u00020\nHÂ\u0003J\t\u0010\u0017\u001a\u00020\fHÂ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0019\u001a\u00020\u000fHÂ\u0003J\t\u0010\u001a\u001a\u00020\u0011HÂ\u0003JY\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0016J\f\u0010'\u001a\u00020%*\u00020(H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TextFieldCoreModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text2/input/internal/TextFieldCoreModifierNode;", "isFocused", "", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(ZLandroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCoreModifier.kt */
public final class TextFieldCoreModifier extends ModifierNodeElement<TextFieldCoreModifierNode> {
    public static final int $stable = 0;
    private final Brush cursorBrush;
    private final boolean isFocused;
    private final Orientation orientation;
    private final ScrollState scrollState;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final boolean writeable;

    private final boolean component1() {
        return this.isFocused;
    }

    private final TextLayoutState component2() {
        return this.textLayoutState;
    }

    private final TransformedTextFieldState component3() {
        return this.textFieldState;
    }

    private final TextFieldSelectionState component4() {
        return this.textFieldSelectionState;
    }

    private final Brush component5() {
        return this.cursorBrush;
    }

    private final boolean component6() {
        return this.writeable;
    }

    private final ScrollState component7() {
        return this.scrollState;
    }

    private final Orientation component8() {
        return this.orientation;
    }

    public static /* synthetic */ TextFieldCoreModifier copy$default(TextFieldCoreModifier textFieldCoreModifier, boolean z, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z2, ScrollState scrollState2, Orientation orientation2, int i, Object obj) {
        TextFieldCoreModifier textFieldCoreModifier2 = textFieldCoreModifier;
        int i2 = i;
        return textFieldCoreModifier.copy((i2 & 1) != 0 ? textFieldCoreModifier2.isFocused : z, (i2 & 2) != 0 ? textFieldCoreModifier2.textLayoutState : textLayoutState2, (i2 & 4) != 0 ? textFieldCoreModifier2.textFieldState : transformedTextFieldState, (i2 & 8) != 0 ? textFieldCoreModifier2.textFieldSelectionState : textFieldSelectionState2, (i2 & 16) != 0 ? textFieldCoreModifier2.cursorBrush : brush, (i2 & 32) != 0 ? textFieldCoreModifier2.writeable : z2, (i2 & 64) != 0 ? textFieldCoreModifier2.scrollState : scrollState2, (i2 & 128) != 0 ? textFieldCoreModifier2.orientation : orientation2);
    }

    public final TextFieldCoreModifier copy(boolean z, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z2, ScrollState scrollState2, Orientation orientation2) {
        return new TextFieldCoreModifier(z, textLayoutState2, transformedTextFieldState, textFieldSelectionState2, brush, z2, scrollState2, orientation2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldCoreModifier)) {
            return false;
        }
        TextFieldCoreModifier textFieldCoreModifier = (TextFieldCoreModifier) obj;
        return this.isFocused == textFieldCoreModifier.isFocused && Intrinsics.areEqual((Object) this.textLayoutState, (Object) textFieldCoreModifier.textLayoutState) && Intrinsics.areEqual((Object) this.textFieldState, (Object) textFieldCoreModifier.textFieldState) && Intrinsics.areEqual((Object) this.textFieldSelectionState, (Object) textFieldCoreModifier.textFieldSelectionState) && Intrinsics.areEqual((Object) this.cursorBrush, (Object) textFieldCoreModifier.cursorBrush) && this.writeable == textFieldCoreModifier.writeable && Intrinsics.areEqual((Object) this.scrollState, (Object) textFieldCoreModifier.scrollState) && this.orientation == textFieldCoreModifier.orientation;
    }

    public int hashCode() {
        return (((((((((((((UByte$$ExternalSyntheticBackport0.m(this.isFocused) * 31) + this.textLayoutState.hashCode()) * 31) + this.textFieldState.hashCode()) * 31) + this.textFieldSelectionState.hashCode()) * 31) + this.cursorBrush.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.writeable)) * 31) + this.scrollState.hashCode()) * 31) + this.orientation.hashCode();
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "TextFieldCoreModifier(isFocused=" + this.isFocused + ", textLayoutState=" + this.textLayoutState + ", textFieldState=" + this.textFieldState + ", textFieldSelectionState=" + this.textFieldSelectionState + ", cursorBrush=" + this.cursorBrush + ", writeable=" + this.writeable + ", scrollState=" + this.scrollState + ", orientation=" + this.orientation + ')';
    }

    public TextFieldCoreModifier(boolean z, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z2, ScrollState scrollState2, Orientation orientation2) {
        this.isFocused = z;
        this.textLayoutState = textLayoutState2;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.cursorBrush = brush;
        this.writeable = z2;
        this.scrollState = scrollState2;
        this.orientation = orientation2;
    }

    public TextFieldCoreModifierNode create() {
        return new TextFieldCoreModifierNode(this.isFocused, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation);
    }

    public void update(TextFieldCoreModifierNode textFieldCoreModifierNode) {
        textFieldCoreModifierNode.updateNode(this.isFocused, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation);
    }
}
