package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$outlineCutout$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ long $labelSize;
    final /* synthetic */ PaddingValues $paddingValues;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OutlinedTextField.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$outlineCutout$1(long j, PaddingValues paddingValues) {
        super(1);
        this.$labelSize = j;
        this.$paddingValues = paddingValues;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        float f;
        float r0 = Size.m3631getWidthimpl(this.$labelSize);
        if (r0 > 0.0f) {
            float r2 = contentDrawScope.m6550toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
            float r3 = contentDrawScope.m6550toPx0680j_4(this.$paddingValues.m685calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - r2;
            float f2 = (float) 2;
            float f3 = r0 + r3 + (r2 * f2);
            if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                f = Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()) - f3;
            } else {
                f = RangesKt.coerceAtLeast(r3, 0.0f);
            }
            float f4 = f;
            if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                f3 = Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()) - RangesKt.coerceAtLeast(r3, 0.0f);
            }
            float f5 = f3;
            float r02 = Size.m3628getHeightimpl(this.$labelSize);
            float f6 = r02 / f2;
            int r11 = ClipOp.Companion.m3804getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long r1 = drawContext.m4412getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m4523clipRectN_I0leg(f4, (-r02) / f2, f5, f6, r11);
            contentDrawScope.drawContent();
            drawContext.getCanvas().restore();
            drawContext.m4413setSizeuvyYCjk(r1);
            return;
        }
        contentDrawScope.drawContent();
    }
}
