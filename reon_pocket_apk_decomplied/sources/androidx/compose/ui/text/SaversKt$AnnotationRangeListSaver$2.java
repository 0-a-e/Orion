package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "", "it", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotationRangeListSaver$2 extends Lambda implements Function1<Object, List<? extends AnnotatedString.Range<? extends Object>>> {
    public static final SaversKt$AnnotationRangeListSaver$2 INSTANCE = new SaversKt$AnnotationRangeListSaver$2();

    SaversKt$AnnotationRangeListSaver$2() {
        super(1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: androidx.compose.ui.text.AnnotatedString$Range} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.ui.text.AnnotatedString.Range<? extends java.lang.Object>> invoke(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r0)
            java.util.List r10 = (java.util.List) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r10.size()
            r0.<init>(r1)
            int r1 = r10.size()
            r2 = 0
            r3 = r2
        L_0x0016:
            if (r3 >= r1) goto L_0x0045
            java.lang.Object r4 = r10.get(r3)
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            androidx.compose.runtime.saveable.Saver r6 = androidx.compose.ui.text.SaversKt.AnnotationRangeSaver
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r7)
            r8 = 0
            if (r7 == 0) goto L_0x0033
            boolean r7 = r6 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r7 != 0) goto L_0x0033
            goto L_0x003c
        L_0x0033:
            if (r4 == 0) goto L_0x003c
            java.lang.Object r4 = r6.restore(r4)
            r8 = r4
            androidx.compose.ui.text.AnnotatedString$Range r8 = (androidx.compose.ui.text.AnnotatedString.Range) r8
        L_0x003c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r5.add(r8)
            int r3 = r3 + 1
            goto L_0x0016
        L_0x0045:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2.invoke(java.lang.Object):java.util.List");
    }
}
