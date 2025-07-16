package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/FirebaseMessageInteractor;", "Ljp/co/sony/reonpocket/data/interactor/FirebaseMessageInteractorInput;", "()V", "isNeedUpdateTopic", "", "aContext", "Landroid/content/Context;", "aNewTopic", "", "subscribeToTopic", "", "aTopic", "subscribeToTopicAll", "unsubscribeFromTopic", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FirebaseMessageInteractor.kt */
public final class FirebaseMessageInteractor implements FirebaseMessageInteractorInput {
    public static final int $stable = 0;

    public void unsubscribeFromTopic(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aTopic");
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null)) {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(str).addOnCompleteListener(new FirebaseMessageInteractor$$ExternalSyntheticLambda0(str));
        }
    }

    /* access modifiers changed from: private */
    public static final void unsubscribeFromTopic$lambda$0(String str, Task task) {
        Intrinsics.checkNotNullParameter(str, "$aTopic");
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.e("unsubscribe topic:" + str + " failed");
        }
    }

    public void subscribeToTopic(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aTopic");
        FirebaseMessaging.getInstance().subscribeToTopic(str).addOnCompleteListener(new FirebaseMessageInteractor$$ExternalSyntheticLambda1(context, str));
    }

    /* access modifiers changed from: private */
    public static final void subscribeToTopic$lambda$1(Context context, String str, Task task) {
        Intrinsics.checkNotNullParameter(context, "$aContext");
        Intrinsics.checkNotNullParameter(str, "$aTopic");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            new UserInfoInteractor().saveTopic(context, str);
        }
    }

    public void subscribeToTopicAll() {
        FirebaseMessaging.getInstance().subscribeToTopic("all");
    }

    public boolean isNeedUpdateTopic(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aNewTopic");
        return !Intrinsics.areEqual((Object) new UserInfoInteractor().getTopic(context), (Object) str);
    }
}
