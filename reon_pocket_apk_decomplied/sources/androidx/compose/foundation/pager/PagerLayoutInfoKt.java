package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"mainAxisViewportSize", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getMainAxisViewportSize$annotations", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)V", "getMainAxisViewportSize", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerLayoutInfo.kt */
public final class PagerLayoutInfoKt {
    public static /* synthetic */ void getMainAxisViewportSize$annotations(PagerLayoutInfo pagerLayoutInfo) {
    }

    public static final int getMainAxisViewportSize(PagerLayoutInfo pagerLayoutInfo) {
        return pagerLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m6789getHeightimpl(pagerLayoutInfo.m975getViewportSizeYbymL2g()) : IntSize.m6790getWidthimpl(pagerLayoutInfo.m975getViewportSizeYbymL2g());
    }
}
