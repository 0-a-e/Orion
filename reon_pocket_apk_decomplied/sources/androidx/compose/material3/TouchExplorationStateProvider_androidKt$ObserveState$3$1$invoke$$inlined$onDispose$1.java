package androidx.compose.material3;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class TouchExplorationStateProvider_androidKt$ObserveState$3$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ LifecycleEventObserver $observer$inlined;
    final /* synthetic */ Function0 $onDispose$inlined;
    final /* synthetic */ Lifecycle $this_ObserveState$inlined;

    public TouchExplorationStateProvider_androidKt$ObserveState$3$1$invoke$$inlined$onDispose$1(Function0 function0, Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        this.$onDispose$inlined = function0;
        this.$this_ObserveState$inlined = lifecycle;
        this.$observer$inlined = lifecycleEventObserver;
    }

    public void dispose() {
        this.$onDispose$inlined.invoke();
        this.$this_ObserveState$inlined.removeObserver(this.$observer$inlined);
    }
}
