package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
/* compiled from: Menu.kt */
final class MenuKt$DropdownMenuItemContent$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MenuItemColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ RowScope $this_Row;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuKt$DropdownMenuItemContent$1$1(Function2<? super Composer, ? super Integer, Unit> function2, MenuItemColors menuItemColors, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, RowScope rowScope, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(2);
        this.$leadingIcon = function2;
        this.$colors = menuItemColors;
        this.$enabled = z;
        this.$trailingIcon = function22;
        this.$this_Row = rowScope;
        this.$text = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C334@13380L18,334@13321L777,356@14235L26,355@14155L304:Menu.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1065051884, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:325)");
            }
            composer.startReplaceableGroup(1426260804);
            ComposerKt.sourceInformation(composer, "327@13072L25,326@12992L302");
            if (this.$leadingIcon != null) {
                ProvidedValue<Color> provides = ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(this.$colors.m1975leadingIconColorXeAY9LY$material3_release(this.$enabled, composer, 0)));
                final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 2035552199, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C329@13139L137:Menu.kt#uh7d8r");
                        if ((i & 3) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2035552199, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:329)");
                            }
                            Modifier r9 = SizeKt.m727defaultMinSizeVpY3zN4$default(Modifier.Companion, MenuTokens.INSTANCE.m2963getListItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, (Object) null);
                            Function2<Composer, Integer, Unit> function2 = function2;
                            composer.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                            composer.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r9);
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
                            Updater.m3289setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3289setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
                            composer.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer, 116818474, "C330@13241L13:Menu.kt#uh7d8r");
                            function2.invoke(composer, 0);
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
                }), composer, ProvidedValue.$stable | 48);
            }
            composer.endReplaceableGroup();
            ProvidedValue<Color> provides2 = ContentColorKt.getLocalContentColor().provides(this.$colors.textColor$material3_release(this.$enabled, composer, 0).getValue());
            final RowScope rowScope = this.$this_Row;
            final Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> function24 = this.$text;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1728894036, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    float f;
                    float f2;
                    Composer composer2 = composer;
                    int i2 = i;
                    ComposerKt.sourceInformation(composer2, "C335@13424L660:Menu.kt#uh7d8r");
                    if ((i2 & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1728894036, i2, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:335)");
                        }
                        Modifier weight$default = RowScope.CC.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                        if (function22 != null) {
                            f = MenuKt.DropdownMenuItemHorizontalPadding;
                        } else {
                            f = Dp.m6614constructorimpl((float) 0);
                        }
                        float f3 = f;
                        if (function23 != null) {
                            f2 = MenuKt.DropdownMenuItemHorizontalPadding;
                        } else {
                            f2 = Dp.m6614constructorimpl((float) 0);
                        }
                        Modifier r2 = PaddingKt.m674paddingqDBjuR0$default(weight$default, f3, 0.0f, f2, 0.0f, 10, (Object) null);
                        Function2<Composer, Integer, Unit> function2 = function24;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r2);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        Composer r8 = Updater.m3282constructorimpl(composer);
                        Updater.m3289setimpl(r8, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3289setimpl(r8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                            r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            r8.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 116819293, "C351@14060L6:Menu.kt#uh7d8r");
                        function2.invoke(composer2, 0);
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
            }), composer, ProvidedValue.$stable | 48);
            if (this.$trailingIcon != null) {
                ProvidedValue<Color> provides3 = ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(this.$colors.m1976trailingIconColorXeAY9LY$material3_release(this.$enabled, composer, 0)));
                final Function2<Composer, Integer, Unit> function25 = this.$trailingIcon;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 580312062, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C358@14302L139:Menu.kt#uh7d8r");
                        if ((i & 3) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(580312062, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:358)");
                            }
                            Modifier r9 = SizeKt.m727defaultMinSizeVpY3zN4$default(Modifier.Companion, MenuTokens.INSTANCE.m2964getListItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, (Object) null);
                            Function2<Composer, Integer, Unit> function2 = function25;
                            composer.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                            composer.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r9);
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
                            Updater.m3289setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3289setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
                            composer.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer, 116819638, "C359@14405L14:Menu.kt#uh7d8r");
                            function2.invoke(composer, 0);
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
                }), composer, ProvidedValue.$stable | 48);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
