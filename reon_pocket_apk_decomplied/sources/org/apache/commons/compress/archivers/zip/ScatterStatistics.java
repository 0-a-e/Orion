package org.apache.commons.compress.archivers.zip;

public class ScatterStatistics {
    private final long compressionElapsed;
    private final long mergingElapsed;

    ScatterStatistics(long j, long j2) {
        this.compressionElapsed = j;
        this.mergingElapsed = j2;
    }

    public long getCompressionElapsed() {
        return this.compressionElapsed;
    }

    public long getMergingElapsed() {
        return this.mergingElapsed;
    }

    public String toString() {
        return "compressionElapsed=" + this.compressionElapsed + "ms, mergingElapsed=" + this.mergingElapsed + "ms";
    }
}
