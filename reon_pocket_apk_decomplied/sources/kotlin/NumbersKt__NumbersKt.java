package kotlin;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\b¨\u0006\u000b"}, d2 = {"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
/* compiled from: Numbers.kt */
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    public static final byte rotateLeft(byte b, int i) {
        byte b2 = i & 7;
        return (byte) (((b & 255) >>> (8 - b2)) | (b << b2));
    }

    public static final short rotateLeft(short s, int i) {
        short s2 = i & 15;
        return (short) (((s & UShort.MAX_VALUE) >>> (16 - s2)) | (s << s2));
    }

    public static final byte rotateRight(byte b, int i) {
        byte b2 = i & 7;
        return (byte) (((b & 255) >>> b2) | (b << (8 - b2)));
    }

    public static final short rotateRight(short s, int i) {
        short s2 = i & 15;
        return (short) (((s & UShort.MAX_VALUE) >>> s2) | (s << (16 - s2)));
    }

    private static final int countOneBits(byte b) {
        return Integer.bitCount(b & 255);
    }

    private static final int countLeadingZeroBits(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    private static final int countTrailingZeroBits(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    private static final byte takeHighestOneBit(byte b) {
        return (byte) Integer.highestOneBit(b & 255);
    }

    private static final byte takeLowestOneBit(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    private static final int countOneBits(short s) {
        return Integer.bitCount(s & UShort.MAX_VALUE);
    }

    private static final int countLeadingZeroBits(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    private static final int countTrailingZeroBits(short s) {
        return Integer.numberOfTrailingZeros(s | UShort.MIN_VALUE);
    }

    private static final short takeHighestOneBit(short s) {
        return (short) Integer.highestOneBit(s & UShort.MAX_VALUE);
    }

    private static final short takeLowestOneBit(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
