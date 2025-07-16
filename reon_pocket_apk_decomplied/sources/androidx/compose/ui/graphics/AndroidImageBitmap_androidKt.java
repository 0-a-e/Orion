package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0001\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u000e\u001a\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u0006*\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0015\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"ActualImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "Landroid/graphics/Bitmap;", "asImageBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidImageBitmap.android.kt */
public final class AndroidImageBitmap_androidKt {
    public static final ImageBitmap asImageBitmap(Bitmap bitmap) {
        return new AndroidImageBitmap(bitmap);
    }

    /* renamed from: ActualImageBitmap-x__-hDU  reason: not valid java name */
    public static final ImageBitmap m3672ActualImageBitmapx__hDU(int i, int i2, int i3, boolean z, ColorSpace colorSpace) {
        Bitmap bitmap;
        Bitmap.Config r0 = m3673toBitmapConfig1JJdX4A(i3);
        if (Build.VERSION.SDK_INT >= 26) {
            bitmap = Api26Bitmap.m3711createBitmapx__hDU$ui_graphics_release(i, i2, i3, z, colorSpace);
        } else {
            bitmap = Bitmap.createBitmap((DisplayMetrics) null, i, i2, r0);
            bitmap.setHasAlpha(z);
        }
        return new AndroidImageBitmap(bitmap);
    }

    public static final Bitmap asAndroidBitmap(ImageBitmap imageBitmap) {
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).getBitmap$ui_graphics_release();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    /* renamed from: toBitmapConfig-1JJdX4A  reason: not valid java name */
    public static final Bitmap.Config m3673toBitmapConfig1JJdX4A(int i) {
        if (ImageBitmapConfig.m4041equalsimpl0(i, ImageBitmapConfig.Companion.m4046getArgb8888_sVssgQ())) {
            return Bitmap.Config.ARGB_8888;
        }
        if (ImageBitmapConfig.m4041equalsimpl0(i, ImageBitmapConfig.Companion.m4045getAlpha8_sVssgQ())) {
            return Bitmap.Config.ALPHA_8;
        }
        if (ImageBitmapConfig.m4041equalsimpl0(i, ImageBitmapConfig.Companion.m4049getRgb565_sVssgQ())) {
            return Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && ImageBitmapConfig.m4041equalsimpl0(i, ImageBitmapConfig.Companion.m4047getF16_sVssgQ())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1();
        }
        if (Build.VERSION.SDK_INT < 26 || !ImageBitmapConfig.m4041equalsimpl0(i, ImageBitmapConfig.Companion.m4048getGpu_sVssgQ())) {
            return Bitmap.Config.ARGB_8888;
        }
        return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m();
    }

    public static final int toImageConfig(Bitmap.Config config) {
        if (config == Bitmap.Config.ALPHA_8) {
            return ImageBitmapConfig.Companion.m4045getAlpha8_sVssgQ();
        }
        if (config == Bitmap.Config.RGB_565) {
            return ImageBitmapConfig.Companion.m4049getRgb565_sVssgQ();
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return ImageBitmapConfig.Companion.m4046getArgb8888_sVssgQ();
        }
        if (Build.VERSION.SDK_INT >= 26 && config == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1()) {
            return ImageBitmapConfig.Companion.m4047getF16_sVssgQ();
        }
        if (Build.VERSION.SDK_INT < 26 || config != Api26Bitmap$$ExternalSyntheticApiModelOutline0.m()) {
            return ImageBitmapConfig.Companion.m4046getArgb8888_sVssgQ();
        }
        return ImageBitmapConfig.Companion.m4048getGpu_sVssgQ();
    }
}
