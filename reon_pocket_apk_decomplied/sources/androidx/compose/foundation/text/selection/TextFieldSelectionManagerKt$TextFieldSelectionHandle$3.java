package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
final class TextFieldSelectionManagerKt$TextFieldSelectionHandle$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ TextFieldSelectionManager $manager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManagerKt$TextFieldSelectionHandle$3(boolean z, ResolvedTextDirection resolvedTextDirection, TextFieldSelectionManager textFieldSelectionManager, int i) {
        super(2);
        this.$isStartHandle = z;
        this.$direction = resolvedTextDirection;
        this.$manager = textFieldSelectionManager;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TextFieldSelectionManagerKt.TextFieldSelectionHandle(this.$isStartHandle, this.$direction, this.$manager, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
