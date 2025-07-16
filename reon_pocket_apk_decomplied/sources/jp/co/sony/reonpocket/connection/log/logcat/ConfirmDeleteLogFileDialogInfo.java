package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/logcat/ConfirmDeleteLogFileDialogInfo;", "", "file", "Ljava/io/File;", "message", "", "(Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogPresenter.kt */
public final class ConfirmDeleteLogFileDialogInfo {
    public static final int $stable = 8;
    private final File file;
    private final String message;

    public static /* synthetic */ ConfirmDeleteLogFileDialogInfo copy$default(ConfirmDeleteLogFileDialogInfo confirmDeleteLogFileDialogInfo, File file2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            file2 = confirmDeleteLogFileDialogInfo.file;
        }
        if ((i & 2) != 0) {
            str = confirmDeleteLogFileDialogInfo.message;
        }
        return confirmDeleteLogFileDialogInfo.copy(file2, str);
    }

    public final File component1() {
        return this.file;
    }

    public final String component2() {
        return this.message;
    }

    public final ConfirmDeleteLogFileDialogInfo copy(File file2, String str) {
        Intrinsics.checkNotNullParameter(file2, TransferTable.COLUMN_FILE);
        Intrinsics.checkNotNullParameter(str, "message");
        return new ConfirmDeleteLogFileDialogInfo(file2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmDeleteLogFileDialogInfo)) {
            return false;
        }
        ConfirmDeleteLogFileDialogInfo confirmDeleteLogFileDialogInfo = (ConfirmDeleteLogFileDialogInfo) obj;
        return Intrinsics.areEqual((Object) this.file, (Object) confirmDeleteLogFileDialogInfo.file) && Intrinsics.areEqual((Object) this.message, (Object) confirmDeleteLogFileDialogInfo.message);
    }

    public int hashCode() {
        return (this.file.hashCode() * 31) + this.message.hashCode();
    }

    public String toString() {
        File file2 = this.file;
        String str = this.message;
        return "ConfirmDeleteLogFileDialogInfo(file=" + file2 + ", message=" + str + ")";
    }

    public ConfirmDeleteLogFileDialogInfo(File file2, String str) {
        Intrinsics.checkNotNullParameter(file2, TransferTable.COLUMN_FILE);
        Intrinsics.checkNotNullParameter(str, "message");
        this.file = file2;
        this.message = str;
    }

    public final File getFile() {
        return this.file;
    }

    public final String getMessage() {
        return this.message;
    }
}
