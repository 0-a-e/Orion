package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt", f = "AndroidTextInputSession.android.kt", i = {}, l = {50}, m = "platformSpecificTextInputSession", n = {}, s = {})
/* compiled from: AndroidTextInputSession.android.kt */
final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1(Continuation<? super AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AndroidTextInputSession_androidKt.platformSpecificTextInputSession((PlatformTextInputSession) null, (TransformedTextFieldState) null, (ImeOptions) null, (Function1<? super ImeAction, Unit>) null, this);
    }
}
