package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/res/Configuration;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCompositionLocals.android.kt */
final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1 extends Lambda implements Function1<Configuration, Unit> {
    final /* synthetic */ MutableState<Configuration> $configuration$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(MutableState<Configuration> mutableState) {
        super(1);
        this.$configuration$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Configuration) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Configuration configuration) {
        AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals$lambda$2(this.$configuration$delegate, new Configuration(configuration));
    }
}
