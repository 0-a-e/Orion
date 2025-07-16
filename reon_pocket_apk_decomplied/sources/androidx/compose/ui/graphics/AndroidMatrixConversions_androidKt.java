package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"setFrom", "", "Landroid/graphics/Matrix;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMatrixConversions.android.kt */
public final class AndroidMatrixConversions_androidKt {
    /* renamed from: setFrom-tU-YjHk  reason: not valid java name */
    public static final void m3675setFromtUYjHk(float[] fArr, Matrix matrix) {
        float[] fArr2 = fArr;
        matrix.getValues(fArr2);
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        float f4 = fArr2[3];
        float f5 = fArr2[4];
        float f6 = fArr2[5];
        float f7 = fArr2[6];
        float f8 = fArr2[7];
        float f9 = fArr2[8];
        fArr2[0] = f;
        fArr2[1] = f4;
        fArr2[2] = 0.0f;
        fArr2[3] = f7;
        fArr2[4] = f2;
        fArr2[5] = f5;
        fArr2[6] = 0.0f;
        fArr2[7] = f8;
        fArr2[8] = 0.0f;
        fArr2[9] = 0.0f;
        fArr2[10] = 1.0f;
        fArr2[11] = 0.0f;
        fArr2[12] = f3;
        fArr2[13] = f6;
        fArr2[14] = 0.0f;
        fArr2[15] = f9;
    }

    /* renamed from: setFrom-EL8BTi8  reason: not valid java name */
    public static final void m3674setFromEL8BTi8(Matrix matrix, float[] fArr) {
        float f = fArr[2];
        if (f == 0.0f) {
            float f2 = fArr[6];
            if (f2 == 0.0f && fArr[10] == 1.0f && fArr[14] == 0.0f) {
                float f3 = fArr[8];
                if (f3 == 0.0f && fArr[9] == 0.0f && fArr[11] == 0.0f) {
                    float f4 = fArr[0];
                    float f5 = fArr[1];
                    float f6 = fArr[3];
                    float f7 = fArr[4];
                    float f8 = fArr[5];
                    float f9 = fArr[7];
                    float f10 = fArr[12];
                    float f11 = fArr[13];
                    float f12 = fArr[15];
                    fArr[0] = f4;
                    fArr[1] = f7;
                    fArr[2] = f10;
                    fArr[3] = f5;
                    fArr[4] = f8;
                    fArr[5] = f11;
                    fArr[6] = f6;
                    fArr[7] = f9;
                    fArr[8] = f12;
                    matrix.setValues(fArr);
                    fArr[0] = f4;
                    fArr[1] = f5;
                    fArr[2] = f;
                    fArr[3] = f6;
                    fArr[4] = f7;
                    fArr[5] = f8;
                    fArr[6] = f2;
                    fArr[7] = f9;
                    fArr[8] = f3;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Android does not support arbitrary transforms".toString());
    }
}
