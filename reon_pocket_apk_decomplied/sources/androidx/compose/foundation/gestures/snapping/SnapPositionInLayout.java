package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bç\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "", "position", "", "layoutSize", "itemSize", "beforeContentPadding", "afterContentPadding", "itemIndex", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapPositionInLayout.kt */
public interface SnapPositionInLayout {
    public static final Companion Companion = Companion.$$INSTANCE;

    int position(int i, int i2, int i3, int i4, int i5);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout$Companion;", "", "()V", "CenterToCenter", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "getCenterToCenter", "()Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapPositionInLayout.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SnapPositionInLayout CenterToCenter = new SnapPositionInLayout$Companion$$ExternalSyntheticLambda0();

        private Companion() {
        }

        public final SnapPositionInLayout getCenterToCenter() {
            return CenterToCenter;
        }

        /* access modifiers changed from: private */
        public static final int CenterToCenter$lambda$0(int i, int i2, int i3, int i4, int i5) {
            return (((i - i3) - i4) / 2) - (i2 / 2);
        }
    }
}
