package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

class BoundedSeekableByteChannelInputStream extends InputStream {
    private static final int MAX_BUF_LEN = 8192;
    private final ByteBuffer buffer;
    private long bytesRemaining;
    private final SeekableByteChannel channel;

    public void close() {
    }

    public BoundedSeekableByteChannelInputStream(SeekableByteChannel seekableByteChannel, long j) {
        this.channel = seekableByteChannel;
        this.bytesRemaining = j;
        if (j >= 8192 || j <= 0) {
            this.buffer = ByteBuffer.allocate(8192);
        } else {
            this.buffer = ByteBuffer.allocate((int) j);
        }
    }

    public int read() throws IOException {
        long j = this.bytesRemaining;
        if (j <= 0) {
            return -1;
        }
        this.bytesRemaining = j - 1;
        int read = read(1);
        if (read < 0) {
            return read;
        }
        return this.buffer.get() & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        ByteBuffer byteBuffer;
        long j = this.bytesRemaining;
        if (j <= 0) {
            return -1;
        }
        if (((long) i2) > j) {
            i2 = (int) j;
        }
        if (i2 <= this.buffer.capacity()) {
            byteBuffer = this.buffer;
            i3 = read(i2);
        } else {
            byteBuffer = ByteBuffer.allocate(i2);
            i3 = this.channel.read(byteBuffer);
            byteBuffer.flip();
        }
        if (i3 >= 0) {
            byteBuffer.get(bArr, i, i3);
            this.bytesRemaining -= (long) i3;
        }
        return i3;
    }

    private int read(int i) throws IOException {
        this.buffer.rewind().limit(i);
        int m = this.channel.read(this.buffer);
        this.buffer.flip();
        return m;
    }
}
