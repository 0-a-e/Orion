package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import androidx.collection.FloatListKt;
import androidx.collection.MutableFloatList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014BK\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/carousel/Strategy;", "", "defaultKeylines", "Landroidx/compose/material3/carousel/KeylineList;", "startKeylineSteps", "", "endKeylineSteps", "startShiftDistance", "", "endShiftDistance", "startShiftPoints", "Landroidx/collection/FloatList;", "endShiftPoints", "(Landroidx/compose/material3/carousel/KeylineList;Ljava/util/List;Ljava/util/List;FFLandroidx/collection/FloatList;Landroidx/collection/FloatList;)V", "getKeylineListForScrollOffset", "scrollOffset", "maxScrollOffset", "roundToNearestStep", "", "getKeylineListForScrollOffset$material3_release", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Strategy.kt */
public final class Strategy {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final KeylineList defaultKeylines;
    private final List<KeylineList> endKeylineSteps;
    private final float endShiftDistance;
    private final FloatList endShiftPoints;
    private final List<KeylineList> startKeylineSteps;
    private final float startShiftDistance;
    private final FloatList startShiftPoints;

    public /* synthetic */ Strategy(KeylineList keylineList, List list, List list2, float f, float f2, FloatList floatList, FloatList floatList2, DefaultConstructorMarker defaultConstructorMarker) {
        this(keylineList, list, list2, f, f2, floatList, floatList2);
    }

    private Strategy(KeylineList keylineList, List<KeylineList> list, List<KeylineList> list2, float f, float f2, FloatList floatList, FloatList floatList2) {
        this.defaultKeylines = keylineList;
        this.startKeylineSteps = list;
        this.endKeylineSteps = list2;
        this.startShiftDistance = f;
        this.endShiftDistance = f2;
        this.startShiftPoints = floatList;
        this.endShiftPoints = floatList2;
    }

    public static /* synthetic */ KeylineList getKeylineListForScrollOffset$material3_release$default(Strategy strategy, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return strategy.getKeylineListForScrollOffset$material3_release(f, f2, z);
    }

