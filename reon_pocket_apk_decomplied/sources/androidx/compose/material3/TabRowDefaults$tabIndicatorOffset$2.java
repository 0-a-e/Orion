package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowDefaults$tabIndicatorOffset$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TabPosition $currentTabPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowDefaults$tabIndicatorOffset$2(TabPosition tabPosition) {
        super(3);
        this.$currentTabPosition = tabPosition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1541271084);
        ComposerKt.sourceInformation(composer2, "C1134@48007L165,1138@48204L164:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1541271084, i, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1134)");
        }
        Composer composer3 = composer;
        State<Dp> r13 = AnimateAsStateKt.m119animateDpAsStateAjpBEmI(this.$currentTabPosition.m2350getWidthD9Ej5fM(), AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (String) null, (Function1<? super Dp, Unit>) null, composer3, 0, 12);
        Modifier modifier2 = modifier;
        Modifier r1 = SizeKt.m747width3ABfNKs(OffsetKt.m629offsetVpY3zN4$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), Alignment.Companion.getBottomStart(), false, 2, (Object) null), invoke$lambda$1(AnimateAsStateKt.m119animateDpAsStateAjpBEmI(this.$currentTabPosition.m2348getLeftD9Ej5fM(), AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (String) null, (Function1<? super Dp, Unit>) null, composer3, 0, 12)), 0.0f, 2, (Object) null), invoke$lambda$0(r13));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    private static final float invoke$lambda$0(State<Dp> state) {
        return state.getValue().m6628unboximpl();
    }

    private static final float invoke$lambda$1(State<Dp> state) {
        return state.getValue().m6628unboximpl();
    }
}
