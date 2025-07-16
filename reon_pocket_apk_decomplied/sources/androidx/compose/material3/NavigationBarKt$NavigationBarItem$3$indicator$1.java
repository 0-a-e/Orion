package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutIdKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$NavigationBarItem$3$indicator$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<Float> $animationProgress;
    final /* synthetic */ NavigationBarItemColors $colors;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationBarKt$NavigationBarItem$3$indicator$1(State<Float> state, NavigationBarItemColors navigationBarItemColors) {
        super(2);
        this.$animationProgress = state;
        this.$colors = navigationBarItemColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-474426875, i, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
            }
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "indicator");
            composer.startReplaceableGroup(1844203561);
            ComposerKt.sourceInformation(composer, "CC(remember):NavigationBar.kt#9igjgp");
            boolean changed = composer.changed((Object) this.$animationProgress);
            State<Float> state = this.$animationProgress;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NavigationBarKt$NavigationBarItem$3$indicator$1$1$1(state);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m213backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue), this.$colors.m1993getIndicatorColor0d7_KjU$material3_release(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer, 6)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
