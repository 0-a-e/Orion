package org.altbeacon.beacon;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.altbeacon.beacon.logging.LogManager;

public class BeaconParser implements Serializable {
    public static final String ALTBEACON_LAYOUT = "m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25";
    private static final Pattern D_PATTERN = Pattern.compile("d\\:(\\d+)\\-(\\d+)([bl]*)?");
    public static final String EDDYSTONE_TLM_LAYOUT = "x,s:0-1=feaa,m:2-2=20,d:3-3,d:4-5,d:6-7,d:8-11,d:12-15";
    public static final String EDDYSTONE_UID_LAYOUT = "s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19";
    public static final String EDDYSTONE_URL_LAYOUT = "s:0-1=feaa,m:2-2=10,p:3-3:-41,i:4-21v";
    private static final char[] HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final Pattern I_PATTERN = Pattern.compile("i\\:(\\d+)\\-(\\d+)([blv]*)?");
    private static final String LITTLE_ENDIAN_SUFFIX = "l";
    private static final Pattern M_PATTERN = Pattern.compile("m\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");
    private static final Pattern P_PATTERN = Pattern.compile("p\\:(\\d+)?\\-(\\d+)?\\:?([\\-\\d]+)?");
    private static final Pattern S_PATTERN = Pattern.compile("s\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f\\-]+)");
    private static final String TAG = "BeaconParser";
    public static final String URI_BEACON_LAYOUT = "s:0-1=fed8,m:2-2=00,p:3-3:-41,i:4-21v";
    private static final String VARIABLE_LENGTH_SUFFIX = "v";
    private static final Pattern X_PATTERN = Pattern.compile("x");
    protected List<BeaconParser> extraParsers = new ArrayList();
    protected Boolean mAllowPduOverflow = true;
    protected String mBeaconLayout;
    protected Integer mDBmCorrection;
    protected final List<Integer> mDataEndOffsets = new ArrayList();
    protected final List<Boolean> mDataLittleEndianFlags = new ArrayList();
    protected final List<Integer> mDataStartOffsets = new ArrayList();
    protected Boolean mExtraFrame;
    protected int[] mHardwareAssistManufacturers = {76};
    protected String mIdentifier;
    protected final List<Integer> mIdentifierEndOffsets = new ArrayList();
    protected final List<Boolean> mIdentifierLittleEndianFlags = new ArrayList();
    protected final List<Integer> mIdentifierStartOffsets = new ArrayList();
    protected final List<Boolean> mIdentifierVariableLengthFlags = new ArrayList();
    protected Integer mLayoutSize;
    private Long mMatchingBeaconTypeCode;
    protected Integer mMatchingBeaconTypeCodeEndOffset;
    protected Integer mMatchingBeaconTypeCodeStartOffset;
    protected Integer mPowerEndOffset;
    protected Integer mPowerStartOffset;
    protected Long mServiceUuid;
    protected byte[] mServiceUuid128Bit = new byte[0];
    protected Integer mServiceUuidEndOffset;
    protected Integer mServiceUuidStartOffset;

    public BeaconParser() {
    }

    public BeaconParser(String str) {
        this.mIdentifier = str;
    }

