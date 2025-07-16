package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$SecondaryTabRow$1 extends Lambda implements Function3<TabIndicatorScope, Composer, Integer, Unit> {
    final /* synthetic */ int $selectedTabIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$SecondaryTabRow$1(int i) {
        super(3);
        this.$selectedTabIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((TabIndicatorScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C210@10618L113:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            i |= (i & 8) == 0 ? composer.changed((Object) tabIndicatorScope) : composer.changedInstance(tabIndicatorScope) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(286693261, i, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:210)");
            }
            TabRowDefaults.INSTANCE.m2353SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.Companion, this.$selectedTabIndex, false), 0.0f, 0, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
