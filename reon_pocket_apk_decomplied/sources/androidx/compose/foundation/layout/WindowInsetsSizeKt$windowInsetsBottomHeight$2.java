package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/WindowInsets;", "it", "Landroidx/compose/ui/unit/Density;", "invoke", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/unit/Density;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsSize.kt */
final class WindowInsetsSizeKt$windowInsetsBottomHeight$2 extends Lambda implements Function2<WindowInsets, Density, Integer> {
    public static final WindowInsetsSizeKt$windowInsetsBottomHeight$2 INSTANCE = new WindowInsetsSizeKt$windowInsetsBottomHeight$2();

    WindowInsetsSizeKt$windowInsetsBottomHeight$2() {
        super(2);
    }

    public final Integer invoke(WindowInsets windowInsets, Density density) {
        return Integer.valueOf(windowInsets.getBottom(density));
    }
}
