package androidx.compose.foundation;

import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Canvas", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "contentDescription", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Canvas.kt */
public final class CanvasKt {
    public static final void Canvas(Modifier modifier, Function1<? super DrawScope, Unit> function1, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-932836462);
        ComposerKt.sourceInformation(startRestartGroup, "C(Canvas)42@1876L35:Canvas.kt#71ulvw");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-932836462, i2, -1, "androidx.compose.foundation.Canvas (Canvas.kt:42)");
            }
            SpacerKt.Spacer(DrawModifierKt.drawBehind(modifier, function1), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CanvasKt$Canvas$1(modifier, function1, i));
        }
    }

    public static final void Canvas(Modifier modifier, String str, Function1<? super DrawScope, Unit> function1, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1162737955);
        ComposerKt.sourceInformation(startRestartGroup, "C(Canvas)P(1)63@3131L94:Canvas.kt#71ulvw");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) str) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162737955, i2, -1, "androidx.compose.foundation.Canvas (Canvas.kt:63)");
            }
            Modifier drawBehind = DrawModifierKt.drawBehind(modifier, function1);
            startRestartGroup.startReplaceableGroup(-403028284);
            boolean changed = startRestartGroup.changed((Object) str);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new CanvasKt$Canvas$2$1(str);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(SemanticsModifierKt.semantics$default(drawBehind, false, (Function1) rememberedValue, 1, (Object) null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CanvasKt$Canvas$3(modifier, str, function1, i));
        }
    }
}
