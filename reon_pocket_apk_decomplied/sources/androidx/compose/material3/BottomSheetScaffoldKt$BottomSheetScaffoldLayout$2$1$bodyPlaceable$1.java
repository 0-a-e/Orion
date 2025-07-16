package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $body;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $sheetPeekHeight;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1(Modifier modifier, long j, long j2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, float f) {
        super(2);
        this.$modifier = modifier;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$body = function3;
        this.$sheetPeekHeight = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer, "C355@15900L194:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459220575, i2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:355)");
            }
            Modifier modifier = this.$modifier;
            long j = this.$containerColor;
            long j2 = this.$contentColor;
            final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$body;
            final float f = this.$sheetPeekHeight;
            SurfaceKt.m2303SurfaceT9BRK9s(modifier, (Shape) null, j, j2, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(composer, 1725620860, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C359@16047L45:BottomSheetScaffold.kt#uh7d8r");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725620860, i, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:359)");
                        }
                        function3.invoke(PaddingKt.m667PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f, 7, (Object) null), composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 12582912, 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
