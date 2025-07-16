package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "S", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentTransitionScopeImpl$SizeModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ long $offset;
    final /* synthetic */ Placeable $placeable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentTransitionScopeImpl$SizeModifier$measure$1(Placeable placeable, long j) {
        super(1);
        this.$placeable = placeable;
        this.$offset = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.m5409place70tqf50$default(placementScope, this.$placeable, this.$offset, 0.0f, 2, (Object) null);
    }
}
