package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0001\b\u0001\u00020\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/animation/core/StartOffset;", "", "offsetMillis", "", "offsetType", "Landroidx/compose/animation/core/StartOffsetType;", "constructor-impl", "(II)J", "value", "", "(J)J", "getOffsetMillis-impl", "(J)I", "getOffsetType-Eo1U57Q", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: AnimationSpec.kt */
public final class StartOffset {
    private final long value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ StartOffset m148boximpl(long j) {
        return new StartOffset(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static long m150constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m152equalsimpl(long j, Object obj) {
        return (obj instanceof StartOffset) && j == ((StartOffset) obj).m158unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m153equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m156hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m157toStringimpl(long j) {
        return "StartOffset(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m152equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m156hashCodeimpl(this.value);
    }

    public String toString() {
        return m157toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m158unboximpl() {
        return this.value;
    }

    private /* synthetic */ StartOffset(long j) {
        this.value = j;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m149constructorimpl(int i, int i2) {
        return m150constructorimpl((long) (i * i2));
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ long m151constructorimpl$default(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            i2 = StartOffsetType.Companion.m166getDelayEo1U57Q();
        }
        return m149constructorimpl(i, i2);
    }

    /* renamed from: getOffsetMillis-impl  reason: not valid java name */
    public static final int m154getOffsetMillisimpl(long j) {
        return Math.abs((int) j);
    }

    /* renamed from: getOffsetType-Eo1U57Q  reason: not valid java name */
    public static final int m155getOffsetTypeEo1U57Q(long j) {
        boolean z = j > 0;
        if (z) {
            return StartOffsetType.Companion.m167getFastForwardEo1U57Q();
        }
        if (!z) {
            return StartOffsetType.Companion.m166getDelayEo1U57Q();
        }
        throw new NoWhenBranchMatchedException();
    }
}
