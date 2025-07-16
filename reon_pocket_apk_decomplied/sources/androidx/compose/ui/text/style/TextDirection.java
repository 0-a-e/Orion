package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: TextDirection.kt */
public final class TextDirection {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Content = m6468constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int ContentOrLtr = m6468constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int ContentOrRtl = m6468constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int Ltr = m6468constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Rtl = m6468constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Unspecified = m6468constructorimpl(Integer.MIN_VALUE);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextDirection m6467boximpl(int i) {
        return new TextDirection(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6468constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6469equalsimpl(int i, Object obj) {
        return (obj instanceof TextDirection) && i == ((TextDirection) obj).m6473unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6470equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6471hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m6469equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6471hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6473unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextDirection(int i) {
        this.value = i;
    }

    public String toString() {
        return m6472toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6472toStringimpl(int i) {
        if (m6470equalsimpl0(i, Ltr)) {
            return "Ltr";
        }
        if (m6470equalsimpl0(i, Rtl)) {
            return "Rtl";
        }
        if (m6470equalsimpl0(i, Content)) {
            return "Content";
        }
        if (m6470equalsimpl0(i, ContentOrLtr)) {
            return "ContentOrLtr";
        }
        if (m6470equalsimpl0(i, ContentOrRtl)) {
            return "ContentOrRtl";
        }
        if (m6470equalsimpl0(i, Unspecified)) {
            return "Unspecified";
        }
        return "Invalid";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextDirection$Companion;", "", "()V", "Content", "Landroidx/compose/ui/text/style/TextDirection;", "getContent-s_7X-co", "()I", "I", "ContentOrLtr", "getContentOrLtr-s_7X-co", "ContentOrRtl", "getContentOrRtl-s_7X-co", "Ltr", "getLtr-s_7X-co", "Rtl", "getRtl-s_7X-co", "Unspecified", "getUnspecified-s_7X-co", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextDirection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getLtr-s_7X-co  reason: not valid java name */
        public final int m6477getLtrs_7Xco() {
            return TextDirection.Ltr;
        }

        /* renamed from: getRtl-s_7X-co  reason: not valid java name */
        public final int m6478getRtls_7Xco() {
            return TextDirection.Rtl;
        }

        /* renamed from: getContent-s_7X-co  reason: not valid java name */
        public final int m6474getContents_7Xco() {
            return TextDirection.Content;
        }

        /* renamed from: getContentOrLtr-s_7X-co  reason: not valid java name */
        public final int m6475getContentOrLtrs_7Xco() {
            return TextDirection.ContentOrLtr;
        }

        /* renamed from: getContentOrRtl-s_7X-co  reason: not valid java name */
        public final int m6476getContentOrRtls_7Xco() {
            return TextDirection.ContentOrRtl;
        }

        /* renamed from: getUnspecified-s_7X-co  reason: not valid java name */
        public final int m6479getUnspecifieds_7Xco() {
            return TextDirection.Unspecified;
        }
    }
}
