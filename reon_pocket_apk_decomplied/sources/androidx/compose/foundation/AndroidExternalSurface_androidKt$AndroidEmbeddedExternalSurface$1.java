package androidx.compose.foundation;

import android.content.Context;
import android.view.TextureView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
final class AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1 extends Lambda implements Function1<Context, TextureView> {
    final /* synthetic */ Function1<AndroidExternalSurfaceScope, Unit> $onInit;
    final /* synthetic */ AndroidEmbeddedExternalSurfaceState $state;
    final /* synthetic */ long $surfaceSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1(AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState, long j, Function1<? super AndroidExternalSurfaceScope, Unit> function1) {
        super(1);
        this.$state = androidEmbeddedExternalSurfaceState;
        this.$surfaceSize = j;
        this.$onInit = function1;
    }

    public final TextureView invoke(Context context) {
        TextureView textureView = new TextureView(context);
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = this.$state;
        long j = this.$surfaceSize;
        Function1<AndroidExternalSurfaceScope, Unit> function1 = this.$onInit;
        androidEmbeddedExternalSurfaceState.m198setSurfaceSizeozmzZPI(j);
        function1.invoke(androidEmbeddedExternalSurfaceState);
        textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceState);
        return textureView;
    }
}
