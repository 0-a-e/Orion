package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$NavigationBarItem$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ NavigationBarItemColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ RowScope $this_NavigationBarItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationBarKt$NavigationBarItem$4(RowScope rowScope, boolean z, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
        super(2);
        this.$this_NavigationBarItem = rowScope;
        this.$selected = z;
        this.$onClick = function0;
        this.$icon = function2;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$label = function22;
        this.$alwaysShowLabel = z3;
        this.$colors = navigationBarItemColors;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavigationBarKt.NavigationBarItem(this.$this_NavigationBarItem, this.$selected, this.$onClick, this.$icon, this.$modifier, this.$enabled, this.$label, this.$alwaysShowLabel, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
