package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$LeadingIconTab$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ long $selectedContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $unselectedContentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabKt$LeadingIconTab$3(boolean z, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, int i, int i2) {
        super(2);
        this.$selected = z;
        this.$onClick = function0;
        this.$text = function2;
        this.$icon = function22;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$selectedContentColor = j;
        this.$unselectedContentColor = j2;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TabKt.m2341LeadingIconTabwqdebIU(this.$selected, this.$onClick, this.$text, this.$icon, this.$modifier, this.$enabled, this.$selectedContentColor, this.$unselectedContentColor, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
