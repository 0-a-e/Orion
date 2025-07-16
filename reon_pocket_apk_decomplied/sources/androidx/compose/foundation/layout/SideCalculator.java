package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\bc\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/SideCalculator;", "", "adjustInsets", "Landroid/graphics/Insets;", "oldInsets", "newValue", "", "consumedOffsets", "Landroidx/compose/ui/geometry/Offset;", "available", "consumedOffsets-MK-Hz9U", "(J)J", "consumedVelocity", "Landroidx/compose/ui/unit/Velocity;", "remaining", "", "consumedVelocity-QWom1Mo", "(JF)J", "hideMotion", "x", "y", "motionOf", "showMotion", "valueOf", "insets", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
interface SideCalculator {
    public static final Companion Companion = Companion.$$INSTANCE;

    Insets adjustInsets(Insets insets, int i);

    /* renamed from: consumedOffsets-MK-Hz9U  reason: not valid java name */
    long m715consumedOffsetsMKHz9U(long j);

    /* renamed from: consumedVelocity-QWom1Mo  reason: not valid java name */
    long m716consumedVelocityQWom1Mo(long j, float f);

    float hideMotion(float f, float f2);

    float motionOf(float f, float f2);

    float showMotion(float f, float f2);

    int valueOf(Insets insets);

    /* renamed from: androidx.compose.foundation.layout.SideCalculator$-CC  reason: invalid class name */
    /* compiled from: WindowInsetsConnection.android.kt */
    public final /* synthetic */ class CC {
        public static float $default$showMotion(SideCalculator _this, float f, float f2) {
            return RangesKt.coerceAtLeast(_this.motionOf(f, f2), 0.0f);
        }

        public static float $default$hideMotion(SideCalculator _this, float f, float f2) {
            return RangesKt.coerceAtMost(_this.motionOf(f, f2), 0.0f);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0004\u0004\u0007\n\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/SideCalculator$Companion;", "", "()V", "BottomSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1;", "LeftSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1;", "RightSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1;", "TopSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1;", "chooseCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "chooseCalculator-ni1skBw", "(ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/foundation/layout/SideCalculator;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WindowInsetsConnection.android.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SideCalculator$Companion$BottomSideCalculator$1 BottomSideCalculator = new SideCalculator$Companion$BottomSideCalculator$1();
        private static final SideCalculator$Companion$LeftSideCalculator$1 LeftSideCalculator = new SideCalculator$Companion$LeftSideCalculator$1();
        private static final SideCalculator$Companion$RightSideCalculator$1 RightSideCalculator = new SideCalculator$Companion$RightSideCalculator$1();
        private static final SideCalculator$Companion$TopSideCalculator$1 TopSideCalculator = new SideCalculator$Companion$TopSideCalculator$1();

        private Companion() {
        }

        /* renamed from: chooseCalculator-ni1skBw  reason: not valid java name */
        public final SideCalculator m717chooseCalculatorni1skBw(int i, LayoutDirection layoutDirection) {
            if (WindowInsetsSides.m782equalsimpl0(i, WindowInsetsSides.Companion.m796getLeftJoeWqyM())) {
                return LeftSideCalculator;
            }
            if (WindowInsetsSides.m782equalsimpl0(i, WindowInsetsSides.Companion.m799getTopJoeWqyM())) {
                return TopSideCalculator;
            }
            if (WindowInsetsSides.m782equalsimpl0(i, WindowInsetsSides.Companion.m797getRightJoeWqyM())) {
                return RightSideCalculator;
            }
            if (WindowInsetsSides.m782equalsimpl0(i, WindowInsetsSides.Companion.m793getBottomJoeWqyM())) {
                return BottomSideCalculator;
            }
            if (WindowInsetsSides.m782equalsimpl0(i, WindowInsetsSides.Companion.m798getStartJoeWqyM())) {
                if (layoutDirection == LayoutDirection.Ltr) {
                    return LeftSideCalculator;
                }
                return RightSideCalculator;
            } else if (!WindowInsetsSides.m782equalsimpl0(i, WindowInsetsSides.Companion.m794getEndJoeWqyM())) {
                throw new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed".toString());
            } else if (layoutDirection == LayoutDirection.Ltr) {
                return RightSideCalculator;
            } else {
                return LeftSideCalculator;
            }
        }
    }
}
