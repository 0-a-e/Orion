package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
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
/* compiled from: DatePicker.kt */
final class DatePickerKt$MonthsNavigation$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $nextAvailable;
    final /* synthetic */ Function0<Unit> $onNextClicked;
    final /* synthetic */ Function0<Unit> $onPreviousClicked;
    final /* synthetic */ Function0<Unit> $onYearPickerButtonClicked;
    final /* synthetic */ boolean $previousAvailable;
    final /* synthetic */ String $yearPickerText;
    final /* synthetic */ boolean $yearPickerVisible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$MonthsNavigation$1$1(Function0<Unit> function0, boolean z, String str, Function0<Unit> function02, boolean z2, Function0<Unit> function03, boolean z3) {
        super(2);
        this.$onYearPickerButtonClicked = function0;
        this.$yearPickerVisible = z;
        this.$yearPickerText = str;
        this.$onPreviousClicked = function02;
        this.$previousAvailable = z2;
        this.$onNextClicked = function03;
        this.$nextAvailable = z3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2153@92815L580,2167@93545L696:DatePicker.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-962805198, i, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2153)");
            }
            Function0<Unit> function0 = this.$onYearPickerButtonClicked;
            boolean z = this.$yearPickerVisible;
            final String str = this.$yearPickerText;
            DatePickerKt.YearPickerMenuButton(function0, z, (Modifier) null, ComposableLambdaKt.composableLambda(composer, 1377272806, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Composer composer2 = composer;
                    int i2 = i;
                    ComposerKt.sourceInformation(composer2, "C2158@93045L335,2157@92967L414:DatePicker.kt#uh7d8r");
                    if ((i2 & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1377272806, i2, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2157)");
                        }
                        String str = str;
                        Modifier modifier = Modifier.Companion;
                        composer2.startReplaceableGroup(1090374478);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changed = composer2.changed((Object) str);
                        String str2 = str;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new DatePickerKt$MonthsNavigation$1$1$1$1$1(str2);
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceableGroup();
                        TextKt.m2456Text4IGK_g(str, SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 3072, 4);
            if (!this.$yearPickerVisible) {
                Function0<Unit> function02 = this.$onPreviousClicked;
                boolean z2 = this.$previousAvailable;
                Function0<Unit> function03 = this.$onNextClicked;
                boolean z3 = this.$nextAvailable;
                composer.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
                composer.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(Modifier.Companion);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer r7 = Updater.m3282constructorimpl(composer);
                Updater.m3289setimpl(r7, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r7, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                    r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    r7.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1090375004, "C2168@93571L321,2174@93913L310:DatePicker.kt#uh7d8r");
                IconButtonKt.IconButton(function02, (Modifier) null, z2, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$DatePickerKt.INSTANCE.m1707getLambda3$material3_release(), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                IconButtonKt.IconButton(function03, (Modifier) null, z3, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$DatePickerKt.INSTANCE.m1708getLambda4$material3_release(), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
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
