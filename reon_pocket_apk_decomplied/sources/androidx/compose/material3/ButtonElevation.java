package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0016\u0010\u0010J\u001d\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/ButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation-u2uoSUM$material3_release", "(Z)F", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Button.kt */
public final class ButtonElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float disabledElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    public /* synthetic */ ButtonElevation(float f, float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5);
    }

    private ButtonElevation(float f, float f2, float f3, float f4, float f5) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
        this.disabledElevation = f5;
    }

    /* renamed from: tonalElevation-u2uoSUM$material3_release  reason: not valid java name */
    public final float m1564tonalElevationu2uoSUM$material3_release(boolean z) {
        return z ? this.defaultElevation : this.disabledElevation;
    }

    public final State<Dp> shadowElevation$material3_release(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        composer.startReplaceableGroup(-2045116089);
        ComposerKt.sourceInformation(composer, "C(shadowElevation)888@42087L74:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045116089, i, -1, "androidx.compose.material3.ButtonElevation.shadowElevation (Button.kt:887)");
        }
        State<Dp> animateElevation = animateElevation(z, interactionSource, composer, i & 1022);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateElevation;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.State<androidx.compose.ui.unit.Dp> animateElevation(boolean r19, androidx.compose.foundation.interaction.InteractionSource r20, androidx.compose.runtime.Composer r21, int r22) {
        /*
            r18 = this;
            r7 = r18
            r3 = r19
            r0 = r20
            r8 = r21
            r1 = r22
            r2 = -1312510462(0xffffffffb1c4ae02, float:-5.724133E-9)
            r8.startReplaceableGroup(r2)
            java.lang.String r4 = "C(animateElevation)896@42336L46,897@42425L1083,897@42391L1117,945@44005L51,947@44089L819,947@44066L842:Button.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0021
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.ButtonElevation.animateElevation (Button.kt:895)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r4, r5)
        L_0x0021:
            r2 = -719928578(0xffffffffd516c2fe, float:-1.03602643E13)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Button.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            java.lang.Object r4 = r21.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x003f
            androidx.compose.runtime.snapshots.SnapshotStateList r4 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r8.updateRememberedValue(r4)
        L_0x003f:
            androidx.compose.runtime.snapshots.SnapshotStateList r4 = (androidx.compose.runtime.snapshots.SnapshotStateList) r4
            r21.endReplaceableGroup()
            r5 = -719928489(0xffffffffd516c357, float:-1.03603577E13)
            r8.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r5 = r1 & 112(0x70, float:1.57E-43)
            r5 = r5 ^ 48
            r6 = 32
            r9 = 1
            r10 = 0
            if (r5 <= r6) goto L_0x005d
            boolean r5 = r8.changed((java.lang.Object) r0)
            if (r5 != 0) goto L_0x0061
        L_0x005d:
            r5 = r1 & 48
            if (r5 != r6) goto L_0x0063
        L_0x0061:
            r5 = r9
            goto L_0x0064
        L_0x0063:
            r5 = r10
        L_0x0064:
            java.lang.Object r6 = r21.rememberedValue()
            if (r5 != 0) goto L_0x0072
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x007e
        L_0x0072:
            androidx.compose.material3.ButtonElevation$animateElevation$1$1 r5 = new androidx.compose.material3.ButtonElevation$animateElevation$1$1
            r6 = 0
            r5.<init>(r0, r4, r6)
            r6 = r5
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r8.updateRememberedValue(r6)
        L_0x007e:
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r21.endReplaceableGroup()
            int r5 = r1 >> 3
            r5 = r5 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r6, (androidx.compose.runtime.Composer) r8, (int) r5)
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r0 = kotlin.collections.CollectionsKt.lastOrNull(r4)
            r5 = r0
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            if (r3 != 0) goto L_0x0099
            float r0 = r7.disabledElevation
        L_0x0097:
            r4 = r0
            goto L_0x00b1
        L_0x0099:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
            if (r0 == 0) goto L_0x00a0
            float r0 = r7.pressedElevation
            goto L_0x0097
        L_0x00a0:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.HoverInteraction.Enter
            if (r0 == 0) goto L_0x00a7
            float r0 = r7.hoveredElevation
            goto L_0x0097
        L_0x00a7:
            boolean r0 = r5 instanceof androidx.compose.foundation.interaction.FocusInteraction.Focus
            if (r0 == 0) goto L_0x00ae
            float r0 = r7.focusedElevation
            goto L_0x0097
        L_0x00ae:
            float r0 = r7.defaultElevation
            goto L_0x0097
        L_0x00b1:
            r0 = -719926909(0xffffffffd516c983, float:-1.03620144E13)
            r8.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            java.lang.Object r0 = r21.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r0 != r6) goto L_0x00df
            androidx.compose.animation.core.Animatable r0 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.unit.Dp r12 = androidx.compose.ui.unit.Dp.m6612boximpl(r4)
            androidx.compose.ui.unit.Dp$Companion r6 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r13 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r6)
            r16 = 12
            r17 = 0
            r14 = 0
            r15 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            r8.updateRememberedValue(r0)
        L_0x00df:
            r11 = r0
            androidx.compose.animation.core.Animatable r11 = (androidx.compose.animation.core.Animatable) r11
            r21.endReplaceableGroup()
            androidx.compose.ui.unit.Dp r12 = androidx.compose.ui.unit.Dp.m6612boximpl(r4)
            r0 = -719926825(0xffffffffd516c9d7, float:-1.03621025E13)
            r8.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            boolean r0 = r8.changedInstance(r11)
            boolean r2 = r8.changed((float) r4)
            r0 = r0 | r2
            r2 = r1 & 14
            r2 = r2 ^ 6
            r6 = 4
            if (r2 <= r6) goto L_0x0108
            boolean r2 = r8.changed((boolean) r3)
            if (r2 != 0) goto L_0x010c
        L_0x0108:
            r2 = r1 & 6
            if (r2 != r6) goto L_0x010e
        L_0x010c:
            r2 = r9
            goto L_0x010f
        L_0x010e:
            r2 = r10
        L_0x010f:
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 ^ 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r2 <= r6) goto L_0x011e
            boolean r2 = r8.changed((java.lang.Object) r7)
            if (r2 != 0) goto L_0x0124
        L_0x011e:
            r1 = r1 & 384(0x180, float:5.38E-43)
            if (r1 != r6) goto L_0x0123
            goto L_0x0124
        L_0x0123:
            r9 = r10
        L_0x0124:
            r0 = r0 | r9
            boolean r1 = r8.changedInstance(r5)
            r0 = r0 | r1
            java.lang.Object r1 = r21.rememberedValue()
            if (r0 != 0) goto L_0x0138
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x014b
        L_0x0138:
            androidx.compose.material3.ButtonElevation$animateElevation$2$1 r9 = new androidx.compose.material3.ButtonElevation$animateElevation$2$1
            r6 = 0
            r0 = r9
            r1 = r11
            r2 = r4
            r3 = r19
            r4 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r1 = r9
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateRememberedValue(r1)
        L_0x014b:
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r21.endReplaceableGroup()
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r12, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r8, (int) r10)
            androidx.compose.runtime.State r0 = r11.asState()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0160
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0160:
            r21.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonElevation.animateElevation(boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ButtonElevation)) {
            return false;
        }
        ButtonElevation buttonElevation = (ButtonElevation) obj;
        return Dp.m6619equalsimpl0(this.defaultElevation, buttonElevation.defaultElevation) && Dp.m6619equalsimpl0(this.pressedElevation, buttonElevation.pressedElevation) && Dp.m6619equalsimpl0(this.focusedElevation, buttonElevation.focusedElevation) && Dp.m6619equalsimpl0(this.hoveredElevation, buttonElevation.hoveredElevation) && Dp.m6619equalsimpl0(this.disabledElevation, buttonElevation.disabledElevation);
    }

    public int hashCode() {
        return (((((((Dp.m6620hashCodeimpl(this.defaultElevation) * 31) + Dp.m6620hashCodeimpl(this.pressedElevation)) * 31) + Dp.m6620hashCodeimpl(this.focusedElevation)) * 31) + Dp.m6620hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m6620hashCodeimpl(this.disabledElevation);
    }
}
