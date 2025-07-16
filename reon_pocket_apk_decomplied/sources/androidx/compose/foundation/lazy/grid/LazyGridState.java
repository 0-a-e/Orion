package androidx.compose.foundation.lazy.grid;

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
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ¢\u00012\u00020\u0001:\u0002¢\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J&\u0010\u001a\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0001\u001a\u00020\u0003H@¢\u0006\u0003\u0010\u0001J$\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020;2\t\b\u0002\u0010\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b\u0001J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u000206H\u0002J\u0012\u0010\u0001\u001a\u00020s2\u0007\u0010\u0001\u001a\u00020sH\u0016J\u001d\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020s2\b\b\u0002\u00105\u001a\u000206H\u0002J\u0018\u0010\u0001\u001a\u00020s2\u0007\u0010\u0001\u001a\u00020sH\u0000¢\u0006\u0003\b\u0001JK\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012.\u0010\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u0001¢\u0006\u0003\b\u0001H@¢\u0006\u0003\u0010\u0001J'\u0010\u0001\u001a\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0001\u001a\u00020\u0003H@¢\u0006\u0003\u0010\u0001J\"\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0001J\"\u0010\u0001\u001a\u00020\u00032\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010 \u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b¡\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118V@RX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118V@RX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0014R\u001a\u00102\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u0011\u00105\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020>8@X\u0002¢\u0006\f\u001a\u0004\bA\u0010B*\u0004\b?\u0010@R\u001e\u0010C\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010'R\u0014\u0010E\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010'R\u0014\u0010G\u001a\u00020HX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020LX\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u001c\u0010O\u001a\u00020PX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bQ\u0010RR\u0001\u0010Z\u001a/\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(V\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020Y0X0W0S23\u0010\u0010\u001a/\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(V\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020Y0X0W0S8@@@X\u0002¢\u0006\u0012\n\u0004\b_\u0010\u0018\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020aX\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0014\"\u0004\bf\u0010\u0016R\u001c\u0010g\u001a\u0004\u0018\u00010hX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u0010m\u001a\u00020nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u000e\u0010q\u001a\u00020rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010t\u001a\u00020s2\u0006\u0010\u0010\u001a\u00020s@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u000e\u0010w\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R+\u0010x\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\b|\u0010}\u001a\u0004\by\u0010'\"\u0004\bz\u0010{R\u000e\u0010~\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006£\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "isVertical", "isVertical$foundation_release", "setVertical$foundation_release", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "lineToPrefetch", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "numOfItemsToTeleport", "getNumOfItemsToTeleport", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "getPlacementAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "prefetchInfoRetriever", "getPrefetchInfoRetriever$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setPrefetchInfoRetriever$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "prefetchInfoRetriever$delegate", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement$foundation_release", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "slotsPerLine", "getSlotsPerLine$foundation_release", "setSlotsPerLine$foundation_release", "(I)V", "slotsPerLine$delegate", "Landroidx/compose/runtime/MutableIntState;", "wasScrollingForward", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "notifyPrefetch", "onScroll", "distance", "onScroll$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridState.kt */
public final class LazyGridState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<LazyGridState, ?> Saver = ListSaverKt.listSaver(LazyGridState$Companion$Saver$1.INSTANCE, LazyGridState$Companion$Saver$2.INSTANCE);
    private final LazyGridAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    private Density density;
    private final MutableInteractionSource internalInteractionSource;
    private boolean isVertical;
    private final MutableState<LazyGridMeasureResult> layoutInfoState;
    private int lineToPrefetch;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final MutableState<Unit> placementScopeInvalidator;
    private final MutableState prefetchInfoRetriever$delegate;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private final MutableIntState slotsPerLine$delegate;
    private boolean wasScrollingForward;

    public LazyGridState() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyGridState(int i, int i2) {
        LazyGridScrollPosition lazyGridScrollPosition = new LazyGridScrollPosition(i, i2);
        this.scrollPosition = lazyGridScrollPosition;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyGridStateKt.EmptyLazyGridLayoutInfo, SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.slotsPerLine$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.density = DensityKt.Density(1.0f, 1.0f);
        this.isVertical = true;
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyGridState$scrollableState$1(this));
        this.prefetchingEnabled = true;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.remeasurementModifier = new LazyGridState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.prefetchInfoRetriever$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LazyGridState$prefetchInfoRetriever$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.placementAnimator = new LazyGridItemPlacementAnimator();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.animateScrollScope = new LazyGridAnimateScrollScope(this);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        lazyGridScrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m908constructorimpl$default((MutableState) null, 1, (DefaultConstructorMarker) null);
        this.canScrollForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.canScrollBackward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.prefetchState = new LazyLayoutPrefetchState();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
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

    public final int getSlotsPerLine$foundation_release() {
        return this.slotsPerLine$delegate.getIntValue();
    }

    public final void setSlotsPerLine$foundation_release(int i) {
        this.slotsPerLine$delegate.setIntValue(i);
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density2) {
        this.density = density2;
    }

    public final boolean isVertical$foundation_release() {
        return this.isVertical;
    }

    public final void setVertical$foundation_release(boolean z) {
        this.isVertical = z;
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

    public final void setRemeasurement$foundation_release(Remeasurement remeasurement2) {
        this.remeasurement = remeasurement2;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final Function1<Integer, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever$foundation_release() {
        return (Function1) this.prefetchInfoRetriever$delegate.getValue();
    }

    public final void setPrefetchInfoRetriever$foundation_release(Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1) {
        this.prefetchInfoRetriever$delegate.setValue(function1);
    }

    public final LazyGridItemPlacementAnimator getPlacementAnimator$foundation_release() {
        return this.placementAnimator;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    private static Object getNearestRange$foundation_release$delegate(LazyGridState lazyGridState) {
        return lazyGridState.scrollPosition.getNearestRangeState();
    }

    public final IntRange getNearestRange$foundation_release() {
        return (IntRange) this.scrollPosition.getNearestRangeState().getValue();
    }

    /* renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release  reason: not valid java name */
    public final MutableState<Unit> m852getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public static /* synthetic */ Object scrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.CC.scroll$default(this, (MutatePriority) null, new LazyGridState$scrollToItem$2(this, i, i2, (Continuation<? super LazyGridState$scrollToItem$2>) null), continuation, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public final void snapToItemIndexInternal$foundation_release(int i, int i2) {
        this.scrollPosition.requestPosition(i, i2);
        this.placementAnimator.reset();
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
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 r0 = (androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 r0 = new androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1
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
            androidx.compose.foundation.lazy.grid.LazyGridState r2 = (androidx.compose.foundation.lazy.grid.LazyGridState) r2
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
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

    public final float onScroll$foundation_release(float f) {
        if ((f < 0.0f && !getCanScrollForward()) || (f > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            float f2 = this.scrollToBeConsumed + f;
            this.scrollToBeConsumed = f2;
            if (Math.abs(f2) > 0.5f) {
                LazyGridMeasureResult value = this.layoutInfoState.getValue();
                float f3 = this.scrollToBeConsumed;
                if (value.tryToApplyScrollWithoutRemeasure(MathKt.roundToInt(f3))) {
                    applyMeasureResult$foundation_release(value, true);
                    ObservableScopeInvalidator.m912invalidateScopeimpl(this.placementScopeInvalidator);
                    notifyPrefetch(f3 - this.scrollToBeConsumed, value);
                } else {
                    Remeasurement remeasurement2 = this.remeasurement;
                    if (remeasurement2 != null) {
                        remeasurement2.forceRemeasure();
                    }
                    notifyPrefetch$default(this, f3 - this.scrollToBeConsumed, (LazyGridLayoutInfo) null, 2, (Object) null);
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

    static /* synthetic */ void notifyPrefetch$default(LazyGridState lazyGridState, float f, LazyGridLayoutInfo lazyGridLayoutInfo, int i, Object obj) {
        if ((i & 2) != 0) {
            lazyGridLayoutInfo = lazyGridState.layoutInfoState.getValue();
        }
        lazyGridState.notifyPrefetch(f, lazyGridLayoutInfo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b4 A[LOOP:1: B:33:0x00b2->B:34:0x00b4, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void notifyPrefetch(float r8, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r9) {
        /*
            r7 = this;
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r0 = r7.prefetchState
            boolean r1 = r7.prefetchingEnabled
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            java.util.List r1 = r9.getVisibleItemsInfo()
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x00da
            r1 = 0
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            r1 = 0
            if (r8 >= 0) goto L_0x001d
            r8 = r2
            goto L_0x001e
        L_0x001d:
            r8 = r1
        L_0x001e:
            if (r8 == 0) goto L_0x0048
            java.util.List r3 = r9.getVisibleItemsInfo()
            java.lang.Object r3 = kotlin.collections.CollectionsKt.last(r3)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r3 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r3
            boolean r4 = r7.isVertical
            if (r4 == 0) goto L_0x0033
            int r3 = r3.getRow()
            goto L_0x0037
        L_0x0033:
            int r3 = r3.getColumn()
        L_0x0037:
            int r3 = r3 + r2
            java.util.List r4 = r9.getVisibleItemsInfo()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.last(r4)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r4 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r4
            int r4 = r4.getIndex()
            int r4 = r4 + r2
            goto L_0x0070
        L_0x0048:
            java.util.List r3 = r9.getVisibleItemsInfo()
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r3)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r3 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r3
            boolean r4 = r7.isVertical
            if (r4 == 0) goto L_0x005b
            int r3 = r3.getRow()
            goto L_0x005f
        L_0x005b:
            int r3 = r3.getColumn()
        L_0x005f:
            int r3 = r3 + -1
            java.util.List r4 = r9.getVisibleItemsInfo()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r4)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r4 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r4
            int r4 = r4.getIndex()
            int r4 = r4 - r2
        L_0x0070:
            int r5 = r7.lineToPrefetch
            if (r3 == r5) goto L_0x00da
            if (r4 < 0) goto L_0x00da
            int r9 = r9.getTotalItemsCount()
            if (r4 >= r9) goto L_0x00da
            boolean r9 = r7.wasScrollingForward
            if (r9 == r8) goto L_0x0097
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r9 = r7.currentLinePrefetchHandles
            int r4 = r9.getSize()
            if (r4 <= 0) goto L_0x0097
            java.lang.Object[] r9 = r9.getContent()
            r5 = r1
        L_0x008d:
            r6 = r9[r5]
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r6 = (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle) r6
            r6.cancel()
            int r5 = r5 + r2
            if (r5 < r4) goto L_0x008d
        L_0x0097:
            r7.wasScrollingForward = r8
            r7.lineToPrefetch = r3
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r8 = r7.currentLinePrefetchHandles
            r8.clear()
            kotlin.jvm.functions.Function1 r8 = r7.getPrefetchInfoRetriever$foundation_release()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            java.lang.Object r8 = r8.invoke(r9)
            java.util.List r8 = (java.util.List) r8
            int r9 = r8.size()
        L_0x00b2:
            if (r1 >= r9) goto L_0x00da
            java.lang.Object r2 = r8.get(r1)
            kotlin.Pair r2 = (kotlin.Pair) r2
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r3 = r7.currentLinePrefetchHandles
            java.lang.Object r4 = r2.getFirst()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Object r2 = r2.getSecond()
            androidx.compose.ui.unit.Constraints r2 = (androidx.compose.ui.unit.Constraints) r2
            long r5 = r2.m6532unboximpl()
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r2 = r0.m901schedulePrefetch0kLqBqw(r4, r5)
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridState.notifyPrefetch(float, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo):void");
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyGridLayoutInfo lazyGridLayoutInfo) {
        int i;
        if (this.lineToPrefetch != -1 && (!lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty())) {
            if (this.wasScrollingForward) {
                LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
                i = (this.isVertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
            } else {
                LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo());
                i = (this.isVertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
            }
            if (this.lineToPrefetch != i) {
                this.lineToPrefetch = -1;
                MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector = this.currentLinePrefetchHandles;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i2 = 0;
                    do {
                        ((LazyLayoutPrefetchState.PrefetchHandle) content[i2]).cancel();
                        i2++;
                    } while (i2 < size);
                }
                this.currentLinePrefetchHandles.clear();
            }
        }
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    private final int getNumOfItemsToTeleport() {
        return getSlotsPerLine$foundation_release() * 100;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, i, i2, getNumOfItemsToTeleport(), this.density, continuation);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(LazyGridState lazyGridState, LazyGridMeasureResult lazyGridMeasureResult, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        lazyGridState.applyMeasureResult$foundation_release(lazyGridMeasureResult, z);
    }

    public final void applyMeasureResult$foundation_release(LazyGridMeasureResult lazyGridMeasureResult, boolean z) {
        this.scrollToBeConsumed -= lazyGridMeasureResult.getConsumedScroll();
        this.layoutInfoState.setValue(lazyGridMeasureResult);
        if (z) {
            this.scrollPosition.updateScrollOffset(lazyGridMeasureResult.getFirstVisibleLineScrollOffset());
        } else {
            this.scrollPosition.updateFromMeasureResult(lazyGridMeasureResult);
            cancelPrefetchIfVisibleItemsChanged(lazyGridMeasureResult);
        }
        setCanScrollBackward(lazyGridMeasureResult.getCanScrollBackward());
        setCanScrollForward(lazyGridMeasureResult.getCanScrollForward());
        this.numMeasurePasses++;
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyGridItemProvider lazyGridItemProvider, int i) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(lazyGridItemProvider, i);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyGridState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyGridState, ?> getSaver() {
            return LazyGridState.Saver;
        }
    }
}
