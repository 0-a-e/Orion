package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
public class JavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JavaAnnotationDescriptor.class), TransferTable.COLUMN_TYPE, "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    private final JavaAnnotationArgument firstArgument;
    private final FqName fqName;
    private final boolean isIdeExternalAnnotation;
    private final SourceElement source;
    private final NotNullLazyValue type$delegate;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0041, code lost:
        r2 = r3.getArguments();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r2, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation r3, kotlin.reflect.jvm.internal.impl.name.FqName r4) {
        /*
            r1 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r1.<init>()
            r1.fqName = r4
            if (r3 == 0) goto L_0x0025
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r4 = r2.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r4 = r4.getSourceElementFactory()
            r0 = r3
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r0 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement) r0
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r4 = r4.source(r0)
            if (r4 == 0) goto L_0x0025
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = (kotlin.reflect.jvm.internal.impl.descriptors.SourceElement) r4
            goto L_0x002c
        L_0x0025:
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            java.lang.String r0 = "NO_SOURCE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
        L_0x002c:
            r1.source = r4
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r4 = r2.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2 r0 = new kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2
            r0.<init>(r2, r1)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r2 = r4.createLazyValue(r0)
            r1.type$delegate = r2
            if (r3 == 0) goto L_0x0050
            java.util.Collection r2 = r3.getArguments()
            if (r2 == 0) goto L_0x0050
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument) r2
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            r1.firstArgument = r2
            r2 = 0
            if (r3 == 0) goto L_0x005e
            boolean r3 = r3.isIdeExternalAnnotation()
            r4 = 1
            if (r3 != r4) goto L_0x005e
            r2 = r4
        L_0x005e:
            r1.isIdeExternalAnnotation = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor.<init>(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation, kotlin.reflect.jvm.internal.impl.name.FqName):void");
    }

    public FqName getFqName() {
        return this.fqName;
    }

    public SourceElement getSource() {
        return this.source;
    }

    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    /* access modifiers changed from: protected */
    public final JavaAnnotationArgument getFirstArgument() {
        return this.firstArgument;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return MapsKt.emptyMap();
    }

    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }
}
