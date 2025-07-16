package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutKeyIndexMap.kt */
final class NearestRangeKeyIndexMap$2$1 extends Lambda implements Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval>, Unit> {
    final /* synthetic */ int $first;
    final /* synthetic */ int $last;
    final /* synthetic */ MutableObjectIntMap<Object> $map;
    final /* synthetic */ NearestRangeKeyIndexMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NearestRangeKeyIndexMap$2$1(int i, int i2, MutableObjectIntMap<Object> mutableObjectIntMap, NearestRangeKeyIndexMap nearestRangeKeyIndexMap) {
        super(1);
        this.$first = i;
        this.$last = i2;
        this.$map = mutableObjectIntMap;
        this.this$0 = nearestRangeKeyIndexMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval>) (IntervalList.Interval) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0037, code lost:
        if (r3 == null) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.lazy.layout.IntervalList.Interval<? extends androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval> r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r7.getValue()
            androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval) r0
            kotlin.jvm.functions.Function1 r0 = r0.getKey()
            int r1 = r6.$first
            int r2 = r7.getStartIndex()
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r6.$last
            int r3 = r7.getStartIndex()
            int r4 = r7.getSize()
            int r3 = r3 + r4
            int r3 = r3 + -1
            int r2 = java.lang.Math.min(r2, r3)
            if (r1 > r2) goto L_0x0057
        L_0x0027:
            if (r0 == 0) goto L_0x0039
            int r3 = r7.getStartIndex()
            int r3 = r1 - r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r3 = r0.invoke(r3)
            if (r3 != 0) goto L_0x003d
        L_0x0039:
            java.lang.Object r3 = androidx.compose.foundation.lazy.layout.Lazy_androidKt.getDefaultLazyLayoutKey(r1)
        L_0x003d:
            androidx.collection.MutableObjectIntMap<java.lang.Object> r4 = r6.$map
            r4.set(r3, r1)
            androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r4 = r6.this$0
            java.lang.Object[] r4 = r4.keys
            androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r5 = r6.this$0
            int r5 = r5.keysStartIndex
            int r5 = r1 - r5
            r4[r5] = r3
            if (r1 == r2) goto L_0x0057
            int r1 = r1 + 1
            goto L_0x0027
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$2$1.invoke(androidx.compose.foundation.lazy.layout.IntervalList$Interval):void");
    }
}
