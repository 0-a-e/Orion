package kotlin.io.path;

import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\b¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\r\u001a&\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0005H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001aw\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2Q\b\u0002\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0017\u0012\u00150\u0019j\u0002`\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007\u001a´\u0001\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2Q\b\u0002\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0017\u0012\u00150\u0019j\u0002`\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u001d\u001a\u00020\u001e2C\b\u0002\u0010 \u001a=\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\"0\u0015¢\u0006\u0002\b#H\u0007\u001a\f\u0010$\u001a\u00020\u0001*\u00020\tH\u0007\u001a\u001b\u0010%\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0&*\u00020\tH\u0002¢\u0006\u0002\b'\u001a'\u0010(\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b*\u001a'\u0010+\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b,\u001a5\u0010-\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010.\u001a\u00020\t2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020100\"\u000201H\u0002¢\u0006\u0004\b2\u00103\u001a\u0011\u00104\u001a\u000205*\u00020\"H\u0003¢\u0006\u0002\b6\u001a\u0011\u00104\u001a\u000205*\u00020\u001cH\u0003¢\u0006\u0002\b6¨\u00067"}, d2 = {"collectIfThrows", "", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "Ljava/nio/file/Path;", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "insecureHandleEntry", "entry", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "copyToRecursively", "target", "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "deleteRecursively", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "Ljava/nio/file/SecureDirectoryStream;", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "handleEntry", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
/* compiled from: PathRecursiveFunctions.kt */
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PathRecursiveFunctions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|5|6|(2:7|8)|9|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        static {
            /*
                kotlin.io.path.CopyActionResult[] r0 = kotlin.io.path.CopyActionResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                kotlin.io.path.CopyActionResult r2 = kotlin.io.path.CopyActionResult.CONTINUE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                kotlin.io.path.CopyActionResult r3 = kotlin.io.path.CopyActionResult.TERMINATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.io.path.CopyActionResult r3 = kotlin.io.path.CopyActionResult.SKIP_SUBTREE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                kotlin.io.path.OnErrorResult[] r0 = kotlin.io.path.OnErrorResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.io.path.OnErrorResult r3 = kotlin.io.path.OnErrorResult.TERMINATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                kotlin.io.path.OnErrorResult r1 = kotlin.io.path.OnErrorResult.SKIP_SUBTREE     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1.INSTANCE;
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, z2);
    }

    public static final Path copyToRecursively(Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(function3, "onError");
        return z2 ? PathsKt.copyToRecursively(path, path2, function3, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2(z)) : PathsKt.copyToRecursively$default(path, path2, (Function3) function3, z, (Function3) null, 8, (Object) null);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, boolean z, Function3 function32, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            function32 = new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4(z);
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) function32);
    }

    public static final Path copyToRecursively(Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, boolean z, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function32) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(function3, "onError");
        Intrinsics.checkNotNullParameter(function32, "copyAction");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(z);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            boolean z2 = false;
            if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (z || !StreamsKt$$ExternalSyntheticApiModelOutline0.m$1(path))) {
                boolean z3 = Files.exists(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !StreamsKt$$ExternalSyntheticApiModelOutline0.m$1(path2);
                if (!z3 || !Trace$$ExternalSyntheticApiModelOutline0.m(path, path2)) {
                    if (Intrinsics.areEqual((Object) Trace$$ExternalSyntheticApiModelOutline0.m(path), (Object) Trace$$ExternalSyntheticApiModelOutline0.m(path2))) {
                        if (z3) {
                            z2 = StreamsKt$$ExternalSyntheticApiModelOutline0.m(StreamsKt$$ExternalSyntheticApiModelOutline0.m(path2, new LinkOption[0]), StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, new LinkOption[0]));
                        } else {
                            Path m$1 = path2.getParent();
                            if (m$1 != null && Files.exists(m$1, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && StreamsKt$$ExternalSyntheticApiModelOutline0.m(StreamsKt$$ExternalSyntheticApiModelOutline0.m(m$1, new LinkOption[0]), StreamsKt$$ExternalSyntheticApiModelOutline0.m(path, new LinkOption[0]))) {
                                z2 = true;
                            }
                        }
                    }
                    if (z2) {
                        Trace$$ExternalSyntheticApiModelOutline0.m$1();
                        throw StreamsKt$$ExternalSyntheticApiModelOutline0.m(path.toString(), path2.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                    }
                }
            }
            PathsKt.visitFileTree$default(path, 0, z, (Function1) new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5(function32, path, path2, function3), 1, (Object) null);
            return path2;
        }
        StreamsKt$$ExternalSyntheticApiModelOutline0.m();
        throw StreamsKt$$ExternalSyntheticApiModelOutline0.m(path.toString(), path2.toString(), "The source file doesn't exist.");
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2, Path path3) {
        Path m = StreamsKt$$ExternalSyntheticApiModelOutline0.m(path2, PathsKt.relativeTo(path3, path).toString());
        Intrinsics.checkNotNullExpressionValue(m, "resolve(...)");
        return m;
    }

    /* access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3, Exception exc) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((OnErrorResult) function3.invoke(path3, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(path, path2, path3), exc));
    }

    /* access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32, Path path3, BasicFileAttributes basicFileAttributes) {
        try {
            return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((CopyActionResult) function3.invoke(DefaultCopyActionContext.INSTANCE, path3, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(path, path2, path3)));
        } catch (Exception e) {
            return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function32, path, path2, path3, e);
        }
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult copyActionResult) {
        int i = WhenMappings.$EnumSwitchMapping$0[copyActionResult.ordinal()];
        if (i == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i == 2) {
            return StreamsKt$$ExternalSyntheticApiModelOutline0.m();
        }
        if (i == 3) {
            return StreamsKt$$ExternalSyntheticApiModelOutline0.m$1();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult onErrorResult) {
        int i = WhenMappings.$EnumSwitchMapping$1[onErrorResult.ordinal()];
        if (i == 1) {
            return StreamsKt$$ExternalSyntheticApiModelOutline0.m();
        }
        if (i == 2) {
            return StreamsKt$$ExternalSyntheticApiModelOutline0.m$1();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void deleteRecursively(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(path);
        if (!deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt.isEmpty()) {
            FileSystemException m = Trace$$ExternalSyntheticApiModelOutline0.m("Failed to delete one or more files. See suppressed exceptions for details.");
            for (Exception addSuppressed : deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt) {
                ExceptionsKt.addSuppressed(m, addSuppressed);
            }
            throw m;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.List<java.lang.Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(java.nio.file.Path r8) {
        /*
            kotlin.io.path.ExceptionsCollector r0 = new kotlin.io.path.ExceptionsCollector
            r1 = 0
            r2 = 1
            r3 = 0
            r0.<init>(r1, r2, r3)
            java.nio.file.Path r4 = r8.getParent()
            if (r4 == 0) goto L_0x0045
            java.nio.file.DirectoryStream r5 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r4)     // Catch:{ all -> 0x0013 }
            goto L_0x0014
        L_0x0013:
            r5 = r3
        L_0x0014:
            if (r5 == 0) goto L_0x0045
            java.io.Closeable r5 = (java.io.Closeable) r5
            java.nio.file.DirectoryStream r6 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r5)     // Catch:{ all -> 0x003e }
            boolean r7 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r6)     // Catch:{ all -> 0x003e }
            if (r7 == 0) goto L_0x0036
            r0.setPath(r4)     // Catch:{ all -> 0x003e }
            java.nio.file.SecureDirectoryStream r2 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r6)     // Catch:{ all -> 0x003e }
            java.nio.file.Path r4 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r8)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = "getFileName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)     // Catch:{ all -> 0x003e }
            handleEntry$PathsKt__PathRecursiveFunctionsKt(r2, r4, r0)     // Catch:{ all -> 0x003e }
            goto L_0x0037
        L_0x0036:
            r1 = r2
        L_0x0037:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003e }
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            r2 = r1
            goto L_0x0045
        L_0x003e:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r8)
            throw r0
        L_0x0045:
            if (r2 == 0) goto L_0x004a
            insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r8, r0)
        L_0x004a:
            java.util.List r8 = r0.getCollectedExceptions()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(java.nio.file.Path):java.util.List");
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector exceptionsCollector, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Exception e) {
            exceptionsCollector.collect(e);
        }
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> function0) {
        try {
            return function0.invoke();
        } catch (NoSuchFileException unused) {
            return null;
        }
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path path, ExceptionsCollector exceptionsCollector) {
        exceptionsCollector.enterEntry(path);
        try {
            if (isDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, Trace$$ExternalSyntheticApiModelOutline0.m())) {
                int totalExceptions = exceptionsCollector.getTotalExceptions();
                enterDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, exceptionsCollector);
                if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                    try {
                        secureDirectoryStream.deleteDirectory(path);
                        Unit unit = Unit.INSTANCE;
                    } catch (NoSuchFileException unused) {
                    }
                }
            } else {
                secureDirectoryStream.deleteFile(path);
                Unit unit2 = Unit.INSTANCE;
            }
        } catch (Exception e) {
            exceptionsCollector.collect(e);
        }
        exceptionsCollector.exitEntry(path);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(java.nio.file.SecureDirectoryStream<java.nio.file.Path> r4, java.nio.file.Path r5, kotlin.io.path.ExceptionsCollector r6) {
        /*
            r0 = 1
            r1 = 0
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r0]     // Catch:{ NoSuchFileException -> 0x0012 }
            java.nio.file.LinkOption r2 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m()     // Catch:{ NoSuchFileException -> 0x0012 }
            r3 = 0
            r0[r3] = r2     // Catch:{ NoSuchFileException -> 0x0012 }
            java.nio.file.SecureDirectoryStream r4 = r4.newDirectoryStream(r5, r0)     // Catch:{ NoSuchFileException -> 0x0012 }
            goto L_0x0013
        L_0x0010:
            r4 = move-exception
            goto L_0x0047
        L_0x0012:
            r4 = r1
        L_0x0013:
            if (r4 == 0) goto L_0x004a
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ Exception -> 0x0010 }
            java.nio.file.SecureDirectoryStream r5 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r4)     // Catch:{ all -> 0x0040 }
            java.util.Iterator r0 = r5.iterator()     // Catch:{ all -> 0x0040 }
        L_0x001f:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003a
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0040 }
            java.nio.file.Path r2 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r2)     // Catch:{ all -> 0x0040 }
            java.nio.file.Path r2 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r2)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "getFileName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0040 }
            handleEntry$PathsKt__PathRecursiveFunctionsKt(r5, r2, r6)     // Catch:{ all -> 0x0040 }
            goto L_0x001f
        L_0x003a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0040 }
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ Exception -> 0x0010 }
            goto L_0x004a
        L_0x0040:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch:{ Exception -> 0x0010 }
            throw r0     // Catch:{ Exception -> 0x0010 }
        L_0x0047:
            r6.collect(r4)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.enterDirectory$PathsKt__PathRecursiveFunctionsKt(java.nio.file.SecureDirectoryStream, java.nio.file.Path, kotlin.io.path.ExceptionsCollector):void");
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean bool;
        try {
            bool = Boolean.valueOf(StreamsKt$$ExternalSyntheticApiModelOutline0.m((Object) secureDirectoryStream.getFileAttributeView(path, StreamsKt$$ExternalSyntheticApiModelOutline0.m(), (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException unused) {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path path, ExceptionsCollector exceptionsCollector) {
        try {
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{Trace$$ExternalSyntheticApiModelOutline0.m()}, 1))) {
                int totalExceptions = exceptionsCollector.getTotalExceptions();
                insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(path, exceptionsCollector);
                if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                    StreamsKt$$ExternalSyntheticApiModelOutline0.m(path);
                    return;
                }
                return;
            }
            StreamsKt$$ExternalSyntheticApiModelOutline0.m(path);
        } catch (Exception e) {
            exceptionsCollector.collect(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(java.nio.file.Path r3, kotlin.io.path.ExceptionsCollector r4) {
        /*
            r0 = 0
            java.nio.file.DirectoryStream r3 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r3)     // Catch:{ NoSuchFileException -> 0x0008 }
            goto L_0x0009
        L_0x0006:
            r3 = move-exception
            goto L_0x0037
        L_0x0008:
            r3 = r0
        L_0x0009:
            if (r3 == 0) goto L_0x003a
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ Exception -> 0x0006 }
            java.nio.file.DirectoryStream r1 = kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r3)     // Catch:{ all -> 0x0030 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0030 }
        L_0x0015:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0030 }
            java.nio.file.Path r2 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r2)     // Catch:{ all -> 0x0030 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x0030 }
            insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r2, r4)     // Catch:{ all -> 0x0030 }
            goto L_0x0015
        L_0x002a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0030 }
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ Exception -> 0x0006 }
            goto L_0x003a
        L_0x0030:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ Exception -> 0x0006 }
            throw r1     // Catch:{ Exception -> 0x0006 }
        L_0x0037:
            r4.collect(r3)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(java.nio.file.Path, kotlin.io.path.ExceptionsCollector):void");
    }
}
