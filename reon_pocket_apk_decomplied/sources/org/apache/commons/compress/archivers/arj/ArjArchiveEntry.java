package org.apache.commons.compress.archivers.arj;

import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipUtil;

public class ArjArchiveEntry implements ArchiveEntry {
    private final LocalFileHeader localFileHeader;

    public static class HostOs {
        public static final int AMIGA = 3;
        public static final int APPLE_GS = 6;
        public static final int ATARI_ST = 7;
        public static final int DOS = 0;
        public static final int MAC_OS = 4;
        public static final int NEXT = 8;
        public static final int OS_2 = 5;
        public static final int PRIMOS = 1;
        public static final int UNIX = 2;
        public static final int VAX_VMS = 9;
        public static final int WIN32 = 11;
        public static final int WIN95 = 10;
    }

    public ArjArchiveEntry() {
        this.localFileHeader = new LocalFileHeader();
    }

    ArjArchiveEntry(LocalFileHeader localFileHeader2) {
        this.localFileHeader = localFileHeader2;
    }

    public String getName() {
        if ((this.localFileHeader.arjFlags & 16) != 0) {
            return this.localFileHeader.name.replaceAll("/", Matcher.quoteReplacement(File.separator));
        }
        return this.localFileHeader.name;
    }

    public long getSize() {
        return this.localFileHeader.originalSize;
    }

    public boolean isDirectory() {
        return this.localFileHeader.fileType == 3;
    }

    public Date getLastModifiedDate() {
        long j;
        if (isHostOsUnix()) {
            j = ((long) this.localFileHeader.dateTimeModified) * 1000;
        } else {
            j = ZipUtil.dosToJavaTime(((long) this.localFileHeader.dateTimeModified) & 4294967295L);
        }
        return new Date(j);
    }

    public int getMode() {
        return this.localFileHeader.fileAccessMode;
    }

    public int getUnixMode() {
        if (isHostOsUnix()) {
            return getMode();
        }
        return 0;
    }

    public int getHostOs() {
        return this.localFileHeader.hostOS;
    }

    public boolean isHostOsUnix() {
        return getHostOs() == 2 || getHostOs() == 8;
    }

    /* access modifiers changed from: package-private */
    public int getMethod() {
        return this.localFileHeader.method;
    }

    public int hashCode() {
        String name = getName();
        if (name == null) {
            return 0;
        }
        return name.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.localFileHeader.equals(((ArjArchiveEntry) obj).localFileHeader);
    }
}
