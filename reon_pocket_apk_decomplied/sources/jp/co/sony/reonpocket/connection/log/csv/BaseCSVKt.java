package jp.co.sony.reonpocket.connection.log.csv;

import kotlin.Metadata;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.QuoteMode;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"WRITER_FORMAT", "Lorg/apache/commons/csv/CSVFormat;", "kotlin.jvm.PlatformType", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseCSV.kt */
public final class BaseCSVKt {
    /* access modifiers changed from: private */
    public static final CSVFormat WRITER_FORMAT = CSVFormat.DEFAULT.withRecordSeparator(10).withQuoteMode(QuoteMode.NON_NUMERIC);
}
