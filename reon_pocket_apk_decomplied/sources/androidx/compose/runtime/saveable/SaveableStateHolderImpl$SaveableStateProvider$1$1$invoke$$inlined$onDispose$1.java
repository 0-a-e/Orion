package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Object $key$inlined;
    final /* synthetic */ SaveableStateHolderImpl.RegistryHolder $registryHolder$inlined;
    final /* synthetic */ SaveableStateHolderImpl this$0;

    public SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1(SaveableStateHolderImpl.RegistryHolder registryHolder, SaveableStateHolderImpl saveableStateHolderImpl, Object obj) {
        this.$registryHolder$inlined = registryHolder;
        this.this$0 = saveableStateHolderImpl;
        this.$key$inlined = obj;
    }

    public void dispose() {
        this.$registryHolder$inlined.saveTo(this.this$0.savedStates);
        this.this$0.registryHolders.remove(this.$key$inlined);
    }
}
