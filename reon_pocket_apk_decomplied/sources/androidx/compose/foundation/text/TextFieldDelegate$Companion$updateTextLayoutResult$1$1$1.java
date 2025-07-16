package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "invoke-58bKbWc", "([F)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDelegate.kt */
final class TextFieldDelegate$Companion$updateTextLayoutResult$1$1$1 extends Lambda implements Function1<Matrix, Unit> {
    final /* synthetic */ LayoutCoordinates $innerTextFieldCoordinates;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDelegate$Companion$updateTextLayoutResult$1$1$1(LayoutCoordinates layoutCoordinates) {
        super(1);
        this.$innerTextFieldCoordinates = layoutCoordinates;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1128invoke58bKbWc(((Matrix) obj).m4079unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-58bKbWc  reason: not valid java name */
    public final void m1128invoke58bKbWc(float[] fArr) {
        LayoutCoordinatesKt.findRootCoordinates(this.$innerTextFieldCoordinates).m5322transformFromEL8BTi8(this.$innerTextFieldCoordinates, fArr);
    }
}
