package androidx.compose.ui.platform;

import android.content.res.Configuration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/res/Configuration;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$configurationChangeObserver$1 extends Lambda implements Function1<Configuration, Unit> {
    public static final AndroidComposeView$configurationChangeObserver$1 INSTANCE = new AndroidComposeView$configurationChangeObserver$1();

    AndroidComposeView$configurationChangeObserver$1() {
        super(1);
    }

    public final void invoke(Configuration configuration) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Configuration) obj);
        return Unit.INSTANCE;
    }
}
