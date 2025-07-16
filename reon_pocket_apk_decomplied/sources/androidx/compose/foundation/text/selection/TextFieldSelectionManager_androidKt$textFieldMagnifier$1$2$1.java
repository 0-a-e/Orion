package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "center", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.android.kt */
final class TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1 extends Lambda implements Function1<Function0<? extends Offset>, Modifier> {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1(Density density, MutableState<IntSize> mutableState) {
        super(1);
        this.$density = density;
        this.$magnifierSize$delegate = mutableState;
    }

    public final Modifier invoke(Function0<Offset> function0) {
        final Function0<Offset> function02 = function0;
        final Density density = this.$density;
        final MutableState<IntSize> mutableState = this.$magnifierSize$delegate;
        return Magnifier_androidKt.m289magnifierjPUL71Q$default(Modifier.Companion, new Function1<Density, Offset>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Offset.m3551boximpl(m1321invoketuRUvjQ((Density) obj));
            }

            /* renamed from: invoke-tuRUvjQ  reason: not valid java name */
            public final long m1321invoketuRUvjQ(Density density) {
                return function02.invoke().m3572unboximpl();
            }
        }, (Function1) null, new Function1<DpSize, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1322invokeEaSLcWc(((DpSize) obj).m6720unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-EaSLcWc  reason: not valid java name */
            public final void m1322invokeEaSLcWc(long j) {
                MutableState<IntSize> mutableState = mutableState;
                Density density = density;
                TextFieldSelectionManager_androidKt$textFieldMagnifier$1.invoke$lambda$2(mutableState, IntSizeKt.IntSize(density.m6545roundToPx0680j_4(DpSize.m6712getWidthD9Ej5fM(j)), density.m6545roundToPx0680j_4(DpSize.m6710getHeightD9Ej5fM(j))));
            }
        }, 0.0f, true, 0, 0.0f, 0.0f, false, PlatformMagnifierFactory.Companion.getForCurrentPlatform(), 490, (Object) null);
    }
}
