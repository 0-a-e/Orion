package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001RB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020%H\u0016J\u0006\u00107\u001a\u00020\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0017J\b\u0010;\u001a\u00020%H\u0002J\b\u0010<\u001a\u00020%H\u0002J\u0010\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020/H\u0002J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0016H\u0002J\b\u0010A\u001a\u00020%H\u0016J\b\u0010B\u001a\u00020%H\u0016JF\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0\"H\u0016J\b\u0010D\u001a\u00020%H\u0016J\u001a\u0010E\u001a\u00020%2\b\u0010F\u001a\u0004\u0018\u00010)2\u0006\u0010G\u001a\u00020)H\u0016JD\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020%0\"2\u0006\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020:H\u0016R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0\"X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006S"}, d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "(Landroid/view/View;Landroidx/compose/ui/input/pointer/PositionCalculator;)V", "rootPositionCalculator", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "inputCommandProcessorExecutor", "Ljava/util/concurrent/Executor;", "(Landroid/view/View;Landroidx/compose/ui/input/pointer/PositionCalculator;Landroidx/compose/ui/text/input/InputMethodManager;Ljava/util/concurrent/Executor;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "cursorAnchorInfoController", "Landroidx/compose/ui/text/input/CursorAnchorInfoController;", "editorHasFocus", "", "focusedRect", "Landroid/graphics/Rect;", "frameCallback", "Ljava/lang/Runnable;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textInputCommandQueue", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "hideSoftwareKeyboard", "isEditorFocused", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "processInputCommands", "restartInputImmediately", "sendInputCommand", "command", "setKeyboardVisibleImmediately", "visible", "showSoftwareKeyboard", "startInput", "value", "stopInput", "updateState", "oldValue", "newValue", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "TextInputCommand", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextInputServiceAndroid.android.kt */
public final class TextInputServiceAndroid implements PlatformTextInputService {
    public static final int $stable = 8;
    private final Lazy baseInputConnection$delegate;
    /* access modifiers changed from: private */
    public final CursorAnchorInfoController cursorAnchorInfoController;
    private boolean editorHasFocus;
    private Rect focusedRect;
    private Runnable frameCallback;
    /* access modifiers changed from: private */
    public List<WeakReference<RecordingInputConnection>> ics;
    private ImeOptions imeOptions;
    private final Executor inputCommandProcessorExecutor;
    private final InputMethodManager inputMethodManager;
    /* access modifiers changed from: private */
    public Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    /* access modifiers changed from: private */
    public Function1<? super ImeAction, Unit> onImeActionPerformed;
    private TextFieldValue state;
    private final MutableVector<TextInputCommand> textInputCommandQueue;
    private final View view;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "", "(Ljava/lang/String;I)V", "StartInput", "StopInput", "ShowKeyboard", "HideKeyboard", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextInputServiceAndroid.android.kt */
    private enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextInputServiceAndroid.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand[] r0 = androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r1 = androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand.StartInput     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r1 = androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand.StopInput     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r1 = androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand.ShowKeyboard     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r1 = androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand.HideKeyboard     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextInputServiceAndroid.WhenMappings.<clinit>():void");
        }
    }

    public TextInputServiceAndroid(View view2, PositionCalculator positionCalculator, InputMethodManager inputMethodManager2, Executor executor) {
        this.view = view2;
        this.inputMethodManager = inputMethodManager2;
        this.inputCommandProcessorExecutor = executor;
        this.onEditCommand = TextInputServiceAndroid$onEditCommand$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$onImeActionPerformed$1.INSTANCE;
        this.state = new TextFieldValue("", TextRange.Companion.m6047getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TextInputServiceAndroid$baseInputConnection$2(this));
        this.cursorAnchorInfoController = new CursorAnchorInfoController(positionCalculator, inputMethodManager2);
        this.textInputCommandQueue = new MutableVector<>(new TextInputCommand[16], 0);
    }

    public final View getView() {
        return this.view;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextInputServiceAndroid(View view2, PositionCalculator positionCalculator, InputMethodManager inputMethodManager2, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, positionCalculator, inputMethodManager2, (i & 8) != 0 ? TextInputServiceAndroid_androidKt.asExecutor(Choreographer.getInstance()) : executor);
    }

    public final TextFieldValue getState$ui_release() {
        return this.state;
    }

    /* access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    public TextInputServiceAndroid(View view2, PositionCalculator positionCalculator) {
        this(view2, positionCalculator, new InputMethodManagerImpl(view2), (Executor) null, 8, (DefaultConstructorMarker) null);
    }

    public final InputConnection createInputConnection(EditorInfo editorInfo) {
        if (!this.editorHasFocus) {
            return null;
        }
        TextInputServiceAndroid_androidKt.update(editorInfo, this.imeOptions, this.state);
        TextInputServiceAndroid_androidKt.updateWithEmojiCompat(editorInfo);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new TextInputServiceAndroid$createInputConnection$1(this), this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference(recordingInputConnection));
        return recordingInputConnection;
    }

    public final boolean isEditorFocused() {
        return this.editorHasFocus;
    }

    public void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions2, Function1<? super List<? extends EditCommand>, Unit> function1, Function1<? super ImeAction, Unit> function12) {
        this.editorHasFocus = true;
        this.state = textFieldValue;
        this.imeOptions = imeOptions2;
        this.onEditCommand = function1;
        this.onImeActionPerformed = function12;
        sendInputCommand(TextInputCommand.StartInput);
    }

    public void startInput() {
        sendInputCommand(TextInputCommand.StartInput);
    }

    public void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = TextInputServiceAndroid$stopInput$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$stopInput$2.INSTANCE;
        this.focusedRect = null;
        sendInputCommand(TextInputCommand.StopInput);
    }

    public void showSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.ShowKeyboard);
    }

    public void hideSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.HideKeyboard);
    }

    private final void sendInputCommand(TextInputCommand textInputCommand) {
        this.textInputCommandQueue.add(textInputCommand);
        if (this.frameCallback == null) {
            TextInputServiceAndroid$$ExternalSyntheticLambda0 textInputServiceAndroid$$ExternalSyntheticLambda0 = new TextInputServiceAndroid$$ExternalSyntheticLambda0(this);
            this.inputCommandProcessorExecutor.execute(textInputServiceAndroid$$ExternalSyntheticLambda0);
            this.frameCallback = textInputServiceAndroid$$ExternalSyntheticLambda0;
        }
    }

    /* access modifiers changed from: private */
    public static final void sendInputCommand$lambda$1(TextInputServiceAndroid textInputServiceAndroid) {
        textInputServiceAndroid.frameCallback = null;
        textInputServiceAndroid.processInputCommands();
    }

    private final void processInputCommands() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        MutableVector<TextInputCommand> mutableVector = this.textInputCommandQueue;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                processInputCommands$applyToState((TextInputCommand) content[i], objectRef, objectRef2);
                i++;
            } while (i < size);
        }
        this.textInputCommandQueue.clear();
        if (Intrinsics.areEqual((Object) objectRef.element, (Object) true)) {
            restartInputImmediately();
        }
        Boolean bool = (Boolean) objectRef2.element;
        if (bool != null) {
            setKeyboardVisibleImmediately(bool.booleanValue());
        }
        if (Intrinsics.areEqual((Object) objectRef.element, (Object) false)) {
            restartInputImmediately();
        }
    }

    private static final void processInputCommands$applyToState(TextInputCommand textInputCommand, Ref.ObjectRef<Boolean> objectRef, Ref.ObjectRef<Boolean> objectRef2) {
        int i = WhenMappings.$EnumSwitchMapping$0[textInputCommand.ordinal()];
        boolean z = true;
        if (i == 1) {
            objectRef.element = true;
            objectRef2.element = true;
        } else if (i == 2) {
            objectRef.element = false;
            objectRef2.element = false;
        } else if ((i == 3 || i == 4) && !Intrinsics.areEqual((Object) objectRef.element, (Object) false)) {
            if (textInputCommand != TextInputCommand.ShowKeyboard) {
                z = false;
            }
            objectRef2.element = Boolean.valueOf(z);
        }
    }

    public void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean z = !TextRange.m6035equalsimpl0(this.state.m6299getSelectiond9O1mEE(), textFieldValue2.m6299getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) this.state.m6298getCompositionMzsxiRA(), (Object) textFieldValue2.m6298getCompositionMzsxiRA());
        this.state = textFieldValue2;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setMTextFieldValue$ui_release(textFieldValue2);
            }
        }
        this.cursorAnchorInfoController.invalidate();
        if (Intrinsics.areEqual((Object) textFieldValue, (Object) textFieldValue2)) {
            if (z) {
                InputMethodManager inputMethodManager2 = this.inputMethodManager;
                int r0 = TextRange.m6040getMinimpl(textFieldValue2.m6299getSelectiond9O1mEE());
                int r8 = TextRange.m6039getMaximpl(textFieldValue2.m6299getSelectiond9O1mEE());
                TextRange r1 = this.state.m6298getCompositionMzsxiRA();
                int i2 = -1;
                int r12 = r1 != null ? TextRange.m6040getMinimpl(r1.m6046unboximpl()) : -1;
                TextRange r3 = this.state.m6298getCompositionMzsxiRA();
                if (r3 != null) {
                    i2 = TextRange.m6039getMaximpl(r3.m6046unboximpl());
                }
                inputMethodManager2.updateSelection(r0, r8, r12, i2);
            }
        } else if (textFieldValue == null || (Intrinsics.areEqual((Object) textFieldValue.getText(), (Object) textFieldValue2.getText()) && (!TextRange.m6035equalsimpl0(textFieldValue.m6299getSelectiond9O1mEE(), textFieldValue2.m6299getSelectiond9O1mEE()) || Intrinsics.areEqual((Object) textFieldValue.m6298getCompositionMzsxiRA(), (Object) textFieldValue2.m6298getCompositionMzsxiRA())))) {
            int size2 = this.ics.size();
            for (int i3 = 0; i3 < size2; i3++) {
                RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) this.ics.get(i3).get();
                if (recordingInputConnection2 != null) {
                    recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
                }
            }
        } else {
            restartInputImmediately();
        }
    }

    @Deprecated(message = "This method should not be called, used BringIntoViewRequester instead.")
    public void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (this.ics.isEmpty() && (rect2 = this.focusedRect) != null) {
            this.view.requestRectangleOnScreen(new Rect(rect2));
        }
    }

    public void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Function1<? super Matrix, Unit> function1, androidx.compose.ui.geometry.Rect rect, androidx.compose.ui.geometry.Rect rect2) {
        this.cursorAnchorInfoController.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, function1, rect, rect2);
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    private final void setKeyboardVisibleImmediately(boolean z) {
        if (z) {
            this.inputMethodManager.showSoftInput();
        } else {
            this.inputMethodManager.hideSoftInput();
        }
    }
}
