package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\r\u001a#\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a!\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0002¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b*\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010.\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0002¢\u0006\u0004\b0\u00101\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b2\u00103\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\b4\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0002¢\u0006\u0004\b5\u00106\u001a\u001c\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004¢\u0006\u0004\b:\u0010;\u001a\u001c\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004¢\u0006\u0004\b<\u0010=\u001a\u001c\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004¢\u0006\u0004\b?\u0010@\u001a\u001c\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004¢\u0006\u0004\bA\u0010B\u001a\u0011\u0010C\u001a\u00020\u0005*\u000208H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010C\u001a\u00020\b*\u00020>H\u0007¢\u0006\u0002\u0010E\u001a\u000e\u0010F\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u001a\u000e\u0010F\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u001a\u0011\u0010G\u001a\u00020\u0005*\u000208H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010G\u001a\u00020\b*\u00020>H\u0007¢\u0006\u0002\u0010E\u001a\u000e\u0010H\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u001a\u000e\u0010H\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u001a\u0012\u0010I\u001a\u00020\u0005*\u00020%H\b¢\u0006\u0002\u0010J\u001a\u0019\u0010I\u001a\u00020\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007¢\u0006\u0002\u0010L\u001a\u0012\u0010I\u001a\u00020\b*\u00020/H\b¢\u0006\u0002\u0010M\u001a\u0019\u0010I\u001a\u00020\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007¢\u0006\u0002\u0010N\u001a\u000f\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%H\b\u001a\u0016\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007\u001a\u000f\u0010O\u001a\u0004\u0018\u00010\b*\u00020/H\b\u001a\u0016\u0010O\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007\u001a\f\u0010P\u001a\u000208*\u000208H\u0007\u001a\f\u0010P\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010Q\u001a\u000208*\u0002082\u0006\u0010Q\u001a\u00020RH\u0004\u001a\u0015\u0010Q\u001a\u00020>*\u00020>2\u0006\u0010Q\u001a\u00020SH\u0004\u001a\u001c\u0010T\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004¢\u0006\u0004\bU\u0010V\u001a\u001c\u0010T\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004¢\u0006\u0004\bW\u0010X\u001a\u001c\u0010T\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004¢\u0006\u0004\bY\u0010Z\u001a\u001c\u0010T\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004¢\u0006\u0004\b[\u0010\\¨\u0006]"}, d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "first", "(Lkotlin/ranges/UIntProgression;)I", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/URangesKt")
/* compiled from: _URanges.kt */
class URangesKt___URangesKt {
    public static final int first(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.m8261getFirstpVg5ArA();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    public static final long first(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.m8270getFirstsVKNKU();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    public static final UInt firstOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m7131boximpl(uIntProgression.m8261getFirstpVg5ArA());
    }

    public static final ULong firstOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m7210boximpl(uLongProgression.m8270getFirstsVKNKU());
    }

    public static final int last(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.m8262getLastpVg5ArA();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    public static final long last(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.m8271getLastsVKNKU();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    public static final UInt lastOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m7131boximpl(uIntProgression.m8262getLastpVg5ArA());
    }

    public static final ULong lastOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m7210boximpl(uLongProgression.m8271getLastsVKNKU());
    }

    private static final int random(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return URangesKt.random(uIntRange, (Random) Random.Default);
    }

    private static final long random(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return URangesKt.random(uLongRange, (Random) Random.Default);
    }

    public static final int random(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return URangesKt.randomOrNull(uIntRange, (Random) Random.Default);
    }

    private static final ULong randomOrNull(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return URangesKt.randomOrNull(uLongRange, (Random) Random.Default);
    }

