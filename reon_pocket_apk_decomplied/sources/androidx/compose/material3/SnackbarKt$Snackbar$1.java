package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$Snackbar$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ long $actionContentColor;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissAction;
    final /* synthetic */ long $dismissActionContentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, long j, long j2, boolean z) {
        super(2);
        this.$action = function2;
        this.$content = function22;
        this.$dismissAction = function23;
        this.$actionContentColor = j;
        this.$dismissActionContentColor = j2;
        this.$actionOnNewLine = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1829663446, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
            final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
            ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
            final Function2<Composer, Integer, Unit> function2 = this.$action;
            final Function2<Composer, Integer, Unit> function22 = this.$content;
            final Function2<Composer, Integer, Unit> function23 = this.$dismissAction;
            final long j = this.$actionContentColor;
            final long j2 = this.$dismissActionContentColor;
            final boolean z = this.$actionOnNewLine;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 835891690, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C:Snackbar.kt#uh7d8r");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(835891690, i, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                        }
                        if (function2 == null) {
                            composer.startReplaceableGroup(-2104362406);
                            ComposerKt.sourceInformation(composer, "119@5760L278");
                            SnackbarKt.m2217OneRowSnackbarkKq0p4A(function22, (Function2<? super Composer, ? super Integer, Unit>) null, function23, fromToken2, j, j2, composer, 48);
                            composer.endReplaceableGroup();
                        } else if (z) {
                            composer.startReplaceableGroup(-2104362092);
                            ComposerKt.sourceInformation(composer, "127@6074L255");
                            SnackbarKt.m2216NewLineButtonSnackbarkKq0p4A(function22, function2, function23, fromToken2, j, j2, composer, 0);
                            composer.endReplaceableGroup();
                        } else {
                            composer.startReplaceableGroup(-2104361812);
                            ComposerKt.sourceInformation(composer, "135@6354L280");
                            SnackbarKt.m2217OneRowSnackbarkKq0p4A(function22, function2, function23, fromToken2, j, j2, composer, 0);
                            composer.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
