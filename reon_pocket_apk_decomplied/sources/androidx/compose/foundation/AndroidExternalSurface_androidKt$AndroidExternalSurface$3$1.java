package androidx.compose.foundation;

import android.view.SurfaceView;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "view", "Landroid/view/SurfaceView;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
final class AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1 extends Lambda implements Function1<SurfaceView, Unit> {
    final /* synthetic */ boolean $isOpaque;
    final /* synthetic */ boolean $isSecure;
    final /* synthetic */ long $surfaceSize;
    final /* synthetic */ int $zOrder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1(long j, boolean z, int i, boolean z2) {
        super(1);
        this.$surfaceSize = j;
        this.$isOpaque = z;
        this.$zOrder = i;
        this.$isSecure = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SurfaceView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SurfaceView surfaceView) {
        if (!IntSize.m6788equalsimpl0(this.$surfaceSize, IntSize.Companion.m6795getZeroYbymL2g())) {
            surfaceView.getHolder().setFixedSize(IntSize.m6790getWidthimpl(this.$surfaceSize), IntSize.m6789getHeightimpl(this.$surfaceSize));
        } else {
            surfaceView.getHolder().setSizeFromLayout();
        }
        surfaceView.getHolder().setFormat(this.$isOpaque ? -1 : -3);
        int i = this.$zOrder;
        if (AndroidExternalSurfaceZOrder.m202equalsimpl0(i, AndroidExternalSurfaceZOrder.Companion.m206getBehindB_4ceCc())) {
            surfaceView.setZOrderOnTop(false);
        } else if (AndroidExternalSurfaceZOrder.m202equalsimpl0(i, AndroidExternalSurfaceZOrder.Companion.m207getMediaOverlayB_4ceCc())) {
            surfaceView.setZOrderMediaOverlay(true);
        } else if (AndroidExternalSurfaceZOrder.m202equalsimpl0(i, AndroidExternalSurfaceZOrder.Companion.m208getOnTopB_4ceCc())) {
            surfaceView.setZOrderOnTop(true);
        }
        surfaceView.setSecure(this.$isSecure);
    }
}
