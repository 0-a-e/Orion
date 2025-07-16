package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$PrimaryTabRow$1 extends Lambda implements Function3<TabIndicatorScope, Composer, Integer, Unit> {
    final /* synthetic */ int $selectedTabIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$PrimaryTabRow$1(int i) {
        super(3);
        this.$selectedTabIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((TabIndicatorScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C153@7624L204:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composer.changed((Object) tabIndicatorScope) : composer.changedInstance(tabIndicatorScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2021049253, i2, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:153)");
            }
            TabRowDefaults.INSTANCE.m2352PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.Companion, this.$selectedTabIndex, true), Dp.Companion.m6634getUnspecifiedD9Ej5fM(), 0.0f, 0, (Shape) null, composer, 196656, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
