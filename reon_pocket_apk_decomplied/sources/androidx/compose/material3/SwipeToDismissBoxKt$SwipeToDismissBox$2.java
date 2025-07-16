package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissBoxKt$SwipeToDismissBox$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $backgroundContent;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enableDismissFromEndToStart;
    final /* synthetic */ boolean $enableDismissFromStartToEnd;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SwipeToDismissBoxState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissBoxKt$SwipeToDismissBox$2(SwipeToDismissBoxState swipeToDismissBoxState, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z, boolean z2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, int i, int i2) {
        super(2);
        this.$state = swipeToDismissBoxState;
        this.$backgroundContent = function3;
        this.$modifier = modifier;
        this.$enableDismissFromStartToEnd = z;
        this.$enableDismissFromEndToStart = z2;
        this.$content = function32;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SwipeToDismissBoxKt.SwipeToDismissBox(this.$state, this.$backgroundContent, this.$modifier, this.$enableDismissFromStartToEnd, this.$enableDismissFromEndToStart, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
