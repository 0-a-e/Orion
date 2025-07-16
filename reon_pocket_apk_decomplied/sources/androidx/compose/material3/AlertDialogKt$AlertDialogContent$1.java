package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.DialogTokens;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $buttonContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $buttons;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogContent$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, long j, long j2, long j3, long j4, Function2<? super Composer, ? super Integer, Unit> function24) {
        super(2);
        this.$icon = function2;
        this.$title = function22;
        this.$text = function23;
        this.$iconContentColor = j;
        this.$titleContentColor = j2;
        this.$textContentColor = j3;
        this.$buttonContentColor = j4;
        this.$buttons = function24;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        String str;
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformation(composer2, "C59@2068L2289:AlertDialog.kt#uh7d8r");
        if ((i3 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126308228, i3, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:59)");
            }
            Modifier padding = PaddingKt.padding(Modifier.Companion, AlertDialogKt.DialogPadding);
            Function2<Composer, Integer, Unit> function2 = this.$icon;
            Function2<Composer, Integer, Unit> function22 = this.$title;
            Function2<Composer, Integer, Unit> function23 = this.$text;
            long j = this.$iconContentColor;
            long j2 = this.$titleContentColor;
            long j3 = this.$textContentColor;
            long j4 = this.$buttonContentColor;
            Function2<Composer, Integer, Unit> function24 = this.$buttons;
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Function2<Composer, Integer, Unit> function25 = function24;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            String str2 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
            long j5 = j4;
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(composer);
            Updater.m3289setimpl(r6, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 76440821, "C108@3982L365:AlertDialog.kt#uh7d8r");
            composer2.startReplaceableGroup(76440827);
            ComposerKt.sourceInformation(composer2, "*63@2183L339");
            if (function2 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j)), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 934657765, true, new AlertDialogKt$AlertDialogContent$1$1$1$1(columnScope, function2)), composer2, ProvidedValue.$stable | 48);
            }
            composer.endReplaceableGroup();
            composer2.startReplaceableGroup(76441222);
            ComposerKt.sourceInformation(composer2, "*76@2708L10,74@2578L777");
            if (function22 == null) {
                str = str2;
                i2 = -1323940314;
            } else {
                str = str2;
                i2 = -1323940314;
                ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(j2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getHeadlineFont()), ComposableLambdaKt.composableLambda(composer2, 434448772, true, new AlertDialogKt$AlertDialogContent$1$1$2$1(columnScope, function2, function22)), composer, 384);
            }
            composer.endReplaceableGroup();
            composer2.startReplaceableGroup(76442054);
            ComposerKt.sourceInformation(composer2, "*94@3440L10,95@3510L445");
            if (function23 != null) {
                ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(j3, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getSupportingTextFont()), ComposableLambdaKt.composableLambda(composer2, -796843771, true, new AlertDialogKt$AlertDialogContent$1$1$3$1(columnScope, function23)), composer, 384);
            }
            composer.endReplaceableGroup();
            Modifier align = columnScope.align(Modifier.Companion, Alignment.Companion.getEnd());
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(i2);
            ComposerKt.sourceInformation(composer2, str);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer r5 = Updater.m3282constructorimpl(composer);
            Updater.m3289setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r5.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 24964985, "C110@4096L10,111@4167L166:AlertDialog.kt#uh7d8r");
            ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(j5, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function25, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
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
