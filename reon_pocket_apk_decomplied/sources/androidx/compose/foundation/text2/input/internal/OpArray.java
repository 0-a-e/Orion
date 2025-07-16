package androidx.compose.foundation.text2.input.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jo\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00102K\u0010\u0018\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00150\u0019H\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\"\u0010\nJ-\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0001\u0006\u0001\u00020\u0007\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/OpArray;", "", "size", "", "constructor-impl", "(I)[I", "values", "", "([I)[I", "getSize-impl", "([I)I", "copyOf", "newSize", "copyOf-S4-kM8k", "([II)[I", "equals", "", "other", "equals-impl", "([ILjava/lang/Object;)Z", "forEach", "", "max", "reversed", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "offset", "srcLen", "destLen", "forEach-impl", "([IIZLkotlin/jvm/functions/Function3;)V", "hashCode", "hashCode-impl", "set", "index", "set-impl", "([IIIII)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: OffsetMappingCalculator.kt */
final class OpArray {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int ElementSize = 3;
    private final int[] values;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ OpArray m1376boximpl(int[] iArr) {
        return new OpArray(iArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int[] m1378constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1380equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof OpArray) && Intrinsics.areEqual((Object) iArr, (Object) ((OpArray) obj).m1388unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1381equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual((Object) iArr, (Object) iArr2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1385hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1387toStringimpl(int[] iArr) {
        return "OpArray(values=" + Arrays.toString(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return m1380equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m1385hashCodeimpl(this.values);
    }

    public String toString() {
        return m1387toStringimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int[] m1388unboximpl() {
        return this.values;
    }

    private /* synthetic */ OpArray(int[] iArr) {
        this.values = iArr;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m1377constructorimpl(int i) {
        return m1378constructorimpl(new int[(i * 3)]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static final int m1384getSizeimpl(int[] iArr) {
        return iArr.length / 3;
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m1386setimpl(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i * 3;
        iArr[i5] = i2;
        iArr[i5 + 1] = i3;
        iArr[i5 + 2] = i4;
    }

    /* renamed from: copyOf-S4-kM8k  reason: not valid java name */
    public static final int[] m1379copyOfS4kM8k(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, i * 3);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return m1378constructorimpl(copyOf);
    }

    /* renamed from: forEach-impl  reason: not valid java name */
    public static final void m1382forEachimpl(int[] iArr, int i, boolean z, Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        if (i >= 0) {
            if (z) {
                while (true) {
                    i--;
                    if (-1 < i) {
                        int i2 = i * 3;
                        function3.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(iArr[i2 + 1]), Integer.valueOf(iArr[i2 + 2]));
                    } else {
                        return;
                    }
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = i3 * 3;
                    function3.invoke(Integer.valueOf(iArr[i4]), Integer.valueOf(iArr[i4 + 1]), Integer.valueOf(iArr[i4 + 2]));
                }
            }
        }
    }

    /* renamed from: forEach-impl$default  reason: not valid java name */
    public static /* synthetic */ void m1383forEachimpl$default(int[] iArr, int i, boolean z, Function3 function3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (i >= 0) {
            if (z) {
                while (true) {
                    i--;
                    if (-1 < i) {
                        int i3 = i * 3;
                        function3.invoke(Integer.valueOf(iArr[i3]), Integer.valueOf(iArr[i3 + 1]), Integer.valueOf(iArr[i3 + 2]));
                    } else {
                        return;
                    }
                }
            } else {
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = i4 * 3;
                    function3.invoke(Integer.valueOf(iArr[i5]), Integer.valueOf(iArr[i5 + 1]), Integer.valueOf(iArr[i5 + 2]));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/OpArray$Companion;", "", "()V", "ElementSize", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OffsetMappingCalculator.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
