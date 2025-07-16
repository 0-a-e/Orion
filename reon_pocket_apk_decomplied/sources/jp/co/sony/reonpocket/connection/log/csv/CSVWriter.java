package jp.co.sony.reonpocket.connection.log.csv;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014*\u00028\u0000H&¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/csv/CSVWriter;", "R", "", "aWriter", "Ljava/io/Writer;", "aHeaders", "", "Ljp/co/sony/reonpocket/connection/log/csv/Column;", "aFormat", "Lorg/apache/commons/csv/CSVFormat;", "(Ljava/io/Writer;Ljava/util/List;Lorg/apache/commons/csv/CSVFormat;)V", "mFormat", "kotlin.jvm.PlatformType", "mPrinter", "Lorg/apache/commons/csv/CSVPrinter;", "write", "", "value", "(Ljava/lang/Object;)V", "encode", "", "(Ljava/lang/Object;)Ljava/util/Map;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseCSV.kt */
public abstract class CSVWriter<R> {
    public static final int $stable = 8;
    private final List<Column> aHeaders;
    private final CSVFormat mFormat;
    private final CSVPrinter mPrinter;

    public abstract Map<? extends Column, Object> encode(R r);

    public CSVWriter(Writer writer, List<? extends Column> list, CSVFormat cSVFormat) {
        Intrinsics.checkNotNullParameter(writer, "aWriter");
        Intrinsics.checkNotNullParameter(list, "aHeaders");
        Intrinsics.checkNotNullParameter(cSVFormat, "aFormat");
        this.aHeaders = list;
        Iterable<Column> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Column header : iterable) {
            arrayList.add(header.getHeader());
        }
        String[] strArr = (String[]) ((List) arrayList).toArray(new String[0]);
        CSVFormat withHeader = cSVFormat.withHeader((String[]) Arrays.copyOf(strArr, strArr.length));
        this.mFormat = withHeader;
        CSVPrinter print = withHeader.print(writer);
        Intrinsics.checkNotNullExpressionValue(print, "print(...)");
        this.mPrinter = print;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CSVWriter(java.io.Writer r1, java.util.List r2, org.apache.commons.csv.CSVFormat r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto L_0x000d
            org.apache.commons.csv.CSVFormat r3 = jp.co.sony.reonpocket.connection.log.csv.BaseCSVKt.WRITER_FORMAT
            java.lang.String r4 = "access$getWRITER_FORMAT$p(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x000d:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.csv.CSVWriter.<init>(java.io.Writer, java.util.List, org.apache.commons.csv.CSVFormat, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void write(R r) {
        Map<? extends Column, Object> encode = encode(r);
        CSVPrinter cSVPrinter = this.mPrinter;
        Iterable<Column> iterable = this.aHeaders;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Column column : iterable) {
            arrayList.add(encode.get(column));
        }
        cSVPrinter.printRecord((Iterable<?>) (List) arrayList);
    }
}
