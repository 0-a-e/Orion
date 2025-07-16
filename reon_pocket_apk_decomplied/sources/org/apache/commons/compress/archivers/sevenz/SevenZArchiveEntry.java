package org.apache.commons.compress.archivers.sevenz;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import java.util.TimeZone;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class SevenZArchiveEntry implements ArchiveEntry {
    private long accessDate;
    private long compressedCrc;
    private long compressedSize;
    private Iterable<? extends SevenZMethodConfiguration> contentMethods;
    private long crc;
    private long creationDate;
    private boolean hasAccessDate;
    private boolean hasCrc;
    private boolean hasCreationDate;
    private boolean hasLastModifiedDate;
    private boolean hasStream;
    private boolean hasWindowsAttributes;
    private boolean isAntiItem;
    private boolean isDirectory;
    private long lastModifiedDate;
    private String name;
    private long size;
    private int windowsAttributes;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean hasStream() {
        return this.hasStream;
    }

    public void setHasStream(boolean z) {
        this.hasStream = z;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public boolean isAntiItem() {
        return this.isAntiItem;
    }

    public void setAntiItem(boolean z) {
        this.isAntiItem = z;
    }

    public boolean getHasCreationDate() {
        return this.hasCreationDate;
    }

    public void setHasCreationDate(boolean z) {
        this.hasCreationDate = z;
    }

    public Date getCreationDate() {
        if (this.hasCreationDate) {
            return ntfsTimeToJavaTime(this.creationDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public void setCreationDate(long j) {
        this.creationDate = j;
    }

    public void setCreationDate(Date date) {
        boolean z = date != null;
        this.hasCreationDate = z;
        if (z) {
            this.creationDate = javaTimeToNtfsTime(date);
        }
    }

    public boolean getHasLastModifiedDate() {
        return this.hasLastModifiedDate;
    }

    public void setHasLastModifiedDate(boolean z) {
        this.hasLastModifiedDate = z;
    }

    public Date getLastModifiedDate() {
        if (this.hasLastModifiedDate) {
            return ntfsTimeToJavaTime(this.lastModifiedDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public void setLastModifiedDate(long j) {
        this.lastModifiedDate = j;
    }

    public void setLastModifiedDate(Date date) {
        boolean z = date != null;
        this.hasLastModifiedDate = z;
        if (z) {
            this.lastModifiedDate = javaTimeToNtfsTime(date);
        }
    }

    public boolean getHasAccessDate() {
        return this.hasAccessDate;
    }

    public void setHasAccessDate(boolean z) {
        this.hasAccessDate = z;
    }

    public Date getAccessDate() {
        if (this.hasAccessDate) {
            return ntfsTimeToJavaTime(this.accessDate);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public void setAccessDate(long j) {
        this.accessDate = j;
    }

    public void setAccessDate(Date date) {
        boolean z = date != null;
        this.hasAccessDate = z;
        if (z) {
            this.accessDate = javaTimeToNtfsTime(date);
        }
    }

    public boolean getHasWindowsAttributes() {
        return this.hasWindowsAttributes;
    }

    public void setHasWindowsAttributes(boolean z) {
        this.hasWindowsAttributes = z;
    }

    public int getWindowsAttributes() {
        return this.windowsAttributes;
    }

    public void setWindowsAttributes(int i) {
        this.windowsAttributes = i;
    }

    public boolean getHasCrc() {
        return this.hasCrc;
    }

    public void setHasCrc(boolean z) {
        this.hasCrc = z;
    }

    @Deprecated
    public int getCrc() {
        return (int) this.crc;
    }

    @Deprecated
    public void setCrc(int i) {
        this.crc = (long) i;
    }

    public long getCrcValue() {
        return this.crc;
    }

    public void setCrcValue(long j) {
        this.crc = j;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public int getCompressedCrc() {
        return (int) this.compressedCrc;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void setCompressedCrc(int i) {
        this.compressedCrc = (long) i;
    }

    /* access modifiers changed from: package-private */
    public long getCompressedCrcValue() {
        return this.compressedCrc;
    }

    /* access modifiers changed from: package-private */
    public void setCompressedCrcValue(long j) {
        this.compressedCrc = j;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    /* access modifiers changed from: package-private */
    public long getCompressedSize() {
        return this.compressedSize;
    }

    /* access modifiers changed from: package-private */
    public void setCompressedSize(long j) {
        this.compressedSize = j;
    }

    public void setContentMethods(Iterable<? extends SevenZMethodConfiguration> iterable) {
        if (iterable != null) {
            LinkedList linkedList = new LinkedList();
            for (SevenZMethodConfiguration addLast : iterable) {
                linkedList.addLast(addLast);
            }
            this.contentMethods = Collections.unmodifiableList(linkedList);
            return;
        }
        this.contentMethods = null;
    }

    public Iterable<? extends SevenZMethodConfiguration> getContentMethods() {
        return this.contentMethods;
    }

    public int hashCode() {
        String name2 = getName();
        if (name2 == null) {
            return 0;
        }
        return name2.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SevenZArchiveEntry sevenZArchiveEntry = (SevenZArchiveEntry) obj;
        if (Objects.equals(this.name, sevenZArchiveEntry.name) && this.hasStream == sevenZArchiveEntry.hasStream && this.isDirectory == sevenZArchiveEntry.isDirectory && this.isAntiItem == sevenZArchiveEntry.isAntiItem && this.hasCreationDate == sevenZArchiveEntry.hasCreationDate && this.hasLastModifiedDate == sevenZArchiveEntry.hasLastModifiedDate && this.hasAccessDate == sevenZArchiveEntry.hasAccessDate && this.creationDate == sevenZArchiveEntry.creationDate && this.lastModifiedDate == sevenZArchiveEntry.lastModifiedDate && this.accessDate == sevenZArchiveEntry.accessDate && this.hasWindowsAttributes == sevenZArchiveEntry.hasWindowsAttributes && this.windowsAttributes == sevenZArchiveEntry.windowsAttributes && this.hasCrc == sevenZArchiveEntry.hasCrc && this.crc == sevenZArchiveEntry.crc && this.compressedCrc == sevenZArchiveEntry.compressedCrc && this.size == sevenZArchiveEntry.size && this.compressedSize == sevenZArchiveEntry.compressedSize && equalSevenZMethods(this.contentMethods, sevenZArchiveEntry.contentMethods)) {
            return true;
        }
        return false;
    }

    public static Date ntfsTimeToJavaTime(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        instance.set(1601, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        return new Date(instance.getTimeInMillis() + (j / 10000));
    }

    public static long javaTimeToNtfsTime(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        instance.set(1601, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        return (date.getTime() - instance.getTimeInMillis()) * 10000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean equalSevenZMethods(java.lang.Iterable<? extends org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration> r5, java.lang.Iterable<? extends org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration> r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 != 0) goto L_0x0009
            if (r6 != 0) goto L_0x0007
            goto L_0x0008
        L_0x0007:
            r0 = r1
        L_0x0008:
            return r0
        L_0x0009:
            if (r6 != 0) goto L_0x000c
            return r1
        L_0x000c:
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
        L_0x0014:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0032
            boolean r2 = r6.hasNext()
            if (r2 != 0) goto L_0x0021
            return r1
        L_0x0021:
            java.lang.Object r2 = r5.next()
            org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration r2 = (org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration) r2
            java.lang.Object r3 = r6.next()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0014
            return r1
        L_0x0032:
            boolean r5 = r6.hasNext()
            if (r5 == 0) goto L_0x0039
            return r1
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry.equalSevenZMethods(java.lang.Iterable, java.lang.Iterable):boolean");
    }
}
