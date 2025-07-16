package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$NavigationDrawerItem$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $badge;
    final /* synthetic */ NavigationDrawerItemColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$NavigationDrawerItem$4(Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
        super(2);
        this.$label = function2;
        this.$selected = z;
        this.$onClick = function0;
        this.$modifier = modifier;
        this.$icon = function22;
        this.$badge = function23;
        this.$shape = shape;
        this.$colors = navigationDrawerItemColors;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavigationDrawerKt.NavigationDrawerItem(this.$label, this.$selected, this.$onClick, this.$modifier, this.$icon, this.$badge, this.$shape, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
