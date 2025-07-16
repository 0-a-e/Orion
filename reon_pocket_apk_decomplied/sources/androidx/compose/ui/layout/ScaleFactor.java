package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\n¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\n¢\u0006\u0004\b\u0013\u0010\fJ'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001e\u0010$\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001aJ\u000f\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0001\u0002\u0001\u00020\u0003\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "scaleX", "", "getScaleX$annotations", "getScaleX-impl", "(J)F", "scaleY", "getScaleY$annotations", "getScaleY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-8GGzs04", "(JFF)J", "div", "operand", "div-44nBxM0", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "times", "times-44nBxM0", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScaleFactor.kt */
public final class ScaleFactor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m5420boximpl(long j) {
        return new ScaleFactor(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5423constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5427equalsimpl(long j, Object obj) {
        return (obj instanceof ScaleFactor) && j == ((ScaleFactor) obj).m5434unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5428equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getScaleX$annotations() {
    }

    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5431hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m5427equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5431hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5434unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ ScaleFactor(long j) {
        this.packedValue = j;
    }

    /* renamed from: getScaleX-impl  reason: not valid java name */
    public static final float m5429getScaleXimpl(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("ScaleFactor is unspecified".toString());
    }

    /* renamed from: getScaleY-impl  reason: not valid java name */
    public static final float m5430getScaleYimpl(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
        throw new IllegalStateException("ScaleFactor is unspecified".toString());
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m5421component1impl(long j) {
        return m5429getScaleXimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m5422component2impl(long j) {
        return m5430getScaleYimpl(j);
    }

    /* renamed from: copy-8GGzs04  reason: not valid java name */
    public static final long m5424copy8GGzs04(long j, float f, float f2) {
        return ScaleFactorKt.ScaleFactor(f, f2);
    }

    /* renamed from: copy-8GGzs04$default  reason: not valid java name */
    public static /* synthetic */ long m5425copy8GGzs04$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5429getScaleXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m5430getScaleYimpl(j);
        }
        return m5424copy8GGzs04(j, f, f2);
    }

    /* renamed from: times-44nBxM0  reason: not valid java name */
    public static final long m5432times44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m5429getScaleXimpl(j) * f, m5430getScaleYimpl(j) * f);
    }

    /* renamed from: div-44nBxM0  reason: not valid java name */
    public static final long m5426div44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m5429getScaleXimpl(j) / f, m5430getScaleYimpl(j) / f);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5433toStringimpl(long j) {
        return "ScaleFactor(" + ScaleFactorKt.roundToTenths(m5429getScaleXimpl(j)) + ", " + ScaleFactorKt.roundToTenths(m5430getScaleYimpl(j)) + ')';
    }

    public String toString() {
        return m5433toStringimpl(this.packedValue);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/layout/ScaleFactor;", "getUnspecified-_hLwfpc$annotations", "getUnspecified-_hLwfpc", "()J", "J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ScaleFactor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-_hLwfpc$annotations  reason: not valid java name */
        public static /* synthetic */ void m5435getUnspecified_hLwfpc$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-_hLwfpc  reason: not valid java name */
        public final long m5436getUnspecified_hLwfpc() {
            return ScaleFactor.Unspecified;
        }
    }
}
