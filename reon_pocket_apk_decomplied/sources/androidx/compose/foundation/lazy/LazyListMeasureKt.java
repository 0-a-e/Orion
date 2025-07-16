package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\\\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002\u001a4\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001a\u0002\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072/\u00108\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:¢\u0006\u0002\b=\u0012\u0004\u0012\u00020>09H\u0000ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "consumedScroll", "", "isLookingAhead", "lastPostLookaheadLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "itemAnimator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "hasLookaheadPassOccurred", "postLookaheadLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-5IMabDg", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasure.kt */
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* renamed from: measureLazyList-5IMabDg  reason: not valid java name */
    public static final LazyListMeasureResult m810measureLazyList5IMabDg(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, List<Integer> list, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyListItemAnimator lazyListItemAnimator, int i8, List<Integer> list2, boolean z3, boolean z4, LazyListLayoutInfo lazyListLayoutInfo, CoroutineScope coroutineScope, MutableState<Unit> mutableState, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        LazyListMeasuredItem lazyListMeasuredItem;
        int i18;
        List<Integer> list3;
        LazyListMeasuredItem lazyListMeasuredItem2;
        List<LazyListMeasuredItem> list4;
        Orientation orientation;
        int i19;
        int i20;
        Orientation orientation2;
        int i21 = i;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        int i22 = i2;
        int i23 = i3;
        long j2 = j;
        boolean z5 = z4;
        Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function32 = function3;
        if (i23 < 0) {
            throw new IllegalArgumentException("invalid beforeContentPadding".toString());
        } else if (i4 < 0) {
            throw new IllegalArgumentException("invalid afterContentPadding".toString());
        } else if (i21 <= 0) {
            int r11 = Constraints.m6528getMinWidthimpl(j);
            int r16 = Constraints.m6527getMinHeightimpl(j);
            lazyListItemAnimator.onMeasured(0, r11, r16, new ArrayList(), lazyListMeasuredItemProvider, z, z4, z3, coroutineScope);
            MeasureResult measureResult = (MeasureResult) function32.invoke(Integer.valueOf(r11), Integer.valueOf(r16), LazyListMeasureKt$measureLazyList$3.INSTANCE);
            List emptyList = CollectionsKt.emptyList();
            int i24 = -i23;
            int i25 = i22 + i4;
            if (z) {
                orientation2 = Orientation.Vertical;
            } else {
                orientation2 = Orientation.Horizontal;
            }
            return new LazyListMeasureResult((LazyListMeasuredItem) null, 0, false, 0.0f, measureResult, 0.0f, false, emptyList, i24, i25, 0, z2, orientation2, i4, i5);
        } else {
            int i26 = 0;
            int i27 = i6;
            if (i27 >= i21) {
                i27 = i21 - 1;
                i9 = 0;
            } else {
                i9 = i7;
            }
            int roundToInt = MathKt.roundToInt(f);
            int i28 = i9 - roundToInt;
            if (i27 == 0 && i28 < 0) {
                roundToInt += i28;
                i28 = 0;
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            int i29 = -i23;
            int i30 = (i5 < 0 ? i5 : 0) + i29;
            int i31 = i28 + i30;
            int i32 = 0;
            while (i31 < 0 && i27 > 0) {
                i27--;
                int i33 = i29;
                LazyListMeasuredItem andMeasure = lazyListMeasuredItemProvider2.getAndMeasure(i27);
                arrayDeque.add(i26, andMeasure);
                i32 = Math.max(i32, andMeasure.getCrossAxisSize());
                i31 += andMeasure.getSizeWithSpacings();
                i29 = i33;
                i26 = 0;
            }
            int i34 = i29;
            if (i31 < i30) {
                roundToInt += i31;
                i31 = i30;
            }
            int i35 = i31 - i30;
            int i36 = i22 + i4;
            int i37 = i27;
            int coerceAtLeast = RangesKt.coerceAtLeast(i36, 0);
            int i38 = i37;
            int i39 = i35;
            int i40 = i32;
            int i41 = -i35;
            int i42 = 0;
            boolean z6 = false;
            while (i42 < arrayDeque.size()) {
                if (i41 >= coerceAtLeast) {
                    arrayDeque.remove(i42);
                    z6 = true;
                } else {
                    i38++;
                    i41 += ((LazyListMeasuredItem) arrayDeque.get(i42)).getSizeWithSpacings();
                    i42++;
                }
            }
            int i43 = i39;
            int i44 = i41;
            boolean z7 = z6;
            int i45 = i38;
            int i46 = i40;
            while (i45 < i21 && (i44 < coerceAtLeast || i44 <= 0 || arrayDeque.isEmpty())) {
                int i47 = coerceAtLeast;
                LazyListMeasuredItem andMeasure2 = lazyListMeasuredItemProvider2.getAndMeasure(i45);
                i44 += andMeasure2.getSizeWithSpacings();
                if (i44 <= i30) {
                    i19 = i30;
                    if (i45 != i21 - 1) {
                        i20 = i45 + 1;
                        i43 -= andMeasure2.getSizeWithSpacings();
                        z7 = true;
                        i45++;
                        coerceAtLeast = i47;
                        i37 = i20;
                        i30 = i19;
                    }
                } else {
                    i19 = i30;
                }
                i46 = Math.max(i46, andMeasure2.getCrossAxisSize());
                arrayDeque.add(andMeasure2);
                i20 = i37;
                i45++;
                coerceAtLeast = i47;
                i37 = i20;
                i30 = i19;
            }
            if (i44 < i22) {
                int i48 = i22 - i44;
                i43 -= i48;
                int i49 = i44 + i48;
                i13 = i46;
                i14 = i37;
                while (i43 < i23 && i14 > 0) {
                    i14--;
                    int i50 = i36;
                    LazyListMeasuredItem andMeasure3 = lazyListMeasuredItemProvider2.getAndMeasure(i14);
                    arrayDeque.add(0, andMeasure3);
                    i13 = Math.max(i13, andMeasure3.getCrossAxisSize());
                    i43 += andMeasure3.getSizeWithSpacings();
                    i36 = i50;
                    i45 = i45;
                }
                i10 = i36;
                i11 = i45;
                i15 = i48 + roundToInt;
                if (i43 < 0) {
                    i15 += i43;
                    i12 = i49 + i43;
                    i43 = 0;
                } else {
                    i12 = i49;
                }
            } else {
                i10 = i36;
                i11 = i45;
                i13 = i46;
                i15 = roundToInt;
                i12 = i44;
                i14 = i37;
            }
            float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(i15) || Math.abs(MathKt.roundToInt(f)) < Math.abs(i15)) ? f : (float) i15;
            float f3 = f - f2;
            float f4 = (!z5 || i15 <= roundToInt || f3 > 0.0f) ? 0.0f : ((float) (i15 - roundToInt)) + f3;
            if (i43 >= 0) {
                int i51 = -i43;
                LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.first();
                if (i23 > 0 || i5 < 0) {
                    int size = arrayDeque.size();
                    LazyListMeasuredItem lazyListMeasuredItem4 = lazyListMeasuredItem3;
                    int i52 = i43;
                    int i53 = 0;
                    while (true) {
                        if (i53 >= size) {
                            break;
                        }
                        int i54 = size;
                        int sizeWithSpacings = ((LazyListMeasuredItem) arrayDeque.get(i53)).getSizeWithSpacings();
                        if (i52 == 0 || sizeWithSpacings > i52) {
                            break;
                        }
                        i17 = i13;
                        if (i53 == CollectionsKt.getLastIndex(arrayDeque)) {
                            break;
                        }
                        i52 -= sizeWithSpacings;
                        i53++;
                        lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.get(i53);
                        i13 = i17;
                        size = i54;
                    }
                    i17 = i13;
                    lazyListMeasuredItem = lazyListMeasuredItem4;
                    i18 = i8;
                    list3 = list2;
                    i16 = i52;
                } else {
                    list3 = list2;
                    i17 = i13;
                    i16 = i43;
                    i18 = i8;
                    lazyListMeasuredItem = lazyListMeasuredItem3;
                }
                List<LazyListMeasuredItem> createItemsBeforeList = createItemsBeforeList(i14, lazyListMeasuredItemProvider2, i18, list3);
                int i55 = i17;
                int i56 = 0;
                for (int size2 = createItemsBeforeList.size(); i56 < size2; size2 = size2) {
                    i55 = Math.max(i55, createItemsBeforeList.get(i56).getCrossAxisSize());
                    i56++;
                }
                List list5 = arrayDeque;
                List<LazyListMeasuredItem> list6 = createItemsBeforeList;
                int i57 = i51;
                int i58 = i34;
                int i59 = i55;
                LazyListMeasuredItem lazyListMeasuredItem5 = lazyListMeasuredItem;
                ArrayDeque arrayDeque2 = arrayDeque;
                int i60 = i10;
                float f5 = f2;
                List<LazyListMeasuredItem> createItemsAfterList = createItemsAfterList(list5, lazyListMeasuredItemProvider, i, i8, list2, f2, z4, lazyListLayoutInfo);
                int size3 = createItemsAfterList.size();
                int i61 = i59;
                for (int i62 = 0; i62 < size3; i62++) {
                    i61 = Math.max(i61, createItemsAfterList.get(i62).getCrossAxisSize());
                }
                boolean z8 = Intrinsics.areEqual((Object) lazyListMeasuredItem5, arrayDeque2.first()) && list6.isEmpty() && createItemsAfterList.isEmpty();
                int r34 = ConstraintsKt.m6540constrainWidthK40F9xA(j2, z ? i61 : i12);
                if (z) {
                    i61 = i12;
                }
                int r35 = ConstraintsKt.m6539constrainHeightK40F9xA(j2, i61);
                int i63 = i12;
                boolean z9 = z5;
                List<LazyListMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(list5, list6, createItemsAfterList, r34, r35, i63, i2, i57, z, vertical, horizontal, z2, density);
                int i64 = i22;
                boolean z10 = z9;
                int i65 = i63;
                float f6 = f5;
                int i66 = i11;
                LazyListMeasuredItem lazyListMeasuredItem6 = lazyListMeasuredItem5;
                Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function33 = function3;
                lazyListItemAnimator.onMeasured((int) f5, r34, r35, calculateItemsOffsets, lazyListMeasuredItemProvider, z, z4, z3, coroutineScope);
                if (!list.isEmpty()) {
                    lazyListMeasuredItem2 = LazyListHeadersKt.findOrComposeLazyListHeader(calculateItemsOffsets, lazyListMeasuredItemProvider, list, i3, r34, r35);
                } else {
                    lazyListMeasuredItem2 = null;
                }
                float f7 = f6;
                boolean z11 = i66 < i || i65 > i64;
                MeasureResult measureResult2 = (MeasureResult) function33.invoke(Integer.valueOf(r34), Integer.valueOf(r35), new LazyListMeasureKt$measureLazyList$7(calculateItemsOffsets, lazyListMeasuredItem2, z10, mutableState));
                if (z8) {
                    list4 = calculateItemsOffsets;
                } else {
                    ArrayList arrayList = new ArrayList(calculateItemsOffsets.size());
                    int size4 = calculateItemsOffsets.size();
                    for (int i67 = 0; i67 < size4; i67++) {
                        LazyListMeasuredItem lazyListMeasuredItem7 = calculateItemsOffsets.get(i67);
                        LazyListMeasuredItem lazyListMeasuredItem8 = lazyListMeasuredItem7;
                        if ((lazyListMeasuredItem8.getIndex() >= ((LazyListMeasuredItem) arrayDeque2.first()).getIndex() && lazyListMeasuredItem8.getIndex() <= ((LazyListMeasuredItem) arrayDeque2.last()).getIndex()) || lazyListMeasuredItem8 == lazyListMeasuredItem2) {
                            arrayList.add(lazyListMeasuredItem7);
                        }
                    }
                    list4 = arrayList;
                }
                if (z) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                return new LazyListMeasureResult(lazyListMeasuredItem6, i16, z11, f7, measureResult2, f4, z7, list4, i58, i60, i, z2, orientation, i4, i5);
            }
            throw new IllegalArgumentException("negative currentFirstItemScrollOffset".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
        r7 = r7.get(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> createItemsAfterList(java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r14, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r15, int r16, int r17, java.util.List<java.lang.Integer> r18, float r19, boolean r20, androidx.compose.foundation.lazy.LazyListLayoutInfo r21) {
        /*
            r0 = r15
            r1 = r16
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r14)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r2
            int r2 = r2.getIndex()
            int r2 = r2 + r17
            int r3 = r1 + -1
            int r2 = java.lang.Math.min(r2, r3)
            java.lang.Object r4 = kotlin.collections.CollectionsKt.last(r14)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r4 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r4
            int r4 = r4.getIndex()
            int r4 = r4 + 1
            r5 = 0
            r6 = r5
            if (r4 > r2) goto L_0x003a
        L_0x0025:
            if (r6 != 0) goto L_0x002e
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
        L_0x002e:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r7 = r15.getAndMeasure(r4)
            r6.add(r7)
            if (r4 == r2) goto L_0x003a
            int r4 = r4 + 1
            goto L_0x0025
        L_0x003a:
            r4 = 0
            if (r20 == 0) goto L_0x015c
            if (r21 == 0) goto L_0x015c
            java.util.List r7 = r21.getVisibleItemsInfo()
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ 1
            if (r7 == 0) goto L_0x015c
            java.util.List r7 = r21.getVisibleItemsInfo()
            int r8 = r7.size()
            int r8 = r8 + -1
        L_0x0057:
            r9 = -1
            if (r9 >= r8) goto L_0x0080
            java.lang.Object r9 = r7.get(r8)
            androidx.compose.foundation.lazy.LazyListItemInfo r9 = (androidx.compose.foundation.lazy.LazyListItemInfo) r9
            int r9 = r9.getIndex()
            if (r9 <= r2) goto L_0x007d
            if (r8 == 0) goto L_0x0076
            int r9 = r8 + -1
            java.lang.Object r9 = r7.get(r9)
            androidx.compose.foundation.lazy.LazyListItemInfo r9 = (androidx.compose.foundation.lazy.LazyListItemInfo) r9
            int r9 = r9.getIndex()
            if (r9 > r2) goto L_0x007d
        L_0x0076:
            java.lang.Object r7 = r7.get(r8)
            androidx.compose.foundation.lazy.LazyListItemInfo r7 = (androidx.compose.foundation.lazy.LazyListItemInfo) r7
            goto L_0x0081
        L_0x007d:
            int r8 = r8 + -1
            goto L_0x0057
        L_0x0080:
            r7 = r5
        L_0x0081:
            java.util.List r8 = r21.getVisibleItemsInfo()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.last(r8)
            androidx.compose.foundation.lazy.LazyListItemInfo r8 = (androidx.compose.foundation.lazy.LazyListItemInfo) r8
            if (r7 == 0) goto L_0x00d1
            int r7 = r7.getIndex()
            int r9 = r8.getIndex()
            int r3 = java.lang.Math.min(r9, r3)
            if (r7 > r3) goto L_0x00d1
        L_0x009b:
            if (r6 == 0) goto L_0x00b9
            int r9 = r6.size()
            r10 = r4
        L_0x00a2:
            if (r10 >= r9) goto L_0x00b5
            java.lang.Object r11 = r6.get(r10)
            r12 = r11
            androidx.compose.foundation.lazy.LazyListMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r12
            int r12 = r12.getIndex()
            if (r12 != r7) goto L_0x00b2
            goto L_0x00b6
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x00a2
        L_0x00b5:
            r11 = r5
        L_0x00b6:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r11 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r11
            goto L_0x00ba
        L_0x00b9:
            r11 = r5
        L_0x00ba:
            if (r11 != 0) goto L_0x00cc
            if (r6 != 0) goto L_0x00c5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
        L_0x00c5:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r9 = r15.getAndMeasure(r7)
            r6.add(r9)
        L_0x00cc:
            if (r7 == r3) goto L_0x00d1
            int r7 = r7 + 1
            goto L_0x009b
        L_0x00d1:
            int r3 = r21.getViewportEndOffset()
            int r7 = r8.getOffset()
            int r3 = r3 - r7
            int r7 = r8.getSize()
            int r3 = r3 - r7
            float r3 = (float) r3
            float r3 = r3 - r19
            r7 = 0
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x015c
            int r7 = r8.getIndex()
            int r7 = r7 + 1
            r8 = r4
        L_0x00ee:
            if (r7 >= r1) goto L_0x015c
            float r9 = (float) r8
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x015c
            if (r7 > r2) goto L_0x0115
            int r9 = r14.size()
            r10 = r4
        L_0x00fc:
            if (r10 >= r9) goto L_0x0110
            r11 = r14
            java.lang.Object r12 = r14.get(r10)
            r13 = r12
            androidx.compose.foundation.lazy.LazyListMeasuredItem r13 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r13
            int r13 = r13.getIndex()
            if (r13 != r7) goto L_0x010d
            goto L_0x0112
        L_0x010d:
            int r10 = r10 + 1
            goto L_0x00fc
        L_0x0110:
            r11 = r14
            r12 = r5
        L_0x0112:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r12
            goto L_0x0135
        L_0x0115:
            r11 = r14
            if (r6 == 0) goto L_0x0134
            int r9 = r6.size()
            r10 = r4
        L_0x011d:
            if (r10 >= r9) goto L_0x0130
            java.lang.Object r12 = r6.get(r10)
            r13 = r12
            androidx.compose.foundation.lazy.LazyListMeasuredItem r13 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r13
            int r13 = r13.getIndex()
            if (r13 != r7) goto L_0x012d
            goto L_0x0131
        L_0x012d:
            int r10 = r10 + 1
            goto L_0x011d
        L_0x0130:
            r12 = r5
        L_0x0131:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r12
            goto L_0x0135
        L_0x0134:
            r12 = r5
        L_0x0135:
            if (r12 == 0) goto L_0x013f
            int r7 = r7 + 1
            int r9 = r12.getSizeWithSpacings()
        L_0x013d:
            int r8 = r8 + r9
            goto L_0x00ee
        L_0x013f:
            if (r6 != 0) goto L_0x0148
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
        L_0x0148:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r9 = r15.getAndMeasure(r7)
            r6.add(r9)
            int r7 = r7 + 1
            java.lang.Object r9 = kotlin.collections.CollectionsKt.last(r6)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r9 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r9
            int r9 = r9.getSizeWithSpacings()
            goto L_0x013d
        L_0x015c:
            if (r6 == 0) goto L_0x0174
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r6)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r1 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r1
            int r1 = r1.getIndex()
            if (r1 <= r2) goto L_0x0174
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r6)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r1 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r1
            int r2 = r1.getIndex()
        L_0x0174:
            int r1 = r18.size()
        L_0x0178:
            if (r4 >= r1) goto L_0x019b
            r3 = r18
            java.lang.Object r5 = r3.get(r4)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 <= r2) goto L_0x0198
            if (r6 != 0) goto L_0x0191
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
        L_0x0191:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r5 = r15.getAndMeasure(r5)
            r6.add(r5)
        L_0x0198:
            int r4 = r4 + 1
            goto L_0x0178
        L_0x019b:
            if (r6 != 0) goto L_0x01a1
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L_0x01a1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.createItemsAfterList(java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, java.util.List, float, boolean, androidx.compose.foundation.lazy.LazyListLayoutInfo):java.util.List");
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        List<LazyListMeasuredItem> list2 = null;
        if (max <= i3) {
            while (true) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(lazyListMeasuredItemProvider.getAndMeasure(i3));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i4 = size - 1;
                int intValue = list.get(size).intValue();
                if (intValue < max) {
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                    }
                    list2.add(lazyListMeasuredItemProvider.getAndMeasure(intValue));
                }
                if (i4 < 0) {
                    break;
                }
                size = i4;
            }
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        List<LazyListMeasuredItem> list4 = list;
        int i6 = i;
        int i7 = i2;
        Arrangement.Vertical vertical2 = vertical;
        boolean z3 = z2;
        int i8 = i4;
        int i9 = z ? i7 : i6;
        boolean z4 = i3 < Math.min(i9, i8);
        if (!z4 || i5 == 0) {
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
            if (!z4) {
                int size = list2.size();
                int i10 = i5;
                for (int i11 = 0; i11 < size; i11++) {
                    List<LazyListMeasuredItem> list5 = list2;
                    LazyListMeasuredItem lazyListMeasuredItem = list2.get(i11);
                    i10 -= lazyListMeasuredItem.getSizeWithSpacings();
                    lazyListMeasuredItem.position(i10, i6, i7);
                    arrayList.add(lazyListMeasuredItem);
                }
                int size2 = list.size();
                int i12 = i5;
                for (int i13 = 0; i13 < size2; i13++) {
                    LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i13);
                    lazyListMeasuredItem2.position(i12, i6, i7);
                    arrayList.add(lazyListMeasuredItem2);
                    i12 += lazyListMeasuredItem2.getSizeWithSpacings();
                }
                int size3 = list3.size();
                for (int i14 = 0; i14 < size3; i14++) {
                    LazyListMeasuredItem lazyListMeasuredItem3 = list3.get(i14);
                    lazyListMeasuredItem3.position(i12, i6, i7);
                    arrayList.add(lazyListMeasuredItem3);
                    i12 += lazyListMeasuredItem3.getSizeWithSpacings();
                }
            } else if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items".toString());
            } else {
                int size4 = list.size();
                int[] iArr = new int[size4];
                for (int i15 = 0; i15 < size4; i15++) {
                    iArr[i15] = list.get(calculateItemsOffsets$reverseAware(i15, z3, size4)).getSize();
                }
                int[] iArr2 = new int[size4];
                for (int i16 = 0; i16 < size4; i16++) {
                    iArr2[i16] = 0;
                }
                if (!z) {
                    Density density2 = density;
                    if (horizontal != null) {
                        horizontal.arrange(density, i9, iArr, LayoutDirection.Ltr, iArr2);
                    } else {
                        throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
                    }
                } else if (vertical2 != null) {
                    vertical2.arrange(density, i9, iArr, iArr2);
                } else {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                }
                IntProgression indices = ArraysKt.getIndices(iArr2);
                if (z3) {
                    indices = RangesKt.reversed(indices);
                }
                int first = indices.getFirst();
                int last = indices.getLast();
                int step = indices.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        int i17 = iArr2[first];
                        LazyListMeasuredItem lazyListMeasuredItem4 = list.get(calculateItemsOffsets$reverseAware(first, z3, size4));
                        if (z3) {
                            i17 = (i9 - i17) - lazyListMeasuredItem4.getSize();
                        }
                        lazyListMeasuredItem4.position(i17, i6, i7);
                        arrayList.add(lazyListMeasuredItem4);
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("non-zero itemsScrollOffset".toString());
    }
}
