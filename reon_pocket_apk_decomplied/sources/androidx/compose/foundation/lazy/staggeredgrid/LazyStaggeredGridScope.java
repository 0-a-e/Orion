package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH&¢\u0006\u0002\u0010\rJ½\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t21\u0010\u0014\u001a-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH&¢\u0006\u0002\u0010\u0016\u0001\u0001\u0017ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "", "item", "", "key", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@LazyStaggeredGridScopeMarker
/* compiled from: LazyStaggeredGridDsl.kt */
public interface LazyStaggeredGridScope {
    void item(Object obj, Object obj2, StaggeredGridItemSpan staggeredGridItemSpan, Function3<? super LazyStaggeredGridItemScope, ? super Composer, ? super Integer, Unit> function3);

    void items(int i, Function1<? super Integer, ? extends Object> function1, Function1<? super Integer, ? extends Object> function12, Function1<? super Integer, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4);

    /* renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope$-CC  reason: invalid class name */
    /* compiled from: LazyStaggeredGridDsl.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void item$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object obj, Object obj2, StaggeredGridItemSpan staggeredGridItemSpan, Function3 function3, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                if ((i & 4) != 0) {
                    staggeredGridItemSpan = null;
                }
                lazyStaggeredGridScope.item(obj, obj2, staggeredGridItemSpan, function3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }

        public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, int i, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i2, Object obj) {
            if (obj == null) {
                Function1 function14 = (i2 & 2) != 0 ? null : function1;
                if ((i2 & 4) != 0) {
                    function12 = LazyStaggeredGridScope$items$1.INSTANCE;
                }
                lazyStaggeredGridScope.items(i, function14, function12, (i2 & 8) != 0 ? null : function13, function4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
    }
}
