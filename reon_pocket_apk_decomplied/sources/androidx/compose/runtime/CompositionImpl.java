package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002£\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010X\u001a\u00020\u0019H\u0002J\u001e\u0010Y\u001a\u00020\u00192\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010[\u001a\u00020\u0012H\u0002J\b\u0010\\\u001a\u00020\u0019H\u0016J\u0010\u0010]\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010^\u001a\u00020\u0019H\u0016J\b\u0010_\u001a\u00020\u0019H\u0016J\b\u0010`\u001a\u00020\u0019H\u0002J \u0010a\u001a\u00020\u00192\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001eJ \u0010c\u001a\u00020\u00192\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010d\u001a\u00020\u0019H\u0016J3\u0010e\u001a\u0002Hf\"\u0004\b\u0000\u0010f2\b\u0010g\u001a\u0004\u0018\u00010\u00012\u0006\u0010h\u001a\u0002072\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hf0\u0018H\u0016¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020\u0019H\u0016J\u0010\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020nH\u0016J\b\u0010o\u001a\u00020\u0019H\u0002J\b\u0010p\u001a\u00020\u0019H\u0002J#\u0010q\u001a\u0004\u0018\u0001Hr\"\u0004\b\u0000\u0010r2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0tH\u0016¢\u0006\u0002\u0010uJ\"\u0010v\u001a\u0002Hr\"\u0004\b\u0000\u0010r2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hr0\u0018H\b¢\u0006\u0002\u0010wJK\u0010x\u001a\u0002Hr\"\u0004\b\u0000\u0010r25\u0010i\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020$\u0012\f\u0012\n\u0012\u0004\u0012\u00020*\u0018\u00010:09¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002Hr0yH\b¢\u0006\u0002\u0010|J&\u0010}\u001a\u00020\u00192\u001c\u0010~\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0005\u0012\u00030\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u000100#H\u0016J\u001e\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020$2\t\u0010\u0001\u001a\u0004\u0018\u00010*H\u0016J\t\u0010\u0001\u001a\u00020\u0019H\u0016J(\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020$2\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010*H\u0002J\u000f\u0010\u0001\u001a\u00020\u00192\u0006\u0010s\u001a\u000207J\u0012\u0010\u0001\u001a\u00020\u00192\u0007\u0010\u0001\u001a\u00020*H\u0002J\u001a\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0017\u0010\u0001\u001a\u00020\u00122\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u0017\u0010\u0001\u001a\u00020\u00192\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\t\u0010\u0001\u001a\u00020\u0012H\u0016J\u0012\u0010\u0001\u001a\u00020\u00192\u0007\u0010\u0001\u001a\u00020$H\u0016J\u0017\u0010\u0001\u001a\u00020\u00192\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u0012\u0010\u0001\u001a\u00020\u00192\u0007\u0010\u0001\u001a\u00020*H\u0016J\u0012\u0010\u0001\u001a\u00020\u00192\u0007\u0010\u0001\u001a\u00020*H\u0016J\u001b\u0010\u0001\u001a\u00020\u00192\n\u0010m\u001a\u0006\u0012\u0002\b\u00030/H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00020\u00192\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020$H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00020\u00192\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001eJ!\u0010\u0001\u001a\u00020\u00192\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u0001\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\f\u0012\n\u0012\u0004\u0012\u00020*\u0018\u00010:09H\u0002J#\u0010\u0001\u001a\u0002Hr\"\u0004\b\u0000\u0010r2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hr0\u0018H\b¢\u0006\u0002\u0010wJ\u001d\u0010 \u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020$2\t\u0010\u0001\u001a\u0004\u0018\u00010*H\u0002J\u0011\u0010¡\u0001\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0002J\t\u0010¢\u0001\u001a\u00020\u0019H\u0016JE\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020$\u0018\u0001`\u0010*\u0016\u0012\u0004\u0012\u00020$\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020$\u0018\u0001`\u00102\u0007\u0010\u0001\u001a\u00020*2\u0006\u0010[\u001a\u00020\u0012H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#8AX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020$0\u000ej\b\u0012\u0004\u0012\u00020$`\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8AX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0018\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030/0.X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0014R\u0014\u00103\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0014R\u0010\u00105\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\f\u0012\n\u0012\u0004\u0012\u00020*\u0018\u00010:09X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0014R\u0014\u0010<\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0014R\u0011\u0010=\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0014R\u000e\u0010>\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020$0.X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020$0.X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020*0)8AX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010,R\u0014\u0010D\u001a\u00020EX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010H\u001a\u00020\u0012X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010MR\"\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010*0Oj\n\u0012\u0006\u0012\u0004\u0018\u00010*`PX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010J\u001a\u0004\bV\u0010W¨\u0006¤\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "", "getDerivedStateDependencies$runtime_release", "()Ljava/util/Set;", "derivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release$annotations", "()V", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "values", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "composeInitial", "deactivate", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "invalidateScopeOfLocked", "value", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observe$runtime_release", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "setContentWithReuse", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composition.kt */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices {
    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    /* access modifiers changed from: private */
    public final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final ScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public final ScopeMap<RecomposeScopeImpl> observations;
    private final ScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    public static /* synthetic */ void getPendingInvalidScopes$runtime_release$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime_release$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier2, CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier2;
        this.pendingModifications = new AtomicReference<>((Object) null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable2 = new SlotTable();
        this.slotTable = slotTable2;
        this.observations = new ScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new ScopeMap<>();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = new ScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        this.observerHolder = new CompositionObserverHolder((CompositionObserver) null, false, 3, (DefaultConstructorMarker) null);
        ComposerImpl composerImpl = new ComposerImpl(applier2, compositionContext, slotTable2, hashSet, changeList, changeList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m3257getLambda1$runtime_release();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier2, (i & 4) != 0 ? null : coroutineContext);
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public final Set<Object> getObservedObjects$runtime_release() {
        return this.observations.getMap().asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime_release() {
        return this.derivedStates.getMap().asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes);
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public final CompositionObserverHolder getObserverHolder$runtime_release() {
        return this.observerHolder;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    public void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        composeInitial(function2);
    }

    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composer.startReuseFromRoot();
        composeInitial(function2);
        this.composer.endReuseFromRoot();
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!this.disposed) {
            this.composable = function2;
            this.parent.composeInitial$runtime_release(this, function2);
            return;
        }
        throw new IllegalStateException("The composition is disposed".toString());
    }

    public final CompositionObserverHandle observe$runtime_release(CompositionObserver compositionObserver) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(compositionObserver);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionImpl$observe$2(this, compositionObserver);
    }

    public final void invalidateGroupsWithKey(int i) {
        List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release;
        synchronized (this.lock) {
            invalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(i);
        }
        if (invalidateGroupsWithKey$runtime_release != null) {
            int size = invalidateGroupsWithKey$runtime_release.size();
            int i2 = 0;
            while (i2 < size) {
                if (invalidateGroupsWithKey$runtime_release.get(i2).invalidateForResult((Object) null) != InvalidationResult.IGNORED) {
                    i2++;
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet == null) {
            return;
        }
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            ComposerKt.composeRuntimeError("pending composition has not been applied");
            throw new KotlinNothingValueException();
        } else if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, true);
        } else if (andSet instanceof Object[]) {
            for (Set addPendingInvalidationsLocked : (Set[]) andSet) {
                addPendingInvalidationsLocked(addPendingInvalidationsLocked, true);
            }
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet((Object) null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
        } else if (andSet instanceof Object[]) {
            for (Set addPendingInvalidationsLocked : (Set[]) andSet) {
                addPendingInvalidationsLocked(addPendingInvalidationsLocked, false);
            }
        } else if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    public void composeContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations = takeInvalidations();
                try {
                    CompositionObserver observer = observer();
                    if (observer != null) {
                        Map<RecomposeScopeImpl, IdentityArraySet<Object>> asMap = takeInvalidations.asMap();
                        Intrinsics.checkNotNull(asMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                        observer.onBeginComposition(this, asMap);
                    }
                    this.composer.composeContent$runtime_release(takeInvalidations, function2);
                    if (observer != null) {
                        observer.onEndComposition(this);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.invalidations = takeInvalidations;
                    throw e;
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e2) {
                abandonChanges();
                throw e2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void dispose() {
        synchronized (this.lock) {
            if (!this.composer.isComposing$runtime_release()) {
                if (!this.disposed) {
                    this.disposed = true;
                    this.composable = ComposableSingletons$CompositionKt.INSTANCE.m3258getLambda2$runtime_release();
                    ChangeList deferredChanges$runtime_release = this.composer.getDeferredChanges$runtime_release();
                    if (deferredChanges$runtime_release != null) {
                        applyChangesInLocked(deferredChanges$runtime_release);
                    }
                    boolean z = this.slotTable.getGroupsSize() > 0;
                    if (z || (true ^ this.abandonSet.isEmpty())) {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter openWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                                Unit unit = Unit.INSTANCE;
                                openWriter.close();
                                this.applier.clear();
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                openWriter.close();
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    }
                    this.composer.dispose$runtime_release();
                }
                Unit unit2 = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.".toString());
            }
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.util.Set[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recordModificationsOf(java.util.Set<? extends java.lang.Object> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r4.pendingModifications
            java.lang.Object r0 = r0.get()
            r1 = 1
            if (r0 != 0) goto L_0x000b
            r2 = r1
            goto L_0x0013
        L_0x000b:
            java.lang.Object r2 = androidx.compose.runtime.CompositionKt.PendingApplyNoModifications
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
        L_0x0013:
            if (r2 == 0) goto L_0x0017
            r2 = r5
            goto L_0x0034
        L_0x0017:
            boolean r2 = r0 instanceof java.util.Set
            if (r2 == 0) goto L_0x0024
            r2 = 2
            java.util.Set[] r2 = new java.util.Set[r2]
            r3 = 0
            r2[r3] = r0
            r2[r1] = r5
            goto L_0x0034
        L_0x0024:
            boolean r1 = r0 instanceof java.lang.Object[]
            if (r1 == 0) goto L_0x004c
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r1 = r0
            java.util.Set[] r1 = (java.util.Set[]) r1
            java.lang.Object[] r2 = kotlin.collections.ArraysKt.plus((T[]) r1, r5)
        L_0x0034:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r4.pendingModifications
            boolean r1 = androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0.m(r1, r0, r2)
            if (r1 == 0) goto L_0x0000
            if (r0 != 0) goto L_0x004b
            java.lang.Object r5 = r4.lock
            monitor-enter(r5)
            r4.drainPendingModificationsLocked()     // Catch:{ all -> 0x0048 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)
            goto L_0x004b
        L_0x0048:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x004b:
            return
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "corrupt pendingModifications: "
            r0.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r4.pendingModifications
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordModificationsOf(java.util.Set):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.runtime.collection.IdentityArraySet
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0030
            androidx.compose.runtime.collection.IdentityArraySet r7 = (androidx.compose.runtime.collection.IdentityArraySet) r7
            java.lang.Object[] r0 = r7.getValues()
            int r7 = r7.size()
            r3 = r2
        L_0x0011:
            if (r3 >= r7) goto L_0x002f
            r4 = r0[r3]
            java.lang.String r5 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r5)
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r5 = r6.observations
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto L_0x002e
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.DerivedState<?>> r5 = r6.derivedStates
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x002e:
            return r1
        L_0x002f:
            return r2
        L_0x0030:
            java.util.Iterator r7 = r7.iterator()
        L_0x0034:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x004f
            java.lang.Object r0 = r7.next()
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r3 = r6.observations
            boolean r3 = r3.contains(r0)
            if (r3 != 0) goto L_0x004e
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.DerivedState<?>> r3 = r6.derivedStates
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x0034
        L_0x004e:
            return r1
        L_0x004f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    public void prepareCompose(Function0<Unit> function0) {
        this.composer.prepareCompose$runtime_release(function0);
    }

    private final HashSet<RecomposeScopeImpl> addPendingInvalidationsLocked(HashSet<RecomposeScopeImpl> hashSet, Object obj, boolean z) {
        HashSet<RecomposeScopeImpl> hashSet2;
        Object obj2 = obj;
        Object obj3 = this.observations.getMap().get(obj2);
        if (obj3 != null) {
            if (obj3 instanceof MutableScatterSet) {
                ScatterSet scatterSet = (MutableScatterSet) obj3;
                Object[] objArr = scatterSet.elements;
                long[] jArr = scatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    hashSet2 = hashSet;
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                                    if (!this.observationsProcessed.remove(obj2, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj2) != InvalidationResult.IGNORED) {
                                        if (!recomposeScopeImpl.isConditional() || z) {
                                            if (hashSet2 == null) {
                                                hashSet2 = new HashSet<>();
                                            }
                                            hashSet2.add(recomposeScopeImpl);
                                        } else {
                                            this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                        }
                                    }
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            }
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                    }
                } else {
                    hashSet2 = hashSet;
                }
                return hashSet2;
            }
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj3;
            if (!this.observationsProcessed.remove(obj2, recomposeScopeImpl2) && recomposeScopeImpl2.invalidateForResult(obj2) != InvalidationResult.IGNORED) {
                if (!recomposeScopeImpl2.isConditional() || z) {
                    HashSet<RecomposeScopeImpl> hashSet3 = hashSet == null ? new HashSet<>() : hashSet;
                    hashSet3.add(recomposeScopeImpl2);
                    return hashSet3;
                }
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            }
        }
        return hashSet;
    }

    private final void cleanUpDerivedStateObservations() {
        long[] jArr;
        int i;
        int i2;
        long[] jArr2;
        long j;
        int i3;
        boolean z;
        Object[] objArr;
        Object[] objArr2;
        MutableScatterMap<Object, Object> map = this.derivedStates.getMap();
        long[] jArr3 = map.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i4 = 0;
            while (true) {
                long j2 = jArr3[i4];
                char c = 7;
                long j3 = -9187201950435737472L;
                if ((((~j2) << 7) & j2 & -9187201950435737472L) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j2 & 255) < 128) {
                            int i8 = (i4 << 3) + i7;
                            Object obj = map.keys[i8];
                            Object obj2 = map.values[i8];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr3 = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                int length2 = jArr4.length - 2;
                                jArr2 = jArr3;
                                i2 = length;
                                if (length2 >= 0) {
                                    int i9 = 0;
                                    while (true) {
                                        long j4 = jArr4[i9];
                                        i = i6;
                                        long[] jArr5 = jArr4;
                                        j = -9187201950435737472L;
                                        if ((((~j4) << c) & j4 & -9187201950435737472L) != -9187201950435737472L) {
                                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                            int i11 = 0;
                                            while (i11 < i10) {
                                                if ((j4 & 255) < 128) {
                                                    int i12 = (i9 << 3) + i11;
                                                    objArr2 = objArr3;
                                                    if (!this.observations.contains((DerivedState) objArr3[i12])) {
                                                        mutableScatterSet.removeElementAt(i12);
                                                    }
                                                } else {
                                                    objArr2 = objArr3;
                                                }
                                                j4 >>= 8;
                                                i11++;
                                                objArr3 = objArr2;
                                            }
                                            objArr = objArr3;
                                            if (i10 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                        }
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        c = 7;
                                        i6 = i;
                                        jArr4 = jArr5;
                                        objArr3 = objArr;
                                    }
                                } else {
                                    i = i6;
                                    j = -9187201950435737472L;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr3;
                                i2 = length;
                                i = i6;
                                j = j3;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                                z = !this.observations.contains((DerivedState) obj2);
                            }
                            if (z) {
                                map.removeValueAt(i8);
                            }
                            i3 = 8;
                        } else {
                            jArr2 = jArr3;
                            i2 = length;
                            i = i6;
                            j = j3;
                            i3 = i5;
                        }
                        j2 >>= i3;
                        i7++;
                        i5 = i3;
                        j3 = j;
                        jArr3 = jArr2;
                        length = i2;
                        i6 = i;
                        c = 7;
                    }
                    jArr = jArr3;
                    int i13 = length;
                    if (i6 != i5) {
                        break;
                    }
                    length = i13;
                } else {
                    jArr = jArr3;
                }
                if (i4 == length) {
                    break;
                }
                i4++;
                jArr3 = jArr;
            }
        }
        if (!this.conditionallyInvalidatedScopes.isEmpty()) {
            Iterator<RecomposeScopeImpl> it = this.conditionallyInvalidatedScopes.iterator();
            while (it.hasNext()) {
                if (!it.next().isConditional()) {
                    it.remove();
                }
            }
        }
    }

    public void recordReadOf(Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        Object obj2 = obj;
        if (!getAreChildrenComposing() && (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) != null) {
            currentRecomposeScope$runtime_release.setUsed(true);
            if (!currentRecomposeScope$runtime_release.recordRead(obj2)) {
                if (obj2 instanceof StateObjectImpl) {
                    ReaderKind.Companion companion = ReaderKind.Companion;
                    ((StateObjectImpl) obj2).m3416recordReadInh_f27i8$runtime_release(ReaderKind.m3402constructorimpl(1));
                }
                this.observations.add(obj2, currentRecomposeScope$runtime_release);
                if (obj2 instanceof DerivedState) {
                    this.derivedStates.removeScope(obj2);
                    ObjectIntMap<StateObject> dependencies = ((DerivedState) obj2).getCurrentRecord().getDependencies();
                    Object[] objArr = dependencies.keys;
                    long[] jArr = dependencies.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        StateObject stateObject = (StateObject) objArr[(i << 3) + i3];
                                        if (stateObject instanceof StateObjectImpl) {
                                            ReaderKind.Companion companion2 = ReaderKind.Companion;
                                            ((StateObjectImpl) stateObject).m3416recordReadInh_f27i8$runtime_release(ReaderKind.m3402constructorimpl(1));
                                        }
                                        this.derivedStates.add(stateObject, obj2);
                                    }
                                    j >>= 8;
                                }
                                if (i2 != 8) {
                                    return;
                                }
                            }
                            if (i != length) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private final void invalidateScopeOfLocked(Object obj) {
        Object obj2 = this.observations.getMap().get(obj);
        if (obj2 == null) {
            return;
        }
        if (obj2 instanceof MutableScatterSet) {
            ScatterSet scatterSet = (MutableScatterSet) obj2;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            return;
                        }
                    }
                    if (i != length) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj2;
            if (recomposeScopeImpl2.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                this.observationsProcessed.add(obj, recomposeScopeImpl2);
            }
        }
    }

    public void recordWriteOf(Object obj) {
        synchronized (this.lock) {
            invalidateScopeOfLocked(obj);
            Object obj2 = this.derivedStates.getMap().get(obj);
            if (obj2 != null) {
                if (obj2 instanceof MutableScatterSet) {
                    ScatterSet scatterSet = (MutableScatterSet) obj2;
                    Object[] objArr = scatterSet.elements;
                    long[] jArr = scatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i3]);
                                    }
                                    j >>= 8;
                                }
                                if (i2 != 8) {
                                    break;
                                }
                            }
                            if (i == length) {
                                break;
                            }
                            i++;
                        }
                    }
                } else {
                    invalidateScopeOfLocked((DerivedState) obj2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean recompose() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations;
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                takeInvalidations = takeInvalidations();
                CompositionObserver observer = observer();
                if (observer != null) {
                    Map<RecomposeScopeImpl, IdentityArraySet<Object>> asMap = takeInvalidations.asMap();
                    Intrinsics.checkNotNull(asMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                    observer.onBeginComposition(this, asMap);
                }
                recompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations);
                if (!recompose$runtime_release) {
                    drainPendingModificationsLocked();
                }
                if (observer != null) {
                    observer.onEndComposition(this);
                }
            } catch (Exception e) {
                this.invalidations = takeInvalidations;
                throw e;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e2) {
                    abandonChanges();
                    throw e2;
                }
            }
        }
        return recompose$runtime_release;
    }

    /* JADX INFO: finally extract failed */
    public void disposeUnusedMovableContent(MovableContentState movableContentState) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = movableContentState.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            openWriter.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void applyChangesInLocked(androidx.compose.runtime.changelist.ChangeList r32) {
        /*
            r31 = this;
            r1 = r31
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r2 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r0 = r1.abandonSet
            java.util.Set r0 = (java.util.Set) r0
            r2.<init>(r0)
            boolean r0 = r32.isEmpty()     // Catch:{ all -> 0x01ed }
            if (r0 == 0) goto L_0x001d
            androidx.compose.runtime.changelist.ChangeList r0 = r1.lateChanges
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001c
            r2.dispatchAbandons()
        L_0x001c:
            return
        L_0x001d:
            java.lang.String r0 = "Compose:applyChanges"
            androidx.compose.runtime.Trace r3 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01ed }
            java.lang.Object r3 = r3.beginSection(r0)     // Catch:{ all -> 0x01ed }
            androidx.compose.runtime.Applier<?> r0 = r1.applier     // Catch:{ all -> 0x01e2 }
            r0.onBeginChanges()     // Catch:{ all -> 0x01e2 }
            androidx.compose.runtime.SlotTable r0 = r1.slotTable     // Catch:{ all -> 0x01e2 }
            androidx.compose.runtime.SlotWriter r4 = r0.openWriter()     // Catch:{ all -> 0x01e2 }
            androidx.compose.runtime.Applier<?> r0 = r1.applier     // Catch:{ all -> 0x01d9 }
            r5 = r2
            androidx.compose.runtime.RememberManager r5 = (androidx.compose.runtime.RememberManager) r5     // Catch:{ all -> 0x01d9 }
            r6 = r32
            r6.executeAndFlushAllPendingChanges(r0, r4, r5)     // Catch:{ all -> 0x01d9 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01d9 }
            r4.close()     // Catch:{ all -> 0x01e2 }
            androidx.compose.runtime.Applier<?> r0 = r1.applier     // Catch:{ all -> 0x01e2 }
            r0.onEndChanges()     // Catch:{ all -> 0x01e2 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01e2 }
            androidx.compose.runtime.Trace r0 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01ed }
            r0.endSection(r3)     // Catch:{ all -> 0x01ed }
            r2.dispatchRememberObservers()     // Catch:{ all -> 0x01ed }
            r2.dispatchSideEffects()     // Catch:{ all -> 0x01ed }
            boolean r0 = r1.pendingInvalidScopes     // Catch:{ all -> 0x01ed }
            if (r0 == 0) goto L_0x01c9
            java.lang.String r0 = "Compose:unobserve"
            androidx.compose.runtime.Trace r3 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01c3 }
            java.lang.Object r3 = r3.beginSection(r0)     // Catch:{ all -> 0x01c3 }
            r0 = 0
            r1.pendingInvalidScopes = r0     // Catch:{ all -> 0x01b8 }
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r4 = r1.observations     // Catch:{ all -> 0x01b8 }
            androidx.collection.MutableScatterMap r4 = r4.getMap()     // Catch:{ all -> 0x01b8 }
            r5 = r4
            androidx.collection.ScatterMap r5 = (androidx.collection.ScatterMap) r5     // Catch:{ all -> 0x01b8 }
            long[] r5 = r5.metadata     // Catch:{ all -> 0x01b8 }
            int r6 = r5.length     // Catch:{ all -> 0x01b8 }
            int r6 = r6 + -2
            if (r6 < 0) goto L_0x01a9
            r7 = r0
        L_0x0071:
            r8 = r5[r7]     // Catch:{ all -> 0x01b8 }
            long r10 = ~r8     // Catch:{ all -> 0x01b8 }
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r13
            int r10 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x0197
            int r10 = r7 - r6
            int r10 = ~r10     // Catch:{ all -> 0x01b8 }
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r15 = r0
        L_0x008b:
            if (r15 >= r10) goto L_0x0187
            r16 = 255(0xff, double:1.26E-321)
            long r18 = r8 & r16
            r20 = 128(0x80, double:6.32E-322)
            int r18 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r18 >= 0) goto L_0x0165
            int r18 = r7 << 3
            int r0 = r18 + r15
            java.lang.Object[] r11 = r4.keys     // Catch:{ all -> 0x01b8 }
            r11 = r11[r0]     // Catch:{ all -> 0x01b8 }
            java.lang.Object[] r11 = r4.values     // Catch:{ all -> 0x01b8 }
            r11 = r11[r0]     // Catch:{ all -> 0x01b8 }
            boolean r13 = r11 instanceof androidx.collection.MutableScatterSet     // Catch:{ all -> 0x01b8 }
            if (r13 == 0) goto L_0x013b
            java.lang.String r13 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r13)     // Catch:{ all -> 0x01b8 }
            androidx.collection.MutableScatterSet r11 = (androidx.collection.MutableScatterSet) r11     // Catch:{ all -> 0x01b8 }
            java.lang.Object[] r13 = r11.elements     // Catch:{ all -> 0x01b8 }
            r14 = r11
            androidx.collection.ScatterSet r14 = (androidx.collection.ScatterSet) r14     // Catch:{ all -> 0x01b8 }
            long[] r14 = r14.metadata     // Catch:{ all -> 0x01b8 }
            int r12 = r14.length     // Catch:{ all -> 0x01b8 }
            int r12 = r12 + -2
            r26 = r2
            r25 = r5
            if (r12 < 0) goto L_0x012b
            r5 = 0
        L_0x00bf:
            r1 = r14[r5]     // Catch:{ all -> 0x01b6 }
            r27 = r6
            r28 = r7
            long r6 = ~r1     // Catch:{ all -> 0x01b6 }
            r24 = 7
            long r6 = r6 << r24
            long r6 = r6 & r1
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r22
            int r6 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r6 == 0) goto L_0x011c
            int r6 = r5 - r12
            int r6 = ~r6     // Catch:{ all -> 0x01b6 }
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r7 = 0
        L_0x00e0:
            if (r7 >= r6) goto L_0x0113
            long r29 = r1 & r16
            int r29 = (r29 > r20 ? 1 : (r29 == r20 ? 0 : -1))
            if (r29 >= 0) goto L_0x00eb
            r29 = 1
            goto L_0x00ed
        L_0x00eb:
            r29 = 0
        L_0x00ed:
            if (r29 == 0) goto L_0x0107
            int r29 = r5 << 3
            r30 = r14
            int r14 = r29 + r7
            r29 = r13[r14]     // Catch:{ all -> 0x01b6 }
            androidx.compose.runtime.RecomposeScopeImpl r29 = (androidx.compose.runtime.RecomposeScopeImpl) r29     // Catch:{ all -> 0x01b6 }
            boolean r29 = r29.getValid()     // Catch:{ all -> 0x01b6 }
            r19 = 1
            r29 = r29 ^ 1
            if (r29 == 0) goto L_0x010b
            r11.removeElementAt(r14)     // Catch:{ all -> 0x01b6 }
            goto L_0x010b
        L_0x0107:
            r30 = r14
            r19 = 1
        L_0x010b:
            r14 = 8
            long r1 = r1 >> r14
            int r7 = r7 + 1
            r14 = r30
            goto L_0x00e0
        L_0x0113:
            r30 = r14
            r14 = 8
            r19 = 1
            if (r6 != r14) goto L_0x0136
            goto L_0x0120
        L_0x011c:
            r30 = r14
            r19 = 1
        L_0x0120:
            if (r5 == r12) goto L_0x0136
            int r5 = r5 + 1
            r6 = r27
            r7 = r28
            r14 = r30
            goto L_0x00bf
        L_0x012b:
            r27 = r6
            r28 = r7
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r24 = 7
        L_0x0136:
            boolean r14 = r11.isEmpty()     // Catch:{ all -> 0x01b6 }
            goto L_0x015d
        L_0x013b:
            r26 = r2
            r25 = r5
            r27 = r6
            r28 = r7
            r24 = r12
            r19 = 1
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            java.lang.String r1 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r1)     // Catch:{ all -> 0x01b6 }
            androidx.compose.runtime.RecomposeScopeImpl r11 = (androidx.compose.runtime.RecomposeScopeImpl) r11     // Catch:{ all -> 0x01b6 }
            boolean r1 = r11.getValid()     // Catch:{ all -> 0x01b6 }
            if (r1 != 0) goto L_0x015c
            r14 = r19
            goto L_0x015d
        L_0x015c:
            r14 = 0
        L_0x015d:
            if (r14 == 0) goto L_0x0162
            r4.removeValueAt(r0)     // Catch:{ all -> 0x01b6 }
        L_0x0162:
            r0 = 8
            goto L_0x0172
        L_0x0165:
            r26 = r2
            r25 = r5
            r27 = r6
            r28 = r7
            r24 = r12
            r22 = r13
            r0 = r11
        L_0x0172:
            long r8 = r8 >> r0
            int r15 = r15 + 1
            r1 = r31
            r11 = r0
            r13 = r22
            r12 = r24
            r5 = r25
            r2 = r26
            r6 = r27
            r7 = r28
            r0 = 0
            goto L_0x008b
        L_0x0187:
            r26 = r2
            r25 = r5
            r27 = r6
            r28 = r7
            r0 = r11
            if (r10 != r0) goto L_0x01ab
            r6 = r27
            r0 = r28
            goto L_0x019c
        L_0x0197:
            r26 = r2
            r25 = r5
            r0 = r7
        L_0x019c:
            if (r0 == r6) goto L_0x01ab
            int r7 = r0 + 1
            r1 = r31
            r5 = r25
            r2 = r26
            r0 = 0
            goto L_0x0071
        L_0x01a9:
            r26 = r2
        L_0x01ab:
            r31.cleanUpDerivedStateObservations()     // Catch:{ all -> 0x01b6 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01b6 }
            androidx.compose.runtime.Trace r0 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01c1 }
            r0.endSection(r3)     // Catch:{ all -> 0x01c1 }
            goto L_0x01cb
        L_0x01b6:
            r0 = move-exception
            goto L_0x01bb
        L_0x01b8:
            r0 = move-exception
            r26 = r2
        L_0x01bb:
            androidx.compose.runtime.Trace r1 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01c1 }
            r1.endSection(r3)     // Catch:{ all -> 0x01c1 }
            throw r0     // Catch:{ all -> 0x01c1 }
        L_0x01c1:
            r0 = move-exception
            goto L_0x01c6
        L_0x01c3:
            r0 = move-exception
            r26 = r2
        L_0x01c6:
            r1 = r31
            goto L_0x01f0
        L_0x01c9:
            r26 = r2
        L_0x01cb:
            r1 = r31
            androidx.compose.runtime.changelist.ChangeList r0 = r1.lateChanges
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01d8
            r26.dispatchAbandons()
        L_0x01d8:
            return
        L_0x01d9:
            r0 = move-exception
            r26 = r2
            r4.close()     // Catch:{ all -> 0x01e0 }
            throw r0     // Catch:{ all -> 0x01e0 }
        L_0x01e0:
            r0 = move-exception
            goto L_0x01e5
        L_0x01e2:
            r0 = move-exception
            r26 = r2
        L_0x01e5:
            androidx.compose.runtime.Trace r2 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01eb }
            r2.endSection(r3)     // Catch:{ all -> 0x01eb }
            throw r0     // Catch:{ all -> 0x01eb }
        L_0x01eb:
            r0 = move-exception
            goto L_0x01f0
        L_0x01ed:
            r0 = move-exception
            r26 = r2
        L_0x01f0:
            androidx.compose.runtime.changelist.ChangeList r2 = r1.lateChanges
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x01fb
            r26.dispatchAbandons()
        L_0x01fb:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.applyChangesInLocked(androidx.compose.runtime.changelist.ChangeList):void");
    }

    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            } catch (Throwable th) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            }
        }
    }

    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            } catch (Throwable th) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            }
        }
    }

    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            } catch (Throwable th) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>>, ? extends T> function1) {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations = takeInvalidations();
        try {
            return function1.invoke(takeInvalidations);
        } catch (Exception e) {
            this.invalidations = takeInvalidations;
            throw e;
        }
    }

    private final void abandonChanges() {
        this.pendingModifications.set((Object) null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public <R> R delegateInvalidations(ControlledComposition controlledComposition, int i, Function0<? extends R> function0) {
        if (controlledComposition == null || Intrinsics.areEqual((Object) controlledComposition, (Object) this) || i < 0) {
            return function0.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) controlledComposition;
        this.invalidationDelegateGroup = i;
        try {
            return function0.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    public InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        CompositionImpl compositionImpl;
        if (recomposeScopeImpl.getDefaultsInScope()) {
            recomposeScopeImpl.setDefaultsInvalid(true);
        }
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            if (compositionImpl == null || !compositionImpl.tryImminentInvalidation(recomposeScopeImpl, obj)) {
                return InvalidationResult.IGNORED;
            }
            return InvalidationResult.IMMINENT;
        } else if (!recomposeScopeImpl.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        } else {
            return invalidateChecked(recomposeScopeImpl, anchor, obj);
        }
    }

    public void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl) {
        this.pendingInvalidScopes = true;
    }

    public <T> T getCompositionService(CompositionServiceKey<T> compositionServiceKey) {
        if (Intrinsics.areEqual((Object) compositionServiceKey, (Object) CompositionKt.getCompositionImplServiceKey())) {
            return this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r1 == null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        return r1.invalidateChecked(r6, r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        r5.parent.invalidate$runtime_release(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        if (isComposing() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return androidx.compose.runtime.InvalidationResult.SCHEDULED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return androidx.compose.runtime.InvalidationResult.DEFERRED;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r6, androidx.compose.runtime.Anchor r7, java.lang.Object r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            androidx.compose.runtime.CompositionImpl r1 = r5.invalidationDelegate     // Catch:{ all -> 0x0049 }
            r2 = 0
            if (r1 == 0) goto L_0x0013
            androidx.compose.runtime.SlotTable r3 = r5.slotTable     // Catch:{ all -> 0x0049 }
            int r4 = r5.invalidationDelegateGroup     // Catch:{ all -> 0x0049 }
            boolean r3 = r3.groupContainsAnchor(r4, r7)     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            if (r1 != 0) goto L_0x002d
            boolean r3 = r5.tryImminentInvalidation(r6, r8)     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0020
            androidx.compose.runtime.InvalidationResult r6 = androidx.compose.runtime.InvalidationResult.IMMINENT     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)
            return r6
        L_0x0020:
            if (r8 != 0) goto L_0x0028
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>> r3 = r5.invalidations     // Catch:{ all -> 0x0049 }
            r3.set(r6, r2)     // Catch:{ all -> 0x0049 }
            goto L_0x002d
        L_0x0028:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>> r2 = r5.invalidations     // Catch:{ all -> 0x0049 }
            androidx.compose.runtime.CompositionKt.addValue(r2, r6, r8)     // Catch:{ all -> 0x0049 }
        L_0x002d:
            monitor-exit(r0)
            if (r1 == 0) goto L_0x0035
            androidx.compose.runtime.InvalidationResult r6 = r1.invalidateChecked(r6, r7, r8)
            return r6
        L_0x0035:
            androidx.compose.runtime.CompositionContext r6 = r5.parent
            r7 = r5
            androidx.compose.runtime.ControlledComposition r7 = (androidx.compose.runtime.ControlledComposition) r7
            r6.invalidate$runtime_release(r7)
            boolean r6 = r5.isComposing()
            if (r6 == 0) goto L_0x0046
            androidx.compose.runtime.InvalidationResult r6 = androidx.compose.runtime.InvalidationResult.DEFERRED
            goto L_0x0048
        L_0x0046:
            androidx.compose.runtime.InvalidationResult r6 = androidx.compose.runtime.InvalidationResult.SCHEDULED
        L_0x0048:
            return r6
        L_0x0049:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void removeObservation$runtime_release(Object obj, RecomposeScopeImpl recomposeScopeImpl) {
        this.observations.remove(obj, recomposeScopeImpl);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> derivedState) {
        if (!this.observations.contains(derivedState)) {
            this.derivedStates.removeScope(derivedState);
        }
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        return identityArrayMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable2) {
        Object[] slots = slotTable2.getSlots();
        Collection arrayList = new ArrayList();
        int i = 0;
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        List list = (List) arrayList;
        int size = list.size();
        while (i < size) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) list.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor == null || slotTable2.slotsOf$runtime_release(anchor.toIndexFor(slotTable2)).contains(recomposeScopeImpl2)) {
                i++;
            } else {
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((T[]) slotTable2.getSlots(), recomposeScopeImpl2)).toString());
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> function0) {
        try {
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder compositionObserverHolder = this.observerHolder;
        if (compositionObserverHolder.getRoot()) {
            return compositionObserverHolder.getObserver();
        }
        CompositionObserverHolder observerHolder$runtime_release = this.parent.getObserverHolder$runtime_release();
        CompositionObserver observer = observerHolder$runtime_release != null ? observerHolder$runtime_release.getObserver() : null;
        if (!Intrinsics.areEqual((Object) observer, (Object) compositionObserverHolder.getObserver())) {
            compositionObserverHolder.setObserver(observer);
        }
        return observer;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0010\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "forgetting", "", "", "releasing", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "remembering", "sideEffects", "Lkotlin/Function0;", "", "deactivating", "instance", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composition.kt */
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private final List<Object> forgetting = new ArrayList();
        private MutableScatterSet<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();

        public RememberEventDispatcher(Set<RememberObserver> set) {
            this.abandoning = set;
        }

        public void remembering(RememberObserver rememberObserver) {
            this.remembering.add(rememberObserver);
        }

        public void forgetting(RememberObserver rememberObserver) {
            this.forgetting.add(rememberObserver);
        }

        public void sideEffect(Function0<Unit> function0) {
            this.sideEffects.add(function0);
        }

        public void deactivating(ComposeNodeLifecycleCallback composeNodeLifecycleCallback) {
            this.forgetting.add(composeNodeLifecycleCallback);
        }

        public void releasing(ComposeNodeLifecycleCallback composeNodeLifecycleCallback) {
            MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSet = this.releasing;
            if (mutableScatterSet == null) {
                mutableScatterSet = ScatterSetKt.mutableScatterSetOf();
                this.releasing = mutableScatterSet;
            }
            mutableScatterSet.plusAssign(composeNodeLifecycleCallback);
            this.forgetting.add(composeNodeLifecycleCallback);
        }

        public final void dispatchRememberObservers() {
            if (!this.forgetting.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSet = this.releasing;
                    for (int size = this.forgetting.size() - 1; -1 < size; size--) {
                        Object obj = this.forgetting.get(size);
                        TypeIntrinsics.asMutableCollection(this.abandoning).remove(obj);
                        if (obj instanceof RememberObserver) {
                            ((RememberObserver) obj).onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            if (mutableScatterSet == null || !mutableScatterSet.contains(obj)) {
                                ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                            } else {
                                ((ComposeNodeLifecycleCallback) obj).onRelease();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
            if (!this.remembering.isEmpty()) {
                Object beginSection2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List<RememberObserver> list = this.remembering;
                    int size2 = list.size();
                    for (int i = 0; i < size2; i++) {
                        RememberObserver rememberObserver = list.get(i);
                        this.abandoning.remove(rememberObserver);
                        rememberObserver.onRemembered();
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection2);
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List<Function0<Unit>> list = this.sideEffects;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        list.get(i).invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator<RememberObserver> it = this.abandoning.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        it.next().onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }
    }

    public void deactivate() {
        SlotWriter openWriter;
        boolean z = this.slotTable.getGroupsSize() > 0;
        if (z || (true ^ this.abandonSet.isEmpty())) {
            Object beginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
            try {
                RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                if (z) {
                    this.applier.onBeginChanges();
                    openWriter = this.slotTable.openWriter();
                    ComposerKt.deactivateCurrentGroup(openWriter, rememberEventDispatcher);
                    Unit unit = Unit.INSTANCE;
                    openWriter.close();
                    this.applier.onEndChanges();
                    rememberEventDispatcher.dispatchRememberObservers();
                }
                rememberEventDispatcher.dispatchAbandons();
                Unit unit2 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(beginSection);
                throw th;
            }
        }
        this.observations.clear();
        this.derivedStates.clear();
        this.invalidations.clear();
        this.changes.clear();
        this.composer.deactivate$runtime_release();
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0211 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0209  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r32, boolean r33) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r2 = r33
            boolean r3 = r1 instanceof androidx.compose.runtime.collection.IdentityArraySet
            r8 = 7
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r13 = 0
            if (r3 == 0) goto L_0x00af
            androidx.compose.runtime.collection.IdentityArraySet r1 = (androidx.compose.runtime.collection.IdentityArraySet) r1
            java.lang.Object[] r3 = r1.getValues()
            int r1 = r1.size()
            r15 = r13
            r14 = 0
        L_0x001d:
            if (r14 >= r1) goto L_0x0138
            r12 = r3[r14]
            java.lang.String r4 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r4)
            boolean r4 = r12 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r4 == 0) goto L_0x0031
            androidx.compose.runtime.RecomposeScopeImpl r12 = (androidx.compose.runtime.RecomposeScopeImpl) r12
            r12.invalidateForResult(r13)
            goto L_0x00a5
        L_0x0031:
            java.util.HashSet r4 = r0.addPendingInvalidationsLocked(r15, r12, r2)
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.DerivedState<?>> r5 = r0.derivedStates
            androidx.collection.MutableScatterMap r5 = r5.getMap()
            java.lang.Object r5 = r5.get(r12)
            if (r5 == 0) goto L_0x00a4
            boolean r12 = r5 instanceof androidx.collection.MutableScatterSet
            if (r12 == 0) goto L_0x009e
            androidx.collection.MutableScatterSet r5 = (androidx.collection.MutableScatterSet) r5
            androidx.collection.ScatterSet r5 = (androidx.collection.ScatterSet) r5
            java.lang.Object[] r12 = r5.elements
            long[] r5 = r5.metadata
            int r15 = r5.length
            int r15 = r15 + -2
            if (r15 < 0) goto L_0x00a4
            r13 = 0
        L_0x0053:
            r6 = r5[r13]
            r32 = r12
            long r11 = ~r6
            long r11 = r11 << r8
            long r11 = r11 & r6
            long r11 = r11 & r9
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0092
            int r11 = r13 - r15
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r12 = 0
        L_0x0069:
            if (r12 >= r11) goto L_0x008e
            r19 = 255(0xff, double:1.26E-321)
            long r21 = r6 & r19
            r16 = 128(0x80, double:6.32E-322)
            int r21 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r21 >= 0) goto L_0x0083
            int r21 = r13 << 3
            int r21 = r21 + r12
            r21 = r32[r21]
            r9 = r21
            androidx.compose.runtime.DerivedState r9 = (androidx.compose.runtime.DerivedState) r9
            java.util.HashSet r4 = r0.addPendingInvalidationsLocked(r4, r9, r2)
        L_0x0083:
            r9 = 8
            long r6 = r6 >> r9
            int r12 = r12 + 1
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            goto L_0x0069
        L_0x008e:
            r9 = 8
            if (r11 != r9) goto L_0x00a4
        L_0x0092:
            if (r13 == r15) goto L_0x00a4
            int r13 = r13 + 1
            r12 = r32
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            goto L_0x0053
        L_0x009e:
            androidx.compose.runtime.DerivedState r5 = (androidx.compose.runtime.DerivedState) r5
            java.util.HashSet r4 = r0.addPendingInvalidationsLocked(r4, r5, r2)
        L_0x00a4:
            r15 = r4
        L_0x00a5:
            int r14 = r14 + 1
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r13 = 0
            goto L_0x001d
        L_0x00af:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r15 = 0
        L_0x00b6:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0138
            java.lang.Object r3 = r1.next()
            boolean r4 = r3 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r4 == 0) goto L_0x00cb
            androidx.compose.runtime.RecomposeScopeImpl r3 = (androidx.compose.runtime.RecomposeScopeImpl) r3
            r4 = 0
            r3.invalidateForResult(r4)
            goto L_0x00b6
        L_0x00cb:
            r4 = 0
            java.util.HashSet r5 = r0.addPendingInvalidationsLocked(r15, r3, r2)
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.DerivedState<?>> r6 = r0.derivedStates
            androidx.collection.MutableScatterMap r6 = r6.getMap()
            java.lang.Object r3 = r6.get(r3)
            if (r3 == 0) goto L_0x0135
            boolean r6 = r3 instanceof androidx.collection.MutableScatterSet
            if (r6 == 0) goto L_0x012d
            androidx.collection.MutableScatterSet r3 = (androidx.collection.MutableScatterSet) r3
            androidx.collection.ScatterSet r3 = (androidx.collection.ScatterSet) r3
            java.lang.Object[] r6 = r3.elements
            long[] r3 = r3.metadata
            int r7 = r3.length
            int r7 = r7 + -2
            if (r7 < 0) goto L_0x0135
            r9 = 0
        L_0x00ee:
            r10 = r3[r9]
            long r12 = ~r10
            long r12 = r12 << r8
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L_0x0128
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r13 = 0
        L_0x0107:
            if (r13 >= r12) goto L_0x0124
            r14 = 255(0xff, double:1.26E-321)
            long r24 = r10 & r14
            r14 = 128(0x80, double:6.32E-322)
            int r18 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r18 >= 0) goto L_0x011e
            int r14 = r9 << 3
            int r14 = r14 + r13
            r14 = r6[r14]
            androidx.compose.runtime.DerivedState r14 = (androidx.compose.runtime.DerivedState) r14
            java.util.HashSet r5 = r0.addPendingInvalidationsLocked(r5, r14, r2)
        L_0x011e:
            r14 = 8
            long r10 = r10 >> r14
            int r13 = r13 + 1
            goto L_0x0107
        L_0x0124:
            r14 = 8
            if (r12 != r14) goto L_0x0135
        L_0x0128:
            if (r9 == r7) goto L_0x0135
            int r9 = r9 + 1
            goto L_0x00ee
        L_0x012d:
            androidx.compose.runtime.DerivedState r3 = (androidx.compose.runtime.DerivedState) r3
            java.util.HashSet r3 = r0.addPendingInvalidationsLocked(r5, r3, r2)
            r15 = r3
            goto L_0x00b6
        L_0x0135:
            r15 = r5
            goto L_0x00b6
        L_0x0138:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>"
            java.lang.String r3 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1"
            r4 = 1
            if (r2 == 0) goto L_0x02c9
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r2 = r0.conditionallyInvalidatedScopes
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x02c9
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r2 = r0.observations
            androidx.collection.MutableScatterMap r2 = r2.getMap()
            r5 = r2
            androidx.collection.ScatterMap r5 = (androidx.collection.ScatterMap) r5
            long[] r5 = r5.metadata
            int r6 = r5.length
            int r6 = r6 + -2
            if (r6 < 0) goto L_0x02bd
            r7 = 0
        L_0x015b:
            r9 = r5[r7]
            long r11 = ~r9
            long r11 = r11 << r8
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x02ab
            int r11 = r7 - r6
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r12 = 0
        L_0x0174:
            if (r12 >= r11) goto L_0x029a
            r13 = 255(0xff, double:1.26E-321)
            long r24 = r9 & r13
            r13 = 128(0x80, double:6.32E-322)
            int r18 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r18 >= 0) goto L_0x027a
            int r13 = r7 << 3
            int r13 = r13 + r12
            java.lang.Object[] r14 = r2.keys
            r14 = r14[r13]
            java.lang.Object[] r14 = r2.values
            r14 = r14[r13]
            boolean r4 = r14 instanceof androidx.collection.MutableScatterSet
            if (r4 == 0) goto L_0x0245
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r1)
            androidx.collection.MutableScatterSet r14 = (androidx.collection.MutableScatterSet) r14
            java.lang.Object[] r4 = r14.elements
            r8 = r14
            androidx.collection.ScatterSet r8 = (androidx.collection.ScatterSet) r8
            long[] r8 = r8.metadata
            r21 = r5
            int r5 = r8.length
            int r5 = r5 + -2
            r24 = r1
            r33 = r6
            r25 = r7
            if (r5 < 0) goto L_0x023a
            r1 = 0
        L_0x01a9:
            r6 = r8[r1]
            r26 = r11
            r27 = r12
            long r11 = ~r6
            r18 = 7
            long r11 = r11 << r18
            long r11 = r11 & r6
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r22
            int r11 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r11 == 0) goto L_0x0226
            int r11 = r1 - r5
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r12 = 0
        L_0x01ca:
            if (r12 >= r11) goto L_0x021d
            r19 = 255(0xff, double:1.26E-321)
            long r28 = r6 & r19
            r16 = 128(0x80, double:6.32E-322)
            int r28 = (r28 > r16 ? 1 : (r28 == r16 ? 0 : -1))
            if (r28 >= 0) goto L_0x01d9
            r28 = 1
            goto L_0x01db
        L_0x01d9:
            r28 = 0
        L_0x01db:
            if (r28 == 0) goto L_0x020d
            int r28 = r1 << 3
            r29 = r8
            int r8 = r28 + r12
            r28 = r4[r8]
            r30 = r4
            r4 = r28
            androidx.compose.runtime.RecomposeScopeImpl r4 = (androidx.compose.runtime.RecomposeScopeImpl) r4
            java.util.HashSet r0 = r31.conditionallyInvalidatedScopes
            boolean r0 = r0.contains(r4)
            if (r0 != 0) goto L_0x0206
            if (r15 == 0) goto L_0x0200
            boolean r0 = r15.contains(r4)
            r4 = 1
            if (r0 != r4) goto L_0x0200
            r4 = 1
            goto L_0x0201
        L_0x0200:
            r4 = 0
        L_0x0201:
            if (r4 == 0) goto L_0x0204
            goto L_0x0206
        L_0x0204:
            r4 = 0
            goto L_0x0207
        L_0x0206:
            r4 = 1
        L_0x0207:
            if (r4 == 0) goto L_0x0211
            r14.removeElementAt(r8)
            goto L_0x0211
        L_0x020d:
            r30 = r4
            r29 = r8
        L_0x0211:
            r0 = 8
            long r6 = r6 >> r0
            int r12 = r12 + 1
            r0 = r31
            r8 = r29
            r4 = r30
            goto L_0x01ca
        L_0x021d:
            r30 = r4
            r29 = r8
            r0 = 8
            if (r11 != r0) goto L_0x023e
            goto L_0x022a
        L_0x0226:
            r30 = r4
            r29 = r8
        L_0x022a:
            if (r1 == r5) goto L_0x023e
            int r1 = r1 + 1
            r0 = r31
            r11 = r26
            r12 = r27
            r8 = r29
            r4 = r30
            goto L_0x01a9
        L_0x023a:
            r26 = r11
            r27 = r12
        L_0x023e:
            boolean r4 = r14.isEmpty()
            r0 = r4
            r4 = 1
            goto L_0x0274
        L_0x0245:
            r24 = r1
            r21 = r5
            r33 = r6
            r25 = r7
            r26 = r11
            r27 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r3)
            androidx.compose.runtime.RecomposeScopeImpl r14 = (androidx.compose.runtime.RecomposeScopeImpl) r14
            java.util.HashSet r0 = r31.conditionallyInvalidatedScopes
            boolean r0 = r0.contains(r14)
            if (r0 != 0) goto L_0x0272
            if (r15 == 0) goto L_0x026b
            boolean r0 = r15.contains(r14)
            r4 = 1
            if (r0 != r4) goto L_0x026c
            r0 = r4
            goto L_0x026d
        L_0x026b:
            r4 = 1
        L_0x026c:
            r0 = 0
        L_0x026d:
            if (r0 == 0) goto L_0x0270
            goto L_0x0273
        L_0x0270:
            r0 = 0
            goto L_0x0274
        L_0x0272:
            r4 = 1
        L_0x0273:
            r0 = r4
        L_0x0274:
            if (r0 == 0) goto L_0x0286
            r2.removeValueAt(r13)
            goto L_0x0286
        L_0x027a:
            r24 = r1
            r21 = r5
            r33 = r6
            r25 = r7
            r26 = r11
            r27 = r12
        L_0x0286:
            r0 = 8
            long r9 = r9 >> r0
            int r12 = r27 + 1
            r8 = 7
            r0 = r31
            r6 = r33
            r5 = r21
            r1 = r24
            r7 = r25
            r11 = r26
            goto L_0x0174
        L_0x029a:
            r24 = r1
            r21 = r5
            r33 = r6
            r25 = r7
            r0 = 8
            if (r11 != r0) goto L_0x02bd
            r6 = r33
            r0 = r25
            goto L_0x02b0
        L_0x02ab:
            r24 = r1
            r21 = r5
            r0 = r7
        L_0x02b0:
            if (r0 == r6) goto L_0x02bd
            int r7 = r0 + 1
            r8 = 7
            r0 = r31
            r5 = r21
            r1 = r24
            goto L_0x015b
        L_0x02bd:
            r0 = r31
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r1 = r0.conditionallyInvalidatedScopes
            r1.clear()
            r31.cleanUpDerivedStateObservations()
            goto L_0x0447
        L_0x02c9:
            r24 = r1
            if (r15 == 0) goto L_0x0447
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r1 = r0.observations
            androidx.collection.MutableScatterMap r1 = r1.getMap()
            r2 = r1
            androidx.collection.ScatterMap r2 = (androidx.collection.ScatterMap) r2
            long[] r2 = r2.metadata
            int r5 = r2.length
            int r5 = r5 + -2
            if (r5 < 0) goto L_0x0440
            r6 = 0
        L_0x02de:
            r7 = r2[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x0421
            int r9 = r6 - r5
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r11 = 8 - r9
            r9 = 0
        L_0x02f8:
            if (r9 >= r11) goto L_0x0405
            r12 = 255(0xff, double:1.26E-321)
            long r25 = r7 & r12
            r12 = 128(0x80, double:6.32E-322)
            int r10 = (r25 > r12 ? 1 : (r25 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x03dd
            int r10 = r6 << 3
            int r10 = r10 + r9
            java.lang.Object[] r12 = r1.keys
            r12 = r12[r10]
            java.lang.Object[] r12 = r1.values
            r12 = r12[r10]
            boolean r13 = r12 instanceof androidx.collection.MutableScatterSet
            if (r13 == 0) goto L_0x03b9
            r13 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)
            androidx.collection.MutableScatterSet r12 = (androidx.collection.MutableScatterSet) r12
            java.lang.Object[] r14 = r12.elements
            r4 = r12
            androidx.collection.ScatterSet r4 = (androidx.collection.ScatterSet) r4
            long[] r4 = r4.metadata
            int r0 = r4.length
            int r0 = r0 + -2
            r21 = r2
            r33 = r5
            r24 = r6
            if (r0 < 0) goto L_0x03a5
            r2 = 0
        L_0x032d:
            r5 = r4[r2]
            r25 = r7
            long r7 = ~r5
            r18 = 7
            long r7 = r7 << r18
            long r7 = r7 & r5
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r22
            int r7 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r7 == 0) goto L_0x0392
            int r7 = r2 - r0
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r8 = 0
        L_0x034c:
            if (r8 >= r7) goto L_0x0385
            r19 = 255(0xff, double:1.26E-321)
            long r27 = r5 & r19
            r16 = 128(0x80, double:6.32E-322)
            int r27 = (r27 > r16 ? 1 : (r27 == r16 ? 0 : -1))
            if (r27 >= 0) goto L_0x035b
            r27 = 1
            goto L_0x035d
        L_0x035b:
            r27 = 0
        L_0x035d:
            if (r27 == 0) goto L_0x0377
            int r27 = r2 << 3
            r28 = r4
            int r4 = r27 + r8
            r27 = r14[r4]
            r29 = r13
            r13 = r27
            androidx.compose.runtime.RecomposeScopeImpl r13 = (androidx.compose.runtime.RecomposeScopeImpl) r13
            boolean r13 = r15.contains(r13)
            if (r13 == 0) goto L_0x037b
            r12.removeElementAt(r4)
            goto L_0x037b
        L_0x0377:
            r28 = r4
            r29 = r13
        L_0x037b:
            r4 = 8
            long r5 = r5 >> r4
            int r8 = r8 + 1
            r4 = r28
            r13 = r29
            goto L_0x034c
        L_0x0385:
            r28 = r4
            r29 = r13
            r4 = 8
            r16 = 128(0x80, double:6.32E-322)
            r19 = 255(0xff, double:1.26E-321)
            if (r7 != r4) goto L_0x03b4
            goto L_0x039a
        L_0x0392:
            r28 = r4
            r29 = r13
            r16 = 128(0x80, double:6.32E-322)
            r19 = 255(0xff, double:1.26E-321)
        L_0x039a:
            if (r2 == r0) goto L_0x03b4
            int r2 = r2 + 1
            r7 = r25
            r4 = r28
            r13 = r29
            goto L_0x032d
        L_0x03a5:
            r25 = r7
            r29 = r13
            r16 = 128(0x80, double:6.32E-322)
            r18 = 7
            r19 = 255(0xff, double:1.26E-321)
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
        L_0x03b4:
            boolean r0 = r12.isEmpty()
            goto L_0x03d7
        L_0x03b9:
            r21 = r2
            r33 = r5
            r25 = r7
            r29 = r24
            r16 = 128(0x80, double:6.32E-322)
            r18 = 7
            r19 = 255(0xff, double:1.26E-321)
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r24 = r6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r3)
            androidx.compose.runtime.RecomposeScopeImpl r12 = (androidx.compose.runtime.RecomposeScopeImpl) r12
            boolean r0 = r15.contains(r12)
        L_0x03d7:
            if (r0 == 0) goto L_0x03f2
            r1.removeValueAt(r10)
            goto L_0x03f2
        L_0x03dd:
            r21 = r2
            r33 = r5
            r25 = r7
            r29 = r24
            r16 = 128(0x80, double:6.32E-322)
            r18 = 7
            r19 = 255(0xff, double:1.26E-321)
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r24 = r6
        L_0x03f2:
            r0 = 8
            long r7 = r25 >> r0
            int r9 = r9 + 1
            r4 = 1
            r0 = r31
            r5 = r33
            r2 = r21
            r6 = r24
            r24 = r29
            goto L_0x02f8
        L_0x0405:
            r21 = r2
            r33 = r5
            r29 = r24
            r0 = 8
            r16 = 128(0x80, double:6.32E-322)
            r18 = 7
            r19 = 255(0xff, double:1.26E-321)
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r24 = r6
            if (r11 != r0) goto L_0x0440
            r5 = r33
            r2 = r24
            goto L_0x0433
        L_0x0421:
            r21 = r2
            r29 = r24
            r0 = 8
            r16 = 128(0x80, double:6.32E-322)
            r18 = 7
            r19 = 255(0xff, double:1.26E-321)
            r22 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r2 = r6
        L_0x0433:
            if (r2 == r5) goto L_0x0440
            int r6 = r2 + 1
            r4 = 1
            r0 = r31
            r2 = r21
            r24 = r29
            goto L_0x02de
        L_0x0440:
            r31.cleanUpDerivedStateObservations()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0447:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual((Object) ((MovableContentStateReference) list.get(i).getFirst()).getComposition$runtime_release(), (Object) this)) {
                break;
            } else {
                i++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(list);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            abandonChanges();
            throw e;
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }

    private final <T> T guardChanges(Function0<? extends T> function0) {
        try {
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Exception e) {
            abandonChanges();
            throw e;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
