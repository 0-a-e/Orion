package jp.co.sony.reonpocket.util;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RemoteConfigUtil$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ FirebaseRemoteConfig f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ RemoteConfigUtil.OnFetchFinishListener f$2;

    public /* synthetic */ RemoteConfigUtil$$ExternalSyntheticLambda0(FirebaseRemoteConfig firebaseRemoteConfig, Activity activity, RemoteConfigUtil.OnFetchFinishListener onFetchFinishListener) {
        this.f$0 = firebaseRemoteConfig;
        this.f$1 = activity;
        this.f$2 = onFetchFinishListener;
    }

    public final void onComplete(Task task) {
        RemoteConfigUtil.fetchAndActivate$lambda$0(this.f$0, this.f$1, this.f$2, task);
    }
}
