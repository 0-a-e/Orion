package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderModifierNode$drawWithCacheModifierNode$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ BorderModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderModifierNode$drawWithCacheModifierNode$1(BorderModifierNode borderModifierNode) {
        super(1);
        this.this$0 = borderModifierNode;
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        if (cacheDrawScope.m3460toPx0680j_4(this.this$0.m232getWidthD9Ej5fM()) < 0.0f || Size.m3630getMinDimensionimpl(cacheDrawScope.m3452getSizeNHjbRc()) <= 0.0f) {
            return BorderKt.drawContentWithoutBorder(cacheDrawScope);
        }
        float f = (float) 2;
        float min = Math.min(Dp.m6619equalsimpl0(this.this$0.m232getWidthD9Ej5fM(), Dp.Companion.m6632getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil((double) cacheDrawScope.m3460toPx0680j_4(this.this$0.m232getWidthD9Ej5fM())), (float) Math.ceil((double) (Size.m3630getMinDimensionimpl(cacheDrawScope.m3452getSizeNHjbRc()) / f)));
        float f2 = min / f;
        long Offset = OffsetKt.Offset(f2, f2);
        long Size = SizeKt.Size(Size.m3631getWidthimpl(cacheDrawScope.m3452getSizeNHjbRc()) - min, Size.m3628getHeightimpl(cacheDrawScope.m3452getSizeNHjbRc()) - min);
        boolean z = f * min > Size.m3630getMinDimensionimpl(cacheDrawScope.m3452getSizeNHjbRc());
        Outline r2 = this.this$0.getShape().m4201createOutlinePq9zytI(cacheDrawScope.m3452getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        if (r2 instanceof Outline.Generic) {
            BorderModifierNode borderModifierNode = this.this$0;
            return borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.getBrush(), (Outline.Generic) r2, z, min);
        } else if (r2 instanceof Outline.Rounded) {
            BorderModifierNode borderModifierNode2 = this.this$0;
            return borderModifierNode2.m231drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode2.getBrush(), (Outline.Rounded) r2, Offset, Size, z, min);
        } else if (r2 instanceof Outline.Rectangle) {
            return BorderKt.m228drawRectBorderNsqcLGU(cacheDrawScope, this.this$0.getBrush(), Offset, Size, z, min);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
