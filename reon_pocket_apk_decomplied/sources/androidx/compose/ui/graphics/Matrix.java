package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@JvmInline
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 G2\u00020\u0001:\u0001GB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u001b\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020$¢\u0006\u0004\b\u001e\u0010%J\r\u0010&\u001a\u00020\u0018¢\u0006\u0004\b'\u0010\u001aJ\u0015\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b-\u0010+J\u0015\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b/\u0010+J+\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u000eH\n¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001b\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ+\u0010E\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\bF\u00105R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "", "row", "", "column", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "invert", "", "invert-impl", "([F)V", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "map-impl", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "reset", "reset-impl", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", "scale", "x", "y", "z", "scale-impl", "([FFFF)V", "set", "v", "set-impl", "([FIIF)V", "setFrom", "matrix", "setFrom-58bKbWc", "([F[F)V", "timesAssign", "m", "timesAssign-58bKbWc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "translate", "translate-impl", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Matrix.kt */
public final class Matrix {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Matrix m4056boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float[] m4057constructorimpl(float[] fArr) {
        return fArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4059equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual((Object) fArr, (Object) ((Matrix) obj).m4079unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4060equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual((Object) fArr, (Object) fArr2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4062hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public boolean equals(Object obj) {
        return m4059equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m4062hashCodeimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float[] m4079unboximpl() {
        return this.values;
    }

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    public final float[] getValues() {
        return this.values;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ float[] m4058constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m4057constructorimpl(fArr);
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final float m4061getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 4) + i2];
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m4073setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 4) + i2] = f;
    }

