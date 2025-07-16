package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aT\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0012\u001aT\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2#\u0010\u001f\u001a\u001f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0002\b\u00112#\u0010!\u001a\u001f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0002\b\u00112\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001aF\u0010\u001b\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001aS\u0010(\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2#\u0010\u001f\u001a\u001f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0002\b\u00112\u0006\u0010)\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001a\u0001\u0010*\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2#\u0010\u001f\u001a\u001f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0002\b\u00112#\u0010!\u001a\u001f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0002\b\u00112\u0006\u0010)\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001a%\u0010+\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\fH\u0001¢\u0006\u0002\u0010,\u001a6\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010\u0019\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a\u001c\u00108\u001a\u00020\f*\u0002092\u0006\u00102\u001a\u0002032\u0006\u0010\u001f\u001a\u00020\fH\u0000\u001a\u0014\u0010!\u001a\u00020\f*\u00020:2\u0006\u00102\u001a\u000203H\u0000\u001a\u001c\u0010;\u001a\u00020\f*\u0002092\u0006\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\fH\u0000\u001a\u0014\u0010\u001f\u001a\u00020\f*\u00020:2\u0006\u00102\u001a\u000203H\u0000\u001a<\u0010<\u001a\u00020\f*\u0002092\u0006\u00104\u001a\u0002052\u0006\u00102\u001a\u0002032\u0014\u0010=\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020\u00040\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b>\u0010?\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"CROSS_AXIS_ALIGNMENT_START", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "FlowColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/FlowRowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "intrinsicCrossAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "mainAxisSizes", "", "crossAxisSizes", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "breakDownItems", "Landroidx/compose/foundation/layout/FlowResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measureHelper", "Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-w1Onq5I", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;Landroidx/compose/foundation/layout/LayoutOrientation;JI)Landroidx/compose/foundation/layout/FlowResult;", "crossAxisMin", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "mainAxisMin", "measureAndCache", "storePlaceable", "measureAndCache-6m2dt9o", "(Landroidx/compose/ui/layout/Measurable;JLandroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function1;)I", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
public final class FlowLayoutKt {
    /* access modifiers changed from: private */
    public static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(Alignment.Companion.getStart());
    /* access modifiers changed from: private */
    public static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.Companion.vertical$foundation_layout_release(Alignment.Companion.getTop());

    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1098475987);
        ComposerKt.sourceInformation(composer, "CC(FlowRow)P(3,1,4,2)66@2954L113,71@3072L134:FlowLayout.kt#2w3rfo");
        if ((i3 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i3 & 2) != 0) {
            horizontal = Arrangement.INSTANCE.getStart();
        }
        if ((i3 & 4) != 0) {
            vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i3 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        MeasurePolicy rowMeasurementHelper = rowMeasurementHelper(horizontal, vertical, i, composer, (i2 >> 3) & 1022);
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer r0 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r0, rowMeasurementHelper, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r0, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r0.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(composer, 483375643, "C72@3121L9:FlowLayout.kt#2w3rfo");
        function3.invoke(FlowRowScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 9) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-310290901);
        ComposerKt.sourceInformation(composer, "CC(FlowColumn)P(3,4,1,2)116@4804L119,121@4928L137:FlowLayout.kt#2w3rfo");
        if ((i3 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i3 & 2) != 0) {
            vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i3 & 4) != 0) {
            horizontal = Arrangement.INSTANCE.getStart();
        }
        if ((i3 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        MeasurePolicy columnMeasurementHelper = columnMeasurementHelper(vertical, horizontal, i, composer, (i2 >> 3) & 1022);
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer r0 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r0, columnMeasurementHelper, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r0, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r0.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(composer, -681937041, "C122@4980L9:FlowLayout.kt#2w3rfo");
        function3.invoke(FlowColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 9) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: androidx.compose.foundation.layout.FlowMeasurePolicy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.foundation.layout.FlowMeasurePolicy} */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0042;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.layout.MeasurePolicy rowMeasurementHelper(androidx.compose.foundation.layout.Arrangement.Horizontal r11, androidx.compose.foundation.layout.Arrangement.Vertical r12, int r13, androidx.compose.runtime.Composer r14, int r15) {
        /*
            r0 = 1479255111(0x582ba447, float:7.5488822E14)
            r14.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rowMeasurementHelper)P(!1,2)157@5820L584:FlowLayout.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:156)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x0017:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r13)
            r0 = 1618982084(0x607fb4c4, float:7.370227E19)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            boolean r0 = r14.changed((java.lang.Object) r11)
            boolean r1 = r14.changed((java.lang.Object) r12)
            r0 = r0 | r1
            boolean r15 = r14.changed((java.lang.Object) r15)
            r15 = r15 | r0
            java.lang.Object r0 = r14.rememberedValue()
            if (r15 != 0) goto L_0x0042
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r0 != r15) goto L_0x005f
        L_0x0042:
            androidx.compose.foundation.layout.LayoutOrientation r2 = androidx.compose.foundation.layout.LayoutOrientation.Horizontal
            float r5 = r11.m552getSpacingD9Ej5fM()
            androidx.compose.foundation.layout.SizeMode r6 = androidx.compose.foundation.layout.SizeMode.Wrap
            androidx.compose.foundation.layout.CrossAxisAlignment r7 = CROSS_AXIS_ALIGNMENT_TOP
            float r8 = r12.m570getSpacingD9Ej5fM()
            androidx.compose.foundation.layout.FlowMeasurePolicy r0 = new androidx.compose.foundation.layout.FlowMeasurePolicy
            r10 = 0
            r1 = r0
            r3 = r11
            r4 = r12
            r9 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.updateRememberedValue(r0)
        L_0x005f:
            r14.endReplaceableGroup()
            androidx.compose.foundation.layout.FlowMeasurePolicy r0 = (androidx.compose.foundation.layout.FlowMeasurePolicy) r0
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x006d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x006d:
            r14.endReplaceableGroup()
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.rowMeasurementHelper(androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, int, androidx.compose.runtime.Composer, int):androidx.compose.ui.layout.MeasurePolicy");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: androidx.compose.foundation.layout.FlowMeasurePolicy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.foundation.layout.FlowMeasurePolicy} */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0042;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.layout.MeasurePolicy columnMeasurementHelper(androidx.compose.foundation.layout.Arrangement.Vertical r11, androidx.compose.foundation.layout.Arrangement.Horizontal r12, int r13, androidx.compose.runtime.Composer r14, int r15) {
        /*
            r0 = -2013098357(0xffffffff88028e8b, float:-3.928801E-34)
            r14.startReplaceableGroup(r0)
            java.lang.String r1 = "C(columnMeasurementHelper)P(2)178@6629L585:FlowLayout.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:177)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x0017:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r13)
            r0 = 1618982084(0x607fb4c4, float:7.370227E19)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            boolean r0 = r14.changed((java.lang.Object) r11)
            boolean r1 = r14.changed((java.lang.Object) r12)
            r0 = r0 | r1
            boolean r15 = r14.changed((java.lang.Object) r15)
            r15 = r15 | r0
            java.lang.Object r0 = r14.rememberedValue()
            if (r15 != 0) goto L_0x0042
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r0 != r15) goto L_0x005f
        L_0x0042:
            androidx.compose.foundation.layout.LayoutOrientation r2 = androidx.compose.foundation.layout.LayoutOrientation.Vertical
            float r5 = r11.m570getSpacingD9Ej5fM()
            androidx.compose.foundation.layout.SizeMode r6 = androidx.compose.foundation.layout.SizeMode.Wrap
            androidx.compose.foundation.layout.CrossAxisAlignment r7 = CROSS_AXIS_ALIGNMENT_START
            float r8 = r12.m552getSpacingD9Ej5fM()
            androidx.compose.foundation.layout.FlowMeasurePolicy r0 = new androidx.compose.foundation.layout.FlowMeasurePolicy
            r10 = 0
            r1 = r0
            r3 = r12
            r4 = r11
            r9 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.updateRememberedValue(r0)
        L_0x005f:
            r14.endReplaceableGroup()
            androidx.compose.foundation.layout.FlowMeasurePolicy r0 = (androidx.compose.foundation.layout.FlowMeasurePolicy) r0
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x006d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x006d:
            r14.endReplaceableGroup()
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.columnMeasurementHelper(androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, int, androidx.compose.runtime.Composer, int):androidx.compose.ui.layout.MeasurePolicy");
    }

    /* access modifiers changed from: private */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4) {
        int i5 = i;
        int size = list.size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = 0;
        }
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        for (int i7 = 0; i7 < size2; i7++) {
            iArr2[i7] = 0;
        }
        int size3 = list.size();
        for (int i8 = 0; i8 < size3; i8++) {
            List<? extends IntrinsicMeasurable> list2 = list;
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i8);
            Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function33 = function3;
            int intValue = function3.invoke(intrinsicMeasurable, Integer.valueOf(i8), Integer.valueOf(i)).intValue();
            iArr[i8] = intValue;
            iArr2[i8] = function32.invoke(intrinsicMeasurable, Integer.valueOf(i8), Integer.valueOf(intValue)).intValue();
        }
        List<? extends IntrinsicMeasurable> list3 = list;
        int sum = ArraysKt.sum(iArr);
        if (size2 != 0) {
            int i9 = iArr2[0];
            IntIterator it = new IntRange(1, ArraysKt.getLastIndex(iArr2)).iterator();
            while (it.hasNext()) {
                int i10 = iArr2[it.nextInt()];
                if (i9 < i10) {
                    i9 = i10;
                }
            }
            if (size != 0) {
                int i11 = iArr[0];
                IntIterator it2 = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
                while (it2.hasNext()) {
                    int i12 = iArr[it2.nextInt()];
                    if (i11 < i12) {
                        i11 = i12;
                    }
                }
                int i13 = sum;
                while (i11 < i13 && i9 != i5) {
                    int i14 = (i11 + i13) / 2;
                    i9 = intrinsicCrossAxisSize(list, iArr, iArr2, i14, i2, i3, i4);
                    if (i9 == i5) {
                        return i14;
                    }
                    if (i9 > i5) {
                        i11 = i14 + 1;
                    } else {
                        i13 = i14 - 1;
                    }
                    sum = i14;
                }
                return sum;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4) {
        return intrinsicCrossAxisSize(list, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) new FlowLayoutKt$intrinsicCrossAxisSize$1(iArr), (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) new FlowLayoutKt$intrinsicCrossAxisSize$2(iArr2), i, i2, i3, i4);
    }

    /* access modifiers changed from: private */
    public static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4) {
        List<? extends IntrinsicMeasurable> list2 = list;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function33 = function3;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function34 = function32;
        if (list.isEmpty()) {
            return 0;
        }
        Object orNull = CollectionsKt.getOrNull(list2, 0);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) orNull;
        int intValue = intrinsicMeasurable != null ? function34.invoke(intrinsicMeasurable, 0, Integer.valueOf(i)).intValue() : 0;
        int intValue2 = intrinsicMeasurable != null ? function33.invoke(intrinsicMeasurable, 0, Integer.valueOf(intValue)).intValue() : 0;
        int size = list.size();
        int i5 = i;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < size) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list2.get(i6);
            Intrinsics.checkNotNull(orNull);
            i5 -= intValue2;
            int max = Math.max(i8, intValue);
            i6++;
            Object orNull2 = CollectionsKt.getOrNull(list2, i6);
            IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) orNull2;
            int intValue3 = intrinsicMeasurable3 != null ? function34.invoke(intrinsicMeasurable3, Integer.valueOf(i6), Integer.valueOf(i)).intValue() : 0;
            int intValue4 = intrinsicMeasurable3 != null ? function33.invoke(intrinsicMeasurable3, Integer.valueOf(i6), Integer.valueOf(intValue3)).intValue() + i2 : 0;
            if (i5 < 0 || i6 == list.size()) {
                int i10 = i4;
            } else if (i6 - i9 != i4 && i5 - intValue4 >= 0) {
                int i11 = intValue3;
                i8 = max;
                orNull = orNull2;
                intValue2 = intValue4;
                intValue = i11;
            }
            i7 += max + i3;
            intValue4 -= i2;
            i5 = i;
            max = 0;
            i9 = i6;
            int i112 = intValue3;
            i8 = max;
            orNull = orNull2;
            intValue2 = intValue4;
            intValue = i112;
        }
        return i7 - i3;
    }

    public static final int mainAxisMin(Measurable measurable, LayoutOrientation layoutOrientation, int i) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return measurable.minIntrinsicWidth(i);
        }
        return measurable.minIntrinsicHeight(i);
    }

    public static final int crossAxisMin(Measurable measurable, LayoutOrientation layoutOrientation, int i) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return measurable.minIntrinsicHeight(i);
        }
        return measurable.minIntrinsicWidth(i);
    }

    public static final int mainAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    public static final int crossAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: measureAndCache-6m2dt9o  reason: not valid java name */
    private static final int m608measureAndCache6m2dt9o(Measurable measurable, long j, LayoutOrientation layoutOrientation, Function1<? super Placeable, Unit> function1) {
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable)) != 0.0f) {
            return mainAxisMin(measurable, layoutOrientation, Integer.MAX_VALUE);
        }
        Placeable r9 = measurable.m5368measureBRTryo0(OrientationIndependentConstraints.m652toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m641copyyUG9Ft0$default(j, 0, 0, 0, 0, 14, (Object) null), layoutOrientation));
        function1.invoke(r9);
        return mainAxisSize(r9, layoutOrientation);
    }

    /* access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < size) {
            int intValue = function3.invoke((IntrinsicMeasurable) list.get(i4), Integer.valueOf(i4), Integer.valueOf(i)).intValue() + i2;
            int i8 = i4 + 1;
            if (i8 - i6 == i3 || i8 == list.size()) {
                i5 = Math.max(i5, (i7 + intValue) - i2);
                i7 = 0;
                i6 = i4;
            } else {
                i7 += intValue;
            }
            i4 = i8;
        }
        return i5;
    }

    /* renamed from: breakDownItems-w1Onq5I  reason: not valid java name */
    public static final FlowResult m607breakDownItemsw1Onq5I(MeasureScope measureScope, RowColumnMeasurementHelper rowColumnMeasurementHelper, LayoutOrientation layoutOrientation, long j, int i) {
        LayoutOrientation layoutOrientation2 = layoutOrientation;
        MutableVector mutableVector = new MutableVector(new RowColumnMeasureHelperResult[16], 0);
        int r2 = Constraints.m6526getMaxWidthimpl(j);
        int r4 = Constraints.m6528getMinWidthimpl(j);
        int r5 = Constraints.m6525getMaxHeightimpl(j);
        List<Measurable> measurables = rowColumnMeasurementHelper.getMeasurables();
        Placeable[] placeables = rowColumnMeasurementHelper.getPlaceables();
        int ceil = (int) ((float) Math.ceil((double) measureScope.m6550toPx0680j_4(rowColumnMeasurementHelper.m713getArrangementSpacingD9Ej5fM())));
        long r9 = OrientationIndependentConstraints.m637constructorimpl(r4, r2, 0, r5);
        Measurable measurable = (Measurable) CollectionsKt.getOrNull(measurables, 0);
        Integer valueOf = measurable != null ? Integer.valueOf(m608measureAndCache6m2dt9o(measurable, r9, layoutOrientation2, new FlowLayoutKt$breakDownItems$nextSize$1(placeables))) : null;
        Integer[] numArr = new Integer[measurables.size()];
        int size = measurables.size();
        int i2 = r2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < size) {
            Intrinsics.checkNotNull(valueOf);
            int intValue = valueOf.intValue();
            int i7 = i4 + intValue;
            i2 -= intValue;
            int i8 = i3 + 1;
            Measurable measurable2 = (Measurable) CollectionsKt.getOrNull(measurables, i8);
            int i9 = size;
            Integer valueOf2 = measurable2 != null ? Integer.valueOf(m608measureAndCache6m2dt9o(measurable2, r9, layoutOrientation2, new FlowLayoutKt$breakDownItems$1(placeables, i3)) + ceil) : null;
            if (i8 >= measurables.size()) {
                int i10 = i;
            } else if (i8 - i5 < i) {
                if (i2 - (valueOf2 != null ? valueOf2.intValue() : 0) >= 0) {
                    i3 = i8;
                    size = i9;
                    valueOf = valueOf2;
                    i4 = i7;
                }
            }
            r4 = Math.min(Math.max(r4, i7), r2);
            numArr[i6] = Integer.valueOf(i8);
            i6++;
            valueOf2 = valueOf2 != null ? Integer.valueOf(valueOf2.intValue() - ceil) : null;
            i2 = r2;
            i5 = i8;
            i7 = 0;
            i3 = i8;
            size = i9;
            valueOf = valueOf2;
            i4 = i7;
        }
        long r22 = OrientationIndependentConstraints.m652toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m641copyyUG9Ft0$default(r9, r4, 0, 0, 0, 14, (Object) null), layoutOrientation2);
        int i11 = 0;
        int i12 = 0;
        Integer num = (Integer) ArraysKt.getOrNull((T[]) numArr, 0);
        int i13 = r4;
        int i14 = 0;
        while (num != null) {
            Integer[] numArr2 = numArr;
            RowColumnMeasureHelperResult r7 = rowColumnMeasurementHelper.m714measureWithoutPlacing_EkL_Y(measureScope, r22, i12, num.intValue());
            i11 += r7.getCrossAxisSize();
            i13 = Math.max(i13, r7.getMainAxisSize());
            mutableVector.add(r7);
            i12 = num.intValue();
            i14++;
            num = (Integer) ArraysKt.getOrNull((T[]) numArr2, i14);
            numArr = numArr2;
        }
        return new FlowResult(Math.max(i13, Constraints.m6528getMinWidthimpl(j)), Math.max(i11, Constraints.m6527getMinHeightimpl(j)), mutableVector);
    }
}
