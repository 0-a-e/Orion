package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001aA\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"unsupportedDirection", "", "lazyLayoutBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
public final class LazyLayoutBeyondBoundsModifierLocalKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal} */
    /* JADX WARNING: type inference failed for: r14v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0054, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0056;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier lazyLayoutBeyondBoundsModifier(androidx.compose.ui.Modifier r6, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r7, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r8, boolean r9, androidx.compose.ui.unit.LayoutDirection r10, androidx.compose.foundation.gestures.Orientation r11, boolean r12, androidx.compose.runtime.Composer r13, int r14) {
        /*
            r0 = 1331498025(0x4f5d0c29, float:3.70856166E9)
            r13.startReplaceableGroup(r0)
            java.lang.String r1 = "C(lazyLayoutBeyondBoundsModifier)P(5!1,4,2,3)54@2427L270:LazyLayoutBeyondBoundsModifierLocal.kt#wow0x6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.lazy.layout.lazyLayoutBeyondBoundsModifier (LazyLayoutBeyondBoundsModifierLocal.kt:51)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x0017:
            if (r12 != 0) goto L_0x001a
            goto L_0x006d
        L_0x001a:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r9)
            r14 = 5
            java.lang.Object[] r0 = new java.lang.Object[r14]
            r1 = 0
            r0[r1] = r7
            r2 = 1
            r0[r2] = r8
            r2 = 2
            r0[r2] = r12
            r12 = 3
            r0[r12] = r10
            r12 = 4
            r0[r12] = r11
            r12 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r13.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r12)
            r12 = r1
        L_0x003c:
            if (r1 >= r14) goto L_0x0048
            r2 = r0[r1]
            boolean r2 = r13.changed((java.lang.Object) r2)
            r12 = r12 | r2
            int r1 = r1 + 1
            goto L_0x003c
        L_0x0048:
            java.lang.Object r14 = r13.rememberedValue()
            if (r12 != 0) goto L_0x0056
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r14 != r12) goto L_0x0064
        L_0x0056:
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal r14 = new androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal
            r0 = r14
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r13.updateRememberedValue(r14)
        L_0x0064:
            r13.endReplaceableGroup()
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            androidx.compose.ui.Modifier r6 = r6.then(r14)
        L_0x006d:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0076
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0076:
            r13.endReplaceableGroup()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo, boolean, androidx.compose.ui.unit.LayoutDirection, androidx.compose.foundation.gestures.Orientation, boolean, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    /* access modifiers changed from: private */
    public static final Void unsupportedDirection() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
    }
}
