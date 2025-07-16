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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccountCircle.kt */
public final class AccountCircleKt {
    private static ImageVector _accountCircle;

    public static final ImageVector getAccountCircle(Icons.Outlined outlined) {
        ImageVector imageVector = _accountCircle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = new ImageVector.Builder("Outlined.AccountCircle", Dp.m6614constructorimpl(24.0f), Dp.m6614constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, (DefaultConstructorMarker) null);
        int r22 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r23 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 2.0f);
        pathBuilder.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        pathBuilder.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        pathBuilder.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(7.35f, 18.5f);
        pathBuilder.curveTo(8.66f, 17.56f, 10.26f, 17.0f, 12.0f, 17.0f);
        pathBuilder.reflectiveCurveToRelative(3.34f, 0.56f, 4.65f, 1.5f);
        pathBuilder.curveTo(15.34f, 19.44f, 13.74f, 20.0f, 12.0f, 20.0f);
        pathBuilder.reflectiveCurveTo(8.66f, 19.44f, 7.35f, 18.5f);
        pathBuilder.close();
        pathBuilder.moveTo(18.14f, 17.12f);
        pathBuilder.lineTo(18.14f, 17.12f);
        pathBuilder.curveTo(16.45f, 15.8f, 14.32f, 15.0f, 12.0f, 15.0f);
        pathBuilder.reflectiveCurveToRelative(-4.45f, 0.8f, -6.14f, 2.12f);
        pathBuilder.lineToRelative(0.0f, 0.0f);
        PathBuilder pathBuilder2 = pathBuilder;
        pathBuilder2.curveTo(4.7f, 15.73f, 4.0f, 13.95f, 4.0f, 12.0f);
        pathBuilder2.curveToRelative(0.0f, -4.42f, 3.58f, -8.0f, 8.0f, -8.0f);
        pathBuilder.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
        pathBuilder.curveTo(20.0f, 13.95f, 19.3f, 15.73f, 18.14f, 17.12f);
        pathBuilder.close();
        ImageVector.Builder.m4578addPathoIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r22, r23, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int r39 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r40 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(12.0f, 6.0f);
        pathBuilder3.curveToRelative(-1.93f, 0.0f, -3.5f, 1.57f, -3.5f, 3.5f);
        pathBuilder3.reflectiveCurveTo(10.07f, 13.0f, 12.0f, 13.0f);
        pathBuilder3.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        pathBuilder3.reflectiveCurveTo(13.93f, 6.0f, 12.0f, 6.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(12.0f, 11.0f);
        pathBuilder3.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        pathBuilder3.reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f);
        pathBuilder3.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        pathBuilder3.reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f);
        pathBuilder3.close();
        ImageVector build = ImageVector.Builder.m4578addPathoIyEayM$default(builder, pathBuilder3.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r39, r40, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _accountCircle = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
