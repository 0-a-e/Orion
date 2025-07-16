package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\u0010\u0010\u0017\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002X\u0002"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Crossfade.kt */
public final class CrossfadeKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void Crossfade(T r17, androidx.compose.ui.Modifier r18, androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r19, java.lang.String r20, kotlin.jvm.functions.Function3<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r1 = r17
            r6 = r23
            r0 = -310686752(0xffffffffed7b4be0, float:-4.860779E27)
            r2 = r22
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(Crossfade)P(4,3!1,2)55@2280L36,56@2332L53:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r24 & 1
            r4 = 4
            if (r3 == 0) goto L_0x001a
            r3 = r6 | 6
            goto L_0x002a
        L_0x001a:
            r3 = r6 & 14
            if (r3 != 0) goto L_0x0029
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0026
            r3 = r4
            goto L_0x0027
        L_0x0026:
            r3 = 2
        L_0x0027:
            r3 = r3 | r6
            goto L_0x002a
        L_0x0029:
            r3 = r6
        L_0x002a:
            r5 = r24 & 2
            if (r5 == 0) goto L_0x0031
            r3 = r3 | 48
            goto L_0x0044
        L_0x0031:
            r7 = r6 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0044
            r7 = r18
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0040
            r8 = 32
            goto L_0x0042
        L_0x0040:
            r8 = 16
        L_0x0042:
            r3 = r3 | r8
            goto L_0x0046
        L_0x0044:
            r7 = r18
        L_0x0046:
            r8 = r24 & 4
            if (r8 == 0) goto L_0x004c
            r3 = r3 | 128(0x80, float:1.794E-43)
        L_0x004c:
            r9 = r24 & 8
            if (r9 == 0) goto L_0x0053
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0066
        L_0x0053:
            r10 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0066
            r10 = r20
            boolean r11 = r2.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0062
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r3 = r3 | r11
            goto L_0x0068
        L_0x0066:
            r10 = r20
        L_0x0068:
            r11 = r24 & 16
            r12 = 57344(0xe000, float:8.0356E-41)
            if (r11 == 0) goto L_0x0074
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r15 = r21
            goto L_0x0086
        L_0x0074:
            r11 = r6 & r12
            r15 = r21
            if (r11 != 0) goto L_0x0086
            boolean r11 = r2.changedInstance(r15)
            if (r11 == 0) goto L_0x0083
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0085
        L_0x0083:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0085:
            r3 = r3 | r11
        L_0x0086:
            if (r8 != r4) goto L_0x009e
            r4 = 46811(0xb6db, float:6.5596E-41)
            r4 = r4 & r3
            r11 = 9362(0x2492, float:1.3119E-41)
            if (r4 != r11) goto L_0x009e
            boolean r4 = r2.getSkipping()
            if (r4 != 0) goto L_0x0097
            goto L_0x009e
        L_0x0097:
            r2.skipToGroupEnd()
            r3 = r19
            r4 = r7
            goto L_0x00f4
        L_0x009e:
            if (r5 == 0) goto L_0x00a5
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00a6
        L_0x00a5:
            r4 = r7
        L_0x00a6:
            r5 = 0
            if (r8 == 0) goto L_0x00b4
            r7 = 7
            r8 = 0
            androidx.compose.animation.core.TweenSpec r7 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r5, r8, r7, r8)
            androidx.compose.animation.core.FiniteAnimationSpec r7 = (androidx.compose.animation.core.FiniteAnimationSpec) r7
            r16 = r7
            goto L_0x00b6
        L_0x00b4:
            r16 = r19
        L_0x00b6:
            if (r9 == 0) goto L_0x00bc
            java.lang.String r7 = "Crossfade"
            r14 = r7
            goto L_0x00bd
        L_0x00bc:
            r14 = r10
        L_0x00bd:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00c9
            r7 = -1
            java.lang.String r8 = "androidx.compose.animation.Crossfade (Crossfade.kt:54)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r7, r8)
        L_0x00c9:
            r0 = r3 & 14
            int r7 = r3 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r0 = r0 | r7
            androidx.compose.animation.core.Transition r7 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r14, (androidx.compose.runtime.Composer) r2, (int) r0, (int) r5)
            r0 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | 512(0x200, float:7.175E-43)
            r3 = r3 & r12
            r13 = r0 | r3
            r0 = 4
            r10 = 0
            r8 = r4
            r9 = r16
            r11 = r21
            r12 = r2
            r3 = r14
            r14 = r0
            Crossfade(r7, (androidx.compose.ui.Modifier) r8, (androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float>) r9, r10, r11, (androidx.compose.runtime.Composer) r12, (int) r13, (int) r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00f1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f1:
            r10 = r3
            r3 = r16
        L_0x00f4:
            androidx.compose.runtime.ScopeUpdateScope r8 = r2.endRestartGroup()
            if (r8 == 0) goto L_0x010f
            androidx.compose.animation.CrossfadeKt$Crossfade$1 r9 = new androidx.compose.animation.CrossfadeKt$Crossfade$1
            r0 = r9
            r1 = r17
            r2 = r4
            r4 = r10
            r5 = r21
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x010f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(java.lang.Object, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(Object obj, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function3 function3, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(523603005);
        ComposerKt.sourceInformation(startRestartGroup, "C(Crossfade)P(3,2)71@2743L29,72@2788L53:Crossfade.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if (i5 == 4 && (i3 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                finiteAnimationSpec = AnimationSpecKt.tween$default(0, 0, (Easing) null, 7, (Object) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(523603005, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:70)");
            }
            Crossfade(TransitionKt.updateTransition(obj, (String) null, startRestartGroup, i3 & 14, 2), modifier, (FiniteAnimationSpec<Float>) finiteAnimationSpec, (Function1) null, function3, startRestartGroup, (i3 & 112) | 512 | ((i3 << 3) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpec;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CrossfadeKt$Crossfade$2(obj, modifier2, finiteAnimationSpec2, function3, i, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void Crossfade(androidx.compose.animation.core.Transition<T> r16, androidx.compose.ui.Modifier r17, androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r18, kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> r19, kotlin.jvm.functions.Function3<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r1 = r16
            r5 = r20
            r6 = r22
            r0 = 679005231(0x2878cc2f, float:1.3811041E-14)
            r2 = r21
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(Crossfade)P(3!1,2)103@4375L64,104@4461L66,138@5750L159:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r23 & r3
            r4 = 2
            if (r3 == 0) goto L_0x001e
            r3 = r6 | 6
            goto L_0x002e
        L_0x001e:
            r3 = r6 & 14
            if (r3 != 0) goto L_0x002d
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = r4
        L_0x002b:
            r3 = r3 | r6
            goto L_0x002e
        L_0x002d:
            r3 = r6
        L_0x002e:
            r7 = r23 & 1
            if (r7 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r8 = r6 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0048
            r8 = r17
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0044
            r9 = 32
            goto L_0x0046
        L_0x0044:
            r9 = 16
        L_0x0046:
            r3 = r3 | r9
            goto L_0x004a
        L_0x0048:
            r8 = r17
        L_0x004a:
            r9 = r23 & 2
            if (r9 == 0) goto L_0x0050
            r3 = r3 | 128(0x80, float:1.794E-43)
        L_0x0050:
            r10 = r23 & 4
            if (r10 == 0) goto L_0x0057
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x006a
        L_0x0057:
            r11 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x006a
            r11 = r19
            boolean r12 = r2.changedInstance(r11)
            if (r12 == 0) goto L_0x0066
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0068
        L_0x0066:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0068:
            r3 = r3 | r12
            goto L_0x006c
        L_0x006a:
            r11 = r19
        L_0x006c:
            r12 = r23 & 8
            if (r12 == 0) goto L_0x0073
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0085
        L_0x0073:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r6
            if (r12 != 0) goto L_0x0085
            boolean r12 = r2.changedInstance(r5)
            if (r12 == 0) goto L_0x0082
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0082:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r3 = r3 | r12
        L_0x0085:
            if (r9 != r4) goto L_0x009e
            r4 = 46811(0xb6db, float:6.5596E-41)
            r4 = r4 & r3
            r12 = 9362(0x2492, float:1.3119E-41)
            if (r4 != r12) goto L_0x009e
            boolean r4 = r2.getSkipping()
            if (r4 != 0) goto L_0x0096
            goto L_0x009e
        L_0x0096:
            r2.skipToGroupEnd()
            r3 = r18
            r4 = r11
            goto L_0x02df
        L_0x009e:
            if (r7 == 0) goto L_0x00a5
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r8 = r4
        L_0x00a5:
            r4 = 0
            if (r9 == 0) goto L_0x00b1
            r7 = 7
            r9 = 0
            androidx.compose.animation.core.TweenSpec r7 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r4, r9, r7, r9)
            androidx.compose.animation.core.FiniteAnimationSpec r7 = (androidx.compose.animation.core.FiniteAnimationSpec) r7
            goto L_0x00b3
        L_0x00b1:
            r7 = r18
        L_0x00b3:
            if (r10 == 0) goto L_0x00ba
            androidx.compose.animation.CrossfadeKt$Crossfade$3 r9 = androidx.compose.animation.CrossfadeKt$Crossfade$3.INSTANCE
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            goto L_0x00bb
        L_0x00ba:
            r9 = r11
        L_0x00bb:
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r11 = -1
            if (r10 == 0) goto L_0x00c7
            java.lang.String r10 = "androidx.compose.animation.Crossfade (Crossfade.kt:102)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r11, r10)
        L_0x00c7:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r0)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            java.lang.Object r10 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x00ec
            androidx.compose.runtime.snapshots.SnapshotStateList r10 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            java.lang.Object r12 = r16.getCurrentState()
            r10.add(r12)
            r2.updateRememberedValue(r10)
        L_0x00ec:
            r2.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r10 = (androidx.compose.runtime.snapshots.SnapshotStateList) r10
            r2.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            java.lang.Object r0 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x010d
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r2.updateRememberedValue(r0)
        L_0x010d:
            r2.endReplaceableGroup()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r3 = r16.getCurrentState()
            java.lang.Object r12 = r16.getTargetState()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r12)
            r12 = 1
            if (r3 == 0) goto L_0x0166
            int r3 = r10.size()
            if (r3 != r12) goto L_0x0135
            java.lang.Object r3 = r10.get(r4)
            java.lang.Object r13 = r16.getTargetState()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r13)
            if (r3 != 0) goto L_0x0166
        L_0x0135:
            r3 = r10
            java.util.List r3 = (java.util.List) r3
            r13 = -928916520(0xffffffffc8a1dbd8, float:-331486.75)
            r2.startReplaceableGroup(r13)
            boolean r13 = r2.changed((java.lang.Object) r1)
            java.lang.Object r14 = r2.rememberedValue()
            if (r13 != 0) goto L_0x0150
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x015b
        L_0x0150:
            androidx.compose.animation.CrossfadeKt$Crossfade$4$1 r13 = new androidx.compose.animation.CrossfadeKt$Crossfade$4$1
            r13.<init>(r1)
            r14 = r13
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r2.updateRememberedValue(r14)
        L_0x015b:
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r2.endReplaceableGroup()
            kotlin.collections.CollectionsKt.removeAll(r3, r14)
            r0.clear()
        L_0x0166:
            java.lang.Object r3 = r16.getTargetState()
            boolean r3 = r0.containsKey(r3)
            if (r3 != 0) goto L_0x01cb
            r3 = r10
            java.util.List r3 = (java.util.List) r3
            java.util.Iterator r13 = r3.iterator()
            r14 = r4
        L_0x0178:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x0199
            java.lang.Object r15 = r13.next()
            java.lang.Object r15 = r9.invoke(r15)
            java.lang.Object r4 = r16.getTargetState()
            java.lang.Object r4 = r9.invoke(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0195
            goto L_0x019a
        L_0x0195:
            int r14 = r14 + 1
            r4 = 0
            goto L_0x0178
        L_0x0199:
            r14 = r11
        L_0x019a:
            if (r14 != r11) goto L_0x01a4
            java.lang.Object r4 = r16.getTargetState()
            r10.add(r4)
            goto L_0x01ab
        L_0x01a4:
            java.lang.Object r4 = r16.getTargetState()
            r10.set(r14, r4)
        L_0x01ab:
            r0.clear()
            int r4 = r3.size()
            r11 = 0
        L_0x01b3:
            if (r11 >= r4) goto L_0x01cb
            java.lang.Object r13 = r3.get(r11)
            androidx.compose.animation.CrossfadeKt$Crossfade$5$1 r14 = new androidx.compose.animation.CrossfadeKt$Crossfade$5$1
            r14.<init>(r1, r7, r13, r5)
            r15 = -1426421288(0xffffffffaafa89d8, float:-4.450457E-13)
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r15, r12, r14)
            r0.put(r13, r14)
            int r11 = r11 + 1
            goto L_0x01b3
        L_0x01cb:
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r4 = 0
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r4, r2, r4)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r4)
            androidx.compose.runtime.CompositionLocalMap r4 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r8)
            androidx.compose.runtime.Applier r14 = r2.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0209
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0209:
            r2.startReusableNode()
            boolean r14 = r2.getInserting()
            if (r14 == 0) goto L_0x0216
            r2.createNode(r12)
            goto L_0x0219
        L_0x0216:
            r2.useNode()
        L_0x0219:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r3, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r4, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r4 = r12.getInserting()
            if (r4 != 0) goto L_0x0249
            java.lang.Object r4 = r12.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r14)
            if (r4 != 0) goto L_0x0257
        L_0x0249:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r12.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r12.apply(r4, r3)
        L_0x0257:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r3)
            r4 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            r13.invoke(r3, r2, r11)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r3)
            r3 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r4 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r3 = 2072161918(0x7b82ae7e, float:1.3570754E36)
            java.lang.String r4 = "C:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r4)
            r3 = -1621447954(0xffffffff9f5aaaee, float:-4.6304685E-20)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            java.util.List r10 = (java.util.List) r10
            int r3 = r10.size()
            r4 = 0
        L_0x0293:
            if (r4 >= r3) goto L_0x02bf
            java.lang.Object r11 = r10.get(r4)
            r12 = -450541366(0xffffffffe52548ca, float:-4.8783324E22)
            java.lang.Object r13 = r9.invoke(r11)
            r2.startMovableGroup(r12, r13)
            java.lang.String r12 = "141@5871L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            java.lang.Object r11 = r0.get(r11)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 0
            if (r11 != 0) goto L_0x02b2
            goto L_0x02b9
        L_0x02b2:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)
            r11.invoke(r2, r13)
        L_0x02b9:
            r2.endMovableGroup()
            int r4 = r4 + 1
            goto L_0x0293
        L_0x02bf:
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02dd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02dd:
            r3 = r7
            r4 = r9
        L_0x02df:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x02f9
            androidx.compose.animation.CrossfadeKt$Crossfade$7 r10 = new androidx.compose.animation.CrossfadeKt$Crossfade$7
            r0 = r10
            r1 = r16
            r2 = r8
            r5 = r20
            r6 = r22
            r7 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x02f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
