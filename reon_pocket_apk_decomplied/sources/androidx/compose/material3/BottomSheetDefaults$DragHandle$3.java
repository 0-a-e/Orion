package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
final class BottomSheetDefaults$DragHandle$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ float $height;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ BottomSheetDefaults $tmp1_rcvr;
    final /* synthetic */ float $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetDefaults$DragHandle$3(BottomSheetDefaults bottomSheetDefaults, Modifier modifier, float f, float f2, Shape shape, long j, int i, int i2) {
        super(2);
        this.$tmp1_rcvr = bottomSheetDefaults;
        this.$modifier = modifier;
        this.$width = f;
        this.$height = f2;
        this.$shape = shape;
        this.$color = j;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp1_rcvr.m1532DragHandlelgZ2HuY(this.$modifier, this.$width, this.$height, this.$shape, this.$color, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
