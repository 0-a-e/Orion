package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text2.input.internal.TextLayoutStateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010r\u001a\u00020O2\u0006\u0010s\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\bt\u0010$J\"\u0010u\u001a\u00020\u00182\u0006\u0010v\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\bx\u0010yJ\r\u0010z\u001a\u00020OH\u0000¢\u0006\u0002\b{J\u0018\u0010|\u001a\u0004\u0018\u00010}2\u0006\u0010~\u001a\u00020H\u0000¢\u0006\u0003\b\u0001J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0003\b\u0001J/\u0010\u0001\u001a\u00020W2\u0006\u0010s\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0007J\u000f\u0010\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020OJ\u000f\u0010\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b\u0001JA\u0010\u0001\u001a\u001f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\t0\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0003\b\u0001J\u001b\u0010\u0001\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020W2\u0007\u0010\u0001\u001a\u00020\tH\u0002J\u000f\u0010\u0001\u001a\u00020\u0007H\u0001¢\u0006\u0003\b\u0001J0\u0010 \u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u00072\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b£\u0001\u0010¤\u0001J\t\u0010¥\u0001\u001a\u00020OH\u0002J\t\u0010¦\u0001\u001a\u00020OH\u0002J9\u0010§\u0001\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u00072\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b¨\u0001\u0010©\u0001J;\u0010§\u0001\u001a\u00020\u00072\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010U\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u00072\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b«\u0001\u0010¬\u0001J\t\u0010­\u0001\u001a\u00020OH\u0002J*\u0010®\u0001\u001a\u00020O*\u00030¯\u00012\u0013\u0010°\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020O0NH@¢\u0006\u0003\u0010±\u0001J\u001d\u0010²\u0001\u001a\u00020J*\u00020J2\u000e\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020O0´\u0001H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R5\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR1\u0010 \u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188@@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R1\u0010&\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188@@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b)\u0010\u001f\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R/\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0017\u001a\u0004\u0018\u00010*8F@BX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u001f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R5\u00101\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b4\u0010\u001f\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R+\u0010A\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\bF\u0010\u001f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010G\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u0011\u0010I\u001a\u00020J8F¢\u0006\u0006\u001a\u0004\bK\u0010LR@\u0010P\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020O0N2\u0014\u0010M\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020O0N@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010U\u001a\u0004\u0018\u00010\u0018X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R&\u0010V\u001a\u0004\u0018\u00010W8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R(\u0010^\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u000e¢\u0006\f\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010CR$\u0010e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010C\"\u0004\bg\u0010ER5\u0010h\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bk\u0010\u001f\u001a\u0004\bi\u0010\u001b\"\u0004\bj\u0010\u001dR\u001c\u0010l\u001a\u0004\u0018\u00010mX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006µ\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_isInTouchMode", "Landroidx/compose/runtime/MutableState;", "", "_selection", "Landroidx/compose/foundation/text/selection/Selection;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "isInTouchMode", "setInTouchMode", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "newOnSelectionChange", "Lkotlin/Function1;", "", "onSelectionChange", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "previousPosition", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getPreviousSelectionLayout$foundation_release$annotations", "()V", "getPreviousSelectionLayout$foundation_release", "()Landroidx/compose/foundation/text/selection/SelectionLayout;", "setPreviousSelectionLayout$foundation_release", "(Landroidx/compose/foundation/text/selection/SelectionLayout;)V", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "shouldShowMagnifier", "getShouldShowMagnifier", "showToolbar", "getShowToolbar$foundation_release", "setShowToolbar$foundation_release", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "setStartHandlePosition-_kEHs6E", "startHandlePosition$delegate", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "copy", "copy$foundation_release", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText$foundation_release", "getSelectionLayout", "previousHandlePosition", "isStartHandle", "getSelectionLayout-Wko1d7g", "(JJZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isNonEmptySelection", "isNonEmptySelection$foundation_release", "isTriviallyCollapsedSelection", "isTriviallyCollapsedSelection$foundation_release", "onRelease", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAll", "Lkotlin/Pair;", "", "", "selectableId", "previousSelection", "selectAll$foundation_release", "selectionChanged", "selectionLayout", "newSelection", "shouldPerformHaptics", "shouldPerformHaptics$foundation_release", "startSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "toolbarCopy", "updateHandleOffsets", "updateSelection", "updateSelection-jyLRC_s$foundation_release", "(JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "newPosition", "updateSelection-qNKwrvQ$foundation_release", "(Landroidx/compose/ui/geometry/Offset;JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "updateSelectionToolbar", "detectNonConsumingTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClearSelectionRequested", "block", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManager {
    public static final int $stable = 8;
    private final MutableState<Boolean> _isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState<Selection> _selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private ClipboardManager clipboardManager;
    private LayoutCoordinates containerLayoutCoordinates;
    private final MutableState currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState dragBeginPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3551boximpl(Offset.Companion.m3578getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState dragTotalDistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3551boximpl(Offset.Companion.m3578getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState endHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private FocusRequester focusRequester = new FocusRequester();
    private HapticFeedback hapticFeedBack;
    private final MutableState hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function1<? super Selection, Unit> onSelectionChange = new SelectionManager$onSelectionChange$1(this);
    private Offset previousPosition;
    private SelectionLayout previousSelectionLayout;
    /* access modifiers changed from: private */
    public final SelectionRegistrarImpl selectionRegistrar;
    private boolean showToolbar;
    private final MutableState startHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private TextToolbar textToolbar;

    public static /* synthetic */ void getPreviousSelectionLayout$foundation_release$annotations() {
    }

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        this.selectionRegistrar = selectionRegistrarImpl;
        selectionRegistrarImpl.setOnPositionChangeCallback$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                if (this.this$0.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j))) {
                    this.this$0.updateHandleOffsets();
                    this.this$0.updateSelectionToolbar();
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateStartCallback$foundation_release(new Function4<Boolean, LayoutCoordinates, Offset, SelectionAdjustment, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                m1269invokeRg1IO4c(((Boolean) obj).booleanValue(), (LayoutCoordinates) obj2, ((Offset) obj3).m3572unboximpl(), (SelectionAdjustment) obj4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Rg1IO4c  reason: not valid java name */
            public final void m1269invokeRg1IO4c(boolean z, LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment) {
                long r0 = layoutCoordinates.m5318getSizeYbymL2g();
                Rect rect = new Rect(0.0f, 0.0f, (float) IntSize.m6790getWidthimpl(r0), (float) IntSize.m6789getHeightimpl(r0));
                if (!SelectionManagerKt.m1277containsInclusiveUv8p0NA(rect, j)) {
                    j = TextLayoutStateKt.m1419coerceIn3MmeM6k(j, rect);
                }
                long r6 = this.this$0.m1253convertToContainerCoordinatesR5De75A(layoutCoordinates, j);
                if (OffsetKt.m3581isSpecifiedk4lQ0M(r6)) {
                    this.this$0.setInTouchMode(z);
                    this.this$0.m1260startSelection9KIMszo(r6, false, selectionAdjustment);
                    this.this$0.getFocusRequester().requestFocus();
                    this.this$0.setShowToolbar$foundation_release(false);
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateSelectAll$foundation_release(new Function2<Boolean, Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Number) obj2).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, long j) {
                SelectionManager selectionManager = this.this$0;
                Pair<Selection, Map<Long, Selection>> selectAll$foundation_release = selectionManager.selectAll$foundation_release(j, selectionManager.getSelection());
                Selection component1 = selectAll$foundation_release.component1();
                Map component2 = selectAll$foundation_release.component2();
                if (!Intrinsics.areEqual((Object) component1, (Object) this.this$0.getSelection())) {
                    this.this$0.selectionRegistrar.setSubselections(component2);
                    this.this$0.getOnSelectionChange().invoke(component1);
                }
                this.this$0.setInTouchMode(z);
                this.this$0.getFocusRequester().requestFocus();
                this.this$0.setShowToolbar$foundation_release(false);
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateCallback$foundation_release(new Function6<Boolean, LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return m1270invokepGV3PM0(((Boolean) obj).booleanValue(), (LayoutCoordinates) obj2, ((Offset) obj3).m3572unboximpl(), ((Offset) obj4).m3572unboximpl(), ((Boolean) obj5).booleanValue(), (SelectionAdjustment) obj6);
            }

            /* renamed from: invoke-pGV3PM0  reason: not valid java name */
            public final Boolean m1270invokepGV3PM0(boolean z, LayoutCoordinates layoutCoordinates, long j, long j2, boolean z2, SelectionAdjustment selectionAdjustment) {
                long r10 = this.this$0.m1253convertToContainerCoordinatesR5De75A(layoutCoordinates, j);
                long r3 = this.this$0.m1253convertToContainerCoordinatesR5De75A(layoutCoordinates, j2);
                this.this$0.setInTouchMode(z);
                return Boolean.valueOf(this.this$0.m1268updateSelectionqNKwrvQ$foundation_release(Offset.m3551boximpl(r10), r3, z2, selectionAdjustment));
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateEndCallback$foundation_release(new Function0<Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.setShowToolbar$foundation_release(true);
                this.this$0.setDraggingHandle((Handle) null);
                this.this$0.m1255setCurrentDragPosition_kEHs6E((Offset) null);
            }
        });
        selectionRegistrarImpl.setOnSelectableChangeCallback$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                if (this.this$0.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j))) {
                    this.this$0.onRelease();
                    this.this$0.setSelection((Selection) null);
                }
            }
        });
        selectionRegistrarImpl.setAfterSelectableUnsubscribe$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                Selection.AnchorInfo end;
                Selection.AnchorInfo start;
                Selection selection = this.this$0.getSelection();
                if (!(selection == null || (start = selection.getStart()) == null || j != start.getSelectableId())) {
                    this.this$0.m1259setStartHandlePosition_kEHs6E((Offset) null);
                }
                Selection selection2 = this.this$0.getSelection();
                if (!(selection2 == null || (end = selection2.getEnd()) == null || j != end.getSelectableId())) {
                    this.this$0.m1258setEndHandlePosition_kEHs6E((Offset) null);
                }
                if (this.this$0.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j))) {
                    this.this$0.updateSelectionToolbar();
                }
            }
        });
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    public final void setSelection(Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final boolean isInTouchMode() {
        return this._isInTouchMode.getValue().booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        if (this._isInTouchMode.getValue().booleanValue() != z) {
            this._isInTouchMode.setValue(Boolean.valueOf(z));
            updateSelectionToolbar();
        }
    }

    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final void setOnSelectionChange(Function1<? super Selection, Unit> function1) {
        this.onSelectionChange = new SelectionManager$onSelectionChange$2(this, function1);
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final void setClipboardManager(ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester2) {
        this.focusRequester = focusRequester2;
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final Modifier getModifier() {
        return KeyInputModifierKt.onKeyEvent(SelectionGesturesKt.updateSelectionTouchMode(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(Modifier.Companion, new SelectionManager$modifier$1(this)), new SelectionManager$modifier$2(this)), this.focusRequester), new SelectionManager$modifier$3(this)), false, (MutableInteractionSource) null, 3, (Object) null), new SelectionManager$modifier$4(this)), new SelectionManager$modifier$5(this)).then(getShouldShowMagnifier() ? SelectionManager_androidKt.selectionMagnifier(Modifier.Companion, this) : Modifier.Companion);
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.containerLayoutCoordinates = layoutCoordinates;
        if (getHasFocus() && getSelection() != null) {
            Offset r3 = layoutCoordinates != null ? Offset.m3551boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates)) : null;
            if (!Intrinsics.areEqual((Object) this.previousPosition, (Object) r3)) {
                this.previousPosition = r3;
                updateHandleOffsets();
                updateSelectionToolbar();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setDragBeginPosition-k-4lQ0M  reason: not valid java name */
    public final void m1256setDragBeginPositionk4lQ0M(long j) {
        this.dragBeginPosition$delegate.setValue(Offset.m3551boximpl(j));
    }

    /* renamed from: getDragBeginPosition-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m1263getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition$delegate.getValue()).m3572unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: setDragTotalDistance-k-4lQ0M  reason: not valid java name */
    public final void m1257setDragTotalDistancek4lQ0M(long j) {
        this.dragTotalDistance$delegate.setValue(Offset.m3551boximpl(j));
    }

    /* renamed from: getDragTotalDistance-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m1264getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance$delegate.getValue()).m3572unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m1259setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition$delegate.setValue(offset);
    }

    /* renamed from: getStartHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m1266getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m1258setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition$delegate.setValue(offset);
    }

    /* renamed from: getEndHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m1265getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E  reason: not valid java name */
    public final void m1255setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1262getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    private final boolean getShouldShowMagnifier() {
        return getDraggingHandle() != null && isInTouchMode() && !isTriviallyCollapsedSelection$foundation_release();
    }

    public final SelectionLayout getPreviousSelectionLayout$foundation_release() {
        return this.previousSelectionLayout;
    }

    public final void setPreviousSelectionLayout$foundation_release(SelectionLayout selectionLayout) {
        this.previousSelectionLayout = selectionLayout;
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo anchorInfo) {
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(anchorInfo.getSelectableId()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r3 = r0.getStart();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006c, code lost:
        if (androidx.compose.foundation.text.selection.SelectionManagerKt.m1277containsInclusiveUv8p0NA(r7, r8) == false) goto L_0x006f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateHandleOffsets() {
        /*
            r11 = this;
            androidx.compose.foundation.text.selection.Selection r0 = r11.getSelection()
            androidx.compose.ui.layout.LayoutCoordinates r1 = r11.containerLayoutCoordinates
            r2 = 0
            if (r0 == 0) goto L_0x0014
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r0.getStart()
            if (r3 == 0) goto L_0x0014
            androidx.compose.foundation.text.selection.Selectable r3 = r11.getAnchorSelectable$foundation_release(r3)
            goto L_0x0015
        L_0x0014:
            r3 = r2
        L_0x0015:
            if (r0 == 0) goto L_0x0022
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r4 = r0.getEnd()
            if (r4 == 0) goto L_0x0022
            androidx.compose.foundation.text.selection.Selectable r4 = r11.getAnchorSelectable$foundation_release(r4)
            goto L_0x0023
        L_0x0022:
            r4 = r2
        L_0x0023:
            if (r3 == 0) goto L_0x002a
            androidx.compose.ui.layout.LayoutCoordinates r5 = r3.getLayoutCoordinates()
            goto L_0x002b
        L_0x002a:
            r5 = r2
        L_0x002b:
            if (r4 == 0) goto L_0x0032
            androidx.compose.ui.layout.LayoutCoordinates r6 = r4.getLayoutCoordinates()
            goto L_0x0033
        L_0x0032:
            r6 = r2
        L_0x0033:
            if (r0 == 0) goto L_0x00a0
            if (r1 == 0) goto L_0x00a0
            boolean r7 = r1.isAttached()
            if (r7 == 0) goto L_0x00a0
            if (r5 != 0) goto L_0x0042
            if (r6 != 0) goto L_0x0042
            goto L_0x00a0
        L_0x0042:
            androidx.compose.ui.geometry.Rect r7 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r1)
            if (r5 == 0) goto L_0x006f
            r8 = 1
            long r8 = r3.m1223getHandlePositiondBAh8RU(r0, r8)
            boolean r3 = androidx.compose.ui.geometry.OffsetKt.m3583isUnspecifiedk4lQ0M(r8)
            if (r3 == 0) goto L_0x0054
            goto L_0x006f
        L_0x0054:
            long r8 = r1.m5319localPositionOfR5De75A(r5, r8)
            androidx.compose.ui.geometry.Offset r3 = androidx.compose.ui.geometry.Offset.m3551boximpl(r8)
            long r8 = r3.m3572unboximpl()
            androidx.compose.foundation.text.Handle r5 = r11.getDraggingHandle()
            androidx.compose.foundation.text.Handle r10 = androidx.compose.foundation.text.Handle.SelectionStart
            if (r5 == r10) goto L_0x0070
            boolean r5 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1277containsInclusiveUv8p0NA(r7, r8)
            if (r5 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r3 = r2
        L_0x0070:
            r11.m1259setStartHandlePosition_kEHs6E(r3)
            if (r6 == 0) goto L_0x009c
            r3 = 0
            long r3 = r4.m1223getHandlePositiondBAh8RU(r0, r3)
            boolean r0 = androidx.compose.ui.geometry.OffsetKt.m3583isUnspecifiedk4lQ0M(r3)
            if (r0 == 0) goto L_0x0081
            goto L_0x009c
        L_0x0081:
            long r0 = r1.m5319localPositionOfR5De75A(r6, r3)
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m3551boximpl(r0)
            long r3 = r0.m3572unboximpl()
            androidx.compose.foundation.text.Handle r1 = r11.getDraggingHandle()
            androidx.compose.foundation.text.Handle r5 = androidx.compose.foundation.text.Handle.SelectionEnd
            if (r1 == r5) goto L_0x009b
            boolean r1 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1277containsInclusiveUv8p0NA(r7, r3)
            if (r1 == 0) goto L_0x009c
        L_0x009b:
            r2 = r0
        L_0x009c:
            r11.m1258setEndHandlePosition_kEHs6E(r2)
            return
        L_0x00a0:
            r11.m1259setStartHandlePosition_kEHs6E(r2)
            r11.m1258setEndHandlePosition_kEHs6E(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.updateHandleOffsets():void");
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (layoutCoordinates == null) {
            throw new IllegalArgumentException("null coordinates".toString());
        } else if (layoutCoordinates.isAttached()) {
            return layoutCoordinates;
        } else {
            throw new IllegalArgumentException("unattached coordinates".toString());
        }
    }

    public final Pair<Selection, Map<Long, Selection>> selectAll$foundation_release(long j, Selection selection) {
        HapticFeedback hapticFeedback;
        Map linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection2 = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selectAllSelection = selectable.getSelectableId() == j ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selectAllSelection);
            }
            selection2 = SelectionManagerKt.merge(selection2, selectAllSelection);
        }
        if (isInTouchMode() && !Intrinsics.areEqual((Object) selection2, (Object) selection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.m4617performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4626getTextHandleMove5zf0vsI());
        }
        return new Pair<>(selection2, linkedHashMap);
    }

    public final boolean isTriviallyCollapsedSelection$foundation_release() {
        Selection selection = getSelection();
        if (selection == null) {
            return true;
        }
        return Intrinsics.areEqual((Object) selection.getStart(), (Object) selection.getEnd());
    }

    public final boolean isNonEmptySelection$foundation_release() {
        Selection selection = getSelection();
        if (selection == null || Intrinsics.areEqual((Object) selection.getStart(), (Object) selection.getEnd())) {
            return false;
        }
        if (selection.getStart().getSelectableId() == selection.getEnd().getSelectableId()) {
            return true;
        }
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selection selection2 = this.selectionRegistrar.getSubselections().get(Long.valueOf(sort.get(i).getSelectableId()));
            if (selection2 != null && selection2.getStart().getOffset() != selection2.getEnd().getOffset()) {
                return true;
            }
        }
        return false;
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString annotatedString;
        if (getSelection() == null || this.selectionRegistrar.getSubselections().isEmpty()) {
            return null;
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selection = this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId()));
            if (selection != null) {
                AnnotatedString text = selectable.getText();
                if (selection.getHandlesCrossed()) {
                    annotatedString = text.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset());
                } else {
                    annotatedString = text.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset());
                }
                builder.append(annotatedString);
            }
        }
        return builder.toAnnotatedString();
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager2;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release != null) {
            if (selectedText$foundation_release.length() <= 0) {
                selectedText$foundation_release = null;
            }
            if (selectedText$foundation_release != null && (clipboardManager2 = this.clipboardManager) != null) {
                clipboardManager2.setText(selectedText$foundation_release);
            }
        }
    }

    public final boolean getShowToolbar$foundation_release() {
        return this.showToolbar;
    }

    public final void setShowToolbar$foundation_release(boolean z) {
        this.showToolbar = z;
        updateSelectionToolbar();
    }

    /* access modifiers changed from: private */
    public final void toolbarCopy() {
        copy$foundation_release();
        onRelease();
    }

    /* access modifiers changed from: private */
    public final void updateSelectionToolbar() {
        TextToolbar textToolbar2;
        if (!getHasFocus() || (textToolbar2 = this.textToolbar) == null) {
            return;
        }
        if (this.showToolbar && isInTouchMode() && isNonEmptySelection$foundation_release()) {
            Rect contentRect = getContentRect();
            if (contentRect != null) {
                TextToolbar.CC.showMenu$default(textToolbar2, contentRect, new SelectionManager$updateSelectionToolbar$1(this), (Function0) null, (Function0) null, (Function0) null, 28, (Object) null);
            }
        } else if (textToolbar2.getStatus() == TextToolbarStatus.Shown) {
            textToolbar2.hide();
        }
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        Pair pair;
        if (getSelection() == null || (layoutCoordinates = this.containerLayoutCoordinates) == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        ArrayList arrayList = new ArrayList(sort.size());
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selection = this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId()));
            if (selection != null) {
                pair = TuplesKt.to(selectable, selection);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        List access$firstAndLast = SelectionManagerKt.firstAndLast(arrayList);
        if (access$firstAndLast.isEmpty()) {
            return null;
        }
        Rect selectedRegionRect = SelectionManagerKt.getSelectedRegionRect(access$firstAndLast, layoutCoordinates);
        if (Intrinsics.areEqual((Object) selectedRegionRect, (Object) SelectionManagerKt.invertedInfiniteRect)) {
            return null;
        }
        Rect intersect = SelectionManagerKt.visibleBounds(layoutCoordinates).intersect(selectedRegionRect);
        if (intersect.getWidth() < 0.0f || intersect.getHeight() < 0.0f) {
            return null;
        }
        return Rect.copy$default(intersect.m3599translatek4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates)), 0.0f, 0.0f, 0.0f, intersect.getBottom() + (SelectionHandlesKt.getHandleHeight() * ((float) 4)), 7, (Object) null);
    }

    public final void onRelease() {
        HapticFeedback hapticFeedback;
        this.selectionRegistrar.setSubselections(MapsKt.emptyMap());
        setShowToolbar$foundation_release(false);
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            if (isInTouchMode() && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.m4617performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4626getTextHandleMove5zf0vsI());
            }
        }
    }

    public final TextDragObserver handleDragObserver(boolean z) {
        return new SelectionManager$handleDragObserver$1(z, this);
    }

    /* access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new SelectionManager$detectNonConsumingTap$2(function1, (Continuation<? super SelectionManager$detectNonConsumingTap$2>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, Function0<Unit> function0) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionManager$onClearSelectionRequested$1(this, function0, (Continuation<? super SelectionManager$onClearSelectionRequested$1>) null)) : modifier;
    }

    /* access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-R5De75A  reason: not valid java name */
    public final long m1253convertToContainerCoordinatesR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        return requireContainerCoordinates$foundation_release().m5319localPositionOfR5De75A(layoutCoordinates, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo  reason: not valid java name */
    public final void m1260startSelection9KIMszo(long j, boolean z, SelectionAdjustment selectionAdjustment) {
        this.previousSelectionLayout = null;
        m1267updateSelectionjyLRC_s$foundation_release(j, Offset.Companion.m3577getUnspecifiedF1C5BW0(), z, selectionAdjustment);
    }

    /* renamed from: updateSelection-qNKwrvQ$foundation_release  reason: not valid java name */
    public final boolean m1268updateSelectionqNKwrvQ$foundation_release(Offset offset, long j, boolean z, SelectionAdjustment selectionAdjustment) {
        if (offset == null) {
            return false;
        }
        return m1267updateSelectionjyLRC_s$foundation_release(offset.m3572unboximpl(), j, z, selectionAdjustment);
    }

    /* renamed from: updateSelection-jyLRC_s$foundation_release  reason: not valid java name */
    public final boolean m1267updateSelectionjyLRC_s$foundation_release(long j, long j2, boolean z, SelectionAdjustment selectionAdjustment) {
        setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
        m1255setCurrentDragPosition_kEHs6E(Offset.m3551boximpl(j));
        SelectionLayout r2 = m1254getSelectionLayoutWko1d7g(j, j2, z);
        if (!r2.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return false;
        }
        Selection adjust = selectionAdjustment.adjust(r2);
        if (!Intrinsics.areEqual((Object) adjust, (Object) getSelection())) {
            selectionChanged(r2, adjust);
        }
        this.previousSelectionLayout = r2;
        return true;
    }

    /* renamed from: getSelectionLayout-Wko1d7g  reason: not valid java name */
    private final SelectionLayout m1254getSelectionLayoutWko1d7g(long j, long j2, boolean z) {
        LayoutCoordinates requireContainerCoordinates$foundation_release = requireContainerCoordinates$foundation_release();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release);
        Map linkedHashMap = new LinkedHashMap();
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            linkedHashMap.put(Long.valueOf(sort.get(i).getSelectableId()), Integer.valueOf(i));
        }
        SelectionLayoutBuilder selectionLayoutBuilder = new SelectionLayoutBuilder(j, j2, requireContainerCoordinates$foundation_release, z, OffsetKt.m3583isUnspecifiedk4lQ0M(j2) ? null : getSelection(), new SelectionManager$getSelectionLayoutWko1d7g$$inlined$compareBy$1(linkedHashMap), (DefaultConstructorMarker) null);
        int size2 = sort.size();
        for (int i2 = 0; i2 < size2; i2++) {
            sort.get(i2).appendSelectableInfoToBuilder(selectionLayoutBuilder);
        }
        return selectionLayoutBuilder.build();
    }

    private final void selectionChanged(SelectionLayout selectionLayout, Selection selection) {
        HapticFeedback hapticFeedback;
        if (shouldPerformHaptics$foundation_release() && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.m4617performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4626getTextHandleMove5zf0vsI());
        }
        this.selectionRegistrar.setSubselections(selectionLayout.createSubSelections(selection));
        this.onSelectionChange.invoke(selection);
    }

    public final boolean shouldPerformHaptics$foundation_release() {
        if (!isInTouchMode()) {
            return false;
        }
        List<Selectable> selectables$foundation_release = this.selectionRegistrar.getSelectables$foundation_release();
        int size = selectables$foundation_release.size();
        for (int i = 0; i < size; i++) {
            if (selectables$foundation_release.get(i).getText().length() > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M  reason: not valid java name */
    public final void m1261contextMenuOpenAdjustmentk4lQ0M(long j) {
        Selection selection = getSelection();
        if (selection != null ? TextRange.m6036getCollapsedimpl(selection.m1225toTextRanged9O1mEE()) : true) {
            m1260startSelection9KIMszo(j, true, SelectionAdjustment.Companion.getWord());
        }
    }
}
