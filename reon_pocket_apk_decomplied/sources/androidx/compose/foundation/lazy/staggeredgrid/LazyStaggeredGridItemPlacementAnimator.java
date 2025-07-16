package androidx.compose.foundation.lazy.staggeredgrid;

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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0002JL\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001bJ\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/staggeredgrid/ItemInfo;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "key", "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "isVertical", "laneCount", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startAnimationsIfNeeded", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridItemPlacementAnimator.kt */
public final class LazyStaggeredGridItemPlacementAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    /* access modifiers changed from: private */
    public LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final MutableScatterMap<Object, ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromStartBound = new ArrayList();

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyStaggeredGridItemPlacementAnimator lazyStaggeredGridItemPlacementAnimator, LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            ItemInfo itemInfo2 = lazyStaggeredGridItemPlacementAnimator.keyToItemInfoMap.get(lazyStaggeredGridMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyStaggeredGridItemPlacementAnimator.initializeAnimation(lazyStaggeredGridMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem, int i, ItemInfo itemInfo) {
        long j;
        long r6 = lazyStaggeredGridMeasuredItem.m946getOffsetnOccac();
        if (lazyStaggeredGridMeasuredItem.isVertical()) {
            j = IntOffset.m6744copyiSbpLlY$default(r6, 0, i, 1, (Object) null);
        } else {
            j = IntOffset.m6744copyiSbpLlY$default(r6, i, 0, 2, (Object) null);
        }
        for (LazyLayoutAnimation lazyLayoutAnimation : itemInfo.getAnimations()) {
            if (lazyLayoutAnimation != null) {
                long r4 = lazyStaggeredGridMeasuredItem.m946getOffsetnOccac();
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r4) - IntOffset.m6748getXimpl(r6), IntOffset.m6749getYimpl(r4) - IntOffset.m6749getYimpl(r6));
                lazyLayoutAnimation.m860setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(IntOffset), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(IntOffset)));
            }
        }
    }

    private final void startAnimationsIfNeeded(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem) {
        ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyStaggeredGridMeasuredItem.getKey());
        Intrinsics.checkNotNull(itemInfo);
        for (LazyLayoutAnimation lazyLayoutAnimation : itemInfo.getAnimations()) {
            if (lazyLayoutAnimation != null) {
                long r4 = lazyStaggeredGridMeasuredItem.m946getOffsetnOccac();
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

    private final boolean getHasAnimations(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem) {
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (LazyStaggeredGridItemPlacementAnimatorKt.getSpecs(lazyStaggeredGridMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x033e, code lost:
        if (r9 >= r6.firstVisibleIndex) goto L_0x0346;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0340, code lost:
        r6.movingAwayToStartBound.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0346, code lost:
        r6.movingAwayToEndBound.add(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasured(int r31, int r32, int r33, java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r34, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r35, boolean r36, int r37, kotlinx.coroutines.CoroutineScope r38) {
        /*
            r30 = this;
            r6 = r30
            r0 = r31
            r7 = r34
            r1 = r37
            int r2 = r34.size()
            r8 = 0
            r3 = r8
        L_0x000e:
            if (r3 >= r2) goto L_0x0020
            java.lang.Object r4 = r7.get(r3)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r4 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r4
            boolean r4 = r6.getHasAnimations(r4)
            if (r4 == 0) goto L_0x001d
            goto L_0x002c
        L_0x001d:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x0020:
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r2 = r6.keyToItemInfoMap
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x002c
            r30.reset()
            return
        L_0x002c:
            int r2 = r6.firstVisibleIndex
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r34)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r3 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r3
            if (r3 == 0) goto L_0x003b
            int r3 = r3.getIndex()
            goto L_0x003c
        L_0x003b:
            r3 = r8
        L_0x003c:
            r6.firstVisibleIndex = r3
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r9 = r6.keyIndexMap
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r3 = r35.getKeyIndexMap()
            r6.keyIndexMap = r3
            if (r36 == 0) goto L_0x004b
            r10 = r33
            goto L_0x004d
        L_0x004b:
            r10 = r32
        L_0x004d:
            if (r36 == 0) goto L_0x0054
            long r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r8, r0)
            goto L_0x0058
        L_0x0054:
            long r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r0, r8)
        L_0x0058:
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r0 = r6.keyToItemInfoMap
            androidx.collection.ScatterMap r0 = (androidx.collection.ScatterMap) r0
            java.lang.Object[] r5 = r0.keys
            long[] r0 = r0.metadata
            int r11 = r0.length
            int r11 = r11 + -2
            r16 = 7
            r17 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            if (r11 < 0) goto L_0x00c5
            r12 = 0
        L_0x006d:
            r14 = r0[r12]
            r13 = r9
            long r8 = ~r14
            long r8 = r8 << r16
            long r8 = r8 & r14
            long r8 = r8 & r17
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r8 == 0) goto L_0x00b7
            int r8 = r12 - r11
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r9 = 0
        L_0x0084:
            if (r9 >= r8) goto L_0x00ae
            r19 = 255(0xff, double:1.26E-321)
            long r21 = r14 & r19
            r23 = 128(0x80, double:6.32E-322)
            int r21 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r21 >= 0) goto L_0x00a0
            int r21 = r12 << 3
            int r21 = r21 + r9
            r22 = r0
            r0 = r5[r21]
            r21 = r5
            androidx.collection.MutableScatterSet<java.lang.Object> r5 = r6.movingAwayKeys
            r5.add(r0)
            goto L_0x00a4
        L_0x00a0:
            r22 = r0
            r21 = r5
        L_0x00a4:
            r0 = 8
            long r14 = r14 >> r0
            int r9 = r9 + 1
            r5 = r21
            r0 = r22
            goto L_0x0084
        L_0x00ae:
            r22 = r0
            r21 = r5
            r0 = 8
            if (r8 != r0) goto L_0x00c6
            goto L_0x00bb
        L_0x00b7:
            r22 = r0
            r21 = r5
        L_0x00bb:
            if (r12 == r11) goto L_0x00c6
            int r12 = r12 + 1
            r9 = r13
            r5 = r21
            r0 = r22
            goto L_0x006d
        L_0x00c5:
            r13 = r9
        L_0x00c6:
            int r0 = r34.size()
            r5 = 0
        L_0x00cb:
            r8 = -1
            if (r5 >= r0) goto L_0x01cf
            java.lang.Object r9 = r7.get(r5)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r9 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r9
            androidx.collection.MutableScatterSet<java.lang.Object> r11 = r6.movingAwayKeys
            java.lang.Object r12 = r9.getKey()
            r11.remove(r12)
            boolean r11 = r6.getHasAnimations(r9)
            if (r11 == 0) goto L_0x01b8
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r11 = r6.keyToItemInfoMap
            java.lang.Object r12 = r9.getKey()
            java.lang.Object r11 = r11.get(r12)
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r11 = (androidx.compose.foundation.lazy.staggeredgrid.ItemInfo) r11
            if (r11 != 0) goto L_0x014a
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r11 = new androidx.compose.foundation.lazy.staggeredgrid.ItemInfo
            int r12 = r9.getLane()
            int r14 = r9.getSpan()
            int r15 = r9.getCrossAxisOffset()
            r11.<init>(r12, r14, r15)
            r12 = r38
            r11.updateAnimation(r9, r12)
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r14 = r6.keyToItemInfoMap
            java.lang.Object r15 = r9.getKey()
            r14.set(r15, r11)
            java.lang.Object r14 = r9.getKey()
            int r14 = r13.getIndex(r14)
            if (r14 == r8) goto L_0x012e
            int r8 = r9.getIndex()
            if (r8 == r14) goto L_0x012e
            if (r14 >= r2) goto L_0x0128
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r8 = r6.movingInFromStartBound
            r8.add(r9)
            goto L_0x0144
        L_0x0128:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r8 = r6.movingInFromEndBound
            r8.add(r9)
            goto L_0x0144
        L_0x012e:
            long r14 = r9.m946getOffsetnOccac()
            boolean r8 = r9.isVertical()
            if (r8 == 0) goto L_0x013d
            int r8 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r14)
            goto L_0x0141
        L_0x013d:
            int r8 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r14)
        L_0x0141:
            r6.initializeAnimation(r9, r8, r11)
        L_0x0144:
            r36 = r0
            r23 = r13
            goto L_0x01c5
        L_0x014a:
            r12 = r38
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation[] r8 = r11.getAnimations()
            int r14 = r8.length
            r15 = 0
        L_0x0152:
            if (r15 >= r14) goto L_0x019b
            r36 = r0
            r0 = r8[r15]
            r21 = r8
            if (r0 == 0) goto L_0x018c
            long r7 = r0.m858getRawOffsetnOccac()
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$Companion r22 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.Companion
            r23 = r13
            long r12 = r22.m861getNotInitializednOccac()
            boolean r7 = androidx.compose.ui.unit.IntOffset.m6747equalsimpl0(r7, r12)
            if (r7 != 0) goto L_0x018e
            long r7 = r0.m858getRawOffsetnOccac()
            int r12 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r7)
            int r13 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r3)
            int r12 = r12 + r13
            int r7 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r7)
            int r8 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r3)
            int r7 = r7 + r8
            long r7 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r12, r7)
            r0.m860setRawOffsetgyyYBs(r7)
            goto L_0x018e
        L_0x018c:
            r23 = r13
        L_0x018e:
            int r15 = r15 + 1
            r7 = r34
            r0 = r36
            r12 = r38
            r8 = r21
            r13 = r23
            goto L_0x0152
        L_0x019b:
            r36 = r0
            r23 = r13
            int r0 = r9.getLane()
            r11.setLane(r0)
            int r0 = r9.getSpan()
            r11.setSpan(r0)
            int r0 = r9.getCrossAxisOffset()
            r11.setCrossAxisOffset(r0)
            r6.startAnimationsIfNeeded(r9)
            goto L_0x01c5
        L_0x01b8:
            r36 = r0
            r23 = r13
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r0 = r6.keyToItemInfoMap
            java.lang.Object r7 = r9.getKey()
            r0.remove(r7)
        L_0x01c5:
            int r5 = r5 + 1
            r7 = r34
            r0 = r36
            r13 = r23
            goto L_0x00cb
        L_0x01cf:
            r23 = r13
            int[] r7 = new int[r1]
            r0 = 0
        L_0x01d4:
            if (r0 >= r1) goto L_0x01dc
            r2 = 0
            r7[r0] = r2
            int r0 = r0 + 1
            goto L_0x01d4
        L_0x01dc:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingInFromStartBound
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r9 = 1
            r0 = r0 ^ r9
            if (r0 == 0) goto L_0x0244
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingInFromStartBound
            int r1 = r0.size()
            if (r1 <= r9) goto L_0x01fd
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1 r1 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
            r11 = r23
            r1.<init>(r11)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
            goto L_0x01ff
        L_0x01fd:
            r11 = r23
        L_0x01ff:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r12 = r6.movingInFromStartBound
            int r13 = r12.size()
            r14 = 0
        L_0x0206:
            if (r14 >= r13) goto L_0x0234
            java.lang.Object r0 = r12.get(r14)
            r15 = r0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r15 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r15
            int r0 = r15.getLane()
            r1 = r7[r0]
            int r2 = r15.getMainAxisSize()
            int r1 = r1 + r2
            r7[r0] = r1
            int r0 = r15.getLane()
            r0 = r7[r0]
            r1 = 0
            int r2 = 0 - r0
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r30
            r1 = r15
            initializeAnimation$default(r0, r1, r2, r3, r4, r5)
            r6.startAnimationsIfNeeded(r15)
            int r14 = r14 + 1
            goto L_0x0206
        L_0x0234:
            r28 = 6
            r29 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r24 = r7
            kotlin.collections.ArraysKt.fill$default((int[]) r24, (int) r25, (int) r26, (int) r27, (int) r28, (java.lang.Object) r29)
            goto L_0x0246
        L_0x0244:
            r11 = r23
        L_0x0246:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingInFromEndBound
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r9
            if (r0 == 0) goto L_0x02a6
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingInFromEndBound
            int r1 = r0.size()
            if (r1 <= r9) goto L_0x0263
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1 r1 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
            r1.<init>(r11)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x0263:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r12 = r6.movingInFromEndBound
            int r13 = r12.size()
            r14 = 0
        L_0x026a:
            if (r14 >= r13) goto L_0x0297
            java.lang.Object r0 = r12.get(r14)
            r15 = r0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r15 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r15
            int r0 = r15.getLane()
            r0 = r7[r0]
            int r2 = r10 + r0
            int r0 = r15.getLane()
            r1 = r7[r0]
            int r3 = r15.getMainAxisSize()
            int r1 = r1 + r3
            r7[r0] = r1
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r30
            r1 = r15
            initializeAnimation$default(r0, r1, r2, r3, r4, r5)
            r6.startAnimationsIfNeeded(r15)
            int r14 = r14 + 1
            goto L_0x026a
        L_0x0297:
            r28 = 6
            r29 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r24 = r7
            kotlin.collections.ArraysKt.fill$default((int[]) r24, (int) r25, (int) r26, (int) r27, (int) r28, (java.lang.Object) r29)
        L_0x02a6:
            androidx.collection.MutableScatterSet<java.lang.Object> r0 = r6.movingAwayKeys
            androidx.collection.ScatterSet r0 = (androidx.collection.ScatterSet) r0
            java.lang.Object[] r1 = r0.elements
            long[] r0 = r0.metadata
            int r2 = r0.length
            int r2 = r2 + -2
            if (r2 < 0) goto L_0x0380
            r3 = 0
        L_0x02b4:
            r4 = r0[r3]
            long r12 = ~r4
            long r12 = r12 << r16
            long r12 = r12 & r4
            long r12 = r12 & r17
            int r12 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r12 == 0) goto L_0x036a
            int r12 = r3 - r2
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r13 = r4
            r4 = 0
        L_0x02cb:
            if (r4 >= r12) goto L_0x035d
            r19 = 255(0xff, double:1.26E-321)
            long r21 = r13 & r19
            r23 = 128(0x80, double:6.32E-322)
            int r5 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x034c
            int r5 = r3 << 3
            int r5 = r5 + r4
            r5 = r1[r5]
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r15 = r6.keyToItemInfoMap
            java.lang.Object r15 = r15.get(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r15 = (androidx.compose.foundation.lazy.staggeredgrid.ItemInfo) r15
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r9 = r6.keyIndexMap
            int r9 = r9.getIndex(r5)
            if (r9 != r8) goto L_0x02f5
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r9 = r6.keyToItemInfoMap
            r9.remove(r5)
            goto L_0x034c
        L_0x02f5:
            int r8 = r15.getLane()
            r21 = r0
            int r0 = r15.getSpan()
            r22 = r1
            long r0 = androidx.compose.foundation.lazy.staggeredgrid.SpanRange.m951constructorimpl(r8, r0)
            r8 = r35
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r0 = r8.m942getAndMeasurejy6DScQ(r9, r0)
            r1 = 1
            r0.setNonScrollableItem(r1)
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation[] r15 = r15.getAnimations()
            int r1 = r15.length
            r8 = 0
        L_0x0315:
            if (r8 >= r1) goto L_0x0330
            r25 = r15[r8]
            r26 = r1
            if (r25 == 0) goto L_0x0327
            boolean r1 = r25.isPlacementAnimationInProgress()
            r36 = r15
            r15 = 1
            if (r1 != r15) goto L_0x0329
            goto L_0x033c
        L_0x0327:
            r36 = r15
        L_0x0329:
            int r8 = r8 + 1
            r15 = r36
            r1 = r26
            goto L_0x0315
        L_0x0330:
            int r1 = r11.getIndex(r5)
            if (r9 != r1) goto L_0x033c
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r0 = r6.keyToItemInfoMap
            r0.remove(r5)
            goto L_0x0350
        L_0x033c:
            int r1 = r6.firstVisibleIndex
            if (r9 >= r1) goto L_0x0346
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r1 = r6.movingAwayToStartBound
            r1.add(r0)
            goto L_0x0350
        L_0x0346:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r1 = r6.movingAwayToEndBound
            r1.add(r0)
            goto L_0x0350
        L_0x034c:
            r21 = r0
            r22 = r1
        L_0x0350:
            r0 = 8
            long r13 = r13 >> r0
            int r4 = r4 + 1
            r0 = r21
            r1 = r22
            r8 = -1
            r9 = 1
            goto L_0x02cb
        L_0x035d:
            r21 = r0
            r22 = r1
            r0 = 8
            r19 = 255(0xff, double:1.26E-321)
            r23 = 128(0x80, double:6.32E-322)
            if (r12 != r0) goto L_0x0380
            goto L_0x0374
        L_0x036a:
            r21 = r0
            r22 = r1
            r0 = 8
            r19 = 255(0xff, double:1.26E-321)
            r23 = 128(0x80, double:6.32E-322)
        L_0x0374:
            if (r3 == r2) goto L_0x0380
            int r3 = r3 + 1
            r0 = r21
            r1 = r22
            r8 = -1
            r9 = 1
            goto L_0x02b4
        L_0x0380:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingAwayToStartBound
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x03f7
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingAwayToStartBound
            int r2 = r0.size()
            if (r2 <= r1) goto L_0x039e
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2 r1 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
            r1.<init>(r6)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x039e:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingAwayToStartBound
            int r1 = r0.size()
            r2 = 0
        L_0x03a5:
            if (r2 >= r1) goto L_0x03e4
            java.lang.Object r3 = r0.get(r2)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r3 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r3
            int r4 = r3.getLane()
            r5 = r7[r4]
            int r8 = r3.getMainAxisSize()
            int r5 = r5 + r8
            r7[r4] = r5
            int r4 = r3.getLane()
            r4 = r7[r4]
            r5 = 0
            int r8 = 0 - r4
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r4 = r6.keyToItemInfoMap
            java.lang.Object r9 = r3.getKey()
            java.lang.Object r4 = r4.get(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r4 = (androidx.compose.foundation.lazy.staggeredgrid.ItemInfo) r4
            int r4 = r4.getCrossAxisOffset()
            r3.position(r8, r4, r10)
            r4 = r34
            r4.add(r3)
            r6.startAnimationsIfNeeded(r3)
            int r2 = r2 + 1
            goto L_0x03a5
        L_0x03e4:
            r4 = r34
            r5 = 0
            r28 = 6
            r29 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r24 = r7
            kotlin.collections.ArraysKt.fill$default((int[]) r24, (int) r25, (int) r26, (int) r27, (int) r28, (java.lang.Object) r29)
            goto L_0x03fa
        L_0x03f7:
            r4 = r34
            r5 = 0
        L_0x03fa:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingAwayToEndBound
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x045a
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingAwayToEndBound
            int r2 = r0.size()
            if (r2 <= r1) goto L_0x0418
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2 r1 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
            r1.<init>(r6)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x0418:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingAwayToEndBound
            int r1 = r0.size()
            r8 = r5
        L_0x041f:
            if (r8 >= r1) goto L_0x045a
            java.lang.Object r2 = r0.get(r8)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r2 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r2
            int r3 = r2.getLane()
            r3 = r7[r3]
            int r3 = r3 + r10
            int r5 = r2.getLane()
            r9 = r7[r5]
            int r11 = r2.getMainAxisSize()
            int r9 = r9 + r11
            r7[r5] = r9
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.staggeredgrid.ItemInfo> r5 = r6.keyToItemInfoMap
            java.lang.Object r9 = r2.getKey()
            java.lang.Object r5 = r5.get(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.compose.foundation.lazy.staggeredgrid.ItemInfo r5 = (androidx.compose.foundation.lazy.staggeredgrid.ItemInfo) r5
            int r5 = r5.getCrossAxisOffset()
            r2.position(r3, r5, r10)
            r4.add(r2)
            r6.startAnimationsIfNeeded(r2)
            int r8 = r8 + 1
            goto L_0x041f
        L_0x045a:
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingInFromStartBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingInFromEndBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingAwayToStartBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r0 = r6.movingAwayToEndBound
            r0.clear()
            androidx.collection.MutableScatterSet<java.lang.Object> r0 = r6.movingAwayKeys
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider, boolean, int, kotlinx.coroutines.CoroutineScope):void");
    }
}
