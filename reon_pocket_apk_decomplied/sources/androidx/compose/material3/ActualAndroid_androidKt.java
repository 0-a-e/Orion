package androidx.compose.material3;

import android.content.res.Configuration;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"defaultLocale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/Locale;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActualAndroid.android.kt */
public final class ActualAndroid_androidKt {
    public static final Locale defaultLocale(Composer composer, int i) {
        Locale locale;
        ComposerKt.sourceInformationMarkerStart(composer, 661006346, "C(defaultLocale):ActualAndroid.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(661006346, i, -1, "androidx.compose.material3.defaultLocale (ActualAndroid.android.kt:32)");
        }
        if (Build.VERSION.SDK_INT >= 24) {
            composer.startReplaceableGroup(-273864580);
            ComposerKt.sourceInformation(composer, "34@1191L15");
            locale = Locale24.Companion.defaultLocale(composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-273864534);
            ComposerKt.sourceInformation(composer, "36@1278L7");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            locale = ConfigurationCompat.getLocales((Configuration) consume).get(0);
            if (locale == null) {
                locale = Locale.getDefault();
            }
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return locale;
    }
}
