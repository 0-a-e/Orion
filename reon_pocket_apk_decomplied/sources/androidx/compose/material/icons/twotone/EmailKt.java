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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_email", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Email", "Landroidx/compose/material/icons/Icons$TwoTone;", "getEmail", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Email.kt */
public final class EmailKt {
    private static ImageVector _email;

    public static final ImageVector getEmail(Icons.TwoTone twoTone) {
        ImageVector imageVector = _email;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = new ImageVector.Builder("TwoTone.Email", Dp.m6614constructorimpl(24.0f), Dp.m6614constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, (DefaultConstructorMarker) null);
        int r22 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r23 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(20.0f, 8.0f);
        pathBuilder.lineToRelative(-8.0f, 5.0f);
        pathBuilder.lineToRelative(-8.0f, -5.0f);
        pathBuilder.verticalLineToRelative(10.0f);
        pathBuilder.horizontalLineToRelative(16.0f);
        pathBuilder.close();
        pathBuilder.moveTo(20.0f, 6.0f);
        pathBuilder.lineTo(4.0f, 6.0f);
        pathBuilder.lineToRelative(8.0f, 4.99f);
        pathBuilder.close();
        ImageVector.Builder.m4578addPathoIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 0.3f, (Brush) null, 0.3f, 1.0f, r22, r23, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int r39 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r40 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(4.0f, 20.0f);
        pathBuilder2.horizontalLineToRelative(16.0f);
        pathBuilder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder2.verticalLineTo(6.0f);
        pathBuilder2.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder2.horizontalLineTo(4.0f);
        pathBuilder2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilder2.verticalLineToRelative(12.0f);
        pathBuilder2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(20.0f, 6.0f);
        pathBuilder2.lineToRelative(-8.0f, 4.99f);
        pathBuilder2.lineTo(4.0f, 6.0f);
        pathBuilder2.horizontalLineToRelative(16.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(4.0f, 8.0f);
        pathBuilder2.lineToRelative(8.0f, 5.0f);
        pathBuilder2.lineToRelative(8.0f, -5.0f);
        pathBuilder2.verticalLineToRelative(10.0f);
        pathBuilder2.horizontalLineTo(4.0f);
        pathBuilder2.verticalLineTo(8.0f);
        pathBuilder2.close();
        ImageVector build = ImageVector.Builder.m4578addPathoIyEayM$default(builder, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r39, r40, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _email = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
