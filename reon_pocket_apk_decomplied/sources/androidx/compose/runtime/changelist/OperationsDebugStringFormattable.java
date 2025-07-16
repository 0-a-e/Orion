package androidx.compose.runtime.changelist;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H&\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "", "toDebugString", "", "linePrefix", "Landroidx/compose/runtime/changelist/ChangeList;", "Landroidx/compose/runtime/changelist/FixupList;", "Landroidx/compose/runtime/changelist/Operations;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Operations.kt */
public interface OperationsDebugStringFormattable {
    String toDebugString(String str);

    /* renamed from: androidx.compose.runtime.changelist.OperationsDebugStringFormattable$-CC  reason: invalid class name */
    /* compiled from: Operations.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ String toDebugString$default(OperationsDebugStringFormattable operationsDebugStringFormattable, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "  ";
                }
                return operationsDebugStringFormattable.toDebugString(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toDebugString");
        }
    }
}
