package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;

public abstract class StreamCompressor implements Closeable {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFLATER_BLOCK_SIZE = 8192;
    private final CRC32 crc = new CRC32();
    private final Deflater def;
    private final byte[] outputBuffer = new byte[4096];
    private final byte[] readerBuf = new byte[4096];
    private long sourcePayloadLength = 0;
    private long totalWrittenToOutputStream = 0;
    private long writtenToOutputStreamForLastEntry = 0;

    /* access modifiers changed from: protected */
    public abstract void writeOut(byte[] bArr, int i, int i2) throws IOException;

    StreamCompressor(Deflater deflater) {
        this.def = deflater;
    }

    static StreamCompressor create(OutputStream outputStream, Deflater deflater) {
        return new OutputStreamCompressor(deflater, outputStream);
    }

    static StreamCompressor create(OutputStream outputStream) {
        return create(outputStream, new Deflater(-1, true));
    }

    static StreamCompressor create(DataOutput dataOutput, Deflater deflater) {
        return new DataOutputCompressor(deflater, dataOutput);
    }

    static StreamCompressor create(SeekableByteChannel seekableByteChannel, Deflater deflater) {
        return new SeekableByteChannelCompressor(deflater, seekableByteChannel);
    }

    public static StreamCompressor create(int i, ScatterGatherBackingStore scatterGatherBackingStore) {
        return new ScatterGatherBackingStoreCompressor(new Deflater(i, true), scatterGatherBackingStore);
    }

    public static StreamCompressor create(ScatterGatherBackingStore scatterGatherBackingStore) {
        return create(-1, scatterGatherBackingStore);
    }

    public long getCrc32() {
        return this.crc.getValue();
    }

    public long getBytesRead() {
        return this.sourcePayloadLength;
    }

    public long getBytesWrittenForLastEntry() {
        return this.writtenToOutputStreamForLastEntry;
    }

    public long getTotalBytesWritten() {
        return this.totalWrittenToOutputStream;
    }

    public void deflate(InputStream inputStream, int i) throws IOException {
        reset();
        while (true) {
            byte[] bArr = this.readerBuf;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read < 0) {
                break;
            }
            write(this.readerBuf, 0, read, i);
        }
        if (i == 8) {
            flushDeflater();
        }
    }

    /* access modifiers changed from: package-private */
    public long write(byte[] bArr, int i, int i2, int i3) throws IOException {
        long j = this.writtenToOutputStreamForLastEntry;
        this.crc.update(bArr, i, i2);
        if (i3 == 8) {
            writeDeflated(bArr, i, i2);
        } else {
            writeCounted(bArr, i, i2);
        }
        this.sourcePayloadLength += (long) i2;
        return this.writtenToOutputStreamForLastEntry - j;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.crc.reset();
        this.def.reset();
        this.sourcePayloadLength = 0;
        this.writtenToOutputStreamForLastEntry = 0;
    }

    public void close() throws IOException {
        this.def.end();
    }

    /* access modifiers changed from: package-private */
    public void flushDeflater() throws IOException {
        this.def.finish();
        while (!this.def.finished()) {
            deflate();
        }
    }

    private void writeDeflated(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0 && !this.def.finished()) {
            if (i2 <= 8192) {
                this.def.setInput(bArr, i, i2);
                deflateUntilInputIsNeeded();
                return;
            }
            int i3 = i2 / 8192;
            for (int i4 = 0; i4 < i3; i4++) {
                this.def.setInput(bArr, (i4 * 8192) + i, 8192);
                deflateUntilInputIsNeeded();
            }
            int i5 = i3 * 8192;
            if (i5 < i2) {
                this.def.setInput(bArr, i + i5, i2 - i5);
                deflateUntilInputIsNeeded();
            }
        }
    }

    private void deflateUntilInputIsNeeded() throws IOException {
        while (!this.def.needsInput()) {
            deflate();
        }
    }

    /* access modifiers changed from: package-private */
    public void deflate() throws IOException {
        Deflater deflater = this.def;
        byte[] bArr = this.outputBuffer;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            writeCounted(this.outputBuffer, 0, deflate);
        }
    }

    public void writeCounted(byte[] bArr) throws IOException {
        writeCounted(bArr, 0, bArr.length);
    }

    public void writeCounted(byte[] bArr, int i, int i2) throws IOException {
        writeOut(bArr, i, i2);
        long j = (long) i2;
        this.writtenToOutputStreamForLastEntry += j;
        this.totalWrittenToOutputStream += j;
    }

    private static final class ScatterGatherBackingStoreCompressor extends StreamCompressor {
        private final ScatterGatherBackingStore bs;

        public ScatterGatherBackingStoreCompressor(Deflater deflater, ScatterGatherBackingStore scatterGatherBackingStore) {
            super(deflater);
            this.bs = scatterGatherBackingStore;
        }

        /* access modifiers changed from: protected */
        public final void writeOut(byte[] bArr, int i, int i2) throws IOException {
            this.bs.writeOut(bArr, i, i2);
        }
    }

    private static final class OutputStreamCompressor extends StreamCompressor {
        private final OutputStream os;

        public OutputStreamCompressor(Deflater deflater, OutputStream outputStream) {
            super(deflater);
            this.os = outputStream;
        }

        /* access modifiers changed from: protected */
        public final void writeOut(byte[] bArr, int i, int i2) throws IOException {
            this.os.write(bArr, i, i2);
        }
    }

    private static final class DataOutputCompressor extends StreamCompressor {
        private final DataOutput raf;

        public DataOutputCompressor(Deflater deflater, DataOutput dataOutput) {
            super(deflater);
            this.raf = dataOutput;
        }

        /* access modifiers changed from: protected */
        public final void writeOut(byte[] bArr, int i, int i2) throws IOException {
            this.raf.write(bArr, i, i2);
        }
    }

    private static final class SeekableByteChannelCompressor extends StreamCompressor {
        private final SeekableByteChannel channel;

        public SeekableByteChannelCompressor(Deflater deflater, SeekableByteChannel seekableByteChannel) {
            super(deflater);
            this.channel = seekableByteChannel;
        }

        /* access modifiers changed from: protected */
        public final void writeOut(byte[] bArr, int i, int i2) throws IOException {
            int unused = this.channel.write(ByteBuffer.wrap(bArr, i, i2));
        }
    }
}
