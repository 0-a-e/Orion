package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/gestures/ModifierLocalScrollableContainerProvider;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "enabled", "", "(Z)V", "getEnabled", "()Z", "setEnabled", "modifierLocalMap", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "providedValues", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ModifierLocalScrollableContainerProvider extends Modifier.Node implements ModifierLocalModifierNode {
    private boolean enabled;
    private final ModifierLocalMap modifierLocalMap = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(ScrollableKt.getModifierLocalScrollableContainer(), true));

    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        ModifierLocalModifierNode.CC.$default$provide(this, modifierLocal, obj);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public ModifierLocalScrollableContainerProvider(boolean z) {
        this.enabled = z;
    }

    public ModifierLocalMap getProvidedValues() {
        if (this.enabled) {
            return this.modifierLocalMap;
        }
        return ModifierLocalModifierNodeKt.modifierLocalMapOf();
    }
}
