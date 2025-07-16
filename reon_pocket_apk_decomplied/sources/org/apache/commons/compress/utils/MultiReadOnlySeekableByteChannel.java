package org.apache.commons.compress.utils;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.altbeacon.beacon.Beacon$$ExternalSyntheticApiModelOutline0;

public class MultiReadOnlySeekableByteChannel implements SeekableByteChannel {
    private final List<SeekableByteChannel> channels;
    private int currentChannelIdx;
    private long globalPosition;

    public MultiReadOnlySeekableByteChannel(List<SeekableByteChannel> list) {
        this.channels = Collections.unmodifiableList(new ArrayList((Collection) Objects.requireNonNull(list, "channels must not be null")));
    }

    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        if (isOpen()) {
            int i = 0;
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            while (byteBuffer.hasRemaining() && this.currentChannelIdx < this.channels.size()) {
                SeekableByteChannel m = Beacon$$ExternalSyntheticApiModelOutline0.m((Object) this.channels.get(this.currentChannelIdx));
                int m2 = m.read(byteBuffer);
                if (m2 == -1) {
                    this.currentChannelIdx++;
                } else {
                    if (Beacon$$ExternalSyntheticApiModelOutline0.m(m) >= m.size()) {
                        this.currentChannelIdx++;
                    }
                    i += m2;
                }
            }
            if (i <= 0) {
                return -1;
            }
            this.globalPosition += (long) i;
            return i;
        }
        throw new ClosedChannelException();
    }

    public void close() throws IOException {
        IOException iOException = null;
        for (SeekableByteChannel m : this.channels) {
            try {
                Beacon$$ExternalSyntheticApiModelOutline0.m(Beacon$$ExternalSyntheticApiModelOutline0.m((Object) m));
            } catch (IOException e) {
                if (iOException == null) {
                    iOException = e;
                }
            }
        }
        if (iOException != null) {
            throw new IOException("failed to close wrapped channel", iOException);
        }
    }

    public boolean isOpen() {
        for (SeekableByteChannel m : this.channels) {
            if (!Beacon$$ExternalSyntheticApiModelOutline0.m(Beacon$$ExternalSyntheticApiModelOutline0.m((Object) m))) {
                return false;
            }
        }
        return true;
    }

    public long position() {
        return this.globalPosition;
    }

    public long size() throws IOException {
        long j = 0;
        for (SeekableByteChannel m : this.channels) {
            j += Beacon$$ExternalSyntheticApiModelOutline0.m((Object) m).size();
        }
        return j;
    }

    public SeekableByteChannel truncate(long j) {
        throw new NonWritableChannelException();
    }

    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    public synchronized SeekableByteChannel position(long j) throws IOException {
        if (j >= 0) {
            try {
                if (isOpen()) {
                    this.globalPosition = j;
                    int i = 0;
                    while (i < this.channels.size()) {
                        SeekableByteChannel m = Beacon$$ExternalSyntheticApiModelOutline0.m((Object) this.channels.get(i));
                        long m$1 = m.size();
                        long j2 = -1;
                        if (j == -1) {
                            j2 = j;
                            j = 0;
                        } else if (j <= m$1) {
                            this.currentChannelIdx = i;
                        } else {
                            j2 = j - m$1;
                            j = m$1;
                        }
                        SeekableByteChannel unused = m.position(j);
                        i++;
                        j = j2;
                    }
                } else {
                    throw new ClosedChannelException();
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Negative position: " + j);
        }
        return this;
    }

    public static SeekableByteChannel forSeekableByteChannels(SeekableByteChannel... seekableByteChannelArr) {
        if (((SeekableByteChannel[]) Objects.requireNonNull(seekableByteChannelArr, "channels must not be null")).length == 1) {
            return seekableByteChannelArr[0];
        }
        return new MultiReadOnlySeekableByteChannel(Arrays.asList(seekableByteChannelArr));
    }

    public static SeekableByteChannel forFiles(File... fileArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (File m : (File[]) Objects.requireNonNull(fileArr, "files must not be null")) {
            arrayList.add(Beacon$$ExternalSyntheticApiModelOutline0.m(m.toPath(), new OpenOption[]{StandardOpenOption.READ}));
        }
        if (arrayList.size() == 1) {
            return Beacon$$ExternalSyntheticApiModelOutline0.m(arrayList.get(0));
        }
        return new MultiReadOnlySeekableByteChannel(arrayList);
    }
}
