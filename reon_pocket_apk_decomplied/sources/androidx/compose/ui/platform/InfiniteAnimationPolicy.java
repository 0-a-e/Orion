package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ2\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH¦@¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onInfiniteOperation", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Key", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InfiniteAnimationPolicy.kt */
public interface InfiniteAnimationPolicy extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    CoroutineContext.Key<?> getKey();

    <R> Object onInfiniteOperation(Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InfiniteAnimationPolicy.kt */
    public static final class DefaultImpls {
        public static <R> R fold(InfiniteAnimationPolicy infiniteAnimationPolicy, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return CoroutineContext.Element.DefaultImpls.fold(infiniteAnimationPolicy, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(InfiniteAnimationPolicy infiniteAnimationPolicy, CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get(infiniteAnimationPolicy, key);
        }

        public static CoroutineContext minusKey(InfiniteAnimationPolicy infiniteAnimationPolicy, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(infiniteAnimationPolicy, key);
        }

        public static CoroutineContext plus(InfiniteAnimationPolicy infiniteAnimationPolicy, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(infiniteAnimationPolicy, coroutineContext);
        }

        @Deprecated
        public static CoroutineContext.Key<?> getKey(InfiniteAnimationPolicy infiniteAnimationPolicy) {
            return CC.$default$getKey(infiniteAnimationPolicy);
        }
    }

    /* renamed from: androidx.compose.ui.platform.InfiniteAnimationPolicy$-CC  reason: invalid class name */
    /* compiled from: InfiniteAnimationPolicy.kt */
    public final /* synthetic */ class CC {
        static {
            Key key = InfiniteAnimationPolicy.Key;
        }

        public static CoroutineContext.Key $default$getKey(InfiniteAnimationPolicy _this) {
            return InfiniteAnimationPolicy.Key;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/InfiniteAnimationPolicy$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InfiniteAnimationPolicy.kt */
    public static final class Key implements CoroutineContext.Key<InfiniteAnimationPolicy> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }
}
