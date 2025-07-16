package jp.co.sony.reonpocket.util;

import android.graphics.Bitmap;
import android.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ljp/co/sony/reonpocket/util/CacheImageUtil;", "", "()V", "mImageCache", "Ljp/co/sony/reonpocket/util/CacheImageUtil$ImageCache;", "getBitmapFromCache", "Landroid/graphics/Bitmap;", "aUrl", "", "setBitmapToCache", "", "aBitmap", "ImageCache", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CacheImageUtil.kt */
public final class CacheImageUtil {
    public static final int $stable = 8;
    public static final CacheImageUtil INSTANCE = new CacheImageUtil();
    private static ImageCache mImageCache = new ImageCache(new HashMap());

    private CacheImageUtil() {
    }

    public final Bitmap getBitmapFromCache(String str) {
        Intrinsics.checkNotNullParameter(str, "aUrl");
        Bitmap bitmap = (Bitmap) mImageCache.get(str);
        if (bitmap == null) {
            Map<String, SoftReference<Bitmap>> cacheMap = mImageCache.getCacheMap();
            Intrinsics.checkNotNull(cacheMap);
            SoftReference softReference = cacheMap.get(str);
            if (softReference != null) {
                Bitmap bitmap2 = (Bitmap) mImageCache.put(str, (Bitmap) softReference.get());
            }
        }
        return bitmap;
    }

    public final void setBitmapToCache(String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(str, "aUrl");
        Intrinsics.checkNotNullParameter(bitmap, "aBitmap");
        mImageCache.put(str, bitmap);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005¢\u0006\u0002\u0010\u0007J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0014J\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0014R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/util/CacheImageUtil$ImageCache;", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "aCacheMap", "", "Ljava/lang/ref/SoftReference;", "(Ljava/util/Map;)V", "mCacheMap", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "getCacheMap", "sizeOf", "", "value", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CacheImageUtil.kt */
    public static final class ImageCache extends LruCache<String, Bitmap> {
        public static final int $stable = 8;
        private final Map<String, SoftReference<Bitmap>> mCacheMap;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImageCache(Map<String, SoftReference<Bitmap>> map) {
            super((int) (Runtime.getRuntime().maxMemory() / ((long) 8)));
            Intrinsics.checkNotNullParameter(map, "aCacheMap");
            this.mCacheMap = map;
        }

        /* access modifiers changed from: protected */
        public int sizeOf(String str, Bitmap bitmap) {
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }

        /* access modifiers changed from: protected */
        public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
            Intrinsics.checkNotNullParameter(bitmap2, "newValue");
            if (bitmap != null) {
                SoftReference put = this.mCacheMap.put(str, new SoftReference(bitmap));
            }
        }

        public final Map<String, SoftReference<Bitmap>> getCacheMap() {
            return this.mCacheMap;
        }
    }
}
