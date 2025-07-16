package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Badge.kt */
final class BadgeKt$Badge$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ RowScope $this_Row;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BadgeKt$Badge$1$1(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, RowScope rowScope) {
        super(2);
        this.$content = function3;
        this.$this_Row = rowScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C213@9101L9:Badge.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(719214594, i, -1, "androidx.compose.material3.Badge.<anonymous>.<anonymous> (Badge.kt:213)");
            }
            this.$content.invoke(this.$this_Row, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
