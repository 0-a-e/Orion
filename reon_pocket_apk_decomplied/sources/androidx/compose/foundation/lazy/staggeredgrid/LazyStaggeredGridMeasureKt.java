package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\b\u000fH\b¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0001H\b\u001a;\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\"\u001a\u001d\u0010#\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001dH\u0002¢\u0006\u0002\u0010$\u001a\u001c\u0010%\u001a\u00020\u0005*\u00020\u00142\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0003H\u0002\u001a7\u0010(\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00122\b\b\u0002\u0010)\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00050\u000eH\b\u001a\u001c\u0010+\u001a\u00020\u0003*\u00020\u00142\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a+\u0010.\u001a\u00020\u0005*\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\f\u00102\u001a\u00020\u0003*\u00020 H\u0002\u001a2\u00103\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001d2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\b¢\u0006\u0002\u00104\u001a\u0016\u00105\u001a\u00020\u0003*\u00020 2\b\b\u0002\u00106\u001a\u00020\u0003H\u0000\u001a\u001e\u00107\u001a\u00020\u0003*\u00020 2\u0006\u00108\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a,\u0010;\u001a\u00020<*\u00020\u00142\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u0001H\u0003\u001a\u0001\u0010A\u001a\u00020<*\u00020\f2\u0006\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00032\u0006\u0010S\u001a\u00020TH\u0001ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a\u0014\u0010W\u001a\u00020\u0005*\u00020 2\u0006\u0010X\u001a\u00020\u0003H\u0002\u001a!\u0010Y\u001a\u00020 *\u00020 2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[II)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "fastForEach", "reverse", "action", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "measureStaggeredGrid-sdzDtKU", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* renamed from: measureStaggeredGrid-sdzDtKU  reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m938measureStaggeredGridsdzDtKU(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope) {
        Snapshot makeCurrent;
        Object obj;
        Object obj2;
        int i5;
        int i6;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, (DefaultConstructorMarker) null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices());
            int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition$foundation_release().getScrollOffsets();
            if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
                obj = updateScrollPositionIfTheFirstItemWasMoved$foundation_release;
            } else {
                lazyStaggeredGridMeasureContext.getLaneInfo().reset();
                int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
                int[] iArr = new int[laneCount];
                for (int i7 = 0; i7 < laneCount; i7++) {
                    if (i7 < updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length && (i6 = updateScrollPositionIfTheFirstItemWasMoved$foundation_release[i7]) != -1) {
                        i5 = i6;
                    } else if (i7 == 0) {
                        i5 = 0;
                    } else {
                        i5 = m937maxInRangejy6DScQ(iArr, SpanRange.m951constructorimpl(0, i7)) + 1;
                    }
                    iArr[i7] = i5;
                    lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i7], i7);
                }
                obj = iArr;
            }
            objectRef.element = obj;
            if (scrollOffsets.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
                obj2 = scrollOffsets;
            } else {
                int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
                int[] iArr2 = new int[laneCount2];
                int i8 = 0;
                while (i8 < laneCount2) {
                    iArr2[i8] = i8 < scrollOffsets.length ? scrollOffsets[i8] : i8 == 0 ? 0 : iArr2[i8 - 1];
                    i8++;
                }
                obj2 = iArr2;
            }
            objectRef2.element = obj2;
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            return measure(lazyStaggeredGridMeasureContext, MathKt.roundToInt(lazyStaggeredGridState.getScrollToBeConsumed$foundation_release()), (int[]) objectRef.element, (int[]) objectRef2.element, true);
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02f4, code lost:
        r2 = indexOfMinValue$default(r5, 0, 1, (java.lang.Object) null);
        r4 = indexOfMaxValue(r29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02ff, code lost:
        if (r2 == r4) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0305, code lost:
        if (r5[r2] != r5[r4]) goto L_0x0309;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0307, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0309, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x030a, code lost:
        r4 = r29[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x030d, code lost:
        if (r4 != -1) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x030f, code lost:
        r8 = r37;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0313, code lost:
        r8 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0315, code lost:
        r4 = findPreviousItemIndex(r8, r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0319, code lost:
        if (r4 >= 0) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x031b, code lost:
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x031d, code lost:
        if (r0 != false) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0323, code lost:
        if (measure$lambda$38$misalignedStart(r7, r8, r5, r2) == false) goto L_0x034f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0325, code lost:
        if (r41 == false) goto L_0x034f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0327, code lost:
        r37.getLaneInfo().reset();
        r0 = r7.length;
        r1 = new int[r0];
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0332, code lost:
        if (r3 >= r0) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0334, code lost:
        r1[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x033a, code lost:
        r0 = r5.length;
        r3 = new int[r0];
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x033e, code lost:
        if (r4 >= r0) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0340, code lost:
        r3[r4] = r5[r2];
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x034e, code lost:
        return measure(r8, r28, r1, r3, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x034f, code lost:
        r14 = r28;
        r28 = r1;
        r39 = r3;
        r24 = r10;
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x035b, code lost:
        r14 = r28;
        r7 = r29;
        r39 = r3;
        r2 = r8.m934getSpanRangelOCCd4c(r37.getItemProvider(), r4, r2);
        r13 = r37.getLaneInfo();
        r24 = r10;
        r25 = r11;
        r10 = (int) (r2 & 4294967295L);
        r29 = r0;
        r28 = r1;
        r0 = (int) (r2 >> 32);
        r1 = r10 - r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0385, code lost:
        if (r1 == 1) goto L_0x038a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0387, code lost:
        r20 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x038a, code lost:
        r20 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x038c, code lost:
        if (r20 == false) goto L_0x0390;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x038e, code lost:
        r11 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0390, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0391, code lost:
        r13.setLane(r4, r11);
        r11 = r37.getMeasuredItemProvider().m942getAndMeasurejy6DScQ(r4, r2);
        r2 = m937maxInRangejy6DScQ(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03a1, code lost:
        if (r1 == 1) goto L_0x03a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03a3, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03a5, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03a6, code lost:
        if (r1 == false) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03a8, code lost:
        r1 = r37.getLaneInfo().getGaps(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03b1, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03b2, code lost:
        if (r0 >= r10) goto L_0x03d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03b6, code lost:
        if (r5[r0] == r2) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03b8, code lost:
        r29 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03ba, code lost:
        r9[r0].addFirst(r11);
        r7[r0] = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03c1, code lost:
        if (r1 != null) goto L_0x03c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03c3, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03c5, code lost:
        r3 = r1[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03c7, code lost:
        r5[r0] = (r11.getSizeWithSpacings() + r2) + r3;
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x055b, code lost:
        if (r7[r6] > r11) goto L_0x055d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0578  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x05a3  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x05aa A[LOOP:24: B:243:0x053b->B:266:0x05aa, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0620  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0649  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x05bb A[EDGE_INSN: B:406:0x05bb->B:268:0x05bb ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r37, int r38, int[] r39, int[] r40, boolean r41) {
        /*
            r0 = r37
            r1 = r38
            r2 = r39
            r3 = r40
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope r4 = r37.getMeasureScope()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r5 = r37.getItemProvider()
            int r15 = r5.getItemCount()
            if (r15 <= 0) goto L_0x07bc
            int r5 = r37.getLaneCount()
            if (r5 != 0) goto L_0x001e
            goto L_0x07bc
        L_0x001e:
            int r5 = r2.length
            int[] r7 = java.util.Arrays.copyOf(r2, r5)
            java.lang.String r5 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            int r2 = r3.length
            int[] r8 = java.util.Arrays.copyOf(r3, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            ensureIndicesInRange(r0, r7, r15)
            int r2 = -r1
            offsetBy(r8, r2)
            int r6 = r37.getLaneCount()
            kotlin.collections.ArrayDeque[] r9 = new kotlin.collections.ArrayDeque[r6]
            r2 = 0
        L_0x003e:
            if (r2 >= r6) goto L_0x004c
            kotlin.collections.ArrayDeque r3 = new kotlin.collections.ArrayDeque
            r11 = 16
            r3.<init>((int) r11)
            r9[r2] = r3
            int r2 = r2 + 1
            goto L_0x003e
        L_0x004c:
            int r2 = r37.getBeforeContentPadding()
            int r2 = -r2
            offsetBy(r8, r2)
            r2 = 0
        L_0x0055:
            boolean r3 = measure$lambda$38$hasSpaceBeforeFirst(r7, r8, r0)
            if (r3 == 0) goto L_0x00e9
            int r3 = indexOfMaxValue(r7)
            r10 = r7[r3]
            int r14 = r8.length
            r11 = 0
        L_0x0063:
            if (r11 >= r14) goto L_0x0076
            r12 = r7[r11]
            r13 = r7[r3]
            if (r12 == r13) goto L_0x0073
            r12 = r8[r11]
            r13 = r8[r3]
            if (r12 >= r13) goto L_0x0073
            r8[r11] = r13
        L_0x0073:
            int r11 = r11 + 1
            goto L_0x0063
        L_0x0076:
            int r10 = findPreviousItemIndex(r0, r10, r3)
            if (r10 >= 0) goto L_0x0082
            r39 = r2
            r24 = r15
            goto L_0x00ee
        L_0x0082:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r11 = r37.getItemProvider()
            long r11 = r0.m934getSpanRangelOCCd4c(r11, r10, r3)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r3 = r37.getLaneInfo()
            r13 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r13 = r13 & r11
            int r13 = (int) r13
            r24 = r15
            r14 = 32
            long r14 = r11 >> r14
            int r14 = (int) r14
            int r15 = r13 - r14
            r39 = r2
            r2 = 1
            if (r15 == r2) goto L_0x00a5
            r2 = -2
            goto L_0x00a6
        L_0x00a5:
            r2 = r14
        L_0x00a6:
            r3.setLane(r10, r2)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r2 = r37.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r2 = r2.m942getAndMeasurejy6DScQ(r10, r11)
            int r3 = m937maxInRangejy6DScQ(r8, r11)
            r11 = 1
            if (r15 == r11) goto L_0x00c1
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r11 = r37.getLaneInfo()
            int[] r11 = r11.getGaps(r10)
            goto L_0x00c2
        L_0x00c1:
            r11 = 0
        L_0x00c2:
            r12 = r39
        L_0x00c4:
            if (r14 >= r13) goto L_0x00e4
            r7[r14] = r10
            if (r11 != 0) goto L_0x00cc
            r15 = 0
            goto L_0x00ce
        L_0x00cc:
            r15 = r11[r14]
        L_0x00ce:
            int r16 = r2.getSizeWithSpacings()
            int r16 = r3 + r16
            int r16 = r16 + r15
            r8[r14] = r16
            int r15 = r37.getMainAxisAvailableSize()
            int r15 = r15 + r16
            if (r15 > 0) goto L_0x00e1
            r12 = 1
        L_0x00e1:
            int r14 = r14 + 1
            goto L_0x00c4
        L_0x00e4:
            r2 = r12
            r15 = r24
            goto L_0x0055
        L_0x00e9:
            r39 = r2
            r24 = r15
            r3 = -1
        L_0x00ee:
            int r2 = r37.getBeforeContentPadding()
            int r2 = -r2
            r10 = 0
            r11 = r8[r10]
            if (r11 >= r2) goto L_0x00fe
            int r1 = r1 + r11
            int r11 = r2 - r11
            offsetBy(r8, r11)
        L_0x00fe:
            int r11 = r37.getBeforeContentPadding()
            offsetBy(r8, r11)
            r11 = -1
            if (r3 != r11) goto L_0x010c
            int r3 = kotlin.collections.ArraysKt.indexOf((int[]) r7, (int) r10)
        L_0x010c:
            if (r3 == r11) goto L_0x013c
            boolean r10 = measure$lambda$38$misalignedStart(r7, r0, r8, r3)
            if (r10 == 0) goto L_0x013c
            if (r41 == 0) goto L_0x013c
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r2 = r37.getLaneInfo()
            r2.reset()
            int r2 = r7.length
            int[] r4 = new int[r2]
            r5 = 0
        L_0x0121:
            if (r5 >= r2) goto L_0x0129
            r4[r5] = r11
            int r5 = r5 + 1
            r11 = -1
            goto L_0x0121
        L_0x0129:
            int r2 = r8.length
            int[] r5 = new int[r2]
            r6 = 0
        L_0x012d:
            if (r6 >= r2) goto L_0x0136
            r7 = r8[r3]
            r5[r6] = r7
            int r6 = r6 + 1
            goto L_0x012d
        L_0x0136:
            r6 = 0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = measure(r0, r1, r4, r5, r6)
            return r0
        L_0x013c:
            int r3 = r7.length
            int[] r10 = java.util.Arrays.copyOf(r7, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)
            int r11 = r8.length
            int[] r12 = new int[r11]
            r3 = 0
        L_0x0148:
            if (r3 >= r11) goto L_0x0152
            r13 = r8[r3]
            int r13 = -r13
            r12[r3] = r13
            int r3 = r3 + 1
            goto L_0x0148
        L_0x0152:
            int r3 = r37.getMainAxisSpacing()
            int r13 = r2 + r3
            int r3 = r37.getMainAxisAvailableSize()
            int r14 = r37.getAfterContentPadding()
            int r3 = r3 + r14
            r14 = 0
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r14)
            r40 = r2
            r2 = 1
            r15 = 0
            int r25 = indexOfMinValue$default(r10, r14, r2, r15)
            r38 = r39
            r15 = r25
            r2 = 0
            r14 = -1
        L_0x0174:
            if (r15 == r14) goto L_0x0208
            int r14 = r37.getLaneCount()
            if (r2 >= r14) goto L_0x0208
            r14 = r10[r15]
            int r25 = indexOfMinValue(r10, r14)
            int r2 = r2 + 1
            r39 = r2
            if (r14 < 0) goto L_0x0201
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r2 = r37.getItemProvider()
            r26 = r4
            r27 = r5
            long r4 = r0.m934getSpanRangelOCCd4c(r2, r14, r15)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r2 = r37.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r2 = r2.m942getAndMeasurejy6DScQ(r14, r4)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r15 = r37.getLaneInfo()
            r28 = r1
            r22 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r0 = r4 & r22
            int r0 = (int) r0
            r29 = r7
            r30 = r8
            r1 = 32
            long r7 = r4 >> r1
            int r1 = (int) r7
            int r7 = r0 - r1
            r8 = 1
            if (r7 == r8) goto L_0x01ba
            r8 = -2
            goto L_0x01bb
        L_0x01ba:
            r8 = r1
        L_0x01bb:
            r15.setLane(r14, r8)
            int r4 = m937maxInRangejy6DScQ(r12, r4)
            r5 = r1
        L_0x01c3:
            if (r5 >= r0) goto L_0x01d6
            int r8 = r2.getSizeWithSpacings()
            int r8 = r8 + r4
            r12[r5] = r8
            r10[r5] = r14
            r8 = r9[r5]
            r8.addLast(r2)
            int r5 = r5 + 1
            goto L_0x01c3
        L_0x01d6:
            if (r4 >= r13) goto L_0x01e2
            r0 = r12[r1]
            if (r0 > r13) goto L_0x01e2
            r0 = 0
            r2.setVisible(r0)
            r0 = 1
            goto L_0x01e4
        L_0x01e2:
            r0 = r38
        L_0x01e4:
            r1 = 1
            if (r7 == r1) goto L_0x01ec
            int r2 = r37.getLaneCount()
            goto L_0x01ee
        L_0x01ec:
            r2 = r39
        L_0x01ee:
            r38 = r0
            r15 = r25
            r4 = r26
            r5 = r27
            r1 = r28
            r7 = r29
            r8 = r30
            r14 = -1
            r0 = r37
            goto L_0x0174
        L_0x0201:
            r14 = -1
            r0 = r37
            r15 = r25
            goto L_0x0174
        L_0x0208:
            r28 = r1
            r26 = r4
            r27 = r5
            r29 = r7
            r30 = r8
        L_0x0212:
            r0 = 0
        L_0x0213:
            if (r0 >= r11) goto L_0x0223
            r1 = r12[r0]
            if (r1 < r3) goto L_0x021f
            if (r1 > 0) goto L_0x021c
            goto L_0x021f
        L_0x021c:
            int r0 = r0 + 1
            goto L_0x0213
        L_0x021f:
            r0 = 0
            r1 = 1
            r2 = 0
            goto L_0x0235
        L_0x0223:
            r0 = 0
        L_0x0224:
            if (r0 >= r6) goto L_0x021f
            r1 = r9[r0]
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0232
            r15 = r24
            r1 = 1
            goto L_0x0242
        L_0x0232:
            int r0 = r0 + 1
            goto L_0x0224
        L_0x0235:
            int r4 = indexOfMinValue$default(r12, r2, r1, r0)
            int r0 = kotlin.collections.ArraysKt.maxOrThrow((int[]) r10)
            int r0 = r0 + r1
            r15 = r24
            if (r0 < r15) goto L_0x0718
        L_0x0242:
            r0 = 0
        L_0x0243:
            if (r0 >= r6) goto L_0x0299
            r2 = r9[r0]
        L_0x0247:
            int r4 = r2.size()
            if (r4 <= r1) goto L_0x0285
            java.lang.Object r4 = r2.first()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r4 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r4
            boolean r4 = r4.isVisible()
            if (r4 != 0) goto L_0x0285
            java.lang.Object r4 = r2.removeFirst()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r4 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r4
            int r5 = r4.getSpan()
            if (r5 == r1) goto L_0x0272
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r1 = r37.getLaneInfo()
            int r5 = r4.getIndex()
            int[] r1 = r1.getGaps(r5)
            goto L_0x0273
        L_0x0272:
            r1 = 0
        L_0x0273:
            r5 = r30[r0]
            int r4 = r4.getSizeWithSpacings()
            if (r1 != 0) goto L_0x027d
            r1 = 0
            goto L_0x027f
        L_0x027d:
            r1 = r1[r0]
        L_0x027f:
            int r4 = r4 + r1
            int r5 = r5 - r4
            r30[r0] = r5
            r1 = 1
            goto L_0x0247
        L_0x0285:
            java.lang.Object r1 = r2.firstOrNull()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r1 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r1
            if (r1 == 0) goto L_0x0292
            int r1 = r1.getIndex()
            goto L_0x0293
        L_0x0292:
            r1 = -1
        L_0x0293:
            r29[r0] = r1
            int r0 = r0 + 1
            r1 = 1
            goto L_0x0243
        L_0x0299:
            int r0 = r10.length
            r1 = 0
        L_0x029b:
            if (r1 >= r0) goto L_0x02af
            r2 = r10[r1]
            int r4 = r15 + -1
            if (r2 != r4) goto L_0x02ac
            int r0 = r37.getMainAxisSpacing()
            int r0 = -r0
            offsetBy(r12, r0)
            goto L_0x02af
        L_0x02ac:
            int r1 = r1 + 1
            goto L_0x029b
        L_0x02af:
            r0 = 0
        L_0x02b0:
            if (r0 >= r11) goto L_0x02ce
            r1 = r12[r0]
            int r2 = r37.getMainAxisAvailableSize()
            if (r1 >= r2) goto L_0x02bd
            int r0 = r0 + 1
            goto L_0x02b0
        L_0x02bd:
            r8 = r37
            r39 = r3
            r24 = r10
            r25 = r11
            r1 = r28
            r7 = r29
            r5 = r30
            r10 = 0
            goto L_0x042a
        L_0x02ce:
            int r0 = indexOfMaxValue(r12)
            int r1 = r37.getMainAxisAvailableSize()
            r0 = r12[r0]
            int r1 = r1 - r0
            int r0 = -r1
            r5 = r30
            offsetBy(r5, r0)
            offsetBy(r12, r1)
            r0 = 0
        L_0x02e3:
            int r2 = r5.length
            r4 = 0
        L_0x02e5:
            if (r4 >= r2) goto L_0x03f6
            r7 = r5[r4]
            int r8 = r37.getBeforeContentPadding()
            if (r7 >= r8) goto L_0x02f1
            r7 = 1
            goto L_0x02f2
        L_0x02f1:
            r7 = 0
        L_0x02f2:
            if (r7 == 0) goto L_0x03e2
            r7 = 0
            r8 = 1
            r13 = 0
            int r2 = indexOfMinValue$default(r5, r13, r8, r7)
            int r4 = indexOfMaxValue(r29)
            if (r2 == r4) goto L_0x030a
            r7 = r5[r2]
            r8 = r5[r4]
            if (r7 != r8) goto L_0x0309
            r2 = r4
            goto L_0x030a
        L_0x0309:
            r0 = 1
        L_0x030a:
            r4 = r29[r2]
            r7 = -1
            if (r4 != r7) goto L_0x0313
            r8 = r37
            r4 = r15
            goto L_0x0315
        L_0x0313:
            r8 = r37
        L_0x0315:
            int r4 = findPreviousItemIndex(r8, r4, r2)
            if (r4 >= 0) goto L_0x035b
            r7 = r29
            if (r0 != 0) goto L_0x0325
            boolean r4 = measure$lambda$38$misalignedStart(r7, r8, r5, r2)
            if (r4 == 0) goto L_0x034f
        L_0x0325:
            if (r41 == 0) goto L_0x034f
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r0 = r37.getLaneInfo()
            r0.reset()
            int r0 = r7.length
            int[] r1 = new int[r0]
            r3 = 0
        L_0x0332:
            if (r3 >= r0) goto L_0x033a
            r4 = -1
            r1[r3] = r4
            int r3 = r3 + 1
            goto L_0x0332
        L_0x033a:
            int r0 = r5.length
            int[] r3 = new int[r0]
            r4 = 0
        L_0x033e:
            if (r4 >= r0) goto L_0x0347
            r6 = r5[r2]
            r3[r4] = r6
            int r4 = r4 + 1
            goto L_0x033e
        L_0x0347:
            r14 = r28
            r4 = 0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = measure(r8, r14, r1, r3, r4)
            return r0
        L_0x034f:
            r14 = r28
            r28 = r1
            r39 = r3
            r24 = r10
            r25 = r11
            goto L_0x0404
        L_0x035b:
            r14 = r28
            r7 = r29
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r13 = r37.getItemProvider()
            r39 = r3
            long r2 = r8.m934getSpanRangelOCCd4c(r13, r4, r2)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r13 = r37.getLaneInfo()
            r24 = r10
            r25 = r11
            r22 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r10 = r2 & r22
            int r10 = (int) r10
            r29 = r0
            r28 = r1
            r11 = 32
            long r0 = r2 >> r11
            int r0 = (int) r0
            int r1 = r10 - r0
            r11 = 1
            if (r1 == r11) goto L_0x038a
            r20 = r11
            goto L_0x038c
        L_0x038a:
            r20 = 0
        L_0x038c:
            if (r20 == 0) goto L_0x0390
            r11 = -2
            goto L_0x0391
        L_0x0390:
            r11 = r0
        L_0x0391:
            r13.setLane(r4, r11)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r11 = r37.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r11 = r11.m942getAndMeasurejy6DScQ(r4, r2)
            int r2 = m937maxInRangejy6DScQ(r5, r2)
            r3 = 1
            if (r1 == r3) goto L_0x03a5
            r1 = 1
            goto L_0x03a6
        L_0x03a5:
            r1 = 0
        L_0x03a6:
            if (r1 == 0) goto L_0x03b1
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r1 = r37.getLaneInfo()
            int[] r1 = r1.getGaps(r4)
            goto L_0x03b2
        L_0x03b1:
            r1 = 0
        L_0x03b2:
            if (r0 >= r10) goto L_0x03d2
            r3 = r5[r0]
            if (r3 == r2) goto L_0x03ba
            r29 = 1
        L_0x03ba:
            r3 = r9[r0]
            r3.addFirst(r11)
            r7[r0] = r4
            if (r1 != 0) goto L_0x03c5
            r3 = 0
            goto L_0x03c7
        L_0x03c5:
            r3 = r1[r0]
        L_0x03c7:
            int r13 = r11.getSizeWithSpacings()
            int r13 = r13 + r2
            int r13 = r13 + r3
            r5[r0] = r13
            int r0 = r0 + 1
            goto L_0x03b2
        L_0x03d2:
            r3 = r39
            r10 = r24
            r11 = r25
            r1 = r28
            r0 = r29
            r29 = r7
            r28 = r14
            goto L_0x02e3
        L_0x03e2:
            r8 = r37
            r39 = r3
            r24 = r10
            r25 = r11
            r14 = r28
            r7 = r29
            r28 = r1
            int r4 = r4 + 1
            r28 = r14
            goto L_0x02e5
        L_0x03f6:
            r8 = r37
            r39 = r3
            r24 = r10
            r25 = r11
            r14 = r28
            r7 = r29
            r28 = r1
        L_0x0404:
            if (r0 == 0) goto L_0x0415
            if (r41 == 0) goto L_0x0415
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r0 = r37.getLaneInfo()
            r0.reset()
            r0 = 0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = measure(r8, r14, r7, r5, r0)
            return r0
        L_0x0415:
            r0 = 0
            int r1 = r14 + r28
            r2 = 1
            r10 = 0
            int r3 = indexOfMinValue$default(r5, r0, r2, r10)
            r0 = r5[r3]
            if (r0 >= 0) goto L_0x042a
            int r1 = r1 + r0
            offsetBy(r12, r0)
            int r0 = -r0
            offsetBy(r5, r0)
        L_0x042a:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r0 = r37.getState()
            float r0 = r0.getScrollToBeConsumed$foundation_release()
            int r0 = kotlin.math.MathKt.roundToInt((float) r0)
            int r0 = kotlin.math.MathKt.getSign((int) r0)
            int r2 = kotlin.math.MathKt.getSign((int) r1)
            if (r0 != r2) goto L_0x0458
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r0 = r37.getState()
            float r0 = r0.getScrollToBeConsumed$foundation_release()
            int r0 = kotlin.math.MathKt.roundToInt((float) r0)
            int r0 = java.lang.Math.abs(r0)
            int r2 = java.lang.Math.abs(r1)
            if (r0 < r2) goto L_0x0458
            float r0 = (float) r1
            goto L_0x0460
        L_0x0458:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r0 = r37.getState()
            float r0 = r0.getScrollToBeConsumed$foundation_release()
        L_0x0460:
            int r1 = r5.length
            int[] r1 = java.util.Arrays.copyOf(r5, r1)
            r11 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)
            int r2 = r1.length
            r3 = 0
        L_0x046c:
            if (r3 >= r2) goto L_0x0476
            r4 = r1[r3]
            int r4 = -r4
            r1[r3] = r4
            int r3 = r3 + 1
            goto L_0x046c
        L_0x0476:
            int r2 = r37.getBeforeContentPadding()
            int r3 = r37.getMainAxisSpacing()
            if (r2 <= r3) goto L_0x04cf
            r2 = 0
        L_0x0481:
            if (r2 >= r6) goto L_0x04cf
            r3 = r9[r2]
            int r4 = r3.size()
            r11 = 0
        L_0x048a:
            if (r11 >= r4) goto L_0x04cb
            java.lang.Object r13 = r3.get(r11)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r13 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r13
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r14 = r37.getLaneInfo()
            int r10 = r13.getIndex()
            int[] r10 = r14.getGaps(r10)
            int r13 = r13.getSizeWithSpacings()
            if (r10 != 0) goto L_0x04a6
            r10 = 0
            goto L_0x04a8
        L_0x04a6:
            r10 = r10[r2]
        L_0x04a8:
            int r13 = r13 + r10
            r10 = r3
            java.util.List r10 = (java.util.List) r10
            int r10 = kotlin.collections.CollectionsKt.getLastIndex(r10)
            if (r11 == r10) goto L_0x04cb
            r10 = r5[r2]
            if (r10 == 0) goto L_0x04cb
            if (r10 < r13) goto L_0x04cb
            int r10 = r10 - r13
            r5[r2] = r10
            int r11 = r11 + 1
            java.lang.Object r10 = r3.get(r11)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r10 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r10
            int r10 = r10.getIndex()
            r7[r2] = r10
            r10 = 0
            goto L_0x048a
        L_0x04cb:
            int r2 = r2 + 1
            r10 = 0
            goto L_0x0481
        L_0x04cf:
            int r2 = r37.getBeforeContentPadding()
            int r3 = r37.getAfterContentPadding()
            int r2 = r2 + r3
            boolean r3 = r37.isVertical()
            if (r3 == 0) goto L_0x04e7
            long r3 = r37.m931getConstraintsmsEJaDk()
            int r3 = androidx.compose.ui.unit.Constraints.m6526getMaxWidthimpl(r3)
            goto L_0x04f4
        L_0x04e7:
            long r3 = r37.m931getConstraintsmsEJaDk()
            int r6 = kotlin.collections.ArraysKt.maxOrThrow((int[]) r12)
            int r6 = r6 + r2
            int r3 = androidx.compose.ui.unit.ConstraintsKt.m6540constrainWidthK40F9xA(r3, r6)
        L_0x04f4:
            boolean r4 = r37.isVertical()
            if (r4 == 0) goto L_0x0508
            long r10 = r37.m931getConstraintsmsEJaDk()
            int r4 = kotlin.collections.ArraysKt.maxOrThrow((int[]) r12)
            int r4 = r4 + r2
            int r2 = androidx.compose.ui.unit.ConstraintsKt.m6539constrainHeightK40F9xA(r10, r4)
            goto L_0x0510
        L_0x0508:
            long r10 = r37.m931getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m6525getMaxHeightimpl(r10)
        L_0x0510:
            boolean r4 = r37.isVertical()
            if (r4 == 0) goto L_0x0518
            r4 = r2
            goto L_0x0519
        L_0x0518:
            r4 = r3
        L_0x0519:
            int r6 = r37.getMainAxisAvailableSize()
            int r4 = java.lang.Math.min(r4, r6)
            int r6 = r37.getBeforeContentPadding()
            int r4 = r4 - r6
            int r6 = r37.getAfterContentPadding()
            int r4 = r4 + r6
            r6 = 0
            r10 = r1[r6]
            java.util.List r6 = r37.getPinnedItems()
            int r11 = r6.size()
            r13 = -1
            int r11 = r11 + r13
            if (r11 < 0) goto L_0x05b4
            r13 = 0
        L_0x053b:
            int r14 = r11 + -1
            java.lang.Object r11 = r6.get(r11)
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r41 = r6
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r6 = r37.getLaneInfo()
            int r6 = r6.getLane(r11)
            r36 = r5
            r5 = -2
            if (r6 == r5) goto L_0x0561
            r5 = -1
            if (r6 == r5) goto L_0x0561
            r5 = r7[r6]
            if (r5 <= r11) goto L_0x055f
        L_0x055d:
            r5 = 1
            goto L_0x0576
        L_0x055f:
            r5 = 0
            goto L_0x0576
        L_0x0561:
            int r5 = r7.length
            r6 = 0
        L_0x0563:
            if (r6 >= r5) goto L_0x055d
            r21 = r5
            r5 = r7[r6]
            if (r5 <= r11) goto L_0x056d
            r5 = 1
            goto L_0x056e
        L_0x056d:
            r5 = 0
        L_0x056e:
            if (r5 != 0) goto L_0x0571
            goto L_0x055f
        L_0x0571:
            int r6 = r6 + 1
            r5 = r21
            goto L_0x0563
        L_0x0576:
            if (r5 == 0) goto L_0x05a3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r5 = r37.getItemProvider()
            r22 = r2
            r21 = r3
            r6 = 0
            long r2 = r8.m934getSpanRangelOCCd4c(r5, r11, r6)
            if (r13 != 0) goto L_0x058f
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r13 = r5
            java.util.List r13 = (java.util.List) r13
        L_0x058f:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r5 = r37.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r2 = r5.m942getAndMeasurejy6DScQ(r11, r2)
            int r3 = r2.getSizeWithSpacings()
            int r10 = r10 - r3
            r2.position(r10, r6, r4)
            r13.add(r2)
            goto L_0x05a7
        L_0x05a3:
            r22 = r2
            r21 = r3
        L_0x05a7:
            if (r14 >= 0) goto L_0x05aa
            goto L_0x05bb
        L_0x05aa:
            r6 = r41
            r11 = r14
            r3 = r21
            r2 = r22
            r5 = r36
            goto L_0x053b
        L_0x05b4:
            r22 = r2
            r21 = r3
            r36 = r5
            r13 = 0
        L_0x05bb:
            if (r13 != 0) goto L_0x05c1
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()
        L_0x05c1:
            java.util.List r2 = calculateVisibleItems(r8, r9, r1, r4)
            r3 = 0
            r1 = r1[r3]
            java.util.List r3 = r37.getPinnedItems()
            int r5 = r3.size()
            r10 = 0
            r14 = 0
        L_0x05d2:
            if (r10 >= r5) goto L_0x0657
            java.lang.Object r6 = r3.get(r10)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r6 < r15) goto L_0x05e8
        L_0x05e0:
            r41 = r3
            r23 = r5
            r9 = r24
        L_0x05e6:
            r3 = 0
            goto L_0x061e
        L_0x05e8:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r9 = r37.getLaneInfo()
            int r9 = r9.getLane(r6)
            r11 = -2
            if (r9 == r11) goto L_0x0602
            r11 = -1
            if (r9 == r11) goto L_0x0602
            r9 = r24[r9]
            if (r9 >= r6) goto L_0x05e0
            r41 = r3
            r23 = r5
            r9 = r24
        L_0x0600:
            r3 = 1
            goto L_0x061e
        L_0x0602:
            r9 = r24
            int r11 = r9.length
            r41 = r3
            r3 = 0
        L_0x0608:
            if (r3 >= r11) goto L_0x061b
            r23 = r5
            r5 = r9[r3]
            if (r5 >= r6) goto L_0x0612
            r5 = 1
            goto L_0x0613
        L_0x0612:
            r5 = 0
        L_0x0613:
            if (r5 != 0) goto L_0x0616
            goto L_0x05e6
        L_0x0616:
            int r3 = r3 + 1
            r5 = r23
            goto L_0x0608
        L_0x061b:
            r23 = r5
            goto L_0x0600
        L_0x061e:
            if (r3 == 0) goto L_0x0649
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r3 = r37.getItemProvider()
            r24 = r12
            r5 = 0
            long r11 = r8.m934getSpanRangelOCCd4c(r3, r6, r5)
            if (r14 != 0) goto L_0x0635
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r14 = r3
            java.util.List r14 = (java.util.List) r14
        L_0x0635:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r3 = r37.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r3 = r3.m942getAndMeasurejy6DScQ(r6, r11)
            r3.position(r1, r5, r4)
            int r5 = r3.getSizeWithSpacings()
            int r1 = r1 + r5
            r14.add(r3)
            goto L_0x064b
        L_0x0649:
            r24 = r12
        L_0x064b:
            int r10 = r10 + 1
            r3 = r41
            r5 = r23
            r12 = r24
            r24 = r9
            goto L_0x05d2
        L_0x0657:
            r9 = r24
            r24 = r12
            if (r14 != 0) goto L_0x0661
            java.util.List r14 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0661:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r13 = (java.util.Collection) r13
            r1.addAll(r13)
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            r1.addAll(r3)
            java.util.Collection r14 = (java.util.Collection) r14
            r1.addAll(r14)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r3 = r37.getState()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator r27 = r3.getPlacementAnimator$foundation_release()
            int r3 = (int) r0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r32 = r37.getMeasuredItemProvider()
            boolean r33 = r37.isVertical()
            int r34 = r37.getLaneCount()
            kotlinx.coroutines.CoroutineScope r35 = r37.getCoroutineScope()
            r28 = r3
            r29 = r21
            r30 = r22
            r31 = r1
            r27.onMeasured(r28, r29, r30, r31, r32, r33, r34, r35)
            r5 = r25
            r10 = 0
        L_0x069f:
            if (r10 >= r5) goto L_0x06b3
            r3 = r24[r10]
            int r4 = r37.getMainAxisAvailableSize()
            if (r3 <= r4) goto L_0x06ab
            r3 = 1
            goto L_0x06ac
        L_0x06ab:
            r3 = 0
        L_0x06ac:
            if (r3 == 0) goto L_0x06b0
            r3 = 1
            goto L_0x06b4
        L_0x06b0:
            int r10 = r10 + 1
            goto L_0x069f
        L_0x06b3:
            r3 = 0
        L_0x06b4:
            if (r3 != 0) goto L_0x06d0
            int r3 = r9.length
            r10 = 0
        L_0x06b8:
            if (r10 >= r3) goto L_0x06ca
            r4 = r9[r10]
            int r5 = r15 + -1
            if (r4 >= r5) goto L_0x06c2
            r4 = 1
            goto L_0x06c3
        L_0x06c2:
            r4 = 0
        L_0x06c3:
            if (r4 != 0) goto L_0x06c7
            r3 = 0
            goto L_0x06cb
        L_0x06c7:
            int r10 = r10 + 1
            goto L_0x06b8
        L_0x06ca:
            r3 = 1
        L_0x06cb:
            if (r3 == 0) goto L_0x06ce
            goto L_0x06d0
        L_0x06ce:
            r11 = 0
            goto L_0x06d1
        L_0x06d0:
            r11 = 1
        L_0x06d1:
            r27 = r26
            androidx.compose.ui.layout.MeasureScope r27 = (androidx.compose.ui.layout.MeasureScope) r27
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$29 r3 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$29
            r3.<init>(r1, r8)
            r31 = r3
            kotlin.jvm.functions.Function1 r31 = (kotlin.jvm.functions.Function1) r31
            r32 = 4
            r33 = 0
            r30 = 0
            r28 = r21
            r29 = r22
            androidx.compose.ui.layout.MeasureResult r10 = androidx.compose.ui.layout.MeasureScope.CC.layout$default(r27, r28, r29, r30, r31, r32, r33)
            boolean r12 = r37.isVertical()
            r3 = r21
            r1 = r22
            long r16 = androidx.compose.ui.unit.IntSizeKt.IntSize(r3, r1)
            int r20 = r37.getBeforeContentPadding()
            int r21 = r37.getAfterContentPadding()
            int r22 = r37.getMainAxisSpacing()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r1 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult
            r6 = r1
            r23 = 0
            r8 = r36
            r9 = r0
            r13 = r38
            r14 = r15
            r15 = r2
            r18 = r40
            r19 = r39
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23)
            return r1
        L_0x0718:
            r8 = r37
            r39 = r3
            r1 = r10
            r5 = r11
            r24 = r12
            r10 = r27
            r14 = r28
            r7 = r29
            r36 = r30
            r11 = -2
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r2 = r37.getItemProvider()
            long r2 = r8.m934getSpanRangelOCCd4c(r2, r0, r4)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r4 = r37.getLaneInfo()
            r22 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r11 = r2 & r22
            int r11 = (int) r11
            r25 = r5
            r21 = r6
            r12 = 32
            long r5 = r2 >> r12
            int r5 = (int) r5
            int r6 = r11 - r5
            r12 = 1
            if (r6 == r12) goto L_0x074d
            r12 = -2
            goto L_0x074e
        L_0x074d:
            r12 = r5
        L_0x074e:
            r4.setLane(r0, r12)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r4 = r37.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r4 = r4.m942getAndMeasurejy6DScQ(r0, r2)
            r12 = r24
            int r2 = m937maxInRangejy6DScQ(r12, r2)
            r3 = 1
            if (r6 == r3) goto L_0x0773
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r6 = r37.getLaneInfo()
            int[] r6 = r6.getGaps(r0)
            if (r6 != 0) goto L_0x0774
            int r6 = r37.getLaneCount()
            int[] r6 = new int[r6]
            goto L_0x0774
        L_0x0773:
            r6 = 0
        L_0x0774:
            r3 = r5
        L_0x0775:
            if (r3 >= r11) goto L_0x0795
            if (r6 == 0) goto L_0x077f
            r24 = r12[r3]
            int r24 = r2 - r24
            r6[r3] = r24
        L_0x077f:
            r1[r3] = r0
            int r24 = r4.getSizeWithSpacings()
            int r24 = r2 + r24
            r12[r3] = r24
            r24 = r1
            r1 = r9[r3]
            r1.addLast(r4)
            int r3 = r3 + 1
            r1 = r24
            goto L_0x0775
        L_0x0795:
            r24 = r1
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r1 = r37.getLaneInfo()
            r1.setGaps(r0, r6)
            if (r2 >= r13) goto L_0x07a8
            r0 = r12[r5]
            if (r0 > r13) goto L_0x07a8
            r0 = 0
            r4.setVisible(r0)
        L_0x07a8:
            r3 = r39
            r29 = r7
            r27 = r10
            r28 = r14
            r6 = r21
            r10 = r24
            r11 = r25
            r30 = r36
            r24 = r15
            goto L_0x0212
        L_0x07bc:
            r8 = r0
            r26 = r4
            r28 = r26
            androidx.compose.ui.layout.MeasureScope r28 = (androidx.compose.ui.layout.MeasureScope) r28
            long r0 = r37.m931getConstraintsmsEJaDk()
            int r29 = androidx.compose.ui.unit.Constraints.m6528getMinWidthimpl(r0)
            long r0 = r37.m931getConstraintsmsEJaDk()
            int r30 = androidx.compose.ui.unit.Constraints.m6527getMinHeightimpl(r0)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1 r0 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1.INSTANCE
            r32 = r0
            kotlin.jvm.functions.Function1 r32 = (kotlin.jvm.functions.Function1) r32
            r33 = 4
            r34 = 0
            r31 = 0
            androidx.compose.ui.layout.MeasureResult r5 = androidx.compose.ui.layout.MeasureScope.CC.layout$default(r28, r29, r30, r31, r32, r33, r34)
            boolean r7 = r37.isVertical()
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
            long r0 = r37.m931getConstraintsmsEJaDk()
            int r0 = androidx.compose.ui.unit.Constraints.m6528getMinWidthimpl(r0)
            long r11 = r37.m931getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m6527getMinHeightimpl(r11)
            long r11 = androidx.compose.ui.unit.IntSizeKt.IntSize(r0, r1)
            int r0 = r37.getBeforeContentPadding()
            int r13 = -r0
            int r0 = r37.getMainAxisAvailableSize()
            int r1 = r37.getAfterContentPadding()
            int r14 = r0 + r1
            int r0 = r37.getBeforeContentPadding()
            r9 = r15
            r15 = r0
            int r16 = r37.getAfterContentPadding()
            int r17 = r37.getMainAxisSpacing()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult
            r1 = r0
            r8 = 0
            r18 = 0
            r4 = 0
            r6 = 0
            r2 = r39
            r3 = r40
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int, int[], int[], boolean):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult");
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        if (lane == 0 || lane == -1 || lane == -2) {
            return false;
        }
        return true;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i) {
        int i2 = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> size : arrayDequeArr) {
            i2 += size.size();
        }
        ArrayList arrayList = new ArrayList(i2);
        while (true) {
            int length = arrayDequeArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (!arrayDequeArr[i3].isEmpty()) {
                    int length2 = arrayDequeArr.length;
                    int i4 = -1;
                    int i5 = Integer.MAX_VALUE;
                    for (int i6 = 0; i6 < length2; i6++) {
                        LazyStaggeredGridMeasuredItem firstOrNull = arrayDequeArr[i6].firstOrNull();
                        int index = firstOrNull != null ? firstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i5 > index) {
                            i4 = i6;
                            i5 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem removeFirst = arrayDequeArr[i4].removeFirst();
                    if (removeFirst.getLane() == i4) {
                        long r5 = SpanRange.m951constructorimpl(removeFirst.getLane(), removeFirst.getSpan());
                        int r3 = m937maxInRangejy6DScQ(iArr, r5);
                        int i7 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i4];
                        if (removeFirst.getPlaceablesCount() != 0) {
                            removeFirst.position(r3, i7, i);
                            arrayList.add(removeFirst);
                            int i8 = (int) (r5 & 4294967295L);
                            for (int i9 = (int) (r5 >> 32); i9 < i8; i9++) {
                                iArr[i9] = removeFirst.getSizeWithSpacings() + r3;
                            }
                        }
                    }
                } else {
                    i3++;
                }
            }
            return arrayList;
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        List<LazyStaggeredGridMeasuredItem> list = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int intValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(intValue)).booleanValue()) {
                        long r4 = lazyStaggeredGridMeasureContext.m934getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        LazyStaggeredGridMeasuredItem r11 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m942getAndMeasurejy6DScQ(intValue, r4);
                        function1.invoke(r11);
                        list.add(r11);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int intValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(intValue2)).booleanValue()) {
                    long r5 = lazyStaggeredGridMeasureContext.m934getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    LazyStaggeredGridMeasuredItem r42 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m942getAndMeasurejy6DScQ(intValue2, r5);
                    function1.invoke(r42);
                    list.add(r42);
                }
            }
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* renamed from: forEach-nIS5qE8  reason: not valid java name */
    private static final void m936forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* renamed from: maxInRange-jy6DScQ  reason: not valid java name */
    private static final int m937maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int i2 = Integer.MIN_VALUE;
        for (int i3 = (int) (j >> 32); i3 < i; i3++) {
            i2 = Math.max(i2, iArr[i3]);
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int intValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > intValue) {
                i = i3;
                i2 = intValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                while (true) {
                    if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                        break;
                    }
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
                if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                    lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
                }
                if (i2 >= 0) {
                    length = i2;
                } else {
                    return;
                }
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    function1.invoke(list.get(size));
                    if (i >= 0) {
                        size = i;
                    } else {
                        return;
                    }
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = size - 1;
                    function1.invoke(list.get(size));
                    if (i2 >= 0) {
                        size = i2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }
}
