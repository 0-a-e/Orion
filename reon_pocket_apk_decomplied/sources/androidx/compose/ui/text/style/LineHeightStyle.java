package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle;", "", "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PIaL0Z0", "()F", "F", "getTrim-EVpEnUU", "()I", "I", "equals", "", "other", "hashCode", "", "toString", "", "Alignment", "Companion", "Trim", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LineHeightStyle.kt */
public final class LineHeightStyle {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final LineHeightStyle Default = new LineHeightStyle(Alignment.Companion.m6438getProportionalPIaL0Z0(), Trim.Companion.m6449getBothEVpEnUU(), (DefaultConstructorMarker) null);
    private final float alignment;
    private final int trim;

    public /* synthetic */ LineHeightStyle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i);
    }

    private LineHeightStyle(float f, int i) {
        this.alignment = f;
        this.trim = i;
    }

    /* renamed from: getAlignment-PIaL0Z0  reason: not valid java name */
    public final float m6427getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* renamed from: getTrim-EVpEnUU  reason: not valid java name */
    public final int m6428getTrimEVpEnUU() {
        return this.trim;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineHeightStyle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        return Alignment.m6432equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m6443equalsimpl0(this.trim, lineHeightStyle.trim);
    }

    public int hashCode() {
        return (Alignment.m6433hashCodeimpl(this.alignment) * 31) + Trim.m6444hashCodeimpl(this.trim);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + Alignment.m6434toStringimpl(this.alignment) + ", trim=" + Trim.m6447toStringimpl(this.trim) + ')';
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isTrimFirstLineTop", "isTrimFirstLineTop-impl$ui_text_release", "(I)Z", "isTrimLastLineBottom", "isTrimLastLineBottom-impl$ui_text_release", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineHeightStyle.kt */
    public static final class Trim {
        /* access modifiers changed from: private */
        public static final int Both = m6441constructorimpl(17);
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int FirstLineTop = m6441constructorimpl(1);
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        /* access modifiers changed from: private */
        public static final int LastLineBottom = m6441constructorimpl(16);
        /* access modifiers changed from: private */
        public static final int None = m6441constructorimpl(0);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Trim m6440boximpl(int i) {
            return new Trim(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m6441constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m6442equalsimpl(int i, Object obj) {
            return (obj instanceof Trim) && i == ((Trim) obj).m6448unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m6443equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m6444hashCodeimpl(int i) {
            return i;
        }

        /* renamed from: isTrimFirstLineTop-impl$ui_text_release  reason: not valid java name */
        public static final boolean m6445isTrimFirstLineTopimpl$ui_text_release(int i) {
            return (i & 1) > 0;
        }

        /* renamed from: isTrimLastLineBottom-impl$ui_text_release  reason: not valid java name */
        public static final boolean m6446isTrimLastLineBottomimpl$ui_text_release(int i) {
            return (i & 16) > 0;
        }

        public boolean equals(Object obj) {
            return m6442equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m6444hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m6448unboximpl() {
            return this.value;
        }

        private /* synthetic */ Trim(int i) {
            this.value = i;
        }

        public String toString() {
            return m6447toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m6447toStringimpl(int i) {
            if (i == FirstLineTop) {
                return "LineHeightStyle.Trim.FirstLineTop";
            }
            if (i == LastLineBottom) {
                return "LineHeightStyle.Trim.LastLineBottom";
            }
            if (i == Both) {
                return "LineHeightStyle.Trim.Both";
            }
            if (i == None) {
                return "LineHeightStyle.Trim.None";
            }
            return "Invalid";
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u0019\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "", "()V", "Both", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "getBoth-EVpEnUU", "()I", "I", "FirstLineTop", "getFirstLineTop-EVpEnUU", "FlagTrimBottom", "", "FlagTrimTop", "LastLineBottom", "getLastLineBottom-EVpEnUU", "None", "getNone-EVpEnUU", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LineHeightStyle.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getFirstLineTop-EVpEnUU  reason: not valid java name */
            public final int m6450getFirstLineTopEVpEnUU() {
                return Trim.FirstLineTop;
            }

            /* renamed from: getLastLineBottom-EVpEnUU  reason: not valid java name */
            public final int m6451getLastLineBottomEVpEnUU() {
                return Trim.LastLineBottom;
            }

            /* renamed from: getBoth-EVpEnUU  reason: not valid java name */
            public final int m6449getBothEVpEnUU() {
                return Trim.Both;
            }

            /* renamed from: getNone-EVpEnUU  reason: not valid java name */
            public final int m6452getNoneEVpEnUU() {
                return Trim.None;
            }
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "", "topRatio", "", "constructor-impl", "(F)F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineHeightStyle.kt */
    public static final class Alignment {
        /* access modifiers changed from: private */
        public static final float Bottom = m6430constructorimpl(1.0f);
        /* access modifiers changed from: private */
        public static final float Center = m6430constructorimpl(0.5f);
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final float Proportional = m6430constructorimpl(-1.0f);
        /* access modifiers changed from: private */
        public static final float Top = m6430constructorimpl(0.0f);
        private final float topRatio;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Alignment m6429boximpl(float f) {
            return new Alignment(f);
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m6431equalsimpl(float f, Object obj) {
            return (obj instanceof Alignment) && Float.compare(f, ((Alignment) obj).m6435unboximpl()) == 0;
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m6432equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m6433hashCodeimpl(float f) {
            return Float.floatToIntBits(f);
        }

        public boolean equals(Object obj) {
            return m6431equalsimpl(this.topRatio, obj);
        }

        public int hashCode() {
            return m6433hashCodeimpl(this.topRatio);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ float m6435unboximpl() {
            return this.topRatio;
        }

        private /* synthetic */ Alignment(float f) {
            this.topRatio = f;
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static float m6430constructorimpl(float f) {
            if ((0.0f <= f && f <= 1.0f) || f == -1.0f) {
                return f;
            }
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }

        public String toString() {
            return m6434toStringimpl(this.topRatio);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m6434toStringimpl(float f) {
            if (f == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f + ')';
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "", "()V", "Bottom", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "getBottom-PIaL0Z0", "()F", "F", "Center", "getCenter-PIaL0Z0", "Proportional", "getProportional-PIaL0Z0", "Top", "getTop-PIaL0Z0", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LineHeightStyle.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getTop-PIaL0Z0  reason: not valid java name */
            public final float m6439getTopPIaL0Z0() {
                return Alignment.Top;
            }

            /* renamed from: getCenter-PIaL0Z0  reason: not valid java name */
            public final float m6437getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* renamed from: getProportional-PIaL0Z0  reason: not valid java name */
            public final float m6438getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }

            /* renamed from: getBottom-PIaL0Z0  reason: not valid java name */
            public final float m6436getBottomPIaL0Z0() {
                return Alignment.Bottom;
            }
        }
    }
}
