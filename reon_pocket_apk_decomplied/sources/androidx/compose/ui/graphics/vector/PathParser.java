package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\bJ\u0014\u0010\u0010\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0011\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000fH\bJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u0010\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", "", "()V", "nodeData", "", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "addNodes", "", "cmd", "", "args", "count", "", "addPathNodes", "", "clear", "parsePathString", "pathData", "", "resizeNodeData", "dataCount", "toNodes", "toPath", "Landroidx/compose/ui/graphics/Path;", "target", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathParser.kt */
public final class PathParser {
    private float[] nodeData = new float[64];
    private final ArrayList<PathNode> nodes = new ArrayList<>();

    public final void clear() {
        this.nodes.clear();
    }

    public final PathParser parsePathString(String str) {
        int i;
        char charAt;
        int i2;
        this.nodes.clear();
        int length = str.length();
        int i3 = 0;
        while (i3 < length && Intrinsics.compare((int) str.charAt(i3), 32) <= 0) {
            i3++;
        }
        while (length > i3 && Intrinsics.compare((int) str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i4 = 0;
        while (i3 < length) {
            while (true) {
                i = i3 + 1;
                charAt = str.charAt(i3);
                char c = charAt | ' ';
                if ((c - 'a') * (c - 'z') <= 0 && c != 'e') {
                    break;
                } else if (i >= length) {
                    charAt = 0;
                    break;
                } else {
                    i3 = i;
                }
            }
            if (charAt != 0) {
                if ((charAt | ' ') != 'z') {
                    i4 = 0;
                    while (true) {
                        if (i >= length || Intrinsics.compare((int) str.charAt(i), 32) > 0) {
                            long nextFloat = FastFloatParserKt.nextFloat(str, i, length);
                            i2 = (int) (nextFloat >>> 32);
                            float intBitsToFloat = Float.intBitsToFloat((int) (nextFloat & 4294967295L));
                            if (!Float.isNaN(intBitsToFloat)) {
                                float[] fArr = this.nodeData;
                                int i5 = i4 + 1;
                                fArr[i4] = intBitsToFloat;
                                if (i5 >= fArr.length) {
                                    float[] fArr2 = new float[(i5 * 2)];
                                    this.nodeData = fArr2;
                                    ArraysKt.copyInto(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i4 = i5;
                            }
                            while (i2 < length && str.charAt(i2) == ',') {
                                i2++;
                            }
                            if (i2 >= length || Float.isNaN(intBitsToFloat)) {
                                i = i2;
                            } else {
                                i = i2;
                            }
                        } else {
                            i++;
                        }
                    }
                    i = i2;
                }
                PathNodeKt.addPathNodes(charAt, this.nodes, this.nodeData, i4);
            }
            i3 = i;
        }
        return this;
    }

    private final void resizeNodeData(int i) {
        float[] fArr = this.nodeData;
        if (i >= fArr.length) {
            float[] fArr2 = new float[(i * 2)];
            this.nodeData = fArr2;
            ArraysKt.copyInto(fArr, fArr2, 0, 0, fArr.length);
        }
    }

    public final PathParser addPathNodes(List<? extends PathNode> list) {
        this.nodes.addAll(list);
        return this;
    }

    public final List<PathNode> toNodes() {
        return this.nodes;
    }

    public static /* synthetic */ Path toPath$default(PathParser pathParser, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(path);
    }

    public final Path toPath(Path path) {
        return PathParserKt.toPath(this.nodes, path);
    }

    private final void addNodes(char c, float[] fArr, int i) {
        PathNodeKt.addPathNodes(c, this.nodes, fArr, i);
    }
}
