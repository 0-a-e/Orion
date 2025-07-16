package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissBoxKt$SwipeToDismiss$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $background;
    final /* synthetic */ Set<SwipeToDismissBoxValue> $directions;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $dismissContent;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SwipeToDismissBoxState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissBoxKt$SwipeToDismiss$1(SwipeToDismissBoxState swipeToDismissBoxState, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, Modifier modifier, Set<? extends SwipeToDismissBoxValue> set, int i, int i2) {
        super(2);
        this.$state = swipeToDismissBoxState;
        this.$background = function3;
        this.$dismissContent = function32;
        this.$modifier = modifier;
        this.$directions = set;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SwipeToDismissBoxKt.SwipeToDismiss(this.$state, this.$background, this.$dismissContent, this.$modifier, this.$directions, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
