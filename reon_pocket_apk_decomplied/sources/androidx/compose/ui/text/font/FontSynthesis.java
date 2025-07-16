package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis;", "", "value", "", "constructor-impl", "(I)I", "isStyleOn", "", "isStyleOn-impl$ui_text_release", "(I)Z", "isWeightOn", "isWeightOn-impl$ui_text_release", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: FontSynthesis.kt */
public final class FontSynthesis {
    /* access modifiers changed from: private */
    public static final int All = m6167constructorimpl(1);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int None = m6167constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Style = m6167constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Weight = m6167constructorimpl(2);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m6166boximpl(int i) {
        return new FontSynthesis(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6167constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6168equalsimpl(int i, Object obj) {
        return (obj instanceof FontSynthesis) && i == ((FontSynthesis) obj).m6174unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6169equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6170hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m6168equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6170hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6174unboximpl() {
        return this.value;
    }

    private /* synthetic */ FontSynthesis(int i) {
        this.value = i;
    }

    public String toString() {
        return m6173toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6173toStringimpl(int i) {
        if (m6169equalsimpl0(i, None)) {
            return "None";
        }
        if (m6169equalsimpl0(i, All)) {
            return "All";
        }
        if (m6169equalsimpl0(i, Weight)) {
            return "Weight";
        }
        if (m6169equalsimpl0(i, Style)) {
            return "Style";
        }
        return "Invalid";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "", "()V", "All", "Landroidx/compose/ui/text/font/FontSynthesis;", "getAll-GVVA2EU", "()I", "I", "None", "getNone-GVVA2EU", "Style", "getStyle-GVVA2EU", "Weight", "getWeight-GVVA2EU", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontSynthesis.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNone-GVVA2EU  reason: not valid java name */
        public final int m6176getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* renamed from: getAll-GVVA2EU  reason: not valid java name */
        public final int m6175getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* renamed from: getWeight-GVVA2EU  reason: not valid java name */
        public final int m6178getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }

        /* renamed from: getStyle-GVVA2EU  reason: not valid java name */
        public final int m6177getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }
    }

    /* renamed from: isWeightOn-impl$ui_text_release  reason: not valid java name */
    public static final boolean m6172isWeightOnimpl$ui_text_release(int i) {
        return m6169equalsimpl0(i, All) || m6169equalsimpl0(i, Weight);
    }

    /* renamed from: isStyleOn-impl$ui_text_release  reason: not valid java name */
    public static final boolean m6171isStyleOnimpl$ui_text_release(int i) {
        return m6169equalsimpl0(i, All) || m6169equalsimpl0(i, Style);
    }
}
