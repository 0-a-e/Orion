package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/AnimatedPaddingValues;", "Landroidx/compose/foundation/layout/PaddingValues;", "animationProgress", "Landroidx/compose/runtime/State;", "", "topPadding", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getAnimationProgress", "()Landroidx/compose/runtime/State;", "getTopPadding", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class AnimatedPaddingValues implements PaddingValues {
    private final State<Float> animationProgress;
    private final State<Dp> topPadding;

    public AnimatedPaddingValues(State<Float> state, State<Dp> state2) {
        this.animationProgress = state;
        this.topPadding = state2;
    }

    public final State<Float> getAnimationProgress() {
        return this.animationProgress;
    }

    public final State<Dp> getTopPadding() {
        return this.topPadding;
    }

    /* renamed from: calculateTopPadding-D9Ej5fM  reason: not valid java name */
    public float m1510calculateTopPaddingD9Ej5fM() {
        return Dp.m6614constructorimpl(this.topPadding.getValue().m6628unboximpl() * this.animationProgress.getValue().floatValue());
    }

    /* renamed from: calculateBottomPadding-D9Ej5fM  reason: not valid java name */
    public float m1507calculateBottomPaddingD9Ej5fM() {
        return Dp.m6614constructorimpl(SearchBar_androidKt.getSearchBarVerticalPadding() * this.animationProgress.getValue().floatValue());
    }

    /* renamed from: calculateLeftPadding-u2uoSUM  reason: not valid java name */
    public float m1508calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return Dp.m6614constructorimpl((float) 0);
    }

    /* renamed from: calculateRightPadding-u2uoSUM  reason: not valid java name */
    public float m1509calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return Dp.m6614constructorimpl((float) 0);
    }
}
