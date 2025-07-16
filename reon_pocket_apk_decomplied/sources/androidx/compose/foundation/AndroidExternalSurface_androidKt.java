package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a]\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"AndroidEmbeddedExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "transform", "Landroidx/compose/ui/graphics/Matrix;", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AndroidExternalSurface", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
public final class AndroidExternalSurface_androidKt {
    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer composer, int i) {
        composer.startReplaceableGroup(-873615933);
        ComposerKt.sourceInformation(composer, "C(rememberAndroidExternalSurfaceState)190@7150L24,191@7186L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, i, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:189)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new AndroidExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidExternalSurfaceState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0120  */
    /* renamed from: AndroidExternalSurface-58FFMhA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m210AndroidExternalSurface58FFMhA(androidx.compose.ui.Modifier r17, boolean r18, long r19, int r21, boolean r22, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.AndroidExternalSurfaceScope, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r7 = r23
            r8 = r25
            r0 = 640888974(0x2633308e, float:6.2168904E-16)
            r1 = r24
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(AndroidExternalSurface)P(2!1,4:c#ui.unit.IntSize,5:c#foundation.AndroidExternalSurfaceZOrder)288@12167L37,290@12210L1032:AndroidExternalSurface.android.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r8 | 6
            r4 = r3
            r3 = r17
            goto L_0x0030
        L_0x001c:
            r3 = r8 & 14
            if (r3 != 0) goto L_0x002d
            r3 = r17
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r8
            goto L_0x0030
        L_0x002d:
            r3 = r17
            r4 = r8
        L_0x0030:
            r5 = r26 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            goto L_0x004a
        L_0x0037:
            r6 = r8 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004a
            r6 = r18
            boolean r9 = r1.changed((boolean) r6)
            if (r9 == 0) goto L_0x0046
            r9 = 32
            goto L_0x0048
        L_0x0046:
            r9 = 16
        L_0x0048:
            r4 = r4 | r9
            goto L_0x004c
        L_0x004a:
            r6 = r18
        L_0x004c:
            r9 = r8 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0065
            r9 = r26 & 4
            if (r9 != 0) goto L_0x005f
            r9 = r19
            boolean r11 = r1.changed((long) r9)
            if (r11 == 0) goto L_0x0061
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x005f:
            r9 = r19
        L_0x0061:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r11
            goto L_0x0067
        L_0x0065:
            r9 = r19
        L_0x0067:
            r11 = r26 & 8
            if (r11 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r12 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0081
            r12 = r21
            boolean r13 = r1.changed((int) r12)
            if (r13 == 0) goto L_0x007d
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r13
            goto L_0x0083
        L_0x0081:
            r12 = r21
        L_0x0083:
            r13 = r26 & 16
            if (r13 == 0) goto L_0x008a
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008a:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r8
            if (r14 != 0) goto L_0x009f
            r14 = r22
            boolean r15 = r1.changed((boolean) r14)
            if (r15 == 0) goto L_0x009b
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r4 = r4 | r15
            goto L_0x00a1
        L_0x009f:
            r14 = r22
        L_0x00a1:
            r15 = r26 & 32
            if (r15 == 0) goto L_0x00a9
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00a7:
            r4 = r4 | r15
            goto L_0x00ba
        L_0x00a9:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00ba
            boolean r15 = r1.changedInstance(r7)
            if (r15 == 0) goto L_0x00b7
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a7
        L_0x00b7:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a7
        L_0x00ba:
            r15 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r15 & r4
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r0) goto L_0x00d2
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00ca
            goto L_0x00d2
        L_0x00ca:
            r1.skipToGroupEnd()
            r2 = r6
            r5 = r12
            r6 = r14
            goto L_0x0197
        L_0x00d2:
            r1.startDefaults()
            r0 = r8 & 1
            r15 = 0
            if (r0 == 0) goto L_0x00f0
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00e1
            goto L_0x00f0
        L_0x00e1:
            r1.skipToGroupEnd()
            r0 = r26 & 4
            if (r0 == 0) goto L_0x00ea
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ea:
            r0 = r3
            r2 = r9
        L_0x00ec:
            r5 = r14
        L_0x00ed:
            r9 = r4
            r4 = r12
            goto L_0x0117
        L_0x00f0:
            if (r2 == 0) goto L_0x00f7
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x00f8
        L_0x00f7:
            r0 = r3
        L_0x00f8:
            if (r5 == 0) goto L_0x00fc
            r2 = 1
            r6 = r2
        L_0x00fc:
            r2 = r26 & 4
            if (r2 == 0) goto L_0x0109
            androidx.compose.ui.unit.IntSize$Companion r2 = androidx.compose.ui.unit.IntSize.Companion
            long r2 = r2.m6795getZeroYbymL2g()
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r9 = r2
        L_0x0109:
            if (r11 == 0) goto L_0x0112
            androidx.compose.foundation.AndroidExternalSurfaceZOrder$Companion r2 = androidx.compose.foundation.AndroidExternalSurfaceZOrder.Companion
            int r2 = r2.m206getBehindB_4ceCc()
            r12 = r2
        L_0x0112:
            r2 = r9
            if (r13 == 0) goto L_0x00ec
            r5 = r15
            goto L_0x00ed
        L_0x0117:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0129
            r10 = -1
            java.lang.String r11 = "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:287)"
            r12 = 640888974(0x2633308e, float:6.2168904E-16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r9, r10, r11)
        L_0x0129:
            androidx.compose.foundation.AndroidExternalSurfaceState r10 = rememberAndroidExternalSurfaceState(r1, r15)
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1 r11 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1
            r11.<init>(r7, r10)
            r10 = r11
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2 r11 = androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r12 = -1909066533(0xffffffff8e35f4db, float:-2.2427866E-30)
            r1.startReplaceableGroup(r12)
            boolean r12 = r1.changed((long) r2)
            boolean r13 = r1.changed((boolean) r6)
            r12 = r12 | r13
            boolean r13 = r1.changed((int) r4)
            r12 = r12 | r13
            boolean r13 = r1.changed((boolean) r5)
            r12 = r12 | r13
            java.lang.Object r13 = r1.rememberedValue()
            if (r12 != 0) goto L_0x0160
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x0175
        L_0x0160:
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1 r12 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
            r17 = r12
            r18 = r2
            r20 = r6
            r21 = r4
            r22 = r5
            r17.<init>(r18, r20, r21, r22)
            r13 = r12
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r1.updateRememberedValue(r13)
        L_0x0175:
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r1.endReplaceableGroup()
            int r9 = r9 << 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            r15 = r9 | 384(0x180, float:5.38E-43)
            r16 = 8
            r12 = 0
            r9 = r10
            r10 = r0
            r14 = r1
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0192
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0192:
            r9 = r2
            r2 = r6
            r3 = r0
            r6 = r5
            r5 = r4
        L_0x0197:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x01b0
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$4 r12 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$4
            r0 = r12
            r1 = r3
            r3 = r9
            r7 = r23
            r8 = r25
            r9 = r26
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x01b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidExternalSurface_androidKt.m210AndroidExternalSurface58FFMhA(androidx.compose.ui.Modifier, boolean, long, int, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer composer, int i) {
        composer.startReplaceableGroup(-1057437053);
        ComposerKt.sourceInformation(composer, "C(rememberAndroidEmbeddedExternalSurfaceState)384@15036L24,385@15072L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, i, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:383)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new AndroidEmbeddedExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidEmbeddedExternalSurfaceState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* renamed from: AndroidEmbeddedExternalSurface-sv6N_fY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m209AndroidEmbeddedExternalSurfacesv6N_fY(androidx.compose.ui.Modifier r18, boolean r19, long r20, float[] r22, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.AndroidExternalSurfaceScope, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r6 = r23
            r7 = r25
            r0 = 217541314(0xcf76ac2, float:3.8120628E-31)
            r1 = r24
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(AndroidEmbeddedExternalSurface)P(1!1,3:c#ui.unit.IntSize,4:c#ui.graphics.Matrix)455@18917L45,457@18968L796:AndroidExternalSurface.android.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r7 | 6
            r4 = r3
            r3 = r18
            goto L_0x0030
        L_0x001c:
            r3 = r7 & 14
            if (r3 != 0) goto L_0x002d
            r3 = r18
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r7
            goto L_0x0030
        L_0x002d:
            r3 = r18
            r4 = r7
        L_0x0030:
            r5 = r26 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            goto L_0x004a
        L_0x0037:
            r8 = r7 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004a
            r8 = r19
            boolean r9 = r1.changed((boolean) r8)
            if (r9 == 0) goto L_0x0046
            r9 = 32
            goto L_0x0048
        L_0x0046:
            r9 = 16
        L_0x0048:
            r4 = r4 | r9
            goto L_0x004c
        L_0x004a:
            r8 = r19
        L_0x004c:
            r9 = r7 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0065
            r9 = r26 & 4
            if (r9 != 0) goto L_0x005f
            r9 = r20
            boolean r11 = r1.changed((long) r9)
            if (r11 == 0) goto L_0x0061
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x005f:
            r9 = r20
        L_0x0061:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r11
            goto L_0x0067
        L_0x0065:
            r9 = r20
        L_0x0067:
            r11 = r26 & 8
            if (r11 == 0) goto L_0x006d
            r4 = r4 | 1024(0x400, float:1.435E-42)
        L_0x006d:
            r12 = r26 & 16
            if (r12 == 0) goto L_0x0074
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0086
        L_0x0074:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r7
            if (r12 != 0) goto L_0x0086
            boolean r12 = r1.changedInstance(r6)
            if (r12 == 0) goto L_0x0083
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0085
        L_0x0083:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0085:
            r4 = r4 | r12
        L_0x0086:
            r12 = 8
            if (r11 != r12) goto L_0x00a2
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r4
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x00a2
            boolean r12 = r1.getSkipping()
            if (r12 != 0) goto L_0x0099
            goto L_0x00a2
        L_0x0099:
            r1.skipToGroupEnd()
            r5 = r22
            r2 = r3
            r3 = r9
            goto L_0x012f
        L_0x00a2:
            r1.startDefaults()
            r12 = r7 & 1
            if (r12 == 0) goto L_0x00c0
            boolean r12 = r1.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00b0
            goto L_0x00c0
        L_0x00b0:
            r1.skipToGroupEnd()
            r2 = r26 & 4
            if (r2 == 0) goto L_0x00b9
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00b9:
            r16 = r22
            r2 = r3
        L_0x00bc:
            r14 = r4
            r3 = r8
            r4 = r9
            goto L_0x00e1
        L_0x00c0:
            if (r2 == 0) goto L_0x00c7
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00c8
        L_0x00c7:
            r2 = r3
        L_0x00c8:
            if (r5 == 0) goto L_0x00cc
            r3 = 1
            r8 = r3
        L_0x00cc:
            r3 = r26 & 4
            if (r3 == 0) goto L_0x00d8
            androidx.compose.ui.unit.IntSize$Companion r3 = androidx.compose.ui.unit.IntSize.Companion
            long r9 = r3.m6795getZeroYbymL2g()
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00d8:
            if (r11 == 0) goto L_0x00de
            r3 = 0
            r16 = r3
            goto L_0x00bc
        L_0x00de:
            r16 = r22
            goto L_0x00bc
        L_0x00e1:
            r1.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00f0
            r8 = -1
            java.lang.String r9 = "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:454)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r8, r9)
        L_0x00f0:
            r0 = 0
            androidx.compose.foundation.AndroidEmbeddedExternalSurfaceState r11 = rememberAndroidEmbeddedExternalSurfaceState(r1, r0)
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1 r0 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1
            r0.<init>(r11, r4, r6)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2 r8 = androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2.INSTANCE
            r15 = r8
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3 r17 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3
            r8 = r17
            r9 = r4
            r12 = r3
            r13 = r16
            r8.<init>(r9, r11, r12, r13)
            r12 = r17
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            int r8 = r14 << 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r14 = r8 | 384(0x180, float:5.38E-43)
            r17 = 8
            r11 = 0
            r8 = r0
            r9 = r2
            r10 = r15
            r13 = r1
            r15 = r17
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x012b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x012b:
            r8 = r3
            r3 = r4
            r5 = r16
        L_0x012f:
            androidx.compose.runtime.ScopeUpdateScope r9 = r1.endRestartGroup()
            if (r9 == 0) goto L_0x0148
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$4 r10 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$4
            r0 = r10
            r1 = r2
            r2 = r8
            r6 = r23
            r7 = r25
            r8 = r26
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidExternalSurface_androidKt.m209AndroidEmbeddedExternalSurfacesv6N_fY(androidx.compose.ui.Modifier, boolean, long, float[], kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
