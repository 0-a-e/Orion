package androidx.compose.runtime.tooling;

import androidx.compose.runtime.RecomposeScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/tooling/RecomposeScopeObserver;", "", "onBeginScopeComposition", "", "scope", "Landroidx/compose/runtime/RecomposeScope;", "onEndScopeComposition", "onScopeDisposed", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionObserver.kt */
public interface RecomposeScopeObserver {
    void onBeginScopeComposition(RecomposeScope recomposeScope);

    void onEndScopeComposition(RecomposeScope recomposeScope);

    void onScopeDisposed(RecomposeScope recomposeScope);
}
