package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$onPositionedModifier$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ WindowInfo $windowInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$onPositionedModifier$1(TextFieldState textFieldState, boolean z, WindowInfo windowInfo, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(1);
        this.$state = textFieldState;
        this.$enabled = z;
        this.$windowInfo = windowInfo;
        this.$manager = textFieldSelectionManager;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        this.$state.setLayoutCoordinates(layoutCoordinates);
        TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
        }
        if (this.$enabled) {
            if (this.$state.getHandleState() == HandleState.Selection) {
                if (!this.$state.getShowFloatingToolbar() || !CoreTextFieldKt.isWindowFocusedBehindFlag(this.$windowInfo)) {
                    this.$manager.hideSelectionToolbar$foundation_release();
                } else {
                    this.$manager.showSelectionToolbar$foundation_release();
                }
                this.$state.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.$manager, true));
                this.$state.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.$manager, false));
                this.$state.setShowCursorHandle(TextRange.m6036getCollapsedimpl(this.$value.m6299getSelectiond9O1mEE()));
            } else if (this.$state.getHandleState() == HandleState.Cursor) {
                this.$state.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.$manager, true));
            }
            CoreTextFieldKt.notifyFocusedRect(this.$state, this.$value, this.$offsetMapping);
            TextLayoutResultProxy layoutResult2 = this.$state.getLayoutResult();
            if (layoutResult2 != null) {
                TextFieldState textFieldState = this.$state;
                TextFieldValue textFieldValue = this.$value;
                OffsetMapping offsetMapping = this.$offsetMapping;
                TextInputSession inputSession = textFieldState.getInputSession();
                if (inputSession != null && textFieldState.getHasFocus()) {
                    TextFieldDelegate.Companion.updateTextLayoutResult$foundation_release(inputSession, textFieldValue, offsetMapping, layoutResult2);
                }
            }
        }
    }
}
