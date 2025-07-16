package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJl\u0010l\u001a\u00020A2\u0006\u0010f\u001a\u00020g2\u0006\u0010m\u001a\u00020g2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\u00142\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020A0?2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zø\u0001\u0000¢\u0006\u0004\b{\u0010|R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010!\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001e\u0010$\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R(\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\n8F@FX\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00100\u001a\u0004\u0018\u00010/2\b\u0010)\u001a\u0004\u0018\u00010/8F@FX\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/06X\u0004¢\u0006\u0002\n\u0000R1\u00108\u001a\u0002072\u0006\u0010\u000b\u001a\u0002078F@FX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b=\u0010\u0013\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001d\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0?¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001d\u0010D\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020A0?¢\u0006\b\n\u0000\u001a\u0004\bF\u0010CR\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020A0?X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010H\u001a\u00020I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR+\u0010R\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\bU\u0010\u0013\u001a\u0004\bS\u0010\u0017\"\u0004\bT\u0010\u0019R+\u0010V\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\bY\u0010\u0013\u001a\u0004\bW\u0010\u0017\"\u0004\bX\u0010\u0019R+\u0010Z\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b]\u0010\u0013\u001a\u0004\b[\u0010\u0017\"\u0004\b\\\u0010\u0019R+\u0010^\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\ba\u0010\u0013\u001a\u0004\b_\u0010\u0017\"\u0004\b`\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001c\u0010f\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006}"}, d2 = {"Landroidx/compose/foundation/text/TextFieldState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/runtime/RecomposeScope;Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "_layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<set-?>", "Landroidx/compose/foundation/text/HandleState;", "handleState", "getHandleState", "()Landroidx/compose/foundation/text/HandleState;", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "handleState$delegate", "Landroidx/compose/runtime/MutableState;", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "isLayoutResultStale", "keyboardActionRunner", "Landroidx/compose/foundation/text/KeyboardActionRunner;", "getKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "value", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "layoutResult", "getLayoutResult", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setLayoutResult", "(Landroidx/compose/foundation/text/TextLayoutResultProxy;)V", "layoutResultState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "onImeActionPerformed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "", "getOnImeActionPerformed", "()Lkotlin/jvm/functions/Function1;", "onValueChange", "Landroidx/compose/ui/text/input/TextFieldValue;", "getOnValueChange", "onValueChangeOriginal", "processor", "Landroidx/compose/ui/text/input/EditProcessor;", "getProcessor", "()Landroidx/compose/ui/text/input/EditProcessor;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "selectionPaint", "Landroidx/compose/ui/graphics/Paint;", "getSelectionPaint", "()Landroidx/compose/ui/graphics/Paint;", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "showFloatingToolbar", "getShowFloatingToolbar", "setShowFloatingToolbar", "showFloatingToolbar$delegate", "showSelectionHandleEnd", "getShowSelectionHandleEnd", "setShowSelectionHandleEnd", "showSelectionHandleEnd$delegate", "showSelectionHandleStart", "getShowSelectionHandleStart", "setShowSelectionHandleStart", "showSelectionHandleStart$delegate", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "untransformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getUntransformedText", "()Landroidx/compose/ui/text/AnnotatedString;", "setUntransformedText", "(Landroidx/compose/ui/text/AnnotatedString;)V", "update", "visualText", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "update-fnh65Uc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/focus/FocusManager;J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
public final class TextFieldState {
    public static final int $stable = 8;
    private LayoutCoordinates _layoutCoordinates;
    private final MutableState handleState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(HandleState.None, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private TextInputSession inputSession;
    private final MutableState isInTouchMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
    private boolean isLayoutResultStale = true;
    /* access modifiers changed from: private */
    public final KeyboardActionRunner keyboardActionRunner;
    private final SoftwareKeyboardController keyboardController;
    private final MutableState<TextLayoutResultProxy> layoutResultState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState minHeightForSingleLineField$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m6612boximpl(Dp.m6614constructorimpl((float) 0)), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Function1<ImeAction, Unit> onImeActionPerformed;
    private final Function1<TextFieldValue, Unit> onValueChange;
    /* access modifiers changed from: private */
    public Function1<? super TextFieldValue, Unit> onValueChangeOriginal;
    private final EditProcessor processor = new EditProcessor();
    private final RecomposeScope recomposeScope;
    private final Paint selectionPaint;
    private final MutableState showCursorHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState showFloatingToolbar$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState showSelectionHandleEnd$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState showSelectionHandleStart$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private TextDelegate textDelegate;
    private AnnotatedString untransformedText;

    public TextFieldState(TextDelegate textDelegate2, RecomposeScope recomposeScope2, SoftwareKeyboardController softwareKeyboardController) {
        this.textDelegate = textDelegate2;
        this.recomposeScope = recomposeScope2;
        this.keyboardController = softwareKeyboardController;
        this.keyboardActionRunner = new KeyboardActionRunner(softwareKeyboardController);
        this.onValueChangeOriginal = TextFieldState$onValueChangeOriginal$1.INSTANCE;
        this.onValueChange = new TextFieldState$onValueChange$1(this);
        this.onImeActionPerformed = new TextFieldState$onImeActionPerformed$1(this);
        this.selectionPaint = AndroidPaint_androidKt.Paint();
    }

    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final void setTextDelegate(TextDelegate textDelegate2) {
        this.textDelegate = textDelegate2;
    }

    public final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    public final SoftwareKeyboardController getKeyboardController() {
        return this.keyboardController;
    }

    public final EditProcessor getProcessor() {
        return this.processor;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final void setInputSession(TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    /* renamed from: getMinHeightForSingleLineField-D9Ej5fM  reason: not valid java name */
    public final float m1146getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((Dp) this.minHeightForSingleLineField$delegate.getValue()).m6628unboximpl();
    }

    /* renamed from: setMinHeightForSingleLineField-0680j_4  reason: not valid java name */
    public final void m1147setMinHeightForSingleLineField0680j_4(float f) {
        this.minHeightForSingleLineField$delegate.setValue(Dp.m6612boximpl(f));
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this._layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    public final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this._layoutCoordinates = layoutCoordinates;
    }

    public final TextLayoutResultProxy getLayoutResult() {
        return this.layoutResultState.getValue();
    }

    public final void setLayoutResult(TextLayoutResultProxy textLayoutResultProxy) {
        this.layoutResultState.setValue(textLayoutResultProxy);
        this.isLayoutResultStale = false;
    }

    public final AnnotatedString getUntransformedText() {
        return this.untransformedText;
    }

    public final void setUntransformedText(AnnotatedString annotatedString) {
        this.untransformedText = annotatedString;
    }

    public final HandleState getHandleState() {
        return (HandleState) this.handleState$delegate.getValue();
    }

    public final void setHandleState(HandleState handleState) {
        this.handleState$delegate.setValue(handleState);
    }

    public final boolean getShowFloatingToolbar() {
        return ((Boolean) this.showFloatingToolbar$delegate.getValue()).booleanValue();
    }

    public final void setShowFloatingToolbar(boolean z) {
        this.showFloatingToolbar$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getShowSelectionHandleStart() {
        return ((Boolean) this.showSelectionHandleStart$delegate.getValue()).booleanValue();
    }

    public final void setShowSelectionHandleStart(boolean z) {
        this.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getShowSelectionHandleEnd() {
        return ((Boolean) this.showSelectionHandleEnd$delegate.getValue()).booleanValue();
    }

    public final void setShowSelectionHandleEnd(boolean z) {
        this.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isLayoutResultStale() {
        return this.isLayoutResultStale;
    }

    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode$delegate.getValue()).booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(z));
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange() {
        return this.onValueChange;
    }

    public final Function1<ImeAction, Unit> getOnImeActionPerformed() {
        return this.onImeActionPerformed;
    }

    public final Paint getSelectionPaint() {
        return this.selectionPaint;
    }

    /* renamed from: update-fnh65Uc  reason: not valid java name */
    public final void m1148updatefnh65Uc(AnnotatedString annotatedString, AnnotatedString annotatedString2, TextStyle textStyle, boolean z, Density density, FontFamily.Resolver resolver, Function1<? super TextFieldValue, Unit> function1, KeyboardActions keyboardActions, FocusManager focusManager, long j) {
        this.onValueChangeOriginal = function1;
        this.selectionPaint.m4094setColor8_81llA(j);
        KeyboardActionRunner keyboardActionRunner2 = this.keyboardActionRunner;
        keyboardActionRunner2.setKeyboardActions(keyboardActions);
        keyboardActionRunner2.setFocusManager(focusManager);
        this.untransformedText = annotatedString;
        TextDelegate r1 = TextDelegateKt.m1118updateTextDelegaterm0N8CA$default(this.textDelegate, annotatedString2, textStyle, density, resolver, z, 0, 0, 0, CollectionsKt.emptyList(), 448, (Object) null);
        if (this.textDelegate != r1) {
            this.isLayoutResultStale = true;
        }
        this.textDelegate = r1;
    }
}
