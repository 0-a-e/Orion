package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$NavigationBarItem$styledLabel$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ NavigationBarItemColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ boolean $selected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationBarKt$NavigationBarItem$styledLabel$1$1(NavigationBarItemColors navigationBarItemColors, boolean z, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$colors = navigationBarItemColors;
        this.$selected = z;
        this.$enabled = z2;
        this.$label = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C185@8666L10,186@8758L49,187@8820L152:NavigationBar.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1644987592, i, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:185)");
            }
            ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(invoke$lambda$0(this.$colors.textColor$material3_release(this.$selected, this.$enabled, composer, 0)), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), NavigationBarTokens.INSTANCE.getLabelTextFont()), this.$label, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    private static final long invoke$lambda$0(State<Color> state) {
        return state.getValue().m3826unboximpl();
    }
}
