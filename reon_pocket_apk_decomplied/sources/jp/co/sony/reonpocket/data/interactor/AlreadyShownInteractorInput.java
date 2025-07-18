package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/AlreadyShownInteractorInput;", "Ljp/co/sony/reonpocket/data/interactor/BaseInteractorInput;", "getIsAlreadyShownWelcomeView", "", "aContext", "Landroid/content/Context;", "saveIsAlreadyShownWelcomeView", "", "isShow", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlreadyShownInteractorInput.kt */
public interface AlreadyShownInteractorInput extends BaseInteractorInput {
    boolean getIsAlreadyShownWelcomeView(Context context);

    void saveIsAlreadyShownWelcomeView(Context context, boolean z);
}
