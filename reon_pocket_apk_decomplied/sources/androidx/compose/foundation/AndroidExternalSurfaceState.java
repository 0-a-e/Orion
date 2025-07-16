package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.SurfaceHolder;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceState;", "Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroid/view/SurfaceHolder$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "lastHeight", "", "getLastHeight", "()I", "setLastHeight", "(I)V", "lastWidth", "getLastWidth", "setLastWidth", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "width", "height", "surfaceCreated", "surfaceDestroyed", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
final class AndroidExternalSurfaceState extends BaseAndroidExternalSurfaceState implements SurfaceHolder.Callback {
    private int lastHeight = -1;
    private int lastWidth = -1;

    public AndroidExternalSurfaceState(CoroutineScope coroutineScope) {
        super(coroutineScope);
    }

    public final int getLastWidth() {
        return this.lastWidth;
    }

    public final void setLastWidth(int i) {
        this.lastWidth = i;
    }

    public final int getLastHeight() {
        return this.lastHeight;
    }

    public final void setLastHeight(int i) {
        this.lastHeight = i;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        this.lastWidth = surfaceFrame.width();
        this.lastHeight = surfaceFrame.height();
        dispatchSurfaceCreated(surfaceHolder.getSurface(), this.lastWidth, this.lastHeight);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.lastWidth != i2 || this.lastHeight != i3) {
            this.lastWidth = i2;
            this.lastHeight = i3;
            dispatchSurfaceChanged(surfaceHolder.getSurface(), i2, i3);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        dispatchSurfaceDestroyed(surfaceHolder.getSurface());
    }
}
