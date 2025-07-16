package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;

/* compiled from: FunctionTypeKindExtractor.kt */
public final class FunctionTypeKindExtractor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final FunctionTypeKindExtractor Default = new FunctionTypeKindExtractor(CollectionsKt.listOf(FunctionTypeKind.Function.INSTANCE, FunctionTypeKind.SuspendFunction.INSTANCE, FunctionTypeKind.KFunction.INSTANCE, FunctionTypeKind.KSuspendFunction.INSTANCE));
    private final List<FunctionTypeKind> kinds;
    private final Map<FqName, List<FunctionTypeKind>> knownKindsByPackageFqName;

    /* compiled from: FunctionTypeKindExtractor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FunctionTypeKindExtractor getDefault() {
            return FunctionTypeKindExtractor.Default;
        }
    }

    public FunctionTypeKindExtractor(List<? extends FunctionTypeKind> list) {
        Intrinsics.checkNotNullParameter(list, "kinds");
        this.kinds = list;
        Map<FqName, List<FunctionTypeKind>> linkedHashMap = new LinkedHashMap<>();
        for (Object next : list) {
            FqName packageFqName = ((FunctionTypeKind) next).getPackageFqName();
            List<FunctionTypeKind> list2 = linkedHashMap.get(packageFqName);
            if (list2 == null) {
                list2 = new ArrayList<>();
                linkedHashMap.put(packageFqName, list2);
            }
            list2.add(next);
        }
        this.knownKindsByPackageFqName = linkedHashMap;
    }

    public final FunctionTypeKind getFunctionalClassKind(FqName fqName, String str) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        Intrinsics.checkNotNullParameter(str, "className");
        KindWithArity functionalClassKindWithArity = getFunctionalClassKindWithArity(fqName, str);
        if (functionalClassKindWithArity != null) {
            return functionalClassKindWithArity.getKind();
        }
        return null;
    }

    public final KindWithArity getFunctionalClassKindWithArity(FqName fqName, String str) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        Intrinsics.checkNotNullParameter(str, "className");
        List<FunctionTypeKind> list = this.knownKindsByPackageFqName.get(fqName);
        if (list == null) {
            return null;
        }
        for (FunctionTypeKind functionTypeKind : list) {
            if (StringsKt.startsWith$default(str, functionTypeKind.getClassNamePrefix(), false, 2, (Object) null)) {
                String substring = str.substring(functionTypeKind.getClassNamePrefix().length());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Integer num = toInt(substring);
                if (num != null) {
                    return new KindWithArity(functionTypeKind, num.intValue());
                }
            }
        }
        return null;
    }

    /* compiled from: FunctionTypeKindExtractor.kt */
    public static final class KindWithArity {
        private final int arity;
        private final FunctionTypeKind kind;

        public final FunctionTypeKind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof KindWithArity)) {
                return false;
            }
            KindWithArity kindWithArity = (KindWithArity) obj;
            return Intrinsics.areEqual((Object) this.kind, (Object) kindWithArity.kind) && this.arity == kindWithArity.arity;
        }

        public int hashCode() {
            return (this.kind.hashCode() * 31) + this.arity;
        }

        public String toString() {
            return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
        }

        public KindWithArity(FunctionTypeKind functionTypeKind, int i) {
            Intrinsics.checkNotNullParameter(functionTypeKind, "kind");
            this.kind = functionTypeKind;
            this.arity = i;
        }

        public final FunctionTypeKind getKind() {
            return this.kind;
        }
    }

    private final Integer toInt(String str) {
        if (str.length() == 0) {
            return null;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int charAt = str.charAt(i2) - '0';
            if (charAt < 0 || charAt >= 10) {
                return null;
            }
            i = (i * 10) + charAt;
        }
        return Integer.valueOf(i);
    }
}
