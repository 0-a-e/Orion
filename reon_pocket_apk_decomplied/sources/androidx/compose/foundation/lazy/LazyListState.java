package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  \u00012\u00020\u0001:\u0002 \u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\"\u0010{\u001a\u00020|2\b\b\u0001\u0010}\u001a\u00020\u00032\b\b\u0002\u0010~\u001a\u00020\u0003H@¢\u0006\u0002\u0010J,\u0010\u0001\u001a\u00020|2\u0007\u0010\u0001\u001a\u00020H2\u0007\u0010\u0001\u001a\u00020\u00152\t\b\u0002\u0010\u0001\u001a\u00020\u0015H\u0000¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020|2\u0007\u0010\u0001\u001a\u00020CH\u0002J\u0012\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\bH\u0016J\u001c\u0010\u0001\u001a\u00020|2\u0007\u0010\u0001\u001a\u00020\b2\b\b\u0002\u0010B\u001a\u00020CH\u0002J\u0018\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b\u0001JI\u0010\u0001\u001a\u00020|2\b\u0010\u0001\u001a\u00030\u00012-\u0010\u0001\u001a(\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020|0\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u0001¢\u0006\u0003\b\u0001H@¢\u0006\u0003\u0010\u0001J#\u0010\u0001\u001a\u00020|2\b\b\u0001\u0010}\u001a\u00020\u00032\b\b\u0002\u0010~\u001a\u00020\u0003H@¢\u0006\u0002\u0010J\u001f\u0010\u0001\u001a\u00020|2\u0006\u0010}\u001a\u00020\u00032\u0006\u0010~\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020|2\u0007\u0010\u0001\u001a\u00020\bH\u0002J\"\u0010\u0001\u001a\u00020\u00032\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0001R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158V@RX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158V@RX\u0002¢\u0006\u0012\n\u0004\b \u0010\u001c\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b1\u00100R\u001e\u00102\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0018R\u000e\u00104\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020:X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0018R\u0014\u0010>\u001a\u00020?X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010B\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010I\u001a\u00020J8@X\u0002¢\u0006\f\u001a\u0004\bM\u0010N*\u0004\bK\u0010LR\u001e\u0010O\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u0014\u0010Q\u001a\u00020RX\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001c\u0010U\u001a\u00020VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\bW\u0010XR\"\u0010Y\u001a\u0004\u0018\u00010H2\b\u0010\u0014\u001a\u0004\u0018\u00010H@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020]X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0018\"\u0004\bb\u0010\u001aR\"\u0010c\u001a\u00020dX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010i\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010k\u001a\u0004\u0018\u00010j2\b\u0010\u0014\u001a\u0004\u0018\u00010j@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020oX\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u000e\u0010u\u001a\u00020vX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010w\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bx\u0010tR\u000e\u0010y\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "_scrollDeltaBetweenPasses", "Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animateScrollScope", "Landroidx/compose/foundation/lazy/LazyListAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation_release", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "hasLookaheadPassOccurred", "getHasLookaheadPassOccurred$foundation_release", "indexToPrefetch", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "itemAnimator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/LazyListState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "postLookaheadLayoutInfo", "getPostLookaheadLayoutInfo$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "premeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "getPremeasureConstraints-msEJaDk$foundation_release", "()J", "setPremeasureConstraints-BRTryo0$foundation_release", "(J)V", "J", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation_release", "()F", "scrollPosition", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "scrollableState", "wasScrollingForward", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "notifyPrefetch", "onScroll", "distance", "onScroll$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "snapToItemIndexInternal$foundation_release", "updateScrollDeltaForPostLookahead", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListState.kt */
public final class LazyListState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<LazyListState, ?> Saver = ListSaverKt.listSaver(LazyListState$Companion$Saver$1.INSTANCE, LazyListState$Companion$Saver$2.INSTANCE);
    /* access modifiers changed from: private */
    public AnimationState<Float, AnimationVector1D> _scrollDeltaBetweenPasses;
    private final LazyListAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private CoroutineScope coroutineScope;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private boolean hasLookaheadPassOccurred;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyListItemAnimator itemAnimator;
    private final MutableState<LazyListMeasureResult> layoutInfoState;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private LazyListMeasureResult postLookaheadLayoutInfo;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    /* access modifiers changed from: private */
    public Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyListScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private boolean wasScrollingForward;

    public LazyListState() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyListState(int i, int i2) {
        LazyListScrollPosition lazyListScrollPosition = new LazyListScrollPosition(i, i2);
        this.scrollPosition = lazyListScrollPosition;
        this.animateScrollScope = new LazyListAnimateScrollScope(this);
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyListStateKt.EmptyLazyListMeasureResult, SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.density = DensityKt.Density(1.0f, 1.0f);
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyListState$scrollableState$1(this));
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.remeasurementModifier = new LazyListState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyListItemAnimator();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        lazyListScrollPosition.getNearestRangeState();
        this.canScrollForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.canScrollBackward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.placementScopeInvalidator = ObservableScopeInvalidator.m908constructorimpl$default((MutableState) null, 1, (DefaultConstructorMarker) null);
        this.prefetchState = new LazyLayoutPrefetchState();
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Float valueOf = Float.valueOf(0.0f);
        this._scrollDeltaBetweenPasses = AnimationStateKt.AnimationState$default(vectorConverter, valueOf, valueOf, 0, 0, false, 56, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyListState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final boolean getHasLookaheadPassOccurred$foundation_release() {
        return this.hasLookaheadPassOccurred;
    }

    public final LazyListMeasureResult getPostLookaheadLayoutInfo$foundation_release() {
        return this.postLookaheadLayoutInfo;
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final LazyListLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density2) {
        this.density = density2;
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return this.remeasurement;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final LazyListItemAnimator getItemAnimator$foundation_release() {
        return this.itemAnimator;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    /* renamed from: getPremeasureConstraints-msEJaDk$foundation_release  reason: not valid java name */
    public final long m817getPremeasureConstraintsmsEJaDk$foundation_release() {
        return this.premeasureConstraints;
    }

    /* renamed from: setPremeasureConstraints-BRTryo0$foundation_release  reason: not valid java name */
    public final void m818setPremeasureConstraintsBRTryo0$foundation_release(long j) {
        this.premeasureConstraints = j;
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    private static Object getNearestRange$foundation_release$delegate(LazyListState lazyListState) {
        return lazyListState.scrollPosition.getNearestRangeState();
    }

    public final IntRange getNearestRange$foundation_release() {
        return (IntRange) this.scrollPosition.getNearestRangeState().getValue();
    }

    public static /* synthetic */ Object scrollToItem$default(LazyListState lazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyListState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.CC.scroll$default(this, (MutatePriority) null, new LazyListState$scrollToItem$2(this, i, i2, (Continuation<? super LazyListState$scrollToItem$2>) null), continuation, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public final void snapToItemIndexInternal$foundation_release(int i, int i2) {
        this.scrollPosition.requestPosition(i, i2);
        this.itemAnimator.reset();
        Remeasurement remeasurement2 = this.remeasurement;
        if (remeasurement2 != null) {
            remeasurement2.forceRemeasure();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object scroll(androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.LazyListState$scroll$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = (androidx.compose.foundation.lazy.LazyListState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = new androidx.compose.foundation.lazy.LazyListState$scroll$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006d
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$2
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r6 = r0.L$1
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.lazy.LazyListState r2 = (androidx.compose.foundation.lazy.LazyListState) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005b
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r5.awaitLayoutModifier
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r8.waitForFirstLayout(r0)
            if (r8 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r2 = r5
        L_0x005b:
            androidx.compose.foundation.gestures.ScrollableState r8 = r2.scrollableState
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L_0x006d
            return r1
        L_0x006d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    private void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    /* renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release  reason: not valid java name */
    public final MutableState<Unit> m816getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public final float onScroll$foundation_release(float f) {
        if ((f < 0.0f && !getCanScrollForward()) || (f > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            float f2 = this.scrollToBeConsumed + f;
            this.scrollToBeConsumed = f2;
            if (Math.abs(f2) > 0.5f) {
                LazyListMeasureResult value = this.layoutInfoState.getValue();
                float f3 = this.scrollToBeConsumed;
                int roundToInt = MathKt.roundToInt(f3);
                LazyListMeasureResult lazyListMeasureResult = this.postLookaheadLayoutInfo;
                boolean tryToApplyScrollWithoutRemeasure = value.tryToApplyScrollWithoutRemeasure(roundToInt, !this.hasLookaheadPassOccurred);
                if (tryToApplyScrollWithoutRemeasure && lazyListMeasureResult != null) {
                    tryToApplyScrollWithoutRemeasure = lazyListMeasureResult.tryToApplyScrollWithoutRemeasure(roundToInt, true);
                }
                if (tryToApplyScrollWithoutRemeasure) {
                    applyMeasureResult$foundation_release(value, this.hasLookaheadPassOccurred, true);
                    ObservableScopeInvalidator.m912invalidateScopeimpl(this.placementScopeInvalidator);
                    notifyPrefetch(f3 - this.scrollToBeConsumed, value);
                } else {
                    Remeasurement remeasurement2 = this.remeasurement;
                    if (remeasurement2 != null) {
                        remeasurement2.forceRemeasure();
                    }
                    notifyPrefetch$default(this, f3 - this.scrollToBeConsumed, (LazyListLayoutInfo) null, 2, (Object) null);
                }
            }
            if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
                return f;
            }
            float f4 = f - this.scrollToBeConsumed;
            this.scrollToBeConsumed = 0.0f;
            return f4;
        }
        throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
    }

    static /* synthetic */ void notifyPrefetch$default(LazyListState lazyListState, float f, LazyListLayoutInfo lazyListLayoutInfo, int i, Object obj) {
        if ((i & 2) != 0) {
            lazyListLayoutInfo = lazyListState.getLayoutInfo();
        }
        lazyListState.notifyPrefetch(f, lazyListLayoutInfo);
    }

    private final void notifyPrefetch(float f, LazyListLayoutInfo lazyListLayoutInfo) {
        int i;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        if (this.prefetchingEnabled && (!lazyListLayoutInfo.getVisibleItemsInfo().isEmpty())) {
            boolean z = f < 0.0f;
            if (z) {
                i = ((LazyListItemInfo) CollectionsKt.last(lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() + 1;
            } else {
                i = ((LazyListItemInfo) CollectionsKt.first(lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() - 1;
            }
            if (i != this.indexToPrefetch && i >= 0 && i < lazyListLayoutInfo.getTotalItemsCount()) {
                if (!(this.wasScrollingForward == z || (prefetchHandle = this.currentPrefetchHandle) == null)) {
                    prefetchHandle.cancel();
                }
                this.wasScrollingForward = z;
                this.indexToPrefetch = i;
                this.currentPrefetchHandle = this.prefetchState.m901schedulePrefetch0kLqBqw(i, this.premeasureConstraints);
            }
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyListLayoutInfo lazyListLayoutInfo) {
        int i;
        if (this.indexToPrefetch != -1 && (!lazyListLayoutInfo.getVisibleItemsInfo().isEmpty())) {
            if (this.wasScrollingForward) {
                i = ((LazyListItemInfo) CollectionsKt.last(lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() + 1;
            } else {
                i = ((LazyListItemInfo) CollectionsKt.first(lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() - 1;
            }
            if (this.indexToPrefetch != i) {
                this.indexToPrefetch = -1;
                LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
                if (prefetchHandle != null) {
                    prefetchHandle.cancel();
                }
                this.currentPrefetchHandle = null;
            }
        }
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyListState lazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyListState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, i, i2, 100, this.density, continuation);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(LazyListState lazyListState, LazyListMeasureResult lazyListMeasureResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        lazyListState.applyMeasureResult$foundation_release(lazyListMeasureResult, z, z2);
    }

    public final void applyMeasureResult$foundation_release(LazyListMeasureResult lazyListMeasureResult, boolean z, boolean z2) {
        if (z || !this.hasLookaheadPassOccurred) {
            if (z) {
                this.hasLookaheadPassOccurred = true;
            }
            if (z2) {
                this.scrollPosition.updateScrollOffset(lazyListMeasureResult.getFirstVisibleItemScrollOffset());
            } else {
                this.scrollPosition.updateFromMeasureResult(lazyListMeasureResult);
                cancelPrefetchIfVisibleItemsChanged(lazyListMeasureResult);
            }
            setCanScrollBackward(lazyListMeasureResult.getCanScrollBackward());
            setCanScrollForward(lazyListMeasureResult.getCanScrollForward());
            this.scrollToBeConsumed -= lazyListMeasureResult.getConsumedScroll();
            this.layoutInfoState.setValue(lazyListMeasureResult);
            if (z) {
                updateScrollDeltaForPostLookahead(lazyListMeasureResult.getScrollBackAmount());
            }
            this.numMeasurePasses++;
            return;
        }
        this.postLookaheadLayoutInfo = lazyListMeasureResult;
    }

    public final CoroutineScope getCoroutineScope$foundation_release() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope$foundation_release(CoroutineScope coroutineScope2) {
        this.coroutineScope = coroutineScope2;
    }

    public final float getScrollDeltaBetweenPasses$foundation_release() {
        return this._scrollDeltaBetweenPasses.getValue().floatValue();
    }

    private final void updateScrollDeltaForPostLookahead(float f) {
        Snapshot makeCurrent;
        float f2 = f;
        if (f2 > this.density.m6550toPx0680j_4(LazyListStateKt.DeltaThresholdForScrollAnimation)) {
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                float floatValue = this._scrollDeltaBetweenPasses.getValue().floatValue();
                if (this._scrollDeltaBetweenPasses.isRunning()) {
                    this._scrollDeltaBetweenPasses = AnimationStateKt.copy$default((AnimationState) this._scrollDeltaBetweenPasses, floatValue - f2, 0.0f, 0, 0, false, 30, (Object) null);
                    CoroutineScope coroutineScope2 = this.coroutineScope;
                    if (coroutineScope2 != null) {
                        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new LazyListState$updateScrollDeltaForPostLookahead$2$1(this, (Continuation<? super LazyListState$updateScrollDeltaForPostLookahead$2$1>) null), 3, (Object) null);
                    }
                } else {
                    this._scrollDeltaBetweenPasses = new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(-f2), (AnimationVector) null, 0, 0, false, 60, (DefaultConstructorMarker) null);
                    CoroutineScope coroutineScope3 = this.coroutineScope;
                    if (coroutineScope3 != null) {
                        Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new LazyListState$updateScrollDeltaForPostLookahead$2$2(this, (Continuation<? super LazyListState$updateScrollDeltaForPostLookahead$2$2>) null), 3, (Object) null);
                    }
                }
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
            } catch (Throwable th) {
                createNonObservableSnapshot.dispose();
                throw th;
            }
        }
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyListItemProvider lazyListItemProvider, int i) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(lazyListItemProvider, i);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/LazyListState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyListState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyListState, ?> getSaver() {
            return LazyListState.Saver;
        }
    }
}
