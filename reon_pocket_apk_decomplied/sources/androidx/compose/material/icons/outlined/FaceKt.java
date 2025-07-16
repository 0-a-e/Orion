package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_face", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face", "Landroidx/compose/material/icons/Icons$Outlined;", "getFace", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Face.kt */
public final class FaceKt {
    private static ImageVector _face;

    public static final ImageVector getFace(Icons.Outlined outlined) {
        ImageVector imageVector = _face;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.Face", Dp.m6614constructorimpl(24.0f), Dp.m6614constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, (DefaultConstructorMarker) null);
        int r22 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r23 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(10.25f, 13.0f);
        pathBuilder.curveToRelative(0.0f, 0.69f, -0.56f, 1.25f, -1.25f, 1.25f);
        pathBuilder.reflectiveCurveTo(7.75f, 13.69f, 7.75f, 13.0f);
        pathBuilder.reflectiveCurveToRelative(0.56f, -1.25f, 1.25f, -1.25f);
        pathBuilder.reflectiveCurveToRelative(1.25f, 0.56f, 1.25f, 1.25f);
        pathBuilder.close();
        pathBuilder.moveTo(15.0f, 11.75f);
        pathBuilder.curveToRelative(-0.69f, 0.0f, -1.25f, 0.56f, -1.25f, 1.25f);
        pathBuilder.reflectiveCurveToRelative(0.56f, 1.25f, 1.25f, 1.25f);
        pathBuilder.reflectiveCurveToRelative(1.25f, -0.56f, 1.25f, -1.25f);
        pathBuilder.reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f);
        pathBuilder.close();
        pathBuilder.moveTo(22.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, 5.52f, -4.48f, 10.0f, -10.0f, 10.0f);
        pathBuilder.reflectiveCurveTo(2.0f, 17.52f, 2.0f, 12.0f);
        pathBuilder.reflectiveCurveTo(6.48f, 2.0f, 12.0f, 2.0f);
        pathBuilder.reflectiveCurveToRelative(10.0f, 4.48f, 10.0f, 10.0f);
        pathBuilder.close();
        pathBuilder.moveTo(10.66f, 4.12f);
        PathBuilder pathBuilder2 = pathBuilder;
        pathBuilder2.curveTo(12.06f, 6.44f, 14.6f, 8.0f, 17.5f, 8.0f);
        pathBuilder2.curveToRelative(0.46f, 0.0f, 0.91f, -0.05f, 1.34f, -0.12f);
        pathBuilder2.curveTo(17.44f, 5.56f, 14.9f, 4.0f, 12.0f, 4.0f);
        pathBuilder2.curveToRelative(-0.46f, 0.0f, -0.91f, 0.05f, -1.34f, 0.12f);
        pathBuilder.close();
        pathBuilder.moveTo(4.42f, 9.47f);
        PathBuilder pathBuilder3 = pathBuilder;
        pathBuilder3.curveToRelative(1.71f, -0.97f, 3.03f, -2.55f, 3.66f, -4.44f);
        pathBuilder3.curveTo(6.37f, 6.0f, 5.05f, 7.58f, 4.42f, 9.47f);
        pathBuilder.close();
        pathBuilder.moveTo(20.0f, 12.0f);
        PathBuilder pathBuilder4 = pathBuilder;
        pathBuilder4.curveToRelative(0.0f, -0.78f, -0.12f, -1.53f, -0.33f, -2.24f);
        pathBuilder4.curveToRelative(-0.7f, 0.15f, -1.42f, 0.24f, -2.17f, 0.24f);
        pathBuilder4.curveToRelative(-3.13f, 0.0f, -5.92f, -1.44f, -7.76f, -3.69f);
        pathBuilder4.curveTo(8.69f, 8.87f, 6.6f, 10.88f, 4.0f, 11.86f);
        pathBuilder4.curveToRelative(0.01f, 0.04f, 0.0f, 0.09f, 0.0f, 0.14f);
        pathBuilder4.curveToRelative(0.0f, 4.41f, 3.59f, 8.0f, 8.0f, 8.0f);
        pathBuilder.reflectiveCurveToRelative(8.0f, -3.59f, 8.0f, -8.0f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.m4578addPathoIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r22, r23, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _face = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
