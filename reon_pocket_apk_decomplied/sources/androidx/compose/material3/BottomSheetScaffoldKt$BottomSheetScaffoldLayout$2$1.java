package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $body;
    final /* synthetic */ Function3<Integer, Composer, Integer, Unit> $bottomSheet;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long j, long j2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32, float f, Function0<Float> function0, SheetState sheetState) {
        super(2);
        this.$topBar = function2;
        this.$snackbarHost = function22;
        this.$bottomSheet = function3;
        this.$modifier = modifier;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$body = function32;
        this.$sheetPeekHeight = f;
        this.$sheetOffset = function0;
        this.$sheetState = sheetState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1542invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1542invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        Object obj;
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        int r11 = Constraints.m6526getMaxWidthimpl(j);
        int r12 = Constraints.m6525getMaxHeightimpl(j);
        long r2 = Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        final Placeable r4 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Sheet, ComposableLambdaKt.composableLambdaInstance(-1192048628, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$sheetPlaceable$1(this.$bottomSheet, r12))).get(0).m5368measureBRTryo0(r2);
        Function2<Composer, Integer, Unit> function2 = this.$topBar;
        Placeable r10 = function2 != null ? subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(-873203005, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$topBarPlaceable$1$1(function2))).get(0).m5368measureBRTryo0(r2) : null;
        int height = r10 != null ? r10.getHeight() : 0;
        long r13 = Constraints.m6517copyZbe2FdA$default(r2, 0, 0, 0, r12 - height, 7, (Object) null);
        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot = BottomSheetScaffoldLayoutSlot.Body;
        new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1(this.$modifier, this.$containerColor, this.$contentColor, this.$body, this.$sheetPeekHeight);
        final Placeable r8 = subcomposeMeasureScope2.subcompose(bottomSheetScaffoldLayoutSlot, ComposableLambdaKt.composableLambdaInstance(-1459220575, true, obj)).get(0).m5368measureBRTryo0(r13);
        final Placeable r5 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, this.$snackbarHost).get(0).m5368measureBRTryo0(r2);
        final Function0<Float> function0 = this.$sheetOffset;
        final SheetState sheetState = this.$sheetState;
        final int i = r11;
        final int i2 = r12;
        final int i3 = height;
        final Placeable placeable = r10;
        return MeasureScope.CC.layout$default(subcomposeMeasureScope2, r11, r12, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
            /* compiled from: BottomSheetScaffold.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                static {
                    /*
                        androidx.compose.material3.SheetValue[] r0 = androidx.compose.material3.SheetValue.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.PartiallyExpanded     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Expanded     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Hidden     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        $EnumSwitchMapping$0 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.AnonymousClass1.WhenMappings.<clinit>():void");
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                int i;
                int roundToInt = MathKt.roundToInt(function0.invoke().floatValue());
                int max = Math.max(0, (i - r4.getWidth()) / 2);
                int width = (i - r5.getWidth()) / 2;
                int i2 = WhenMappings.$EnumSwitchMapping$0[sheetState.getCurrentValue().ordinal()];
                if (i2 == 1) {
                    i = roundToInt - r5.getHeight();
                } else if (i2 == 2 || i2 == 3) {
                    i = i2 - r5.getHeight();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                int i3 = i;
                Placeable.PlacementScope.placeRelative$default(placementScope, r8, 0, i3, 0.0f, 4, (Object) null);
                Placeable placeable = placeable;
                if (placeable != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, r4, max, roundToInt, 0.0f, 4, (Object) null);
                Placeable.PlacementScope.placeRelative$default(placementScope, r5, width, i3, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
