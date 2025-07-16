package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"androidx/compose/animation/core/VectorizedAnimationSpecKt$createSpringAnimations$2", "Landroidx/compose/animation/core/Animations;", "anim", "Landroidx/compose/animation/core/FloatSpringSpec;", "get", "index", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedAnimationSpec.kt */
public final class VectorizedAnimationSpecKt$createSpringAnimations$2 implements Animations {
    private final FloatSpringSpec anim;

    VectorizedAnimationSpecKt$createSpringAnimations$2(float f, float f2) {
        this.anim = new FloatSpringSpec(f, f2, 0.0f, 4, (DefaultConstructorMarker) null);
    }

    public FloatSpringSpec get(int i) {
        return this.anim;
    }
}
