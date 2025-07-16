package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aJ\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\b¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u0015\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0016"}, d2 = {"DefaultColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultColumnMeasurePolicy$annotations", "()V", "getDefaultColumnMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Column", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Column.kt */
public final class ColumnKt {
    private static final MeasurePolicy DefaultColumnMeasurePolicy = new RowColumnMeasurePolicy(LayoutOrientation.Vertical, (Arrangement.Horizontal) null, Arrangement.INSTANCE.getTop(), Arrangement.INSTANCE.getTop().m570getSpacingD9Ej5fM(), SizeMode.Wrap, CrossAxisAlignment.Companion.horizontal$foundation_layout_release(Alignment.Companion.getStart()), (DefaultConstructorMarker) null);

    public static /* synthetic */ void getDefaultColumnMeasurePolicy$annotations() {
    }

    public static final void Column(Modifier modifier, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        if ((i2 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i2 & 2) != 0) {
            vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i2 & 4) != 0) {
            horizontal = Alignment.Companion.getStart();
        }
        MeasurePolicy columnMeasurePolicy = columnMeasurePolicy(vertical, horizontal, composer, (i >> 3) & 126);
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
        Composer r1 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r1, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r1.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
        function3.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i >> 6) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final MeasurePolicy getDefaultColumnMeasurePolicy() {
        return DefaultColumnMeasurePolicy;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.compose.foundation.layout.RowColumnMeasurePolicy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.foundation.layout.RowColumnMeasurePolicy} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0054;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.layout.MeasurePolicy columnMeasurePolicy(androidx.compose.foundation.layout.Arrangement.Vertical r9, androidx.compose.ui.Alignment.Horizontal r10, androidx.compose.runtime.Composer r11, int r12) {
        /*
            r0 = 1089876336(0x40f63170, float:7.693535)
            r11.startReplaceableGroup(r0)
            java.lang.String r1 = "C(columnMeasurePolicy)P(1)104@4766L476:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:101)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
        L_0x0017:
            androidx.compose.foundation.layout.Arrangement r12 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r12 = r12.getTop()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0032
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r12 = r12.getStart()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0032
            androidx.compose.ui.layout.MeasurePolicy r9 = DefaultColumnMeasurePolicy
            goto L_0x0074
        L_0x0032:
            r12 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            boolean r12 = r11.changed((java.lang.Object) r9)
            boolean r0 = r11.changed((java.lang.Object) r10)
            r12 = r12 | r0
            java.lang.Object r0 = r11.rememberedValue()
            if (r12 != 0) goto L_0x0054
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r0 != r12) goto L_0x006e
        L_0x0054:
            androidx.compose.foundation.layout.LayoutOrientation r2 = androidx.compose.foundation.layout.LayoutOrientation.Vertical
            float r5 = r9.m570getSpacingD9Ej5fM()
            androidx.compose.foundation.layout.CrossAxisAlignment$Companion r12 = androidx.compose.foundation.layout.CrossAxisAlignment.Companion
            androidx.compose.foundation.layout.CrossAxisAlignment r7 = r12.horizontal$foundation_layout_release(r10)
            androidx.compose.foundation.layout.SizeMode r6 = androidx.compose.foundation.layout.SizeMode.Wrap
            androidx.compose.foundation.layout.RowColumnMeasurePolicy r0 = new androidx.compose.foundation.layout.RowColumnMeasurePolicy
            r3 = 0
            r8 = 0
            r1 = r0
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r11.updateRememberedValue(r0)
        L_0x006e:
            r11.endReplaceableGroup()
            r9 = r0
            androidx.compose.ui.layout.MeasurePolicy r9 = (androidx.compose.ui.layout.MeasurePolicy) r9
        L_0x0074:
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x007d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x007d:
            r11.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.runtime.Composer, int):androidx.compose.ui.layout.MeasurePolicy");
    }
}
