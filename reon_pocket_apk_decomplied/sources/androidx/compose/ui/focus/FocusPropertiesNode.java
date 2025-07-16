package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusPropertiesNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusPropertiesScope", "Landroidx/compose/ui/focus/FocusPropertiesScope;", "(Landroidx/compose/ui/focus/FocusPropertiesScope;)V", "getFocusPropertiesScope", "()Landroidx/compose/ui/focus/FocusPropertiesScope;", "setFocusPropertiesScope", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
final class FocusPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    private FocusPropertiesScope focusPropertiesScope;

    public final FocusPropertiesScope getFocusPropertiesScope() {
        return this.focusPropertiesScope;
    }

    public final void setFocusPropertiesScope(FocusPropertiesScope focusPropertiesScope2) {
        this.focusPropertiesScope = focusPropertiesScope2;
    }

    public FocusPropertiesNode(FocusPropertiesScope focusPropertiesScope2) {
        this.focusPropertiesScope = focusPropertiesScope2;
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        this.focusPropertiesScope.apply(focusProperties);
    }
}
