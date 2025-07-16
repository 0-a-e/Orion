package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$methods$1 extends Lambda implements Function1<Method, Boolean> {
    final /* synthetic */ ReflectJavaClass this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        super(1);
        this.this$0 = reflectJavaClass;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        if (r0.isEnumValuesOrValueOf(r4) == false) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(java.lang.reflect.Method r4) {
        /*
            r3 = this;
            boolean r0 = r4.isSynthetic()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            goto L_0x001d
        L_0x0008:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = r3.this$0
            boolean r0 = r0.isEnum()
            r2 = 1
            if (r0 == 0) goto L_0x001c
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = r3.this$0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r4 = r0.isEnumValuesOrValueOf(r4)
            if (r4 != 0) goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$1.invoke(java.lang.reflect.Method):java.lang.Boolean");
    }
}
