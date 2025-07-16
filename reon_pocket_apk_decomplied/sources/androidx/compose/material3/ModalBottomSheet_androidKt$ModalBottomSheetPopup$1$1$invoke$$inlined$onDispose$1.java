package androidx.compose.material3;

import androidx.compose.runtime.DisposableEffectResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ ModalBottomSheetWindow $modalBottomSheetWindow$inlined;

    public ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1$invoke$$inlined$onDispose$1(ModalBottomSheetWindow modalBottomSheetWindow) {
        this.$modalBottomSheetWindow$inlined = modalBottomSheetWindow;
    }

    public void dispose() {
        this.$modalBottomSheetWindow$inlined.disposeComposition();
        this.$modalBottomSheetWindow$inlined.dismiss();
    }
}
