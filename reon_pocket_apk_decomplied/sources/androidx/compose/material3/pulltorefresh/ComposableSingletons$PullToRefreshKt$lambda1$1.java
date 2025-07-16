package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "pullRefreshState", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "invoke", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.material3.pulltorefresh.ComposableSingletons$PullToRefreshKt$lambda-1$1  reason: invalid class name */
/* compiled from: PullToRefresh.kt */
final class ComposableSingletons$PullToRefreshKt$lambda1$1 extends Lambda implements Function3<PullToRefreshState, Composer, Integer, Unit> {
    public static final ComposableSingletons$PullToRefreshKt$lambda1$1 INSTANCE = new ComposableSingletons$PullToRefreshKt$lambda1$1();

    ComposableSingletons$PullToRefreshKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((PullToRefreshState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PullToRefreshState pullToRefreshState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C110@4798L35:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i |= composer.changed((Object) pullToRefreshState) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1116780789, i, -1, "androidx.compose.material3.pulltorefresh.ComposableSingletons$PullToRefreshKt.lambda-1.<anonymous> (PullToRefresh.kt:110)");
            }
            PullToRefreshDefaults.INSTANCE.m2631IndicatorFNF3uiM(pullToRefreshState, (Modifier) null, 0, composer, (i & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
