package org.apache.commons.compress.archivers.dump;

import com.amazonaws.services.s3.model.InstructionFileId;

public class InvalidFormatException extends DumpArchiveException {
    private static final long serialVersionUID = 1;
    protected long offset;

    public InvalidFormatException() {
        super("there was an error decoding a tape segment");
    }

    public InvalidFormatException(long j) {
        super("there was an error decoding a tape segment header at offset " + j + InstructionFileId.DOT);
        this.offset = j;
    }

    public long getOffset() {
        return this.offset;
    }
}
