package androidx.compose.ui.graphics;

import android.graphics.Shader;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u001a0\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aN\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aN\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a<\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "LinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "LinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "RadialGradientShader", "center", "radius", "RadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "SweepGradientShader", "SweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Shader.kt */
public final class ShaderKt {
    /* renamed from: LinearGradientShader-VjE6UOU$default  reason: not valid java name */
    public static /* synthetic */ Shader m4190LinearGradientShaderVjE6UOU$default(long j, long j2, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            i = TileMode.Companion.m4251getClamp3opZhB0();
        }
        return m4189LinearGradientShaderVjE6UOU(j, j2, list, list3, i);
    }

    /* renamed from: LinearGradientShader-VjE6UOU  reason: not valid java name */
    public static final Shader m4189LinearGradientShaderVjE6UOU(long j, long j2, List<Color> list, List<Float> list2, int i) {
        return AndroidShader_androidKt.m3705ActualLinearGradientShaderVjE6UOU(j, j2, list, list2, i);
    }

    /* renamed from: RadialGradientShader-8uybcMk$default  reason: not valid java name */
    public static /* synthetic */ Shader m4192RadialGradientShader8uybcMk$default(long j, float f, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            i = TileMode.Companion.m4251getClamp3opZhB0();
        }
        return m4191RadialGradientShader8uybcMk(j, f, list, list3, i);
    }

    /* renamed from: RadialGradientShader-8uybcMk  reason: not valid java name */
    public static final Shader m4191RadialGradientShader8uybcMk(long j, float f, List<Color> list, List<Float> list2, int i) {
        return AndroidShader_androidKt.m3706ActualRadialGradientShader8uybcMk(j, f, list, list2, i);
    }

    /* renamed from: SweepGradientShader-9KIMszo$default  reason: not valid java name */
    public static /* synthetic */ Shader m4194SweepGradientShader9KIMszo$default(long j, List list, List list2, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = null;
        }
        return m4193SweepGradientShader9KIMszo(j, list, list2);
    }

    /* renamed from: SweepGradientShader-9KIMszo  reason: not valid java name */
    public static final Shader m4193SweepGradientShader9KIMszo(long j, List<Color> list, List<Float> list2) {
        return AndroidShader_androidKt.m3707ActualSweepGradientShader9KIMszo(j, list, list2);
    }

    /* renamed from: ImageShader-F49vj9s$default  reason: not valid java name */
    public static /* synthetic */ Shader m4188ImageShaderF49vj9s$default(ImageBitmap imageBitmap, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = TileMode.Companion.m4251getClamp3opZhB0();
        }
        if ((i3 & 4) != 0) {
            i2 = TileMode.Companion.m4251getClamp3opZhB0();
        }
        return m4187ImageShaderF49vj9s(imageBitmap, i, i2);
    }

    /* renamed from: ImageShader-F49vj9s  reason: not valid java name */
    public static final Shader m4187ImageShaderF49vj9s(ImageBitmap imageBitmap, int i, int i2) {
        return AndroidShader_androidKt.m3704ActualImageShaderF49vj9s(imageBitmap, i, i2);
    }
}
