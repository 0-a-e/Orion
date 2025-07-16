package androidx.compose.ui.window;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
final class AndroidPopup_androidKt$Popup$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ PopupLayout $popupLayout;
    final /* synthetic */ PopupProperties $properties;
    final /* synthetic */ String $testTag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidPopup_androidKt$Popup$2(PopupLayout popupLayout, Function0<Unit> function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
        super(1);
        this.$popupLayout = popupLayout;
        this.$onDismissRequest = function0;
        this.$properties = popupProperties;
        this.$testTag = str;
        this.$layoutDirection = layoutDirection;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        this.$popupLayout.show();
        this.$popupLayout.updateParameters(this.$onDismissRequest, this.$properties, this.$testTag, this.$layoutDirection);
        return new AndroidPopup_androidKt$Popup$2$invoke$$inlined$onDispose$1(this.$popupLayout);
    }
}
