package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Set<String> PUBLIC_METHOD_NAMES_IN_OBJECT = SetsKt.setOf("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
    /* access modifiers changed from: private */
    public final ClassDescriptor additionalSupertypeClassDescriptor;
    private final Annotations annotations;
    /* access modifiers changed from: private */
    public final LazyJavaResolverContext c;
    private final NotNullLazyValue<List<TypeParameterDescriptor>> declaredParameters;
    private final InnerClassesScopeWrapper innerClassesScope;
    private final boolean isInner;
    private final JavaClass jClass;
    private final ClassKind kind;
    private final Modality modality;
    private final Lazy moduleAnnotations$delegate;
    private final LazyJavaResolverContext outerContext;
    private final ScopesHolderForClass<LazyJavaClassMemberScope> scopeHolder;
    private final LazyJavaStaticClassScope staticScope;
    private final LazyJavaClassTypeConstructor typeConstructor;
    /* access modifiers changed from: private */
    public final LazyJavaClassMemberScope unsubstitutedMemberScope;
    private final Visibility visibility;

    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return false;
    }

    public boolean isData() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isFun() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, declarationDescriptor, javaClass, (i & 8) != 0 ? null : classDescriptor);
    }

    public final LazyJavaResolverContext getOuterContext() {
        return this.outerContext;
    }

    public final JavaClass getJClass() {
        return this.jClass;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LazyJavaClassDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r17, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r18, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r19, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r20) {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            r15 = r19
            r8 = r20
            java.lang.String r0 = "outerContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "containingDeclaration"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "jClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r1 = r17.getStorageManager()
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r19.getName()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r17.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r0 = r0.getSourceElementFactory()
            r4 = r15
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r4 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement) r4
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r0 = r0.source(r4)
            r4 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = (kotlin.reflect.jvm.internal.impl.descriptors.SourceElement) r4
            r5 = 0
            r0 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            r6.outerContext = r7
            r6.jClass = r15
            r6.additionalSupertypeClassDescriptor = r8
            r1 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor) r1
            r2 = r15
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner) r2
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r17
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForClassOrPackage$default(r0, r1, r2, r3, r4, r5)
            r6.c = r0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r0.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache r1 = r1.getJavaResolverCache()
            r2 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            r1.recordClass(r15, r2)
            r19.getLightClassOriginKind()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$moduleAnnotations$2 r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$moduleAnnotations$2
            r1.<init>(r6)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.Lazy r1 = kotlin.LazyKt.lazy(r1)
            r6.moduleAnnotations$delegate = r1
            boolean r1 = r19.isAnnotationType()
            if (r1 == 0) goto L_0x0077
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            goto L_0x008b
        L_0x0077:
            boolean r1 = r19.isInterface()
            if (r1 == 0) goto L_0x0080
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            goto L_0x008b
        L_0x0080:
            boolean r1 = r19.isEnum()
            if (r1 == 0) goto L_0x0089
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS
            goto L_0x008b
        L_0x0089:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
        L_0x008b:
            r6.kind = r1
            boolean r1 = r19.isAnnotationType()
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x00c2
            boolean r1 = r19.isEnum()
            if (r1 == 0) goto L_0x009c
            goto L_0x00c2
        L_0x009c:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality$Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion
            boolean r5 = r19.isSealed()
            boolean r7 = r19.isSealed()
            if (r7 != 0) goto L_0x00b7
            boolean r7 = r19.isAbstract()
            if (r7 != 0) goto L_0x00b7
            boolean r7 = r19.isInterface()
            if (r7 == 0) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r7 = r3
            goto L_0x00b8
        L_0x00b7:
            r7 = r4
        L_0x00b8:
            boolean r9 = r19.isFinal()
            r9 = r9 ^ r4
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r1 = r1.convertFromFlags(r5, r7, r9)
            goto L_0x00c4
        L_0x00c2:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r1 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
        L_0x00c4:
            r6.modality = r1
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r1 = r19.getVisibility()
            r6.visibility = r1
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r1 = r19.getOuterClass()
            if (r1 == 0) goto L_0x00da
            boolean r1 = r19.isStatic()
            if (r1 != 0) goto L_0x00da
            r1 = r4
            goto L_0x00db
        L_0x00da:
            r1 = r3
        L_0x00db:
            r6.isInner = r1
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor
            r1.<init>()
            r6.typeConstructor = r1
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope
            if (r8 == 0) goto L_0x00ea
            r11 = r4
            goto L_0x00eb
        L_0x00ea:
            r11 = r3
        L_0x00eb:
            r13 = 16
            r14 = 0
            r12 = 0
            r7 = r1
            r8 = r0
            r9 = r2
            r10 = r19
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r6.unsubstitutedMemberScope = r1
            kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$Companion r3 = kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r4 = r0.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r5 = r0.getComponents()
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r5 = r5.getKotlinTypeChecker()
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r5 = r5.getKotlinTypeRefiner()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$scopeHolder$1 r7 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$scopeHolder$1
            r7.<init>(r6)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass r2 = r3.create(r2, r4, r5, r7)
            r6.scopeHolder = r2
            kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper r2 = new kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r1 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) r1
            r2.<init>(r1)
            r6.innerClassesScope = r2
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope
            r2 = r6
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor) r2
            r1.<init>(r0, r15, r2)
            r6.staticScope = r1
            r1 = r15
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner) r1
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(r0, r1)
            r6.annotations = r1
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r0 = r0.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$declaredParameters$1 r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$declaredParameters$1
            r1.<init>(r6)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r0 = r0.createLazyValue(r1)
            r6.declaredParameters = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.<init>(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):void");
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final List<JavaAnnotation> getModuleAnnotations() {
        return (List) this.moduleAnnotations$delegate.getValue();
    }

    public ClassKind getKind() {
        return this.kind;
    }

    public Modality getModality() {
        return this.modality;
    }

    public DescriptorVisibility getVisibility() {
        if (!Intrinsics.areEqual((Object) this.visibility, (Object) DescriptorVisibilities.PRIVATE) || this.jClass.getOuterClass() != null) {
            return UtilsKt.toDescriptorVisibility(this.visibility);
        }
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
        Intrinsics.checkNotNull(descriptorVisibility);
        return descriptorVisibility;
    }

    public boolean isInner() {
        return this.isInner;
    }

    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    /* access modifiers changed from: protected */
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.scopeHolder.getScope(kotlinTypeRefiner);
    }

    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.innerClassesScope;
    }

    public MemberScope getStaticScope() {
        return this.staticScope;
    }

    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope2 = super.getUnsubstitutedMemberScope();
        Intrinsics.checkNotNull(unsubstitutedMemberScope2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (LazyJavaClassMemberScope) unsubstitutedMemberScope2;
    }

    public List<ClassConstructorDescriptor> getConstructors() {
        return (List) this.unsubstitutedMemberScope.getConstructors$descriptors_jvm().invoke();
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return (List) this.declaredParameters.invoke();
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.modality != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, (TypeParameterDescriptor) null, 7, (Object) null);
        Collection arrayList = new ArrayList();
        for (JavaClassifierType transformJavaType : this.jClass.getPermittedTypes()) {
            ClassifierDescriptor declarationDescriptor = this.c.getTypeResolver().transformJavaType(transformJavaType, attributes$default).getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                arrayList.add(classDescriptor);
            }
        }
        return CollectionsKt.sortedWith((List) arrayList, new LazyJavaClassDescriptor$getSealedSubclasses$$inlined$sortedBy$1());
    }

    public String toString() {
        return "Lazy Java class " + DescriptorUtilsKt.getFqNameUnsafe(this);
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    private final class LazyJavaClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        public boolean isDenotable() {
            return true;
        }

        public LazyJavaClassTypeConstructor() {
            super(LazyJavaClassDescriptor.this.c.getStorageManager());
            this.parameters = LazyJavaClassDescriptor.this.c.getStorageManager().createLazyValue(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(LazyJavaClassDescriptor.this));
        }

        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.parameters.invoke();
        }

        /* access modifiers changed from: protected */
        public Collection<KotlinType> computeSupertypes() {
            Object obj;
            Collection<JavaClassifierType> supertypes = LazyJavaClassDescriptor.this.getJClass().getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            ArrayList arrayList2 = new ArrayList(0);
            KotlinType purelyImplementedSupertype = getPurelyImplementedSupertype();
            Iterator<JavaClassifierType> it = supertypes.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                JavaClassifierType next = it.next();
                KotlinType enhanceSuperType = LazyJavaClassDescriptor.this.c.getComponents().getSignatureEnhancement().enhanceSuperType(LazyJavaClassDescriptor.this.c.getTypeResolver().transformJavaType(next, JavaTypeAttributesKt.toAttributes$default(TypeUsage.SUPERTYPE, false, false, (TypeParameterDescriptor) null, 7, (Object) null)), LazyJavaClassDescriptor.this.c);
                if (enhanceSuperType.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) {
                    arrayList2.add(next);
                }
                TypeConstructor constructor = enhanceSuperType.getConstructor();
                if (purelyImplementedSupertype != null) {
                    obj = purelyImplementedSupertype.getConstructor();
                }
                if (!Intrinsics.areEqual((Object) constructor, obj) && !KotlinBuiltIns.isAnyOrNullableAny(enhanceSuperType)) {
                    arrayList.add(enhanceSuperType);
                }
            }
            Collection collection = arrayList;
            ClassDescriptor access$getAdditionalSupertypeClassDescriptor$p = LazyJavaClassDescriptor.this.additionalSupertypeClassDescriptor;
            if (access$getAdditionalSupertypeClassDescriptor$p != null) {
                obj = MappingUtilKt.createMappedTypeParametersSubstitution(access$getAdditionalSupertypeClassDescriptor$p, LazyJavaClassDescriptor.this).buildSubstitutor().substitute(access$getAdditionalSupertypeClassDescriptor$p.getDefaultType(), Variance.INVARIANT);
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, obj);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, purelyImplementedSupertype);
            if (!arrayList2.isEmpty()) {
                ErrorReporter errorReporter = LazyJavaClassDescriptor.this.c.getComponents().getErrorReporter();
                ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
                Iterable<JavaType> iterable = arrayList2;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (JavaType javaType : iterable) {
                    Intrinsics.checkNotNull(javaType, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList3.add(((JavaClassifierType) javaType).getPresentableText());
                }
                errorReporter.reportIncompleteHierarchy(declarationDescriptor, (List) arrayList3);
            }
            return collection.isEmpty() ^ true ? CollectionsKt.toList(arrayList) : CollectionsKt.listOf(LazyJavaClassDescriptor.this.c.getModule().getBuiltIns().getAnyType());
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.util.Collection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.util.List} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final kotlin.reflect.jvm.internal.impl.types.KotlinType getPurelyImplementedSupertype() {
            /*
                r8 = this;
                kotlin.reflect.jvm.internal.impl.name.FqName r0 = r8.getPurelyImplementsFqNameFromAnnotation()
                r1 = 0
                if (r0 == 0) goto L_0x0016
                boolean r2 = r0.isRoot()
                if (r2 != 0) goto L_0x0016
                kotlin.reflect.jvm.internal.impl.name.Name r2 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME
                boolean r2 = r0.startsWith(r2)
                if (r2 == 0) goto L_0x0016
                goto L_0x0017
            L_0x0016:
                r0 = r1
            L_0x0017:
                if (r0 != 0) goto L_0x002a
                kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider r2 = kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider.INSTANCE
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r3 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
                kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r3)
                kotlin.reflect.jvm.internal.impl.name.FqName r2 = r2.getPurelyImplementedInterface(r3)
                if (r2 != 0) goto L_0x002b
                return r1
            L_0x002a:
                r2 = r0
            L_0x002b:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r3 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r3 = r3.c
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r3 = r3.getModule()
                kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r4 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_JAVA_LOADER
                kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r4 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r4
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.resolveTopLevelClass(r3, r2, r4)
                if (r2 != 0) goto L_0x0040
                return r1
            L_0x0040:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r2.getTypeConstructor()
                java.util.List r3 = r3.getParameters()
                int r3 = r3.size()
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r4.getTypeConstructor()
                java.util.List r4 = r4.getParameters()
                java.lang.String r5 = "getParameters(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                int r5 = r4.size()
                r6 = 10
                if (r5 != r3) goto L_0x0094
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r6)
                r0.<init>(r1)
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r1 = r4.iterator()
            L_0x0074:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0091
                java.lang.Object r3 = r1.next()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r3
                kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r4 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
                kotlin.reflect.jvm.internal.impl.types.Variance r5 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.getDefaultType()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
                r4.<init>(r5, r3)
                r0.add(r4)
                goto L_0x0074
            L_0x0091:
                java.util.List r0 = (java.util.List) r0
                goto L_0x00d7
            L_0x0094:
                r7 = 1
                if (r5 != r7) goto L_0x00e4
                if (r3 <= r7) goto L_0x00e4
                if (r0 != 0) goto L_0x00e4
                kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
                kotlin.reflect.jvm.internal.impl.types.Variance r1 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                java.lang.Object r4 = kotlin.collections.CollectionsKt.single(r4)
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r4
                kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getDefaultType()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
                r0.<init>(r1, r4)
                kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
                r1.<init>(r7, r3)
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r3 = new java.util.ArrayList
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r6)
                r3.<init>(r4)
                java.util.Collection r3 = (java.util.Collection) r3
                java.util.Iterator r1 = r1.iterator()
            L_0x00c4:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x00d4
                r4 = r1
                kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
                r4.nextInt()
                r3.add(r0)
                goto L_0x00c4
            L_0x00d4:
                r0 = r3
                java.util.List r0 = (java.util.List) r0
            L_0x00d7:
                kotlin.reflect.jvm.internal.impl.types.TypeAttributes$Companion r1 = kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion
                kotlin.reflect.jvm.internal.impl.types.TypeAttributes r1 = r1.getEmpty()
                kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(r1, r2, r0)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
                return r0
            L_0x00e4:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.getPurelyImplementedSupertype():kotlin.reflect.jvm.internal.impl.types.KotlinType");
        }

        private final FqName getPurelyImplementsFqNameFromAnnotation() {
            String str;
            Annotations annotations = LazyJavaClassDescriptor.this.getAnnotations();
            FqName fqName = JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(fqName, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor findAnnotation = annotations.findAnnotation(fqName);
            if (findAnnotation == null) {
                return null;
            }
            Object singleOrNull = CollectionsKt.singleOrNull(findAnnotation.getAllValueArguments().values());
            StringValue stringValue = singleOrNull instanceof StringValue ? (StringValue) singleOrNull : null;
            if (stringValue == null || (str = (String) stringValue.getValue()) == null || !FqNamesUtilKt.isValidJavaFqName(str)) {
                return null;
            }
            return new FqName(str);
        }

        /* access modifiers changed from: protected */
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return LazyJavaClassDescriptor.this.c.getComponents().getSupertypeLoopChecker();
        }

        public ClassDescriptor getDeclarationDescriptor() {
            return LazyJavaClassDescriptor.this;
        }

        public String toString() {
            String asString = LazyJavaClassDescriptor.this.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return asString;
        }
    }

    public final LazyJavaClassDescriptor copy$descriptors_jvm(JavaResolverCache javaResolverCache, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        LazyJavaResolverContext lazyJavaResolverContext = this.c;
        LazyJavaResolverContext replaceComponents = ContextKt.replaceComponents(lazyJavaResolverContext, lazyJavaResolverContext.getComponents().replace(javaResolverCache));
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        return new LazyJavaClassDescriptor(replaceComponents, containingDeclaration, this.jClass, classDescriptor);
    }
}
