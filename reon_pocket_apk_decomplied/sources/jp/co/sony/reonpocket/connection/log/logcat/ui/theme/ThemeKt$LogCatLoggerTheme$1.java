package jp.co.sony.reonpocket.connection.log.logcat.ui.theme;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.compose.material3.ColorScheme;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.view.WindowCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Theme.kt */
final class ThemeKt$LogCatLoggerTheme$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ColorScheme $colorScheme;
    final /* synthetic */ boolean $darkTheme;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ThemeKt$LogCatLoggerTheme$1(View view, ColorScheme colorScheme, boolean z) {
        super(0);
        this.$view = view;
        this.$colorScheme = colorScheme;
        this.$darkTheme = z;
    }

    public final void invoke() {
        Context context = this.$view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        window.setStatusBarColor(ColorKt.m3870toArgb8_81llA(this.$colorScheme.m1662getPrimary0d7_KjU()));
        WindowCompat.getInsetsController(window, this.$view).setAppearanceLightStatusBars(this.$darkTheme);
    }
}
