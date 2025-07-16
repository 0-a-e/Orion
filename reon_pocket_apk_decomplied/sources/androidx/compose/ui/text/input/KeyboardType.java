package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: KeyboardType.kt */
public final class KeyboardType {
    /* access modifiers changed from: private */
    public static final int Ascii = m6270constructorimpl(2);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Decimal = m6270constructorimpl(9);
    /* access modifiers changed from: private */
    public static final int Email = m6270constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int Number = m6270constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int NumberPassword = m6270constructorimpl(8);
    /* access modifiers changed from: private */
    public static final int Password = m6270constructorimpl(7);
    /* access modifiers changed from: private */
    public static final int Phone = m6270constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Text = m6270constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Uri = m6270constructorimpl(5);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ KeyboardType m6269boximpl(int i) {
        return new KeyboardType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6270constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6271equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardType) && i == ((KeyboardType) obj).m6275unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6272equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6273hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m6271equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6273hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6275unboximpl() {
        return this.value;
    }

    private /* synthetic */ KeyboardType(int i) {
        this.value = i;
    }

    public String toString() {
        return m6274toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6274toStringimpl(int i) {
        if (m6272equalsimpl0(i, Text)) {
            return "Text";
        }
        if (m6272equalsimpl0(i, Ascii)) {
            return "Ascii";
        }
        if (m6272equalsimpl0(i, Number)) {
            return "Number";
        }
        if (m6272equalsimpl0(i, Phone)) {
            return "Phone";
        }
        if (m6272equalsimpl0(i, Uri)) {
            return "Uri";
        }
        if (m6272equalsimpl0(i, Email)) {
            return "Email";
        }
        if (m6272equalsimpl0(i, Password)) {
            return "Password";
        }
        if (m6272equalsimpl0(i, NumberPassword)) {
            return "NumberPassword";
        }
        if (m6272equalsimpl0(i, Decimal)) {
            return "Decimal";
        }
        return "Invalid";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType$Companion;", "", "()V", "Ascii", "Landroidx/compose/ui/text/input/KeyboardType;", "getAscii-PjHm6EE$annotations", "getAscii-PjHm6EE", "()I", "I", "Decimal", "getDecimal-PjHm6EE$annotations", "getDecimal-PjHm6EE", "Email", "getEmail-PjHm6EE$annotations", "getEmail-PjHm6EE", "Number", "getNumber-PjHm6EE$annotations", "getNumber-PjHm6EE", "NumberPassword", "getNumberPassword-PjHm6EE$annotations", "getNumberPassword-PjHm6EE", "Password", "getPassword-PjHm6EE$annotations", "getPassword-PjHm6EE", "Phone", "getPhone-PjHm6EE$annotations", "getPhone-PjHm6EE", "Text", "getText-PjHm6EE$annotations", "getText-PjHm6EE", "Uri", "getUri-PjHm6EE$annotations", "getUri-PjHm6EE", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: KeyboardType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAscii-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6276getAsciiPjHm6EE$annotations() {
        }

        /* renamed from: getDecimal-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6277getDecimalPjHm6EE$annotations() {
        }

        /* renamed from: getEmail-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6278getEmailPjHm6EE$annotations() {
        }

        /* renamed from: getNumber-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6279getNumberPjHm6EE$annotations() {
        }

        /* renamed from: getNumberPassword-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6280getNumberPasswordPjHm6EE$annotations() {
        }

        /* renamed from: getPassword-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6281getPasswordPjHm6EE$annotations() {
        }

        /* renamed from: getPhone-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6282getPhonePjHm6EE$annotations() {
        }

        /* renamed from: getText-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6283getTextPjHm6EE$annotations() {
        }

        /* renamed from: getUri-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m6284getUriPjHm6EE$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getText-PjHm6EE  reason: not valid java name */
        public final int m6292getTextPjHm6EE() {
            return KeyboardType.Text;
        }

        /* renamed from: getAscii-PjHm6EE  reason: not valid java name */
        public final int m6285getAsciiPjHm6EE() {
            return KeyboardType.Ascii;
        }

        /* renamed from: getNumber-PjHm6EE  reason: not valid java name */
        public final int m6288getNumberPjHm6EE() {
            return KeyboardType.Number;
        }

        /* renamed from: getPhone-PjHm6EE  reason: not valid java name */
        public final int m6291getPhonePjHm6EE() {
            return KeyboardType.Phone;
        }

        /* renamed from: getUri-PjHm6EE  reason: not valid java name */
        public final int m6293getUriPjHm6EE() {
            return KeyboardType.Uri;
        }

        /* renamed from: getEmail-PjHm6EE  reason: not valid java name */
        public final int m6287getEmailPjHm6EE() {
            return KeyboardType.Email;
        }

        /* renamed from: getPassword-PjHm6EE  reason: not valid java name */
        public final int m6290getPasswordPjHm6EE() {
            return KeyboardType.Password;
        }

        /* renamed from: getNumberPassword-PjHm6EE  reason: not valid java name */
        public final int m6289getNumberPasswordPjHm6EE() {
            return KeyboardType.NumberPassword;
        }

        /* renamed from: getDecimal-PjHm6EE  reason: not valid java name */
        public final int m6286getDecimalPjHm6EE() {
            return KeyboardType.Decimal;
        }
    }
}
