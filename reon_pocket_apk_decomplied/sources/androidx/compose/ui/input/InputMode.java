package androidx.compose.ui.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/InputMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: InputModeManager.kt */
public final class InputMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Keyboard = m4631constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Touch = m4631constructorimpl(1);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ InputMode m4630boximpl(int i) {
        return new InputMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4631constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4632equalsimpl(int i, Object obj) {
        return (obj instanceof InputMode) && i == ((InputMode) obj).m4636unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4633equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4634hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4632equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4634hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4636unboximpl() {
        return this.value;
    }

    private /* synthetic */ InputMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m4635toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4635toStringimpl(int i) {
        if (m4633equalsimpl0(i, Touch)) {
            return "Touch";
        }
        if (m4633equalsimpl0(i, Keyboard)) {
            return "Keyboard";
        }
        return "Error";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/input/InputMode$Companion;", "", "()V", "Keyboard", "Landroidx/compose/ui/input/InputMode;", "getKeyboard-aOaMEAU", "()I", "I", "Touch", "getTouch-aOaMEAU", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InputModeManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getTouch-aOaMEAU  reason: not valid java name */
        public final int m4638getTouchaOaMEAU() {
            return InputMode.Touch;
        }

        /* renamed from: getKeyboard-aOaMEAU  reason: not valid java name */
        public final int m4637getKeyboardaOaMEAU() {
            return InputMode.Keyboard;
        }
    }
}
