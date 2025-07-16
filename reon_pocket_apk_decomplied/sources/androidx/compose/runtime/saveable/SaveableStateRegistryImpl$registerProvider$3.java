package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/runtime/saveable/SaveableStateRegistryImpl$registerProvider$3", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "unregister", "", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SaveableStateRegistry.kt */
public final class SaveableStateRegistryImpl$registerProvider$3 implements SaveableStateRegistry.Entry {
    final /* synthetic */ String $key;
    final /* synthetic */ Function0<Object> $valueProvider;
    final /* synthetic */ SaveableStateRegistryImpl this$0;

    SaveableStateRegistryImpl$registerProvider$3(SaveableStateRegistryImpl saveableStateRegistryImpl, String str, Function0<? extends Object> function0) {
        this.this$0 = saveableStateRegistryImpl;
        this.$key = str;
        this.$valueProvider = function0;
    }

    public void unregister() {
        List list = (List) this.this$0.valueProviders.remove(this.$key);
        if (list != null) {
            list.remove(this.$valueProvider);
        }
        if (list != null && (!list.isEmpty())) {
            this.this$0.valueProviders.put(this.$key, list);
        }
    }
}
