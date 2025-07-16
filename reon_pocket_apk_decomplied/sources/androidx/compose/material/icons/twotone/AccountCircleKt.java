package androidx.compose.material.icons.twotone;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccountCircle.kt */
public final class AccountCircleKt {
    private static ImageVector _accountCircle;

    public static final ImageVector getAccountCircle(Icons.TwoTone twoTone) {
        ImageVector imageVector = _accountCircle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = r1;
        ImageVector.Builder builder4 = new ImageVector.Builder("TwoTone.AccountCircle", Dp.m6614constructorimpl(24.0f), Dp.m6614constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, (DefaultConstructorMarker) null);
        int r22 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r23 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 4.0f);
        PathBuilder pathBuilder2 = pathBuilder;
        pathBuilder2.curveToRelative(-4.42f, 0.0f, -8.0f, 3.58f, -8.0f, 8.0f);
        pathBuilder2.curveToRelative(0.0f, 1.95f, 0.7f, 3.73f, 1.86f, 5.12f);
        pathBuilder2.curveTo(7.55f, 15.8f, 9.68f, 15.0f, 12.0f, 15.0f);
        pathBuilder.reflectiveCurveToRelative(4.45f, 0.8f, 6.14f, 2.12f);
        PathBuilder pathBuilder3 = pathBuilder;
        pathBuilder3.curveTo(19.3f, 15.73f, 20.0f, 13.95f, 20.0f, 12.0f);
        pathBuilder3.curveTo(20.0f, 7.58f, 16.42f, 4.0f, 12.0f, 4.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 13.0f);
        PathBuilder pathBuilder4 = pathBuilder;
        pathBuilder4.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        pathBuilder4.curveTo(8.5f, 7.57f, 10.07f, 6.0f, 12.0f, 6.0f);
        pathBuilder.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        pathBuilder.curveTo(15.5f, 11.43f, 13.93f, 13.0f, 12.0f, 13.0f);
        pathBuilder.close();
        ImageVector.Builder.m4578addPathoIyEayM$default(builder3, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 0.3f, (Brush) null, 0.3f, 1.0f, r22, r23, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int r39 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r40 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder5 = new PathBuilder();
        pathBuilder5.moveTo(12.0f, 2.0f);
        PathBuilder pathBuilder6 = pathBuilder5;
        pathBuilder6.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder6.curveToRelative(0.0f, 5.52f, 4.48f, 10.0f, 10.0f, 10.0f);
        pathBuilder5.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        pathBuilder5.curveTo(22.0f, 6.48f, 17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder5.close();
        pathBuilder5.moveTo(12.0f, 20.0f);
        PathBuilder pathBuilder7 = pathBuilder5;
        pathBuilder7.curveToRelative(-1.74f, 0.0f, -3.34f, -0.56f, -4.65f, -1.5f);
        pathBuilder7.curveTo(8.66f, 17.56f, 10.26f, 17.0f, 12.0f, 17.0f);
        pathBuilder5.reflectiveCurveToRelative(3.34f, 0.56f, 4.65f, 1.5f);
        pathBuilder5.curveTo(15.34f, 19.44f, 13.74f, 20.0f, 12.0f, 20.0f);
        pathBuilder5.close();
        pathBuilder5.moveTo(18.14f, 17.12f);
        pathBuilder5.curveTo(16.45f, 15.8f, 14.32f, 15.0f, 12.0f, 15.0f);
        pathBuilder5.reflectiveCurveToRelative(-4.45f, 0.8f, -6.14f, 2.12f);
        PathBuilder pathBuilder8 = pathBuilder5;
        pathBuilder8.curveTo(4.7f, 15.73f, 4.0f, 13.95f, 4.0f, 12.0f);
        pathBuilder8.curveToRelative(0.0f, -4.42f, 3.58f, -8.0f, 8.0f, -8.0f);
        pathBuilder5.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
        pathBuilder5.curveTo(20.0f, 13.95f, 19.3f, 15.73f, 18.14f, 17.12f);
        pathBuilder5.close();
        ImageVector.Builder.m4578addPathoIyEayM$default(builder2, pathBuilder5.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r39, r40, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int r56 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r57 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder9 = new PathBuilder();
        pathBuilder9.moveTo(12.0f, 5.93f);
        PathBuilder pathBuilder10 = pathBuilder9;
        pathBuilder10.curveToRelative(-1.93f, 0.0f, -3.5f, 1.57f, -3.5f, 3.5f);
        pathBuilder10.curveToRelative(0.0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        pathBuilder9.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        pathBuilder9.curveTo(15.5f, 7.5f, 13.93f, 5.93f, 12.0f, 5.93f);
        pathBuilder9.close();
        pathBuilder9.moveTo(12.0f, 10.93f);
        pathBuilder9.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        pathBuilder9.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        pathBuilder9.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        pathBuilder9.reflectiveCurveTo(12.83f, 10.93f, 12.0f, 10.93f);
        pathBuilder9.close();
        ImageVector build = ImageVector.Builder.m4578addPathoIyEayM$default(builder, pathBuilder9.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r56, r57, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _accountCircle = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
