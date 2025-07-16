package org.apache.commons.compress.archivers.ar;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

public class ArArchiveInputStream extends ArchiveInputStream {
    private static final String BSD_LONGNAME_PATTERN = "^#1/\\d+";
    static final String BSD_LONGNAME_PREFIX = "#1/";
    private static final int BSD_LONGNAME_PREFIX_LEN = 3;
    private static final int FILE_MODE_LEN = 8;
    private static final int FILE_MODE_OFFSET = 40;
    private static final String GNU_LONGNAME_PATTERN = "^/\\d+";
    private static final String GNU_STRING_TABLE_NAME = "//";
    private static final int GROUP_ID_LEN = 6;
    private static final int GROUP_ID_OFFSET = 34;
    private static final int LAST_MODIFIED_LEN = 12;
    private static final int LAST_MODIFIED_OFFSET = 16;
    private static final int LENGTH_LEN = 10;
    private static final int LENGTH_OFFSET = 48;
    private static final int NAME_LEN = 16;
    private static final int NAME_OFFSET = 0;
    private static final int USER_ID_LEN = 6;
    private static final int USER_ID_OFFSET = 28;
    private boolean closed;
    private ArArchiveEntry currentEntry = null;
    private long entryOffset = -1;
    private final InputStream input;
    private final byte[] metaData = new byte[58];
    private byte[] namebuffer = null;
    private long offset = 0;

    public ArArchiveInputStream(InputStream inputStream) {
        this.input = inputStream;
        this.closed = false;
    }

    public ArArchiveEntry getNextArEntry() throws IOException {
        ArArchiveEntry arArchiveEntry = this.currentEntry;
        if (arArchiveEntry != null) {
            trackReadBytes(IOUtils.skip(this.input, (this.entryOffset + arArchiveEntry.getLength()) - this.offset));
            this.currentEntry = null;
        }
        if (this.offset == 0) {
            byte[] asciiBytes = ArchiveUtils.toAsciiBytes(ArArchiveEntry.HEADER);
            byte[] bArr = new byte[asciiBytes.length];
            int readFully = IOUtils.readFully(this.input, bArr);
            trackReadBytes((long) readFully);
            if (readFully != asciiBytes.length) {
                throw new IOException("Failed to read header. Occured at byte: " + getBytesRead());
            } else if (!Arrays.equals(asciiBytes, bArr)) {
                throw new IOException("Invalid header " + ArchiveUtils.toAsciiString(bArr));
            }
        }
        if (this.offset % 2 != 0) {
            if (this.input.read() < 0) {
                return null;
            }
            trackReadBytes(1);
        }
        int readFully2 = IOUtils.readFully(this.input, this.metaData);
        trackReadBytes((long) readFully2);
        if (readFully2 == 0) {
            return null;
        }
        if (readFully2 >= this.metaData.length) {
            byte[] asciiBytes2 = ArchiveUtils.toAsciiBytes(ArArchiveEntry.TRAILER);
            byte[] bArr2 = new byte[asciiBytes2.length];
            int readFully3 = IOUtils.readFully(this.input, bArr2);
            trackReadBytes((long) readFully3);
            if (readFully3 != asciiBytes2.length) {
                throw new IOException("Failed to read entry trailer. Occured at byte: " + getBytesRead());
            } else if (Arrays.equals(asciiBytes2, bArr2)) {
                this.entryOffset = this.offset;
                String trim = ArchiveUtils.toAsciiString(this.metaData, 0, 16).trim();
                if (isGNUStringTable(trim)) {
                    this.currentEntry = readGNUStringTable(this.metaData, 48, 10);
                    return getNextArEntry();
                }
                long asLong = asLong(this.metaData, 48, 10);
                if (trim.endsWith("/")) {
                    trim = trim.substring(0, trim.length() - 1);
                } else if (isGNULongName(trim)) {
                    trim = getExtendedName(Integer.parseInt(trim.substring(1)));
                } else if (isBSDLongName(trim)) {
                    trim = getBSDLongName(trim);
                    long length = (long) trim.length();
                    asLong -= length;
                    this.entryOffset += length;
                }
                ArArchiveEntry arArchiveEntry2 = new ArArchiveEntry(trim, asLong, asInt(this.metaData, 28, 6, true), asInt(this.metaData, 34, 6, true), asInt(this.metaData, 40, 8, 8), asLong(this.metaData, 16, 12));
                this.currentEntry = arArchiveEntry2;
                return arArchiveEntry2;
            } else {
                throw new IOException("Invalid entry trailer. not read the content? Occured at byte: " + getBytesRead());
            }
        } else {
            throw new IOException("Truncated ar archive");
        }
    }

