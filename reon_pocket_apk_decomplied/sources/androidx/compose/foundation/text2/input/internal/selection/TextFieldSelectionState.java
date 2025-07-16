package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.foundation.text2.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020[2\b\b\u0002\u0010]\u001a\u00020\tJ\u0006\u0010^\u001a\u00020[J\u0006\u0010_\u001a\u00020[J\u0006\u0010`\u001a\u00020[J\b\u0010a\u001a\u00020\u001eH\u0002J\u001d\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\tH\u0002J<\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020:2\u0006\u0010j\u001a\u00020:2\b\u0010k\u001a\u0004\u0018\u00010h2\u0006\u0010c\u001a\u00020\t2\u0006\u0010l\u001a\u00020mH\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001a\u00020[H\u0002J\b\u0010q\u001a\u00020[H\u0002J\u000e\u0010r\u001a\u00020[H@¢\u0006\u0002\u0010sJ\u000e\u0010t\u001a\u00020[H@¢\u0006\u0002\u0010sJ\u000e\u0010u\u001a\u00020[H@¢\u0006\u0002\u0010sJ\u0006\u0010v\u001a\u00020[J\u0010\u0010w\u001a\u00020[2\u0006\u0010x\u001a\u00020\u001eH\u0002J6\u0010y\u001a\u00020[2\u0006\u00102\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\"\u0010z\u001a\u00020[2\u0006\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b}\u0010~JN\u0010\u001a\u00020h2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020:2\u0006\u0010c\u001a\u00020\t2\u0006\u0010l\u001a\u00020m2\t\b\u0002\u0010\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0001\u001a\u00020[2\u0006\u0010T\u001a\u00020SJ\u0015\u0010\u0001\u001a\u00020[*\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020[*\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u00020[*\u00030\u00012\u0006\u0010c\u001a\u00020\tH@¢\u0006\u0003\u0010\u0001J%\u0010\u0001\u001a\u00020[*\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0001H@¢\u0006\u0003\u0010\u0001J5\u0010\u0001\u001a\u00020[*\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0001H@¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020[*\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u00020[*\u00030\u00012\u0006\u0010c\u001a\u00020\tH@¢\u0006\u0003\u0010\u0001J5\u0010\u0001\u001a\u00020[*\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0001H@¢\u0006\u0003\u0010\u0001R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u00108BX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b.\u0010\u0016R\u0017\u00100\u001a\u00020\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u0010\u0012R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b4\u00105R+\u00106\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8F@BX\u0002¢\u0006\u0012\n\u0004\b8\u0010*\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u00105R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R1\u0010=\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bA\u0010*\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010@R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R+\u0010B\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\bE\u0010*\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u00105R1\u0010F\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bI\u0010*\u001a\u0004\bG\u0010\u0012\"\u0004\bH\u0010@R\u001b\u0010J\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\bL\u0010\u0018\u001a\u0004\bK\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\u0004\u0018\u00010N8BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R+\u0010T\u001a\u00020S2\u0006\u0010\"\u001a\u00020S8B@BX\u0002¢\u0006\u0012\n\u0004\bY\u0010*\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZ)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "currentContentVisibleOffset", "Landroidx/compose/ui/geometry/Offset;", "getCurrentContentVisibleOffset-F1C5BW0", "()J", "cursorHandle", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "getCursorHandle", "()Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "cursorHandle$delegate", "Landroidx/compose/runtime/State;", "cursorHandleInBounds", "getCursorHandleInBounds", "()Z", "cursorHandleInBounds$delegate", "cursorRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorRect", "()Landroidx/compose/ui/geometry/Rect;", "cursorRect$delegate", "<set-?>", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/runtime/MutableState;", "editable", "getEditable", "endSelectionHandle", "getEndSelectionHandle", "endSelectionHandle$delegate", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startContentVisibleOffset", "getStartContentVisibleOffset-F1C5BW0", "setStartContentVisibleOffset-k-4lQ0M", "startContentVisibleOffset$delegate", "startSelectionHandle", "getStartSelectionHandle", "startSelectionHandle$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "clearHandleDragging", "", "copy", "cancelSelection", "cut", "deselect", "dispose", "getContentRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "markStartContentVisibleOffset", "observeChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTextChanges", "observeTextToolbarVisibility", "paste", "showTextToolbar", "contentRect", "update", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "updateSelection-QNhciaU", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldLongPressAndAfterDrag", "requestFocus", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldGestures", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private final State cursorHandle$delegate = SnapshotStateKt.derivedStateOf(new TextFieldSelectionState$cursorHandle$2(this));
    private final State cursorHandleInBounds$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new TextFieldSelectionState$cursorHandleInBounds$2(this));
    private final State cursorRect$delegate = SnapshotStateKt.derivedStateOf(new TextFieldSelectionState$cursorRect$2(this));
    /* access modifiers changed from: private */
    public Density density;
    private final MutableState draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private boolean enabled;
    private final State endSelectionHandle$delegate = SnapshotStateKt.derivedStateOf(new TextFieldSelectionState$endSelectionHandle$2(this));
    /* access modifiers changed from: private */
    public HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private final MutableState isInTouchMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public int previousRawDragOffset = -1;
    private SelectionLayout previousSelectionLayout;
    private final MutableState rawHandleDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3551boximpl(Offset.Companion.m3577getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private boolean readOnly;
    private final MutableState showCursorHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState startContentVisibleOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3551boximpl(Offset.Companion.m3577getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final State startSelectionHandle$delegate = SnapshotStateKt.derivedStateOf(new TextFieldSelectionState$startSelectionHandle$2(this));
    /* access modifiers changed from: private */
    public final TransformedTextFieldState textFieldState;
    /* access modifiers changed from: private */
    public final TextLayoutState textLayoutState;
    private TextToolbar textToolbar;
    private final MutableState textToolbarState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, (SnapshotMutationPolicy) null, 2, (Object) null);

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, Density density2, boolean z, boolean z2, boolean z3) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState2;
        this.density = density2;
        this.enabled = z;
        this.readOnly = z2;
        this.isFocused = z3;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    /* access modifiers changed from: private */
    public final void setInTouchMode(boolean z) {
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode$delegate.getValue()).booleanValue();
    }

    /* renamed from: getStartContentVisibleOffset-F1C5BW0  reason: not valid java name */
    private final long m1455getStartContentVisibleOffsetF1C5BW0() {
        return ((Offset) this.startContentVisibleOffset$delegate.getValue()).m3572unboximpl();
    }

    /* renamed from: setStartContentVisibleOffset-k-4lQ0M  reason: not valid java name */
    private final void m1458setStartContentVisibleOffsetk4lQ0M(long j) {
        this.startContentVisibleOffset$delegate.setValue(Offset.m3551boximpl(j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0);
     */
    /* renamed from: getCurrentContentVisibleOffset-F1C5BW0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m1452getCurrentContentVisibleOffsetF1C5BW0() {
        /*
            r2 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r2.getTextLayoutCoordinates()
            if (r0 == 0) goto L_0x0011
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)
            if (r0 == 0) goto L_0x0011
            long r0 = r0.m3597getTopLeftF1C5BW0()
            goto L_0x0017
        L_0x0011:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3577getUnspecifiedF1C5BW0()
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.m1452getCurrentContentVisibleOffsetF1C5BW0():long");
    }

    /* renamed from: getRawHandleDragPosition-F1C5BW0  reason: not valid java name */
    private final long m1454getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition$delegate.getValue()).m3572unboximpl();
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M  reason: not valid java name */
    private final void m1457setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition$delegate.setValue(Offset.m3551boximpl(j));
    }

    /* renamed from: getHandleDragPosition-F1C5BW0  reason: not valid java name */
    public final long m1462getHandleDragPositionF1C5BW0() {
        if (OffsetKt.m3583isUnspecifiedk4lQ0M(m1454getRawHandleDragPositionF1C5BW0())) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        if (OffsetKt.m3583isUnspecifiedk4lQ0M(m1455getStartContentVisibleOffsetF1C5BW0())) {
            return TextLayoutStateKt.m1420fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1454getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m3566minusMKHz9U(Offset.m3567plusMKHz9U(m1454getRawHandleDragPositionF1C5BW0(), m1452getCurrentContentVisibleOffsetF1C5BW0()), m1455getStartContentVisibleOffsetF1C5BW0());
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    /* access modifiers changed from: private */
    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState$delegate.setValue(textToolbarState);
    }

    /* access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    /* access modifiers changed from: private */
    public final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    public final TextFieldHandleState getCursorHandle() {
        return (TextFieldHandleState) this.cursorHandle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean getCursorHandleInBounds() {
        return ((Boolean) this.cursorHandleInBounds$delegate.getValue()).booleanValue();
    }

    public final Rect getCursorRect() {
        return (Rect) this.cursorRect$delegate.getValue();
    }

    public final TextFieldHandleState getStartSelectionHandle() {
        return (TextFieldHandleState) this.startSelectionHandle$delegate.getValue();
    }

    public final TextFieldHandleState getEndSelectionHandle() {
        return (TextFieldHandleState) this.endSelectionHandle$delegate.getValue();
    }

    public final void update(HapticFeedback hapticFeedback, ClipboardManager clipboardManager2, TextToolbar textToolbar2, Density density2, boolean z, boolean z2) {
        if (!z) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedback;
        this.clipboardManager = clipboardManager2;
        this.textToolbar = textToolbar2;
        this.density = density2;
        this.enabled = z;
        this.readOnly = z2;
    }

    public final Object cursorHandleGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$cursorHandleGestures$2(this, pointerInputScope, (Continuation<? super TextFieldSelectionState$cursorHandleGestures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object textFieldGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$textFieldGestures$2(this, pointerInputScope, function0, function02, (Continuation<? super TextFieldSelectionState$textFieldGestures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object selectionHandleGestures(PointerInputScope pointerInputScope, boolean z, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$selectionHandleGestures$2(this, pointerInputScope, z, (Continuation<? super TextFieldSelectionState$selectionHandleGestures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object observeChanges(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002f }
            goto L_0x0050
        L_0x002f:
            r6 = move-exception
            goto L_0x0063
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2 r6 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2     // Catch:{ all -> 0x0061 }
            r2 = 0
            r6.<init>(r5, r2)     // Catch:{ all -> 0x0061 }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ all -> 0x0061 }
            r0.L$0 = r5     // Catch:{ all -> 0x0061 }
            r0.label = r4     // Catch:{ all -> 0x0061 }
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)     // Catch:{ all -> 0x0061 }
            if (r6 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r5
        L_0x0050:
            r0.setShowCursorHandle(r3)
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r6 = r0.getTextToolbarState()
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.None
            if (r6 == r1) goto L_0x005e
            r0.hideTextToolbar()
        L_0x005e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0061:
            r6 = move-exception
            r0 = r5
        L_0x0063:
            r0.setShowCursorHandle(r3)
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r1 = r0.getTextToolbarState()
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r2 = androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.None
            if (r1 == r2) goto L_0x0071
            r0.hideTextToolbar()
        L_0x0071:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.observeChanges(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.textToolbar = null;
        this.clipboardManager = null;
        this.hapticFeedBack = null;
    }

    /* access modifiers changed from: private */
    public final Object detectTouchMode(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TextFieldSelectionState$detectTouchMode$2(this, (Continuation<? super TextFieldSelectionState$detectTouchMode$2>) null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object detectTapAndDoubleTap = TapAndDoubleTapGestureKt.detectTapAndDoubleTap(pointerInputScope, new TextFieldSelectionState$detectTextFieldTapGestures$2(function0, this, function02), new TextFieldSelectionState$detectTextFieldTapGestures$3(this), continuation);
        return detectTapAndDoubleTap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndDoubleTap : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            r0.<init>(r9, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0042
            if (r1 != r2) goto L_0x003a
            java.lang.Object r10 = r6.L$2
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r0 = r6.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r6.L$0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r1 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState) r1
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0037 }
            goto L_0x0096
        L_0x0037:
            r11 = move-exception
            goto L_0x00a1
        L_0x003a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.internal.Ref$LongRef r11 = new kotlin.jvm.internal.Ref$LongRef
            r11.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r3 = r1.m3577getUnspecifiedF1C5BW0()
            r11.element = r3
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r3 = r1.m3577getUnspecifiedF1C5BW0()
            r7.element = r3
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2     // Catch:{ all -> 0x009c }
            r1.<init>(r11, r9, r7)     // Catch:{ all -> 0x009c }
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x009c }
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3     // Catch:{ all -> 0x009c }
            r1.<init>(r11, r7, r9)     // Catch:{ all -> 0x009c }
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch:{ all -> 0x009c }
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4     // Catch:{ all -> 0x009c }
            r1.<init>(r11, r7, r9)     // Catch:{ all -> 0x009c }
            r5 = r1
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x009c }
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5     // Catch:{ all -> 0x009c }
            r1.<init>(r7, r9, r11)     // Catch:{ all -> 0x009c }
            r8 = r1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch:{ all -> 0x009c }
            r6.L$0 = r9     // Catch:{ all -> 0x009c }
            r6.L$1 = r11     // Catch:{ all -> 0x009c }
            r6.L$2 = r7     // Catch:{ all -> 0x009c }
            r6.label = r2     // Catch:{ all -> 0x009c }
            r1 = r10
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            java.lang.Object r10 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x009c }
            if (r10 != r0) goto L_0x0093
            return r0
        L_0x0093:
            r1 = r9
            r0 = r11
            r10 = r7
        L_0x0096:
            detectCursorHandleDragGestures$onDragStop(r0, r10, r1)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x009c:
            r10 = move-exception
            r1 = r9
            r0 = r11
            r11 = r10
            r10 = r7
        L_0x00a1:
            detectCursorHandleDragGestures$onDragStop(r0, r10, r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if (OffsetKt.m3581isSpecifiedk4lQ0M(longRef.element)) {
            longRef.element = Offset.Companion.m3577getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m3577getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    /* access modifiers changed from: private */
    public final Object detectTextFieldLongPressAndAfterDrag(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.Companion.m3577getUnspecifiedF1C5BW0();
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = Offset.Companion.m3578getZeroF1C5BW0();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Handle.SelectionEnd;
        Object detectDragGesturesAfterLongPress = DragGestureDetectorKt.detectDragGesturesAfterLongPress(pointerInputScope, new TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$2(function0, this, objectRef, longRef, longRef2, intRef), new TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$3(longRef, this, intRef, longRef2), new TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$4(longRef, this, intRef, longRef2), new TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$5(this, longRef2, longRef, intRef, objectRef), continuation);
        return detectDragGesturesAfterLongPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGesturesAfterLongPress : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void detectTextFieldLongPressAndAfterDrag$onDragStop$1(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.IntRef intRef, Ref.LongRef longRef2) {
        if (OffsetKt.m3581isSpecifiedk4lQ0M(longRef.element)) {
            textFieldSelectionState.clearHandleDragging();
            intRef.element = -1;
            longRef.element = Offset.Companion.m3577getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m3578getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r18, boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r17 = this;
            r7 = r17
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1 r1 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1 r1 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1
            r1.<init>(r7, r0)
        L_0x001d:
            r13 = r1
            java.lang.Object r0 = r13.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r8 = 1
            if (r1 == 0) goto L_0x004b
            if (r1 != r8) goto L_0x0043
            java.lang.Object r1 = r13.L$3
            androidx.compose.foundation.text.Handle r1 = (androidx.compose.foundation.text.Handle) r1
            java.lang.Object r2 = r13.L$2
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r3 = r13.L$1
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r4 = r13.L$0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r4 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0040 }
            goto L_0x00bc
        L_0x0040:
            r0 = move-exception
            goto L_0x00db
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3577getUnspecifiedF1C5BW0()
            r15.element = r0
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r12.element = r0
            if (r19 == 0) goto L_0x006d
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionStart
            goto L_0x006f
        L_0x006d:
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionEnd
        L_0x006f:
            r11 = r0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$2 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$2     // Catch:{ all -> 0x00d4 }
            r1 = r0
            r2 = r15
            r3 = r17
            r4 = r19
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00d4 }
            r9 = r0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9     // Catch:{ all -> 0x00d4 }
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$3 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$3     // Catch:{ all -> 0x00d4 }
            r0.<init>(r15, r7, r12)     // Catch:{ all -> 0x00d4 }
            r10 = r0
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10     // Catch:{ all -> 0x00d4 }
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$4 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$4     // Catch:{ all -> 0x00d4 }
            r0.<init>(r15, r7, r12)     // Catch:{ all -> 0x00d4 }
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0     // Catch:{ all -> 0x00d4 }
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$5 r16 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$5     // Catch:{ all -> 0x00d4 }
            r1 = r16
            r2 = r12
            r3 = r17
            r4 = r11
            r5 = r15
            r6 = r19
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00d4 }
            r1 = r16
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch:{ all -> 0x00d4 }
            r13.L$0 = r7     // Catch:{ all -> 0x00d4 }
            r13.L$1 = r15     // Catch:{ all -> 0x00d4 }
            r13.L$2 = r12     // Catch:{ all -> 0x00d4 }
            r13.L$3 = r11     // Catch:{ all -> 0x00d4 }
            r13.label = r8     // Catch:{ all -> 0x00d4 }
            r8 = r18
            r2 = r11
            r11 = r0
            r3 = r12
            r12 = r1
            java.lang.Object r0 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00d2 }
            if (r0 != r14) goto L_0x00b8
            return r14
        L_0x00b8:
            r1 = r2
            r2 = r3
            r4 = r7
            r3 = r15
        L_0x00bc:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
            r0.<init>(r4, r1)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionStateKt.logDebug(r0)
            androidx.compose.foundation.text.Handle r0 = r4.getDraggingHandle()
            if (r0 != r1) goto L_0x00cf
            detectSelectionHandleDragGestures$onDragStop$2(r3, r4, r2)
        L_0x00cf:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00d2:
            r0 = move-exception
            goto L_0x00d7
        L_0x00d4:
            r0 = move-exception
            r2 = r11
            r3 = r12
        L_0x00d7:
            r1 = r2
            r2 = r3
            r4 = r7
            r3 = r15
        L_0x00db:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6 r5 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
            r5.<init>(r4, r1)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionStateKt.logDebug(r5)
            androidx.compose.foundation.text.Handle r5 = r4.getDraggingHandle()
            if (r5 != r1) goto L_0x00ee
            detectSelectionHandleDragGestures$onDragStop$2(r3, r4, r2)
        L_0x00ee:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$2(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if (OffsetKt.m3581isSpecifiedk4lQ0M(longRef.element)) {
            textFieldSelectionState.clearHandleDragging();
            longRef.element = Offset.Companion.m3577getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m3578getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new TextFieldSelectionState$observeTextChanges$2(this)), TextFieldSelectionState$observeTextChanges$3.INSTANCE), 1).collect(new TextFieldSelectionState$observeTextChanges$4(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new TextFieldSelectionState$observeTextToolbarVisibility$2(this)).collect(new TextFieldSelectionState$observeTextToolbarVisibility$3(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Rect getContentRect() {
        float f;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m6036getCollapsedimpl(text.m1346getSelectionInCharsd9O1mEE())) {
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            return RectKt.m3602Recttz77jQw(textLayoutCoordinates != null ? textLayoutCoordinates.m5320localToRootMKHz9U(getCursorRect().m3597getTopLeftF1C5BW0()) : Offset.Companion.m3578getZeroF1C5BW0(), getCursorRect().m3595getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long r1 = textLayoutCoordinates2 != null ? textLayoutCoordinates2.m5320localToRootMKHz9U(m1453getHandlePositiontuRUvjQ(true)) : Offset.Companion.m3578getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long r3 = textLayoutCoordinates3 != null ? textLayoutCoordinates3.m5320localToRootMKHz9U(m1453getHandlePositiontuRUvjQ(false)) : Offset.Companion.m3578getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float f2 = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            f = Offset.m3563getYimpl(textLayoutCoordinates4.m5320localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m6042getStartimpl(text.m1346getSelectionInCharsd9O1mEE()))) == null) ? 0.0f : cursorRect2.getTop())));
        } else {
            f = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            f2 = Offset.m3563getYimpl(textLayoutCoordinates5.m5320localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m6037getEndimpl(text.m1346getSelectionInCharsd9O1mEE()))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m3562getXimpl(r1), Offset.m3562getXimpl(r3)), Math.min(f, f2), Math.max(Offset.m3562getXimpl(r1), Offset.m3562getXimpl(r3)), Math.max(Offset.m3563getYimpl(r1), Offset.m3563getYimpl(r3)));
    }

    /* access modifiers changed from: private */
    public final TextFieldHandleState getSelectionHandleState(boolean z) {
        Rect visibleBounds;
        Rect visibleBounds2;
        Handle handle = z ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.Companion.getHidden();
        }
        long r2 = this.textFieldState.getText().m1346getSelectionInCharsd9O1mEE();
        if (TextRange.m6036getCollapsedimpl(r2)) {
            return TextFieldHandleState.Companion.getHidden();
        }
        long r4 = m1453getHandlePositiontuRUvjQ(z);
        if (getDraggingHandle() != handle) {
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (!((textLayoutCoordinates == null || (visibleBounds2 = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? false : SelectionManagerKt.m1277containsInclusiveUv8p0NA(visibleBounds2, r4))) {
                return TextFieldHandleState.Companion.getHidden();
            }
        }
        ResolvedTextDirection bidiRunDirection = layoutResult.getBidiRunDirection(z ? TextRange.m6042getStartimpl(r2) : Math.max(TextRange.m6037getEndimpl(r2) - 1, 0));
        boolean r11 = TextRange.m6041getReversedimpl(r2);
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        if (!(textLayoutCoordinates2 == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates2)) == null)) {
            r4 = TextLayoutStateKt.m1419coerceIn3MmeM6k(r4, visibleBounds);
        }
        return new TextFieldHandleState(true, r4, bidiRunDirection, r11, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ  reason: not valid java name */
    public final long m1453getHandlePositiontuRUvjQ(boolean z) {
        int i;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        long r1 = this.textFieldState.getText().m1346getSelectionInCharsd9O1mEE();
        if (z) {
            i = TextRange.m6042getStartimpl(r1);
        } else {
            i = TextRange.m6037getEndimpl(r1);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, i, z, TextRange.m6041getReversedimpl(r1));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateHandleDragging-Uv8p0NA  reason: not valid java name */
    public final void m1459updateHandleDraggingUv8p0NA(Handle handle, long j) {
        setDraggingHandle(handle);
        m1457setRawHandleDragPositionk4lQ0M(j);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void markStartContentVisibleOffset() {
        /*
            r2 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r2.getTextLayoutCoordinates()
            if (r0 == 0) goto L_0x0011
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)
            if (r0 == 0) goto L_0x0011
            long r0 = r0.m3597getTopLeftF1C5BW0()
            goto L_0x0017
        L_0x0011:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3577getUnspecifiedF1C5BW0()
        L_0x0017:
            r2.m1458setStartContentVisibleOffsetk4lQ0M(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.markStartContentVisibleOffset():void");
    }

    /* access modifiers changed from: private */
    public final void clearHandleDragging() {
        setDraggingHandle((Handle) null);
        m1457setRawHandleDragPositionk4lQ0M(Offset.Companion.m3577getUnspecifiedF1C5BW0());
        m1458setStartContentVisibleOffsetk4lQ0M(Offset.Companion.m3577getUnspecifiedF1C5BW0());
    }

    public final void cut() {
        TextFieldCharSequence text = this.textFieldState.getText();
        if (!TextRange.m6036getCollapsedimpl(text.m1346getSelectionInCharsd9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null));
            }
            this.textFieldState.deleteSelectedText();
        }
    }

    public static /* synthetic */ void copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionState.copy(z);
    }

    public final void copy(boolean z) {
        TextFieldCharSequence text = this.textFieldState.getText();
        if (!TextRange.m6036getCollapsedimpl(text.m1346getSelectionInCharsd9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null));
            }
            if (z) {
                this.textFieldState.collapseSelectionToMax();
            }
        }
    }

    public final void paste() {
        AnnotatedString text;
        String text2;
        ClipboardManager clipboardManager2 = this.clipboardManager;
        if (clipboardManager2 != null && (text = clipboardManager2.getText()) != null && (text2 = text.getText()) != null) {
            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, text2, false, TextFieldEditUndoBehavior.NeverMerge, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r2 = r10.clipboardManager;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showTextToolbar(androidx.compose.ui.geometry.Rect r11) {
        /*
            r10 = this;
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r0 = r10.textFieldState
            androidx.compose.foundation.text2.input.TextFieldCharSequence r0 = r0.getText()
            long r0 = r0.m1346getSelectionInCharsd9O1mEE()
            boolean r2 = r10.getEditable()
            r3 = 0
            if (r2 == 0) goto L_0x0025
            androidx.compose.ui.platform.ClipboardManager r2 = r10.clipboardManager
            if (r2 == 0) goto L_0x0025
            boolean r2 = r2.hasText()
            r4 = 1
            if (r2 != r4) goto L_0x0025
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$paste$1 r2 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$paste$1
            r2.<init>(r10)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r7 = r2
            goto L_0x0026
        L_0x0025:
            r7 = r3
        L_0x0026:
            boolean r2 = androidx.compose.ui.text.TextRange.m6036getCollapsedimpl(r0)
            if (r2 != 0) goto L_0x0035
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$copy$1 r2 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$copy$1
            r2.<init>(r10)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r6 = r2
            goto L_0x0036
        L_0x0035:
            r6 = r3
        L_0x0036:
            boolean r2 = androidx.compose.ui.text.TextRange.m6036getCollapsedimpl(r0)
            if (r2 != 0) goto L_0x004b
            boolean r2 = r10.getEditable()
            if (r2 == 0) goto L_0x004b
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$cut$1 r2 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$cut$1
            r2.<init>(r10)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r8 = r2
            goto L_0x004c
        L_0x004b:
            r8 = r3
        L_0x004c:
            int r0 = androidx.compose.ui.text.TextRange.m6038getLengthimpl(r0)
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r1 = r10.textFieldState
            androidx.compose.foundation.text2.input.TextFieldCharSequence r1 = r1.getText()
            int r1 = r1.length()
            if (r0 == r1) goto L_0x0064
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$selectAll$1 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$selectAll$1
            r0.<init>(r10)
            r3 = r0
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
        L_0x0064:
            r9 = r3
            androidx.compose.ui.platform.TextToolbar r4 = r10.textToolbar
            if (r4 == 0) goto L_0x006d
            r5 = r11
            r4.showMenu(r5, r6, r7, r8, r9)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.showTextToolbar(androidx.compose.ui.geometry.Rect):void");
    }

    public final void deselect() {
        if (!TextRange.m6036getCollapsedimpl(this.textFieldState.getText().m1346getSelectionInCharsd9O1mEE())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbar textToolbar2;
        TextToolbar textToolbar3 = this.textToolbar;
        if ((textToolbar3 != null ? textToolbar3.getStatus() : null) == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
            textToolbar2.hide();
        }
    }

    /* renamed from: updateSelection-QNhciaU$default  reason: not valid java name */
    static /* synthetic */ long m1461updateSelectionQNhciaU$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        return textFieldSelectionState.m1460updateSelectionQNhciaU(textFieldCharSequence, i, i2, z, selectionAdjustment, z2);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateSelection-QNhciaU  reason: not valid java name */
    public final long m1460updateSelectionQNhciaU(TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2) {
        HapticFeedback hapticFeedback;
        TextRange r0 = TextRange.m6030boximpl(textFieldCharSequence.m1346getSelectionInCharsd9O1mEE());
        long r1 = r0.m6046unboximpl();
        if (!z2 && TextRange.m6036getCollapsedimpl(r1)) {
            r0 = null;
        }
        long r9 = m1456getTextFieldSelectionqeG_v_k(i, i2, r0, z, selectionAdjustment);
        if (TextRange.m6035equalsimpl0(r9, textFieldCharSequence.m1346getSelectionInCharsd9O1mEE())) {
            return r9;
        }
        boolean z3 = TextRange.m6041getReversedimpl(r9) != TextRange.m6041getReversedimpl(textFieldCharSequence.m1346getSelectionInCharsd9O1mEE()) && TextRange.m6035equalsimpl0(TextRangeKt.TextRange(TextRange.m6037getEndimpl(r9), TextRange.m6042getStartimpl(r9)), textFieldCharSequence.m1346getSelectionInCharsd9O1mEE());
        if (isInTouchMode() && !z3 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.m4617performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4626getTextHandleMove5zf0vsI());
        }
        return r9;
    }

    /* renamed from: getTextFieldSelection-qeG_v_k  reason: not valid java name */
    private final long m1456getTextFieldSelectionqeG_v_k(int i, int i2, TextRange textRange, boolean z, SelectionAdjustment selectionAdjustment) {
        long j;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.Companion.m6047getZerod9O1mEE();
        }
        if (textRange == null && Intrinsics.areEqual((Object) selectionAdjustment, (Object) SelectionAdjustment.Companion.getCharacter())) {
            return TextRangeKt.TextRange(i, i2);
        }
        int i3 = this.previousRawDragOffset;
        if (textRange != null) {
            j = textRange.m6046unboximpl();
        } else {
            j = TextRange.Companion.m6047getZerod9O1mEE();
        }
        SelectionLayout r0 = SelectionLayoutKt.m1240getTextFieldSelectionLayoutRcvTLA(layoutResult, i, i2, i3, j, textRange == null, z);
        if (textRange != null && !r0.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return textRange.m6046unboximpl();
        }
        long r1 = selectionAdjustment.adjust(r0).m1225toTextRanged9O1mEE();
        this.previousSelectionLayout = r0;
        if (!z) {
            i = i2;
        }
        this.previousRawDragOffset = i;
        return r1;
    }
}
