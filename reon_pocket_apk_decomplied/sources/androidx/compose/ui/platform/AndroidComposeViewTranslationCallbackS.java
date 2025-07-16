package androidx.compose.ui.platform;

import android.view.View;
import android.view.translation.ViewTranslationCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewTranslationCallbackS;", "", "()V", "clearViewTranslationCallback", "", "view", "Landroid/view/View;", "setViewTranslationCallback", "translationCallback", "Landroid/view/translation/ViewTranslationCallback;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeViewTranslationCallbackS {
    public static final int $stable = 0;
    public static final AndroidComposeViewTranslationCallbackS INSTANCE = new AndroidComposeViewTranslationCallbackS();

    private AndroidComposeViewTranslationCallbackS() {
    }

    public final void setViewTranslationCallback(View view, ViewTranslationCallback viewTranslationCallback) {
        view.setViewTranslationCallback(viewTranslationCallback);
    }

    public final void clearViewTranslationCallback(View view) {
        RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(view);
    }
}
