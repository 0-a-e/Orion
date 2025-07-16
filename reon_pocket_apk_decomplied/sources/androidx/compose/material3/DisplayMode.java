package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DisplayMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: DatePicker.kt */
public final class DisplayMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Input = m1807constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Picker = m1807constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DisplayMode m1806boximpl(int i) {
        return new DisplayMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1807constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1808equalsimpl(int i, Object obj) {
        return (obj instanceof DisplayMode) && i == ((DisplayMode) obj).m1812unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1809equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1810hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1808equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1810hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1812unboximpl() {
        return this.value;
    }

    private /* synthetic */ DisplayMode(int i) {
        this.value = i;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/material3/DisplayMode$Companion;", "", "()V", "Input", "Landroidx/compose/material3/DisplayMode;", "getInput-jFl-4v0", "()I", "I", "Picker", "getPicker-jFl-4v0", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DatePicker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getPicker-jFl-4v0  reason: not valid java name */
        public final int m1814getPickerjFl4v0() {
            return DisplayMode.Picker;
        }

        /* renamed from: getInput-jFl-4v0  reason: not valid java name */
        public final int m1813getInputjFl4v0() {
            return DisplayMode.Input;
        }
    }

    public String toString() {
        return m1811toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1811toStringimpl(int i) {
        if (m1809equalsimpl0(i, Picker)) {
            return "Picker";
        }
        if (m1809equalsimpl0(i, Input)) {
            return "Input";
        }
        return "Unknown";
    }
}
