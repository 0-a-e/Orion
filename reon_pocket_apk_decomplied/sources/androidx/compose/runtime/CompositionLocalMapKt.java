package androidx.compose.runtime;

import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0000\u001a%\u0010\r\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0000¢\u0006\u0002\u0010\u000e\u001a=\u0010\u000f\u001a\u00020\u0001*\u00020\u00012.\u0010\u0010\u001a*\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00140\u0012\u0012\u0004\u0012\u00020\u00150\u0011H\b\u001a%\u0010\u0016\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0000¢\u0006\u0002\u0010\u000e¨\u0006\u0017"}, d2 = {"updateCompositionMap", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "previous", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/PersistentCompositionLocalMap;)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "contains", "", "T", "key", "Landroidx/compose/runtime/CompositionLocal;", "getValueOf", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "mutate", "mutator", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/State;", "", "read", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocalMap.kt */
public final class CompositionLocalMapKt {
    public static final PersistentCompositionLocalMap mutate(PersistentCompositionLocalMap persistentCompositionLocalMap, Function1<? super Map<CompositionLocal<Object>, State<Object>>, Unit> function1) {
        PersistentCompositionLocalMap.Builder builder = persistentCompositionLocalMap.builder();
        function1.invoke(builder);
        return builder.build();
    }

    public static final <T> boolean contains(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        return persistentCompositionLocalMap.containsKey(compositionLocal);
    }

    public static final <T> T getValueOf(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        State state = (State) persistentCompositionLocalMap.get(compositionLocal);
        if (state != null) {
            return state.getValue();
        }
        return null;
    }

    public static final <T> T read(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal<T> compositionLocal) {
        if (contains(persistentCompositionLocalMap, compositionLocal)) {
            return getValueOf(persistentCompositionLocalMap, compositionLocal);
        }
        return compositionLocal.getDefaultValueHolder$runtime_release().getValue();
    }

    public static /* synthetic */ PersistentCompositionLocalMap updateCompositionMap$default(ProvidedValue[] providedValueArr, PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2, int i, Object obj) {
        if ((i & 4) != 0) {
            persistentCompositionLocalMap2 = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        }
        return updateCompositionMap(providedValueArr, persistentCompositionLocalMap, persistentCompositionLocalMap2);
    }

    public static final PersistentCompositionLocalMap updateCompositionMap(ProvidedValue<?>[] providedValueArr, PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentCompositionLocalMap.Builder builder = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf().builder();
        PersistentMap persistentMap = persistentCompositionLocalMap2;
        for (ProvidedValue<?> providedValue : providedValueArr) {
            CompositionLocal<?> compositionLocal = providedValue.getCompositionLocal();
            Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
            ProvidableCompositionLocal providableCompositionLocal = (ProvidableCompositionLocal) compositionLocal;
            if (providedValue.getCanOverride() || !contains(persistentCompositionLocalMap, providableCompositionLocal)) {
                builder.put(providableCompositionLocal, providableCompositionLocal.updatedStateOf$runtime_release(providedValue.getValue(), (State) persistentMap.get(providableCompositionLocal)));
            }
        }
        return builder.build();
    }
}
