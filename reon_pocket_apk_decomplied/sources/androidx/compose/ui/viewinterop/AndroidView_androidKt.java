package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u0017\"\b\b\u0000\u0010\b*\u00020\u0002*\u00020\u0014H\u0002\u001a^\u0010\u0018\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "onReset", "onRelease", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "compositeKeyHash", "", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r9, androidx.compose.ui.Modifier r10, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = -1783766393(0xffffffff95ade287, float:-7.023154E-26)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(AndroidView)107@5478L130:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0022
            boolean r1 = r12.changedInstance(r9)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r13
            goto L_0x0023
        L_0x0022:
            r1 = r13
        L_0x0023:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 48
            goto L_0x003a
        L_0x002a:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x003a
            boolean r3 = r12.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r1 = r1 | r3
        L_0x003a:
            r3 = r14 & 4
            if (r3 == 0) goto L_0x0041
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0051
        L_0x0041:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0051
            boolean r4 = r12.changedInstance(r11)
            if (r4 == 0) goto L_0x004e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0050
        L_0x004e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0050:
            r1 = r1 | r4
        L_0x0051:
            r4 = r1 & 731(0x2db, float:1.024E-42)
            r5 = 146(0x92, float:2.05E-43)
            if (r4 != r5) goto L_0x0064
            boolean r4 = r12.getSkipping()
            if (r4 != 0) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            r12.skipToGroupEnd()
        L_0x0061:
            r3 = r10
            r4 = r11
            goto L_0x009e
        L_0x0064:
            if (r2 == 0) goto L_0x006a
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
        L_0x006a:
            if (r3 == 0) goto L_0x006e
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r11 = NoOpUpdate
        L_0x006e:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x007a
            r2 = -1
            java.lang.String r3 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:106)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x007a:
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r4 = NoOpUpdate
            r0 = r1 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            int r1 = r1 << 6
            r1 = r1 & r2
            r7 = r0 | r1
            r8 = 4
            r3 = 0
            r1 = r9
            r2 = r10
            r5 = r11
            r6 = r12
            AndroidView(r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0061
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0061
        L_0x009e:
            androidx.compose.runtime.ScopeUpdateScope r10 = r12.endRestartGroup()
            if (r10 == 0) goto L_0x00b2
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1 r11 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
            r1 = r11
            r2 = r9
            r5 = r13
            r6 = r14
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r24, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r1 = r21
            r6 = r27
            r0 = -180024211(0xfffffffff5450c6d, float:-2.497887E32)
            r2 = r26
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(AndroidView)P(!2,3)211@11894L23,213@12018L7,214@12073L7,221@12529L7,222@12600L7:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r28 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r6 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r6 & 14
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r6
            goto L_0x0029
        L_0x0028:
            r3 = r6
        L_0x0029:
            r4 = r28 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r6 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0043
            r5 = r22
            boolean r7 = r2.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r5 = r22
        L_0x0045:
            r7 = r28 & 4
            if (r7 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r8 = r6 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x005f
            r8 = r23
            boolean r9 = r2.changedInstance(r8)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r9
            goto L_0x0061
        L_0x005f:
            r8 = r23
        L_0x0061:
            r9 = r28 & 8
            if (r9 == 0) goto L_0x0068
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r10 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007b
            r10 = r24
            boolean r11 = r2.changedInstance(r10)
            if (r11 == 0) goto L_0x0077
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r3 = r3 | r11
            goto L_0x007d
        L_0x007b:
            r10 = r24
        L_0x007d:
            r11 = r28 & 16
            if (r11 == 0) goto L_0x0084
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0084:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r6
            if (r12 != 0) goto L_0x0099
            r12 = r25
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r3 = r3 | r13
            goto L_0x009b
        L_0x0099:
            r12 = r25
        L_0x009b:
            r13 = 46811(0xb6db, float:6.5596E-41)
            r13 = r13 & r3
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00b2
            boolean r13 = r2.getSkipping()
            if (r13 != 0) goto L_0x00aa
            goto L_0x00b2
        L_0x00aa:
            r2.skipToGroupEnd()
            r4 = r5
        L_0x00ae:
            r3 = r8
            r5 = r12
            goto L_0x0205
        L_0x00b2:
            if (r4 == 0) goto L_0x00b9
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00ba
        L_0x00b9:
            r4 = r5
        L_0x00ba:
            if (r7 == 0) goto L_0x00be
            r5 = 0
            r8 = r5
        L_0x00be:
            if (r9 == 0) goto L_0x00c3
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r5 = NoOpUpdate
            r10 = r5
        L_0x00c3:
            if (r11 == 0) goto L_0x00c8
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r5 = NoOpUpdate
            r12 = r5
        L_0x00c8:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00d4
            r5 = -1
            java.lang.String r7 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r5, r7)
        L_0x00d4:
            r0 = 0
            int r15 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r0)
            androidx.compose.ui.Modifier r14 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r16 = r0
            androidx.compose.ui.unit.Density r16 = (androidx.compose.ui.unit.Density) r16
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r19 = r0
            androidx.compose.ui.unit.LayoutDirection r19 = (androidx.compose.ui.unit.LayoutDirection) r19
            androidx.compose.runtime.CompositionLocalMap r20 = r2.getCurrentCompositionLocalMap()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r17 = r0
            androidx.lifecycle.LifecycleOwner r17 = (androidx.lifecycle.LifecycleOwner) r17
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r18 = r0
            androidx.savedstate.SavedStateRegistryOwner r18 = (androidx.savedstate.SavedStateRegistryOwner) r18
            if (r8 == 0) goto L_0x019d
            r0 = -88753355(0xfffffffffab5bb35, float:-4.7180137E35)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "226@12710L37,225@12644L843"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r3 & 14
            kotlin.jvm.functions.Function0 r0 = createAndroidViewNodeFactory(r1, r2, r0)
            r3 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            androidx.compose.runtime.Applier r3 = r2.getApplier()
            boolean r3 = r3 instanceof androidx.compose.ui.node.UiApplier
            if (r3 != 0) goto L_0x015f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x015f:
            r2.startReusableNode()
            boolean r3 = r2.getInserting()
            if (r3 == 0) goto L_0x0173
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1 r3 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1
            r3.<init>(r0)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r2.createNode(r3)
            goto L_0x0176
        L_0x0173:
            r2.useNode()
        L_0x0176:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            r13 = r0
            m6872updateViewHolderParams6NefGtU(r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1 r3 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1.INSTANCE
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r0, r8, r3)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2 r3 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2.INSTANCE
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r0, r12, r3)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3 r3 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3.INSTANCE
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r0, r10, r3)
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            goto L_0x01fa
        L_0x019d:
            r0 = -88752490(0xfffffffffab5be96, float:-4.7183564E35)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "244@13567L37,243@13509L756"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r3 & 14
            kotlin.jvm.functions.Function0 r0 = createAndroidViewNodeFactory(r1, r2, r0)
            r3 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            androidx.compose.runtime.Applier r3 = r2.getApplier()
            boolean r3 = r3 instanceof androidx.compose.ui.node.UiApplier
            if (r3 != 0) goto L_0x01c4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01c4:
            r2.startNode()
            boolean r3 = r2.getInserting()
            if (r3 == 0) goto L_0x01d8
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1 r3 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
            r3.<init>(r0)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r2.createNode(r3)
            goto L_0x01db
        L_0x01d8:
            r2.useNode()
        L_0x01db:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            r13 = r0
            m6872updateViewHolderParams6NefGtU(r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1 r3 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1.INSTANCE
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r0, r12, r3)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2 r3 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2.INSTANCE
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r0, r10, r3)
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
        L_0x01fa:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00ae
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x00ae
        L_0x0205:
            androidx.compose.runtime.ScopeUpdateScope r8 = r2.endRestartGroup()
            if (r8 == 0) goto L_0x021e
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4 r9 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
            r0 = r9
            r1 = r21
            r2 = r4
            r4 = r10
            r6 = r27
            r7 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x021e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(Function1<? super Context, ? extends T> function1, Composer composer, int i) {
        composer.startReplaceableGroup(2030558801);
        ComposerKt.sourceInformation(composer, "C(createAndroidViewNodeFactory)266@14417L23,267@14472L7,268@14506L28,269@14586L7,270@14624L7:AndroidView.android.kt#z33iqn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030558801, i, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:265)");
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Function0<LayoutNode> androidView_androidKt$createAndroidViewNodeFactory$1 = new AndroidView_androidKt$createAndroidViewNodeFactory$1((Context) consume, function1, rememberCompositionContext, (SaveableStateRegistry) consume2, currentCompositeKeyHash, (View) consume3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidView_androidKt$createAndroidViewNodeFactory$1;
    }

    /* renamed from: updateViewHolderParams-6NefGtU  reason: not valid java name */
    private static final <T extends View> void m6872updateViewHolderParams6NefGtU(Composer composer, Modifier modifier, int i, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        Updater.m3289setimpl(composer, compositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.m3289setimpl(composer, modifier, AndroidView_androidKt$updateViewHolderParams$1.INSTANCE);
        Updater.m3289setimpl(composer, density, AndroidView_androidKt$updateViewHolderParams$2.INSTANCE);
        Updater.m3289setimpl(composer, lifecycleOwner, AndroidView_androidKt$updateViewHolderParams$3.INSTANCE);
        Updater.m3289setimpl(composer, savedStateRegistryOwner, AndroidView_androidKt$updateViewHolderParams$4.INSTANCE);
        Updater.m3289setimpl(composer, layoutDirection, AndroidView_androidKt$updateViewHolderParams$5.INSTANCE);
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), (Object) Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            composer.apply(Integer.valueOf(i), setCompositeKeyHash);
        }
    }

    /* access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode layoutNode) {
        AndroidViewHolder interopViewFactoryHolder$ui_release = layoutNode.getInteropViewFactoryHolder$ui_release();
        if (interopViewFactoryHolder$ui_release != null) {
            Intrinsics.checkNotNull(interopViewFactoryHolder$ui_release, "null cannot be cast to non-null type androidx.compose.ui.viewinterop.ViewFactoryHolder<T of androidx.compose.ui.viewinterop.AndroidView_androidKt.requireViewFactoryHolder>");
            return (ViewFactoryHolder) interopViewFactoryHolder$ui_release;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
