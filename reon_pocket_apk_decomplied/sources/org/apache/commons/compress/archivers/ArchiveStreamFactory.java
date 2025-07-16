package org.apache.commons.compress.archivers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.compress.archivers.ar.ArArchiveInputStream;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.arj.ArjArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.apache.commons.compress.utils.Sets;

public class ArchiveStreamFactory implements ArchiveStreamProvider {
    public static final String AR = "ar";
    public static final String ARJ = "arj";
    public static final String CPIO = "cpio";
    public static final String DUMP = "dump";
    private static final int DUMP_SIGNATURE_SIZE = 32;
    public static final String JAR = "jar";
    public static final String SEVEN_Z = "7z";
    private static final int SIGNATURE_SIZE = 12;
    /* access modifiers changed from: private */
    public static final ArchiveStreamFactory SINGLETON = new ArchiveStreamFactory();
    public static final String TAR = "tar";
    private static final int TAR_HEADER_SIZE = 512;
    public static final String ZIP = "zip";
    private SortedMap<String, ArchiveStreamProvider> archiveInputStreamProviders;
    private SortedMap<String, ArchiveStreamProvider> archiveOutputStreamProviders;
    private final String encoding;
    private volatile String entryEncoding;

    /* access modifiers changed from: private */
    public static ArrayList<ArchiveStreamProvider> findArchiveStreamProviders() {
        return Lists.newArrayList(serviceLoaderIterator());
    }

    static void putAll(Set<String> set, ArchiveStreamProvider archiveStreamProvider, TreeMap<String, ArchiveStreamProvider> treeMap) {
        for (String key : set) {
            treeMap.put(toKey(key), archiveStreamProvider);
        }
    }

    private static Iterator<ArchiveStreamProvider> serviceLoaderIterator() {
        return new ServiceLoaderIterator(ArchiveStreamProvider.class);
    }

    private static String toKey(String str) {
        return str.toUpperCase(Locale.ROOT);
    }

    public static SortedMap<String, ArchiveStreamProvider> findAvailableArchiveInputStreamProviders() {
        return (SortedMap) AccessController.doPrivileged(new PrivilegedAction<SortedMap<String, ArchiveStreamProvider>>() {
            public SortedMap<String, ArchiveStreamProvider> run() {
                TreeMap treeMap = new TreeMap();
                ArchiveStreamFactory.putAll(ArchiveStreamFactory.SINGLETON.getInputStreamArchiveNames(), ArchiveStreamFactory.SINGLETON, treeMap);
                Iterator it = ArchiveStreamFactory.findArchiveStreamProviders().iterator();
                while (it.hasNext()) {
                    ArchiveStreamProvider archiveStreamProvider = (ArchiveStreamProvider) it.next();
                    ArchiveStreamFactory.putAll(archiveStreamProvider.getInputStreamArchiveNames(), archiveStreamProvider, treeMap);
                }
                return treeMap;
            }
        });
    }

    public static SortedMap<String, ArchiveStreamProvider> findAvailableArchiveOutputStreamProviders() {
        return (SortedMap) AccessController.doPrivileged(new PrivilegedAction<SortedMap<String, ArchiveStreamProvider>>() {
            public SortedMap<String, ArchiveStreamProvider> run() {
                TreeMap treeMap = new TreeMap();
                ArchiveStreamFactory.putAll(ArchiveStreamFactory.SINGLETON.getOutputStreamArchiveNames(), ArchiveStreamFactory.SINGLETON, treeMap);
                Iterator it = ArchiveStreamFactory.findArchiveStreamProviders().iterator();
                while (it.hasNext()) {
                    ArchiveStreamProvider archiveStreamProvider = (ArchiveStreamProvider) it.next();
                    ArchiveStreamFactory.putAll(archiveStreamProvider.getOutputStreamArchiveNames(), archiveStreamProvider, treeMap);
                }
                return treeMap;
            }
        });
    }

    public ArchiveStreamFactory() {
        this((String) null);
    }

    public ArchiveStreamFactory(String str) {
        this.encoding = str;
        this.entryEncoding = str;
    }

    public String getEntryEncoding() {
        return this.entryEncoding;
    }

