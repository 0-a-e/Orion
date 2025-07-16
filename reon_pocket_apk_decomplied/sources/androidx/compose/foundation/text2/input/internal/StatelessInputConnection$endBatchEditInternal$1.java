package androidx.compose.foundation.text2.input.internal;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StatelessInputConnection.android.kt */
final class StatelessInputConnection$endBatchEditInternal$1 extends Lambda implements Function1<EditingBuffer, Unit> {
    final /* synthetic */ StatelessInputConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StatelessInputConnection$endBatchEditInternal$1(StatelessInputConnection statelessInputConnection) {
        super(1);
        this.this$0 = statelessInputConnection;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EditingBuffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EditingBuffer editingBuffer) {
        MutableVector access$getEditCommands$p = this.this$0.editCommands;
        int size = access$getEditCommands$p.getSize();
        if (size > 0) {
            Object[] content = access$getEditCommands$p.getContent();
            int i = 0;
            do {
                ((Function1) content[i]).invoke(editingBuffer);
                i++;
            } while (i < size);
        }
    }
}
