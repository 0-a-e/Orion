package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: PathEffect.kt */
public final class StampedPathEffectStyle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Morph = m4214constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Rotate = m4214constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Translate = m4214constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ StampedPathEffectStyle m4213boximpl(int i) {
        return new StampedPathEffectStyle(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4214constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4215equalsimpl(int i, Object obj) {
        return (obj instanceof StampedPathEffectStyle) && i == ((StampedPathEffectStyle) obj).m4219unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4216equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4217hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4215equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4217hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4219unboximpl() {
        return this.value;
    }

    private /* synthetic */ StampedPathEffectStyle(int i) {
        this.value = i;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/StampedPathEffectStyle$Companion;", "", "()V", "Morph", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "getMorph-Ypspkwk", "()I", "I", "Rotate", "getRotate-Ypspkwk", "Translate", "getTranslate-Ypspkwk", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PathEffect.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getTranslate-Ypspkwk  reason: not valid java name */
        public final int m4222getTranslateYpspkwk() {
            return StampedPathEffectStyle.Translate;
        }

        /* renamed from: getRotate-Ypspkwk  reason: not valid java name */
        public final int m4221getRotateYpspkwk() {
            return StampedPathEffectStyle.Rotate;
        }

        /* renamed from: getMorph-Ypspkwk  reason: not valid java name */
        public final int m4220getMorphYpspkwk() {
            return StampedPathEffectStyle.Morph;
        }
    }

    public String toString() {
        return m4218toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4218toStringimpl(int i) {
        if (m4216equalsimpl0(i, Translate)) {
            return "Translate";
        }
        if (m4216equalsimpl0(i, Rotate)) {
            return "Rotate";
        }
        if (m4216equalsimpl0(i, Morph)) {
            return "Morph";
        }
        return "Unknown";
    }
}
