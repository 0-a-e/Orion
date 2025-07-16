package jp.co.sony.reonpocket.data.interactor;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FirebaseMessageInteractor$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ String f$0;

    public /* synthetic */ FirebaseMessageInteractor$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    public final void onComplete(Task task) {
        FirebaseMessageInteractor.unsubscribeFromTopic$lambda$0(this.f$0, task);
    }
}
