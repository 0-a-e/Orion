package androidx.compose.material3.carousel;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016JL\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J \u0010\u001f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", "()V", "firstFocalIndex", "", "focalItemSize", "", "pivotIndex", "pivotOffset", "tmpKeylines", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "add", "", "size", "isAnchor", "", "createKeylinesWithPivot", "", "Landroidx/compose/material3/carousel/Keyline;", "lastFocalIndex", "itemMainAxisSize", "carouselMainAxisSize", "createWithAlignment", "Landroidx/compose/material3/carousel/KeylineList;", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "createWithPivot", "findLastFocalIndex", "isCutoffLeft", "offset", "isCutoffRight", "TmpKeyline", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Keyline.kt */
final class KeylineListScopeImpl implements KeylineListScope {
    private int firstFocalIndex = -1;
    private float focalItemSize;
    private int pivotIndex = -1;
    private float pivotOffset;
    private final List<TmpKeyline> tmpKeylines = new ArrayList();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Keyline.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.material3.carousel.CarouselAlignment[] r0 = androidx.compose.material3.carousel.CarouselAlignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.material3.carousel.CarouselAlignment r1 = androidx.compose.material3.carousel.CarouselAlignment.Start     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.material3.carousel.CarouselAlignment r1 = androidx.compose.material3.carousel.CarouselAlignment.Center     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.material3.carousel.CarouselAlignment r1 = androidx.compose.material3.carousel.CarouselAlignment.End     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.KeylineListScopeImpl.WhenMappings.<clinit>():void");
        }
    }

    private final boolean isCutoffLeft(float f, float f2) {
        float f3 = f / ((float) 2);
        return f2 - f3 < 0.0f && f2 + f3 > 0.0f;
    }

    private final boolean isCutoffRight(float f, float f2, float f3) {
        float f4 = f / ((float) 2);
        return f2 - f4 < f3 && f2 + f4 > f3;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "(FZ)V", "()Z", "getSize", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Keyline.kt */
    private static final class TmpKeyline {
        private final boolean isAnchor;
        private final float size;

        public static /* synthetic */ TmpKeyline copy$default(TmpKeyline tmpKeyline, float f, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                f = tmpKeyline.size;
            }
            if ((i & 2) != 0) {
                z = tmpKeyline.isAnchor;
            }
            return tmpKeyline.copy(f, z);
        }

        public final float component1() {
            return this.size;
        }

        public final boolean component2() {
            return this.isAnchor;
        }

        public final TmpKeyline copy(float f, boolean z) {
            return new TmpKeyline(f, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TmpKeyline)) {
                return false;
            }
            TmpKeyline tmpKeyline = (TmpKeyline) obj;
            return Float.compare(this.size, tmpKeyline.size) == 0 && this.isAnchor == tmpKeyline.isAnchor;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.size) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isAnchor);
        }

        public String toString() {
            return "TmpKeyline(size=" + this.size + ", isAnchor=" + this.isAnchor + ')';
        }

        public TmpKeyline(float f, boolean z) {
            this.size = f;
            this.isAnchor = z;
        }

        public final float getSize() {
            return this.size;
        }

        public final boolean isAnchor() {
            return this.isAnchor;
        }
    }

    public void add(float f, boolean z) {
        this.tmpKeylines.add(new TmpKeyline(f, z));
        if (f > this.focalItemSize) {
            this.firstFocalIndex = CollectionsKt.getLastIndex(this.tmpKeylines);
            this.focalItemSize = f;
        }
    }

    public final KeylineList createWithPivot(float f, int i, float f2) {
        return new KeylineList(createKeylinesWithPivot(i, f2, this.firstFocalIndex, findLastFocalIndex(), this.focalItemSize, f, this.tmpKeylines));
    }

    public final KeylineList createWithAlignment(float f, CarouselAlignment carouselAlignment) {
        float f2;
        float f3;
        int findLastFocalIndex = findLastFocalIndex();
        int i = this.firstFocalIndex;
        int i2 = findLastFocalIndex - i;
        this.pivotIndex = i;
        int i3 = WhenMappings.$EnumSwitchMapping$0[carouselAlignment.ordinal()];
        if (i3 == 1) {
            f3 = this.focalItemSize / ((float) 2);
        } else if (i3 == 2) {
            float f4 = (float) 2;
            f2 = (f / f4) - ((this.focalItemSize / f4) * ((float) i2));
            this.pivotOffset = f2;
            return new KeylineList(createKeylinesWithPivot(this.pivotIndex, f2, this.firstFocalIndex, findLastFocalIndex, this.focalItemSize, f, this.tmpKeylines));
        } else if (i3 == 3) {
            f3 = f - (this.focalItemSize / ((float) 2));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        f2 = f3;
        this.pivotOffset = f2;
        return new KeylineList(createKeylinesWithPivot(this.pivotIndex, f2, this.firstFocalIndex, findLastFocalIndex, this.focalItemSize, f, this.tmpKeylines));
    }

    private final int findLastFocalIndex() {
        int i = this.firstFocalIndex;
        while (i < CollectionsKt.getLastIndex(this.tmpKeylines)) {
            int i2 = i + 1;
            if (this.tmpKeylines.get(i2).getSize() != this.focalItemSize) {
                break;
            }
            i = i2;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<androidx.compose.material3.carousel.Keyline> createKeylinesWithPivot(int r29, float r30, int r31, int r32, float r33, float r34, java.util.List<androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline> r35) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r10 = r30
            r11 = r31
            r12 = r32
            r13 = r34
            r14 = r35
            java.lang.Object r2 = r14.get(r1)
            androidx.compose.material3.carousel.KeylineListScopeImpl$TmpKeyline r2 = (androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r15 = r3
            java.util.List r15 = (java.util.List) r15
            float r3 = r2.getSize()
            boolean r3 = r0.isCutoffLeft(r3, r10)
            r16 = 0
            r9 = 2
            if (r3 == 0) goto L_0x0034
            float r3 = r2.getSize()
            float r4 = (float) r9
            float r3 = r3 / r4
            float r3 = r10 - r3
        L_0x0031:
            r17 = r3
            goto L_0x0049
        L_0x0034:
            float r3 = r2.getSize()
            boolean r3 = r0.isCutoffRight(r3, r10, r13)
            if (r3 == 0) goto L_0x0047
            float r3 = r2.getSize()
            float r4 = (float) r9
            float r3 = r3 / r4
            float r3 = r3 + r10
            float r3 = r3 - r13
            goto L_0x0031
        L_0x0047:
            r17 = r16
        L_0x0049:
            androidx.compose.material3.carousel.Keyline r8 = new androidx.compose.material3.carousel.Keyline
            float r3 = r2.getSize()
            r18 = 1
            r7 = 0
            if (r11 > r1) goto L_0x0059
            if (r1 > r12) goto L_0x0059
            r6 = r18
            goto L_0x005a
        L_0x0059:
            r6 = r7
        L_0x005a:
            boolean r19 = r2.isAnchor()
            r20 = 1
            r2 = r8
            r4 = r30
            r5 = r30
            r13 = r7
            r7 = r19
            r13 = r8
            r8 = r20
            r12 = r9
            r9 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r15.add(r13)
            float r2 = (float) r12
            float r3 = r33 / r2
            float r4 = r10 - r3
            int r5 = r1 + -1
            r6 = 0
            kotlin.ranges.IntProgression r5 = kotlin.ranges.RangesKt.downTo((int) r5, (int) r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r6 = r4
        L_0x0087:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e3
            r7 = r5
            kotlin.collections.IntIterator r7 = (kotlin.collections.IntIterator) r7
            int r7 = r7.nextInt()
            java.lang.Object r8 = r14.get(r7)
            androidx.compose.material3.carousel.KeylineListScopeImpl$TmpKeyline r8 = (androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline) r8
            float r9 = r8.getSize()
            float r9 = r9 / r2
            float r9 = r4 - r9
            float r23 = r6 - r3
            float r12 = r8.getSize()
            boolean r12 = r0.isCutoffLeft(r12, r9)
            if (r12 == 0) goto L_0x00b7
            float r12 = r8.getSize()
            float r12 = r12 / r2
            float r12 = r9 - r12
            r27 = r12
            goto L_0x00b9
        L_0x00b7:
            r27 = r16
        L_0x00b9:
            androidx.compose.material3.carousel.Keyline r12 = new androidx.compose.material3.carousel.Keyline
            float r21 = r8.getSize()
            r13 = r32
            if (r11 > r7) goto L_0x00c8
            if (r7 > r13) goto L_0x00c8
            r24 = r18
            goto L_0x00ca
        L_0x00c8:
            r24 = 0
        L_0x00ca:
            boolean r25 = r8.isAnchor()
            r26 = 0
            r20 = r12
            r22 = r9
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            r7 = 0
            r15.add(r7, r12)
            float r8 = r8.getSize()
            float r4 = r4 - r8
            float r6 = r6 - r33
            goto L_0x0087
        L_0x00e3:
            r13 = r32
            r7 = 0
            float r4 = r10 + r3
            int r1 = r1 + 1
            int r5 = r35.size()
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until((int) r1, (int) r5)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r5 = r4
        L_0x00f9:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0155
            r6 = r1
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            java.lang.Object r8 = r14.get(r6)
            androidx.compose.material3.carousel.KeylineListScopeImpl$TmpKeyline r8 = (androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline) r8
            float r9 = r8.getSize()
            float r9 = r9 / r2
            float r9 = r9 + r4
            float r22 = r5 + r3
            float r10 = r8.getSize()
            r12 = r7
            r7 = r34
            boolean r10 = r0.isCutoffRight(r10, r9, r7)
            if (r10 == 0) goto L_0x012b
            float r10 = r8.getSize()
            float r10 = r10 / r2
            float r10 = r10 + r9
            float r10 = r10 - r7
            r26 = r10
            goto L_0x012d
        L_0x012b:
            r26 = r16
        L_0x012d:
            androidx.compose.material3.carousel.Keyline r10 = new androidx.compose.material3.carousel.Keyline
            float r20 = r8.getSize()
            if (r11 > r6) goto L_0x013a
            if (r6 > r13) goto L_0x013a
            r23 = r18
            goto L_0x013c
        L_0x013a:
            r23 = r12
        L_0x013c:
            boolean r24 = r8.isAnchor()
            r25 = 0
            r19 = r10
            r21 = r9
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r15.add(r10)
            float r6 = r8.getSize()
            float r4 = r4 + r6
            float r5 = r5 + r33
            r7 = r12
            goto L_0x00f9
        L_0x0155:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.KeylineListScopeImpl.createKeylinesWithPivot(int, float, int, int, float, float, java.util.List):java.util.List");
    }
}
