package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text.KeyboardOptions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0001\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text2/input/InputTransformation;", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "transformInput", "", "originalValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "valueWithChanges", "Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InputTransformation.kt */
public interface InputTransformation {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: androidx.compose.foundation.text2.input.InputTransformation$-CC  reason: invalid class name */
    /* compiled from: InputTransformation.kt */
    public final /* synthetic */ class CC {
        public static KeyboardOptions $default$getKeyboardOptions(InputTransformation _this) {
            return null;
        }
    }

    KeyboardOptions getKeyboardOptions();

    void transformInput(TextFieldCharSequence textFieldCharSequence, TextFieldBuffer textFieldBuffer);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text2/input/InputTransformation$Companion;", "", "()V", "byValue", "Landroidx/compose/foundation/text2/input/InputTransformation;", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InputTransformation.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final InputTransformation byValue(Function2<? super CharSequence, ? super CharSequence, ? extends CharSequence> function2) {
            return new InputTransformationByValue(function2);
        }
    }
}
