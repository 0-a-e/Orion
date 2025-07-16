package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "element", "Landroidx/compose/ui/Modifier$Element;", "invoke", "(Landroidx/compose/ui/Modifier$Element;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeChain.kt */
final class NodeChainKt$fillVector$1 extends Lambda implements Function1<Modifier.Element, Boolean> {
    final /* synthetic */ MutableVector<Modifier.Element> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodeChainKt$fillVector$1(MutableVector<Modifier.Element> mutableVector) {
        super(1);
        this.$result = mutableVector;
    }

    public final Boolean invoke(Modifier.Element element) {
        this.$result.add(element);
        return true;
    }
}
