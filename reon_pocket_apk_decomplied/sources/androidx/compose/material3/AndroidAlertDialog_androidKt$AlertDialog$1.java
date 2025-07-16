package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAlertDialog.android.kt */
final class AndroidAlertDialog_androidKt$AlertDialog$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidAlertDialog_androidKt$AlertDialog$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j, float f, long j2, long j3, long j4, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25) {
        super(2);
        this.$icon = function2;
        this.$title = function22;
        this.$text = function23;
        this.$shape = shape;
        this.$containerColor = j;
        this.$tonalElevation = f;
        this.$iconContentColor = j2;
        this.$titleContentColor = j3;
        this.$textContentColor = j4;
        this.$dismissButton = function24;
        this.$confirmButton = function25;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(461081686, i2, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
            }
            final Function2<Composer, Integer, Unit> function2 = this.$dismissButton;
            final Function2<Composer, Integer, Unit> function22 = this.$confirmButton;
            AlertDialogKt.m1499AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer2, -3244296, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-3244296, i, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                        }
                        float access$getButtonsMainAxisSpacing$p = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                        float access$getButtonsCrossAxisSpacing$p = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        AlertDialogKt.m1500AlertDialogFlowRowixp7dh8(access$getButtonsMainAxisSpacing$p, access$getButtonsCrossAxisSpacing$p, ComposableLambdaKt.composableLambda(composer, -909933713, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ComposerKt.sourceInformation(composer, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                if ((i & 3) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-909933713, i, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                    }
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    composer.startReplaceableGroup(-1969500671);
                                    ComposerKt.sourceInformation(composer, "103@4991L8");
                                    if (function2 != null) {
                                        function2.invoke(composer, 0);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    composer.endReplaceableGroup();
                                    function22.invoke(composer, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 438);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), (Modifier) null, this.$icon, this.$title, this.$text, this.$shape, this.$containerColor, this.$tonalElevation, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), this.$iconContentColor, this.$titleContentColor, this.$textContentColor, composer, 6, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
