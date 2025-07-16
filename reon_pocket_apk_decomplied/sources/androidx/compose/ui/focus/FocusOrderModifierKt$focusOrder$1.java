package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/focus/FocusProperties;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOrderModifier.kt */
final class FocusOrderModifierKt$focusOrder$1 extends Lambda implements Function1<FocusProperties, Unit> {
    final /* synthetic */ FocusOrderToProperties $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusOrderModifierKt$focusOrder$1(FocusOrderToProperties focusOrderToProperties) {
        super(1);
        this.$scope = focusOrderToProperties;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusProperties) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusProperties focusProperties) {
        this.$scope.apply(focusProperties);
    }
}
