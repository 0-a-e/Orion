package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nJT\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0001\u0010\u00112\u0006\u0010\u0012\u001a\u00020\n26\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\u00110\u0014H\b¢\u0006\u0002\u0010\u0019R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Interval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "", "()V", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "itemCount", "", "getItemCount", "()I", "getContentType", "index", "getKey", "withInterval", "T", "globalIndex", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "localIntervalIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutIntervalContent.kt */
public abstract class LazyLayoutIntervalContent<Interval extends Interval> {
    public static final int $stable = 0;

    public abstract IntervalList<Interval> getIntervals();

    public final int getItemCount() {
        return getIntervals().getSize();
    }

    public final <T> T withInterval(int i, Function2<? super Integer, ? super Interval, ? extends T> function2) {
        IntervalList.Interval interval = getIntervals().get(i);
        return function2.invoke(Integer.valueOf(i - interval.getStartIndex()), interval.getValue());
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001R1\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR1\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "getKey", "()Lkotlin/jvm/functions/Function1;", "type", "getType", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutIntervalContent.kt */
    public interface Interval {
        Function1<Integer, Object> getKey();

        Function1<Integer, Object> getType();

        /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval$-CC  reason: invalid class name */
        /* compiled from: LazyLayoutIntervalContent.kt */
        public final /* synthetic */ class CC {
            public static Function1 $default$getKey(Interval _this) {
                return null;
            }

            public static Function1 $default$getType(Interval _this) {
                return LazyLayoutIntervalContent$Interval$type$1.INSTANCE;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001a, code lost:
        r0 = r0.invoke(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getKey(int r3) {
        /*
            r2 = this;
            androidx.compose.foundation.lazy.layout.IntervalList r0 = r2.getIntervals()
            androidx.compose.foundation.lazy.layout.IntervalList$Interval r0 = r0.get(r3)
            int r1 = r0.getStartIndex()
            int r1 = r3 - r1
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval) r0
            kotlin.jvm.functions.Function1 r0 = r0.getKey()
            if (r0 == 0) goto L_0x0024
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.invoke(r1)
            if (r0 != 0) goto L_0x0028
        L_0x0024:
            java.lang.Object r0 = androidx.compose.foundation.lazy.layout.Lazy_androidKt.getDefaultLazyLayoutKey(r3)
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.getKey(int):java.lang.Object");
    }

    public final Object getContentType(int i) {
        IntervalList.Interval interval = getIntervals().get(i);
        return ((Interval) interval.getValue()).getType().invoke(Integer.valueOf(i - interval.getStartIndex()));
    }
}
