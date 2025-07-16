package jp.co.sony.reonpocket.modules.base.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import jp.co.sony.reonpocket.R;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b'\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u0002/0B\u0005¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0004J\b\u0010\u001b\u001a\u00020\u001aH\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0004J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020(H\u0004J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020+H\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00061"}, d2 = {"Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/View$OnClickListener;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mActivity", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "mCallback", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "mCustomToast", "Landroid/widget/Toast;", "mLastClickTime", "", "getMLastClickTime", "()J", "setMLastClickTime", "(J)V", "getCallback", "T", "getCallback$app_prodRelease", "()Ljava/lang/Object;", "isAttachingActivity", "", "isPassedEnoughTime", "isShowHomeAsUpButton", "", "isShow", "onAttach", "context", "Landroid/content/Context;", "onClick", "v", "Landroid/view/View;", "onDetach", "setActionBarTitle", "resId", "", "showCustomToast", "aMsg", "", "showToast", "aMessageResId", "aMessage", "Callback", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment extends Fragment implements CoroutineScope, View.OnClickListener {
    public static final int $stable = 8;
    public static final long CLICK_DELAY = 200;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private BaseActivity mActivity;
    private Callback mCallback;
    private Toast mCustomToast;
    private long mLastClickTime;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseFragment.kt */
    public interface Callback {
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public void onClick(View view) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Companion;", "", "()V", "CLICK_DELAY", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final long getMLastClickTime() {
        return this.mLastClickTime;
    }

    /* access modifiers changed from: protected */
    public final void setMLastClickTime(long j) {
        this.mLastClickTime = j;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
        Object parentFragment = getParentFragment();
        if (parentFragment == null && (parentFragment = this.mActivity) == null) {
            this.mCallback = null;
        } else if (parentFragment instanceof Callback) {
            this.mCallback = (Callback) parentFragment;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mCallback = null;
    }

    /* access modifiers changed from: protected */
    public final void showToast(int i) {
        Toast.makeText(this.mActivity, i, 0).show();
    }

    /* access modifiers changed from: protected */
    public final void showToast(String str) {
        Intrinsics.checkNotNullParameter(str, "aMessage");
        Toast.makeText(this.mActivity, str, 0).show();
    }

    /* access modifiers changed from: protected */
    public final void showCustomToast(String str) {
        Intrinsics.checkNotNullParameter(str, "aMsg");
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        View inflate = layoutInflater.inflate(R.layout.view_toast_smart, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.toast_msg);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(str);
        Toast toast = new Toast(this.mActivity);
        this.mCustomToast = toast;
        Intrinsics.checkNotNull(toast);
        toast.setGravity(81, 0, getResources().getDimensionPixelSize(R.dimen.smartToastTopBotMargin));
        Toast toast2 = this.mCustomToast;
        Intrinsics.checkNotNull(toast2);
        toast2.setView(inflate);
        Toast toast3 = this.mCustomToast;
        Intrinsics.checkNotNull(toast3);
        toast3.setDuration(1);
        Toast toast4 = this.mCustomToast;
        Intrinsics.checkNotNull(toast4);
        toast4.show();
    }

    /* access modifiers changed from: protected */
    public final boolean isPassedEnoughTime() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.mLastClickTime >= 200;
        this.mLastClickTime = currentTimeMillis;
        return z;
    }

    /* access modifiers changed from: protected */
    public final boolean isAttachingActivity() {
        return this.mActivity != null;
    }

    public final <T> T getCallback$app_prodRelease() {
        try {
            return (Object) this.mCallback;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void isShowHomeAsUpButton(boolean z) {
        ActionBar supportActionBar;
        BaseActivity baseActivity = this.mActivity;
        if (baseActivity != null && (supportActionBar = baseActivity.getSupportActionBar()) != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(z);
        }
    }

    public final void setActionBarTitle(int i) {
        ActionBar supportActionBar;
        BaseActivity baseActivity = this.mActivity;
        if (baseActivity != null && (supportActionBar = baseActivity.getSupportActionBar()) != null) {
            supportActionBar.setTitle(i);
        }
    }
}
