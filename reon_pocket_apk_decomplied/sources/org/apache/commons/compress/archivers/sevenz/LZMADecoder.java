package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.FlushShieldFilterOutputStream;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.LZMAOutputStream;

class LZMADecoder extends CoderBase {
    LZMADecoder() {
        super(LZMA2Options.class, Number.class);
    }

    /* access modifiers changed from: package-private */
    public InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
        if (coder.properties == null) {
            throw new IOException("Missing LZMA properties");
        } else if (coder.properties.length >= 1) {
            byte b = coder.properties[0];
            int dictionarySize = getDictionarySize(coder);
            if (dictionarySize <= 2147483632) {
                int memoryUsage = LZMAInputStream.getMemoryUsage(dictionarySize, b);
                if (memoryUsage <= i) {
                    return new LZMAInputStream(inputStream, j, b, dictionarySize);
                }
                throw new MemoryLimitException((long) memoryUsage, i);
            }
            throw new IOException("Dictionary larger than 4GiB maximum size used in " + str);
        } else {
            throw new IOException("LZMA properties too short");
        }
    }

    /* access modifiers changed from: package-private */
    public OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
        return new FlushShieldFilterOutputStream(new LZMAOutputStream(outputStream, getOptions(obj), false));
    }

    /* access modifiers changed from: package-private */
    public byte[] getOptionsAsProperties(Object obj) throws IOException {
        LZMA2Options options = getOptions(obj);
        int dictSize = options.getDictSize();
        byte[] bArr = new byte[5];
        bArr[0] = (byte) ((((options.getPb() * 5) + options.getLp()) * 9) + options.getLc());
        ByteUtils.toLittleEndian(bArr, (long) dictSize, 1, 4);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public Object getOptionsFromCoder(Coder coder, InputStream inputStream) throws IOException {
        if (coder.properties == null) {
            throw new IOException("Missing LZMA properties");
        } else if (coder.properties.length >= 1) {
            byte b = coder.properties[0] & 255;
            int i = b / 45;
            int i2 = b - (i * 45);
            int i3 = i2 / 9;
            LZMA2Options lZMA2Options = new LZMA2Options();
            lZMA2Options.setPb(i);
            lZMA2Options.setLcLp(i2 - (i3 * 9), i3);
            lZMA2Options.setDictSize(getDictionarySize(coder));
            return lZMA2Options;
        } else {
            throw new IOException("LZMA properties too short");
        }
    }

    private int getDictionarySize(Coder coder) throws IllegalArgumentException {
        return (int) ByteUtils.fromLittleEndian(coder.properties, 1, 4);
    }

    private LZMA2Options getOptions(Object obj) throws IOException {
        if (obj instanceof LZMA2Options) {
            return (LZMA2Options) obj;
        }
        LZMA2Options lZMA2Options = new LZMA2Options();
        lZMA2Options.setDictSize(numberOptionOrDefault(obj));
        return lZMA2Options;
    }

    private int numberOptionOrDefault(Object obj) {
        return numberOptionOrDefault(obj, 8388608);
    }
}
