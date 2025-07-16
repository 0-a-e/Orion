package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBar$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $active;
    final /* synthetic */ State<Float> $animationProgress;
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function1<Boolean, Unit> $onActiveChange;
    final /* synthetic */ Function1<String, Unit> $onQueryChange;
    final /* synthetic */ Function1<String, Unit> $onSearch;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ String $query;
    final /* synthetic */ State<Dp> $topPadding;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBar$4(String str, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z, Function1<? super Boolean, Unit> function13, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, SearchBarColors searchBarColors, MutableInteractionSource mutableInteractionSource, State<Float> state, State<Dp> state2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$query = str;
        this.$onQueryChange = function1;
        this.$onSearch = function12;
        this.$active = z;
        this.$onActiveChange = function13;
        this.$enabled = z2;
        this.$placeholder = function2;
        this.$leadingIcon = function22;
        this.$trailingIcon = function23;
        this.$colors = searchBarColors;
        this.$interactionSource = mutableInteractionSource;
        this.$animationProgress = state;
        this.$topPadding = state2;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        State<Float> state;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(483163116, i2, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
            }
            String str = this.$query;
            Function1<String, Unit> function1 = this.$onQueryChange;
            Function1<String, Unit> function12 = this.$onSearch;
            boolean z = this.$active;
            Function1<Boolean, Unit> function13 = this.$onActiveChange;
            boolean z2 = this.$enabled;
            Function2<Composer, Integer, Unit> function2 = this.$placeholder;
            Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
            Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            SearchBarColors searchBarColors = this.$colors;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            State<Float> state2 = this.$animationProgress;
            State<Dp> state3 = this.$topPadding;
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
            String str2 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo";
            MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            String str3 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function2<Composer, Integer, Unit> function24 = function23;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(Modifier.Companion);
            Function2<Composer, Integer, Unit> function25 = function22;
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
            Updater.m3289setimpl(r9, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r9, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r9.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
            composer2.startReplaceableGroup(-685095283);
            ComposerKt.sourceInformation(composer2, "CC(remember):SearchBar.android.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AnimatedPaddingValues(state2, state3);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            String str4 = "C79@3979L9:Column.kt#2w3rfo";
            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
            String str5 = str3;
            State<Float> state4 = state2;
            SearchBarColors searchBarColors2 = searchBarColors;
            SearchBar_androidKt.SearchBarInputField(str, function1, function12, z, function13, PaddingKt.padding(Modifier.Companion, (AnimatedPaddingValues) rememberedValue), z2, function2, function25, function24, searchBarColors.getInputFieldColors(), mutableInteractionSource2, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 0);
            Composer composer3 = composer;
            composer3.startReplaceableGroup(-685094554);
            String str6 = "CC(remember):SearchBar.android.kt#9igjgp";
            ComposerKt.sourceInformation(composer3, str6);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                state = state4;
                rememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBar_androidKt$SearchBar$4$1$showResults$2$1(state));
                composer3.updateRememberedValue(rememberedValue2);
            } else {
                state = state4;
            }
            composer.endReplaceableGroup();
            composer3.startReplaceableGroup(551421253);
            ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
            if (invoke$lambda$5$lambda$2((State) rememberedValue2)) {
                Modifier modifier = Modifier.Companion;
                composer3.startReplaceableGroup(-685094361);
                ComposerKt.sourceInformation(composer3, str6);
                boolean changed = composer3.changed((Object) state);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new SearchBar_androidKt$SearchBar$4$1$1$1(state);
                    composer3.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceableGroup();
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) rememberedValue3);
                composer3.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer3, str2);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer3, str5);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer3.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer r5 = Updater.m3282constructorimpl(composer);
                Updater.m3289setimpl(r5, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r5.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer3, 0);
                composer3.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, str4);
                ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                DividerKt.m1817HorizontalDivider9IZ8Weo((Modifier) null, 0.0f, searchBarColors2.m2107getDividerColor0d7_KjU(), composer, 0, 3);
                function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
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

    private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
