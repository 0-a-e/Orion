package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.activity.ViewTreeFullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/activity/compose/LocalFullyDrawnReporterOwner;", "", "()V", "LocalFullyDrawnReporterOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/FullyDrawnReporterOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/FullyDrawnReporterOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "fullyDrawnReporterOwner", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReportDrawn.kt */
public final class LocalFullyDrawnReporterOwner {
    public static final int $stable = 0;
    public static final LocalFullyDrawnReporterOwner INSTANCE = new LocalFullyDrawnReporterOwner();
    private static final ProvidableCompositionLocal<FullyDrawnReporterOwner> LocalFullyDrawnReporterOwner = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, LocalFullyDrawnReporterOwner$LocalFullyDrawnReporterOwner$1.INSTANCE, 1, (Object) null);

    private LocalFullyDrawnReporterOwner() {
    }

    public final FullyDrawnReporterOwner getCurrent(Composer composer, int i) {
        composer.startReplaceableGroup(540186968);
        ComposerKt.sourceInformation(composer, "C105@3596L7,*107@3738L7:ReportDrawn.kt#q1dkbc");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalFullyDrawnReporterOwner);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FullyDrawnReporterOwner fullyDrawnReporterOwner = (FullyDrawnReporterOwner) consume;
        composer.startReplaceableGroup(1606493384);
        ComposerKt.sourceInformation(composer, "106@3629L7");
        if (fullyDrawnReporterOwner == null) {
            ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(composer);
            fullyDrawnReporterOwner = ViewTreeFullyDrawnReporterOwner.get((View) consume2);
        }
        composer.endReplaceableGroup();
        if (fullyDrawnReporterOwner == null) {
            ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Context context = (Context) consume3;
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    context = null;
                    break;
                } else if (context instanceof FullyDrawnReporterOwner) {
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            fullyDrawnReporterOwner = (FullyDrawnReporterOwner) context;
        }
        composer.endReplaceableGroup();
        return fullyDrawnReporterOwner;
    }

    public final ProvidedValue<FullyDrawnReporterOwner> provides(FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        return LocalFullyDrawnReporterOwner.provides(fullyDrawnReporterOwner);
    }
}
