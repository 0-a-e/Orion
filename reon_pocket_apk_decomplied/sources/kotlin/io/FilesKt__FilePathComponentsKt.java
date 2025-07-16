package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* compiled from: FilePathComponents.kt */
class FilesKt__FilePathComponentsKt {
    private static final int getRootLength$FilesKt__FilePathComponentsKt(String str) {
        int indexOf$default;
        CharSequence charSequence = str;
        int indexOf$default2 = StringsKt.indexOf$default(charSequence, File.separatorChar, 0, false, 4, (Object) null);
        if (indexOf$default2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != File.separatorChar || (indexOf$default = StringsKt.indexOf$default(charSequence, File.separatorChar, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int i = indexOf$default + 1;
            int indexOf$default3 = StringsKt.indexOf$default(charSequence, File.separatorChar, i, false, 4, (Object) null);
            if (indexOf$default3 >= 0) {
                return indexOf$default3 + 1;
            }
            return str.length();
        } else if (indexOf$default2 > 0 && str.charAt(indexOf$default2 - 1) == ':') {
            return indexOf$default2 + 1;
        } else {
            if (indexOf$default2 != -1 || !StringsKt.endsWith$default(charSequence, ':', false, 2, (Object) null)) {
                return 0;
            }
            return str.length();
        }
    }

    public static final String getRootName(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        String substring = path.substring(0, getRootLength$FilesKt__FilePathComponentsKt(path2));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final File getRoot(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new File(FilesKt.getRootName(file));
    }

    public static final boolean isRooted(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return getRootLength$FilesKt__FilePathComponentsKt(path) > 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.io.FilePathComponents toComponents(java.io.File r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r10 = r10.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            int r0 = getRootLength$FilesKt__FilePathComponentsKt(r10)
            r1 = 0
            java.lang.String r2 = r10.substring(r1, r0)
            java.lang.String r3 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r10 = r10.substring(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            r4 = r10
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r10 = r4.length()
            if (r10 != 0) goto L_0x002f
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0069
        L_0x002f:
            r10 = 1
            char[] r5 = new char[r10]
            char r10 = java.io.File.separatorChar
            r5[r1] = r10
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r10 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r4, (char[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r10 = r10.iterator()
        L_0x0051:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x0066
            java.lang.Object r1 = r10.next()
            java.lang.String r1 = (java.lang.String) r1
            java.io.File r3 = new java.io.File
            r3.<init>(r1)
            r0.add(r3)
            goto L_0x0051
        L_0x0066:
            r10 = r0
            java.util.List r10 = (java.util.List) r10
        L_0x0069:
            kotlin.io.FilePathComponents r0 = new kotlin.io.FilePathComponents
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            r0.<init>(r1, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FilePathComponentsKt.toComponents(java.io.File):kotlin.io.FilePathComponents");
    }

    public static final File subPath(File file, int i, int i2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return FilesKt.toComponents(file).subPath(i, i2);
    }
}
