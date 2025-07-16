package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nH\u0000\u001aA\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0017\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0018"}, d2 = {"DragHandleVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "velocity", "", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
public final class SheetDefaultsKt {
    /* access modifiers changed from: private */
    public static final float DragHandleVerticalPadding = Dp.m6614constructorimpl((float) 22);

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(SheetState sheetState, Orientation orientation, Function1<? super Float, Unit> function1) {
        return new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(sheetState, function1, orientation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.SheetState, androidx.compose.material3.SheetValue>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.SheetState rememberSheetState(boolean r14, kotlin.jvm.functions.Function1<? super androidx.compose.material3.SheetValue, java.lang.Boolean> r15, androidx.compose.material3.SheetValue r16, boolean r17, androidx.compose.runtime.Composer r18, int r19, int r20) {
        /*
            r7 = r18
            r0 = r19
            r1 = 1032784200(0x3d8f0948, float:0.06984192)
            r7.startReplaceableGroup(r1)
            java.lang.String r2 = "C(rememberSheetState)P(3)482@18033L7,490@18313L179,483@18052L440:SheetDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r20 & 1
            r3 = 0
            if (r2 == 0) goto L_0x0016
            r9 = r3
            goto L_0x0017
        L_0x0016:
            r9 = r14
        L_0x0017:
            r2 = r20 & 2
            if (r2 == 0) goto L_0x0021
            androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1 r2 = androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12 = r2
            goto L_0x0022
        L_0x0021:
            r12 = r15
        L_0x0022:
            r2 = r20 & 4
            if (r2 == 0) goto L_0x002a
            androidx.compose.material3.SheetValue r2 = androidx.compose.material3.SheetValue.Hidden
            r11 = r2
            goto L_0x002c
        L_0x002a:
            r11 = r16
        L_0x002c:
            r2 = r20 & 8
            if (r2 == 0) goto L_0x0032
            r13 = r3
            goto L_0x0034
        L_0x0032:
            r13 = r17
        L_0x0034:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0040
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:480)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r2, r4)
        L_0x0040:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r2, r4)
            java.lang.Object r1 = r7.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r18)
            r10 = r1
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r1
            r1 = 1
            r2[r1] = r12
            androidx.compose.material3.SheetState$Companion r4 = androidx.compose.material3.SheetState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r4.Saver(r9, r12, r10)
            r5 = 1097108455(0x41648be7, float:14.284156)
            r7.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):SheetDefaults.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            r5 = r0 & 14
            r5 = r5 ^ 6
            r6 = 4
            if (r5 <= r6) goto L_0x0082
            boolean r5 = r7.changed((boolean) r9)
            if (r5 != 0) goto L_0x0086
        L_0x0082:
            r5 = r0 & 6
            if (r5 != r6) goto L_0x0088
        L_0x0086:
            r5 = r1
            goto L_0x0089
        L_0x0088:
            r5 = r3
        L_0x0089:
            boolean r6 = r7.changed((java.lang.Object) r10)
            r5 = r5 | r6
            r6 = r0 & 896(0x380, float:1.256E-42)
            r6 = r6 ^ 384(0x180, float:5.38E-43)
            r8 = 256(0x100, float:3.59E-43)
            if (r6 <= r8) goto L_0x009c
            boolean r6 = r7.changed((java.lang.Object) r11)
            if (r6 != 0) goto L_0x00a0
        L_0x009c:
            r6 = r0 & 384(0x180, float:5.38E-43)
            if (r6 != r8) goto L_0x00a2
        L_0x00a0:
            r6 = r1
            goto L_0x00a3
        L_0x00a2:
            r6 = r3
        L_0x00a3:
            r5 = r5 | r6
            r6 = r0 & 112(0x70, float:1.57E-43)
            r6 = r6 ^ 48
            r8 = 32
            if (r6 <= r8) goto L_0x00b2
            boolean r6 = r7.changed((java.lang.Object) r12)
            if (r6 != 0) goto L_0x00b6
        L_0x00b2:
            r6 = r0 & 48
            if (r6 != r8) goto L_0x00b8
        L_0x00b6:
            r6 = r1
            goto L_0x00b9
        L_0x00b8:
            r6 = r3
        L_0x00b9:
            r5 = r5 | r6
            r6 = r0 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 ^ 3072(0xc00, float:4.305E-42)
            r8 = 2048(0x800, float:2.87E-42)
            if (r6 <= r8) goto L_0x00c8
            boolean r6 = r7.changed((boolean) r13)
            if (r6 != 0) goto L_0x00cc
        L_0x00c8:
            r0 = r0 & 3072(0xc00, float:4.305E-42)
            if (r0 != r8) goto L_0x00cd
        L_0x00cc:
            r3 = r1
        L_0x00cd:
            r0 = r5 | r3
            java.lang.Object r1 = r18.rememberedValue()
            if (r0 != 0) goto L_0x00dd
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00e9
        L_0x00dd:
            androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1 r0 = new androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r7.updateRememberedValue(r1)
        L_0x00e9:
            r3 = r1
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r18.endReplaceableGroup()
            r5 = 0
            r6 = 4
            r8 = 0
            r0 = r2
            r1 = r4
            r2 = r8
            r4 = r18
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.SheetState r0 = (androidx.compose.material3.SheetState) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0106
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0106:
            r18.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt.rememberSheetState(boolean, kotlin.jvm.functions.Function1, androidx.compose.material3.SheetValue, boolean, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.SheetState");
    }
}
