package org.apache.commons.csv;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class CSVRecord implements Serializable, Iterable<String> {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final long serialVersionUID = 1;
    private final long characterPosition;
    private final String comment;
    private final CSVParser parser;
    private final long recordNumber;
    private final String[] values;

    CSVRecord(CSVParser cSVParser, String[] strArr, String str, long j, long j2) {
        this.recordNumber = j;
        this.values = strArr == null ? EMPTY_STRING_ARRAY : strArr;
        this.parser = cSVParser;
        this.comment = str;
        this.characterPosition = j2;
    }

    public String get(Enum<?> enumR) {
        return get(enumR.toString());
    }

    public String get(int i) {
        return this.values[i];
    }

    public String get(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        if (headerMapRaw != null) {
            Integer num = headerMapRaw.get(str);
            if (num != null) {
                try {
                    return this.values[num.intValue()];
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new IllegalArgumentException(String.format("Index for header '%s' is %d but CSVRecord only has %d values!", new Object[]{str, num, Integer.valueOf(this.values.length)}));
                }
            } else {
                throw new IllegalArgumentException(String.format("Mapping for %s not found, expected one of %s", new Object[]{str, headerMapRaw.keySet()}));
            }
        } else {
            throw new IllegalStateException("No header mapping was specified, the record values can't be accessed by name");
        }
    }

    public long getCharacterPosition() {
        return this.characterPosition;
    }

    public String getComment() {
        return this.comment;
    }

    private Map<String, Integer> getHeaderMapRaw() {
        return this.parser.getHeaderMapRaw();
    }

    public CSVParser getParser() {
        return this.parser;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public boolean hasComment() {
        return this.comment != null;
    }

    public boolean isConsistent() {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw == null || headerMapRaw.size() == this.values.length;
    }

    public boolean isMapped(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw != null && headerMapRaw.containsKey(str);
    }

    public boolean isSet(String str) {
        return isMapped(str) && getHeaderMapRaw().get(str).intValue() < this.values.length;
    }

    public Iterator<String> iterator() {
        return toList().iterator();
    }

    /* access modifiers changed from: package-private */
    public <M extends Map<String, String>> M putIn(M m) {
        if (getHeaderMapRaw() == null) {
            return m;
        }
        for (Map.Entry next : getHeaderMapRaw().entrySet()) {
            int intValue = ((Integer) next.getValue()).intValue();
            if (intValue < this.values.length) {
                m.put(next.getKey(), this.values[intValue]);
            }
        }
        return m;
    }

    public int size() {
        return this.values.length;
    }

    private List<String> toList() {
        return Arrays.asList(this.values);
    }

    public Map<String, String> toMap() {
        return putIn(new LinkedHashMap(this.values.length));
    }

    public String toString() {
        return "CSVRecord [comment='" + this.comment + "', recordNumber=" + this.recordNumber + ", values=" + Arrays.toString(this.values) + "]";
    }

    /* access modifiers changed from: package-private */
    public String[] values() {
        return this.values;
    }
}
