package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BoxWithConstraints.kt */
final class BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<BoxWithConstraintsScope, Composer, Integer, Unit> $content;
    final /* synthetic */ BoxWithConstraintsScopeImpl $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1(Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl) {
        super(2);
        this.$content = function3;
        this.$scope = boxWithConstraintsScopeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C68@3420L9:BoxWithConstraints.kt#2w3rfo");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1945019079, i, -1, "androidx.compose.foundation.layout.BoxWithConstraints.<anonymous>.<anonymous>.<anonymous> (BoxWithConstraints.kt:68)");
            }
            this.$content.invoke(this.$scope, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
