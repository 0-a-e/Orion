package org.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazonaws.services.s3.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.client.BeaconDataFactory;
import org.altbeacon.beacon.client.NullBeaconDataFactory;
import org.altbeacon.beacon.distance.DistanceCalculator;
import org.altbeacon.beacon.logging.LogManager;

public class Beacon implements Parcelable, Serializable {
    @Deprecated
    public static final Parcelable.Creator<Beacon> CREATOR = new Parcelable.Creator<Beacon>() {
        public Beacon createFromParcel(Parcel parcel) {
            return new Beacon(parcel);
        }

        public Beacon[] newArray(int i) {
            return new Beacon[i];
        }
    };
    private static final String TAG = "Beacon";
    private static final List<Identifier> UNMODIFIABLE_LIST_OF_IDENTIFIER = Collections.unmodifiableList(new ArrayList());
    private static final List<Long> UNMODIFIABLE_LIST_OF_LONG = Collections.unmodifiableList(new ArrayList());
    protected static BeaconDataFactory beaconDataFactory = new NullBeaconDataFactory();
    protected static DistanceCalculator sDistanceCalculator = null;
    protected static boolean sHardwareEqualityEnforced = false;
    protected int mBeaconTypeCode;
    protected String mBluetoothAddress;
    protected String mBluetoothName;
    protected List<Long> mDataFields;
    protected Double mDistance;
    protected List<Long> mExtraDataFields;
    protected long mFirstCycleDetectionTimestamp;
    protected List<Identifier> mIdentifiers;
    protected long mLastCycleDetectionTimestamp;
    protected int mManufacturer;
    protected boolean mMultiFrameBeacon;
    private int mPacketCount;
    protected String mParserIdentifier;
    protected int mRssi;
    private int mRssiMeasurementCount;
    /* access modifiers changed from: private */
    public Double mRunningAverageRssi;
    protected int mServiceUuid;
    protected byte[] mServiceUuid128Bit;
    protected int mTxPower;

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public static void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        sDistanceCalculator = distanceCalculator;
    }

    public static DistanceCalculator getDistanceCalculator() {
        return sDistanceCalculator;
    }

    public static void setHardwareEqualityEnforced(boolean z) {
        sHardwareEqualityEnforced = z;
    }

    public static boolean getHardwareEqualityEnforced() {
        return sHardwareEqualityEnforced;
    }

    @Deprecated
    protected Beacon(Parcel parcel) {
        boolean z = false;
        this.mRssiMeasurementCount = 0;
        this.mPacketCount = 0;
        this.mRunningAverageRssi = null;
        this.mServiceUuid = -1;
        this.mServiceUuid128Bit = new byte[0];
        this.mMultiFrameBeacon = false;
        this.mFirstCycleDetectionTimestamp = 0;
        this.mLastCycleDetectionTimestamp = 0;
        int readInt = parcel.readInt();
        this.mIdentifiers = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.mIdentifiers.add(Identifier.parse(parcel.readString()));
        }
        this.mDistance = Double.valueOf(parcel.readDouble());
        this.mRssi = parcel.readInt();
        this.mTxPower = parcel.readInt();
        this.mBluetoothAddress = parcel.readString();
        this.mBeaconTypeCode = parcel.readInt();
        this.mServiceUuid = parcel.readInt();
        if (parcel.readBoolean()) {
            this.mServiceUuid128Bit = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                this.mServiceUuid128Bit[i2] = parcel.readByte();
            }
        }
        int readInt2 = parcel.readInt();
        this.mDataFields = new ArrayList(readInt2);
        for (int i3 = 0; i3 < readInt2; i3++) {
            this.mDataFields.add(Long.valueOf(parcel.readLong()));
        }
        int readInt3 = parcel.readInt();
        this.mExtraDataFields = new ArrayList(readInt3);
        for (int i4 = 0; i4 < readInt3; i4++) {
            this.mExtraDataFields.add(Long.valueOf(parcel.readLong()));
        }
        this.mManufacturer = parcel.readInt();
        this.mBluetoothName = parcel.readString();
        this.mParserIdentifier = parcel.readString();
        this.mMultiFrameBeacon = parcel.readByte() != 0 ? true : z;
        this.mRunningAverageRssi = (Double) parcel.readValue((ClassLoader) null);
        this.mRssiMeasurementCount = parcel.readInt();
        this.mPacketCount = parcel.readInt();
        this.mFirstCycleDetectionTimestamp = parcel.readLong();
        this.mLastCycleDetectionTimestamp = parcel.readLong();
    }

    protected Beacon(Beacon beacon) {
        this.mRssiMeasurementCount = 0;
        this.mPacketCount = 0;
        this.mRunningAverageRssi = null;
        this.mServiceUuid = -1;
        this.mServiceUuid128Bit = new byte[0];
        this.mMultiFrameBeacon = false;
        this.mFirstCycleDetectionTimestamp = 0;
        this.mLastCycleDetectionTimestamp = 0;
        this.mIdentifiers = new ArrayList(beacon.mIdentifiers);
        this.mDataFields = new ArrayList(beacon.mDataFields);
        this.mExtraDataFields = new ArrayList(beacon.mExtraDataFields);
        this.mDistance = beacon.mDistance;
        this.mRunningAverageRssi = beacon.mRunningAverageRssi;
        this.mPacketCount = beacon.mPacketCount;
        this.mRssiMeasurementCount = beacon.mRssiMeasurementCount;
        this.mRssi = beacon.mRssi;
        this.mTxPower = beacon.mTxPower;
        this.mBluetoothAddress = beacon.mBluetoothAddress;
        this.mBeaconTypeCode = beacon.getBeaconTypeCode();
        this.mServiceUuid = beacon.getServiceUuid();
        this.mServiceUuid128Bit = beacon.getServiceUuid128Bit();
        this.mBluetoothName = beacon.mBluetoothName;
        this.mParserIdentifier = beacon.mParserIdentifier;
        this.mMultiFrameBeacon = beacon.mMultiFrameBeacon;
        this.mManufacturer = beacon.mManufacturer;
        this.mFirstCycleDetectionTimestamp = beacon.mFirstCycleDetectionTimestamp;
        this.mLastCycleDetectionTimestamp = beacon.mLastCycleDetectionTimestamp;
    }

    protected Beacon() {
        this.mRssiMeasurementCount = 0;
        this.mPacketCount = 0;
        this.mRunningAverageRssi = null;
        this.mServiceUuid = -1;
        this.mServiceUuid128Bit = new byte[0];
        this.mMultiFrameBeacon = false;
        this.mFirstCycleDetectionTimestamp = 0;
        this.mLastCycleDetectionTimestamp = 0;
        this.mIdentifiers = new ArrayList(1);
        this.mDataFields = new ArrayList(1);
        this.mExtraDataFields = new ArrayList(1);
    }

    public void setRssiMeasurementCount(int i) {
        this.mRssiMeasurementCount = i;
    }

    public int getPacketCount() {
        return this.mPacketCount;
    }

    public void setPacketCount(int i) {
        this.mPacketCount = i;
    }

    public long getFirstCycleDetectionTimestamp() {
        return this.mFirstCycleDetectionTimestamp;
    }

    public void setFirstCycleDetectionTimestamp(long j) {
        this.mFirstCycleDetectionTimestamp = j;
    }

    public long getLastCycleDetectionTimestamp() {
        return this.mLastCycleDetectionTimestamp;
    }

    public void setLastCycleDetectionTimestamp(long j) {
        this.mLastCycleDetectionTimestamp = j;
    }

    public int getMeasurementCount() {
        return this.mRssiMeasurementCount;
    }

    public void setRunningAverageRssi(double d) {
        this.mRunningAverageRssi = Double.valueOf(d);
        this.mDistance = null;
    }

    @Deprecated
    public double getRunningAverageRssi(double d) {
        Double valueOf = Double.valueOf(d);
        this.mRunningAverageRssi = valueOf;
        valueOf.getClass();
        return d;
    }

    public double getRunningAverageRssi() {
        Double d = this.mRunningAverageRssi;
        if (d != null) {
            return d.doubleValue();
        }
        return (double) this.mRssi;
    }

    public void setRssi(int i) {
        this.mRssi = i;
    }

    public int getManufacturer() {
        return this.mManufacturer;
    }

    public int getServiceUuid() {
        return this.mServiceUuid;
    }

    public byte[] getServiceUuid128Bit() {
        return this.mServiceUuid128Bit;
    }

    public Identifier getIdentifier(int i) {
        return this.mIdentifiers.get(i);
    }

    public Identifier getId1() {
        return this.mIdentifiers.get(0);
    }

    public Identifier getId2() {
        return this.mIdentifiers.get(1);
    }

    public Identifier getId3() {
        return this.mIdentifiers.get(2);
    }

    public List<Long> getDataFields() {
        if (this.mDataFields.getClass().isInstance(UNMODIFIABLE_LIST_OF_LONG)) {
            return this.mDataFields;
        }
        return Collections.unmodifiableList(this.mDataFields);
    }

    public List<Long> getExtraDataFields() {
        if (this.mExtraDataFields.getClass().isInstance(UNMODIFIABLE_LIST_OF_LONG)) {
            return this.mExtraDataFields;
        }
        return Collections.unmodifiableList(this.mExtraDataFields);
    }

    public void setExtraDataFields(List<Long> list) {
        this.mExtraDataFields = list;
    }

    public List<Identifier> getIdentifiers() {
        if (this.mIdentifiers.getClass().isInstance(UNMODIFIABLE_LIST_OF_IDENTIFIER)) {
            return this.mIdentifiers;
        }
        return Collections.unmodifiableList(this.mIdentifiers);
    }

    public double getDistance() {
        if (this.mDistance == null) {
            double d = (double) this.mRssi;
            Double d2 = this.mRunningAverageRssi;
            if (d2 != null) {
                d = d2.doubleValue();
            } else {
                LogManager.d(TAG, "Not using running average RSSI because it is null", new Object[0]);
            }
            this.mDistance = calculateDistance(this.mTxPower, d);
        }
        return this.mDistance.doubleValue();
    }

    public int getRssi() {
        return this.mRssi;
    }

    public int getTxPower() {
        return this.mTxPower;
    }

    public int getBeaconTypeCode() {
        return this.mBeaconTypeCode;
    }

    public String getBluetoothAddress() {
        return this.mBluetoothAddress;
    }

    public String getBluetoothName() {
        return this.mBluetoothName;
    }

    public String getParserIdentifier() {
        return this.mParserIdentifier;
    }

    public boolean isMultiFrameBeacon() {
        return this.mMultiFrameBeacon;
    }

    public int hashCode() {
        StringBuilder stringBuilder = toStringBuilder();
        if (sHardwareEqualityEnforced) {
            stringBuilder.append(this.mBluetoothAddress);
        }
        return stringBuilder.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Beacon)) {
            return false;
        }
        Beacon beacon = (Beacon) obj;
        if (!this.mIdentifiers.equals(beacon.mIdentifiers)) {
            return false;
        }
        if (sHardwareEqualityEnforced) {
            return getBluetoothAddress().equals(beacon.getBluetoothAddress());
        }
        return true;
    }

    public void requestData(BeaconDataNotifier beaconDataNotifier) {
        beaconDataFactory.requestBeaconData(this, beaconDataNotifier);
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    private StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder();
        Iterator<Identifier> it = this.mIdentifiers.iterator();
        int i = 1;
        while (it.hasNext()) {
            Identifier next = it.next();
            if (i > 1) {
                sb.append(" ");
            }
            sb.append("id");
            sb.append(i);
            sb.append(": ");
            sb.append(next == null ? Constants.NULL_VERSION_ID : next.toString());
            i++;
        }
        if (this.mParserIdentifier != null) {
            sb.append(" type " + this.mParserIdentifier);
        }
        return sb;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        String str;
        parcel.writeInt(this.mIdentifiers.size());
        for (Identifier next : this.mIdentifiers) {
            if (next == null) {
                str = null;
            } else {
                str = next.toString();
            }
            parcel.writeString(str);
        }
        parcel.writeDouble(getDistance());
        parcel.writeInt(this.mRssi);
        parcel.writeInt(this.mTxPower);
        parcel.writeString(this.mBluetoothAddress);
        parcel.writeInt(this.mBeaconTypeCode);
        parcel.writeInt(this.mServiceUuid);
        parcel.writeBoolean(this.mServiceUuid128Bit.length != 0);
        if (this.mServiceUuid128Bit.length != 0) {
            for (int i2 = 0; i2 < 16; i2++) {
                parcel.writeByte(this.mServiceUuid128Bit[i2]);
            }
        }
        parcel.writeInt(this.mDataFields.size());
        for (Long longValue : this.mDataFields) {
            parcel.writeLong(longValue.longValue());
        }
        parcel.writeInt(this.mExtraDataFields.size());
        for (Long longValue2 : this.mExtraDataFields) {
            parcel.writeLong(longValue2.longValue());
        }
        parcel.writeInt(this.mManufacturer);
        parcel.writeString(this.mBluetoothName);
        parcel.writeString(this.mParserIdentifier);
        parcel.writeByte(this.mMultiFrameBeacon ? (byte) 1 : 0);
        parcel.writeValue(this.mRunningAverageRssi);
        parcel.writeInt(this.mRssiMeasurementCount);
        parcel.writeInt(this.mPacketCount);
        parcel.writeLong(this.mFirstCycleDetectionTimestamp);
        parcel.writeLong(this.mLastCycleDetectionTimestamp);
    }

    public boolean isExtraBeaconData() {
        return this.mIdentifiers.size() == 0 && this.mDataFields.size() != 0;
    }

    protected static Double calculateDistance(int i, double d) {
        if (getDistanceCalculator() != null) {
            return Double.valueOf(getDistanceCalculator().calculateDistance(i, d));
        }
        LogManager.e(TAG, "Distance calculator not set.  Distance will bet set to -1", new Object[0]);
        return Double.valueOf(-1.0d);
    }

    public static class Builder {
        protected final Beacon mBeacon = new Beacon();
        private Identifier mId1;
        private Identifier mId2;
        private Identifier mId3;

        public Beacon build() {
            if (this.mId1 != null) {
                this.mBeacon.mIdentifiers.add(this.mId1);
                if (this.mId2 != null) {
                    this.mBeacon.mIdentifiers.add(this.mId2);
                    if (this.mId3 != null) {
                        this.mBeacon.mIdentifiers.add(this.mId3);
                    }
                }
            }
            return this.mBeacon;
        }

        public Builder copyBeaconFields(Beacon beacon) {
            setIdentifiers(beacon.getIdentifiers());
            setBeaconTypeCode(beacon.getBeaconTypeCode());
            setDataFields(beacon.getDataFields());
            setBluetoothAddress(beacon.getBluetoothAddress());
            setBluetoothName(beacon.getBluetoothName());
            setExtraDataFields(beacon.getExtraDataFields());
            setManufacturer(beacon.getManufacturer());
            setTxPower(beacon.getTxPower());
            setRssi(beacon.getRssi());
            setServiceUuid(beacon.getServiceUuid());
            setMultiFrameBeacon(beacon.isMultiFrameBeacon());
            return this;
        }

        public Builder setIdentifiers(List<Identifier> list) {
            this.mId1 = null;
            this.mId2 = null;
            this.mId3 = null;
            this.mBeacon.mIdentifiers = list;
            return this;
        }

        public Builder setId1(String str) {
            this.mId1 = Identifier.parse(str);
            return this;
        }

        public Builder setId2(String str) {
            this.mId2 = Identifier.parse(str);
            return this;
        }

        public Builder setId3(String str) {
            this.mId3 = Identifier.parse(str);
            return this;
        }

        public Builder setRssi(int i) {
            this.mBeacon.mRssi = i;
            return this;
        }

        public Builder setRunningAverageRssi(double d) {
            Double unused = this.mBeacon.mRunningAverageRssi = Double.valueOf(d);
            return this;
        }

        public Builder setTxPower(int i) {
            this.mBeacon.mTxPower = i;
            return this;
        }

        public Builder setBeaconTypeCode(int i) {
            this.mBeacon.mBeaconTypeCode = i;
            return this;
        }

        public Builder setServiceUuid(int i) {
            this.mBeacon.mServiceUuid = i;
            return this;
        }

        public Builder setServiceUuid128Bit(byte[] bArr) {
            this.mBeacon.mServiceUuid128Bit = bArr;
            return this;
        }

        public Builder setBluetoothAddress(String str) {
            this.mBeacon.mBluetoothAddress = str;
            return this;
        }

        public Builder setDataFields(List<Long> list) {
            this.mBeacon.mDataFields = list;
            return this;
        }

        public Builder setExtraDataFields(List<Long> list) {
            this.mBeacon.mExtraDataFields = list;
            return this;
        }

        public Builder setManufacturer(int i) {
            this.mBeacon.mManufacturer = i;
            return this;
        }

        public Builder setBluetoothName(String str) {
            this.mBeacon.mBluetoothName = str;
            return this;
        }

        public Builder setParserIdentifier(String str) {
            this.mBeacon.mParserIdentifier = str;
            return this;
        }

        public Builder setMultiFrameBeacon(boolean z) {
            this.mBeacon.mMultiFrameBeacon = z;
            return this;
        }
    }
}
