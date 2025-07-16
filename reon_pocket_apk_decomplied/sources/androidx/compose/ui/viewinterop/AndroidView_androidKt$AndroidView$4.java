package androidx.compose.ui.viewinterop;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$AndroidView$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<Context, T> $factory;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<T, Unit> $onRelease;
    final /* synthetic */ Function1<T, Unit> $onReset;
    final /* synthetic */ Function1<T, Unit> $update;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$AndroidView$4(Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function12, Function1<? super T, Unit> function13, Function1<? super T, Unit> function14, int i, int i2) {
        super(2);
        this.$factory = function1;
        this.$modifier = modifier;
        this.$onReset = function12;
        this.$onRelease = function13;
        this.$update = function14;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AndroidView_androidKt.AndroidView(this.$factory, this.$modifier, this.$onReset, this.$onRelease, this.$update, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
