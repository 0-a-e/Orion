package jp.co.sony.reonpocket.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import com.amazonaws.services.s3.internal.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import jp.co.sony.reonpocket.view.CustomImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.view.CustomImageView$setImageURL$1", f = "CustomImageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CustomImageView.kt */
final class CustomImageView$setImageURL$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $aPath;
    int label;
    final /* synthetic */ CustomImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomImageView$setImageURL$1(String str, CustomImageView customImageView, Continuation<? super CustomImageView$setImageURL$1> continuation) {
        super(2, continuation);
        this.$aPath = str;
        this.this$0 = customImageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomImageView$setImageURL$1(this.$aPath, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomImageView$setImageURL$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                URLConnection openConnection = new URL(this.$aPath).openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(Constants.MAXIMUM_UPLOAD_PARTS);
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    Message obtain = Message.obtain();
                    String str = this.$aPath;
                    Intrinsics.checkNotNull(decodeStream);
                    obtain.obj = new CustomImageView.DownloadBundle(str, decodeStream);
                    obtain.what = 1;
                    this.this$0.mHandler.sendMessage(obtain);
                    inputStream.close();
                } else {
                    this.this$0.mHandler.sendEmptyMessage(3);
                }
            } catch (IOException e) {
                e.printStackTrace();
                this.this$0.mHandler.sendEmptyMessage(2);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
