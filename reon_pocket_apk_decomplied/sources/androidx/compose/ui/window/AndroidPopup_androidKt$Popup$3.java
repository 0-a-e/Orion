package androidx.compose.ui.window;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
final class AndroidPopup_androidKt$Popup$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ PopupLayout $popupLayout;
    final /* synthetic */ PopupProperties $properties;
    final /* synthetic */ String $testTag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidPopup_androidKt$Popup$3(PopupLayout popupLayout, Function0<Unit> function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
        super(0);
        this.$popupLayout = popupLayout;
        this.$onDismissRequest = function0;
        this.$properties = popupProperties;
        this.$testTag = str;
        this.$layoutDirection = layoutDirection;
    }

    public final void invoke() {
        this.$popupLayout.updateParameters(this.$onDismissRequest, this.$properties, this.$testTag, this.$layoutDirection);
    }
}
