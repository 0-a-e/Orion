package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"StretchOverscrollNonClippingLayer", "Landroidx/compose/ui/Modifier;", "rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.android.kt */
public final class AndroidOverscroll_androidKt {
    /* access modifiers changed from: private */
    public static final Modifier StretchOverscrollNonClippingLayer;

    public static final OverscrollEffect rememberOverscrollEffect(Composer composer, int i) {
        OverscrollEffect overscrollEffect;
        composer.startReplaceableGroup(-1476348564);
        ComposerKt.sourceInformation(composer, "C(rememberOverscrollEffect)65@2883L7,66@2937L7,68@2986L80:AndroidOverscroll.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1476348564, i, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.android.kt:64)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) consume2;
        if (overscrollConfiguration != null) {
            composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = composer.changed((Object) context) | composer.changed((Object) overscrollConfiguration);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            overscrollEffect = (OverscrollEffect) rememberedValue;
        } else {
            overscrollEffect = NoOpOverscrollEffect.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return overscrollEffect;
    }

    static {
        Modifier modifier;
        if (Build.VERSION.SDK_INT >= 31) {
            modifier = LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.Companion, AndroidOverscroll_androidKt$StretchOverscrollNonClippingLayer$1.INSTANCE), AndroidOverscroll_androidKt$StretchOverscrollNonClippingLayer$2.INSTANCE);
        } else {
            modifier = Modifier.Companion;
        }
        StretchOverscrollNonClippingLayer = modifier;
    }
}
