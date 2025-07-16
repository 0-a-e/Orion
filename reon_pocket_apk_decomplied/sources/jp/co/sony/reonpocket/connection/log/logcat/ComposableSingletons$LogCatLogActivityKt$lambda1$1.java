package jp.co.sony.reonpocket.connection.log.logcat;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* renamed from: jp.co.sony.reonpocket.connection.log.logcat.ComposableSingletons$LogCatLogActivityKt$lambda-1$1  reason: invalid class name */
/* compiled from: LogCatLogActivity.kt */
final class ComposableSingletons$LogCatLogActivityKt$lambda1$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$LogCatLogActivityKt$lambda1$1 INSTANCE = new ComposableSingletons$LogCatLogActivityKt$lambda1$1();

    ComposableSingletons$LogCatLogActivityKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        int i2 = i;
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        if ((i2 & 81) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2147346291, i2, -1, "jp.co.sony.reonpocket.connection.log.logcat.ComposableSingletons$LogCatLogActivityKt.lambda-1.<anonymous> (LogCatLogActivity.kt:115)");
            }
            TextKt.m2456Text4IGK_g("OK", (Modifier) null, 0, TextUnitKt.getSp(18), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3078, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
