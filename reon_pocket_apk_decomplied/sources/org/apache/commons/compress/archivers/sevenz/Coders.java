package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.FlushShieldFilterOutputStream;
import org.tukaani.xz.ARMOptions;
import org.tukaani.xz.ARMThumbOptions;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.IA64Options;
import org.tukaani.xz.PowerPCOptions;
import org.tukaani.xz.SPARCOptions;
import org.tukaani.xz.X86Options;

class Coders {
    private static final Map<SevenZMethod, CoderBase> CODER_MAP = new HashMap<SevenZMethod, CoderBase>() {
        private static final long serialVersionUID = 1664829131806520867L;

        {
            put(SevenZMethod.COPY, new CopyDecoder());
            put(SevenZMethod.LZMA, new LZMADecoder());
            put(SevenZMethod.LZMA2, new LZMA2Decoder());
            put(SevenZMethod.DEFLATE, new DeflateDecoder());
            put(SevenZMethod.DEFLATE64, new Deflate64Decoder());
            put(SevenZMethod.BZIP2, new BZIP2Decoder());
            put(SevenZMethod.AES256SHA256, new AES256SHA256Decoder());
            put(SevenZMethod.BCJ_X86_FILTER, new BCJDecoder(new X86Options()));
            put(SevenZMethod.BCJ_PPC_FILTER, new BCJDecoder(new PowerPCOptions()));
            put(SevenZMethod.BCJ_IA64_FILTER, new BCJDecoder(new IA64Options()));
            put(SevenZMethod.BCJ_ARM_FILTER, new BCJDecoder(new ARMOptions()));
            put(SevenZMethod.BCJ_ARM_THUMB_FILTER, new BCJDecoder(new ARMThumbOptions()));
            put(SevenZMethod.BCJ_SPARC_FILTER, new BCJDecoder(new SPARCOptions()));
            put(SevenZMethod.DELTA_FILTER, new DeltaDecoder());
        }
    };

    Coders() {
    }

    static CoderBase findByMethod(SevenZMethod sevenZMethod) {
        return CODER_MAP.get(sevenZMethod);
    }

    static InputStream addDecoder(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
        CoderBase findByMethod = findByMethod(SevenZMethod.byId(coder.decompressionMethodId));
        if (findByMethod != null) {
            return findByMethod.decode(str, inputStream, j, coder, bArr, i);
        }
        throw new IOException("Unsupported compression method " + Arrays.toString(coder.decompressionMethodId) + " used in " + str);
    }

    static OutputStream addEncoder(OutputStream outputStream, SevenZMethod sevenZMethod, Object obj) throws IOException {
        CoderBase findByMethod = findByMethod(sevenZMethod);
        if (findByMethod != null) {
            return findByMethod.encode(outputStream, obj);
        }
        throw new IOException("Unsupported compression method " + sevenZMethod);
    }

    static class CopyDecoder extends CoderBase {
        /* access modifiers changed from: package-private */
        public InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            return inputStream;
        }

        /* access modifiers changed from: package-private */
        public OutputStream encode(OutputStream outputStream, Object obj) {
            return outputStream;
        }

        CopyDecoder() {
            super(new Class[0]);
        }
    }

    static class BCJDecoder extends CoderBase {
        private final FilterOptions opts;

        BCJDecoder(FilterOptions filterOptions) {
            super(new Class[0]);
            this.opts = filterOptions;
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            try {
                return this.opts.getInputStream(inputStream);
            } catch (AssertionError e) {
                throw new IOException("BCJ filter used in " + str + " needs XZ for Java > 1.4 - see https://commons.apache.org/proper/commons-compress/limitations.html#7Z", e);
            }
        }

        /* access modifiers changed from: package-private */
        public OutputStream encode(OutputStream outputStream, Object obj) {
            return new FlushShieldFilterOutputStream(this.opts.getOutputStream(new FinishableWrapperOutputStream(outputStream)));
        }
    }

    static class DeflateDecoder extends CoderBase {
        private static final byte[] ONE_ZERO_BYTE = new byte[1];

        DeflateDecoder() {
            super(Number.class);
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            Inflater inflater = new Inflater(true);
            return new DeflateDecoderInputStream(new InflaterInputStream(new SequenceInputStream(inputStream, new ByteArrayInputStream(ONE_ZERO_BYTE)), inflater), inflater);
        }

        /* access modifiers changed from: package-private */
        public OutputStream encode(OutputStream outputStream, Object obj) {
            Deflater deflater = new Deflater(numberOptionOrDefault(obj, 9), true);
            return new DeflateDecoderOutputStream(new DeflaterOutputStream(outputStream, deflater), deflater);
        }

        static class DeflateDecoderInputStream extends InputStream {
            Inflater inflater;
            InflaterInputStream inflaterInputStream;

            public DeflateDecoderInputStream(InflaterInputStream inflaterInputStream2, Inflater inflater2) {
                this.inflaterInputStream = inflaterInputStream2;
                this.inflater = inflater2;
            }

            public int read() throws IOException {
                return this.inflaterInputStream.read();
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                return this.inflaterInputStream.read(bArr, i, i2);
            }

            public int read(byte[] bArr) throws IOException {
                return this.inflaterInputStream.read(bArr);
            }

            public void close() throws IOException {
                try {
                    this.inflaterInputStream.close();
                } finally {
                    this.inflater.end();
                }
            }
        }

        static class DeflateDecoderOutputStream extends OutputStream {
            Deflater deflater;
            DeflaterOutputStream deflaterOutputStream;

            public DeflateDecoderOutputStream(DeflaterOutputStream deflaterOutputStream2, Deflater deflater2) {
                this.deflaterOutputStream = deflaterOutputStream2;
                this.deflater = deflater2;
            }

            public void write(int i) throws IOException {
                this.deflaterOutputStream.write(i);
            }

            public void write(byte[] bArr) throws IOException {
                this.deflaterOutputStream.write(bArr);
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                this.deflaterOutputStream.write(bArr, i, i2);
            }

            public void close() throws IOException {
                try {
                    this.deflaterOutputStream.close();
                } finally {
                    this.deflater.end();
                }
            }
        }
    }

    static class Deflate64Decoder extends CoderBase {
        Deflate64Decoder() {
            super(Number.class);
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            return new Deflate64CompressorInputStream(inputStream);
        }
    }

    static class BZIP2Decoder extends CoderBase {
        BZIP2Decoder() {
            super(Number.class);
        }

        /* access modifiers changed from: package-private */
        public InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            return new BZip2CompressorInputStream(inputStream);
        }

        /* access modifiers changed from: package-private */
        public OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
            return new BZip2CompressorOutputStream(outputStream, numberOptionOrDefault(obj, 9));
        }
    }
}