    @Deprecated
    public void setEntryEncoding(String str) {
        if (this.encoding == null) {
            this.entryEncoding = str;
            return;
        }
        throw new IllegalStateException("Cannot overide encoding set by the constructor");
    }

    public ArchiveInputStream createArchiveInputStream(String str, InputStream inputStream) throws ArchiveException {
        return createArchiveInputStream(str, inputStream, this.entryEncoding);
    }

    public ArchiveInputStream createArchiveInputStream(String str, InputStream inputStream, String str2) throws ArchiveException {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        } else if (inputStream == null) {
            throw new IllegalArgumentException("InputStream must not be null.");
        } else if (AR.equalsIgnoreCase(str)) {
            return new ArArchiveInputStream(inputStream);
        } else {
            if (ARJ.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new ArjArchiveInputStream(inputStream, str2);
                }
                return new ArjArchiveInputStream(inputStream);
            } else if (ZIP.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new ZipArchiveInputStream(inputStream, str2);
                }
                return new ZipArchiveInputStream(inputStream);
            } else if (TAR.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new TarArchiveInputStream(inputStream, str2);
                }
                return new TarArchiveInputStream(inputStream);
            } else if (JAR.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new JarArchiveInputStream(inputStream, str2);
                }
                return new JarArchiveInputStream(inputStream);
            } else if (CPIO.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new CpioArchiveInputStream(inputStream, str2);
                }
                return new CpioArchiveInputStream(inputStream);
            } else if (DUMP.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new DumpArchiveInputStream(inputStream, str2);
                }
                return new DumpArchiveInputStream(inputStream);
            } else if (!SEVEN_Z.equalsIgnoreCase(str)) {
                ArchiveStreamProvider archiveStreamProvider = (ArchiveStreamProvider) getArchiveInputStreamProviders().get(toKey(str));
                if (archiveStreamProvider != null) {
                    return archiveStreamProvider.createArchiveInputStream(str, inputStream, str2);
                }
                throw new ArchiveException("Archiver: " + str + " not found.");
            } else {
                throw new StreamingNotSupportedException(SEVEN_Z);
            }
        }
    }

    public ArchiveOutputStream createArchiveOutputStream(String str, OutputStream outputStream) throws ArchiveException {
        return createArchiveOutputStream(str, outputStream, this.entryEncoding);
    }

    public ArchiveOutputStream createArchiveOutputStream(String str, OutputStream outputStream, String str2) throws ArchiveException {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        } else if (outputStream == null) {
            throw new IllegalArgumentException("OutputStream must not be null.");
        } else if (AR.equalsIgnoreCase(str)) {
            return new ArArchiveOutputStream(outputStream);
        } else {
            if (ZIP.equalsIgnoreCase(str)) {
                ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
                if (str2 != null) {
                    zipArchiveOutputStream.setEncoding(str2);
                }
                return zipArchiveOutputStream;
            } else if (TAR.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new TarArchiveOutputStream(outputStream, str2);
                }
                return new TarArchiveOutputStream(outputStream);
            } else if (JAR.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new JarArchiveOutputStream(outputStream, str2);
                }
                return new JarArchiveOutputStream(outputStream);
            } else if (CPIO.equalsIgnoreCase(str)) {
                if (str2 != null) {
                    return new CpioArchiveOutputStream(outputStream, str2);
                }
                return new CpioArchiveOutputStream(outputStream);
            } else if (!SEVEN_Z.equalsIgnoreCase(str)) {
                ArchiveStreamProvider archiveStreamProvider = (ArchiveStreamProvider) getArchiveOutputStreamProviders().get(toKey(str));
                if (archiveStreamProvider != null) {
                    return archiveStreamProvider.createArchiveOutputStream(str, outputStream, str2);
                }
                throw new ArchiveException("Archiver: " + str + " not found.");
            } else {
                throw new StreamingNotSupportedException(SEVEN_Z);
            }
        }
    }

    public ArchiveInputStream createArchiveInputStream(InputStream inputStream) throws ArchiveException {
        return createArchiveInputStream(detect(inputStream), inputStream);
    }

    public static String detect(InputStream inputStream) throws ArchiveException {
        Throwable th;
        TarArchiveInputStream tarArchiveInputStream;
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        } else if (inputStream.markSupported()) {
            byte[] bArr = new byte[12];
            inputStream.mark(12);
            try {
                int readFully = IOUtils.readFully(inputStream, bArr);
                inputStream.reset();
                if (ZipArchiveInputStream.matches(bArr, readFully)) {
                    return ZIP;
                }
                if (JarArchiveInputStream.matches(bArr, readFully)) {
                    return JAR;
                }
                if (ArArchiveInputStream.matches(bArr, readFully)) {
                    return AR;
                }
                if (CpioArchiveInputStream.matches(bArr, readFully)) {
                    return CPIO;
                }
                if (ArjArchiveInputStream.matches(bArr, readFully)) {
                    return ARJ;
                }
                if (SevenZFile.matches(bArr, readFully)) {
                    return SEVEN_Z;
                }
                byte[] bArr2 = new byte[32];
                inputStream.mark(32);
                try {
                    int readFully2 = IOUtils.readFully(inputStream, bArr2);
                    inputStream.reset();
                    if (DumpArchiveInputStream.matches(bArr2, readFully2)) {
                        return DUMP;
                    }
                    byte[] bArr3 = new byte[512];
                    inputStream.mark(512);
                    try {
                        int readFully3 = IOUtils.readFully(inputStream, bArr3);
                        inputStream.reset();
                        if (TarArchiveInputStream.matches(bArr3, readFully3)) {
                            return TAR;
                        }
                        if (readFully3 >= 512) {
                            TarArchiveInputStream tarArchiveInputStream2 = null;
                            try {
                                tarArchiveInputStream = new TarArchiveInputStream(new ByteArrayInputStream(bArr3));
                                try {
                                    if (tarArchiveInputStream.getNextTarEntry().isCheckSumOK()) {
                                        IOUtils.closeQuietly(tarArchiveInputStream);
                                        return TAR;
                                    }
                                    IOUtils.closeQuietly(tarArchiveInputStream);
                                } catch (Exception unused) {
                                    tarArchiveInputStream2 = tarArchiveInputStream;
                                    IOUtils.closeQuietly(tarArchiveInputStream2);
                                    throw new ArchiveException("No Archiver found for the stream signature");
                                } catch (Throwable th2) {
                                    th = th2;
                                    IOUtils.closeQuietly(tarArchiveInputStream);
                                    throw th;
                                }
                            } catch (Exception unused2) {
                                IOUtils.closeQuietly(tarArchiveInputStream2);
                                throw new ArchiveException("No Archiver found for the stream signature");
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                tarArchiveInputStream = null;
                                th = th4;
                                IOUtils.closeQuietly(tarArchiveInputStream);
                                throw th;
                            }
                        }
                        throw new ArchiveException("No Archiver found for the stream signature");
                    } catch (IOException e) {
                        throw new ArchiveException("IOException while reading tar signature", e);
                    }
                } catch (IOException e2) {
                    throw new ArchiveException("IOException while reading dump signature", e2);
                }
            } catch (IOException e3) {
                throw new ArchiveException("IOException while reading signature.", e3);
            }
        } else {
            throw new IllegalArgumentException("Mark is not supported.");
        }
    }

    public SortedMap<String, ArchiveStreamProvider> getArchiveInputStreamProviders() {
        if (this.archiveInputStreamProviders == null) {
            this.archiveInputStreamProviders = Collections.unmodifiableSortedMap(findAvailableArchiveInputStreamProviders());
        }
        return this.archiveInputStreamProviders;
    }

    public SortedMap<String, ArchiveStreamProvider> getArchiveOutputStreamProviders() {
        if (this.archiveOutputStreamProviders == null) {
            this.archiveOutputStreamProviders = Collections.unmodifiableSortedMap(findAvailableArchiveOutputStreamProviders());
        }
        return this.archiveOutputStreamProviders;
    }

    public Set<String> getInputStreamArchiveNames() {
        return Sets.newHashSet(AR, ARJ, ZIP, TAR, JAR, CPIO, DUMP, SEVEN_Z);
    }

    public Set<String> getOutputStreamArchiveNames() {
        return Sets.newHashSet(AR, ZIP, TAR, JAR, CPIO, SEVEN_Z);
    }
}
