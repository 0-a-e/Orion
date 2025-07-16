package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$PrimaryScrollableTabRow$1 extends Lambda implements Function3<List<? extends TabPosition>, Composer, Integer, Unit> {
    final /* synthetic */ int $selectedTabIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$PrimaryScrollableTabRow$1(int i) {
        super(3);
        this.$selectedTabIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((List<TabPosition>) (List) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(List<TabPosition> list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C683@29809L75,684@29912L138:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(438091970, i, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:682)");
        }
        if (this.$selectedTabIndex < list.size()) {
            TabRowDefaults.INSTANCE.m2352PrimaryIndicator10LGxhE(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.Companion, list.get(this.$selectedTabIndex)), invoke$lambda$0(AnimateAsStateKt.m119animateDpAsStateAjpBEmI(list.get(this.$selectedTabIndex).m2347getContentWidthD9Ej5fM(), (AnimationSpec<Dp>) null, (String) null, (Function1<? super Dp, Unit>) null, composer, 0, 14)), 0.0f, 0, (Shape) null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    private static final float invoke$lambda$0(State<Dp> state) {
        return state.getValue().m6628unboximpl();
    }
}
