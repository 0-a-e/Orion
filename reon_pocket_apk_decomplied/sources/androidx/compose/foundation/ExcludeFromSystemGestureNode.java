package androidx.compose.foundation;

import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/ExcludeFromSystemGestureNode;", "Landroidx/compose/foundation/RectListNode;", "rect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function1;)V", "currentRects", "Landroidx/compose/runtime/collection/MutableVector;", "Landroid/graphics/Rect;", "updateRects", "", "rects", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SystemGestureExclusion.android.kt */
final class ExcludeFromSystemGestureNode extends RectListNode {
    public ExcludeFromSystemGestureNode(Function1<? super LayoutCoordinates, Rect> function1) {
        super(function1);
    }

    public void updateRects(MutableVector<android.graphics.Rect> mutableVector) {
        getView().setSystemGestureExclusionRects(mutableVector.asMutableList());
    }

    public MutableVector<android.graphics.Rect> currentRects() {
        MutableVector<android.graphics.Rect> mutableVector = new MutableVector<>(new android.graphics.Rect[16], 0);
        mutableVector.addAll(mutableVector.getSize(), (List<? extends android.graphics.Rect>) ComponentDialog$$ExternalSyntheticApiModelOutline0.m(getView()));
        return mutableVector;
    }
}
