package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$StandardBottomSheet$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ Function1<IntSize, DraggableAnchors<SheetValue>> $calculateAnchors;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ float $peekHeight;
    final /* synthetic */ float $shadowElevation;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ SheetState $state;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$StandardBottomSheet$4(SheetState sheetState, Function1<? super IntSize, ? extends DraggableAnchors<SheetValue>> function1, float f, float f2, boolean z, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2) {
        super(2);
        this.$state = sheetState;
        this.$calculateAnchors = function1;
        this.$peekHeight = f;
        this.$sheetMaxWidth = f2;
        this.$sheetSwipeEnabled = z;
        this.$shape = shape;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$tonalElevation = f3;
        this.$shadowElevation = f4;
        this.$dragHandle = function2;
        this.$content = function3;
        this.$$changed = i;
        this.$$changed1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        SheetState sheetState = this.$state;
        SheetState sheetState2 = sheetState;
        BottomSheetScaffoldKt.m1538StandardBottomSheetXcniZvE(sheetState2, this.$calculateAnchors, this.$peekHeight, this.$sheetMaxWidth, this.$sheetSwipeEnabled, this.$shape, this.$containerColor, this.$contentColor, this.$tonalElevation, this.$shadowElevation, this.$dragHandle, this.$content, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1));
    }
}
