package androidx.compose.material3;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/material3/DraggableAnchors;", "Landroidx/compose/material3/SheetValue;", "sheetSize", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)Landroidx/compose/material3/DraggableAnchors;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1 extends Lambda implements Function1<IntSize, DraggableAnchors<SheetValue>> {
    final /* synthetic */ int $layoutHeight;
    final /* synthetic */ int $peekHeightPx;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1(BottomSheetScaffoldState bottomSheetScaffoldState, int i, int i2) {
        super(1);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$layoutHeight = i;
        this.$peekHeightPx = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m1541invokeozmzZPI(((IntSize) obj).m6794unboximpl());
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final DraggableAnchors<SheetValue> m1541invokeozmzZPI(long j) {
        final int r4 = IntSize.m6789getHeightimpl(j);
        final BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
        final int i = this.$layoutHeight;
        final int i2 = this.$peekHeightPx;
        return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DraggableAnchorsConfig<SheetValue>) (DraggableAnchorsConfig) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                if (!bottomSheetScaffoldState.getBottomSheetState().getSkipPartiallyExpanded$material3_release()) {
                    draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, (float) (i - i2));
                }
                if (r4 != i2) {
                    draggableAnchorsConfig.at(SheetValue.Expanded, (float) Math.max(i - r4, 0));
                }
                if (!bottomSheetScaffoldState.getBottomSheetState().getSkipHiddenState$material3_release()) {
                    draggableAnchorsConfig.at(SheetValue.Hidden, (float) i);
                }
            }
        });
    }
}
