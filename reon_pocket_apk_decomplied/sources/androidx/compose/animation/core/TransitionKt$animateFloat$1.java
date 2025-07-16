package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: Transition.kt */
public final class TransitionKt$animateFloat$1 extends Lambda implements Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Float>> {
    public static final TransitionKt$animateFloat$1 INSTANCE = new TransitionKt$animateFloat$1();

    public TransitionKt$animateFloat$1() {
        super(3);
    }

    public final SpringSpec<Float> invoke(Transition.Segment<S> segment, Composer composer, int i) {
        composer.startReplaceableGroup(-522164544);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-522164544, i, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:1161)");
        }
        SpringSpec<Float> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
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
