package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ\u001e\u0010\u0011\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0016\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi21;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "tmpLocation", "", "[F", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "transformMatrixToWindow", "transformMatrixToWindow-EL8BTi8", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation;
    private final float[] tmpMatrix;

    public /* synthetic */ CalculateMatrixToWindowApi21(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    private CalculateMatrixToWindowApi21(float[] fArr) {
        this.tmpMatrix = fArr;
        this.tmpLocation = new int[2];
    }

    /* renamed from: calculateMatrixToWindow-EL8BTi8  reason: not valid java name */
    public void m5764calculateMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Matrix.m4067resetimpl(fArr);
        m5763transformMatrixToWindowEL8BTi8(view, fArr);
    }

    /* renamed from: transformMatrixToWindow-EL8BTi8  reason: not valid java name */
    private final void m5763transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m5763transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m5762preTranslate3XD1CNM(fArr, -((float) view.getScrollX()), -((float) view.getScrollY()));
            m5762preTranslate3XD1CNM(fArr, (float) view.getLeft(), (float) view.getTop());
        } else {
            int[] iArr = this.tmpLocation;
            view.getLocationInWindow(iArr);
            m5762preTranslate3XD1CNM(fArr, -((float) view.getScrollX()), -((float) view.getScrollY()));
            m5762preTranslate3XD1CNM(fArr, (float) iArr[0], (float) iArr[1]);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            m5761preConcattUYjHk(fArr, matrix);
        }
    }

    /* renamed from: preConcat-tU-YjHk  reason: not valid java name */
    private final void m5761preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.m3675setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m5757preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* renamed from: preTranslate-3XD1CNM  reason: not valid java name */
    private final void m5762preTranslate3XD1CNM(float[] fArr, float f, float f2) {
        AndroidComposeView_androidKt.m5758preTranslatecG2Xzmc(fArr, f, f2, this.tmpMatrix);
    }
}
