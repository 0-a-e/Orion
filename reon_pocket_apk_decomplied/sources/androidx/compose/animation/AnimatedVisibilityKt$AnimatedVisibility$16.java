package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedVisibilityScope;", "invoke", "(Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedVisibilityKt$AnimatedVisibility$16 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedVisibilityKt$AnimatedVisibility$16(Function2<? super Composer, ? super Integer, Unit> function2) {
        super(3);
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C721@39155L9:AnimatedVisibility.kt#xbi5r1");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1996320812, i, -1, "androidx.compose.animation.AnimatedVisibility.<anonymous> (AnimatedVisibility.kt:721)");
            }
            this.$content.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
