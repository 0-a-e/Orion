package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 12\u00020\u0001:\u00011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\n¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\n¢\u0006\u0004\b\u0013\u0010\fJ'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0002ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0002ø\u0001\u0001¢\u0006\u0004\b(\u0010&J\u001e\u0010)\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001aJ\u000f\u0010+\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0016\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0001\u0002\u0001\u00020\u0003\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OHQCggk", "(JFF)J", "div", "operand", "div-Bz7bX_o", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-vF7b-mM", "(JJ)J", "plus", "plus-vF7b-mM", "times", "times-Bz7bX_o", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-kKHJgLs", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CornerRadius.kt */
public final class CornerRadius {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, (Object) null);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CornerRadius m3528boximpl(long j) {
        return new CornerRadius(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m3531constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3535equalsimpl(long j, Object obj) {
        return (obj instanceof CornerRadius) && j == ((CornerRadius) obj).m3545unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3536equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3539hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m3535equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3539hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m3545unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ CornerRadius(long j) {
        this.packedValue = j;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m3529component1impl(long j) {
        return m3537getXimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m3530component2impl(long j) {
        return m3538getYimpl(j);
    }

    /* renamed from: copy-OHQCggk  reason: not valid java name */
    public static final long m3532copyOHQCggk(long j, float f, float f2) {
        return CornerRadiusKt.CornerRadius(f, f2);
    }

    /* renamed from: copy-OHQCggk$default  reason: not valid java name */
    public static /* synthetic */ long m3533copyOHQCggk$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m3537getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m3538getYimpl(j);
        }
        return m3532copyOHQCggk(j, f, f2);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/CornerRadius;", "getZero-kKHJgLs$annotations", "getZero-kKHJgLs", "()J", "J", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CornerRadius.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-kKHJgLs$annotations  reason: not valid java name */
        public static /* synthetic */ void m3546getZerokKHJgLs$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getZero-kKHJgLs  reason: not valid java name */
        public final long m3547getZerokKHJgLs() {
            return CornerRadius.Zero;
        }
    }

    /* renamed from: unaryMinus-kKHJgLs  reason: not valid java name */
    public static final long m3544unaryMinuskKHJgLs(long j) {
        return CornerRadiusKt.CornerRadius(-m3537getXimpl(j), -m3538getYimpl(j));
    }

    /* renamed from: minus-vF7b-mM  reason: not valid java name */
    public static final long m3540minusvF7bmM(long j, long j2) {
        return CornerRadiusKt.CornerRadius(m3537getXimpl(j) - m3537getXimpl(j2), m3538getYimpl(j) - m3538getYimpl(j2));
    }

    /* renamed from: plus-vF7b-mM  reason: not valid java name */
    public static final long m3541plusvF7bmM(long j, long j2) {
        return CornerRadiusKt.CornerRadius(m3537getXimpl(j) + m3537getXimpl(j2), m3538getYimpl(j) + m3538getYimpl(j2));
    }

    /* renamed from: times-Bz7bX_o  reason: not valid java name */
    public static final long m3542timesBz7bX_o(long j, float f) {
        return CornerRadiusKt.CornerRadius(m3537getXimpl(j) * f, m3538getYimpl(j) * f);
    }

    /* renamed from: div-Bz7bX_o  reason: not valid java name */
    public static final long m3534divBz7bX_o(long j, float f) {
        return CornerRadiusKt.CornerRadius(m3537getXimpl(j) / f, m3538getYimpl(j) / f);
    }

    public String toString() {
        return m3543toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3543toStringimpl(long j) {
        if (m3537getXimpl(j) == m3538getYimpl(j)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m3537getXimpl(j), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m3537getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m3538getYimpl(j), 1) + ')';
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m3537getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m3538getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
