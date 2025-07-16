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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_arrowBack", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowBack", "Landroidx/compose/material/icons/Icons$Outlined;", "getArrowBack$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getArrowBack", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ArrowBack.kt */
public final class ArrowBackKt {
    private static ImageVector _arrowBack;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Outlined.ArrowBack", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Outlined.ArrowBack", imports = {"androidx.compose.material.icons.automirrored.outlined.ArrowBack"}))
    public static /* synthetic */ void getArrowBack$annotations(Icons.Outlined outlined) {
    }

    public static final ImageVector getArrowBack(Icons.Outlined outlined) {
        ImageVector imageVector = _arrowBack;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.ArrowBack", Dp.m6614constructorimpl(24.0f), Dp.m6614constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, (DefaultConstructorMarker) null);
        int r22 = StrokeCap.Companion.m4230getButtKaPHkGw();
        int r23 = StrokeJoin.Companion.m4240getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(20.0f, 11.0f);
        pathBuilder.horizontalLineTo(7.83f);
        pathBuilder.lineToRelative(5.59f, -5.59f);
        pathBuilder.lineTo(12.0f, 4.0f);
        pathBuilder.lineToRelative(-8.0f, 8.0f);
        pathBuilder.lineToRelative(8.0f, 8.0f);
        pathBuilder.lineToRelative(1.41f, -1.41f);
        pathBuilder.lineTo(7.83f, 13.0f);
        pathBuilder.horizontalLineTo(20.0f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.m4578addPathoIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3842getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r22, r23, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _arrowBack = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
