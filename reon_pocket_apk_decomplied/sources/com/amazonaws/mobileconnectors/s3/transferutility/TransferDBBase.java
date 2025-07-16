package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

class TransferDBBase {
    private static final String BASE_PATH = "transfers";
    private static final Object LOCK = new Object();
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferDBBase.class);
    private static final int TRANSFERS = 10;
    private static final int TRANSFER_ID = 20;
    private static final int TRANSFER_PART = 30;
    private static final int TRANSFER_STATE = 40;
    private final Uri contentUri;
    private final Context context;
    private SQLiteDatabase database;
    private final TransferDatabaseHelper databaseHelper;
    private final UriMatcher uriMatcher;

    public TransferDBBase(Context context2) {
        this.context = context2;
        String packageName = context2.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context2);
        this.databaseHelper = transferDatabaseHelper;
        this.database = transferDatabaseHelper.getWritableDatabase();
        this.contentUri = Uri.parse("content://" + packageName + "/transfers");
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        this.uriMatcher = uriMatcher2;
        uriMatcher2.addURI(packageName, BASE_PATH, 10);
        uriMatcher2.addURI(packageName, "transfers/#", 20);
        uriMatcher2.addURI(packageName, "transfers/part/#", 30);
        uriMatcher2.addURI(packageName, "transfers/state/*", 40);
    }

    /* access modifiers changed from: package-private */
    public TransferDatabaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public void closeDBHelper() {
        this.databaseHelper.close();
    }

    public Uri getContentUri() {
        return this.contentUri;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match == 10) {
            long insertOrThrow = this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, (String) null, contentValues);
            return Uri.parse("transfers/" + insertOrThrow);
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(TransferTable.TABLE_TRANSFER);
        int match = this.uriMatcher.match(uri);
        if (match == 10) {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        } else if (match == 20) {
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
        } else if (match == 30) {
            sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
        } else if (match == 40) {
            sQLiteQueryBuilder.appendWhere("state=");
            sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        ensureDatabaseOpen();
        return sQLiteQueryBuilder.query(this.database, strArr, str, strArr2, (String) null, (String) null, str2);
    }

    public synchronized int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i;
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match == 10) {
            i = this.database.update(TransferTable.TABLE_TRANSFER, contentValues, str, strArr);
        } else if (match == 20) {
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(str)) {
                SQLiteDatabase sQLiteDatabase = this.database;
                i = sQLiteDatabase.update(TransferTable.TABLE_TRANSFER, contentValues, "_id=" + lastPathSegment, (String[]) null);
            } else {
                SQLiteDatabase sQLiteDatabase2 = this.database;
                i = sQLiteDatabase2.update(TransferTable.TABLE_TRANSFER, contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
            }
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return i;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match == 10) {
            return this.database.delete(TransferTable.TABLE_TRANSFER, str, strArr);
        }
        if (match == 20) {
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(str)) {
                SQLiteDatabase sQLiteDatabase = this.database;
                return sQLiteDatabase.delete(TransferTable.TABLE_TRANSFER, "_id=" + lastPathSegment, (String[]) null);
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            return sQLiteDatabase2.delete(TransferTable.TABLE_TRANSFER, "_id=" + lastPathSegment + " and " + str, strArr);
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match == 10) {
            int i = 0;
            try {
                this.database.beginTransaction();
                i = (int) this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, (String) null, contentValuesArr[0]);
                for (int i2 = 1; i2 < contentValuesArr.length; i2++) {
                    contentValuesArr[i2].put(TransferTable.COLUMN_MAIN_UPLOAD_ID, Integer.valueOf(i));
                    this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, (String) null, contentValuesArr[i2]);
                }
                this.database.setTransactionSuccessful();
            } catch (Exception e) {
                LOGGER.error("bulkInsert error : ", e);
            } catch (Throwable th) {
                this.database.endTransaction();
                throw th;
            }
            this.database.endTransaction();
            return i;
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    private void ensureDatabaseOpen() {
        synchronized (LOCK) {
            if (!this.database.isOpen()) {
                this.database = this.databaseHelper.getWritableDatabase();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase getDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (LOCK) {
            sQLiteDatabase = this.database;
        }
        return sQLiteDatabase;
    }
}
