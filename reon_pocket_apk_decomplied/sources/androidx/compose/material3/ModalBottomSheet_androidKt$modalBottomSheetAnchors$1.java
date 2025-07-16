package androidx.compose.material3;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "sheetSize", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$modalBottomSheetAnchors$1 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ float $fullHeight;
    final /* synthetic */ SheetState $sheetState;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.android.kt */
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
                androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Hidden     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.PartiallyExpanded     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Expanded     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetAnchors$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$modalBottomSheetAnchors$1(SheetState sheetState, float f) {
        super(1);
        this.$sheetState = sheetState;
        this.$fullHeight = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1987invokeozmzZPI(((IntSize) obj).m6794unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m1987invokeozmzZPI(long j) {
        SheetValue sheetValue;
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new ModalBottomSheet_androidKt$modalBottomSheetAnchors$1$newAnchors$1(this.$fullHeight, j, this.$sheetState));
        int i = WhenMappings.$EnumSwitchMapping$0[this.$sheetState.getAnchoredDraggableState$material3_release().getTargetValue().ordinal()];
        if (i == 1) {
            sheetValue = SheetValue.Hidden;
        } else if (i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        } else if (DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
            sheetValue = SheetValue.PartiallyExpanded;
        } else {
            sheetValue = DraggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        }
        this.$sheetState.getAnchoredDraggableState$material3_release().updateAnchors(DraggableAnchors, sheetValue);
    }
}
