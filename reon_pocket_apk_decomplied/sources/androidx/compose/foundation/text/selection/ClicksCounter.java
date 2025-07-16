package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/selection/ClicksCounter;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "clicks", "", "getClicks", "()I", "setClicks", "(I)V", "prevClick", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "getPrevClick", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setPrevClick", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "positionIsTolerable", "", "newClick", "timeIsTolerable", "update", "", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionGestures.kt */
final class ClicksCounter {
    private int clicks;
    private PointerInputChange prevClick;
    private final ViewConfiguration viewConfiguration;

    public ClicksCounter(ViewConfiguration viewConfiguration2) {
        this.viewConfiguration = viewConfiguration2;
    }

    public final int getClicks() {
        return this.clicks;
    }

    public final void setClicks(int i) {
        this.clicks = i;
    }

    public final PointerInputChange getPrevClick() {
        return this.prevClick;
    }

    public final void setPrevClick(PointerInputChange pointerInputChange) {
        this.prevClick = pointerInputChange;
    }

    public final void update(PointerEvent pointerEvent) {
        PointerInputChange pointerInputChange = this.prevClick;
        PointerInputChange pointerInputChange2 = pointerEvent.getChanges().get(0);
        if (pointerInputChange == null || !timeIsTolerable(pointerInputChange, pointerInputChange2) || !positionIsTolerable(pointerInputChange, pointerInputChange2)) {
            this.clicks = 1;
        } else {
            this.clicks++;
        }
        this.prevClick = pointerInputChange2;
    }

    public final boolean timeIsTolerable(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return pointerInputChange2.getUptimeMillis() - pointerInputChange.getUptimeMillis() < this.viewConfiguration.getDoubleTapTimeoutMillis();
    }

    public final boolean positionIsTolerable(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return ((double) Offset.m3560getDistanceimpl(Offset.m3566minusMKHz9U(pointerInputChange2.m5113getPositionF1C5BW0(), pointerInputChange.m5113getPositionF1C5BW0()))) < 100.0d;
    }
}
