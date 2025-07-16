package jp.co.sony.reonpocket.util;

import com.amazonaws.services.s3.model.InstructionFileId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/util/DebugLogUtil;", "", "()V", "LOG_ENABLED", "", "LOG_ENABLED_DEBUG", "LOG_ENABLED_ERROR", "LOG_ENABLED_INFO", "LOG_ENABLED_VERBOSE", "LOG_ENABLED_WARNING", "TAG", "", "buildMessage", "message", "stackIndex", "", "d", "tag", "e", "i", "v", "w", "StackIndex", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DebugLogUtil.kt */
public final class DebugLogUtil {
    public static final int $stable = 0;
    public static final DebugLogUtil INSTANCE = new DebugLogUtil();
    private static final boolean LOG_ENABLED = true;
    private static final boolean LOG_ENABLED_DEBUG = true;
    private static final boolean LOG_ENABLED_ERROR = true;
    private static final boolean LOG_ENABLED_INFO = true;
    private static final boolean LOG_ENABLED_VERBOSE = true;
    private static final boolean LOG_ENABLED_WARNING = true;
    private static final String TAG = "blelib";

    private final int d(String str, String str2, int i) {
        return 0;
    }

    private final int e(String str, String str2, int i) {
        return 0;
    }

    private final int i(String str, String str2, int i) {
        return 0;
    }

    private final int v(String str, String str2, int i) {
        return 0;
    }

    private final int w(String str, String str2, int i) {
        return 0;
    }

    private DebugLogUtil() {
    }

    public final String buildMessage(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i];
        Intrinsics.checkNotNullExpressionValue(stackTraceElement, "get(...)");
        String className = stackTraceElement.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) className, InstructionFileId.DOT, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            className = className.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(className, "substring(...)");
        }
        String methodName = stackTraceElement.getMethodName();
        Intrinsics.checkNotNullExpressionValue(methodName, "getMethodName(...)");
        String str2 = className + "#" + methodName + "()-[" + stackTraceElement.getLineNumber() + "]";
        if (str.length() == 0) {
            return str2;
        }
        return str2 + ": " + str;
    }

    public final int d(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return d(TAG, str, 3);
    }

    public final int d(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        return d(TAG, str, i);
    }

    public final int d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        return d(str, str2, 3);
    }

    public final int e(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return e(TAG, str, 3);
    }

    public final int e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        return e(str, str2, 3);
    }

    public final int i(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return i(TAG, str, 3);
    }

    public final int i(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        return i(str, str2, 3);
    }

    public final int v(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return v(TAG, str, 3);
    }

    public final int v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        return v(str, str2, 3);
    }

    public final int w(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return w(TAG, str, 3);
    }

    public final int w(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
        return w(str, str2, 3);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/util/DebugLogUtil$StackIndex;", "", "()V", "SELF", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DebugLogUtil.kt */
    public static final class StackIndex {
        public static final int $stable = 0;
        public static final StackIndex INSTANCE = new StackIndex();
        public static final int SELF = 3;

        private StackIndex() {
        }
    }
}
