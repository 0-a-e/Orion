package org.apache.commons.csv;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public final class CSVPrinter implements Flushable, Closeable {
    private final CSVFormat format;
    private boolean newRecord = true;
    private final Appendable out;

    public CSVPrinter(Appendable appendable, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(appendable, "out");
        Assertions.notNull(cSVFormat, "format");
        this.out = appendable;
        this.format = cSVFormat;
        if (cSVFormat.getHeaderComments() != null) {
            for (String str : cSVFormat.getHeaderComments()) {
                if (str != null) {
                    printComment(str);
                }
            }
        }
        if (cSVFormat.getHeader() != null && !cSVFormat.getSkipHeaderRecord()) {
            printRecord((Object[]) cSVFormat.getHeader());
        }
    }

    public void close() throws IOException {
        close(false);
    }

    public void close(boolean z) throws IOException {
        if (z || this.format.getAutoFlush()) {
            flush();
        }
        Appendable appendable = this.out;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    public void flush() throws IOException {
        Appendable appendable = this.out;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public Appendable getOut() {
        return this.out;
    }

    public void print(Object obj) throws IOException {
        this.format.print(obj, this.out, this.newRecord);
        this.newRecord = false;
    }

    public void printComment(String str) throws IOException {
        if (this.format.isCommentMarkerSet()) {
            if (!this.newRecord) {
                println();
            }
            this.out.append(this.format.getCommentMarker().charValue());
            this.out.append(' ');
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt != 10) {
                    if (charAt != 13) {
                        this.out.append(charAt);
                        i++;
                    } else {
                        int i2 = i + 1;
                        if (i2 < str.length() && str.charAt(i2) == 10) {
                            i = i2;
                        }
                    }
                }
                println();
                this.out.append(this.format.getCommentMarker().charValue());
                this.out.append(' ');
                i++;
            }
            println();
        }
    }

    public void println() throws IOException {
        this.format.println(this.out);
        this.newRecord = true;
    }

    public void printRecord(Iterable<?> iterable) throws IOException {
        for (Object print : iterable) {
            print(print);
        }
        println();
    }

    public void printRecord(Object... objArr) throws IOException {
        this.format.printRecord(this.out, objArr);
        this.newRecord = true;
    }

    public void printRecords(Iterable<?> iterable) throws IOException {
        for (Object next : iterable) {
            if (next instanceof Object[]) {
                printRecord((Object[]) next);
            } else if (next instanceof Iterable) {
                printRecord((Iterable<?>) (Iterable) next);
            } else {
                printRecord(next);
            }
        }
    }

    public void printRecords(Object... objArr) throws IOException {
        printRecords((Iterable<?>) Arrays.asList(objArr));
    }

    public void printRecords(ResultSet resultSet) throws SQLException, IOException {
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                Object object = resultSet.getObject(i);
                if (object instanceof Clob) {
                    object = ((Clob) object).getCharacterStream();
                }
                print(object);
            }
            println();
        }
    }
}
