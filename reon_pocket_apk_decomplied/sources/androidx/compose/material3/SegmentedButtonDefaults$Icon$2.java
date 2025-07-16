package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(ZLandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentedButton.kt */
final class SegmentedButtonDefaults$Icon$2 extends Lambda implements Function3<Boolean, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $activeContent;
    final /* synthetic */ Function2<Composer, Integer, Unit> $inactiveContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SegmentedButtonDefaults$Icon$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(3);
        this.$activeContent = function2;
        this.$inactiveContent = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, Composer composer, int i) {
        Function2<Composer, Integer, Unit> function2;
        ComposerKt.sourceInformation(composer, "C:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i |= composer.changed(z) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1364873619, i, -1, "androidx.compose.material3.SegmentedButtonDefaults.Icon.<anonymous> (SegmentedButton.kt:589)");
            }
            if (z) {
                composer.startReplaceableGroup(-412602680);
                ComposerKt.sourceInformation(composer, "589@25531L15");
                function2 = this.$activeContent;
            } else {
                composer.startReplaceableGroup(-412602659);
                ComposerKt.sourceInformation(composer, "589@25552L17");
                function2 = this.$inactiveContent;
            }
            function2.invoke(composer, 0);
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
