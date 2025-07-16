package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInteropFilter.android.kt */
final class PointerInteropFilter_androidKt$pointerInteropFilter$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<MotionEvent, Boolean> $onTouchEvent;
    final /* synthetic */ RequestDisallowInterceptTouchEvent $requestDisallowInterceptTouchEvent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerInteropFilter_androidKt$pointerInteropFilter$2(Function1<? super MotionEvent, Boolean> function1, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent) {
        super(3);
        this.$onTouchEvent = function1;
        this.$requestDisallowInterceptTouchEvent = requestDisallowInterceptTouchEvent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceableGroup(374375707);
        ComposerKt.sourceInformation(composer, "C78@3403L35:PointerInteropFilter.android.kt#a556rk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(374375707, i, -1, "androidx.compose.ui.input.pointer.pointerInteropFilter.<anonymous> (PointerInteropFilter.android.kt:78)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PointerInteropFilter();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) rememberedValue;
        pointerInteropFilter.setOnTouchEvent(this.$onTouchEvent);
        pointerInteropFilter.setRequestDisallowInterceptTouchEvent(this.$requestDisallowInterceptTouchEvent);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pointerInteropFilter;
    }
}
