package androidx.compose.ui.node;

import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R$\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/compose/ui/node/BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackwardsCompatNode.kt */
public final class BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 implements ModifierLocalReadScope {
    BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1() {
    }

    public <T> T getCurrent(ModifierLocal<T> modifierLocal) {
        return modifierLocal.getDefaultFactory$ui_release().invoke();
    }
}
