package androidx.compose.ui.platform;

import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$removeAndroidView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidViewHolder $view;
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$removeAndroidView$1(AndroidComposeView androidComposeView, AndroidViewHolder androidViewHolder) {
        super(0);
        this.this$0 = androidComposeView;
        this.$view = androidViewHolder;
    }

    public final void invoke() {
        this.this$0.getAndroidViewsHandler$ui_release().removeViewInLayout(this.$view);
        TypeIntrinsics.asMutableMap(this.this$0.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder()).remove(this.this$0.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(this.$view));
        ViewCompat.setImportantForAccessibility(this.$view, 0);
    }
}
