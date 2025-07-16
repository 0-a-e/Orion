package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DialogTokens;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePickerDialog.android.kt */
final class DatePickerDialog_androidKt$DatePickerDialog$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerDialog_androidKt$DatePickerDialog$1(Shape shape, DatePickerColors datePickerColors, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$shape = shape;
        this.$colors = datePickerColors;
        this.$tonalElevation = f;
        this.$content = function3;
        this.$dismissButton = function2;
        this.$confirmButton = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer, "C79@3857L1306:DatePickerDialog.android.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-10625622, i2, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:79)");
            }
            Modifier r1 = SizeKt.m730heightInVpY3zN4$default(SizeKt.m739requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2785getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2784getContainerHeightD9Ej5fM(), 1, (Object) null);
            Shape shape = this.$shape;
            long r3 = this.$colors.m1738getContainerColor0d7_KjU();
            float f = this.$tonalElevation;
            final Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            final Function2<Composer, Integer, Unit> function2 = this.$dismissButton;
            final Function2<Composer, Integer, Unit> function22 = this.$confirmButton;
            SurfaceKt.m2303SurfaceT9BRK9s(r1, shape, r3, 0, f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(composer, -1706202235, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C87@4178L975:DatePickerDialog.android.kt#uh7d8r");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1706202235, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:87)");
                        }
                        Function3<ColumnScope, Composer, Integer, Unit> function3 = function3;
                        Function2<Composer, Integer, Unit> function2 = function2;
                        Function2<Composer, Integer, Unit> function22 = function22;
                        composer.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer, 6);
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
                        Composer r10 = Updater.m3282constructorimpl(composer);
                        Updater.m3289setimpl(r10, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3289setimpl(r10, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                            r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            r10.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer, 1146374327, "C88@4251L9,90@4304L835:DatePickerDialog.android.kt#uh7d8r");
                        function3.invoke(columnScope, composer, 6);
                        Modifier padding = PaddingKt.padding(columnScope.align(Modifier.Companion, Alignment.Companion.getEnd()), DatePickerDialog_androidKt.DialogButtonsPadding);
                        composer.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                        composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(padding);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor2);
                        } else {
                            composer.useNode();
                        }
                        Composer r8 = Updater.m3282constructorimpl(composer);
                        Updater.m3289setimpl(r8, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3289setimpl(r8, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                            r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            r8.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer, -552861241, "C96@4593L5,98@4674L10,95@4490L631:DatePickerDialog.android.kt#uh7d8r");
                        ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer, 6), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), ComposableLambdaKt.composableLambda(composer, 1174914401, true, new DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1(function2, function22)), composer, 384);
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
            }), composer, 12582918, LocationRequestCompat.QUALITY_LOW_POWER);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
