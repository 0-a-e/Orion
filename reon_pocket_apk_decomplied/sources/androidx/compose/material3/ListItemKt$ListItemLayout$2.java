package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$ListItemLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $headline;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leading;
    final /* synthetic */ Function2<Composer, Integer, Unit> $overline;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supporting;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$ListItemLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, int i) {
        super(2);
        this.$leading = function2;
        this.$trailing = function22;
        this.$headline = function23;
        this.$overline = function24;
        this.$supporting = function25;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ListItemKt.ListItemLayout(this.$leading, this.$trailing, this.$headline, this.$overline, this.$supporting, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
