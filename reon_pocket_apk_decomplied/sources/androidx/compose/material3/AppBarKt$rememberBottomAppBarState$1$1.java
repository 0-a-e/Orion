package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material3/BottomAppBarState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$rememberBottomAppBarState$1$1 extends Lambda implements Function0<BottomAppBarState> {
    final /* synthetic */ float $initialContentOffset;
    final /* synthetic */ float $initialHeightOffset;
    final /* synthetic */ float $initialHeightOffsetLimit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$rememberBottomAppBarState$1$1(float f, float f2, float f3) {
        super(0);
        this.$initialHeightOffsetLimit = f;
        this.$initialHeightOffset = f2;
        this.$initialContentOffset = f3;
    }

    public final BottomAppBarState invoke() {
        return AppBarKt.BottomAppBarState(this.$initialHeightOffsetLimit, this.$initialHeightOffset, this.$initialContentOffset);
    }
}
