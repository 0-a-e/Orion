package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import jp.co.sony.reonpocket.util.CacheImageUtil;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0003\r\u000e\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "aContext", "Landroid/content/Context;", "aAttrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mHandler", "Ljp/co/sony/reonpocket/view/CustomImageView$DownloadHandler;", "setImageURL", "", "aPath", "", "Companion", "DownloadBundle", "DownloadHandler", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomImageView.kt */
public final class CustomImageView extends AppCompatImageView {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int GET_DATA_SUCCESS = 1;
    public static final int NETWORK_ERROR = 2;
    public static final int SERVER_ERROR = 3;
    private static final String TAG = "CustomImageView";
    /* access modifiers changed from: private */
    public final DownloadHandler mHandler = new DownloadHandler();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "aContext");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomImageView$Companion;", "", "()V", "GET_DATA_SUCCESS", "", "NETWORK_ERROR", "SERVER_ERROR", "TAG", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomImageView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setImageURL(String str) {
        Intrinsics.checkNotNullParameter(str, "aPath");
        Bitmap bitmapFromCache = CacheImageUtil.INSTANCE.getBitmapFromCache(str);
        if (bitmapFromCache != null) {
            setImageBitmap(bitmapFromCache);
            DebugLogUtil.INSTANCE.d(TAG, "get image from cache");
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new CustomImageView$setImageURL$1(str, this, (Continuation<? super CustomImageView$setImageURL$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomImageView$DownloadBundle;", "", "aUrl", "", "aBitmap", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "url", "getUrl", "()Ljava/lang/String;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomImageView.kt */
    private static final class DownloadBundle {
        private final Bitmap bitmap;
        private final String url;

        public DownloadBundle(String str, Bitmap bitmap2) {
            Intrinsics.checkNotNullParameter(str, "aUrl");
            Intrinsics.checkNotNullParameter(bitmap2, "aBitmap");
            this.url = str;
            this.bitmap = bitmap2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomImageView$DownloadHandler;", "Landroid/os/Handler;", "(Ljp/co/sony/reonpocket/view/CustomImageView;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomImageView.kt */
    private final class DownloadHandler extends Handler {
        public DownloadHandler() {
        }

        public void handleMessage(Message message) {
            Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.CustomImageView.DownloadBundle");
                DownloadBundle downloadBundle = (DownloadBundle) obj;
                CacheImageUtil.INSTANCE.setBitmapToCache(downloadBundle.getUrl(), downloadBundle.getBitmap());
                CustomImageView.this.setImageBitmap(downloadBundle.getBitmap());
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                String url = downloadBundle.getUrl();
                debugLogUtil.d(CustomImageView.TAG, "image downloaded from " + url);
            } else if (i == 2) {
                DebugLogUtil.INSTANCE.e(CustomImageView.TAG, "network error");
            } else if (i == 3) {
                DebugLogUtil.INSTANCE.e(CustomImageView.TAG, "server error");
            }
        }
    }
}
