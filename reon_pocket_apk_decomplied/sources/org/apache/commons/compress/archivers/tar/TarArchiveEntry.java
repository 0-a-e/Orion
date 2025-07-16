package org.apache.commons.compress.archivers.tar;

import androidx.appcompat.app.AppCompatDelegate;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;

public class TarArchiveEntry implements ArchiveEntry, TarConstants {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    private static final TarArchiveEntry[] EMPTY_TAR_ARCHIVE_ENTRIES = new TarArchiveEntry[0];
    public static final int MAX_NAMELEN = 31;
    public static final int MILLIS_PER_SECOND = 1000;
    public static final long UNKNOWN = -1;
    private boolean checkSumOK;
    private int devMajor;
    private int devMinor;
    private final Map<String, String> extraPaxHeaders;
    private final File file;
    private long groupId;
    private String groupName;
    private boolean isExtended;
    private byte linkFlag;
    private String linkName;
    private String magic;
    private long modTime;
    private int mode;
    private String name;
    private boolean paxGNUSparse;
    private final boolean preserveAbsolutePath;
    private long realSize;
    private long size;
    private boolean starSparse;
    private long userId;
    private String userName;
    private String version;

    private TarArchiveEntry(boolean z) {
        this.name = "";
        this.userId = 0;
        this.groupId = 0;
        this.size = 0;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        this.extraPaxHeaders = new HashMap();
        String property = System.getProperty("user.name", "");
        this.userName = property.length() > 31 ? property.substring(0, 31) : property;
        this.file = null;
        this.preserveAbsolutePath = z;
    }

    public TarArchiveEntry(String str) {
        this(str, false);
    }

    public TarArchiveEntry(String str, boolean z) {
        this(z);
        String normalizeFileName = normalizeFileName(str, z);
        boolean endsWith = normalizeFileName.endsWith("/");
        this.name = normalizeFileName;
        this.mode = endsWith ? DEFAULT_DIR_MODE : DEFAULT_FILE_MODE;
        this.linkFlag = endsWith ? TarConstants.LF_DIR : TarConstants.LF_NORMAL;
        this.modTime = new Date().getTime() / 1000;
        this.userName = "";
    }

    public TarArchiveEntry(String str, byte b) {
        this(str, b, false);
    }

    public TarArchiveEntry(String str, byte b, boolean z) {
        this(str, z);
        this.linkFlag = b;
        if (b == 76) {
            this.magic = TarConstants.MAGIC_GNU;
            this.version = TarConstants.VERSION_GNU_SPACE;
        }
    }

    public TarArchiveEntry(File file2) {
        this(file2, file2.getPath());
    }

    public TarArchiveEntry(File file2, String str) {
        this.name = "";
        this.userId = 0;
        this.groupId = 0;
        this.size = 0;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        this.extraPaxHeaders = new HashMap();
        String normalizeFileName = normalizeFileName(str, false);
        this.file = file2;
        if (file2.isDirectory()) {
            this.mode = DEFAULT_DIR_MODE;
            this.linkFlag = TarConstants.LF_DIR;
            int length = normalizeFileName.length();
            if (length == 0 || normalizeFileName.charAt(length - 1) != '/') {
                this.name = normalizeFileName + "/";
            } else {
                this.name = normalizeFileName;
            }
        } else {
            this.mode = DEFAULT_FILE_MODE;
            this.linkFlag = TarConstants.LF_NORMAL;
            this.size = file2.length();
            this.name = normalizeFileName;
        }
        this.modTime = file2.lastModified() / 1000;
        this.userName = "";
        this.preserveAbsolutePath = false;
    }

    public TarArchiveEntry(byte[] bArr) {
        this(false);
        parseTarHeader(bArr);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        this(bArr, zipEncoding, false);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding, boolean z) throws IOException {
        this(false);
        parseTarHeader(bArr, zipEncoding, false, z);
    }

