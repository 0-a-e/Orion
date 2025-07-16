package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePickerDialog.android.kt */
final class DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$dismissButton = function2;
        this.$confirmButton = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C100@4777L322:DatePickerDialog.android.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1174914401, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:100)");
            }
            float access$getDialogButtonsMainAxisSpacing$p = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
            float access$getDialogButtonsCrossAxisSpacing$p = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
            final Function2<Composer, Integer, Unit> function2 = this.$dismissButton;
            final Function2<Composer, Integer, Unit> function22 = this.$confirmButton;
            AlertDialogKt.m1500AlertDialogFlowRowixp7dh8(access$getDialogButtonsMainAxisSpacing$p, access$getDialogButtonsCrossAxisSpacing$p, ComposableLambdaKt.composableLambda(composer, -330605494, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C105@5058L15:DatePickerDialog.android.kt#uh7d8r");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-330605494, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:104)");
                        }
                        Function2<Composer, Integer, Unit> function2 = function2;
                        composer.startReplaceableGroup(1914517404);
                        ComposerKt.sourceInformation(composer, "104@5021L8");
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
}
