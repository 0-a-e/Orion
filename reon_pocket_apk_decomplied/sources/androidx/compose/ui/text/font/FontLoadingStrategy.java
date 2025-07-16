package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/font/FontLoadingStrategy;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: FontLoadingStrategy.kt */
public final class FontLoadingStrategy {
    /* access modifiers changed from: private */
    public static final int Async = m6143constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Blocking = m6143constructorimpl(0);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int OptionalLocal = m6143constructorimpl(1);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FontLoadingStrategy m6142boximpl(int i) {
        return new FontLoadingStrategy(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m6143constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6144equalsimpl(int i, Object obj) {
        return (obj instanceof FontLoadingStrategy) && i == ((FontLoadingStrategy) obj).m6148unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6145equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6146hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m6144equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6146hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6148unboximpl() {
        return this.value;
    }

    private /* synthetic */ FontLoadingStrategy(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m6147toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6147toStringimpl(int i) {
        if (m6145equalsimpl0(i, Blocking)) {
            return "Blocking";
        }
        if (m6145equalsimpl0(i, OptionalLocal)) {
            return "Optional";
        }
        if (m6145equalsimpl0(i, Async)) {
            return "Async";
        }
        return "Invalid(value=" + i + ')';
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/font/FontLoadingStrategy$Companion;", "", "()V", "Async", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "getAsync-PKNRLFQ", "()I", "I", "Blocking", "getBlocking-PKNRLFQ", "OptionalLocal", "getOptionalLocal-PKNRLFQ", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontLoadingStrategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getBlocking-PKNRLFQ  reason: not valid java name */
        public final int m6150getBlockingPKNRLFQ() {
            return FontLoadingStrategy.Blocking;
        }

        /* renamed from: getOptionalLocal-PKNRLFQ  reason: not valid java name */
        public final int m6151getOptionalLocalPKNRLFQ() {
            return FontLoadingStrategy.OptionalLocal;
        }

        /* renamed from: getAsync-PKNRLFQ  reason: not valid java name */
        public final int m6149getAsyncPKNRLFQ() {
            return FontLoadingStrategy.Async;
        }
    }
}
