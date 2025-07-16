package jp.co.sony.reonpocket.connection.log.logcat;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import jp.co.sony.reonpocket.connection.log.logcat.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
final class LogCatLogActivity$onCreate$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LogCatLogActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogActivity$onCreate$1(LogCatLogActivity logCatLogActivity) {
        super(2);
        this.this$0 = logCatLogActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(777571839, i, -1, "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivity.onCreate.<anonymous> (LogCatLogActivity.kt:50)");
            }
            final LogCatLogActivity logCatLogActivity = this.this$0;
            ThemeKt.LogCatLoggerTheme(false, false, ComposableLambdaKt.composableLambda(composer, -190826907, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Composer composer2 = composer;
                    int i2 = i;
                    if ((i2 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-190826907, i2, -1, "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivity.onCreate.<anonymous>.<anonymous> (LogCatLogActivity.kt:51)");
                        }
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        long r4 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).m1643getBackground0d7_KjU();
                        final LogCatLogActivity logCatLogActivity = logCatLogActivity;
                        SurfaceKt.m2303SurfaceT9BRK9s(fillMaxSize$default, (Shape) null, r4, 0, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(composer2, 793464704, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(793464704, i, -1, "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (LogCatLogActivity.kt:55)");
                                    }
                                    LogCatLogPresenter access$getPresenter$p = logCatLogActivity.presenter;
                                    if (access$getPresenter$p == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        access$getPresenter$p = null;
                                    }
                                    LogCatLogActivityKt.Content(access$getPresenter$p, composer, 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 12582918, 122);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
