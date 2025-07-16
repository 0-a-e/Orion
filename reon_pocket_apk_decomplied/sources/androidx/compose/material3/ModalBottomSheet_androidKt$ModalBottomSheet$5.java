package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheet$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ ModalBottomSheetProperties $properties;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ float $tonalElevation;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheet$5(Function0<Unit> function0, Modifier modifier, SheetState sheetState, float f, Shape shape, long j, long j2, float f2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, ModalBottomSheetProperties modalBottomSheetProperties, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2, int i3) {
        super(2);
        this.$onDismissRequest = function0;
        this.$modifier = modifier;
        this.$sheetState = sheetState;
        this.$sheetMaxWidth = f;
        this.$shape = shape;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$tonalElevation = f2;
        this.$scrimColor = j3;
        this.$dragHandle = function2;
        this.$windowInsets = windowInsets;
        this.$properties = modalBottomSheetProperties;
        this.$content = function3;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        Function0<Unit> function0 = this.$onDismissRequest;
        Function0<Unit> function02 = function0;
        ModalBottomSheet_androidKt.m1982ModalBottomSheetdYc4hso(function02, this.$modifier, this.$sheetState, this.$sheetMaxWidth, this.$shape, this.$containerColor, this.$contentColor, this.$tonalElevation, this.$scrimColor, this.$dragHandle, this.$windowInsets, this.$properties, this.$content, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
