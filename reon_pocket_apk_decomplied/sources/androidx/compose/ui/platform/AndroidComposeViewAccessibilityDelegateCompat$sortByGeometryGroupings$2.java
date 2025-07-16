package androidx.compose.ui.platform;

import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "a", "Landroidx/compose/ui/semantics/SemanticsNode;", "kotlin.jvm.PlatformType", "b", "invoke", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
final class AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 extends Lambda implements Function2<SemanticsNode, SemanticsNode, Integer> {
    public static final AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2();

    AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2() {
        super(2);
    }

    public final Integer invoke(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return Integer.valueOf(Float.compare(((Number) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), AndroidComposeViewAccessibilityDelegateCompat_androidKt$traversalIndex$1.INSTANCE)).floatValue(), ((Number) semanticsNode2.getConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), AndroidComposeViewAccessibilityDelegateCompat_androidKt$traversalIndex$1.INSTANCE)).floatValue()));
    }
}
