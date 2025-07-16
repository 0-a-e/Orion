package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    private final TypeProjection[] arguments;
    private final TypeParameterDescriptor[] parameters;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z);
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptorArr, "parameters");
        Intrinsics.checkNotNullParameter(typeProjectionArr, "arguments");
        this.parameters = typeParameterDescriptorArr;
        this.arguments = typeProjectionArr;
        this.approximateContravariantCapturedTypes = z;
        int length = typeParameterDescriptorArr.length;
        int length2 = typeProjectionArr.length;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> list, List<? extends TypeProjection> list2) {
        this((TypeParameterDescriptor[]) list.toArray(new TypeParameterDescriptor[0]), (TypeProjection[]) list2.toArray(new TypeProjection[0]), false, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "parameters");
        Intrinsics.checkNotNullParameter(list2, "argumentsList");
    }

    public boolean isEmpty() {
        return this.arguments.length == 0;
    }

    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, TransferTable.COLUMN_KEY);
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return null;
        }
        int index = typeParameterDescriptor.getIndex();
        TypeParameterDescriptor[] typeParameterDescriptorArr = this.parameters;
        if (index >= typeParameterDescriptorArr.length || !Intrinsics.areEqual((Object) typeParameterDescriptorArr[index].getTypeConstructor(), (Object) typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.arguments[index];
    }
}
