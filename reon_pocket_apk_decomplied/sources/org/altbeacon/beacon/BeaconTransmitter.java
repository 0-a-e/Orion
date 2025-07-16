package org.altbeacon.beacon;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.os.ParcelUuid;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import org.altbeacon.beacon.logging.LogManager;

public class BeaconTransmitter {
    public static final int NOT_SUPPORTED_BLE = 2;
    public static final int NOT_SUPPORTED_CANNOT_GET_ADVERTISER = 4;
    public static final int NOT_SUPPORTED_CANNOT_GET_ADVERTISER_MULTIPLE_ADVERTISEMENTS = 5;
    public static final int NOT_SUPPORTED_MIN_SDK = 1;
    @Deprecated
    public static final int NOT_SUPPORTED_MULTIPLE_ADVERTISEMENTS = 3;
    public static final int SUPPORTED = 0;
    private static final String TAG = "BeaconTransmitter";
    private AdvertiseCallback mAdvertiseCallback;
    private int mAdvertiseMode = 0;
    private int mAdvertiseTxPowerLevel = 3;
    /* access modifiers changed from: private */
    public AdvertiseCallback mAdvertisingClientCallback;
    private Beacon mBeacon;
    private BeaconParser mBeaconParser;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    private boolean mConnectable = false;
    /* access modifiers changed from: private */
    public boolean mStarted;

    public BeaconTransmitter(Context context, BeaconParser beaconParser) {
        this.mBeaconParser = beaconParser;
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            this.mBluetoothAdapter = adapter;
            BluetoothLeAdvertiser bluetoothLeAdvertiser = adapter.getBluetoothLeAdvertiser();
            this.mBluetoothLeAdvertiser = bluetoothLeAdvertiser;
            LogManager.d(TAG, "new BeaconTransmitter constructed.  mbluetoothLeAdvertiser is %s", bluetoothLeAdvertiser);
            return;
        }
        LogManager.e(TAG, "Failed to get BluetoothManager", new Object[0]);
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void setBeacon(Beacon beacon) {
        this.mBeacon = beacon;
    }

    public void setBeaconParser(BeaconParser beaconParser) {
        this.mBeaconParser = beaconParser;
    }

    public int getAdvertiseMode() {
        return this.mAdvertiseMode;
    }

    public void setAdvertiseMode(int i) {
        this.mAdvertiseMode = i;
    }

    public int getAdvertiseTxPowerLevel() {
        return this.mAdvertiseTxPowerLevel;
    }

    public void setAdvertiseTxPowerLevel(int i) {
        this.mAdvertiseTxPowerLevel = i;
    }

    public void setConnectable(boolean z) {
        this.mConnectable = z;
    }

    public boolean isConnectable() {
        return this.mConnectable;
    }

    public void startAdvertising(Beacon beacon) {
        startAdvertising(beacon, (AdvertiseCallback) null);
    }

    public void startAdvertising(Beacon beacon, AdvertiseCallback advertiseCallback) {
        this.mBeacon = beacon;
        this.mAdvertisingClientCallback = advertiseCallback;
        startAdvertising();
    }

