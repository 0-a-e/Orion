package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/PaintingStyle;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: PaintingStyle.kt */
public final class PaintingStyle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Fill = m4100constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Stroke = m4100constructorimpl(1);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PaintingStyle m4099boximpl(int i) {
        return new PaintingStyle(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4100constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4101equalsimpl(int i, Object obj) {
        return (obj instanceof PaintingStyle) && i == ((PaintingStyle) obj).m4105unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4102equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4103hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4101equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4103hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4105unboximpl() {
        return this.value;
    }

    private /* synthetic */ PaintingStyle(int i) {
        this.value = i;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/PaintingStyle$Companion;", "", "()V", "Fill", "Landroidx/compose/ui/graphics/PaintingStyle;", "getFill-TiuSbCo", "()I", "I", "Stroke", "getStroke-TiuSbCo", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PaintingStyle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getFill-TiuSbCo  reason: not valid java name */
        public final int m4106getFillTiuSbCo() {
            return PaintingStyle.Fill;
        }

        /* renamed from: getStroke-TiuSbCo  reason: not valid java name */
        public final int m4107getStrokeTiuSbCo() {
            return PaintingStyle.Stroke;
        }
    }

    public String toString() {
        return m4104toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4104toStringimpl(int i) {
        if (m4102equalsimpl0(i, Fill)) {
            return "Fill";
        }
        if (m4102equalsimpl0(i, Stroke)) {
            return "Stroke";
        }
        return "Unknown";
    }
}
