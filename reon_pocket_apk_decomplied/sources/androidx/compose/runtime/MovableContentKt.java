package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0007\u001a;\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\n\u001aM\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r2\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u000e\u001a_\u0010\u0002\u001a\u001f\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u00102#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0011\u001aq\u0010\u0002\u001a%\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0010\"\u0004\b\u0003\u0010\u00132)\u0010\u0006\u001a%\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0014\u001aE\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017\"\u0004\b\u0000\u0010\u00162\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\n\u001aW\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\u000e\u001ai\u0010\u0015\u001a$\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r2(\u0010\u0006\u001a$\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\u0011\u001a{\u0010\u0015\u001a*\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u00102.\u0010\u0006\u001a*\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"movableContentKey", "", "movableContentOf", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "Lkotlin/Function1;", "P", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "Lkotlin/Function2;", "P1", "P2", "(Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function4;", "Lkotlin/Function3;", "P3", "(Lkotlin/jvm/functions/Function5;)Lkotlin/jvm/functions/Function5;", "Lkotlin/Function4;", "P4", "(Lkotlin/jvm/functions/Function6;)Lkotlin/jvm/functions/Function6;", "movableContentWithReceiverOf", "R", "Lkotlin/ExtensionFunctionType;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MovableContent.kt */
public final class MovableContentKt {
    public static final int movableContentKey = 126665345;

    public static final Function2<Composer, Integer, Unit> movableContentOf(Function2<? super Composer, ? super Integer, Unit> function2) {
        return ComposableLambdaKt.composableLambdaInstance(-642339857, true, new MovableContentKt$movableContentOf$1(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1079330685, true, new MovableContentKt$movableContentOf$movableContent$1(function2)))));
    }

    public static final <P> Function3<P, Composer, Integer, Unit> movableContentOf(Function3<? super P, ? super Composer, ? super Integer, Unit> function3) {
        return ComposableLambdaKt.composableLambdaInstance(-434707029, true, new MovableContentKt$movableContentOf$2(new MovableContent(function3)));
    }

    public static final <P1, P2> Function4<P1, P2, Composer, Integer, Unit> movableContentOf(Function4<? super P1, ? super P2, ? super Composer, ? super Integer, Unit> function4) {
        return ComposableLambdaKt.composableLambdaInstance(-1200019734, true, new MovableContentKt$movableContentOf$3(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1849814513, true, new MovableContentKt$movableContentOf$movableContent$2(function4)))));
    }

    public static final <P1, P2, P3> Function5<P1, P2, P3, Composer, Integer, Unit> movableContentOf(Function5<? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function5) {
        return ComposableLambdaKt.composableLambdaInstance(-1083870185, true, new MovableContentKt$movableContentOf$4(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-284417101, true, new MovableContentKt$movableContentOf$movableContent$3(function5)))));
    }

    public static final <P1, P2, P3, P4> Function6<P1, P2, P3, P4, Composer, Integer, Unit> movableContentOf(Function6<? super P1, ? super P2, ? super P3, ? super P4, ? super Composer, ? super Integer, Unit> function6) {
        return ComposableLambdaKt.composableLambdaInstance(-1741877681, true, new MovableContentKt$movableContentOf$5(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1876318581, true, new MovableContentKt$movableContentOf$movableContent$4(function6)))));
    }

    public static final <R> Function3<R, Composer, Integer, Unit> movableContentWithReceiverOf(Function3<? super R, ? super Composer, ? super Integer, Unit> function3) {
        return ComposableLambdaKt.composableLambdaInstance(506997506, true, new MovableContentKt$movableContentWithReceiverOf$1(new MovableContent(ComposableLambdaKt.composableLambdaInstance(250838178, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$1(function3)))));
    }

    public static final <R, P> Function4<R, P, Composer, Integer, Unit> movableContentWithReceiverOf(Function4<? super R, ? super P, ? super Composer, ? super Integer, Unit> function4) {
        return ComposableLambdaKt.composableLambdaInstance(627354118, true, new MovableContentKt$movableContentWithReceiverOf$2(new MovableContent(ComposableLambdaKt.composableLambdaInstance(812082854, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$2(function4)))));
    }

    public static final <R, P1, P2> Function5<R, P1, P2, Composer, Integer, Unit> movableContentWithReceiverOf(Function5<? super R, ? super P1, ? super P2, ? super Composer, ? super Integer, Unit> function5) {
        return ComposableLambdaKt.composableLambdaInstance(583402949, true, new MovableContentKt$movableContentWithReceiverOf$3(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1322148760, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$3(function5)))));
    }

    public static final <R, P1, P2, P3> Function6<R, P1, P2, P3, Composer, Integer, Unit> movableContentWithReceiverOf(Function6<? super R, ? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function6) {
        return ComposableLambdaKt.composableLambdaInstance(1468683306, true, new MovableContentKt$movableContentWithReceiverOf$4(new MovableContent(ComposableLambdaKt.composableLambdaInstance(838586922, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$4(function6)))));
    }
}
