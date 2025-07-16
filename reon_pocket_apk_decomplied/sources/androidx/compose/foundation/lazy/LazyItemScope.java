package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0016\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\tH&J\u0016\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyItemScope;", "", "animateItemPlacement", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "fillParentMaxHeight", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@LazyScopeMarker
/* compiled from: LazyItemScope.kt */
public interface LazyItemScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyItemScope.kt */
    public static final class DefaultImpls {
    }

    Modifier animateItemPlacement(Modifier modifier, FiniteAnimationSpec<IntOffset> finiteAnimationSpec);

    Modifier fillParentMaxHeight(Modifier modifier, float f);

    Modifier fillParentMaxSize(Modifier modifier, float f);

    Modifier fillParentMaxWidth(Modifier modifier, float f);

    /* renamed from: androidx.compose.foundation.lazy.LazyItemScope$-CC  reason: invalid class name */
    /* compiled from: LazyItemScope.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Modifier fillParentMaxSize$default(LazyItemScope lazyItemScope, Modifier modifier, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    f = 1.0f;
                }
                return lazyItemScope.fillParentMaxSize(modifier, f);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxSize");
        }

        public static /* synthetic */ Modifier fillParentMaxWidth$default(LazyItemScope lazyItemScope, Modifier modifier, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    f = 1.0f;
                }
                return lazyItemScope.fillParentMaxWidth(modifier, f);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxWidth");
        }

        public static /* synthetic */ Modifier fillParentMaxHeight$default(LazyItemScope lazyItemScope, Modifier modifier, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    f = 1.0f;
                }
                return lazyItemScope.fillParentMaxHeight(modifier, f);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxHeight");
        }

        public static /* synthetic */ Modifier animateItemPlacement$default(LazyItemScope lazyItemScope, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
                }
                return lazyItemScope.animateItemPlacement(modifier, finiteAnimationSpec);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItemPlacement");
        }
    }
}
