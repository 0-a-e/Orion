package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: KotlinTypePreparator.kt */
public abstract class KotlinTypePreparator extends AbstractTypePreparator {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX WARNING: type inference failed for: r3v3, types: [kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType r15) {
        /*
            r14 = this;
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r15.getConstructor()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl
            r2 = 10
            r3 = 0
            if (r1 == 0) goto L_0x0088
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl r0 = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl) r0
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r1 = r0.getProjection()
            kotlin.reflect.jvm.internal.impl.types.Variance r4 = r1.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r4 != r5) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = r3
        L_0x001b:
            if (r1 == 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            if (r1 == 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3 = r1.unwrap()
        L_0x0027:
            r7 = r3
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r1 = r0.getNewTypeConstructor()
            if (r1 != 0) goto L_0x006a
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r9 = r0.getProjection()
            java.util.Collection r1 = r0.getSupertypes()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r2)
            r3.<init>(r2)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        L_0x0047:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x005b
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r2 = r2.unwrap()
            r3.add(r2)
            goto L_0x0047
        L_0x005b:
            r10 = r3
            java.util.List r10 = (java.util.List) r10
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r1 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor
            r11 = 0
            r12 = 4
            r13 = 0
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13)
            r0.setNewTypeConstructor(r1)
        L_0x006a:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r1 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
            kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus r5 = kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r6 = r0.getNewTypeConstructor()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes r8 = r15.getAttributes()
            boolean r9 = r15.isMarkedNullable()
            r11 = 32
            r12 = 0
            r10 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1
            return r1
        L_0x0088:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor
            r4 = 0
            if (r1 == 0) goto L_0x00dd
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor) r0
            java.util.Collection r0 = r0.getSupertypes()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x00a4:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00c1
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            boolean r3 = r15.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified(r2, r3)
            java.lang.String r3 = "makeNullableAsSpecified(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.add(r2)
            goto L_0x00a4
        L_0x00c1:
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r1 = (java.util.Collection) r1
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r0.<init>(r1)
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes r1 = r15.getAttributes()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r0
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r15 = r15.getMemberScope()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r1, r0, r2, r4, r15)
            return r15
        L_0x00dd:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r1 == 0) goto L_0x0135
            boolean r1 = r15.isMarkedNullable()
            if (r1 == 0) goto L_0x0135
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r0
            java.util.Collection r15 = r0.getSupertypes()
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r15 = r15.iterator()
        L_0x00fe:
            boolean r2 = r15.hasNext()
            if (r2 == 0) goto L_0x0113
            java.lang.Object r2 = r15.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r2)
            r1.add(r2)
            r4 = 1
            goto L_0x00fe
        L_0x0113:
            java.util.List r1 = (java.util.List) r1
            if (r4 != 0) goto L_0x0118
            goto L_0x012d
        L_0x0118:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = r0.getAlternativeType()
            if (r15 == 0) goto L_0x0122
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r15)
        L_0x0122:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r15 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            java.util.Collection r1 = (java.util.Collection) r1
            r15.<init>(r1)
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r3 = r15.setAlternative(r3)
        L_0x012d:
            if (r3 != 0) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r0 = r3
        L_0x0131:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = r0.createType()
        L_0x0135:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    public UnwrappedType prepareType(KotlinTypeMarker kotlinTypeMarker) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, TransferTable.COLUMN_TYPE);
        if (kotlinTypeMarker instanceof KotlinType) {
            UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
            if (unwrap instanceof SimpleType) {
                unwrappedType = transformToNewType((SimpleType) unwrap);
            } else if (unwrap instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) unwrap;
                SimpleType transformToNewType = transformToNewType(flexibleType.getLowerBound());
                SimpleType transformToNewType2 = transformToNewType(flexibleType.getUpperBound());
                if (transformToNewType == flexibleType.getLowerBound() && transformToNewType2 == flexibleType.getUpperBound()) {
                    unwrappedType = unwrap;
                } else {
                    unwrappedType = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap, new KotlinTypePreparator$prepareType$1(this));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* compiled from: KotlinTypePreparator.kt */
    public static final class Default extends KotlinTypePreparator {
        public static final Default INSTANCE = new Default();

        private Default() {
        }
    }
}
