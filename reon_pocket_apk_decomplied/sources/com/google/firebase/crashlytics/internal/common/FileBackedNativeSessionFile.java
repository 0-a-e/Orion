package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

class FileBackedNativeSessionFile implements NativeSessionFile {
    private final String dataTransportFilename;
    private final File file;
    private final String reportsEndpointFilename;

    FileBackedNativeSessionFile(String str, String str2, File file2) {
        this.dataTransportFilename = str;
        this.reportsEndpointFilename = str2;
        this.file = file2;
    }

    public String getReportsEndpointFilename() {
        return this.reportsEndpointFilename;
    }

    public InputStream getStream() {
        if (this.file.exists() && this.file.isFile()) {
            try {
                return new FileInputStream(this.file);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    public CrashlyticsReport.FilesPayload.File asFilePayload() {
        byte[] asGzippedBytes = asGzippedBytes();
        if (asGzippedBytes != null) {
            return CrashlyticsReport.FilesPayload.File.builder().setContents(asGzippedBytes).setFilename(this.dataTransportFilename).build();
        }
        return null;
    }

    private byte[] asGzippedBytes() {
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr = new byte[8192];
        try {
            InputStream stream = getStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (stream == null) {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        if (stream != null) {
                            stream.close();
                        }
                        return null;
                    }
                    while (true) {
                        int read = stream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        gZIPOutputStream.write(bArr, 0, read);
                    }
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    if (stream != null) {
                        stream.close();
                    }
                    return byteArray;
                } catch (Throwable th) {
                    byteArrayOutputStream.close();
                    throw th;
                }
                throw th;
            } catch (Throwable th2) {
                if (stream != null) {
                    stream.close();
                }
                throw th2;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
    }
}
