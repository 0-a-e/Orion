package org.apache.commons.csv;

import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.apache.commons.csv.Token;

public final class CSVParser implements Iterable<CSVRecord>, Closeable {
    private final long characterOffset;
    private final CSVRecordIterator csvRecordIterator;
    private final CSVFormat format;
    private final Map<String, Integer> headerMap;
    private final List<String> headerNames;
    private final Lexer lexer;
    private final List<String> recordList;
    private long recordNumber;
    private final Token reusableToken;

    class CSVRecordIterator implements Iterator<CSVRecord> {
        private CSVRecord current;

        CSVRecordIterator() {
        }

        private CSVRecord getNextRecord() {
            try {
                return CSVParser.this.nextRecord();
            } catch (IOException e) {
                throw new IllegalStateException(e.getClass().getSimpleName() + " reading next record: " + e.toString(), e);
            }
        }

        public boolean hasNext() {
            if (CSVParser.this.isClosed()) {
                return false;
            }
            if (this.current == null) {
                this.current = getNextRecord();
            }
            if (this.current != null) {
                return true;
            }
            return false;
        }

        public CSVRecord next() {
            if (!CSVParser.this.isClosed()) {
                CSVRecord cSVRecord = this.current;
                this.current = null;
                if (cSVRecord != null || (cSVRecord = getNextRecord()) != null) {
                    return cSVRecord;
                }
                throw new NoSuchElementException("No more CSV records available");
            }
            throw new NoSuchElementException("CSVParser has been closed");
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static CSVParser parse(File file, Charset charset, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(file, TransferTable.COLUMN_FILE);
        Assertions.notNull(cSVFormat, "format");
        return new CSVParser(new InputStreamReader(new FileInputStream(file), charset), cSVFormat);
    }

    public static CSVParser parse(InputStream inputStream, Charset charset, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(inputStream, "inputStream");
        Assertions.notNull(cSVFormat, "format");
        return parse((Reader) new InputStreamReader(inputStream, charset), cSVFormat);
    }

    public static CSVParser parse(Path path, Charset charset, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(path, "path");
        Assertions.notNull(cSVFormat, "format");
        return parse(Trace$$ExternalSyntheticApiModelOutline0.m(path, new OpenOption[0]), charset, cSVFormat);
    }

    public static CSVParser parse(Reader reader, CSVFormat cSVFormat) throws IOException {
        return new CSVParser(reader, cSVFormat);
    }

    public static CSVParser parse(String str, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(str, "string");
        Assertions.notNull(cSVFormat, "format");
        return new CSVParser(new StringReader(str), cSVFormat);
    }

    public static CSVParser parse(URL url, Charset charset, CSVFormat cSVFormat) throws IOException {
        Assertions.notNull(url, "url");
        Assertions.notNull(charset, "charset");
        Assertions.notNull(cSVFormat, "format");
        return new CSVParser(new InputStreamReader(url.openStream(), charset), cSVFormat);
    }

    public CSVParser(Reader reader, CSVFormat cSVFormat) throws IOException {
        this(reader, cSVFormat, 0, 1);
    }

    public CSVParser(Reader reader, CSVFormat cSVFormat, long j, long j2) throws IOException {
        this.recordList = new ArrayList();
        this.reusableToken = new Token();
        Assertions.notNull(reader, "reader");
        Assertions.notNull(cSVFormat, "format");
        this.format = cSVFormat;
        this.lexer = new Lexer(cSVFormat, new ExtendedBufferedReader(reader));
        this.csvRecordIterator = new CSVRecordIterator();
        Headers createHeaders = createHeaders();
        this.headerMap = createHeaders.headerMap;
        this.headerNames = createHeaders.headerNames;
        this.characterOffset = j;
        this.recordNumber = j2 - 1;
    }

    private void addRecordValue(boolean z) {
        String sb = this.reusableToken.content.toString();
        if (this.format.getTrim()) {
            sb = sb.trim();
        }
        if (!z || !sb.isEmpty() || !this.format.getTrailingDelimiter()) {
            String nullString = this.format.getNullString();
            List<String> list = this.recordList;
            if (sb.equals(nullString)) {
                sb = null;
            }
            list.add(sb);
        }
    }

    public void close() throws IOException {
        Lexer lexer2 = this.lexer;
        if (lexer2 != null) {
            lexer2.close();
        }
    }

    private Map<String, Integer> createEmptyHeaderMap() {
        return this.format.getIgnoreHeaderCase() ? new TreeMap(String.CASE_INSENSITIVE_ORDER) : new LinkedHashMap();
    }

    private static final class Headers {
        final Map<String, Integer> headerMap;
        final List<String> headerNames;

        Headers(Map<String, Integer> map, List<String> list) {
            this.headerMap = map;
            this.headerNames = list;
        }
    }

    private Headers createHeaders() throws IOException {
        Map<String, Integer> map;
        List list;
        boolean z;
        String[] header = this.format.getHeader();
        ArrayList arrayList = null;
        if (header != null) {
            map = createEmptyHeaderMap();
            if (header.length == 0) {
                CSVRecord nextRecord = nextRecord();
                header = nextRecord != null ? nextRecord.values() : null;
            } else if (this.format.getSkipHeaderRecord()) {
                nextRecord();
            }
            if (header != null) {
                for (int i = 0; i < header.length; i++) {
                    String str = header[i];
                    if (str == null) {
                        z = false;
                    } else {
                        z = map.containsKey(str);
                    }
                    boolean z2 = str == null || str.trim().isEmpty();
                    if (z) {
                        if (!z2 && !this.format.getAllowDuplicateHeaderNames()) {
                            throw new IllegalArgumentException(String.format("The header contains a duplicate name: \"%s\" in %s. If this is valid then use CSVFormat.withAllowDuplicateHeaderNames().", new Object[]{str, Arrays.toString(header)}));
                        } else if (z2 && !this.format.getAllowMissingColumnNames()) {
                            throw new IllegalArgumentException("A header name is missing in " + Arrays.toString(header));
                        }
                    }
                    if (str != null) {
                        map.put(str, Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList(header.length);
                        }
                        arrayList.add(str);
                    }
                }
            }
        } else {
            map = null;
        }
        if (arrayList == null) {
            list = Collections.emptyList();
        } else {
            list = Collections.unmodifiableList(arrayList);
        }
        return new Headers(map, list);
    }

    public long getCurrentLineNumber() {
        return this.lexer.getCurrentLineNumber();
    }

    public String getFirstEndOfLine() {
        return this.lexer.getFirstEol();
    }

    public Map<String, Integer> getHeaderMap() {
        if (this.headerMap == null) {
            return null;
        }
        Map<String, Integer> createEmptyHeaderMap = createEmptyHeaderMap();
        createEmptyHeaderMap.putAll(this.headerMap);
        return createEmptyHeaderMap;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Integer> getHeaderMapRaw() {
        return this.headerMap;
    }

    public List<String> getHeaderNames() {
        return this.headerNames;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public List<CSVRecord> getRecords() throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            CSVRecord nextRecord = nextRecord();
            if (nextRecord == null) {
                return arrayList;
            }
            arrayList.add(nextRecord);
        }
    }

    public boolean isClosed() {
        return this.lexer.isClosed();
    }

    public Iterator<CSVRecord> iterator() {
        return this.csvRecordIterator;
    }

    /* access modifiers changed from: package-private */
    public CSVRecord nextRecord() throws IOException {
        this.recordList.clear();
        long characterPosition = this.lexer.getCharacterPosition() + this.characterOffset;
        String str = null;
        StringBuilder sb = null;
        do {
            this.reusableToken.reset();
            this.lexer.nextToken(this.reusableToken);
            int i = AnonymousClass1.$SwitchMap$org$apache$commons$csv$Token$Type[this.reusableToken.type.ordinal()];
            if (i == 1) {
                addRecordValue(false);
            } else if (i == 2) {
                addRecordValue(true);
            } else if (i != 3) {
                if (i == 4) {
                    throw new IOException("(line " + getCurrentLineNumber() + ") invalid parse sequence");
                } else if (i == 5) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        sb.append(10);
                    }
                    sb.append(this.reusableToken.content);
                    this.reusableToken.type = Token.Type.TOKEN;
                } else {
                    throw new IllegalStateException("Unexpected Token type: " + this.reusableToken.type);
                }
            } else if (this.reusableToken.isReady) {
                addRecordValue(true);
            }
        } while (this.reusableToken.type == Token.Type.TOKEN);
        if (this.recordList.isEmpty()) {
            return null;
        }
        this.recordNumber++;
        if (sb != null) {
            str = sb.toString();
        }
        List<String> list = this.recordList;
        return new CSVRecord(this, (String[]) list.toArray(new String[list.size()]), str, this.recordNumber, characterPosition);
    }

    /* renamed from: org.apache.commons.csv.CSVParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$Token$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.apache.commons.csv.Token$Type[] r0 = org.apache.commons.csv.Token.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$csv$Token$Type = r0
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.TOKEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$csv$Token$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.EORECORD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$csv$Token$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.EOF     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$apache$commons$csv$Token$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.INVALID     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$apache$commons$csv$Token$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.COMMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVParser.AnonymousClass1.<clinit>():void");
        }
    }
}
