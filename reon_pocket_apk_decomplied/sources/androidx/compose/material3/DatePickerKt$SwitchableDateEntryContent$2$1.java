package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/animation/ContentTransform;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/material3/DisplayMode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$SwitchableDateEntryContent$2$1 extends Lambda implements Function1<AnimatedContentTransitionScope<DisplayMode>, ContentTransform> {
    final /* synthetic */ int $parallaxTarget;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$SwitchableDateEntryContent$2$1(int i) {
        super(1);
        this.$parallaxTarget = i;
    }

    public final ContentTransform invoke(AnimatedContentTransitionScope<DisplayMode> animatedContentTransitionScope) {
        ContentTransform contentTransform;
        if (DisplayMode.m1809equalsimpl0(animatedContentTransitionScope.getTargetState().m1812unboximpl(), DisplayMode.Companion.m1813getInputjFl4v0())) {
            EnterTransition plus = EnterExitTransitionKt.slideInVertically$default((FiniteAnimationSpec) null, AnonymousClass1.INSTANCE, 1, (Object) null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 100, (Easing) null, 4, (Object) null), 0.0f, 2, (Object) null));
            ExitTransition fadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null);
            final int i = this.$parallaxTarget;
            contentTransform = AnimatedContentKt.togetherWith(plus, fadeOut$default.plus(EnterExitTransitionKt.slideOutVertically$default((FiniteAnimationSpec) null, new Function1<Integer, Integer>() {
                public final Integer invoke(int i) {
                    return Integer.valueOf(i);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }
            }, 1, (Object) null)));
        } else {
            final int i2 = this.$parallaxTarget;
            contentTransform = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween$default(0, 50, (Easing) null, 5, (Object) null), new Function1<Integer, Integer>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Integer invoke(int i) {
                    return Integer.valueOf(i2);
                }
            }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 100, (Easing) null, 4, (Object) null), 0.0f, 2, (Object) null)), EnterExitTransitionKt.slideOutVertically$default((FiniteAnimationSpec) null, AnonymousClass4.INSTANCE, 1, (Object) null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null)));
        }
        return animatedContentTransitionScope.using(contentTransform, AnimatedContentKt.SizeTransform(true, AnonymousClass5.INSTANCE));
    }
}
