package jp.co.sony.reonpocket.connection.log.logcat;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\rH@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u000bH@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/logcat/LogCatFileRepository;", "", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "dateFormatDate", "Ljava/text/SimpleDateFormat;", "dateFormatTime", "externalStorageDownload", "Ljava/io/File;", "deleteAllLogFiles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilesInExternalStorageDownload", "", "getLatestHHmmssLogFile", "logfiles", "getLogFiles", "getLogFilesNameStartWithMatch", "fileName", "", "getTargetLogFile", "isFileSizeOverLimitSize", "", "file", "limitSize", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatFileRepository.kt */
public final class LogCatFileRepository {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FILE_EXTENSION = "txt";
    private static final String FILE_NAME_FORMAT_DATE = "yyyyMMdd";
    private static final String FILE_NAME_FORMAT_TIME = "HHmmss";
    private static final String FILE_NAME_PREFIX = "logcat";
    public static final int MAX_LOG_FILE_SIZE_BYTE = 10000000;
    /* access modifiers changed from: private */
    public final SimpleDateFormat dateFormatDate;
    /* access modifiers changed from: private */
    public final SimpleDateFormat dateFormatTime;
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    public final File externalStorageDownload;

    public LogCatFileRepository(Context context, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.dispatcher = coroutineDispatcher;
        this.externalStorageDownload = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FILE_NAME_FORMAT_DATE, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        this.dateFormatDate = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(FILE_NAME_FORMAT_TIME, Locale.getDefault());
        simpleDateFormat2.setTimeZone(TimeZone.getDefault());
        this.dateFormatTime = simpleDateFormat2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogCatFileRepository(Context context, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final Object getLogFiles(Continuation<? super List<? extends File>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new LogCatFileRepository$getLogFiles$2(this, (Continuation<? super LogCatFileRepository$getLogFiles$2>) null), continuation);
    }

    public final Object getTargetLogFile(Continuation<? super File> continuation) {
        return BuildersKt.withContext(this.dispatcher, new LogCatFileRepository$getTargetLogFile$2(this, (Continuation<? super LogCatFileRepository$getTargetLogFile$2>) null), continuation);
    }

    public final Object deleteAllLogFiles(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatcher, new LogCatFileRepository$deleteAllLogFiles$2(this, (Continuation<? super LogCatFileRepository$deleteAllLogFiles$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    static /* synthetic */ boolean isFileSizeOverLimitSize$default(LogCatFileRepository logCatFileRepository, File file, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = MAX_LOG_FILE_SIZE_BYTE;
        }
        return logCatFileRepository.isFileSizeOverLimitSize(file, i);
    }

    private final boolean isFileSizeOverLimitSize(File file, int i) {
        return file.length() > ((long) i);
    }

    /* access modifiers changed from: private */
    public final File getLatestHHmmssLogFile(List<? extends File> list) {
        if (list.isEmpty()) {
            return null;
        }
        Iterable<File> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (File file : iterable) {
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            arrayList.add(new Pair(file, StringsKt.replace$default((String) StringsKt.split$default((CharSequence) name, new String[]{"_"}, false, 0, 6, (Object) null).get(2), ".txt", "", false, 4, (Object) null)));
        }
        Iterator it = ((List) arrayList).iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int parseInt = Integer.parseInt((String) ((Pair) next).component2());
                do {
                    Object next2 = it.next();
                    int parseInt2 = Integer.parseInt((String) ((Pair) next2).component2());
                    if (parseInt < parseInt2) {
                        next = next2;
                        parseInt = parseInt2;
                    }
                } while (it.hasNext());
            }
            return (File) ((Pair) next).component1();
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    public final List<File> getLogFilesNameStartWithMatch(String str) {
        Collection arrayList = new ArrayList();
        for (Object next : getFilesInExternalStorageDownload()) {
            String name = ((File) next).getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (StringsKt.startsWith$default(name, str, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public final List<File> getFilesInExternalStorageDownload() {
        List list;
        File[] listFiles;
        File file = this.externalStorageDownload;
        if (file == null || (listFiles = file.listFiles()) == null || (list = ArraysKt.toList((T[]) listFiles)) == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<File> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (File file2 : iterable) {
            String name = file2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            List split$default = StringsKt.split$default((CharSequence) name, new String[]{"_"}, false, 0, 6, (Object) null);
            arrayList.add(new Triple(file2, (String) split$default.get(1), StringsKt.replace$default((String) split$default.get(2), ".txt", "", false, 4, (Object) null)));
        }
        Iterable<Triple> sortedWith = CollectionsKt.sortedWith((List) arrayList, new LogCatFileRepository$getFilesInExternalStorageDownload$$inlined$thenByDescending$1(new LogCatFileRepository$getFilesInExternalStorageDownload$$inlined$compareByDescending$1()));
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (Triple component1 : sortedWith) {
            arrayList2.add((File) component1.component1());
        }
        return (List) arrayList2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/logcat/LogCatFileRepository$Companion;", "", "()V", "FILE_EXTENSION", "", "FILE_NAME_FORMAT_DATE", "FILE_NAME_FORMAT_TIME", "FILE_NAME_PREFIX", "MAX_LOG_FILE_SIZE_BYTE", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LogCatFileRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
