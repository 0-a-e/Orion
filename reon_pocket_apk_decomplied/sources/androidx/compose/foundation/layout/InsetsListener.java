package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001e\u0010\"\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020\u001eH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Landroidx/compose/foundation/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeInsets", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "(Landroidx/compose/foundation/layout/WindowInsetsHolder;)V", "getComposeInsets", "()Landroidx/compose/foundation/layout/WindowInsetsHolder;", "prepared", "", "getPrepared", "()Z", "setPrepared", "(Z)V", "runningAnimation", "getRunningAnimation", "setRunningAnimation", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "getSavedInsets", "()Landroidx/core/view/WindowInsetsCompat;", "setSavedInsets", "(Landroidx/core/view/WindowInsetsCompat;)V", "onApplyWindowInsets", "view", "Landroid/view/View;", "insets", "onEnd", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onPrepare", "onProgress", "runningAnimations", "", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onViewAttachedToWindow", "onViewDetachedFromWindow", "v", "run", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsets.android.kt */
final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {
    private final WindowInsetsHolder composeInsets;
    private boolean prepared;
    private boolean runningAnimation;
    private WindowInsetsCompat savedInsets;

    public void onViewDetachedFromWindow(View view) {
    }

    public final WindowInsetsHolder getComposeInsets() {
        return this.composeInsets;
    }

    public InsetsListener(WindowInsetsHolder windowInsetsHolder) {
        super(windowInsetsHolder.getConsumes() ^ true ? 1 : 0);
        this.composeInsets = windowInsetsHolder;
    }

    public final boolean getPrepared() {
        return this.prepared;
    }

    public final void setPrepared(boolean z) {
        this.prepared = z;
    }

    public final boolean getRunningAnimation() {
        return this.runningAnimation;
    }

    public final void setRunningAnimation(boolean z) {
        this.runningAnimation = z;
    }

    public final WindowInsetsCompat getSavedInsets() {
        return this.savedInsets;
    }

    public final void setSavedInsets(WindowInsetsCompat windowInsetsCompat) {
        this.savedInsets = windowInsetsCompat;
    }

    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.prepared = true;
        this.runningAnimation = true;
        super.onPrepare(windowInsetsAnimationCompat);
    }

    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.prepared = false;
        return super.onStart(windowInsetsAnimationCompat, boundsCompat);
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
        WindowInsetsHolder.update$default(this.composeInsets, windowInsetsCompat, 0, 2, (Object) null);
        return this.composeInsets.getConsumes() ? WindowInsetsCompat.CONSUMED : windowInsetsCompat;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.prepared = false;
        this.runningAnimation = false;
        WindowInsetsCompat windowInsetsCompat = this.savedInsets;
        if (!(windowInsetsAnimationCompat.getDurationMillis() == 0 || windowInsetsCompat == null)) {
            this.composeInsets.updateImeAnimationSource(windowInsetsCompat);
            this.composeInsets.updateImeAnimationTarget(windowInsetsCompat);
            WindowInsetsHolder.update$default(this.composeInsets, windowInsetsCompat, 0, 2, (Object) null);
        }
        this.savedInsets = null;
        super.onEnd(windowInsetsAnimationCompat);
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        this.savedInsets = windowInsetsCompat;
        this.composeInsets.updateImeAnimationTarget(windowInsetsCompat);
        if (this.prepared) {
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
        } else if (!this.runningAnimation) {
            this.composeInsets.updateImeAnimationSource(windowInsetsCompat);
            WindowInsetsHolder.update$default(this.composeInsets, windowInsetsCompat, 0, 2, (Object) null);
        }
        return this.composeInsets.getConsumes() ? WindowInsetsCompat.CONSUMED : windowInsetsCompat;
    }

    public void run() {
        if (this.prepared) {
            this.prepared = false;
            this.runningAnimation = false;
            WindowInsetsCompat windowInsetsCompat = this.savedInsets;
            if (windowInsetsCompat != null) {
                this.composeInsets.updateImeAnimationSource(windowInsetsCompat);
                WindowInsetsHolder.update$default(this.composeInsets, windowInsetsCompat, 0, 2, (Object) null);
                this.savedInsets = null;
            }
        }
    }

    public void onViewAttachedToWindow(View view) {
        view.requestApplyInsets();
    }
}
