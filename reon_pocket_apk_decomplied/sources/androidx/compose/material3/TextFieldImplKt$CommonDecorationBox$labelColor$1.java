package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/Color;", "it", "Landroidx/compose/material3/InputPhase;", "invoke-XeAY9LY", "(Landroidx/compose/material3/InputPhase;Landroidx/compose/runtime/Composer;I)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$labelColor$1 extends Lambda implements Function3<InputPhase, Composer, Integer, Color> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$labelColor$1(TextFieldColors textFieldColors, boolean z, boolean z2, InteractionSource interactionSource) {
        super(3);
        this.$colors = textFieldColors;
        this.$enabled = z;
        this.$isError = z2;
        this.$interactionSource = interactionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return Color.m3806boximpl(m2448invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
    }

    /* renamed from: invoke-XeAY9LY  reason: not valid java name */
    public final long m2448invokeXeAY9LY(InputPhase inputPhase, Composer composer, int i) {
        composer.startReplaceableGroup(-502832279);
        ComposerKt.sourceInformation(composer, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-502832279, i, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
        }
        long r0 = this.$colors.labelColor$material3_release(this.$enabled, this.$isError, this.$interactionSource, composer, 0).getValue().m3826unboximpl();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }
}
