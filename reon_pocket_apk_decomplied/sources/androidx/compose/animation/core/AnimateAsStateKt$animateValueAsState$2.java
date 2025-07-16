package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimateAsState.kt */
final class AnimateAsStateKt$animateValueAsState$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Channel<T> $channel;
    final /* synthetic */ T $targetValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimateAsStateKt$animateValueAsState$2(Channel<T> channel, T t) {
        super(0);
        this.$channel = channel;
        this.$targetValue = t;
    }

    public final void invoke() {
        this.$channel.m8593trySendJP2dKIU(this.$targetValue);
    }
}
