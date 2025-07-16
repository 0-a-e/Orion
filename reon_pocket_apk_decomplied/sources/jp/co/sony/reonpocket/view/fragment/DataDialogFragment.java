package jp.co.sony.reonpocket.view.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "()V", "mButtonNegative", "Landroid/widget/Button;", "mButtonPositive", "mDialogType", "", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "onResume", "setLifecycleListener", "aListener", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "Builder", "Callback", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataDialogFragment.kt */
public final class DataDialogFragment extends BaseDialogFragment {
    public static final int $stable = 8;
    private Button mButtonNegative;
    private Button mButtonPositive;
    private int mDialogType = -1;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Callback;", "onDataDialogCancelled", "", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "", "onDataDialogSucceeded", "aResultCode", "onDismiss", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataDialogFragment.kt */
    public interface Callback extends BaseDialogFragment.Callback {
        void onDataDialogCancelled(BaseDialogFragment baseDialogFragment, int i);

        void onDataDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2);

        void onDismiss(BaseDialogFragment baseDialogFragment, int i);
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
            if (mParam2.getMView$app_prodRelease() != null) {
                builder.setView(mParam2.getMView$app_prodRelease());
            }
            if (mParam2.getMType$app_prodRelease() != null) {
                Integer mType$app_prodRelease = mParam2.getMType$app_prodRelease();
                Intrinsics.checkNotNull(mType$app_prodRelease);
                this.mDialogType = mType$app_prodRelease.intValue();
                Integer mType$app_prodRelease2 = mParam2.getMType$app_prodRelease();
                int ordinal = BaseDialogFragment.Builder.DialogType.PICKER.ordinal();
                if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal) {
                    View inflate = LayoutInflater.from(requireContext()).inflate(R.layout.view_timer, (ViewGroup) null);
                    Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                    builder.setView(inflate);
                    BaseDialogFragment.DialogFragmentLifecycleListener mListener = getMListener();
                    if (mListener != null) {
                        mListener.onViewCreated(inflate);
                    }
                } else {
                    int ordinal2 = BaseDialogFragment.Builder.DialogType.RADIO.ordinal();
                    if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal2) {
                        View inflate2 = LayoutInflater.from(requireContext()).inflate(R.layout.view_duration, (ViewGroup) null);
                        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                        builder.setView(inflate2);
                        BaseDialogFragment.DialogFragmentLifecycleListener mListener2 = getMListener();
                        if (mListener2 != null) {
                            mListener2.onViewCreated(inflate2);
                        }
                    } else {
                        int ordinal3 = BaseDialogFragment.Builder.DialogType.INFORMATION.ordinal();
                        if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal3) {
                            View inflate3 = LayoutInflater.from(requireContext()).inflate(R.layout.view_information, (ViewGroup) null);
                            Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
                            builder.setView(inflate3);
                            BaseDialogFragment.DialogFragmentLifecycleListener mListener3 = getMListener();
                            if (mListener3 != null) {
                                mListener3.onViewCreated(inflate3);
                            }
                        } else {
                            int ordinal4 = BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_2.ordinal();
                            if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal4) {
                                View inflate4 = LayoutInflater.from(requireContext()).inflate(R.layout.view_information_with_button, (ViewGroup) null);
                                Intrinsics.checkNotNullExpressionValue(inflate4, "inflate(...)");
                                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) inflate4.findViewById(R.id.info_close);
                                if (appCompatImageButton != null) {
                                    appCompatImageButton.setOnClickListener(new DataDialogFragment$$ExternalSyntheticLambda0(this));
                                }
                                builder.setView(inflate4);
                                BaseDialogFragment.DialogFragmentLifecycleListener mListener4 = getMListener();
                                if (mListener4 != null) {
                                    mListener4.onViewCreated(inflate4);
                                }
                            } else {
                                int ordinal5 = BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_3.ordinal();
                                if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal5) {
                                    View inflate5 = LayoutInflater.from(requireContext()).inflate(R.layout.view_information_auto_start, (ViewGroup) null);
                                    Intrinsics.checkNotNullExpressionValue(inflate5, "inflate(...)");
                                    this.mButtonPositive = (Button) inflate5.findViewById(R.id.button_positive);
                                    this.mButtonNegative = (Button) inflate5.findViewById(R.id.button_negative);
                                    builder.setView(inflate5);
                                    BaseDialogFragment.DialogFragmentLifecycleListener mListener5 = getMListener();
                                    if (mListener5 != null) {
                                        mListener5.onViewCreated(inflate5);
                                    }
                                } else {
                                    int ordinal6 = BaseDialogFragment.Builder.DialogType.EULA_PP.ordinal();
                                    if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal6) {
                                        View inflate6 = LayoutInflater.from(requireContext()).inflate(R.layout.view_information_eula_updated, (ViewGroup) null);
                                        Intrinsics.checkNotNullExpressionValue(inflate6, "inflate(...)");
                                        Button button = (Button) inflate6.findViewById(R.id.ok_button);
                                        if (button != null) {
                                            button.setOnClickListener(new DataDialogFragment$$ExternalSyntheticLambda1(this));
                                        }
                                        builder.setView(inflate6);
                                        BaseDialogFragment.DialogFragmentLifecycleListener mListener6 = getMListener();
                                        if (mListener6 != null) {
                                            mListener6.onViewCreated(inflate6);
                                        }
                                    } else {
                                        int ordinal7 = BaseDialogFragment.Builder.DialogType.PASSWORD.ordinal();
                                        if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal7) {
                                            View inflate7 = LayoutInflater.from(requireContext()).inflate(R.layout.view_password_input, (ViewGroup) null);
                                            Intrinsics.checkNotNullExpressionValue(inflate7, "inflate(...)");
                                            builder.setView(inflate7);
                                            BaseDialogFragment.DialogFragmentLifecycleListener mListener7 = getMListener();
                                            if (mListener7 != null) {
                                                mListener7.onViewCreated(inflate7);
                                            }
                                        } else {
                                            int ordinal8 = BaseDialogFragment.Builder.DialogType.PROGRESS.ordinal();
                                            if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal8) {
                                                View inflate8 = LayoutInflater.from(requireContext()).inflate(R.layout.view_progress, (ViewGroup) null);
                                                Intrinsics.checkNotNullExpressionValue(inflate8, "inflate(...)");
                                                builder.setView(inflate8);
                                                BaseDialogFragment.DialogFragmentLifecycleListener mListener8 = getMListener();
                                                if (mListener8 != null) {
                                                    mListener8.onViewCreated(inflate8);
                                                }
                                            } else {
                                                int ordinal9 = BaseDialogFragment.Builder.DialogType.TAG_SINGLE_BUTTON.ordinal();
                                                if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal9) {
                                                    View inflate9 = LayoutInflater.from(requireContext()).inflate(R.layout.view_tag_register, (ViewGroup) null);
                                                    Intrinsics.checkNotNullExpressionValue(inflate9, "inflate(...)");
                                                    this.mButtonPositive = (Button) inflate9.findViewById(R.id.positive_button);
                                                    Button button2 = (Button) inflate9.findViewById(R.id.negative_button);
                                                    this.mButtonNegative = button2;
                                                    if (button2 != null) {
                                                        button2.setVisibility(8);
                                                    }
                                                    builder.setView(inflate9);
                                                    BaseDialogFragment.DialogFragmentLifecycleListener mListener9 = getMListener();
                                                    if (mListener9 != null) {
                                                        mListener9.onViewCreated(inflate9);
                                                    }
                                                } else {
                                                    int ordinal10 = BaseDialogFragment.Builder.DialogType.TAG_DOUBLE_BUTTON.ordinal();
                                                    if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal10) {
                                                        View inflate10 = LayoutInflater.from(requireContext()).inflate(R.layout.view_tag_register, (ViewGroup) null);
                                                        Intrinsics.checkNotNullExpressionValue(inflate10, "inflate(...)");
                                                        this.mButtonPositive = (Button) inflate10.findViewById(R.id.positive_button);
                                                        this.mButtonNegative = (Button) inflate10.findViewById(R.id.negative_button);
                                                        builder.setView(inflate10);
                                                        BaseDialogFragment.DialogFragmentLifecycleListener mListener10 = getMListener();
                                                        if (mListener10 != null) {
                                                            mListener10.onViewCreated(inflate10);
                                                        }
                                                    } else {
                                                        int ordinal11 = BaseDialogFragment.Builder.DialogType.SETTING_MENU_POPUP.ordinal();
                                                        if (mType$app_prodRelease2 != null && mType$app_prodRelease2.intValue() == ordinal11) {
                                                            View inflate11 = LayoutInflater.from(requireContext()).inflate(R.layout.view_setting_menu_popup, (ViewGroup) null);
                                                            Intrinsics.checkNotNullExpressionValue(inflate11, "inflate(...)");
                                                            builder.setView(inflate11);
                                                            BaseDialogFragment.DialogFragmentLifecycleListener mListener11 = getMListener();
                                                            if (mListener11 != null) {
                                                                mListener11.onViewCreated(inflate11);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (mParam2.getMViewRes$app_prodRelease() != null) {
                LayoutInflater from = LayoutInflater.from(requireContext());
                Integer mViewRes$app_prodRelease = mParam2.getMViewRes$app_prodRelease();
                Intrinsics.checkNotNull(mViewRes$app_prodRelease);
                builder.setView(from.inflate(mViewRes$app_prodRelease.intValue(), (ViewGroup) null));
            }
            if (!TextUtils.isEmpty(mParam2.getMPositiveLabel$app_prodRelease())) {
                builder.setPositiveButton((CharSequence) mParam2.getMPositiveLabel$app_prodRelease(), (DialogInterface.OnClickListener) new DataDialogFragment$$ExternalSyntheticLambda2(this));
            }
            if (!TextUtils.isEmpty(mParam2.getMNegativeLabel$app_prodRelease())) {
                builder.setNegativeButton((CharSequence) mParam2.getMNegativeLabel$app_prodRelease(), (DialogInterface.OnClickListener) new DataDialogFragment$$ExternalSyntheticLambda3(this));
            }
        }
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4$lambda$0(DataDialogFragment dataDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(dataDialogFragment, "this$0");
        dataDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4$lambda$1(DataDialogFragment dataDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(dataDialogFragment, "this$0");
        dataDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4$lambda$2(DataDialogFragment dataDialogFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dataDialogFragment, "this$0");
        dataDialogFragment.dismiss();
        Callback callback = (Callback) dataDialogFragment.getCallback$app_prodRelease();
        if (callback != null) {
            callback.onDataDialogSucceeded(dataDialogFragment, dataDialogFragment.getRequestCode(), -1);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4$lambda$3(DataDialogFragment dataDialogFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dataDialogFragment, "this$0");
        dataDialogFragment.dismiss();
        Callback callback = (Callback) dataDialogFragment.getCallback$app_prodRelease();
        if (callback != null) {
            callback.onDataDialogSucceeded(dataDialogFragment, dataDialogFragment.getRequestCode(), -2);
        }
    }

    public final void setLifecycleListener(BaseDialogFragment.DialogFragmentLifecycleListener dialogFragmentLifecycleListener) {
        Intrinsics.checkNotNullParameter(dialogFragmentLifecycleListener, "aListener");
        setMListener(dialogFragmentLifecycleListener);
    }

    public void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        Callback callback = (Callback) getCallback$app_prodRelease();
        if (callback != null) {
            callback.onDataDialogCancelled(this, getRequestCode());
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Callback callback = (Callback) getCallback$app_prodRelease();
        if (callback != null) {
            callback.onDismiss(this, getRequestCode());
        }
    }

    public void onResume() {
        Dialog dialog;
        Window window;
        super.onResume();
        if ((this.mDialogType == BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_2.ordinal() || this.mDialogType == BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_3.ordinal()) && (dialog = getDialog()) != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawableResource(17170445);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Builder;", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Builder;", "aActivity", "Landroidx/fragment/app/FragmentActivity;", "aParentFragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "createInstance", "Landroidx/fragment/app/DialogFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataDialogFragment.kt */
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
            return new DataDialogFragment();
        }
    }
}
