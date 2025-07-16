package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.fragment.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000 92\u00020\u0001:\u00049:;<B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0012J#\u0010\u0013\u001a\u00020\u00102\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\u00160\u00152\u0006\u0010\u0017\u001a\u00020\bH&J \u0010\u0018\u001a\u00020\u00102\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\u00160\u0015H\u0010¢\u0006\u0002\b\u0019J\u0006\u0010\u001a\u001a\u00020\u0010J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!J\u000e\u0010%\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!J\u0006\u0010&\u001a\u00020\u0010J\u0012\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020)H\u0002J\u0006\u0010+\u001a\u00020\u0010J\u0006\u0010,\u001a\u00020\u0010J\u0010\u0010-\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!J\u0016\u0010.\u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u00100\u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\u0010J\u000e\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u000205J\u001b\u00106\u001a\u00020\u00102\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\u00160\u0015H\u0002J\b\u00107\u001a\u00020\u0010H\u0002J\u000e\u00108\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/fragment/app/SpecialEffectsController;", "", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "getContainer", "()Landroid/view/ViewGroup;", "isContainerPostponed", "", "operationDirectionIsPop", "pendingOperations", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "runningNonSeekableTransition", "runningOperations", "applyContainerChangesToOperation", "", "operation", "applyContainerChangesToOperation$fragment_release", "collectEffects", "operations", "", "Lkotlin/jvm/JvmSuppressWildcards;", "isPop", "commitEffects", "commitEffects$fragment_release", "completeBack", "enqueue", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragmentStateManager", "Landroidx/fragment/app/FragmentStateManager;", "enqueueAdd", "enqueueHide", "enqueueRemove", "enqueueShow", "executePendingOperations", "findPendingOperation", "fragment", "Landroidx/fragment/app/Fragment;", "findRunningOperation", "forceCompleteAllOperations", "forcePostponedExecutePendingOperations", "getAwaitingCompletionLifecycleImpact", "isOperationSeekable", "newPendingOperations", "isOperationTransitioning", "isPendingExecute", "markPostponedState", "processProgress", "backEvent", "Landroidx/activity/BackEventCompat;", "processStart", "updateFinalState", "updateOperationDirection", "Companion", "Effect", "FragmentStateManagerOperation", "Operation", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpecialEffectsController.kt */
public abstract class SpecialEffectsController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ViewGroup container;
    private boolean isContainerPostponed;
    private boolean operationDirectionIsPop;
    private final List<Operation> pendingOperations = new ArrayList();
    private boolean runningNonSeekableTransition;
    private final List<Operation> runningOperations = new ArrayList();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SpecialEffectsController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final SpecialEffectsController getOrCreateController(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return Companion.getOrCreateController(viewGroup, fragmentManager);
    }

    @JvmStatic
    public static final SpecialEffectsController getOrCreateController(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        return Companion.getOrCreateController(viewGroup, specialEffectsControllerFactory);
    }

    public abstract void collectEffects(List<Operation> list, boolean z);

    public SpecialEffectsController(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.container = viewGroup;
    }

    public final ViewGroup getContainer() {
        return this.container;
    }

    public final Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager fragmentStateManager) {
        int i;
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        Fragment fragment = fragmentStateManager.getFragment();
        Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
        Operation findPendingOperation = findPendingOperation(fragment);
        Operation.LifecycleImpact lifecycleImpact = null;
        Operation.LifecycleImpact lifecycleImpact2 = findPendingOperation != null ? findPendingOperation.getLifecycleImpact() : null;
        Operation findRunningOperation = findRunningOperation(fragment);
        if (findRunningOperation != null) {
            lifecycleImpact = findRunningOperation.getLifecycleImpact();
        }
        if (lifecycleImpact2 == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[lifecycleImpact2.ordinal()];
        }
        return (i == -1 || i == 1) ? lifecycleImpact : lifecycleImpact2;
    }

    private final Operation findPendingOperation(Fragment fragment) {
        Object obj;
        Iterator it = this.pendingOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Operation operation = (Operation) obj;
            if (Intrinsics.areEqual((Object) operation.getFragment(), (Object) fragment) && !operation.isCanceled()) {
                break;
            }
        }
        return (Operation) obj;
    }

    private final Operation findRunningOperation(Fragment fragment) {
        Object obj;
        Iterator it = this.runningOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Operation operation = (Operation) obj;
            if (Intrinsics.areEqual((Object) operation.getFragment(), (Object) fragment) && !operation.isCanceled()) {
                break;
            }
        }
        return (Operation) obj;
    }

    public final void enqueueAdd(Operation.State state, FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(state, "finalState");
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public final void enqueueShow(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void enqueueHide(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void enqueueRemove(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    private final void enqueue(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.pendingOperations) {
            Fragment fragment = fragmentStateManager.getFragment();
            Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
            Operation findPendingOperation = findPendingOperation(fragment);
            if (findPendingOperation == null) {
                if (fragmentStateManager.getFragment().mTransitioning) {
                    Fragment fragment2 = fragmentStateManager.getFragment();
                    Intrinsics.checkNotNullExpressionValue(fragment2, "fragmentStateManager.fragment");
                    findPendingOperation = findRunningOperation(fragment2);
                } else {
                    findPendingOperation = null;
                }
            }
            if (findPendingOperation != null) {
                findPendingOperation.mergeWith(state, lifecycleImpact);
                return;
            }
            FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager);
            this.pendingOperations.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.addCompletionListener(new SpecialEffectsController$$ExternalSyntheticLambda0(this, fragmentStateManagerOperation));
            fragmentStateManagerOperation.addCompletionListener(new SpecialEffectsController$$ExternalSyntheticLambda1(this, fragmentStateManagerOperation));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void enqueue$lambda$4$lambda$2(SpecialEffectsController specialEffectsController, FragmentStateManagerOperation fragmentStateManagerOperation) {
        Intrinsics.checkNotNullParameter(specialEffectsController, "this$0");
        Intrinsics.checkNotNullParameter(fragmentStateManagerOperation, "$operation");
        if (specialEffectsController.pendingOperations.contains(fragmentStateManagerOperation)) {
            Operation.State finalState = fragmentStateManagerOperation.getFinalState();
            View view = fragmentStateManagerOperation.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            finalState.applyState(view, specialEffectsController.container);
        }
    }

    /* access modifiers changed from: private */
    public static final void enqueue$lambda$4$lambda$3(SpecialEffectsController specialEffectsController, FragmentStateManagerOperation fragmentStateManagerOperation) {
        Intrinsics.checkNotNullParameter(specialEffectsController, "this$0");
        Intrinsics.checkNotNullParameter(fragmentStateManagerOperation, "$operation");
        specialEffectsController.pendingOperations.remove(fragmentStateManagerOperation);
        specialEffectsController.runningOperations.remove(fragmentStateManagerOperation);
    }

    public final void updateOperationDirection(boolean z) {
        this.operationDirectionIsPop = z;
    }

    public final void markPostponedState() {
        Fragment fragment;
        Operation operation;
        synchronized (this.pendingOperations) {
            updateFinalState();
            List<Operation> list = this.pendingOperations;
            ListIterator<Operation> listIterator = list.listIterator(list.size());
            while (true) {
                fragment = null;
                if (!listIterator.hasPrevious()) {
                    operation = null;
                    break;
                }
                operation = listIterator.previous();
                Operation operation2 = operation;
                Operation.State.Companion companion = Operation.State.Companion;
                View view = operation2.getFragment().mView;
                Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                Operation.State asOperationState = companion.asOperationState(view);
                if (operation2.getFinalState() == Operation.State.VISIBLE && asOperationState != Operation.State.VISIBLE) {
                    break;
                }
            }
            Operation operation3 = operation;
            if (operation3 != null) {
                fragment = operation3.getFragment();
            }
            this.isContainerPostponed = fragment != null ? fragment.isPostponed() : false;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isPendingExecute() {
        return !this.pendingOperations.isEmpty();
    }

    public final void forcePostponedExecutePendingOperations() {
        if (this.isContainerPostponed) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing postponed operations");
            }
            this.isContainerPostponed = false;
            executePendingOperations();
        }
    }

    public final void executePendingOperations() {
        boolean z;
        if (!this.isContainerPostponed) {
            if (!this.container.isAttachedToWindow()) {
                forceCompleteAllOperations();
                this.operationDirectionIsPop = false;
                return;
            }
            synchronized (this.pendingOperations) {
                List<Operation> mutableList = CollectionsKt.toMutableList(this.runningOperations);
                this.runningOperations.clear();
                Iterator it = mutableList.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Operation operation = (Operation) it.next();
                    if (!(!this.pendingOperations.isEmpty()) || !operation.getFragment().mTransitioning) {
                        z = false;
                    }
                    operation.setSeeking$fragment_release(z);
                }
                for (Operation operation2 : mutableList) {
                    if (this.runningNonSeekableTransition) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Completing non-seekable operation " + operation2);
                        }
                        operation2.complete$fragment_release();
                    } else {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Cancelling operation " + operation2);
                        }
                        operation2.cancel(this.container);
                    }
                    this.runningNonSeekableTransition = false;
                    if (!operation2.isComplete()) {
                        this.runningOperations.add(operation2);
                    }
                }
                if (!this.pendingOperations.isEmpty()) {
                    updateFinalState();
                    List mutableList2 = CollectionsKt.toMutableList(this.pendingOperations);
                    if (!mutableList2.isEmpty()) {
                        this.pendingOperations.clear();
                        this.runningOperations.addAll(mutableList2);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Executing pending operations");
                        }
                        collectEffects(mutableList2, this.operationDirectionIsPop);
                        boolean isOperationSeekable = isOperationSeekable(mutableList2);
                        boolean isOperationTransitioning = isOperationTransitioning(mutableList2);
                        if (!isOperationTransitioning || isOperationSeekable) {
                            z = false;
                        }
                        this.runningNonSeekableTransition = z;
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Operation seekable = " + isOperationSeekable + " \ntransition = " + isOperationTransitioning);
                        }
                        if (!isOperationTransitioning) {
                            processStart(mutableList2);
                            commitEffects$fragment_release(mutableList2);
                        } else if (isOperationSeekable) {
                            processStart(mutableList2);
                            int size = mutableList2.size();
                            for (int i = 0; i < size; i++) {
                                applyContainerChangesToOperation$fragment_release((Operation) mutableList2.get(i));
                            }
                        }
                        this.operationDirectionIsPop = false;
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Finished executing pending operations");
                        }
                    } else {
                        return;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final boolean isOperationTransitioning(List<Operation> list) {
        boolean z = true;
        for (Operation fragment : list) {
            if (!fragment.getFragment().mTransitioning) {
                z = false;
            }
        }
        return z;
    }

    private final boolean isOperationSeekable(List<Operation> list) {
        boolean z;
        Iterable<Operation> iterable = list;
        loop0:
        while (true) {
            z = true;
            for (Operation operation : iterable) {
                if (!operation.getEffects$fragment_release().isEmpty()) {
                    Iterable<Effect> effects$fragment_release = operation.getEffects$fragment_release();
                    if (!(effects$fragment_release instanceof Collection) || !((Collection) effects$fragment_release).isEmpty()) {
                        for (Effect isSeekingSupported : effects$fragment_release) {
                            if (!isSeekingSupported.isSeekingSupported()) {
                            }
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        if (z) {
            Collection arrayList = new ArrayList();
            for (Operation effects$fragment_release2 : iterable) {
                CollectionsKt.addAll(arrayList, effects$fragment_release2.getEffects$fragment_release());
            }
            if (!((List) arrayList).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final void applyContainerChangesToOperation$fragment_release(Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (operation.isAwaitingContainerChanges()) {
            Operation.State finalState = operation.getFinalState();
            View requireView = operation.getFragment().requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "operation.fragment.requireView()");
            finalState.applyState(requireView, this.container);
            operation.setAwaitingContainerChanges(false);
        }
    }

    public final void forceCompleteAllOperations() {
        String str;
        String str2;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = this.container.isAttachedToWindow();
        synchronized (this.pendingOperations) {
            updateFinalState();
            processStart(this.pendingOperations);
            List<Operation> mutableList = CollectionsKt.toMutableList(this.runningOperations);
            for (Operation seeking$fragment_release : mutableList) {
                seeking$fragment_release.setSeeking$fragment_release(false);
            }
            for (Operation operation : mutableList) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    if (isAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.container + " is not attached to window. ";
                    }
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: " + str2 + "Cancelling running operation " + operation);
                }
                operation.cancel(this.container);
            }
            List<Operation> mutableList2 = CollectionsKt.toMutableList(this.pendingOperations);
            for (Operation seeking$fragment_release2 : mutableList2) {
                seeking$fragment_release2.setSeeking$fragment_release(false);
            }
            for (Operation operation2 : mutableList2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    if (isAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.container + " is not attached to window. ";
                    }
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: " + str + "Cancelling pending operation " + operation2);
                }
                operation2.cancel(this.container);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void updateFinalState() {
        for (Operation next : this.pendingOperations) {
            if (next.getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                View requireView = next.getFragment().requireView();
                Intrinsics.checkNotNullExpressionValue(requireView, "fragment.requireView()");
                next.mergeWith(Operation.State.Companion.from(requireView.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public void commitEffects$fragment_release(List<Operation> list) {
        Intrinsics.checkNotNullParameter(list, "operations");
        Iterable<Operation> iterable = list;
        Collection arrayList = new ArrayList();
        for (Operation effects$fragment_release : iterable) {
            CollectionsKt.addAll(arrayList, effects$fragment_release.getEffects$fragment_release());
        }
        List list2 = CollectionsKt.toList(CollectionsKt.toSet((List) arrayList));
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            ((Effect) list2.get(i)).onCommit(this.container);
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            applyContainerChangesToOperation$fragment_release(list.get(i2));
        }
        List list3 = CollectionsKt.toList(iterable);
        int size3 = list3.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Operation operation = (Operation) list3.get(i3);
            if (operation.getEffects$fragment_release().isEmpty()) {
                operation.complete$fragment_release();
            }
        }
    }

    private final void processStart(List<Operation> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).onStart();
        }
        Collection arrayList = new ArrayList();
        for (Operation effects$fragment_release : list) {
            CollectionsKt.addAll(arrayList, effects$fragment_release.getEffects$fragment_release());
        }
        List list2 = CollectionsKt.toList(CollectionsKt.toSet((List) arrayList));
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((Effect) list2.get(i2)).performStart(this.container);
        }
    }

    public final void processProgress(BackEventCompat backEventCompat) {
        Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Processing Progress " + backEventCompat.getProgress());
        }
        Collection arrayList = new ArrayList();
        for (Operation effects$fragment_release : this.runningOperations) {
            CollectionsKt.addAll(arrayList, effects$fragment_release.getEffects$fragment_release());
        }
        List list = CollectionsKt.toList(CollectionsKt.toSet((List) arrayList));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Effect) list.get(i)).onProgress(backEventCompat, this.container);
        }
    }

    public final void completeBack() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "SpecialEffectsController: Completing Back ");
        }
        processStart(this.runningOperations);
        commitEffects$fragment_release(this.runningOperations);
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001:\u000267B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\rJ\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.J\r\u0010/\u001a\u00020(H\u0011¢\u0006\u0002\b0J\u000e\u00101\u001a\u00020(2\u0006\u0010+\u001a\u00020\u000bJ\u0016\u00102\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\b\u00103\u001a\u00020(H\u0017J\b\u00104\u001a\u000205H\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u001e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR$\u0010 \u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\u001e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00068"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/Fragment;)V", "_effects", "", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "completionListeners", "Ljava/lang/Runnable;", "effects", "", "getEffects$fragment_release", "()Ljava/util/List;", "getFinalState", "()Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "setFinalState", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "isAwaitingContainerChanges", "", "()Z", "setAwaitingContainerChanges", "(Z)V", "<set-?>", "isCanceled", "isComplete", "isSeeking", "setSeeking$fragment_release", "isStarted", "getLifecycleImpact", "()Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "setLifecycleImpact", "(Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "addCompletionListener", "", "listener", "addEffect", "effect", "cancel", "container", "Landroid/view/ViewGroup;", "complete", "complete$fragment_release", "completeEffect", "mergeWith", "onStart", "toString", "", "LifecycleImpact", "State", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SpecialEffectsController.kt */
    public static class Operation {
        private final List<Effect> _effects;
        private final List<Runnable> completionListeners = new ArrayList();
        private final List<Effect> effects;
        private State finalState;
        private final Fragment fragment;
        private boolean isAwaitingContainerChanges = true;
        private boolean isCanceled;
        private boolean isComplete;
        private boolean isSeeking;
        private boolean isStarted;
        private LifecycleImpact lifecycleImpact;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "", "(Ljava/lang/String;I)V", "NONE", "ADDING", "REMOVING", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: SpecialEffectsController.kt */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: SpecialEffectsController.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.WhenMappings.<clinit>():void");
            }
        }

        public Operation(State state, LifecycleImpact lifecycleImpact2, Fragment fragment2) {
            Intrinsics.checkNotNullParameter(state, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact2, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
            this.finalState = state;
            this.lifecycleImpact = lifecycleImpact2;
            this.fragment = fragment2;
            List<Effect> arrayList = new ArrayList<>();
            this._effects = arrayList;
            this.effects = arrayList;
        }

        public final State getFinalState() {
            return this.finalState;
        }

        public final void setFinalState(State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.finalState = state;
        }

        public final LifecycleImpact getLifecycleImpact() {
            return this.lifecycleImpact;
        }

        public final void setLifecycleImpact(LifecycleImpact lifecycleImpact2) {
            Intrinsics.checkNotNullParameter(lifecycleImpact2, "<set-?>");
            this.lifecycleImpact = lifecycleImpact2;
        }

        public final Fragment getFragment() {
            return this.fragment;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "(Ljava/lang/String;I)V", "applyState", "", "view", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "REMOVED", "VISIBLE", "GONE", "INVISIBLE", "Companion", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: SpecialEffectsController.kt */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;
            
            public static final Companion Companion = null;

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* compiled from: SpecialEffectsController.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
                static {
                    /*
                        androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x002b }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                        r2 = 4
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                    L_0x002b:
                        $EnumSwitchMapping$0 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.State.WhenMappings.<clinit>():void");
                }
            }

            @JvmStatic
            public static final State from(int i) {
                return Companion.from(i);
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }

            /* JADX WARNING: type inference failed for: r7v1, types: [android.view.ViewParent] */
            /* JADX WARNING: type inference failed for: r0v8, types: [android.view.ViewParent] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Unknown variable types count: 2 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void applyState(android.view.View r6, android.view.ViewGroup r7) {
                /*
                    r5 = this;
                    java.lang.String r0 = "view"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    java.lang.String r0 = "container"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    int[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.WhenMappings.$EnumSwitchMapping$0
                    int r1 = r5.ordinal()
                    r0 = r0[r1]
                    r1 = 1
                    r2 = 0
                    java.lang.String r3 = "FragmentManager"
                    r4 = 2
                    if (r0 == r1) goto L_0x00b3
                    java.lang.String r1 = "SpecialEffectsController: Setting view "
                    if (r0 == r4) goto L_0x0065
                    r7 = 3
                    if (r0 == r7) goto L_0x0044
                    r7 = 4
                    if (r0 == r7) goto L_0x0025
                    goto L_0x00e2
                L_0x0025:
                    boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r4)
                    if (r0 == 0) goto L_0x003f
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>(r1)
                    r0.append(r6)
                    java.lang.String r1 = " to INVISIBLE"
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    android.util.Log.v(r3, r0)
                L_0x003f:
                    r6.setVisibility(r7)
                    goto L_0x00e2
                L_0x0044:
                    boolean r7 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r4)
                    if (r7 == 0) goto L_0x005e
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>(r1)
                    r7.append(r6)
                    java.lang.String r0 = " to GONE"
                    r7.append(r0)
                    java.lang.String r7 = r7.toString()
                    android.util.Log.v(r3, r7)
                L_0x005e:
                    r7 = 8
                    r6.setVisibility(r7)
                    goto L_0x00e2
                L_0x0065:
                    boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r4)
                    if (r0 == 0) goto L_0x007f
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>(r1)
                    r0.append(r6)
                    java.lang.String r1 = " to VISIBLE"
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    android.util.Log.v(r3, r0)
                L_0x007f:
                    android.view.ViewParent r0 = r6.getParent()
                    boolean r1 = r0 instanceof android.view.ViewGroup
                    if (r1 == 0) goto L_0x008a
                    r2 = r0
                    android.view.ViewGroup r2 = (android.view.ViewGroup) r2
                L_0x008a:
                    if (r2 != 0) goto L_0x00ae
                    boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r4)
                    if (r0 == 0) goto L_0x00ab
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "SpecialEffectsController: Adding view "
                    r0.<init>(r1)
                    r0.append(r6)
                    java.lang.String r1 = " to Container "
                    r0.append(r1)
                    r0.append(r7)
                    java.lang.String r0 = r0.toString()
                    android.util.Log.v(r3, r0)
                L_0x00ab:
                    r7.addView(r6)
                L_0x00ae:
                    r7 = 0
                    r6.setVisibility(r7)
                    goto L_0x00e2
                L_0x00b3:
                    android.view.ViewParent r7 = r6.getParent()
                    boolean r0 = r7 instanceof android.view.ViewGroup
                    if (r0 == 0) goto L_0x00be
                    r2 = r7
                    android.view.ViewGroup r2 = (android.view.ViewGroup) r2
                L_0x00be:
                    if (r2 == 0) goto L_0x00e2
                    boolean r7 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r4)
                    if (r7 == 0) goto L_0x00df
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    java.lang.String r0 = "SpecialEffectsController: Removing view "
                    r7.<init>(r0)
                    r7.append(r6)
                    java.lang.String r0 = " from container "
                    r7.append(r0)
                    r7.append(r2)
                    java.lang.String r7 = r7.toString()
                    android.util.Log.v(r3, r7)
                L_0x00df:
                    r2.removeView(r6)
                L_0x00e2:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.State.applyState(android.view.View, android.view.ViewGroup):void");
            }

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\n\u0010\u0007\u001a\u00020\u0004*\u00020\b¨\u0006\t"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State$Companion;", "", "()V", "from", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "visibility", "", "asOperationState", "Landroid/view/View;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: SpecialEffectsController.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final State asOperationState(View view) {
                    Intrinsics.checkNotNullParameter(view, "<this>");
                    if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                        return State.INVISIBLE;
                    }
                    return from(view.getVisibility());
                }

                @JvmStatic
                public final State from(int i) {
                    if (i == 0) {
                        return State.VISIBLE;
                    }
                    if (i == 4) {
                        return State.INVISIBLE;
                    }
                    if (i == 8) {
                        return State.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i);
                }
            }
        }

        public final boolean isCanceled() {
            return this.isCanceled;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        public final boolean isSeeking() {
            return this.isSeeking;
        }

        public final void setSeeking$fragment_release(boolean z) {
            this.isSeeking = z;
        }

        public final boolean isStarted() {
            return this.isStarted;
        }

        public final boolean isAwaitingContainerChanges() {
            return this.isAwaitingContainerChanges;
        }

        public final void setAwaitingContainerChanges(boolean z) {
            this.isAwaitingContainerChanges = z;
        }

        public final List<Effect> getEffects$fragment_release() {
            return this.effects;
        }

        public String toString() {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            return "Operation {" + hexString + "} {finalState = " + this.finalState + " lifecycleImpact = " + this.lifecycleImpact + " fragment = " + this.fragment + '}';
        }

        public final void cancel(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            this.isStarted = false;
            if (!this.isCanceled) {
                this.isCanceled = true;
                if (this._effects.isEmpty()) {
                    complete$fragment_release();
                    return;
                }
                for (Effect cancel : CollectionsKt.toList(this.effects)) {
                    cancel.cancel(viewGroup);
                }
            }
        }

        public final void mergeWith(State state, LifecycleImpact lifecycleImpact2) {
            Intrinsics.checkNotNullParameter(state, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact2, "lifecycleImpact");
            int i = WhenMappings.$EnumSwitchMapping$0[lifecycleImpact2.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> REMOVED. mLifecycleImpact  = " + this.lifecycleImpact + " to REMOVING.");
                    }
                    this.finalState = State.REMOVED;
                    this.lifecycleImpact = LifecycleImpact.REMOVING;
                    this.isAwaitingContainerChanges = true;
                } else if (i == 3 && this.finalState != State.REMOVED) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> " + state + '.');
                    }
                    this.finalState = state;
                }
            } else if (this.finalState == State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.lifecycleImpact + " to ADDING.");
                }
                this.finalState = State.VISIBLE;
                this.lifecycleImpact = LifecycleImpact.ADDING;
                this.isAwaitingContainerChanges = true;
            }
        }

        public final void addCompletionListener(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.completionListeners.add(runnable);
        }

        public final void addEffect(Effect effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this._effects.add(effect);
        }

        public final void completeEffect(Effect effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            if (this._effects.remove(effect) && this._effects.isEmpty()) {
                complete$fragment_release();
            }
        }

        public void onStart() {
            this.isStarted = true;
        }

        public void complete$fragment_release() {
            this.isStarted = false;
            if (!this.isComplete) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
                }
                this.isComplete = true;
                for (Runnable run : this.completionListeners) {
                    run.run();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragmentStateManager", "Landroidx/fragment/app/FragmentStateManager;", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/FragmentStateManager;)V", "complete", "", "complete$fragment_release", "onStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SpecialEffectsController.kt */
    private static final class FragmentStateManagerOperation extends Operation {
        private final FragmentStateManager fragmentStateManager;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public FragmentStateManagerOperation(androidx.fragment.app.SpecialEffectsController.Operation.State r3, androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact r4, androidx.fragment.app.FragmentStateManager r5) {
            /*
                r2 = this;
                java.lang.String r0 = "finalState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "lifecycleImpact"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "fragmentStateManager"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                androidx.fragment.app.Fragment r0 = r5.getFragment()
                java.lang.String r1 = "fragmentStateManager.fragment"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r2.<init>(r3, r4, r0)
                r2.fragmentStateManager = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.FragmentStateManagerOperation.<init>(androidx.fragment.app.SpecialEffectsController$Operation$State, androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact, androidx.fragment.app.FragmentStateManager):void");
        }

        public void onStart() {
            if (!isStarted()) {
                super.onStart();
                if (getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                    Fragment fragment = this.fragmentStateManager.getFragment();
                    Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
                    View findFocus = fragment.mView.findFocus();
                    if (findFocus != null) {
                        fragment.setFocusedView(findFocus);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                        }
                    }
                    View requireView = getFragment().requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView, "this.fragment.requireView()");
                    if (requireView.getParent() == null) {
                        this.fragmentStateManager.addViewToContainer();
                        requireView.setAlpha(0.0f);
                    }
                    if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                        requireView.setVisibility(4);
                    }
                    requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
                } else if (getLifecycleImpact() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragment2 = this.fragmentStateManager.getFragment();
                    Intrinsics.checkNotNullExpressionValue(fragment2, "fragmentStateManager.fragment");
                    View requireView2 = fragment2.requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView2, "fragment.requireView()");
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + fragment2);
                    }
                    requireView2.clearFocus();
                }
            }
        }

        public void complete$fragment_release() {
            super.complete$fragment_release();
            getFragment().mTransitioning = false;
            this.fragmentStateManager.moveToExpectedState();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Effect;", "", "()V", "isCancelled", "", "isSeekingSupported", "()Z", "isStarted", "cancel", "", "container", "Landroid/view/ViewGroup;", "onCancel", "onCommit", "onProgress", "backEvent", "Landroidx/activity/BackEventCompat;", "onStart", "performStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SpecialEffectsController.kt */
    public static class Effect {
        private boolean isCancelled;
        private final boolean isSeekingSupported;
        private boolean isStarted;

        public void onCancel(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
        }

        public void onCommit(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
        }

        public void onProgress(BackEventCompat backEventCompat, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
            Intrinsics.checkNotNullParameter(viewGroup, "container");
        }

        public void onStart(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
        }

        public boolean isSeekingSupported() {
            return this.isSeekingSupported;
        }

        public final void performStart(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!this.isStarted) {
                onStart(viewGroup);
            }
            this.isStarted = true;
        }

        public final void cancel(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!this.isCancelled) {
                onCancel(viewGroup);
            }
            this.isCancelled = true;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Companion;", "", "()V", "getOrCreateController", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "factory", "Landroidx/fragment/app/SpecialEffectsControllerFactory;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SpecialEffectsController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SpecialEffectsController getOrCreateController(ViewGroup viewGroup, FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            SpecialEffectsControllerFactory specialEffectsControllerFactory = fragmentManager.getSpecialEffectsControllerFactory();
            Intrinsics.checkNotNullExpressionValue(specialEffectsControllerFactory, "fragmentManager.specialEffectsControllerFactory");
            return getOrCreateController(viewGroup, specialEffectsControllerFactory);
        }

        @JvmStatic
        public final SpecialEffectsController getOrCreateController(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(specialEffectsControllerFactory, "factory");
            Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController createController = specialEffectsControllerFactory.createController(viewGroup);
            Intrinsics.checkNotNullExpressionValue(createController, "factory.createController(container)");
            viewGroup.setTag(R.id.special_effects_controller_view_tag, createController);
            return createController;
        }
    }
}
