package androidx.compose.ui.node;

import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\n\u001a\u00020\u000b8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"androidx/compose/ui/node/LayoutNode$Companion$DummyViewConfiguration$1", "Landroidx/compose/ui/platform/ViewConfiguration;", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "minimumTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "getMinimumTouchTargetSize-MYxV2XQ", "touchSlop", "", "getTouchSlop", "()F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNode$Companion$DummyViewConfiguration$1 implements ViewConfiguration {
    public long getDoubleTapMinTimeMillis() {
        return 40;
    }

    public long getDoubleTapTimeoutMillis() {
        return 300;
    }

    public long getLongPressTimeoutMillis() {
        return 400;
    }

    public /* synthetic */ float getMaximumFlingVelocity() {
        return ViewConfiguration.CC.$default$getMaximumFlingVelocity(this);
    }

    public float getTouchSlop() {
        return 16.0f;
    }

    LayoutNode$Companion$DummyViewConfiguration$1() {
    }

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
    public long m5511getMinimumTouchTargetSizeMYxV2XQ() {
        return DpSize.Companion.m6722getZeroMYxV2XQ();
    }
}
