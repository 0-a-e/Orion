package jp.co.sony.reonpocket.data.entity;

import java.math.BigInteger;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u0010#J5\u0010$\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010%2\u0006\u0010&\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"2\b\b\u0002\u0010(\u001a\u00020\u0017¢\u0006\u0002\u0010)J'\u0010*\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010(\u001a\u00020\u0017¢\u0006\u0002\u0010+J3\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010&\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010(\u001a\u00020\u0017¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"H\u0002J%\u00101\u001a\u0004\u0018\u0001022\u0006\u0010&\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b3J\u0006\u0010'\u001a\u00020\"J\b\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020 H\u0002J\u0010\u00107\u001a\u00020-2\u0006\u00106\u001a\u00020 H\u0002J\u0018\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0002J(\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 H\u0002J(\u0010=\u001a\u00020-2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 H\u0002J\u0018\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"H\u0002J\u0018\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020-2\u0006\u0010'\u001a\u00020\"H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "", "action", "Ljp/co/sony/reonpocket/constant/BleActionCode;", "characteristicUuid", "", "serviceUuid", "data", "", "result", "", "responseCode", "Ljp/co/sony/reonpocket/constant/ResponseCode;", "(Ljp/co/sony/reonpocket/constant/BleActionCode;Ljava/lang/String;Ljava/lang/String;[BZLjp/co/sony/reonpocket/constant/ResponseCode;)V", "HEX_ARRAY", "", "getAction", "()Ljp/co/sony/reonpocket/constant/BleActionCode;", "getCharacteristicUuid", "()Ljava/lang/String;", "getData", "()[B", "mOrder", "Ljava/nio/ByteOrder;", "kotlin.jvm.PlatformType", "mValue", "getResponseCode", "()Ljp/co/sony/reonpocket/constant/ResponseCode;", "getResult", "()Z", "getServiceUuid", "getByte", "", "offset", "", "(I)Ljava/lang/Byte;", "getIntArray", "", "formatType", "size", "order", "(IIILjava/nio/ByteOrder;)[Ljava/lang/Integer;", "getIntValue", "(IILjava/nio/ByteOrder;)Ljava/lang/Integer;", "getLongValue", "", "default", "(IILjava/lang/Long;Ljava/nio/ByteOrder;)Ljava/lang/Long;", "getTypeLen", "getULongValue", "Lkotlin/ULong;", "getULongValue-woJcscw", "toString", "unsignedByteToInt", "b", "unsignedByteToLong", "unsignedBytesToInt", "b0", "b1", "b2", "b3", "unsignedBytesToLong", "unsignedToSigned", "unsigned", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleDataEntity.kt */
public final class BleDataEntity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FORMAT_SINT16 = 34;
    public static final int FORMAT_SINT24 = 35;
    public static final int FORMAT_SINT32 = 36;
    public static final int FORMAT_SINT8 = 33;
    public static final int FORMAT_UINT16 = 18;
    public static final int FORMAT_UINT24 = 19;
    public static final int FORMAT_UINT32 = 20;
    public static final int FORMAT_UINT64 = 21;
    public static final int FORMAT_UINT8 = 17;
    private final char[] HEX_ARRAY;
    private final BleActionCode action;
    private final String characteristicUuid;
    private final byte[] data;
    private ByteOrder mOrder;
    private byte[] mValue;
    private final ResponseCode responseCode;
    private final boolean result;
    private final String serviceUuid;

    private final int getTypeLen(int i) {
        return i & 15;
    }

    private final int unsignedByteToInt(byte b) {
        return b & 255;
    }

    private final long unsignedByteToLong(byte b) {
        return ((long) b) & 255;
    }

    private final int unsignedToSigned(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        return (i & i3) != 0 ? (i3 - (i & (i3 - 1))) * -1 : i;
    }

    private final long unsignedToSigned(long j, int i) {
        int i2 = 1 << (i - 1);
        long j2 = (long) i2;
        return (j & j2) != 0 ? ((long) -1) * (j2 - (j & ((long) (i2 - 1)))) : j;
    }

    public BleDataEntity(BleActionCode bleActionCode, String str, String str2, byte[] bArr, boolean z, ResponseCode responseCode2) {
        Intrinsics.checkNotNullParameter(bleActionCode, "action");
        Intrinsics.checkNotNullParameter(str, "characteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "serviceUuid");
        Intrinsics.checkNotNullParameter(responseCode2, "responseCode");
        this.action = bleActionCode;
        this.characteristicUuid = str;
        this.serviceUuid = str2;
        this.data = bArr;
        this.result = z;
        this.responseCode = responseCode2;
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        this.HEX_ARRAY = charArray;
        this.mOrder = ByteOrder.BIG_ENDIAN;
        this.mValue = bArr == null ? new byte[0] : bArr;
    }

    public final BleActionCode getAction() {
        return this.action;
    }

    public final String getCharacteristicUuid() {
        return this.characteristicUuid;
    }

    public final String getServiceUuid() {
        return this.serviceUuid;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final boolean getResult() {
        return this.result;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BleDataEntity(BleActionCode bleActionCode, String str, String str2, byte[] bArr, boolean z, ResponseCode responseCode2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bleActionCode, str, str2, (i & 8) != 0 ? null : bArr, (i & 16) != 0 ? false : z, (i & 32) != 0 ? ResponseCode.CUSTOM_UNKNOWN_RESPONSE_CODE : responseCode2);
    }

    public final ResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/BleDataEntity$Companion;", "", "()V", "FORMAT_SINT16", "", "FORMAT_SINT24", "FORMAT_SINT32", "FORMAT_SINT8", "FORMAT_UINT16", "FORMAT_UINT24", "FORMAT_UINT32", "FORMAT_UINT64", "FORMAT_UINT8", "createWriteBytes", "", "value", "formatType", "order", "Ljava/nio/ByteOrder;", "intToSignedBits", "i", "size", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleDataEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int intToSignedBits(int i, int i2) {
            if (i >= 0) {
                return i;
            }
            int i3 = 1 << (i2 - 1);
            return (i & (i3 - 1)) + i3;
        }

        private Companion() {
        }

        public static /* synthetic */ byte[] createWriteBytes$default(Companion companion, int i, int i2, ByteOrder byteOrder, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                byteOrder = ByteOrder.BIG_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
            }
            return companion.createWriteBytes(i, i2, byteOrder);
        }

        public final byte[] createWriteBytes(int i, int i2, ByteOrder byteOrder) {
            Intrinsics.checkNotNullParameter(byteOrder, "order");
            byte[] bArr = new byte[(i2 & 15)];
            if (i2 == 17) {
                bArr[0] = (byte) (i & 255);
            } else if (i2 == 18) {
                bArr[0] = (byte) (i & 255);
                bArr[1] = (byte) ((i >> 8) & 255);
            } else if (i2 == 20) {
                bArr[0] = (byte) (i & 255);
                bArr[1] = (byte) ((i >> 8) & 255);
                bArr[2] = (byte) ((i >> 16) & 255);
                bArr[3] = (byte) ((i >> 24) & 255);
            } else if (i2 == 36) {
                int intToSignedBits = intToSignedBits(i, 32);
                bArr[0] = (byte) (intToSignedBits & 255);
                bArr[1] = (byte) ((intToSignedBits >> 8) & 255);
                bArr[2] = (byte) ((intToSignedBits >> 16) & 255);
                bArr[3] = (byte) ((intToSignedBits >> 24) & 255);
            } else if (i2 == 33) {
                bArr[0] = (byte) (intToSignedBits(i, 8) & 255);
            } else if (i2 == 34) {
                int intToSignedBits2 = intToSignedBits(i, 16);
                bArr[0] = (byte) (intToSignedBits2 & 255);
                bArr[1] = (byte) ((intToSignedBits2 >> 8) & 255);
            }
            if (Intrinsics.areEqual((Object) byteOrder, (Object) ByteOrder.BIG_ENDIAN)) {
                ArraysKt.reverse(bArr);
            }
            return bArr;
        }
    }

    public final int size() {
        return this.mValue.length;
    }

    public String toString() {
        if (size() == 0) {
            return "";
        }
        char[] cArr = new char[((size() * 3) - 1)];
        int length = this.mValue.length;
        for (int i = 0; i < length; i++) {
            byte[] bArr = this.mValue;
            byte b = bArr[i];
            int i2 = i * 3;
            char[] cArr2 = this.HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
            if (i != bArr.length - 1) {
                cArr[i2 + 2] = '-';
            }
        }
        return "(0x) ".concat(new String(cArr));
    }

    public final Byte getByte(int i) {
        if (i + 1 > size()) {
            return null;
        }
        return Byte.valueOf(this.mValue[i]);
    }

    public static /* synthetic */ Integer getIntValue$default(BleDataEntity bleDataEntity, int i, int i2, ByteOrder byteOrder, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            byteOrder = ByteOrder.BIG_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
        }
        return bleDataEntity.getIntValue(i, i2, byteOrder);
    }

    public final Integer getIntValue(int i, int i2, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        if (getTypeLen(i) + i2 > size()) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String str = this.characteristicUuid;
            String arrays = Arrays.toString(this.mValue);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
            debugLogUtil.e("[" + str + "] invalid length, offset:" + i2 + " in " + arrays);
            return null;
        }
        this.mOrder = byteOrder;
        switch (i) {
            case 17:
                return Integer.valueOf(unsignedByteToInt(this.mValue[i2]));
            case 18:
                byte[] bArr = this.mValue;
                return Integer.valueOf(unsignedBytesToInt(bArr[i2], bArr[i2 + 1]));
            case 19:
                byte[] bArr2 = this.mValue;
                return Integer.valueOf(unsignedBytesToInt(bArr2[i2], bArr2[i2 + 1], bArr2[i2 + 2], (byte) 0));
            case 20:
                byte[] bArr3 = this.mValue;
                return Integer.valueOf(unsignedBytesToInt(bArr3[i2], bArr3[i2 + 1], bArr3[i2 + 2], bArr3[i2 + 3]));
            default:
                switch (i) {
                    case 33:
                        return Integer.valueOf(unsignedToSigned(unsignedByteToInt(this.mValue[i2]), 8));
                    case 34:
                        byte[] bArr4 = this.mValue;
                        return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(bArr4[i2], bArr4[i2 + 1]), 16));
                    case 35:
                        byte[] bArr5 = this.mValue;
                        return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(bArr5[i2], bArr5[i2 + 1], bArr5[i2 + 2], (byte) 0), 24));
                    case 36:
                        byte[] bArr6 = this.mValue;
                        return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(bArr6[i2], bArr6[i2 + 1], bArr6[i2 + 2], bArr6[i2 + 3]), 32));
                    default:
                        return null;
                }
        }
    }

    public static /* synthetic */ Long getLongValue$default(BleDataEntity bleDataEntity, int i, int i2, Long l, ByteOrder byteOrder, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            l = null;
        }
        if ((i3 & 8) != 0) {
            byteOrder = ByteOrder.BIG_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
        }
        return bleDataEntity.getLongValue(i, i2, l, byteOrder);
    }

    public final Long getLongValue(int i, int i2, Long l, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        if (getTypeLen(i) + i2 > size()) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String str = this.characteristicUuid;
            String arrays = Arrays.toString(this.mValue);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
            debugLogUtil.e("[" + str + "] invalid length, offset:" + i2 + " in " + arrays);
            return l;
        }
        this.mOrder = byteOrder;
        if (i == 20) {
            byte[] bArr = this.mValue;
            return Long.valueOf(unsignedBytesToLong(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]));
        } else if (i != 36) {
            return l;
        } else {
            byte[] bArr2 = this.mValue;
            return Long.valueOf(unsignedToSigned(unsignedBytesToLong(bArr2[i2], bArr2[i2 + 1], bArr2[i2 + 2], bArr2[i2 + 3]), 32));
        }
    }

    /* renamed from: getULongValue-woJcscw  reason: not valid java name */
    public final ULong m6988getULongValuewoJcscw(int i, int i2) {
        if (i != 21) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String str = this.characteristicUuid;
            String arrays = Arrays.toString(this.mValue);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
            debugLogUtil.e("[" + str + "] invalid length, offset:" + i2 + " in " + arrays);
            return null;
        }
        byte[] copyOfRange = ArraysKt.copyOfRange(this.mValue, i2, i2 + 8);
        BigInteger shiftLeft = BigInteger.ONE.shiftLeft(64);
        long j = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j = (j << 8) | ((long) ((byte) copyOfRange[i3]));
        }
        BigInteger valueOf = BigInteger.valueOf(j);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(shiftLeft);
        }
        String bigInteger = valueOf.toString();
        Intrinsics.checkNotNullExpressionValue(bigInteger, "toString(...)");
        return ULong.m7210boximpl(UStringsKt.toULong(bigInteger));
    }

    public static /* synthetic */ Integer[] getIntArray$default(BleDataEntity bleDataEntity, int i, int i2, int i3, ByteOrder byteOrder, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            byteOrder = ByteOrder.BIG_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
        }
        return bleDataEntity.getIntArray(i, i2, i3, byteOrder);
    }

    public final Integer[] getIntArray(int i, int i2, int i3, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(byteOrder, "order");
        this.mOrder = byteOrder;
        List arrayList = new ArrayList();
        int i4 = i3 + i2;
        while (i2 < i4) {
            Integer intValue$default = getIntValue$default(this, i, i2, (ByteOrder) null, 4, (Object) null);
            if (intValue$default == null) {
                return null;
            }
            intValue$default.intValue();
            arrayList.add(intValue$default);
            i2++;
        }
        return (Integer[]) arrayList.toArray(new Integer[0]);
    }

    private final int unsignedBytesToInt(byte b, byte b2) {
        if (Intrinsics.areEqual((Object) this.mOrder, (Object) ByteOrder.LITTLE_ENDIAN)) {
            return unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8);
        }
        byte[] reversedArray = ArraysKt.reversedArray(new byte[]{b, b2});
        return (unsignedByteToInt(reversedArray[1]) << 8) + unsignedByteToInt(reversedArray[0]);
    }

    private final int unsignedBytesToInt(byte b, byte b2, byte b3, byte b4) {
        if (Intrinsics.areEqual((Object) this.mOrder, (Object) ByteOrder.LITTLE_ENDIAN)) {
            return unsignedByteToInt(b) + (unsignedByteToInt(b2) << 8) + (unsignedByteToInt(b3) << 16) + (unsignedByteToInt(b4) << 24);
        }
        byte[] reversedArray = ArraysKt.reversedArray(new byte[]{b, b2, b3, b4});
        return (unsignedByteToInt(reversedArray[3]) << 24) + unsignedByteToInt(reversedArray[0]) + (unsignedByteToInt(reversedArray[1]) << 8) + (unsignedByteToInt(reversedArray[2]) << 16);
    }

    private final long unsignedBytesToLong(byte b, byte b2, byte b3, byte b4) {
        long j;
        long j2;
        if (Intrinsics.areEqual((Object) this.mOrder, (Object) ByteOrder.LITTLE_ENDIAN)) {
            j2 = unsignedByteToLong(b) + (unsignedByteToLong(b2) << 8) + (unsignedByteToLong(b3) << 16);
            j = unsignedByteToLong(b4);
        } else {
            byte[] reversedArray = ArraysKt.reversedArray(new byte[]{b, b2, b3, b4});
            j2 = unsignedByteToLong(reversedArray[0]) + (unsignedByteToLong(reversedArray[1]) << 8) + (unsignedByteToLong(reversedArray[2]) << 16);
            j = unsignedByteToLong(reversedArray[3]);
        }
        return j2 + (j << 24);
    }
}
