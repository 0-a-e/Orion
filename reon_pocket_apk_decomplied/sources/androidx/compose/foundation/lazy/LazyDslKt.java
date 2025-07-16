package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001al\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001av\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a©\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u0010+\u001a\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u0010,\u001a©\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u0010.\u001a\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u0010/\u001aè\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u00104\u001a¬\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u00105\u001aè\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u00106\u001a¬\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u00107¨\u00068"}, d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class LazyDslKt {
    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        Function1 function13 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyDslKt$items$1.INSTANCE;
        }
        int size = list.size();
        if (function1 != null) {
            function13 = new LazyDslKt$items$2(function1, list);
        }
        lazyListScope.items(size, function13, new LazyDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static final <T> void items(LazyListScope lazyListScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = LazyDslKt$itemsIndexed$1.INSTANCE;
        }
        int size = list.size();
        if (function2 != null) {
            function1 = new LazyDslKt$itemsIndexed$2(function2, list);
        }
        lazyListScope.items(size, function1, new LazyDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        Function1 function13 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyDslKt$items$5.INSTANCE;
        }
        int length = objArr.length;
        if (function1 != null) {
            function13 = new LazyDslKt$items$6(function1, objArr);
        }
        lazyListScope.items(length, function13, new LazyDslKt$items$7(function12, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, objArr)));
    }

    public static final <T> void items(LazyListScope lazyListScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(tArr.length, function1 != null ? new LazyDslKt$items$6(function1, tArr) : null, new LazyDslKt$items$7(function12, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = LazyDslKt$itemsIndexed$5.INSTANCE;
        }
        int length = objArr.length;
        if (function2 != null) {
            function1 = new LazyDslKt$itemsIndexed$6(function2, objArr);
        }
        lazyListScope.items(length, function1, new LazyDslKt$itemsIndexed$7(function22, objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(tArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, tArr) : null, new LazyDslKt$itemsIndexed$7(function22, tArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, tArr)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyRow(androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.LazyListState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Horizontal r33, androidx.compose.ui.Alignment.Vertical r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r10 = r39
            r11 = r40
            r0 = -1724297413(0xffffffff99394f3b, float:-9.580276E-24)
            r1 = r38
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LazyRow)P(4,6,1,5,3,8,2,7)294@14218L23,300@14569L15,304@14671L389:LazyDsl.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r10 | 6
            r4 = r3
            r3 = r29
            goto L_0x0030
        L_0x001c:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x002d
            r3 = r29
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r10
            goto L_0x0030
        L_0x002d:
            r3 = r29
            r4 = r10
        L_0x0030:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0049
            r5 = r11 & 2
            if (r5 != 0) goto L_0x0043
            r5 = r30
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0043:
            r5 = r30
        L_0x0045:
            r6 = 16
        L_0x0047:
            r4 = r4 | r6
            goto L_0x004b
        L_0x0049:
            r5 = r30
        L_0x004b:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0052
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0065
            r7 = r31
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0061
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r8
            goto L_0x0067
        L_0x0065:
            r7 = r31
        L_0x0067:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r9 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0081
            r9 = r32
            boolean r12 = r1.changed((boolean) r9)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r12
            goto L_0x0083
        L_0x0081:
            r9 = r32
        L_0x0083:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x009e
            r12 = r11 & 16
            if (r12 != 0) goto L_0x0098
            r12 = r33
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x009a
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r12 = r33
        L_0x009a:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r4 = r4 | r13
            goto L_0x00a0
        L_0x009e:
            r12 = r33
        L_0x00a0:
            r13 = r11 & 32
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r13 == 0) goto L_0x00aa
            r15 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r15
            goto L_0x00be
        L_0x00aa:
            r15 = r10 & r14
            if (r15 != 0) goto L_0x00be
            r15 = r34
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r4 = r4 | r16
            goto L_0x00c0
        L_0x00be:
            r15 = r34
        L_0x00c0:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r10 & r16
            if (r17 != 0) goto L_0x00da
            r17 = r11 & 64
            r14 = r35
            if (r17 != 0) goto L_0x00d5
            boolean r17 = r1.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x00d5
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r4 = r4 | r17
            goto L_0x00dc
        L_0x00da:
            r14 = r35
        L_0x00dc:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00e7
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r18
            r3 = r36
            goto L_0x00fc
        L_0x00e7:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r10 & r18
            r3 = r36
            if (r18 != 0) goto L_0x00fc
            boolean r18 = r1.changed((boolean) r3)
            if (r18 == 0) goto L_0x00f8
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f8:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r4 = r4 | r18
        L_0x00fc:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0104
            r3 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r3
            goto L_0x0119
        L_0x0104:
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r10
            if (r3 != 0) goto L_0x0119
            r3 = r37
            boolean r18 = r1.changedInstance(r3)
            if (r18 == 0) goto L_0x0114
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0116
        L_0x0114:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0116:
            r4 = r4 | r18
            goto L_0x011b
        L_0x0119:
            r3 = r37
        L_0x011b:
            r18 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r4 & r18
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r5) goto L_0x013c
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x012c
            goto L_0x013c
        L_0x012c:
            r1.skipToGroupEnd()
            r2 = r29
            r3 = r30
            r6 = r7
            r4 = r9
            r5 = r12
            r7 = r14
            r8 = r15
            r9 = r36
            goto L_0x0232
        L_0x013c:
            r1.startDefaults()
            r3 = r10 & 1
            r5 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x0171
            boolean r3 = r1.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0150
            goto L_0x0171
        L_0x0150:
            r1.skipToGroupEnd()
            r0 = r11 & 2
            if (r0 == 0) goto L_0x0159
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0159:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x015f
            r4 = r4 & r18
        L_0x015f:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0164
            r4 = r4 & r5
        L_0x0164:
            r2 = r29
            r3 = r30
            r0 = r36
            r6 = r7
            r5 = r9
            r7 = r12
            r9 = r14
            r8 = r15
            goto L_0x01d0
        L_0x0171:
            if (r2 == 0) goto L_0x0178
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x017a
        L_0x0178:
            r2 = r29
        L_0x017a:
            r3 = r11 & 2
            r5 = 0
            if (r3 == 0) goto L_0x0187
            r3 = 3
            androidx.compose.foundation.lazy.LazyListState r3 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r5, r5, r1, r5, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0189
        L_0x0187:
            r3 = r30
        L_0x0189:
            if (r6 == 0) goto L_0x0195
            float r6 = (float) r5
            float r6 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r6)
            androidx.compose.foundation.layout.PaddingValues r6 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r6)
            goto L_0x0196
        L_0x0195:
            r6 = r7
        L_0x0196:
            if (r8 == 0) goto L_0x0199
            goto L_0x019a
        L_0x0199:
            r5 = r9
        L_0x019a:
            r7 = r11 & 16
            if (r7 == 0) goto L_0x01ae
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r5 != 0) goto L_0x01a7
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getStart()
            goto L_0x01ab
        L_0x01a7:
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getEnd()
        L_0x01ab:
            r4 = r4 & r18
            goto L_0x01af
        L_0x01ae:
            r7 = r12
        L_0x01af:
            if (r13 == 0) goto L_0x01b8
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r8.getTop()
            goto L_0x01b9
        L_0x01b8:
            r8 = r15
        L_0x01b9:
            r9 = r11 & 64
            if (r9 == 0) goto L_0x01c9
            androidx.compose.foundation.gestures.ScrollableDefaults r9 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r12 = 6
            androidx.compose.foundation.gestures.FlingBehavior r9 = r9.flingBehavior(r1, r12)
            r12 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r12
            goto L_0x01ca
        L_0x01c9:
            r9 = r14
        L_0x01ca:
            if (r0 == 0) goto L_0x01ce
            r0 = 1
            goto L_0x01d0
        L_0x01ce:
            r0 = r36
        L_0x01d0:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01e2
            r12 = -1
            java.lang.String r13 = "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:303)"
            r14 = -1724297413(0xffffffff99394f3b, float:-9.580276E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r4, r12, r13)
        L_0x01e2:
            r12 = r4 & 14
            r12 = r12 | 24576(0x6000, float:3.4438E-41)
            r13 = r4 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            r13 = r4 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            r13 = r4 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            int r13 = r4 >> 3
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r13
            r12 = r12 | r14
            r13 = r13 & r16
            r26 = r12 | r13
            int r12 = r4 >> 15
            r12 = r12 & 14
            int r13 = r4 >> 9
            r13 = r13 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            int r4 = r4 >> 18
            r4 = r4 & 896(0x380, float:1.256E-42)
            r27 = r12 | r4
            r28 = 896(0x380, float:1.256E-42)
            r16 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r12 = r2
            r13 = r3
            r14 = r6
            r15 = r5
            r17 = r9
            r18 = r0
            r22 = r8
            r23 = r7
            r24 = r37
            r25 = r1
            androidx.compose.foundation.lazy.LazyListKt.LazyList(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x022e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x022e:
            r4 = r5
            r5 = r7
            r7 = r9
            r9 = r0
        L_0x0232:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x024e
            androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1 r13 = new androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1
            r0 = r13
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r9
            r9 = r37
            r10 = r39
            r11 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x024e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyColumn(androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.LazyListState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Vertical r33, androidx.compose.ui.Alignment.Horizontal r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r10 = r39
            r11 = r40
            r0 = -740714857(0xffffffffd3d99697, float:-1.86906876E12)
            r1 = r38
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LazyColumn)P(4,6,1,5,8,3,2,7)350@17150L23,356@17504L15,360@17606L388:LazyDsl.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r10 | 6
            r4 = r3
            r3 = r29
            goto L_0x0030
        L_0x001c:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x002d
            r3 = r29
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r10
            goto L_0x0030
        L_0x002d:
            r3 = r29
            r4 = r10
        L_0x0030:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0049
            r5 = r11 & 2
            if (r5 != 0) goto L_0x0043
            r5 = r30
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0043:
            r5 = r30
        L_0x0045:
            r6 = 16
        L_0x0047:
            r4 = r4 | r6
            goto L_0x004b
        L_0x0049:
            r5 = r30
        L_0x004b:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0052
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0065
            r7 = r31
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0061
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r8
            goto L_0x0067
        L_0x0065:
            r7 = r31
        L_0x0067:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r9 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0081
            r9 = r32
            boolean r12 = r1.changed((boolean) r9)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r12
            goto L_0x0083
        L_0x0081:
            r9 = r32
        L_0x0083:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x009e
            r12 = r11 & 16
            if (r12 != 0) goto L_0x0098
            r12 = r33
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x009a
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r12 = r33
        L_0x009a:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r4 = r4 | r13
            goto L_0x00a0
        L_0x009e:
            r12 = r33
        L_0x00a0:
            r13 = r11 & 32
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r13 == 0) goto L_0x00aa
            r15 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r15
            goto L_0x00be
        L_0x00aa:
            r15 = r10 & r14
            if (r15 != 0) goto L_0x00be
            r15 = r34
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r4 = r4 | r16
            goto L_0x00c0
        L_0x00be:
            r15 = r34
        L_0x00c0:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r10 & r16
            if (r17 != 0) goto L_0x00da
            r17 = r11 & 64
            r14 = r35
            if (r17 != 0) goto L_0x00d5
            boolean r17 = r1.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x00d5
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r4 = r4 | r17
            goto L_0x00dc
        L_0x00da:
            r14 = r35
        L_0x00dc:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00e7
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r18
            r3 = r36
            goto L_0x00fc
        L_0x00e7:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r10 & r18
            r3 = r36
            if (r18 != 0) goto L_0x00fc
            boolean r18 = r1.changed((boolean) r3)
            if (r18 == 0) goto L_0x00f8
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f8:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r4 = r4 | r18
        L_0x00fc:
            r3 = r11 & 256(0x100, float:3.59E-43)
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            if (r3 == 0) goto L_0x0106
            r3 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r3
            goto L_0x011a
        L_0x0106:
            r3 = r10 & r18
            if (r3 != 0) goto L_0x011a
            r3 = r37
            boolean r19 = r1.changedInstance(r3)
            if (r19 == 0) goto L_0x0115
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r4 = r4 | r19
            goto L_0x011c
        L_0x011a:
            r3 = r37
        L_0x011c:
            r19 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r4 & r19
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r5) goto L_0x013d
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x012d
            goto L_0x013d
        L_0x012d:
            r1.skipToGroupEnd()
            r2 = r29
            r3 = r30
            r6 = r7
            r4 = r9
            r5 = r12
            r7 = r14
            r8 = r15
            r9 = r36
            goto L_0x0235
        L_0x013d:
            r1.startDefaults()
            r3 = r10 & 1
            r5 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x0172
            boolean r3 = r1.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0151
            goto L_0x0172
        L_0x0151:
            r1.skipToGroupEnd()
            r0 = r11 & 2
            if (r0 == 0) goto L_0x015a
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x015a:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0160
            r4 = r4 & r19
        L_0x0160:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0165
            r4 = r4 & r5
        L_0x0165:
            r2 = r29
            r3 = r30
            r0 = r36
            r6 = r7
            r5 = r9
            r7 = r12
            r9 = r14
            r8 = r15
            goto L_0x01d1
        L_0x0172:
            if (r2 == 0) goto L_0x0179
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x017b
        L_0x0179:
            r2 = r29
        L_0x017b:
            r3 = r11 & 2
            r5 = 0
            if (r3 == 0) goto L_0x0188
            r3 = 3
            androidx.compose.foundation.lazy.LazyListState r3 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r5, r5, r1, r5, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x018a
        L_0x0188:
            r3 = r30
        L_0x018a:
            if (r6 == 0) goto L_0x0196
            float r6 = (float) r5
            float r6 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r6)
            androidx.compose.foundation.layout.PaddingValues r6 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r6)
            goto L_0x0197
        L_0x0196:
            r6 = r7
        L_0x0197:
            if (r8 == 0) goto L_0x019a
            goto L_0x019b
        L_0x019a:
            r5 = r9
        L_0x019b:
            r7 = r11 & 16
            if (r7 == 0) goto L_0x01af
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r5 != 0) goto L_0x01a8
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getTop()
            goto L_0x01ac
        L_0x01a8:
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getBottom()
        L_0x01ac:
            r4 = r4 & r19
            goto L_0x01b0
        L_0x01af:
            r7 = r12
        L_0x01b0:
            if (r13 == 0) goto L_0x01b9
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r8 = r8.getStart()
            goto L_0x01ba
        L_0x01b9:
            r8 = r15
        L_0x01ba:
            r9 = r11 & 64
            if (r9 == 0) goto L_0x01ca
            androidx.compose.foundation.gestures.ScrollableDefaults r9 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r12 = 6
            androidx.compose.foundation.gestures.FlingBehavior r9 = r9.flingBehavior(r1, r12)
            r12 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r12
            goto L_0x01cb
        L_0x01ca:
            r9 = r14
        L_0x01cb:
            if (r0 == 0) goto L_0x01cf
            r0 = 1
            goto L_0x01d1
        L_0x01cf:
            r0 = r36
        L_0x01d1:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01e3
            r12 = -1
            java.lang.String r13 = "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:359)"
            r14 = -740714857(0xffffffffd3d99697, float:-1.86906876E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r4, r12, r13)
        L_0x01e3:
            r12 = r4 & 14
            r12 = r12 | 24576(0x6000, float:3.4438E-41)
            r13 = r4 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            r13 = r4 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            r13 = r4 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            int r13 = r4 >> 3
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r13
            r12 = r12 | r14
            r13 = r13 & r16
            r12 = r12 | r13
            int r13 = r4 << 9
            r13 = r13 & r18
            r12 = r12 | r13
            int r13 = r4 << 15
            r14 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r14
            r26 = r12 | r13
            int r4 = r4 >> 18
            r4 = r4 & 896(0x380, float:1.256E-42)
            r27 = r4
            r28 = 3200(0xc80, float:4.484E-42)
            r16 = 1
            r19 = 0
            r22 = 0
            r23 = 0
            r12 = r2
            r13 = r3
            r14 = r6
            r15 = r5
            r17 = r9
            r18 = r0
            r20 = r8
            r21 = r7
            r24 = r37
            r25 = r1
            androidx.compose.foundation.lazy.LazyListKt.LazyList(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0231
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0231:
            r4 = r5
            r5 = r7
            r7 = r9
            r9 = r0
        L_0x0235:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x0251
            androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1 r13 = new androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
            r0 = r13
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r9
            r9 = r37
            r10 = r39
            r11 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0251:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0119  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void LazyColumn(androidx.compose.ui.Modifier r23, androidx.compose.foundation.lazy.LazyListState r24, androidx.compose.foundation.layout.PaddingValues r25, boolean r26, androidx.compose.foundation.layout.Arrangement.Vertical r27, androidx.compose.ui.Alignment.Horizontal r28, androidx.compose.foundation.gestures.FlingBehavior r29, kotlin.jvm.functions.Function1 r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r32
            r10 = r33
            r0 = -563353797(0xffffffffde6be73b, float:-4.24965505E18)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LazyColumn)P(4,6,1,5,7,3,2)378@18168L23,384@18522L15,387@18585L350:LazyDsl.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r9 | 6
            r4 = r3
            r3 = r23
            goto L_0x0030
        L_0x001c:
            r3 = r9 & 14
            if (r3 != 0) goto L_0x002d
            r3 = r23
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r9
            goto L_0x0030
        L_0x002d:
            r3 = r23
            r4 = r9
        L_0x0030:
            r5 = r9 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0049
            r5 = r10 & 2
            if (r5 != 0) goto L_0x0043
            r5 = r24
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0043:
            r5 = r24
        L_0x0045:
            r6 = 16
        L_0x0047:
            r4 = r4 | r6
            goto L_0x004b
        L_0x0049:
            r5 = r24
        L_0x004b:
            r6 = r10 & 4
            if (r6 == 0) goto L_0x0052
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r7 = r9 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0065
            r7 = r25
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0061
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r8
            goto L_0x0067
        L_0x0065:
            r7 = r25
        L_0x0067:
            r8 = r10 & 8
            if (r8 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0081
            r11 = r26
            boolean r12 = r1.changed((boolean) r11)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r12
            goto L_0x0083
        L_0x0081:
            r11 = r26
        L_0x0083:
            r12 = 57344(0xe000, float:8.0356E-41)
            r13 = r9 & r12
            if (r13 != 0) goto L_0x009f
            r13 = r10 & 16
            if (r13 != 0) goto L_0x0099
            r13 = r27
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009b
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x0099:
            r13 = r27
        L_0x009b:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r4 = r4 | r14
            goto L_0x00a1
        L_0x009f:
            r13 = r27
        L_0x00a1:
            r14 = r10 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00ae
            r16 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r16
            r15 = r28
            goto L_0x00c1
        L_0x00ae:
            r16 = r9 & r15
            r15 = r28
            if (r16 != 0) goto L_0x00c1
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00bd
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r4 = r4 | r16
        L_0x00c1:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r9 & r16
            if (r17 != 0) goto L_0x00db
            r17 = r10 & 64
            r12 = r29
            if (r17 != 0) goto L_0x00d6
            boolean r18 = r1.changed((java.lang.Object) r12)
            if (r18 == 0) goto L_0x00d6
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r4 = r4 | r18
            goto L_0x00dd
        L_0x00db:
            r12 = r29
        L_0x00dd:
            r0 = r10 & 128(0x80, float:1.794E-43)
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e6
            r4 = r4 | r19
            goto L_0x00fb
        L_0x00e6:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x00fb
            r0 = r30
            boolean r20 = r1.changedInstance(r0)
            if (r20 == 0) goto L_0x00f6
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f6:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r4 = r4 | r20
            goto L_0x00fd
        L_0x00fb:
            r0 = r30
        L_0x00fd:
            r20 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r4 & r20
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0119
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x010e
            goto L_0x0119
        L_0x010e:
            r1.skipToGroupEnd()
            r2 = r23
            r3 = r7
            r4 = r11
            r7 = r12
            r6 = r15
            goto L_0x01f7
        L_0x0119:
            r1.startDefaults()
            r0 = r9 & 1
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = 3
            if (r0 == 0) goto L_0x014a
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x012b
            goto L_0x014a
        L_0x012b:
            r1.skipToGroupEnd()
            r0 = r10 & 2
            if (r0 == 0) goto L_0x0134
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0134:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x013a
            r4 = r4 & r20
        L_0x013a:
            r0 = r10 & 64
            if (r0 == 0) goto L_0x0142
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r0
        L_0x0142:
            r0 = r23
            r2 = r11
            r8 = r12
            r6 = r15
        L_0x0147:
            r11 = r4
            r4 = r13
            goto L_0x01a3
        L_0x014a:
            if (r2 == 0) goto L_0x0151
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0153
        L_0x0151:
            r0 = r23
        L_0x0153:
            r2 = r10 & 2
            r23 = r0
            r0 = 0
            if (r2 == 0) goto L_0x0161
            androidx.compose.foundation.lazy.LazyListState r2 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r0, r0, r1, r0, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            r5 = r2
        L_0x0161:
            if (r6 == 0) goto L_0x016d
            float r2 = (float) r0
            float r2 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r2)
            androidx.compose.foundation.layout.PaddingValues r2 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r2)
            r7 = r2
        L_0x016d:
            if (r8 == 0) goto L_0x0170
            r11 = r0
        L_0x0170:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x0185
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r11 != 0) goto L_0x017d
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = r0.getTop()
            goto L_0x0181
        L_0x017d:
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = r0.getBottom()
        L_0x0181:
            r2 = r4 & r20
            r13 = r0
            r4 = r2
        L_0x0185:
            if (r14 == 0) goto L_0x018e
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r0 = r0.getStart()
            r15 = r0
        L_0x018e:
            r0 = r10 & 64
            if (r0 == 0) goto L_0x0142
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r2 = 6
            androidx.compose.foundation.gestures.FlingBehavior r0 = r0.flingBehavior(r1, r2)
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r2
            r8 = r0
            r2 = r11
            r6 = r15
            r0 = r23
            goto L_0x0147
        L_0x01a3:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01b5
            r12 = -1
            java.lang.String r13 = "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:386)"
            r14 = -563353797(0xffffffffde6be73b, float:-4.24965505E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r11, r12, r13)
        L_0x01b5:
            r12 = r11 & 14
            r12 = r12 | r19
            r13 = r11 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            r13 = r11 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            r13 = r11 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            r12 = r12 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r11
            r12 = r12 | r13
            r13 = r11 & r16
            r12 = r12 | r13
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            int r3 = r11 << 3
            r3 = r3 & r13
            r21 = r12 | r3
            r22 = 0
            r18 = 1
            r11 = r0
            r12 = r5
            r13 = r7
            r14 = r2
            r15 = r4
            r16 = r6
            r17 = r8
            r19 = r30
            r20 = r1
            LazyColumn(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01f2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f2:
            r13 = r4
            r3 = r7
            r7 = r8
            r4 = r2
            r2 = r0
        L_0x01f7:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x0211
            androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$2 r12 = new androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$2
            r0 = r12
            r1 = r2
            r2 = r5
            r5 = r13
            r8 = r30
            r9 = r32
            r10 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0119  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void LazyRow(androidx.compose.ui.Modifier r23, androidx.compose.foundation.lazy.LazyListState r24, androidx.compose.foundation.layout.PaddingValues r25, boolean r26, androidx.compose.foundation.layout.Arrangement.Horizontal r27, androidx.compose.ui.Alignment.Vertical r28, androidx.compose.foundation.gestures.FlingBehavior r29, kotlin.jvm.functions.Function1 r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r32
            r10 = r33
            r0 = 407929823(0x185083df, float:2.6949948E-24)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LazyRow)P(4,6,1,5,3,7,2)404@19106L23,410@19457L15,413@19520L347:LazyDsl.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r9 | 6
            r4 = r3
            r3 = r23
            goto L_0x0030
        L_0x001c:
            r3 = r9 & 14
            if (r3 != 0) goto L_0x002d
            r3 = r23
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r9
            goto L_0x0030
        L_0x002d:
            r3 = r23
            r4 = r9
        L_0x0030:
            r5 = r9 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0049
            r5 = r10 & 2
            if (r5 != 0) goto L_0x0043
            r5 = r24
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0043:
            r5 = r24
        L_0x0045:
            r6 = 16
        L_0x0047:
            r4 = r4 | r6
            goto L_0x004b
        L_0x0049:
            r5 = r24
        L_0x004b:
            r6 = r10 & 4
            if (r6 == 0) goto L_0x0052
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r7 = r9 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0065
            r7 = r25
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0061
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r8
            goto L_0x0067
        L_0x0065:
            r7 = r25
        L_0x0067:
            r8 = r10 & 8
            if (r8 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0081
            r11 = r26
            boolean r12 = r1.changed((boolean) r11)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r12
            goto L_0x0083
        L_0x0081:
            r11 = r26
        L_0x0083:
            r12 = 57344(0xe000, float:8.0356E-41)
            r13 = r9 & r12
            if (r13 != 0) goto L_0x009f
            r13 = r10 & 16
            if (r13 != 0) goto L_0x0099
            r13 = r27
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009b
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x0099:
            r13 = r27
        L_0x009b:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r4 = r4 | r14
            goto L_0x00a1
        L_0x009f:
            r13 = r27
        L_0x00a1:
            r14 = r10 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00ae
            r16 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r16
            r15 = r28
            goto L_0x00c1
        L_0x00ae:
            r16 = r9 & r15
            r15 = r28
            if (r16 != 0) goto L_0x00c1
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00bd
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r4 = r4 | r16
        L_0x00c1:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r9 & r16
            if (r17 != 0) goto L_0x00db
            r17 = r10 & 64
            r12 = r29
            if (r17 != 0) goto L_0x00d6
            boolean r18 = r1.changed((java.lang.Object) r12)
            if (r18 == 0) goto L_0x00d6
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r4 = r4 | r18
            goto L_0x00dd
        L_0x00db:
            r12 = r29
        L_0x00dd:
            r0 = r10 & 128(0x80, float:1.794E-43)
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e6
            r4 = r4 | r19
            goto L_0x00fb
        L_0x00e6:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x00fb
            r0 = r30
            boolean r20 = r1.changedInstance(r0)
            if (r20 == 0) goto L_0x00f6
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f6:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r4 = r4 | r20
            goto L_0x00fd
        L_0x00fb:
            r0 = r30
        L_0x00fd:
            r20 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r4 & r20
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0119
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x010e
            goto L_0x0119
        L_0x010e:
            r1.skipToGroupEnd()
            r2 = r23
            r3 = r7
            r4 = r11
            r7 = r12
            r6 = r15
            goto L_0x01f7
        L_0x0119:
            r1.startDefaults()
            r0 = r9 & 1
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = 3
            if (r0 == 0) goto L_0x014a
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x012b
            goto L_0x014a
        L_0x012b:
            r1.skipToGroupEnd()
            r0 = r10 & 2
            if (r0 == 0) goto L_0x0134
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0134:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x013a
            r4 = r4 & r20
        L_0x013a:
            r0 = r10 & 64
            if (r0 == 0) goto L_0x0142
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r0
        L_0x0142:
            r0 = r23
            r2 = r11
            r8 = r12
            r6 = r15
        L_0x0147:
            r11 = r4
            r4 = r13
            goto L_0x01a3
        L_0x014a:
            if (r2 == 0) goto L_0x0151
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0153
        L_0x0151:
            r0 = r23
        L_0x0153:
            r2 = r10 & 2
            r23 = r0
            r0 = 0
            if (r2 == 0) goto L_0x0161
            androidx.compose.foundation.lazy.LazyListState r2 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r0, r0, r1, r0, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            r5 = r2
        L_0x0161:
            if (r6 == 0) goto L_0x016d
            float r2 = (float) r0
            float r2 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r2)
            androidx.compose.foundation.layout.PaddingValues r2 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r2)
            r7 = r2
        L_0x016d:
            if (r8 == 0) goto L_0x0170
            r11 = r0
        L_0x0170:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x0185
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r11 != 0) goto L_0x017d
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getStart()
            goto L_0x0181
        L_0x017d:
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getEnd()
        L_0x0181:
            r2 = r4 & r20
            r13 = r0
            r4 = r2
        L_0x0185:
            if (r14 == 0) goto L_0x018e
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r0 = r0.getTop()
            r15 = r0
        L_0x018e:
            r0 = r10 & 64
            if (r0 == 0) goto L_0x0142
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r2 = 6
            androidx.compose.foundation.gestures.FlingBehavior r0 = r0.flingBehavior(r1, r2)
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r2
            r8 = r0
            r2 = r11
            r6 = r15
            r0 = r23
            goto L_0x0147
        L_0x01a3:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01b5
            r12 = -1
            java.lang.String r13 = "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:412)"
            r14 = 407929823(0x185083df, float:2.6949948E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r11, r12, r13)
        L_0x01b5:
            r12 = r11 & 14
            r12 = r12 | r19
            r13 = r11 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            r13 = r11 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            r13 = r11 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            r12 = r12 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r11
            r12 = r12 | r13
            r13 = r11 & r16
            r12 = r12 | r13
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            int r3 = r11 << 3
            r3 = r3 & r13
            r21 = r12 | r3
            r22 = 0
            r18 = 1
            r11 = r0
            r12 = r5
            r13 = r7
            r14 = r2
            r15 = r4
            r16 = r6
            r17 = r8
            r19 = r30
            r20 = r1
            LazyRow(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01f2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f2:
            r13 = r4
            r3 = r7
            r7 = r8
            r4 = r2
            r2 = r0
        L_0x01f7:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x0211
            androidx.compose.foundation.lazy.LazyDslKt$LazyRow$2 r12 = new androidx.compose.foundation.lazy.LazyDslKt$LazyRow$2
            r0 = r12
            r1 = r2
            r2 = r5
            r5 = r13
            r8 = r30
            r9 = r32
            r10 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope lazyListScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(LazyDslKt$items$1.INSTANCE, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function4 function4, int i, Object obj) {
        Function1 function12 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        Function1 function13 = LazyDslKt$items$1.INSTANCE;
        int size = list.size();
        if (function1 != null) {
            function12 = new LazyDslKt$items$2(function1, list);
        }
        lazyListScope.items(size, function12, new LazyDslKt$items$3(function13, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(function4, list)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        int size = list.size();
        if (function2 != null) {
            function1 = new LazyDslKt$itemsIndexed$2(function2, list);
        }
        lazyListScope.items(size, function1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope lazyListScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(tArr.length, function1 != null ? new LazyDslKt$items$6(function1, tArr) : null, new LazyDslKt$items$7(LazyDslKt$items$5.INSTANCE, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, tArr)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function4 function4, int i, Object obj) {
        Function1 function12 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        Function1 function13 = LazyDslKt$items$5.INSTANCE;
        int length = objArr.length;
        if (function1 != null) {
            function12 = new LazyDslKt$items$6(function1, objArr);
        }
        lazyListScope.items(length, function12, new LazyDslKt$items$7(function13, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(function4, objArr)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope lazyListScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(tArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, tArr) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(tArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        int length = objArr.length;
        if (function2 != null) {
            function1 = new LazyDslKt$itemsIndexed$6(function2, objArr);
        }
        lazyListScope.items(length, function1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(function5, objArr)));
    }
}
