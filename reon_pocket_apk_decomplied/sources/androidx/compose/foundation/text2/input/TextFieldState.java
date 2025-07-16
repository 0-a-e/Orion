package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.TextFieldBuffer;
import androidx.compose.foundation.text2.input.TextUndoManager;
import androidx.compose.foundation.text2.input.internal.ChangeTracker;
import androidx.compose.foundation.text2.input.internal.EditingBuffer;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text2.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text2.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0002JKB\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014H\u0000¢\u0006\u0002\b)J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0001J*\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\"\u00105\u001a\u00020'2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'07¢\u0006\u0002\b8H\bJE\u00109\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'07¢\u0006\u0002\b8H\b¢\u0006\u0002\b:J'\u0010;\u001a\u00020'2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'07¢\u0006\u0002\b8H\b¢\u0006\u0002\b<J\u0018\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0016H\u0002J(\u0010?\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020B2\u0006\u00103\u001a\u000204H\u0002J\u0015\u0010C\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014H\u0000¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0016H\u0001¢\u0006\u0002\bFJ\u0010\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020\u0016H\u0001J\b\u0010I\u001a\u00020\u0003H\u0016R$\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@BX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\"8GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\r\u001a\u0004\b$\u0010%¨\u0006L"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldState;", "", "initialText", "", "initialSelectionInChars", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "initialTextUndoManager", "Landroidx/compose/foundation/text2/input/TextUndoManager;", "(Ljava/lang/String;JLandroidx/compose/foundation/text2/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "mainBuffer", "Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "getMainBuffer$foundation_release$annotations", "()V", "getMainBuffer$foundation_release", "()Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "setMainBuffer$foundation_release", "(Landroidx/compose/foundation/text2/input/internal/EditingBuffer;)V", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text2/input/TextFieldState$NotifyImeListener;", "<set-?>", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "text", "getText", "()Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "setText", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;)V", "text$delegate", "Landroidx/compose/runtime/MutableState;", "textUndoManager", "getTextUndoManager$foundation_release", "()Landroidx/compose/foundation/text2/input/TextUndoManager;", "undoState", "Landroidx/compose/foundation/text2/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text2/input/UndoState;", "addNotifyImeListener", "", "notifyImeListener", "addNotifyImeListener$foundation_release", "commitEdit", "newValue", "Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "commitEditAsUser", "previousValue", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "notifyImeOfChanges", "", "undoBehavior", "Landroidx/compose/foundation/text2/input/internal/undo/TextFieldEditUndoBehavior;", "edit", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "editAsUser", "editAsUser$foundation_release", "editWithNoSideEffects", "editWithNoSideEffects$foundation_release", "notifyIme", "oldValue", "recordEditForUndo", "postValue", "changes", "Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "removeNotifyImeListener", "removeNotifyImeListener$foundation_release", "resetStateAndNotifyIme", "resetStateAndNotifyIme$foundation_release", "startEdit", "value", "toString", "NotifyImeListener", "Saver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldState.kt */
public final class TextFieldState {
    public static final int $stable = 0;
    private EditingBuffer mainBuffer;
    private final MutableVector<NotifyImeListener> notifyImeListeners;
    private final MutableState text$delegate;
    private final TextUndoManager textUndoManager;
    private final UndoState undoState;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "newValue", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldState.kt */
    public interface NotifyImeListener {
        void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldState.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior[] r0 = androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior r1 = androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior.ClearHistory     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior r1 = androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior.MergeIfPossible     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior r1 = androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior.NeverMerge     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.TextFieldState.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ TextFieldState(String str, long j, TextUndoManager textUndoManager2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, textUndoManager2);
    }

