package kotlin.io.path;

import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PathUtils.kt */
final class PathRelativizer {
    public static final PathRelativizer INSTANCE = new PathRelativizer();
    private static final Path emptyPath = Paths.get("", new String[0]);
    private static final Path parentPath = Paths.get("..", new String[0]);

    private PathRelativizer() {
    }

    public final Path tryRelativeTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(path2, "base");
        Path m$2 = path2.normalize();
        Path m$22 = path.normalize();
        Path m$1 = m$2.relativize(m$22);
        int min = Math.min(Trace$$ExternalSyntheticApiModelOutline0.m(m$2), Trace$$ExternalSyntheticApiModelOutline0.m(m$22));
        int i = 0;
        while (i < min) {
            Path m = m$2.getName(i);
            Path path3 = parentPath;
            if (!Intrinsics.areEqual((Object) m, (Object) path3)) {
                break;
            } else if (Intrinsics.areEqual((Object) m$22.getName(i), (Object) path3)) {
                i++;
            } else {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (Intrinsics.areEqual((Object) m$22, (Object) m$2) || !Intrinsics.areEqual((Object) m$2, (Object) emptyPath)) {
            String obj = m$1.toString();
            String m2 = Trace$$ExternalSyntheticApiModelOutline0.m(m$1).getSeparator();
            Intrinsics.checkNotNullExpressionValue(m2, "getSeparator(...)");
            m$22 = StringsKt.endsWith$default(obj, m2, false, 2, (Object) null) ? Trace$$ExternalSyntheticApiModelOutline0.m(m$1).getPath(StringsKt.dropLast(obj, Trace$$ExternalSyntheticApiModelOutline0.m(m$1).getSeparator().length()), new String[0]) : m$1;
        }
        Intrinsics.checkNotNull(m$22);
        return m$22;
    }
}
