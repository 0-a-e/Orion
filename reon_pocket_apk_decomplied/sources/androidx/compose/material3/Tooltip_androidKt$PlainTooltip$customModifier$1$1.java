package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.android.kt */
final class Tooltip_androidKt$PlainTooltip$customModifier$1$1 extends Lambda implements Function2<CacheDrawScope, LayoutCoordinates, DrawResult> {
    final /* synthetic */ CaretProperties $caretProperties;
    final /* synthetic */ Configuration $configuration;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Density $density;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Tooltip_androidKt$PlainTooltip$customModifier$1$1(Density density, Configuration configuration, long j, CaretProperties caretProperties) {
        super(2);
        this.$density = density;
        this.$configuration = configuration;
        this.$containerColor = j;
        this.$caretProperties = caretProperties;
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope, LayoutCoordinates layoutCoordinates) {
        return Tooltip_androidKt.m2607drawCaretWithPathBx497Mc(cacheDrawScope, this.$density, this.$configuration, this.$containerColor, this.$caretProperties, layoutCoordinates);
    }
}
