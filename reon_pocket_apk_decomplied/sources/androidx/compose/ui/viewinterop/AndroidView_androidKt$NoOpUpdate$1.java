package androidx.compose.ui.viewinterop;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$NoOpUpdate$1 extends Lambda implements Function1<View, Unit> {
    public static final AndroidView_androidKt$NoOpUpdate$1 INSTANCE = new AndroidView_androidKt$NoOpUpdate$1();

    AndroidView_androidKt$NoOpUpdate$1() {
        super(1);
    }

    public final void invoke(View view) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }
}
