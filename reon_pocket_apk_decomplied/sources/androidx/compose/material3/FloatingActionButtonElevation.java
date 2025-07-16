package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u0003H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation-D9Ej5fM$material3_release", "()F", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public class FloatingActionButtonElevation {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public final float defaultElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    public /* synthetic */ FloatingActionButtonElevation(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private FloatingActionButtonElevation(float f, float f2, float f3, float f4) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
    }

    public final State<Dp> shadowElevation$material3_release(InteractionSource interactionSource, Composer composer, int i) {
        composer.startReplaceableGroup(-424810125);
        ComposerKt.sourceInformation(composer, "C(shadowElevation)489@23517L55:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-424810125, i, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:488)");
        }
        State<Dp> animateElevation = animateElevation(interactionSource, composer, i & 126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateElevation;
    }

    /* renamed from: tonalElevation-D9Ej5fM$material3_release  reason: not valid java name */
    public final float m1877tonalElevationD9Ej5fM$material3_release() {
        return this.defaultElevation;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: androidx.compose.material3.FloatingActionButtonElevationAnimatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: androidx.compose.material3.FloatingActionButtonElevationAnimatable} */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x004e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.State<androidx.compose.ui.unit.Dp> animateElevation(androidx.compose.foundation.interaction.InteractionSource r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = -1845106002(0xffffffff9205eaae, float:-4.2256665E-28)
            r2.startReplaceableGroup(r4)
            java.lang.String r5 = "C(animateElevation)498@23784L317,507@24132L276,507@24111L297,516@24452L1318,516@24418L1352:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x001f
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:497)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r5, r6)
        L_0x001f:
            r4 = 1849274698(0x6e39b14a, float:1.4367264E28)
            r2.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):FloatingActionButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r5 = r3 & 14
            r6 = r5 ^ 6
            r7 = 0
            r8 = 1
            r9 = 4
            if (r6 <= r9) goto L_0x0039
            boolean r10 = r2.changed((java.lang.Object) r1)
            if (r10 != 0) goto L_0x003d
        L_0x0039:
            r10 = r3 & 6
            if (r10 != r9) goto L_0x003f
        L_0x003d:
            r10 = r8
            goto L_0x0040
        L_0x003f:
            r10 = r7
        L_0x0040:
            java.lang.Object r11 = r20.rememberedValue()
            if (r10 != 0) goto L_0x004e
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0063
        L_0x004e:
            androidx.compose.material3.FloatingActionButtonElevationAnimatable r11 = new androidx.compose.material3.FloatingActionButtonElevationAnimatable
            float r13 = r0.defaultElevation
            float r14 = r0.pressedElevation
            float r15 = r0.hoveredElevation
            float r10 = r0.focusedElevation
            r17 = 0
            r12 = r11
            r16 = r10
            r12.<init>(r13, r14, r15, r16, r17)
            r2.updateRememberedValue(r11)
        L_0x0063:
            androidx.compose.material3.FloatingActionButtonElevationAnimatable r11 = (androidx.compose.material3.FloatingActionButtonElevationAnimatable) r11
            r20.endReplaceableGroup()
            r10 = 1849275046(0x6e39b2a6, float:1.4367675E28)
            r2.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            boolean r10 = r2.changedInstance(r11)
            r12 = r3 & 112(0x70, float:1.57E-43)
            r12 = r12 ^ 48
            r13 = 32
            if (r12 <= r13) goto L_0x0083
            boolean r12 = r2.changed((java.lang.Object) r0)
            if (r12 != 0) goto L_0x0087
        L_0x0083:
            r12 = r3 & 48
            if (r12 != r13) goto L_0x0089
        L_0x0087:
            r12 = r8
            goto L_0x008a
        L_0x0089:
            r12 = r7
        L_0x008a:
            r10 = r10 | r12
            java.lang.Object r12 = r20.rememberedValue()
            r13 = 0
            if (r10 != 0) goto L_0x009a
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x00a5
        L_0x009a:
            androidx.compose.material3.FloatingActionButtonElevation$animateElevation$1$1 r10 = new androidx.compose.material3.FloatingActionButtonElevation$animateElevation$1$1
            r10.<init>(r11, r0, r13)
            r12 = r10
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r2.updateRememberedValue(r12)
        L_0x00a5:
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r20.endReplaceableGroup()
            int r10 = r3 >> 3
            r10 = r10 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r12, (androidx.compose.runtime.Composer) r2, (int) r10)
            r10 = 1849275366(0x6e39b3e6, float:1.4368053E28)
            r2.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            if (r6 <= r9) goto L_0x00c2
            boolean r4 = r2.changed((java.lang.Object) r1)
            if (r4 != 0) goto L_0x00c6
        L_0x00c2:
            r3 = r3 & 6
            if (r3 != r9) goto L_0x00c7
        L_0x00c6:
            r7 = r8
        L_0x00c7:
            boolean r3 = r2.changedInstance(r11)
            r3 = r3 | r7
            java.lang.Object r4 = r20.rememberedValue()
            if (r3 != 0) goto L_0x00da
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x00e5
        L_0x00da:
            androidx.compose.material3.FloatingActionButtonElevation$animateElevation$2$1 r3 = new androidx.compose.material3.FloatingActionButtonElevation$animateElevation$2$1
            r3.<init>(r1, r11, r13)
            r4 = r3
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.updateRememberedValue(r4)
        L_0x00e5:
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r20.endReplaceableGroup()
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r4, (androidx.compose.runtime.Composer) r2, (int) r5)
            androidx.compose.runtime.State r1 = r11.asState()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00fa
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00fa:
            r20.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonElevation.animateElevation(androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FloatingActionButtonElevation)) {
            return false;
        }
        FloatingActionButtonElevation floatingActionButtonElevation = (FloatingActionButtonElevation) obj;
        if (Dp.m6619equalsimpl0(this.defaultElevation, floatingActionButtonElevation.defaultElevation) && Dp.m6619equalsimpl0(this.pressedElevation, floatingActionButtonElevation.pressedElevation) && Dp.m6619equalsimpl0(this.focusedElevation, floatingActionButtonElevation.focusedElevation)) {
            return Dp.m6619equalsimpl0(this.hoveredElevation, floatingActionButtonElevation.hoveredElevation);
        }
        return false;
    }

    public int hashCode() {
        return (((((Dp.m6620hashCodeimpl(this.defaultElevation) * 31) + Dp.m6620hashCodeimpl(this.pressedElevation)) * 31) + Dp.m6620hashCodeimpl(this.focusedElevation)) * 31) + Dp.m6620hashCodeimpl(this.hoveredElevation);
    }
}
