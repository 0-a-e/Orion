package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Switch;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomSwitch;", "Landroid/widget/Switch;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mIsEnable", "", "mListener", "Ljp/co/sony/reonpocket/view/CustomSwitch$OnDisableClickListener;", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "setEnabled", "", "enabled", "setOnDisableClickListener", "aListener", "OnDisableClickListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomSwitch.kt */
public final class CustomSwitch extends Switch {
    public static final int $stable = 8;
    private boolean mIsEnable = true;
    private OnDisableClickListener mListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomSwitch$OnDisableClickListener;", "", "onDisableClick", "", "id", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomSwitch.kt */
    public interface OnDisableClickListener {
        void onDisableClick(int i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void setEnabled(boolean z) {
        this.mIsEnable = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        boolean z = this.mIsEnable;
        if (z) {
            return super.onTouchEvent(motionEvent);
        }
        if (!z) {
            OnDisableClickListener onDisableClickListener = this.mListener;
            if (onDisableClickListener != null) {
                onDisableClickListener.onDisableClick(getId());
            }
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setOnDisableClickListener(OnDisableClickListener onDisableClickListener) {
        Intrinsics.checkNotNullParameter(onDisableClickListener, "aListener");
        this.mListener = onDisableClickListener;
    }
}
