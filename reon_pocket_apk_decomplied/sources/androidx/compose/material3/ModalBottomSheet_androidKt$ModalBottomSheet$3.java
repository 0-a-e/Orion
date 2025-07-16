package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheet$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $animateToDismiss;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ Function1<Float, Unit> $settleToDismiss;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheet$3(long j, Function0<Unit> function0, SheetState sheetState, Modifier modifier, float f, Function1<? super Float, Unit> function1, Shape shape, long j2, long j3, float f2, Function2<? super Composer, ? super Integer, Unit> function2, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$scrimColor = j;
        this.$animateToDismiss = function0;
        this.$sheetState = sheetState;
        this.$modifier = modifier;
        this.$sheetMaxWidth = f;
        this.$settleToDismiss = function1;
        this.$shape = shape;
        this.$containerColor = j2;
        this.$contentColor = j3;
        this.$tonalElevation = f2;
        this.$dragHandle = function2;
        this.$scope = coroutineScope;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2 = i;
        ComposerKt.sourceInformation(composer, "C183@8621L4790:ModalBottomSheet.android.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1311525899, i2, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:183)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            final long j = this.$scrimColor;
            final Function0<Unit> function0 = this.$animateToDismiss;
            final SheetState sheetState = this.$sheetState;
            final Modifier modifier = this.$modifier;
            final float f = this.$sheetMaxWidth;
            final Function1<Float, Unit> function1 = this.$settleToDismiss;
            final Shape shape = this.$shape;
            final long j2 = this.$containerColor;
            final long j3 = this.$contentColor;
            final float f2 = this.$tonalElevation;
            final Function2<Composer, Integer, Unit> function2 = this.$dragHandle;
            final CoroutineScope coroutineScope = this.$scope;
            final Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            Composer composer2 = composer;
            BoxWithConstraintsKt.BoxWithConstraints(fillMaxSize$default, (Alignment) null, false, ComposableLambdaKt.composableLambda(composer2, 2008499679, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: kotlin.jvm.functions.Function3} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r25, androidx.compose.runtime.Composer r26, int r27) {
                    /*
                        r24 = this;
                        r0 = r24
                        r1 = r25
                        r11 = r26
                        java.lang.String r2 = "C185@8729L168,190@8937L48,196@9208L36,197@9273L244,206@9577L348,219@10319L23,191@8998L4403:ModalBottomSheet.android.kt#uh7d8r"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
                        r2 = r27 & 6
                        r8 = 2
                        if (r2 != 0) goto L_0x001c
                        boolean r2 = r11.changed((java.lang.Object) r1)
                        if (r2 == 0) goto L_0x0018
                        r2 = 4
                        goto L_0x0019
                    L_0x0018:
                        r2 = r8
                    L_0x0019:
                        r2 = r27 | r2
                        goto L_0x001e
                    L_0x001c:
                        r2 = r27
                    L_0x001e:
                        r3 = r2 & 19
                        r4 = 18
                        if (r3 != r4) goto L_0x0030
                        boolean r3 = r26.getSkipping()
                        if (r3 != 0) goto L_0x002b
                        goto L_0x0030
                    L_0x002b:
                        r26.skipToGroupEnd()
                        goto L_0x01b9
                    L_0x0030:
                        boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r3 == 0) goto L_0x003f
                        r3 = -1
                        java.lang.String r4 = "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:184)"
                        r5 = 2008499679(0x77b745df, float:7.4344334E33)
                        androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
                    L_0x003f:
                        long r2 = r25.m587getConstraintsmsEJaDk()
                        int r9 = androidx.compose.ui.unit.Constraints.m6525getMaxHeightimpl(r2)
                        long r2 = r7
                        kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r9
                        androidx.compose.material3.SheetState r5 = r10
                        androidx.compose.material3.SheetValue r5 = r5.getTargetValue()
                        androidx.compose.material3.SheetValue r6 = androidx.compose.material3.SheetValue.Hidden
                        r10 = 0
                        r12 = 1
                        if (r5 == r6) goto L_0x0059
                        r5 = r12
                        goto L_0x005a
                    L_0x0059:
                        r5 = r10
                    L_0x005a:
                        r7 = 0
                        r6 = r26
                        androidx.compose.material3.ModalBottomSheet_androidKt.m1983Scrim3JVO9M(r2, r4, r5, r6, r7)
                        androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
                        int r2 = androidx.compose.material3.R.string.m3c_bottom_sheet_pane_title
                        int r2 = androidx.compose.material3.Strings.m2224constructorimpl(r2)
                        java.lang.String r2 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r2, r11, r10)
                        androidx.compose.ui.Modifier r3 = r11
                        float r4 = r12
                        r5 = 0
                        r6 = 0
                        androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m749widthInVpY3zN4$default(r3, r5, r4, r12, r6)
                        androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r5, r12, r6)
                        androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment r4 = r4.getTopCenter()
                        androidx.compose.ui.Modifier r1 = r1.align(r3, r4)
                        r3 = -1482644208(0xffffffffa7a0a510, float:-4.458788E-15)
                        r11.startReplaceableGroup(r3)
                        java.lang.String r3 = "CC(remember):ModalBottomSheet.android.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
                        boolean r4 = r11.changed((java.lang.Object) r2)
                        java.lang.Object r5 = r26.rememberedValue()
                        if (r4 != 0) goto L_0x00a1
                        androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r4 = r4.getEmpty()
                        if (r5 != r4) goto L_0x00ac
                    L_0x00a1:
                        androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$1$1 r4 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$1$1
                        r4.<init>(r2)
                        r5 = r4
                        kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                        r11.updateRememberedValue(r5)
                    L_0x00ac:
                        kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                        r26.endReplaceableGroup()
                        androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r10, r5, r12, r6)
                        r2 = -1482644143(0xffffffffa7a0a551, float:-4.4588157E-15)
                        r11.startReplaceableGroup(r2)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
                        androidx.compose.material3.SheetState r2 = r10
                        boolean r2 = r11.changed((java.lang.Object) r2)
                        androidx.compose.material3.SheetState r4 = r10
                        java.lang.Object r5 = r26.rememberedValue()
                        if (r2 != 0) goto L_0x00d4
                        androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r2 = r2.getEmpty()
                        if (r5 != r2) goto L_0x00df
                    L_0x00d4:
                        androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$2$1 r2 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$2$1
                        r2.<init>(r4)
                        r5 = r2
                        kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                        r11.updateRememberedValue(r5)
                    L_0x00df:
                        kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                        r26.endReplaceableGroup()
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.OffsetKt.offset(r1, r5)
                        r2 = -1482643839(0xffffffffa7a0a681, float:-4.4589445E-15)
                        r11.startReplaceableGroup(r2)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
                        androidx.compose.material3.SheetState r2 = r10
                        boolean r2 = r11.changed((java.lang.Object) r2)
                        androidx.compose.material3.SheetState r4 = r10
                        kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r5 = r13
                        java.lang.Object r7 = r26.rememberedValue()
                        if (r2 != 0) goto L_0x0109
                        androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r2 = r2.getEmpty()
                        if (r7 != r2) goto L_0x0112
                    L_0x0109:
                        androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
                        androidx.compose.ui.input.nestedscroll.NestedScrollConnection r7 = androidx.compose.material3.SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r4, r2, r5)
                        r11.updateRememberedValue(r7)
                    L_0x0112:
                        androidx.compose.ui.input.nestedscroll.NestedScrollConnection r7 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r7
                        r26.endReplaceableGroup()
                        androidx.compose.ui.Modifier r13 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r1, r7, r6, r8, r6)
                        androidx.compose.material3.SheetState r1 = r10
                        androidx.compose.material3.AnchoredDraggableState r1 = r1.getAnchoredDraggableState$material3_release()
                        androidx.compose.foundation.gestures.DraggableState r14 = r1.getDraggableState$material3_release()
                        androidx.compose.foundation.gestures.Orientation r15 = androidx.compose.foundation.gestures.Orientation.Vertical
                        androidx.compose.material3.SheetState r1 = r10
                        boolean r16 = r1.isVisible()
                        androidx.compose.material3.SheetState r1 = r10
                        androidx.compose.material3.AnchoredDraggableState r1 = r1.getAnchoredDraggableState$material3_release()
                        boolean r18 = r1.isAnimationRunning()
                        r1 = -1482643097(0xffffffffa7a0a967, float:-4.4592587E-15)
                        r11.startReplaceableGroup(r1)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
                        kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r1 = r13
                        boolean r1 = r11.changed((java.lang.Object) r1)
                        kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r2 = r13
                        java.lang.Object r3 = r26.rememberedValue()
                        if (r1 != 0) goto L_0x0156
                        androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r1 = r1.getEmpty()
                        if (r3 != r1) goto L_0x0161
                    L_0x0156:
                        androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1 r1 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1
                        r1.<init>(r2, r6)
                        r3 = r1
                        kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
                        r11.updateRememberedValue(r3)
                    L_0x0161:
                        r20 = r3
                        kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
                        r26.endReplaceableGroup()
                        r22 = 168(0xa8, float:2.35E-43)
                        r23 = 0
                        r17 = 0
                        r19 = 0
                        r21 = 0
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                        androidx.compose.material3.SheetState r2 = r10
                        float r3 = (float) r9
                        androidx.compose.ui.Modifier r1 = androidx.compose.material3.ModalBottomSheet_androidKt.modalBottomSheetAnchors(r1, r2, r3)
                        androidx.compose.ui.graphics.Shape r2 = r14
                        long r3 = r15
                        long r5 = r17
                        float r7 = r19
                        androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5 r8 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5
                        kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r20
                        androidx.compose.material3.SheetState r15 = r10
                        kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r9
                        kotlinx.coroutines.CoroutineScope r10 = r21
                        kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r13 = r22
                        r18 = r13
                        r13 = r8
                        r16 = r9
                        r17 = r10
                        r13.<init>(r14, r15, r16, r17, r18)
                        r9 = 1096570852(0x415c57e4, float:13.771458)
                        androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r9, r12, r8)
                        r10 = r8
                        kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
                        r12 = 12582912(0xc00000, float:1.7632415E-38)
                        r13 = 96
                        r8 = 0
                        r9 = 0
                        r11 = r26
                        androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
                        boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r1 == 0) goto L_0x01b9
                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                    L_0x01b9:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3.AnonymousClass1.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
                }
            }), composer2, 3078, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
