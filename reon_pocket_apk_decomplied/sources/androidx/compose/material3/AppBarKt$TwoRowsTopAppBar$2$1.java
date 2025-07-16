package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TwoRowsTopAppBar$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.FloatRef $maxHeightPx;
    final /* synthetic */ Ref.FloatRef $pinnedHeightPx;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TwoRowsTopAppBar$2$1(TopAppBarScrollBehavior topAppBarScrollBehavior, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
        super(0);
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$pinnedHeightPx = floatRef;
        this.$maxHeightPx = floatRef2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r4 = this;
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r4.$scrollBehavior
            r1 = 0
            if (r0 == 0) goto L_0x0014
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            if (r0 == 0) goto L_0x0014
            float r0 = r0.getHeightOffsetLimit()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            kotlin.jvm.internal.Ref$FloatRef r2 = r4.$pinnedHeightPx
            float r2 = r2.element
            kotlin.jvm.internal.Ref$FloatRef r3 = r4.$maxHeightPx
            float r3 = r3.element
            float r2 = r2 - r3
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Float) r0, (float) r2)
            if (r0 != 0) goto L_0x003b
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r4.$scrollBehavior
            if (r0 == 0) goto L_0x002c
            androidx.compose.material3.TopAppBarState r1 = r0.getState()
        L_0x002c:
            if (r1 != 0) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            kotlin.jvm.internal.Ref$FloatRef r0 = r4.$pinnedHeightPx
            float r0 = r0.element
            kotlin.jvm.internal.Ref$FloatRef r2 = r4.$maxHeightPx
            float r2 = r2.element
            float r0 = r0 - r2
            r1.setHeightOffsetLimit(r0)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1.invoke():void");
    }
}
