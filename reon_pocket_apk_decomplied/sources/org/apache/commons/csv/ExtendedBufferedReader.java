package org.apache.commons.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

final class ExtendedBufferedReader extends BufferedReader {
    private boolean closed;
    private long eolCounter;
    private int lastChar = -2;
    private long position;

    ExtendedBufferedReader(Reader reader) {
        super(reader);
    }

    public int read() throws IOException {
        int read = super.read();
        if (read == 13 || (read == 10 && this.lastChar != 13)) {
            this.eolCounter++;
        }
        this.lastChar = read;
        this.position++;
        return read;
    }

    /* access modifiers changed from: package-private */
    public int getLastChar() {
        return this.lastChar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            if (r9 != 0) goto L_0x0004
            r7 = 0
            return r7
        L_0x0004:
            int r9 = super.read(r7, r8, r9)
            if (r9 <= 0) goto L_0x003b
            r0 = r8
        L_0x000b:
            int r1 = r8 + r9
            if (r0 >= r1) goto L_0x0034
            char r1 = r7[r0]
            r2 = 10
            r3 = 1
            r5 = 13
            if (r1 != r2) goto L_0x002a
            if (r0 <= 0) goto L_0x0020
            int r1 = r0 + -1
            char r1 = r7[r1]
            goto L_0x0022
        L_0x0020:
            int r1 = r6.lastChar
        L_0x0022:
            if (r5 == r1) goto L_0x0031
            long r1 = r6.eolCounter
            long r1 = r1 + r3
            r6.eolCounter = r1
            goto L_0x0031
        L_0x002a:
            if (r1 != r5) goto L_0x0031
            long r1 = r6.eolCounter
            long r1 = r1 + r3
            r6.eolCounter = r1
        L_0x0031:
            int r0 = r0 + 1
            goto L_0x000b
        L_0x0034:
            int r1 = r1 + -1
            char r7 = r7[r1]
            r6.lastChar = r7
            goto L_0x0040
        L_0x003b:
            r7 = -1
            if (r9 != r7) goto L_0x0040
            r6.lastChar = r7
        L_0x0040:
            long r7 = r6.position
            long r0 = (long) r9
            long r7 = r7 + r0
            r6.position = r7
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.ExtendedBufferedReader.read(char[], int, int):int");
    }

    public String readLine() throws IOException {
        String readLine = super.readLine();
        if (readLine != null) {
            this.lastChar = 10;
            this.eolCounter++;
        } else {
            this.lastChar = -1;
        }
        return readLine;
    }

    /* access modifiers changed from: package-private */
    public int lookAhead() throws IOException {
        super.mark(1);
        int read = super.read();
        super.reset();
        return read;
    }

    /* access modifiers changed from: package-private */
    public long getCurrentLineNumber() {
        int i = this.lastChar;
        if (i == 13 || i == 10 || i == -2 || i == -1) {
            return this.eolCounter;
        }
        return this.eolCounter + 1;
    }

    /* access modifiers changed from: package-private */
    public long getPosition() {
        return this.position;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void close() throws IOException {
        this.closed = true;
        this.lastChar = -1;
        super.close();
    }
}
