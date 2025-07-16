package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J&\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000J\u0006\u0010\u001b\u001a\u00020\u0017J&\u0010\u001b\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000J\u0011\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J&\u0010!\u001a\u00020\u00042\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000J\u0013\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0001JD\u0010%\u001a\u00020&26\u0010'\u001a2\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020&0\u0019H\bø\u0001\u0000J/\u0010*\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020&0+H\bø\u0001\u0000J/\u0010-\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020&0+H\bø\u0001\u0000J/\u0010.\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020&0+H\bø\u0001\u0000J\u0011\u0010/\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0016\u00100\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0004J\"\u00102\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000403H\bø\u0001\u0000J\b\u00104\u001a\u00020\u0004H\u0016J\u0006\u00105\u001a\u00020\u0017J\u0006\u00106\u001a\u00020\u0017J:\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010>\u001a\u00020:H\u0007Jx\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010>\u001a\u00020:28\b\u0004\u0010?\u001a2\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0004\u0012\u00020:0\u0019H\bø\u0001\u0000J\u0006\u0010@\u001a\u00020\u0017J\b\u0010A\u001a\u000208H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0018\u0010\u0006\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0018\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002R\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0018\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u0001\u0001B\u0002\u0007\n\u0005\b20\u0001¨\u0006C"}, d2 = {"Landroidx/collection/FloatIntMap;", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableFloatIntMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatIntMap.kt */
public abstract class FloatIntMap {
    public int _capacity;
    public int _size;
    public float[] keys;
    public long[] metadata;
    public int[] values;