    public boolean equals(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry != null && getName().equals(tarArchiveEntry.getName());
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return equals((TarArchiveEntry) obj);
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isDescendent(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry.getName().startsWith(getName());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = normalizeFileName(str, this.preserveAbsolutePath);
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public void setLinkName(String str) {
        this.linkName = str;
    }

    @Deprecated
    public int getUserId() {
        return (int) this.userId;
    }

    public void setUserId(int i) {
        setUserId((long) i);
    }

    public long getLongUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    @Deprecated
    public int getGroupId() {
        return (int) this.groupId;
    }

    public void setGroupId(int i) {
        setGroupId((long) i);
    }

    public long getLongGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIds(int i, int i2) {
        setUserId(i);
        setGroupId(i2);
    }

    public void setNames(String str, String str2) {
        setUserName(str);
        setGroupName(str2);
    }

    public void setModTime(long j) {
        this.modTime = j / 1000;
    }

    public void setModTime(Date date) {
        this.modTime = date.getTime() / 1000;
    }

    public Date getModTime() {
        return new Date(this.modTime * 1000);
    }

    public Date getLastModifiedDate() {
        return getModTime();
    }

    public boolean isCheckSumOK() {
        return this.checkSumOK;
    }

    public File getFile() {
        return this.file;
    }

    public int getMode() {
        return this.mode;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        if (j >= 0) {
            this.size = j;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j);
    }

    public int getDevMajor() {
        return this.devMajor;
    }

    public void setDevMajor(int i) {
        if (i >= 0) {
            this.devMajor = i;
            return;
        }
        throw new IllegalArgumentException("Major device number is out of range: " + i);
    }

    public int getDevMinor() {
        return this.devMinor;
    }

    public void setDevMinor(int i) {
        if (i >= 0) {
            this.devMinor = i;
            return;
        }
        throw new IllegalArgumentException("Minor device number is out of range: " + i);
    }

    public boolean isExtended() {
        return this.isExtended;
    }

    public long getRealSize() {
        return this.realSize;
    }

    public boolean isGNUSparse() {
        return isOldGNUSparse() || isPaxGNUSparse();
    }

    public boolean isOldGNUSparse() {
        return this.linkFlag == 83;
    }

    public boolean isPaxGNUSparse() {
        return this.paxGNUSparse;
    }

    public boolean isStarSparse() {
        return this.starSparse;
    }

    public boolean isGNULongLinkEntry() {
        return this.linkFlag == 75;
    }

    public boolean isGNULongNameEntry() {
        return this.linkFlag == 76;
    }

    public boolean isPaxHeader() {
        byte b = this.linkFlag;
        return b == 120 || b == 88;
    }

    public boolean isGlobalPaxHeader() {
        return this.linkFlag == 103;
    }

    public boolean isDirectory() {
        File file2 = this.file;
        if (file2 != null) {
            return file2.isDirectory();
        }
        if (this.linkFlag == 53) {
            return true;
        }
        if (isPaxHeader() || isGlobalPaxHeader() || !getName().endsWith("/")) {
            return false;
        }
        return true;
    }

    public boolean isFile() {
        File file2 = this.file;
        if (file2 != null) {
            return file2.isFile();
        }
        byte b = this.linkFlag;
        if (b == 0 || b == 48) {
            return true;
        }
        return !getName().endsWith("/");
    }

    public boolean isSymbolicLink() {
        return this.linkFlag == 50;
    }

    public boolean isLink() {
        return this.linkFlag == 49;
    }

    public boolean isCharacterDevice() {
        return this.linkFlag == 51;
    }

    public boolean isBlockDevice() {
        return this.linkFlag == 52;
    }

    public boolean isFIFO() {
        return this.linkFlag == 54;
    }

    public boolean isSparse() {
        return isGNUSparse() || isStarSparse();
    }

    public Map<String, String> getExtraPaxHeaders() {
        return Collections.unmodifiableMap(this.extraPaxHeaders);
    }

    public void clearExtraPaxHeaders() {
        this.extraPaxHeaders.clear();
    }

    public void addPaxHeader(String str, String str2) {
        processPaxHeader(str, str2);
    }

    public String getExtraPaxHeader(String str) {
        return this.extraPaxHeaders.get(str);
    }

    /* access modifiers changed from: package-private */
    public void updateEntryFromPaxHeaders(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            processPaxHeader((String) next.getKey(), (String) next.getValue(), map);
        }
    }

    private void processPaxHeader(String str, String str2) {
        processPaxHeader(str, str2, this.extraPaxHeaders);
    }

    private void processPaxHeader(String str, String str2, Map<String, String> map) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1916861932:
                if (str.equals("SCHILY.devmajor")) {
                    c = 0;
                    break;
                }
                break;
            case -1916619760:
                if (str.equals("SCHILY.devminor")) {
                    c = 1;
                    break;
                }
                break;
            case -277496563:
                if (str.equals("GNU.sparse.realsize")) {
                    c = 2;
                    break;
                }
                break;
            case -160380561:
                if (str.equals("GNU.sparse.size")) {
                    c = 3;
                    break;
                }
                break;
            case 102338:
                if (str.equals("gid")) {
                    c = 4;
                    break;
                }
                break;
            case 115792:
                if (str.equals("uid")) {
                    c = 5;
                    break;
                }
                break;
            case 3433509:
                if (str.equals("path")) {
                    c = 6;
                    break;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    c = 7;
                    break;
                }
                break;
            case 98496370:
                if (str.equals("gname")) {
                    c = 8;
                    break;
                }
                break;
            case 104223930:
                if (str.equals("mtime")) {
                    c = 9;
                    break;
                }
                break;
            case 111425664:
                if (str.equals("uname")) {
                    c = 10;
                    break;
                }
                break;
            case 530706950:
                if (str.equals("SCHILY.filetype")) {
                    c = 11;
                    break;
                }
                break;
            case 1195018015:
                if (str.equals("linkpath")) {
                    c = 12;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setDevMajor(Integer.parseInt(str2));
                return;
            case 1:
                setDevMinor(Integer.parseInt(str2));
                return;
            case 2:
                fillGNUSparse1xData(map);
                return;
            case 3:
                fillGNUSparse0xData(map);
                return;
            case 4:
                setGroupId(Long.parseLong(str2));
                return;
            case 5:
                setUserId(Long.parseLong(str2));
                return;
            case 6:
                setName(str2);
                return;
            case 7:
                setSize(Long.parseLong(str2));
                return;
            case 8:
                setGroupName(str2);
                return;
            case 9:
                setModTime((long) (Double.parseDouble(str2) * 1000.0d));
                return;
            case 10:
                setUserName(str2);
                return;
            case 11:
                if ("sparse".equals(str2)) {
                    fillStarSparseData(map);
                    return;
                }
                return;
            case 12:
                setLinkName(str2);
                return;
            default:
                this.extraPaxHeaders.put(str, str2);
                return;
        }
    }

