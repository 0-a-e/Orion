package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/graphics/BlendModeColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "(JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "(JILandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlendMode-0nO6VwU", "()I", "I", "getColor-0d7_KjU", "()J", "J", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorFilter.kt */
public final class BlendModeColorFilter extends ColorFilter {
    private final int blendMode;
    private final long color;

    public /* synthetic */ BlendModeColorFilter(long j, int i, ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, colorFilter);
    }

    public /* synthetic */ BlendModeColorFilter(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i);
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m3749getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public final int m3748getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    private BlendModeColorFilter(long j, int i, ColorFilter colorFilter) {
        super(colorFilter);
        this.color = j;
        this.blendMode = i;
    }

    private BlendModeColorFilter(long j, int i) {
        this(j, i, AndroidColorFilter_androidKt.m3670actualTintColorFilterxETnrds(j, i), (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlendModeColorFilter)) {
            return false;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj;
        return Color.m3817equalsimpl0(this.color, blendModeColorFilter.color) && BlendMode.m3715equalsimpl0(this.blendMode, blendModeColorFilter.blendMode);
    }

    public int hashCode() {
        return (Color.m3823hashCodeimpl(this.color) * 31) + BlendMode.m3716hashCodeimpl(this.blendMode);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + Color.m3824toStringimpl(this.color) + ", blendMode=" + BlendMode.m3717toStringimpl(this.blendMode) + ')';
    }
}
