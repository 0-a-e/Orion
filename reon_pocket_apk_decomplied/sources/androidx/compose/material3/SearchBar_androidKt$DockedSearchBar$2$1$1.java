package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedVisibilityScope;", "invoke", "(Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$DockedSearchBar$2$1$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$DockedSearchBar$2$1$1(SearchBarColors searchBarColors, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$colors = searchBarColors;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1804538904, i, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        float r11 = Dp.m6614constructorimpl((float) ((Configuration) consume).screenHeightDp);
        composer.startReplaceableGroup(747855826);
        ComposerKt.sourceInformation(composer, "CC(remember):SearchBar.android.kt#9igjgp");
        boolean changed = composer.changed(r11);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = Dp.m6612boximpl(Dp.m6614constructorimpl(r11 * 0.6666667f));
            composer.updateRememberedValue(rememberedValue);
        }
        float r112 = ((Dp) rememberedValue).m6628unboximpl();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(747855974);
        ComposerKt.sourceInformation(composer, "CC(remember):SearchBar.android.kt#9igjgp");
        boolean changed2 = composer.changed(r112);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = Dp.m6612boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6612boximpl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.m6612boximpl(r112))).m6628unboximpl());
            composer.updateRememberedValue(rememberedValue2);
        }
        float r13 = ((Dp) rememberedValue2).m6628unboximpl();
        composer.endReplaceableGroup();
        Modifier r113 = SizeKt.m729heightInVpY3zN4(Modifier.Companion, r13, r112);
        SearchBarColors searchBarColors = this.$colors;
        Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
        composer.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r113);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer r5 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r5, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
        ComposerKt.sourceInformationMarkerStart(composer, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
        DividerKt.m1817HorizontalDivider9IZ8Weo((Modifier) null, 0.0f, searchBarColors.m2107getDividerColor0d7_KjU(), composer, 0, 3);
        function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
