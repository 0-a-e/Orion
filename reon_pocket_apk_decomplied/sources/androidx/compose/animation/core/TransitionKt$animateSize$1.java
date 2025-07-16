package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: Transition.kt */
public final class TransitionKt$animateSize$1 extends Lambda implements Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Size>> {
    public static final TransitionKt$animateSize$1 INSTANCE = new TransitionKt$animateSize$1();

    public TransitionKt$animateSize$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final SpringSpec<Size> invoke(Transition.Segment<S> segment, Composer composer, int i) {
        composer.startReplaceableGroup(-1607152761);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1607152761, i, -1, "androidx.compose.animation.core.animateSize.<anonymous> (Transition.kt:1253)");
        }
        SpringSpec<Size> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m3619boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return spring$default;
    }
}
