package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0003\u001a7\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"touchExplorationState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "ObserveState", "", "Landroidx/lifecycle/Lifecycle;", "handleEvent", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "onDispose", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
public final class TouchExplorationStateProvider_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<java.lang.Boolean> touchExplorationState(androidx.compose.runtime.Composer r10, int r11) {
        /*
            r0 = -906157724(0xffffffffc9fd2164, float:-2073644.5)
            r10.startReplaceableGroup(r0)
            java.lang.String r1 = "C(touchExplorationState)40@1640L7,41@1679L104,45@1804L23,47@1853L7,48@1907L144,53@2073L65,47@1871L273:TouchExplorationStateProvider.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.touchExplorationState (TouchExplorationStateProvider.android.kt:39)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r1, r2)
        L_0x0017:
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r1)
            java.lang.Object r11 = r10.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            android.content.Context r11 = (android.content.Context) r11
            r2 = -1014858715(0xffffffffc3827c25, float:-260.96988)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):TouchExplorationStateProvider.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r3 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0056
            java.lang.String r3 = "accessibility"
            java.lang.Object r11 = r11.getSystemService(r3)
            java.lang.String r3 = "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r3)
            r3 = r11
            android.view.accessibility.AccessibilityManager r3 = (android.view.accessibility.AccessibilityManager) r3
            r10.updateRememberedValue(r3)
        L_0x0056:
            android.view.accessibility.AccessibilityManager r3 = (android.view.accessibility.AccessibilityManager) r3
            r10.endReplaceableGroup()
            r11 = -1014858590(0xffffffffc3827ca2, float:-260.9737)
            r10.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r11 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r11 != r4) goto L_0x0078
            androidx.compose.material3.Listener r11 = new androidx.compose.material3.Listener
            r11.<init>()
            r10.updateRememberedValue(r11)
        L_0x0078:
            androidx.compose.material3.Listener r11 = (androidx.compose.material3.Listener) r11
            r10.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r1)
            java.lang.Object r0 = r10.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.lifecycle.Lifecycle r4 = r0.getLifecycle()
            r0 = -1014858487(0xffffffffc3827d09, float:-260.97684)
            r10.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r0 = r10.changedInstance(r3)
            java.lang.Object r1 = r10.rememberedValue()
            if (r0 != 0) goto L_0x00ae
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00b9
        L_0x00ae:
            androidx.compose.material3.TouchExplorationStateProvider_androidKt$touchExplorationState$1$1 r0 = new androidx.compose.material3.TouchExplorationStateProvider_androidKt$touchExplorationState$1$1
            r0.<init>(r11, r3)
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r10.updateRememberedValue(r1)
        L_0x00b9:
            r5 = r1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r10.endReplaceableGroup()
            r0 = -1014858321(0xffffffffc3827daf, float:-260.9819)
            r10.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r0 = r10.changedInstance(r3)
            java.lang.Object r1 = r10.rememberedValue()
            if (r0 != 0) goto L_0x00da
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00e5
        L_0x00da:
            androidx.compose.material3.TouchExplorationStateProvider_androidKt$touchExplorationState$2$1 r0 = new androidx.compose.material3.TouchExplorationStateProvider_androidKt$touchExplorationState$2$1
            r0.<init>(r11, r3)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r10.updateRememberedValue(r1)
        L_0x00e5:
            r6 = r1
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r10.endReplaceableGroup()
            r8 = 0
            r9 = 0
            r7 = r10
            ObserveState(r4, r5, r6, r7, r8, r9)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00fa
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00fa:
            r10.endReplaceableGroup()
            androidx.compose.runtime.State r11 = (androidx.compose.runtime.State) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TouchExplorationStateProvider_androidKt.touchExplorationState(androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    /* access modifiers changed from: private */
    public static final void ObserveState(Lifecycle lifecycle, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1703772404);
        ComposerKt.sourceInformation(startRestartGroup, "C(ObserveState)66@2328L265,66@2305L288:TouchExplorationStateProvider.android.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(lifecycle) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                function1 = TouchExplorationStateProvider_androidKt$ObserveState$1.INSTANCE;
            }
            if (i5 != 0) {
                function0 = TouchExplorationStateProvider_androidKt$ObserveState$2.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1703772404, i3, -1, "androidx.compose.material3.ObserveState (TouchExplorationStateProvider.android.kt:65)");
            }
            startRestartGroup.startReplaceableGroup(-1018043936);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TouchExplorationStateProvider.android.kt#9igjgp");
            boolean z = false;
            boolean changedInstance = ((i3 & 112) == 32) | startRestartGroup.changedInstance(lifecycle);
            if ((i3 & 896) == 256) {
                z = true;
            }
            boolean z2 = changedInstance | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TouchExplorationStateProvider_androidKt$ObserveState$3$1(lifecycle, function1, function0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect((Object) lifecycle, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, startRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Function1<? super Lifecycle.Event, Unit> function12 = function1;
        Function0<Unit> function02 = function0;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TouchExplorationStateProvider_androidKt$ObserveState$4(lifecycle, function12, function02, i, i2));
        }
    }
}
