package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "invoke-Deg8D_g", "(Landroidx/compose/runtime/Composer;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
final class LayoutKt$materializerOfWithCompositionLocalInjection$1 extends Lambda implements Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> {
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutKt$materializerOfWithCompositionLocalInjection$1(Modifier modifier) {
        super(3);
        this.$modifier = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m5328invokeDeg8D_g(((SkippableUpdater) obj).m3280unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Deg8D_g  reason: not valid java name */
    public final void m5328invokeDeg8D_g(Composer composer, Composer composer2, int i) {
        ComposerKt.sourceInformation(composer2, "C226@8842L23:Layout.kt#80mrfh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-55743822, i, -1, "androidx.compose.ui.layout.materializerOfWithCompositionLocalInjection.<anonymous> (Layout.kt:226)");
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        Modifier materializeWithCompositionLocalInjectionInternal = ComposedModifierKt.materializeWithCompositionLocalInjectionInternal(composer2, this.$modifier);
        composer.startReplaceableGroup(509942095);
        Composer r0 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r0, materializeWithCompositionLocalInjectionInternal, ComposeUiNode.Companion.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r0.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
