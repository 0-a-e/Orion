package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/MotionDurationScale;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "scaleFactor", "", "getScaleFactor", "()F", "Key", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MotionDurationScale.kt */
public interface MotionDurationScale extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    CoroutineContext.Key<?> getKey();

    float getScaleFactor();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MotionDurationScale.kt */
    public static final class DefaultImpls {
        public static <R> R fold(MotionDurationScale motionDurationScale, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return CoroutineContext.Element.DefaultImpls.fold(motionDurationScale, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(MotionDurationScale motionDurationScale, CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get(motionDurationScale, key);
        }

        public static CoroutineContext minusKey(MotionDurationScale motionDurationScale, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(motionDurationScale, key);
        }

        public static CoroutineContext plus(MotionDurationScale motionDurationScale, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(motionDurationScale, coroutineContext);
        }
    }

    /* renamed from: androidx.compose.ui.MotionDurationScale$-CC  reason: invalid class name */
    /* compiled from: MotionDurationScale.kt */
    public final /* synthetic */ class CC {
        public static CoroutineContext.Key $default$getKey(MotionDurationScale _this) {
            return MotionDurationScale.Key;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/MotionDurationScale$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/MotionDurationScale;", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MotionDurationScale.kt */
    public static final class Key implements CoroutineContext.Key<MotionDurationScale> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }
}
