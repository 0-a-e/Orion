package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: LazyGridDsl.kt */
public final class LazyGridDslKt$items$10 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
    final /* synthetic */ T[] $items;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$items$10(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
        super(4);
        this.$itemContent = function4;
        this.$items = tArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "C527@22869L22:LazyGridDsl.kt#7791vq");
        if ((i2 & 14) == 0) {
            i3 = (composer.changed((Object) lazyGridItemScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if ((i3 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407562193, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:527)");
            }
            this.$itemContent.invoke(lazyGridItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
