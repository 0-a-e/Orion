package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\b\u0010\f\u001a\u00020\rH\u0007\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0007\"&\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00018\u0006@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0002\u0010\u0005\":\u0010\u0006\u001a.\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u0007j\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"<set-?>", "", "isLiveLiteralsEnabled", "isLiveLiteralsEnabled$annotations", "()V", "()Z", "liveLiteralCache", "Ljava/util/HashMap;", "", "Landroidx/compose/runtime/MutableState;", "", "Lkotlin/collections/HashMap;", "enableLiveLiterals", "", "liveLiteral", "Landroidx/compose/runtime/State;", "T", "key", "value", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/compose/runtime/State;", "updateLiveLiteralValue", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LiveLiteral.kt */
public final class LiveLiteralKt {
    private static boolean isLiveLiteralsEnabled;
    private static final HashMap<String, MutableState<Object>> liveLiteralCache = new HashMap<>();

    @ComposeCompilerApi
    public static /* synthetic */ void isLiveLiteralsEnabled$annotations() {
    }

    public static final boolean isLiveLiteralsEnabled() {
        return isLiveLiteralsEnabled;
    }

    public static final void enableLiveLiterals() {
        isLiveLiteralsEnabled = true;
    }

    @ComposeCompilerApi
    public static final <T> State<T> liveLiteral(String str, T t) {
        Map map = liveLiteralCache;
        Object obj = map.get(str);
        if (obj == null) {
            obj = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
            map.put(str, obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.State<T of androidx.compose.runtime.internal.LiveLiteralKt.liveLiteral>");
        return (State) obj;
    }

    public static final void updateLiveLiteralValue(String str, Object obj) {
        boolean z;
        Map map = liveLiteralCache;
        Object obj2 = map.get(str);
        if (obj2 == null) {
            obj2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, (SnapshotMutationPolicy) null, 2, (Object) null);
            map.put(str, obj2);
            z = false;
        } else {
            z = true;
        }
        MutableState mutableState = (MutableState) obj2;
        if (z) {
            mutableState.setValue(obj);
        }
    }
}
