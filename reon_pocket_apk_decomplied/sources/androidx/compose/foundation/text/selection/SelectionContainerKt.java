package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0002"}, d2 = {"DisableSelection", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionContainer", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
public final class SelectionContainerKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SelectionContainer(androidx.compose.ui.Modifier r8, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = -1075498320(0xffffffffbfe532b0, float:-1.7906094)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r1 = "C(SelectionContainer)P(1)43@1784L45,44@1834L180:SelectionContainer.kt#eksfi3"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r12 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0014
            r3 = r11 | 6
            goto L_0x0024
        L_0x0014:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x0023
            boolean r3 = r10.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0020
            r3 = 4
            goto L_0x0021
        L_0x0020:
            r3 = r2
        L_0x0021:
            r3 = r3 | r11
            goto L_0x0024
        L_0x0023:
            r3 = r11
        L_0x0024:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x002b
            r3 = r3 | 48
            goto L_0x003b
        L_0x002b:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x003b
            boolean r4 = r10.changedInstance(r9)
            if (r4 == 0) goto L_0x0038
            r4 = 32
            goto L_0x003a
        L_0x0038:
            r4 = 16
        L_0x003a:
            r3 = r3 | r4
        L_0x003b:
            r4 = r3 & 91
            r5 = 18
            if (r4 != r5) goto L_0x004d
            boolean r4 = r10.getSkipping()
            if (r4 != 0) goto L_0x0048
            goto L_0x004d
        L_0x0048:
            r10.skipToGroupEnd()
            goto L_0x00c9
        L_0x004d:
            if (r1 == 0) goto L_0x0053
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x0053:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x005f
            r1 = -1
            java.lang.String r4 = "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:42)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r4)
        L_0x005f:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x007e
            r0 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r2, r0)
            r10.updateRememberedValue(r0)
        L_0x007e:
            r10.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.foundation.text.selection.Selection r2 = SelectionContainer$lambda$1(r0)
            r1 = -861885378(0xffffffffcca0ac3e, float:-8.4238832E7)
            r10.startReplaceableGroup(r1)
            boolean r1 = r10.changed((java.lang.Object) r0)
            java.lang.Object r4 = r10.rememberedValue()
            if (r1 != 0) goto L_0x009f
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r4 != r1) goto L_0x00aa
        L_0x009f:
            androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1 r1 = new androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
            r1.<init>(r0)
            r4 = r1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r10.updateRememberedValue(r4)
        L_0x00aa:
            r0 = r4
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r10.endReplaceableGroup()
            r1 = r3 & 14
            int r3 = r3 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | r3
            r7 = 0
            r1 = r8
            r3 = r0
            r4 = r9
            r5 = r10
            SelectionContainer(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00c9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00c9:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 == 0) goto L_0x00d9
            androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2 r0 = new androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2
            r0.<init>(r8, r9, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        return (Selection) mutableState.getValue();
    }

    public static final void DisableSelection(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(336063542);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableSelection)62@2305L104:SelectionContainer.kt#eksfi3");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(336063542, i2, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:61)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null), function2, startRestartGroup, (i2 << 3) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectionContainerKt$DisableSelection$1(function2, i));
        }
    }

    public static final void SelectionContainer(Modifier modifier, Selection selection, Function1<? super Selection, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2078139907);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionContainer)P(1,3,2)85@3010L95,89@3125L44,91@3220L7,92@3281L7,93@3332L7,97@3429L2085,143@5520L132:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) selection) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078139907, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:84)");
            }
            SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) RememberSaveableKt.rememberSaveable(new Object[0], SelectionRegistrarImpl.Companion.getSaver(), (String) null, SelectionContainerKt$SelectionContainer$registrarImpl$1.INSTANCE, startRestartGroup, 3144, 4);
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SelectionManager(selectionRegistrarImpl);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SelectionManager selectionManager = (SelectionManager) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setHapticFeedBack((HapticFeedback) consume);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setClipboardManager((ClipboardManager) consume2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setTextToolbar((TextToolbar) consume3);
            selectionManager.setOnSelectionChange(function1);
            selectionManager.setSelection(selection);
            startRestartGroup.startReplaceableGroup(605522716);
            ComposerKt.sourceInformation(startRestartGroup, "CC(ContextMenuArea)P(1)37@1206L9:ContextMenu.android.kt#423gt5");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1279221227, "C98@3464L2044:SelectionContainer.kt#eksfi3");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) SelectionRegistrarKt.getLocalSelectionRegistrar().provides(selectionRegistrarImpl), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 935424596, true, new SelectionContainerKt$SelectionContainer$3$1(modifier, selectionManager, function2)), startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect((Object) selectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SelectionContainerKt$SelectionContainer$4(selectionManager), startRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectionContainerKt$SelectionContainer$5(modifier2, selection, function1, function2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void SelectionContainer$lambda$2(MutableState<Selection> mutableState, Selection selection) {
        mutableState.setValue(selection);
    }
}
