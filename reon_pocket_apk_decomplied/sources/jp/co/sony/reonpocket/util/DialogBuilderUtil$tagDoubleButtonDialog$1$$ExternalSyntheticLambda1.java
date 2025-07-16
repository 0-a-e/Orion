package jp.co.sony.reonpocket.util;

import android.view.View;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DialogBuilderUtil$tagDoubleButtonDialog$1$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ DialogDoubleActionListener f$0;
    public final /* synthetic */ DataDialogFragment f$1;

    public /* synthetic */ DialogBuilderUtil$tagDoubleButtonDialog$1$$ExternalSyntheticLambda1(DialogDoubleActionListener dialogDoubleActionListener, DataDialogFragment dataDialogFragment) {
        this.f$0 = dialogDoubleActionListener;
        this.f$1 = dataDialogFragment;
    }

    public final void onClick(View view) {
        DialogBuilderUtil$tagDoubleButtonDialog$1.onViewCreated$lambda$1(this.f$0, this.f$1, view);
    }
}
