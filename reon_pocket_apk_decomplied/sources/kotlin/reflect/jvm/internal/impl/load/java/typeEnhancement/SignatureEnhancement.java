package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement {
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(JavaTypeEnhancement javaTypeEnhancement) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancement, "typeEnhancement");
        this.typeEnhancement = javaTypeEnhancement;
    }

    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext lazyJavaResolverContext, Collection<? extends D> collection) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(collection, "platformSignatures");
        Iterable<CallableMemberDescriptor> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (CallableMemberDescriptor enhanceSignature : iterable) {
            arrayList.add(enhanceSignature(enhanceSignature, lazyJavaResolverContext));
        }
        return (List) arrayList;
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D d, LazyJavaResolverContext lazyJavaResolverContext) {
        ClassifierDescriptor topLevelContainingClassifier = DescriptorUtilKt.getTopLevelContainingClassifier((DeclarationDescriptor) d);
        if (topLevelContainingClassifier == null) {
            return d.getAnnotations();
        }
        List<JavaAnnotation> list = null;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = topLevelContainingClassifier instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor) topLevelContainingClassifier : null;
        if (lazyJavaClassDescriptor != null) {
            list = lazyJavaClassDescriptor.getModuleAnnotations();
        }
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            return d.getAnnotations();
        }
        Iterable<JavaAnnotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (JavaAnnotation lazyJavaAnnotationDescriptor : iterable) {
            arrayList.add(new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, lazyJavaAnnotationDescriptor, true));
        }
        return Annotations.Companion.create(CollectionsKt.plus(d.getAnnotations(), (Annotations) (List) arrayList));
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0216 A[EDGE_INSN: B:137:0x0216->B:99:0x0216 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D enhanceSignature(D r22, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r23) {
        /*
            r21 = this;
            r11 = r21
            r12 = r22
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
            if (r0 != 0) goto L_0x0009
            return r12
        L_0x0009:
            r13 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r13 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor) r13
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r0 = r13.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r1 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE
            r14 = 1
            if (r0 != r1) goto L_0x0024
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = r13.getOriginal()
            java.util.Collection r0 = r0.getOverriddenDescriptors()
            int r0 = r0.size()
            if (r0 != r14) goto L_0x0024
            return r12
        L_0x0024:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r21.getDefaultAnnotations(r22, r23)
            r7 = r23
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(r7, r0)
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor
            if (r0 == 0) goto L_0x004c
            r0 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r1 = r0.getGetter()
            if (r1 == 0) goto L_0x004c
            boolean r1 = r1.isDefault()
            if (r1 != 0) goto L_0x004c
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r0 = r0.getGetter()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            r9 = r0
            goto L_0x004d
        L_0x004c:
            r9 = r12
        L_0x004d:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r13.getExtensionReceiverParameter()
            r15 = 0
            if (r0 == 0) goto L_0x007d
            boolean r0 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r0 == 0) goto L_0x005c
            r0 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            goto L_0x005d
        L_0x005c:
            r0 = r15
        L_0x005d:
            if (r0 == 0) goto L_0x0069
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor$UserDataKey<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r1 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER
            java.lang.Object r0 = r0.getUserData(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            r2 = r0
            goto L_0x006a
        L_0x0069:
            r2 = r15
        L_0x006a:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1 r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.INSTANCE
            r6 = r0
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r4 = 0
            r5 = 0
            r0 = r21
            r1 = r22
            r3 = r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.enhanceValueParameter(r1, r2, r3, r4, r5, r6)
            r16 = r0
            goto L_0x007f
        L_0x007d:
            r16 = r15
        L_0x007f:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor
            if (r0 == 0) goto L_0x0087
            r0 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) r0
            goto L_0x0088
        L_0x0087:
            r0 = r15
        L_0x0088:
            r10 = 0
            if (r0 == 0) goto L_0x00b2
            kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r0.getContainingDeclaration()
            java.lang.String r3 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            r3 = 3
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r0, r10, r10, r3, r15)
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt.signature(r1, r2, r0)
            if (r0 == 0) goto L_0x00b2
            java.util.Map r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE()
            java.lang.Object r0 = r1.get(r0)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo) r0
            r17 = r0
            goto L_0x00b4
        L_0x00b2:
            r17 = r15
        L_0x00b4:
            if (r17 == 0) goto L_0x00c4
            java.util.List r0 = r17.getParametersInfo()
            r0.size()
            java.util.List r0 = r13.getValueParameters()
            r0.size()
        L_0x00c4:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r23.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState r0 = r0.getJavaTypeEnhancementState()
            boolean r0 = kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.isJspecifyEnabledInStrictMode(r0)
            if (r0 != 0) goto L_0x00e0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r8.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r0 = r0.getSettings()
            boolean r0 = r0.getIgnoreNullabilityForErasedValueParameters()
            if (r0 == 0) goto L_0x00e8
        L_0x00e0:
            boolean r0 = kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.hasErasedValueParameters(r22)
            if (r0 == 0) goto L_0x00e8
            r7 = r14
            goto L_0x00e9
        L_0x00e8:
            r7 = r10
        L_0x00e9:
            java.util.List r0 = r9.getValueParameters()
            java.lang.String r6 = "getValueParameters(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r5 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r5)
            r1.<init>(r2)
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r18 = r0.iterator()
        L_0x0106:
            boolean r0 = r18.hasNext()
            if (r0 == 0) goto L_0x014e
            java.lang.Object r0 = r18.next()
            r2 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r2
            if (r17 == 0) goto L_0x0128
            java.util.List r0 = r17.getParametersInfo()
            if (r0 == 0) goto L_0x0128
            int r1 = r2.getIndex()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r1)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo) r0
            r19 = r0
            goto L_0x012a
        L_0x0128:
            r19 = r15
        L_0x012a:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1 r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1
            r0.<init>(r2)
            r20 = r0
            kotlin.jvm.functions.Function1 r20 = (kotlin.jvm.functions.Function1) r20
            r0 = r21
            r1 = r22
            r3 = r8
            r10 = r4
            r4 = r19
            r15 = r5
            r5 = r7
            r15 = r6
            r6 = r20
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.enhanceValueParameter(r1, r2, r3, r4, r5, r6)
            r10.add(r0)
            r4 = r10
            r6 = r15
            r5 = 10
            r10 = 0
            r15 = 0
            goto L_0x0106
        L_0x014e:
            r10 = r4
            r15 = r6
            r18 = r10
            java.util.List r18 = (java.util.List) r18
            r2 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r2
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
            if (r0 == 0) goto L_0x015f
            r0 = r12
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r0
            goto L_0x0160
        L_0x015f:
            r0 = 0
        L_0x0160:
            if (r0 == 0) goto L_0x016b
            boolean r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt.isJavaField(r0)
            if (r0 != r14) goto L_0x016b
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.FIELD
            goto L_0x016d
        L_0x016b:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE
        L_0x016d:
            r5 = r0
            if (r17 == 0) goto L_0x0176
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r0 = r17.getReturnTypeInfo()
            r6 = r0
            goto L_0x0177
        L_0x0176:
            r6 = 0
        L_0x0177:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE
            r9 = r0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r10 = 32
            r17 = 0
            r3 = 1
            r7 = 0
            r0 = r21
            r1 = r22
            r4 = r8
            r8 = r9
            r9 = r10
            r20 = 0
            r10 = r17
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = enhance$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r13.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = r11.containsFunctionN(r1)
            java.lang.String r2 = "getType(...)"
            if (r1 != 0) goto L_0x01f1
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r13.getExtensionReceiverParameter()
            if (r1 == 0) goto L_0x01b1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            if (r1 == 0) goto L_0x01b1
            boolean r10 = r11.containsFunctionN(r1)
            goto L_0x01b3
        L_0x01b1:
            r10 = r20
        L_0x01b3:
            if (r10 != 0) goto L_0x01f1
            java.util.List r1 = r13.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r15)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r3 = r1 instanceof java.util.Collection
            if (r3 == 0) goto L_0x01ce
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x01ce
        L_0x01cb:
            r10 = r20
            goto L_0x01ec
        L_0x01ce:
            java.util.Iterator r1 = r1.iterator()
        L_0x01d2:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x01cb
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            boolean r3 = r11.containsFunctionN(r3)
            if (r3 == 0) goto L_0x01d2
            r10 = r14
        L_0x01ec:
            if (r10 == 0) goto L_0x01ef
            goto L_0x01f1
        L_0x01ef:
            r1 = 0
            goto L_0x0201
        L_0x01f1:
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor$UserDataKey r1 = kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY()
            kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo r3 = new kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo
            r4 = r12
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r4
            r3.<init>(r4)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r3)
        L_0x0201:
            if (r16 != 0) goto L_0x0237
            if (r0 != 0) goto L_0x0237
            r3 = r18
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L_0x0219
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0219
        L_0x0216:
            r14 = r20
            goto L_0x0231
        L_0x0219:
            java.util.Iterator r3 = r3.iterator()
        L_0x021d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0216
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            if (r4 == 0) goto L_0x022d
            r10 = r14
            goto L_0x022f
        L_0x022d:
            r10 = r20
        L_0x022f:
            if (r10 == 0) goto L_0x021d
        L_0x0231:
            if (r14 != 0) goto L_0x0237
            if (r1 == 0) goto L_0x0236
            goto L_0x0237
        L_0x0236:
            return r12
        L_0x0237:
            if (r16 != 0) goto L_0x0246
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r3 = r13.getExtensionReceiverParameter()
            if (r3 == 0) goto L_0x0244
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = r3.getType()
            goto L_0x0248
        L_0x0244:
            r15 = 0
            goto L_0x0248
        L_0x0246:
            r15 = r16
        L_0x0248:
            r3 = r18
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
            r10 = r20
        L_0x025f:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x028a
            java.lang.Object r5 = r3.next()
            int r6 = r10 + 1
            if (r10 >= 0) goto L_0x0270
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0270:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
            if (r5 != 0) goto L_0x0285
            java.util.List r5 = r13.getValueParameters()
            java.lang.Object r5 = r5.get(r10)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r5
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r5.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
        L_0x0285:
            r4.add(r5)
            r10 = r6
            goto L_0x025f
        L_0x028a:
            java.util.List r4 = (java.util.List) r4
            if (r0 != 0) goto L_0x0295
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r13.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
        L_0x0295:
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r0 = r13.enhance(r15, r4, r0, r1)
            java.lang.String r1 = "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor typeParameterDescriptor, List<? extends KotlinType> list, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(list, "bounds");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
        Iterable<KotlinType> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType kotlinType : iterable) {
            if (!TypeUtilsKt.contains(kotlinType, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE)) {
                KotlinType kotlinType2 = kotlinType;
                KotlinType enhance$default = enhance$default(this, new SignatureParts(typeParameterDescriptor, false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, (DefaultConstructorMarker) null), kotlinType2, CollectionsKt.emptyList(), (TypeEnhancementInfo) null, false, 12, (Object) null);
                if (enhance$default != null) {
                    kotlinType = enhance$default;
                }
            }
            arrayList.add(kotlinType);
        }
        return (List) arrayList;
    }

    public final KotlinType enhanceSuperType(KotlinType kotlinType, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(kotlinType, TransferTable.COLUMN_TYPE);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
        KotlinType enhance$default = enhance$default(this, new SignatureParts((Annotated) null, false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_USE, true), kotlinType, CollectionsKt.emptyList(), (TypeEnhancementInfo) null, false, 12, (Object) null);
        return enhance$default == null ? kotlinType : enhance$default;
    }

    private final boolean containsFunctionN(KotlinType kotlinType) {
        return TypeUtils.contains(kotlinType, SignatureEnhancement$containsFunctionN$1.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r11 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(r12, r11.getAnnotations());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType enhanceValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r10, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r11, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r12, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r13, boolean r14, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> r15) {
        /*
            r9 = this;
            r2 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r2
            if (r11 == 0) goto L_0x0012
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11 = r11.getAnnotations()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r11 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(r12, r11)
            if (r11 != 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r4 = r11
            goto L_0x0013
        L_0x0012:
            r4 = r12
        L_0x0013:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r5 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.VALUE_PARAMETER
            r3 = 0
            r0 = r9
            r1 = r10
            r6 = r13
            r7 = r14
            r8 = r15
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r0.enhance(r1, r2, r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo, boolean, kotlin.jvm.functions.Function1):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z2, Function1 function1, int i, Object obj) {
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, (i & 32) != 0 ? false : z2, function1);
    }

    private final KotlinType enhance(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z2, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        Function1<? super CallableMemberDescriptor, ? extends KotlinType> function12 = function1;
        SignatureParts signatureParts = new SignatureParts(annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, false, 16, (DefaultConstructorMarker) null);
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        KotlinType kotlinType = (KotlinType) function12.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        Iterable<CallableMemberDescriptor> iterable = overriddenDescriptors;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (CallableMemberDescriptor callableMemberDescriptor3 : iterable) {
            Intrinsics.checkNotNull(callableMemberDescriptor3);
            arrayList.add((KotlinType) function12.invoke(callableMemberDescriptor3));
        }
        return enhance(signatureParts, kotlinType, (List) arrayList, typeEnhancementInfo, z2);
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, SignatureParts signatureParts, KotlinType kotlinType, List list, TypeEnhancementInfo typeEnhancementInfo, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            typeEnhancementInfo = null;
        }
        TypeEnhancementInfo typeEnhancementInfo2 = typeEnhancementInfo;
        if ((i & 8) != 0) {
            z = false;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo2, z);
    }

    private final KotlinType enhance(SignatureParts signatureParts, KotlinType kotlinType, List<? extends KotlinType> list, TypeEnhancementInfo typeEnhancementInfo, boolean z) {
        return this.typeEnhancement.enhance(kotlinType, signatureParts.computeIndexedQualifiers(kotlinType, list, typeEnhancementInfo, z), signatureParts.getSkipRawTypeArguments());
    }
}
