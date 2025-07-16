package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocals.kt */
final class CompositionLocalsKt$ProvideCommonCompositionLocals$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Owner $owner;
    final /* synthetic */ UriHandler $uriHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompositionLocalsKt$ProvideCommonCompositionLocals$1(Owner owner, UriHandler uriHandler, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$owner = owner;
        this.$uriHandler = uriHandler;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CompositionLocalsKt.ProvideCommonCompositionLocals(this.$owner, this.$uriHandler, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
