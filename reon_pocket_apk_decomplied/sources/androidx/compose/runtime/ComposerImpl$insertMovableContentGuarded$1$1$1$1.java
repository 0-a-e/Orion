package androidx.compose.runtime;

import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.collection.IntMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$insertMovableContentGuarded$1$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ChangeList $offsetChanges;
    final /* synthetic */ SlotReader $reader;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentGuarded$1$1$1$1(ComposerImpl composerImpl, ChangeList changeList, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.this$0 = composerImpl;
        this.$offsetChanges = changeList;
        this.$reader = slotReader;
        this.$to = movableContentStateReference;
    }

    /* JADX INFO: finally extract failed */
    public final void invoke() {
        ComposerChangeListWriter access$getChangeListWriter$p;
        boolean implicitRootStart;
        ComposerChangeListWriter access$getChangeListWriter$p2 = this.this$0.changeListWriter;
        ChangeList changeList = this.$offsetChanges;
        ComposerImpl composerImpl = this.this$0;
        SlotReader slotReader = this.$reader;
        MovableContentStateReference movableContentStateReference = this.$to;
        ChangeList changeList2 = access$getChangeListWriter$p2.getChangeList();
        try {
            access$getChangeListWriter$p2.setChangeList(changeList);
            SlotReader reader$runtime_release = composerImpl.getReader$runtime_release();
            int[] access$getNodeCountOverrides$p = composerImpl.nodeCountOverrides;
            IntMap access$getProviderUpdates$p = composerImpl.providerUpdates;
            composerImpl.nodeCountOverrides = null;
            composerImpl.providerUpdates = null;
            try {
                composerImpl.setReader$runtime_release(slotReader);
                access$getChangeListWriter$p = composerImpl.changeListWriter;
                implicitRootStart = access$getChangeListWriter$p.getImplicitRootStart();
                access$getChangeListWriter$p.setImplicitRootStart(false);
                composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals$runtime_release(), movableContentStateReference.getParameter$runtime_release(), true);
                access$getChangeListWriter$p.setImplicitRootStart(implicitRootStart);
                Unit unit = Unit.INSTANCE;
                composerImpl.setReader$runtime_release(reader$runtime_release);
                composerImpl.nodeCountOverrides = access$getNodeCountOverrides$p;
                composerImpl.providerUpdates = access$getProviderUpdates$p;
                access$getChangeListWriter$p2.setChangeList(changeList2);
            } catch (Throwable th) {
                composerImpl.setReader$runtime_release(reader$runtime_release);
                composerImpl.nodeCountOverrides = access$getNodeCountOverrides$p;
                composerImpl.providerUpdates = access$getProviderUpdates$p;
                throw th;
            }
        } catch (Throwable th2) {
            access$getChangeListWriter$p2.setChangeList(changeList2);
            throw th2;
        }
    }
}
