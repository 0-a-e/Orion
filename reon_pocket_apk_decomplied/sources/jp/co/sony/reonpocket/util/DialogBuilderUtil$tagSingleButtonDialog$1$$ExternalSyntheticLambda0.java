package jp.co.sony.reonpocket.util;

import android.view.View;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DialogBuilderUtil$tagSingleButtonDialog$1$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ DialogSingleActionListener f$0;
    public final /* synthetic */ DataDialogFragment f$1;

    public /* synthetic */ DialogBuilderUtil$tagSingleButtonDialog$1$$ExternalSyntheticLambda0(DialogSingleActionListener dialogSingleActionListener, DataDialogFragment dataDialogFragment) {
        this.f$0 = dialogSingleActionListener;
        this.f$1 = dataDialogFragment;
    }

    public final void onClick(View view) {
        DialogBuilderUtil$tagSingleButtonDialog$1.onViewCreated$lambda$6(this.f$0, this.f$1, view);
    }
}
