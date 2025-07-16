package org.altbeacon.beacon.service.scanner;

import android.bluetooth.le.ScanFilter;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.Region;

public class ScanFilterUtils {
    public static final String TAG = "ScanFilterUtils";

    class ScanFilterData {
        public byte[] filter;
        public int manufacturer;
        public byte[] mask;
        public Long serviceUuid = null;
        public byte[] serviceUuid128Bit = new byte[0];

        ScanFilterData() {
        }
    }

    public List<ScanFilter> createWildcardScanFilters() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanFilter.Builder().build());
        return arrayList;
    }

    public List<ScanFilterData> createScanFilterDataForBeaconParser(BeaconParser beaconParser, List<Identifier> list) {
        List<Identifier> list2 = list;
        ArrayList arrayList = new ArrayList();
        long longValue = beaconParser.getMatchingBeaconTypeCode().longValue();
        int matchingBeaconTypeCodeStartOffset = beaconParser.getMatchingBeaconTypeCodeStartOffset();
        int matchingBeaconTypeCodeEndOffset = beaconParser.getMatchingBeaconTypeCodeEndOffset();
        byte[] longToByteArray = BeaconParser.longToByteArray(longValue, (matchingBeaconTypeCodeEndOffset - matchingBeaconTypeCodeStartOffset) + 1);
        if (list2 != null && list.size() > 0 && list2.get(0) != null && beaconParser.getMatchingBeaconTypeCode().longValue() == 533) {
            int[] hardwareAssistManufacturers = beaconParser.getHardwareAssistManufacturers();
            if (hardwareAssistManufacturers.length > 0) {
                int i = hardwareAssistManufacturers[0];
                ScanFilterData scanFilterData = new ScanFilterData();
                scanFilterData.manufacturer = i;
                int i2 = list.size() == 2 ? 20 : 18;
                if (list.size() == 3) {
                    i2 = 22;
                }
                scanFilterData.filter = new byte[i2];
                scanFilterData.filter[0] = longToByteArray[0];
                scanFilterData.filter[1] = longToByteArray[1];
                byte[] byteArray = list2.get(0).toByteArray();
                for (int i3 = 0; i3 < byteArray.length; i3++) {
                    scanFilterData.filter[i3 + 2] = byteArray[i3];
                }
                if (list.size() > 1 && list2.get(1) != null) {
                    byte[] byteArray2 = list2.get(1).toByteArray();
                    for (int i4 = 0; i4 < byteArray2.length; i4++) {
                        scanFilterData.filter[i4 + 18] = byteArray2[i4];
                    }
                }
                if (list.size() > 2 && list2.get(2) != null) {
                    byte[] byteArray3 = list2.get(2).toByteArray();
                    for (int i5 = 0; i5 < byteArray3.length; i5++) {
                        scanFilterData.filter[i5 + 20] = byteArray3[i5];
                    }
                }
                scanFilterData.mask = new byte[i2];
                for (int i6 = 0; i6 < i2; i6++) {
                    scanFilterData.mask[i6] = -1;
                }
                scanFilterData.serviceUuid = null;
                scanFilterData.serviceUuid128Bit = new byte[0];
                arrayList.add(scanFilterData);
                return arrayList;
            }
        }
        for (int i7 : beaconParser.getHardwareAssistManufacturers()) {
            ScanFilterData scanFilterData2 = new ScanFilterData();
            Long serviceUuid = beaconParser.getServiceUuid();
            int i8 = matchingBeaconTypeCodeEndOffset - 1;
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            if (i8 > 0) {
                bArr = new byte[i8];
                bArr2 = new byte[i8];
                for (int i9 = 2; i9 <= matchingBeaconTypeCodeEndOffset; i9++) {
                    int i10 = i9 - 2;
                    if (i9 < matchingBeaconTypeCodeStartOffset) {
                        bArr[i10] = 0;
                        bArr2[i10] = 0;
                    } else {
                        bArr[i10] = longToByteArray[i9 - matchingBeaconTypeCodeStartOffset];
                        bArr2[i10] = -1;
                    }
                }
            }
            scanFilterData2.manufacturer = i7;
            scanFilterData2.filter = bArr;
            scanFilterData2.mask = bArr2;
            scanFilterData2.serviceUuid = serviceUuid;
            scanFilterData2.serviceUuid128Bit = beaconParser.getServiceUuid128Bit();
            arrayList.add(scanFilterData2);
        }
        return arrayList;
    }

    public List<ScanFilter> createScanFiltersForBeaconParsers(List<BeaconParser> list) {
        return createScanFiltersForBeaconParsers(list, (List<Region>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.bluetooth.le.ScanFilter> createScanFiltersForBeaconParsers(java.util.List<org.altbeacon.beacon.BeaconParser> r17, java.util.List<org.altbeacon.beacon.Region> r18) {
        /*
            r16 = this;
            r0 = r18
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            if (r0 != 0) goto L_0x000e
            r1.add(r2)
            goto L_0x0011
        L_0x000e:
            r1.addAll(r0)
        L_0x0011:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x001a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0155
            java.lang.Object r3 = r1.next()
            org.altbeacon.beacon.Region r3 = (org.altbeacon.beacon.Region) r3
            java.util.Iterator r4 = r17.iterator()
        L_0x002a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0151
            java.lang.Object r5 = r4.next()
            org.altbeacon.beacon.BeaconParser r5 = (org.altbeacon.beacon.BeaconParser) r5
            if (r3 != 0) goto L_0x003c
            r7 = r16
            r6 = r2
            goto L_0x0042
        L_0x003c:
            java.util.List r6 = r3.getIdentifiers()
            r7 = r16
        L_0x0042:
            java.util.List r5 = r7.createScanFilterDataForBeaconParser(r5, r6)
            java.util.Iterator r5 = r5.iterator()
        L_0x004a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x002a
            java.lang.Object r6 = r5.next()
            org.altbeacon.beacon.service.scanner.ScanFilterUtils$ScanFilterData r6 = (org.altbeacon.beacon.service.scanner.ScanFilterUtils.ScanFilterData) r6
            android.bluetooth.le.ScanFilter$Builder r8 = new android.bluetooth.le.ScanFilter$Builder
            r8.<init>()
            java.lang.Long r9 = r6.serviceUuid
            java.lang.String r10 = "making scan filter with service mask: FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF "
            java.lang.String r11 = "making scan filter for service: "
            java.lang.String r12 = "FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF"
            r13 = 1
            java.lang.String r14 = " "
            java.lang.String r15 = "ScanFilterUtils"
            r2 = 0
            if (r9 == 0) goto L_0x00b3
            java.lang.Long r6 = r6.serviceUuid
            java.lang.Object[] r9 = new java.lang.Object[r13]
            r9[r2] = r6
            java.lang.String r6 = "0000%04X-0000-1000-8000-00805f9b34fb"
            java.lang.String r6 = java.lang.String.format(r6, r9)
            android.os.ParcelUuid r9 = android.os.ParcelUuid.fromString(r6)
            android.os.ParcelUuid r12 = android.os.ParcelUuid.fromString(r12)
            boolean r13 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r13 == 0) goto L_0x00ad
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r13.append(r6)
            r13.append(r14)
            r13.append(r9)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r11 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r15, r6, r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r10)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r10 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r15, r6, r10)
        L_0x00ad:
            r8.setServiceUuid(r9, r12)
        L_0x00b0:
            r9 = 0
            goto L_0x012e
        L_0x00b3:
            byte[] r9 = r6.serviceUuid128Bit
            int r9 = r9.length
            if (r9 == 0) goto L_0x00fe
            byte[] r6 = r6.serviceUuid128Bit
            r9 = 16
            org.altbeacon.beacon.Identifier r6 = org.altbeacon.beacon.Identifier.fromBytes(r6, r2, r9, r13)
            java.lang.String r6 = r6.toString()
            android.os.ParcelUuid r9 = android.os.ParcelUuid.fromString(r6)
            android.os.ParcelUuid r12 = android.os.ParcelUuid.fromString(r12)
            boolean r13 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r13 == 0) goto L_0x00fa
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r13.append(r6)
            r13.append(r14)
            r13.append(r9)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r11 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r15, r6, r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r10)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r10 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r15, r6, r10)
        L_0x00fa:
            r8.setServiceUuid(r9, r12)
            goto L_0x00b0
        L_0x00fe:
            r9 = 0
            r8.setServiceUuid(r9)
            int r10 = r6.manufacturer
            byte[] r11 = r6.filter
            byte[] r12 = r6.mask
            r8.setManufacturerData(r10, r11, r12)
            boolean r10 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r10 == 0) goto L_0x012e
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "making scan filter for manufacturer: "
            r10.<init>(r11)
            int r11 = r6.manufacturer
            r10.append(r11)
            r10.append(r14)
            byte[] r6 = r6.filter
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            java.lang.Object[] r10 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r15, r6, r10)
        L_0x012e:
            android.bluetooth.le.ScanFilter r6 = r8.build()
            boolean r8 = org.altbeacon.beacon.logging.LogManager.isVerboseLoggingEnabled()
            if (r8 == 0) goto L_0x014b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "Set up a scan filter: "
            r8.<init>(r10)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r15, r8, r2)
        L_0x014b:
            r0.add(r6)
            r2 = r9
            goto L_0x004a
        L_0x0151:
            r7 = r16
            goto L_0x001a
        L_0x0155:
            r7 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.service.scanner.ScanFilterUtils.createScanFiltersForBeaconParsers(java.util.List, java.util.List):java.util.List");
    }
}
