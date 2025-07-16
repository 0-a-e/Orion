package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
final class OutlinedTextFieldDefaults$DecorationBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldDefaults$DecorationBox$1(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors) {
        super(2);
        this.$enabled = z;
        this.$isError = z2;
        this.$interactionSource = interactionSource;
        this.$colors = textFieldColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2 = i;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer, "C1781@99680L135:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1448570018, i2, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:1781)");
            }
            OutlinedTextFieldDefaults.INSTANCE.m2039ContainerBoxnbWgWpA(this.$enabled, this.$isError, this.$interactionSource, this.$colors, (Shape) null, 0.0f, 0.0f, composer, 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
