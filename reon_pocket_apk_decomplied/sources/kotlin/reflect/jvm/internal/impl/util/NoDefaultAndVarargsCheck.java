package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* compiled from: modifierChecks.kt */
final class NoDefaultAndVarargsCheck implements Check {
    public static final NoDefaultAndVarargsCheck INSTANCE = new NoDefaultAndVarargsCheck();
    private static final String description = "should not have varargs or parameters with default values";

    private NoDefaultAndVarargsCheck() {
    }

    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    public String getDescription() {
        return description;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean check(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4) {
        /*
            r3 = this;
            java.lang.String r0 = "functionDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List r4 = r4.getValueParameters()
            java.lang.String r0 = "getValueParameters(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r0 = r4 instanceof java.util.Collection
            r1 = 1
            if (r0 == 0) goto L_0x001f
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001f
            goto L_0x0040
        L_0x001f:
            java.util.Iterator r4 = r4.iterator()
        L_0x0023:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0040
            java.lang.Object r0 = r4.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r0)
            if (r2 != 0) goto L_0x003f
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getVarargElementType()
            if (r0 != 0) goto L_0x003f
            goto L_0x0023
        L_0x003f:
            r1 = 0
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.check(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):boolean");
    }
}
