package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/MarqueeAnimationMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: BasicMarquee.kt */
public final class MarqueeAnimationMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Immediately = m291constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int WhileFocused = m291constructorimpl(1);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ MarqueeAnimationMode m290boximpl(int i) {
        return new MarqueeAnimationMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m291constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m292equalsimpl(int i, Object obj) {
        return (obj instanceof MarqueeAnimationMode) && i == ((MarqueeAnimationMode) obj).m296unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m293equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m294hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m292equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m294hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m296unboximpl() {
        return this.value;
    }

    private /* synthetic */ MarqueeAnimationMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m295toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m295toStringimpl(int i) {
        if (m293equalsimpl0(i, Immediately)) {
            return "Immediately";
        }
        if (m293equalsimpl0(i, WhileFocused)) {
            return "WhileFocused";
        }
        throw new IllegalStateException(("invalid value: " + i).toString());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/MarqueeAnimationMode$Companion;", "", "()V", "Immediately", "Landroidx/compose/foundation/MarqueeAnimationMode;", "getImmediately-ZbEOnfQ$annotations", "getImmediately-ZbEOnfQ", "()I", "I", "WhileFocused", "getWhileFocused-ZbEOnfQ$annotations", "getWhileFocused-ZbEOnfQ", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BasicMarquee.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getImmediately-ZbEOnfQ$annotations  reason: not valid java name */
        public static /* synthetic */ void m297getImmediatelyZbEOnfQ$annotations() {
        }

        /* renamed from: getWhileFocused-ZbEOnfQ$annotations  reason: not valid java name */
        public static /* synthetic */ void m298getWhileFocusedZbEOnfQ$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getImmediately-ZbEOnfQ  reason: not valid java name */
        public final int m299getImmediatelyZbEOnfQ() {
            return MarqueeAnimationMode.Immediately;
        }

        /* renamed from: getWhileFocused-ZbEOnfQ  reason: not valid java name */
        public final int m300getWhileFocusedZbEOnfQ() {
            return MarqueeAnimationMode.WhileFocused;
        }
    }
}
