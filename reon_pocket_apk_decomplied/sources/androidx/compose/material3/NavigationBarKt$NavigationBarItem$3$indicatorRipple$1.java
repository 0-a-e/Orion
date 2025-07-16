package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutIdKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$NavigationBarItem$3$indicatorRipple$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MappedInteractionSource $offsetInteractionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationBarKt$NavigationBarItem$3$indicatorRipple$1(MappedInteractionSource mappedInteractionSource) {
        super(2);
        this.$offsetInteractionSource = mappedInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(691730997, i, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
            }
            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.Companion, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer, 6)), this.$offsetInteractionSource, RippleKt.m1491rememberRipple9IZ8Weo(false, 0.0f, 0, composer, 0, 7)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
