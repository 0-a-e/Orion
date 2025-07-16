package androidx.activity.compose;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "I", "O", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActivityResultRegistry.kt */
final class ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1 extends Lambda implements Function0<String> {
    public static final ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1 INSTANCE = new ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1();

    ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1() {
        super(0);
    }

    public final String invoke() {
        return UUID.randomUUID().toString();
    }
}
