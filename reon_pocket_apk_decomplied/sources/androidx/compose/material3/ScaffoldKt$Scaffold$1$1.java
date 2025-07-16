package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "consumedWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$Scaffold$1$1 extends Lambda implements Function1<WindowInsets, Unit> {
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ MutableWindowInsets $safeInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$Scaffold$1$1(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets) {
        super(1);
        this.$safeInsets = mutableWindowInsets;
        this.$contentWindowInsets = windowInsets;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WindowInsets) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(WindowInsets windowInsets) {
        this.$safeInsets.setInsets(WindowInsetsKt.exclude(this.$contentWindowInsets, windowInsets));
    }
}
