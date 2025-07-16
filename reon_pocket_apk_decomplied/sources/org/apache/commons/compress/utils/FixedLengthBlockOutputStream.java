package org.apache.commons.compress.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedLengthBlockOutputStream extends OutputStream implements WritableByteChannel {
    private final int blockSize;
    private final ByteBuffer buffer;
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final WritableByteChannel out;

    public FixedLengthBlockOutputStream(OutputStream outputStream, int i) {
        if (outputStream instanceof FileOutputStream) {
            this.out = ((FileOutputStream) outputStream).getChannel();
            this.buffer = ByteBuffer.allocateDirect(i);
        } else {
            this.out = new BufferAtATimeOutputChannel(outputStream);
            this.buffer = ByteBuffer.allocate(i);
        }
        this.blockSize = i;
    }

    public FixedLengthBlockOutputStream(WritableByteChannel writableByteChannel, int i) {
        this.out = writableByteChannel;
        this.blockSize = i;
        this.buffer = ByteBuffer.allocateDirect(i);
    }

    private void maybeFlush() throws IOException {
        if (!this.buffer.hasRemaining()) {
            writeBlock();
        }
    }

    private void writeBlock() throws IOException {
        this.buffer.flip();
        int write = this.out.write(this.buffer);
        boolean hasRemaining = this.buffer.hasRemaining();
        int i = this.blockSize;
        if (write != i || hasRemaining) {
            throw new IOException(String.format("Failed to write %,d bytes atomically. Only wrote  %,d", new Object[]{Integer.valueOf(i), Integer.valueOf(write)}));
        }
        this.buffer.clear();
    }

    public void write(int i) throws IOException {
        if (isOpen()) {
            this.buffer.put((byte) i);
            maybeFlush();
            return;
        }
        throw new ClosedChannelException();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (isOpen()) {
            while (i2 > 0) {
                int min = Math.min(i2, this.buffer.remaining());
                this.buffer.put(bArr, i, min);
                maybeFlush();
                i2 -= min;
                i += min;
            }
            return;
        }
        throw new ClosedChannelException();
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        int i;
        if (isOpen()) {
            int remaining = byteBuffer.remaining();
            if (remaining < this.buffer.remaining()) {
                this.buffer.put(byteBuffer);
            } else {
                int limit = byteBuffer.limit();
                if (this.buffer.position() != 0) {
                    int remaining2 = this.buffer.remaining();
                    byteBuffer.limit(byteBuffer.position() + remaining2);
                    this.buffer.put(byteBuffer);
                    writeBlock();
                    i = remaining - remaining2;
                } else {
                    i = remaining;
                }
                while (i >= this.blockSize) {
                    byteBuffer.limit(byteBuffer.position() + this.blockSize);
                    this.out.write(byteBuffer);
                    i -= this.blockSize;
                }
                byteBuffer.limit(limit);
                this.buffer.put(byteBuffer);
            }
            return remaining;
        }
        throw new ClosedChannelException();
    }

    public boolean isOpen() {
        if (!this.out.isOpen()) {
            this.closed.set(true);
        }
        return !this.closed.get();
    }

    public void flushBlock() throws IOException {
        if (this.buffer.position() != 0) {
            padBlock();
            writeBlock();
        }
    }

    public void close() throws IOException {
        if (this.closed.compareAndSet(false, true)) {
            try {
                flushBlock();
            } finally {
                this.out.close();
            }
        }
    }

    private void padBlock() {
        this.buffer.order(ByteOrder.nativeOrder());
        int remaining = this.buffer.remaining();
        if (remaining > 8) {
            int position = this.buffer.position() & 7;
            if (position != 0) {
                int i = 8 - position;
                for (int i2 = 0; i2 < i; i2++) {
                    this.buffer.put((byte) 0);
                }
                remaining -= i;
            }
            while (remaining >= 8) {
                this.buffer.putLong(0);
                remaining -= 8;
            }
        }
        while (this.buffer.hasRemaining()) {
            this.buffer.put((byte) 0);
        }
    }

    private static class BufferAtATimeOutputChannel implements WritableByteChannel {
        private final AtomicBoolean closed;
        private final OutputStream out;

        private BufferAtATimeOutputChannel(OutputStream outputStream) {
            this.closed = new AtomicBoolean(false);
            this.out = outputStream;
        }

        public int write(ByteBuffer byteBuffer) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (byteBuffer.hasArray()) {
                try {
                    int position = byteBuffer.position();
                    int limit = byteBuffer.limit() - position;
                    this.out.write(byteBuffer.array(), byteBuffer.arrayOffset() + position, limit);
                    byteBuffer.position(byteBuffer.limit());
                    return limit;
                } catch (IOException e) {
                    try {
                        close();
                    } catch (IOException unused) {
                    }
                    throw e;
                }
            } else {
                throw new IllegalArgumentException("Direct buffer somehow written to BufferAtATimeOutputChannel");
            }
        }

        public boolean isOpen() {
            return !this.closed.get();
        }

        public void close() throws IOException {
            if (this.closed.compareAndSet(false, true)) {
                this.out.close();
            }
        }
    }
}
