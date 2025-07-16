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
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonKt$ExtendedFloatingActionButton$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ FloatingActionButtonElevation $elevation;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonKt$ExtendedFloatingActionButton$6(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2) {
        super(2);
        this.$text = function2;
        this.$icon = function22;
        this.$onClick = function0;
        this.$modifier = modifier;
        this.$expanded = z;
        this.$shape = shape;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$elevation = floatingActionButtonElevation;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        FloatingActionButtonKt.m1880ExtendedFloatingActionButtonElI57k(this.$text, this.$icon, this.$onClick, this.$modifier, this.$expanded, this.$shape, this.$containerColor, this.$contentColor, this.$elevation, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
