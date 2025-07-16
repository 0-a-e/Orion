package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: TypeSubstitution.kt */
public final class TypeSubstitution$replaceWithNonApproximating$1 extends TypeSubstitution {
    final /* synthetic */ TypeSubstitution this$0;

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    TypeSubstitution$replaceWithNonApproximating$1(TypeSubstitution typeSubstitution) {
        this.this$0 = typeSubstitution;
    }

    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, TransferTable.COLUMN_KEY);
        return this.this$0.get(kotlinType);
    }

    public Annotations filterAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return this.this$0.filterAnnotations(annotations);
    }

    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics.checkNotNullParameter(variance, "position");
        return this.this$0.prepareTopLevelType(kotlinType, variance);
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }
}
