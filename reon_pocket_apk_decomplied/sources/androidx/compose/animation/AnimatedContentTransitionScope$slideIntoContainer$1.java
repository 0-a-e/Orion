package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "S", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentTransitionScope$slideIntoContainer$1 extends Lambda implements Function1<Integer, Integer> {
    public static final AnimatedContentTransitionScope$slideIntoContainer$1 INSTANCE = new AnimatedContentTransitionScope$slideIntoContainer$1();

    AnimatedContentTransitionScope$slideIntoContainer$1() {
        super(1);
    }

    public final Integer invoke(int i) {
        return Integer.valueOf(i);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
