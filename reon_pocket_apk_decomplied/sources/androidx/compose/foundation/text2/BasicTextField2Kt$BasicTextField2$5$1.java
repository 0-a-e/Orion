package androidx.compose.foundation.text2;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.HeightInLinesModifierKt;
import androidx.compose.foundation.text.TextFieldSizeKt;
import androidx.compose.foundation.text2.input.TextFieldLineLimits;
import androidx.compose.foundation.text2.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text2.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField2.kt */
final class BasicTextField2Kt$BasicTextField2$5$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $isFocused;
    final /* synthetic */ boolean $isWindowFocused;
    final /* synthetic */ TextFieldLineLimits $lineLimits;
    final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ TextFieldSelectionState $textFieldSelectionState;
    final /* synthetic */ TextLayoutState $textLayoutState;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ TransformedTextFieldState $transformedState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextField2Kt$BasicTextField2$5$1(TextFieldLineLimits textFieldLineLimits, TextLayoutState textLayoutState, TextStyle textStyle, boolean z, boolean z2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z3, boolean z4, ScrollState scrollState, Orientation orientation, boolean z5, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        super(2);
        this.$lineLimits = textFieldLineLimits;
        this.$textLayoutState = textLayoutState;
        this.$textStyle = textStyle;
        this.$isFocused = z;
        this.$isWindowFocused = z2;
        this.$transformedState = transformedTextFieldState;
        this.$textFieldSelectionState = textFieldSelectionState;
        this.$cursorBrush = brush;
        this.$enabled = z3;
        this.$readOnly = z4;
        this.$scrollState = scrollState;
        this.$orientation = orientation;
        this.$singleLine = z5;
        this.$onTextLayout = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        int i3;
        Composer composer2 = composer;
        int i4 = i;
        ComposerKt.sourceInformation(composer2, "C436@24100L1966:BasicTextField2.kt#g98mwb");
        if ((i4 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1476233751, i4, -1, "androidx.compose.foundation.text2.BasicTextField2.<anonymous>.<anonymous> (BasicTextField2.kt:426)");
            }
            TextFieldLineLimits textFieldLineLimits = this.$lineLimits;
            if (textFieldLineLimits instanceof TextFieldLineLimits.MultiLine) {
                i3 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits).getMinHeightInLines();
                i2 = ((TextFieldLineLimits.MultiLine) this.$lineLimits).getMaxHeightInLines();
            } else {
                i3 = 1;
                i2 = 1;
            }
            Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m730heightInVpY3zN4$default(Modifier.Companion, this.$textLayoutState.m1414getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, (Object) null), this.$textStyle, i3, i2), this.$textStyle)).then(new TextFieldCoreModifier(this.$isFocused && this.$isWindowFocused, this.$textLayoutState, this.$transformedState, this.$textFieldSelectionState, this.$cursorBrush, this.$enabled && !this.$readOnly, this.$scrollState, this.$orientation));
            TextLayoutState textLayoutState = this.$textLayoutState;
            TransformedTextFieldState transformedTextFieldState = this.$transformedState;
            TextStyle textStyle = this.$textStyle;
            boolean z = this.$singleLine;
            Function2<Density, Function0<TextLayoutResult>, Unit> function2 = this.$onTextLayout;
            boolean z2 = this.$enabled;
            boolean z3 = this.$isFocused;
            boolean z4 = this.$isWindowFocused;
            TextFieldSelectionState textFieldSelectionState = this.$textFieldSelectionState;
            boolean z5 = this.$readOnly;
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
            boolean z6 = z5;
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer r0 = Updater.m3282constructorimpl(composer);
            Updater.m3289setimpl(r0, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r0, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r0.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1666145625, "C460@25204L370:BasicTextField2.kt#g98mwb");
            BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState, transformedTextFieldState, textStyle, z, function2), composer2, 0);
            composer2.startReplaceableGroup(-39277302);
            ComposerKt.sourceInformation(composer2, "472@25720L113,476@25895L117");
            if (z2 && z3 && z4 && textFieldSelectionState.isInTouchMode()) {
                BasicTextField2Kt.TextFieldSelectionHandles(textFieldSelectionState, composer2, 8);
                if (!z6) {
                    BasicTextField2Kt.TextFieldCursorHandle(textFieldSelectionState, composer2, 8);
                }
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
}
