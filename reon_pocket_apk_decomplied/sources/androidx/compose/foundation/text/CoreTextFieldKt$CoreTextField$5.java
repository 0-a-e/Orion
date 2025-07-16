package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ Modifier $cursorModifier;
    final /* synthetic */ Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> $decorationBox;
    final /* synthetic */ Density $density;
    final /* synthetic */ Modifier $drawModifier;
    final /* synthetic */ Modifier $magnifierModifier;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ Modifier $onPositionedModifier;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
    final /* synthetic */ boolean $showHandleAndMagnifier;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$5(Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, TextFieldState textFieldState, TextStyle textStyle, int i, int i2, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1, OffsetMapping offsetMapping, Density density) {
        super(2);
        this.$decorationBox = function3;
        this.$state = textFieldState;
        this.$textStyle = textStyle;
        this.$minLines = i;
        this.$maxLines = i2;
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$value = textFieldValue;
        this.$visualTransformation = visualTransformation;
        this.$cursorModifier = modifier;
        this.$drawModifier = modifier2;
        this.$onPositionedModifier = modifier3;
        this.$magnifierModifier = modifier4;
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$manager = textFieldSelectionManager;
        this.$showHandleAndMagnifier = z;
        this.$readOnly = z2;
        this.$onTextLayout = function1;
        this.$offsetMapping = offsetMapping;
        this.$density = density;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2 = i;
        ComposerKt.sourceInformation(composer, "C642@29093L4568:CoreTextField.kt#423gt5");
        if ((i2 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374338080, i2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:642)");
            }
            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function3 = this.$decorationBox;
            final TextFieldState textFieldState = this.$state;
            final TextStyle textStyle = this.$textStyle;
            final int i3 = this.$minLines;
            final int i4 = this.$maxLines;
            final TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
            final TextFieldValue textFieldValue = this.$value;
            final VisualTransformation visualTransformation = this.$visualTransformation;
            final Modifier modifier = this.$cursorModifier;
            final Modifier modifier2 = this.$drawModifier;
            final Modifier modifier3 = this.$onPositionedModifier;
            final Modifier modifier4 = this.$magnifierModifier;
            final BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            final boolean z = this.$showHandleAndMagnifier;
            final boolean z2 = this.$readOnly;
            final Function1<TextLayoutResult, Unit> function1 = this.$onTextLayout;
            final OffsetMapping offsetMapping = this.$offsetMapping;
            final Density density = this.$density;
            AnonymousClass1 r3 = new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C667@30284L3367:CoreTextField.kt#423gt5");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2032502107, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:645)");
                        }
                        Modifier bringIntoViewRequester = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(HeightInLinesModifierKt.heightInLines(SizeKt.m730heightInVpY3zN4$default(Modifier.Companion, textFieldState.m1146getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, (Object) null), textStyle, i3, i4), textFieldScrollerPosition, textFieldValue, visualTransformation, new CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(textFieldState)).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester);
                        final TextFieldSelectionManager textFieldSelectionManager = textFieldSelectionManager;
                        final TextFieldState textFieldState = textFieldState;
                        final boolean z = z;
                        final boolean z2 = z2;
                        final Function1<TextLayoutResult, Unit> function1 = function1;
                        final TextFieldValue textFieldValue = textFieldValue;
                        final OffsetMapping offsetMapping = offsetMapping;
                        final Density density = density;
                        final int i2 = i4;
                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester, ComposableLambdaKt.composableLambda(composer, -363167407, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ComposerKt.sourceInformation(composer, "C668@30338L2699,721@33055L322,734@33579L40:CoreTextField.kt#423gt5");
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-363167407, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:668)");
                                    }
                                    final TextFieldState textFieldState = textFieldState;
                                    final Function1<TextLayoutResult, Unit> function1 = function1;
                                    final TextFieldValue textFieldValue = textFieldValue;
                                    final OffsetMapping offsetMapping = offsetMapping;
                                    final Density density = density;
                                    final int i2 = i2;
                                    MeasurePolicy r12 = new MeasurePolicy() {
                                        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                                            return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                                        }

                                        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                                            return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                                        }

                                        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                                            return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                                        }

                                        /* renamed from: measure-3p2s80s  reason: not valid java name */
                                        public MeasureResult m1063measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                            Snapshot makeCurrent;
                                            Snapshot.Companion companion = Snapshot.Companion;
                                            TextFieldState textFieldState = textFieldState;
                                            Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                                            try {
                                                makeCurrent = createNonObservableSnapshot.makeCurrent();
                                                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                                                TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                                createNonObservableSnapshot.dispose();
                                                Triple<Integer, Integer, TextLayoutResult> r10 = TextFieldDelegate.Companion.m1126layout_EkL_Y$foundation_release(textFieldState.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                int intValue = r10.component1().intValue();
                                                int intValue2 = r10.component2().intValue();
                                                TextLayoutResult component3 = r10.component3();
                                                if (!Intrinsics.areEqual((Object) value, (Object) component3)) {
                                                    textFieldState.setLayoutResult(new TextLayoutResultProxy(component3));
                                                    function1.invoke(component3);
                                                    CoreTextFieldKt.notifyFocusedRect(textFieldState, textFieldValue, offsetMapping);
                                                }
                                                textFieldState.m1147setMinHeightForSingleLineField0680j_4(density.m6547toDpu2uoSUM(i2 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getLastBaseline())))), CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2.INSTANCE);
                                            } catch (Throwable th) {
                                                createNonObservableSnapshot.dispose();
                                                throw th;
                                            }
                                        }

                                        public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                                            textFieldState.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                            return textFieldState.getTextDelegate().getMaxIntrinsicWidth();
                                        }
                                    };
                                    composer.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    boolean z = false;
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
                                    Composer r4 = Updater.m3282constructorimpl(composer);
                                    Updater.m3289setimpl(r4, r12, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3289setimpl(r4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                                        r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        r4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
                                    composer.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer, 1017247175, "C:CoreTextField.kt#423gt5");
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    composer.endReplaceableGroup();
                                    composer.endNode();
                                    composer.endReplaceableGroup();
                                    TextFieldSelectionManager textFieldSelectionManager = textFieldSelectionManager;
                                    if (!(textFieldState.getHandleState() == HandleState.None || textFieldState.getLayoutCoordinates() == null)) {
                                        LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
                                        Intrinsics.checkNotNull(layoutCoordinates);
                                        if (layoutCoordinates.isAttached() && z) {
                                            z = true;
                                        }
                                    }
                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z, composer, 8);
                                    if (textFieldState.getHandleState() == HandleState.Cursor && !z2 && z) {
                                        CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager, composer, 8);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer2 = composer;
            function3.invoke(ComposableLambdaKt.composableLambda(composer2, 2032502107, true, r3), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
