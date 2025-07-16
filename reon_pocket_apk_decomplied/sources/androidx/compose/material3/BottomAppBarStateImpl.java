package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR+\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\u0010R+\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\u0010¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/BottomAppBarStateImpl;", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "(FFF)V", "_heightOffset", "Landroidx/compose/runtime/MutableFloatState;", "collapsedFraction", "getCollapsedFraction", "()F", "<set-?>", "contentOffset", "getContentOffset", "setContentOffset", "(F)V", "contentOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "heightOffset", "getHeightOffset", "setHeightOffset", "heightOffsetLimit", "getHeightOffsetLimit", "setHeightOffsetLimit", "heightOffsetLimit$delegate", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class BottomAppBarStateImpl implements BottomAppBarState {
    private MutableFloatState _heightOffset;
    private final MutableFloatState contentOffset$delegate;
    private final MutableFloatState heightOffsetLimit$delegate;

    public BottomAppBarStateImpl(float f, float f2, float f3) {
        this.heightOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.contentOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f3);
        this._heightOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2);
    }

    public float getHeightOffsetLimit() {
        return this.heightOffsetLimit$delegate.getFloatValue();
    }

    public void setHeightOffsetLimit(float f) {
        this.heightOffsetLimit$delegate.setFloatValue(f);
    }

    public float getHeightOffset() {
        return this._heightOffset.getFloatValue();
    }

    public void setHeightOffset(float f) {
        this._heightOffset.setFloatValue(RangesKt.coerceIn(f, getHeightOffsetLimit(), 0.0f));
    }

    public float getContentOffset() {
        return this.contentOffset$delegate.getFloatValue();
    }

    public void setContentOffset(float f) {
        this.contentOffset$delegate.setFloatValue(f);
    }

    public float getCollapsedFraction() {
        if (getHeightOffsetLimit() == 0.0f) {
            return 0.0f;
        }
        return getHeightOffset() / getHeightOffsetLimit();
    }
}
