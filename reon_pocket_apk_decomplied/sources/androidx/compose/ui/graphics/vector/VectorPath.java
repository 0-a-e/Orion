package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0002\u0010\u0018J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00101\u001a\u000202H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\b&\u0010\"R\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\b'\u0010\"R\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001c\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPath;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "name", "", "pathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "(Ljava/lang/String;Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "getFillAlpha", "()F", "getName", "()Ljava/lang/String;", "getPathData", "()Ljava/util/List;", "getPathFillType-Rg-k1Os", "()I", "I", "getStroke", "getStrokeAlpha", "getStrokeLineCap-KaPHkGw", "getStrokeLineJoin-LxFBmk8", "getStrokeLineMiter", "getStrokeLineWidth", "getTrimPathEnd", "getTrimPathOffset", "getTrimPathStart", "equals", "", "other", "", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImageVector.kt */
public final class VectorPath extends VectorNode {
    public static final int $stable = 0;
    private final Brush fill;
    private final float fillAlpha;
    private final String name;
    private final List<PathNode> pathData;
    private final int pathFillType;
    private final Brush stroke;
    private final float strokeAlpha;
    private final int strokeLineCap;
    private final int strokeLineJoin;
    private final float strokeLineMiter;
    private final float strokeLineWidth;
    private final float trimPathEnd;
    private final float trimPathOffset;
    private final float trimPathStart;

    public /* synthetic */ VectorPath(String str, List list, int i, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, i, brush, f, brush2, f2, f3, i2, i3, f4, f5, f6, f7);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VectorPath(java.lang.String r19, java.util.List r20, int r21, androidx.compose.ui.graphics.Brush r22, float r23, androidx.compose.ui.graphics.Brush r24, float r25, float r26, int r27, int r28, float r29, float r30, float r31, float r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = ""
            r3 = r1
            goto L_0x000c
        L_0x000a:
            r3 = r19
        L_0x000c:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r6 = r2
            goto L_0x0015
        L_0x0013:
            r6 = r22
        L_0x0015:
            r1 = r0 & 16
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x001d
            r7 = r4
            goto L_0x001f
        L_0x001d:
            r7 = r23
        L_0x001f:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0025
            r8 = r2
            goto L_0x0027
        L_0x0025:
            r8 = r24
        L_0x0027:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002d
            r9 = r4
            goto L_0x002f
        L_0x002d:
            r9 = r25
        L_0x002f:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0036
            r10 = r2
            goto L_0x0038
        L_0x0036:
            r10 = r26
        L_0x0038:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0042
            int r1 = androidx.compose.ui.graphics.vector.VectorKt.getDefaultStrokeLineCap()
            r11 = r1
            goto L_0x0044
        L_0x0042:
            r11 = r27
        L_0x0044:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x004e
            int r1 = androidx.compose.ui.graphics.vector.VectorKt.getDefaultStrokeLineJoin()
            r12 = r1
            goto L_0x0050
        L_0x004e:
            r12 = r28
        L_0x0050:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0058
            r1 = 1082130432(0x40800000, float:4.0)
            r13 = r1
            goto L_0x005a
        L_0x0058:
            r13 = r29
        L_0x005a:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0060
            r14 = r2
            goto L_0x0062
        L_0x0060:
            r14 = r30
        L_0x0062:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0068
            r15 = r4
            goto L_0x006a
        L_0x0068:
            r15 = r31
        L_0x006a:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0071
            r16 = r2
            goto L_0x0073
        L_0x0071:
            r16 = r32
        L_0x0073:
            r17 = 0
            r2 = r18
            r4 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPath.<init>(java.lang.String, java.util.List, int, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getName() {
        return this.name;
    }

    public final List<PathNode> getPathData() {
        return this.pathData;
    }

    /* renamed from: getPathFillType-Rg-k1Os  reason: not valid java name */
    public final int m4610getPathFillTypeRgk1Os() {
        return this.pathFillType;
    }

    public final Brush getFill() {
        return this.fill;
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    public final Brush getStroke() {
        return this.stroke;
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    /* renamed from: getStrokeLineCap-KaPHkGw  reason: not valid java name */
    public final int m4611getStrokeLineCapKaPHkGw() {
        return this.strokeLineCap;
    }

    /* renamed from: getStrokeLineJoin-LxFBmk8  reason: not valid java name */
    public final int m4612getStrokeLineJoinLxFBmk8() {
        return this.strokeLineJoin;
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    private VectorPath(String str, List<? extends PathNode> list, int i, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7) {
        super((DefaultConstructorMarker) null);
        this.name = str;
        this.pathData = list;
        this.pathFillType = i;
        this.fill = brush;
        this.fillAlpha = f;
        this.stroke = brush2;
        this.strokeAlpha = f2;
        this.strokeLineWidth = f3;
        this.strokeLineCap = i2;
        this.strokeLineJoin = i3;
        this.strokeLineMiter = f4;
        this.trimPathStart = f5;
        this.trimPathEnd = f6;
        this.trimPathOffset = f7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            VectorPath vectorPath = (VectorPath) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) vectorPath.name) && Intrinsics.areEqual((Object) this.fill, (Object) vectorPath.fill) && this.fillAlpha == vectorPath.fillAlpha && Intrinsics.areEqual((Object) this.stroke, (Object) vectorPath.stroke) && this.strokeAlpha == vectorPath.strokeAlpha && this.strokeLineWidth == vectorPath.strokeLineWidth && StrokeCap.m4226equalsimpl0(this.strokeLineCap, vectorPath.strokeLineCap) && StrokeJoin.m4236equalsimpl0(this.strokeLineJoin, vectorPath.strokeLineJoin) && this.strokeLineMiter == vectorPath.strokeLineMiter && this.trimPathStart == vectorPath.trimPathStart && this.trimPathEnd == vectorPath.trimPathEnd && this.trimPathOffset == vectorPath.trimPathOffset && PathFillType.m4124equalsimpl0(this.pathFillType, vectorPath.pathFillType) && Intrinsics.areEqual((Object) this.pathData, (Object) vectorPath.pathData);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.pathData.hashCode()) * 31;
        Brush brush = this.fill;
        int i = 0;
        int hashCode2 = (((hashCode + (brush != null ? brush.hashCode() : 0)) * 31) + Float.floatToIntBits(this.fillAlpha)) * 31;
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            i = brush2.hashCode();
        }
        return ((((((((((((((((((hashCode2 + i) * 31) + Float.floatToIntBits(this.strokeAlpha)) * 31) + Float.floatToIntBits(this.strokeLineWidth)) * 31) + StrokeCap.m4227hashCodeimpl(this.strokeLineCap)) * 31) + StrokeJoin.m4237hashCodeimpl(this.strokeLineJoin)) * 31) + Float.floatToIntBits(this.strokeLineMiter)) * 31) + Float.floatToIntBits(this.trimPathStart)) * 31) + Float.floatToIntBits(this.trimPathEnd)) * 31) + Float.floatToIntBits(this.trimPathOffset)) * 31) + PathFillType.m4125hashCodeimpl(this.pathFillType);
    }
}
