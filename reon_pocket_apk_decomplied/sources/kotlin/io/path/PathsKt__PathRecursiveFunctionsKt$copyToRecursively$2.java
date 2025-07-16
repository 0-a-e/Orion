package kotlin.io.path;

import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/io/path/CopyActionContext;", "src", "Ljava/nio/file/Path;", "dst", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: PathRecursiveFunctions.kt */
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2 extends Lambda implements Function3<CopyActionContext, Path, Path, CopyActionResult> {
    final /* synthetic */ boolean $followLinks;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2(boolean z) {
        super(3);
        this.$followLinks = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CopyActionContext) obj, Trace$$ExternalSyntheticApiModelOutline0.m(obj2), Trace$$ExternalSyntheticApiModelOutline0.m(obj3));
    }

    public final CopyActionResult invoke(CopyActionContext copyActionContext, Path path, Path path2) {
        Intrinsics.checkNotNullParameter(copyActionContext, "$this$copyToRecursively");
        Intrinsics.checkNotNullParameter(path, "src");
        Intrinsics.checkNotNullParameter(path2, "dst");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(this.$followLinks);
        boolean m = Files.isDirectory(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{Trace$$ExternalSyntheticApiModelOutline0.m()}, 1));
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !m) {
            if (m) {
                PathsKt.deleteRecursively(path2);
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(linkOptions);
            spreadBuilder.add(StreamsKt$$ExternalSyntheticApiModelOutline0.m());
            CopyOption[] copyOptionArr = (CopyOption[]) spreadBuilder.toArray(new CopyOption[spreadBuilder.size()]);
            Intrinsics.checkNotNullExpressionValue(Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(...)");
        }
        return CopyActionResult.CONTINUE;
    }
}
