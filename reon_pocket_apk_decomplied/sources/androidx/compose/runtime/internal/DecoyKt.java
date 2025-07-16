package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"illegalDecoyCallException", "", "fName", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Decoy.kt */
public final class DecoyKt {
    @ComposeCompilerApi
    public static final Void illegalDecoyCallException(String str) {
        throw new IllegalStateException("Function " + str + " should have been replaced by compiler.");
    }
}
