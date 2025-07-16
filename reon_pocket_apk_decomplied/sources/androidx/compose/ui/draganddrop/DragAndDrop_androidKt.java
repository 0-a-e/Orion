package androidx.compose.ui.draganddrop;

import android.content.ClipDescription;
import android.view.DragEvent;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "getPositionInRoot", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)J", "mimeTypes", "", "", "toAndroidDragEvent", "Landroid/view/DragEvent;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDrop.android.kt */
public final class DragAndDrop_androidKt {
    public static final DragEvent toAndroidDragEvent(DragAndDropEvent dragAndDropEvent) {
        return dragAndDropEvent.getDragEvent$ui_release();
    }

    public static final Set<String> mimeTypes(DragAndDropEvent dragAndDropEvent) {
        ClipDescription clipDescription = dragAndDropEvent.getDragEvent$ui_release().getClipDescription();
        if (clipDescription == null) {
            return SetsKt.emptySet();
        }
        Set createSetBuilder = SetsKt.createSetBuilder(clipDescription.getMimeTypeCount());
        int mimeTypeCount = clipDescription.getMimeTypeCount();
        for (int i = 0; i < mimeTypeCount; i++) {
            createSetBuilder.add(clipDescription.getMimeType(i));
        }
        return SetsKt.build(createSetBuilder);
    }

    public static final long getPositionInRoot(DragAndDropEvent dragAndDropEvent) {
        return OffsetKt.Offset(dragAndDropEvent.getDragEvent$ui_release().getX(), dragAndDropEvent.getDragEvent$ui_release().getY());
    }
}
