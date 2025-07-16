package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$ListItem$decoratedHeadlineContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ListItemColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $headlineContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$ListItem$decoratedHeadlineContent$1(ListItemColors listItemColors, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$colors = listItemColors;
        this.$headlineContent = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C94@4498L160:ListItem.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-403249643, i, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
            }
            ListItemKt.m1945ProvideTextStyleFromToken3JVO9M(this.$colors.m1937headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), this.$headlineContent, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
