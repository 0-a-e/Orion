package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0019H\u0014J\u0012\u0010B\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\u001bH\u0014J\f\u0010D\u001a\u00020E*\u00020FH\u0014R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000f8@X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b8@@@X\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b&\u0010'R+\u0010(\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u001d8B@BX\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R$\u0010/\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8@@@X\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R1\u00104\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8@@@X\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b8\u0010\r\u001a\u0004\b5\u0010'\"\u0004\b6\u00107R\u0014\u00109\u001a\u00020:X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R*\u0010=\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020%8@@@X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b>\u0010'\"\u0004\b?\u00107\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "<set-?>", "", "autoMirror", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror$delegate", "Landroidx/compose/runtime/MutableState;", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getBitmapConfig-_sVssgQ$ui_release", "()I", "composition", "Landroidx/compose/runtime/Composition;", "getComposition$ui_release", "()Landroidx/compose/runtime/Composition;", "setComposition$ui_release", "(Landroidx/compose/runtime/Composition;)V", "currentAlpha", "", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawCount", "", "value", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "invalidateCount", "getInvalidateCount", "setInvalidateCount", "(I)V", "invalidateCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "", "name", "getName$ui_release", "()Ljava/lang/String;", "setName$ui_release", "(Ljava/lang/String;)V", "size", "getSize-NH-jbRc$ui_release", "setSize-uvyYCjk$ui_release", "(J)V", "size$delegate", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "getVector$ui_release", "()Landroidx/compose/ui/graphics/vector/VectorComponent;", "viewportSize", "getViewportSize-NH-jbRc$ui_release", "setViewportSize-uvyYCjk$ui_release", "applyAlpha", "alpha", "applyColorFilter", "colorFilter", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
public final class VectorPainter extends Painter {
    public static final int $stable = 8;
    private final MutableState autoMirror$delegate;
    private Composition composition;
    private float currentAlpha;
    private ColorFilter currentColorFilter;
    /* access modifiers changed from: private */
    public int drawCount;
    private final MutableIntState invalidateCount$delegate;
    private final MutableState size$delegate;
    private final VectorComponent vector;

    public VectorPainter() {
        this((GroupComponent) null, 1, (DefaultConstructorMarker) null);
    }

    public VectorPainter(GroupComponent groupComponent) {
        this.size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3619boximpl(Size.Companion.m3640getZeroNHjbRc()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.autoMirror$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.setInvalidateCallback$ui_release(new VectorPainter$vector$1$1(this));
        this.vector = vectorComponent;
        this.invalidateCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.currentAlpha = 1.0f;
        this.drawCount = -1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorPainter(GroupComponent groupComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new GroupComponent() : groupComponent);
    }

    /* renamed from: getSize-NH-jbRc$ui_release  reason: not valid java name */
    public final long m4598getSizeNHjbRc$ui_release() {
        return ((Size) this.size$delegate.getValue()).m3636unboximpl();
    }

    /* renamed from: setSize-uvyYCjk$ui_release  reason: not valid java name */
    public final void m4600setSizeuvyYCjk$ui_release(long j) {
        this.size$delegate.setValue(Size.m3619boximpl(j));
    }

    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror$delegate.getValue()).booleanValue();
    }

    public final void setAutoMirror$ui_release(boolean z) {
        this.autoMirror$delegate.setValue(Boolean.valueOf(z));
    }

    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.vector.setIntrinsicColorFilter$ui_release(colorFilter);
    }

    /* renamed from: getViewportSize-NH-jbRc$ui_release  reason: not valid java name */
    public final long m4599getViewportSizeNHjbRc$ui_release() {
        return this.vector.m4589getViewportSizeNHjbRc$ui_release();
    }

    /* renamed from: setViewportSize-uvyYCjk$ui_release  reason: not valid java name */
    public final void m4601setViewportSizeuvyYCjk$ui_release(long j) {
        this.vector.m4590setViewportSizeuvyYCjk$ui_release(j);
    }

    public final String getName$ui_release() {
        return this.vector.getName();
    }

    public final void setName$ui_release(String str) {
        this.vector.setName(str);
    }

    public final VectorComponent getVector$ui_release() {
        return this.vector;
    }

    /* renamed from: getBitmapConfig-_sVssgQ$ui_release  reason: not valid java name */
    public final int m4596getBitmapConfig_sVssgQ$ui_release() {
        return this.vector.m4588getCacheBitmapConfig_sVssgQ$ui_release();
    }

    public final Composition getComposition$ui_release() {
        return this.composition;
    }

    public final void setComposition$ui_release(Composition composition2) {
        this.composition = composition2;
    }

    /* access modifiers changed from: private */
    public final int getInvalidateCount() {
        return this.invalidateCount$delegate.getIntValue();
    }

    /* access modifiers changed from: private */
    public final void setInvalidateCount(int i) {
        this.invalidateCount$delegate.setIntValue(i);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m4597getIntrinsicSizeNHjbRc() {
        return m4598getSizeNHjbRc$ui_release();
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope drawScope) {
        VectorComponent vectorComponent = this.vector;
        ColorFilter colorFilter = this.currentColorFilter;
        if (colorFilter == null) {
            colorFilter = vectorComponent.getIntrinsicColorFilter$ui_release();
        }
        if (!getAutoMirror$ui_release() || drawScope.getLayoutDirection() != LayoutDirection.Rtl) {
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
        } else {
            long r2 = drawScope.m4433getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long r5 = drawContext.m4412getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m4527scale0AR0LA0(-1.0f, 1.0f, r2);
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
            drawContext.getCanvas().restore();
            drawContext.m4413setSizeuvyYCjk(r5);
        }
        this.drawCount = getInvalidateCount();
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float f) {
        this.currentAlpha = f;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }
}
