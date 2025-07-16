package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$SingleRowTopAppBar$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ float $heightOffsetLimit;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$SingleRowTopAppBar$1$1(TopAppBarScrollBehavior topAppBarScrollBehavior, float f) {
        super(0);
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$heightOffsetLimit = f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r3 = this;
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r3.$scrollBehavior
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
            float r2 = r3.$heightOffsetLimit
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Float) r0, (float) r2)
            if (r0 != 0) goto L_0x002d
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r3.$scrollBehavior
            if (r0 == 0) goto L_0x0025
            androidx.compose.material3.TopAppBarState r1 = r0.getState()
        L_0x0025:
            if (r1 != 0) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            float r0 = r3.$heightOffsetLimit
            r1.setHeightOffsetLimit(r0)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1.invoke():void");
    }
}
