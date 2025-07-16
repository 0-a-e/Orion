package androidx.compose.material.icons;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\b\u001a4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\b\u001aN\u0010\u000e\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\t¢\u0006\u0002\b\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"MaterialIconDimension", "", "getMaterialIconDimension$annotations", "()V", "materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "name", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "autoMirror", "", "materialPath", "fillAlpha", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Icons.kt */
public final class IconsKt {
    public static final float MaterialIconDimension = 24.0f;

    public static /* synthetic */ void getMaterialIconDimension$annotations() {
    }

    public static final ImageVector materialIcon(String str, boolean z, Function1<? super ImageVector.Builder, ImageVector.Builder> function1) {
        return function1.invoke(new ImageVector.Builder(str, Dp.m6614constructorimpl(24.0f), Dp.m6614constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, z, 96, (DefaultConstructorMarker) null)).build();
    }

    public static /* synthetic */ ImageVector materialIcon$default(String str, boolean z, Function1 function1, int i, Object obj) {
        Function1 function12 = function1;
        return ((ImageVector.Builder) function1.invoke(new ImageVector.Builder(str, Dp.m6614constructorimpl(24.0f), Dp.m6614constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, (i & 2) != 0 ? false : z, 96, (DefaultConstructorMarker) null))).build();
    }

    /* renamed from: materialPath-YwgOQQI$default  reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m1478materialPathYwgOQQI$default(ImageVector.Builder builder, float f, float f2, int i, Function1 function1, int i2, Object obj) {
        float f3 = (i2 & 1) != 0 ? 1.0f : f;
        float f4 = (i2 & 2) != 0 ? 1.0f : f2;
        int defaultFillType = (i2 & 4) != 0 ? VectorKt.getDefaultFillType() : i;
        int r11 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r12 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return ImageVector.Builder.m4578addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), f3, (Brush) null, f4, 1.0f, r11, r12, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }

    /* renamed from: materialPath-YwgOQQI  reason: not valid java name */
    public static final ImageVector.Builder m1477materialPathYwgOQQI(ImageVector.Builder builder, float f, float f2, int i, Function1<? super PathBuilder, Unit> function1) {
        int i2 = i;
        Brush solidColor = new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r9 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r10 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return ImageVector.Builder.m4578addPathoIyEayM$default(builder, pathBuilder.getNodes(), i2, "", solidColor, f, (Brush) null, f2, 1.0f, r9, r10, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }
}
