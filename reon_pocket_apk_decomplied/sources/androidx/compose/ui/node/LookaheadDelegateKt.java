package androidx.compose.ui.node;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"MaxLayoutDimension", "", "MaxLayoutMask", "checkMeasuredSize", "", "width", "height", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadDelegate.kt */
public final class LookaheadDelegateKt {
    private static final int MaxLayoutDimension = 16777215;
    private static final int MaxLayoutMask = -16777216;

    public static final void checkMeasuredSize(int i, int i2) {
        if ((i & -16777216) != 0 || (-16777216 & i2) != 0) {
            throw new IllegalStateException(("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.").toString());
        }
    }
}
