package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
final class LazyLayoutItemContentFactoryKt$SkippableItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $index;
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ Object $key;
    final /* synthetic */ Object $saveableStateHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemContentFactoryKt$SkippableItem$2(LazyLayoutItemProvider lazyLayoutItemProvider, Object obj, int i, Object obj2, int i2) {
        super(2);
        this.$itemProvider = lazyLayoutItemProvider;
        this.$saveableStateHolder = obj;
        this.$index = i;
        this.$key = obj2;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyLayoutItemContentFactoryKt.m868SkippableItemJVlU9Rs(this.$itemProvider, this.$saveableStateHolder, this.$index, this.$key, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
