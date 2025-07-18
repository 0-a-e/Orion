package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: KotlinTypeRefiner.kt */
public abstract class KotlinTypeRefiner extends AbstractTypeRefiner {
    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId classId);

    public abstract <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor classDescriptor, Function0<? extends S> function0);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor moduleDescriptor);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor);

    public abstract KotlinType refineType(KotlinTypeMarker kotlinTypeMarker);

    /* compiled from: KotlinTypeRefiner.kt */
    public static final class Default extends KotlinTypeRefiner {
        public static final Default INSTANCE = new Default();

        public ClassDescriptor findClassAcrossModuleDependencies(ClassId classId) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            return null;
        }

        public boolean isRefinementNeededForModule(ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        public boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor) {
            Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
            return false;
        }

        public ClassDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor) {
            Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
            return null;
        }

        private Default() {
        }

        public KotlinType refineType(KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, TransferTable.COLUMN_TYPE);
            return (KotlinType) kotlinTypeMarker;
        }

        public Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes, "getSupertypes(...)");
            return supertypes;
        }

        public <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor classDescriptor, Function0<? extends S> function0) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics.checkNotNullParameter(function0, "compute");
            return (MemberScope) function0.invoke();
        }
    }
}
