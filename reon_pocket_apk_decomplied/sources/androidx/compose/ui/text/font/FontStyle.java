package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/font/FontStyle;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: FontStyle.kt */
public final class FontStyle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Italic = m6156constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Normal = m6156constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FontStyle m6155boximpl(int i) {
        return new FontStyle(i);
    }

    @Deprecated(message = "Please use FontStyle.Normal or FontStyle.Italic", replaceWith = @ReplaceWith(expression = "FontStyle.", imports = {}))
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6156constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6157equalsimpl(int i, Object obj) {
        return (obj instanceof FontStyle) && i == ((FontStyle) obj).m6161unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6158equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6159hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m6157equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6159hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6161unboximpl() {
        return this.value;
    }

    @Deprecated(message = "Please use FontStyle.Normal or FontStyle.Italic", replaceWith = @ReplaceWith(expression = "FontStyle.", imports = {}))
    private /* synthetic */ FontStyle(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m6160toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6160toStringimpl(int i) {
        if (m6158equalsimpl0(i, Normal)) {
            return "Normal";
        }
        if (m6158equalsimpl0(i, Italic)) {
            return "Italic";
        }
        return "Invalid";
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rR\u001f\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/font/FontStyle$Companion;", "", "()V", "Italic", "Landroidx/compose/ui/text/font/FontStyle;", "getItalic-_-LCdwA$annotations", "getItalic-_-LCdwA", "()I", "I", "Normal", "getNormal-_-LCdwA$annotations", "getNormal-_-LCdwA", "values", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontStyle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getItalic-_-LCdwA$annotations  reason: not valid java name */
        public static /* synthetic */ void m6162getItalic_LCdwA$annotations() {
        }

        /* renamed from: getNormal-_-LCdwA$annotations  reason: not valid java name */
        public static /* synthetic */ void m6163getNormal_LCdwA$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getNormal-_-LCdwA  reason: not valid java name */
        public final int m6165getNormal_LCdwA() {
            return FontStyle.Normal;
        }

        /* renamed from: getItalic-_-LCdwA  reason: not valid java name */
        public final int m6164getItalic_LCdwA() {
            return FontStyle.Italic;
        }

        public final List<FontStyle> values() {
            return CollectionsKt.listOf(FontStyle.m6155boximpl(m6165getNormal_LCdwA()), FontStyle.m6155boximpl(m6164getItalic_LCdwA()));
        }
    }
}
