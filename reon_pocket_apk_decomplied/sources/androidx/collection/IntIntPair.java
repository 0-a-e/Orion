package androidx.collection;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\u0001\u0007\u0001\u00020\b¨\u0006\u001e"}, d2 = {"Landroidx/collection/IntIntPair;", "", "first", "", "second", "constructor-impl", "(II)J", "packedValue", "", "(J)J", "getFirst-impl", "(J)I", "getPackedValue$annotations", "()V", "getSecond-impl", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: IntIntPair.kt */
public final class IntIntPair {
    public final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntIntPair m21boximpl(long j) {
        return new IntIntPair(j);
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m22component1impl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m23component2impl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m25constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m26equalsimpl(long j, Object obj) {
        return (obj instanceof IntIntPair) && j == ((IntIntPair) obj).m32unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m27equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFirst-impl  reason: not valid java name */
    public static final int m28getFirstimpl(long j) {
        return (int) (j >> 32);
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getSecond-impl  reason: not valid java name */
    public static final int m29getSecondimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m30hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m26equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m30hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m32unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntIntPair(long j) {
        this.packedValue = j;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m24constructorimpl(int i, int i2) {
        return m25constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m31toStringimpl(long j) {
        return "(" + m28getFirstimpl(j) + ", " + m29getSecondimpl(j) + ')';
    }

    public String toString() {
        return m31toStringimpl(this.packedValue);
    }
}
