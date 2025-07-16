package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "layoutHeight", "", "invoke", "(ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$1 extends Lambda implements Function3<Integer, Composer, Integer, Unit> {
    final /* synthetic */ int $peekHeightPx;
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$1(BottomSheetScaffoldState bottomSheetScaffoldState, int i, float f, float f2, boolean z, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$peekHeightPx = i;
        this.$sheetPeekHeight = f;
        this.$sheetMaxWidth = f2;
        this.$sheetSwipeEnabled = z;
        this.$sheetShape = shape;
        this.$sheetContainerColor = j;
        this.$sheetContentColor = j2;
        this.$sheetTonalElevation = f3;
        this.$sheetShadowElevation = f4;
        this.$sheetDragHandle = function2;
        this.$sheetContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(int r20, androidx.compose.runtime.Composer r21, int r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r15 = r21
            java.lang.String r2 = "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r22 & 6
            r3 = 4
            if (r2 != 0) goto L_0x001c
            boolean r2 = r15.changed((int) r1)
            if (r2 == 0) goto L_0x0018
            r2 = r3
            goto L_0x0019
        L_0x0018:
            r2 = 2
        L_0x0019:
            r2 = r22 | r2
            goto L_0x001e
        L_0x001c:
            r2 = r22
        L_0x001e:
            r4 = r2 & 19
            r5 = 18
            if (r4 != r5) goto L_0x0030
            boolean r4 = r21.getSkipping()
            if (r4 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            r21.skipToGroupEnd()
            goto L_0x00b0
        L_0x0030:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x003f
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)"
            r6 = -680109608(0xffffffffd77659d8, float:-2.70865736E14)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r4, r5)
        L_0x003f:
            androidx.compose.material3.BottomSheetScaffoldState r4 = r0.$scaffoldState
            androidx.compose.material3.SheetState r18 = r4.getBottomSheetState()
            r4 = 1237684821(0x49c59255, float:1618506.6)
            r15.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):BottomSheetScaffold.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r4)
            androidx.compose.material3.BottomSheetScaffoldState r4 = r0.$scaffoldState
            boolean r4 = r15.changed((java.lang.Object) r4)
            r2 = r2 & 14
            if (r2 != r3) goto L_0x005c
            r2 = 1
            goto L_0x005d
        L_0x005c:
            r2 = 0
        L_0x005d:
            r2 = r2 | r4
            int r3 = r0.$peekHeightPx
            boolean r3 = r15.changed((int) r3)
            r2 = r2 | r3
            androidx.compose.material3.BottomSheetScaffoldState r3 = r0.$scaffoldState
            int r4 = r0.$peekHeightPx
            java.lang.Object r5 = r21.rememberedValue()
            if (r2 != 0) goto L_0x0077
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r5 != r2) goto L_0x0082
        L_0x0077:
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1 r2 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
            r2.<init>(r3, r1, r4)
            r5 = r2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r15.updateRememberedValue(r5)
        L_0x0082:
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r21.endReplaceableGroup()
            float r3 = r0.$sheetPeekHeight
            float r4 = r0.$sheetMaxWidth
            boolean r5 = r0.$sheetSwipeEnabled
            androidx.compose.ui.graphics.Shape r6 = r0.$sheetShape
            long r7 = r0.$sheetContainerColor
            long r9 = r0.$sheetContentColor
            float r11 = r0.$sheetTonalElevation
            float r12 = r0.$sheetShadowElevation
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r13 = r0.$sheetDragHandle
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r0.$sheetContent
            r16 = 0
            r17 = 0
            r1 = r18
            r15 = r21
            androidx.compose.material3.BottomSheetScaffoldKt.m1538StandardBottomSheetXcniZvE(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00b0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1.invoke(int, androidx.compose.runtime.Composer, int):void");
    }
}
