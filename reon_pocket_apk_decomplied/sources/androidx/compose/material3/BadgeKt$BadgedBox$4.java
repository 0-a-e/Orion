package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Badge.kt */
final class BadgeKt$BadgedBox$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> $badge;
    final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BadgeKt$BadgedBox$4(Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32, int i, int i2) {
        super(2);
        this.$badge = function3;
        this.$modifier = modifier;
        this.$content = function32;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BadgeKt.BadgedBox(this.$badge, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
