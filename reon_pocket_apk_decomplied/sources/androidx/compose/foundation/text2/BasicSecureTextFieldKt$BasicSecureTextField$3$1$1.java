package androidx.compose.foundation.text2;

import androidx.compose.foundation.text2.input.ImeActionHandler;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
/* synthetic */ class BasicSecureTextFieldKt$BasicSecureTextField$3$1$1 implements ImeActionHandler, FunctionAdapter {
    final /* synthetic */ ImeActionHandler $tmp0;

    BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(ImeActionHandler imeActionHandler) {
        this.$tmp0 = imeActionHandler;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ImeActionHandler) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.$tmp0, ImeActionHandler.class, "onImeAction", "onImeAction-KlQnJC8(I)Z", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    /* renamed from: onImeAction-KlQnJC8  reason: not valid java name */
    public final boolean m1327onImeActionKlQnJC8(int i) {
        return this.$tmp0.m1333onImeActionKlQnJC8(i);
    }
}
