package androidx.compose.ui.platform;

import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
/* synthetic */ class AndroidComposeView$dragAndDropModifierOnDragListener$1 extends FunctionReferenceImpl implements Function3<DragAndDropTransferData, Size, Function1<? super DrawScope, ? extends Unit>, Boolean> {
    AndroidComposeView$dragAndDropModifierOnDragListener$1(Object obj) {
        super(3, obj, AndroidComposeView.class, "startDrag", "startDrag-12SF9DM(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m5745invoke12SF9DM((DragAndDropTransferData) obj, ((Size) obj2).m3636unboximpl(), (Function1) obj3);
    }

    /* renamed from: invoke-12SF9DM  reason: not valid java name */
    public final Boolean m5745invoke12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j, Function1<? super DrawScope, Unit> function1) {
        return Boolean.valueOf(((AndroidComposeView) this.receiver).m5735startDrag12SF9DM(dragAndDropTransferData, j, function1));
    }
}
