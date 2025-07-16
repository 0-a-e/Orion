package jp.co.sony.reonpocket.util;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.DialogBuilderUtil;
import jp.co.sony.reonpocket.view.CustomImageView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/util/DialogBuilderUtil$tagDoubleButtonDialog$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DialogBuilderUtil.kt */
public final class DialogBuilderUtil$tagDoubleButtonDialog$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ FragmentActivity $aActivity;
    final /* synthetic */ DialogDoubleActionListener $callback;
    final /* synthetic */ DataDialogFragment $dataDialogFragment;
    final /* synthetic */ DialogBuilderUtil.TagDialogEntity $tagDialogEntity;

    DialogBuilderUtil$tagDoubleButtonDialog$1(DialogBuilderUtil.TagDialogEntity tagDialogEntity, FragmentActivity fragmentActivity, DialogDoubleActionListener dialogDoubleActionListener, DataDialogFragment dataDialogFragment) {
        this.$tagDialogEntity = tagDialogEntity;
        this.$aActivity = fragmentActivity;
        this.$callback = dialogDoubleActionListener;
        this.$dataDialogFragment = dataDialogFragment;
    }

    public void onViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "aView");
        TextView textView = (TextView) view.findViewById(R.id.tag_dialog_title);
        if (textView != null) {
            textView.setText(this.$tagDialogEntity.getTitle());
        }
        CustomImageView customImageView = (CustomImageView) view.findViewById(R.id.tag_dialog_image);
        String title = this.$tagDialogEntity.getTitle();
        if (Intrinsics.areEqual((Object) title, (Object) this.$aActivity.getString(R.string.tag_registration_discovered_title))) {
            if (customImageView != null) {
                customImageView.setImageResource(R.drawable.img_tag_serial_number);
            }
        } else if (Intrinsics.areEqual((Object) title, (Object) this.$aActivity.getString(R.string.tag_registration_start_title))) {
            if (customImageView != null) {
                customImageView.setImageResource(R.drawable.img_tag_register);
            }
        } else if (customImageView != null) {
            customImageView.setImageResource(R.drawable.img_tag);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.tag_dialog_message);
        if (textView2 != null) {
            textView2.setText(this.$tagDialogEntity.getMessage());
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tag_dialog_model_layout);
        TextView textView3 = (TextView) view.findViewById(R.id.tag_dialog_model);
        if (this.$tagDialogEntity.getModelName() != null) {
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            if (textView3 != null) {
                textView3.setText(this.$aActivity.getString(R.string.tag_registration_model_name, new Object[]{this.$tagDialogEntity.getModelName()}));
            }
        } else if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.tag_dialog_serial_no_layout);
        TextView textView4 = (TextView) view.findViewById(R.id.tag_dialog_serial_no);
        if (this.$tagDialogEntity.getSerialNo() != null) {
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            if (textView4 != null) {
                textView4.setText(this.$aActivity.getString(R.string.tag_registration_serial_number, new Object[]{this.$tagDialogEntity.getSerialNo()}));
            }
        } else if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        Button button = (Button) view.findViewById(R.id.positive_button);
        if (button != null) {
            button.setText(this.$tagDialogEntity.getPositiveButtonText());
        }
        if (button != null) {
            button.setOnClickListener(new DialogBuilderUtil$tagDoubleButtonDialog$1$$ExternalSyntheticLambda0(this.$callback, this.$dataDialogFragment));
        }
        Button button2 = (Button) view.findViewById(R.id.negative_button);
        if (button2 != null) {
            button2.setText(this.$tagDialogEntity.getNegativeButtonText());
        }
        if (button2 != null) {
            button2.setOnClickListener(new DialogBuilderUtil$tagDoubleButtonDialog$1$$ExternalSyntheticLambda1(this.$callback, this.$dataDialogFragment));
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(DialogDoubleActionListener dialogDoubleActionListener, DataDialogFragment dataDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogDoubleActionListener, "$callback");
        Intrinsics.checkNotNullParameter(dataDialogFragment, "$dataDialogFragment");
        dialogDoubleActionListener.positiveButtonAction();
        dataDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(DialogDoubleActionListener dialogDoubleActionListener, DataDialogFragment dataDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogDoubleActionListener, "$callback");
        Intrinsics.checkNotNullParameter(dataDialogFragment, "$dataDialogFragment");
        dialogDoubleActionListener.negativeButtonAction();
        dataDialogFragment.dismiss();
    }
}
