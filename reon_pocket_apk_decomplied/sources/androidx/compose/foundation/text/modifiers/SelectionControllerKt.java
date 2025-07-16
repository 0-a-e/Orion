package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¨\u0006\b"}, d2 = {"makeSelectionModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "selectableId", "", "layoutCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionController.kt */
public final class SelectionControllerKt {
    /* access modifiers changed from: private */
    public static final Modifier makeSelectionModifier(SelectionRegistrar selectionRegistrar, long j, Function0<? extends LayoutCoordinates> function0) {
        SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 selectionControllerKt$makeSelectionModifier$longPressDragObserver$1 = new SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1(function0, selectionRegistrar, j);
        return SelectionGesturesKt.selectionGestureInput(Modifier.Companion, new SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1(function0, selectionRegistrar, j), selectionControllerKt$makeSelectionModifier$longPressDragObserver$1);
    }
}
