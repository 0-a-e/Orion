package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"modifierLocalProvider", "Landroidx/compose/ui/Modifier;", "T", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "Lkotlin/Function0;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalProvider.kt */
public final class ModifierLocalProviderKt {
    public static final <T> Modifier modifierLocalProvider(Modifier modifier, ProvidableModifierLocal<T> providableModifierLocal, Function0<? extends T> function0) {
        return modifier.then(new ModifierLocalProviderKt$modifierLocalProvider$1(providableModifierLocal, function0, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1(providableModifierLocal, function0) : InspectableValueKt.getNoInspectorInfo()));
    }
}
