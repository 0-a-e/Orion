package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonKt$ExtendedFloatingActionButton$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonKt$ExtendedFloatingActionButton$5(boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$expanded = z;
        this.$icon = function2;
        this.$text = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        float f;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C354@17647L838:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1172118032, i2, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:351)");
            }
            float access$getExtendedFabStartIconPadding$p = this.$expanded ? FloatingActionButtonKt.ExtendedFabStartIconPadding : Dp.m6614constructorimpl((float) 0);
            float access$getExtendedFabTextPadding$p = this.$expanded ? FloatingActionButtonKt.ExtendedFabTextPadding : Dp.m6614constructorimpl((float) 0);
            Modifier modifier = Modifier.Companion;
            if (this.$expanded) {
                f = FloatingActionButtonKt.ExtendedFabMinimumWidth;
            } else {
                f = FabPrimaryTokens.INSTANCE.m2857getContainerWidthD9Ej5fM();
            }
            Modifier r1 = PaddingKt.m674paddingqDBjuR0$default(SizeKt.m746sizeInqDBjuR0$default(modifier, f, 0.0f, 0.0f, 0.0f, 14, (Object) null), access$getExtendedFabStartIconPadding$p, 0.0f, access$getExtendedFabTextPadding$p, 0.0f, 10, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal start = this.$expanded ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
            Function2<Composer, Integer, Unit> function2 = this.$icon;
            boolean z = this.$expanded;
            Function2<Composer, Integer, Unit> function22 = this.$text;
            composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r1);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer r9 = Updater.m3282constructorimpl(composer);
            Updater.m3289setimpl(r9, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r9, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r9.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(composer2, -1419543993, "C364@18095L6,365@18114L361:FloatingActionButton.kt#uh7d8r");
            function2.invoke(composer2, 0);
            AnimatedVisibilityKt.AnimatedVisibility((RowScope) RowScopeInstance.INSTANCE, z, (Modifier) null, FloatingActionButtonKt.ExtendedFabExpandAnimation, FloatingActionButtonKt.ExtendedFabCollapseAnimation, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 176242764, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1(function22)), composer, 1600518, 18);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
