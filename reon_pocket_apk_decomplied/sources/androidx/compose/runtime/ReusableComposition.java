package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\u0007H&¢\u0006\u0002\u0010\b\u0001\u0001\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/Composition;", "deactivate", "", "setContentWithReuse", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;)V", "Landroidx/compose/runtime/CompositionImpl;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composition.kt */
public interface ReusableComposition extends Composition {
    void deactivate();

    void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> function2);
}
