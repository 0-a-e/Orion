package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/LayoutNode;", "T", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$createAndroidViewNodeFactory$1 extends Lambda implements Function0<LayoutNode> {
    final /* synthetic */ int $compositeKeyHash;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Context, T> $factory;
    final /* synthetic */ View $ownerView;
    final /* synthetic */ CompositionContext $parentReference;
    final /* synthetic */ SaveableStateRegistry $stateRegistry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$createAndroidViewNodeFactory$1(Context context, Function1<? super Context, ? extends T> function1, CompositionContext compositionContext, SaveableStateRegistry saveableStateRegistry, int i, View view) {
        super(0);
        this.$context = context;
        this.$factory = function1;
        this.$parentReference = compositionContext;
        this.$stateRegistry = saveableStateRegistry;
        this.$compositeKeyHash = i;
        this.$ownerView = view;
    }

    public final LayoutNode invoke() {
        Context context = this.$context;
        Function1<Context, T> function1 = this.$factory;
        CompositionContext compositionContext = this.$parentReference;
        SaveableStateRegistry saveableStateRegistry = this.$stateRegistry;
        int i = this.$compositeKeyHash;
        View view = this.$ownerView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
        return new ViewFactoryHolder(context, function1, compositionContext, saveableStateRegistry, i, (Owner) view).getLayoutNode();
    }
}
