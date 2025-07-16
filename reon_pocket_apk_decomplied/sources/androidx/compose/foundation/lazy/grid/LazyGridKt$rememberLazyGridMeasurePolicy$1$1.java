package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyGridItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridSlotsProvider $slots;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyGridItemProvider> function0, LazyGridSlotsProvider lazyGridSlotsProvider, LazyGridState lazyGridState, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, CoroutineScope coroutineScope) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$slots = lazyGridSlotsProvider;
        this.$state = lazyGridState;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$coroutineScope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m839invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridMeasureResult m839invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j2;
        Snapshot makeCurrent;
        int i5;
        int i6;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        CheckScrollableContainerConstraintsKt.m242checkScrollableContainerConstraintsK40F9xA(j3, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m685calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m686calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int r4 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m687calculateTopPaddingD9Ej5fM());
        int r5 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m684calculateBottomPaddingD9Ej5fM());
        int i7 = r4 + r5;
        int i8 = i + i2;
        boolean z = this.$isVertical;
        int i9 = z ? i7 : i8;
        if (z && !this.$reverseLayout) {
            i3 = r4;
        } else if (!z || !this.$reverseLayout) {
            i3 = (z || this.$reverseLayout) ? i2 : i;
        } else {
            i3 = r5;
        }
        int i10 = i9 - i3;
        long r26 = ConstraintsKt.m6542offsetNN6EwU(j3, -i8, -i7);
        LazyGridItemProvider invoke = this.$itemProviderLambda.invoke();
        LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
        Density density = lazyLayoutMeasureScope2;
        LazyGridSlots r30 = this.$slots.m851invoke0kLqBqw(density, j3);
        int length = r30.getSizes().length;
        spanLayoutProvider.setSlotsPerLine(length);
        this.$state.setDensity$foundation_release(density);
        this.$state.setSlotsPerLine$foundation_release(length);
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                f = vertical.m570getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                f = horizontal.m552getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
            }
        }
        int r22 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(f);
        int itemCount = invoke.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m6525getMaxHeightimpl(j) - i7;
        } else {
            i4 = Constraints.m6526getMaxWidthimpl(j) - i8;
        }
        int i11 = i4;
        if (!this.$reverseLayout || i11 > 0) {
            j2 = IntOffsetKt.IntOffset(i, r4);
        } else {
            boolean z2 = this.$isVertical;
            if (!z2) {
                i += i11;
            }
            if (z2) {
                r4 += i11;
            }
            j2 = IntOffsetKt.IntOffset(i, r4);
        }
        int i12 = itemCount;
        Density density2 = density;
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = spanLayoutProvider;
        int i13 = i8;
        LazyGridItemProvider lazyGridItemProvider = invoke;
        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(invoke, lazyLayoutMeasureScope, r22, this.$state, this.$isVertical, this.$reverseLayout, i3, i10, j2);
        final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(this.$isVertical, r30, i12, r22, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, lazyGridSpanLayoutProvider);
        final LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider2 = lazyGridSpanLayoutProvider;
        this.$state.setPrefetchInfoRetriever$foundation_release(new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final ArrayList<Pair<Integer, Constraints>> invoke(int i) {
                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = lazyGridSpanLayoutProvider2.getLineConfiguration(i);
                int firstItemIndex = lineConfiguration.getFirstItemIndex();
                ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                List<GridItemSpan> spans = lineConfiguration.getSpans();
                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1;
                int size = spans.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    int r6 = GridItemSpan.m824getCurrentLineSpanimpl(spans.get(i3).m827unboximpl());
                    arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m6514boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m849childConstraintsJhjzzOo$foundation_release(i2, r6))));
                    firstItemIndex++;
                    i2 += r6;
                }
                return arrayList;
            }
        });
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.$state;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider, lazyGridState.getFirstVisibleItemIndex());
            int i14 = i12;
            if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= i14) {
                if (i14 > 0) {
                    i6 = lazyGridSpanLayoutProvider2.getLineIndexOfItem(i14 - 1);
                    i5 = 0;
                    Unit unit = Unit.INSTANCE;
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    createNonObservableSnapshot.dispose();
                    final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
                    final long j4 = j;
                    final int i15 = i13;
                    final int i16 = i7;
                    LazyGridMeasureResult r0 = LazyGridMeasureKt.m841measureLazyGridW2FL7xs(i14, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, i11, i3, i10, r22, i6, i5, this.$state.getScrollToBeConsumed$foundation_release(), r26, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, density2, this.$state.getPlacementAnimator$foundation_release(), lazyGridSpanLayoutProvider2, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), this.$coroutineScope, this.$state.m852getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                        }

                        public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
                            return lazyLayoutMeasureScope3.layout(ConstraintsKt.m6540constrainWidthK40F9xA(j4, i + i15), ConstraintsKt.m6539constrainHeightK40F9xA(j4, i2 + i16), MapsKt.emptyMap(), function1);
                        }
                    });
                    LazyGridState.applyMeasureResult$foundation_release$default(this.$state, r0, false, 2, (Object) null);
                    return r0;
                }
            }
            int lineIndexOfItem = lazyGridSpanLayoutProvider2.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
            i5 = lazyGridState.getFirstVisibleItemScrollOffset();
            i6 = lineIndexOfItem;
            Unit unit2 = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            final LazyLayoutMeasureScope lazyLayoutMeasureScope32 = lazyLayoutMeasureScope;
            final long j42 = j;
            final int i152 = i13;
            final int i162 = i7;
            LazyGridMeasureResult r02 = LazyGridMeasureKt.m841measureLazyGridW2FL7xs(i14, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, i11, i3, i10, r22, i6, i5, this.$state.getScrollToBeConsumed$foundation_release(), r26, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, density2, this.$state.getPlacementAnimator$foundation_release(), lazyGridSpanLayoutProvider2, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), this.$coroutineScope, this.$state.m852getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                }

                public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
                    return lazyLayoutMeasureScope32.layout(ConstraintsKt.m6540constrainWidthK40F9xA(j42, i + i152), ConstraintsKt.m6539constrainHeightK40F9xA(j42, i2 + i162), MapsKt.emptyMap(), function1);
                }
            });
            LazyGridState.applyMeasureResult$foundation_release$default(this.$state, r02, false, 2, (Object) null);
            return r02;
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
