package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/animation/core/PathEasing;", "Landroidx/compose/animation/core/Easing;", "path", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/Path;)V", "offsetX", "", "offsetY", "transform", "", "fraction", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathEasing.kt */
public final class PathEasing implements Easing {
    public static final int $stable = 0;
    private final float[] offsetX;
    private final float[] offsetY;

    public PathEasing(Path path) {
        PathMeasure PathMeasure = AndroidPathMeasure_androidKt.PathMeasure();
        PathMeasure.setPath(path, false);
        float length = PathMeasure.getLength();
        if (length > 0.0f) {
            int i = (int) (length / 0.002f);
            int i2 = i + 1;
            float[] fArr = new float[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                fArr[i3] = 0.0f;
            }
            this.offsetX = fArr;
            float[] fArr2 = new float[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                fArr2[i4] = 0.0f;
            }
            this.offsetY = fArr2;
            for (int i5 = 0; i5 < i2; i5++) {
                long r5 = PathMeasure.m4130getPositiontuRUvjQ((((float) i5) * length) / ((float) i));
                this.offsetX[i5] = Offset.m3562getXimpl(r5);
                this.offsetY[i5] = Offset.m3563getYimpl(r5);
                if (i5 > 0) {
                    float[] fArr3 = this.offsetX;
                    if (fArr3[i5] < fArr3[i5 - 1]) {
                        throw new IllegalArgumentException("Path needs to be continuously increasing");
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("Path cannot be zero in length. Ensure that supplied Path starts at [0,0] and ends at [1,1]".toString());
    }

    public float transform(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int binarySearch$default = ArraysKt.binarySearch$default(this.offsetX, f, 0, 0, 6, (Object) null);
        if (binarySearch$default > 0) {
            return this.offsetY[binarySearch$default];
        }
        int abs = Math.abs(binarySearch$default);
        float[] fArr = this.offsetX;
        if (abs >= fArr.length - 1) {
            return ArraysKt.last(this.offsetY);
        }
        int i = abs + 1;
        float f2 = fArr[i];
        float f3 = fArr[abs];
        float f4 = f - f3;
        float[] fArr2 = this.offsetY;
        float f5 = fArr2[abs];
        return f5 + ((f4 / (f2 - f3)) * (fArr2[i] - f5));
    }
}
