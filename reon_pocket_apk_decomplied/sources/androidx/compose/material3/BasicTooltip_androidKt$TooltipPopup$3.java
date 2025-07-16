package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTooltip.android.kt */
final class BasicTooltip_androidKt$TooltipPopup$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $focusable;
    final /* synthetic */ PopupPositionProvider $positionProvider;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ BasicTooltipState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTooltip_androidKt$TooltipPopup$3(PopupPositionProvider popupPositionProvider, BasicTooltipState basicTooltipState, CoroutineScope coroutineScope, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$positionProvider = popupPositionProvider;
        this.$state = basicTooltipState;
        this.$scope = coroutineScope;
        this.$focusable = z;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BasicTooltip_androidKt.TooltipPopup(this.$positionProvider, this.$state, this.$scope, this.$focusable, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
