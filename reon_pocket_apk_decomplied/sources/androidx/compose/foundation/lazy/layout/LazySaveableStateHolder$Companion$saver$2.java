package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "restored", "", "", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySaveableStateHolder.kt */
final class LazySaveableStateHolder$Companion$saver$2 extends Lambda implements Function1<Map<String, ? extends List<? extends Object>>, LazySaveableStateHolder> {
    final /* synthetic */ SaveableStateRegistry $parentRegistry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySaveableStateHolder$Companion$saver$2(SaveableStateRegistry saveableStateRegistry) {
        super(1);
        this.$parentRegistry = saveableStateRegistry;
    }

    public final LazySaveableStateHolder invoke(Map<String, ? extends List<? extends Object>> map) {
        return new LazySaveableStateHolder(this.$parentRegistry, map);
    }
}
