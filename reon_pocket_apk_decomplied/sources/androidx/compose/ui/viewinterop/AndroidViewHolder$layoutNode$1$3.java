package androidx.compose.ui.viewinterop;

import android.view.ViewParent;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "owner", "Landroidx/compose/ui/node/Owner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
final class AndroidViewHolder$layoutNode$1$3 extends Lambda implements Function1<Owner, Unit> {
    final /* synthetic */ LayoutNode $layoutNode;
    final /* synthetic */ AndroidViewHolder $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$3(AndroidViewHolder androidViewHolder, LayoutNode layoutNode) {
        super(1);
        this.$this_run = androidViewHolder;
        this.$layoutNode = layoutNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Owner) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Owner owner) {
        AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
        if (androidComposeView != null) {
            androidComposeView.addAndroidView(this.$this_run, this.$layoutNode);
        }
        ViewParent parent = this.$this_run.getView().getParent();
        AndroidViewHolder androidViewHolder = this.$this_run;
        if (parent != androidViewHolder) {
            androidViewHolder.addView(androidViewHolder.getView());
        }
    }
}
