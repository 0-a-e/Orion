package androidx.compose.foundation.text2;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField2.kt */
final class BasicTextField2Kt$DefaultTextFieldDecorator$1$Decoration$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $it;
    final /* synthetic */ BasicTextField2Kt$DefaultTextFieldDecorator$1 $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextField2Kt$DefaultTextFieldDecorator$1$Decoration$1(BasicTextField2Kt$DefaultTextFieldDecorator$1 basicTextField2Kt$DefaultTextFieldDecorator$1, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$tmp0_rcvr = basicTextField2Kt$DefaultTextFieldDecorator$1;
        this.$it = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.Decoration(this.$it, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
