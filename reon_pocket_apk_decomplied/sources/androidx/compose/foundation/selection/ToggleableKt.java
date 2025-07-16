package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000¢\u0006\u0002\b\u000e\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000¢\u0006\u0002\b\u000f\u001aP\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000¢\u0006\u0002\b\u0015\u001a>\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000¢\u0006\u0002\b\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"toggleable", "Landroidx/compose/ui/Modifier;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "toggleable-O2vRcR0", "toggleable-XHw0xAI", "triStateToggleable", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "triStateToggleable-O2vRcR0", "triStateToggleable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Toggleable.kt */
public final class ToggleableKt {
    /* renamed from: toggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1007toggleableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1006toggleableXHw0xAI(modifier, z, z2, role, function1);
    }

    /* renamed from: toggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1005toggleableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m1004toggleableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, function1);
    }

    /* renamed from: triStateToggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1011triStateToggleableXHw0xAI$default(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1010triStateToggleableXHw0xAI(modifier, toggleableState, z, role, function0);
    }

    /* renamed from: triStateToggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1009triStateToggleableO2vRcR0$default(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            role = null;
        }
        return m1008triStateToggleableO2vRcR0(modifier, toggleableState, mutableInteractionSource, indication, z2, role, function0);
    }

    /* renamed from: toggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m1006toggleableXHw0xAI(Modifier modifier, boolean z, boolean z2, Role role, Function1<? super Boolean, Unit> function1) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(z, z2, role, function1) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$toggleable$2(z, z2, role, function1));
    }

    /* renamed from: toggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m1004toggleableO2vRcR0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1<? super Boolean, Unit> function1) {
        Function1<InspectorInfo, Unit> r0 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableO2vRcR0$$inlined$debugInspectorInfo$1(z, mutableInteractionSource, indication, z2, role, function1) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, r0, m1008triStateToggleableO2vRcR0(Modifier.Companion, ToggleableStateKt.ToggleableState(z), mutableInteractionSource, indication, z2, role, new ToggleableKt$toggleable$4$1(function1, z)));
    }

    /* renamed from: triStateToggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m1010triStateToggleableXHw0xAI(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, Function0<Unit> function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableXHw0xAI$$inlined$debugInspectorInfo$1(toggleableState, z, role, function0) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$triStateToggleable$2(toggleableState, z, role, function0));
    }

    /* renamed from: triStateToggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m1008triStateToggleableO2vRcR0(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0<Unit> function0) {
        ToggleableState toggleableState2 = toggleableState;
        Modifier modifier2 = modifier;
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableO2vRcR0$$inlined$debugInspectorInfo$1(toggleableState, z, role, mutableInteractionSource, indication, function0) : InspectableValueKt.getNoInspectorInfo(), SemanticsModifierKt.semantics$default(ClickableKt.m246clickableO2vRcR0$default(Modifier.Companion, mutableInteractionSource, indication, z, (String) null, role, function0, 8, (Object) null), false, new ToggleableKt$triStateToggleable$4$1(toggleableState), 1, (Object) null));
    }
}
