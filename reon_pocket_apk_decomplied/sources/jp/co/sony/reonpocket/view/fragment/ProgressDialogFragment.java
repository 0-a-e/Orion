package jp.co.sony.reonpocket.view.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\r"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "()V", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "Callback", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ProgressDialogFragment.kt */
public final class ProgressDialogFragment extends BaseDialogFragment {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment$Callback;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Callback;", "onProgressDialogCancelled", "", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aTag", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ProgressDialogFragment.kt */
    public interface Callback extends BaseDialogFragment.Callback {
        void onProgressDialogCancelled(BaseDialogFragment baseDialogFragment, String str);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        ProgressDialog progressDialog = new ProgressDialog(requireContext());
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(BaseDialogFragment.KEY_ARGUMENT);
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.BaseDialogFragment.Param");
            setMParam((BaseDialogFragment.Param) serializable);
        }
        BaseDialogFragment.Param mParam = getMParam();
        if (mParam != null) {
            setCancelable(mParam.getMCancelable$app_prodRelease());
            if (!TextUtils.isEmpty(mParam.getMMessage$app_prodRelease())) {
                progressDialog.setMessage(mParam.getMMessage$app_prodRelease());
            } else {
                View inflate = LayoutInflater.from(requireContext()).inflate(R.layout.view_progressing, (ViewGroup) null);
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setView(inflate);
                AlertDialog create = builder.create();
                Intrinsics.checkNotNullExpressionValue(create, "create(...)");
                return create;
            }
        }
        return progressDialog;
    }

    public void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        Callback callback = (Callback) getCallback$app_prodRelease();
        if (callback != null) {
            callback.onProgressDialogCancelled(this, getDialogTag());
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment$Builder;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Builder;", "aActivity", "Landroidx/fragment/app/FragmentActivity;", "aParentFragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "dialog", "Landroid/content/DialogInterface;", "getDialog", "()Landroid/content/DialogInterface;", "mInstance", "Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment;", "createInstance", "Landroidx/fragment/app/DialogFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ProgressDialogFragment.kt */
    public static final class Builder extends BaseDialogFragment.Builder {
        public static final int $stable = 8;
        private ProgressDialogFragment mInstance;

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

        public final DialogInterface getDialog() {
            return this.mInstance;
        }

        /* access modifiers changed from: protected */
        public DialogFragment createInstance() {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
            this.mInstance = progressDialogFragment;
            Intrinsics.checkNotNull(progressDialogFragment, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment");
            return progressDialogFragment;
        }
    }
}
