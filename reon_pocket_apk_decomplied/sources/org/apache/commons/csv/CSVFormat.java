package org.apache.commons.csv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.text.Typography;

public final class CSVFormat implements Serializable {
    public static final CSVFormat DEFAULT;
    public static final CSVFormat EXCEL;
    public static final CSVFormat INFORMIX_UNLOAD;
    public static final CSVFormat INFORMIX_UNLOAD_CSV;
    public static final CSVFormat MONGODB_CSV;
    public static final CSVFormat MONGODB_TSV;
    public static final CSVFormat MYSQL;
    public static final CSVFormat ORACLE;
    public static final CSVFormat POSTGRESQL_CSV;
    public static final CSVFormat POSTGRESQL_TEXT;
    public static final CSVFormat RFC4180;
    public static final CSVFormat TDF;
    private static final long serialVersionUID = 1;
    private final boolean allowDuplicateHeaderNames;
    private final boolean allowMissingColumnNames;
    private final boolean autoFlush;
    private final Character commentMarker;
    private final char delimiter;
    private final Character escapeCharacter;
    private final String[] header;
    private final String[] headerComments;
    private final boolean ignoreEmptyLines;
    private final boolean ignoreHeaderCase;
    private final boolean ignoreSurroundingSpaces;
    private final String nullString;
    private final Character quoteCharacter;
    private final QuoteMode quoteMode;
    private final String quotedNullString;
    private final String recordSeparator;
    private final boolean skipHeaderRecord;
    private final boolean trailingDelimiter;
    private final boolean trim;

    private static boolean isLineBreak(char c) {
        return c == 10 || c == 13;
    }

    public enum Predefined {
        Default(CSVFormat.DEFAULT),
        Excel(CSVFormat.EXCEL),
        InformixUnload(CSVFormat.INFORMIX_UNLOAD),
        InformixUnloadCsv(CSVFormat.INFORMIX_UNLOAD_CSV),
        MongoDBCsv(CSVFormat.MONGODB_CSV),
        MongoDBTsv(CSVFormat.MONGODB_TSV),
        MySQL(CSVFormat.MYSQL),
        Oracle(CSVFormat.ORACLE),
        PostgreSQLCsv(CSVFormat.POSTGRESQL_CSV),
        PostgreSQLText(CSVFormat.POSTGRESQL_TEXT),
        RFC4180(CSVFormat.RFC4180),
        TDF(CSVFormat.TDF);
        
        private final CSVFormat format;

        private Predefined(CSVFormat cSVFormat) {
            this.format = cSVFormat;
        }

        public CSVFormat getFormat() {
            return this.format;
        }
    }

    static {
        CSVFormat cSVFormat = r0;
        CSVFormat cSVFormat2 = new CSVFormat(',', Constants.DOUBLE_QUOTE_CHAR, (QuoteMode) null, (Character) null, (Character) null, false, true, "\r\n", (String) null, (Object[]) null, (String[]) null, false, false, false, false, false, false, true);
        CSVFormat cSVFormat3 = cSVFormat;
        DEFAULT = cSVFormat3;
        EXCEL = cSVFormat3.withIgnoreEmptyLines(false).withAllowMissingColumnNames();
        INFORMIX_UNLOAD = cSVFormat3.withDelimiter('|').withEscape('\\').withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator(10);
        INFORMIX_UNLOAD_CSV = cSVFormat3.withDelimiter(',').withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator(10);
        MONGODB_CSV = cSVFormat3.withDelimiter(',').withEscape(Constants.DOUBLE_QUOTE_CHAR).withQuote(Constants.DOUBLE_QUOTE_CHAR).withQuoteMode(QuoteMode.MINIMAL).withSkipHeaderRecord(false);
        MONGODB_TSV = cSVFormat3.withDelimiter(9).withEscape(Constants.DOUBLE_QUOTE_CHAR).withQuote(Constants.DOUBLE_QUOTE_CHAR).withQuoteMode(QuoteMode.MINIMAL).withSkipHeaderRecord(false);
        MYSQL = cSVFormat3.withDelimiter(9).withEscape('\\').withIgnoreEmptyLines(false).withQuote((Character) null).withRecordSeparator(10).withNullString("\\N").withQuoteMode(QuoteMode.ALL_NON_NULL);
        ORACLE = cSVFormat3.withDelimiter(',').withEscape('\\').withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withNullString("\\N").withTrim().withSystemRecordSeparator().withQuoteMode(QuoteMode.MINIMAL);
        POSTGRESQL_CSV = cSVFormat3.withDelimiter(',').withEscape(Constants.DOUBLE_QUOTE_CHAR).withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator(10).withNullString("").withQuoteMode(QuoteMode.ALL_NON_NULL);
        POSTGRESQL_TEXT = cSVFormat3.withDelimiter(9).withEscape('\\').withIgnoreEmptyLines(false).withQuote(Constants.DOUBLE_QUOTE_CHAR).withRecordSeparator(10).withNullString("\\N").withQuoteMode(QuoteMode.ALL_NON_NULL);
        RFC4180 = cSVFormat3.withIgnoreEmptyLines(false);
        TDF = cSVFormat3.withDelimiter(9).withIgnoreSurroundingSpaces();
    }

