package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "dragEvent", "Landroid/view/DragEvent;", "(Landroid/view/DragEvent;)V", "getDragEvent$ui_release", "()Landroid/view/DragEvent;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDrop.android.kt */
public final class DragAndDropEvent {
    public static final int $stable = 8;
    private final DragEvent dragEvent;

    public DragAndDropEvent(DragEvent dragEvent2) {
        this.dragEvent = dragEvent2;
    }

    public final DragEvent getDragEvent$ui_release() {
        return this.dragEvent;
    }
}
