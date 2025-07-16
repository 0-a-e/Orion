package no.nordicsemi.android.dfu.internal;

import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;

public class ArchiveInputStream extends InputStream {
    private static final String APPLICATION_BIN = "application.bin";
    private static final String APPLICATION_HEX = "application.hex";
    private static final String APPLICATION_INIT = "application.dat";
    private static final String BOOTLOADER_BIN = "bootloader.bin";
    private static final String BOOTLOADER_HEX = "bootloader.hex";
    private static final String MANIFEST = "manifest.json";
    private static final String SOFTDEVICE_BIN = "softdevice.bin";
    private static final String SOFTDEVICE_HEX = "softdevice.hex";
    private static final String SYSTEM_INIT = "system.dat";
    private static final String TAG = "DfuArchiveInputStream";
    private byte[] applicationBytes;
    private byte[] applicationInitBytes;
    private int applicationSize;
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead;
    private int bytesReadFromCurrentSource;
    private int bytesReadFromMarkedSource;
    private final CRC32 crc32;
    private byte[] currentSource;
    private final Map<String, byte[]> entries;
    private Manifest manifest;
    private byte[] markedSource;
    private byte[] softDeviceAndBootloaderBytes;
    private byte[] softDeviceBytes;
    private int softDeviceSize;
    private byte[] systemInitBytes;
    private int type;
    private final ZipInputStream zipInputStream;

    public boolean markSupported() {
        return true;
    }

