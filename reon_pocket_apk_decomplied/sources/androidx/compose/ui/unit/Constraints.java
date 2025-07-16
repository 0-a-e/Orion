package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b+\u0010\tJ\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0012\u0001\u0002\u0001\u00020\u0003\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "focusIndex", "", "getFocusIndex-impl", "(J)I", "hasBoundedHeight", "", "getHasBoundedHeight-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "()V", "getHasFixedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "isZero", "isZero$annotations", "isZero-impl", "maxHeight", "getMaxHeight-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "minWidth", "getMinWidth-impl", "getValue$annotations", "copy", "copy-Zbe2FdA", "(JIIII)J", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: Constraints.kt */
public final class Constraints {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FocusMask = 3;
    private static final int[] HeightMask = {32767, MaxNonFocusMask, 65535, MaxFocusMask};
    public static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxFocusBits = 18;
    private static final long MaxFocusHeight = 3;
    private static final int MaxFocusMask = 262143;
    private static final long MaxFocusWidth = 1;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final long MinFocusHeight = 2;
    private static final int MinFocusMask = 65535;
    private static final long MinFocusWidth = 0;
    /* access modifiers changed from: private */
    public static final int[] MinHeightOffsets = {18, 20, 17, 15};
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;
    private static final int[] WidthMask = {65535, MaxFocusMask, 32767, MaxNonFocusMask};
    private final long value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Constraints m6514boximpl(long j) {
        return new Constraints(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m6515constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6518equalsimpl(long j, Object obj) {
        return (obj instanceof Constraints) && j == ((Constraints) obj).m6532unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6519equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFocusIndex-impl  reason: not valid java name */
    private static final int m6520getFocusIndeximpl(long j) {
        return (int) (j & 3);
    }

    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6529hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    public static /* synthetic */ void isZero$annotations() {
    }

    public boolean equals(Object obj) {
        return m6518equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6529hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m6532unboximpl() {
        return this.value;
    }

    private /* synthetic */ Constraints(long j) {
        this.value = j;
    }

    /* renamed from: getMinWidth-impl  reason: not valid java name */
    public static final int m6528getMinWidthimpl(long j) {
        return ((int) (j >> MinFocusHeight)) & WidthMask[m6520getFocusIndeximpl(j)];
    }

    /* renamed from: getMaxWidth-impl  reason: not valid java name */
    public static final int m6526getMaxWidthimpl(long j) {
        int i = ((int) (j >> 33)) & WidthMask[m6520getFocusIndeximpl(j)];
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return i - 1;
    }

    /* renamed from: getMinHeight-impl  reason: not valid java name */
    public static final int m6527getMinHeightimpl(long j) {
        int r0 = m6520getFocusIndeximpl(j);
        return ((int) (j >> MinHeightOffsets[r0])) & HeightMask[r0];
    }

    /* renamed from: getMaxHeight-impl  reason: not valid java name */
    public static final int m6525getMaxHeightimpl(long j) {
        int r0 = m6520getFocusIndeximpl(j);
        int i = ((int) (j >> (MinHeightOffsets[r0] + 31))) & HeightMask[r0];
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return i - 1;
    }

    /* renamed from: getHasBoundedWidth-impl  reason: not valid java name */
    public static final boolean m6522getHasBoundedWidthimpl(long j) {
        return (((int) (j >> 33)) & WidthMask[m6520getFocusIndeximpl(j)]) != 0;
    }

    /* renamed from: getHasBoundedHeight-impl  reason: not valid java name */
    public static final boolean m6521getHasBoundedHeightimpl(long j) {
        int r0 = m6520getFocusIndeximpl(j);
        return (((int) (j >> (MinHeightOffsets[r0] + 31))) & HeightMask[r0]) != 0;
    }

    /* renamed from: getHasFixedWidth-impl  reason: not valid java name */
    public static final boolean m6524getHasFixedWidthimpl(long j) {
        return m6526getMaxWidthimpl(j) == m6528getMinWidthimpl(j);
    }

    /* renamed from: getHasFixedHeight-impl  reason: not valid java name */
    public static final boolean m6523getHasFixedHeightimpl(long j) {
        return m6525getMaxHeightimpl(j) == m6527getMinHeightimpl(j);
    }

    /* renamed from: isZero-impl  reason: not valid java name */
    public static final boolean m6530isZeroimpl(long j) {
        return m6526getMaxWidthimpl(j) == 0 || m6525getMaxHeightimpl(j) == 0;
    }

    /* renamed from: copy-Zbe2FdA$default  reason: not valid java name */
    public static /* synthetic */ long m6517copyZbe2FdA$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = m6528getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = m6526getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = m6527getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = m6525getMaxHeightimpl(j);
        }
        return m6516copyZbe2FdA(j, i6, i7, i8, i4);
    }

    /* renamed from: copy-Zbe2FdA  reason: not valid java name */
    public static final long m6516copyZbe2FdA(long j, int i, int i2, int i3, int i4) {
        if (i3 < 0 || i < 0) {
            throw new IllegalArgumentException(("minHeight(" + i3 + ") and minWidth(" + i + ") must be >= 0").toString());
        } else if (i2 < i && i2 != Integer.MAX_VALUE) {
            throw new IllegalArgumentException(("maxWidth(" + i2 + ") must be >= minWidth(" + i + ')').toString());
        } else if (i4 >= i3 || i4 == Integer.MAX_VALUE) {
            return Companion.m6533createConstraintsZbe2FdA$ui_unit_release(i, i2, i3, i4);
        } else {
            throw new IllegalArgumentException(("maxHeight(" + i4 + ") must be >= minHeight(" + i3 + ')').toString());
        }
    }

    public String toString() {
        return m6531toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6531toStringimpl(long j) {
        int r0 = m6526getMaxWidthimpl(j);
        String str = "Infinity";
        String valueOf = r0 == Integer.MAX_VALUE ? str : String.valueOf(r0);
        int r3 = m6525getMaxHeightimpl(j);
        if (r3 != Integer.MAX_VALUE) {
            str = String.valueOf(r3);
        }
        return "Constraints(minWidth = " + m6528getMinWidthimpl(j) + ", maxWidth = " + valueOf + ", minHeight = " + m6527getMinHeightimpl(j) + ", maxHeight = " + str + ')';
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J5\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J%\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "()V", "FocusMask", "", "HeightMask", "", "Infinity", "", "MaxFocusBits", "MaxFocusHeight", "MaxFocusMask", "MaxFocusWidth", "MaxNonFocusBits", "MaxNonFocusMask", "MinFocusBits", "MinFocusHeight", "MinFocusMask", "MinFocusWidth", "MinHeightOffsets", "MinNonFocusBits", "MinNonFocusMask", "WidthMask", "bitsNeedForSize", "size", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "createConstraints-Zbe2FdA$ui_unit_release", "(IIII)J", "fixed", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedHeight", "fixedHeight-OenEA2s", "(I)J", "fixedWidth", "fixedWidth-OenEA2s", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Constraints.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: fixed-JhjzzOo  reason: not valid java name */
        public final long m6534fixedJhjzzOo(int i, int i2) {
            if (i >= 0 && i2 >= 0) {
                return m6533createConstraintsZbe2FdA$ui_unit_release(i, i, i2, i2);
            }
            throw new IllegalArgumentException(("width(" + i + ") and height(" + i2 + ") must be >= 0").toString());
        }

        /* renamed from: fixedWidth-OenEA2s  reason: not valid java name */
        public final long m6536fixedWidthOenEA2s(int i) {
            if (i >= 0) {
                return m6533createConstraintsZbe2FdA$ui_unit_release(i, i, 0, Integer.MAX_VALUE);
            }
            throw new IllegalArgumentException(("width(" + i + ") must be >= 0").toString());
        }

        /* renamed from: fixedHeight-OenEA2s  reason: not valid java name */
        public final long m6535fixedHeightOenEA2s(int i) {
            if (i >= 0) {
                return m6533createConstraintsZbe2FdA$ui_unit_release(0, Integer.MAX_VALUE, i, i);
            }
            throw new IllegalArgumentException(("height(" + i + ") must be >= 0").toString());
        }

        /* renamed from: createConstraints-Zbe2FdA$ui_unit_release  reason: not valid java name */
        public final long m6533createConstraintsZbe2FdA$ui_unit_release(int i, int i2, int i3, int i4) {
            long j;
            int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
            int bitsNeedForSize = bitsNeedForSize(i5);
            int i6 = i2 == Integer.MAX_VALUE ? i : i2;
            int bitsNeedForSize2 = bitsNeedForSize(i6);
            if (bitsNeedForSize + bitsNeedForSize2 <= 31) {
                if (bitsNeedForSize2 == 13) {
                    j = 3;
                } else if (bitsNeedForSize2 == 18) {
                    j = 1;
                } else if (bitsNeedForSize2 == 15) {
                    j = Constraints.MinFocusHeight;
                } else if (bitsNeedForSize2 == 16) {
                    j = 0;
                } else {
                    throw new IllegalStateException("Should only have the provided constants.");
                }
                int i7 = 0;
                int i8 = i2 == Integer.MAX_VALUE ? 0 : i2 + 1;
                if (i4 != Integer.MAX_VALUE) {
                    i7 = i4 + 1;
                }
                int i9 = Constraints.MinHeightOffsets[(int) j];
                return Constraints.m6515constructorimpl((((long) i8) << 33) | j | (((long) i) << Constraints.MinFocusHeight) | (((long) i3) << i9) | (((long) i7) << (i9 + 31)));
            }
            throw new IllegalArgumentException("Can't represent a width of " + i6 + " and height of " + i5 + " in Constraints");
        }

        private final int bitsNeedForSize(int i) {
            if (i < Constraints.MaxNonFocusMask) {
                return 13;
            }
            if (i < 32767) {
                return 15;
            }
            if (i < 65535) {
                return 16;
            }
            if (i < Constraints.MaxFocusMask) {
                return 18;
            }
            throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
        }
    }
}