    public /* synthetic */ TextFieldState(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    public static /* synthetic */ void getMainBuffer$foundation_release$annotations() {
    }

    public static /* synthetic */ void getUndoState$annotations() {
    }

    private TextFieldState(String str, long j, TextUndoManager textUndoManager2) {
        this.textUndoManager = textUndoManager2;
        this.mainBuffer = new EditingBuffer(str, TextRangeKt.m6048coerceIn8ffj60Q(j, 0, str.length()), (DefaultConstructorMarker) null);
        this.text$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextFieldCharSequenceKt.m1349TextFieldCharSequenceFDrldGo(str, j), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.undoState = new UndoState(this);
        this.notifyImeListeners = new MutableVector<>(new NotifyImeListener[16], 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextFieldState(java.lang.String r1, long r2, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            java.lang.String r1 = ""
        L_0x0006:
            r4 = r4 & 2
            if (r4 == 0) goto L_0x0012
            int r2 = r1.length()
            long r2 = androidx.compose.ui.text.TextRangeKt.TextRange(r2)
        L_0x0012:
            r4 = 0
            r0.<init>((java.lang.String) r1, (long) r2, (kotlin.jvm.internal.DefaultConstructorMarker) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.TextFieldState.<init>(java.lang.String, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextFieldState(String str, long j) {
        this(str, j, new TextUndoManager((TextUndoOperation) null, (UndoManager) null, 3, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
    }

    public final TextUndoManager getTextUndoManager$foundation_release() {
        return this.textUndoManager;
    }

    public final EditingBuffer getMainBuffer$foundation_release() {
        return this.mainBuffer;
    }

    public final void setMainBuffer$foundation_release(EditingBuffer editingBuffer) {
        this.mainBuffer = editingBuffer;
    }

    /* access modifiers changed from: private */
    public final void setText(TextFieldCharSequence textFieldCharSequence) {
        this.text$delegate.setValue(textFieldCharSequence);
    }

    public final TextFieldCharSequence getText() {
        return (TextFieldCharSequence) this.text$delegate.getValue();
    }

    public final void edit(Function1<? super TextFieldBuffer, Unit> function1) {
        TextFieldBuffer startEdit = startEdit(getText());
        function1.invoke(startEdit);
        commitEdit(startEdit);
    }

    public String toString() {
        return "TextFieldState(selectionInChars=" + TextRange.m6045toStringimpl(getText().m1346getSelectionInCharsd9O1mEE()) + ", text=\"" + getText() + "\")";
    }

    public final UndoState getUndoState() {
        return this.undoState;
    }

    public final TextFieldBuffer startEdit(TextFieldCharSequence textFieldCharSequence) {
        return new TextFieldBuffer(textFieldCharSequence, (ChangeTracker) null, (TextFieldCharSequence) null, 6, (DefaultConstructorMarker) null);
    }

    public final void commitEdit(TextFieldBuffer textFieldBuffer) {
        boolean z = textFieldBuffer.getChanges().getChangeCount() > 0;
        boolean z2 = !TextRange.m6035equalsimpl0(textFieldBuffer.m1338getSelectionInCharsd9O1mEE(), this.mainBuffer.m1370getSelectiond9O1mEE());
        if (z || z2) {
            resetStateAndNotifyIme$foundation_release(TextFieldBuffer.m1337toTextFieldCharSequenceOEnZFl4$foundation_release$default(textFieldBuffer, (TextRange) null, 1, (Object) null));
        }
        this.textUndoManager.clearHistory();
    }

    public static /* synthetic */ void editAsUser$foundation_release$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(textFieldState.getMainBuffer$foundation_release());
        if (textFieldState.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), textFieldState.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldState.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            textFieldState.commitEditAsUser(text, inputTransformation, z, textFieldEditUndoBehavior);
        }
    }

    public final void editAsUser$foundation_release(InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1<? super EditingBuffer, Unit> function1) {
        TextFieldCharSequence text = getText();
        getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(getMainBuffer$foundation_release());
        if (getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            commitEditAsUser(text, inputTransformation, z, textFieldEditUndoBehavior);
        }
    }

    public final void editWithNoSideEffects$foundation_release(Function1<? super EditingBuffer, Unit> function1) {
        TextFieldCharSequence text = getText();
        getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(getMainBuffer$foundation_release());
        TextFieldCharSequence r5 = TextFieldCharSequenceKt.m1347TextFieldCharSequence3r_uNRQ(getMainBuffer$foundation_release().toString(), getMainBuffer$foundation_release().m1370getSelectiond9O1mEE(), getMainBuffer$foundation_release().m1369getCompositionMzsxiRA());
        setText(r5);
        notifyIme(text, r5);
    }

    /* access modifiers changed from: private */
    public final void commitEditAsUser(TextFieldCharSequence textFieldCharSequence, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        TextFieldCharSequence r0 = TextFieldCharSequenceKt.m1347TextFieldCharSequence3r_uNRQ(this.mainBuffer.toString(), this.mainBuffer.m1370getSelectiond9O1mEE(), this.mainBuffer.m1369getCompositionMzsxiRA());
        if (inputTransformation == null) {
            TextFieldCharSequence text = getText();
            setText(r0);
            if (z) {
                notifyIme(text, r0);
            }
            recordEditForUndo(textFieldCharSequence, getText(), this.mainBuffer.getChangeTracker(), textFieldEditUndoBehavior);
            return;
        }
        TextFieldCharSequence text2 = getText();
        if (!r0.contentEquals(text2) || !TextRange.m6035equalsimpl0(r0.m1346getSelectionInCharsd9O1mEE(), text2.m1346getSelectionInCharsd9O1mEE())) {
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(r0, this.mainBuffer.getChangeTracker(), text2);
            inputTransformation.transformInput(text2, textFieldBuffer);
            TextFieldCharSequence r8 = textFieldBuffer.m1342toTextFieldCharSequenceOEnZFl4$foundation_release(r0.m1345getCompositionInCharsMzsxiRA());
            if (Intrinsics.areEqual((Object) r8, (Object) r0)) {
                setText(r8);
                if (z) {
                    notifyIme(text2, r0);
                }
            } else {
                resetStateAndNotifyIme$foundation_release(r8);
            }
            recordEditForUndo(textFieldCharSequence, getText(), textFieldBuffer.getChanges(), textFieldEditUndoBehavior);
            return;
        }
        setText(r0);
        if (z) {
            notifyIme(text2, r0);
        }
    }

    private final void recordEditForUndo(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        int i = WhenMappings.$EnumSwitchMapping$0[textFieldEditUndoBehavior.ordinal()];
        if (i == 1) {
            this.textUndoManager.clearHistory();
        } else if (i == 2) {
            TextUndoManagerKt.recordChanges(this.textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, true);
        } else if (i == 3) {
            TextUndoManagerKt.recordChanges(this.textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, false);
        }
    }

    public final void addNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.add(notifyImeListener);
    }

    public final void removeNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.remove(notifyImeListener);
    }

    public final void resetStateAndNotifyIme$foundation_release(TextFieldCharSequence textFieldCharSequence) {
        TextFieldCharSequence r0 = TextFieldCharSequenceKt.m1347TextFieldCharSequence3r_uNRQ(this.mainBuffer.toString(), this.mainBuffer.m1370getSelectiond9O1mEE(), this.mainBuffer.m1369getCompositionMzsxiRA());
        boolean z = true;
        boolean z2 = !Intrinsics.areEqual((Object) textFieldCharSequence.m1345getCompositionInCharsMzsxiRA(), (Object) this.mainBuffer.m1369getCompositionMzsxiRA());
        boolean z3 = false;
        if (!r0.contentEquals(textFieldCharSequence)) {
            this.mainBuffer = new EditingBuffer(textFieldCharSequence.toString(), textFieldCharSequence.m1346getSelectionInCharsd9O1mEE(), (DefaultConstructorMarker) null);
        } else if (!TextRange.m6035equalsimpl0(r0.m1346getSelectionInCharsd9O1mEE(), textFieldCharSequence.m1346getSelectionInCharsd9O1mEE())) {
            this.mainBuffer.setSelection(TextRange.m6042getStartimpl(textFieldCharSequence.m1346getSelectionInCharsd9O1mEE()), TextRange.m6037getEndimpl(textFieldCharSequence.m1346getSelectionInCharsd9O1mEE()));
            z3 = true;
            z = false;
        } else {
            z = false;
        }
        TextRange r3 = textFieldCharSequence.m1345getCompositionInCharsMzsxiRA();
        if (r3 == null || TextRange.m6036getCollapsedimpl(r3.m6046unboximpl())) {
            this.mainBuffer.commitComposition();
        } else {
            this.mainBuffer.setComposition(TextRange.m6040getMinimpl(r3.m6046unboximpl()), TextRange.m6039getMaximpl(r3.m6046unboximpl()));
        }
        if (z || (!z3 && z2)) {
            this.mainBuffer.commitComposition();
        }
        if (!z) {
            textFieldCharSequence = r0;
        }
        TextFieldCharSequence r11 = TextFieldCharSequenceKt.m1347TextFieldCharSequence3r_uNRQ(textFieldCharSequence, this.mainBuffer.m1370getSelectiond9O1mEE(), this.mainBuffer.m1369getCompositionMzsxiRA());
        setText(r11);
        notifyIme(r0, r11);
    }

    /* access modifiers changed from: private */
    public final void notifyIme(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2) {
        MutableVector<NotifyImeListener> mutableVector = this.notifyImeListeners;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                ((NotifyImeListener) content[i]).onChange(textFieldCharSequence, textFieldCharSequence2);
                i++;
            } while (i < size);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text2/input/TextFieldState;", "", "()V", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldState.kt */
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {
        public static final int $stable = 0;
        public static final Saver INSTANCE = new Saver();

        private Saver() {
        }

        public Object save(SaverScope saverScope, TextFieldState textFieldState) {
            return CollectionsKt.listOf(textFieldState.getText().toString(), Integer.valueOf(TextRange.m6042getStartimpl(textFieldState.getText().m1346getSelectionInCharsd9O1mEE())), Integer.valueOf(TextRange.m6037getEndimpl(textFieldState.getText().m1346getSelectionInCharsd9O1mEE())), TextUndoManager.Companion.Saver.INSTANCE.save(saverScope, textFieldState.getTextUndoManager$foundation_release()));
        }

        public TextFieldState restore(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Object obj3 = list.get(1);
            Object obj4 = list.get(2);
            Object obj5 = list.get(3);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
            long TextRange = TextRangeKt.TextRange(intValue, ((Integer) obj4).intValue());
            TextUndoManager.Companion.Saver saver = TextUndoManager.Companion.Saver.INSTANCE;
            Intrinsics.checkNotNull(obj5);
            TextUndoManager restore = saver.restore(obj5);
            Intrinsics.checkNotNull(restore);
            return new TextFieldState((String) obj2, TextRange, restore, (DefaultConstructorMarker) null);
        }
    }
}
