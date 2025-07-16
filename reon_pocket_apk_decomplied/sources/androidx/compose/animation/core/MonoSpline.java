package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000bj\b\u0012\u0004\u0012\u00020\u0003`\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0003J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J8\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J(\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000bj\b\u0012\u0004\u0012\u00020\u0003`\f2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001eH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000bj\b\u0012\u0004\u0012\u00020\u0003`\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000bj\b\u0012\u0004\u0012\u00020\u0003`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/animation/core/MonoSpline;", "", "time", "", "y", "", "([FLjava/util/List;)V", "isExtrapolate", "", "slopeTemp", "tangents", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "timePoints", "values", "copyData", "diff", "", "h", "x", "y1", "y2", "t1", "t2", "getPos", "", "t", "v", "Landroidx/compose/animation/core/AnimationVector;", "j", "", "getSlope", "interpolate", "makeFloatArray", "a", "b", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MonoSpline.kt */
public final class MonoSpline {
    public static final int $stable = 8;
    private final boolean isExtrapolate = true;
    private final float[] slopeTemp;
    private final ArrayList<float[]> tangents;
    private final float[] timePoints;
    private final ArrayList<float[]> values;

    private final float diff(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 * f2;
        float f8 = (float) 6;
        float f9 = f8 * f2;
        float f10 = ((float) 3) * f;
        return (((((((((((float) -6) * f7) * f4) + (f4 * f9)) + ((f8 * f7) * f3)) - (f9 * f3)) + ((f10 * f6) * f7)) + ((f10 * f5) * f7)) - (((((float) 2) * f) * f6) * f2)) - (((((float) 4) * f) * f5) * f2)) + (f * f5);
    }

    private final float interpolate(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 * f2;
        float f8 = f7 * f2;
        float f9 = ((float) 3) * f7;
        float f10 = (((float) -2) * f8 * f4) + (f4 * f9);
        float f11 = (float) 2;
        float f12 = f6 * f;
        float f13 = ((f10 + ((f11 * f8) * f3)) - (f9 * f3)) + f3 + (f12 * f8);
        float f14 = f * f5;
        return (((f13 + (f8 * f14)) - (f12 * f7)) - (((f11 * f) * f5) * f7)) + (f14 * f2);
    }

    public MonoSpline(float[] fArr, List<float[]> list) {
        int i;
        float[] fArr2 = fArr;
        List<float[]> list2 = list;
        int length = fArr2.length;
        int i2 = 0;
        int length2 = list2.get(0).length;
        this.slopeTemp = new float[length2];
        int i3 = length - 1;
        ArrayList<float[]> makeFloatArray = makeFloatArray(i3, length2);
        ArrayList<float[]> makeFloatArray2 = makeFloatArray(length, length2);
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                makeFloatArray.get(i5)[i4] = (list2.get(i6)[i4] - list2.get(i5)[i4]) / (fArr2[i6] - fArr2[i5]);
                if (i5 == 0) {
                    makeFloatArray2.get(i5)[i4] = makeFloatArray.get(i5)[i4];
                } else {
                    makeFloatArray2.get(i5)[i4] = (makeFloatArray.get(i5 - 1)[i4] + makeFloatArray.get(i5)[i4]) * 0.5f;
                }
                i5 = i6;
            }
            makeFloatArray2.get(i3)[i4] = makeFloatArray.get(length - 2)[i4];
        }
        int i7 = 0;
        while (i7 < i3) {
            int i8 = i2;
            while (i8 < length2) {
                if (makeFloatArray.get(i7)[i8] == 0.0f) {
                    makeFloatArray2.get(i7)[i8] = 0.0f;
                    makeFloatArray2.get(i7 + 1)[i8] = 0.0f;
                    i = length2;
                } else {
                    float f = makeFloatArray2.get(i7)[i8] / makeFloatArray.get(i7)[i8];
                    int i9 = i7 + 1;
                    float f2 = makeFloatArray2.get(i9)[i8] / makeFloatArray.get(i7)[i8];
                    i = length2;
                    float hypot = (float) Math.hypot((double) f, (double) f2);
                    if (((double) hypot) > 9.0d) {
                        float f3 = 3.0f / hypot;
                        makeFloatArray2.get(i7)[i8] = f * f3 * makeFloatArray.get(i7)[i8];
                        makeFloatArray2.get(i9)[i8] = f3 * f2 * makeFloatArray.get(i7)[i8];
                    }
                }
                i8++;
                length2 = i;
            }
            int i10 = length2;
            i7++;
            i2 = 0;
        }
        this.timePoints = fArr2;
        this.values = copyData(list2);
        this.tangents = makeFloatArray2;
    }

    private final ArrayList<float[]> makeFloatArray(int i, int i2) {
        ArrayList<float[]> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < i; i3++) {
            arrayList.add(new float[i2]);
        }
        return arrayList;
    }

    private final ArrayList<float[]> copyData(List<float[]> list) {
        ArrayList<float[]> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        return arrayList;
    }

    public final void getPos(float f, float[] fArr) {
        int length = this.timePoints.length;
        int i = 0;
        int length2 = this.values.get(0).length;
        if (this.isExtrapolate) {
            float[] fArr2 = this.timePoints;
            float f2 = fArr2[0];
            if (f <= f2) {
                getSlope(f2, this.slopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = this.values.get(0)[i2] + ((f - this.timePoints[0]) * this.slopeTemp[i2]);
                }
                return;
            }
            int i3 = length - 1;
            float f3 = fArr2[i3];
            if (f >= f3) {
                getSlope(f3, this.slopeTemp);
                while (i < length2) {
                    fArr[i] = this.values.get(i3)[i] + ((f - this.timePoints[i3]) * this.slopeTemp[i]);
                    i++;
                }
                return;
            }
        } else {
            float[] fArr3 = this.timePoints;
            if (f <= fArr3[0]) {
                for (int i4 = 0; i4 < length2; i4++) {
                    fArr[i4] = this.values.get(0)[i4];
                }
                return;
            }
            int i5 = length - 1;
            if (f >= fArr3[i5]) {
                while (i < length2) {
                    fArr[i] = this.values.get(i5)[i];
                    i++;
                }
                return;
            }
        }
        int i6 = length - 1;
        int i7 = 0;
        while (i7 < i6) {
            if (f == this.timePoints[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = this.values.get(i7)[i8];
                }
            }
            float[] fArr4 = this.timePoints;
            int i9 = i7 + 1;
            float f4 = fArr4[i9];
            if (f < f4) {
                float f5 = fArr4[i7];
                float f6 = f4 - f5;
                float f7 = (f - f5) / f6;
                for (int i10 = 0; i10 < length2; i10++) {
                    fArr[i10] = interpolate(f6, f7, this.values.get(i7)[i10], this.values.get(i9)[i10], this.tangents.get(i7)[i10], this.tangents.get(i9)[i10]);
                }
                return;
            }
            i7 = i9;
        }
    }

    public final float getPos(float f, int i) {
        float f2;
        float f3;
        float slope;
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i2 = 0;
        if (this.isExtrapolate) {
            if (f <= fArr[0]) {
                f2 = this.values.get(0)[i];
                float f4 = this.timePoints[0];
                f3 = f - f4;
                slope = getSlope(f4, i);
            } else {
                int i3 = length - 1;
                if (f >= fArr[i3]) {
                    f2 = this.values.get(i3)[i];
                    float f5 = this.timePoints[i3];
                    f3 = f - f5;
                    slope = getSlope(f5, i);
                }
            }
            return f2 + (f3 * slope);
        } else if (f <= fArr[0]) {
            return this.values.get(0)[i];
        } else {
            int i4 = length - 1;
            if (f >= fArr[i4]) {
                return this.values.get(i4)[i];
            }
        }
        int i5 = length - 1;
        while (i2 < i5) {
            float[] fArr2 = this.timePoints;
            float f6 = fArr2[i2];
            if (f == f6) {
                return this.values.get(i2)[i];
            }
            int i6 = i2 + 1;
            float f7 = fArr2[i6];
            if (f < f7) {
                float f8 = f7 - f6;
                return interpolate(f8, (f - f6) / f8, this.values.get(i2)[i], this.values.get(i6)[i], this.tangents.get(i2)[i], this.tangents.get(i6)[i]);
            }
            i2 = i6;
        }
        return 0.0f;
    }

    public final void getPos(float f, AnimationVector animationVector) {
        AnimationVector animationVector2 = animationVector;
        int length = this.timePoints.length;
        int i = 0;
        int length2 = this.values.get(0).length;
        if (this.isExtrapolate) {
            float[] fArr = this.timePoints;
            float f2 = fArr[0];
            if (f <= f2) {
                getSlope(f2, this.slopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    animationVector2.set$animation_core_release(i2, this.values.get(0)[i2] + ((f - this.timePoints[0]) * this.slopeTemp[i2]));
                }
                return;
            }
            int i3 = length - 1;
            float f3 = fArr[i3];
            if (f >= f3) {
                getSlope(f3, this.slopeTemp);
                while (i < length2) {
                    animationVector2.set$animation_core_release(i, this.values.get(i3)[i] + ((f - this.timePoints[i3]) * this.slopeTemp[i]));
                    i++;
                }
                return;
            }
        } else {
            float[] fArr2 = this.timePoints;
            if (f <= fArr2[0]) {
                for (int i4 = 0; i4 < length2; i4++) {
                    animationVector2.set$animation_core_release(i4, this.values.get(0)[i4]);
                }
                return;
            }
            int i5 = length - 1;
            if (f >= fArr2[i5]) {
                while (i < length2) {
                    animationVector2.set$animation_core_release(i, this.values.get(i5)[i]);
                    i++;
                }
                return;
            }
        }
        int i6 = length - 1;
        int i7 = 0;
        while (i7 < i6) {
            if (f == this.timePoints[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    animationVector2.set$animation_core_release(i8, this.values.get(i7)[i8]);
                }
            }
            float[] fArr3 = this.timePoints;
            int i9 = i7 + 1;
            float f4 = fArr3[i9];
            if (f < f4) {
                float f5 = fArr3[i7];
                float f6 = f4 - f5;
                float f7 = (f - f5) / f6;
                for (int i10 = 0; i10 < length2; i10++) {
                    animationVector2.set$animation_core_release(i10, interpolate(f6, f7, this.values.get(i7)[i10], this.values.get(i9)[i10], this.tangents.get(i7)[i10], this.tangents.get(i9)[i10]));
                }
                return;
            }
            i7 = i9;
        }
    }

    public final void getSlope(float f, float[] fArr) {
        float f2;
        int length = this.timePoints.length;
        int length2 = this.values.get(0).length;
        float[] fArr2 = this.timePoints;
        float f3 = fArr2[0];
        if (f <= f3) {
            f2 = f3;
        } else {
            f2 = fArr2[length - 1];
            if (f < f2) {
                f2 = f;
            }
        }
        int i = length - 1;
        int i2 = 0;
        while (i2 < i) {
            float[] fArr3 = this.timePoints;
            int i3 = i2 + 1;
            float f4 = fArr3[i3];
            if (f2 <= f4) {
                float f5 = fArr3[i2];
                float f6 = f4 - f5;
                float f7 = (f2 - f5) / f6;
                for (int i4 = 0; i4 < length2; i4++) {
                    fArr[i4] = diff(f6, f7, this.values.get(i2)[i4], this.values.get(i3)[i4], this.tangents.get(i2)[i4], this.tangents.get(i3)[i4]) / f6;
                }
                return;
            }
            i2 = i3;
        }
    }

    public final void getSlope(float f, AnimationVector animationVector) {
        float f2;
        int length = this.timePoints.length;
        int length2 = this.values.get(0).length;
        float[] fArr = this.timePoints;
        float f3 = fArr[0];
        if (f <= f3) {
            f2 = f3;
        } else {
            f2 = fArr[length - 1];
            if (f < f2) {
                f2 = f;
            }
        }
        int i = length - 1;
        int i2 = 0;
        while (i2 < i) {
            float[] fArr2 = this.timePoints;
            int i3 = i2 + 1;
            float f4 = fArr2[i3];
            if (f2 <= f4) {
                float f5 = fArr2[i2];
                float f6 = f4 - f5;
                float f7 = (f2 - f5) / f6;
                for (int i4 = 0; i4 < length2; i4++) {
                    animationVector.set$animation_core_release(i4, diff(f6, f7, this.values.get(i2)[i4], this.values.get(i3)[i4], this.tangents.get(i2)[i4], this.tangents.get(i3)[i4]) / f6);
                }
                return;
            }
            AnimationVector animationVector2 = animationVector;
            i2 = i3;
        }
    }

    private final float getSlope(float f, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i2 = 0;
        float f2 = fArr[0];
        if (f < f2) {
            f = f2;
        } else {
            float f3 = fArr[length - 1];
            if (f >= f3) {
                f = f3;
            }
        }
        int i3 = length - 1;
        while (i2 < i3) {
            float[] fArr2 = this.timePoints;
            int i4 = i2 + 1;
            float f4 = fArr2[i4];
            if (f <= f4) {
                float f5 = fArr2[i2];
                float f6 = f4 - f5;
                return diff(f6, (f - f5) / f6, this.values.get(i2)[i], this.values.get(i4)[i], this.tangents.get(i2)[i], this.tangents.get(i4)[i]) / f6;
            }
            i2 = i4;
        }
        return 0.0f;
    }
}