    private static boolean isLineBreak(Character ch) {
        return ch != null && isLineBreak(ch.charValue());
    }

    public static CSVFormat newFormat(char c) {
        return new CSVFormat(c, (Character) null, (QuoteMode) null, (Character) null, (Character) null, false, false, (String) null, (String) null, (Object[]) null, (String[]) null, false, false, false, false, false, false, true);
    }

    public static CSVFormat valueOf(String str) {
        return Predefined.valueOf(str).getFormat();
    }

    private CSVFormat(char c, Character ch, QuoteMode quoteMode2, Character ch2, Character ch3, boolean z, boolean z2, String str, String str2, Object[] objArr, String[] strArr, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        String[] strArr2;
        this.delimiter = c;
        this.quoteCharacter = ch;
        this.quoteMode = quoteMode2;
        this.commentMarker = ch2;
        this.escapeCharacter = ch3;
        this.ignoreSurroundingSpaces = z;
        this.allowMissingColumnNames = z4;
        this.ignoreEmptyLines = z2;
        this.recordSeparator = str;
        this.nullString = str2;
        Object[] objArr2 = objArr;
        this.headerComments = toStringArray(objArr);
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) strArr.clone();
        }
        this.header = strArr2;
        this.skipHeaderRecord = z3;
        this.ignoreHeaderCase = z5;
        this.trailingDelimiter = z7;
        this.trim = z6;
        this.autoFlush = z8;
        this.quotedNullString = ch + str2 + ch;
        this.allowDuplicateHeaderNames = z9;
        validate();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CSVFormat cSVFormat = (CSVFormat) obj;
        if (this.delimiter != cSVFormat.delimiter || this.quoteMode != cSVFormat.quoteMode) {
            return false;
        }
        Character ch = this.quoteCharacter;
        if (ch == null) {
            if (cSVFormat.quoteCharacter != null) {
                return false;
            }
        } else if (!ch.equals(cSVFormat.quoteCharacter)) {
            return false;
        }
        Character ch2 = this.commentMarker;
        if (ch2 == null) {
            if (cSVFormat.commentMarker != null) {
                return false;
            }
        } else if (!ch2.equals(cSVFormat.commentMarker)) {
            return false;
        }
        Character ch3 = this.escapeCharacter;
        if (ch3 == null) {
            if (cSVFormat.escapeCharacter != null) {
                return false;
            }
        } else if (!ch3.equals(cSVFormat.escapeCharacter)) {
            return false;
        }
        String str = this.nullString;
        if (str == null) {
            if (cSVFormat.nullString != null) {
                return false;
            }
        } else if (!str.equals(cSVFormat.nullString)) {
            return false;
        }
        if (!Arrays.equals(this.header, cSVFormat.header) || this.ignoreSurroundingSpaces != cSVFormat.ignoreSurroundingSpaces || this.ignoreEmptyLines != cSVFormat.ignoreEmptyLines || this.skipHeaderRecord != cSVFormat.skipHeaderRecord) {
            return false;
        }
        String str2 = this.recordSeparator;
        if (str2 == null) {
            if (cSVFormat.recordSeparator != null) {
                return false;
            }
        } else if (!str2.equals(cSVFormat.recordSeparator)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String format(java.lang.Object... r3) {
        /*
            r2 = this;
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            org.apache.commons.csv.CSVPrinter r1 = new org.apache.commons.csv.CSVPrinter     // Catch:{ IOException -> 0x0025 }
            r1.<init>(r0, r2)     // Catch:{ IOException -> 0x0025 }
            r1.printRecord((java.lang.Object[]) r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x0019 }
            r1.close()     // Catch:{ IOException -> 0x0025 }
            return r3
        L_0x0019:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001b }
        L_0x001b:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r1 = move-exception
            r3.addSuppressed(r1)     // Catch:{ IOException -> 0x0025 }
        L_0x0024:
            throw r0     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            r3 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVFormat.format(java.lang.Object[]):java.lang.String");
    }

    public boolean getAllowDuplicateHeaderNames() {
        return this.allowDuplicateHeaderNames;
    }

    public boolean getAllowMissingColumnNames() {
        return this.allowMissingColumnNames;
    }

    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public Character getCommentMarker() {
        return this.commentMarker;
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public Character getEscapeCharacter() {
        return this.escapeCharacter;
    }

    public String[] getHeader() {
        String[] strArr = this.header;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public String[] getHeaderComments() {
        String[] strArr = this.headerComments;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public boolean getIgnoreEmptyLines() {
        return this.ignoreEmptyLines;
    }

    public boolean getIgnoreHeaderCase() {
        return this.ignoreHeaderCase;
    }

    public boolean getIgnoreSurroundingSpaces() {
        return this.ignoreSurroundingSpaces;
    }

    public String getNullString() {
        return this.nullString;
    }

    public Character getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public QuoteMode getQuoteMode() {
        return this.quoteMode;
    }

    public String getRecordSeparator() {
        return this.recordSeparator;
    }

    public boolean getSkipHeaderRecord() {
        return this.skipHeaderRecord;
    }

    public boolean getTrailingDelimiter() {
        return this.trailingDelimiter;
    }

    public boolean getTrim() {
        return this.trim;
    }

    public int hashCode() {
        int i = (this.delimiter + 31) * 31;
        QuoteMode quoteMode2 = this.quoteMode;
        int i2 = 0;
        int hashCode = (i + (quoteMode2 == null ? 0 : quoteMode2.hashCode())) * 31;
        Character ch = this.quoteCharacter;
        int hashCode2 = (hashCode + (ch == null ? 0 : ch.hashCode())) * 31;
        Character ch2 = this.commentMarker;
        int hashCode3 = (hashCode2 + (ch2 == null ? 0 : ch2.hashCode())) * 31;
        Character ch3 = this.escapeCharacter;
        int hashCode4 = (hashCode3 + (ch3 == null ? 0 : ch3.hashCode())) * 31;
        String str = this.nullString;
        int i3 = 1231;
        int hashCode5 = (((((((hashCode4 + (str == null ? 0 : str.hashCode())) * 31) + (this.ignoreSurroundingSpaces ? 1231 : 1237)) * 31) + (this.ignoreHeaderCase ? 1231 : 1237)) * 31) + (this.ignoreEmptyLines ? 1231 : 1237)) * 31;
        if (!this.skipHeaderRecord) {
            i3 = 1237;
        }
        int i4 = (hashCode5 + i3) * 31;
        String str2 = this.recordSeparator;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((i4 + i2) * 31) + Arrays.hashCode(this.header);
    }

    public boolean isCommentMarkerSet() {
        return this.commentMarker != null;
    }

    public boolean isEscapeCharacterSet() {
        return this.escapeCharacter != null;
    }

    public boolean isNullStringSet() {
        return this.nullString != null;
    }

    public boolean isQuoteCharacterSet() {
        return this.quoteCharacter != null;
    }

    public CSVParser parse(Reader reader) throws IOException {
        return new CSVParser(reader, this);
    }

    public CSVPrinter print(Appendable appendable) throws IOException {
        return new CSVPrinter(appendable, this);
    }

    public CSVPrinter print(File file, Charset charset) throws IOException {
        return new CSVPrinter(new OutputStreamWriter(new FileOutputStream(file), charset), this);
    }

    public void print(Object obj, Appendable appendable, boolean z) throws IOException {
        CharSequence charSequence;
        if (obj == null) {
            if (this.nullString == null) {
                charSequence = "";
            } else if (QuoteMode.ALL == this.quoteMode) {
                charSequence = this.quotedNullString;
            } else {
                charSequence = this.nullString;
            }
        } else if (obj instanceof CharSequence) {
            charSequence = (CharSequence) obj;
        } else if (obj instanceof Reader) {
            print((Reader) obj, appendable, z);
            return;
        } else {
            charSequence = obj.toString();
        }
        if (getTrim()) {
            charSequence = trim(charSequence);
        }
        print(obj, charSequence, appendable, z);
    }

    private void print(Object obj, CharSequence charSequence, Appendable appendable, boolean z) throws IOException {
        int length = charSequence.length();
        if (!z) {
            appendable.append(getDelimiter());
        }
        if (obj == null) {
            appendable.append(charSequence);
        } else if (isQuoteCharacterSet()) {
            printWithQuotes(obj, charSequence, appendable, z);
        } else if (isEscapeCharacterSet()) {
            printWithEscapes(charSequence, appendable);
        } else {
            appendable.append(charSequence, 0, length);
        }
    }

    public CSVPrinter print(Path path, Charset charset) throws IOException {
        return print(Files.newBufferedWriter(path, charset, new OpenOption[0]));
    }

    private void print(Reader reader, Appendable appendable, boolean z) throws IOException {
        if (!z) {
            appendable.append(getDelimiter());
        }
        if (isQuoteCharacterSet()) {
            printWithQuotes(reader, appendable);
        } else if (isEscapeCharacterSet()) {
            printWithEscapes(reader, appendable);
        } else if (appendable instanceof Writer) {
            IOUtils.copyLarge(reader, (Writer) appendable);
        } else {
            IOUtils.copy(reader, appendable);
        }
    }

    public CSVPrinter printer() throws IOException {
        return new CSVPrinter(System.out, this);
    }

    public void println(Appendable appendable) throws IOException {
        if (getTrailingDelimiter()) {
            appendable.append(getDelimiter());
        }
        String str = this.recordSeparator;
        if (str != null) {
            appendable.append(str);
        }
    }

    public void printRecord(Appendable appendable, Object... objArr) throws IOException {
        int i = 0;
        while (i < objArr.length) {
            print(objArr[i], appendable, i == 0);
            i++;
        }
        println(appendable);
    }

    private void printWithEscapes(CharSequence charSequence, Appendable appendable) throws IOException {
        int length = charSequence.length();
        char delimiter2 = getDelimiter();
        char charValue = getEscapeCharacter().charValue();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt == 13 || charAt == 10 || charAt == delimiter2 || charAt == charValue) {
                if (i > i2) {
                    appendable.append(charSequence, i2, i);
                }
                if (charAt == 10) {
                    charAt = 'n';
                } else if (charAt == 13) {
                    charAt = 'r';
                }
                appendable.append(charValue);
                appendable.append(charAt);
                i2 = i + 1;
            }
            i++;
        }
        if (i > i2) {
            appendable.append(charSequence, i2, i);
        }
    }

    private void printWithEscapes(Reader reader, Appendable appendable) throws IOException {
        char delimiter2 = getDelimiter();
        char charValue = getEscapeCharacter().charValue();
        StringBuilder sb = new StringBuilder(4096);
        int i = 0;
        int i2 = 0;
        while (true) {
            int read = reader.read();
            if (-1 == read) {
                break;
            }
            sb.append((char) read);
            if (read == 13 || read == 10 || read == delimiter2 || read == charValue) {
                if (i > i2) {
                    appendable.append(sb.substring(i2, i));
                    sb.setLength(0);
                }
                if (read == 10) {
                    read = 110;
                } else if (read == 13) {
                    read = 114;
                }
                appendable.append(charValue);
                appendable.append((char) read);
                i2 = i + 1;
            }
            i++;
        }
        if (i > i2) {
            appendable.append(sb.substring(i2, i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
        if (r10.charAt(r9) <= ' ') goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void printWithQuotes(java.lang.Object r9, java.lang.CharSequence r10, java.lang.Appendable r11, boolean r12) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r10.length()
            char r1 = r8.getDelimiter()
            java.lang.Character r2 = r8.getQuoteCharacter()
            char r2 = r2.charValue()
            org.apache.commons.csv.QuoteMode r3 = r8.getQuoteMode()
            if (r3 != 0) goto L_0x0018
            org.apache.commons.csv.QuoteMode r3 = org.apache.commons.csv.QuoteMode.MINIMAL
        L_0x0018:
            int[] r4 = org.apache.commons.csv.CSVFormat.AnonymousClass1.$SwitchMap$org$apache$commons$csv$QuoteMode
            int r5 = r3.ordinal()
            r4 = r4[r5]
            r5 = 1
            r6 = 0
            if (r4 == r5) goto L_0x008b
            r7 = 2
            if (r4 == r7) goto L_0x008b
            r7 = 3
            if (r4 == r7) goto L_0x0088
            r9 = 4
            if (r4 == r9) goto L_0x0084
            r9 = 5
            if (r4 != r9) goto L_0x0070
            if (r0 > 0) goto L_0x0038
            if (r12 == 0) goto L_0x0035
            goto L_0x0040
        L_0x0035:
            r9 = r6
            r5 = r9
            goto L_0x006a
        L_0x0038:
            char r9 = r10.charAt(r6)
            r12 = 35
            if (r9 > r12) goto L_0x0042
        L_0x0040:
            r9 = r6
            goto L_0x006a
        L_0x0042:
            r9 = r6
        L_0x0043:
            if (r9 >= r0) goto L_0x005b
            char r12 = r10.charAt(r9)
            r3 = 10
            if (r12 == r3) goto L_0x0059
            r3 = 13
            if (r12 == r3) goto L_0x0059
            if (r12 == r2) goto L_0x0059
            if (r12 != r1) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            int r9 = r9 + 1
            goto L_0x0043
        L_0x0059:
            r12 = r5
            goto L_0x005c
        L_0x005b:
            r12 = r6
        L_0x005c:
            if (r12 != 0) goto L_0x0069
            int r9 = r0 + -1
            char r1 = r10.charAt(r9)
            r3 = 32
            if (r1 > r3) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r5 = r12
        L_0x006a:
            if (r5 != 0) goto L_0x008c
            r11.append(r10, r6, r0)
            return
        L_0x0070:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Unexpected Quote value: "
            r10.<init>(r11)
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0084:
            r8.printWithEscapes((java.lang.CharSequence) r10, (java.lang.Appendable) r11)
            return
        L_0x0088:
            boolean r9 = r9 instanceof java.lang.Number
            r5 = r5 ^ r9
        L_0x008b:
            r9 = r6
        L_0x008c:
            if (r5 != 0) goto L_0x0092
            r11.append(r10, r6, r0)
            return
        L_0x0092:
            r11.append(r2)
        L_0x0095:
            if (r9 >= r0) goto L_0x00a6
            char r12 = r10.charAt(r9)
            if (r12 != r2) goto L_0x00a3
            int r12 = r9 + 1
            r11.append(r10, r6, r12)
            r6 = r9
        L_0x00a3:
            int r9 = r9 + 1
            goto L_0x0095
        L_0x00a6:
            r11.append(r10, r6, r9)
            r11.append(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVFormat.printWithQuotes(java.lang.Object, java.lang.CharSequence, java.lang.Appendable, boolean):void");
    }

    /* renamed from: org.apache.commons.csv.CSVFormat$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$QuoteMode;

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
                org.apache.commons.csv.QuoteMode[] r0 = org.apache.commons.csv.QuoteMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$csv$QuoteMode = r0
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$csv$QuoteMode     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.ALL_NON_NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$csv$QuoteMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.NON_NUMERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$apache$commons$csv$QuoteMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$apache$commons$csv$QuoteMode     // Catch:{ NoSuchFieldError -> 0x003e }
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.MINIMAL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVFormat.AnonymousClass1.<clinit>():void");
        }
    }

    private void printWithQuotes(Reader reader, Appendable appendable) throws IOException {
        if (getQuoteMode() == QuoteMode.NONE) {
            printWithEscapes(reader, appendable);
            return;
        }
        char charValue = getQuoteCharacter().charValue();
        StringBuilder sb = new StringBuilder(4096);
        appendable.append(charValue);
        int i = 0;
        while (true) {
            int read = reader.read();
            if (-1 == read) {
                break;
            }
            char c = (char) read;
            sb.append(c);
            if (read == charValue) {
                if (i > 0) {
                    appendable.append(sb.substring(0, i));
                    sb.setLength(0);
                    i = -1;
                }
                appendable.append(charValue);
                appendable.append(c);
            }
            i++;
        }
        if (i > 0) {
            appendable.append(sb.substring(0, i));
        }
        appendable.append(charValue);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Delimiter=<");
        sb.append(this.delimiter);
        sb.append(Typography.greater);
        if (isEscapeCharacterSet()) {
            sb.append(" Escape=<");
            sb.append(this.escapeCharacter);
            sb.append(Typography.greater);
        }
        if (isQuoteCharacterSet()) {
            sb.append(" QuoteChar=<");
            sb.append(this.quoteCharacter);
            sb.append(Typography.greater);
        }
        if (isCommentMarkerSet()) {
            sb.append(" CommentStart=<");
            sb.append(this.commentMarker);
            sb.append(Typography.greater);
        }
        if (isNullStringSet()) {
            sb.append(" NullString=<");
            sb.append(this.nullString);
            sb.append(Typography.greater);
        }
        if (this.recordSeparator != null) {
            sb.append(" RecordSeparator=<");
            sb.append(this.recordSeparator);
            sb.append(Typography.greater);
        }
        if (getIgnoreEmptyLines()) {
            sb.append(" EmptyLines:ignored");
        }
        if (getIgnoreSurroundingSpaces()) {
            sb.append(" SurroundingSpaces:ignored");
        }
        if (getIgnoreHeaderCase()) {
            sb.append(" IgnoreHeaderCase:ignored");
        }
        sb.append(" SkipHeaderRecord:");
        sb.append(this.skipHeaderRecord);
        if (this.headerComments != null) {
            sb.append(" HeaderComments:");
            sb.append(Arrays.toString(this.headerComments));
        }
        if (this.header != null) {
            sb.append(" Header:");
            sb.append(Arrays.toString(this.header));
        }
        return sb.toString();
    }

    private String[] toStringArray(Object[] objArr) {
        String str;
        if (objArr == null) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                str = null;
            } else {
                str = obj.toString();
            }
            strArr[i] = str;
        }
        return strArr;
    }

    private CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) <= ' ') {
            i++;
        }
        int i2 = length;
        while (i < i2 && charSequence.charAt(i2 - 1) <= ' ') {
            i2--;
        }
        return (i > 0 || i2 < length) ? charSequence.subSequence(i, i2) : charSequence;
    }

    private void validate() throws IllegalArgumentException {
        if (!isLineBreak(this.delimiter)) {
            Character ch = this.quoteCharacter;
            if (ch == null || this.delimiter != ch.charValue()) {
                Character ch2 = this.escapeCharacter;
                if (ch2 == null || this.delimiter != ch2.charValue()) {
                    Character ch3 = this.commentMarker;
                    if (ch3 == null || this.delimiter != ch3.charValue()) {
                        Character ch4 = this.quoteCharacter;
                        if (ch4 == null || !ch4.equals(this.commentMarker)) {
                            Character ch5 = this.escapeCharacter;
                            if (ch5 != null && ch5.equals(this.commentMarker)) {
                                throw new IllegalArgumentException("The comment start and the escape character cannot be the same ('" + this.commentMarker + "')");
                            } else if (this.escapeCharacter == null && this.quoteMode == QuoteMode.NONE) {
                                throw new IllegalArgumentException("No quotes mode set but no escape character is set");
                            } else if (this.header != null) {
                                HashSet hashSet = new HashSet();
                                String[] strArr = this.header;
                                int length = strArr.length;
                                int i = 0;
                                while (i < length) {
                                    String str = strArr[i];
                                    if (hashSet.add(str)) {
                                        i++;
                                    } else {
                                        throw new IllegalArgumentException("The header contains a duplicate entry: '" + str + "' in " + Arrays.toString(this.header));
                                    }
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("The comment start character and the quoteChar cannot be the same ('" + this.commentMarker + "')");
                        }
                    } else {
                        throw new IllegalArgumentException("The comment start character and the delimiter cannot be the same ('" + this.commentMarker + "')");
                    }
                } else {
                    throw new IllegalArgumentException("The escape character and the delimiter cannot be the same ('" + this.escapeCharacter + "')");
                }
            } else {
                throw new IllegalArgumentException("The quoteChar character and the delimiter cannot be the same ('" + this.quoteCharacter + "')");
            }
        } else {
            throw new IllegalArgumentException("The delimiter cannot be a line break");
        }
    }

    public CSVFormat withAllowDuplicateHeaderNames() {
        return withAllowDuplicateHeaderNames(true);
    }

    public CSVFormat withAllowDuplicateHeaderNames(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, z);
    }

    public CSVFormat withAllowMissingColumnNames() {
        return withAllowMissingColumnNames(true);
    }

    public CSVFormat withAllowMissingColumnNames(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, z, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withAutoFlush(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, z, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withCommentMarker(char c) {
        return withCommentMarker(Character.valueOf(c));
    }

    public CSVFormat withCommentMarker(Character ch) {
        if (!isLineBreak(ch)) {
            return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, ch, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
        }
        throw new IllegalArgumentException("The comment start marker character cannot be a line break");
    }

    public CSVFormat withDelimiter(char c) {
        if (!isLineBreak(c)) {
            return new CSVFormat(c, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
        }
        throw new IllegalArgumentException("The delimiter cannot be a line break");
    }

    public CSVFormat withEscape(char c) {
        return withEscape(Character.valueOf(c));
    }

    public CSVFormat withEscape(Character ch) {
        if (!isLineBreak(ch)) {
            return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, ch, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
        }
        throw new IllegalArgumentException("The escape character cannot be a line break");
    }

    public CSVFormat withFirstRecordAsHeader() {
        return withHeader(new String[0]).withSkipHeaderRecord();
    }

    public CSVFormat withHeader(Class<? extends Enum<?>> cls) {
        String[] strArr;
        if (cls != null) {
            Enum[] enumArr = (Enum[]) cls.getEnumConstants();
            strArr = new String[enumArr.length];
            for (int i = 0; i < enumArr.length; i++) {
                strArr[i] = enumArr[i].name();
            }
        } else {
            strArr = null;
        }
        return withHeader(strArr);
    }

    public CSVFormat withHeader(ResultSet resultSet) throws SQLException {
        return withHeader(resultSet != null ? resultSet.getMetaData() : null);
    }

    public CSVFormat withHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
        String[] strArr;
        if (resultSetMetaData != null) {
            int columnCount = resultSetMetaData.getColumnCount();
            strArr = new String[columnCount];
            int i = 0;
            while (i < columnCount) {
                int i2 = i + 1;
                strArr[i] = resultSetMetaData.getColumnLabel(i2);
                i = i2;
            }
        } else {
            strArr = null;
        }
        return withHeader(strArr);
    }

    public CSVFormat withHeader(String... strArr) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, strArr, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withHeaderComments(Object... objArr) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, objArr, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreEmptyLines() {
        return withIgnoreEmptyLines(true);
    }

    public CSVFormat withIgnoreEmptyLines(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, z, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreHeaderCase() {
        return withIgnoreHeaderCase(true);
    }

    public CSVFormat withIgnoreHeaderCase(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, z, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withIgnoreSurroundingSpaces() {
        return withIgnoreSurroundingSpaces(true);
    }

    public CSVFormat withIgnoreSurroundingSpaces(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, z, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withNullString(String str) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, str, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withQuote(char c) {
        return withQuote(Character.valueOf(c));
    }

    public CSVFormat withQuote(Character ch) {
        if (!isLineBreak(ch)) {
            return new CSVFormat(this.delimiter, ch, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
        }
        throw new IllegalArgumentException("The quoteChar cannot be a line break");
    }

    public CSVFormat withQuoteMode(QuoteMode quoteMode2) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, quoteMode2, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withRecordSeparator(char c) {
        return withRecordSeparator(String.valueOf(c));
    }

    public CSVFormat withRecordSeparator(String str) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, str, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withSkipHeaderRecord() {
        return withSkipHeaderRecord(true);
    }

    public CSVFormat withSkipHeaderRecord(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, z, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withSystemRecordSeparator() {
        return withRecordSeparator(System.getProperty("line.separator"));
    }

    public CSVFormat withTrailingDelimiter() {
        return withTrailingDelimiter(true);
    }

    public CSVFormat withTrailingDelimiter(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, this.trim, z, this.autoFlush, this.allowDuplicateHeaderNames);
    }

    public CSVFormat withTrim() {
        return withTrim(true);
    }

    public CSVFormat withTrim(boolean z) {
        return new CSVFormat(this.delimiter, this.quoteCharacter, this.quoteMode, this.commentMarker, this.escapeCharacter, this.ignoreSurroundingSpaces, this.ignoreEmptyLines, this.recordSeparator, this.nullString, this.headerComments, this.header, this.skipHeaderRecord, this.allowMissingColumnNames, this.ignoreHeaderCase, z, this.trailingDelimiter, this.autoFlush, this.allowDuplicateHeaderNames);
    }
}
