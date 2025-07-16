package jp.co.sony.reonpocket.view.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "()V", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "Builder", "Callback", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlertDialogFragment.kt */
public final class AlertDialogFragment extends BaseDialogFragment {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment$Callback;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Callback;", "onAlertDialogCancelled", "", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "", "onAlertDialogSucceeded", "aResultCode", "onDismiss", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AlertDialogFragment.kt */
    public interface Callback extends BaseDialogFragment.Callback {
        void onAlertDialogCancelled(BaseDialogFragment baseDialogFragment, int i);

        void onAlertDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2);

        void onDismiss(BaseDialogFragment baseDialogFragment);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(BaseDialogFragment.KEY_ARGUMENT);
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.BaseDialogFragment.Param");
            setMParam((BaseDialogFragment.Param) serializable);
        } else {
            setMParam(new BaseDialogFragment.Param());
            BaseDialogFragment.Param mParam = getMParam();
            Intrinsics.checkNotNull(mParam);
            mParam.setMNegativeLabel$app_prodRelease(getString(R.string.common_cancel));
        }
        BaseDialogFragment.Param mParam2 = getMParam();
        if (mParam2 != null) {
            setCancelable(mParam2.getMCancelable$app_prodRelease());
            if (!TextUtils.isEmpty(mParam2.getMTitle$app_prodRelease())) {
                builder.setTitle((CharSequence) mParam2.getMTitle$app_prodRelease());
            }
            if (!TextUtils.isEmpty(mParam2.getMMessage$app_prodRelease())) {
                builder.setMessage((CharSequence) mParam2.getMMessage$app_prodRelease());
            }
            if (!TextUtils.isEmpty(mParam2.getMPositiveLabel$app_prodRelease())) {
                builder.setPositiveButton((CharSequence) mParam2.getMPositiveLabel$app_prodRelease(), (DialogInterface.OnClickListener) new AlertDialogFragment$$ExternalSyntheticLambda0(this));
            }
            if (!TextUtils.isEmpty(mParam2.getMNegativeLabel$app_prodRelease())) {
                builder.setNegativeButton((CharSequence) mParam2.getMNegativeLabel$app_prodRelease(), (DialogInterface.OnClickListener) new AlertDialogFragment$$ExternalSyntheticLambda1(this));
            }
        }
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2$lambda$0(AlertDialogFragment alertDialogFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(alertDialogFragment, "this$0");
        alertDialogFragment.dismiss();
        Callback callback = (Callback) alertDialogFragment.getCallback$app_prodRelease();
        if (callback != null) {
            callback.onAlertDialogSucceeded(alertDialogFragment, alertDialogFragment.getRequestCode(), -1);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2$lambda$1(AlertDialogFragment alertDialogFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(alertDialogFragment, "this$0");
        alertDialogFragment.dismiss();
        Callback callback = (Callback) alertDialogFragment.getCallback$app_prodRelease();
        if (callback != null) {
            callback.onAlertDialogSucceeded(alertDialogFragment, alertDialogFragment.getRequestCode(), -2);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        Callback callback = (Callback) getCallback$app_prodRelease();
        if (callback != null) {
            callback.onAlertDialogCancelled(this, getRequestCode());
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Callback callback = (Callback) getCallback$app_prodRelease();
        if (callback != null) {
            callback.onDismiss(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment$Builder;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Builder;", "aActivity", "Landroidx/fragment/app/FragmentActivity;", "aParentFragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "createInstance", "Landroidx/fragment/app/DialogFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AlertDialogFragment.kt */
    public static final class Builder extends BaseDialogFragment.Builder {
        public static final int $stable = 0;

        public Builder() {
            this((FragmentActivity) null, (Fragment) null, 3, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(FragmentActivity fragmentActivity, Fragment fragment, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : fragmentActivity, (i & 2) != 0 ? null : fragment);
        }

        public Builder(FragmentActivity fragmentActivity, Fragment fragment) {
            super(fragmentActivity, fragment);
        }

        /* access modifiers changed from: protected */
        public DialogFragment createInstance() {
            return new AlertDialogFragment();
        }
    }
}
