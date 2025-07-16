package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/StrokeJoin;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: StrokeJoin.kt */
public final class StrokeJoin {
    /* access modifiers changed from: private */
    public static final int Bevel = m4234constructorimpl(2);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Miter = m4234constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Round = m4234constructorimpl(1);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ StrokeJoin m4233boximpl(int i) {
        return new StrokeJoin(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4234constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4235equalsimpl(int i, Object obj) {
        return (obj instanceof StrokeJoin) && i == ((StrokeJoin) obj).m4239unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4236equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4237hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4235equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4237hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4239unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/StrokeJoin$Companion;", "", "()V", "Bevel", "Landroidx/compose/ui/graphics/StrokeJoin;", "getBevel-LxFBmk8", "()I", "I", "Miter", "getMiter-LxFBmk8", "Round", "getRound-LxFBmk8", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: StrokeJoin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getMiter-LxFBmk8  reason: not valid java name */
        public final int m4241getMiterLxFBmk8() {
            return StrokeJoin.Miter;
        }

        /* renamed from: getRound-LxFBmk8  reason: not valid java name */
        public final int m4242getRoundLxFBmk8() {
            return StrokeJoin.Round;
        }

        /* renamed from: getBevel-LxFBmk8  reason: not valid java name */
        public final int m4240getBevelLxFBmk8() {
            return StrokeJoin.Bevel;
        }
    }

    private /* synthetic */ StrokeJoin(int i) {
        this.value = i;
    }

    public String toString() {
        return m4238toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4238toStringimpl(int i) {
        if (m4236equalsimpl0(i, Miter)) {
            return "Miter";
        }
        if (m4236equalsimpl0(i, Round)) {
            return "Round";
        }
        if (m4236equalsimpl0(i, Bevel)) {
            return "Bevel";
        }
        return "Unknown";
    }
}
