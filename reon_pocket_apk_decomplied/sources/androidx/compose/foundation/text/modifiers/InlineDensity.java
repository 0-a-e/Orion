package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@JvmInline
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bB\u0011\b\u0002\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0001\t\u0001\u00020\n¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity;", "", "density", "", "fontScale", "constructor-impl", "(FF)J", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)J", "packedValue", "", "(J)J", "getDensity-impl", "(J)F", "getFontScale-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InlineDensity.kt */
public final class InlineDensity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified = m1162constructorimpl(Float.NaN, Float.NaN);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ InlineDensity m1161boximpl(long j) {
        return new InlineDensity(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static long m1163constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1165equalsimpl(long j, Object obj) {
        return (obj instanceof InlineDensity) && j == ((InlineDensity) obj).m1171unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1166equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1169hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1165equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1169hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1171unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ InlineDensity(long j) {
        this.packedValue = j;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1164constructorimpl(Density density) {
        return m1162constructorimpl(density.getDensity(), density.getFontScale());
    }

    public String toString() {
        return m1170toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1170toStringimpl(long j) {
        return "InlineDensity(density=" + m1167getDensityimpl(j) + ", fontScale=" + m1168getFontScaleimpl(j) + ')';
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity$Companion;", "", "()V", "Unspecified", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "getUnspecified-L26CHvs", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InlineDensity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-L26CHvs  reason: not valid java name */
        public final long m1172getUnspecifiedL26CHvs() {
            return InlineDensity.Unspecified;
        }
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1162constructorimpl(float f, float f2) {
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f);
        return m1163constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (floatToRawIntBits << 32));
    }

    /* renamed from: getDensity-impl  reason: not valid java name */
    public static final float m1167getDensityimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getFontScale-impl  reason: not valid java name */
    public static final float m1168getFontScaleimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
