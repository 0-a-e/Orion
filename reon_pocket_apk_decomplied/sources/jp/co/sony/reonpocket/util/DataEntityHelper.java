package jp.co.sony.reonpocket.util;

import com.google.firebase.messaging.Constants;
import java.math.BigInteger;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0002\u0010\u0011J=\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0017J;\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ-\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u000eJ\u001e\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ0\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J.\u0010*\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Ljp/co/sony/reonpocket/util/DataEntityHelper;", "", "()V", "HEX_ARRAY", "", "createWriteBytes", "", "value", "", "formatType", "Ljp/co/sony/reonpocket/util/DataEntityHelper$DataFormat;", "order", "Ljava/nio/ByteOrder;", "getByte", "", "data", "offset", "([BI)Ljava/lang/Byte;", "getIntArray", "", "size", "([BLjp/co/sony/reonpocket/util/DataEntityHelper$DataFormat;IILjava/nio/ByteOrder;)[Ljava/lang/Integer;", "getIntValue", "([BLjp/co/sony/reonpocket/util/DataEntityHelper$DataFormat;ILjava/nio/ByteOrder;)Ljava/lang/Integer;", "getLongValue", "", "default", "([BLjp/co/sony/reonpocket/util/DataEntityHelper$DataFormat;ILjava/lang/Long;Ljava/nio/ByteOrder;)Ljava/lang/Long;", "getTypeLen", "getULongValue", "Lkotlin/ULong;", "getULongValue-W7BF2j0", "intToSignedBits", "i", "unsignedByteToInt", "b", "unsignedByteToLong", "unsignedBytesToInt", "b0", "b1", "b2", "b3", "unsignedBytesToLong", "unsignedToSigned", "unsigned", "DataFormat", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataEntityHelper.kt */
public final class DataEntityHelper {
    public static final int $stable = 8;
    private static final char[] HEX_ARRAY;
    public static final DataEntityHelper INSTANCE = new DataEntityHelper();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataEntityHelper.kt */
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
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat[] r0 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat r1 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.FORMAT_SINT8     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat r1 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.FORMAT_UINT8     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat r1 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.FORMAT_SINT16     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat r1 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.FORMAT_UINT16     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat r1 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.FORMAT_SINT32     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat r1 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.FORMAT_UINT32     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat r1 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.FORMAT_UINT24     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                jp.co.sony.reonpocket.util.DataEntityHelper$DataFormat r1 = jp.co.sony.reonpocket.util.DataEntityHelper.DataFormat.FORMAT_SINT24     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.util.DataEntityHelper.WhenMappings.<clinit>():void");
        }
    }

    private final int intToSignedBits(int i, int i2) {
        if (i >= 0) {
            return i;
        }
        int i3 = 1 << (i2 - 1);
        return (i & (i3 - 1)) + i3;
    }

    public final int getTypeLen(int i) {
        return i & 15;
    }

    public final int unsignedByteToInt(byte b) {
        return b & 255;
    }

    public final long unsignedByteToLong(byte b) {
        return ((long) b) & 255;
    }

    public final int unsignedToSigned(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        return (i & i3) != 0 ? (i3 - (i & (i3 - 1))) * -1 : i;
    }

    public final long unsignedToSigned(long j, int i) {
        int i2 = 1 << (i - 1);
        long j2 = (long) i2;
        return (j & j2) != 0 ? ((long) -1) * (j2 - (j & ((long) (i2 - 1)))) : j;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/util/DataEntityHelper$DataFormat;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "FORMAT_UINT8", "FORMAT_UINT16", "FORMAT_UINT24", "FORMAT_UINT32", "FORMAT_UINT64", "FORMAT_SINT8", "FORMAT_SINT16", "FORMAT_SINT24", "FORMAT_SINT32", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataEntityHelper.kt */
    public enum DataFormat {
        FORMAT_UINT8(17),
        FORMAT_UINT16(18),
        FORMAT_UINT24(19),
        FORMAT_UINT32(20),
        FORMAT_UINT64(21),
        FORMAT_SINT8(33),
        FORMAT_SINT16(34),
        FORMAT_SINT24(35),
        FORMAT_SINT32(36);
        
        private final int code;

        public static EnumEntries<DataFormat> getEntries() {
            return $ENTRIES;
        }

        private DataFormat(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }

        static {
            DataFormat[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    private DataEntityHelper() {
    }

    public static /* synthetic */ byte[] createWriteBytes$default(DataEntityHelper dataEntityHelper, int i, DataFormat dataFormat, ByteOrder byteOrder, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            byteOrder = ByteOrder.BIG_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
        }
        return dataEntityHelper.createWriteBytes(i, dataFormat, byteOrder);
    }

    public final byte[] createWriteBytes(int i, DataFormat dataFormat, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(dataFormat, "formatType");
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        byte[] bArr = new byte[(dataFormat.getCode() & 15)];
        switch (WhenMappings.$EnumSwitchMapping$0[dataFormat.ordinal()]) {
            case 1:
                bArr[0] = (byte) (intToSignedBits(i, 8) & 255);
                break;
            case 2:
                bArr[0] = (byte) (i & 255);
                break;
            case 3:
                int intToSignedBits = intToSignedBits(i, 16);
                bArr[0] = (byte) (intToSignedBits & 255);
                bArr[1] = (byte) ((intToSignedBits >> 8) & 255);
                break;
            case 4:
                bArr[0] = (byte) (i & 255);
                bArr[1] = (byte) ((i >> 8) & 255);
                break;
            case 5:
                int intToSignedBits2 = intToSignedBits(i, 32);
                bArr[0] = (byte) (intToSignedBits2 & 255);
                bArr[1] = (byte) ((intToSignedBits2 >> 8) & 255);
                bArr[2] = (byte) ((intToSignedBits2 >> 16) & 255);
                bArr[3] = (byte) ((intToSignedBits2 >> 24) & 255);
                break;
            case 6:
                bArr[0] = (byte) (i & 255);
                bArr[1] = (byte) ((i >> 8) & 255);
                bArr[2] = (byte) ((i >> 16) & 255);
                bArr[3] = (byte) ((i >> 24) & 255);
                break;
        }
        if (Intrinsics.areEqual((Object) byteOrder, (Object) ByteOrder.BIG_ENDIAN)) {
            ArraysKt.reverse(bArr);
        }
        return bArr;
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        HEX_ARRAY = charArray;
    }

    public final Byte getByte(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (i + 1 > bArr.length) {
            return null;
        }
        return Byte.valueOf(bArr[i]);
    }

    public static /* synthetic */ Integer getIntValue$default(DataEntityHelper dataEntityHelper, byte[] bArr, DataFormat dataFormat, int i, ByteOrder byteOrder, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            byteOrder = ByteOrder.BIG_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
        }
        return dataEntityHelper.getIntValue(bArr, dataFormat, i, byteOrder);
    }

    public final Integer getIntValue(byte[] bArr, DataFormat dataFormat, int i, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(bArr, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        Intrinsics.checkNotNullParameter(dataFormat, "formatType");
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        if (getTypeLen(dataFormat.getCode()) + i > bArr.length) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[dataFormat.ordinal()]) {
            case 1:
                return Integer.valueOf(unsignedToSigned(unsignedByteToInt(bArr[i]), 8));
            case 2:
                return Integer.valueOf(unsignedByteToInt(bArr[i]));
            case 3:
                return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(bArr[i], bArr[i + 1], byteOrder), 16));
            case 4:
                return Integer.valueOf(unsignedBytesToInt(bArr[i], bArr[i + 1], byteOrder));
            case 5:
                return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3], byteOrder), 32));
            case 6:
                return Integer.valueOf(unsignedBytesToInt(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3], byteOrder));
            case 7:
                return Integer.valueOf(unsignedBytesToInt(bArr[i], bArr[i + 1], bArr[i + 2], (byte) 0, byteOrder));
            case 8:
                return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(bArr[i], bArr[i + 1], bArr[i + 2], (byte) 0, byteOrder), 24));
            default:
                return null;
        }
    }

    public static /* synthetic */ Long getLongValue$default(DataEntityHelper dataEntityHelper, byte[] bArr, DataFormat dataFormat, int i, Long l, ByteOrder byteOrder, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            l = null;
        }
        Long l2 = l;
        if ((i2 & 16) != 0) {
            byteOrder = ByteOrder.BIG_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
        }
        return dataEntityHelper.getLongValue(bArr, dataFormat, i, l2, byteOrder);
    }

    public final Long getLongValue(byte[] bArr, DataFormat dataFormat, int i, Long l, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(bArr, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        Intrinsics.checkNotNullParameter(dataFormat, "formatType");
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        if (getTypeLen(dataFormat.getCode()) + i > bArr.length) {
            return l;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[dataFormat.ordinal()];
        if (i2 == 5) {
            return Long.valueOf(unsignedToSigned(unsignedBytesToLong(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3], byteOrder), 32));
        } else if (i2 != 6) {
            return l;
        } else {
            return Long.valueOf(unsignedBytesToLong(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3], byteOrder));
        }
    }

    /* renamed from: getULongValue-W7BF2j0  reason: not valid java name */
    public final ULong m7028getULongValueW7BF2j0(byte[] bArr, DataFormat dataFormat, int i) {
        Intrinsics.checkNotNullParameter(bArr, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        Intrinsics.checkNotNullParameter(dataFormat, "formatType");
        if (dataFormat != DataFormat.FORMAT_UINT64) {
            return null;
        }
        byte[] copyOfRange = ArraysKt.copyOfRange(bArr, i, i + 8);
        BigInteger shiftLeft = BigInteger.ONE.shiftLeft(64);
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j = (j << 8) | ((long) ((byte) copyOfRange[i2]));
        }
        BigInteger valueOf = BigInteger.valueOf(j);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(shiftLeft);
        }
        String bigInteger = valueOf.toString();
        Intrinsics.checkNotNullExpressionValue(bigInteger, "toString(...)");
        return ULong.m7210boximpl(UStringsKt.toULong(bigInteger));
    }

    public final int unsignedBytesToInt(byte b, byte b2, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        if (Intrinsics.areEqual((Object) byteOrder, (Object) ByteOrder.LITTLE_ENDIAN)) {
            return unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8);
        }
        byte[] reversedArray = ArraysKt.reversedArray(new byte[]{b, b2});
        return (unsignedByteToInt(reversedArray[1]) << 8) + unsignedByteToInt(reversedArray[0]);
    }

    private final int unsignedBytesToInt(byte b, byte b2, byte b3, byte b4, ByteOrder byteOrder) {
        if (Intrinsics.areEqual((Object) byteOrder, (Object) ByteOrder.LITTLE_ENDIAN)) {
            return unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8) + (unsignedByteToInt(b3) << 16) + (unsignedByteToInt(b4) << 24);
        }
        byte[] reversedArray = ArraysKt.reversedArray(new byte[]{b, b2, b3, b4});
        return (unsignedByteToInt(reversedArray[3]) << 24) + unsignedByteToInt(reversedArray[0]) + (unsignedByteToInt(reversedArray[1]) << 8) + (unsignedByteToInt(reversedArray[2]) << 16);
    }

    public final long unsignedBytesToLong(byte b, byte b2, byte b3, byte b4, ByteOrder byteOrder) {
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        if (Intrinsics.areEqual((Object) byteOrder, (Object) ByteOrder.LITTLE_ENDIAN)) {
            j2 = unsignedByteToLong(b) + (unsignedByteToLong(b2) << 8) + (unsignedByteToLong(b3) << 16);
            j = unsignedByteToLong(b4);
        } else {
            byte[] reversedArray = ArraysKt.reversedArray(new byte[]{b, b2, b3, b4});
            j2 = unsignedByteToLong(reversedArray[0]) + (unsignedByteToLong(reversedArray[1]) << 8) + (unsignedByteToLong(reversedArray[2]) << 16);
            j = unsignedByteToLong(reversedArray[3]);
        }
        return j2 + (j << 24);
    }

    public static /* synthetic */ Integer[] getIntArray$default(DataEntityHelper dataEntityHelper, byte[] bArr, DataFormat dataFormat, int i, int i2, ByteOrder byteOrder, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            byteOrder = ByteOrder.BIG_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
        }
        return dataEntityHelper.getIntArray(bArr, dataFormat, i, i2, byteOrder);
    }

    public final Integer[] getIntArray(byte[] bArr, DataFormat dataFormat, int i, int i2, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(bArr, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        Intrinsics.checkNotNullParameter(dataFormat, "formatType");
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        List arrayList = new ArrayList();
        int i3 = i2 + i;
        while (i < i3) {
            Integer intValue = getIntValue(bArr, dataFormat, i, byteOrder);
            if (intValue == null) {
                return null;
            }
            intValue.intValue();
            arrayList.add(intValue);
            i++;
        }
        return (Integer[]) arrayList.toArray(new Integer[0]);
    }
}
