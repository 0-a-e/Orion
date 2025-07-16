package androidx.compose.ui.layout;

import androidx.compose.ui.layout.SubcomposeLayoutState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "", "", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "invoke", "(Ljava/util/Map$Entry;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class LayoutNodeSubcompositionsState$disposeUnusedSlotsInPostLookahead$1 extends Lambda implements Function1<Map.Entry<Object, SubcomposeLayoutState.PrecomposedSlotHandle>, Boolean> {
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeSubcompositionsState$disposeUnusedSlotsInPostLookahead$1(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        super(1);
        this.this$0 = layoutNodeSubcompositionsState;
    }

    public final Boolean invoke(Map.Entry<Object, SubcomposeLayoutState.PrecomposedSlotHandle> entry) {
        boolean z;
        Object key = entry.getKey();
        SubcomposeLayoutState.PrecomposedSlotHandle value = entry.getValue();
        int indexOf = this.this$0.postLookaheadComposedSlotIds.indexOf(key);
        if (indexOf < 0 || indexOf >= this.this$0.currentPostLookaheadIndex) {
            value.dispose();
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
