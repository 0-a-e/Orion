package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$HandlePopup$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ HandleReferencePoint $handleReferencePoint;
    final /* synthetic */ OffsetProvider $positionProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$HandlePopup$1(OffsetProvider offsetProvider, HandleReferencePoint handleReferencePoint, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$positionProvider = offsetProvider;
        this.$handleReferencePoint = handleReferencePoint;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AndroidSelectionHandles_androidKt.HandlePopup(this.$positionProvider, this.$handleReferencePoint, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
