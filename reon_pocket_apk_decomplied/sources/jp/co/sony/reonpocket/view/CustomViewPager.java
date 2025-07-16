package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mIsEnable", "", "canScrollHorizontally", "direction", "", "onHoverEvent", "event", "Landroid/view/MotionEvent;", "onInterceptHoverEvent", "onInterceptTouchEvent", "ev", "onTouchEvent", "setPagingEnabled", "", "isEnable", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomViewPager.kt */
public final class CustomViewPager extends ViewPager {
    public static final int $stable = 8;
    private boolean mIsEnable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setOffscreenPageLimit(4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsEnable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mIsEnable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.mIsEnable) {
            return super.onHoverEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        if (this.mIsEnable) {
            return super.onInterceptHoverEvent(motionEvent);
        }
        return false;
    }

    public final void setPagingEnabled(boolean z) {
        this.mIsEnable = z;
    }

    public boolean canScrollHorizontally(int i) {
        if (this.mIsEnable) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }
}
