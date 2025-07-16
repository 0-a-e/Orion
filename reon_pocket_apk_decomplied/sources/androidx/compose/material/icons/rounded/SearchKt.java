package androidx.compose.material.icons.rounded;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_search", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Search", "Landroidx/compose/material/icons/Icons$Rounded;", "getSearch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Search.kt */
public final class SearchKt {
    private static ImageVector _search;

    public static final ImageVector getSearch(Icons.Rounded rounded) {
        ImageVector imageVector = _search;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Search", Dp.m6614constructorimpl(24.0f), Dp.m6614constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, (DefaultConstructorMarker) null);
        int r22 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r23 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(15.5f, 14.0f);
        pathBuilder.horizontalLineToRelative(-0.79f);
        pathBuilder.lineToRelative(-0.28f, -0.27f);
        PathBuilder pathBuilder2 = pathBuilder;
        pathBuilder2.curveToRelative(1.2f, -1.4f, 1.82f, -3.31f, 1.48f, -5.34f);
        pathBuilder2.curveToRelative(-0.47f, -2.78f, -2.79f, -5.0f, -5.59f, -5.34f);
        pathBuilder2.curveToRelative(-4.23f, -0.52f, -7.79f, 3.04f, -7.27f, 7.27f);
        pathBuilder2.curveToRelative(0.34f, 2.8f, 2.56f, 5.12f, 5.34f, 5.59f);
        pathBuilder2.curveToRelative(2.03f, 0.34f, 3.94f, -0.28f, 5.34f, -1.48f);
        pathBuilder.lineToRelative(0.27f, 0.28f);
        pathBuilder.verticalLineToRelative(0.79f);
        pathBuilder.lineToRelative(4.25f, 4.25f);
        PathBuilder pathBuilder3 = pathBuilder;
        pathBuilder3.curveToRelative(0.41f, 0.41f, 1.08f, 0.41f, 1.49f, 0.0f);
        pathBuilder3.curveToRelative(0.41f, -0.41f, 0.41f, -1.08f, 0.0f, -1.49f);
        pathBuilder.lineTo(15.5f, 14.0f);
        pathBuilder.close();
        pathBuilder.moveTo(9.5f, 14.0f);
        pathBuilder.curveTo(7.01f, 14.0f, 5.0f, 11.99f, 5.0f, 9.5f);
        pathBuilder.reflectiveCurveTo(7.01f, 5.0f, 9.5f, 5.0f);
        pathBuilder.reflectiveCurveTo(14.0f, 7.01f, 14.0f, 9.5f);
        pathBuilder.reflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.m4578addPathoIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r22, r23, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _search = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
