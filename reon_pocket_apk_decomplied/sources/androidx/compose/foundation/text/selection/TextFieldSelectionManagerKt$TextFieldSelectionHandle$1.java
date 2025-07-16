package androidx.compose.foundation.text.selection;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
final class TextFieldSelectionManagerKt$TextFieldSelectionHandle$1 implements OffsetProvider {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ TextFieldSelectionManager $manager;

    TextFieldSelectionManagerKt$TextFieldSelectionHandle$1(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        this.$manager = textFieldSelectionManager;
        this.$isStartHandle = z;
    }

    /* renamed from: provide-F1C5BW0  reason: not valid java name */
    public final long m1319provideF1C5BW0() {
        return this.$manager.m1304getHandlePositiontuRUvjQ$foundation_release(this.$isStartHandle);
    }
}
