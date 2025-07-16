package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
final class AndroidExternalSurface_androidKt$AndroidExternalSurface$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $isOpaque;
    final /* synthetic */ boolean $isSecure;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<AndroidExternalSurfaceScope, Unit> $onInit;
    final /* synthetic */ long $surfaceSize;
    final /* synthetic */ int $zOrder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidExternalSurface_androidKt$AndroidExternalSurface$4(Modifier modifier, boolean z, long j, int i, boolean z2, Function1<? super AndroidExternalSurfaceScope, Unit> function1, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$isOpaque = z;
        this.$surfaceSize = j;
        this.$zOrder = i;
        this.$isSecure = z2;
        this.$onInit = function1;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AndroidExternalSurface_androidKt.m210AndroidExternalSurface58FFMhA(this.$modifier, this.$isOpaque, this.$surfaceSize, this.$zOrder, this.$isSecure, this.$onInit, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
