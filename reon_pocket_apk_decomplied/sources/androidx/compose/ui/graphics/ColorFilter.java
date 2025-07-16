package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/ColorFilter;", "", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "(Landroid/graphics/ColorFilter;)V", "getNativeColorFilter$ui_graphics_release", "()Landroid/graphics/ColorFilter;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorFilter.kt */
public class ColorFilter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final android.graphics.ColorFilter nativeColorFilter;

    public ColorFilter(android.graphics.ColorFilter colorFilter) {
        this.nativeColorFilter = colorFilter;
    }

    public final android.graphics.ColorFilter getNativeColorFilter$ui_graphics_release() {
        return this.nativeColorFilter;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/ColorFilter$Companion;", "", "()V", "colorMatrix", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorMatrix-jHG-Opc", "([F)Landroidx/compose/ui/graphics/ColorFilter;", "lighting", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "lighting--OWjLjI", "(JJ)Landroidx/compose/ui/graphics/ColorFilter;", "tint", "color", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "tint-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ColorFilter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: tint-xETnrds$default  reason: not valid java name */
        public static /* synthetic */ ColorFilter m3857tintxETnrds$default(Companion companion, long j, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = BlendMode.Companion.m3744getSrcIn0nO6VwU();
            }
            return companion.m3860tintxETnrds(j, i);
        }

        /* renamed from: tint-xETnrds  reason: not valid java name */
        public final ColorFilter m3860tintxETnrds(long j, int i) {
            return new BlendModeColorFilter(j, i, (DefaultConstructorMarker) null);
        }

        /* renamed from: colorMatrix-jHG-Opc  reason: not valid java name */
        public final ColorFilter m3858colorMatrixjHGOpc(float[] fArr) {
            return new ColorMatrixColorFilter(fArr, (DefaultConstructorMarker) null);
        }

        /* renamed from: lighting--OWjLjI  reason: not valid java name */
        public final ColorFilter m3859lightingOWjLjI(long j, long j2) {
            return new LightingColorFilter(j, j2, (DefaultConstructorMarker) null);
        }
    }
}
