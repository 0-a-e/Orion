package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aa\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010 \u001aJ\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00012\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00070\"¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010#\u001a[\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010$\u001ak\u0010%\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010&\u001am\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010'\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020(2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010)\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020(2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010*\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020+2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010,\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020+2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010-\u001a9\u0010.\u001a\u00020\u0003\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010/\u001a\u0002H\bH\u0003¢\u0006\u0002\u00100\"\u001e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u00061²\u0006\"\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013\"\u0004\b\u0000\u0010\bX\u0002²\u0006\u0010\u00103\u001a\u00020\u0001\"\u0004\b\u0000\u0010\bX\u0002"}, d2 = {"exitFinished", "", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "AnimatedEnterExitImpl", "", "T", "transition", "visible", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "shouldDisposeBlock", "Lkotlin/Function2;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "label", "", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "initiallyVisible", "Lkotlin/Function0;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
public final class AnimatedVisibilityKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(boolean r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r7 = r30
            r0 = 2088733774(0x7c7f8c4e, float:5.3075257E36)
            r1 = r29
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedVisibility)P(5,4,1,2,3)133@6955L32,134@6992L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r31 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r7 | 6
            r3 = r2
            r2 = r23
            goto L_0x002e
        L_0x001a:
            r2 = r7 & 14
            if (r2 != 0) goto L_0x002b
            r2 = r23
            boolean r3 = r1.changed((boolean) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r7
            goto L_0x002e
        L_0x002b:
            r2 = r23
            r3 = r7
        L_0x002e:
            r4 = r31 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r7 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0048
            r5 = r24
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0044
            r6 = 32
            goto L_0x0046
        L_0x0044:
            r6 = 16
        L_0x0046:
            r3 = r3 | r6
            goto L_0x004a
        L_0x0048:
            r5 = r24
        L_0x004a:
            r6 = r31 & 4
            if (r6 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r8 = r7 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0064
            r8 = r25
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r8 = r25
        L_0x0066:
            r9 = r31 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r10 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0080
            r10 = r26
            boolean r11 = r1.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x007c
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r11
            goto L_0x0082
        L_0x0080:
            r10 = r26
        L_0x0082:
            r11 = r31 & 16
            r12 = 57344(0xe000, float:8.0356E-41)
            if (r11 == 0) goto L_0x008c
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008c:
            r13 = r7 & r12
            if (r13 != 0) goto L_0x009f
            r13 = r27
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009b
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r3 = r3 | r14
            goto L_0x00a1
        L_0x009f:
            r13 = r27
        L_0x00a1:
            r14 = r31 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00ab
            r14 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r14
            goto L_0x00bf
        L_0x00ab:
            r14 = r7 & r15
            if (r14 != 0) goto L_0x00bf
            r14 = r28
            boolean r16 = r1.changedInstance(r14)
            if (r16 == 0) goto L_0x00ba
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r16
            goto L_0x00c1
        L_0x00bf:
            r14 = r28
        L_0x00c1:
            r16 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r3 & r16
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r12) goto L_0x00da
            boolean r12 = r1.getSkipping()
            if (r12 != 0) goto L_0x00d2
            goto L_0x00da
        L_0x00d2:
            r1.skipToGroupEnd()
            r4 = r5
            r3 = r8
            r5 = r13
            goto L_0x016e
        L_0x00da:
            if (r4 == 0) goto L_0x00e1
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00e2
        L_0x00e1:
            r4 = r5
        L_0x00e2:
            r5 = 0
            r12 = 3
            r15 = 0
            if (r6 == 0) goto L_0x0100
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r15, r5, r12, r15)
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.EnterTransition r8 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r6 = r6.plus(r8)
            goto L_0x0101
        L_0x0100:
            r6 = r8
        L_0x0101:
            if (r9 == 0) goto L_0x011c
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.ExitTransition r8 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r15, r5, r12, r15)
            androidx.compose.animation.ExitTransition r5 = r8.plus(r5)
            goto L_0x011d
        L_0x011c:
            r5 = r10
        L_0x011d:
            if (r11 == 0) goto L_0x0123
            java.lang.String r8 = "AnimatedVisibility"
            r15 = r8
            goto L_0x0124
        L_0x0123:
            r15 = r13
        L_0x0124:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0130
            r8 = -1
            java.lang.String r9 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:132)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r8, r9)
        L_0x0130:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r23)
            r8 = r3 & 14
            int r9 = r3 >> 9
            r9 = r9 & 112(0x70, float:1.57E-43)
            r8 = r8 | r9
            r9 = 0
            androidx.compose.animation.core.Transition r8 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r15, (androidx.compose.runtime.Composer) r1, (int) r8, (int) r9)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1.INSTANCE
            r9 = r0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            int r0 = r3 << 3
            r10 = r0 & 896(0x380, float:1.256E-42)
            r10 = r10 | 48
            r11 = r0 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r11
            r0 = r0 | r10
            r10 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r10
            r0 = r0 | r3
            r10 = r4
            r11 = r6
            r12 = r5
            r13 = r28
            r14 = r1
            r3 = r15
            r15 = r0
            AnimatedVisibilityImpl(r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x016b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x016b:
            r10 = r5
            r5 = r3
            r3 = r6
        L_0x016e:
            androidx.compose.runtime.ScopeUpdateScope r9 = r1.endRestartGroup()
            if (r9 == 0) goto L_0x0189
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2 r11 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2
            r0 = r11
            r1 = r23
            r2 = r4
            r4 = r10
            r6 = r28
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r9.updateScope(r11)
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.RowScope r23, boolean r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r8 = r31
            r0 = -1741346906(0xffffffff983527a6, float:-2.341372E-24)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedVisibility)P(5,4,1,2,3)208@11260L32,209@11297L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r32 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 48
            r3 = r2
            r2 = r24
            goto L_0x0030
        L_0x001a:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x002d
            r2 = r24
            boolean r3 = r1.changed((boolean) r2)
            if (r3 == 0) goto L_0x0029
            r3 = 32
            goto L_0x002b
        L_0x0029:
            r3 = 16
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r24
            r3 = r8
        L_0x0030:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x004a
        L_0x0037:
            r5 = r8 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x004a
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0048
        L_0x0046:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r25
        L_0x004c:
            r6 = r32 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0066
        L_0x0053:
            r7 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0066
            r7 = r26
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0062
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r3 = r3 | r9
            goto L_0x0068
        L_0x0066:
            r7 = r26
        L_0x0068:
            r9 = r32 & 8
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0072
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0085
        L_0x0072:
            r11 = r8 & r10
            if (r11 != 0) goto L_0x0085
            r11 = r27
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0081
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0083
        L_0x0081:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0083:
            r3 = r3 | r12
            goto L_0x0087
        L_0x0085:
            r11 = r27
        L_0x0087:
            r12 = r32 & 16
            r13 = 458752(0x70000, float:6.42848E-40)
            if (r12 == 0) goto L_0x0091
            r14 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r14
            goto L_0x00a4
        L_0x0091:
            r14 = r8 & r13
            if (r14 != 0) goto L_0x00a4
            r14 = r28
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00a0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a2
        L_0x00a0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00a2:
            r3 = r3 | r15
            goto L_0x00a6
        L_0x00a4:
            r14 = r28
        L_0x00a6:
            r15 = r32 & 32
            if (r15 == 0) goto L_0x00ae
            r15 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r15
            goto L_0x00c3
        L_0x00ae:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00c3
            r15 = r29
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00be
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c0
        L_0x00be:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00c0:
            r3 = r3 | r16
            goto L_0x00c5
        L_0x00c3:
            r15 = r29
        L_0x00c5:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r13 = r3 & r16
            r10 = 599184(0x92490, float:8.39636E-40)
            if (r13 != r10) goto L_0x00df
            boolean r10 = r1.getSkipping()
            if (r10 != 0) goto L_0x00d6
            goto L_0x00df
        L_0x00d6:
            r1.skipToGroupEnd()
            r3 = r5
            r4 = r7
            r5 = r11
            r6 = r14
            goto L_0x0171
        L_0x00df:
            if (r4 == 0) goto L_0x00e6
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00e7
        L_0x00e6:
            r4 = r5
        L_0x00e7:
            r5 = 0
            r10 = 3
            r13 = 0
            if (r6 == 0) goto L_0x0105
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r5, r10, r13)
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.expandHorizontally$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r6 = r6.plus(r7)
            goto L_0x0106
        L_0x0105:
            r6 = r7
        L_0x0106:
            if (r9 == 0) goto L_0x0121
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r5, r10, r13)
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.ExitTransition r7 = androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r5 = r5.plus(r7)
            goto L_0x0122
        L_0x0121:
            r5 = r11
        L_0x0122:
            if (r12 == 0) goto L_0x0127
            java.lang.String r7 = "AnimatedVisibility"
            goto L_0x0128
        L_0x0127:
            r7 = r14
        L_0x0128:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0134
            r9 = -1
            java.lang.String r10 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:207)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r9, r10)
        L_0x0134:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r24)
            int r9 = r3 >> 3
            r10 = r9 & 14
            int r11 = r3 >> 12
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            r11 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r7, (androidx.compose.runtime.Composer) r1, (int) r10, (int) r11)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3 r10 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r11 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 | 48
            r12 = r3 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r12
            r3 = r3 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r11
            r16 = r3 | r9
            r9 = r0
            r11 = r4
            r12 = r6
            r13 = r5
            r14 = r29
            r15 = r1
            AnimatedVisibilityImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x016e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x016e:
            r3 = r4
            r4 = r6
            r6 = r7
        L_0x0171:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x018c
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4 r11 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4
            r0 = r11
            r1 = r23
            r2 = r24
            r7 = r29
            r8 = r31
            r9 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope r23, boolean r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r8 = r31
            r0 = 1766503102(0x694ab2be, float:1.5315444E25)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedVisibility)P(5,4,1,2,3)281@15543L32,282@15580L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r32 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 48
            r3 = r2
            r2 = r24
            goto L_0x0030
        L_0x001a:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x002d
            r2 = r24
            boolean r3 = r1.changed((boolean) r2)
            if (r3 == 0) goto L_0x0029
            r3 = 32
            goto L_0x002b
        L_0x0029:
            r3 = 16
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r24
            r3 = r8
        L_0x0030:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x004a
        L_0x0037:
            r5 = r8 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x004a
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0048
        L_0x0046:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r25
        L_0x004c:
            r6 = r32 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0066
        L_0x0053:
            r7 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0066
            r7 = r26
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0062
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r3 = r3 | r9
            goto L_0x0068
        L_0x0066:
            r7 = r26
        L_0x0068:
            r9 = r32 & 8
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0072
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0085
        L_0x0072:
            r11 = r8 & r10
            if (r11 != 0) goto L_0x0085
            r11 = r27
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0081
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0083
        L_0x0081:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0083:
            r3 = r3 | r12
            goto L_0x0087
        L_0x0085:
            r11 = r27
        L_0x0087:
            r12 = r32 & 16
            r13 = 458752(0x70000, float:6.42848E-40)
            if (r12 == 0) goto L_0x0091
            r14 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r14
            goto L_0x00a4
        L_0x0091:
            r14 = r8 & r13
            if (r14 != 0) goto L_0x00a4
            r14 = r28
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00a0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a2
        L_0x00a0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00a2:
            r3 = r3 | r15
            goto L_0x00a6
        L_0x00a4:
            r14 = r28
        L_0x00a6:
            r15 = r32 & 32
            if (r15 == 0) goto L_0x00ae
            r15 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r15
            goto L_0x00c3
        L_0x00ae:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00c3
            r15 = r29
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00be
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c0
        L_0x00be:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00c0:
            r3 = r3 | r16
            goto L_0x00c5
        L_0x00c3:
            r15 = r29
        L_0x00c5:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r13 = r3 & r16
            r10 = 599184(0x92490, float:8.39636E-40)
            if (r13 != r10) goto L_0x00df
            boolean r10 = r1.getSkipping()
            if (r10 != 0) goto L_0x00d6
            goto L_0x00df
        L_0x00d6:
            r1.skipToGroupEnd()
            r3 = r5
            r4 = r7
            r5 = r11
            r6 = r14
            goto L_0x0171
        L_0x00df:
            if (r4 == 0) goto L_0x00e6
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00e7
        L_0x00e6:
            r4 = r5
        L_0x00e7:
            r5 = 0
            r10 = 3
            r13 = 0
            if (r6 == 0) goto L_0x0105
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r5, r10, r13)
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r6 = r6.plus(r7)
            goto L_0x0106
        L_0x0105:
            r6 = r7
        L_0x0106:
            if (r9 == 0) goto L_0x0121
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r5, r10, r13)
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.ExitTransition r7 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r5 = r5.plus(r7)
            goto L_0x0122
        L_0x0121:
            r5 = r11
        L_0x0122:
            if (r12 == 0) goto L_0x0127
            java.lang.String r7 = "AnimatedVisibility"
            goto L_0x0128
        L_0x0127:
            r7 = r14
        L_0x0128:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0134
            r9 = -1
            java.lang.String r10 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:280)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r9, r10)
        L_0x0134:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r24)
            int r9 = r3 >> 3
            r10 = r9 & 14
            int r11 = r3 >> 12
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            r11 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r7, (androidx.compose.runtime.Composer) r1, (int) r10, (int) r11)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5 r10 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r11 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 | 48
            r12 = r3 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r12
            r3 = r3 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r11
            r16 = r3 | r9
            r9 = r0
            r11 = r4
            r12 = r6
            r13 = r5
            r14 = r29
            r15 = r1
            AnimatedVisibilityImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x016e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x016e:
            r3 = r4
            r4 = r6
            r6 = r7
        L_0x0171:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x018c
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6 r11 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6
            r0 = r11
            r1 = r23
            r2 = r24
            r7 = r29
            r8 = r31
            r9 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r1 = r23
            r7 = r30
            r0 = -222898426(0xfffffffff2b6d706, float:-7.243036E30)
            r2 = r29
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(AnimatedVisibility)P(5,4,1,2,3)387@20969L37,388@21011L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r31 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r7 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r7 & 14
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r7
            goto L_0x0029
        L_0x0028:
            r3 = r7
        L_0x0029:
            r4 = r31 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r7 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0043
            r5 = r24
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r24
        L_0x0045:
            r6 = r31 & 4
            if (r6 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r8 = r7 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x005f
            r8 = r25
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r9
            goto L_0x0061
        L_0x005f:
            r8 = r25
        L_0x0061:
            r9 = r31 & 8
            if (r9 == 0) goto L_0x0068
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r10 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007b
            r10 = r26
            boolean r11 = r2.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0077
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r3 = r3 | r11
            goto L_0x007d
        L_0x007b:
            r10 = r26
        L_0x007d:
            r11 = r31 & 16
            r12 = 57344(0xe000, float:8.0356E-41)
            if (r11 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r13 = r7 & r12
            if (r13 != 0) goto L_0x009a
            r13 = r27
            boolean r14 = r2.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0096
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r3 = r3 | r14
            goto L_0x009c
        L_0x009a:
            r13 = r27
        L_0x009c:
            r14 = r31 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00a6
            r14 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r14
            goto L_0x00ba
        L_0x00a6:
            r14 = r7 & r15
            if (r14 != 0) goto L_0x00ba
            r14 = r28
            boolean r16 = r2.changedInstance(r14)
            if (r16 == 0) goto L_0x00b5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r3 = r3 | r16
            goto L_0x00bc
        L_0x00ba:
            r14 = r28
        L_0x00bc:
            r16 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r3 & r16
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r12) goto L_0x00d5
            boolean r12 = r2.getSkipping()
            if (r12 != 0) goto L_0x00cd
            goto L_0x00d5
        L_0x00cd:
            r2.skipToGroupEnd()
            r4 = r5
            r3 = r8
            r5 = r13
            goto L_0x0168
        L_0x00d5:
            if (r4 == 0) goto L_0x00dc
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00dd
        L_0x00dc:
            r4 = r5
        L_0x00dd:
            r5 = 0
            r12 = 3
            r15 = 0
            if (r6 == 0) goto L_0x00fb
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r15, r5, r12, r15)
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.EnterTransition r8 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r6 = r6.plus(r8)
            goto L_0x00fc
        L_0x00fb:
            r6 = r8
        L_0x00fc:
            if (r9 == 0) goto L_0x0117
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r15, r5, r12, r15)
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.ExitTransition r8 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r5 = r5.plus(r8)
            goto L_0x0118
        L_0x0117:
            r5 = r10
        L_0x0118:
            if (r11 == 0) goto L_0x011e
            java.lang.String r8 = "AnimatedVisibility"
            r15 = r8
            goto L_0x011f
        L_0x011e:
            r15 = r13
        L_0x011f:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x012b
            r8 = -1
            java.lang.String r9 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:386)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r8, r9)
        L_0x012b:
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            r8 = r3 & 14
            r0 = r0 | r8
            int r8 = r3 >> 9
            r8 = r8 & 112(0x70, float:1.57E-43)
            r0 = r0 | r8
            r8 = 0
            androidx.compose.animation.core.Transition r8 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r15, (androidx.compose.runtime.Composer) r2, (int) r0, (int) r8)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7.INSTANCE
            r9 = r0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            int r0 = r3 << 3
            r10 = r0 & 896(0x380, float:1.256E-42)
            r10 = r10 | 48
            r11 = r0 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r11
            r0 = r0 | r10
            r10 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r10
            r0 = r0 | r3
            r10 = r4
            r11 = r6
            r12 = r5
            r13 = r28
            r14 = r2
            r3 = r15
            r15 = r0
            AnimatedVisibilityImpl(r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0165
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0165:
            r10 = r5
            r5 = r3
            r3 = r6
        L_0x0168:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x0183
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8 r11 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8
            r0 = r11
            r1 = r23
            r2 = r4
            r4 = r10
            r6 = r28
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r9.updateScope(r11)
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.RowScope r23, androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r2 = r24
            r8 = r31
            r0 = 836509870(0x31dc20ae, float:6.406558E-9)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(AnimatedVisibility)P(5,4,1,2,3)462@25330L37,463@25372L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r8 | 48
            goto L_0x002b
        L_0x0019:
            r3 = r8 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x002a
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0026
            r3 = 32
            goto L_0x0028
        L_0x0026:
            r3 = 16
        L_0x0028:
            r3 = r3 | r8
            goto L_0x002b
        L_0x002a:
            r3 = r8
        L_0x002b:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0045
        L_0x0032:
            r5 = r8 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0045
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0043
        L_0x0041:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r25
        L_0x0047:
            r6 = r32 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0061
        L_0x004e:
            r7 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0061
            r7 = r26
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x005d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x005f
        L_0x005d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x005f:
            r3 = r3 | r9
            goto L_0x0063
        L_0x0061:
            r7 = r26
        L_0x0063:
            r9 = r32 & 8
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0080
        L_0x006d:
            r11 = r8 & r10
            if (r11 != 0) goto L_0x0080
            r11 = r27
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x007c
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007e
        L_0x007c:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x007e:
            r3 = r3 | r12
            goto L_0x0082
        L_0x0080:
            r11 = r27
        L_0x0082:
            r12 = r32 & 16
            r13 = 458752(0x70000, float:6.42848E-40)
            if (r12 == 0) goto L_0x008c
            r14 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r14
            goto L_0x009f
        L_0x008c:
            r14 = r8 & r13
            if (r14 != 0) goto L_0x009f
            r14 = r28
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x009b
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x009d
        L_0x009b:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x009d:
            r3 = r3 | r15
            goto L_0x00a1
        L_0x009f:
            r14 = r28
        L_0x00a1:
            r15 = r32 & 32
            if (r15 == 0) goto L_0x00a9
            r15 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r15
            goto L_0x00be
        L_0x00a9:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00be
            r15 = r29
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00b9
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bb
        L_0x00b9:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00bb:
            r3 = r3 | r16
            goto L_0x00c0
        L_0x00be:
            r15 = r29
        L_0x00c0:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r13 = r3 & r16
            r10 = 599184(0x92490, float:8.39636E-40)
            if (r13 != r10) goto L_0x00da
            boolean r10 = r1.getSkipping()
            if (r10 != 0) goto L_0x00d1
            goto L_0x00da
        L_0x00d1:
            r1.skipToGroupEnd()
            r3 = r5
            r4 = r7
            r5 = r11
            r6 = r14
            goto L_0x016b
        L_0x00da:
            if (r4 == 0) goto L_0x00e1
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00e2
        L_0x00e1:
            r4 = r5
        L_0x00e2:
            r5 = 0
            r10 = 3
            r13 = 0
            if (r6 == 0) goto L_0x0100
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandHorizontally$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r5, r10, r13)
            androidx.compose.animation.EnterTransition r6 = r6.plus(r7)
            goto L_0x0101
        L_0x0100:
            r6 = r7
        L_0x0101:
            if (r9 == 0) goto L_0x011c
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.ExitTransition r7 = androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r5, r10, r13)
            androidx.compose.animation.ExitTransition r5 = r7.plus(r5)
            goto L_0x011d
        L_0x011c:
            r5 = r11
        L_0x011d:
            if (r12 == 0) goto L_0x0122
            java.lang.String r7 = "AnimatedVisibility"
            goto L_0x0123
        L_0x0122:
            r7 = r14
        L_0x0123:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x012f
            r9 = -1
            java.lang.String r10 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:461)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r9, r10)
        L_0x012f:
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            int r9 = r3 >> 3
            r10 = r9 & 14
            r0 = r0 | r10
            int r10 = r3 >> 12
            r10 = r10 & 112(0x70, float:1.57E-43)
            r0 = r0 | r10
            r10 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r7, (androidx.compose.runtime.Composer) r1, (int) r0, (int) r10)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9 r10 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r11 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 | 48
            r12 = r3 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r12
            r3 = r3 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r11
            r16 = r3 | r9
            r9 = r0
            r11 = r4
            r12 = r6
            r13 = r5
            r14 = r29
            r15 = r1
            AnimatedVisibilityImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0168
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0168:
            r3 = r4
            r4 = r6
            r6 = r7
        L_0x016b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x0186
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10 r11 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10
            r0 = r11
            r1 = r23
            r2 = r24
            r7 = r29
            r8 = r31
            r9 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope r23, androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r2 = r24
            r8 = r31
            r0 = -850656618(0xffffffffcd4c0296, float:-2.13920096E8)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(AnimatedVisibility)P(5,4,1,2,3)538@29783L37,539@29825L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r8 | 48
            goto L_0x002b
        L_0x0019:
            r3 = r8 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x002a
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0026
            r3 = 32
            goto L_0x0028
        L_0x0026:
            r3 = 16
        L_0x0028:
            r3 = r3 | r8
            goto L_0x002b
        L_0x002a:
            r3 = r8
        L_0x002b:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0045
        L_0x0032:
            r5 = r8 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0045
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0043
        L_0x0041:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r25
        L_0x0047:
            r6 = r32 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0061
        L_0x004e:
            r7 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0061
            r7 = r26
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x005d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x005f
        L_0x005d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x005f:
            r3 = r3 | r9
            goto L_0x0063
        L_0x0061:
            r7 = r26
        L_0x0063:
            r9 = r32 & 8
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0080
        L_0x006d:
            r11 = r8 & r10
            if (r11 != 0) goto L_0x0080
            r11 = r27
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x007c
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007e
        L_0x007c:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x007e:
            r3 = r3 | r12
            goto L_0x0082
        L_0x0080:
            r11 = r27
        L_0x0082:
            r12 = r32 & 16
            r13 = 458752(0x70000, float:6.42848E-40)
            if (r12 == 0) goto L_0x008c
            r14 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r14
            goto L_0x009f
        L_0x008c:
            r14 = r8 & r13
            if (r14 != 0) goto L_0x009f
            r14 = r28
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x009b
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x009d
        L_0x009b:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x009d:
            r3 = r3 | r15
            goto L_0x00a1
        L_0x009f:
            r14 = r28
        L_0x00a1:
            r15 = r32 & 32
            if (r15 == 0) goto L_0x00a9
            r15 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r15
            goto L_0x00be
        L_0x00a9:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00be
            r15 = r29
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00b9
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bb
        L_0x00b9:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00bb:
            r3 = r3 | r16
            goto L_0x00c0
        L_0x00be:
            r15 = r29
        L_0x00c0:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r13 = r3 & r16
            r10 = 599184(0x92490, float:8.39636E-40)
            if (r13 != r10) goto L_0x00da
            boolean r10 = r1.getSkipping()
            if (r10 != 0) goto L_0x00d1
            goto L_0x00da
        L_0x00d1:
            r1.skipToGroupEnd()
            r3 = r5
            r4 = r7
            r5 = r11
            r6 = r14
            goto L_0x016b
        L_0x00da:
            if (r4 == 0) goto L_0x00e1
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00e2
        L_0x00e1:
            r4 = r5
        L_0x00e2:
            r5 = 0
            r10 = 3
            r13 = 0
            if (r6 == 0) goto L_0x0100
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r5, r10, r13)
            androidx.compose.animation.EnterTransition r6 = r6.plus(r7)
            goto L_0x0101
        L_0x0100:
            r6 = r7
        L_0x0101:
            if (r9 == 0) goto L_0x011c
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.ExitTransition r7 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r5, r10, r13)
            androidx.compose.animation.ExitTransition r5 = r7.plus(r5)
            goto L_0x011d
        L_0x011c:
            r5 = r11
        L_0x011d:
            if (r12 == 0) goto L_0x0122
            java.lang.String r7 = "AnimatedVisibility"
            goto L_0x0123
        L_0x0122:
            r7 = r14
        L_0x0123:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x012f
            r9 = -1
            java.lang.String r10 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:537)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r9, r10)
        L_0x012f:
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            int r9 = r3 >> 3
            r10 = r9 & 14
            r0 = r0 | r10
            int r10 = r3 >> 12
            r10 = r10 & 112(0x70, float:1.57E-43)
            r0 = r0 | r10
            r10 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r7, (androidx.compose.runtime.Composer) r1, (int) r0, (int) r10)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11 r10 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r11 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 | 48
            r12 = r3 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r12
            r3 = r3 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r11
            r16 = r3 | r9
            r9 = r0
            r11 = r4
            r12 = r6
            r13 = r5
            r14 = r29
            r15 = r1
            AnimatedVisibilityImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0168
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0168:
            r3 = r4
            r4 = r6
            r6 = r7
        L_0x016b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x0186
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12 r11 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12
            r0 = r11
            r1 = r23
            r2 = r24
            r7 = r29
            r8 = r31
            r9 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void AnimatedVisibility(androidx.compose.animation.core.Transition<T> r23, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r7 = r30
            r0 = 1031950689(0x3d825161, float:0.06363178)
            r1 = r29
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedVisibility)P(4,3,1,2)612@34154L79:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r31 & r2
            if (r2 == 0) goto L_0x001c
            r2 = r7 | 6
            r3 = r2
            r2 = r23
            goto L_0x0030
        L_0x001c:
            r2 = r7 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r23
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r7
            goto L_0x0030
        L_0x002d:
            r2 = r23
            r3 = r7
        L_0x0030:
            r4 = r31 & 1
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r7 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004a
            r4 = r24
            boolean r5 = r1.changedInstance(r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r3 = r3 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r24
        L_0x004c:
            r5 = r31 & 2
            if (r5 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r7 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0066
            r6 = r25
            boolean r8 = r1.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0062
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r8
            goto L_0x0068
        L_0x0066:
            r6 = r25
        L_0x0068:
            r8 = r31 & 4
            if (r8 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r9 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0082
            r9 = r26
            boolean r10 = r1.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x007e
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r10
            goto L_0x0084
        L_0x0082:
            r9 = r26
        L_0x0084:
            r10 = r31 & 8
            if (r10 == 0) goto L_0x008b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008b:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r7
            if (r11 != 0) goto L_0x00a0
            r11 = r27
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x009c
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r3 = r3 | r12
            goto L_0x00a2
        L_0x00a0:
            r11 = r27
        L_0x00a2:
            r12 = r31 & 16
            if (r12 == 0) goto L_0x00ac
            r12 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r12
            r15 = r28
            goto L_0x00bf
        L_0x00ac:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r7
            r15 = r28
            if (r12 != 0) goto L_0x00bf
            boolean r12 = r1.changedInstance(r15)
            if (r12 == 0) goto L_0x00bc
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r3 = r3 | r12
        L_0x00bf:
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r3
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r13) goto L_0x00d6
            boolean r12 = r1.getSkipping()
            if (r12 != 0) goto L_0x00cf
            goto L_0x00d6
        L_0x00cf:
            r1.skipToGroupEnd()
            r3 = r6
            r5 = r11
            goto L_0x0148
        L_0x00d6:
            if (r5 == 0) goto L_0x00dd
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x00de
        L_0x00dd:
            r5 = r6
        L_0x00de:
            r6 = 3
            r12 = 0
            r13 = 0
            if (r8 == 0) goto L_0x00fe
            androidx.compose.animation.EnterTransition r8 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r12, r6, r13)
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.EnterTransition r9 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r8 = r8.plus(r9)
            r16 = r8
            goto L_0x0100
        L_0x00fe:
            r16 = r9
        L_0x0100:
            if (r10 == 0) goto L_0x011b
            r21 = 15
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.animation.ExitTransition r8 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r6 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r12, r6, r13)
            androidx.compose.animation.ExitTransition r6 = r8.plus(r6)
            goto L_0x011c
        L_0x011b:
            r6 = r11
        L_0x011c:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0128
            r8 = -1
            java.lang.String r9 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:612)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r8, r9)
        L_0x0128:
            r0 = 524286(0x7fffe, float:7.34681E-40)
            r0 = r0 & r3
            r8 = r23
            r9 = r24
            r10 = r5
            r11 = r16
            r12 = r6
            r13 = r28
            r14 = r1
            r15 = r0
            AnimatedVisibilityImpl(r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0144
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0144:
            r3 = r5
            r5 = r6
            r9 = r16
        L_0x0148:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x0164
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13 r11 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13
            r0 = r11
            r1 = r23
            r2 = r24
            r4 = r9
            r6 = r28
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(message = "AnimatedVisibility no longer accepts initiallyVisible as a parameter, please use AnimatedVisibility(MutableTransitionState, Modifier, ...) API instead", replaceWith = @kotlin.ReplaceWith(expression = "AnimatedVisibility(transitionState = remember { MutableTransitionState(initiallyVisible) }\n.apply { targetState = visible },\nmodifier = modifier,\nenter = enter,\nexit = exit) {\ncontent() \n}", imports = {"androidx.compose.animation.core.MutableTransitionState"}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(boolean r17, androidx.compose.ui.Modifier r18, androidx.compose.animation.EnterTransition r19, androidx.compose.animation.ExitTransition r20, boolean r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r6 = r22
            r7 = r24
            r0 = 1121582420(0x42d9fd54, float:108.99478)
            r1 = r23
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedVisibility)P(5,4,1,2,3)*715@38991L53,714@38952L214:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r25 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r7 | 6
            r3 = r2
            r2 = r17
            goto L_0x0030
        L_0x001c:
            r2 = r7 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r17
            boolean r3 = r1.changed((boolean) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r7
            goto L_0x0030
        L_0x002d:
            r2 = r17
            r3 = r7
        L_0x0030:
            r4 = r25 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r7 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004a
            r5 = r18
            boolean r8 = r1.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x0046
            r8 = 32
            goto L_0x0048
        L_0x0046:
            r8 = 16
        L_0x0048:
            r3 = r3 | r8
            goto L_0x004c
        L_0x004a:
            r5 = r18
        L_0x004c:
            r8 = r25 & 4
            if (r8 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            r15 = r19
            goto L_0x0067
        L_0x0055:
            r8 = r7 & 896(0x380, float:1.256E-42)
            r15 = r19
            if (r8 != 0) goto L_0x0067
            boolean r8 = r1.changed((java.lang.Object) r15)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r8
        L_0x0067:
            r8 = r25 & 8
            if (r8 == 0) goto L_0x0070
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r14 = r20
            goto L_0x0082
        L_0x0070:
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            r14 = r20
            if (r8 != 0) goto L_0x0082
            boolean r8 = r1.changed((java.lang.Object) r14)
            if (r8 == 0) goto L_0x007f
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r3 = r3 | r8
        L_0x0082:
            r8 = r25 & 16
            if (r8 == 0) goto L_0x008b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r13 = r21
            goto L_0x009f
        L_0x008b:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r7
            r13 = r21
            if (r8 != 0) goto L_0x009f
            boolean r8 = r1.changed((boolean) r13)
            if (r8 == 0) goto L_0x009c
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r3 = r3 | r8
        L_0x009f:
            r8 = r25 & 32
            r9 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a7
            r3 = r3 | r9
            goto L_0x00b8
        L_0x00a7:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r7
            if (r8 != 0) goto L_0x00b8
            boolean r8 = r1.changedInstance(r6)
            if (r8 == 0) goto L_0x00b5
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r3 = r3 | r8
        L_0x00b8:
            r8 = 374491(0x5b6db, float:5.24774E-40)
            r8 = r8 & r3
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r8 != r10) goto L_0x00ce
            boolean r8 = r1.getSkipping()
            if (r8 != 0) goto L_0x00c8
            goto L_0x00ce
        L_0x00c8:
            r1.skipToGroupEnd()
            r4 = r5
            goto L_0x0144
        L_0x00ce:
            if (r4 == 0) goto L_0x00d5
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00d6
        L_0x00d5:
            r4 = r5
        L_0x00d6:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00e2
            r5 = -1
            java.lang.String r8 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:714)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r5, r8)
        L_0x00e2:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            java.lang.Object r0 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x0105
            androidx.compose.animation.core.MutableTransitionState r0 = new androidx.compose.animation.core.MutableTransitionState
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r21)
            r0.<init>(r5)
            r1.updateRememberedValue(r0)
        L_0x0105:
            r1.endReplaceableGroup()
            r8 = r0
            androidx.compose.animation.core.MutableTransitionState r8 = (androidx.compose.animation.core.MutableTransitionState) r8
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r17)
            r8.setTargetState(r0)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$16 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$16
            r0.<init>(r6)
            r5 = 1996320812(0x76fd702c, float:2.5701684E33)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r5, r10, r0)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            int r5 = androidx.compose.animation.core.MutableTransitionState.$stable
            r5 = r5 | r9
            r9 = r3 & 112(0x70, float:1.57E-43)
            r5 = r5 | r9
            r9 = r3 & 896(0x380, float:1.256E-42)
            r5 = r5 | r9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r5
            r16 = 16
            r12 = 0
            r9 = r4
            r10 = r19
            r11 = r20
            r13 = r0
            r14 = r1
            r15 = r3
            AnimatedVisibility((androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean>) r8, (androidx.compose.ui.Modifier) r9, (androidx.compose.animation.EnterTransition) r10, (androidx.compose.animation.ExitTransition) r11, (java.lang.String) r12, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0144
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0144:
            androidx.compose.runtime.ScopeUpdateScope r9 = r1.endRestartGroup()
            if (r9 == 0) goto L_0x0164
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$17 r10 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$17
            r0 = r10
            r1 = r17
            r2 = r4
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r24
            r8 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final <T> void AnimatedVisibilityImpl(Transition<T> transition, Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        int i2;
        Transition<T> transition2 = transition;
        Function1<? super T, Boolean> function12 = function1;
        Modifier modifier2 = modifier;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(429978603);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibilityImpl)P(4,5,3,1,2)740@39776L703:AnimatedVisibility.kt#xbi5r1");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) transition2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier2) ? 256 : 128;
        }
        EnterTransition enterTransition2 = enterTransition;
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) enterTransition2) ? 2048 : 1024;
        }
        ExitTransition exitTransition2 = exitTransition;
        if ((i3 & 57344) == 0) {
            i2 |= startRestartGroup.changed((Object) exitTransition2) ? 16384 : 8192;
        }
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        if ((458752 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
        }
        if ((374491 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429978603, i2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:739)");
            }
            startRestartGroup.startReplaceableGroup(-311853878);
            boolean changedInstance = startRestartGroup.changedInstance(function12) | startRestartGroup.changed((Object) transition2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1(function12, transition2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AnimatedEnterExitImpl(transition, function1, LayoutModifierKt.layout(modifier2, (Function3) rememberedValue), enterTransition, exitTransition, AnimatedVisibilityKt$AnimatedVisibilityImpl$2.INSTANCE, (OnLookaheadMeasured) null, function3, startRestartGroup, 196608 | (i2 & 14) | (i2 & 112) | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AnimatedVisibilityKt$AnimatedVisibilityImpl$3(transition, function1, modifier, enterTransition, exitTransition, function3, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void AnimatedEnterExitImpl(androidx.compose.animation.core.Transition<T> r21, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r22, androidx.compose.ui.Modifier r23, androidx.compose.animation.EnterTransition r24, androidx.compose.animation.ExitTransition r25, kotlin.jvm.functions.Function2<? super androidx.compose.animation.EnterExitState, ? super androidx.compose.animation.EnterExitState, java.lang.Boolean> r26, androidx.compose.animation.OnLookaheadMeasured r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r26
            r10 = r28
            r11 = r30
            r12 = r31
            r0 = -891967166(0xffffffffcad5a942, float:-7001249.0)
            r1 = r29
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedEnterExitImpl)P(6,7,3,1,2,5,4)788@41251L116,792@41410L40,794@41490L574,815@42162L69,819@42377L39,833@43122L50,816@42244L942:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0023
            r1 = r11 | 6
            goto L_0x0033
        L_0x0023:
            r1 = r11 & 14
            if (r1 != 0) goto L_0x0032
            boolean r1 = r15.changed((java.lang.Object) r6)
            if (r1 == 0) goto L_0x002f
            r1 = 4
            goto L_0x0030
        L_0x002f:
            r1 = 2
        L_0x0030:
            r1 = r1 | r11
            goto L_0x0033
        L_0x0032:
            r1 = r11
        L_0x0033:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x003a
            r1 = r1 | 48
            goto L_0x004a
        L_0x003a:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004a
            boolean r2 = r15.changedInstance(r7)
            if (r2 == 0) goto L_0x0047
            r2 = 32
            goto L_0x0049
        L_0x0047:
            r2 = 16
        L_0x0049:
            r1 = r1 | r2
        L_0x004a:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0051
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x0051:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0061
            boolean r2 = r15.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x005e
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r2
        L_0x0061:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r14 = r24
            goto L_0x007c
        L_0x006a:
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            r14 = r24
            if (r2 != 0) goto L_0x007c
            boolean r2 = r15.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0079
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r2
        L_0x007c:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x0085
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r13 = r25
            goto L_0x0099
        L_0x0085:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r11
            r13 = r25
            if (r2 != 0) goto L_0x0099
            boolean r2 = r15.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0096
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r2
        L_0x0099:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x00a1
            r2 = 196608(0x30000, float:2.75506E-40)
        L_0x009f:
            r1 = r1 | r2
            goto L_0x00b2
        L_0x00a1:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r15.changedInstance(r9)
            if (r2 == 0) goto L_0x00af
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x009f
        L_0x00af:
            r2 = 65536(0x10000, float:9.18355E-41)
            goto L_0x009f
        L_0x00b2:
            r2 = r12 & 64
            if (r2 == 0) goto L_0x00ba
            r3 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r3
            goto L_0x00ce
        L_0x00ba:
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r11
            if (r3 != 0) goto L_0x00ce
            r3 = r27
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x00ca
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00ca:
            r4 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r1 = r1 | r4
            goto L_0x00d0
        L_0x00ce:
            r3 = r27
        L_0x00d0:
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00d8
            r4 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00d6:
            r1 = r1 | r4
            goto L_0x00e9
        L_0x00d8:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r11
            if (r4 != 0) goto L_0x00e9
            boolean r4 = r15.changedInstance(r10)
            if (r4 == 0) goto L_0x00e6
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00d6
        L_0x00e6:
            r4 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00d6
        L_0x00e9:
            r5 = r1
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r5
            r4 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r4) goto L_0x0101
            boolean r1 = r15.getSkipping()
            if (r1 != 0) goto L_0x00fa
            goto L_0x0101
        L_0x00fa:
            r15.skipToGroupEnd()
            r11 = r3
            r0 = r15
            goto L_0x0389
        L_0x0101:
            if (r2 == 0) goto L_0x0104
            r3 = 0
        L_0x0104:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r2 = -1
            if (r1 == 0) goto L_0x0110
            java.lang.String r1 = "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:784)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r2, r1)
        L_0x0110:
            java.lang.Object r0 = r21.getTargetState()
            java.lang.Object r0 = r7.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x013a
            java.lang.Object r0 = r21.getCurrentState()
            java.lang.Object r0 = r7.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x013a
            boolean r0 = r21.isSeeking()
            if (r0 == 0) goto L_0x0137
            goto L_0x013a
        L_0x0137:
            r0 = r15
            goto L_0x037f
        L_0x013a:
            r0 = r5 & 14
            r0 = r0 | 48
            r1 = 1215497572(0x48730564, float:248853.56)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(createChildTransition)1010@39937L36,1011@39997L74,1012@40094L39,1013@40145L63:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r0 = r0 & 14
            r1 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            boolean r16 = r15.changed((java.lang.Object) r6)
            java.lang.Object r1 = r15.rememberedValue()
            if (r16 != 0) goto L_0x0168
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r16.getEmpty()
            if (r1 != r4) goto L_0x016f
        L_0x0168:
            java.lang.Object r1 = r21.getCurrentState()
            r15.updateRememberedValue(r1)
        L_0x016f:
            r15.endReplaceableGroup()
            boolean r4 = r21.isSeeking()
            if (r4 == 0) goto L_0x017c
            java.lang.Object r1 = r21.getCurrentState()
        L_0x017c:
            r4 = -466616829(0xffffffffe42ffe03, float:-1.2985935E22)
            r15.startReplaceableGroup(r4)
            java.lang.String r4 = "C789@41329L28:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r4)
            boolean r18 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r19 = r2
            java.lang.String r2 = "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:789)"
            r11 = 0
            if (r18 == 0) goto L_0x019c
            r18 = r3
            r3 = -1
            r12 = -466616829(0xffffffffe42ffe03, float:-1.2985935E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r11, r3, r2)
            goto L_0x019e
        L_0x019c:
            r18 = r3
        L_0x019e:
            r3 = r5 & 126(0x7e, float:1.77E-43)
            androidx.compose.animation.EnterExitState r1 = targetEnterExit(r6, r7, r1, r15, r3)
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01ad
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ad:
            r15.endReplaceableGroup()
            java.lang.Object r12 = r21.getTargetState()
            r11 = -466616829(0xffffffffe42ffe03, float:-1.2985935E22)
            r15.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r4)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r16 = r5
            if (r4 == 0) goto L_0x01ca
            r4 = 0
            r5 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r4, r5, r2)
        L_0x01ca:
            androidx.compose.animation.EnterExitState r2 = targetEnterExit(r6, r7, r12, r15, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01d7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d7:
            r15.endReplaceableGroup()
            r5 = r0 | 3072(0xc00, float:4.305E-42)
            java.lang.String r3 = "EnterExitTransition"
            r0 = r21
            r11 = 1157296644(0x44faf204, float:2007.563)
            r12 = r19
            r4 = r18
            r20 = r4
            r11 = 0
            r4 = r15
            r19 = r16
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(r0, r1, r2, r3, r4, r5)
            r15.endReplaceableGroup()
            int r1 = r19 >> 15
            r1 = r1 & 14
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r9, r15, r1)
            java.lang.Object r2 = r0.getCurrentState()
            java.lang.Object r3 = r0.getTargetState()
            java.lang.Object r2 = r9.invoke(r2, r3)
            r3 = -311852107(0xffffffffed6983b5, float:-4.516827E27)
            r15.startReplaceableGroup(r3)
            boolean r3 = r15.changed((java.lang.Object) r0)
            boolean r4 = r15.changed((java.lang.Object) r1)
            r3 = r3 | r4
            java.lang.Object r4 = r15.rememberedValue()
            if (r3 != 0) goto L_0x0225
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0230
        L_0x0225:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 r3 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1
            r3.<init>(r0, r1, r11)
            r4 = r3
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r15.updateRememberedValue(r4)
        L_0x0230:
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r15.endReplaceableGroup()
            r1 = 64
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.produceState(r2, r4, r15, r1)
            boolean r2 = getExitFinished(r0)
            if (r2 == 0) goto L_0x024d
            boolean r1 = AnimatedEnterExitImpl$lambda$6(r1)
            if (r1 != 0) goto L_0x0248
            goto L_0x024d
        L_0x0248:
            r0 = r15
            r3 = r20
            goto L_0x037f
        L_0x024d:
            r1 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r12)
            boolean r1 = r15.changed((java.lang.Object) r6)
            java.lang.Object r2 = r15.rememberedValue()
            if (r1 != 0) goto L_0x0268
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0270
        L_0x0268:
            androidx.compose.animation.AnimatedVisibilityScopeImpl r2 = new androidx.compose.animation.AnimatedVisibilityScopeImpl
            r2.<init>(r0)
            r15.updateRememberedValue(r2)
        L_0x0270:
            r15.endReplaceableGroup()
            androidx.compose.animation.AnimatedVisibilityScopeImpl r2 = (androidx.compose.animation.AnimatedVisibilityScopeImpl) r2
            int r1 = r19 >> 6
            r3 = r1 & 112(0x70, float:1.57E-43)
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r1 = r1 & 896(0x380, float:1.256E-42)
            r18 = r3 | r1
            java.lang.String r16 = "Built-in"
            r13 = r0
            r14 = r24
            r0 = r15
            r15 = r25
            r17 = r0
            androidx.compose.ui.Modifier r1 = androidx.compose.animation.EnterExitTransitionKt.createModifier(r13, r14, r15, r16, r17, r18)
            r3 = r20
            if (r3 == 0) goto L_0x02a1
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2 r5 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2
            r5.<init>(r3)
            kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.layout.LayoutModifierKt.layout(r4, r5)
            goto L_0x02a5
        L_0x02a1:
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
        L_0x02a5:
            androidx.compose.ui.Modifier r1 = r1.then(r4)
            androidx.compose.ui.Modifier r1 = r8.then(r1)
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            java.lang.Object r4 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x02cc
            androidx.compose.animation.AnimatedEnterExitMeasurePolicy r4 = new androidx.compose.animation.AnimatedEnterExitMeasurePolicy
            r4.<init>(r2)
            r0.updateRememberedValue(r4)
        L_0x02cc:
            r0.endReplaceableGroup()
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r5 = 0
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r0, r5)
            androidx.compose.runtime.CompositionLocalMap r5 = r0.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            androidx.compose.runtime.Applier r13 = r0.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x02fa
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02fa:
            r0.startReusableNode()
            boolean r13 = r0.getInserting()
            if (r13 == 0) goto L_0x0307
            r0.createNode(r12)
            goto L_0x030a
        L_0x0307:
            r0.useNode()
        L_0x030a:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m3282constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r4, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r5 = r12.getInserting()
            if (r5 != 0) goto L_0x033a
            java.lang.Object r5 = r12.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r13)
            if (r5 != 0) goto L_0x0348
        L_0x033a:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r12.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r12.apply(r5, r4)
        L_0x0348:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r4)
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.invoke(r4, r0, r5)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -174036415(0xfffffffff5a06a41, float:-4.0670048E32)
            java.lang.String r4 = "C817@42286L9:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r1, r4)
            int r1 = r19 >> 18
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 8
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.invoke(r2, r0, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
        L_0x037f:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0388
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0388:
            r11 = r3
        L_0x0389:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 == 0) goto L_0x03ad
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4 r13 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4
            r0 = r13
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r11
            r8 = r28
            r9 = r30
            r10 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x03ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function2, androidx.compose.animation.OnLookaheadMeasured, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        return transition.getCurrentState() == EnterExitState.PostExit && transition.getTargetState() == EnterExitState.PostExit;
    }

    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer composer, int i) {
        EnterExitState enterExitState;
        composer.startReplaceableGroup(361571134);
        ComposerKt.sourceInformation(composer, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:889)");
        }
        composer.startMovableGroup(-721835388, transition);
        ComposerKt.sourceInformation(composer, "902@45413L34");
        if (!transition.isSeeking()) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(true);
            }
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else if (function1.invoke(t).booleanValue()) {
            enterExitState = EnterExitState.Visible;
        } else if (function1.invoke(transition.getCurrentState()).booleanValue()) {
            enterExitState = EnterExitState.PostExit;
        } else {
            enterExitState = EnterExitState.PreEnter;
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return enterExitState;
    }

    /* access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$4(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
