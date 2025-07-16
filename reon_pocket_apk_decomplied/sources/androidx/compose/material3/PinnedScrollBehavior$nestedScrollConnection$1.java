package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"androidx/compose/material3/PinnedScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
public final class PinnedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ PinnedScrollBehavior this$0;

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public /* synthetic */ Object m2052onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return NestedScrollConnection.CC.m4975$default$onPostFlingRZ2iAVY(this, j, j2, continuation);
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m2054onPreFlingQWom1Mo(long j, Continuation continuation) {
        return NestedScrollConnection.CC.m4977$default$onPreFlingQWom1Mo(this, j, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public /* synthetic */ long m2055onPreScrollOzD1aCk(long j, int i) {
        return NestedScrollConnection.CC.m4978$default$onPreScrollOzD1aCk(this, j, i);
    }

    PinnedScrollBehavior$nestedScrollConnection$1(PinnedScrollBehavior pinnedScrollBehavior) {
        this.this$0 = pinnedScrollBehavior;
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m2053onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        if (Offset.m3563getYimpl(j) != 0.0f || Offset.m3563getYimpl(j2) <= 0.0f) {
            TopAppBarState state = this.this$0.getState();
            state.setContentOffset(state.getContentOffset() + Offset.m3563getYimpl(j));
        } else {
            this.this$0.getState().setContentOffset(0.0f);
        }
        return Offset.Companion.m3578getZeroF1C5BW0();
    }
}
