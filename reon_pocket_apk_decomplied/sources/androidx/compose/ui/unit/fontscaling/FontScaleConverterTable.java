package androidx.compose.ui.unit.fontscaling;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "fromSp", "", "toDp", "([F[F)V", "mFromSpValues", "getMFromSpValues$annotations", "()V", "getMFromSpValues", "()[F", "mToDpValues", "getMToDpValues$annotations", "getMToDpValues", "convertDpToSp", "", "dp", "convertSpToDp", "sp", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontScaleConverterTable.android.kt */
public final class FontScaleConverterTable implements FontScaleConverter {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final float[] mFromSpValues;
    private final float[] mToDpValues;

    public static /* synthetic */ void getMFromSpValues$annotations() {
    }

    public static /* synthetic */ void getMToDpValues$annotations() {
    }

    public FontScaleConverterTable(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero".toString());
        }
        this.mFromSpValues = fArr;
        this.mToDpValues = fArr2;
    }

    public final float[] getMFromSpValues() {
        return this.mFromSpValues;
    }

    public final float[] getMToDpValues() {
        return this.mToDpValues;
    }

    public float convertDpToSp(float f) {
        return Companion.lookupAndInterpolate(f, this.mToDpValues, this.mFromSpValues);
    }

    public float convertSpToDp(float f) {
        return Companion.lookupAndInterpolate(f, this.mFromSpValues, this.mToDpValues);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FontScaleConverterTable)) {
            return false;
        }
        FontScaleConverterTable fontScaleConverterTable = (FontScaleConverterTable) obj;
        if (!Arrays.equals(this.mFromSpValues, fontScaleConverterTable.mFromSpValues) || !Arrays.equals(this.mToDpValues, fontScaleConverterTable.mToDpValues)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.mFromSpValues) * 31) + Arrays.hashCode(this.mToDpValues);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FontScaleConverter{fromSpValues=");
        String arrays = Arrays.toString(this.mFromSpValues);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        sb.append(", toDpValues=");
        String arrays2 = Arrays.toString(this.mToDpValues);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        sb.append(arrays2);
        sb.append('}');
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable$Companion;", "", "()V", "lookupAndInterpolate", "", "sourceValue", "sourceValues", "", "targetValues", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontScaleConverterTable.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final float lookupAndInterpolate(float f, float[] fArr, float[] fArr2) {
            float f2;
            float f3;
            float f4;
            float constrainedMap;
            float abs = Math.abs(f);
            float signum = Math.signum(f);
            int binarySearch = Arrays.binarySearch(fArr, abs);
            if (binarySearch >= 0) {
                constrainedMap = fArr2[binarySearch];
            } else {
                int i = -(binarySearch + 1);
                int i2 = i - 1;
                float f5 = 0.0f;
                if (i2 >= fArr.length - 1) {
                    float f6 = fArr[fArr.length - 1];
                    float f7 = fArr2[fArr.length - 1];
                    if (f6 == 0.0f) {
                        return 0.0f;
                    }
                    return f * (f7 / f6);
                }
                if (i2 == -1) {
                    float f8 = fArr[0];
                    f3 = fArr2[0];
                    f2 = f8;
                    f4 = 0.0f;
                } else {
                    float f9 = fArr[i2];
                    float f10 = fArr[i];
                    f4 = fArr2[i2];
                    f5 = f9;
                    f2 = f10;
                    f3 = fArr2[i];
                }
                constrainedMap = MathUtils.INSTANCE.constrainedMap(f4, f3, f5, f2, abs);
            }
            return signum * constrainedMap;
        }
    }
}
