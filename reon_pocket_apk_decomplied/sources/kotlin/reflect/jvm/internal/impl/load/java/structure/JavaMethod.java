package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;

/* compiled from: javaElements.kt */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {
    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    JavaType getReturnType();

    List<JavaValueParameter> getValueParameters();
}