    public final KeylineList getKeylineListForScrollOffset$material3_release(float f, float f2, boolean z) {
        int i;
        float f3 = this.startShiftDistance;
        float f4 = f2 - this.endShiftDistance;
        if (f3 <= f && f <= f4) {
            return this.defaultKeylines;
        }
        float access$lerp = StrategyKt.lerp(1.0f, 0.0f, 0.0f, f3, f);
        FloatList floatList = this.startShiftPoints;
        List<KeylineList> list = this.startKeylineSteps;
        if (f > f4) {
            access$lerp = StrategyKt.lerp(0.0f, 1.0f, f4, f2, f);
            floatList = this.endShiftPoints;
            list = this.endKeylineSteps;
        }
        Companion.ShiftPointRange access$getShiftPointRange = Companion.getShiftPointRange(list.size(), floatList, access$lerp);
        if (!z) {
            return StrategyKt.lerp(list.get(access$getShiftPointRange.getFromStepIndex()), list.get(access$getShiftPointRange.getToStepIndex()), access$getShiftPointRange.getSteppedInterpolation());
        }
        if (MathKt.roundToInt(access$getShiftPointRange.getSteppedInterpolation()) == 0) {
            i = access$getShiftPointRange.getFromStepIndex();
        } else {
            i = access$getShiftPointRange.getToStepIndex();
        }
        return list.get(i);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J&\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0002¨\u0006\""}, d2 = {"Landroidx/compose/material3/carousel/Strategy$Companion;", "", "()V", "create", "Landroidx/compose/material3/carousel/Strategy;", "carouselMainAxisSize", "", "keylineList", "Landroidx/compose/material3/carousel/KeylineList;", "create$material3_release", "getEndKeylineSteps", "", "defaultKeylines", "getShiftPointRange", "Landroidx/compose/material3/carousel/Strategy$Companion$ShiftPointRange;", "stepsCount", "", "shiftPoint", "Landroidx/collection/FloatList;", "interpolation", "getStartKeylineSteps", "getStepInterpolationPoints", "totalShiftDistance", "steps", "isShiftingLeft", "", "moveKeylineAndCreateShiftedKeylineList", "from", "srcIndex", "dstIndex", "move", "", "Landroidx/compose/material3/carousel/Keyline;", "ShiftPointRange", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Strategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Strategy create$material3_release(float f, KeylineList keylineList) {
            List<KeylineList> startKeylineSteps = getStartKeylineSteps(keylineList, f);
            List<KeylineList> endKeylineSteps = getEndKeylineSteps(keylineList, f);
            List list = keylineList;
            float unadjustedOffset = ((Keyline) CollectionsKt.first((List) CollectionsKt.last(startKeylineSteps))).getUnadjustedOffset() - ((Keyline) CollectionsKt.first(list)).getUnadjustedOffset();
            float unadjustedOffset2 = ((Keyline) CollectionsKt.last(list)).getUnadjustedOffset() - ((Keyline) CollectionsKt.last((List) CollectionsKt.last(endKeylineSteps))).getUnadjustedOffset();
            return new Strategy(keylineList, startKeylineSteps, endKeylineSteps, unadjustedOffset, unadjustedOffset2, getStepInterpolationPoints(unadjustedOffset, startKeylineSteps, true), getStepInterpolationPoints(unadjustedOffset2, endKeylineSteps, false), (DefaultConstructorMarker) null);
        }

        private final List<KeylineList> getStartKeylineSteps(KeylineList keylineList, float f) {
            List<KeylineList> arrayList = new ArrayList<>();
            arrayList.add(keylineList);
            if (keylineList.isFirstFocalItemAtStartOfContainer()) {
                return arrayList;
            }
            int firstNonAnchorIndex = keylineList.getFirstNonAnchorIndex();
            int firstFocalIndex = keylineList.getFirstFocalIndex() - firstNonAnchorIndex;
            if (firstFocalIndex > 0 || keylineList.getFirstFocal().getCutoff() <= 0.0f) {
                for (int i = 0; i < firstFocalIndex; i++) {
                    KeylineList keylineList2 = (KeylineList) CollectionsKt.last(arrayList);
                    int i2 = firstNonAnchorIndex + i;
                    int lastIndex = CollectionsKt.getLastIndex(keylineList);
                    if (i2 > 0) {
                        lastIndex = keylineList2.firstIndexAfterFocalRangeWithSize(keylineList.get(i2 - 1).getSize()) - 1;
                    }
                    arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList2, keylineList.getFirstNonAnchorIndex(), lastIndex, f));
                }
                return arrayList;
            }
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f));
            return arrayList;
        }

        private final List<KeylineList> getEndKeylineSteps(KeylineList keylineList, float f) {
            List<KeylineList> arrayList = new ArrayList<>();
            arrayList.add(keylineList);
            if (keylineList.isLastFocalItemAtEndOfContainer(f)) {
                return arrayList;
            }
            int lastFocalIndex = keylineList.getLastFocalIndex();
            int lastNonAnchorIndex = keylineList.getLastNonAnchorIndex();
            int i = lastNonAnchorIndex - lastFocalIndex;
            if (i > 0 || keylineList.getLastFocal().getCutoff() <= 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    KeylineList keylineList2 = (KeylineList) CollectionsKt.last(arrayList);
                    int i3 = lastNonAnchorIndex - i2;
                    arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList2, keylineList.getLastNonAnchorIndex(), i3 < CollectionsKt.getLastIndex(keylineList) ? keylineList2.lastIndexBeforeFocalRangeWithSize(keylineList.get(i3 + 1).getSize()) + 1 : 0, f));
                }
                return arrayList;
            }
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f));
            return arrayList;
        }

        private final KeylineList moveKeylineAndCreateShiftedKeylineList(KeylineList keylineList, int i, int i2, float f) {
            int i3 = i > i2 ? 1 : -1;
            return KeylineKt.keylineListOf(f, keylineList.getPivotIndex() + i3, keylineList.getPivot().getOffset() + (keylineList.get(i).getSize() * ((float) i3)), new Strategy$Companion$moveKeylineAndCreateShiftedKeylineList$1(keylineList, i, i2));
        }

        private final FloatList getStepInterpolationPoints(float f, List<KeylineList> list, boolean z) {
            float f2;
            MutableFloatList mutableFloatListOf = FloatListKt.mutableFloatListOf(0.0f);
            if (f == 0.0f) {
                return mutableFloatListOf;
            }
            Iterable until = RangesKt.until(1, list.size());
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                int i = nextInt - 1;
                KeylineList keylineList = list.get(i);
                KeylineList keylineList2 = list.get(nextInt);
                if (z) {
                    f2 = ((Keyline) CollectionsKt.first(keylineList2)).getUnadjustedOffset() - ((Keyline) CollectionsKt.first(keylineList)).getUnadjustedOffset();
                } else {
                    f2 = ((Keyline) CollectionsKt.last(keylineList)).getUnadjustedOffset() - ((Keyline) CollectionsKt.last(keylineList2)).getUnadjustedOffset();
                }
                arrayList.add(Boolean.valueOf(mutableFloatListOf.add(nextInt == CollectionsKt.getLastIndex(list) ? 1.0f : mutableFloatListOf.get(i) + (f2 / f))));
            }
            List list2 = (List) arrayList;
            return mutableFloatListOf;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/carousel/Strategy$Companion$ShiftPointRange;", "", "fromStepIndex", "", "toStepIndex", "steppedInterpolation", "", "(IIF)V", "getFromStepIndex", "()I", "getSteppedInterpolation", "()F", "getToStepIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Strategy.kt */
        private static final class ShiftPointRange {
            private final int fromStepIndex;
            private final float steppedInterpolation;
            private final int toStepIndex;

            public static /* synthetic */ ShiftPointRange copy$default(ShiftPointRange shiftPointRange, int i, int i2, float f, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = shiftPointRange.fromStepIndex;
                }
                if ((i3 & 2) != 0) {
                    i2 = shiftPointRange.toStepIndex;
                }
                if ((i3 & 4) != 0) {
                    f = shiftPointRange.steppedInterpolation;
                }
                return shiftPointRange.copy(i, i2, f);
            }

            public final int component1() {
                return this.fromStepIndex;
            }

            public final int component2() {
                return this.toStepIndex;
            }

            public final float component3() {
                return this.steppedInterpolation;
            }

            public final ShiftPointRange copy(int i, int i2, float f) {
                return new ShiftPointRange(i, i2, f);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ShiftPointRange)) {
                    return false;
                }
                ShiftPointRange shiftPointRange = (ShiftPointRange) obj;
                return this.fromStepIndex == shiftPointRange.fromStepIndex && this.toStepIndex == shiftPointRange.toStepIndex && Float.compare(this.steppedInterpolation, shiftPointRange.steppedInterpolation) == 0;
            }

            public int hashCode() {
                return (((this.fromStepIndex * 31) + this.toStepIndex) * 31) + Float.floatToIntBits(this.steppedInterpolation);
            }

            public String toString() {
                return "ShiftPointRange(fromStepIndex=" + this.fromStepIndex + ", toStepIndex=" + this.toStepIndex + ", steppedInterpolation=" + this.steppedInterpolation + ')';
            }

            public ShiftPointRange(int i, int i2, float f) {
                this.fromStepIndex = i;
                this.toStepIndex = i2;
                this.steppedInterpolation = f;
            }

            public final int getFromStepIndex() {
                return this.fromStepIndex;
            }

            public final int getToStepIndex() {
                return this.toStepIndex;
            }

            public final float getSteppedInterpolation() {
                return this.steppedInterpolation;
            }
        }

        /* access modifiers changed from: private */
        public final ShiftPointRange getShiftPointRange(int i, FloatList floatList, float f) {
            float f2 = floatList.get(0);
            Iterator it = RangesKt.until(1, i).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                float f3 = floatList.get(nextInt);
                if (f <= f3) {
                    return new ShiftPointRange(nextInt - 1, nextInt, StrategyKt.lerp(0.0f, 1.0f, f2, f3, f));
                }
                f2 = f3;
            }
            return new ShiftPointRange(0, 0, 0.0f);
        }

        /* access modifiers changed from: private */
        public final List<Keyline> move(List<Keyline> list, int i, int i2) {
            list.remove(i);
            list.add(i2, list.get(i));
            return list;
        }
    }
}
