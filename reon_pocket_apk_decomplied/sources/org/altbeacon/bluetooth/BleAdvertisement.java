package org.altbeacon.bluetooth;

import java.util.ArrayList;
import java.util.List;

public class BleAdvertisement {
    private static final String TAG = "BleAdvertisement";
    private byte[] mBytes;
    private List<Pdu> mPdus;

    public BleAdvertisement(byte[] bArr) {
        this.mBytes = bArr;
        ArrayList arrayList = new ArrayList();
        parsePdus(0, bArr.length < 31 ? bArr.length : 31, arrayList);
        if (bArr.length > 31) {
            parsePdus(31, bArr.length, arrayList);
        }
        this.mPdus = arrayList;
    }

    private void parsePdus(int i, int i2, ArrayList<Pdu> arrayList) {
        do {
            Pdu parse = Pdu.parse(this.mBytes, i);
            if (parse != null) {
                i = i + parse.getDeclaredLength() + 1;
                arrayList.add(parse);
            }
            if (parse == null) {
                return;
            }
        } while (i < i2);
    }

    public List<Pdu> getPdus() {
        return this.mPdus;
    }
}
