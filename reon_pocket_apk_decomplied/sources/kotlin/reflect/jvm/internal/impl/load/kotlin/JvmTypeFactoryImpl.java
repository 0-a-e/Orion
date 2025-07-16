package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* compiled from: methodSignatureMapping.kt */
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE = new JvmTypeFactoryImpl();

    /* compiled from: methodSignatureMapping.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType[] r0 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.CHAR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BYTE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.SHORT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.INT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.FLOAT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.LONG     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl.WhenMappings.<clinit>():void");
        }
    }

    private JvmTypeFactoryImpl() {
    }

    public JvmType boxType(JvmType jvmType) {
        Intrinsics.checkNotNullParameter(jvmType, "possiblyPrimitiveType");
        if (!(jvmType instanceof JvmType.Primitive)) {
            return jvmType;
        }
        JvmType.Primitive primitive = (JvmType.Primitive) jvmType;
        if (primitive.getJvmPrimitiveType() == null) {
            return jvmType;
        }
        String internalName = JvmClassName.byFqNameWithoutInnerClasses(primitive.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "getInternalName(...)");
        return createObjectType(internalName);
    }

    public JvmType createFromString(String str) {
        JvmPrimitiveType jvmPrimitiveType;
        Intrinsics.checkNotNullParameter(str, "representation");
        CharSequence charSequence = str;
        charSequence.length();
        char charAt = str.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new JvmType.Primitive(jvmPrimitiveType);
        }
        if (charAt == 'V') {
            return new JvmType.Primitive((JvmPrimitiveType) null);
        }
        if (charAt == '[') {
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return new JvmType.Array(createFromString(substring));
        }
        if (charAt == 'L') {
            boolean endsWith$default = StringsKt.endsWith$default(charSequence, ';', false, 2, (Object) null);
        }
        String substring2 = str.substring(1, str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return new JvmType.Object(substring2);
    }

    public JvmType createPrimitiveType(PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        switch (WhenMappings.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1:
                return JvmType.Companion.getBOOLEAN$descriptors_jvm();
            case 2:
                return JvmType.Companion.getCHAR$descriptors_jvm();
            case 3:
                return JvmType.Companion.getBYTE$descriptors_jvm();
            case 4:
                return JvmType.Companion.getSHORT$descriptors_jvm();
            case 5:
                return JvmType.Companion.getINT$descriptors_jvm();
            case 6:
                return JvmType.Companion.getFLOAT$descriptors_jvm();
            case 7:
                return JvmType.Companion.getLONG$descriptors_jvm();
            case 8:
                return JvmType.Companion.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public JvmType.Object createObjectType(String str) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        return new JvmType.Object(str);
    }

    public String toString(JvmType jvmType) {
        String desc;
        Intrinsics.checkNotNullParameter(jvmType, TransferTable.COLUMN_TYPE);
        if (jvmType instanceof JvmType.Array) {
            return "[" + toString(((JvmType.Array) jvmType).getElementType());
        } else if (jvmType instanceof JvmType.Primitive) {
            JvmPrimitiveType jvmPrimitiveType = ((JvmType.Primitive) jvmType).getJvmPrimitiveType();
            if (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) {
                return "V";
            }
            return desc;
        } else if (jvmType instanceof JvmType.Object) {
            return "L" + ((JvmType.Object) jvmType).getInternalName() + ';';
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public JvmType getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }
}
