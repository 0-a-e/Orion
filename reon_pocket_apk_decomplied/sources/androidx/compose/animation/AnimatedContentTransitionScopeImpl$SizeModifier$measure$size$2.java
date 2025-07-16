package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "S", "it", "invoke-YEO4UFw", "(Ljava/lang/Object;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$2 extends Lambda implements Function1<S, IntSize> {
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$2(AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl) {
        super(1);
        this.this$0 = animatedContentTransitionScopeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntSize.m6782boximpl(m65invokeYEO4UFw(obj));
    }

    /* renamed from: invoke-YEO4UFw  reason: not valid java name */
    public final long m65invokeYEO4UFw(S s) {
        State state = this.this$0.getTargetSizeMap$animation_release().get(s);
        return state != null ? ((IntSize) state.getValue()).m6794unboximpl() : IntSize.Companion.m6795getZeroYbymL2g();
    }
}
