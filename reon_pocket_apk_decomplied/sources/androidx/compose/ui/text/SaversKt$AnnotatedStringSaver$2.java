package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/AnnotatedString;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotatedStringSaver$2 extends Lambda implements Function1<Object, AnnotatedString> {
    public static final SaversKt$AnnotatedStringSaver$2 INSTANCE = new SaversKt$AnnotatedStringSaver$2();

    SaversKt$AnnotatedStringSaver$2() {
        super(1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.AnnotatedString invoke(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r0)
            java.util.List r8 = (java.util.List) r8
            r0 = 1
            java.lang.Object r0 = r8.get(r0)
            androidx.compose.runtime.saveable.Saver r1 = androidx.compose.ui.text.SaversKt.AnnotationRangeListSaver
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            r5 = 0
            if (r4 == 0) goto L_0x0021
            boolean r4 = r1 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r4 != 0) goto L_0x0021
            goto L_0x002a
        L_0x0021:
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r1.restore(r0)
            java.util.List r0 = (java.util.List) r0
            goto L_0x002b
        L_0x002a:
            r0 = r5
        L_0x002b:
            r1 = 2
            java.lang.Object r1 = r8.get(r1)
            androidx.compose.runtime.saveable.Saver r4 = androidx.compose.ui.text.SaversKt.AnnotationRangeListSaver
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r6 == 0) goto L_0x003f
            boolean r6 = r4 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r6 != 0) goto L_0x003f
            goto L_0x0048
        L_0x003f:
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r4.restore(r1)
            java.util.List r1 = (java.util.List) r1
            goto L_0x0049
        L_0x0048:
            r1 = r5
        L_0x0049:
            java.lang.Object r2 = r8.get(r2)
            if (r2 == 0) goto L_0x0052
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0053
        L_0x0052:
            r2 = r5
        L_0x0053:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            if (r0 == 0) goto L_0x0064
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x0061
            r0 = r5
        L_0x0061:
            java.util.List r0 = (java.util.List) r0
            goto L_0x0065
        L_0x0064:
            r0 = r5
        L_0x0065:
            if (r1 == 0) goto L_0x0073
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x0070
            r1 = r5
        L_0x0070:
            java.util.List r1 = (java.util.List) r1
            goto L_0x0074
        L_0x0073:
            r1 = r5
        L_0x0074:
            r4 = 3
            java.lang.Object r8 = r8.get(r4)
            androidx.compose.runtime.saveable.Saver r4 = androidx.compose.ui.text.SaversKt.AnnotationRangeListSaver
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0088
            boolean r3 = r4 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r3 != 0) goto L_0x0088
            goto L_0x0091
        L_0x0088:
            if (r8 == 0) goto L_0x0091
            java.lang.Object r8 = r4.restore(r8)
            r5 = r8
            java.util.List r5 = (java.util.List) r5
        L_0x0091:
            androidx.compose.ui.text.AnnotatedString r8 = new androidx.compose.ui.text.AnnotatedString
            r8.<init>(r2, r0, r1, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2.invoke(java.lang.Object):androidx.compose.ui.text.AnnotatedString");
    }
}
