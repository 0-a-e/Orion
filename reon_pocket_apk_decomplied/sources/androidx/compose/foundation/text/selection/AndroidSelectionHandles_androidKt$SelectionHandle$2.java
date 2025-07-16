package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandle$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ OffsetProvider $offsetProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandle$2(OffsetProvider offsetProvider, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2, Modifier modifier, int i) {
        super(2);
        this.$offsetProvider = offsetProvider;
        this.$isStartHandle = z;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
        this.$modifier = modifier;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AndroidSelectionHandles_androidKt.SelectionHandle(this.$offsetProvider, this.$isStartHandle, this.$direction, this.$handlesCrossed, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
