package androidx.compose.foundation;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "view", "Landroid/view/TextureView;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
final class AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3 extends Lambda implements Function1<TextureView, Unit> {
    final /* synthetic */ boolean $isOpaque;
    final /* synthetic */ AndroidEmbeddedExternalSurfaceState $state;
    final /* synthetic */ long $surfaceSize;
    final /* synthetic */ float[] $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3(long j, AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState, boolean z, float[] fArr) {
        super(1);
        this.$surfaceSize = j;
        this.$state = androidEmbeddedExternalSurfaceState;
        this.$isOpaque = z;
        this.$transform = fArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextureView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextureView textureView) {
        Matrix matrix;
        SurfaceTexture surfaceTexture;
        if (!IntSize.m6788equalsimpl0(this.$surfaceSize, IntSize.Companion.m6795getZeroYbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
            surfaceTexture.setDefaultBufferSize(IntSize.m6790getWidthimpl(this.$surfaceSize), IntSize.m6789getHeightimpl(this.$surfaceSize));
        }
        this.$state.m198setSurfaceSizeozmzZPI(this.$surfaceSize);
        textureView.setOpaque(this.$isOpaque);
        float[] fArr = this.$transform;
        if (fArr != null) {
            matrix = this.$state.getMatrix();
            AndroidMatrixConversions_androidKt.m3674setFromEL8BTi8(matrix, fArr);
        } else {
            matrix = null;
        }
        textureView.setTransform(matrix);
    }
}
