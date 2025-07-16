package androidx.compose.ui.platform;

import androidx.compose.ui.semantics.SemanticsNode;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1<T> implements Comparator {
    final /* synthetic */ Comparator $comparator;
    final /* synthetic */ Comparator $this_thenBy;

    public AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(Comparator comparator, Comparator comparator2) {
        this.$this_thenBy = comparator;
        this.$comparator = comparator2;
    }

    public final int compare(T t, T t2) {
        int compare = this.$this_thenBy.compare(t, t2);
        return compare != 0 ? compare : this.$comparator.compare(((SemanticsNode) t).getLayoutNode$ui_release(), ((SemanticsNode) t2).getLayoutNode$ui_release());
    }
}
