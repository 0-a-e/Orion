package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@JvmInline
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u00078GX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel;", "", "packedValue", "", "constructor-impl", "(J)J", "componentCount", "", "getComponentCount$annotations", "()V", "getComponentCount-impl", "(J)I", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorModel.kt */
public final class ColorModel {
    /* access modifiers changed from: private */
    public static final long Cmyk;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Lab;
    /* access modifiers changed from: private */
    public static final long Rgb;
    /* access modifiers changed from: private */
    public static final long Xyz;
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ColorModel m4282boximpl(long j) {
        return new ColorModel(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4283constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4284equalsimpl(long j, Object obj) {
        return (obj instanceof ColorModel) && j == ((ColorModel) obj).m4289unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4285equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getComponentCount$annotations() {
    }

    /* renamed from: getComponentCount-impl  reason: not valid java name */
    public static final int m4286getComponentCountimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4287hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m4284equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4287hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m4289unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ ColorModel(long j) {
        this.packedValue = j;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel$Companion;", "", "()V", "Cmyk", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "getCmyk-xdoWZVw", "()J", "J", "Lab", "getLab-xdoWZVw", "Rgb", "getRgb-xdoWZVw", "Xyz", "getXyz-xdoWZVw", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ColorModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getRgb-xdoWZVw  reason: not valid java name */
        public final long m4292getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* renamed from: getXyz-xdoWZVw  reason: not valid java name */
        public final long m4293getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }

        /* renamed from: getLab-xdoWZVw  reason: not valid java name */
        public final long m4291getLabxdoWZVw() {
            return ColorModel.Lab;
        }

        /* renamed from: getCmyk-xdoWZVw  reason: not valid java name */
        public final long m4290getCmykxdoWZVw() {
            return ColorModel.Cmyk;
        }
    }

    static {
        long j = (long) 3;
        long j2 = j << 32;
        Rgb = m4283constructorimpl((((long) 0) & 4294967295L) | j2);
        Xyz = m4283constructorimpl((((long) 1) & 4294967295L) | j2);
        Lab = m4283constructorimpl(j2 | (((long) 2) & 4294967295L));
        Cmyk = m4283constructorimpl((j & 4294967295L) | (((long) 4) << 32));
    }

    public String toString() {
        return m4288toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4288toStringimpl(long j) {
        if (m4285equalsimpl0(j, Rgb)) {
            return "Rgb";
        }
        if (m4285equalsimpl0(j, Xyz)) {
            return "Xyz";
        }
        if (m4285equalsimpl0(j, Lab)) {
            return "Lab";
        }
        if (m4285equalsimpl0(j, Cmyk)) {
            return "Cmyk";
        }
        return "Unknown";
    }
}
