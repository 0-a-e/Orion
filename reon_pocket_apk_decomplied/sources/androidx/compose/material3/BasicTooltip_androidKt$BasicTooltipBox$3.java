package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTooltip.android.kt */
final class BasicTooltip_androidKt$BasicTooltipBox$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enableUserInput;
    final /* synthetic */ boolean $focusable;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ PopupPositionProvider $positionProvider;
    final /* synthetic */ BasicTooltipState $state;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tooltip;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTooltip_androidKt$BasicTooltipBox$3(PopupPositionProvider popupPositionProvider, Function2<? super Composer, ? super Integer, Unit> function2, BasicTooltipState basicTooltipState, Modifier modifier, boolean z, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, int i, int i2) {
        super(2);
        this.$positionProvider = popupPositionProvider;
        this.$tooltip = function2;
        this.$state = basicTooltipState;
        this.$modifier = modifier;
        this.$focusable = z;
        this.$enableUserInput = z2;
        this.$content = function22;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BasicTooltip_androidKt.BasicTooltipBox(this.$positionProvider, this.$tooltip, this.$state, this.$modifier, this.$focusable, this.$enableUserInput, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
