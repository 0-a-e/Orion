package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005:\u0001\u000bJ\b\u0010\u0006\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\u00002\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/PersistentCompositionLocalMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "builder", "Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "putValue", "key", "value", "Builder", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocalMap.kt */
public interface PersistentCompositionLocalMap extends PersistentMap<CompositionLocal<Object>, State<? extends Object>>, CompositionLocalMap {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0001J\b\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "build", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CompositionLocalMap.kt */
    public interface Builder extends PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> {
        PersistentCompositionLocalMap build();
    }

    Builder builder();

    PersistentCompositionLocalMap putValue(CompositionLocal<Object> compositionLocal, State<? extends Object> state);
}