    /* renamed from: map-MK-Hz9U  reason: not valid java name */
    public static final long m4064mapMKHz9U(float[] fArr, long j) {
        float r0 = Offset.m3562getXimpl(j);
        float r5 = Offset.m3563getYimpl(j);
        float f = ((float) 1) / (((fArr[3] * r0) + (fArr[7] * r5)) + fArr[15]);
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            f = 0.0f;
        }
        return OffsetKt.Offset(((fArr[0] * r0) + (fArr[4] * r5) + fArr[12]) * f, f * ((fArr[1] * r0) + (fArr[5] * r5) + fArr[13]));
    }

    /* renamed from: map-impl  reason: not valid java name */
    public static final Rect m4065mapimpl(float[] fArr, Rect rect) {
        long r0 = m4064mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long r2 = m4064mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long r4 = m4064mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long r11 = m4064mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        return new Rect(Math.min(Math.min(Offset.m3562getXimpl(r0), Offset.m3562getXimpl(r2)), Math.min(Offset.m3562getXimpl(r4), Offset.m3562getXimpl(r11))), Math.min(Math.min(Offset.m3563getYimpl(r0), Offset.m3563getYimpl(r2)), Math.min(Offset.m3563getYimpl(r4), Offset.m3563getYimpl(r11))), Math.max(Math.max(Offset.m3562getXimpl(r0), Offset.m3562getXimpl(r2)), Math.max(Offset.m3562getXimpl(r4), Offset.m3562getXimpl(r11))), Math.max(Math.max(Offset.m3563getYimpl(r0), Offset.m3563getYimpl(r2)), Math.max(Offset.m3563getYimpl(r4), Offset.m3563getYimpl(r11))));
    }

    /* renamed from: map-impl  reason: not valid java name */
    public static final void m4066mapimpl(float[] fArr, MutableRect mutableRect) {
        long r0 = m4064mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getTop()));
        long r2 = m4064mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getBottom()));
        long r4 = m4064mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getTop()));
        long r6 = m4064mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getBottom()));
        mutableRect.setLeft(Math.min(Math.min(Offset.m3562getXimpl(r0), Offset.m3562getXimpl(r2)), Math.min(Offset.m3562getXimpl(r4), Offset.m3562getXimpl(r6))));
        mutableRect.setTop(Math.min(Math.min(Offset.m3563getYimpl(r0), Offset.m3563getYimpl(r2)), Math.min(Offset.m3563getYimpl(r4), Offset.m3563getYimpl(r6))));
        mutableRect.setRight(Math.max(Math.max(Offset.m3562getXimpl(r0), Offset.m3562getXimpl(r2)), Math.max(Offset.m3562getXimpl(r4), Offset.m3562getXimpl(r6))));
        mutableRect.setBottom(Math.max(Math.max(Offset.m3563getYimpl(r0), Offset.m3563getYimpl(r2)), Math.max(Offset.m3563getYimpl(r4), Offset.m3563getYimpl(r6))));
    }

    /* renamed from: timesAssign-58bKbWc  reason: not valid java name */
    public static final void m4075timesAssign58bKbWc(float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        float r3 = MatrixKt.m4081dotp89u6pk(fArr3, 0, fArr4, 0);
        float r5 = MatrixKt.m4081dotp89u6pk(fArr3, 0, fArr4, 1);
        float r7 = MatrixKt.m4081dotp89u6pk(fArr3, 0, fArr4, 2);
        float r9 = MatrixKt.m4081dotp89u6pk(fArr3, 0, fArr4, 3);
        float r10 = MatrixKt.m4081dotp89u6pk(fArr3, 1, fArr4, 0);
        float r11 = MatrixKt.m4081dotp89u6pk(fArr3, 1, fArr4, 1);
        float r12 = MatrixKt.m4081dotp89u6pk(fArr3, 1, fArr4, 2);
        float r13 = MatrixKt.m4081dotp89u6pk(fArr3, 1, fArr4, 3);
        float r14 = MatrixKt.m4081dotp89u6pk(fArr3, 2, fArr4, 0);
        float r15 = MatrixKt.m4081dotp89u6pk(fArr3, 2, fArr4, 1);
        float r16 = MatrixKt.m4081dotp89u6pk(fArr3, 2, fArr4, 2);
        float r17 = MatrixKt.m4081dotp89u6pk(fArr3, 2, fArr4, 3);
        float r18 = MatrixKt.m4081dotp89u6pk(fArr3, 3, fArr4, 0);
        float r19 = MatrixKt.m4081dotp89u6pk(fArr3, 3, fArr4, 1);
        float r20 = MatrixKt.m4081dotp89u6pk(fArr3, 3, fArr4, 2);
        float r1 = MatrixKt.m4081dotp89u6pk(fArr3, 3, fArr4, 3);
        fArr3[0] = r3;
        fArr3[1] = r5;
        fArr3[2] = r7;
        fArr3[3] = r9;
        fArr3[4] = r10;
        fArr3[5] = r11;
        fArr3[6] = r12;
        fArr3[7] = r13;
        fArr3[8] = r14;
        fArr3[9] = r15;
        fArr3[10] = r16;
        fArr3[11] = r17;
        fArr3[12] = r18;
        fArr3[13] = r19;
        fArr3[14] = r20;
        fArr3[15] = r1;
    }

    public String toString() {
        return m4076toStringimpl(this.values);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4076toStringimpl(float[] fArr) {
        return StringsKt.trimIndent("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    /* renamed from: setFrom-58bKbWc  reason: not valid java name */
    public static final void m4074setFrom58bKbWc(float[] fArr, float[] fArr2) {
        for (int i = 0; i < 16; i++) {
            fArr[i] = fArr2[i];
        }
    }

    /* renamed from: rotateX-impl  reason: not valid java name */
    public static final void m4068rotateXimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[5];
        float f5 = fArr[6];
        float f6 = fArr[9];
        float f7 = fArr[10];
        float f8 = fArr[13];
        float f9 = fArr[14];
        fArr[1] = (f2 * cos) - (f3 * sin);
        fArr[2] = (f2 * sin) + (f3 * cos);
        fArr[5] = (f4 * cos) - (f5 * sin);
        fArr[6] = (f4 * sin) + (f5 * cos);
        fArr[9] = (f6 * cos) - (f7 * sin);
        fArr[10] = (f6 * sin) + (f7 * cos);
        fArr[13] = (f8 * cos) - (f9 * sin);
        fArr[14] = (f8 * sin) + (f9 * cos);
    }

    /* renamed from: rotateY-impl  reason: not valid java name */
    public static final void m4069rotateYimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f2 = fArr[0];
        float f3 = fArr[2];
        float f4 = fArr[4];
        float f5 = fArr[6];
        float f6 = fArr[8];
        float f7 = fArr[10];
        float f8 = fArr[12];
        float f9 = fArr[14];
        fArr[0] = (f2 * cos) + (f3 * sin);
        fArr[2] = ((-f2) * sin) + (f3 * cos);
        fArr[4] = (f4 * cos) + (f5 * sin);
        fArr[6] = ((-f4) * sin) + (f5 * cos);
        fArr[8] = (f6 * cos) + (f7 * sin);
        fArr[10] = ((-f6) * sin) + (f7 * cos);
        fArr[12] = (f8 * cos) + (f9 * sin);
        fArr[14] = ((-f8) * sin) + (f9 * cos);
    }

    /* renamed from: rotateZ-impl  reason: not valid java name */
    public static final void m4070rotateZimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f2 = fArr[0];
        float f3 = fArr[4];
        float f4 = -sin;
        float f5 = fArr[1];
        float f6 = fArr[5];
        float f7 = fArr[2];
        float f8 = fArr[6];
        float f9 = fArr[3];
        float f10 = fArr[7];
        fArr[0] = (cos * f2) + (sin * f3);
        fArr[1] = (cos * f5) + (sin * f6);
        fArr[2] = (cos * f7) + (sin * f8);
        fArr[3] = (cos * f9) + (sin * f10);
        fArr[4] = (f2 * f4) + (f3 * cos);
        fArr[5] = (f5 * f4) + (f6 * cos);
        fArr[6] = (f7 * f4) + (f8 * cos);
        fArr[7] = (f4 * f9) + (cos * f10);
    }

    /* renamed from: scale-impl$default  reason: not valid java name */
    public static /* synthetic */ void m4072scaleimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        m4071scaleimpl(fArr, f, f2, f3);
    }

    /* renamed from: translate-impl$default  reason: not valid java name */
    public static /* synthetic */ void m4078translateimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        m4077translateimpl(fArr, f, f2, f3);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/Matrix$Companion;", "", "()V", "Perspective0", "", "Perspective1", "Perspective2", "ScaleX", "ScaleY", "ScaleZ", "SkewX", "SkewY", "TranslateX", "TranslateY", "TranslateZ", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Matrix.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: invert-impl  reason: not valid java name */
    public static final void m4063invertimpl(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        float f10 = fArr[9];
        float f11 = fArr[10];
        float f12 = fArr[11];
        float f13 = fArr[12];
        float f14 = fArr[13];
        float f15 = fArr[14];
        float f16 = fArr[15];
        float f17 = (f * f6) - (f2 * f5);
        float f18 = (f * f7) - (f3 * f5);
        float f19 = (f * f8) - (f4 * f5);
        float f20 = (f2 * f7) - (f3 * f6);
        float f21 = (f2 * f8) - (f4 * f6);
        float f22 = (f3 * f8) - (f4 * f7);
        float f23 = (f9 * f14) - (f10 * f13);
        float f24 = (f9 * f15) - (f11 * f13);
        float f25 = (f9 * f16) - (f12 * f13);
        float f26 = (f10 * f15) - (f11 * f14);
        float f27 = (f10 * f16) - (f12 * f14);
        float f28 = (f11 * f16) - (f12 * f15);
        float f29 = (((((f17 * f28) - (f18 * f27)) + (f19 * f26)) + (f20 * f25)) - (f21 * f24)) + (f22 * f23);
        if (f29 != 0.0f) {
            float f30 = 1.0f / f29;
            fArr[0] = (((f6 * f28) - (f7 * f27)) + (f8 * f26)) * f30;
            fArr[1] = ((((-f2) * f28) + (f3 * f27)) - (f4 * f26)) * f30;
            fArr[2] = (((f14 * f22) - (f15 * f21)) + (f16 * f20)) * f30;
            fArr[3] = ((((-f10) * f22) + (f11 * f21)) - (f12 * f20)) * f30;
            float f31 = -f5;
            fArr[4] = (((f31 * f28) + (f7 * f25)) - (f8 * f24)) * f30;
            fArr[5] = (((f28 * f) - (f3 * f25)) + (f4 * f24)) * f30;
            float f32 = -f13;
            fArr[6] = (((f32 * f22) + (f15 * f19)) - (f16 * f18)) * f30;
            fArr[7] = (((f22 * f9) - (f11 * f19)) + (f12 * f18)) * f30;
            fArr[8] = (((f5 * f27) - (f6 * f25)) + (f8 * f23)) * f30;
            fArr[9] = ((((-f) * f27) + (f25 * f2)) - (f4 * f23)) * f30;
            fArr[10] = (((f13 * f21) - (f14 * f19)) + (f16 * f17)) * f30;
            fArr[11] = ((((-f9) * f21) + (f19 * f10)) - (f12 * f17)) * f30;
            fArr[12] = (((f31 * f26) + (f6 * f24)) - (f7 * f23)) * f30;
            fArr[13] = (((f * f26) - (f2 * f24)) + (f3 * f23)) * f30;
            fArr[14] = (((f32 * f20) + (f14 * f18)) - (f15 * f17)) * f30;
            fArr[15] = (((f9 * f20) - (f10 * f18)) + (f11 * f17)) * f30;
        }
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static final void m4067resetimpl(float[] fArr) {
        int i = 0;
        while (i < 4) {
            int i2 = 0;
            while (i2 < 4) {
                fArr[(i2 * 4) + i] = i == i2 ? 1.0f : 0.0f;
                i2++;
            }
            i++;
        }
    }

    /* renamed from: scale-impl  reason: not valid java name */
    public static final void m4071scaleimpl(float[] fArr, float f, float f2, float f3) {
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
        fArr[3] = fArr[3] * f;
        fArr[4] = fArr[4] * f2;
        fArr[5] = fArr[5] * f2;
        fArr[6] = fArr[6] * f2;
        fArr[7] = fArr[7] * f2;
        fArr[8] = fArr[8] * f3;
        fArr[9] = fArr[9] * f3;
        fArr[10] = fArr[10] * f3;
        fArr[11] = fArr[11] * f3;
    }

    /* renamed from: translate-impl  reason: not valid java name */
    public static final void m4077translateimpl(float[] fArr, float f, float f2, float f3) {
        float f4 = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
        float f5 = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
        float f6 = (fArr[2] * f) + (fArr[6] * f2) + (fArr[10] * f3) + fArr[14];
        fArr[12] = f4;
        fArr[13] = f5;
        fArr[14] = f6;
        fArr[15] = (fArr[3] * f) + (fArr[7] * f2) + (fArr[11] * f3) + fArr[15];
    }
}