    private String getExtendedName(int i) throws IOException {
        byte[] bArr;
        if (this.namebuffer != null) {
            int i2 = i;
            while (true) {
                bArr = this.namebuffer;
                if (i2 < bArr.length) {
                    byte b = bArr[i2];
                    if (b != 10 && b != 0) {
                        i2++;
                    }
                } else {
                    throw new IOException("Failed to read entry: " + i);
                }
            }
            if (bArr[i2 - 1] == 47) {
                i2--;
            }
            return ArchiveUtils.toAsciiString(bArr, i, i2 - i);
        }
        throw new IOException("Cannot process GNU long filename as no // record was found");
    }

    private long asLong(byte[] bArr, int i, int i2) {
        return Long.parseLong(ArchiveUtils.toAsciiString(bArr, i, i2).trim());
    }

    private int asInt(byte[] bArr, int i, int i2) {
        return asInt(bArr, i, i2, 10, false);
    }

    private int asInt(byte[] bArr, int i, int i2, boolean z) {
        return asInt(bArr, i, i2, 10, z);
    }

    private int asInt(byte[] bArr, int i, int i2, int i3) {
        return asInt(bArr, i, i2, i3, false);
    }

    private int asInt(byte[] bArr, int i, int i2, int i3, boolean z) {
        String trim = ArchiveUtils.toAsciiString(bArr, i, i2).trim();
        if (trim.length() != 0 || !z) {
            return Integer.parseInt(trim, i3);
        }
        return 0;
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return getNextArEntry();
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.input.close();
        }
        this.currentEntry = null;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        ArArchiveEntry arArchiveEntry = this.currentEntry;
        if (arArchiveEntry != null) {
            long length = this.entryOffset + arArchiveEntry.getLength();
            if (i2 < 0) {
                return -1;
            }
            long j = this.offset;
            if (j >= length) {
                return -1;
            }
            int read = this.input.read(bArr, i, (int) Math.min((long) i2, length - j));
            trackReadBytes((long) read);
            return read;
        }
        throw new IllegalStateException("No current ar entry");
    }

    public static boolean matches(byte[] bArr, int i) {
        return i >= 8 && bArr[0] == 33 && bArr[1] == 60 && bArr[2] == 97 && bArr[3] == 114 && bArr[4] == 99 && bArr[5] == 104 && bArr[6] == 62 && bArr[7] == 10;
    }

    private static boolean isBSDLongName(String str) {
        return str != null && str.matches(BSD_LONGNAME_PATTERN);
    }

    private String getBSDLongName(String str) throws IOException {
        int parseInt = Integer.parseInt(str.substring(BSD_LONGNAME_PREFIX_LEN));
        byte[] bArr = new byte[parseInt];
        int readFully = IOUtils.readFully(this.input, bArr);
        trackReadBytes((long) readFully);
        if (readFully == parseInt) {
            return ArchiveUtils.toAsciiString(bArr);
        }
        throw new EOFException();
    }

    private static boolean isGNUStringTable(String str) {
        return GNU_STRING_TABLE_NAME.equals(str);
    }

    private void trackReadBytes(long j) {
        count(j);
        if (j > 0) {
            this.offset += j;
        }
    }

    private ArArchiveEntry readGNUStringTable(byte[] bArr, int i, int i2) throws IOException {
        int asInt = asInt(bArr, i, i2);
        byte[] bArr2 = new byte[asInt];
        this.namebuffer = bArr2;
        int readFully = IOUtils.readFully(this.input, bArr2, 0, asInt);
        trackReadBytes((long) readFully);
        if (readFully == asInt) {
            return new ArArchiveEntry(GNU_STRING_TABLE_NAME, (long) asInt);
        }
        throw new IOException("Failed to read complete // record: expected=" + asInt + " read=" + readFully);
    }

    private boolean isGNULongName(String str) {
        return str != null && str.matches(GNU_LONGNAME_PATTERN);
    }
}
