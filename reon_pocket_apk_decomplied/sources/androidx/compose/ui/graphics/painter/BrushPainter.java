package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0013\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\f8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/painter/BrushPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "brush", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/Brush;)V", "alpha", "", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrushPainter.kt */
public final class BrushPainter extends Painter {
    private float alpha = 1.0f;
    private final Brush brush;
    private ColorFilter colorFilter;

    public final Brush getBrush() {
        return this.brush;
    }

    public BrushPainter(Brush brush2) {
        this.brush = brush2;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m4565getIntrinsicSizeNHjbRc() {
        return this.brush.m3753getIntrinsicSizeNHjbRc();
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope drawScope) {
        DrawScope.CC.m4469drawRectAsUm42w$default(drawScope, this.brush, 0, 0, this.alpha, (DrawStyle) null, this.colorFilter, 0, 86, (Object) null);
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
        return (obj instanceof BrushPainter) && Intrinsics.areEqual((Object) this.brush, (Object) ((BrushPainter) obj).brush);
    }

    public int hashCode() {
        return this.brush.hashCode();
    }

    public String toString() {
        return "BrushPainter(brush=" + this.brush + ')';
    }
}
