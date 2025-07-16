package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
final class LazyLayoutItemContentFactoryKt$SkippableItem$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ Object $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemContentFactoryKt$SkippableItem$1(LazyLayoutItemProvider lazyLayoutItemProvider, int i, Object obj) {
        super(2);
        this.$itemProvider = lazyLayoutItemProvider;
        this.$index = i;
        this.$key = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C134@4764L22:LazyLayoutItemContentFactory.kt#wow0x6");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(980966366, i, -1, "androidx.compose.foundation.lazy.layout.SkippableItem.<anonymous> (LazyLayoutItemContentFactory.kt:134)");
            }
            this.$itemProvider.Item(this.$index, this.$key, composer, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