    public BeaconParser setBeaconLayout(String str) {
        int i;
        int i2;
        int i3;
        String str2 = str;
        boolean z = false;
        LogManager.d(TAG, "API setBeaconLayout " + str2, new Object[0]);
        this.mBeaconLayout = str2;
        Log.d(TAG, "Parsing beacon layout: " + str2);
        String[] split = str2.split(",");
        this.mExtraFrame = false;
        int length = split.length;
        int i4 = 0;
        while (i4 < length) {
            String str3 = split[i4];
            Matcher matcher = I_PATTERN.matcher(str3);
            boolean z2 = z;
            while (true) {
                i = 3;
                i2 = 2;
                i3 = 1;
                if (!matcher.find()) {
                    break;
                }
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    this.mIdentifierLittleEndianFlags.add(Boolean.valueOf(matcher.group(3).contains(LITTLE_ENDIAN_SUFFIX)));
                    this.mIdentifierVariableLengthFlags.add(Boolean.valueOf(matcher.group(3).contains(VARIABLE_LENGTH_SUFFIX)));
                    this.mIdentifierStartOffsets.add(Integer.valueOf(parseInt));
                    this.mIdentifierEndOffsets.add(Integer.valueOf(parseInt2));
                    z2 = true;
                } catch (NumberFormatException unused) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str3);
                }
            }
            Matcher matcher2 = D_PATTERN.matcher(str3);
            while (matcher2.find()) {
                try {
                    int parseInt3 = Integer.parseInt(matcher2.group(1));
                    int parseInt4 = Integer.parseInt(matcher2.group(2));
                    this.mDataLittleEndianFlags.add(Boolean.valueOf(matcher2.group(3).contains(LITTLE_ENDIAN_SUFFIX)));
                    this.mDataStartOffsets.add(Integer.valueOf(parseInt3));
                    this.mDataEndOffsets.add(Integer.valueOf(parseInt4));
                    z2 = true;
                } catch (NumberFormatException unused2) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str3);
                }
            }
            Matcher matcher3 = P_PATTERN.matcher(str3);
            while (matcher3.find()) {
                try {
                    if (!(matcher3.group(1) == null || matcher3.group(2) == null)) {
                        int parseInt5 = Integer.parseInt(matcher3.group(1));
                        int parseInt6 = Integer.parseInt(matcher3.group(2));
                        this.mPowerStartOffset = Integer.valueOf(parseInt5);
                        this.mPowerEndOffset = Integer.valueOf(parseInt6);
                    }
                    this.mDBmCorrection = Integer.valueOf(matcher3.group(3) != null ? Integer.parseInt(matcher3.group(3)) : 0);
                    z2 = true;
                } catch (NumberFormatException unused3) {
                    throw new BeaconLayoutException("Cannot parse integer power byte offset (" + "none" + ") in term: " + str3);
                }
            }
            Matcher matcher4 = M_PATTERN.matcher(str3);
            while (matcher4.find()) {
                try {
                    int parseInt7 = Integer.parseInt(matcher4.group(1));
                    int parseInt8 = Integer.parseInt(matcher4.group(2));
                    this.mMatchingBeaconTypeCodeStartOffset = Integer.valueOf(parseInt7);
                    this.mMatchingBeaconTypeCodeEndOffset = Integer.valueOf(parseInt8);
                    String group = matcher4.group(3);
                    try {
                        this.mMatchingBeaconTypeCode = Long.decode("0x" + group);
                        z2 = true;
                    } catch (NumberFormatException unused4) {
                        throw new BeaconLayoutException("Cannot parse beacon type code: " + group + " in term: " + str3);
                    }
                } catch (NumberFormatException unused5) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str3);
                }
            }
            Matcher matcher5 = S_PATTERN.matcher(str3);
            while (matcher5.find()) {
                try {
                    int parseInt9 = Integer.parseInt(matcher5.group(i3));
                    int parseInt10 = Integer.parseInt(matcher5.group(i2));
                    this.mServiceUuidStartOffset = Integer.valueOf(parseInt9);
                    this.mServiceUuidEndOffset = Integer.valueOf(parseInt10);
                    String group2 = matcher5.group(i);
                    if ((this.mServiceUuidEndOffset.intValue() - this.mServiceUuidStartOffset.intValue()) + i3 == i2) {
                        try {
                            this.mServiceUuid = Long.decode("0x" + group2);
                        } catch (NumberFormatException unused6) {
                            throw new BeaconLayoutException("Cannot parse serviceUuid: " + group2 + " in term: " + str3);
                        }
                    } else if ((this.mServiceUuidEndOffset.intValue() - this.mServiceUuidStartOffset.intValue()) + i3 == 16) {
                        String replace = group2.replace("-", "");
                        if (replace.length() == 32) {
                            this.mServiceUuid128Bit = new byte[16];
                            int i5 = 0;
                            while (i5 < 16) {
                                int i6 = i5 * 2;
                                String substring = replace.substring(i6, i6 + 2);
                                try {
                                    this.mServiceUuid128Bit[15 - i5] = (byte) Integer.parseInt(substring, 16);
                                    i5++;
                                } catch (NumberFormatException unused7) {
                                    throw new BeaconLayoutException("Cannot parse serviceUuid byte " + substring + " in term: " + str3);
                                }
                            }
                        } else {
                            throw new BeaconLayoutException("128-bit ServiceUuid must be 16 bytes long: " + group2 + " in term: " + str3);
                        }
                    } else {
                        throw new BeaconLayoutException("Cannot parse serviceUuid -- it must be 2 bytes or 16 bytes long: " + group2 + " in term: " + str3);
                    }
                    z2 = true;
                    i = 3;
                    i2 = 2;
                    i3 = 1;
                } catch (NumberFormatException unused8) {
                    throw new BeaconLayoutException("Cannot parse integer byte offset in term: " + str3);
                }
            }
            Matcher matcher6 = X_PATTERN.matcher(str3);
            while (matcher6.find()) {
                this.mExtraFrame = true;
                z2 = true;
            }
            if (z2) {
                i4++;
                z = false;
            } else {
                LogManager.d(TAG, "cannot parse term %s", str3);
                throw new BeaconLayoutException("Cannot parse beacon layout term: " + str3);
            }
        }
        this.mLayoutSize = Integer.valueOf(calculateLayoutSize());
        return this;
    }

    public boolean addExtraDataParser(BeaconParser beaconParser) {
        return beaconParser != null && beaconParser.mExtraFrame.booleanValue() && this.extraParsers.add(beaconParser);
    }

    public List<BeaconParser> getExtraDataParsers() {
        return new ArrayList(this.extraParsers);
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public int[] getHardwareAssistManufacturers() {
        return this.mHardwareAssistManufacturers;
    }

    public void setHardwareAssistManufacturerCodes(int[] iArr) {
        this.mHardwareAssistManufacturers = iArr;
    }

    public void setAllowPduOverflow(Boolean bool) {
        this.mAllowPduOverflow = bool;
    }

    public Long getMatchingBeaconTypeCode() {
        Long l = this.mMatchingBeaconTypeCode;
        if (l == null) {
            return -1L;
        }
        return l;
    }

    public int getMatchingBeaconTypeCodeStartOffset() {
        Integer num = this.mMatchingBeaconTypeCodeStartOffset;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public int getMatchingBeaconTypeCodeEndOffset() {
        Integer num = this.mMatchingBeaconTypeCodeEndOffset;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public Long getServiceUuid() {
        return this.mServiceUuid;
    }

    public byte[] getServiceUuid128Bit() {
        return this.mServiceUuid128Bit;
    }

    public int getMServiceUuidStartOffset() {
        return this.mServiceUuidStartOffset.intValue();
    }

    public int getServiceUuidEndOffset() {
        return this.mServiceUuidEndOffset.intValue();
    }

    public Beacon fromScanData(byte[] bArr, int i, BluetoothDevice bluetoothDevice, long j) {
        return fromScanData(bArr, i, bluetoothDevice, j, new Beacon());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0196, code lost:
        if (r6.getType() == 33) goto L_0x019b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x048f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0249  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.altbeacon.beacon.Beacon fromScanData(byte[] r25, int r26, android.bluetooth.BluetoothDevice r27, long r28, org.altbeacon.beacon.Beacon r30) {
        /*
            r24 = this;
            r0 = r24
            r1 = r28
            r3 = r30
            org.altbeacon.bluetooth.BleAdvertisement r4 = new org.altbeacon.bluetooth.BleAdvertisement
            r5 = r25
            r4.<init>(r5)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r4 = r4.getPdus()
            java.util.Iterator r4 = r4.iterator()
        L_0x0024:
            boolean r9 = r4.hasNext()
            r11 = 4
            r12 = -1
            r13 = 33
            r14 = 22
            java.lang.String r10 = "BeaconParser"
            if (r9 == 0) goto L_0x00a7
            java.lang.Object r9 = r4.next()
            org.altbeacon.bluetooth.Pdu r9 = (org.altbeacon.bluetooth.Pdu) r9
            byte r15 = r9.getType()
            if (r15 != r14) goto L_0x0042
            java.lang.Long r14 = r0.mServiceUuid
            if (r14 != 0) goto L_0x0053
        L_0x0042:
            byte r14 = r9.getType()
            if (r14 != r13) goto L_0x004d
            byte[] r13 = r0.mServiceUuid128Bit
            int r13 = r13.length
            if (r13 != 0) goto L_0x0053
        L_0x004d:
            byte r13 = r9.getType()
            if (r13 != r12) goto L_0x008c
        L_0x0053:
            r6.add(r9)
            boolean r12 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r12 == 0) goto L_0x0024
            byte r12 = r9.getType()
            java.lang.Byte r12 = java.lang.Byte.valueOf(r12)
            java.lang.String r13 = bytesToHex(r25)
            int r14 = r9.getStartIndex()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            int r9 = r9.getEndIndex()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r15 = 0
            r11[r15] = r12
            r12 = 1
            r11[r12] = r13
            r12 = 2
            r11[r12] = r14
            r12 = 3
            r11[r12] = r9
            java.lang.String r9 = "Processing pdu type %02X: %s with startIndex: %d, endIndex: %d"
            org.altbeacon.beacon.logging.LogManager.d(r10, r9, r11)
            goto L_0x0024
        L_0x008c:
            r12 = 1
            boolean r11 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r11 == 0) goto L_0x0024
            byte r9 = r9.getType()
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            java.lang.Object[] r11 = new java.lang.Object[r12]
            r12 = 0
            r11[r12] = r9
            java.lang.String r9 = "Ignoring pdu type %02X"
            org.altbeacon.beacon.logging.LogManager.d(r10, r9, r11)
            goto L_0x0024
        L_0x00a7:
            int r4 = r6.size()
            if (r4 != 0) goto L_0x00c1
            boolean r4 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r4 == 0) goto L_0x00bc
            java.lang.String r4 = "No PDUs to process in this packet."
            r15 = 0
            java.lang.Object[] r6 = new java.lang.Object[r15]
            org.altbeacon.beacon.logging.LogManager.d(r10, r4, r6)
            goto L_0x00bd
        L_0x00bc:
            r15 = 0
        L_0x00bd:
            r4 = r15
            r14 = r4
            goto L_0x049f
        L_0x00c1:
            r15 = 0
            java.util.Iterator r4 = r6.iterator()
            r6 = r15
            r19 = r6
            r20 = r19
        L_0x00cb:
            boolean r18 = r4.hasNext()
            if (r18 == 0) goto L_0x049b
            java.lang.Object r6 = r4.next()
            org.altbeacon.bluetooth.Pdu r6 = (org.altbeacon.bluetooth.Pdu) r6
            byte[] r12 = new byte[r15]
            java.lang.Integer r15 = r0.mMatchingBeaconTypeCodeEndOffset
            if (r15 == 0) goto L_0x0100
            java.lang.Integer r15 = r0.mMatchingBeaconTypeCodeStartOffset
            int r15 = r15.intValue()
            if (r15 < 0) goto L_0x0100
            java.lang.Long r12 = r24.getMatchingBeaconTypeCode()
            long r11 = r12.longValue()
            java.lang.Integer r15 = r0.mMatchingBeaconTypeCodeEndOffset
            int r15 = r15.intValue()
            java.lang.Integer r9 = r0.mMatchingBeaconTypeCodeStartOffset
            int r9 = r9.intValue()
            int r15 = r15 - r9
            r9 = 1
            int r15 = r15 + r9
            byte[] r12 = longToByteArray(r11, r15)
        L_0x0100:
            byte[] r9 = r24.getServiceUuid128Bit()
            java.lang.Long r11 = r24.getServiceUuid()
            if (r11 == 0) goto L_0x0126
            java.lang.Long r9 = r24.getServiceUuid()
            long r14 = r9.longValue()
            java.lang.Integer r9 = r0.mServiceUuidEndOffset
            int r9 = r9.intValue()
            java.lang.Integer r11 = r0.mServiceUuidStartOffset
            int r11 = r11.intValue()
            int r9 = r9 - r11
            r11 = 1
            int r9 = r9 + r11
            r11 = 0
            byte[] r9 = longToByteArray(r14, r9, r11)
        L_0x0126:
            int r14 = r6.getStartIndex()
            int r11 = r9.length
            if (r11 != 0) goto L_0x0147
            java.lang.Integer r11 = r0.mMatchingBeaconTypeCodeEndOffset
            if (r11 == 0) goto L_0x0143
            java.lang.Integer r11 = r0.mMatchingBeaconTypeCodeStartOffset
            int r11 = r11.intValue()
            int r11 = r11 + r14
            boolean r11 = r0.byteArraysMatch(r5, r11, r12)
            if (r11 == 0) goto L_0x0143
            r15 = r13
            r11 = 1
            r13 = 22
            goto L_0x01a2
        L_0x0143:
            r15 = r13
            r13 = 22
            goto L_0x01a1
        L_0x0147:
            byte r11 = r6.getType()
            if (r11 != r13) goto L_0x0154
            int r11 = r9.length
            r15 = 16
            if (r11 != r15) goto L_0x0154
            r15 = 1
            goto L_0x0155
        L_0x0154:
            r15 = 0
        L_0x0155:
            byte r11 = r6.getType()
            r13 = 22
            if (r11 != r13) goto L_0x0162
            int r13 = r9.length
            r11 = 2
            if (r13 != r11) goto L_0x0162
            r15 = 1
        L_0x0162:
            if (r15 == 0) goto L_0x019d
            java.lang.Integer r11 = r0.mServiceUuidStartOffset
            int r11 = r11.intValue()
            int r11 = r11 + r14
            boolean r11 = r0.byteArraysMatch(r5, r11, r9)
            if (r11 == 0) goto L_0x019d
            java.lang.Integer r11 = r0.mMatchingBeaconTypeCodeEndOffset
            if (r11 == 0) goto L_0x0188
            java.lang.Integer r11 = r0.mMatchingBeaconTypeCodeStartOffset
            int r11 = r11.intValue()
            int r11 = r11 + r14
            boolean r11 = r0.byteArraysMatch(r5, r11, r12)
            if (r11 == 0) goto L_0x019d
            r11 = 1
            r13 = 22
            r15 = 33
            goto L_0x01a2
        L_0x0188:
            byte r11 = r6.getType()
            r13 = 22
            if (r11 == r13) goto L_0x0199
            byte r11 = r6.getType()
            r15 = 33
            if (r11 != r15) goto L_0x01a1
            goto L_0x019b
        L_0x0199:
            r15 = 33
        L_0x019b:
            r11 = 1
            goto L_0x01a2
        L_0x019d:
            r13 = 22
            r15 = 33
        L_0x01a1:
            r11 = 0
        L_0x01a2:
            if (r11 != 0) goto L_0x021e
            java.lang.Long r21 = r24.getServiceUuid()
            if (r21 != 0) goto L_0x01cf
            byte[] r13 = r24.getServiceUuid128Bit()
            int r13 = r13.length
            if (r13 == 0) goto L_0x01b2
            goto L_0x01cf
        L_0x01b2:
            boolean r9 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r9 == 0) goto L_0x0217
            java.lang.String r9 = r0.byteArrayToString(r12)
            java.lang.String r12 = bytesToHex(r5)
            r13 = 2
            java.lang.Object[] r15 = new java.lang.Object[r13]
            r13 = 0
            r15[r13] = r9
            r9 = 1
            r15[r9] = r12
            java.lang.String r9 = "This is not a matching Beacon advertisement. (Was expecting %s.  The bytes I see are: %s"
            org.altbeacon.beacon.logging.LogManager.d(r10, r9, r15)
            goto L_0x0217
        L_0x01cf:
            boolean r13 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r13 == 0) goto L_0x0217
            java.lang.Integer r13 = r0.mMatchingBeaconTypeCodeStartOffset
            if (r13 == 0) goto L_0x01de
            int r13 = r13.intValue()
            goto L_0x01df
        L_0x01de:
            r13 = 0
        L_0x01df:
            java.lang.String r9 = r0.byteArrayToString(r9)
            java.lang.Integer r15 = r0.mServiceUuidStartOffset
            int r15 = r15.intValue()
            int r15 = r15 + r14
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            java.lang.String r12 = r0.byteArrayToString(r12)
            int r13 = r13 + r14
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r22 = bytesToHex(r5)
            r23 = r4
            r4 = 5
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r18 = 0
            r4[r18] = r9
            r9 = 1
            r4[r9] = r15
            r15 = 2
            r4[r15] = r12
            r16 = 3
            r4[r16] = r13
            r13 = 4
            r4[r13] = r22
            java.lang.String r12 = "This is not a matching Beacon advertisement. Was expecting %s at offset %d and %s at offset %d.  The bytes I see are: %s"
            org.altbeacon.beacon.logging.LogManager.d(r10, r12, r4)
            goto L_0x0247
        L_0x0217:
            r23 = r4
            r13 = 4
            r15 = 2
            r16 = 3
            goto L_0x0247
        L_0x021e:
            r23 = r4
            r9 = 1
            r13 = 4
            r15 = 2
            r16 = 3
            boolean r4 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r4 == 0) goto L_0x0247
            java.lang.String r4 = r0.byteArrayToString(r12)
            java.lang.Object[] r12 = new java.lang.Object[r9]
            r17 = 0
            r12[r17] = r4
            java.lang.String r4 = "This is a recognized beacon advertisement -- %s seen"
            org.altbeacon.beacon.logging.LogManager.d(r10, r4, r12)
            java.lang.String r4 = bytesToHex(r5)
            java.lang.Object[] r12 = new java.lang.Object[r9]
            r12[r17] = r4
            java.lang.String r4 = "Bytes are: %s"
            org.altbeacon.beacon.logging.LogManager.d(r10, r4, r12)
        L_0x0247:
            if (r11 == 0) goto L_0x048f
            int r4 = r5.length
            java.lang.Integer r9 = r0.mLayoutSize
            int r9 = r9.intValue()
            int r9 = r9 + r14
            if (r4 > r9) goto L_0x0291
            java.lang.Boolean r4 = r0.mAllowPduOverflow
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0291
            boolean r4 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r4 == 0) goto L_0x0285
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r9 = "Expanding buffer because it is too short to parse: "
            r4.<init>(r9)
            int r9 = r5.length
            r4.append(r9)
            java.lang.String r9 = ", needed: "
            r4.append(r9)
            java.lang.Integer r9 = r0.mLayoutSize
            int r9 = r9.intValue()
            int r9 = r9 + r14
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            r9 = 0
            java.lang.Object[] r11 = new java.lang.Object[r9]
            org.altbeacon.beacon.logging.LogManager.d(r10, r4, r11)
        L_0x0285:
            java.lang.Integer r4 = r0.mLayoutSize
            int r4 = r4.intValue()
            int r4 = r4 + r14
            byte[] r4 = r0.ensureMaxSize(r5, r4)
            goto L_0x0292
        L_0x0291:
            r4 = r5
        L_0x0292:
            r12 = r20
            r5 = 0
        L_0x0295:
            java.util.List<java.lang.Integer> r9 = r0.mIdentifierEndOffsets
            int r9 = r9.size()
            java.lang.String r11 = " because PDU is too short.  endIndex: "
            java.lang.String r13 = " PDU endIndex: "
            if (r5 >= r9) goto L_0x0376
            java.util.List<java.lang.Integer> r9 = r0.mIdentifierEndOffsets
            java.lang.Object r9 = r9.get(r5)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            int r9 = r9 + r14
            int r15 = r6.getEndIndex()
            if (r9 <= r15) goto L_0x0314
            java.util.List<java.lang.Boolean> r15 = r0.mIdentifierVariableLengthFlags
            java.lang.Object r15 = r15.get(r5)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0314
            boolean r11 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r11 == 0) goto L_0x02e1
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r13 = "Need to truncate identifier by "
            r11.<init>(r13)
            int r13 = r6.getEndIndex()
            int r9 = r9 - r13
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r11 = 0
            java.lang.Object[] r13 = new java.lang.Object[r11]
            org.altbeacon.beacon.logging.LogManager.d(r10, r9, r13)
        L_0x02e1:
            java.util.List<java.lang.Integer> r9 = r0.mIdentifierStartOffsets
            java.lang.Object r9 = r9.get(r5)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            int r9 = r9 + r14
            int r11 = r6.getEndIndex()
            r13 = 1
            int r11 = r11 + r13
            if (r11 > r9) goto L_0x0300
            java.lang.String r1 = "PDU is too short for identifer.  Packet is malformed"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r10, r1, r2)
            r1 = 0
            return r1
        L_0x0300:
            java.util.List<java.lang.Boolean> r13 = r0.mIdentifierLittleEndianFlags
            java.lang.Object r13 = r13.get(r5)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            org.altbeacon.beacon.Identifier r9 = org.altbeacon.beacon.Identifier.fromBytes(r4, r9, r11, r13)
            r7.add(r9)
            goto L_0x0370
        L_0x0314:
            int r15 = r6.getEndIndex()
            if (r9 <= r15) goto L_0x034e
            java.lang.Boolean r15 = r0.mAllowPduOverflow
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x034e
            boolean r12 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r12 == 0) goto L_0x034c
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r15 = "Cannot parse identifier "
            r12.<init>(r15)
            r12.append(r5)
            r12.append(r11)
            r12.append(r9)
            r12.append(r13)
            int r9 = r6.getEndIndex()
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            r11 = 0
            java.lang.Object[] r12 = new java.lang.Object[r11]
            org.altbeacon.beacon.logging.LogManager.d(r10, r9, r12)
        L_0x034c:
            r12 = 1
            goto L_0x0370
        L_0x034e:
            java.util.List<java.lang.Integer> r11 = r0.mIdentifierStartOffsets
            java.lang.Object r11 = r11.get(r5)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            int r11 = r11 + r14
            int r9 = r9 + 1
            java.util.List<java.lang.Boolean> r13 = r0.mIdentifierLittleEndianFlags
            java.lang.Object r13 = r13.get(r5)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            org.altbeacon.beacon.Identifier r9 = org.altbeacon.beacon.Identifier.fromBytes(r4, r11, r9, r13)
            r7.add(r9)
        L_0x0370:
            int r5 = r5 + 1
            r13 = 4
            r15 = 2
            goto L_0x0295
        L_0x0376:
            r5 = 0
        L_0x0377:
            java.util.List<java.lang.Integer> r9 = r0.mDataEndOffsets
            int r9 = r9.size()
            if (r5 >= r9) goto L_0x0408
            java.util.List<java.lang.Integer> r9 = r0.mDataEndOffsets
            java.lang.Object r9 = r9.get(r5)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            int r9 = r9 + r14
            int r15 = r6.getEndIndex()
            if (r9 <= r15) goto L_0x03da
            java.lang.Boolean r15 = r0.mAllowPduOverflow
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x03da
            boolean r15 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r15 == 0) goto L_0x03cc
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r20 = r12
            java.lang.String r12 = "Cannot parse data field "
            r15.<init>(r12)
            r15.append(r5)
            r15.append(r11)
            r15.append(r9)
            r15.append(r13)
            int r9 = r6.getEndIndex()
            r15.append(r9)
            java.lang.String r9 = ".  Setting value to 0"
            r15.append(r9)
            java.lang.String r9 = r15.toString()
            r12 = 0
            java.lang.Object[] r15 = new java.lang.Object[r12]
            org.altbeacon.beacon.logging.LogManager.d(r10, r9, r15)
            goto L_0x03ce
        L_0x03cc:
            r20 = r12
        L_0x03ce:
            java.lang.Long r9 = new java.lang.Long
            r15 = r11
            r11 = 0
            r9.<init>(r11)
            r8.add(r9)
            goto L_0x0401
        L_0x03da:
            r15 = r11
            r20 = r12
            java.util.List<java.lang.Integer> r11 = r0.mDataStartOffsets
            java.lang.Object r11 = r11.get(r5)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            int r11 = r11 + r14
            java.util.List<java.lang.Boolean> r12 = r0.mDataLittleEndianFlags
            java.lang.Object r12 = r12.get(r5)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            java.lang.String r9 = r0.byteArrayToFormattedString(r4, r11, r9, r12)
            java.lang.Long r9 = java.lang.Long.decode(r9)
            r8.add(r9)
        L_0x0401:
            int r5 = r5 + 1
            r11 = r15
            r12 = r20
            goto L_0x0377
        L_0x0408:
            r20 = r12
            java.lang.Integer r5 = r0.mPowerStartOffset
            if (r5 == 0) goto L_0x0477
            java.lang.Integer r5 = r0.mPowerEndOffset
            int r5 = r5.intValue()
            int r5 = r5 + r14
            int r9 = r6.getEndIndex()     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            if (r5 <= r9) goto L_0x044c
            java.lang.Boolean r9 = r0.mAllowPduOverflow     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            boolean r9 = r9.booleanValue()     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            if (r9 != 0) goto L_0x044c
            boolean r9 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            if (r9 == 0) goto L_0x044a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            r9.<init>()     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            java.lang.String r11 = "Cannot parse power field because PDU is too short.  endIndex: "
            r9.append(r11)     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            r9.append(r5)     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            r9.append(r13)     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            int r5 = r6.getEndIndex()     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            r9.append(r5)     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            java.lang.String r5 = r9.toString()     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            r6 = 0
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
            org.altbeacon.beacon.logging.LogManager.d(r10, r5, r9)     // Catch:{ NullPointerException | NumberFormatException -> 0x044a }
        L_0x044a:
            r12 = 1
            goto L_0x0474
        L_0x044c:
            java.lang.Integer r5 = r0.mPowerStartOffset     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            int r5 = r5.intValue()     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            int r5 = r5 + r14
            java.lang.Integer r6 = r0.mPowerEndOffset     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            int r6 = r6.intValue()     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            int r6 = r6 + r14
            r9 = 0
            java.lang.String r5 = r0.byteArrayToFormattedString(r4, r5, r6, r9)     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            java.lang.Integer r6 = r0.mDBmCorrection     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            int r6 = r6.intValue()     // Catch:{ NullPointerException | NumberFormatException -> 0x0472 }
            int r5 = r5 + r6
            r6 = 127(0x7f, float:1.78E-43)
            if (r5 <= r6) goto L_0x0470
            int r5 = r5 + -256
        L_0x0470:
            r19 = r5
        L_0x0472:
            r12 = r20
        L_0x0474:
            r15 = r19
            goto L_0x0485
        L_0x0477:
            java.lang.Integer r5 = r0.mDBmCorrection
            if (r5 == 0) goto L_0x0481
            int r5 = r5.intValue()
            r15 = r5
            goto L_0x0483
        L_0x0481:
            r15 = r19
        L_0x0483:
            r12 = r20
        L_0x0485:
            r5 = r4
            if (r12 != 0) goto L_0x048b
            r4 = r15
            r15 = 1
            goto L_0x049f
        L_0x048b:
            r20 = r12
            r19 = r15
        L_0x048f:
            r6 = r14
            r4 = r23
            r11 = 4
            r12 = -1
            r13 = 33
            r14 = 22
            r15 = 0
            goto L_0x00cb
        L_0x049b:
            r14 = r6
            r4 = r19
            r15 = 0
        L_0x049f:
            if (r15 == 0) goto L_0x051d
            java.lang.Integer r6 = r0.mMatchingBeaconTypeCodeEndOffset
            if (r6 == 0) goto L_0x04bd
            java.lang.Integer r6 = r0.mMatchingBeaconTypeCodeStartOffset
            int r6 = r6.intValue()
            int r6 = r6 + r14
            java.lang.Integer r9 = r0.mMatchingBeaconTypeCodeEndOffset
            int r9 = r9.intValue()
            int r9 = r9 + r14
            r11 = 0
            java.lang.String r6 = r0.byteArrayToFormattedString(r5, r6, r9, r11)
            int r6 = java.lang.Integer.parseInt(r6)
            goto L_0x04bf
        L_0x04bd:
            r11 = 0
            r6 = -1
        L_0x04bf:
            int r9 = r14 + 1
            r12 = 1
            java.lang.String r5 = r0.byteArrayToFormattedString(r5, r14, r9, r12)
            int r5 = java.lang.Integer.parseInt(r5)
            if (r27 == 0) goto L_0x04db
            java.lang.String r9 = r27.getAddress()
            java.lang.String r10 = r27.getName()     // Catch:{ SecurityException -> 0x04d5 }
            goto L_0x04dd
        L_0x04d5:
            java.lang.String r13 = "Cannot read device name without Manifest.permission.BLUETOOTH_CONNECT"
            android.util.Log.d(r10, r13)
            goto L_0x04dc
        L_0x04db:
            r9 = 0
        L_0x04dc:
            r10 = 0
        L_0x04dd:
            r3.mIdentifiers = r7
            r3.mDataFields = r8
            r7 = r26
            r3.mRssi = r7
            r3.mBeaconTypeCode = r6
            java.lang.Long r6 = r0.mServiceUuid
            if (r6 == 0) goto L_0x04f3
            long r6 = r6.longValue()
            int r6 = (int) r6
            r3.mServiceUuid = r6
            goto L_0x04f6
        L_0x04f3:
            r6 = -1
            r3.mServiceUuid = r6
        L_0x04f6:
            r3.mBluetoothAddress = r9
            r3.mBluetoothName = r10
            r3.mManufacturer = r5
            java.lang.String r5 = r0.mIdentifier
            r3.mParserIdentifier = r5
            java.util.List<org.altbeacon.beacon.BeaconParser> r5 = r0.extraParsers
            int r5 = r5.size()
            if (r5 > 0) goto L_0x0513
            java.lang.Boolean r5 = r0.mExtraFrame
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0511
            goto L_0x0513
        L_0x0511:
            r15 = r11
            goto L_0x0514
        L_0x0513:
            r15 = r12
        L_0x0514:
            r3.mMultiFrameBeacon = r15
            r3.mFirstCycleDetectionTimestamp = r1
            r3.mLastCycleDetectionTimestamp = r1
            r3.mTxPower = r4
            return r3
        L_0x051d:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.BeaconParser.fromScanData(byte[], int, android.bluetooth.BluetoothDevice, long, org.altbeacon.beacon.Beacon):org.altbeacon.beacon.Beacon");
    }

    public byte[] getBeaconAdvertisementData(Beacon beacon) {
        if (beacon.getIdentifiers().size() == getIdentifierCount()) {
            Integer num = this.mMatchingBeaconTypeCodeEndOffset;
            int intValue = (num == null || num.intValue() <= -1) ? -1 : this.mMatchingBeaconTypeCodeEndOffset.intValue();
            Integer num2 = this.mPowerEndOffset;
            if (num2 != null && num2.intValue() > intValue) {
                intValue = this.mPowerEndOffset.intValue();
            }
            for (int i = 0; i < this.mIdentifierEndOffsets.size(); i++) {
                if (this.mIdentifierEndOffsets.get(i) != null && this.mIdentifierEndOffsets.get(i).intValue() > intValue) {
                    intValue = this.mIdentifierEndOffsets.get(i).intValue();
                }
            }
            for (int i2 = 0; i2 < this.mDataEndOffsets.size(); i2++) {
                if (this.mDataEndOffsets.get(i2) != null && this.mDataEndOffsets.get(i2).intValue() > intValue) {
                    intValue = this.mDataEndOffsets.get(i2).intValue();
                }
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.mIdentifierStartOffsets.size(); i4++) {
                if (this.mIdentifierVariableLengthFlags.get(i4).booleanValue()) {
                    i3 = (i3 + beacon.getIdentifier(i4).getByteCount()) - ((this.mIdentifierEndOffsets.get(i4).intValue() - this.mIdentifierStartOffsets.get(i4).intValue()) + 1);
                }
            }
            byte[] bArr = new byte[((intValue + i3) - 1)];
            if (this.mMatchingBeaconTypeCodeEndOffset != null) {
                getMatchingBeaconTypeCode().longValue();
                for (int intValue2 = this.mMatchingBeaconTypeCodeStartOffset.intValue(); intValue2 <= this.mMatchingBeaconTypeCodeEndOffset.intValue(); intValue2++) {
                    bArr[intValue2 - 2] = (byte) ((int) ((getMatchingBeaconTypeCode().longValue() >> ((this.mMatchingBeaconTypeCodeEndOffset.intValue() - intValue2) * 8)) & 255));
                }
            }
            for (int i5 = 0; i5 < this.mIdentifierStartOffsets.size(); i5++) {
                byte[] byteArrayOfSpecifiedEndianness = beacon.getIdentifier(i5).toByteArrayOfSpecifiedEndianness(!this.mIdentifierLittleEndianFlags.get(i5).booleanValue());
                if (byteArrayOfSpecifiedEndianness.length < getIdentifierByteCount(i5)) {
                    if (!this.mIdentifierVariableLengthFlags.get(i5).booleanValue()) {
                        if (this.mIdentifierLittleEndianFlags.get(i5).booleanValue()) {
                            byteArrayOfSpecifiedEndianness = Arrays.copyOf(byteArrayOfSpecifiedEndianness, getIdentifierByteCount(i5));
                        } else {
                            byte[] bArr2 = new byte[getIdentifierByteCount(i5)];
                            System.arraycopy(byteArrayOfSpecifiedEndianness, 0, bArr2, getIdentifierByteCount(i5) - byteArrayOfSpecifiedEndianness.length, byteArrayOfSpecifiedEndianness.length);
                            byteArrayOfSpecifiedEndianness = bArr2;
                        }
                    }
                    LogManager.d(TAG, "Expanded identifier because it is too short.  It is now: " + byteArrayToString(byteArrayOfSpecifiedEndianness), new Object[0]);
                } else if (byteArrayOfSpecifiedEndianness.length > getIdentifierByteCount(i5)) {
                    if (this.mIdentifierLittleEndianFlags.get(i5).booleanValue()) {
                        byteArrayOfSpecifiedEndianness = Arrays.copyOfRange(byteArrayOfSpecifiedEndianness, getIdentifierByteCount(i5) - byteArrayOfSpecifiedEndianness.length, getIdentifierByteCount(i5));
                    } else {
                        byteArrayOfSpecifiedEndianness = Arrays.copyOf(byteArrayOfSpecifiedEndianness, getIdentifierByteCount(i5));
                    }
                    LogManager.d(TAG, "Truncated identifier because it is too long.  It is now: " + byteArrayToString(byteArrayOfSpecifiedEndianness), new Object[0]);
                } else {
                    LogManager.d(TAG, "Identifier size is just right: " + byteArrayToString(byteArrayOfSpecifiedEndianness), new Object[0]);
                }
                for (int intValue3 = this.mIdentifierStartOffsets.get(i5).intValue(); intValue3 <= (this.mIdentifierStartOffsets.get(i5).intValue() + byteArrayOfSpecifiedEndianness.length) - 1; intValue3++) {
                    bArr[intValue3 - 2] = byteArrayOfSpecifiedEndianness[intValue3 - this.mIdentifierStartOffsets.get(i5).intValue()];
                }
            }
            Integer num3 = this.mPowerStartOffset;
            if (!(num3 == null || this.mPowerEndOffset == null || num3.intValue() < 2)) {
                for (int intValue4 = this.mPowerStartOffset.intValue(); intValue4 <= this.mPowerEndOffset.intValue(); intValue4++) {
                    bArr[intValue4 - 2] = (byte) ((beacon.getTxPower() >> ((intValue4 - this.mPowerStartOffset.intValue()) * 8)) & 255);
                }
            }
            for (int i6 = 0; i6 < this.mDataStartOffsets.size(); i6++) {
                long longValue = beacon.getDataFields().get(i6).longValue();
                int intValue5 = this.mDataEndOffsets.get(i6).intValue() - this.mDataStartOffsets.get(i6).intValue();
                for (int i7 = 0; i7 <= intValue5; i7++) {
                    bArr[(this.mDataStartOffsets.get(i6).intValue() - 2) + (!this.mDataLittleEndianFlags.get(i6).booleanValue() ? intValue5 - i7 : i7)] = (byte) ((int) ((longValue >> (i7 * 8)) & 255));
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Beacon has " + beacon.getIdentifiers().size() + " identifiers but format requires " + getIdentifierCount());
    }

    public BeaconParser setMatchingBeaconTypeCode(Long l) {
        this.mMatchingBeaconTypeCode = l;
        return this;
    }

    public int getIdentifierByteCount(int i) {
        return (this.mIdentifierEndOffsets.get(i).intValue() - this.mIdentifierStartOffsets.get(i).intValue()) + 1;
    }

    public int getIdentifierCount() {
        return this.mIdentifierStartOffsets.size();
    }

    public int getDataFieldCount() {
        return this.mDataStartOffsets.size();
    }

    public String getLayout() {
        return this.mBeaconLayout;
    }

    public int getPowerCorrection() {
        return this.mDBmCorrection.intValue();
    }

    protected static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static class BeaconLayoutException extends RuntimeException {
        public BeaconLayoutException(String str) {
            super(str);
        }
    }

    public static byte[] longToByteArray(long j, int i) {
        return longToByteArray(j, i, true);
    }

    public static byte[] longToByteArray(long j, int i, boolean z) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = ((i - (z ? i2 : (i - i2) - 1)) - 1) * 8;
            bArr[i2] = (byte) ((int) ((j & (255 << i3)) >> ((int) ((long) i3))));
        }
        return bArr;
    }

    private int calculateLayoutSize() {
        List<Integer> list = this.mIdentifierEndOffsets;
        int i = 0;
        if (list != null) {
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                if (intValue2 > i) {
                    i = intValue2;
                }
            }
        }
        List<Integer> list2 = this.mDataEndOffsets;
        if (list2 != null) {
            for (Integer intValue3 : list2) {
                int intValue4 = intValue3.intValue();
                if (intValue4 > i) {
                    i = intValue4;
                }
            }
        }
        Integer num = this.mPowerEndOffset;
        if (num != null && num.intValue() > i) {
            i = this.mPowerEndOffset.intValue();
        }
        Integer num2 = this.mServiceUuidEndOffset;
        if (num2 != null && num2.intValue() > i) {
            i = this.mServiceUuidEndOffset.intValue();
        }
        return i + 1;
    }

    private boolean byteArraysMatch(byte[] bArr, int i, byte[] bArr2) {
        int length = bArr2.length;
        if (bArr.length - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private String byteArrayToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String byteArrayToFormattedString(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i2 - i;
        int i4 = i3 + 1;
        byte[] bArr2 = new byte[i4];
        if (z) {
            for (int i5 = 0; i5 <= i3; i5++) {
                bArr2[i5] = bArr[((i + i4) - 1) - i5];
            }
        } else {
            for (int i6 = 0; i6 <= i3; i6++) {
                bArr2[i6] = bArr[i + i6];
            }
        }
        if (i4 < 5) {
            long j = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                j += ((long) (bArr2[(i4 - i7) - 1] & 255)) * ((long) Math.pow(256.0d, ((double) i7) * 1.0d));
            }
            return Long.toString(j);
        }
        String bytesToHex = bytesToHex(bArr2);
        if (i4 == 16) {
            return bytesToHex.substring(0, 8) + "-" + bytesToHex.substring(8, 12) + "-" + bytesToHex.substring(12, 16) + "-" + bytesToHex.substring(16, 20) + "-" + bytesToHex.substring(20, 32);
        }
        return "0x" + bytesToHex;
    }

    private byte[] ensureMaxSize(byte[] bArr, int i) {
        if (bArr.length >= i) {
            return bArr;
        }
        return Arrays.copyOf(bArr, i);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.mMatchingBeaconTypeCode, this.mIdentifierStartOffsets, this.mIdentifierEndOffsets, this.mIdentifierLittleEndianFlags, this.mDataStartOffsets, this.mDataEndOffsets, this.mDataLittleEndianFlags, this.mIdentifierVariableLengthFlags, this.mMatchingBeaconTypeCodeStartOffset, this.mMatchingBeaconTypeCodeEndOffset, this.mServiceUuidStartOffset, this.mServiceUuidEndOffset, this.mServiceUuid, this.mServiceUuid128Bit, this.mExtraFrame, this.mPowerStartOffset, this.mPowerEndOffset, this.mDBmCorrection, this.mLayoutSize, this.mAllowPduOverflow, this.mIdentifier, this.mHardwareAssistManufacturers, this.extraParsers});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r3 = r3.mIdentifier;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            org.altbeacon.beacon.BeaconParser r3 = (org.altbeacon.beacon.BeaconParser) r3     // Catch:{ ClassCastException -> 0x001c }
            java.lang.String r0 = r3.mBeaconLayout     // Catch:{ ClassCastException -> 0x001c }
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = r2.mBeaconLayout     // Catch:{ ClassCastException -> 0x001c }
            boolean r0 = r0.equals(r1)     // Catch:{ ClassCastException -> 0x001c }
            if (r0 == 0) goto L_0x001c
            java.lang.String r3 = r3.mIdentifier     // Catch:{ ClassCastException -> 0x001c }
            if (r3 == 0) goto L_0x001c
            java.lang.String r0 = r2.mIdentifier     // Catch:{ ClassCastException -> 0x001c }
            boolean r3 = r3.equals(r0)     // Catch:{ ClassCastException -> 0x001c }
            if (r3 == 0) goto L_0x001c
            r3 = 1
            return r3
        L_0x001c:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.BeaconParser.equals(java.lang.Object):boolean");
    }
}
