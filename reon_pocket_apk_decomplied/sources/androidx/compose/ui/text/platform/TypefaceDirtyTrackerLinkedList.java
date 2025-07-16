package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;", "", "resolveResult", "Landroidx/compose/runtime/State;", "next", "(Landroidx/compose/runtime/State;Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;)V", "initial", "getInitial", "()Ljava/lang/Object;", "isStaleResolvedFont", "", "()Z", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraphIntrinsics.android.kt */
final class TypefaceDirtyTrackerLinkedList {
    private final Object initial;
    private final TypefaceDirtyTrackerLinkedList next;
    private final State<Object> resolveResult;

    public TypefaceDirtyTrackerLinkedList(State<? extends Object> state, TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList) {
        this.resolveResult = state;
        this.next = typefaceDirtyTrackerLinkedList;
        this.initial = state.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypefaceDirtyTrackerLinkedList(State state, TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, (i & 2) != 0 ? null : typefaceDirtyTrackerLinkedList);
    }

    public final Object getInitial() {
        return this.initial;
    }

    public final Typeface getTypeface() {
        Object obj = this.initial;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r2.next;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isStaleResolvedFont() {
        /*
            r2 = this;
            androidx.compose.runtime.State<java.lang.Object> r0 = r2.resolveResult
            java.lang.Object r0 = r0.getValue()
            java.lang.Object r1 = r2.initial
            if (r0 != r1) goto L_0x0017
            androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList r0 = r2.next
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.isStaleResolvedFont()
            if (r0 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r0 = 1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList.isStaleResolvedFont():boolean");
    }
}
