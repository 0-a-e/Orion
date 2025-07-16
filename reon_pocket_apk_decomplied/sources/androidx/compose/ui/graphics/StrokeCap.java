package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/StrokeCap;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: StrokeCap.kt */
public final class StrokeCap {
    /* access modifiers changed from: private */
    public static final int Butt = m4224constructorimpl(0);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Round = m4224constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Square = m4224constructorimpl(2);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ StrokeCap m4223boximpl(int i) {
        return new StrokeCap(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4224constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4225equalsimpl(int i, Object obj) {
        return (obj instanceof StrokeCap) && i == ((StrokeCap) obj).m4229unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4226equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4227hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4225equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4227hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4229unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/StrokeCap$Companion;", "", "()V", "Butt", "Landroidx/compose/ui/graphics/StrokeCap;", "getButt-KaPHkGw", "()I", "I", "Round", "getRound-KaPHkGw", "Square", "getSquare-KaPHkGw", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: StrokeCap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getButt-KaPHkGw  reason: not valid java name */
        public final int m4230getButtKaPHkGw() {
            return StrokeCap.Butt;
        }

        /* renamed from: getRound-KaPHkGw  reason: not valid java name */
        public final int m4231getRoundKaPHkGw() {
            return StrokeCap.Round;
        }

        /* renamed from: getSquare-KaPHkGw  reason: not valid java name */
        public final int m4232getSquareKaPHkGw() {
            return StrokeCap.Square;
        }
    }

    private /* synthetic */ StrokeCap(int i) {
        this.value = i;
    }

    public String toString() {
        return m4228toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4228toStringimpl(int i) {
        if (m4226equalsimpl0(i, Butt)) {
            return "Butt";
        }
        if (m4226equalsimpl0(i, Round)) {
            return "Round";
        }
        if (m4226equalsimpl0(i, Square)) {
            return "Square";
        }
        return "Unknown";
    }
}
