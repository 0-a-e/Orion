package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R0\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/lazy/grid/ItemInfo;", "", "crossAxisSize", "", "crossAxisOffset", "(II)V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "getCrossAxisSize", "setCrossAxisSize", "updateAnimation", "", "positionedItem", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridItemPlacementAnimator.kt */
final class ItemInfo {
    private LazyLayoutAnimation[] animations = LazyGridItemPlacementAnimatorKt.EmptyArray;
    private int crossAxisOffset;
    private int crossAxisSize;

    public ItemInfo(int i, int i2) {
        this.crossAxisSize = i;
        this.crossAxisOffset = i2;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final void setCrossAxisSize(int i) {
        this.crossAxisSize = i;
    }

    public final int getCrossAxisOffset() {
        return this.crossAxisOffset;
    }

    public final void setCrossAxisOffset(int i) {
        this.crossAxisOffset = i;
    }

    public final LazyLayoutAnimation[] getAnimations() {
        return this.animations;
    }

    public final void updateAnimation(LazyGridMeasuredItem lazyGridMeasuredItem, CoroutineScope coroutineScope) {
        int length = this.animations.length;
        for (int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount(); placeablesCount < length; placeablesCount++) {
            LazyLayoutAnimation lazyLayoutAnimation = this.animations[placeablesCount];
            if (lazyLayoutAnimation != null) {
                lazyLayoutAnimation.stopAnimations();
            }
        }
        if (this.animations.length != lazyGridMeasuredItem.getPlaceablesCount()) {
            Object[] copyOf = Arrays.copyOf(this.animations, lazyGridMeasuredItem.getPlaceablesCount());
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.animations = (LazyLayoutAnimation[]) copyOf;
        }
        int placeablesCount2 = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount2; i++) {
            LazyLayoutAnimationSpecsNode access$getSpecs = LazyGridItemPlacementAnimatorKt.getSpecs(lazyGridMeasuredItem.getParentData(i));
            if (access$getSpecs == null) {
                LazyLayoutAnimation lazyLayoutAnimation2 = this.animations[i];
                if (lazyLayoutAnimation2 != null) {
                    lazyLayoutAnimation2.stopAnimations();
                }
                this.animations[i] = null;
            } else {
                LazyLayoutAnimation lazyLayoutAnimation3 = this.animations[i];
                if (lazyLayoutAnimation3 == null) {
                    lazyLayoutAnimation3 = new LazyLayoutAnimation(coroutineScope);
                    this.animations[i] = lazyLayoutAnimation3;
                }
                lazyLayoutAnimation3.setAppearanceSpec(access$getSpecs.getAppearanceSpec());
                lazyLayoutAnimation3.setPlacementSpec(access$getSpecs.getPlacementSpec());
            }
        }
    }
}
