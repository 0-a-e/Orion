package org.apache.commons.compress.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ByteUtils {

    public interface ByteConsumer {
        void accept(int i) throws IOException;
    }

    public interface ByteSupplier {
        int getAsByte() throws IOException;
    }

    private ByteUtils() {
    }

    public static long fromLittleEndian(byte[] bArr) {
        return fromLittleEndian(bArr, 0, bArr.length);
    }

    public static long fromLittleEndian(byte[] bArr, int i, int i2) {
        checkReadLength(i2);
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (((long) bArr[i + i3]) & 255) << (i3 * 8);
        }
        return j;
    }

    public static long fromLittleEndian(InputStream inputStream, int i) throws IOException {
        checkReadLength(i);
        long j = 0;
        int i2 = 0;
        while (i2 < i) {
            long read = (long) inputStream.read();
            if (read != -1) {
                j |= read << (i2 * 8);
                i2++;
            } else {
                throw new IOException("Premature end of data");
            }
        }
        return j;
    }

    public static long fromLittleEndian(ByteSupplier byteSupplier, int i) throws IOException {
        checkReadLength(i);
        long j = 0;
        int i2 = 0;
        while (i2 < i) {
            long asByte = (long) byteSupplier.getAsByte();
            if (asByte != -1) {
                j |= asByte << (i2 * 8);
                i2++;
            } else {
                throw new IOException("Premature end of data");
            }
        }
        return j;
    }

    public static long fromLittleEndian(DataInput dataInput, int i) throws IOException {
        checkReadLength(i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j |= ((long) dataInput.readUnsignedByte()) << (i2 * 8);
        }
        return j;
    }

    public static void toLittleEndian(byte[] bArr, long j, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i + i3] = (byte) ((int) (255 & j));
            j >>= 8;
        }
    }

    public static void toLittleEndian(OutputStream outputStream, long j, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            outputStream.write((int) (255 & j));
            j >>= 8;
        }
    }

    public static void toLittleEndian(ByteConsumer byteConsumer, long j, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            byteConsumer.accept((int) (255 & j));
            j >>= 8;
        }
    }

    public static void toLittleEndian(DataOutput dataOutput, long j, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            dataOutput.write((int) (255 & j));
            j >>= 8;
        }
    }

    public static class InputStreamByteSupplier implements ByteSupplier {
        private final InputStream is;

        public InputStreamByteSupplier(InputStream inputStream) {
            this.is = inputStream;
        }

        public int getAsByte() throws IOException {
            return this.is.read();
        }
    }

    public static class OutputStreamByteConsumer implements ByteConsumer {
        private final OutputStream os;

        public OutputStreamByteConsumer(OutputStream outputStream) {
            this.os = outputStream;
        }

        public void accept(int i) throws IOException {
            this.os.write(i);
        }
    }

    private static final void checkReadLength(int i) {
        if (i > 8) {
            throw new IllegalArgumentException("Can't read more than eight bytes into a long value");
        }
    }
}
