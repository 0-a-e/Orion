package androidx.compose.ui.platform;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda3 implements Comparator {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda3(Function2 function2) {
        this.f$0 = function2;
    }

    public final int compare(Object obj, Object obj2) {
        return AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings$lambda$7(this.f$0, obj, obj2);
    }
}
