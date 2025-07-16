package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003()*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\b¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "", "gridContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "(Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;)V", "bucketSize", "", "getBucketSize", "()I", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "cachedBucket", "", "cachedBucketIndex", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "previousDefaultSpans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "totalSize", "getTotalSize", "getDefaultSpans", "currentSlotsPerLine", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "itemIndex", "invalidateCache", "", "spanOf", "maxSpan", "Bucket", "LazyGridItemSpanScopeImpl", "LineConfiguration", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridSpanLayoutProvider.kt */
public final class LazyGridSpanLayoutProvider {
    public static final int $stable = 8;
    private final ArrayList<Bucket> buckets;
    private final List<Integer> cachedBucket = new ArrayList();
    private int cachedBucketIndex = -1;
    private final LazyGridIntervalContent gridContent;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List<GridItemSpan> previousDefaultSpans = CollectionsKt.emptyList();
    private int slotsPerLine;

    public LazyGridSpanLayoutProvider(LazyGridIntervalContent lazyGridIntervalContent) {
        this.gridContent = lazyGridIntervalContent;
        ArrayList<Bucket> arrayList = new ArrayList<>();
        arrayList.add(new Bucket(0, 0, 2, (DefaultConstructorMarker) null));
        this.buckets = arrayList;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "", "firstItemIndex", "", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyGridSpanLayoutProvider.kt */
    public static final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;
        private final List<GridItemSpan> spans;

        public LineConfiguration(int i, List<GridItemSpan> list) {
            this.firstItemIndex = i;
            this.spans = list;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.slotsPerLine))) + 1;
    }

    private final List<GridItemSpan> getDefaultSpans(int i) {
        if (i == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(GridItemSpan.m820boximpl(LazyGridSpanKt.GridItemSpan(1)));
        }
        List<GridItemSpan> list = arrayList;
        this.previousDefaultSpans = list;
        return list;
    }

    public final int getTotalSize() {
        return this.gridContent.getIntervals().getSize();
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final void setSlotsPerLine(int i) {
        if (i != this.slotsPerLine) {
            this.slotsPerLine = i;
            invalidateCache();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008d, code lost:
        if (r7 < r6) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LineConfiguration getLineConfiguration(int r11) {
        /*
            r10 = this;
            androidx.compose.foundation.lazy.grid.LazyGridIntervalContent r0 = r10.gridContent
            boolean r0 = r0.getHasCustomSpans$foundation_release()
            r1 = 0
            if (r0 != 0) goto L_0x0025
            int r0 = r10.slotsPerLine
            int r11 = r11 * r0
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration r0 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration
            int r2 = r10.slotsPerLine
            int r3 = r10.getTotalSize()
            int r3 = r3 - r11
            int r2 = kotlin.ranges.RangesKt.coerceAtMost((int) r2, (int) r3)
            int r1 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r1)
            java.util.List r1 = r10.getDefaultSpans(r1)
            r0.<init>(r11, r1)
            return r0
        L_0x0025:
            int r0 = r10.getBucketSize()
            int r0 = r11 / r0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r2 = r10.buckets
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            int r0 = java.lang.Math.min(r0, r2)
            int r2 = r10.getBucketSize()
            int r2 = r2 * r0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r4 = r10.buckets
            java.lang.Object r4 = r4.get(r0)
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r4 = (androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.Bucket) r4
            int r4 = r4.getFirstItemIndex()
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r5 = r10.buckets
            java.lang.Object r5 = r5.get(r0)
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r5 = (androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.Bucket) r5
            int r5 = r5.getFirstItemKnownSpan()
            int r6 = r10.lastLineIndex
            if (r2 > r6) goto L_0x0060
            if (r6 > r11) goto L_0x0060
            int r4 = r10.lastLineStartItemIndex
            int r5 = r10.lastLineStartKnownSpan
            r2 = r6
            goto L_0x007c
        L_0x0060:
            int r6 = r10.cachedBucketIndex
            if (r0 != r6) goto L_0x007c
            int r6 = r11 - r2
            java.util.List<java.lang.Integer> r7 = r10.cachedBucket
            int r7 = r7.size()
            if (r6 >= r7) goto L_0x007c
            java.util.List<java.lang.Integer> r2 = r10.cachedBucket
            java.lang.Object r2 = r2.get(r6)
            java.lang.Number r2 = (java.lang.Number) r2
            int r4 = r2.intValue()
            r2 = r11
            r5 = r1
        L_0x007c:
            int r6 = r10.getBucketSize()
            int r6 = r2 % r6
            if (r6 != 0) goto L_0x0090
            int r6 = r10.getBucketSize()
            int r7 = r11 - r2
            r8 = 2
            if (r8 > r7) goto L_0x0090
            if (r7 >= r6) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r3 = r1
        L_0x0091:
            if (r3 == 0) goto L_0x009a
            r10.cachedBucketIndex = r0
            java.util.List<java.lang.Integer> r0 = r10.cachedBucket
            r0.clear()
        L_0x009a:
            if (r2 > r11) goto L_0x0148
        L_0x009c:
            if (r2 >= r11) goto L_0x0107
            int r0 = r10.getTotalSize()
            if (r4 >= r0) goto L_0x0107
            if (r3 == 0) goto L_0x00af
            java.util.List<java.lang.Integer> r0 = r10.cachedBucket
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r0.add(r6)
        L_0x00af:
            r0 = r1
        L_0x00b0:
            int r6 = r10.slotsPerLine
            if (r0 >= r6) goto L_0x00d2
            int r6 = r10.getTotalSize()
            if (r4 >= r6) goto L_0x00d2
            if (r5 != 0) goto L_0x00c7
            int r6 = r10.slotsPerLine
            int r6 = r6 - r0
            int r6 = r10.spanOf(r4, r6)
            r9 = r6
            r6 = r5
            r5 = r9
            goto L_0x00c8
        L_0x00c7:
            r6 = r1
        L_0x00c8:
            int r0 = r0 + r5
            int r7 = r10.slotsPerLine
            if (r0 <= r7) goto L_0x00ce
            goto L_0x00d2
        L_0x00ce:
            int r4 = r4 + 1
            r5 = r6
            goto L_0x00b0
        L_0x00d2:
            int r2 = r2 + 1
            int r0 = r10.getBucketSize()
            int r0 = r2 % r0
            if (r0 != 0) goto L_0x009c
            int r0 = r10.getTotalSize()
            if (r4 >= r0) goto L_0x009c
            int r0 = r10.getBucketSize()
            int r0 = r2 / r0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r6 = r10.buckets
            int r6 = r6.size()
            if (r6 != r0) goto L_0x00fb
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r0 = r10.buckets
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r6 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket
            r6.<init>(r4, r5)
            r0.add(r6)
            goto L_0x009c
        L_0x00fb:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "invalid starting point"
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x0107:
            r10.lastLineIndex = r11
            r10.lastLineStartItemIndex = r4
            r10.lastLineStartKnownSpan = r5
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r11 = (java.util.List) r11
            r0 = r1
            r2 = r4
        L_0x0116:
            int r3 = r10.slotsPerLine
            if (r0 >= r3) goto L_0x0142
            int r3 = r10.getTotalSize()
            if (r2 >= r3) goto L_0x0142
            if (r5 != 0) goto L_0x012d
            int r3 = r10.slotsPerLine
            int r3 = r3 - r0
            int r3 = r10.spanOf(r2, r3)
            r9 = r5
            r5 = r3
            r3 = r9
            goto L_0x012e
        L_0x012d:
            r3 = r1
        L_0x012e:
            int r0 = r0 + r5
            int r6 = r10.slotsPerLine
            if (r0 > r6) goto L_0x0142
            int r2 = r2 + 1
            long r5 = androidx.compose.foundation.lazy.grid.LazyGridSpanKt.GridItemSpan(r5)
            androidx.compose.foundation.lazy.grid.GridItemSpan r5 = androidx.compose.foundation.lazy.grid.GridItemSpan.m820boximpl(r5)
            r11.add(r5)
            r5 = r3
            goto L_0x0116
        L_0x0142:
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration r0 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration
            r0.<init>(r4, r11)
            return r0
        L_0x0148:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "currentLine > lineIndex"
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.getLineConfiguration(int):androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration");
    }

    public final int getLineIndexOfItem(int i) {
        if (getTotalSize() <= 0) {
            return 0;
        }
        if (i >= getTotalSize()) {
            throw new IllegalArgumentException("ItemIndex > total count".toString());
        } else if (!this.gridContent.getHasCustomSpans$foundation_release()) {
            return i / this.slotsPerLine;
        } else {
            int binarySearch$default = CollectionsKt.binarySearch$default((List) this.buckets, 0, 0, (Function1) new LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1(i), 3, (Object) null);
            if (binarySearch$default < 0) {
                binarySearch$default = (-binarySearch$default) - 2;
            }
            int bucketSize = getBucketSize() * binarySearch$default;
            int firstItemIndex = this.buckets.get(binarySearch$default).getFirstItemIndex();
            if (firstItemIndex <= i) {
                int i2 = 0;
                while (firstItemIndex < i) {
                    int i3 = firstItemIndex + 1;
                    int spanOf = spanOf(firstItemIndex, this.slotsPerLine - i2);
                    i2 += spanOf;
                    int i4 = this.slotsPerLine;
                    if (i2 >= i4) {
                        if (i2 == i4) {
                            bucketSize++;
                            i2 = 0;
                        } else {
                            bucketSize++;
                            i2 = spanOf;
                        }
                    }
                    if (bucketSize % getBucketSize() == 0 && bucketSize / getBucketSize() >= this.buckets.size()) {
                        this.buckets.add(new Bucket(i3 - (i2 > 0 ? 1 : 0), 0, 2, (DefaultConstructorMarker) null));
                    }
                    firstItemIndex = i3;
                }
                return i2 + spanOf(i, this.slotsPerLine - i2) > this.slotsPerLine ? bucketSize + 1 : bucketSize;
            }
            throw new IllegalArgumentException("currentItemIndex > itemIndex".toString());
        }
    }

    public final int spanOf(int i, int i2) {
        LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = LazyGridItemSpanScopeImpl.INSTANCE;
        lazyGridItemSpanScopeImpl.setMaxCurrentLineSpan(i2);
        lazyGridItemSpanScopeImpl.setMaxLineSpan(this.slotsPerLine);
        IntervalList.Interval interval = this.gridContent.getIntervals().get(i);
        return GridItemSpan.m824getCurrentLineSpanimpl(((LazyGridInterval) interval.getValue()).getSpan().invoke(lazyGridItemSpanScopeImpl, Integer.valueOf(i - interval.getStartIndex())).m827unboximpl());
    }

    private final void invalidateCache() {
        this.buckets.clear();
        this.buckets.add(new Bucket(0, 0, 2, (DefaultConstructorMarker) null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.lastLineStartKnownSpan = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "", "firstItemIndex", "", "firstItemKnownSpan", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyGridSpanLayoutProvider.kt */
    private static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public Bucket(int i, int i2) {
            this.firstItemIndex = i;
            this.firstItemKnownSpan = i2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Bucket(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0 : i2);
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "()V", "maxCurrentLineSpan", "", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyGridSpanLayoutProvider.kt */
    private static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        public void setMaxCurrentLineSpan(int i) {
            maxCurrentLineSpan = i;
        }

        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxLineSpan(int i) {
            maxLineSpan = i;
        }
    }
}
