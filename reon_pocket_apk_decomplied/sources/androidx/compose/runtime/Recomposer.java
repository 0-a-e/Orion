package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ¹\u00012\u00020\u0001:\n¹\u0001º\u0001»\u0001¼\u0001½\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u0007H\u0002J\u0010\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020aH\u0002J\u0006\u0010b\u001a\u00020cJ\u000e\u0010d\u001a\u00020\\H@¢\u0006\u0002\u0010eJ\u000e\u0010f\u001a\u00020\\H@¢\u0006\u0002\u0010eJ\u0006\u0010g\u001a\u00020\\J\b\u0010h\u001a\u00020\\H\u0002J\u0006\u0010i\u001a\u00020\\J*\u0010j\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u00072\u0011\u0010k\u001a\r\u0012\u0004\u0012\u00020\\0l¢\u0006\u0002\bmH\u0010¢\u0006\u0004\bn\u0010oJ:\u0010p\u001a\u0002Hq\"\u0004\b\u0000\u0010q2\u0006\u0010^\u001a\u00020\u00072\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010R2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hq0lH\b¢\u0006\u0002\u0010tJ\u0015\u0010u\u001a\u00020\\2\u0006\u0010v\u001a\u00020\u001fH\u0010¢\u0006\u0002\bwJ\u0010\u0010x\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010[H\u0002J\b\u0010y\u001a\u00020\\H\u0002J\u0015\u0010z\u001a\u00020\\2\u0006\u0010v\u001a\u00020\u001fH\u0010¢\u0006\u0002\b{J\u0015\u0010|\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u0007H\u0010¢\u0006\u0002\b}J\u0017\u0010~\u001a\u00020\\2\u0007\u0010\u001a\u00030\u0001H\u0010¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020\\H@¢\u0006\u0002\u0010eJ \u0010\u0001\u001a\u00020\\2\u0006\u0010v\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020 H\u0010¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u0004\u0018\u00010 2\u0006\u0010v\u001a\u00020\u001fH\u0010¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020\\J\u0011\u0010\u0001\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u0007H\u0002J.\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\t2\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010RH\u0002J#\u0010\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010^\u001a\u00020\u00072\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010RH\u0002J0\u0010\u0001\u001a\u00020\\2\r\u0010\u0001\u001a\b0\u0001j\u0003`\u00012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00072\t\b\u0002\u0010\u0001\u001a\u00020\u0017H\u0002J\u001e\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\\0\u00012\u0006\u0010^\u001a\u00020\u0007H\u0002JV\u0010\u0001\u001a\u00020\\2D\u0010s\u001a@\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\\0\u0001\u0012\u0006\u0012\u0004\u0018\u00010$0\u0001¢\u0006\u0003\b\u0001H@¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0017H\u0002J \u0010\u0001\u001a\u00020\\2\u0014\u0010 \u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\\0\u0001H\bJ\u001f\u0010¡\u0001\u001a\u00020\\2\u000e\u0010¢\u0001\u001a\t\u0012\u0005\u0012\u00030£\u00010'H\u0010¢\u0006\u0003\b¤\u0001J\u0017\u0010¥\u0001\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u0007H\u0010¢\u0006\u0003\b¦\u0001J\u0012\u0010§\u0001\u001a\u00020\\2\u0007\u0010¨\u0001\u001a\u00020NH\u0002J\u0011\u0010©\u0001\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u0007H\u0002J\u0017\u0010ª\u0001\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u0007H\u0010¢\u0006\u0003\b«\u0001J\u000b\u0010¬\u0001\u001a\u0004\u0018\u000106H\u0002J\u0007\u0010­\u0001\u001a\u00020\\J\t\u0010®\u0001\u001a\u00020\\H\u0002J$\u0010¯\u0001\u001a\u00020\\2\b\u0010\u0001\u001a\u00030\u00012\b\u0010°\u0001\u001a\u00030±\u0001H@¢\u0006\u0003\u0010²\u0001J\u000f\u0010³\u0001\u001a\u00020\\H@¢\u0006\u0002\u0010eJ\u0018\u0010´\u0001\u001a\u00020\\2\u0006\u0010I\u001a\u00020\u0003H@¢\u0006\u0003\u0010µ\u0001J\u0017\u0010¶\u0001\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u0007H\u0010¢\u0006\u0003\b·\u0001J.\u0010¸\u0001\u001a\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\\0\u00012\u0006\u0010^\u001a\u00020\u00072\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010RH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178PX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178PX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010$0#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00060\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)8PX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0019R\u0014\u0010;\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0019R\u0014\u0010=\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0019R\u0014\u0010?\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0019R\u0011\u0010A\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bB\u0010\u0019R\u0014\u0010C\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u0019R\u000e\u0010E\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070\t8BX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\u00038PX\u0004¢\u0006\u0006\u001a\u0004\bJ\u00102R\u0012\u0010K\u001a\u00060LR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0019R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020$0RX\u000e¢\u0006\u0002\n\u0000R \u0010S\u001a\b\u0012\u0004\u0012\u00020\f0T8FX\u0004¢\u0006\f\u0012\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u000e\u0010Y\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010[X\u000e¢\u0006\u0002\n\u0000¨\u0006¾\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "collectingSourceInformation", "getCollectingSourceInformation$runtime_release", "compositionInvalidations", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compositionsRemoved", "", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "frameClockPaused", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "getKnownCompositions", "()Ljava/util/List;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "Landroidx/compose/runtime/collection/IdentityArraySet;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "addKnownCompositionLocked", "composition", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "clearKnownCompositionsLocked", "close", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "pauseCompositionFrameClock", "performInitialMovableContentInserts", "performInsertValues", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModifications", "onEachInvalidComposition", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "removeKnownCompositionLocked", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "resetErrorState", "resumeCompositionFrameClock", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
public final class Recomposer extends CompositionContext {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);
    /* access modifiers changed from: private */
    public static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private final List<ControlledComposition> _knownCompositions = new ArrayList();
    private List<? extends ControlledComposition> _knownCompositionsCache;
    /* access modifiers changed from: private */
    public final MutableStateFlow<State> _state = StateFlowKt.MutableStateFlow(State.Inactive);
    /* access modifiers changed from: private */
    public final BroadcastFrameClock broadcastFrameClock;
    /* access modifiers changed from: private */
    public long changeCount;
    /* access modifiers changed from: private */
    public Throwable closeCause;
    /* access modifiers changed from: private */
    public final List<ControlledComposition> compositionInvalidations = new ArrayList();
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final List<MovableContentStateReference> compositionValuesAwaitingInsert = new ArrayList();
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final List<ControlledComposition> compositionsAwaitingApply = new ArrayList();
    /* access modifiers changed from: private */
    public Set<ControlledComposition> compositionsRemoved;
    /* access modifiers changed from: private */
    public int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    /* access modifiers changed from: private */
    public RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    /* access modifiers changed from: private */
    public boolean isClosed;
    /* access modifiers changed from: private */
    public final RecomposerInfoImpl recomposerInfo;
    /* access modifiers changed from: private */
    public Job runnerJob;
    /* access modifiers changed from: private */
    public IdentityArraySet<Object> snapshotInvalidations = new IdentityArraySet<>();
    /* access modifiers changed from: private */
    public final Object stateLock = new Object();
    /* access modifiers changed from: private */
    public CancellableContinuation<? super Unit> workContinuation;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    public boolean getCollectingSourceInformation$runtime_release() {
        return false;
    }

    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
    }

    public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock2 = new BroadcastFrameClock(new Recomposer$broadcastFrameClock$1(this));
        this.broadcastFrameClock = broadcastFrameClock2;
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.Key));
        Job.invokeOnCompletion(new Recomposer$effectJob$1$1(this));
        this.effectJob = Job;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock2).plus(Job);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* access modifiers changed from: private */
    public final List<ControlledComposition> getKnownCompositions() {
        List<? extends ControlledComposition> list = this._knownCompositionsCache;
        if (list == null) {
            Recomposer recomposer = this;
            List<ControlledComposition> list2 = this._knownCompositions;
            list = list2.isEmpty() ? CollectionsKt.emptyList() : new ArrayList<>(list2);
            this._knownCompositionsCache = list;
        }
        return list;
    }

    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new IdentityArraySet<>();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, (Throwable) null, 1, (Object) null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new IdentityArraySet<>();
            this.compositionInvalidations.clear();
            if (getHasBroadcastFrameClockAwaitersLocked()) {
                state = State.InactivePendingWork;
            } else {
                state = State.Inactive;
            }
        } else if ((!this.compositionInvalidations.isEmpty()) || this.snapshotInvalidations.isNotEmpty() || (!this.compositionsAwaitingApply.isEmpty()) || (!this.compositionValuesAwaitingInsert.isEmpty()) || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation<? super Unit> cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = !this.isClosed;
        }
        if (z) {
            return true;
        }
        for (Job isActive : this.effectJob.getChildren()) {
            if (isActive.isActive()) {
                return true;
            }
        }
        return false;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState access$getErrorState$p;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                access$getErrorState$p = recomposer.errorState;
            }
            return access$getErrorState$p;
        }

        public final void invalidateGroupsWithKey(int i) {
            List access$getKnownCompositions;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                access$getKnownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(access$getKnownCompositions.size());
            int size = access$getKnownCompositions.size();
            for (int i2 = 0; i2 < size; i2++) {
                ControlledComposition controlledComposition = (ControlledComposition) access$getKnownCompositions.get(i2);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            List list = arrayList;
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((CompositionImpl) list.get(i3)).invalidateGroupsWithKey(i);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List access$getKnownCompositions;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                access$getKnownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(access$getKnownCompositions.size());
            int size = access$getKnownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) access$getKnownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            List list = arrayList;
            ArrayList arrayList2 = new ArrayList(list.size());
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) list.get(i2));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m3259getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Exception exc) {
            this.recoverable = z;
            this.cause = exc;
        }

        public boolean getRecoverable() {
            return this.recoverable;
        }

        public Exception getCause() {
            return this.cause;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r0 = r6.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2 = getKnownCompositions();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0 = r6;
        r0 = r2.size();
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        if (r3 >= r0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
        r2.get(r3).recordModificationsOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r6._state.getValue().compareTo(androidx.compose.runtime.Recomposer.State.ShuttingDown) <= 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        r6.snapshotInvalidations = new androidx.compose.runtime.collection.IdentityArraySet<>();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        r0 = r6.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        if (deriveStateLocked() != null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005e, code lost:
        r1 = getHasFrameWorkLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006f, code lost:
        throw new java.lang.IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0073, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0076, code lost:
        monitor-enter(r6.stateLock);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r6.snapshotInvalidations.addAll(r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0081, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean recordComposerModifications() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.stateLock
            monitor-enter(r0)
            androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r1 = r6.snapshotInvalidations     // Catch:{ all -> 0x0088 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0011
            boolean r1 = r6.getHasFrameWorkLocked()     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)
            return r1
        L_0x0011:
            androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r1 = r6.snapshotInvalidations     // Catch:{ all -> 0x0088 }
            androidx.compose.runtime.collection.IdentityArraySet r2 = new androidx.compose.runtime.collection.IdentityArraySet     // Catch:{ all -> 0x0088 }
            r2.<init>()     // Catch:{ all -> 0x0088 }
            r6.snapshotInvalidations = r2     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)
            java.lang.Object r0 = r6.stateLock
            monitor-enter(r0)
            java.util.List r2 = r6.getKnownCompositions()     // Catch:{ all -> 0x0085 }
            monitor-exit(r0)
            r0 = r6
            androidx.compose.runtime.Recomposer r0 = (androidx.compose.runtime.Recomposer) r0     // Catch:{ all -> 0x0073 }
            int r0 = r2.size()     // Catch:{ all -> 0x0073 }
            r3 = 0
        L_0x002b:
            if (r3 >= r0) goto L_0x004e
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x0073 }
            androidx.compose.runtime.ControlledComposition r4 = (androidx.compose.runtime.ControlledComposition) r4     // Catch:{ all -> 0x0073 }
            r5 = r1
            java.util.Set r5 = (java.util.Set) r5     // Catch:{ all -> 0x0073 }
            r4.recordModificationsOf(r5)     // Catch:{ all -> 0x0073 }
            kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.runtime.Recomposer$State> r4 = r6._state     // Catch:{ all -> 0x0073 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0073 }
            androidx.compose.runtime.Recomposer$State r4 = (androidx.compose.runtime.Recomposer.State) r4     // Catch:{ all -> 0x0073 }
            androidx.compose.runtime.Recomposer$State r5 = androidx.compose.runtime.Recomposer.State.ShuttingDown     // Catch:{ all -> 0x0073 }
            java.lang.Enum r5 = (java.lang.Enum) r5     // Catch:{ all -> 0x0073 }
            int r4 = r4.compareTo(r5)     // Catch:{ all -> 0x0073 }
            if (r4 <= 0) goto L_0x004e
            int r3 = r3 + 1
            goto L_0x002b
        L_0x004e:
            androidx.compose.runtime.collection.IdentityArraySet r0 = new androidx.compose.runtime.collection.IdentityArraySet     // Catch:{ all -> 0x0073 }
            r0.<init>()     // Catch:{ all -> 0x0073 }
            r6.snapshotInvalidations = r0     // Catch:{ all -> 0x0073 }
            java.lang.Object r0 = r6.stateLock
            monitor-enter(r0)
            kotlinx.coroutines.CancellableContinuation r1 = r6.deriveStateLocked()     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x0064
            boolean r1 = r6.getHasFrameWorkLocked()     // Catch:{ all -> 0x0070 }
            monitor-exit(r0)
            return r1
        L_0x0064:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "called outside of runRecomposeAndApplyChanges"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0070 }
            r1.<init>(r2)     // Catch:{ all -> 0x0070 }
            throw r1     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0073:
            r0 = move-exception
            java.lang.Object r2 = r6.stateLock
            monitor-enter(r2)
            androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r3 = r6.snapshotInvalidations     // Catch:{ all -> 0x0082 }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x0082 }
            r3.addAll(r1)     // Catch:{ all -> 0x0082 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0082 }
            monitor-exit(r2)
            throw r0
        L_0x0082:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0085:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0088:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.recordComposerModifications():boolean");
    }

    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> function1) {
        IdentityArraySet access$getSnapshotInvalidations$p = this.snapshotInvalidations;
        if (access$getSnapshotInvalidations$p.isNotEmpty()) {
            List access$getKnownCompositions = getKnownCompositions();
            int size = access$getKnownCompositions.size();
            for (int i = 0; i < size; i++) {
                ((ControlledComposition) access$getKnownCompositions.get(i)).recordModificationsOf(access$getSnapshotInvalidations$p);
            }
            this.snapshotInvalidations = new IdentityArraySet();
        }
        List access$getCompositionInvalidations$p = this.compositionInvalidations;
        int size2 = access$getCompositionInvalidations$p.size();
        for (int i2 = 0; i2 < size2; i2++) {
            function1.invoke(access$getCompositionInvalidations$p.get(i2));
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }

    /* access modifiers changed from: private */
    public final void registerRunnerJob(Job job) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            } else if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            } else if (this.runnerJob == null) {
                this.runnerJob = job;
                deriveStateLocked();
            } else {
                throw new IllegalStateException("Recomposer already running".toString());
            }
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, (Continuation<? super Recomposer$runRecomposeAndApplyChanges$2>) null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception exc, ControlledComposition controlledComposition, boolean z) {
        if (!_hotReloadEnabled.get().booleanValue() || (exc instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                RecomposerErrorState recomposerErrorState = this.errorState;
                if (recomposerErrorState == null) {
                    this.errorState = new RecomposerErrorState(false, exc);
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw recomposerErrorState.getCause();
                }
            }
            throw exc;
        }
        synchronized (this.stateLock) {
            ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", exc);
            this.compositionsAwaitingApply.clear();
            this.compositionInvalidations.clear();
            this.snapshotInvalidations = new IdentityArraySet<>();
            this.compositionValuesAwaitingInsert.clear();
            this.compositionValuesRemoved.clear();
            this.compositionValueStatesAvailable.clear();
            this.errorState = new RecomposerErrorState(z, exc);
            if (controlledComposition != null) {
                List<ControlledComposition> list = this.failedCompositions;
                if (list == null) {
                    list = new ArrayList<>();
                    this.failedCompositions = list;
                }
                if (!list.contains(controlledComposition)) {
                    list.add(controlledComposition);
                }
                removeKnownCompositionLocked(controlledComposition);
            }
            deriveStateLocked();
        }
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final void removeKnownCompositionLocked(ControlledComposition controlledComposition) {
        this._knownCompositions.remove(controlledComposition);
        this._knownCompositionsCache = null;
    }

    private final void addKnownCompositionLocked(ControlledComposition controlledComposition) {
        this._knownCompositions.add(controlledComposition);
        this._knownCompositionsCache = null;
    }

    /* access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list != null) {
            while (!list.isEmpty()) {
                try {
                    ControlledComposition controlledComposition = (ControlledComposition) CollectionsKt.removeLast(list);
                    if (controlledComposition instanceof CompositionImpl) {
                        controlledComposition.invalidateAll();
                        controlledComposition.setContent(((CompositionImpl) controlledComposition).getComposable());
                        if (this.errorState != null) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    if (!list.isEmpty()) {
                        synchronized (this.stateLock) {
                            List<ControlledComposition> list2 = this.failedCompositions;
                            if (list2 != null) {
                                list2.addAll(list);
                                if (list2 != null) {
                                    list = list2;
                                }
                            }
                            this.failedCompositions = list;
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    throw th;
                }
            }
            if (!list.isEmpty()) {
                synchronized (this.stateLock) {
                    List<ControlledComposition> list3 = this.failedCompositions;
                    if (list3 != null) {
                        list3.addAll(list);
                        if (list3 != null) {
                            list = list3;
                        }
                    }
                    this.failedCompositions = list;
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(coroutineContext, this, (Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2>) null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r8, androidx.compose.runtime.ProduceFrameSignal r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.runtime.Recomposer$runFrameLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer$runFrameLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0066
            if (r2 == r4) goto L_0x004e
            if (r2 != r3) goto L_0x0046
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x0040:
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r5
            r5 = r6
            goto L_0x0078
        L_0x0046:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004e:
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0092
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r5 = r7
        L_0x0078:
            java.lang.Object r6 = r5.stateLock
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r2
            r0.label = r4
            java.lang.Object r6 = r9.awaitFrameRequest(r6, r0)
            if (r6 != r1) goto L_0x008d
            return r1
        L_0x008d:
            r6 = r5
            r5 = r8
            r8 = r2
            r2 = r9
            r9 = r10
        L_0x0092:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r10 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r10.<init>(r6, r9, r8, r2)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r10 = r5.withFrameNanos(r10, r0)
            if (r10 != r1) goto L_0x0040
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = true;
            if (!this.snapshotInvalidations.isNotEmpty() && !(!this.compositionInvalidations.isEmpty()) && !getHasBroadcastFrameClockAwaitersLocked()) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        synchronized (this.stateLock) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = cancellableContinuation;
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), (Continuation<? super Recomposer$recompositionRunner$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2((Continuation<? super Recomposer$join$2>) null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    public void composeInitial$runtime_release(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
        Snapshot snapshot;
        Snapshot makeCurrent;
        boolean isComposing = controlledComposition.isComposing();
        try {
            MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, (IdentityArraySet<Object>) null));
            try {
                snapshot = takeMutableSnapshot;
                makeCurrent = snapshot.makeCurrent();
                controlledComposition.composeContent(function2);
                Unit unit = Unit.INSTANCE;
                snapshot.restoreCurrent(makeCurrent);
                applyAndCheck(takeMutableSnapshot);
                if (!isComposing) {
                    Snapshot.Companion.notifyObjectsInitialized();
                }
                synchronized (this.stateLock) {
                    if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !getKnownCompositions().contains(controlledComposition)) {
                        addKnownCompositionLocked(controlledComposition);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
                try {
                    performInitialMovableContentInserts(controlledComposition);
                    try {
                        controlledComposition.applyChanges();
                        controlledComposition.applyLateChanges();
                        if (!isComposing) {
                            Snapshot.Companion.notifyObjectsInitialized();
                        }
                    } catch (Exception e) {
                        processCompositionError$default(this, e, (ControlledComposition) null, false, 6, (Object) null);
                    }
                } catch (Exception e2) {
                    processCompositionError(e2, controlledComposition, true);
                }
            } catch (Throwable th) {
                applyAndCheck(takeMutableSnapshot);
                throw th;
            }
        } catch (Exception e3) {
            processCompositionError(e3, controlledComposition, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if ((!r0.isEmpty()) == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        performInsertValues(r0, (androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>) null);
        performInitialMovableContentInserts$fillToInsert(r0, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r0 = new java.util.ArrayList();
        performInitialMovableContentInserts$fillToInsert(r0, r5, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.stateLock
            monitor-enter(r0)
            java.util.List<androidx.compose.runtime.MovableContentStateReference> r1 = r5.compositionValuesAwaitingInsert     // Catch:{ all -> 0x0042 }
            int r2 = r1.size()     // Catch:{ all -> 0x0042 }
            r3 = 0
        L_0x000a:
            if (r3 >= r2) goto L_0x0040
            java.lang.Object r4 = r1.get(r3)     // Catch:{ all -> 0x0042 }
            androidx.compose.runtime.MovableContentStateReference r4 = (androidx.compose.runtime.MovableContentStateReference) r4     // Catch:{ all -> 0x0042 }
            androidx.compose.runtime.ControlledComposition r4 = r4.getComposition$runtime_release()     // Catch:{ all -> 0x0042 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x003d
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            performInitialMovableContentInserts$fillToInsert(r0, r5, r6)
        L_0x0029:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x003c
            r1 = 0
            r5.performInsertValues(r0, r1)
            performInitialMovableContentInserts$fillToInsert(r0, r5, r6)
            goto L_0x0029
        L_0x003c:
            return
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x000a
        L_0x0040:
            monitor-exit(r0)
            return
        L_0x0042:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition):void");
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (Intrinsics.areEqual((Object) next.getComposition$runtime_release(), (Object) controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final ControlledComposition performRecompose(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        Set<ControlledComposition> set;
        Snapshot snapshot;
        Snapshot makeCurrent;
        if (controlledComposition.isComposing() || controlledComposition.isDisposed() || ((set = this.compositionsRemoved) != null && set.contains(controlledComposition))) {
            return null;
        }
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            snapshot = takeMutableSnapshot;
            makeCurrent = snapshot.makeCurrent();
            if (identityArraySet != null) {
                if (identityArraySet.isNotEmpty()) {
                    controlledComposition.prepareCompose(new Recomposer$performRecompose$1$1(identityArraySet, controlledComposition));
                }
            }
            boolean recompose = controlledComposition.recompose();
            snapshot.restoreCurrent(makeCurrent);
            applyAndCheck(takeMutableSnapshot);
            if (recompose) {
                return controlledComposition;
            }
            return null;
        } catch (Throwable th) {
            applyAndCheck(takeMutableSnapshot);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i;
        List list;
        synchronized (this.stateLock) {
            if (!this.compositionValuesRemoved.isEmpty()) {
                List flatten = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                this.compositionValuesRemoved.clear();
                ArrayList arrayList = new ArrayList(flatten.size());
                int size = flatten.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) flatten.get(i2);
                    arrayList.add(TuplesKt.to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                }
                list = arrayList;
                this.compositionValueStatesAvailable.clear();
            } else {
                list = CollectionsKt.emptyList();
            }
        }
        int size2 = list.size();
        for (i = 0; i < size2; i++) {
            Pair pair = (Pair) list.get(i);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition$runtime_release().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    private final Function1<Object, Unit> readObserverOf(ControlledComposition controlledComposition) {
        return new Recomposer$readObserverOf$1(controlledComposition);
    }

    private final Function1<Object, Unit> writeObserverOf(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        return new Recomposer$writeObserverOf$1(controlledComposition, identityArraySet);
    }

    private final <T> T composing(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet, Function0<? extends T> function0) {
        Snapshot snapshot;
        Snapshot makeCurrent;
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            snapshot = takeMutableSnapshot;
            makeCurrent = snapshot.makeCurrent();
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            snapshot.restoreCurrent(makeCurrent);
            InlineMarker.finallyEnd(1);
            InlineMarker.finallyStart(1);
            applyAndCheck(takeMutableSnapshot);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            applyAndCheck(takeMutableSnapshot);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            mutableSnapshot.dispose();
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = true;
            if (!this.snapshotInvalidations.isNotEmpty() && !(!this.compositionInvalidations.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !(!this.compositionsAwaitingApply.isEmpty()) && !getHasBroadcastFrameClockAwaitersLocked()) {
                z = false;
            }
        }
        return z;
    }

    private final boolean getHasFrameWorkLocked() {
        return (this.compositionInvalidations.isEmpty() ^ true) || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return (this.compositionsAwaitingApply.isEmpty() ^ true) || getHasBroadcastFrameClockAwaitersLocked();
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2((Continuation<? super Recomposer$awaitIdle$2>) null)), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
        }
    }

    public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(controlledComposition);
            this.compositionInvalidations.remove(controlledComposition);
            this.compositionsAwaitingApply.remove(controlledComposition);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void invalidate$runtime_release(ControlledComposition controlledComposition) {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (!this.compositionInvalidations.contains(controlledComposition)) {
                this.compositionInvalidations.add(controlledComposition);
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
        }
    }

    public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(recomposeScopeImpl);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
        }
    }

    public void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(movableContentStateReference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
        }
    }

    public void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, movableContentStateReference.getContent$runtime_release(), movableContentStateReference);
        }
    }

    public void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(movableContentStateReference, movableContentState);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            Set<ControlledComposition> set = this.compositionsRemoved;
            if (set == null) {
                set = new LinkedHashSet<>();
                this.compositionsRemoved = set;
            }
            set.add(controlledComposition);
        }
    }

    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
        MovableContentState remove;
        synchronized (this.stateLock) {
            remove = this.compositionValueStatesAvailable.remove(movableContentStateReference);
        }
        return remove;
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void setHotReloadEnabled$runtime_release(boolean z) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(z));
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final void addRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl r4) {
            /*
                r3 = this;
            L_0x0000:
                kotlinx.coroutines.flow.MutableStateFlow r0 = androidx.compose.runtime.Recomposer._runningRecomposers
                java.lang.Object r0 = r0.getValue()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet) r0
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r1 = r0.add(r4)
                if (r0 == r1) goto L_0x001a
                kotlinx.coroutines.flow.MutableStateFlow r2 = androidx.compose.runtime.Recomposer._runningRecomposers
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.Companion.addRunning(androidx.compose.runtime.Recomposer$RecomposerInfoImpl):void");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final void removeRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl r4) {
            /*
                r3 = this;
            L_0x0000:
                kotlinx.coroutines.flow.MutableStateFlow r0 = androidx.compose.runtime.Recomposer._runningRecomposers
                java.lang.Object r0 = r0.getValue()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet) r0
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r1 = r0.remove(r4)
                if (r0 == r1) goto L_0x001a
                kotlinx.coroutines.flow.MutableStateFlow r2 = androidx.compose.runtime.Recomposer._runningRecomposers
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.Companion.removeRunning(androidx.compose.runtime.Recomposer$RecomposerInfoImpl):void");
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(true);
            Collection arrayList = new ArrayList();
            for (RecomposerInfoImpl saveStateAndDisposeForHotReload : (Iterable) Recomposer._runningRecomposers.getValue()) {
                CollectionsKt.addAll(arrayList, saveStateAndDisposeForHotReload.saveStateAndDisposeForHotReload());
            }
            return (List) arrayList;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object obj) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl resetErrorState : (Iterable) Recomposer._runningRecomposers.getValue()) {
                resetErrorState.resetErrorState();
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
            for (RecomposerInfoImpl retryFailedCompositions : (Iterable) Recomposer._runningRecomposers.getValue()) {
                retryFailedCompositions.retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime_release(int i) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(i);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Collection arrayList = new ArrayList();
            for (RecomposerInfoImpl currentError : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError2 = currentError.getCurrentError();
                if (currentError2 != null) {
                    arrayList.add(currentError2);
                }
            }
            return (List) arrayList;
        }

        public final void clearErrors$runtime_release() {
            Collection arrayList = new ArrayList();
            for (RecomposerInfoImpl resetErrorState : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorState resetErrorState2 = resetErrorState.resetErrorState();
                if (resetErrorState2 != null) {
                    arrayList.add(resetErrorState2);
                }
            }
            List list = (List) arrayList;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> list, IdentityArraySet<Object> identityArraySet) {
        Iterator it;
        List list2;
        HashMap hashMap = new HashMap(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MovableContentStateReference movableContentStateReference = list.get(i);
            ControlledComposition composition$runtime_release = movableContentStateReference.getComposition$runtime_release();
            Map map = hashMap;
            Object obj = map.get(composition$runtime_release);
            if (obj == null) {
                obj = new ArrayList();
                map.put(composition$runtime_release, obj);
            }
            ((ArrayList) obj).add(movableContentStateReference);
        }
        Map map2 = hashMap;
        Iterator it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list3 = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition.isComposing());
            MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
            try {
                Snapshot snapshot = takeMutableSnapshot;
                Snapshot makeCurrent = snapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        ArrayList arrayList = new ArrayList(list3.size());
                        int size2 = list3.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list3.get(i2);
                            arrayList.add(TuplesKt.to(movableContentStateReference2, RecomposerKt.removeLastMultiValue(this.compositionValuesRemoved, movableContentStateReference2.getContent$runtime_release())));
                            i2++;
                            it2 = it2;
                        }
                        it = it2;
                        list2 = arrayList;
                    }
                    controlledComposition.insertMovableContent(list2);
                    Unit unit = Unit.INSTANCE;
                    snapshot.restoreCurrent(makeCurrent);
                    applyAndCheck(takeMutableSnapshot);
                    it2 = it;
                } catch (Throwable th) {
                    snapshot.restoreCurrent(makeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                applyAndCheck(takeMutableSnapshot);
                throw th2;
            }
        }
        return CollectionsKt.toList(map2.keySet());
    }
}
