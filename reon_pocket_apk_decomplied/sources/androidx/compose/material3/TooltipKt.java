package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0001\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010!¢\u0006\u0002\b\"2\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010!¢\u0006\u0002\b\"2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u001d0!¢\u0006\u0002\b\"H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001al\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\u001c\u00100\u001a\u0018\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001d01¢\u0006\u0002\b\"¢\u0006\u0002\b32\u0006\u00104\u001a\u0002052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002072\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020\u001d0!¢\u0006\u0002\b\"H\u0007¢\u0006\u0002\u0010:\u001a&\u0010;\u001a\u0002052\b\b\u0002\u0010<\u001a\u0002072\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a+\u0010@\u001a\u0002052\b\b\u0002\u0010<\u001a\u0002072\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020?H\u0007¢\u0006\u0002\u0010A\u001a\u001a\u0010B\u001a\u00020\u001f*\u00020\u001f2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002070DH\u0000\u001a\u001c\u0010E\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010F\u001a\u0002072\u0006\u0010G\u001a\u000207H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0010\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u000f\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0010\u0010\r\"\u0010\u0010\u0011\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0012\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0013\u0010\r\"\u0010\u0010\u0014\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0019\u0010\r\"\u0016\u0010\u001a\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u001b\u0010\r\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\f\u0010I\u001a\u0004\u0018\u00010JX\u0002²\u0006\n\u0010K\u001a\u00020LX\u0002²\u0006\n\u0010M\u001a\u00020LX\u0002"}, d2 = {"ActionLabelBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ActionLabelMinHeight", "HeightFromSubheadToTextFirstLine", "HeightToSubheadFirstLine", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipHorizontalPadding", "PlainTooltipMaxWidth", "getPlainTooltipMaxWidth", "()F", "PlainTooltipVerticalPadding", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "RichTooltipMaxWidth", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "TextBottomPadding", "TooltipFadeInDuration", "", "TooltipFadeOutDuration", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "RichTooltip", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/RichTooltipColors;", "tonalElevation", "shadowElevation", "text", "RichTooltip-1tP8Re8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipBox", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/CaretScope;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "textVerticalPadding", "subheadExists", "actionExists", "material3_release", "anchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
public final class TooltipKt {
    /* access modifiers changed from: private */
    public static final float ActionLabelBottomPadding;
    /* access modifiers changed from: private */
    public static final float ActionLabelMinHeight = Dp.m6614constructorimpl((float) 36);
    private static final float HeightFromSubheadToTextFirstLine;
    /* access modifiers changed from: private */
    public static final float HeightToSubheadFirstLine = Dp.m6614constructorimpl((float) 28);
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipMaxWidth = Dp.m6614constructorimpl((float) 200);
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding;
    private static final float RichTooltipMaxWidth = Dp.m6614constructorimpl((float) 320);
    private static final float SpacingBetweenTooltipAndAnchor;
    private static final float TextBottomPadding;
    public static final int TooltipFadeInDuration = 150;
    public static final int TooltipFadeOutDuration = 75;
    private static final float TooltipMinHeight;
    private static final float TooltipMinWidth = Dp.m6614constructorimpl((float) 40);

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TooltipBox(androidx.compose.ui.window.PopupPositionProvider r21, kotlin.jvm.functions.Function3<? super androidx.compose.material3.CaretScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.material3.TooltipState r23, androidx.compose.ui.Modifier r24, boolean r25, boolean r26, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r2 = r22
            r3 = r23
            r7 = r27
            r8 = r29
            r0 = 1836749106(0x6d7a9132, float:4.846674E27)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r4 = "C(TooltipBox)P(4,6,5,3,2,1)120@5234L64,121@5343L33,122@5393L257,139@5846L310:Tooltip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            r4 = r30 & 1
            if (r4 == 0) goto L_0x0020
            r4 = r8 | 6
            r6 = r4
            r4 = r21
            goto L_0x0034
        L_0x0020:
            r4 = r8 & 6
            if (r4 != 0) goto L_0x0031
            r4 = r21
            boolean r6 = r1.changed((java.lang.Object) r4)
            if (r6 == 0) goto L_0x002e
            r6 = 4
            goto L_0x002f
        L_0x002e:
            r6 = 2
        L_0x002f:
            r6 = r6 | r8
            goto L_0x0034
        L_0x0031:
            r4 = r21
            r6 = r8
        L_0x0034:
            r9 = r30 & 2
            if (r9 == 0) goto L_0x003b
            r6 = r6 | 48
            goto L_0x004b
        L_0x003b:
            r9 = r8 & 48
            if (r9 != 0) goto L_0x004b
            boolean r9 = r1.changedInstance(r2)
            if (r9 == 0) goto L_0x0048
            r9 = 32
            goto L_0x004a
        L_0x0048:
            r9 = 16
        L_0x004a:
            r6 = r6 | r9
        L_0x004b:
            r9 = r30 & 4
            if (r9 == 0) goto L_0x0052
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x0052:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0062
            boolean r9 = r1.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r6 = r6 | r9
        L_0x0062:
            r9 = r30 & 8
            if (r9 == 0) goto L_0x0069
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007c
            r10 = r24
            boolean r11 = r1.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0078
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r6 = r6 | r11
            goto L_0x007e
        L_0x007c:
            r10 = r24
        L_0x007e:
            r11 = r30 & 16
            if (r11 == 0) goto L_0x0085
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r12 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0098
            r12 = r25
            boolean r13 = r1.changed((boolean) r12)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r6 = r6 | r13
            goto L_0x009a
        L_0x0098:
            r12 = r25
        L_0x009a:
            r13 = r30 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a2
            r6 = r6 | r14
            goto L_0x00b4
        L_0x00a2:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00b4
            r14 = r26
            boolean r15 = r1.changed((boolean) r14)
            if (r15 == 0) goto L_0x00b0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r6 = r6 | r15
            goto L_0x00b6
        L_0x00b4:
            r14 = r26
        L_0x00b6:
            r15 = r30 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bf
            r6 = r6 | r16
            goto L_0x00cf
        L_0x00bf:
            r15 = r8 & r16
            if (r15 != 0) goto L_0x00cf
            boolean r15 = r1.changedInstance(r7)
            if (r15 == 0) goto L_0x00cc
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r6 = r6 | r15
        L_0x00cf:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r6
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r5) goto L_0x00e6
            boolean r5 = r1.getSkipping()
            if (r5 != 0) goto L_0x00df
            goto L_0x00e6
        L_0x00df:
            r1.skipToGroupEnd()
            r5 = r12
            r6 = r14
            goto L_0x01b3
        L_0x00e6:
            if (r9 == 0) goto L_0x00ed
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x00ee
        L_0x00ed:
            r5 = r10
        L_0x00ee:
            r9 = 1
            if (r11 == 0) goto L_0x00f4
            r19 = r9
            goto L_0x00f6
        L_0x00f4:
            r19 = r12
        L_0x00f6:
            if (r13 == 0) goto L_0x00fb
            r20 = r9
            goto L_0x00fd
        L_0x00fb:
            r20 = r14
        L_0x00fd:
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0109
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.TooltipBox (Tooltip.kt:118)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r10, r11)
        L_0x0109:
            androidx.compose.animation.core.MutableTransitionState r0 = r23.getTransition()
            int r10 = androidx.compose.animation.core.MutableTransitionState.$stable
            r10 = r10 | 48
            r11 = 0
            java.lang.String r12 = "tooltip transition"
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r12, (androidx.compose.runtime.Composer) r1, (int) r10, (int) r11)
            r10 = 2029979988(0x78ff0954, float:4.1382028E34)
            r1.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):Tooltip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            java.lang.Object r11 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r11 != r12) goto L_0x0139
            r11 = 0
            r12 = 2
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r11, r11, r12, r11)
            r1.updateRememberedValue(r11)
        L_0x0139:
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            r1.endReplaceableGroup()
            r12 = 2029980038(0x78ff0986, float:4.1382152E34)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            java.lang.Object r10 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x015b
            androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1 r10 = new androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1
            r10.<init>(r11)
            r1.updateRememberedValue(r10)
        L_0x015b:
            androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1 r10 = (androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1) r10
            r1.endReplaceableGroup()
            androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1 r12 = new androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1
            r12.<init>(r11, r7)
            r11 = -1130808188(0xffffffffbc993c84, float:-0.018705614)
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r11, r9, r12)
            r15 = r11
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            androidx.compose.material3.TooltipKt$TooltipBox$1 r11 = new androidx.compose.material3.TooltipKt$TooltipBox$1
            r11.<init>(r0, r2, r10)
            r0 = -149611544(0xfffffffff7151be8, float:-3.02429E33)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r9, r11)
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = r3
            androidx.compose.material3.BasicTooltipState r11 = (androidx.compose.material3.BasicTooltipState) r11
            r0 = r6 & 14
            r9 = 1572912(0x180030, float:2.204119E-39)
            r0 = r0 | r9
            r9 = r6 & 896(0x380, float:1.256E-42)
            r0 = r0 | r9
            r9 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r9
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r6
            r0 = r0 | r9
            r9 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r9
            r17 = r0 | r6
            r18 = 0
            r9 = r21
            r12 = r5
            r13 = r19
            r14 = r20
            r16 = r1
            androidx.compose.material3.BasicTooltip_androidKt.BasicTooltipBox(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ae
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ae:
            r10 = r5
            r5 = r19
            r6 = r20
        L_0x01b3:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x01d1
            androidx.compose.material3.TooltipKt$TooltipBox$2 r12 = new androidx.compose.material3.TooltipKt$TooltipBox$2
            r0 = r12
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r10
            r7 = r27
            r8 = r29
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x01d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.TooltipBox(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function3, androidx.compose.material3.TooltipState, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final LayoutCoordinates TooltipBox$lambda$1(MutableState<LayoutCoordinates> mutableState) {
        return (LayoutCoordinates) mutableState.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0110  */
    /* renamed from: RichTooltip-1tP8Re8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2604RichTooltip1tP8Re8(androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.graphics.Shape r27, androidx.compose.material3.RichTooltipColors r28, float r29, float r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r8 = r31
            r9 = r33
            r10 = r34
            r0 = 1589779214(0x5ec21b0e, float:6.9933942E18)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(RichTooltip)P(2,6!1,4!1,7:c#ui.unit.Dp,3:c#ui.unit.Dp)230@9367L25,231@9442L19,236@9631L2169:Tooltip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001e
            r3 = r9 | 6
            r4 = r3
            r3 = r24
            goto L_0x0032
        L_0x001e:
            r3 = r9 & 6
            if (r3 != 0) goto L_0x002f
            r3 = r24
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r9
            goto L_0x0032
        L_0x002f:
            r3 = r24
            r4 = r9
        L_0x0032:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r9 & 48
            if (r6 != 0) goto L_0x004c
            r6 = r25
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r4 = r4 | r7
            goto L_0x004e
        L_0x004c:
            r6 = r25
        L_0x004e:
            r7 = r10 & 4
            if (r7 == 0) goto L_0x0055
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r11 = r9 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0068
            r11 = r26
            boolean r12 = r1.changedInstance(r11)
            if (r12 == 0) goto L_0x0064
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r12
            goto L_0x006a
        L_0x0068:
            r11 = r26
        L_0x006a:
            r12 = r9 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x0083
            r12 = r10 & 8
            if (r12 != 0) goto L_0x007d
            r12 = r27
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x007f
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007d:
            r12 = r27
        L_0x007f:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r4 = r4 | r13
            goto L_0x0085
        L_0x0083:
            r12 = r27
        L_0x0085:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009e
            r13 = r10 & 16
            if (r13 != 0) goto L_0x0098
            r13 = r28
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009a
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r13 = r28
        L_0x009a:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r4 = r4 | r14
            goto L_0x00a0
        L_0x009e:
            r13 = r28
        L_0x00a0:
            r14 = r10 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a8
            r4 = r4 | r15
            goto L_0x00bb
        L_0x00a8:
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00bb
            r15 = r29
            boolean r16 = r1.changed((float) r15)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r4 = r4 | r16
            goto L_0x00bd
        L_0x00bb:
            r15 = r29
        L_0x00bd:
            r16 = r10 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c8
            r4 = r4 | r17
            r0 = r30
            goto L_0x00db
        L_0x00c8:
            r17 = r9 & r17
            r0 = r30
            if (r17 != 0) goto L_0x00db
            boolean r18 = r1.changed((float) r0)
            if (r18 == 0) goto L_0x00d7
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r4 = r4 | r18
        L_0x00db:
            r0 = r10 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e4
            r4 = r4 | r18
            goto L_0x00f4
        L_0x00e4:
            r0 = r9 & r18
            if (r0 != 0) goto L_0x00f4
            boolean r0 = r1.changedInstance(r8)
            if (r0 == 0) goto L_0x00f1
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00f1:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r4 = r4 | r0
        L_0x00f4:
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r0 & r4
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0110
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0104
            goto L_0x0110
        L_0x0104:
            r1.skipToGroupEnd()
            r2 = r24
            r7 = r30
            r3 = r11
            r4 = r12
            r5 = r13
            goto L_0x01f1
        L_0x0110:
            r1.startDefaults()
            r0 = r9 & 1
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0139
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0121
            goto L_0x0139
        L_0x0121:
            r1.skipToGroupEnd()
            r0 = r10 & 8
            if (r0 == 0) goto L_0x012a
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x012a:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x012f
            r4 = r4 & r3
        L_0x012f:
            r0 = r24
        L_0x0131:
            r7 = r30
        L_0x0133:
            r2 = r11
            r3 = r12
            r5 = r15
            r11 = r4
            r4 = r13
            goto L_0x0177
        L_0x0139:
            if (r2 == 0) goto L_0x0140
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0142
        L_0x0140:
            r0 = r24
        L_0x0142:
            r2 = 0
            if (r5 == 0) goto L_0x0146
            r6 = r2
        L_0x0146:
            if (r7 == 0) goto L_0x0149
            r11 = r2
        L_0x0149:
            r2 = r10 & 8
            r5 = 6
            if (r2 == 0) goto L_0x0157
            androidx.compose.material3.TooltipDefaults r2 = androidx.compose.material3.TooltipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getRichTooltipContainerShape(r1, r5)
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r12 = r2
        L_0x0157:
            r2 = r10 & 16
            if (r2 == 0) goto L_0x0164
            androidx.compose.material3.TooltipDefaults r2 = androidx.compose.material3.TooltipDefaults.INSTANCE
            androidx.compose.material3.RichTooltipColors r2 = r2.richTooltipColors(r1, r5)
            r3 = r3 & r4
            r13 = r2
            r4 = r3
        L_0x0164:
            if (r14 == 0) goto L_0x016d
            androidx.compose.material3.tokens.RichTooltipTokens r2 = androidx.compose.material3.tokens.RichTooltipTokens.INSTANCE
            float r2 = r2.m3115getContainerElevationD9Ej5fM()
            r15 = r2
        L_0x016d:
            if (r16 == 0) goto L_0x0131
            androidx.compose.material3.tokens.RichTooltipTokens r2 = androidx.compose.material3.tokens.RichTooltipTokens.INSTANCE
            float r2 = r2.m3115getContainerElevationD9Ej5fM()
            r7 = r2
            goto L_0x0133
        L_0x0177:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0189
            r12 = -1
            java.lang.String r13 = "androidx.compose.material3.RichTooltip (Tooltip.kt:235)"
            r14 = 1589779214(0x5ec21b0e, float:6.9933942E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r11, r12, r13)
        L_0x0189:
            float r12 = TooltipMinWidth
            float r13 = RichTooltipMaxWidth
            float r14 = TooltipMinHeight
            r15 = 8
            r16 = 0
            r17 = 0
            r24 = r0
            r25 = r12
            r26 = r14
            r27 = r13
            r28 = r17
            r29 = r15
            r30 = r16
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.m746sizeInqDBjuR0$default(r24, r25, r26, r27, r28, r29, r30)
            long r13 = r4.m2094getContainerColor0d7_KjU()
            androidx.compose.material3.TooltipKt$RichTooltip$1 r15 = new androidx.compose.material3.TooltipKt$RichTooltip$1
            r15.<init>(r6, r2, r4, r8)
            r0 = 4342931(0x424493, float:6.085743E-39)
            r25 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r2, r15)
            r20 = r0
            kotlin.jvm.functions.Function2 r20 = (kotlin.jvm.functions.Function2) r20
            int r0 = r11 >> 6
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r18
            int r2 = r11 >> 3
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r2
            r0 = r0 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r11
            r22 = r0 | r2
            r23 = 72
            r15 = 0
            r19 = 0
            r11 = r12
            r12 = r3
            r17 = r5
            r18 = r7
            r21 = r1
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ea
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ea:
            r2 = r24
            r15 = r5
            r5 = r4
            r4 = r3
            r3 = r25
        L_0x01f1:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x020b
            androidx.compose.material3.TooltipKt$RichTooltip$2 r12 = new androidx.compose.material3.TooltipKt$RichTooltip$2
            r0 = r12
            r1 = r2
            r2 = r6
            r6 = r15
            r8 = r31
            r9 = r33
            r10 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.m2604RichTooltip1tP8Re8(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.RichTooltipColors, float, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TooltipState rememberTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1413230530);
        ComposerKt.sourceInformation(composer, "C(rememberTooltipState)513@20571L232:Tooltip.kt#uh7d8r");
        boolean z3 = false;
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413230530, i, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:513)");
        }
        composer.startReplaceableGroup(512858205);
        ComposerKt.sourceInformation(composer, "CC(remember):Tooltip.kt#9igjgp");
        boolean z4 = (((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32;
        if ((((i & 896) ^ 384) > 256 && composer.changed((Object) mutatorMutex)) || (i & 384) == 256) {
            z3 = true;
        }
        boolean z5 = z4 | z3;
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(rememberedValue);
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) rememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tooltipStateImpl;
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipState(z, z2, mutatorMutex);
    }

    public static final TooltipState TooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new TooltipStateImpl(z, z2, mutatorMutex);
    }

    /* access modifiers changed from: private */
    public static final Modifier textVerticalPadding(Modifier modifier, boolean z, boolean z2) {
        if (z || z2) {
            return PaddingKt.m674paddingqDBjuR0$default(AlignmentLineKt.m510paddingFromBaselineVpY3zN4$default(modifier, HeightFromSubheadToTextFirstLine, 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, (Object) null);
        }
        return PaddingKt.m672paddingVpY3zN4$default(modifier, 0.0f, PlainTooltipVerticalPadding, 1, (Object) null);
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    public static final float getPlainTooltipMaxWidth() {
        return PlainTooltipMaxWidth;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final Modifier animateTooltip(Modifier modifier, Transition<Boolean> transition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1(transition) : InspectableValueKt.getNoInspectorInfo(), new TooltipKt$animateTooltip$2(transition));
    }

    /* access modifiers changed from: private */
    public static final void TooltipBox$lambda$2(MutableState<LayoutCoordinates> mutableState, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
    }

    static {
        float f = (float) 4;
        SpacingBetweenTooltipAndAnchor = Dp.m6614constructorimpl(f);
        float f2 = (float) 24;
        TooltipMinHeight = Dp.m6614constructorimpl(f2);
        float r0 = Dp.m6614constructorimpl(f);
        PlainTooltipVerticalPadding = r0;
        float f3 = (float) 8;
        float r3 = Dp.m6614constructorimpl(f3);
        PlainTooltipHorizontalPadding = r3;
        PlainTooltipContentPadding = PaddingKt.m664PaddingValuesYgX7TsA(r3, r0);
        float f4 = (float) 16;
        RichTooltipHorizontalPadding = Dp.m6614constructorimpl(f4);
        HeightFromSubheadToTextFirstLine = Dp.m6614constructorimpl(f2);
        TextBottomPadding = Dp.m6614constructorimpl(f4);
        ActionLabelBottomPadding = Dp.m6614constructorimpl(f3);
    }
}
