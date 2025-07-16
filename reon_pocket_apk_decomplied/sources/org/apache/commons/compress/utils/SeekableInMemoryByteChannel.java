package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class SeekableInMemoryByteChannel implements SeekableByteChannel {
    private static final int NAIVE_RESIZE_LIMIT = 1073741823;
    private final AtomicBoolean closed;
    private byte[] data;
    private int position;
    private int size;

    public SeekableInMemoryByteChannel(byte[] bArr) {
        this.closed = new AtomicBoolean();
        this.data = bArr;
        this.size = bArr.length;
    }

    public SeekableInMemoryByteChannel() {
        this(new byte[0]);
    }

    public SeekableInMemoryByteChannel(int i) {
        this(new byte[i]);
    }

    public long position() {
        return (long) this.position;
    }

    public SeekableByteChannel position(long j) throws IOException {
        ensureOpen();
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException("Position has to be in range 0.. 2147483647");
        }
        this.position = (int) j;
        return this;
    }

    public long size() {
        return (long) this.size;
    }

    public SeekableByteChannel truncate(long j) {
        if (((long) this.size) > j) {
            this.size = (int) j;
        }
        repositionIfNecessary();
        return this;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        repositionIfNecessary();
        int remaining = byteBuffer.remaining();
        int i = this.size;
        int i2 = this.position;
        int i3 = i - i2;
        if (i3 <= 0) {
            return -1;
        }
        if (remaining > i3) {
            remaining = i3;
        }
        byteBuffer.put(this.data, i2, remaining);
        this.position += remaining;
        return remaining;
    }

    public void close() {
        this.closed.set(true);
    }

    public boolean isOpen() {
        return !this.closed.get();
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        int remaining = byteBuffer.remaining();
        int i = this.size;
        int i2 = this.position;
        if (remaining > i - i2) {
            int i3 = i2 + remaining;
            if (i3 < 0) {
                resize(Integer.MAX_VALUE);
                remaining = Integer.MAX_VALUE - this.position;
            } else {
                resize(i3);
            }
        }
        byteBuffer.get(this.data, this.position, remaining);
        int i4 = this.position + remaining;
        this.position = i4;
        if (this.size < i4) {
            this.size = i4;
        }
        return remaining;
    }

    public byte[] array() {
        return this.data;
    }

    private void resize(int i) {
        int length = this.data.length;
        if (length <= 0) {
            length = 1;
        }
        if (i < 1073741823) {
            while (length < i) {
                length <<= 1;
            }
            i = length;
        }
        this.data = Arrays.copyOf(this.data, i);
    }

    private void ensureOpen() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    private void repositionIfNecessary() {
        int i = this.position;
        int i2 = this.size;
        if (i > i2) {
            this.position = i2;
        }
    }
}
