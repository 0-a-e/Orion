package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetContainerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $sheetDragHandle;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ float $sheetShadowElevation;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ float $sheetTonalElevation;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$4(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, long j3, long j4, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, int i, int i2, int i3) {
        super(2);
        this.$sheetContent = function3;
        this.$modifier = modifier;
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$sheetPeekHeight = f;
        this.$sheetMaxWidth = f2;
        this.$sheetShape = shape;
        this.$sheetContainerColor = j;
        this.$sheetContentColor = j2;
        this.$sheetTonalElevation = f3;
        this.$sheetShadowElevation = f4;
        this.$sheetDragHandle = function2;
        this.$sheetSwipeEnabled = z;
        this.$topBar = function22;
        this.$snackbarHost = function32;
        this.$containerColor = j3;
        this.$contentColor = j4;
        this.$content = function33;
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
        Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$sheetContent;
        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
        BottomSheetScaffoldKt.m1536BottomSheetScaffoldsdMYb0k(function32, this.$modifier, this.$scaffoldState, this.$sheetPeekHeight, this.$sheetMaxWidth, this.$sheetShape, this.$sheetContainerColor, this.$sheetContentColor, this.$sheetTonalElevation, this.$sheetShadowElevation, this.$sheetDragHandle, this.$sheetSwipeEnabled, this.$topBar, this.$snackbarHost, this.$containerColor, this.$contentColor, this.$content, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
