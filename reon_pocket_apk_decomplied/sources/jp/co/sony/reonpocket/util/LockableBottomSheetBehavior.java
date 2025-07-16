package jp.co.sony.reonpocket.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\n\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J5\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010\u001dJE\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020!H\u0016¢\u0006\u0002\u0010&J=\u0010'\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010)\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0016¢\u0006\u0002\u0010*J-\u0010+\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010%\u001a\u00020!H\u0016¢\u0006\u0002\u0010,J%\u0010-\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006."}, d2 = {"Ljp/co/sony/reonpocket/util/LockableBottomSheetBehavior;", "V", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "swipeEnabled", "", "getSwipeEnabled", "()Z", "setSwipeEnabled", "(Z)V", "onInterceptTouchEvent", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "event", "Landroid/view/MotionEvent;", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onNestedPreFling", "coordinatorLayout", "target", "velocityX", "", "velocityY", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;FF)Z", "onNestedPreScroll", "", "dx", "", "dy", "consumed", "", "type", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[II)V", "onStartNestedScroll", "directTargetChild", "axes", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "onStopNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;I)V", "onTouchEvent", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LockableBottomSheetBehavior.kt */
public final class LockableBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public static final int $stable = 8;
    private boolean swipeEnabled;

    public LockableBottomSheetBehavior() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LockableBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public final boolean getSwipeEnabled() {
        return this.swipeEnabled;
    }

    public final void setSwipeEnabled(boolean z) {
        this.swipeEnabled = z;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(v, "child");
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.swipeEnabled) {
            return super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(v, "child");
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.swipeEnabled) {
            return super.onTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(v, "child");
        Intrinsics.checkNotNullParameter(view, "directTargetChild");
        Intrinsics.checkNotNullParameter(view2, "target");
        if (this.swipeEnabled) {
            return super.onStartNestedScroll(coordinatorLayout, v, view, view2, i, i2);
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(v, "child");
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (this.swipeEnabled) {
            super.onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr, i3);
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(v, "child");
        Intrinsics.checkNotNullParameter(view, "target");
        if (this.swipeEnabled) {
            super.onStopNestedScroll(coordinatorLayout, v, view, i);
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(v, "child");
        Intrinsics.checkNotNullParameter(view, "target");
        if (this.swipeEnabled) {
            return super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
        }
        return false;
    }
}
