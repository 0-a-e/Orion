package androidx.compose.ui.input.nestedscroll;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: NestedScrollModifier.kt */
public final class NestedScrollSource {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Drag = m4998constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Fling = m4998constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Relocate = m4998constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Wheel = m4998constructorimpl(4);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ NestedScrollSource m4997boximpl(int i) {
        return new NestedScrollSource(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4998constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4999equalsimpl(int i, Object obj) {
        return (obj instanceof NestedScrollSource) && i == ((NestedScrollSource) obj).m5003unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5000equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5001hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4999equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5001hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5003unboximpl() {
        return this.value;
    }

    private /* synthetic */ NestedScrollSource(int i) {
        this.value = i;
    }

    public String toString() {
        return m5002toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5002toStringimpl(int i) {
        if (m5000equalsimpl0(i, Drag)) {
            return "Drag";
        }
        if (m5000equalsimpl0(i, Fling)) {
            return "Fling";
        }
        if (m5000equalsimpl0(i, Relocate)) {
            return "Relocate";
        }
        if (m5000equalsimpl0(i, Wheel)) {
            return "Wheel";
        }
        return "Invalid";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R$\u0010\n\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource$Companion;", "", "()V", "Drag", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "getDrag-WNlRxjI", "()I", "I", "Fling", "getFling-WNlRxjI", "Relocate", "getRelocate-WNlRxjI$annotations", "getRelocate-WNlRxjI", "Wheel", "getWheel-WNlRxjI", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NestedScrollModifier.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Do not use. Will be removed in the future.")
        /* renamed from: getRelocate-WNlRxjI$annotations  reason: not valid java name */
        public static /* synthetic */ void m5004getRelocateWNlRxjI$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getDrag-WNlRxjI  reason: not valid java name */
        public final int m5005getDragWNlRxjI() {
            return NestedScrollSource.Drag;
        }

        /* renamed from: getFling-WNlRxjI  reason: not valid java name */
        public final int m5006getFlingWNlRxjI() {
            return NestedScrollSource.Fling;
        }

        /* renamed from: getRelocate-WNlRxjI  reason: not valid java name */
        public final int m5007getRelocateWNlRxjI() {
            return NestedScrollSource.Relocate;
        }

        /* renamed from: getWheel-WNlRxjI  reason: not valid java name */
        public final int m5008getWheelWNlRxjI() {
            return NestedScrollSource.Wheel;
        }
    }
}
