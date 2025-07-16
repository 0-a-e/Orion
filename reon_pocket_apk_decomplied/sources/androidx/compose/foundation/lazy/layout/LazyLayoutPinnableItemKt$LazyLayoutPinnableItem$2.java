package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPinnableItem.kt */
final class LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ int $index;
    final /* synthetic */ Object $key;
    final /* synthetic */ LazyLayoutPinnedItemList $pinnedItemList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$2(Object obj, int i, LazyLayoutPinnedItemList lazyLayoutPinnedItemList, Function2<? super Composer, ? super Integer, Unit> function2, int i2) {
        super(2);
        this.$key = obj;
        this.$index = i;
        this.$pinnedItemList = lazyLayoutPinnedItemList;
        this.$content = function2;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(this.$key, this.$index, this.$pinnedItemList, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
