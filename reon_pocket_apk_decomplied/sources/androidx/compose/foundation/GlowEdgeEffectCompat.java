package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/GlowEdgeEffectCompat;", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "oppositeReleaseDelta", "", "oppositeReleaseDeltaThreshold", "onAbsorb", "", "velocity", "", "onPull", "deltaDistance", "displacement", "onRelease", "releaseWithOppositeDelta", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EdgeEffectCompat.android.kt */
final class GlowEdgeEffectCompat extends EdgeEffect {
    private float oppositeReleaseDelta;
    private final float oppositeReleaseDeltaThreshold;

    public GlowEdgeEffectCompat(Context context) {
        super(context);
        this.oppositeReleaseDeltaThreshold = AndroidDensity_androidKt.Density(context).m6550toPx0680j_4(Dp.m6614constructorimpl((float) 1));
    }

    public void onPull(float f, float f2) {
        this.oppositeReleaseDelta = 0.0f;
        super.onPull(f, f2);
    }

    public void onPull(float f) {
        this.oppositeReleaseDelta = 0.0f;
        super.onPull(f);
    }

    public void onRelease() {
        this.oppositeReleaseDelta = 0.0f;
        super.onRelease();
    }

    public void onAbsorb(int i) {
        this.oppositeReleaseDelta = 0.0f;
        super.onAbsorb(i);
    }

    public final void releaseWithOppositeDelta(float f) {
        float f2 = this.oppositeReleaseDelta + f;
        this.oppositeReleaseDelta = f2;
        if (Math.abs(f2) > this.oppositeReleaseDeltaThreshold) {
            onRelease();
        }
    }
}
