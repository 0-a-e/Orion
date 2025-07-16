package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$ProvideTextStyleFromToken$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $color;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ TypographyKeyTokens $textToken;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$ProvideTextStyleFromToken$1(long j, TypographyKeyTokens typographyKeyTokens, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$color = j;
        this.$textToken = typographyKeyTokens;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ListItemKt.m1945ProvideTextStyleFromToken3JVO9M(this.$color, this.$textToken, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
