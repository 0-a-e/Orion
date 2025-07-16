package androidx.compose.foundation;

import android.content.Context;
import android.view.SurfaceView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
final class AndroidExternalSurface_androidKt$AndroidExternalSurface$1 extends Lambda implements Function1<Context, SurfaceView> {
    final /* synthetic */ Function1<AndroidExternalSurfaceScope, Unit> $onInit;
    final /* synthetic */ AndroidExternalSurfaceState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidExternalSurface_androidKt$AndroidExternalSurface$1(Function1<? super AndroidExternalSurfaceScope, Unit> function1, AndroidExternalSurfaceState androidExternalSurfaceState) {
        super(1);
        this.$onInit = function1;
        this.$state = androidExternalSurfaceState;
    }

    public final SurfaceView invoke(Context context) {
        SurfaceView surfaceView = new SurfaceView(context);
        Function1<AndroidExternalSurfaceScope, Unit> function1 = this.$onInit;
        AndroidExternalSurfaceState androidExternalSurfaceState = this.$state;
        function1.invoke(androidExternalSurfaceState);
        surfaceView.getHolder().addCallback(androidExternalSurfaceState);
        return surfaceView;
    }
}
