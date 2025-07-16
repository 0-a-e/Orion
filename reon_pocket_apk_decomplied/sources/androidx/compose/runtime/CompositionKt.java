package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a$\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001c\u0010\u0014\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a$\u0010\u0014\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001a\u0010\u0015\u001a\u00020\u00162\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001aI\u0010\u0017\u001a\u00020\u0018\"\b\b\u0000\u0010\u0019*\u00020\u0006\"\b\b\u0001\u0010\u001a*\u00020\u0006*\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u001a\u0018\u00010\u001c0\u001b2\u0006\u0010\u001d\u001a\u0002H\u00192\u0006\u0010\u001e\u001a\u0002H\u001aH\u0002¢\u0006\u0002\u0010\u001f\u001a'\u0010 \u001a\u0004\u0018\u0001H!\"\u0004\b\u0000\u0010!*\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H!0\u0001H\u0000¢\u0006\u0002\u0010\"\u001a7\u0010#\u001a\u00020\u0018\"\u0004\b\u0000\u0010$*\u0012\u0012\u0004\u0012\u0002H$0%j\b\u0012\u0004\u0012\u0002H$`&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020)0(H\b\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0007\u001a\u00020\b*\u00020\t8GX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006*"}, d2 = {"CompositionImplServiceKey", "Landroidx/compose/runtime/CompositionServiceKey;", "Landroidx/compose/runtime/CompositionImpl;", "getCompositionImplServiceKey", "()Landroidx/compose/runtime/CompositionServiceKey;", "PendingApplyNoModifications", "", "recomposeCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/compose/runtime/ControlledComposition;", "getRecomposeCoroutineContext$annotations", "(Landroidx/compose/runtime/ControlledComposition;)V", "getRecomposeCoroutineContext", "(Landroidx/compose/runtime/ControlledComposition;)Lkotlin/coroutines/CoroutineContext;", "Composition", "Landroidx/compose/runtime/Composition;", "applier", "Landroidx/compose/runtime/Applier;", "parent", "Landroidx/compose/runtime/CompositionContext;", "ControlledComposition", "ReusableComposition", "Landroidx/compose/runtime/ReusableComposition;", "addValue", "", "K", "V", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "key", "value", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Ljava/lang/Object;Ljava/lang/Object;)V", "getCompositionService", "T", "(Landroidx/compose/runtime/Composition;Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "removeValueIf", "E", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "predicate", "Lkotlin/Function1;", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composition.kt */
public final class CompositionKt {
    private static final CompositionServiceKey<CompositionImpl> CompositionImplServiceKey = new CompositionKt$CompositionImplServiceKey$1();
    /* access modifiers changed from: private */
    public static final Object PendingApplyNoModifications = new Object();

    public static /* synthetic */ void getRecomposeCoroutineContext$annotations(ControlledComposition controlledComposition) {
    }

    public static final <T> T getCompositionService(Composition composition, CompositionServiceKey<T> compositionServiceKey) {
        CompositionServices compositionServices = composition instanceof CompositionServices ? (CompositionServices) composition : null;
        if (compositionServices != null) {
            return compositionServices.getCompositionService(compositionServiceKey);
        }
        return null;
    }

    public static final CoroutineContext getRecomposeCoroutineContext(ControlledComposition controlledComposition) {
        CoroutineContext recomposeContext;
        CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
        return (compositionImpl == null || (recomposeContext = compositionImpl.getRecomposeContext()) == null) ? EmptyCoroutineContext.INSTANCE : recomposeContext;
    }

    public static final Composition Composition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier, (CoroutineContext) null, 4, (DefaultConstructorMarker) null);
    }

    public static final ReusableComposition ReusableComposition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier, (CoroutineContext) null, 4, (DefaultConstructorMarker) null);
    }

    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier, (CoroutineContext) null, 4, (DefaultConstructorMarker) null);
    }

    public static final Composition Composition(Applier<?> applier, CompositionContext compositionContext, CoroutineContext coroutineContext) {
        return new CompositionImpl(compositionContext, applier, coroutineContext);
    }

    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext compositionContext, CoroutineContext coroutineContext) {
        return new CompositionImpl(compositionContext, applier, coroutineContext);
    }

    public static final CompositionServiceKey<CompositionImpl> getCompositionImplServiceKey() {
        return CompositionImplServiceKey;
    }

    /* access modifiers changed from: private */
    public static final <K, V> void addValue(IdentityArrayMap<K, IdentityArraySet<V>> identityArrayMap, K k, V v) {
        if (identityArrayMap.contains(k)) {
            IdentityArraySet identityArraySet = identityArrayMap.get(k);
            if (identityArraySet != null) {
                identityArraySet.add(v);
                return;
            }
            return;
        }
        IdentityArraySet identityArraySet2 = new IdentityArraySet();
        identityArraySet2.add(v);
        Unit unit = Unit.INSTANCE;
        identityArrayMap.set(k, identityArraySet2);
    }

    private static final <E> void removeValueIf(HashSet<E> hashSet, Function1<? super E, Boolean> function1) {
        Iterator<E> it = hashSet.iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                it.remove();
            }
        }
    }
}
