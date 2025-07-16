package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"EmptyLazyGridLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "rememberLazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridState.kt */
public final class LazyGridStateKt {
    /* access modifiers changed from: private */
    public static final LazyGridMeasureResult EmptyLazyGridLayoutInfo = new LazyGridMeasureResult((LazyGridMeasuredLine) null, 0, false, 0.0f, new LazyGridStateKt$EmptyLazyGridLayoutInfo$1(), false, CollectionsKt.emptyList(), 0, 0, 0, false, Orientation.Vertical, 0, 0);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.grid.LazyGridState rememberLazyGridState(int r10, int r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 29186956(0x1bd5b8c, float:6.9559E-38)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberLazyGridState)68@3084L176:LazyGridState.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0011
            r10 = r2
        L_0x0011:
            r14 = r14 & 2
            if (r14 == 0) goto L_0x0016
            r11 = r2
        L_0x0016:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0022
            r14 = -1
            java.lang.String r1 = "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:67)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r14, r1)
        L_0x0022:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.foundation.lazy.grid.LazyGridState$Companion r13 = androidx.compose.foundation.lazy.grid.LazyGridState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r13.getSaver()
            r13 = -707393359(0xffffffffd5d608b1, float:-2.94166022E13)
            r12.startReplaceableGroup(r13)
            boolean r13 = r12.changed((int) r10)
            boolean r14 = r12.changed((int) r11)
            r13 = r13 | r14
            java.lang.Object r14 = r12.rememberedValue()
            if (r13 != 0) goto L_0x0047
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x0052
        L_0x0047:
            androidx.compose.foundation.lazy.grid.LazyGridStateKt$rememberLazyGridState$1$1 r13 = new androidx.compose.foundation.lazy.grid.LazyGridStateKt$rememberLazyGridState$1$1
            r13.<init>(r10, r11)
            r14 = r13
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r12.updateRememberedValue(r14)
        L_0x0052:
            r6 = r14
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r12.endReplaceableGroup()
            r8 = 72
            r9 = 4
            r5 = 0
            r7 = r12
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.foundation.lazy.grid.LazyGridState r10 = (androidx.compose.foundation.lazy.grid.LazyGridState) r10
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x006c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x006c:
            r12.endReplaceableGroup()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(int, int, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.lazy.grid.LazyGridState");
    }
}