    public long skip(long j) {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x024e A[SYNTHETIC, Splitter:B:101:0x024e] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f1 A[Catch:{ all -> 0x0256 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01ff A[Catch:{ all -> 0x0256 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0220 A[Catch:{ all -> 0x0256 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x022e A[Catch:{ all -> 0x0256 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArchiveInputStream(java.io.InputStream r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "File "
            java.lang.String r1 = "SoftDevice file "
            java.lang.String r2 = "Bootloader file "
            java.lang.String r3 = "Application file "
            r9.<init>()
            int r4 = r10.available()
            r5 = 10485760(0xa00000, float:1.469368E-38)
            if (r4 > r5) goto L_0x0263
            java.util.zip.ZipInputStream r4 = new java.util.zip.ZipInputStream
            r4.<init>(r10)
            r9.zipInputStream = r4
            java.util.zip.CRC32 r10 = new java.util.zip.CRC32
            r10.<init>()
            r9.crc32 = r10
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            r9.entries = r10
            r5 = 0
            r9.bytesRead = r5
            r9.bytesReadFromCurrentSource = r5
            r9.parseZip(r11)     // Catch:{ all -> 0x0256 }
            no.nordicsemi.android.dfu.internal.manifest.Manifest r11 = r9.manifest     // Catch:{ all -> 0x0256 }
            r6 = 1
            if (r11 == 0) goto L_0x01a9
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r11 = r11.getApplicationInfo()     // Catch:{ all -> 0x0256 }
            java.lang.String r7 = " not found."
            if (r11 == 0) goto L_0x0085
            if (r12 == 0) goto L_0x0043
            r11 = r12 & 4
            if (r11 <= 0) goto L_0x0085
        L_0x0043:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r11 = r9.manifest     // Catch:{ all -> 0x0256 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r11 = r11.getApplicationInfo()     // Catch:{ all -> 0x0256 }
            java.lang.String r8 = r11.getBinFileName()     // Catch:{ all -> 0x0256 }
            java.lang.Object r8 = r10.get(r8)     // Catch:{ all -> 0x0256 }
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0256 }
            r9.applicationBytes = r8     // Catch:{ all -> 0x0256 }
            java.lang.String r8 = r11.getDatFileName()     // Catch:{ all -> 0x0256 }
            java.lang.Object r8 = r10.get(r8)     // Catch:{ all -> 0x0256 }
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0256 }
            r9.applicationInitBytes = r8     // Catch:{ all -> 0x0256 }
            byte[] r8 = r9.applicationBytes     // Catch:{ all -> 0x0256 }
            if (r8 == 0) goto L_0x006c
            int r11 = r8.length     // Catch:{ all -> 0x0256 }
            r9.applicationSize = r11     // Catch:{ all -> 0x0256 }
            r9.currentSource = r8     // Catch:{ all -> 0x0256 }
            r11 = r6
            goto L_0x0086
        L_0x006c:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0256 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0256 }
            r12.<init>(r3)     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = r11.getBinFileName()     // Catch:{ all -> 0x0256 }
            r12.append(r11)     // Catch:{ all -> 0x0256 }
            r12.append(r7)     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x0256 }
            r10.<init>(r11)     // Catch:{ all -> 0x0256 }
            throw r10     // Catch:{ all -> 0x0256 }
        L_0x0085:
            r11 = r5
        L_0x0086:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r3 = r9.manifest     // Catch:{ all -> 0x0256 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r3 = r3.getBootloaderInfo()     // Catch:{ all -> 0x0256 }
            if (r3 == 0) goto L_0x00e2
            if (r12 == 0) goto L_0x0094
            r3 = r12 & 2
            if (r3 <= 0) goto L_0x00e2
        L_0x0094:
            byte[] r11 = r9.systemInitBytes     // Catch:{ all -> 0x0256 }
            if (r11 != 0) goto L_0x00da
            no.nordicsemi.android.dfu.internal.manifest.Manifest r11 = r9.manifest     // Catch:{ all -> 0x0256 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r11 = r11.getBootloaderInfo()     // Catch:{ all -> 0x0256 }
            java.lang.String r3 = r11.getBinFileName()     // Catch:{ all -> 0x0256 }
            java.lang.Object r3 = r10.get(r3)     // Catch:{ all -> 0x0256 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0256 }
            r9.bootloaderBytes = r3     // Catch:{ all -> 0x0256 }
            java.lang.String r3 = r11.getDatFileName()     // Catch:{ all -> 0x0256 }
            java.lang.Object r3 = r10.get(r3)     // Catch:{ all -> 0x0256 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0256 }
            r9.systemInitBytes = r3     // Catch:{ all -> 0x0256 }
            byte[] r3 = r9.bootloaderBytes     // Catch:{ all -> 0x0256 }
            if (r3 == 0) goto L_0x00c1
            int r11 = r3.length     // Catch:{ all -> 0x0256 }
            r9.bootloaderSize = r11     // Catch:{ all -> 0x0256 }
            r9.currentSource = r3     // Catch:{ all -> 0x0256 }
            r11 = r6
            goto L_0x00e2
        L_0x00c1:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0256 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0256 }
            r12.<init>(r2)     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = r11.getBinFileName()     // Catch:{ all -> 0x0256 }
            r12.append(r11)     // Catch:{ all -> 0x0256 }
            r12.append(r7)     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x0256 }
            r10.<init>(r11)     // Catch:{ all -> 0x0256 }
            throw r10     // Catch:{ all -> 0x0256 }
        L_0x00da:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = "Manifest: softdevice and bootloader specified. Use softdevice_bootloader instead."
            r10.<init>(r11)     // Catch:{ all -> 0x0256 }
            throw r10     // Catch:{ all -> 0x0256 }
        L_0x00e2:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r2 = r9.manifest     // Catch:{ all -> 0x0256 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r2 = r2.getSoftdeviceInfo()     // Catch:{ all -> 0x0256 }
            if (r2 == 0) goto L_0x0132
            if (r12 == 0) goto L_0x00f0
            r2 = r12 & 1
            if (r2 <= 0) goto L_0x0132
        L_0x00f0:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r11 = r9.manifest     // Catch:{ all -> 0x0256 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r11 = r11.getSoftdeviceInfo()     // Catch:{ all -> 0x0256 }
            java.lang.String r2 = r11.getBinFileName()     // Catch:{ all -> 0x0256 }
            java.lang.Object r2 = r10.get(r2)     // Catch:{ all -> 0x0256 }
            byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x0256 }
            r9.softDeviceBytes = r2     // Catch:{ all -> 0x0256 }
            java.lang.String r2 = r11.getDatFileName()     // Catch:{ all -> 0x0256 }
            java.lang.Object r2 = r10.get(r2)     // Catch:{ all -> 0x0256 }
            byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x0256 }
            r9.systemInitBytes = r2     // Catch:{ all -> 0x0256 }
            byte[] r2 = r9.softDeviceBytes     // Catch:{ all -> 0x0256 }
            if (r2 == 0) goto L_0x0119
            int r11 = r2.length     // Catch:{ all -> 0x0256 }
            r9.softDeviceSize = r11     // Catch:{ all -> 0x0256 }
            r9.currentSource = r2     // Catch:{ all -> 0x0256 }
            r11 = r6
            goto L_0x0132
        L_0x0119:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0256 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0256 }
            r12.<init>(r1)     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = r11.getBinFileName()     // Catch:{ all -> 0x0256 }
            r12.append(r11)     // Catch:{ all -> 0x0256 }
            r12.append(r7)     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x0256 }
            r10.<init>(r11)     // Catch:{ all -> 0x0256 }
            throw r10     // Catch:{ all -> 0x0256 }
        L_0x0132:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r1 = r9.manifest     // Catch:{ all -> 0x0256 }
            no.nordicsemi.android.dfu.internal.manifest.SoftDeviceBootloaderFileInfo r1 = r1.getSoftdeviceBootloaderInfo()     // Catch:{ all -> 0x0256 }
            if (r1 == 0) goto L_0x019c
            if (r12 == 0) goto L_0x0144
            r1 = r12 & 1
            if (r1 <= 0) goto L_0x019c
            r12 = r12 & 2
            if (r12 <= 0) goto L_0x019c
        L_0x0144:
            byte[] r11 = r9.systemInitBytes     // Catch:{ all -> 0x0256 }
            if (r11 != 0) goto L_0x0194
            no.nordicsemi.android.dfu.internal.manifest.Manifest r11 = r9.manifest     // Catch:{ all -> 0x0256 }
            no.nordicsemi.android.dfu.internal.manifest.SoftDeviceBootloaderFileInfo r11 = r11.getSoftdeviceBootloaderInfo()     // Catch:{ all -> 0x0256 }
            java.lang.String r12 = r11.getBinFileName()     // Catch:{ all -> 0x0256 }
            java.lang.Object r12 = r10.get(r12)     // Catch:{ all -> 0x0256 }
            byte[] r12 = (byte[]) r12     // Catch:{ all -> 0x0256 }
            r9.softDeviceAndBootloaderBytes = r12     // Catch:{ all -> 0x0256 }
            java.lang.String r12 = r11.getDatFileName()     // Catch:{ all -> 0x0256 }
            java.lang.Object r10 = r10.get(r12)     // Catch:{ all -> 0x0256 }
            byte[] r10 = (byte[]) r10     // Catch:{ all -> 0x0256 }
            r9.systemInitBytes = r10     // Catch:{ all -> 0x0256 }
            byte[] r10 = r9.softDeviceAndBootloaderBytes     // Catch:{ all -> 0x0256 }
            if (r10 == 0) goto L_0x017b
            int r10 = r11.getSoftdeviceSize()     // Catch:{ all -> 0x0256 }
            r9.softDeviceSize = r10     // Catch:{ all -> 0x0256 }
            int r10 = r11.getBootloaderSize()     // Catch:{ all -> 0x0256 }
            r9.bootloaderSize = r10     // Catch:{ all -> 0x0256 }
            byte[] r10 = r9.softDeviceAndBootloaderBytes     // Catch:{ all -> 0x0256 }
            r9.currentSource = r10     // Catch:{ all -> 0x0256 }
            goto L_0x019d
        L_0x017b:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0256 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0256 }
            r12.<init>(r0)     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = r11.getBinFileName()     // Catch:{ all -> 0x0256 }
            r12.append(r11)     // Catch:{ all -> 0x0256 }
            r12.append(r7)     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x0256 }
            r10.<init>(r11)     // Catch:{ all -> 0x0256 }
            throw r10     // Catch:{ all -> 0x0256 }
        L_0x0194:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = "Manifest: The softdevice_bootloader may not be used together with softdevice or bootloader."
            r10.<init>(r11)     // Catch:{ all -> 0x0256 }
            throw r10     // Catch:{ all -> 0x0256 }
        L_0x019c:
            r6 = r11
        L_0x019d:
            if (r6 == 0) goto L_0x01a1
            goto L_0x0241
        L_0x01a1:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = "Manifest file must specify at least one file."
            r10.<init>(r11)     // Catch:{ all -> 0x0256 }
            throw r10     // Catch:{ all -> 0x0256 }
        L_0x01a9:
            if (r12 == 0) goto L_0x01af
            r11 = r12 & 4
            if (r11 <= 0) goto L_0x01dc
        L_0x01af:
            java.lang.String r11 = "application.hex"
            java.lang.Object r11 = r10.get(r11)     // Catch:{ all -> 0x0256 }
            byte[] r11 = (byte[]) r11     // Catch:{ all -> 0x0256 }
            r9.applicationBytes = r11     // Catch:{ all -> 0x0256 }
            if (r11 != 0) goto L_0x01c5
            java.lang.String r11 = "application.bin"
            java.lang.Object r11 = r10.get(r11)     // Catch:{ all -> 0x0256 }
            byte[] r11 = (byte[]) r11     // Catch:{ all -> 0x0256 }
            r9.applicationBytes = r11     // Catch:{ all -> 0x0256 }
        L_0x01c5:
            byte[] r11 = r9.applicationBytes     // Catch:{ all -> 0x0256 }
            if (r11 == 0) goto L_0x01dc
            int r11 = r11.length     // Catch:{ all -> 0x0256 }
            r9.applicationSize = r11     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = "application.dat"
            java.lang.Object r11 = r10.get(r11)     // Catch:{ all -> 0x0256 }
            byte[] r11 = (byte[]) r11     // Catch:{ all -> 0x0256 }
            r9.applicationInitBytes = r11     // Catch:{ all -> 0x0256 }
            byte[] r11 = r9.applicationBytes     // Catch:{ all -> 0x0256 }
            r9.currentSource = r11     // Catch:{ all -> 0x0256 }
            r11 = r6
            goto L_0x01dd
        L_0x01dc:
            r11 = r5
        L_0x01dd:
            java.lang.String r0 = "system.dat"
            if (r12 == 0) goto L_0x01e5
            r1 = r12 & 2
            if (r1 <= 0) goto L_0x020f
        L_0x01e5:
            java.lang.String r1 = "bootloader.hex"
            java.lang.Object r1 = r10.get(r1)     // Catch:{ all -> 0x0256 }
            byte[] r1 = (byte[]) r1     // Catch:{ all -> 0x0256 }
            r9.bootloaderBytes = r1     // Catch:{ all -> 0x0256 }
            if (r1 != 0) goto L_0x01fb
            java.lang.String r1 = "bootloader.bin"
            java.lang.Object r1 = r10.get(r1)     // Catch:{ all -> 0x0256 }
            byte[] r1 = (byte[]) r1     // Catch:{ all -> 0x0256 }
            r9.bootloaderBytes = r1     // Catch:{ all -> 0x0256 }
        L_0x01fb:
            byte[] r1 = r9.bootloaderBytes     // Catch:{ all -> 0x0256 }
            if (r1 == 0) goto L_0x020f
            int r11 = r1.length     // Catch:{ all -> 0x0256 }
            r9.bootloaderSize = r11     // Catch:{ all -> 0x0256 }
            java.lang.Object r11 = r10.get(r0)     // Catch:{ all -> 0x0256 }
            byte[] r11 = (byte[]) r11     // Catch:{ all -> 0x0256 }
            r9.systemInitBytes = r11     // Catch:{ all -> 0x0256 }
            byte[] r11 = r9.bootloaderBytes     // Catch:{ all -> 0x0256 }
            r9.currentSource = r11     // Catch:{ all -> 0x0256 }
            r11 = r6
        L_0x020f:
            if (r12 == 0) goto L_0x0214
            r12 = r12 & r6
            if (r12 <= 0) goto L_0x023e
        L_0x0214:
            java.lang.String r12 = "softdevice.hex"
            java.lang.Object r12 = r10.get(r12)     // Catch:{ all -> 0x0256 }
            byte[] r12 = (byte[]) r12     // Catch:{ all -> 0x0256 }
            r9.softDeviceBytes = r12     // Catch:{ all -> 0x0256 }
            if (r12 != 0) goto L_0x022a
            java.lang.String r12 = "softdevice.bin"
            java.lang.Object r12 = r10.get(r12)     // Catch:{ all -> 0x0256 }
            byte[] r12 = (byte[]) r12     // Catch:{ all -> 0x0256 }
            r9.softDeviceBytes = r12     // Catch:{ all -> 0x0256 }
        L_0x022a:
            byte[] r12 = r9.softDeviceBytes     // Catch:{ all -> 0x0256 }
            if (r12 == 0) goto L_0x023e
            int r11 = r12.length     // Catch:{ all -> 0x0256 }
            r9.softDeviceSize = r11     // Catch:{ all -> 0x0256 }
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0256 }
            byte[] r10 = (byte[]) r10     // Catch:{ all -> 0x0256 }
            r9.systemInitBytes = r10     // Catch:{ all -> 0x0256 }
            byte[] r10 = r9.softDeviceBytes     // Catch:{ all -> 0x0256 }
            r9.currentSource = r10     // Catch:{ all -> 0x0256 }
            goto L_0x023f
        L_0x023e:
            r6 = r11
        L_0x023f:
            if (r6 == 0) goto L_0x024e
        L_0x0241:
            r9.mark(r5)     // Catch:{ all -> 0x0256 }
            int r10 = r9.getContentType()
            r9.type = r10
            r4.close()
            return
        L_0x024e:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0256 }
            java.lang.String r11 = "The ZIP file must contain an Application, a Soft Device and/or a Bootloader."
            r10.<init>(r11)     // Catch:{ all -> 0x0256 }
            throw r10     // Catch:{ all -> 0x0256 }
        L_0x0256:
            r10 = move-exception
            int r11 = r9.getContentType()
            r9.type = r11
            java.util.zip.ZipInputStream r11 = r9.zipInputStream
            r11.close()
            throw r10
        L_0x0263:
            java.io.IOException r11 = new java.io.IOException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "File too large: "
            r12.<init>(r0)
            int r10 = r10.available()
            r12.append(r10)
            java.lang.String r10 = " bytes (max 10 MB)"
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.internal.ArchiveInputStream.<init>(java.io.InputStream, int, int):void");
    }

    private String validateFilename(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath.substring(1);
        }
        throw new IllegalStateException("File is outside extraction target directory.");
    }

    private void parseZip(int i) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = this.zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String validateFilename = validateFilename(nextEntry.getName(), InstructionFileId.DOT);
            if (nextEntry.isDirectory()) {
                Log.w(TAG, "A directory found in the ZIP: " + validateFilename + "!");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = this.zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (validateFilename.toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(byteArray, i);
                    byteArray = new byte[hexInputStream.available()];
                    hexInputStream.read(byteArray);
                    hexInputStream.close();
                }
                if (MANIFEST.equals(validateFilename)) {
                    str = new String(byteArray, StandardCharsets.UTF_8);
                } else {
                    this.entries.put(validateFilename, byteArray);
                }
            }
        }
        if (this.entries.isEmpty()) {
            throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
        } else if (str != null) {
            Manifest manifest2 = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
            this.manifest = manifest2;
            if (manifest2 == null) {
                Log.w(TAG, "Manifest failed to be parsed. Did you add \n-keep class no.nordicsemi.android.dfu.** { *; }\nto your proguard rules?");
            }
        } else {
            Log.w(TAG, "Manifest not found in the ZIP. It is recommended to use a distribution file created with: https://github.com/NordicSemiconductor/pc-nrfutil/ (for Legacy DFU use version 0.5.x)");
        }
    }

    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.applicationBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        this.zipInputStream.close();
    }

    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int rawRead = rawRead(bArr, i, i2);
        return (i2 <= rawRead || startNextFile() == null) ? rawRead : rawRead + rawRead(bArr, i + rawRead, i2 - rawRead);
    }

    private int rawRead(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.currentSource;
        if (bArr2 == null || i < 0 || i2 < 0) {
            return -1;
        }
        int min = Math.min(i2, bArr2.length - this.bytesReadFromCurrentSource);
        System.arraycopy(this.currentSource, this.bytesReadFromCurrentSource, bArr, i, min);
        this.bytesReadFromCurrentSource += min;
        this.bytesRead += min;
        this.crc32.update(bArr, i, min);
        return min;
    }

    public void mark(int i) {
        this.markedSource = this.currentSource;
        this.bytesReadFromMarkedSource = this.bytesReadFromCurrentSource;
    }

    public void reset() {
        int i;
        byte[] bArr;
        this.currentSource = this.markedSource;
        int i2 = this.bytesReadFromMarkedSource;
        this.bytesReadFromCurrentSource = i2;
        this.bytesRead = i2;
        this.crc32.reset();
        if (this.currentSource == this.bootloaderBytes && (bArr = this.softDeviceBytes) != null) {
            this.crc32.update(bArr);
            this.bytesRead += this.softDeviceSize;
        }
        byte[] bArr2 = this.currentSource;
        if (bArr2 != null && (i = this.bytesReadFromCurrentSource) > 0) {
            this.crc32.update(bArr2, 0, i);
        }
    }

    public void fullReset() {
        byte[] bArr;
        byte[] bArr2 = this.softDeviceBytes;
        if (!(bArr2 == null || (bArr = this.bootloaderBytes) == null || this.currentSource != bArr)) {
            this.currentSource = bArr2;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
    }

    public int getBytesRead() {
        return this.bytesRead;
    }

    public long getCrc32() {
        return this.crc32.getValue();
    }

    public int getContentType() {
        this.type = 0;
        if (this.softDeviceAndBootloaderBytes != null) {
            this.type = 3;
        }
        if (this.softDeviceSize > 0) {
            this.type |= 1;
        }
        if (this.bootloaderSize > 0) {
            this.type |= 2;
        }
        if (this.applicationSize > 0) {
            this.type |= 4;
        }
        return this.type;
    }

    public int setContentType(int i) {
        byte[] bArr;
        this.type = i;
        int i2 = i & 4;
        if (i2 > 0 && this.applicationBytes == null) {
            this.type = i & -5;
        }
        int i3 = i & 3;
        if (i3 == 3) {
            if (this.softDeviceBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
            if (this.bootloaderBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
        } else if (this.softDeviceAndBootloaderBytes != null) {
            this.type &= -4;
        }
        if (i3 > 0 && (bArr = this.softDeviceAndBootloaderBytes) != null) {
            this.currentSource = bArr;
        } else if ((i & 1) > 0) {
            this.currentSource = this.softDeviceBytes;
        } else if ((i & 2) > 0) {
            this.currentSource = this.bootloaderBytes;
        } else if (i2 > 0) {
            this.currentSource = this.applicationBytes;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
        return this.type;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        byte[] bArr2 = this.currentSource;
        if (bArr2 != this.softDeviceBytes || (bArr = this.bootloaderBytes) == null || (this.type & 2) <= 0) {
            bArr = this.applicationBytes;
            if (bArr2 == bArr || bArr == null || (this.type & 4) <= 0) {
                bArr = null;
                this.currentSource = null;
            } else {
                this.currentSource = bArr;
            }
        } else {
            this.currentSource = bArr;
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    public int available() {
        int softDeviceImageSize;
        int i;
        byte[] bArr = this.softDeviceAndBootloaderBytes;
        if (bArr == null || this.softDeviceSize != 0 || this.bootloaderSize != 0 || (this.type & 3) <= 0) {
            softDeviceImageSize = softDeviceImageSize() + bootloaderImageSize() + applicationImageSize();
            i = this.bytesRead;
        } else {
            softDeviceImageSize = bArr.length + applicationImageSize();
            i = this.bytesRead;
        }
        return softDeviceImageSize - i;
    }

    public int softDeviceImageSize() {
        if ((this.type & 1) > 0) {
            return this.softDeviceSize;
        }
        return 0;
    }

    public int bootloaderImageSize() {
        if ((this.type & 2) > 0) {
            return this.bootloaderSize;
        }
        return 0;
    }

    public int applicationImageSize() {
        if ((this.type & 4) > 0) {
            return this.applicationSize;
        }
        return 0;
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }

    public boolean isSecureDfuRequired() {
        Manifest manifest2 = this.manifest;
        return manifest2 != null && manifest2.isSecureDfuRequired();
    }
}
