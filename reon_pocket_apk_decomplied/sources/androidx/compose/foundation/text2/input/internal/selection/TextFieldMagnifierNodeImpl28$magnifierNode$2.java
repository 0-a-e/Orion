package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "size", "Landroidx/compose/ui/unit/DpSize;", "invoke-EaSLcWc", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextFieldMagnifier.android.kt */
final class TextFieldMagnifierNodeImpl28$magnifierNode$2 extends Lambda implements Function1<DpSize, Unit> {
    final /* synthetic */ TextFieldMagnifierNodeImpl28 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierNodeImpl28$magnifierNode$2(TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28) {
        super(1);
        this.this$0 = textFieldMagnifierNodeImpl28;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1446invokeEaSLcWc(((DpSize) obj).m6720unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-EaSLcWc  reason: not valid java name */
    public final void m1446invokeEaSLcWc(long j) {
        TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = this.this$0;
        Density density = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldMagnifierNodeImpl28, CompositionLocalsKt.getLocalDensity());
        textFieldMagnifierNodeImpl28.m1444setMagnifierSizeozmzZPI(IntSizeKt.IntSize(density.m6545roundToPx0680j_4(DpSize.m6712getWidthD9Ej5fM(j)), density.m6545roundToPx0680j_4(DpSize.m6710getHeightD9Ej5fM(j))));
    }
}
