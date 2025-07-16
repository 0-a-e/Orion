package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaAnnotationOwner.kt */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {
    ReflectJavaAnnotation findAnnotation(FqName fqName);

    List<ReflectJavaAnnotation> getAnnotations();

    AnnotatedElement getElement();
}
