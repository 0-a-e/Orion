package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"calculateDistanceToDesiredSnapPosition", "", "mainAxisViewPortSize", "", "beforeContentPadding", "afterContentPadding", "itemSize", "itemOffset", "itemIndex", "snapPositionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapPositionInLayout.kt */
public final class SnapPositionInLayoutKt {
    public static final float calculateDistanceToDesiredSnapPosition(int i, int i2, int i3, int i4, int i5, int i6, SnapPositionInLayout snapPositionInLayout) {
        return ((float) i5) - ((float) snapPositionInLayout.position(i, i4, i2, i3, i6));
    }
}
