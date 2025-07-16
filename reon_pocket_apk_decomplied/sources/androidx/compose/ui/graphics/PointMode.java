package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/PointMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: PointMode.kt */
public final class PointMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Lines = m4146constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Points = m4146constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Polygon = m4146constructorimpl(2);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PointMode m4145boximpl(int i) {
        return new PointMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4146constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4147equalsimpl(int i, Object obj) {
        return (obj instanceof PointMode) && i == ((PointMode) obj).m4151unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4148equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4149hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4147equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4149hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4151unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/PointMode$Companion;", "", "()V", "Lines", "Landroidx/compose/ui/graphics/PointMode;", "getLines-r_lszbg", "()I", "I", "Points", "getPoints-r_lszbg", "Polygon", "getPolygon-r_lszbg", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PointMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getPoints-r_lszbg  reason: not valid java name */
        public final int m4153getPointsr_lszbg() {
            return PointMode.Points;
        }

        /* renamed from: getLines-r_lszbg  reason: not valid java name */
        public final int m4152getLinesr_lszbg() {
            return PointMode.Lines;
        }

        /* renamed from: getPolygon-r_lszbg  reason: not valid java name */
        public final int m4154getPolygonr_lszbg() {
            return PointMode.Polygon;
        }
    }

    private /* synthetic */ PointMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m4150toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4150toStringimpl(int i) {
        if (m4148equalsimpl0(i, Points)) {
            return "Points";
        }
        if (m4148equalsimpl0(i, Lines)) {
            return "Lines";
        }
        if (m4148equalsimpl0(i, Polygon)) {
            return "Polygon";
        }
        return "Unknown";
    }
}
