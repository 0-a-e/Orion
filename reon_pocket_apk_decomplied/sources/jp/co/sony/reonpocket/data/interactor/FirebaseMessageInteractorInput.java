package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\tH&J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/FirebaseMessageInteractorInput;", "", "isNeedUpdateTopic", "", "aContext", "Landroid/content/Context;", "aNewTopic", "", "subscribeToTopic", "", "aTopic", "subscribeToTopicAll", "unsubscribeFromTopic", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FirebaseMessageInteractorInput.kt */
public interface FirebaseMessageInteractorInput {
    boolean isNeedUpdateTopic(Context context, String str);

    void subscribeToTopic(Context context, String str);

    void subscribeToTopicAll();

    void unsubscribeFromTopic(Context context, String str);
}
