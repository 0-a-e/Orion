package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J4\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0010\b\n\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0005H\b¢\u0006\u0002\u0010\u001aJ4\u0010\u001b\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0010\b\n\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0005H\b¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u0004\u0018\u00010\f*\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/focus/FocusTransactionManager;", "", "()V", "cancellationListener", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "", "ongoingTransaction", "", "states", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "uncommittedFocusState", "getUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusStateImpl;", "setUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusStateImpl;)V", "beginTransaction", "cancelTransaction", "commitTransaction", "withExistingTransaction", "T", "onCancelled", "block", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withNewTransaction", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTransactionManager.kt */
public final class FocusTransactionManager {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final MutableVector<Function0<Unit>> cancellationListener = new MutableVector<>(new Function0[16], 0);
    /* access modifiers changed from: private */
    public boolean ongoingTransaction;
    private final Map<FocusTargetNode, FocusStateImpl> states = new LinkedHashMap();

    public static /* synthetic */ Object withNewTransaction$default(FocusTransactionManager focusTransactionManager, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        try {
            if (focusTransactionManager.ongoingTransaction) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            if (function0 != null) {
                focusTransactionManager.cancellationListener.add(function0);
            }
            return function02.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            focusTransactionManager.commitTransaction();
            InlineMarker.finallyEnd(1);
        }
    }

    public final <T> T withNewTransaction(Function0<Unit> function0, Function0<? extends T> function02) {
        try {
            if (this.ongoingTransaction) {
                cancelTransaction();
            }
            beginTransaction();
            if (function0 != null) {
                this.cancellationListener.add(function0);
            }
            return function02.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            commitTransaction();
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: finally extract failed */
    public static /* synthetic */ Object withExistingTransaction$default(FocusTransactionManager focusTransactionManager, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if (function0 != null) {
            focusTransactionManager.cancellationListener.add(function0);
        }
        if (focusTransactionManager.ongoingTransaction) {
            return function02.invoke();
        }
        try {
            focusTransactionManager.beginTransaction();
            Object invoke = function02.invoke();
            InlineMarker.finallyStart(1);
            focusTransactionManager.commitTransaction();
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            focusTransactionManager.commitTransaction();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public final <T> T withExistingTransaction(Function0<Unit> function0, Function0<? extends T> function02) {
        if (function0 != null) {
            this.cancellationListener.add(function0);
        }
        if (this.ongoingTransaction) {
            return function02.invoke();
        }
        try {
            beginTransaction();
            T invoke = function02.invoke();
            InlineMarker.finallyStart(1);
            commitTransaction();
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            commitTransaction();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public final FocusStateImpl getUncommittedFocusState(FocusTargetNode focusTargetNode) {
        return this.states.get(focusTargetNode);
    }

    public final void setUncommittedFocusState(FocusTargetNode focusTargetNode, FocusStateImpl focusStateImpl) {
        Map<FocusTargetNode, FocusStateImpl> map = this.states;
        if (focusStateImpl != null) {
            map.put(focusTargetNode, focusStateImpl);
            return;
        }
        throw new IllegalStateException("requires a non-null focus state".toString());
    }

    /* access modifiers changed from: private */
    public final void beginTransaction() {
        this.ongoingTransaction = true;
    }

    /* access modifiers changed from: private */
    public final void commitTransaction() {
        for (FocusTargetNode commitFocusState$ui_release : this.states.keySet()) {
            commitFocusState$ui_release.commitFocusState$ui_release();
        }
        this.states.clear();
        this.ongoingTransaction = false;
    }

    /* access modifiers changed from: private */
    public final void cancelTransaction() {
        MutableVector<Function0<Unit>> mutableVector = this.cancellationListener;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                ((Function0) content[i]).invoke();
                i++;
            } while (i < size);
        }
        this.cancellationListener.clear();
        this.states.clear();
        this.ongoingTransaction = false;
    }
}
