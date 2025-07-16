package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J7\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0001\u001a\u00020\u00052\u0010\b\u0002\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0001H@¢\u0006\u0003\u0010 \u0001J$\u0010¡\u0001\u001a\u00030\u00012\u0007\u0010¢\u0001\u001a\u00020S2\t\b\u0002\u0010£\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b¤\u0001J\u0011\u0010¥\u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010¦\u0001J\u0013\u0010§\u0001\u001a\u00030\u00012\u0007\u0010¨\u0001\u001a\u00020=H\u0002J\u0012\u0010©\u0001\u001a\u00020\u00052\u0007\u0010ª\u0001\u001a\u00020\u0005H\u0016J\u0010\u0010«\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0003J\u0012\u0010¬\u0001\u001a\u00020\u00132\u0007\u0010­\u0001\u001a\u00020\u0005H\u0002J\t\u0010®\u0001\u001a\u00020\u0013H\u0002J#\u0010¯\u0001\u001a\u00020\u00032\b\u0010°\u0001\u001a\u00030±\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0003\b²\u0001J\u001c\u0010³\u0001\u001a\u00030\u00012\u0007\u0010ª\u0001\u001a\u00020\u00052\u0007\u0010¨\u0001\u001a\u00020=H\u0002J\u0012\u0010´\u0001\u001a\u00020\u00052\u0007\u0010ª\u0001\u001a\u00020\u0005H\u0002JK\u0010µ\u0001\u001a\u00030\u00012\b\u0010¶\u0001\u001a\u00030·\u00012.\u0010¸\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030º\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010»\u0001\u0012\u0007\u0012\u0005\u0018\u00010¼\u00010¹\u0001¢\u0006\u0003\b½\u0001H@¢\u0006\u0003\u0010¾\u0001J%\u0010¿\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0001\u001a\u00020\u0005H@¢\u0006\u0003\u0010À\u0001J\"\u0010Á\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010Â\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0003\bÃ\u0001J\u0013\u0010Ä\u0001\u001a\u00030\u00012\u0007\u0010¢\u0001\u001a\u00020SH\u0002J\r\u0010Å\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002J!\u0010Æ\u0001\u001a\u00030\u0001*\u00030º\u00012\u0007\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0001\u001a\u00020\u0005J\u0016\u0010Ç\u0001\u001a\u00030\u0001*\u00030º\u00012\u0007\u0010\u0001\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@BX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u001e\u0010-\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u000e\u0010/\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0016R+\u00109\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138B@BX\u0002¢\u0006\u0012\n\u0004\b;\u0010\u001a\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R\u0011\u0010<\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0018\u0010@\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003@BX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8@X\u0002¢\u0006\f\u001a\u0004\bE\u0010F*\u0004\bC\u0010DR\u001e\u0010G\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010 R\u0012\u0010I\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010 R\u0014\u0010K\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\bL\u0010 R\u0014\u0010M\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\bN\u0010 R\u0014\u0010O\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\bP\u0010 R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010T\u001a\u00020UX\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001c\u0010X\u001a\u00020YX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\"R\u0014\u0010^\u001a\u00020_X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0016\"\u0004\bd\u0010\u0018R\"\u0010e\u001a\u00020fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010k\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u000e\u0010l\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R+\u0010m\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bn\u0010 \"\u0004\bo\u0010pR/\u0010t\u001a\u0004\u0018\u00010s2\b\u0010\u0012\u001a\u0004\u0018\u00010s8@@BX\u0002¢\u0006\u0012\n\u0004\by\u0010\u001a\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0014\u0010z\u001a\u00020{X\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0001\u001a\u00020\u00038FX\u0002¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010 R/\u0010\u0001\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010r\u001a\u0005\b\u0001\u0010 \"\u0005\b\u0001\u0010pR1\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00058@@@X\u0002¢\u0006\u0017\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\"\"\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u00020\u00038FX\u0002¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010 R7\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0012\u001a\u00030\u00018@@@X\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0015\n\u0005\b\u0001\u0010\u001a\u001a\u0005\b\u0001\u0010h\"\u0005\b\u0001\u0010jR\u000f\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006È\u0001"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentPage", "", "currentPageOffsetFraction", "", "(IF)V", "accumulator", "animatedScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "getCurrentPage", "()I", "getCurrentPageOffsetFraction", "()F", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "firstVisiblePage", "getFirstVisiblePage$foundation_release", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation_release", "indexToPrefetch", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "isScrollingForward", "setScrollingForward", "isScrollingForward$delegate", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "maxScrollOffset", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "pageCount", "getPageCount", "pageSize", "getPageSize$foundation_release", "pageSizeWithSpacing", "getPageSizeWithSpacing$foundation_release", "pageSpacing", "getPageSpacing$foundation_release", "pagerLayoutInfoState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "positionThresholdFraction", "getPositionThresholdFraction$foundation_release", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "premeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "getPremeasureConstraints-msEJaDk$foundation_release", "()J", "setPremeasureConstraints-BRTryo0$foundation_release", "(J)V", "J", "previousPassDelta", "programmaticScrollTargetPage", "getProgrammaticScrollTargetPage", "setProgrammaticScrollTargetPage", "(I)V", "programmaticScrollTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "getScrollPosition$foundation_release", "()Landroidx/compose/foundation/pager/PagerScrollPosition;", "scrollableState", "settledPage", "getSettledPage", "settledPage$delegate", "Landroidx/compose/runtime/State;", "settledPageState", "getSettledPageState", "setSettledPageState", "settledPageState$delegate", "snapRemainingScrollOffset", "getSnapRemainingScrollOffset$foundation_release", "setSnapRemainingScrollOffset$foundation_release", "(F)V", "snapRemainingScrollOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "targetPage", "getTargetPage", "targetPage$delegate", "Landroidx/compose/ui/geometry/Offset;", "upDownDifference", "getUpDownDifference-F1C5BW0$foundation_release", "setUpDownDifference-k-4lQ0M$foundation_release", "upDownDifference$delegate", "wasPrefetchingForward", "animateScrollToPage", "", "page", "pageOffsetFraction", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "getOffsetFractionForPage", "isGestureActionMatchesScroll", "scrollDelta", "isNotGestureAction", "matchScrollPositionWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "matchScrollPositionWithKey$foundation_release", "notifyPrefetch", "performScroll", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPage", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "offsetFraction", "snapToItem$foundation_release", "tryRunPrefetch", "coerceInPageRange", "updateCurrentPage", "updateTargetPage", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public abstract class PagerState implements ScrollableState {
    public static final int $stable = 0;
    private float accumulator;
    private final LazyLayoutAnimateScrollScope animatedScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState isScrollingForward$delegate;
    private int maxScrollOffset;
    private int numMeasurePasses;
    private MutableState<PagerMeasureResult> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;
    private final MutableIntState programmaticScrollTargetPage$delegate;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;
    private final State settledPage$delegate;
    private final MutableIntState settledPageState$delegate;
    private final MutableFloatState snapRemainingScrollOffset$delegate;
    private final State targetPage$delegate;
    private final MutableState upDownDifference$delegate;
    private boolean wasPrefetchingForward;

    public PagerState() {
        this(0, 0.0f, 3, (DefaultConstructorMarker) null);
    }

    public abstract int getPageCount();

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return scroll$suspendImpl(this, mutatePriority, function2, continuation);
    }

    public PagerState(int i, float f) {
        double d = (double) f;
        if (-0.5d > d || d > 0.5d) {
            throw new IllegalArgumentException(("initialPageOffsetFraction " + f + " is not within the range -0.5 to 0.5").toString());
        }
        this.upDownDifference$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3551boximpl(Offset.Companion.m3578getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.snapRemainingScrollOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.animatedScrollScope = PagerLazyAnimateScrollScopeKt.PagerLazyAnimateScrollScope(this);
        this.isScrollingForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(i, f, this);
        this.scrollPosition = pagerScrollPosition;
        this.firstVisiblePage = i;
        this.maxScrollOffset = Integer.MAX_VALUE;
        this.scrollableState = ScrollableStateKt.ScrollableState(new PagerState$scrollableState$1(this));
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this.density = PagerStateKt.UnitDensity;
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.programmaticScrollTargetPage$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.settledPageState$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.settledPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$settledPage$2(this));
        this.targetPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$targetPage$2(this));
        this.prefetchState = new LazyLayoutPrefetchState();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.remeasurement$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.remeasurementModifier = new PagerState$remeasurementModifier$1(this);
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
        this.pinnedPages = new LazyLayoutPinnedItemList();
        pagerScrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m908constructorimpl$default((MutableState) null, 1, (DefaultConstructorMarker) null);
        this.canScrollForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.canScrollBackward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerState(int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f);
    }

    /* renamed from: getUpDownDifference-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m984getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference$delegate.getValue()).m3572unboximpl();
    }

    /* renamed from: setUpDownDifference-k-4lQ0M$foundation_release  reason: not valid java name */
    public final void m986setUpDownDifferencek4lQ0M$foundation_release(long j) {
        this.upDownDifference$delegate.setValue(Offset.m3551boximpl(j));
    }

    public final float getSnapRemainingScrollOffset$foundation_release() {
        return this.snapRemainingScrollOffset$delegate.getFloatValue();
    }

    public final void setSnapRemainingScrollOffset$foundation_release(float f) {
        this.snapRemainingScrollOffset$delegate.setFloatValue(f);
    }

    /* access modifiers changed from: private */
    public final boolean isScrollingForward() {
        return ((Boolean) this.isScrollingForward$delegate.getValue()).booleanValue();
    }

    private final void setScrollingForward(boolean z) {
        this.isScrollingForward$delegate.setValue(Boolean.valueOf(z));
    }

    public final PagerScrollPosition getScrollPosition$foundation_release() {
        return this.scrollPosition;
    }

    public final int getFirstVisiblePage$foundation_release() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageOffset$foundation_release() {
        return this.firstVisiblePageOffset;
    }

    /* access modifiers changed from: private */
    public final float performScroll(float f) {
        float currentScrollOffset = (float) this.scrollPosition.currentScrollOffset();
        float f2 = currentScrollOffset + f + this.accumulator;
        float coerceIn = RangesKt.coerceIn(f2, 0.0f, (float) this.maxScrollOffset);
        boolean z = false;
        boolean z2 = !(f2 == coerceIn);
        float f3 = coerceIn - currentScrollOffset;
        this.previousPassDelta = f3;
        if (Math.abs(f3) != 0.0f) {
            if (f3 > 0.0f) {
                z = true;
            }
            setScrollingForward(z);
        }
        int roundToInt = MathKt.roundToInt(f3);
        PagerMeasureResult value = this.pagerLayoutInfoState.getValue();
        if (value.tryToApplyScrollWithoutRemeasure(-roundToInt)) {
            applyMeasureResult$foundation_release(value, true);
            ObservableScopeInvalidator.m912invalidateScopeimpl(this.placementScopeInvalidator);
        } else {
            this.scrollPosition.applyScrollDelta(roundToInt);
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
        }
        this.accumulator = f3 - ((float) roundToInt);
        return z2 ? f3 : f;
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

    public final PagerLayoutInfo getLayoutInfo() {
        return this.pagerLayoutInfoState.getValue();
    }

    public final int getPageSpacing$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    public final int getPageSize$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSize();
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density2) {
        this.density = density2;
    }

    public final int getPageSizeWithSpacing$foundation_release() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    public final float getPositionThresholdFraction$foundation_release() {
        return Math.min(this.density.m6550toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), ((float) getPageSize$foundation_release()) / 2.0f) / ((float) getPageSize$foundation_release());
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    /* access modifiers changed from: private */
    public final int getProgrammaticScrollTargetPage() {
        return this.programmaticScrollTargetPage$delegate.getIntValue();
    }

    private final void setProgrammaticScrollTargetPage(int i) {
        this.programmaticScrollTargetPage$delegate.setIntValue(i);
    }

    /* access modifiers changed from: private */
    public final int getSettledPageState() {
        return this.settledPageState$delegate.getIntValue();
    }

    private final void setSettledPageState(int i) {
        this.settledPageState$delegate.setIntValue(i);
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage$delegate.getValue()).intValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage$delegate.getValue()).intValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    /* access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement$delegate.setValue(remeasurement);
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    /* renamed from: getPremeasureConstraints-msEJaDk$foundation_release  reason: not valid java name */
    public final long m983getPremeasureConstraintsmsEJaDk$foundation_release() {
        return this.premeasureConstraints;
    }

    /* renamed from: setPremeasureConstraints-BRTryo0$foundation_release  reason: not valid java name */
    public final void m985setPremeasureConstraintsBRTryo0$foundation_release(long j) {
        this.premeasureConstraints = j;
    }

    public final LazyLayoutPinnedItemList getPinnedPages$foundation_release() {
        return this.pinnedPages;
    }

    private static Object getNearestRange$foundation_release$delegate(PagerState pagerState) {
        return pagerState.scrollPosition.getNearestRangeState();
    }

    public final IntRange getNearestRange$foundation_release() {
        return (IntRange) this.scrollPosition.getNearestRangeState().getValue();
    }

    /* renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release  reason: not valid java name */
    public final MutableState<Unit> m982getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            return pagerState.scrollToPage(i, f, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
    }

    public final Object scrollToPage(int i, float f, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.CC.scroll$default(this, (MutatePriority) null, new PagerState$scrollToPage$2(this, f, i, (Continuation<? super PagerState$scrollToPage$2>) null), continuation, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public static /* synthetic */ void updateCurrentPage$default(PagerState pagerState, ScrollScope scrollScope, int i, float f, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            pagerState.updateCurrentPage(scrollScope, i, f);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentPage");
    }

    public final void updateCurrentPage(ScrollScope scrollScope, int i, float f) {
        this.animatedScrollScope.snapToItem(scrollScope, i, (int) (f * ((float) getPageSizeWithSpacing$foundation_release())));
    }

    public final void updateTargetPage(ScrollScope scrollScope, int i) {
        setProgrammaticScrollTargetPage(coerceInPageRange(i));
    }

    public final void snapToItem$foundation_release(int i, float f) {
        this.scrollPosition.requestPosition(i, f);
        Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
        if (remeasurement$foundation_release != null) {
            remeasurement$foundation_release.forceRemeasure();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateScrollToPage(int r12, float r13, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r0 = (androidx.compose.foundation.pager.PagerState$animateScrollToPage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r0 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            r0.<init>(r11, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00ab
        L_0x002e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0036:
            float r13 = r0.F$0
            int r12 = r0.I$0
            java.lang.Object r14 = r0.L$1
            androidx.compose.animation.core.AnimationSpec r14 = (androidx.compose.animation.core.AnimationSpec) r14
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.pager.PagerState r2 = (androidx.compose.foundation.pager.PagerState) r2
            kotlin.ResultKt.throwOnFailure(r15)
            r9 = r14
            r5 = r2
            goto L_0x0076
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r15)
            int r15 = r11.getCurrentPage()
            if (r12 != r15) goto L_0x005a
            float r15 = r11.getCurrentPageOffsetFraction()
            int r15 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x005a
            goto L_0x0060
        L_0x005a:
            int r15 = r11.getPageCount()
            if (r15 != 0) goto L_0x0063
        L_0x0060:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0063:
            r0.L$0 = r11
            r0.L$1 = r14
            r0.I$0 = r12
            r0.F$0 = r13
            r0.label = r4
            java.lang.Object r15 = r11.awaitScrollDependencies(r0)
            if (r15 != r1) goto L_0x0074
            return r1
        L_0x0074:
            r5 = r11
            r9 = r14
        L_0x0076:
            double r14 = (double) r13
            r6 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r2 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r2 > 0) goto L_0x00ae
            r6 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r14 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r14 > 0) goto L_0x00ae
            int r6 = r5.coerceInPageRange(r12)
            int r12 = r5.getPageSizeWithSpacing$foundation_release()
            float r12 = (float) r12
            float r13 = r13 * r12
            int r8 = kotlin.math.MathKt.roundToInt((float) r13)
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r12 = r5.animatedScrollScope
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$3$1 r13 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$3$1
            r10 = 0
            r4 = r13
            r7 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r14 = 0
            r0.L$0 = r14
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r12 = r12.scroll(r13, r0)
            if (r12 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00ae:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "pageOffsetFraction "
            r12.<init>(r14)
            r12.append(r13)
            java.lang.String r13 = " is not within the range -0.5 to 0.5"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r12 = r12.toString()
            r13.<init>(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.animateScrollToPage(int, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, AnimationSpec animationSpec, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
            }
            return pagerState.animateScrollToPage(i, f, animationSpec, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
    }

    /* access modifiers changed from: private */
    public final Object awaitScrollDependencies(Continuation<? super Unit> continuation) {
        Object waitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout(continuation);
        return waitForFirstLayout == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? waitForFirstLayout : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.compose.foundation.MutatePriority} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object scroll$suspendImpl(androidx.compose.foundation.pager.PagerState r5, androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.pager.PagerState$scroll$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = (androidx.compose.foundation.pager.PagerState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = new androidx.compose.foundation.pager.PagerState$scroll$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007c
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            java.lang.Object r5 = r0.L$2
            r7 = r5
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005d
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r5.awaitScrollDependencies(r0)
            if (r8 != r1) goto L_0x005d
            return r1
        L_0x005d:
            boolean r8 = r5.isScrollInProgress()
            if (r8 != 0) goto L_0x006a
            int r8 = r5.getCurrentPage()
            r5.setSettledPageState(r8)
        L_0x006a:
            androidx.compose.foundation.gestures.ScrollableState r8 = r5.scrollableState
            r0.L$0 = r5
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r6 = -1
            r5.setProgrammaticScrollTargetPage(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.scroll$suspendImpl(androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private final void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    private final void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(PagerState pagerState, PagerMeasureResult pagerMeasureResult, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            pagerState.applyMeasureResult$foundation_release(pagerMeasureResult, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult pagerMeasureResult, boolean z) {
        if (z) {
            this.scrollPosition.updateCurrentPageOffsetFraction(pagerMeasureResult.getCurrentPageOffsetFraction());
        } else {
            this.scrollPosition.updateFromMeasureResult(pagerMeasureResult);
            cancelPrefetchIfVisibleItemsChanged(pagerMeasureResult);
        }
        this.pagerLayoutInfoState.setValue(pagerMeasureResult);
        setCanScrollForward(pagerMeasureResult.getCanScrollForward());
        setCanScrollBackward(pagerMeasureResult.getCanScrollBackward());
        this.numMeasurePasses++;
        MeasuredPage firstVisiblePage2 = pagerMeasureResult.getFirstVisiblePage();
        if (firstVisiblePage2 != null) {
            this.firstVisiblePage = firstVisiblePage2.getIndex();
        }
        this.firstVisiblePageOffset = pagerMeasureResult.getFirstVisiblePageScrollOffset();
        tryRunPrefetch(pagerMeasureResult);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(pagerMeasureResult, getPageCount());
    }

    private final void tryRunPrefetch(PagerMeasureResult pagerMeasureResult) {
        Snapshot makeCurrent;
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            if (Math.abs(this.previousPassDelta) > 0.5f && this.prefetchingEnabled && isGestureActionMatchesScroll(this.previousPassDelta)) {
                notifyPrefetch(this.previousPassDelta, pagerMeasureResult);
            }
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final int coerceInPageRange(int i) {
        if (getPageCount() > 0) {
            return RangesKt.coerceIn(i, 0, getPageCount() - 1);
        }
        return 0;
    }

    private final boolean isGestureActionMatchesScroll(float f) {
        if (getLayoutInfo().getOrientation() != Orientation.Vertical ? Math.signum(f) != Math.signum(-Offset.m3562getXimpl(m984getUpDownDifferenceF1C5BW0$foundation_release())) : Math.signum(f) != Math.signum(-Offset.m3563getYimpl(m984getUpDownDifferenceF1C5BW0$foundation_release()))) {
            return isNotGestureAction();
        }
    }

    private final boolean isNotGestureAction() {
        return ((int) Offset.m3562getXimpl(m984getUpDownDifferenceF1C5BW0$foundation_release())) == 0 && ((int) Offset.m3563getYimpl(m984getUpDownDifferenceF1C5BW0$foundation_release())) == 0;
    }

    private final void notifyPrefetch(float f, PagerLayoutInfo pagerLayoutInfo) {
        int i;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        if (this.prefetchingEnabled && (!pagerLayoutInfo.getVisiblePagesInfo().isEmpty())) {
            boolean z = f > 0.0f;
            if (z) {
                i = ((PageInfo) CollectionsKt.last(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() + pagerLayoutInfo.getBeyondBoundsPageCount() + 1;
            } else {
                i = (((PageInfo) CollectionsKt.first(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() - pagerLayoutInfo.getBeyondBoundsPageCount()) - 1;
            }
            if (i != this.indexToPrefetch && i >= 0 && i < getPageCount()) {
                if (!(this.wasPrefetchingForward == z || (prefetchHandle = this.currentPrefetchHandle) == null)) {
                    prefetchHandle.cancel();
                }
                this.wasPrefetchingForward = z;
                this.indexToPrefetch = i;
                this.currentPrefetchHandle = this.prefetchState.m901schedulePrefetch0kLqBqw(i, this.premeasureConstraints);
            }
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo pagerLayoutInfo) {
        int i;
        if (this.indexToPrefetch != -1 && (!pagerLayoutInfo.getVisiblePagesInfo().isEmpty())) {
            if (this.wasPrefetchingForward) {
                i = ((PageInfo) CollectionsKt.last(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() + pagerLayoutInfo.getBeyondBoundsPageCount() + 1;
            } else {
                i = (((PageInfo) CollectionsKt.first(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() - pagerLayoutInfo.getBeyondBoundsPageCount()) - 1;
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

    public final float getOffsetFractionForPage(int i) {
        if (i >= 0 && i <= getPageCount()) {
            return ((float) (getCurrentPage() - i)) + getCurrentPageOffsetFraction();
        }
        throw new IllegalArgumentException(("page " + i + " is not within the range 0 to " + getPageCount()).toString());
    }

    public static /* synthetic */ int matchScrollPositionWithKey$foundation_release$default(PagerState pagerState, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i, int i2, Object obj) {
        Snapshot makeCurrent;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
                try {
                    makeCurrent = createNonObservableSnapshot.makeCurrent();
                    int currentPage = pagerState.scrollPosition.getCurrentPage();
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    createNonObservableSnapshot.dispose();
                    i = currentPage;
                } catch (Throwable th) {
                    createNonObservableSnapshot.dispose();
                    throw th;
                }
            }
            return pagerState.matchScrollPositionWithKey$foundation_release(pagerLazyLayoutItemProvider, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: matchScrollPositionWithKey");
    }

    public final int matchScrollPositionWithKey$foundation_release(PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i) {
        return this.scrollPosition.matchPageWithKey(pagerLazyLayoutItemProvider, i);
    }
}
