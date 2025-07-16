package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$Decoration$contentWithColor$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$Decoration$contentWithColor$1(long j, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$contentColor = j;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C273@11220L118:TextFieldImpl.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1449369305, i, -1, "androidx.compose.material3.Decoration.<anonymous> (TextFieldImpl.kt:273)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(this.$contentColor)), (Function2<? super Composer, ? super Integer, Unit>) this.$content, composer, ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
