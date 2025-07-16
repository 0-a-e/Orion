package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: JvmBuiltInsCustomizer.kt */
final class JvmBuiltInsCustomizer$deprecationForSomeOfTheListMethods$1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, Annotations> {
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsCustomizer$deprecationForSomeOfTheListMethods$1(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(1);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    public final Annotations invoke(Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        String component2 = pair.component2();
        return Annotations.Companion.create(CollectionsKt.listOf(AnnotationUtilKt.createDeprecatedAnnotation(this.this$0.moduleDescriptor.getBuiltIns(), "'" + pair.component1() + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + component2 + "()' stdlib extension instead", component2 + "()", "HIDDEN", false)));
    }
}
