package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $isLeft;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ OffsetProvider $offsetProvider;
    final /* synthetic */ ViewConfiguration $viewConfiguration;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandle$1(ViewConfiguration viewConfiguration, Modifier modifier, boolean z, OffsetProvider offsetProvider, boolean z2) {
        super(2);
        this.$viewConfiguration = viewConfiguration;
        this.$modifier = modifier;
        this.$isLeft = z;
        this.$offsetProvider = offsetProvider;
        this.$isStartHandle = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C74@3360L709:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1868300064, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:74)");
            }
            ProvidedValue<ViewConfiguration> provides = CompositionLocalsKt.getLocalViewConfiguration().provides(this.$viewConfiguration);
            final Modifier modifier = this.$modifier;
            final boolean z = this.$isLeft;
            final OffsetProvider offsetProvider = this.$offsetProvider;
            final boolean z2 = this.$isStartHandle;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1338858912, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C75@3450L609:AndroidSelectionHandles.android.kt#eksfi3");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1338858912, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:75)");
                        }
                        Modifier modifier = modifier;
                        final OffsetProvider offsetProvider = offsetProvider;
                        final boolean z = z2;
                        final boolean z2 = z;
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                long r3 = offsetProvider.m1222provideF1C5BW0();
                                semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(z ? Handle.SelectionStart : Handle.SelectionEnd, r3, z2 ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right, OffsetKt.m3581isSpecifiedk4lQ0M(r3), (DefaultConstructorMarker) null));
                            }
                        }, 1, (Object) null);
                        final OffsetProvider offsetProvider2 = offsetProvider;
                        AndroidSelectionHandles_androidKt.SelectionHandleIcon(semantics$default, new Function0<Boolean>() {
                            public final Boolean invoke() {
                                return Boolean.valueOf(OffsetKt.m3581isSpecifiedk4lQ0M(offsetProvider2.m1222provideF1C5BW0()));
                            }
                        }, z, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
