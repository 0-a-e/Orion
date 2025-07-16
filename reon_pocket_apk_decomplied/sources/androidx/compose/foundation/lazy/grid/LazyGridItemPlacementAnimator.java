package androidx.compose.foundation.lazy.grid;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0002JL\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001bJ\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "key", "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "isVertical", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startAnimationsIfNeeded", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridItemPlacementAnimator.kt */
public final class LazyGridItemPlacementAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    /* access modifiers changed from: private */
    public LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final MutableScatterMap<Object, ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromStartBound = new ArrayList();

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridMeasuredItem lazyGridMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            ItemInfo itemInfo2 = lazyGridItemPlacementAnimator.keyToItemInfoMap.get(lazyGridMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyGridItemPlacementAnimator.initializeAnimation(lazyGridMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyGridMeasuredItem lazyGridMeasuredItem, int i, ItemInfo itemInfo) {
        long j;
        long r6 = lazyGridMeasuredItem.m845getOffsetnOccac();
        if (lazyGridMeasuredItem.isVertical()) {
            j = IntOffset.m6744copyiSbpLlY$default(r6, 0, i, 1, (Object) null);
        } else {
            j = IntOffset.m6744copyiSbpLlY$default(r6, i, 0, 2, (Object) null);
        }
        for (LazyLayoutAnimation lazyLayoutAnimation : itemInfo.getAnimations()) {
            if (lazyLayoutAnimation != null) {
                long r4 = lazyGridMeasuredItem.m845getOffsetnOccac();
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r4) - IntOffset.m6748getXimpl(r6), IntOffset.m6749getYimpl(r4) - IntOffset.m6749getYimpl(r6));
                lazyLayoutAnimation.m860setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(IntOffset), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(IntOffset)));
            }
        }
    }

    private final void startAnimationsIfNeeded(LazyGridMeasuredItem lazyGridMeasuredItem) {
        ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyGridMeasuredItem.getKey());
        Intrinsics.checkNotNull(itemInfo);
        for (LazyLayoutAnimation lazyLayoutAnimation : itemInfo.getAnimations()) {
            if (lazyLayoutAnimation != null) {
                long r4 = lazyGridMeasuredItem.m845getOffsetnOccac();
                long r6 = lazyLayoutAnimation.m858getRawOffsetnOccac();
                if (!IntOffset.m6747equalsimpl0(r6, LazyLayoutAnimation.Companion.m861getNotInitializednOccac()) && !IntOffset.m6747equalsimpl0(r6, r4)) {
                    lazyLayoutAnimation.m855animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r4) - IntOffset.m6748getXimpl(r6), IntOffset.m6749getYimpl(r4) - IntOffset.m6749getYimpl(r6)));
                }
                lazyLayoutAnimation.m860setRawOffsetgyyYBs(r4);
            }
        }
    }

    public final LazyLayoutAnimation getAnimation(Object obj, int i) {
        ItemInfo itemInfo;
        LazyLayoutAnimation[] animations;
        if (this.keyToItemInfoMap.isEmpty() || (itemInfo = this.keyToItemInfoMap.get(obj)) == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[i];
    }

    private final boolean getHasAnimations(LazyGridMeasuredItem lazyGridMeasuredItem) {
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (LazyGridItemPlacementAnimatorKt.getSpecs(lazyGridMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0337, code lost:
        if (r11 >= r6.firstVisibleIndex) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0339, code lost:
        r6.movingAwayToStartBound.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x033f, code lost:
        r6.movingAwayToEndBound.add(r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasured(int r35, int r36, int r37, java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r38, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider r39, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider r40, boolean r41, kotlinx.coroutines.CoroutineScope r42) {
        /*
            r34 = this;
            r6 = r34
            r0 = r35
            r7 = r38
            r8 = r40
            int r1 = r38.size()
            r9 = 0
            r2 = r9
        L_0x000e:
            if (r2 >= r1) goto L_0x0020
            java.lang.Object r3 = r7.get(r2)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r3 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r3
            boolean r3 = r6.getHasAnimations(r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x002c
        L_0x001d:
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0020:
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r1 = r6.keyToItemInfoMap
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x002c
            r34.reset()
            return
        L_0x002c:
            int r1 = r6.firstVisibleIndex
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r38)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r2 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r2
            if (r2 == 0) goto L_0x003b
            int r2 = r2.getIndex()
            goto L_0x003c
        L_0x003b:
            r2 = r9
        L_0x003c:
            r6.firstVisibleIndex = r2
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r10 = r6.keyIndexMap
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r2 = r39.getKeyIndexMap()
            r6.keyIndexMap = r2
            if (r41 == 0) goto L_0x004b
            r11 = r37
            goto L_0x004d
        L_0x004b:
            r11 = r36
        L_0x004d:
            if (r41 == 0) goto L_0x0054
            long r2 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r9, r0)
            goto L_0x0058
        L_0x0054:
            long r2 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r0, r9)
        L_0x0058:
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r0 = r6.keyToItemInfoMap
            androidx.collection.ScatterMap r0 = (androidx.collection.ScatterMap) r0
            java.lang.Object[] r4 = r0.keys
            long[] r0 = r0.metadata
            int r5 = r0.length
            int r5 = r5 + -2
            r16 = 7
            r17 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            if (r5 < 0) goto L_0x00c5
            r12 = 0
        L_0x006d:
            r14 = r0[r12]
            r13 = r10
            long r9 = ~r14
            long r9 = r9 << r16
            long r9 = r9 & r14
            long r9 = r9 & r17
            int r9 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r9 == 0) goto L_0x00b7
            int r9 = r12 - r5
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r10 = 0
        L_0x0084:
            if (r10 >= r9) goto L_0x00ae
            r22 = 255(0xff, double:1.26E-321)
            long r24 = r14 & r22
            r20 = 128(0x80, double:6.32E-322)
            int r24 = (r24 > r20 ? 1 : (r24 == r20 ? 0 : -1))
            if (r24 >= 0) goto L_0x00a0
            int r24 = r12 << 3
            int r24 = r24 + r10
            r25 = r0
            r0 = r4[r24]
            r24 = r4
            androidx.collection.MutableScatterSet<java.lang.Object> r4 = r6.movingAwayKeys
            r4.add(r0)
            goto L_0x00a4
        L_0x00a0:
            r25 = r0
            r24 = r4
        L_0x00a4:
            r0 = 8
            long r14 = r14 >> r0
            int r10 = r10 + 1
            r4 = r24
            r0 = r25
            goto L_0x0084
        L_0x00ae:
            r25 = r0
            r24 = r4
            r0 = 8
            if (r9 != r0) goto L_0x00c6
            goto L_0x00bb
        L_0x00b7:
            r25 = r0
            r24 = r4
        L_0x00bb:
            if (r12 == r5) goto L_0x00c6
            int r12 = r12 + 1
            r10 = r13
            r4 = r24
            r0 = r25
            goto L_0x006d
        L_0x00c5:
            r13 = r10
        L_0x00c6:
            int r0 = r38.size()
            r4 = 0
        L_0x00cb:
            r9 = -1
            if (r4 >= r0) goto L_0x01c4
            java.lang.Object r5 = r7.get(r4)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r5 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r5
            androidx.collection.MutableScatterSet<java.lang.Object> r10 = r6.movingAwayKeys
            java.lang.Object r12 = r5.getKey()
            r10.remove(r12)
            boolean r10 = r6.getHasAnimations(r5)
            if (r10 == 0) goto L_0x01ab
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r10 = r6.keyToItemInfoMap
            java.lang.Object r12 = r5.getKey()
            java.lang.Object r10 = r10.get(r12)
            androidx.compose.foundation.lazy.grid.ItemInfo r10 = (androidx.compose.foundation.lazy.grid.ItemInfo) r10
            if (r10 != 0) goto L_0x0146
            androidx.compose.foundation.lazy.grid.ItemInfo r10 = new androidx.compose.foundation.lazy.grid.ItemInfo
            int r12 = r5.getCrossAxisSize()
            int r14 = r5.getCrossAxisOffset()
            r10.<init>(r12, r14)
            r12 = r42
            r10.updateAnimation(r5, r12)
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r14 = r6.keyToItemInfoMap
            java.lang.Object r15 = r5.getKey()
            r14.set(r15, r10)
            java.lang.Object r14 = r5.getKey()
            int r14 = r13.getIndex(r14)
            if (r14 == r9) goto L_0x012a
            int r9 = r5.getIndex()
            if (r9 == r14) goto L_0x012a
            if (r14 >= r1) goto L_0x0124
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r9 = r6.movingInFromStartBound
            r9.add(r5)
            goto L_0x0140
        L_0x0124:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r9 = r6.movingInFromEndBound
            r9.add(r5)
            goto L_0x0140
        L_0x012a:
            long r14 = r5.m845getOffsetnOccac()
            boolean r9 = r5.isVertical()
            if (r9 == 0) goto L_0x0139
            int r9 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r14)
            goto L_0x013d
        L_0x0139:
            int r9 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r14)
        L_0x013d:
            r6.initializeAnimation(r5, r9, r10)
        L_0x0140:
            r24 = r0
            r26 = r11
            goto L_0x01b8
        L_0x0146:
            r12 = r42
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation[] r9 = r10.getAnimations()
            int r14 = r9.length
            r15 = 0
        L_0x014e:
            if (r15 >= r14) goto L_0x0195
            r24 = r0
            r0 = r9[r15]
            if (r0 == 0) goto L_0x0186
            long r7 = r0.m858getRawOffsetnOccac()
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$Companion r25 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.Companion
            r26 = r11
            long r11 = r25.m861getNotInitializednOccac()
            boolean r7 = androidx.compose.ui.unit.IntOffset.m6747equalsimpl0(r7, r11)
            if (r7 != 0) goto L_0x0188
            long r7 = r0.m858getRawOffsetnOccac()
            int r11 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r7)
            int r12 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r2)
            int r11 = r11 + r12
            int r7 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r7)
            int r8 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r2)
            int r7 = r7 + r8
            long r7 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r11, r7)
            r0.m860setRawOffsetgyyYBs(r7)
            goto L_0x0188
        L_0x0186:
            r26 = r11
        L_0x0188:
            int r15 = r15 + 1
            r7 = r38
            r8 = r40
            r12 = r42
            r0 = r24
            r11 = r26
            goto L_0x014e
        L_0x0195:
            r24 = r0
            r26 = r11
            int r0 = r5.getCrossAxisSize()
            r10.setCrossAxisSize(r0)
            int r0 = r5.getCrossAxisOffset()
            r10.setCrossAxisOffset(r0)
            r6.startAnimationsIfNeeded(r5)
            goto L_0x01b8
        L_0x01ab:
            r24 = r0
            r26 = r11
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r0 = r6.keyToItemInfoMap
            java.lang.Object r5 = r5.getKey()
            r0.remove(r5)
        L_0x01b8:
            int r4 = r4 + 1
            r7 = r38
            r8 = r40
            r0 = r24
            r11 = r26
            goto L_0x00cb
        L_0x01c4:
            r26 = r11
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingInFromStartBound
            int r1 = r0.size()
            r7 = 1
            if (r1 <= r7) goto L_0x01d9
            androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1 r1 = new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
            r1.<init>(r13)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x01d9:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r8 = r6.movingInFromStartBound
            int r10 = r8.size()
            r0 = r9
            r1 = 0
            r2 = 0
            r11 = 0
        L_0x01e3:
            if (r11 >= r10) goto L_0x022c
            java.lang.Object r3 = r8.get(r11)
            r12 = r3
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r12 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r12
            if (r41 == 0) goto L_0x01f3
            int r3 = r12.getRow()
            goto L_0x01f7
        L_0x01f3:
            int r3 = r12.getColumn()
        L_0x01f7:
            if (r3 == r9) goto L_0x0208
            if (r3 != r0) goto L_0x0208
            int r3 = r12.getMainAxisSize()
            int r1 = java.lang.Math.max(r1, r3)
            r14 = r0
            r15 = r1
            r24 = r2
            goto L_0x0211
        L_0x0208:
            int r2 = r2 + r1
            int r0 = r12.getMainAxisSize()
            r15 = r0
            r24 = r2
            r14 = r3
        L_0x0211:
            int r0 = 0 - r24
            int r1 = r12.getMainAxisSize()
            int r2 = r0 - r1
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r34
            r1 = r12
            initializeAnimation$default(r0, r1, r2, r3, r4, r5)
            r6.startAnimationsIfNeeded(r12)
            int r11 = r11 + 1
            r0 = r14
            r1 = r15
            r2 = r24
            goto L_0x01e3
        L_0x022c:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingInFromEndBound
            int r1 = r0.size()
            if (r1 <= r7) goto L_0x023e
            androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1 r1 = new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
            r1.<init>(r13)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x023e:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r8 = r6.movingInFromEndBound
            int r10 = r8.size()
            r0 = r9
            r1 = 0
            r2 = 0
            r11 = 0
        L_0x0248:
            if (r11 >= r10) goto L_0x028b
            java.lang.Object r3 = r8.get(r11)
            r12 = r3
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r12 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r12
            if (r41 == 0) goto L_0x0258
            int r3 = r12.getRow()
            goto L_0x025c
        L_0x0258:
            int r3 = r12.getColumn()
        L_0x025c:
            if (r3 == r9) goto L_0x026d
            if (r3 != r0) goto L_0x026d
            int r3 = r12.getMainAxisSize()
            int r1 = java.lang.Math.max(r1, r3)
            r14 = r0
            r15 = r1
            r24 = r2
            goto L_0x0276
        L_0x026d:
            int r2 = r2 + r1
            int r0 = r12.getMainAxisSize()
            r15 = r0
            r24 = r2
            r14 = r3
        L_0x0276:
            int r2 = r26 + r24
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r34
            r1 = r12
            initializeAnimation$default(r0, r1, r2, r3, r4, r5)
            r6.startAnimationsIfNeeded(r12)
            int r11 = r11 + 1
            r0 = r14
            r1 = r15
            r2 = r24
            goto L_0x0248
        L_0x028b:
            androidx.collection.MutableScatterSet<java.lang.Object> r0 = r6.movingAwayKeys
            androidx.collection.ScatterSet r0 = (androidx.collection.ScatterSet) r0
            java.lang.Object[] r1 = r0.elements
            long[] r0 = r0.metadata
            int r2 = r0.length
            int r2 = r2 + -2
            if (r2 < 0) goto L_0x0375
            r3 = 0
        L_0x0299:
            r4 = r0[r3]
            long r10 = ~r4
            long r10 = r10 << r16
            long r10 = r10 & r4
            long r10 = r10 & r17
            int r8 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r8 == 0) goto L_0x0361
            int r8 = r3 - r2
            int r8 = ~r8
            int r8 = r8 >>> 31
            r10 = 8
            int r8 = 8 - r8
            r10 = 0
        L_0x02af:
            if (r10 >= r8) goto L_0x0356
            r11 = 255(0xff, double:1.26E-321)
            long r14 = r4 & r11
            r20 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r14 >= 0) goto L_0x0345
            int r14 = r3 << 3
            int r14 = r14 + r10
            r14 = r1[r14]
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r15 = r6.keyToItemInfoMap
            java.lang.Object r15 = r15.get(r14)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            androidx.compose.foundation.lazy.grid.ItemInfo r15 = (androidx.compose.foundation.lazy.grid.ItemInfo) r15
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r11 = r6.keyIndexMap
            int r11 = r11.getIndex(r14)
            if (r11 != r9) goto L_0x02da
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r11 = r6.keyToItemInfoMap
            r11.remove(r14)
            goto L_0x0345
        L_0x02da:
            if (r41 == 0) goto L_0x02e7
            androidx.compose.ui.unit.Constraints$Companion r12 = androidx.compose.ui.unit.Constraints.Companion
            int r9 = r15.getCrossAxisSize()
            long r27 = r12.m6536fixedWidthOenEA2s(r9)
            goto L_0x02f1
        L_0x02e7:
            androidx.compose.ui.unit.Constraints$Companion r9 = androidx.compose.ui.unit.Constraints.Companion
            int r12 = r15.getCrossAxisSize()
            long r27 = r9.m6535fixedHeightOenEA2s(r12)
        L_0x02f1:
            r30 = r27
            r32 = 2
            r33 = 0
            r29 = 0
            r27 = r39
            r28 = r11
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r9 = androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.m847getAndMeasure3p2s80s$default(r27, r28, r29, r30, r32, r33)
            r9.setNonScrollableItem(r7)
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation[] r12 = r15.getAnimations()
            int r15 = r12.length
            r7 = 0
        L_0x030a:
            if (r7 >= r15) goto L_0x0325
            r25 = r12[r7]
            r27 = r0
            if (r25 == 0) goto L_0x031c
            boolean r0 = r25.isPlacementAnimationInProgress()
            r25 = r1
            r1 = 1
            if (r0 != r1) goto L_0x031e
            goto L_0x0335
        L_0x031c:
            r25 = r1
        L_0x031e:
            int r7 = r7 + 1
            r1 = r25
            r0 = r27
            goto L_0x030a
        L_0x0325:
            r27 = r0
            r25 = r1
            int r0 = r13.getIndex(r14)
            if (r11 != r0) goto L_0x0335
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r0 = r6.keyToItemInfoMap
            r0.remove(r14)
            goto L_0x0349
        L_0x0335:
            int r0 = r6.firstVisibleIndex
            if (r11 >= r0) goto L_0x033f
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingAwayToStartBound
            r0.add(r9)
            goto L_0x0349
        L_0x033f:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingAwayToEndBound
            r0.add(r9)
            goto L_0x0349
        L_0x0345:
            r27 = r0
            r25 = r1
        L_0x0349:
            r0 = 8
            long r4 = r4 >> r0
            int r10 = r10 + 1
            r1 = r25
            r0 = r27
            r7 = 1
            r9 = -1
            goto L_0x02af
        L_0x0356:
            r27 = r0
            r25 = r1
            r0 = 8
            r20 = 128(0x80, double:6.32E-322)
            if (r8 != r0) goto L_0x0375
            goto L_0x0369
        L_0x0361:
            r27 = r0
            r25 = r1
            r0 = 8
            r20 = 128(0x80, double:6.32E-322)
        L_0x0369:
            if (r3 == r2) goto L_0x0375
            int r3 = r3 + 1
            r1 = r25
            r0 = r27
            r7 = 1
            r9 = -1
            goto L_0x0299
        L_0x0375:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingAwayToStartBound
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L_0x0388
            androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2 r1 = new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
            r1.<init>(r6)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x0388:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingAwayToStartBound
            int r1 = r0.size()
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = 0
        L_0x0392:
            if (r2 >= r1) goto L_0x03f1
            java.lang.Object r7 = r0.get(r2)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r7 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r7
            int r8 = r7.getIndex()
            r15 = r40
            int r8 = r15.getLineIndexOfItem(r8)
            r9 = -1
            if (r8 == r9) goto L_0x03b2
            if (r8 != r3) goto L_0x03b2
            int r8 = r7.getMainAxisSize()
            int r4 = java.lang.Math.max(r4, r8)
            goto L_0x03b9
        L_0x03b2:
            int r5 = r5 + r4
            int r3 = r7.getMainAxisSize()
            r4 = r3
            r3 = r8
        L_0x03b9:
            int r8 = 0 - r5
            int r9 = r7.getMainAxisSize()
            int r9 = r8 - r9
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r8 = r6.keyToItemInfoMap
            java.lang.Object r10 = r7.getKey()
            java.lang.Object r8 = r8.get(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            androidx.compose.foundation.lazy.grid.ItemInfo r8 = (androidx.compose.foundation.lazy.grid.ItemInfo) r8
            int r10 = r8.getCrossAxisOffset()
            r16 = 48
            r17 = 0
            r13 = 0
            r14 = 0
            r8 = r7
            r11 = r36
            r12 = r37
            r15 = r16
            r16 = r17
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem.position$default(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r8 = r38
            r8.add(r7)
            r6.startAnimationsIfNeeded(r7)
            int r2 = r2 + 1
            goto L_0x0392
        L_0x03f1:
            r8 = r38
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingAwayToEndBound
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L_0x0406
            androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2 r1 = new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
            r1.<init>(r6)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x0406:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingAwayToEndBound
            int r1 = r0.size()
            r2 = -1
            r3 = 0
            r9 = 0
            r19 = 0
        L_0x0411:
            if (r9 >= r1) goto L_0x0469
            java.lang.Object r4 = r0.get(r9)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r4 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r4
            int r5 = r4.getIndex()
            r7 = r40
            int r5 = r7.getLineIndexOfItem(r5)
            r15 = -1
            if (r5 == r15) goto L_0x0431
            if (r5 != r2) goto L_0x0431
            int r5 = r4.getMainAxisSize()
            int r3 = java.lang.Math.max(r3, r5)
            goto L_0x0439
        L_0x0431:
            int r19 = r19 + r3
            int r2 = r4.getMainAxisSize()
            r3 = r2
            r2 = r5
        L_0x0439:
            int r11 = r26 + r19
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.grid.ItemInfo> r5 = r6.keyToItemInfoMap
            java.lang.Object r10 = r4.getKey()
            java.lang.Object r5 = r5.get(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.compose.foundation.lazy.grid.ItemInfo r5 = (androidx.compose.foundation.lazy.grid.ItemInfo) r5
            int r12 = r5.getCrossAxisOffset()
            r17 = 48
            r18 = 0
            r5 = 0
            r16 = 0
            r10 = r4
            r13 = r36
            r14 = r37
            r20 = r15
            r15 = r5
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem.position$default(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r8.add(r4)
            r6.startAnimationsIfNeeded(r4)
            int r9 = r9 + 1
            goto L_0x0411
        L_0x0469:
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingInFromStartBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingInFromEndBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingAwayToStartBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r0 = r6.movingAwayToEndBound
            r0.clear()
            androidx.collection.MutableScatterSet<java.lang.Object> r0 = r6.movingAwayKeys
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider, boolean, kotlinx.coroutines.CoroutineScope):void");
    }
}
