package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001al\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\b\u0010\u001aT\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\b\u0015\u001aB\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\b\u0016\u001a\u0001\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\b\u0018\u001at\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\b\u0019\u001a\u0001\u0010\u001a\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\b$\u001a=\u0010%\u001a\u00020\u0004*\u00020&2\u0006\u0010'\u001a\u00020#2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H@ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"CombinedClickableNode", "Landroidx/compose/foundation/CombinedClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "CombinedClickableNode-xpl5gLE", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-Kqv-Bsg", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "delayPressInteraction", "handlePressInteraction-EPk0efs", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m248clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m247clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m246clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return m245clickableO2vRcR0(modifier, mutableInteractionSource, indication, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, function0);
    }

    /* renamed from: combinedClickable-cJG_KMw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m252combinedClickablecJG_KMw$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        return m251combinedClickablecJG_KMw(modifier, (i & 1) != 0 ? true : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : role, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : function0, (i & 32) != 0 ? null : function02, function03);
    }

    /* renamed from: combinedClickable-XVZzFYc$default  reason: not valid java name */
    public static /* synthetic */ Modifier m250combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        int i2 = i;
        return m249combinedClickableXVZzFYc(modifier, mutableInteractionSource, indication, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : role, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? null : function0, (i2 & 128) != 0 ? null : function02, function03);
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePressInteraction-EPk0efs  reason: not valid java name */
    public static final Object m255handlePressInteractionEPk0efs(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ClickableKt$handlePressInteraction$2(pressGestureScope, j, mutableInteractionSource, interactionData, function0, (Continuation<? super ClickableKt$handlePressInteraction$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg$default  reason: not valid java name */
    public static /* synthetic */ Modifier m254genericClickableWithoutGestureKqvBsg$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map map, State state, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, int i, Object obj) {
        int i2 = i;
        return m253genericClickableWithoutGestureKqvBsg(modifier, mutableInteractionSource, indication, coroutineScope, map, state, (i2 & 32) != 0 ? true : z, (i2 & 64) != 0 ? null : str, (i2 & 128) != 0 ? null : role, (i2 & 256) != 0 ? null : str2, (i2 & 512) != 0 ? null : function0, function02);
    }

    private static final Modifier genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(Modifier modifier, boolean z, Map<Key, PressInteraction.Press> map, State<Offset> state, CoroutineScope coroutineScope, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1(z, map, state, coroutineScope, function0, mutableInteractionSource));
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg  reason: not valid java name */
    public static final Modifier m253genericClickableWithoutGestureKqvBsg(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map<Key, PressInteraction.Press> map, State<Offset> state, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02) {
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        boolean z2 = z;
        return modifier.then(FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(new ClickableSemanticsElement(z, role, str2, function0, str, function02, (DefaultConstructorMarker) null), z, map, state, coroutineScope, function02, mutableInteractionSource), mutableInteractionSource2, indication), mutableInteractionSource2, z2), z2, mutableInteractionSource2));
    }

    /* renamed from: CombinedClickableNode-xpl5gLE  reason: not valid java name */
    public static final CombinedClickableNode m243CombinedClickableNodexpl5gLE(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, MutableInteractionSource mutableInteractionSource, boolean z, String str2, Role role) {
        return new CombinedClickableNodeImpl(function0, str, function02, function03, mutableInteractionSource, z, str2, role, (DefaultConstructorMarker) null);
    }

    /* renamed from: clickable-XHw0xAI  reason: not valid java name */
    public static final Modifier m247clickableXHw0xAI(Modifier modifier, boolean z, String str, Role role, Function0<Unit> function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(z, str, role, function0) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$2(z, str, role, function0));
    }

    /* renamed from: clickable-O2vRcR0  reason: not valid java name */
    public static final Modifier m245clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0<Unit> function0) {
        Function1<InspectorInfo, Unit> r0 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableO2vRcR0$$inlined$debugInspectorInfo$1(mutableInteractionSource, indication, z, str, role, function0) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, r0, FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(new ClickableElement(mutableInteractionSource, z, str, role, function0, (DefaultConstructorMarker) null)));
    }

    /* renamed from: combinedClickable-cJG_KMw  reason: not valid java name */
    public static final Modifier m251combinedClickablecJG_KMw(Modifier modifier, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Modifier modifier2 = modifier;
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(z, str, role, function03, function02, function0, str2) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$2(z, str, role, str2, function0, function02, function03));
    }

    /* renamed from: combinedClickable-XVZzFYc  reason: not valid java name */
    public static final Modifier m249combinedClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        boolean z2 = z;
        Function1<InspectorInfo, Unit> r12 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(indication, mutableInteractionSource, z, str, role, function03, function02, function0, str2) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        Modifier modifier3 = modifier;
        return InspectableValueKt.inspectableWrapper(modifier, r12, FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(Modifier.Companion, mutableInteractionSource2, indication), mutableInteractionSource2, z2), z2, mutableInteractionSource2).then(new CombinedClickableElement(mutableInteractionSource, z, str, role, function03, str2, function0, function02, (DefaultConstructorMarker) null)));
    }
}
