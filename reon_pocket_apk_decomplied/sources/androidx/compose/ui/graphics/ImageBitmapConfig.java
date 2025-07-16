package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: ImageBitmap.kt */
public final class ImageBitmapConfig {
    /* access modifiers changed from: private */
    public static final int Alpha8 = m4039constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Argb8888 = m4039constructorimpl(0);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int F16 = m4039constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Gpu = m4039constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Rgb565 = m4039constructorimpl(2);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ImageBitmapConfig m4038boximpl(int i) {
        return new ImageBitmapConfig(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4039constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4040equalsimpl(int i, Object obj) {
        return (obj instanceof ImageBitmapConfig) && i == ((ImageBitmapConfig) obj).m4044unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4041equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4042hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4040equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4042hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4044unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig$Companion;", "", "()V", "Alpha8", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getAlpha8-_sVssgQ", "()I", "I", "Argb8888", "getArgb8888-_sVssgQ", "F16", "getF16-_sVssgQ", "Gpu", "getGpu-_sVssgQ", "Rgb565", "getRgb565-_sVssgQ", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ImageBitmap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getArgb8888-_sVssgQ  reason: not valid java name */
        public final int m4046getArgb8888_sVssgQ() {
            return ImageBitmapConfig.Argb8888;
        }

        /* renamed from: getAlpha8-_sVssgQ  reason: not valid java name */
        public final int m4045getAlpha8_sVssgQ() {
            return ImageBitmapConfig.Alpha8;
        }

        /* renamed from: getRgb565-_sVssgQ  reason: not valid java name */
        public final int m4049getRgb565_sVssgQ() {
            return ImageBitmapConfig.Rgb565;
        }

        /* renamed from: getF16-_sVssgQ  reason: not valid java name */
        public final int m4047getF16_sVssgQ() {
            return ImageBitmapConfig.F16;
        }

        /* renamed from: getGpu-_sVssgQ  reason: not valid java name */
        public final int m4048getGpu_sVssgQ() {
            return ImageBitmapConfig.Gpu;
        }
    }

    private /* synthetic */ ImageBitmapConfig(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m4043toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4043toStringimpl(int i) {
        if (m4041equalsimpl0(i, Argb8888)) {
            return "Argb8888";
        }
        if (m4041equalsimpl0(i, Alpha8)) {
            return "Alpha8";
        }
        if (m4041equalsimpl0(i, Rgb565)) {
            return "Rgb565";
        }
        if (m4041equalsimpl0(i, F16)) {
            return "F16";
        }
        if (m4041equalsimpl0(i, Gpu)) {
            return "Gpu";
        }
        return "Unknown";
    }
}
