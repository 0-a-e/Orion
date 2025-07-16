package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0010\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "", "packedValue", "", "constructor-impl", "(J)J", "currentLineSpan", "", "getCurrentLineSpan-impl", "(J)I", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: LazyGridSpan.kt */
public final class GridItemSpan {
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ GridItemSpan m820boximpl(long j) {
        return new GridItemSpan(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m821constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m822equalsimpl(long j, Object obj) {
        return (obj instanceof GridItemSpan) && j == ((GridItemSpan) obj).m827unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m823equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getCurrentLineSpan-impl  reason: not valid java name */
    public static final int m824getCurrentLineSpanimpl(long j) {
        return (int) j;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m825hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m826toStringimpl(long j) {
        return "GridItemSpan(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m822equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m825hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m826toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m827unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ GridItemSpan(long j) {
        this.packedValue = j;
    }
}
