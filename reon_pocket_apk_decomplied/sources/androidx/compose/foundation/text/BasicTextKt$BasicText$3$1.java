package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Rect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Landroidx/compose/ui/geometry/Rect;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$BasicText$3$1 extends Lambda implements Function1<List<? extends Rect>, Unit> {
    final /* synthetic */ MutableState<List<Rect>> $measuredPlaceholderPositions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$BasicText$3$1(MutableState<List<Rect>> mutableState) {
        super(1);
        this.$measuredPlaceholderPositions = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<Rect>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<Rect> list) {
        this.$measuredPlaceholderPositions.setValue(list);
    }
}
