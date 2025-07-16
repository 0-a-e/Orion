package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0004J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0002JT\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u001cJ\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/LazyListItemAnimator$ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "key", "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "isVertical", "isLookingAhead", "hasLookaheadOccurred", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startPlacementAnimationsIfNeeded", "ItemInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListItemAnimator.kt */
public final class LazyListItemAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0259, code lost:
        if (r2 >= r6.firstVisibleIndex) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x025b, code lost:
        r6.movingAwayToStartBound.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0261, code lost:
        r6.movingAwayToEndBound.add(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasured(int r20, int r21, int r22, java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r23, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r24, boolean r25, boolean r26, boolean r27, kotlinx.coroutines.CoroutineScope r28) {
        /*
            r19 = this;
            r6 = r19
            r0 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r1 = r28
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r10 = r6.keyIndexMap
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r11 = r24.getKeyIndexMap()
            r6.keyIndexMap = r11
            int r2 = r23.size()
            r12 = 0
            r3 = r12
        L_0x001a:
            if (r3 >= r2) goto L_0x002c
            java.lang.Object r4 = r9.get(r3)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r4 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r4
            boolean r4 = r6.getHasAnimations(r4)
            if (r4 == 0) goto L_0x0029
            goto L_0x0038
        L_0x0029:
            int r3 = r3 + 1
            goto L_0x001a
        L_0x002c:
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo> r2 = r6.keyToItemInfoMap
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0038
            r19.reset()
            return
        L_0x0038:
            int r2 = r6.firstVisibleIndex
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r23)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r3 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r3
            if (r3 == 0) goto L_0x0047
            int r3 = r3.getIndex()
            goto L_0x0048
        L_0x0047:
            r3 = r12
        L_0x0048:
            r6.firstVisibleIndex = r3
            if (r25 == 0) goto L_0x004e
            r13 = r8
            goto L_0x004f
        L_0x004e:
            r13 = r7
        L_0x004f:
            if (r25 == 0) goto L_0x0056
            long r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r12, r0)
            goto L_0x005a
        L_0x0056:
            long r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r0, r12)
        L_0x005a:
            if (r26 != 0) goto L_0x0061
            if (r27 != 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r15 = r12
            goto L_0x0062
        L_0x0061:
            r15 = 1
        L_0x0062:
            java.util.LinkedHashSet<java.lang.Object> r0 = r6.movingAwayKeys
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo> r5 = r6.keyToItemInfoMap
            java.util.Set r5 = r5.keySet()
            java.util.Collection r5 = (java.util.Collection) r5
            r0.addAll(r5)
            int r0 = r23.size()
            r5 = r12
        L_0x0074:
            if (r5 >= r0) goto L_0x017a
            java.lang.Object r16 = r9.get(r5)
            r12 = r16
            androidx.compose.foundation.lazy.LazyListMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r12
            java.util.LinkedHashSet<java.lang.Object> r14 = r6.movingAwayKeys
            r27 = r0
            java.lang.Object r0 = r12.getKey()
            r14.remove(r0)
            boolean r0 = r6.getHasAnimations(r12)
            if (r0 == 0) goto L_0x015e
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo> r0 = r6.keyToItemInfoMap
            java.lang.Object r14 = r12.getKey()
            java.lang.Object r0 = r0.get(r14)
            androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo r0 = (androidx.compose.foundation.lazy.LazyListItemAnimator.ItemInfo) r0
            if (r0 != 0) goto L_0x0101
            androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo r0 = new androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo
            r0.<init>()
            r0.updateAnimation(r12, r1)
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo> r14 = r6.keyToItemInfoMap
            java.lang.Object r9 = r12.getKey()
            r14.put(r9, r0)
            if (r10 == 0) goto L_0x00b9
            java.lang.Object r9 = r12.getKey()
            int r9 = r10.getIndex(r9)
            goto L_0x00ba
        L_0x00b9:
            r9 = -1
        L_0x00ba:
            int r14 = r12.getIndex()
            if (r14 == r9) goto L_0x00d3
            r14 = -1
            if (r9 == r14) goto L_0x00d3
            if (r9 >= r2) goto L_0x00cc
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingInFromStartBound
            r0.add(r12)
            goto L_0x015b
        L_0x00cc:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingInFromEndBound
            r0.add(r12)
            goto L_0x015b
        L_0x00d3:
            r14 = 0
            long r17 = r12.m814getOffsetBjo55l4(r14)
            boolean r14 = r12.isVertical()
            if (r14 == 0) goto L_0x00e3
            int r14 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r17)
            goto L_0x00e7
        L_0x00e3:
            int r14 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r17)
        L_0x00e7:
            r6.initializeAnimation(r12, r14, r0)
            r12 = -1
            if (r9 != r12) goto L_0x015b
            if (r10 == 0) goto L_0x015b
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation[] r0 = r0.getAnimations()
            int r9 = r0.length
            r14 = 0
        L_0x00f5:
            if (r14 >= r9) goto L_0x015b
            r12 = r0[r14]
            if (r12 == 0) goto L_0x00fe
            r12.animateAppearance()
        L_0x00fe:
            int r14 = r14 + 1
            goto L_0x00f5
        L_0x0101:
            if (r15 == 0) goto L_0x015b
            r0.updateAnimation(r12, r1)
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation[] r0 = r0.getAnimations()
            int r9 = r0.length
            r14 = 0
        L_0x010c:
            if (r14 >= r9) goto L_0x0155
            r1 = r0[r14]
            if (r1 == 0) goto L_0x0144
            long r7 = r1.m858getRawOffsetnOccac()
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$Companion r16 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.Companion
            r18 = r9
            r17 = r10
            long r9 = r16.m861getNotInitializednOccac()
            boolean r7 = androidx.compose.ui.unit.IntOffset.m6747equalsimpl0(r7, r9)
            if (r7 != 0) goto L_0x0148
            long r7 = r1.m858getRawOffsetnOccac()
            int r9 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r7)
            int r10 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r3)
            int r9 = r9 + r10
            int r7 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r7)
            int r8 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r3)
            int r7 = r7 + r8
            long r7 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r9, r7)
            r1.m860setRawOffsetgyyYBs(r7)
            goto L_0x0148
        L_0x0144:
            r18 = r9
            r17 = r10
        L_0x0148:
            int r14 = r14 + 1
            r7 = r21
            r8 = r22
            r1 = r28
            r10 = r17
            r9 = r18
            goto L_0x010c
        L_0x0155:
            r17 = r10
            r6.startPlacementAnimationsIfNeeded(r12)
            goto L_0x0169
        L_0x015b:
            r17 = r10
            goto L_0x0169
        L_0x015e:
            r17 = r10
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo> r0 = r6.keyToItemInfoMap
            java.lang.Object r1 = r12.getKey()
            r0.remove(r1)
        L_0x0169:
            int r5 = r5 + 1
            r7 = r21
            r8 = r22
            r9 = r23
            r0 = r27
            r1 = r28
            r10 = r17
            r12 = 0
            goto L_0x0074
        L_0x017a:
            r17 = r10
            if (r15 == 0) goto L_0x01fd
            if (r17 == 0) goto L_0x01fd
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingInFromStartBound
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L_0x0196
            androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$1 r1 = new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$1
            r7 = r17
            r1.<init>(r7)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
            goto L_0x0198
        L_0x0196:
            r7 = r17
        L_0x0198:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r8 = r6.movingInFromStartBound
            int r9 = r8.size()
            r0 = 0
            r14 = 0
        L_0x01a0:
            if (r14 >= r9) goto L_0x01c1
            java.lang.Object r1 = r8.get(r14)
            r10 = r1
            androidx.compose.foundation.lazy.LazyListMeasuredItem r10 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r10
            int r1 = r10.getSizeWithSpacings()
            int r12 = r0 + r1
            int r2 = 0 - r12
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r19
            r1 = r10
            initializeAnimation$default(r0, r1, r2, r3, r4, r5)
            r6.startPlacementAnimationsIfNeeded(r10)
            int r14 = r14 + 1
            r0 = r12
            goto L_0x01a0
        L_0x01c1:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingInFromEndBound
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L_0x01d4
            androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$1 r1 = new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$1
            r1.<init>(r7)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x01d4:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r8 = r6.movingInFromEndBound
            int r9 = r8.size()
            r0 = 0
            r14 = 0
        L_0x01dc:
            if (r14 >= r9) goto L_0x01ff
            java.lang.Object r1 = r8.get(r14)
            r10 = r1
            androidx.compose.foundation.lazy.LazyListMeasuredItem r10 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r10
            int r2 = r13 + r0
            int r1 = r10.getSizeWithSpacings()
            int r12 = r0 + r1
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r19
            r1 = r10
            initializeAnimation$default(r0, r1, r2, r3, r4, r5)
            r6.startPlacementAnimationsIfNeeded(r10)
            int r14 = r14 + 1
            r0 = r12
            goto L_0x01dc
        L_0x01fd:
            r7 = r17
        L_0x01ff:
            java.util.LinkedHashSet<java.lang.Object> r0 = r6.movingAwayKeys
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0207:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0267
            java.lang.Object r1 = r0.next()
            int r2 = r11.getIndex(r1)
            r3 = -1
            if (r2 != r3) goto L_0x0220
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo> r2 = r6.keyToItemInfoMap
            r2.remove(r1)
            r4 = r24
            goto L_0x0207
        L_0x0220:
            r4 = r24
            androidx.compose.foundation.lazy.LazyListMeasuredItem r5 = r4.getAndMeasure(r2)
            r8 = 1
            r5.setNonScrollableItem(r8)
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo> r9 = r6.keyToItemInfoMap
            java.lang.Object r9 = kotlin.collections.MapsKt.getValue(r9, r1)
            androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo r9 = (androidx.compose.foundation.lazy.LazyListItemAnimator.ItemInfo) r9
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation[] r9 = r9.getAnimations()
            int r10 = r9.length
            r14 = 0
        L_0x0238:
            if (r14 >= r10) goto L_0x0249
            r12 = r9[r14]
            if (r12 == 0) goto L_0x0245
            boolean r12 = r12.isPlacementAnimationInProgress()
            if (r12 != r8) goto L_0x0245
            goto L_0x0257
        L_0x0245:
            int r14 = r14 + 1
            r8 = 1
            goto L_0x0238
        L_0x0249:
            if (r7 == 0) goto L_0x0257
            int r8 = r7.getIndex(r1)
            if (r2 != r8) goto L_0x0257
            java.util.Map<java.lang.Object, androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo> r2 = r6.keyToItemInfoMap
            r2.remove(r1)
            goto L_0x0207
        L_0x0257:
            int r1 = r6.firstVisibleIndex
            if (r2 >= r1) goto L_0x0261
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r1 = r6.movingAwayToStartBound
            r1.add(r5)
            goto L_0x0207
        L_0x0261:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r1 = r6.movingAwayToEndBound
            r1.add(r5)
            goto L_0x0207
        L_0x0267:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingAwayToStartBound
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L_0x027a
            androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$2 r1 = new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$2
            r1.<init>(r11)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x027a:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingAwayToStartBound
            int r1 = r0.size()
            r2 = 0
            r14 = 0
        L_0x0282:
            if (r14 >= r1) goto L_0x02ae
            java.lang.Object r3 = r0.get(r14)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r3 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r3
            int r4 = r3.getSizeWithSpacings()
            int r2 = r2 + r4
            if (r26 == 0) goto L_0x029d
            java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r23)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r4 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r4
            int r4 = r4.getOffset()
            int r4 = r4 - r2
            goto L_0x029f
        L_0x029d:
            int r4 = 0 - r2
        L_0x029f:
            r5 = r21
            r7 = r22
            r3.position(r4, r5, r7)
            if (r15 == 0) goto L_0x02ab
            r6.startPlacementAnimationsIfNeeded(r3)
        L_0x02ab:
            int r14 = r14 + 1
            goto L_0x0282
        L_0x02ae:
            r5 = r21
            r7 = r22
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingAwayToEndBound
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L_0x02c5
            androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$2 r1 = new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$2
            r1.<init>(r11)
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r0, r1)
        L_0x02c5:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingAwayToEndBound
            int r1 = r0.size()
            r2 = 0
            r14 = 0
        L_0x02cd:
            if (r14 >= r1) goto L_0x02fa
            java.lang.Object r3 = r0.get(r14)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r3 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r3
            if (r26 == 0) goto L_0x02e8
            java.lang.Object r4 = kotlin.collections.CollectionsKt.last(r23)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r4 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r4
            int r8 = r4.getOffset()
            int r4 = r4.getSizeWithSpacings()
            int r8 = r8 + r4
            int r8 = r8 + r2
            goto L_0x02ea
        L_0x02e8:
            int r8 = r13 + r2
        L_0x02ea:
            int r4 = r3.getSizeWithSpacings()
            int r2 = r2 + r4
            r3.position(r8, r5, r7)
            if (r15 == 0) goto L_0x02f7
            r6.startPlacementAnimationsIfNeeded(r3)
        L_0x02f7:
            int r14 = r14 + 1
            goto L_0x02cd
        L_0x02fa:
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingAwayToStartBound
            kotlin.collections.CollectionsKt.reverse(r0)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = r23
            r2 = 0
            r1.addAll(r2, r0)
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingAwayToEndBound
            java.util.Collection r0 = (java.util.Collection) r0
            r1.addAll(r0)
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingInFromStartBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingInFromEndBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingAwayToStartBound
            r0.clear()
            java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r0 = r6.movingAwayToEndBound
            r0.clear()
            java.util.LinkedHashSet<java.lang.Object> r0 = r6.movingAwayKeys
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, boolean, boolean, boolean, kotlinx.coroutines.CoroutineScope):void");
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyListItemAnimator lazyListItemAnimator, LazyListMeasuredItem lazyListMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            itemInfo = (ItemInfo) MapsKt.getValue(lazyListItemAnimator.keyToItemInfoMap, lazyListMeasuredItem.getKey());
        }
        lazyListItemAnimator.initializeAnimation(lazyListMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyListMeasuredItem lazyListMeasuredItem, int i, ItemInfo itemInfo) {
        long j;
        int i2 = 0;
        long r7 = lazyListMeasuredItem.m814getOffsetBjo55l4(0);
        if (lazyListMeasuredItem.isVertical()) {
            j = IntOffset.m6744copyiSbpLlY$default(r7, 0, i, 1, (Object) null);
        } else {
            j = IntOffset.m6744copyiSbpLlY$default(r7, i, 0, 2, (Object) null);
        }
        LazyLayoutAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i3 = 0;
        while (i2 < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i2];
            int i4 = i3 + 1;
            if (lazyLayoutAnimation != null) {
                long r9 = lazyListMeasuredItem.m814getOffsetBjo55l4(i3);
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r9) - IntOffset.m6748getXimpl(r7), IntOffset.m6749getYimpl(r9) - IntOffset.m6749getYimpl(r7));
                lazyLayoutAnimation.m860setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(IntOffset), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(IntOffset)));
            }
            i2++;
            i3 = i4;
        }
    }

    private final void startPlacementAnimationsIfNeeded(LazyListMeasuredItem lazyListMeasuredItem) {
        LazyLayoutAnimation[] animations = ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyListMeasuredItem.getKey())).getAnimations();
        int length = animations.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutAnimation != null) {
                long r6 = lazyListMeasuredItem.m814getOffsetBjo55l4(i2);
                long r8 = lazyLayoutAnimation.m858getRawOffsetnOccac();
                if (!IntOffset.m6747equalsimpl0(r8, LazyLayoutAnimation.Companion.m861getNotInitializednOccac()) && !IntOffset.m6747equalsimpl0(r8, r6)) {
                    lazyLayoutAnimation.m855animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r6) - IntOffset.m6748getXimpl(r8), IntOffset.m6749getYimpl(r6) - IntOffset.m6749getYimpl(r8)));
                }
                lazyLayoutAnimation.m860setRawOffsetgyyYBs(r6);
            }
            i++;
            i2 = i3;
        }
    }

    public final LazyLayoutAnimation getAnimation(Object obj, int i) {
        LazyLayoutAnimation[] animations;
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[i];
    }

    private final boolean getHasAnimations(LazyListMeasuredItem lazyListMeasuredItem) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (LazyListItemAnimatorKt.getSpecs(lazyListMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator$ItemInfo;", "", "()V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "updateAnimation", "", "positionedItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyListItemAnimator.kt */
    private static final class ItemInfo {
        private LazyLayoutAnimation[] animations = LazyListItemAnimatorKt.EmptyArray;

        public final LazyLayoutAnimation[] getAnimations() {
            return this.animations;
        }

        public final void updateAnimation(LazyListMeasuredItem lazyListMeasuredItem, CoroutineScope coroutineScope) {
            int length = this.animations.length;
            for (int placeablesCount = lazyListMeasuredItem.getPlaceablesCount(); placeablesCount < length; placeablesCount++) {
                LazyLayoutAnimation lazyLayoutAnimation = this.animations[placeablesCount];
                if (lazyLayoutAnimation != null) {
                    lazyLayoutAnimation.stopAnimations();
                }
            }
            if (this.animations.length != lazyListMeasuredItem.getPlaceablesCount()) {
                Object[] copyOf = Arrays.copyOf(this.animations, lazyListMeasuredItem.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.animations = (LazyLayoutAnimation[]) copyOf;
            }
            int placeablesCount2 = lazyListMeasuredItem.getPlaceablesCount();
            for (int i = 0; i < placeablesCount2; i++) {
                LazyLayoutAnimationSpecsNode access$getSpecs = LazyListItemAnimatorKt.getSpecs(lazyListMeasuredItem.getParentData(i));
                if (access$getSpecs == null) {
                    LazyLayoutAnimation lazyLayoutAnimation2 = this.animations[i];
                    if (lazyLayoutAnimation2 != null) {
                        lazyLayoutAnimation2.stopAnimations();
                    }
                    this.animations[i] = null;
                } else {
                    LazyLayoutAnimation lazyLayoutAnimation3 = this.animations[i];
                    if (lazyLayoutAnimation3 == null) {
                        lazyLayoutAnimation3 = new LazyLayoutAnimation(coroutineScope);
                        this.animations[i] = lazyLayoutAnimation3;
                    }
                    lazyLayoutAnimation3.setAppearanceSpec(access$getSpecs.getAppearanceSpec());
                    lazyLayoutAnimation3.setPlacementSpec(access$getSpecs.getPlacementSpec());
                }
            }
        }
    }
}
