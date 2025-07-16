package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001a6\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002\u001a2\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t¨\u0006\u0011"}, d2 = {"rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "horizontalScroll", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "scroll", "isScrollable", "isVertical", "verticalScroll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
public final class ScrollKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.ScrollState rememberScrollState(int r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            r0 = -1464256199(0xffffffffa8b93939, float:-2.0563942E-14)
            r11.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberScrollState)74@3377L90:Scroll.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r13 = r13 & 1
            r1 = 0
            if (r13 == 0) goto L_0x0011
            r10 = r1
        L_0x0011:
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x001d
            r13 = -1
            java.lang.String r2 = "androidx.compose.foundation.rememberScrollState (Scroll.kt:73)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r13, r2)
        L_0x001d:
            java.lang.Object[] r3 = new java.lang.Object[r1]
            androidx.compose.foundation.ScrollState$Companion r12 = androidx.compose.foundation.ScrollState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r12.getSaver()
            r12 = -699453458(0xffffffffd64f2fee, float:-5.6951191E13)
            r11.startReplaceableGroup(r12)
            boolean r12 = r11.changed((int) r10)
            java.lang.Object r13 = r11.rememberedValue()
            if (r12 != 0) goto L_0x003d
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x0048
        L_0x003d:
            androidx.compose.foundation.ScrollKt$rememberScrollState$1$1 r12 = new androidx.compose.foundation.ScrollKt$rememberScrollState$1$1
            r12.<init>(r10)
            r13 = r12
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r11.updateRememberedValue(r13)
        L_0x0048:
            r6 = r13
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r11.endReplaceableGroup()
            r8 = 72
            r9 = 4
            r5 = 0
            r7 = r11
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.foundation.ScrollState r10 = (androidx.compose.foundation.ScrollState) r10
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0062
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0062:
            r11.endReplaceableGroup()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ScrollKt.rememberScrollState(int, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.ScrollState");
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return verticalScroll(modifier, scrollState, z, flingBehavior, z2);
    }

    public static final Modifier verticalScroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2) {
        return scroll(modifier, scrollState, z2, flingBehavior, z, true);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return horizontalScroll(modifier, scrollState, z, flingBehavior, z2);
    }

    public static final Modifier horizontalScroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2) {
        return scroll(modifier, scrollState, z2, flingBehavior, z, false);
    }

    private static final Modifier scroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, boolean z3) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ScrollKt$scroll$$inlined$debugInspectorInfo$1(scrollState, z, flingBehavior, z2, z3) : InspectableValueKt.getNoInspectorInfo(), new ScrollKt$scroll$2(z3, z, scrollState, z2, flingBehavior));
    }
}
