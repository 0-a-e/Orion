package jp.co.sony.reonpocket.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.DialogBuilderUtil;
import jp.co.sony.reonpocket.view.CustomImageView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/util/DialogBuilderUtil$tagSingleButtonDialog$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DialogBuilderUtil.kt */
public final class DialogBuilderUtil$tagSingleButtonDialog$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ FragmentActivity $aActivity;
    final /* synthetic */ DialogSingleActionListener $callback;
    final /* synthetic */ DataDialogFragment $dataDialogFragment;
    final /* synthetic */ DialogBuilderUtil.TagDialogEntity $tagDialogEntity;

    DialogBuilderUtil$tagSingleButtonDialog$1(DialogBuilderUtil.TagDialogEntity tagDialogEntity, FragmentActivity fragmentActivity, DialogSingleActionListener dialogSingleActionListener, DataDialogFragment dataDialogFragment) {
        this.$tagDialogEntity = tagDialogEntity;
        this.$aActivity = fragmentActivity;
        this.$callback = dialogSingleActionListener;
        this.$dataDialogFragment = dataDialogFragment;
    }

    public void onViewCreated(View view) {
        Unit unit;
        Unit unit2;
        Intrinsics.checkNotNullParameter(view, "aView");
        TextView textView = (TextView) view.findViewById(R.id.tag_dialog_title);
        if (textView != null) {
            textView.setText(this.$tagDialogEntity.getTitle());
        }
        TextView textView2 = (TextView) view.findViewById(R.id.tag_dialog_message);
        String message = this.$tagDialogEntity.getMessage();
        Unit unit3 = null;
        if (message != null) {
            if (textView2 != null) {
                textView2.setText(message);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null && textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.tag_dialog_model);
        String modelName = this.$tagDialogEntity.getModelName();
        if (modelName != null) {
            FragmentActivity fragmentActivity = this.$aActivity;
            if (textView3 != null) {
                textView3.setText(fragmentActivity.getString(R.string.tag_registration_model_name, new Object[]{modelName}));
            }
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null && textView3 != null) {
            textView3.setVisibility(8);
        }
        TextView textView4 = (TextView) view.findViewById(R.id.tag_dialog_serial_no);
        String serialNo = this.$tagDialogEntity.getSerialNo();
        if (serialNo != null) {
            FragmentActivity fragmentActivity2 = this.$aActivity;
            if (textView4 != null) {
                textView4.setText(fragmentActivity2.getString(R.string.tag_registration_serial_number, new Object[]{serialNo}));
            }
            unit3 = Unit.INSTANCE;
        }
        if (unit3 == null && textView4 != null) {
            textView4.setVisibility(8);
        }
        Button button = (Button) view.findViewById(R.id.positive_button);
        if (button != null) {
            button.setText(this.$tagDialogEntity.getPositiveButtonText());
        }
        if (button != null) {
            button.setOnClickListener(new DialogBuilderUtil$tagSingleButtonDialog$1$$ExternalSyntheticLambda0(this.$callback, this.$dataDialogFragment));
        }
        Float messageFontSize = this.$tagDialogEntity.getMessageFontSize();
        if (messageFontSize != null) {
            float floatValue = messageFontSize.floatValue();
            if (textView2 != null) {
                textView2.setTextSize(floatValue);
            }
        }
        if (this.$tagDialogEntity.isPositiveButtonDelayAppear()) {
            if (button != null) {
                button.setVisibility(4);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new DialogBuilderUtil$tagSingleButtonDialog$1$$ExternalSyntheticLambda1(button), 5000);
        }
        CustomImageView customImageView = (CustomImageView) view.findViewById(R.id.tag_dialog_image);
        if (Intrinsics.areEqual((Object) this.$tagDialogEntity.getTitle(), (Object) this.$aActivity.getString(R.string.tag_dfu_start_title))) {
            if (customImageView != null) {
                customImageView.setImageResource(R.drawable.img_tag_register);
            }
            if (button != null) {
                button.setTextSize(0, button.getTextSize() * 1.5f);
            }
        } else if (customImageView != null) {
            customImageView.setImageResource(R.drawable.img_tag);
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(DialogSingleActionListener dialogSingleActionListener, DataDialogFragment dataDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogSingleActionListener, "$callback");
        Intrinsics.checkNotNullParameter(dataDialogFragment, "$dataDialogFragment");
        dialogSingleActionListener.positiveButtonAction();
        dataDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8(Button button) {
        if (button != null) {
            button.setVisibility(0);
        }
    }
}
