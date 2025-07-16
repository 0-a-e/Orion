package androidx.compose.ui.graphics;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\r\u0010\u0002\u001a\u00020\u0003*\u00020\u0001H\b\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0005"}, d2 = {"Path", "Landroidx/compose/ui/graphics/Path;", "asAndroidPath", "Landroid/graphics/Path;", "asComposePath", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPath.android.kt */
public final class AndroidPath_androidKt {
    public static final Path Path() {
        return new AndroidPath((Path) null, 1, (DefaultConstructorMarker) null);
    }

    public static final Path asComposePath(Path path) {
        return new AndroidPath(path);
    }

    public static final Path asAndroidPath(Path path) {
        if (path instanceof AndroidPath) {
            return ((AndroidPath) path).getInternalPath();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }
}
