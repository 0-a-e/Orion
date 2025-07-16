package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"ProvideContentColorTextStyle", "", "contentColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ProvideContentColorTextStyle-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProvideContentColorTextStyle.kt */
public final class ProvideContentColorTextStyleKt {
    /* renamed from: ProvideContentColorTextStyle-3J-VO9M  reason: not valid java name */
    public static final void m2082ProvideContentColorTextStyle3JVO9M(long j, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1479790536);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideContentColorTextStyle)P(1:c#ui.graphics.Color,2)37@1313L7,38@1342L151:ProvideContentColorTextStyle.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1479790536, i2, -1, "androidx.compose.material3.ProvideContentColorTextStyle (ProvideContentColorTextStyle.kt:36)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j)), TextKt.getLocalTextStyle().provides(((TextStyle) consume).merge(textStyle))}, function2, startRestartGroup, (i2 >> 3) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProvideContentColorTextStyleKt$ProvideContentColorTextStyle$1(j, textStyle, function2, i));
        }
    }
}
