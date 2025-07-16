package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift;", "", "multiplier", "", "constructor-impl", "(F)F", "getMultiplier", "()F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: BaselineShift.kt */
public final class BaselineShift {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float None = m6344constructorimpl(0.0f);
    /* access modifiers changed from: private */
    public static final float Subscript = m6344constructorimpl(-0.5f);
    /* access modifiers changed from: private */
    public static final float Superscript = m6344constructorimpl(0.5f);
    private final float multiplier;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BaselineShift m6343boximpl(float f) {
        return new BaselineShift(f);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float m6344constructorimpl(float f) {
        return f;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6345equalsimpl(float f, Object obj) {
        return (obj instanceof BaselineShift) && Float.compare(f, ((BaselineShift) obj).m6349unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6346equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6347hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6348toStringimpl(float f) {
        return "BaselineShift(multiplier=" + f + ')';
    }

    public boolean equals(Object obj) {
        return m6345equalsimpl(this.multiplier, obj);
    }

    public int hashCode() {
        return m6347hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m6348toStringimpl(this.multiplier);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float m6349unboximpl() {
        return this.multiplier;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/style/BaselineShift;", "getNone-y9eOQZs$annotations", "getNone-y9eOQZs", "()F", "F", "Subscript", "getSubscript-y9eOQZs$annotations", "getSubscript-y9eOQZs", "Superscript", "getSuperscript-y9eOQZs$annotations", "getSuperscript-y9eOQZs", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BaselineShift.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNone-y9eOQZs$annotations  reason: not valid java name */
        public static /* synthetic */ void m6350getNoney9eOQZs$annotations() {
        }

        /* renamed from: getSubscript-y9eOQZs$annotations  reason: not valid java name */
        public static /* synthetic */ void m6351getSubscripty9eOQZs$annotations() {
        }

        /* renamed from: getSuperscript-y9eOQZs$annotations  reason: not valid java name */
        public static /* synthetic */ void m6352getSuperscripty9eOQZs$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getSuperscript-y9eOQZs  reason: not valid java name */
        public final float m6355getSuperscripty9eOQZs() {
            return BaselineShift.Superscript;
        }

        /* renamed from: getSubscript-y9eOQZs  reason: not valid java name */
        public final float m6354getSubscripty9eOQZs() {
            return BaselineShift.Subscript;
        }

        /* renamed from: getNone-y9eOQZs  reason: not valid java name */
        public final float m6353getNoney9eOQZs() {
            return BaselineShift.None;
        }
    }

    private /* synthetic */ BaselineShift(float f) {
        this.multiplier = f;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }
}
