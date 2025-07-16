package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Rect;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$observeTextToolbarVisibility$2 extends Lambda implements Function0<Rect> {
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$observeTextToolbarVisibility$2(TextFieldSelectionState textFieldSelectionState) {
        super(0);
        this.this$0 = textFieldSelectionState;
    }

    public final Rect invoke() {
        Rect intersect;
        boolean r0 = TextRange.m6036getCollapsedimpl(this.this$0.textFieldState.getText().m1346getSelectionInCharsd9O1mEE());
        if (((!r0 || this.this$0.getTextToolbarState() != TextToolbarState.Cursor) && (r0 || this.this$0.getTextToolbarState() != TextToolbarState.Selection)) || this.this$0.getDraggingHandle() != null || !this.this$0.isInTouchMode()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates access$getTextLayoutCoordinates = this.this$0.getTextLayoutCoordinates();
        Rect rect = null;
        Rect visibleBounds = access$getTextLayoutCoordinates != null ? SelectionManagerKt.visibleBounds(access$getTextLayoutCoordinates) : null;
        if (visibleBounds == null) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates access$getTextLayoutCoordinates2 = this.this$0.getTextLayoutCoordinates();
        Offset r2 = access$getTextLayoutCoordinates2 != null ? Offset.m3551boximpl(access$getTextLayoutCoordinates2.m5320localToRootMKHz9U(visibleBounds.m3597getTopLeftF1C5BW0())) : null;
        Intrinsics.checkNotNull(r2);
        Rect r02 = RectKt.m3602Recttz77jQw(r2.m3572unboximpl(), visibleBounds.m3595getSizeNHjbRc());
        Rect access$getContentRect = this.this$0.getContentRect();
        if (r02.overlaps(access$getContentRect)) {
            rect = access$getContentRect;
        }
        if (rect == null || (intersect = rect.intersect(r02)) == null) {
            return Rect.Companion.getZero();
        }
        return intersect;
    }
}
