package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\u0001\u0002¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/SliderRange;", "", "packedValue", "", "constructor-impl", "(J)J", "endInclusive", "", "getEndInclusive$annotations", "()V", "getEndInclusive-impl", "(J)F", "getPackedValue", "()J", "start", "getStart$annotations", "getStart-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderRange {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified = SliderKt.SliderRange(Float.NaN, Float.NaN);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SliderRange m2204boximpl(long j) {
        return new SliderRange(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2205constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2206equalsimpl(long j, Object obj) {
        return (obj instanceof SliderRange) && j == ((SliderRange) obj).m2212unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2207equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getEndInclusive$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2210hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m2206equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2210hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2212unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ SliderRange(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: getStart-impl  reason: not valid java name */
    public static final float m2209getStartimpl(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("SliderRange is unspecified".toString());
    }

    /* renamed from: getEndInclusive-impl  reason: not valid java name */
    public static final float m2208getEndInclusiveimpl(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
        throw new IllegalStateException("SliderRange is unspecified".toString());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/material3/SliderRange$Companion;", "", "()V", "Unspecified", "Landroidx/compose/material3/SliderRange;", "getUnspecified-FYbKRX4$annotations", "getUnspecified-FYbKRX4", "()J", "J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Slider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-FYbKRX4$annotations  reason: not valid java name */
        public static /* synthetic */ void m2213getUnspecifiedFYbKRX4$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-FYbKRX4  reason: not valid java name */
        public final long m2214getUnspecifiedFYbKRX4() {
            return SliderRange.Unspecified;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2211toStringimpl(long j) {
        if (!SliderKt.m2196isSpecifiedIf1S1O4(j)) {
            return "FloatRange.Unspecified";
        }
        return m2209getStartimpl(j) + ".." + m2208getEndInclusiveimpl(j);
    }

    public String toString() {
        return m2211toStringimpl(this.packedValue);
    }
}
