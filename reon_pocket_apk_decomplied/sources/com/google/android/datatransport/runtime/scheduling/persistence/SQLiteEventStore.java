package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SQLiteEventStore implements EventStore, SynchronizationGuard {
    private static final int LOCK_RETRY_BACK_OFF_MILLIS = 50;
    private static final String LOG_TAG = "SQLiteEventStore";
    static final int MAX_RETRIES = 16;
    private static final Encoding PROTOBUF_ENCODING = Encoding.of("proto");
    private final EventStoreConfig config;
    private final Clock monotonicClock;
    private final SchemaManager schemaManager;
    private final Clock wallClock;

    interface Function<T, U> {
        U apply(T t);
    }

    interface Producer<T> {
        T produce();
    }

    @Inject
    SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager2) {
        this.schemaManager = schemaManager2;
        this.wallClock = clock;
        this.monotonicClock = clock2;
        this.config = eventStoreConfig;
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase getDb() {
        SchemaManager schemaManager2 = this.schemaManager;
        Objects.requireNonNull(schemaManager2);
        return (SQLiteDatabase) retryIfDbLocked(new SQLiteEventStore$$ExternalSyntheticLambda14(schemaManager2), new SQLiteEventStore$$ExternalSyntheticLambda15());
    }

    static /* synthetic */ SQLiteDatabase lambda$getDb$0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal) {
        Logging.d(LOG_TAG, "Storing event with priority=%s, name=%s for destination %s", transportContext.getPriority(), eventInternal.getTransportName(), transportContext.getBackendName());
        long longValue = ((Long) inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda18(this, transportContext, eventInternal))).longValue();
        if (longValue < 1) {
            return null;
        }
        return PersistedEvent.create(longValue, transportContext, eventInternal);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$persist$1$com-google-android-datatransport-runtime-scheduling-persistence-SQLiteEventStore  reason: not valid java name */
    public /* synthetic */ Long m6954lambda$persist$1$comgoogleandroiddatatransportruntimeschedulingpersistenceSQLiteEventStore(TransportContext transportContext, EventInternal eventInternal, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr;
        if (isStorageAtLimit()) {
            return -1L;
        }
        long ensureTransportContext = ensureTransportContext(sQLiteDatabase, transportContext);
        int maxBlobByteSizePerRow = this.config.getMaxBlobByteSizePerRow();
        byte[] bytes = eventInternal.getEncodedPayload().getBytes();
        boolean z = bytes.length <= maxBlobByteSizePerRow;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(ensureTransportContext));
        contentValues.put("transport_name", eventInternal.getTransportName());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.getEventMillis()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.getUptimeMillis()));
        contentValues.put("payload_encoding", eventInternal.getEncodedPayload().getEncoding().getName());
        contentValues.put("code", eventInternal.getCode());
        contentValues.put("num_attempts", 0);
        contentValues.put("inline", Boolean.valueOf(z));
        if (z) {
            bArr = bytes;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues);
        if (!z) {
            int ceil = (int) Math.ceil(((double) bytes.length) / ((double) maxBlobByteSizePerRow));
            for (int i = 1; i <= ceil; i++) {
                byte[] copyOfRange = Arrays.copyOfRange(bytes, (i - 1) * maxBlobByteSizePerRow, Math.min(i * maxBlobByteSizePerRow, bytes.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
            }
        }
        for (Map.Entry next : eventInternal.getMetadata().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put("value", (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    private long ensureTransportContext(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId != null) {
            return transportContextId.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.getBackendName());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
        contentValues.put("next_request_ms", 0);
        if (transportContext.getExtras() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    private Long getTransportContextId(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))}));
        if (transportContext.getExtras() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.getExtras(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) tryWithCursor(sQLiteDatabase.query("transport_contexts", new String[]{TransferTable.COLUMN_ID}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), new SQLiteEventStore$$ExternalSyntheticLambda17());
    }

    static /* synthetic */ Long lambda$getTransportContextId$2(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    public void recordFailure(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda0("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + toIdList(iterable)));
        }
    }

    static /* synthetic */ Object lambda$recordFailure$3(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public void recordSuccess(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            getDb().compileStatement("DELETE FROM events WHERE _id in " + toIdList(iterable)).execute();
        }
    }

    private static String toIdList(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getId());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public long getNextCallTime(TransportContext transportContext) {
        return ((Long) tryWithCursor(getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))}), new SQLiteEventStore$$ExternalSyntheticLambda9())).longValue();
    }

    static /* synthetic */ Long lambda$getNextCallTime$4(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public boolean hasPendingEventsFor(TransportContext transportContext) {
        return ((Boolean) inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda2(this, transportContext))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$hasPendingEventsFor$5$com-google-android-datatransport-runtime-scheduling-persistence-SQLiteEventStore  reason: not valid java name */
    public /* synthetic */ Boolean m6951lambda$hasPendingEventsFor$5$comgoogleandroiddatatransportruntimeschedulingpersistenceSQLiteEventStore(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return false;
        }
        return (Boolean) tryWithCursor(getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()}), new SQLiteEventStore$$ExternalSyntheticLambda1());
    }

    public void recordNextCallTime(TransportContext transportContext, long j) {
        inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda3(j, transportContext));
    }

    static /* synthetic */ Object lambda$recordNextCallTime$6(long j, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))}) < 1) {
            contentValues.put("backend_name", transportContext.getBackendName());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    public Iterable<PersistedEvent> loadBatch(TransportContext transportContext) {
        return (Iterable) inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda13(this, transportContext));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$loadBatch$7$com-google-android-datatransport-runtime-scheduling-persistence-SQLiteEventStore  reason: not valid java name */
    public /* synthetic */ List m6952lambda$loadBatch$7$comgoogleandroiddatatransportruntimeschedulingpersistenceSQLiteEventStore(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> loadEvents = loadEvents(sQLiteDatabase, transportContext);
        return join(loadEvents, loadMetadata(sQLiteDatabase, loadEvents));
    }

    public Iterable<TransportContext> loadActiveContexts() {
        return (Iterable) inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda8());
    }

    static /* synthetic */ List lambda$loadActiveContexts$9(SQLiteDatabase sQLiteDatabase) {
        return (List) tryWithCursor(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new SQLiteEventStore$$ExternalSyntheticLambda16());
    }

    static /* synthetic */ List lambda$loadActiveContexts$8(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.builder().setBackendName(cursor.getString(1)).setPriority(PriorityMapping.valueOf(cursor.getInt(2))).setExtras(maybeBase64Decode(cursor.getString(3))).build());
        }
        return arrayList;
    }

    public int cleanUp() {
        return ((Integer) inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda5(this.wallClock.getTime() - this.config.getEventCleanUpAge()))).intValue();
    }

    public void close() {
        this.schemaManager.close();
    }

    public void clearDb() {
        inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda12());
    }

    static /* synthetic */ Object lambda$clearDb$11(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("events", (String) null, new String[0]);
        sQLiteDatabase.delete("transport_contexts", (String) null, new String[0]);
        return null;
    }

    private static byte[] maybeBase64Decode(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private List<PersistedEvent> loadEvents(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        ArrayList arrayList = new ArrayList();
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return arrayList;
        }
        tryWithCursor(sQLiteDatabase.query("events", new String[]{TransferTable.COLUMN_ID, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{transportContextId.toString()}, (String) null, (String) null, (String) null, String.valueOf(this.config.getLoadBatchSize())), new SQLiteEventStore$$ExternalSyntheticLambda6(this, arrayList, transportContext));
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$loadEvents$12$com-google-android-datatransport-runtime-scheduling-persistence-SQLiteEventStore  reason: not valid java name */
    public /* synthetic */ Object m6953lambda$loadEvents$12$comgoogleandroiddatatransportruntimeschedulingpersistenceSQLiteEventStore(List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z = false;
            long j = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z = true;
            }
            EventInternal.Builder uptimeMillis = EventInternal.builder().setTransportName(cursor.getString(1)).setEventMillis(cursor.getLong(2)).setUptimeMillis(cursor.getLong(3));
            if (z) {
                uptimeMillis.setEncodedPayload(new EncodedPayload(toEncoding(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                uptimeMillis.setEncodedPayload(new EncodedPayload(toEncoding(cursor.getString(4)), readPayload(j)));
            }
            if (!cursor.isNull(6)) {
                uptimeMillis.setCode(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(PersistedEvent.create(j, transportContext, uptimeMillis.build()));
        }
        return null;
    }

    private byte[] readPayload(long j) {
        return (byte[]) tryWithCursor(getDb().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, (String) null, (String) null, "sequence_num"), new SQLiteEventStore$$ExternalSyntheticLambda7());
    }

    static /* synthetic */ byte[] lambda$readPayload$13(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    private static Encoding toEncoding(String str) {
        if (str == null) {
            return PROTOBUF_ENCODING;
        }
        return Encoding.of(str);
    }

    private Map<Long, Set<Metadata>> loadMetadata(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getId());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        tryWithCursor(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), new SQLiteEventStore$$ExternalSyntheticLambda4(hashMap));
        return hashMap;
    }

    static /* synthetic */ Object lambda$loadMetadata$14(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new Metadata(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    private List<PersistedEvent> join(List<PersistedEvent> list, Map<Long, Set<Metadata>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.getId()))) {
                EventInternal.Builder builder = next.getEvent().toBuilder();
                for (Metadata metadata : map.get(Long.valueOf(next.getId()))) {
                    builder.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(PersistedEvent.create(next.getId(), next.getTransportContext(), builder.build()));
            }
        }
        return list;
    }

    private <T> T retryIfDbLocked(Producer<T> producer, Function<Throwable, T> function) {
        long time = this.monotonicClock.getTime();
        while (true) {
            try {
                return producer.produce();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.monotonicClock.getTime() >= ((long) this.config.getCriticalSectionEnterTimeoutMs()) + time) {
                    return function.apply(e);
                }
                SystemClock.sleep(50);
            }
        }
    }

    private void ensureBeginTransaction(SQLiteDatabase sQLiteDatabase) {
        retryIfDbLocked(new SQLiteEventStore$$ExternalSyntheticLambda10(sQLiteDatabase), new SQLiteEventStore$$ExternalSyntheticLambda11());
    }

    static /* synthetic */ Object lambda$ensureBeginTransaction$16(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    public <T> T runCriticalSection(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase db = getDb();
        ensureBeginTransaction(db);
        try {
            T execute = criticalSection.execute();
            db.setTransactionSuccessful();
            return execute;
        } finally {
            db.endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T inTransaction(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            T apply = function.apply(db);
            db.setTransactionSuccessful();
            return apply;
        } finally {
            db.endTransaction();
        }
    }

    private static class Metadata {
        final String key;
        final String value;

        private Metadata(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    private boolean isStorageAtLimit() {
        return getPageCount() * getPageSize() >= this.config.getMaxStorageSizeInBytes();
    }

    /* access modifiers changed from: package-private */
    public long getByteSize() {
        return getPageCount() * getPageSize();
    }

    private long getPageSize() {
        return getDb().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private long getPageCount() {
        return getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    static <T> T tryWithCursor(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }
}