    public /* synthetic */ FloatIntMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 31, (Object) null);
    }

    public final String joinToString(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 30, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, 28, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, 24, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, (CharSequence) null, 16, (Object) null);
    }

    private FloatIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = FloatSetKt.getEmptyFloatArray();
        this.values = IntSetKt.getEmptyIntArray();
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean none() {
        return this._size == 0;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final int get(float f) {
        int findKeyIndex = findKeyIndex(f);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("Cannot find value for key " + f);
    }

    public final int getOrDefault(float f, int i) {
        int findKeyIndex = findKeyIndex(f);
        return findKeyIndex >= 0 ? this.values[findKeyIndex] : i;
    }

    public final int getOrElse(float f, Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        int findKeyIndex = findKeyIndex(f);
        if (findKeyIndex < 0) {
            return function0.invoke().intValue();
        }
        return this.values[findKeyIndex];
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            function1.invoke(Integer.valueOf((i << 3) + i3));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void forEach(Function2<? super Float, ? super Integer, Unit> function2) {
        Function2<? super Float, ? super Integer, Unit> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "block");
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            function22.invoke(Float.valueOf(fArr[i4]), Integer.valueOf(iArr[i4]));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void forEachKey(Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        float[] fArr = this.keys;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            function1.invoke(Float.valueOf(fArr[(i << 3) + i3]));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void forEachValue(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            function1.invoke(Integer.valueOf(iArr[(i << 3) + i3]));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final int count() {
        return getSize();
    }

    public final boolean contains(float f) {
        return findKeyIndex(f) >= 0;
    }

    public final boolean containsKey(float f) {
        return findKeyIndex(f) >= 0;
    }

    public static /* synthetic */ String joinToString$default(FloatIntMap floatIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
            }
            if ((i2 & 2) != 0) {
                charSequence2 = "";
            }
            CharSequence charSequence5 = charSequence2;
            if ((i2 & 4) != 0) {
                charSequence3 = "";
            }
            CharSequence charSequence6 = charSequence3;
            if ((i2 & 8) != 0) {
                i = -1;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            return floatIntMap.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        float[] fArr;
        float[] fArr2;
        int i2;
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        Intrinsics.checkNotNullParameter(charSequence5, "separator");
        Intrinsics.checkNotNullParameter(charSequence6, "prefix");
        Intrinsics.checkNotNullParameter(charSequence7, "postfix");
        Intrinsics.checkNotNullParameter(charSequence8, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        float[] fArr3 = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            loop0:
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i3 << 3) + i7;
                            float f = fArr3[i8];
                            int i9 = iArr[i8];
                            fArr2 = fArr3;
                            if (i4 == i) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append(f);
                            sb.append('=');
                            sb.append(i9);
                            i4++;
                            i2 = 8;
                        } else {
                            fArr2 = fArr3;
                            int i10 = i;
                            i2 = i5;
                        }
                        j >>= i2;
                        i7++;
                        i5 = i2;
                        fArr3 = fArr2;
                    }
                    fArr = fArr3;
                    int i11 = i;
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                    int i12 = i;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                fArr3 = fArr;
            }
        }
        sb.append(charSequence7);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String joinToString$default(FloatIntMap floatIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 function2, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        CharSequence charSequence7;
        long[] jArr;
        long[] jArr2;
        int i3;
        FloatIntMap floatIntMap2 = floatIntMap;
        Function2 function22 = function2;
        if (obj == null) {
            String str = (i2 & 1) != 0 ? ", " : charSequence;
            if ((i2 & 2) != 0) {
                charSequence5 = "";
            } else {
                charSequence5 = charSequence2;
            }
            if ((i2 & 4) == 0) {
                charSequence6 = charSequence3;
            }
            int i4 = (i2 & 8) != 0 ? -1 : i;
            if ((i2 & 16) == 0) {
                charSequence7 = charSequence4;
            }
            Intrinsics.checkNotNullParameter(str, "separator");
            Intrinsics.checkNotNullParameter(charSequence5, "prefix");
            Intrinsics.checkNotNullParameter(charSequence6, "postfix");
            Intrinsics.checkNotNullParameter(charSequence7, "truncated");
            Intrinsics.checkNotNullParameter(function22, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence5);
            float[] fArr = floatIntMap2.keys;
            int[] iArr = floatIntMap2.values;
            long[] jArr3 = floatIntMap2.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i5 = 0;
                int i6 = 0;
                loop0:
                while (true) {
                    long j = jArr3[i5];
                    int i7 = i5;
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i8 = 8;
                        int i9 = 8 - ((~(i7 - length)) >>> 31);
                        int i10 = 0;
                        while (i10 < i9) {
                            if ((j & 255) < 128) {
                                int i11 = (i7 << 3) + i10;
                                float f = fArr[i11];
                                int i12 = iArr[i11];
                                if (i6 == i4) {
                                    sb.append(charSequence7);
                                    break loop0;
                                }
                                if (i6 != 0) {
                                    sb.append(str);
                                }
                                Float valueOf = Float.valueOf(f);
                                jArr2 = jArr3;
                                sb.append((CharSequence) function22.invoke(valueOf, Integer.valueOf(i12)));
                                i6++;
                                i3 = 8;
                            } else {
                                jArr2 = jArr3;
                                i3 = i8;
                            }
                            j >>= i3;
                            i10++;
                            i8 = i3;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i9 != i8) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    int i13 = i7;
                    if (i13 == length) {
                        break;
                    }
                    i5 = i13 + 1;
                    jArr3 = jArr;
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
            sb.append(charSequence6);
            String sb22 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb22, "StringBuilder().apply(builderAction).toString()");
            return sb22;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2<? super Float, ? super Integer, ? extends CharSequence> function2) {
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        Function2<? super Float, ? super Integer, ? extends CharSequence> function22 = function2;
        Intrinsics.checkNotNullParameter(charSequence5, "separator");
        Intrinsics.checkNotNullParameter(charSequence6, "prefix");
        Intrinsics.checkNotNullParameter(charSequence7, "postfix");
        Intrinsics.checkNotNullParameter(charSequence8, "truncated");
        Intrinsics.checkNotNullParameter(function22, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i4 << 3) + i6;
                            float f = fArr[i7];
                            int i8 = iArr[i7];
                            if (i3 == i) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append((CharSequence) function22.invoke(Float.valueOf(f), Integer.valueOf(i8)));
                            i3++;
                        }
                        j >>= 8;
                        i6++;
                        charSequence5 = charSequence;
                    }
                    if (i5 != 8) {
                        break;
                    }
                }
                int i9 = i4;
                if (i9 == length) {
                    break;
                }
                i2 = i9 + 1;
                charSequence5 = charSequence;
            }
        }
        sb.append(charSequence7);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r1 != r0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof androidx.collection.FloatIntMap
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            androidx.collection.FloatIntMap r1 = (androidx.collection.FloatIntMap) r1
            int r3 = r1.getSize()
            int r5 = r18.getSize()
            if (r3 == r5) goto L_0x001b
            return r4
        L_0x001b:
            float[] r3 = r0.keys
            int[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + -2
            if (r7 < 0) goto L_0x0065
            r8 = r4
        L_0x0027:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x0060
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L_0x0041:
            if (r13 >= r11) goto L_0x005e
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x005a
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r3[r14]
            r14 = r5[r14]
            int r15 = r1.get(r15)
            if (r14 == r15) goto L_0x005a
            return r4
        L_0x005a:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L_0x0041
        L_0x005e:
            if (r11 != r12) goto L_0x0065
        L_0x0060:
            if (r8 == r7) goto L_0x0065
            int r8 = r8 + 1
            goto L_0x0027
        L_0x0065:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatIntMap.equals(java.lang.Object):boolean");
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            float f = fArr[i5];
                            int i6 = iArr[i5];
                            sb.append(f);
                            sb.append("=");
                            sb.append(i6);
                            i2++;
                            if (i2 < this._size) {
                                sb.append(", ");
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "s.append('}').toString()");
        return sb2;
    }

    public final boolean all(Function2<? super Float, ? super Integer, Boolean> function2) {
        Function2<? super Float, ? super Integer, Boolean> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "predicate");
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        if (!function22.invoke(Float.valueOf(fArr[i4]), Integer.valueOf(iArr[i4])).booleanValue()) {
                            return false;
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean any(Function2<? super Float, ? super Integer, Boolean> function2) {
        Function2<? super Float, ? super Integer, Boolean> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "predicate");
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (function22.invoke(Float.valueOf(fArr[i4]), Integer.valueOf(iArr[i4])).booleanValue()) {
                                return true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count(Function2<? super Float, ? super Integer, Boolean> function2) {
        Function2<? super Float, ? super Integer, Boolean> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "predicate");
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            if (function22.invoke(Float.valueOf(fArr[i6]), Integer.valueOf(iArr[i6])).booleanValue()) {
                                i3++;
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                }
                if (i2 == length) {
                    i = i3;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public final boolean containsValue(int i) {
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128 && i == iArr[(i2 << 3) + i4]) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public int hashCode() {
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            i3 += iArr[i6] ^ Float.floatToIntBits(fArr[i6]);
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                }
                if (i2 == length) {
                    i = i3;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public final int findKeyIndex(float f) {
        int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        int i = floatToIntBits ^ (floatToIntBits << 16);
        int i2 = i & WorkQueueKt.MASK;
        int i3 = this._capacity;
        int i4 = (i >>> 7) & i3;
        int i5 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j = ((jArr[i6 + 1] << (64 - i7)) & ((-((long) i7)) >> 63)) | (jArr[i6] >>> i7);
            long j2 = (((long) i2) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j3 != 0; j3 &= j3 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i4) & i3;
                if (this.keys[numberOfTrailingZeros] == f) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & -9187201950435737472L) != 0) {
                return -1;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Function2<? super Float, ? super Integer, ? extends CharSequence> function2) {
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        Function2<? super Float, ? super Integer, ? extends CharSequence> function22 = function2;
        Intrinsics.checkNotNullParameter(charSequence4, "separator");
        Intrinsics.checkNotNullParameter(charSequence5, "prefix");
        Intrinsics.checkNotNullParameter(charSequence6, "postfix");
        Intrinsics.checkNotNullParameter(function22, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i4 << 3) + i6;
                            float f = fArr[i7];
                            int i8 = iArr[i7];
                            if (i3 == i) {
                                sb.append(r5);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) function22.invoke(Float.valueOf(f), Integer.valueOf(i8)));
                            i3++;
                        }
                        j >>= 8;
                        i6++;
                        charSequence4 = charSequence;
                    }
                    if (i5 != 8) {
                        break;
                    }
                }
                int i9 = i4;
                if (i9 == length) {
                    break;
                }
                i2 = i9 + 1;
                charSequence4 = charSequence;
            }
        }
        sb.append(charSequence6);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Function2<? super Float, ? super Integer, ? extends CharSequence> function2) {
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        Function2<? super Float, ? super Integer, ? extends CharSequence> function22 = function2;
        Intrinsics.checkNotNullParameter(charSequence4, "separator");
        Intrinsics.checkNotNullParameter(charSequence5, "prefix");
        Intrinsics.checkNotNullParameter(charSequence6, "postfix");
        Intrinsics.checkNotNullParameter(function22, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0:
            while (true) {
                long j = jArr[i];
                int i3 = i;
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            int i6 = (i3 << 3) + i5;
                            float f = fArr[i6];
                            int i7 = iArr[i6];
                            if (i2 == -1) {
                                sb.append(r5);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) function22.invoke(Float.valueOf(f), Integer.valueOf(i7)));
                            i2++;
                        }
                        j >>= 8;
                        i5++;
                        charSequence4 = charSequence;
                    }
                    if (i4 != 8) {
                        break;
                    }
                }
                int i8 = i3;
                if (i8 == length) {
                    break;
                }
                i = i8 + 1;
                charSequence4 = charSequence;
            }
        }
        sb.append(charSequence6);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, Function2<? super Float, ? super Integer, ? extends CharSequence> function2) {
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        Function2<? super Float, ? super Integer, ? extends CharSequence> function22 = function2;
        Intrinsics.checkNotNullParameter(charSequence3, "separator");
        Intrinsics.checkNotNullParameter(charSequence4, "prefix");
        Intrinsics.checkNotNullParameter(function22, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence4);
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0:
            while (true) {
                long j = jArr[i];
                int i3 = i;
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            int i6 = (i3 << 3) + i5;
                            float f = fArr[i6];
                            int i7 = iArr[i6];
                            if (i2 == -1) {
                                sb.append(r5);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence3);
                            }
                            sb.append((CharSequence) function22.invoke(Float.valueOf(f), Integer.valueOf(i7)));
                            i2++;
                        }
                        j >>= 8;
                        i5++;
                        charSequence3 = charSequence;
                    }
                    if (i4 != 8) {
                        break;
                    }
                }
                int i8 = i3;
                if (i8 == length) {
                    break;
                }
                i = i8 + 1;
                charSequence3 = charSequence;
            }
        }
        sb.append(r4);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, Function2<? super Float, ? super Integer, ? extends CharSequence> function2) {
        int i;
        CharSequence charSequence2 = charSequence;
        Function2<? super Float, ? super Integer, ? extends CharSequence> function22 = function2;
        Intrinsics.checkNotNullParameter(charSequence2, "separator");
        Intrinsics.checkNotNullParameter(function22, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i4 << 3) + i7;
                            float f = fArr[i8];
                            int i9 = iArr[i8];
                            if (i3 == -1) {
                                sb.append(r5);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence2);
                            }
                            sb.append((CharSequence) function22.invoke(Float.valueOf(f), Integer.valueOf(i9)));
                            i3++;
                            i = 8;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                }
                int i10 = i4;
                if (i10 == length) {
                    break;
                }
                i2 = i10 + 1;
            }
        }
        sb.append(r3);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(Function2<? super Float, ? super Integer, ? extends CharSequence> function2) {
        int i;
        Function2<? super Float, ? super Integer, ? extends CharSequence> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        float[] fArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i4 << 3) + i7;
                            float f = fArr[i8];
                            int i9 = iArr[i8];
                            if (i3 == -1) {
                                sb.append(r5);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(r2);
                            }
                            sb.append((CharSequence) function22.invoke(Float.valueOf(f), Integer.valueOf(i9)));
                            i3++;
                            i = 8;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                }
                int i10 = i4;
                if (i10 == length) {
                    break;
                }
                i2 = i10 + 1;
            }
        }
        sb.append(r3);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
