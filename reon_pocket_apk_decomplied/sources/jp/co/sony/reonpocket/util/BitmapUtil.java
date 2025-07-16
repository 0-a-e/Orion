package jp.co.sony.reonpocket.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/util/BitmapUtil;", "", "()V", "COMPRESS_QUALITY", "", "conversionBitmap", "Landroid/graphics/Bitmap;", "aBitmap", "aNewWidth", "aNewHeight", "convertBitmapToByteArray", "", "convertByteArrayToBitmap", "aByteArray", "getBitmap", "aContext", "Landroid/content/Context;", "aId", "aFilePath", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BitmapUtil.kt */
public final class BitmapUtil {
    public static final int $stable = 0;
    private static final int COMPRESS_QUALITY = 100;
    public static final BitmapUtil INSTANCE = new BitmapUtil();

    private BitmapUtil() {
    }

    public final byte[] convertBitmapToByteArray(Bitmap bitmap) {
        if (bitmap == null) {
            DebugLogUtil.INSTANCE.e("Bitmap invalid data value");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final Bitmap convertByteArrayToBitmap(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        DebugLogUtil.INSTANCE.e("aByteArray invalid data value");
        return null;
    }

    public final Bitmap getBitmap(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(...)");
        return decodeResource;
    }

    public final Bitmap getBitmap(String str) {
        Intrinsics.checkNotNullParameter(str, "aFilePath");
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        Intrinsics.checkNotNullExpressionValue(decodeFile, "decodeFile(...)");
        return decodeFile;
    }

    public final Bitmap conversionBitmap(Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "aBitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }
}
