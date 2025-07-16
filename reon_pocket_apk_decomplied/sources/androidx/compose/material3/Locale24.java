package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/material3/Locale24;", "", "()V", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActualAndroid.android.kt */
final class Locale24 {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/Locale24$Companion;", "", "()V", "defaultLocale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/Locale;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ActualAndroid.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Locale defaultLocale(Composer composer, int i) {
            ComposerKt.sourceInformationMarkerStart(composer, 169072322, "C(defaultLocale)46@1523L7:ActualAndroid.android.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(169072322, i, -1, "androidx.compose.material3.Locale24.Companion.defaultLocale (ActualAndroid.android.kt:45)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Locale m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m((Configuration) consume).get(0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return m;
        }
    }
}
