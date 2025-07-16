package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$Scrim$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $color;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ boolean $visible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$Scrim$2(long j, Function0<Unit> function0, boolean z, int i) {
        super(2);
        this.$color = j;
        this.$onDismissRequest = function0;
        this.$visible = z;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ModalBottomSheet_androidKt.m1983Scrim3JVO9M(this.$color, this.$onDismissRequest, this.$visible, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
