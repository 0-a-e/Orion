package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "size", "<anonymous parameter 1>", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke", "(ILandroidx/compose/ui/unit/LayoutDirection;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Arrangement.kt */
final class Arrangement$spacedBy$3 extends Lambda implements Function2<Integer, LayoutDirection, Integer> {
    final /* synthetic */ Alignment.Vertical $alignment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Arrangement$spacedBy$3(Alignment.Vertical vertical) {
        super(2);
        this.$alignment = vertical;
    }

    public final Integer invoke(int i, LayoutDirection layoutDirection) {
        return Integer.valueOf(this.$alignment.align(0, i));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
    }
}
