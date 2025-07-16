package androidx.compose.foundation.text2;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldBuffer;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078@@BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text2/PasswordRevealFilter;", "Landroidx/compose/foundation/text2/input/InputTransformation;", "scheduleHide", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "revealCodepointIndex", "getRevealCodepointIndex$foundation_release", "()I", "setRevealCodepointIndex", "(I)V", "revealCodepointIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "getScheduleHide", "()Lkotlin/jvm/functions/Function0;", "hide", "transformInput", "originalValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "valueWithChanges", "Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
public final class PasswordRevealFilter implements InputTransformation {
    public static final int $stable = 0;
    private final MutableIntState revealCodepointIndex$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
    private final Function0<Unit> scheduleHide;

    public /* synthetic */ KeyboardOptions getKeyboardOptions() {
        return InputTransformation.CC.$default$getKeyboardOptions(this);
    }

    public PasswordRevealFilter(Function0<Unit> function0) {
        this.scheduleHide = function0;
    }

    public final Function0<Unit> getScheduleHide() {
        return this.scheduleHide;
    }

    private final void setRevealCodepointIndex(int i) {
        this.revealCodepointIndex$delegate.setIntValue(i);
    }

    public final int getRevealCodepointIndex$foundation_release() {
        return this.revealCodepointIndex$delegate.getIntValue();
    }

    public void transformInput(TextFieldCharSequence textFieldCharSequence, TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.getChanges().getChangeCount() == 1 && TextRange.m6038getLengthimpl(textFieldBuffer.getChanges().m1344getRangejx7JFs(0)) == 1 && TextRange.m6038getLengthimpl(textFieldBuffer.getChanges().m1343getOriginalRangejx7JFs(0)) == 0 && !textFieldBuffer.hasSelection()) {
            int r5 = TextRange.m6040getMinimpl(textFieldBuffer.getChanges().m1344getRangejx7JFs(0));
            if (getRevealCodepointIndex$foundation_release() != r5) {
                this.scheduleHide.invoke();
                setRevealCodepointIndex(r5);
                return;
            }
            return;
        }
        setRevealCodepointIndex(-1);
    }

    public final void hide() {
        setRevealCodepointIndex(-1);
    }
}
