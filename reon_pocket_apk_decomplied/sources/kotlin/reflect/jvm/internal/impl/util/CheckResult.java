package kotlin.reflect.jvm.internal.impl.util;

import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: modifierChecks.kt */
public abstract class CheckResult {
    private final boolean isSuccess;

    public /* synthetic */ CheckResult(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    /* compiled from: modifierChecks.kt */
    public static final class IllegalSignature extends CheckResult {
        private final String error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IllegalSignature(String str) {
            super(false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            this.error = str;
        }
    }

    private CheckResult(boolean z) {
        this.isSuccess = z;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    /* compiled from: modifierChecks.kt */
    public static final class IllegalFunctionName extends CheckResult {
        public static final IllegalFunctionName INSTANCE = new IllegalFunctionName();

        private IllegalFunctionName() {
            super(false, (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class SuccessCheck extends CheckResult {
        public static final SuccessCheck INSTANCE = new SuccessCheck();

        private SuccessCheck() {
            super(true, (DefaultConstructorMarker) null);
        }
    }
}
