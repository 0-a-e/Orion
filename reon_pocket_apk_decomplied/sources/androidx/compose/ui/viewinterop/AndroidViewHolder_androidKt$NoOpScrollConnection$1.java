package androidx.compose.ui.viewinterop;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"androidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
public final class AndroidViewHolder_androidKt$NoOpScrollConnection$1 implements NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public /* synthetic */ Object m6868onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return NestedScrollConnection.CC.m4975$default$onPostFlingRZ2iAVY(this, j, j2, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public /* synthetic */ long m6869onPostScrollDzOQY0M(long j, long j2, int i) {
        return NestedScrollConnection.CC.m4976$default$onPostScrollDzOQY0M(this, j, j2, i);
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m6870onPreFlingQWom1Mo(long j, Continuation continuation) {
        return NestedScrollConnection.CC.m4977$default$onPreFlingQWom1Mo(this, j, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public /* synthetic */ long m6871onPreScrollOzD1aCk(long j, int i) {
        return NestedScrollConnection.CC.m4978$default$onPreScrollOzD1aCk(this, j, i);
    }

    AndroidViewHolder_androidKt$NoOpScrollConnection$1() {
    }
}
