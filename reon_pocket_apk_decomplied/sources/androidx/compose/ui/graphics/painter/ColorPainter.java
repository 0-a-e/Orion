package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0013\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/painter/ColorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "color", "Landroidx/compose/ui/graphics/Color;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "alpha", "", "getColor-0d7_KjU", "()J", "J", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorPainter.kt */
public final class ColorPainter extends Painter {
    private float alpha;
    private final long color;
    private ColorFilter colorFilter;
    private final long intrinsicSize;

    public /* synthetic */ ColorPainter(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    private ColorPainter(long j) {
        this.color = j;
        this.alpha = 1.0f;
        this.intrinsicSize = Size.Companion.m3639getUnspecifiedNHjbRc();
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m4566getColor0d7_KjU() {
        return this.color;
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope drawScope) {
        DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope, this.color, 0, 0, this.alpha, (DrawStyle) null, this.colorFilter, 0, 86, (Object) null);
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter2) {
        this.colorFilter = colorFilter2;
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorPainter) && Color.m3817equalsimpl0(this.color, ((ColorPainter) obj).color);
    }

    public int hashCode() {
        return Color.m3823hashCodeimpl(this.color);
    }

    public String toString() {
        return "ColorPainter(color=" + Color.m3824toStringimpl(this.color) + ')';
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m4567getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }
}
