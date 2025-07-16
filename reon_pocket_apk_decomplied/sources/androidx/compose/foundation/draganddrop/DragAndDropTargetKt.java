package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"dragAndDropTarget", "Landroidx/compose/ui/Modifier;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "startEvent", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropTarget.kt */
public final class DragAndDropTargetKt {
    public static final Modifier dragAndDropTarget(Modifier modifier, Function1<? super DragAndDropEvent, Boolean> function1, DragAndDropTarget dragAndDropTarget) {
        return modifier.then(new DropTargetElement(function1, dragAndDropTarget));
    }
}
