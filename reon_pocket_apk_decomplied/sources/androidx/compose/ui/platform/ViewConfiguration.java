package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0012\u0010\u0011\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/ViewConfiguration;", "", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "maximumFlingVelocity", "", "getMaximumFlingVelocity", "()F", "minimumTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "getMinimumTouchTargetSize-MYxV2XQ", "touchSlop", "getTouchSlop", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewConfiguration.kt */
public interface ViewConfiguration {
    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    long getLongPressTimeoutMillis();

    float getMaximumFlingVelocity();

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
    long m5831getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewConfiguration.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
        public static long m5834getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration viewConfiguration) {
            return CC.m5832$default$getMinimumTouchTargetSizeMYxV2XQ(viewConfiguration);
        }

        @Deprecated
        public static float getMaximumFlingVelocity(ViewConfiguration viewConfiguration) {
            return CC.$default$getMaximumFlingVelocity(viewConfiguration);
        }
    }

    /* renamed from: androidx.compose.ui.platform.ViewConfiguration$-CC  reason: invalid class name */
    /* compiled from: ViewConfiguration.kt */
    public final /* synthetic */ class CC {
        public static float $default$getMaximumFlingVelocity(ViewConfiguration _this) {
            return Float.MAX_VALUE;
        }

        /* renamed from: $default$getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
        public static long m5832$default$getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration _this) {
            float f = (float) 48;
            return DpKt.m6636DpSizeYgX7TsA(Dp.m6614constructorimpl(f), Dp.m6614constructorimpl(f));
        }
    }
}
