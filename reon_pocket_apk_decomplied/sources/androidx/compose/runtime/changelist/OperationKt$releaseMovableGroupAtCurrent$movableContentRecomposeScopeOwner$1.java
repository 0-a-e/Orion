package androidx.compose.runtime.changelist;

import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.InvalidationResult;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeOwner;
import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"androidx/compose/runtime/changelist/OperationKt$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1", "Landroidx/compose/runtime/RecomposeScopeOwner;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "", "recomposeScopeReleased", "", "recordReadOf", "value", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Operation.kt */
public final class OperationKt$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1 implements RecomposeScopeOwner {
    final /* synthetic */ ControlledComposition $composition;
    final /* synthetic */ MovableContentStateReference $reference;

    public void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl) {
    }

    public void recordReadOf(Object obj) {
    }

    OperationKt$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1(ControlledComposition controlledComposition, MovableContentStateReference movableContentStateReference) {
        this.$composition = controlledComposition;
        this.$reference = movableContentStateReference;
    }

    public InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        InvalidationResult invalidationResult;
        ControlledComposition controlledComposition = this.$composition;
        IdentityArraySet identityArraySet = null;
        RecomposeScopeOwner recomposeScopeOwner = controlledComposition instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition : null;
        if (recomposeScopeOwner == null || (invalidationResult = recomposeScopeOwner.invalidate(recomposeScopeImpl, obj)) == null) {
            invalidationResult = InvalidationResult.IGNORED;
        }
        if (invalidationResult != InvalidationResult.IGNORED) {
            return invalidationResult;
        }
        MovableContentStateReference movableContentStateReference = this.$reference;
        Collection invalidations$runtime_release = movableContentStateReference.getInvalidations$runtime_release();
        if (obj != null) {
            identityArraySet = new IdentityArraySet();
            identityArraySet.add(identityArraySet);
        }
        movableContentStateReference.setInvalidations$runtime_release(CollectionsKt.plus(invalidations$runtime_release, TuplesKt.to(recomposeScopeImpl, identityArraySet)));
        return InvalidationResult.SCHEDULED;
    }
}
