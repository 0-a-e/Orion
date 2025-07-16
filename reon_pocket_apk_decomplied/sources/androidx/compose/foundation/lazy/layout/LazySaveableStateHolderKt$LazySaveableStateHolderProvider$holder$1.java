package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySaveableStateHolder.kt */
final class LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1 extends Lambda implements Function0<LazySaveableStateHolder> {
    final /* synthetic */ SaveableStateRegistry $currentRegistry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1(SaveableStateRegistry saveableStateRegistry) {
        super(0);
        this.$currentRegistry = saveableStateRegistry;
    }

    public final LazySaveableStateHolder invoke() {
        return new LazySaveableStateHolder(this.$currentRegistry, MapsKt.emptyMap());
    }
}
