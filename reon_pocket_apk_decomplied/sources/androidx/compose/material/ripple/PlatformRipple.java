package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\fJF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "findNearestViewGroup", "Landroid/view/ViewGroup;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/ViewGroup;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.android.kt */
public final class PlatformRipple extends Ripple {
    public static final int $stable = 0;

    public /* synthetic */ PlatformRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    private PlatformRipple(boolean z, float f, State<Color> state) {
        super(z, f, state, (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v22, resolved type: androidx.compose.material.ripple.AndroidRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: androidx.compose.material.ripple.AndroidRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v23, resolved type: androidx.compose.material.ripple.CommonRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.compose.material.ripple.CommonRippleIndicationInstance} */
    /* JADX WARNING: type inference failed for: r14v11 */
    /* JADX WARNING: type inference failed for: r14v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009f, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0050, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0052;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberUpdatedRippleInstance-942rkJo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.material.ripple.RippleIndicationInstance m1482rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource r8, boolean r9, float r10, androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> r11, androidx.compose.runtime.State<androidx.compose.material.ripple.RippleAlpha> r12, androidx.compose.runtime.Composer r13, int r14) {
        /*
            r7 = this;
            r0 = 331259447(0x13be9e37, float:4.8118755E-27)
            r13.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberUpdatedRippleInstance)P(2!1,3:c#ui.unit.Dp)64@2491L22,72@2825L138:Ripple.android.kt#vhb33q"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:63)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x0017:
            int r14 = r14 >> 15
            r14 = r14 & 14
            android.view.ViewGroup r5 = r7.findNearestViewGroup(r13, r14)
            r14 = 1643267293(0x61f244dd, float:5.5863427E20)
            r13.startReplaceableGroup(r14)
            java.lang.String r14 = "67@2665L133"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r14)
            boolean r14 = r5.isInEditMode()
            if (r14 == 0) goto L_0x0077
            r14 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r14)
            boolean r8 = r13.changed((java.lang.Object) r8)
            boolean r14 = r13.changed((java.lang.Object) r7)
            r8 = r8 | r14
            java.lang.Object r14 = r13.rememberedValue()
            if (r8 != 0) goto L_0x0052
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r14 != r8) goto L_0x0060
        L_0x0052:
            androidx.compose.material.ripple.CommonRippleIndicationInstance r14 = new androidx.compose.material.ripple.CommonRippleIndicationInstance
            r5 = 0
            r0 = r14
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r13.updateRememberedValue(r14)
        L_0x0060:
            r13.endReplaceableGroup()
            androidx.compose.material.ripple.CommonRippleIndicationInstance r14 = (androidx.compose.material.ripple.CommonRippleIndicationInstance) r14
            r13.endReplaceableGroup()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0071
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0071:
            r13.endReplaceableGroup()
            androidx.compose.material.ripple.RippleIndicationInstance r14 = (androidx.compose.material.ripple.RippleIndicationInstance) r14
            return r14
        L_0x0077:
            r13.endReplaceableGroup()
            r14 = 1618982084(0x607fb4c4, float:7.370227E19)
            r13.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r14)
            boolean r8 = r13.changed((java.lang.Object) r8)
            boolean r14 = r13.changed((java.lang.Object) r7)
            r8 = r8 | r14
            boolean r14 = r13.changed((java.lang.Object) r5)
            r8 = r8 | r14
            java.lang.Object r14 = r13.rememberedValue()
            if (r8 != 0) goto L_0x00a1
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r14 != r8) goto L_0x00af
        L_0x00a1:
            androidx.compose.material.ripple.AndroidRippleIndicationInstance r14 = new androidx.compose.material.ripple.AndroidRippleIndicationInstance
            r6 = 0
            r0 = r14
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r13.updateRememberedValue(r14)
        L_0x00af:
            r13.endReplaceableGroup()
            androidx.compose.material.ripple.AndroidRippleIndicationInstance r14 = (androidx.compose.material.ripple.AndroidRippleIndicationInstance) r14
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00bd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00bd:
            r13.endReplaceableGroup()
            androidx.compose.material.ripple.RippleIndicationInstance r14 = (androidx.compose.material.ripple.RippleIndicationInstance) r14
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.PlatformRipple.m1482rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource, boolean, float, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.Composer, int):androidx.compose.material.ripple.RippleIndicationInstance");
    }

    private final ViewGroup findNearestViewGroup(Composer composer, int i) {
        composer.startReplaceableGroup(-1737891121);
        ComposerKt.sourceInformation(composer, "C(findNearestViewGroup)87@3452L7:Ripple.android.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1737891121, i, -1, "androidx.compose.material.ripple.PlatformRipple.findNearestViewGroup (Ripple.android.kt:86)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(composer);
        while (!(consume instanceof ViewGroup)) {
            ViewParent parent = ((View) consume).getParent();
            if (parent instanceof View) {
                consume = parent;
            } else {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + consume + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
        }
        ViewGroup viewGroup = (ViewGroup) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return viewGroup;
    }
}