    public static final UInt randomOrNull(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m7131boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    public static final ULong randomOrNull(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m7210boximpl(URandomKt.nextULong(random, uLongRange));
    }

    /* renamed from: contains-biwQdVI  reason: not valid java name */
    private static final boolean m8298containsbiwQdVI(UIntRange uIntRange, UInt uInt) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return uInt != null && uIntRange.m8266containsWZ4Q5Ns(uInt.m7189unboximpl());
    }

    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    private static final boolean m8294containsGYNo2lE(ULongRange uLongRange, ULong uLong) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLong != null && uLongRange.m8275containsVKZWuLQ(uLong.m7268unboximpl());
    }

    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m8293contains68kG9v0(UIntRange uIntRange, byte b) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return uIntRange.m8266containsWZ4Q5Ns(UInt.m7137constructorimpl(b & 255));
    }

    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m8296containsULbyJY(ULongRange uLongRange, byte b) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m8275containsVKZWuLQ(ULong.m7216constructorimpl(((long) b) & 255));
    }

    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m8295containsGab390E(ULongRange uLongRange, int i) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m8275containsVKZWuLQ(ULong.m7216constructorimpl(((long) i) & 4294967295L));
    }

    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m8299containsfz5IDCE(UIntRange uIntRange, long j) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return ULong.m7216constructorimpl(j >>> 32) == 0 && uIntRange.m8266containsWZ4Q5Ns(UInt.m7137constructorimpl((int) j));
    }

    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m8297containsZsK3CEQ(UIntRange uIntRange, short s) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return uIntRange.m8266containsWZ4Q5Ns(UInt.m7137constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m8300containsuhHAxoY(ULongRange uLongRange, short s) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m8275containsVKZWuLQ(ULong.m7216constructorimpl(((long) s) & 65535));
    }

    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m8303downToKr8caGY(byte b, byte b2) {
        return UIntProgression.Companion.m8263fromClosedRangeNkh28Cs(UInt.m7137constructorimpl(b & 255), UInt.m7137constructorimpl(b2 & 255), -1);
    }

    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m8302downToJ1ME1BU(int i, int i2) {
        return UIntProgression.Companion.m8263fromClosedRangeNkh28Cs(i, i2, -1);
    }

    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m8304downToeb3DHEI(long j, long j2) {
        return ULongProgression.Companion.m8272fromClosedRange7ftBX0g(j, j2, -1);
    }

    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m8301downTo5PvTz6A(short s, short s2) {
        return UIntProgression.Companion.m8263fromClosedRangeNkh28Cs(UInt.m7137constructorimpl(s & UShort.MAX_VALUE), UInt.m7137constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        return UIntProgression.Companion.m8263fromClosedRangeNkh28Cs(uIntProgression.m8262getLastpVg5ArA(), uIntProgression.m8261getFirstpVg5ArA(), -uIntProgression.getStep());
    }

    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        return ULongProgression.Companion.m8272fromClosedRange7ftBX0g(uLongProgression.m8271getLastsVKNKU(), uLongProgression.m8270getFirstsVKNKU(), -uLongProgression.getStep());
    }

    public static final UIntProgression step(UIntProgression uIntProgression, int i) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.Companion;
        int r1 = uIntProgression.m8261getFirstpVg5ArA();
        int r2 = uIntProgression.m8262getLastpVg5ArA();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m8263fromClosedRangeNkh28Cs(r1, r2, i);
    }

    public static final ULongProgression step(ULongProgression uLongProgression, long j) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.Companion;
        long r5 = uLongProgression.m8270getFirstsVKNKU();
        long r7 = uLongProgression.m8271getLastsVKNKU();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m8272fromClosedRange7ftBX0g(r5, r7, j);
    }

    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m8307untilKr8caGY(byte b, byte b2) {
        byte b3 = b2 & 255;
        if (Intrinsics.compare((int) b3, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(UInt.m7137constructorimpl(b & 255), UInt.m7137constructorimpl(UInt.m7137constructorimpl(b3) - 1), (DefaultConstructorMarker) null);
    }

    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m8306untilJ1ME1BU(int i, int i2) {
        if (Integer.compare(i2 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(i, UInt.m7137constructorimpl(i2 - 1), (DefaultConstructorMarker) null);
    }

    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m8308untileb3DHEI(long j, long j2) {
        if (UByte$$ExternalSyntheticBackport0.m(j2, 0) <= 0) {
            return ULongRange.Companion.getEMPTY();
        }
        return new ULongRange(j, ULong.m7216constructorimpl(j2 - ULong.m7216constructorimpl(((long) 1) & 4294967295L)), (DefaultConstructorMarker) null);
    }

    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m8305until5PvTz6A(short s, short s2) {
        short s3 = s2 & UShort.MAX_VALUE;
        if (Intrinsics.compare((int) s3, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(UInt.m7137constructorimpl(s & UShort.MAX_VALUE), UInt.m7137constructorimpl(UInt.m7137constructorimpl(s3) - 1), (DefaultConstructorMarker) null);
    }

    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m8280coerceAtLeastJ1ME1BU(int i, int i2) {
        return Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) < 0 ? i2 : i;
    }

    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m8282coerceAtLeasteb3DHEI(long j, long j2) {
        return UByte$$ExternalSyntheticBackport0.m(j, j2) < 0 ? j2 : j;
    }

    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m8281coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.compare((int) b & 255, (int) b2 & 255) < 0 ? b2 : b;
    }

    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m8279coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare((int) s & UShort.MAX_VALUE, (int) 65535 & s2) < 0 ? s2 : s;
    }

    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m8284coerceAtMostJ1ME1BU(int i, int i2) {
        return Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) > 0 ? i2 : i;
    }

    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m8286coerceAtMosteb3DHEI(long j, long j2) {
        return UByte$$ExternalSyntheticBackport0.m(j, j2) > 0 ? j2 : j;
    }

    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m8285coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.compare((int) b & 255, (int) b2 & 255) > 0 ? b2 : b;
    }

    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m8283coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare((int) s & UShort.MAX_VALUE, (int) 65535 & s2) > 0 ? s2 : s;
    }

    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m8289coerceInWZ9TVnA(int i, int i2, int i3) {
        if (Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m7183toStringimpl(i3) + " is less than minimum " + UInt.m7183toStringimpl(i2) + '.');
        } else if (Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) < 0) {
            return i2;
        } else {
            return Integer.compare(i ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) > 0 ? i3 : i;
        }
    }

    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m8291coerceInsambcqE(long j, long j2, long j3) {
        if (UByte$$ExternalSyntheticBackport0.m(j2, j3) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m7262toStringimpl(j3) + " is less than minimum " + ULong.m7262toStringimpl(j2) + '.');
        } else if (UByte$$ExternalSyntheticBackport0.m(j, j2) < 0) {
            return j2;
        } else {
            return UByte$$ExternalSyntheticBackport0.m(j, j3) > 0 ? j3 : j;
        }
    }

    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m8290coerceInb33U2AM(byte b, byte b2, byte b3) {
        byte b4 = b2 & 255;
        byte b5 = b3 & 255;
        if (Intrinsics.compare((int) b4, (int) b5) <= 0) {
            byte b6 = b & 255;
            if (Intrinsics.compare((int) b6, (int) b4) < 0) {
                return b2;
            }
            return Intrinsics.compare((int) b6, (int) b5) > 0 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m7104toStringimpl(b3) + " is less than minimum " + UByte.m7104toStringimpl(b2) + '.');
    }

    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m8288coerceInVKSA0NQ(short s, short s2, short s3) {
        short s4 = s2 & UShort.MAX_VALUE;
        short s5 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare((int) s4, (int) s5) <= 0) {
            short s6 = 65535 & s;
            if (Intrinsics.compare((int) s6, (int) s4) < 0) {
                return s2;
            }
            return Intrinsics.compare((int) s6, (int) s5) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m7367toStringimpl(s3) + " is less than minimum " + UShort.m7367toStringimpl(s2) + '.');
    }

    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m8292coerceInwuiCnnA(int i, ClosedRange<UInt> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt.coerceIn(UInt.m7131boximpl(i), (ClosedFloatingPointRange) closedRange)).m7189unboximpl();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        } else if (Integer.compare(i ^ Integer.MIN_VALUE, closedRange.getStart().m7189unboximpl() ^ Integer.MIN_VALUE) < 0) {
            return closedRange.getStart().m7189unboximpl();
        } else {
            return Integer.compare(i ^ Integer.MIN_VALUE, closedRange.getEndInclusive().m7189unboximpl() ^ Integer.MIN_VALUE) > 0 ? closedRange.getEndInclusive().m7189unboximpl() : i;
        }
    }

    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m8287coerceInJPwROB0(long j, ClosedRange<ULong> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt.coerceIn(ULong.m7210boximpl(j), (ClosedFloatingPointRange) closedRange)).m7268unboximpl();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        } else if (UByte$$ExternalSyntheticBackport0.m(j, closedRange.getStart().m7268unboximpl()) < 0) {
            return closedRange.getStart().m7268unboximpl();
        } else {
            return UByte$$ExternalSyntheticBackport0.m(j, closedRange.getEndInclusive().m7268unboximpl()) > 0 ? closedRange.getEndInclusive().m7268unboximpl() : j;
        }
    }
}
