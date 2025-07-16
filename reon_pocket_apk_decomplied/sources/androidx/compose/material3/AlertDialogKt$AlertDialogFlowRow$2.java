package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogFlowRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ float $mainAxisSpacing;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogFlowRow$2(float f, float f2, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$mainAxisSpacing = f;
        this.$crossAxisSpacing = f2;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AlertDialogKt.m1500AlertDialogFlowRowixp7dh8(this.$mainAxisSpacing, this.$crossAxisSpacing, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
