package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.PathMeasure;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u001d\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0010J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPathMeasure;", "Landroidx/compose/ui/graphics/PathMeasure;", "internalPathMeasure", "Landroid/graphics/PathMeasure;", "(Landroid/graphics/PathMeasure;)V", "length", "", "getLength", "()F", "positionArray", "", "tangentArray", "getPosition", "Landroidx/compose/ui/geometry/Offset;", "distance", "getPosition-tuRUvjQ", "(F)J", "getSegment", "", "startDistance", "stopDistance", "destination", "Landroidx/compose/ui/graphics/Path;", "startWithMoveTo", "getTangent", "getTangent-tuRUvjQ", "setPath", "", "path", "forceClosed", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPathMeasure.android.kt */
public final class AndroidPathMeasure implements PathMeasure {
    private final PathMeasure internalPathMeasure;
    private float[] positionArray;
    private float[] tangentArray;

    public AndroidPathMeasure(PathMeasure pathMeasure) {
        this.internalPathMeasure = pathMeasure;
    }

    public float getLength() {
        return this.internalPathMeasure.getLength();
    }

    public boolean getSegment(float f, float f2, Path path, boolean z) {
        PathMeasure pathMeasure = this.internalPathMeasure;
        if (path instanceof AndroidPath) {
            return pathMeasure.getSegment(f, f2, ((AndroidPath) path).getInternalPath(), z);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public void setPath(Path path, boolean z) {
        Path path2;
        PathMeasure pathMeasure = this.internalPathMeasure;
        if (path == null) {
            path2 = null;
        } else if (path instanceof AndroidPath) {
            path2 = ((AndroidPath) path).getInternalPath();
        } else {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        pathMeasure.setPath(path2, z);
    }

    /* renamed from: getPosition-tuRUvjQ  reason: not valid java name */
    public long m3702getPositiontuRUvjQ(float f) {
        if (this.positionArray == null) {
            this.positionArray = new float[2];
        }
        if (this.tangentArray == null) {
            this.tangentArray = new float[2];
        }
        if (!this.internalPathMeasure.getPosTan(f, this.positionArray, this.tangentArray)) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        float[] fArr = this.positionArray;
        Intrinsics.checkNotNull(fArr);
        float f2 = fArr[0];
        float[] fArr2 = this.positionArray;
        Intrinsics.checkNotNull(fArr2);
        return OffsetKt.Offset(f2, fArr2[1]);
    }

    /* renamed from: getTangent-tuRUvjQ  reason: not valid java name */
    public long m3703getTangenttuRUvjQ(float f) {
        if (this.positionArray == null) {
            this.positionArray = new float[2];
        }
        if (this.tangentArray == null) {
            this.tangentArray = new float[2];
        }
        if (!this.internalPathMeasure.getPosTan(f, this.positionArray, this.tangentArray)) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        float[] fArr = this.tangentArray;
        Intrinsics.checkNotNull(fArr);
        float f2 = fArr[0];
        float[] fArr2 = this.tangentArray;
        Intrinsics.checkNotNull(fArr2);
        return OffsetKt.Offset(f2, fArr2[1]);
    }
}
