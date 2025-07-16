package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader;

/* compiled from: AbstractBinaryClassAnnotationLoader.kt */
public final class AnnotationsContainerWithConstants<A, C> extends AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {
    private final Map<MemberSignature, C> annotationParametersDefaultValues;
    private final Map<MemberSignature, List<A>> memberAnnotations;
    private final Map<MemberSignature, C> propertyConstants;

    public Map<MemberSignature, List<A>> getMemberAnnotations() {
        return this.memberAnnotations;
    }

    public final Map<MemberSignature, C> getPropertyConstants() {
        return this.propertyConstants;
    }

    public final Map<MemberSignature, C> getAnnotationParametersDefaultValues() {
        return this.annotationParametersDefaultValues;
    }

    public AnnotationsContainerWithConstants(Map<MemberSignature, ? extends List<? extends A>> map, Map<MemberSignature, ? extends C> map2, Map<MemberSignature, ? extends C> map3) {
        Intrinsics.checkNotNullParameter(map, "memberAnnotations");
        Intrinsics.checkNotNullParameter(map2, "propertyConstants");
        Intrinsics.checkNotNullParameter(map3, "annotationParametersDefaultValues");
        this.memberAnnotations = map;
        this.propertyConstants = map2;
        this.annotationParametersDefaultValues = map3;
    }
}
