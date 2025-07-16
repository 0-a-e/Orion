package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: Transition.kt */
public final class TransitionKt$animateIntSize$1 extends Lambda implements Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntSize>> {
    public static final TransitionKt$animateIntSize$1 INSTANCE = new TransitionKt$animateIntSize$1();

    public TransitionKt$animateIntSize$1() {
        super(3);
    }

    public final SpringSpec<IntSize> invoke(Transition.Segment<S> segment, Composer composer, int i) {
        composer.startReplaceableGroup(967893300);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(967893300, i, -1, "androidx.compose.animation.core.animateIntSize.<anonymous> (Transition.kt:1346)");
        }
        SpringSpec<IntSize> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m6782boximpl(IntSizeKt.IntSize(1, 1)), 3, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return spring$default;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
