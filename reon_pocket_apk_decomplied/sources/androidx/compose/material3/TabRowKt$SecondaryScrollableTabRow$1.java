package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$SecondaryScrollableTabRow$1 extends Lambda implements Function3<List<? extends TabPosition>, Composer, Integer, Unit> {
    final /* synthetic */ int $selectedTabIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$SecondaryScrollableTabRow$1(int i) {
        super(3);
        this.$selectedTabIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((List<TabPosition>) (List) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(List<TabPosition> list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C754@33494L101:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-115843248, i, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:754)");
        }
        TabRowDefaults.INSTANCE.m2353SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.Companion, list.get(this.$selectedTabIndex)), 0.0f, 0, composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