    public void startAdvertising() {
        Beacon beacon = this.mBeacon;
        if (beacon != null) {
            int manufacturer = beacon.getManufacturer();
            int intValue = this.mBeaconParser.getServiceUuid() != null ? this.mBeaconParser.getServiceUuid().intValue() : -1;
            BeaconParser beaconParser = this.mBeaconParser;
            if (beaconParser != null) {
                byte[] beaconAdvertisementData = beaconParser.getBeaconAdvertisementData(this.mBeacon);
                Object obj = "";
                String str = obj;
                for (int i = 0; i < beaconAdvertisementData.length; i++) {
                    str = (str + String.format("%02X", new Object[]{Byte.valueOf(beaconAdvertisementData[i])})) + " ";
                }
                Identifier id1 = this.mBeacon.getId1();
                Object id2 = this.mBeacon.getIdentifiers().size() > 1 ? this.mBeacon.getId2() : obj;
                Object obj2 = obj;
                if (this.mBeacon.getIdentifiers().size() > 2) {
                    obj2 = this.mBeacon.getId3();
                }
                LogManager.d(TAG, "Starting advertising with ID1: %s ID2: %s ID3: %s and data: %s of size %s", id1, id2, obj2, str, Integer.valueOf(beaconAdvertisementData.length));
                try {
                    AdvertiseData.Builder builder = new AdvertiseData.Builder();
                    if (intValue > 0) {
                        ParcelUuid parseUuidFrom = parseUuidFrom(new byte[]{(byte) (intValue & 255), (byte) ((intValue >> 8) & 255)});
                        builder.addServiceData(parseUuidFrom, beaconAdvertisementData);
                        builder.addServiceUuid(parseUuidFrom);
                        builder.setIncludeTxPowerLevel(false);
                        builder.setIncludeDeviceName(false);
                    } else {
                        builder.addManufacturerData(manufacturer, beaconAdvertisementData);
                    }
                    AdvertiseSettings.Builder builder2 = new AdvertiseSettings.Builder();
                    builder2.setAdvertiseMode(this.mAdvertiseMode);
                    builder2.setTxPowerLevel(this.mAdvertiseTxPowerLevel);
                    builder2.setConnectable(this.mConnectable);
                    this.mBluetoothLeAdvertiser.startAdvertising(builder2.build(), builder.build(), getAdvertiseCallback());
                    LogManager.d(TAG, "Started advertisement with callback: %s", getAdvertiseCallback());
                } catch (Exception e) {
                    LogManager.e(e, TAG, "Cannot start advertising due to exception", new Object[0]);
                }
            } else {
                throw new NullPointerException("You must supply a BeaconParser instance to BeaconTransmitter.");
            }
        } else {
            throw new NullPointerException("Beacon cannot be null.  Set beacon before starting advertising");
        }
    }

    public void stopAdvertising() {
        if (!this.mStarted) {
            LogManager.d(TAG, "Skipping stop advertising -- not started", new Object[0]);
            return;
        }
        LogManager.d(TAG, "Stopping advertising with object %s", this.mBluetoothLeAdvertiser);
        this.mAdvertisingClientCallback = null;
        try {
            this.mBluetoothLeAdvertiser.stopAdvertising(getAdvertiseCallback());
        } catch (IllegalStateException unused) {
            LogManager.w(TAG, "Bluetooth is turned off. Transmitter stop call failed.", new Object[0]);
        }
        this.mStarted = false;
    }

    public static int checkTransmissionSupported(Context context) {
        if (!context.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return 2;
        }
        try {
            if (((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().getBluetoothLeAdvertiser() != null) {
                return 0;
            }
            if (!((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isMultipleAdvertisementSupported()) {
                return 5;
            }
            return 4;
        } catch (Exception unused) {
        }
    }

    private AdvertiseCallback getAdvertiseCallback() {
        if (this.mAdvertiseCallback == null) {
            this.mAdvertiseCallback = new AdvertiseCallback() {
                public void onStartFailure(int i) {
                    LogManager.e(BeaconTransmitter.TAG, "Advertisement start failed, code: %s", Integer.valueOf(i));
                    if (BeaconTransmitter.this.mAdvertisingClientCallback != null) {
                        BeaconTransmitter.this.mAdvertisingClientCallback.onStartFailure(i);
                    }
                }

                public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                    LogManager.i(BeaconTransmitter.TAG, "Advertisement start succeeded.", new Object[0]);
                    boolean unused = BeaconTransmitter.this.mStarted = true;
                    if (BeaconTransmitter.this.mAdvertisingClientCallback != null) {
                        BeaconTransmitter.this.mAdvertisingClientCallback.onStartSuccess(advertiseSettings);
                    }
                }
            };
        }
        return this.mAdvertiseCallback;
    }

    private static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j;
        ParcelUuid fromString = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + length);
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
                } else {
                    j = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
                }
                return new ParcelUuid(new UUID(fromString.getUuid().getMostSignificantBits() + (j << 32), fromString.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }
}
