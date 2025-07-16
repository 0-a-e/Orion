package androidx.compose.foundation.text2.input.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TextFieldPreparedSelectionState;", "", "()V", "cachedX", "", "getCachedX", "()F", "setCachedX", "(F)V", "resetCachedX", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public final class TextFieldPreparedSelectionState {
    public static final int $stable = 8;
    private float cachedX = Float.NaN;

    public final float getCachedX() {
        return this.cachedX;
    }

    public final void setCachedX(float f) {
        this.cachedX = f;
    }

    public final void resetCachedX() {
        this.cachedX = Float.NaN;
    }
}
