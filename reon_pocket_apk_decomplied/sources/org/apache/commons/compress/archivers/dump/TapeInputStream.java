package org.apache.commons.compress.archivers.dump;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.apache.commons.compress.utils.IOUtils;

class TapeInputStream extends FilterInputStream {
    private static final int RECORD_SIZE = 1024;
    private byte[] blockBuffer = new byte[1024];
    private int blockSize = 1024;
    private long bytesRead = 0;
    private int currBlkIdx = -1;
    private boolean isCompressed = false;
    private int readOffset = 1024;

    public TapeInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void resetBlockSize(int i, boolean z) throws IOException {
        this.isCompressed = z;
        if (i >= 1) {
            int i2 = i * 1024;
            this.blockSize = i2;
            byte[] bArr = this.blockBuffer;
            byte[] bArr2 = new byte[i2];
            this.blockBuffer = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 1024);
            readFully(this.blockBuffer, 1024, this.blockSize - 1024);
            this.currBlkIdx = 0;
            this.readOffset = 1024;
            return;
        }
        throw new IOException("Block with " + i + " records found, must be at least 1");
    }

    public int available() throws IOException {
        int i = this.readOffset;
        int i2 = this.blockSize;
        if (i < i2) {
            return i2 - i;
        }
        return this.in.available();
    }

    public int read() throws IOException {
        throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 % 1024 == 0) {
            int i3 = 0;
            while (i3 < i2) {
                if (this.readOffset == this.blockSize) {
                    try {
                        readBlock(true);
                    } catch (ShortFileException unused) {
                        return -1;
                    }
                }
                int i4 = this.readOffset;
                int i5 = i2 - i3;
                int i6 = i4 + i5;
                int i7 = this.blockSize;
                if (i6 > i7) {
                    i5 = i7 - i4;
                }
                System.arraycopy(this.blockBuffer, i4, bArr, i, i5);
                this.readOffset += i5;
                i3 += i5;
                i += i5;
            }
            return i3;
        }
        throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
    }

    public long skip(long j) throws IOException {
        long j2 = 0;
        if (j % 1024 == 0) {
            while (j2 < j) {
                int i = this.readOffset;
                int i2 = this.blockSize;
                if (i == i2) {
                    try {
                        readBlock(j - j2 < ((long) i2));
                    } catch (ShortFileException unused) {
                        return -1;
                    }
                }
                int i3 = this.readOffset;
                long j3 = j - j2;
                int i4 = this.blockSize;
                if (((long) i3) + j3 > ((long) i4)) {
                    j3 = ((long) i4) - ((long) i3);
                }
                this.readOffset = (int) (((long) i3) + j3);
                j2 += j3;
            }
            return j2;
        }
        throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
    }

    public void close() throws IOException {
        if (this.in != null && this.in != System.in) {
            this.in.close();
        }
    }

    public byte[] peek() throws IOException {
        if (this.readOffset == this.blockSize) {
            try {
                readBlock(true);
            } catch (ShortFileException unused) {
                return null;
            }
        }
        byte[] bArr = new byte[1024];
        System.arraycopy(this.blockBuffer, this.readOffset, bArr, 0, 1024);
        return bArr;
    }

    public byte[] readRecord() throws IOException {
        byte[] bArr = new byte[1024];
        if (-1 != read(bArr, 0, 1024)) {
            return bArr;
        }
        throw new ShortFileException();
    }

    private void readBlock(boolean z) throws IOException {
        if (this.in != null) {
            if (!this.isCompressed || this.currBlkIdx == -1) {
                readFully(this.blockBuffer, 0, this.blockSize);
                this.bytesRead += (long) this.blockSize;
            } else {
                readFully(this.blockBuffer, 0, 4);
                this.bytesRead += 4;
                int convert32 = DumpArchiveUtil.convert32(this.blockBuffer, 0);
                if ((convert32 & 1) == 1) {
                    int i = convert32 >> 1;
                    int i2 = (convert32 >> 4) & 268435455;
                    byte[] bArr = new byte[i2];
                    readFully(bArr, 0, i2);
                    this.bytesRead += (long) i2;
                    if (!z) {
                        Arrays.fill(this.blockBuffer, (byte) 0);
                    } else {
                        int i3 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.find(i & 3).ordinal()];
                        if (i3 == 1) {
                            Inflater inflater = new Inflater();
                            try {
                                inflater.setInput(bArr, 0, i2);
                                if (inflater.inflate(this.blockBuffer) == this.blockSize) {
                                    inflater.end();
                                } else {
                                    throw new ShortFileException();
                                }
                            } catch (DataFormatException e) {
                                throw new DumpArchiveException("Bad data", e);
                            } catch (Throwable th) {
                                inflater.end();
                                throw th;
                            }
                        } else if (i3 == 2) {
                            throw new UnsupportedCompressionAlgorithmException("BZLIB2");
                        } else if (i3 != 3) {
                            throw new UnsupportedCompressionAlgorithmException();
                        } else {
                            throw new UnsupportedCompressionAlgorithmException("LZO");
                        }
                    }
                } else {
                    readFully(this.blockBuffer, 0, this.blockSize);
                    this.bytesRead += (long) this.blockSize;
                }
            }
            this.currBlkIdx++;
            this.readOffset = 0;
            return;
        }
        throw new IOException("Input buffer is closed");
    }

    /* renamed from: org.apache.commons.compress.archivers.dump.TapeInputStream$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE[] r0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE = r0
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.ZLIB     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.BZLIB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.LZO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.dump.TapeInputStream.AnonymousClass1.<clinit>():void");
        }
    }

    private void readFully(byte[] bArr, int i, int i2) throws IOException {
        if (IOUtils.readFully(this.in, bArr, i, i2) < i2) {
            throw new ShortFileException();
        }
    }

    public long getBytesRead() {
        return this.bytesRead;
    }
}
