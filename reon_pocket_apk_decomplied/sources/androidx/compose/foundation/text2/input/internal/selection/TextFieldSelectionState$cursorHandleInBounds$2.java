package androidx.compose.foundation.text2.input.internal.selection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$cursorHandleInBounds$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$cursorHandleInBounds$2(TextFieldSelectionState textFieldSelectionState) {
        super(0);
        this.this$0 = textFieldSelectionState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke() {
        /*
            r5 = this;
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r1 = r5.this$0
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.createNonObservableSnapshot()
            androidx.compose.runtime.snapshots.Snapshot r2 = r0.makeCurrent()     // Catch:{ all -> 0x0038 }
            androidx.compose.ui.geometry.Rect r1 = r1.getCursorRect()     // Catch:{ all -> 0x0033 }
            long r3 = r1.m3589getBottomCenterF1C5BW0()     // Catch:{ all -> 0x0033 }
            r0.restoreCurrent(r2)     // Catch:{ all -> 0x0038 }
            r0.dispose()
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r0 = r5.this$0
            androidx.compose.ui.layout.LayoutCoordinates r0 = r0.getTextLayoutCoordinates()
            if (r0 == 0) goto L_0x002d
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)
            if (r0 == 0) goto L_0x002d
            boolean r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1277containsInclusiveUv8p0NA(r0, r3)
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x0033:
            r1 = move-exception
            r0.restoreCurrent(r2)     // Catch:{ all -> 0x0038 }
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r1 = move-exception
            r0.dispose()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleInBounds$2.invoke():java.lang.Boolean");
    }
}
