package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: Placeholder.kt */
public final class PlaceholderVerticalAlign {
    /* access modifiers changed from: private */
    public static final int AboveBaseline = m5967constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Bottom = m5967constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Center = m5967constructorimpl(4);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TextBottom = m5967constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int TextCenter = m5967constructorimpl(7);
    /* access modifiers changed from: private */
    public static final int TextTop = m5967constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int Top = m5967constructorimpl(2);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PlaceholderVerticalAlign m5966boximpl(int i) {
        return new PlaceholderVerticalAlign(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5967constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5968equalsimpl(int i, Object obj) {
        return (obj instanceof PlaceholderVerticalAlign) && i == ((PlaceholderVerticalAlign) obj).m5972unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5969equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5970hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m5968equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5970hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5972unboximpl() {
        return this.value;
    }

    private /* synthetic */ PlaceholderVerticalAlign(int i) {
        this.value = i;
    }

    public String toString() {
        return m5971toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5971toStringimpl(int i) {
        if (m5969equalsimpl0(i, AboveBaseline)) {
            return "AboveBaseline";
        }
        if (m5969equalsimpl0(i, Top)) {
            return "Top";
        }
        if (m5969equalsimpl0(i, Bottom)) {
            return "Bottom";
        }
        if (m5969equalsimpl0(i, Center)) {
            return "Center";
        }
        if (m5969equalsimpl0(i, TextTop)) {
            return "TextTop";
        }
        if (m5969equalsimpl0(i, TextBottom)) {
            return "TextBottom";
        }
        if (m5969equalsimpl0(i, TextCenter)) {
            return "TextCenter";
        }
        return "Invalid";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/PlaceholderVerticalAlign$Companion;", "", "()V", "AboveBaseline", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getAboveBaseline-J6kI3mc", "()I", "I", "Bottom", "getBottom-J6kI3mc", "Center", "getCenter-J6kI3mc", "TextBottom", "getTextBottom-J6kI3mc", "TextCenter", "getTextCenter-J6kI3mc", "TextTop", "getTextTop-J6kI3mc", "Top", "getTop-J6kI3mc", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Placeholder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAboveBaseline-J6kI3mc  reason: not valid java name */
        public final int m5973getAboveBaselineJ6kI3mc() {
            return PlaceholderVerticalAlign.AboveBaseline;
        }

        /* renamed from: getTop-J6kI3mc  reason: not valid java name */
        public final int m5979getTopJ6kI3mc() {
            return PlaceholderVerticalAlign.Top;
        }

        /* renamed from: getBottom-J6kI3mc  reason: not valid java name */
        public final int m5974getBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.Bottom;
        }

        /* renamed from: getCenter-J6kI3mc  reason: not valid java name */
        public final int m5975getCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.Center;
        }

        /* renamed from: getTextTop-J6kI3mc  reason: not valid java name */
        public final int m5978getTextTopJ6kI3mc() {
            return PlaceholderVerticalAlign.TextTop;
        }

        /* renamed from: getTextBottom-J6kI3mc  reason: not valid java name */
        public final int m5976getTextBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.TextBottom;
        }

        /* renamed from: getTextCenter-J6kI3mc  reason: not valid java name */
        public final int m5977getTextCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.TextCenter;
        }
    }
}
