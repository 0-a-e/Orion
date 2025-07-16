package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0004H\u0001¢\u0006\u0002\b\u0011\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/Api26Bitmap;", "", "()V", "createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "createBitmap-x__-hDU$ui_graphics_release", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroid/graphics/Bitmap;", "composeColorSpace", "composeColorSpace$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidImageBitmap.android.kt */
public final class Api26Bitmap {
    public static final Api26Bitmap INSTANCE = new Api26Bitmap();

    private Api26Bitmap() {
    }

    @JvmStatic
    /* renamed from: createBitmap-x__-hDU$ui_graphics_release  reason: not valid java name */
    public static final Bitmap m3711createBitmapx__hDU$ui_graphics_release(int i, int i2, int i3, boolean z, ColorSpace colorSpace) {
        return Bitmap.createBitmap((DisplayMetrics) null, i, i2, AndroidImageBitmap_androidKt.m3673toBitmapConfig1JJdX4A(i3), z, AndroidColorSpace_androidKt.toAndroidColorSpace(colorSpace));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.compose.ui.graphics.AndroidColorSpace_androidKt.toComposeColorSpace(r0);
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace$ui_graphics_release(android.graphics.Bitmap r0) {
        /*
            android.graphics.ColorSpace r0 = r0.getColorSpace()
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.graphics.colorspace.ColorSpace r0 = androidx.compose.ui.graphics.AndroidColorSpace_androidKt.toComposeColorSpace(r0)
            if (r0 != 0) goto L_0x0014
        L_0x000c:
            androidx.compose.ui.graphics.colorspace.ColorSpaces r0 = androidx.compose.ui.graphics.colorspace.ColorSpaces.INSTANCE
            androidx.compose.ui.graphics.colorspace.Rgb r0 = r0.getSrgb()
            androidx.compose.ui.graphics.colorspace.ColorSpace r0 = (androidx.compose.ui.graphics.colorspace.ColorSpace) r0
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Api26Bitmap.composeColorSpace$ui_graphics_release(android.graphics.Bitmap):androidx.compose.ui.graphics.colorspace.ColorSpace");
    }
}