    public TarArchiveEntry[] getDirectoryEntries() {
        File file2 = this.file;
        if (file2 == null || !file2.isDirectory()) {
            return EMPTY_TAR_ARCHIVE_ENTRIES;
        }
        String[] list = this.file.list();
        if (list == null) {
            return EMPTY_TAR_ARCHIVE_ENTRIES;
        }
        int length = list.length;
        TarArchiveEntry[] tarArchiveEntryArr = new TarArchiveEntry[length];
        for (int i = 0; i < length; i++) {
            tarArchiveEntryArr[i] = new TarArchiveEntry(new File(this.file, list[i]));
        }
        return tarArchiveEntryArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeEntryHeader(byte[] r3) {
        /*
            r2 = this;
            r0 = 0
            org.apache.commons.compress.archivers.zip.ZipEncoding r1 = org.apache.commons.compress.archivers.tar.TarUtils.DEFAULT_ENCODING     // Catch:{ IOException -> 0x0007 }
            r2.writeEntryHeader(r3, r1, r0)     // Catch:{ IOException -> 0x0007 }
            goto L_0x000c
        L_0x0007:
            org.apache.commons.compress.archivers.zip.ZipEncoding r1 = org.apache.commons.compress.archivers.tar.TarUtils.FALLBACK_ENCODING     // Catch:{ IOException -> 0x000d }
            r2.writeEntryHeader(r3, r1, r0)     // Catch:{ IOException -> 0x000d }
        L_0x000c:
            return
        L_0x000d:
            r3 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarArchiveEntry.writeEntryHeader(byte[]):void");
    }

    public void writeEntryHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z) throws IOException {
        byte[] bArr2 = bArr;
        ZipEncoding zipEncoding2 = zipEncoding;
        byte[] bArr3 = bArr;
        boolean z2 = z;
        int writeEntryHeaderField = writeEntryHeaderField(this.modTime, bArr3, writeEntryHeaderField(this.size, bArr3, writeEntryHeaderField(this.groupId, bArr3, writeEntryHeaderField(this.userId, bArr3, writeEntryHeaderField((long) this.mode, bArr3, TarUtils.formatNameBytes(this.name, bArr, 0, 100, zipEncoding2), 8, z2), 8, z2), 8, z2), 12, z2), 12, z2);
        int i = 0;
        int i2 = writeEntryHeaderField;
        while (i < 8) {
            bArr2[i2] = 32;
            i++;
            i2++;
        }
        bArr2[i2] = this.linkFlag;
        byte[] bArr4 = bArr;
        boolean z3 = z;
        for (int writeEntryHeaderField2 = writeEntryHeaderField((long) this.devMinor, bArr4, writeEntryHeaderField((long) this.devMajor, bArr4, TarUtils.formatNameBytes(this.groupName, bArr, TarUtils.formatNameBytes(this.userName, bArr, TarUtils.formatNameBytes(this.version, bArr, TarUtils.formatNameBytes(this.magic, bArr, TarUtils.formatNameBytes(this.linkName, bArr, i2 + 1, 100, zipEncoding2), 6), 2), 32, zipEncoding2), 32, zipEncoding2), 8, z3), 8, z3); writeEntryHeaderField2 < bArr2.length; writeEntryHeaderField2++) {
            bArr2[writeEntryHeaderField2] = 0;
        }
        TarUtils.formatCheckSumOctalBytes(TarUtils.computeCheckSum(bArr), bArr, writeEntryHeaderField, 8);
    }

    private int writeEntryHeaderField(long j, byte[] bArr, int i, int i2, boolean z) {
        if (z || (j >= 0 && j < (1 << ((i2 - 1) * 3)))) {
            return TarUtils.formatLongOctalOrBinaryBytes(j, bArr, i, i2);
        }
        return TarUtils.formatLongOctalBytes(0, bArr, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0006 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseTarHeader(byte[] r4) {
        /*
            r3 = this;
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = org.apache.commons.compress.archivers.tar.TarUtils.DEFAULT_ENCODING     // Catch:{ IOException -> 0x0006 }
            r3.parseTarHeader(r4, r0)     // Catch:{ IOException -> 0x0006 }
            goto L_0x000d
        L_0x0006:
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = org.apache.commons.compress.archivers.tar.TarUtils.DEFAULT_ENCODING     // Catch:{ IOException -> 0x000e }
            r1 = 1
            r2 = 0
            r3.parseTarHeader(r4, r0, r1, r2)     // Catch:{ IOException -> 0x000e }
        L_0x000d:
            return
        L_0x000e:
            r4 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarArchiveEntry.parseTarHeader(byte[]):void");
    }

    public void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        parseTarHeader(bArr, zipEncoding, false, false);
    }

    private void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z, boolean z2) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (z) {
            str = TarUtils.parseName(bArr, 0, 100);
        } else {
            str = TarUtils.parseName(bArr, 0, 100, zipEncoding);
        }
        this.name = str;
        this.mode = (int) parseOctalOrBinary(bArr, 100, 8, z2);
        this.userId = (long) ((int) parseOctalOrBinary(bArr, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 8, z2));
        this.groupId = (long) ((int) parseOctalOrBinary(bArr, 116, 8, z2));
        this.size = TarUtils.parseOctalOrBinary(bArr, 124, 12);
        this.modTime = parseOctalOrBinary(bArr, 136, 12, z2);
        this.checkSumOK = TarUtils.verifyCheckSum(bArr);
        this.linkFlag = bArr[156];
        if (z) {
            str2 = TarUtils.parseName(bArr, 157, 100);
        } else {
            str2 = TarUtils.parseName(bArr, 157, 100, zipEncoding);
        }
        this.linkName = str2;
        this.magic = TarUtils.parseName(bArr, 257, 6);
        this.version = TarUtils.parseName(bArr, TarConstants.VERSION_OFFSET, 2);
        if (z) {
            str3 = TarUtils.parseName(bArr, 265, 32);
        } else {
            str3 = TarUtils.parseName(bArr, 265, 32, zipEncoding);
        }
        this.userName = str3;
        if (z) {
            str4 = TarUtils.parseName(bArr, 297, 32);
        } else {
            str4 = TarUtils.parseName(bArr, 297, 32, zipEncoding);
        }
        this.groupName = str4;
        byte b = this.linkFlag;
        if (b == 51 || b == 52) {
            this.devMajor = (int) parseOctalOrBinary(bArr, 329, 8, z2);
            this.devMinor = (int) parseOctalOrBinary(bArr, 337, 8, z2);
        }
        int evaluateType = evaluateType(bArr);
        if (evaluateType == 2) {
            this.isExtended = TarUtils.parseBoolean(bArr, 482);
            this.realSize = TarUtils.parseOctal(bArr, 483, 12);
        } else if (evaluateType != 4) {
            if (z) {
                str6 = TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN);
            } else {
                str6 = TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN, zipEncoding);
            }
            if (isDirectory() && !this.name.endsWith("/")) {
                this.name += "/";
            }
            if (str6.length() > 0) {
                this.name = str6 + "/" + this.name;
            }
        } else {
            if (z) {
                str5 = TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN_XSTAR);
            } else {
                str5 = TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN_XSTAR, zipEncoding);
            }
            if (str5.length() > 0) {
                this.name = str5 + "/" + this.name;
            }
        }
    }

    private long parseOctalOrBinary(byte[] bArr, int i, int i2, boolean z) {
        if (!z) {
            return TarUtils.parseOctalOrBinary(bArr, i, i2);
        }
        try {
            return TarUtils.parseOctalOrBinary(bArr, i, i2);
        } catch (IllegalArgumentException unused) {
            return -1;
        }
    }

    private static String normalizeFileName(String str, boolean z) {
        String lowerCase;
        int indexOf;
        if (!z && (lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH)) != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char charAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (indexOf = str.indexOf(58)) != -1) {
                str = str.substring(indexOf + 1);
            }
        }
        String replace = str.replace(File.separatorChar, '/');
        while (!z && replace.startsWith("/")) {
            replace = replace.substring(1);
        }
        return replace;
    }

    private int evaluateType(byte[] bArr) {
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, 257, 6)) {
            return 2;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6)) {
            return ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_XSTAR, bArr, TarConstants.XSTAR_MAGIC_OFFSET, 4) ? 4 : 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void fillGNUSparse0xData(Map<String, String> map) {
        this.paxGNUSparse = true;
        this.realSize = (long) Integer.parseInt(map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.name = map.get("GNU.sparse.name");
        }
    }

    /* access modifiers changed from: package-private */
    public void fillGNUSparse1xData(Map<String, String> map) {
        this.paxGNUSparse = true;
        this.realSize = (long) Integer.parseInt(map.get("GNU.sparse.realsize"));
        this.name = map.get("GNU.sparse.name");
    }

    /* access modifiers changed from: package-private */
    public void fillStarSparseData(Map<String, String> map) {
        this.starSparse = true;
        if (map.containsKey("SCHILY.realsize")) {
            this.realSize = Long.parseLong(map.get("SCHILY.realsize"));
        }
    }
}
