package androidx.compose.ui.unit;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/FontScalingLinear;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toSp", "toSp-0xMU5do", "(F)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontScaling.kt */
public interface FontScalingLinear {
    float getFontScale();

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    float m6731toDpGaN1DYA(long j);

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    long m6732toSp0xMU5do(float f);

    /* renamed from: androidx.compose.ui.unit.FontScalingLinear$-CC  reason: invalid class name */
    /* compiled from: FontScaling.kt */
    public final /* synthetic */ class CC {
        /* renamed from: $default$toSp-0xMU5do  reason: not valid java name */
        public static long m6734$default$toSp0xMU5do(FontScalingLinear _this, float f) {
            return TextUnitKt.getSp(f / _this.getFontScale());
        }

        /* renamed from: $default$toDp-GaN1DYA  reason: not valid java name */
        public static float m6733$default$toDpGaN1DYA(FontScalingLinear _this, long j) {
            if (TextUnitType.m6839equalsimpl0(TextUnit.m6810getTypeUIouoOA(j), TextUnitType.Companion.m6844getSpUIouoOA())) {
                return Dp.m6614constructorimpl(TextUnit.m6811getValueimpl(j) * _this.getFontScale());
            }
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontScaling.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m6738toSp0xMU5do(FontScalingLinear fontScalingLinear, float f) {
            return CC.m6734$default$toSp0xMU5do(fontScalingLinear, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m6737toDpGaN1DYA(FontScalingLinear fontScalingLinear, long j) {
            return CC.m6733$default$toDpGaN1DYA(fontScalingLinear, j);
        }
    }
}
