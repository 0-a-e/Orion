package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a \u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0012\u001a\u00020\f*\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"BITS_PER_SLOT", "", "SLOTS_PER_INT", "bitsForSlot", "bits", "slot", "composableLambda", "Landroidx/compose/runtime/internal/ComposableLambda;", "composer", "Landroidx/compose/runtime/Composer;", "key", "tracked", "", "block", "", "composableLambdaInstance", "differentBits", "sameBits", "replacableWith", "Landroidx/compose/runtime/RecomposeScope;", "other", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposableLambda.kt */
public final class ComposableLambdaKt {
    private static final int BITS_PER_SLOT = 3;
    public static final int SLOTS_PER_INT = 10;

    public static final int bitsForSlot(int i, int i2) {
        return i << (((i2 % 10) * 3) + 1);
    }

    public static final int sameBits(int i) {
        return bitsForSlot(1, i);
    }

    public static final int differentBits(int i) {
        return bitsForSlot(2, i);
    }

    public static final boolean replacableWith(RecomposeScope recomposeScope, RecomposeScope recomposeScope2) {
        if (recomposeScope != null) {
            if ((recomposeScope instanceof RecomposeScopeImpl) && (recomposeScope2 instanceof RecomposeScopeImpl)) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) recomposeScope;
                if (!recomposeScopeImpl.getValid() || Intrinsics.areEqual((Object) recomposeScope, (Object) recomposeScope2) || Intrinsics.areEqual((Object) recomposeScopeImpl.getAnchor(), (Object) ((RecomposeScopeImpl) recomposeScope2).getAnchor())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @ComposeCompilerApi
    public static final ComposableLambda composableLambdaInstance(int i, boolean z, Object obj) {
        return new ComposableLambdaImpl(i, z, obj);
    }

    @ComposeCompilerApi
    public static final ComposableLambda composableLambda(Composer composer, int i, boolean z, Object obj) {
        ComposableLambdaImpl composableLambdaImpl;
        composer.startReplaceableGroup(Integer.rotateLeft(i, 1));
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            composableLambdaImpl = new ComposableLambdaImpl(i, z, obj);
            composer.updateRememberedValue(composableLambdaImpl);
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            composableLambdaImpl = (ComposableLambdaImpl) rememberedValue;
            composableLambdaImpl.update(obj);
        }
        composer.endReplaceableGroup();
        return composableLambdaImpl;
    }
}
