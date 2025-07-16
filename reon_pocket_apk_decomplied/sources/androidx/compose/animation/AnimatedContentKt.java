package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0004¨\u0006("}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", "name", "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
public final class AnimatedContentKt {
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(S r18, androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r20, androidx.compose.ui.Alignment r21, java.lang.String r22, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r23, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r1 = r18
            r8 = r26
            r0 = 2132720749(0x7f1ebc6d, float:2.1099639E38)
            r2 = r25
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(AnimatedContent)P(5,4,6,1,3,2)139@7459L58,140@7533L136:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r27 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r8 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r8 & 14
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r8
            goto L_0x0029
        L_0x0028:
            r3 = r8
        L_0x0029:
            r4 = r27 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r8 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0043
            r5 = r19
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
            r5 = r19
        L_0x0045:
            r6 = r27 & 4
            if (r6 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r7 = r8 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x005f
            r7 = r20
            boolean r9 = r2.changedInstance(r7)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r9
            goto L_0x0061
        L_0x005f:
            r7 = r20
        L_0x0061:
            r9 = r27 & 8
            if (r9 == 0) goto L_0x0068
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r10 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007b
            r10 = r21
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
            r10 = r21
        L_0x007d:
            r11 = r27 & 16
            r12 = 57344(0xe000, float:8.0356E-41)
            if (r11 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r13 = r8 & r12
            if (r13 != 0) goto L_0x009a
            r13 = r22
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
            r13 = r22
        L_0x009c:
            r14 = r27 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00a9
            r16 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r16
            r15 = r23
            goto L_0x00bc
        L_0x00a9:
            r16 = r8 & r15
            r15 = r23
            if (r16 != 0) goto L_0x00bc
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00b8
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r3 = r3 | r16
        L_0x00bc:
            r16 = r27 & 64
            if (r16 == 0) goto L_0x00c7
            r16 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r16
            r12 = r24
            goto L_0x00dc
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r8 & r16
            r12 = r24
            if (r16 != 0) goto L_0x00dc
            boolean r17 = r2.changedInstance(r12)
            if (r17 == 0) goto L_0x00d8
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r3 = r3 | r17
        L_0x00dc:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r3 & r17
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r5) goto L_0x00f7
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00ed
            goto L_0x00f7
        L_0x00ed:
            r2.skipToGroupEnd()
            r3 = r19
            r4 = r10
            r5 = r13
            r6 = r15
            goto L_0x015e
        L_0x00f7:
            if (r4 == 0) goto L_0x00fe
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0100
        L_0x00fe:
            r0 = r19
        L_0x0100:
            if (r6 == 0) goto L_0x0107
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$1 r4 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$1.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r7 = r4
        L_0x0107:
            if (r9 == 0) goto L_0x0110
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            goto L_0x0111
        L_0x0110:
            r4 = r10
        L_0x0111:
            if (r11 == 0) goto L_0x0116
            java.lang.String r5 = "AnimatedContent"
            goto L_0x0117
        L_0x0116:
            r5 = r13
        L_0x0117:
            if (r14 == 0) goto L_0x011e
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$2 r6 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$2.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            goto L_0x011f
        L_0x011e:
            r6 = r15
        L_0x011f:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x012e
            r9 = -1
            java.lang.String r10 = "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:138)"
            r11 = 2132720749(0x7f1ebc6d, float:2.1099639E38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r3, r9, r10)
        L_0x012e:
            r9 = r3 & 14
            int r10 = r3 >> 9
            r10 = r10 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            r10 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r5, (androidx.compose.runtime.Composer) r2, (int) r9, (int) r10)
            r10 = r3 & 8176(0x1ff0, float:1.1457E-41)
            int r3 = r3 >> 3
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r3
            r10 = r10 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r11
            r16 = r10 | r3
            r17 = 0
            r10 = r0
            r11 = r7
            r12 = r4
            r13 = r6
            r14 = r24
            r15 = r2
            AnimatedContent(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x015d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015d:
            r3 = r0
        L_0x015e:
            androidx.compose.runtime.ScopeUpdateScope r10 = r2.endRestartGroup()
            if (r10 == 0) goto L_0x0179
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$3 r11 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$3
            r0 = r11
            r1 = r18
            r2 = r3
            r3 = r7
            r7 = r24
            r8 = r26
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0179:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = AnimatedContentKt$SizeTransform$1.INSTANCE;
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(z, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: androidx.compose.animation.AnimatedContentTransitionScopeImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(androidx.compose.animation.core.Transition<S> r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r23, androidx.compose.ui.Alignment r24, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r25, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r7 = r21
            r8 = r28
            r0 = -114689412(0xfffffffff929fa7c, float:-5.516116E34)
            r1 = r27
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedContent)P(3,4,1,2)666@34009L7,667@34037L106,671@34231L51,672@34304L62,760@38852L58,761@38944L45,771@39263L52,762@38994L327:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r29 & r1
            if (r1 == 0) goto L_0x001b
            r1 = r8 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r8 & 14
            if (r1 != 0) goto L_0x002a
            boolean r1 = r9.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r8
            goto L_0x002b
        L_0x002a:
            r1 = r8
        L_0x002b:
            r2 = r29 & 1
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r8 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0045
            r3 = r22
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r22
        L_0x0047:
            r4 = r29 & 2
            if (r4 == 0) goto L_0x004e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r5 = r8 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0061
            r5 = r23
            boolean r6 = r9.changedInstance(r5)
            if (r6 == 0) goto L_0x005d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r6
            goto L_0x0063
        L_0x0061:
            r5 = r23
        L_0x0063:
            r6 = r29 & 4
            if (r6 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r10 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007d
            r10 = r24
            boolean r11 = r9.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r11
            goto L_0x007f
        L_0x007d:
            r10 = r24
        L_0x007f:
            r11 = r29 & 8
            if (r11 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x009b
            r12 = r25
            boolean r13 = r9.changedInstance(r12)
            if (r13 == 0) goto L_0x0097
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r1 = r1 | r13
            goto L_0x009d
        L_0x009b:
            r12 = r25
        L_0x009d:
            r13 = r29 & 16
            if (r13 == 0) goto L_0x00a5
            r13 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r13
            goto L_0x00b9
        L_0x00a5:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b9
            r13 = r26
            boolean r14 = r9.changedInstance(r13)
            if (r14 == 0) goto L_0x00b5
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r1 = r1 | r14
            goto L_0x00bb
        L_0x00b9:
            r13 = r26
        L_0x00bb:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r1
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00d4
            boolean r14 = r9.getSkipping()
            if (r14 != 0) goto L_0x00cb
            goto L_0x00d4
        L_0x00cb:
            r9.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r10
            r5 = r12
            goto L_0x03fd
        L_0x00d4:
            if (r2 == 0) goto L_0x00dc
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r14 = r2
            goto L_0x00dd
        L_0x00dc:
            r14 = r3
        L_0x00dd:
            if (r4 == 0) goto L_0x00e5
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$4 r2 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$4.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r15 = r2
            goto L_0x00e6
        L_0x00e5:
            r15 = r5
        L_0x00e6:
            if (r6 == 0) goto L_0x00ef
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r10 = r2
        L_0x00ef:
            if (r11 == 0) goto L_0x00f6
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5 r2 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$5.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12 = r2
        L_0x00f6:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r3 = -1
            if (r2 == 0) goto L_0x0102
            java.lang.String r2 = "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:665)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r2)
        L_0x0102:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r2)
            java.lang.Object r0 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            r1 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r1)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            boolean r4 = r9.changed((java.lang.Object) r7)
            java.lang.Object r5 = r9.rememberedValue()
            if (r4 != 0) goto L_0x0136
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x013e
        L_0x0136:
            androidx.compose.animation.AnimatedContentTransitionScopeImpl r5 = new androidx.compose.animation.AnimatedContentTransitionScopeImpl
            r5.<init>(r7, r10, r0)
            r9.updateRememberedValue(r5)
        L_0x013e:
            r9.endReplaceableGroup()
            r11 = r5
            androidx.compose.animation.AnimatedContentTransitionScopeImpl r11 = (androidx.compose.animation.AnimatedContentTransitionScopeImpl) r11
            r9.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            boolean r4 = r9.changed((java.lang.Object) r7)
            java.lang.Object r5 = r9.rememberedValue()
            r6 = 0
            r3 = 1
            if (r4 != 0) goto L_0x015e
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x016d
        L_0x015e:
            java.lang.Object r4 = r21.getCurrentState()
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r5[r6] = r4
            androidx.compose.runtime.snapshots.SnapshotStateList r5 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf(r5)
            r9.updateRememberedValue(r5)
        L_0x016d:
            r9.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r5 = (androidx.compose.runtime.snapshots.SnapshotStateList) r5
            r9.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            boolean r1 = r9.changed((java.lang.Object) r7)
            java.lang.Object r2 = r9.rememberedValue()
            if (r1 != 0) goto L_0x018a
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0195
        L_0x018a:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2
            r9.updateRememberedValue(r2)
        L_0x0195:
            r9.endReplaceableGroup()
            r4 = r2
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r1 = r21.getCurrentState()
            boolean r1 = r5.contains(r1)
            if (r1 != 0) goto L_0x01af
            r5.clear()
            java.lang.Object r1 = r21.getCurrentState()
            r5.add(r1)
        L_0x01af:
            java.lang.Object r1 = r21.getCurrentState()
            java.lang.Object r2 = r21.getTargetState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x01f4
            int r1 = r5.size()
            if (r1 != r3) goto L_0x01d1
            java.lang.Object r1 = r5.get(r6)
            java.lang.Object r2 = r21.getCurrentState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x01db
        L_0x01d1:
            r5.clear()
            java.lang.Object r1 = r21.getCurrentState()
            r5.add(r1)
        L_0x01db:
            int r1 = r4.size()
            if (r1 != r3) goto L_0x01eb
            java.lang.Object r1 = r21.getCurrentState()
            boolean r1 = r4.containsKey(r1)
            if (r1 == 0) goto L_0x01ee
        L_0x01eb:
            r4.clear()
        L_0x01ee:
            r11.setContentAlignment(r10)
            r11.setLayoutDirection$animation_release(r0)
        L_0x01f4:
            java.lang.Object r0 = r21.getCurrentState()
            java.lang.Object r1 = r21.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x0249
            java.lang.Object r0 = r21.getTargetState()
            boolean r0 = r5.contains(r0)
            if (r0 != 0) goto L_0x0249
            r0 = r5
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = r6
        L_0x0214:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0236
            java.lang.Object r2 = r0.next()
            java.lang.Object r2 = r12.invoke(r2)
            java.lang.Object r3 = r21.getTargetState()
            java.lang.Object r3 = r12.invoke(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0232
            r0 = -1
            goto L_0x0238
        L_0x0232:
            int r1 = r1 + 1
            r3 = 1
            goto L_0x0214
        L_0x0236:
            r0 = -1
            r1 = -1
        L_0x0238:
            if (r1 != r0) goto L_0x0242
            java.lang.Object r0 = r21.getTargetState()
            r5.add(r0)
            goto L_0x0249
        L_0x0242:
            java.lang.Object r0 = r21.getTargetState()
            r5.set(r1, r0)
        L_0x0249:
            java.lang.Object r0 = r21.getTargetState()
            boolean r0 = r4.containsKey(r0)
            if (r0 == 0) goto L_0x0262
            java.lang.Object r0 = r21.getCurrentState()
            boolean r0 = r4.containsKey(r0)
            if (r0 != 0) goto L_0x025e
            goto L_0x0262
        L_0x025e:
            r2 = r4
            r20 = r5
            goto L_0x02a9
        L_0x0262:
            r4.clear()
            r3 = r5
            java.util.List r3 = (java.util.List) r3
            int r2 = r3.size()
            r1 = r6
        L_0x026d:
            if (r1 >= r2) goto L_0x025e
            java.lang.Object r0 = r3.get(r1)
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1 r7 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
            r22 = r0
            r0 = r7
            r16 = r1
            r1 = r21
            r17 = r2
            r2 = r22
            r18 = r3
            r8 = 1
            r3 = r15
            r19 = r4
            r4 = r11
            r20 = r5
            r6 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 885640742(0x34c9ce26, float:3.758916E-7)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r0, r8, r7)
            r1 = r22
            r2 = r19
            r2.put(r1, r0)
            int r1 = r16 + 1
            r7 = r21
            r8 = r28
            r4 = r2
            r2 = r17
            r3 = r18
            r6 = 0
            goto L_0x026d
        L_0x02a9:
            androidx.compose.animation.core.Transition$Segment r0 = r21.getSegment()
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            boolean r1 = r9.changed((java.lang.Object) r11)
            boolean r0 = r9.changed((java.lang.Object) r0)
            r0 = r0 | r1
            java.lang.Object r1 = r9.rememberedValue()
            if (r0 != 0) goto L_0x02cf
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x02d9
        L_0x02cf:
            java.lang.Object r0 = r15.invoke(r11)
            r1 = r0
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            r9.updateRememberedValue(r1)
        L_0x02d9:
            r9.endReplaceableGroup()
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            r0 = 72
            androidx.compose.ui.Modifier r0 = r11.createSizeAnimationModifier$animation_release(r1, r9, r0)
            androidx.compose.ui.Modifier r0 = r14.then(r0)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            java.lang.Object r1 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r1 != r3) goto L_0x0307
            androidx.compose.animation.AnimatedContentMeasurePolicy r1 = new androidx.compose.animation.AnimatedContentMeasurePolicy
            r1.<init>(r11)
            r9.updateRememberedValue(r1)
        L_0x0307:
            r9.endReplaceableGroup()
            androidx.compose.animation.AnimatedContentMeasurePolicy r1 = (androidx.compose.animation.AnimatedContentMeasurePolicy) r1
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r3)
            r3 = 0
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r3)
            androidx.compose.runtime.CompositionLocalMap r5 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r7 = r9.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0335
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0335:
            r9.startReusableNode()
            boolean r7 = r9.getInserting()
            if (r7 == 0) goto L_0x0342
            r9.createNode(r6)
            goto L_0x0345
        L_0x0342:
            r9.useNode()
        L_0x0345:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3282constructorimpl(r9)
            androidx.compose.ui.layout.MeasurePolicy r1 = (androidx.compose.ui.layout.MeasurePolicy) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x0377
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x0385
        L_0x0377:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6.updateRememberedValue(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.apply(r4, r1)
        L_0x0385:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r0.invoke(r1, r9, r4)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r0)
            r0 = -740835328(0xffffffffd3d7c000, float:-1.85327839E12)
            java.lang.String r1 = "C:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r1)
            r0 = -441506448(0xffffffffe5af2570, float:-1.0338809E23)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r5 = r20
            java.util.List r5 = (java.util.List) r5
            int r0 = r5.size()
            r6 = r3
        L_0x03b6:
            if (r6 >= r0) goto L_0x03e1
            java.lang.Object r1 = r5.get(r6)
            r4 = -1739558576(0xffffffff98507150, float:-2.6940578E-24)
            java.lang.Object r7 = r12.invoke(r1)
            r9.startMovableGroup(r4, r7)
            java.lang.String r4 = "767@39187L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            java.lang.Object r1 = r2.get(r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            if (r1 != 0) goto L_0x03d4
            goto L_0x03db
        L_0x03d4:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r1.invoke(r9, r4)
        L_0x03db:
            r9.endMovableGroup()
            int r6 = r6 + 1
            goto L_0x03b6
        L_0x03e1:
            r9.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03f9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03f9:
            r4 = r10
            r5 = r12
            r2 = r14
            r3 = r15
        L_0x03fd:
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.endRestartGroup()
            if (r9 == 0) goto L_0x0416
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$9 r10 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$9
            r0 = r10
            r1 = r21
            r6 = r26
            r7 = r28
            r8 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0416:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
