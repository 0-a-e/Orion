package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$2 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$2 INSTANCE = new OperatorChecks$checks$2();

    OperatorChecks$checks$2() {
        super(1);
    }

    private static final boolean invoke$isAny(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) declarationDescriptor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ab A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4) {
        /*
            r3 = this;
            java.lang.String r0 = "$this$$receiver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.reflect.jvm.internal.impl.util.OperatorChecks r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
            kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks r0 = (kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks) r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r4.getContainingDeclaration()
            java.lang.String r1 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = invoke$isAny(r0)
            if (r0 != 0) goto L_0x0054
            java.util.Collection r0 = r4.getOverriddenDescriptors()
            java.lang.String r2 = "getOverriddenDescriptors(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x002d
            goto L_0x004b
        L_0x002d:
            java.util.Iterator r0 = r0.iterator()
        L_0x0031:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r2.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            boolean r2 = invoke$isAny(r2)
            if (r2 == 0) goto L_0x0031
            goto L_0x0054
        L_0x004b:
            boolean r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt.isTypedEqualsInValueClass(r4)
            if (r0 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r0 = 0
            goto L_0x0055
        L_0x0054:
            r0 = 1
        L_0x0055:
            if (r0 != 0) goto L_0x00ab
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "must override ''equals()'' in Any"
            r0.<init>(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r4.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(r2)
            if (r1 == 0) goto L_0x00a1
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer r1 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.SHORT_NAMES_IN_TYPES
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = r4.getContainingDeclaration()
            java.lang.String r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getDefaultType()
            java.lang.String r2 = "getDefaultType(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r4)
            java.lang.String r4 = r1.renderType(r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " or define ''equals(other: "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = "): Boolean''"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.append(r4)
        L_0x00a1:
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            goto L_0x00ac
        L_0x00ab:
            r4 = 0
        L_0x00ac:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):java.lang.String");
    }
}
