package androidx.compose.material3.internal;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.android.kt */
final class ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ PopupLayout $popupLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1(PopupLayout popupLayout, Function0<Unit> function0, LayoutDirection layoutDirection) {
        super(1);
        this.$popupLayout = popupLayout;
        this.$onDismissRequest = function0;
        this.$layoutDirection = layoutDirection;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        this.$popupLayout.show();
        this.$popupLayout.updateParameters(this.$onDismissRequest, this.$layoutDirection);
        return new ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1$invoke$$inlined$onDispose$1(this.$popupLayout);
    }
}
