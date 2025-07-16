package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/AlreadyShownInteractor;", "Ljp/co/sony/reonpocket/data/interactor/AlreadyShownInteractorInput;", "()V", "getIsAlreadyShownWelcomeView", "", "aContext", "Landroid/content/Context;", "saveIsAlreadyShownWelcomeView", "", "isShow", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlreadyShownInteractor.kt */
public final class AlreadyShownInteractor implements AlreadyShownInteractorInput {
    public static final int $stable = 0;

    public void saveIsAlreadyShownWelcomeView(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.IS_ALREADY_DISPLAY_WELCOME_VIEW, z);
    }

    public boolean getIsAlreadyShownWelcomeView(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.IS_ALREADY_DISPLAY_WELCOME_VIEW, false);
    }
}
