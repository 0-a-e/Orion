package kotlin.sequences;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/sequences/USequencesKt")
/* compiled from: _USequences.kt */
class USequencesKt___USequencesKt {
    public static final int sumOfUInt(Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i = 0;
        for (UInt r1 : sequence) {
            i = UInt.m7137constructorimpl(i + r1.m7189unboximpl());
        }
        return i;
    }

    public static final long sumOfULong(Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        long j = 0;
        for (ULong r2 : sequence) {
            j = ULong.m7216constructorimpl(j + r2.m7268unboximpl());
        }
        return j;
    }

    public static final int sumOfUByte(Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i = 0;
        for (UByte r1 : sequence) {
            i = UInt.m7137constructorimpl(i + UInt.m7137constructorimpl(r1.m7110unboximpl() & 255));
        }
        return i;
    }

    public static final int sumOfUShort(Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i = 0;
        for (UShort r1 : sequence) {
            i = UInt.m7137constructorimpl(i + UInt.m7137constructorimpl(r1.m7373unboximpl() & UShort.MAX_VALUE));
        }
        return i;
    }
}
