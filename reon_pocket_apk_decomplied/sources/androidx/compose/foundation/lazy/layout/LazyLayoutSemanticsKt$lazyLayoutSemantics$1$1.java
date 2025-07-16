package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ ScrollAxisRange $accessibilityScrollState;
    final /* synthetic */ CollectionInfo $collectionInfo;
    final /* synthetic */ Function1<Object, Integer> $indexForKeyMapping;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function2<Float, Float, Boolean> $scrollByAction;
    final /* synthetic */ Function1<Integer, Boolean> $scrollToIndexAction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1(Function1<Object, Integer> function1, boolean z, ScrollAxisRange scrollAxisRange, Function2<? super Float, ? super Float, Boolean> function2, Function1<? super Integer, Boolean> function12, CollectionInfo collectionInfo) {
        super(1);
        this.$indexForKeyMapping = function1;
        this.$isVertical = z;
        this.$accessibilityScrollState = scrollAxisRange;
        this.$scrollByAction = function2;
        this.$scrollToIndexAction = function12;
        this.$collectionInfo = collectionInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        SemanticsPropertiesKt.indexForKey(semanticsPropertyReceiver, this.$indexForKeyMapping);
        if (this.$isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, this.$accessibilityScrollState);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, this.$accessibilityScrollState);
        }
        Function2<Float, Float, Boolean> function2 = this.$scrollByAction;
        if (function2 != null) {
            SemanticsPropertiesKt.scrollBy$default(semanticsPropertyReceiver, (String) null, function2, 1, (Object) null);
        }
        Function1<Integer, Boolean> function1 = this.$scrollToIndexAction;
        if (function1 != null) {
            SemanticsPropertiesKt.scrollToIndex$default(semanticsPropertyReceiver, (String) null, function1, 1, (Object) null);
        }
        SemanticsPropertiesKt.setCollectionInfo(semanticsPropertyReceiver, this.$collectionInfo);
    }
}
