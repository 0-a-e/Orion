package androidx.compose.runtime.collection;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006H\b¨\u0006\u0007"}, d2 = {"fastForEach", "", "T", "", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArraySet.kt */
public final class IdentityArraySetKt {
    public static final <T> void fastForEach(Set<? extends T> set, Function1<? super T, Unit> function1) {
        if (set instanceof IdentityArraySet) {
            IdentityArraySet identityArraySet = (IdentityArraySet) set;
            Object[] values = identityArraySet.getValues();
            int size = identityArraySet.size();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                function1.invoke(obj);
            }
            return;
        }
        for (Object invoke : set) {
            function1.invoke(invoke);
        }
    }
}
