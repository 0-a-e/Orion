package androidx.compose.ui.platform;

import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$viewTreeOwners$2 extends Lambda implements Function0<AndroidComposeView.ViewTreeOwners> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$viewTreeOwners$2(AndroidComposeView androidComposeView) {
        super(0);
        this.this$0 = androidComposeView;
    }

    public final AndroidComposeView.ViewTreeOwners invoke() {
        return this.this$0.get_viewTreeOwners();
    }
}
