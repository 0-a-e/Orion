package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: javaElements.kt */
public interface JavaAnnotation extends JavaElement {
    Collection<JavaAnnotationArgument> getArguments();

    ClassId getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    JavaClass resolve();
}
