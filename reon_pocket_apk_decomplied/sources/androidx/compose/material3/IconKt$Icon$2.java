package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ImageBitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Icon.kt */
final class IconKt$Icon$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ ImageBitmap $bitmap;
    final /* synthetic */ String $contentDescription;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $tint;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconKt$Icon$2(ImageBitmap imageBitmap, String str, Modifier modifier, long j, int i, int i2) {
        super(2);
        this.$bitmap = imageBitmap;
        this.$contentDescription = str;
        this.$modifier = modifier;
        this.$tint = j;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        IconKt.m1901Iconww6aTOc(this.$bitmap, this.$contentDescription, this.$modifier, this.$tint, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
