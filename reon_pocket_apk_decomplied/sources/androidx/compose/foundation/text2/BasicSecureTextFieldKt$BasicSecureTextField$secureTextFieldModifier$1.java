package androidx.compose.foundation.text2;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
final class BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1 INSTANCE = new BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1();

    BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.password(semanticsPropertyReceiver);
        SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, (String) null, AnonymousClass1.INSTANCE, 1, (Object) null);
        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, (String) null, AnonymousClass2.INSTANCE, 1, (Object) null);
    }
}
