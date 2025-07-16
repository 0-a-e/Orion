package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00126\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0018\u001a\u00020\bHÂ\u0003J\t\u0010\u0019\u001a\u00020\nHÂ\u0003J9\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014HÂ\u0003Jk\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n28\b\u0002\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014HÆ\u0001J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0002H\u0016J\f\u0010&\u001a\u00020\u0013*\u00020'H\u0016R>\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TextFieldTextLayoutModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text2/input/internal/TextFieldTextLayoutModifierNode;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;)V", "component1", "component2", "component3", "component4", "component5", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldTextLayoutModifier.kt */
public final class TextFieldTextLayoutModifier extends ModifierNodeElement<TextFieldTextLayoutModifierNode> {
    public static final int $stable = 0;
    private final Function2<Density, Function0<TextLayoutResult>, Unit> onTextLayout;
    private final boolean singleLine;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final TextStyle textStyle;

    private final TextLayoutState component1() {
        return this.textLayoutState;
    }

    private final TransformedTextFieldState component2() {
        return this.textFieldState;
    }

    private final TextStyle component3() {
        return this.textStyle;
    }

    private final boolean component4() {
        return this.singleLine;
    }

    private final Function2<Density, Function0<TextLayoutResult>, Unit> component5() {
        return this.onTextLayout;
    }

    public static /* synthetic */ TextFieldTextLayoutModifier copy$default(TextFieldTextLayoutModifier textFieldTextLayoutModifier, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle2, boolean z, Function2<Density, Function0<TextLayoutResult>, Unit> function2, int i, Object obj) {
        if ((i & 1) != 0) {
            textLayoutState2 = textFieldTextLayoutModifier.textLayoutState;
        }
        if ((i & 2) != 0) {
            transformedTextFieldState = textFieldTextLayoutModifier.textFieldState;
        }
        TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
        if ((i & 4) != 0) {
            textStyle2 = textFieldTextLayoutModifier.textStyle;
        }
        TextStyle textStyle3 = textStyle2;
        if ((i & 8) != 0) {
            z = textFieldTextLayoutModifier.singleLine;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            function2 = textFieldTextLayoutModifier.onTextLayout;
        }
        return textFieldTextLayoutModifier.copy(textLayoutState2, transformedTextFieldState2, textStyle3, z2, function2);
    }

    public final TextFieldTextLayoutModifier copy(TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle2, boolean z, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        return new TextFieldTextLayoutModifier(textLayoutState2, transformedTextFieldState, textStyle2, z, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldTextLayoutModifier)) {
            return false;
        }
        TextFieldTextLayoutModifier textFieldTextLayoutModifier = (TextFieldTextLayoutModifier) obj;
        return Intrinsics.areEqual((Object) this.textLayoutState, (Object) textFieldTextLayoutModifier.textLayoutState) && Intrinsics.areEqual((Object) this.textFieldState, (Object) textFieldTextLayoutModifier.textFieldState) && Intrinsics.areEqual((Object) this.textStyle, (Object) textFieldTextLayoutModifier.textStyle) && this.singleLine == textFieldTextLayoutModifier.singleLine && Intrinsics.areEqual((Object) this.onTextLayout, (Object) textFieldTextLayoutModifier.onTextLayout);
    }

    public int hashCode() {
        int hashCode = ((((((this.textLayoutState.hashCode() * 31) + this.textFieldState.hashCode()) * 31) + this.textStyle.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.singleLine)) * 31;
        Function2<Density, Function0<TextLayoutResult>, Unit> function2 = this.onTextLayout;
        return hashCode + (function2 == null ? 0 : function2.hashCode());
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "TextFieldTextLayoutModifier(textLayoutState=" + this.textLayoutState + ", textFieldState=" + this.textFieldState + ", textStyle=" + this.textStyle + ", singleLine=" + this.singleLine + ", onTextLayout=" + this.onTextLayout + ')';
    }

    public TextFieldTextLayoutModifier(TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle2, boolean z, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.textLayoutState = textLayoutState2;
        this.textFieldState = transformedTextFieldState;
        this.textStyle = textStyle2;
        this.singleLine = z;
        this.onTextLayout = function2;
    }

    public TextFieldTextLayoutModifierNode create() {
        return new TextFieldTextLayoutModifierNode(this.textLayoutState, this.textFieldState, this.textStyle, this.singleLine, this.onTextLayout);
    }

    public void update(TextFieldTextLayoutModifierNode textFieldTextLayoutModifierNode) {
        textFieldTextLayoutModifierNode.updateNode(this.textLayoutState, this.textFieldState, this.textStyle, this.singleLine, this.onTextLayout);
    }
}
