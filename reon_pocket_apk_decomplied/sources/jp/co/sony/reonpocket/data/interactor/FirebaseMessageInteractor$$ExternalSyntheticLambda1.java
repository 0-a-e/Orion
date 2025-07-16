package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FirebaseMessageInteractor$$ExternalSyntheticLambda1 implements OnCompleteListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ FirebaseMessageInteractor$$ExternalSyntheticLambda1(Context context, String str) {
        this.f$0 = context;
        this.f$1 = str;
    }

    public final void onComplete(Task task) {
        FirebaseMessageInteractor.subscribeToTopic$lambda$1(this.f$0, this.f$1, task);
    }
}
