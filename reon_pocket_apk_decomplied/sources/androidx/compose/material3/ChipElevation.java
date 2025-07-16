package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001e\u0010\u0018J\u001d\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\"²\u0006\f\u0010#\u001a\u0004\u0018\u00010$X\u0002"}, d2 = {"Landroidx/compose/material3/ChipElevation;", "", "elevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledElevation-D9Ej5fM", "()F", "F", "getDraggedElevation-D9Ej5fM", "getElevation-D9Ej5fM", "getFocusedElevation-D9Ej5fM", "getHoveredElevation-D9Ej5fM", "getPressedElevation-D9Ej5fM", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation-u2uoSUM$material3_release", "(Z)F", "material3_release", "lastInteraction", "Landroidx/compose/foundation/interaction/Interaction;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class ChipElevation {
    public static final int $stable = 0;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float elevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ ChipElevation(float f, float f2, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6);
    }

    private ChipElevation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.elevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
        this.draggedElevation = f5;
        this.disabledElevation = f6;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m1621getElevationD9Ej5fM() {
        return this.elevation;
    }

    /* renamed from: getPressedElevation-D9Ej5fM  reason: not valid java name */
    public final float m1624getPressedElevationD9Ej5fM() {
        return this.pressedElevation;
    }

    /* renamed from: getFocusedElevation-D9Ej5fM  reason: not valid java name */
    public final float m1622getFocusedElevationD9Ej5fM() {
        return this.focusedElevation;
    }

    /* renamed from: getHoveredElevation-D9Ej5fM  reason: not valid java name */
    public final float m1623getHoveredElevationD9Ej5fM() {
        return this.hoveredElevation;
    }

    /* renamed from: getDraggedElevation-D9Ej5fM  reason: not valid java name */
    public final float m1620getDraggedElevationD9Ej5fM() {
        return this.draggedElevation;
    }

    /* renamed from: getDisabledElevation-D9Ej5fM  reason: not valid java name */
    public final float m1619getDisabledElevationD9Ej5fM() {
        return this.disabledElevation;
    }

    /* renamed from: tonalElevation-u2uoSUM$material3_release  reason: not valid java name */
    public final float m1625tonalElevationu2uoSUM$material3_release(boolean z) {
        return z ? this.elevation : this.disabledElevation;
    }

    public final State<Dp> shadowElevation$material3_release(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        composer.startReplaceableGroup(1881877139);
        ComposerKt.sourceInformation(composer, "C(shadowElevation)2088@102080L74:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1881877139, i, -1, "androidx.compose.material3.ChipElevation.shadowElevation (Chip.kt:2087)");
        }
        State<Dp> animateElevation = animateElevation(z, interactionSource, composer, i & 1022);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateElevation;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.State<androidx.compose.ui.unit.Dp> animateElevation(boolean r21, androidx.compose.foundation.interaction.InteractionSource r22, androidx.compose.runtime.Composer r23, int r24) {
        /*
            r20 = this;
            r0 = r20
            r4 = r21
            r1 = r22
            r8 = r23
            r2 = r24
            r3 = -2071499570(0xffffffff84876cce, float:-3.183827E-36)
            r8.startReplaceableGroup(r3)
            java.lang.String r5 = "C(animateElevation)2096@102329L46,2097@102407L47,2098@102497L1482,2098@102463L1516,2158@104482L51,2160@104566L466,2160@104543L489:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0021
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.ChipElevation.animateElevation (Chip.kt:2095)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r5, r6)
        L_0x0021:
            r3 = -1373742275(0xffffffffae1e5b3d, float:-3.6006077E-11)
            r8.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            java.lang.Object r5 = r23.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x003f
            androidx.compose.runtime.snapshots.SnapshotStateList r5 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r8.updateRememberedValue(r5)
        L_0x003f:
            androidx.compose.runtime.snapshots.SnapshotStateList r5 = (androidx.compose.runtime.snapshots.SnapshotStateList) r5
            r23.endReplaceableGroup()
            r6 = -1373742197(0xffffffffae1e5b8b, float:-3.6006347E-11)
            r8.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            java.lang.Object r6 = r23.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            r9 = 0
            if (r6 != r7) goto L_0x0062
            r6 = 2
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r9, r9, r6, r9)
            r8.updateRememberedValue(r6)
        L_0x0062:
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            r23.endReplaceableGroup()
            r7 = -1373742107(0xffffffffae1e5be5, float:-3.600666E-11)
            r8.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            r7 = r2 & 112(0x70, float:1.57E-43)
            r7 = r7 ^ 48
            r10 = 1
            r11 = 32
            r12 = 0
            if (r7 <= r11) goto L_0x0080
            boolean r7 = r8.changed((java.lang.Object) r1)
            if (r7 != 0) goto L_0x0084
        L_0x0080:
            r7 = r2 & 48
            if (r7 != r11) goto L_0x0086
        L_0x0084:
            r7 = r10
            goto L_0x0087
        L_0x0086:
            r7 = r12
        L_0x0087:
            java.lang.Object r11 = r23.rememberedValue()
            if (r7 != 0) goto L_0x0095
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r11 != r7) goto L_0x00a0
        L_0x0095:
            androidx.compose.material3.ChipElevation$animateElevation$1$1 r7 = new androidx.compose.material3.ChipElevation$animateElevation$1$1
            r7.<init>(r1, r5, r9)
            r11 = r7
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r8.updateRememberedValue(r11)
        L_0x00a0:
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r23.endReplaceableGroup()
            int r7 = r2 >> 3
            r7 = r7 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r11, (androidx.compose.runtime.Composer) r8, (int) r7)
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r1 = kotlin.collections.CollectionsKt.lastOrNull(r5)
            r5 = r1
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            if (r4 != 0) goto L_0x00bb
            float r1 = r0.disabledElevation
        L_0x00b9:
            r7 = r1
            goto L_0x00da
        L_0x00bb:
            boolean r1 = r5 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
            if (r1 == 0) goto L_0x00c2
            float r1 = r0.pressedElevation
            goto L_0x00b9
        L_0x00c2:
            boolean r1 = r5 instanceof androidx.compose.foundation.interaction.HoverInteraction.Enter
            if (r1 == 0) goto L_0x00c9
            float r1 = r0.hoveredElevation
            goto L_0x00b9
        L_0x00c9:
            boolean r1 = r5 instanceof androidx.compose.foundation.interaction.FocusInteraction.Focus
            if (r1 == 0) goto L_0x00d0
            float r1 = r0.focusedElevation
            goto L_0x00b9
        L_0x00d0:
            boolean r1 = r5 instanceof androidx.compose.foundation.interaction.DragInteraction.Start
            if (r1 == 0) goto L_0x00d7
            float r1 = r0.draggedElevation
            goto L_0x00b9
        L_0x00d7:
            float r1 = r0.elevation
            goto L_0x00b9
        L_0x00da:
            r1 = -1373740122(0xffffffffae1e63a6, float:-3.6013546E-11)
            r8.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            java.lang.Object r1 = r23.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r1 != r9) goto L_0x010a
            androidx.compose.animation.core.Animatable r1 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.unit.Dp r14 = androidx.compose.ui.unit.Dp.m6612boximpl(r7)
            androidx.compose.ui.unit.Dp$Companion r9 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r15 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r9)
            r18 = 12
            r19 = 0
            r16 = 0
            r17 = 0
            r13 = r1
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r8.updateRememberedValue(r1)
        L_0x010a:
            r9 = r1
            androidx.compose.animation.core.Animatable r9 = (androidx.compose.animation.core.Animatable) r9
            r23.endReplaceableGroup()
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m6612boximpl(r7)
            r1 = -1373740038(0xffffffffae1e63fa, float:-3.6013838E-11)
            r8.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            boolean r1 = r8.changedInstance(r9)
            boolean r3 = r8.changed((float) r7)
            r1 = r1 | r3
            r3 = r2 & 14
            r3 = r3 ^ 6
            r13 = 4
            if (r3 <= r13) goto L_0x0133
            boolean r3 = r8.changed((boolean) r4)
            if (r3 != 0) goto L_0x0139
        L_0x0133:
            r2 = r2 & 6
            if (r2 != r13) goto L_0x0138
            goto L_0x0139
        L_0x0138:
            r10 = r12
        L_0x0139:
            r1 = r1 | r10
            boolean r2 = r8.changedInstance(r5)
            r1 = r1 | r2
            java.lang.Object r2 = r23.rememberedValue()
            if (r1 != 0) goto L_0x014d
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x015f
        L_0x014d:
            androidx.compose.material3.ChipElevation$animateElevation$2$1 r10 = new androidx.compose.material3.ChipElevation$animateElevation$2$1
            r13 = 0
            r1 = r10
            r2 = r9
            r3 = r7
            r4 = r21
            r7 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r2 = r10
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r8.updateRememberedValue(r2)
        L_0x015f:
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r23.endReplaceableGroup()
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2, (androidx.compose.runtime.Composer) r8, (int) r12)
            androidx.compose.runtime.State r1 = r9.asState()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0174
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0174:
            r23.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipElevation.animateElevation(boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    /* access modifiers changed from: private */
    public static final Interaction animateElevation$lambda$2(MutableState<Interaction> mutableState) {
        return (Interaction) mutableState.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChipElevation)) {
            return false;
        }
        ChipElevation chipElevation = (ChipElevation) obj;
        return Dp.m6619equalsimpl0(this.elevation, chipElevation.elevation) && Dp.m6619equalsimpl0(this.pressedElevation, chipElevation.pressedElevation) && Dp.m6619equalsimpl0(this.focusedElevation, chipElevation.focusedElevation) && Dp.m6619equalsimpl0(this.hoveredElevation, chipElevation.hoveredElevation) && Dp.m6619equalsimpl0(this.disabledElevation, chipElevation.disabledElevation);
    }

    public int hashCode() {
        return (((((((Dp.m6620hashCodeimpl(this.elevation) * 31) + Dp.m6620hashCodeimpl(this.pressedElevation)) * 31) + Dp.m6620hashCodeimpl(this.focusedElevation)) * 31) + Dp.m6620hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m6620hashCodeimpl(this.disabledElevation);
    }

    /* access modifiers changed from: private */
    public static final void animateElevation$lambda$3(MutableState<Interaction> mutableState, Interaction interaction) {
        mutableState.setValue(interaction);
    }
}
