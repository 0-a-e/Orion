package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b#\b \u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0002\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020#H\u0002J)\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00020T2\u0006\u0010S\u001a\u00020TH\u0004ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J'\u0010\u0001\u001a\u00020\u00172\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010S\u001a\u00020TH\u0004ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u001cJ\u001c\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0012\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u0001\u001a\u00020\u001dH&J\u0018\u0010\u0001\u001a\u00020\u00002\u0007\u0010 \u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b¡\u0001J\u001f\u0010¢\u0001\u001a\u00030\u00012\u0007\u0010e\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b£\u0001\u0010\u0001J\u001b\u0010¤\u0001\u001a\u00020\u001d2\u0007\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020#H\u0002J#\u0010¦\u0001\u001a\u00020#2\f\u0010§\u0001\u001a\u0007\u0012\u0002\b\u00030¨\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010ª\u0001J#\u0010«\u0001\u001a\u0004\u0018\u00010z2\f\u0010§\u0001\u001a\u0007\u0012\u0002\b\u00030¨\u0001ø\u0001\u0000¢\u0006\u0006\b¬\u0001\u0010­\u0001J\u0014\u0010®\u0001\u001a\u0004\u0018\u00010z2\u0007\u0010¯\u0001\u001a\u00020#H\u0002JC\u0010°\u0001\u001a\u00020\u001d2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#ø\u0001\u0000¢\u0006\u0006\b·\u0001\u0010¸\u0001JE\u0010¹\u0001\u001a\u00020\u001d2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#H\u0016ø\u0001\u0000¢\u0006\u0006\bº\u0001\u0010¸\u0001J\t\u0010»\u0001\u001a\u00020\u001dH\u0016J\u001f\u0010¼\u0001\u001a\u00020#2\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0007\u0010¿\u0001\u001a\u00020#J\u001c\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020#H\u0016J)\u0010Ã\u0001\u001a\u00030\u00012\u0007\u0010Â\u0001\u001a\u00020\u00032\b\u0010Ä\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J \u0010Ç\u0001\u001a\u00030\u00012\b\u0010È\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010\u0001J \u0010Ê\u0001\u001a\u00030\u00012\b\u0010È\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bË\u0001\u0010\u0001J \u0010Ì\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010\u0001J\u000f\u0010Î\u0001\u001a\u00020\u001dH\u0000¢\u0006\u0003\bÏ\u0001J\t\u0010Ð\u0001\u001a\u00020\u001dH\u0016J\u0007\u0010Ñ\u0001\u001a\u00020\u001dJ\u001b\u0010Ò\u0001\u001a\u00020\u001d2\u0007\u0010Ó\u0001\u001a\u00020Y2\u0007\u0010Ô\u0001\u001a\u00020YH\u0014J\u0007\u0010Õ\u0001\u001a\u00020\u001dJ\u0007\u0010Ö\u0001\u001a\u00020\u001dJ\u0007\u0010×\u0001\u001a\u00020\u001dJ\u0012\u0010Ø\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u001cH\u0016J2\u0010Ù\u0001\u001a\u00030Ú\u00012\u0007\u0010Û\u0001\u001a\u0002002\u0010\b\u0004\u0010Ü\u0001\u001a\t\u0012\u0005\u0012\u00030Ú\u00010'H\bø\u0001\u0000¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001JA\u0010ß\u0001\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020\u00172\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b8H\u0014ø\u0001\u0000¢\u0006\u0006\bà\u0001\u0010á\u0001JA\u0010â\u0001\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020\u00172\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b8H\u0002ø\u0001\u0000¢\u0006\u0006\bã\u0001\u0010á\u0001J?\u0010ä\u0001\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020\u00172\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b8ø\u0001\u0000¢\u0006\u0006\bå\u0001\u0010á\u0001J,\u0010æ\u0001\u001a\u00020\u001d2\u0007\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020#2\t\b\u0002\u0010ç\u0001\u001a\u00020#H\u0000¢\u0006\u0003\bè\u0001J\u000f\u0010é\u0001\u001a\u00020\u001dH\u0010¢\u0006\u0003\bê\u0001J\u0007\u0010ë\u0001\u001a\u00020#J\u001f\u0010ì\u0001\u001a\u00030\u00012\u0007\u0010e\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bí\u0001\u0010\u0001J\b\u0010î\u0001\u001a\u00030Á\u0001J(\u0010ï\u0001\u001a\u00020\u001d2\u0007\u0010Â\u0001\u001a\u00020\u00032\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001J(\u0010ô\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010ö\u0001J(\u0010÷\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010ö\u0001J-\u0010ù\u0001\u001a\u00020\u001d2\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b82\t\b\u0002\u0010ú\u0001\u001a\u00020#J\u0014\u0010û\u0001\u001a\u00020\u001d2\t\b\u0002\u0010ü\u0001\u001a\u00020#H\u0002JF\u0010ý\u0001\u001a\u00020\u001d\"\u0007\b\u0000\u0010þ\u0001\u0018\u00012\u000f\u0010§\u0001\u001a\n\u0012\u0005\u0012\u0003Hþ\u00010¨\u00012\u0014\u0010Ü\u0001\u001a\u000f\u0012\u0005\u0012\u0003Hþ\u0001\u0012\u0004\u0012\u00020\u001d0\u001bH\bø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0002J1\u0010ý\u0001\u001a\u00020\u001d2\u0007\u0010\u0002\u001a\u00020Y2\u0007\u0010¯\u0001\u001a\u00020#2\u0013\u0010Ü\u0001\u001a\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u001d0\u001bH\bJ \u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J(\u0010\u0002\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u001c2\u0013\u0010Ü\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\bJ\u001f\u0010\u0002\u001a\u00020#2\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010¾\u0001JK\u0010\u0002\u001a\u00020\u001d*\u0004\u0018\u00010z2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002JT\u0010\u0002\u001a\u00020\u001d*\u0004\u0018\u00010z2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#2\u0007\u0010\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002JT\u0010\u0002\u001a\u00020\u001d*\u0004\u0018\u00010z2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#2\u0007\u0010\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\r\u0010\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0'X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010%R\u000e\u0010)\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010%R\u000e\u0010+\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020#2\u0006\u0010,\u001a\u00020#@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u001a\u0010/\u001a\u0002008@X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u00102R\"\u00104\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u000103@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106RD\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b82\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b8@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020?8VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR&\u0010H\u001a\u0004\u0018\u00010G2\b\u0010,\u001a\u0004\u0018\u00010G@dX¦\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t8P@PX\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0017\u0010S\u001a\u00020T8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bU\u00102R\u001c\u0010V\u001a\u0010\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020Y\u0018\u00010WX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0012R\u0013\u0010\\\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b]\u0010\u0015R\u0016\u0010^\u001a\u0004\u0018\u00010_8VX\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bc\u0010\u0015R,\u0010e\u001a\u00020d2\u0006\u0010,\u001a\u00020d@TX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010i\u001a\u0004\bf\u00102\"\u0004\bg\u0010hR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020X0k8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020\u000b8DX\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u000e\u0010q\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010r\u001a\u00020s8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bt\u00102R\u0014\u0010u\u001a\u00020v8BX\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0012\u0010y\u001a\u00020zX¦\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u001e\u0010}\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0001\u0010\"\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0017@DX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0001\u0010\u0019\"\u0006\b\u0001\u0010\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "getDrawBlock$annotations", "()V", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeSelf", "placeSelf-f8xVGno", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-f8xVGno", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "replace", "replace$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", "T", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    /* access modifiers changed from: private */
    public static final HitTestSource PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
    /* access modifiers changed from: private */
    public static final HitTestSource SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    /* access modifiers changed from: private */
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    /* access modifiers changed from: private */
    public static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m4058constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function1<Canvas, Unit> drawBlock = new NodeCoordinator$drawBlock$1(this);
    private final Function0<Unit> invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    private boolean isClipping;
    private float lastLayerAlpha = 0.8f;
    /* access modifiers changed from: private */
    public boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    /* access modifiers changed from: private */
    public LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m6758getZeronOccac();
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public interface HitTestSource {
        /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
        void m5642childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2);

        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        int m5643entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    private static /* synthetic */ void getDrawBlock$annotations() {
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    /* access modifiers changed from: protected */
    public abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode2) {
        this.layoutNode = layoutNode2;
    }

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    public LayoutCoordinates getCoordinates() {
        return this;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (!(nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null)) {
                return tail.getChild$ui_release();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.getTail();
            }
        }
        return null;
    }

    public final void visitNodes(int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        Modifier.Node tail = getTail();
        if (z || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(z);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
                if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                    function1.invoke(access$headNode);
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ  reason: not valid java name */
    public final /* synthetic */ <T> void m5635visitNodesaLcG6gQ(int i, Function1<? super T, Unit> function1) {
        boolean r0 = NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (r0 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r0);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
                if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node = access$headNode;
                    Modifier.Node node2 = access$headNode;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node2 instanceof Object) {
                            function1.invoke(node2);
                        } else {
                            Modifier.Node node3 = node2;
                            if ((node2.getKindSet$ui_release() & i) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    Modifier.Node node4 = delegate$ui_release;
                                    if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui_release;
                                        } else {
                                            MutableVector mutableVector2 = mutableVector;
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector3 = mutableVector;
                                            }
                                            Modifier.Node node5 = node2;
                                            if (node2 != null) {
                                                MutableVector mutableVector4 = mutableVector;
                                                if (mutableVector != null) {
                                                    mutableVector.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            MutableVector mutableVector5 = mutableVector;
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                        }
                        MutableVector mutableVector6 = mutableVector;
                        node2 = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: hasNode-H91voCI  reason: not valid java name */
    private final boolean m5607hasNodeH91voCI(int i) {
        Modifier.Node headNode = headNode(NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(i));
        return headNode != null && DelegatableNodeKt.m5466has64DMado(headNode, i);
    }

    /* renamed from: head-H91voCI  reason: not valid java name */
    public final Modifier.Node m5622headH91voCI(int i) {
        boolean r0 = NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!r0 && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        Modifier.Node access$headNode = headNode(r0);
        while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
            if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                return access$headNode;
            }
            if (access$headNode == tail) {
                return null;
            }
            access$headNode = access$headNode.getChild$ui_release();
        }
        return null;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m5621getSizeYbymL2g() {
        return m5404getMeasuredSizeYbymL2g();
    }

    /* access modifiers changed from: protected */
    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    public void replace$ui_release() {
        m5630placeAtf8xVGno(m5620getPositionnOccac(), this.zIndex, this.layerBlock);
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public boolean isAttached() {
        return getTail().isAttached();
    }

    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (!(measureResult2 != null && measureResult.getWidth() == measureResult2.getWidth() && measureResult.getHeight() == measureResult2.getHeight())) {
                onMeasureResultChanged(measureResult.getWidth(), measureResult.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (((map != null && !map.isEmpty()) || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) measureResult.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map<AlignmentLine, Integer> map2 = this.oldAlignmentLines;
                if (map2 == null) {
                    map2 = new LinkedHashMap<>();
                    this.oldAlignmentLines = map2;
                }
                map2.clear();
                map2.putAll(measureResult.getAlignmentLines());
            }
        }
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Set<AlignmentLine> set = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (set == null) {
                    set = new LinkedHashSet<>();
                }
                set.addAll(alignmentLines.keySet());
            }
        }
        return set == null ? SetsKt.emptySet() : set;
    }

    /* access modifiers changed from: protected */
    public void onMeasureResultChanged(int i, int i2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.m5701resizeozmzZPI(IntSizeKt.IntSize(i, i2));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        m5407setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        updateLayerParameters(false);
        int r11 = NodeKind.m5647constructorimpl(4);
        boolean r0 = NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(r11);
        Modifier.Node tail = getTail();
        if (r0 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r0);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r11) != 0) {
                if ((access$headNode.getKindSet$ui_release() & r11) != 0) {
                    Modifier.Node node = access$headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof DrawModifierNode) {
                            ((DrawModifierNode) node).onMeasureResultChanged();
                        } else if ((node.getKindSet$ui_release() & r11) != 0 && (node instanceof DelegatingNode)) {
                            int i3 = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r11) != 0) {
                                    i3++;
                                    if (i3 == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i3 == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (access$headNode == tail) {
                    break;
                }
                access$headNode = access$headNode.getChild$ui_release();
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m5620getPositionnOccac() {
        return this.position;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m5632setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* access modifiers changed from: protected */
    public final void setZIndex(float f) {
        this.zIndex = f;
    }

    public Object getParentData() {
        if (!getLayoutNode().getNodes$ui_release().m5597hasH91voCI$ui_release(NodeKind.m5647constructorimpl(64))) {
            return null;
        }
        getTail();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (Modifier.Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if ((NodeKind.m5647constructorimpl(64) & tail$ui_release.getKindSet$ui_release()) != 0) {
                int r4 = NodeKind.m5647constructorimpl(64);
                MutableVector mutableVector = null;
                Modifier.Node node = tail$ui_release;
                while (node != null) {
                    if (node instanceof ParentDataModifierNode) {
                        objectRef.element = ((ParentDataModifierNode) node).modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                    } else if ((node.getKindSet$ui_release() & r4) != 0 && (node instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                            if ((delegate$ui_release.getKindSet$ui_release() & r4) != 0) {
                                i++;
                                if (i == 1) {
                                    node = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(node);
                                        }
                                        node = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector);
                }
            }
        }
        return objectRef.element;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
    }

    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            onCoordinatesUsed$ui_release();
            return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            onCoordinatesUsed$ui_release();
            return this.wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    /* access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release  reason: not valid java name */
    public final long m5618getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return m5405getMeasurementConstraintsmsEJaDk();
    }

    /* access modifiers changed from: protected */
    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m5629performingMeasureK40F9xA(long j, Function0<? extends Placeable> function0) {
        m5408setMeasurementConstraintsBRTryo0(j);
        return (Placeable) function0.invoke();
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m5630placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        m5611placeSelff8xVGno(j, f, function1);
    }

    /* renamed from: placeSelf-f8xVGno  reason: not valid java name */
    private final void m5611placeSelff8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        updateLayerBlock$default(this, function1, false, 2, (Object) null);
        if (!IntOffset.m6747equalsimpl0(m5620getPositionnOccac(), j)) {
            m5632setPositiongyyYBs(j);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m5700movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
    }

    /* renamed from: placeSelfApparentToRealOffset-f8xVGno  reason: not valid java name */
    public final void m5631placeSelfApparentToRealOffsetf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        long r0 = m5403getApparentToRealOffsetnOccac();
        m5611placeSelff8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(r0)), f, function1);
    }

    public final void draw(Canvas canvas) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float r0 = (float) IntOffset.m6748getXimpl(m5620getPositionnOccac());
        float r1 = (float) IntOffset.m6749getYimpl(m5620getPositionnOccac());
        canvas.translate(r0, r1);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-r0, -r1);
    }

    public void performDraw(Canvas canvas) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            nodeCoordinator.updateLayerBlock(function1, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> function1, boolean z) {
        Owner owner$ui_release;
        LayoutNode layoutNode2 = getLayoutNode();
        boolean z2 = z || this.layerBlock != function1 || !Intrinsics.areEqual((Object) this.layerDensity, (Object) layoutNode2.getDensity()) || this.layerLayoutDirection != layoutNode2.getLayoutDirection();
        this.layerBlock = function1;
        this.layerDensity = layoutNode2.getDensity();
        this.layerLayoutDirection = layoutNode2.getLayoutDirection();
        if (!layoutNode2.isAttached() || function1 == null) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                layoutNode2.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = layoutNode2.getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(layoutNode2);
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
        } else if (this.layer == null) {
            OwnedLayer createLayer = LayoutNodeKt.requireOwner(layoutNode2).createLayer(this.drawBlock, this.invalidateParentLayer);
            createLayer.m5701resizeozmzZPI(m5404getMeasuredSizeYbymL2g());
            createLayer.m5700movegyyYBs(m5620getPositionnOccac());
            this.layer = createLayer;
            updateLayerParameters$default(this, false, 1, (Object) null);
            layoutNode2.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
        } else if (z2) {
            updateLayerParameters$default(this, false, 1, (Object) null);
        }
    }

    static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            nodeCoordinator.updateLayerParameters(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
    }

    private final void updateLayerParameters(boolean z) {
        Owner owner$ui_release;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                reusableGraphicsLayerScope.reset();
                reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                reusableGraphicsLayerScope.m4172setSizeuvyYCjk(IntSizeKt.m6800toSizeozmzZPI(m5621getSizeYbymL2g()));
                getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new NodeCoordinator$updateLayerParameters$1(function1));
                LayerPositionalProperties layerPositionalProperties2 = this.layerPositionalProperties;
                if (layerPositionalProperties2 == null) {
                    layerPositionalProperties2 = new LayerPositionalProperties();
                    this.layerPositionalProperties = layerPositionalProperties2;
                }
                layerPositionalProperties2.copyFrom((GraphicsLayerScope) reusableGraphicsLayerScope);
                ownedLayer.updateLayerProperties(reusableGraphicsLayerScope, getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
                this.isClipping = reusableGraphicsLayerScope.getClip();
                this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
                if (z && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(getLayoutNode());
                    return;
                }
                return;
            }
            throw new IllegalStateException("updateLayerParameters requires a non-null layerBlock".toString());
        } else if (this.layerBlock != null) {
            throw new IllegalStateException("null layer with a non-null layerBlock".toString());
        }
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    public boolean isValidOwnerScope() {
        return this.layer != null && !this.released && getLayoutNode().isAttached();
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc  reason: not valid java name */
    public final long m5619getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.m6551toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().m5831getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-YqVAtuI  reason: not valid java name */
    public final void m5623hitTestYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        float f;
        long j2 = j;
        HitTestResult hitTestResult2 = hitTestResult;
        Modifier.Node r1 = m5622headH91voCI(hitTestSource.m5643entityTypeOLwlOKw());
        if (!m5637withinLayerBoundsk4lQ0M(j)) {
            if (z) {
                float r8 = m5616distanceInMinimumTouchTargettz77jQw(j, m5619getMinimumTouchTargetSizeNHjbRc());
                if (!Float.isInfinite(r8) && !Float.isNaN(r8) && hitTestResult.isHitInMinimumTouchTargetBetter(r8, false)) {
                    m5609hitNearJHbHoSQ(r1, hitTestSource, j, hitTestResult, z, false, r8);
                }
            }
        } else if (r1 == null) {
            m5624hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (m5625isPointerInBoundsk4lQ0M(j)) {
            m5608hit1hIXUjU(r1, hitTestSource, j, hitTestResult, z, z2);
        } else {
            if (!z) {
                f = Float.POSITIVE_INFINITY;
            } else {
                f = m5616distanceInMinimumTouchTargettz77jQw(j, m5619getMinimumTouchTargetSizeNHjbRc());
            }
            float f2 = f;
            if (Float.isInfinite(f2) || Float.isNaN(f2)) {
                boolean z3 = z2;
            } else if (hitTestResult.isHitInMinimumTouchTargetBetter(f2, z2)) {
                m5609hitNearJHbHoSQ(r1, hitTestSource, j, hitTestResult, z, z2, f2);
                return;
            }
            m5612speculativeHitJHbHoSQ(r1, hitTestSource, j, hitTestResult, z, z2, f2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU  reason: not valid java name */
    public final void m5608hit1hIXUjU(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        if (node == null) {
            m5624hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        hitTestResult.hit(node, z2, new NodeCoordinator$hit$1(this, node, hitTestSource, j, hitTestResult, z, z2));
    }

    /* access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ  reason: not valid java name */
    public final void m5609hitNearJHbHoSQ(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        if (node == null) {
            m5624hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        float f2 = f;
        hitTestResult.hitInMinimumTouchTarget(node, f2, z2, new NodeCoordinator$hitNear$1(this, node, hitTestSource, j, hitTestResult, z, z2, f));
    }

    /* access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ  reason: not valid java name */
    public final void m5612speculativeHitJHbHoSQ(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        Modifier.Node node2 = node;
        if (node2 == null) {
            m5624hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        HitTestSource hitTestSource2 = hitTestSource;
        if (hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            boolean z3 = z2;
            float f2 = f;
            hitTestResult.speculativeHit(node, f2, z3, new NodeCoordinator$speculativeHit$1(this, node, hitTestSource, j, hitTestResult, z, z3, f2));
            return;
        }
        HitTestResult hitTestResult2 = hitTestResult;
        m5612speculativeHitJHbHoSQ(NodeCoordinatorKt.m5645nextUntilhw7D004(node2, hitTestSource.m5643entityTypeOLwlOKw(), NodeKind.m5647constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
    }

    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    public void m5624hitTestChildYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m5623hitTestYqVAtuI(hitTestSource, nodeCoordinator.m5617fromParentPositionMKHz9U(j), hitTestResult, z, z2);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long r2 = m5615calculateMinimumTouchTargetPaddingE7KxVPU(m5619getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m3631getWidthimpl(r2));
        rectCache.setTop(-Size.m3628getHeightimpl(r2));
        rectCache.setRight(((float) getMeasuredWidth()) + Size.m3631getWidthimpl(r2));
        rectCache.setBottom(((float) getMeasuredHeight()) + Size.m3628getHeightimpl(r2));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != findRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m5636windowToLocalMKHz9U(long j) {
        if (isAttached()) {
            LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
            return m5626localPositionOfR5De75A(findRootCoordinates, Offset.m3566minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).m5703calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m5628localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).m5704calculatePositionInWindowMKHz9U(m5627localToRootMKHz9U(j));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m5626localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            return Offset.m3571unaryMinusF1C5BW0(layoutCoordinates.m5319localPositionOfR5De75A(this, Offset.m3571unaryMinusF1C5BW0(j)));
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            j = coordinator.m5633toParentPositionMKHz9U(j);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m5606ancestorToLocalR5De75A(findCommonAncestor$ui_release, j);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m5634transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m4067resetimpl(fArr);
        coordinator.m5614transformToAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
        m5613transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
    }

    /* renamed from: transformToAncestor-EL8BTi8  reason: not valid java name */
    private final void m5614transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual((Object) nodeCoordinator2, (Object) nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.m5702transform58bKbWc(fArr);
            }
            long r1 = nodeCoordinator2.m5620getPositionnOccac();
            if (!IntOffset.m6747equalsimpl0(r1, IntOffset.Companion.m6758getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m4067resetimpl(fArr2);
                Matrix.m4078translateimpl$default(fArr2, (float) IntOffset.m6748getXimpl(r1), (float) IntOffset.m6749getYimpl(r1), 0.0f, 4, (Object) null);
                Matrix.m4075timesAssign58bKbWc(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8  reason: not valid java name */
    private final void m5613transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (!Intrinsics.areEqual((Object) nodeCoordinator, (Object) this)) {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            nodeCoordinator2.m5613transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
            if (!IntOffset.m6747equalsimpl0(m5620getPositionnOccac(), IntOffset.Companion.m6758getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m4067resetimpl(fArr2);
                Matrix.m4078translateimpl$default(fArr2, -((float) IntOffset.m6748getXimpl(m5620getPositionnOccac())), -((float) IntOffset.m6749getYimpl(m5620getPositionnOccac())), 0.0f, 4, (Object) null);
                Matrix.m4075timesAssign58bKbWc(fArr, fArr2);
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m5697inverseTransform58bKbWc(fArr);
            }
        }
    }

    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        } else if (layoutCoordinates.isAttached()) {
            NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
            coordinator.onCoordinatesUsed$ui_release();
            NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
            MutableRect rectCache = getRectCache();
            rectCache.setLeft(0.0f);
            rectCache.setTop(0.0f);
            rectCache.setRight((float) IntSize.m6790getWidthimpl(layoutCoordinates.m5318getSizeYbymL2g()));
            rectCache.setBottom((float) IntSize.m6789getHeightimpl(layoutCoordinates.m5318getSizeYbymL2g()));
            while (coordinator != findCommonAncestor$ui_release) {
                rectInParent$ui_release$default(coordinator, rectCache, z, false, 4, (Object) null);
                if (rectCache.isEmpty()) {
                    return Rect.Companion.getZero();
                }
                coordinator = coordinator.wrappedBy;
                Intrinsics.checkNotNull(coordinator);
            }
            ancestorToLocal(findCommonAncestor$ui_release, rectCache, z);
            return MutableRectKt.toRect(rectCache);
        } else {
            throw new IllegalStateException(("LayoutCoordinates " + layoutCoordinates + " is not attached!").toString());
        }
    }

    /* renamed from: ancestorToLocal-R5De75A  reason: not valid java name */
    private final long m5606ancestorToLocalR5De75A(NodeCoordinator nodeCoordinator, long j) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || Intrinsics.areEqual((Object) nodeCoordinator, (Object) nodeCoordinator2)) {
            return m5617fromParentPositionMKHz9U(j);
        }
        return m5617fromParentPositionMKHz9U(nodeCoordinator2.m5606ancestorToLocalR5De75A(nodeCoordinator, j));
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator != this) {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
            }
            fromParentRect(mutableRect, z);
        }
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m5627localToRootMKHz9U(long j) {
        if (isAttached()) {
            onCoordinatesUsed$ui_release();
            for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
                j = nodeCoordinator.m5633toParentPositionMKHz9U(j);
            }
            return j;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        float r0 = (float) IntOffset.m6748getXimpl(m5620getPositionnOccac());
        float r1 = (float) IntOffset.m6749getYimpl(m5620getPositionnOccac());
        canvas.translate(r0, r1);
        function1.invoke(canvas);
        canvas.translate(-r0, -r1);
    }

    /* renamed from: toParentPosition-MK-Hz9U  reason: not valid java name */
    public long m5633toParentPositionMKHz9U(long j) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.m5699mapOffset8S9VItk(j, false);
        }
        return IntOffsetKt.m6762plusNvtHpc(j, m5620getPositionnOccac());
    }

    /* renamed from: fromParentPosition-MK-Hz9U  reason: not valid java name */
    public long m5617fromParentPositionMKHz9U(long j) {
        long r3 = IntOffsetKt.m6760minusNvtHpc(j, m5620getPositionnOccac());
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.m5699mapOffset8S9VItk(r3, true) : r3;
    }

    /* access modifiers changed from: protected */
    public final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(new Rect(0.5f, 0.5f, ((float) IntSize.m6790getWidthimpl(m5404getMeasuredSizeYbymL2g())) - 0.5f, ((float) IntSize.m6789getHeightimpl(m5404getMeasuredSizeYbymL2g())) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        if (this.layer != null) {
            updateLayerBlock$default(this, (Function1) null, false, 2, (Object) null);
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
    }

    public final void rectInParent$ui_release(MutableRect mutableRect, boolean z, boolean z2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long r8 = m5619getMinimumTouchTargetSizeNHjbRc();
                    float r1 = Size.m3631getWidthimpl(r8) / 2.0f;
                    float r82 = Size.m3628getHeightimpl(r8) / 2.0f;
                    mutableRect.intersect(-r1, -r82, ((float) IntSize.m6790getWidthimpl(m5621getSizeYbymL2g())) + r1, ((float) IntSize.m6789getHeightimpl(m5621getSizeYbymL2g())) + r82);
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m6790getWidthimpl(m5621getSizeYbymL2g()), (float) IntSize.m6789getHeightimpl(m5621getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float r83 = (float) IntOffset.m6748getXimpl(m5620getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + r83);
        mutableRect.setRight(mutableRect.getRight() + r83);
        float r84 = (float) IntOffset.m6749getYimpl(m5620getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + r84);
        mutableRect.setBottom(mutableRect.getBottom() + r84);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float r0 = (float) IntOffset.m6748getXimpl(m5620getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - r0);
        mutableRect.setRight(mutableRect.getRight() - r0);
        float r02 = (float) IntOffset.m6749getYimpl(m5620getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - r02);
        mutableRect.setBottom(mutableRect.getBottom() - r02);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m6790getWidthimpl(m5621getSizeYbymL2g()), (float) IntSize.m6789getHeightimpl(m5621getSizeYbymL2g()));
                mutableRect.isEmpty();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: withinLayerBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m5637withinLayerBoundsk4lQ0M(long j) {
        if (!OffsetKt.m3579isFinitek4lQ0M(j)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || !this.isClipping || ownedLayer.m5698isInLayerk4lQ0M(j)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: isPointerInBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m5625isPointerInBoundsk4lQ0M(long j) {
        float r0 = Offset.m3562getXimpl(j);
        float r3 = Offset.m3563getYimpl(j);
        return r0 >= 0.0f && r3 >= 0.0f && r0 < ((float) getMeasuredWidth()) && r3 < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNode2 = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode3 = getLayoutNode();
        if (layoutNode2 == layoutNode3) {
            Modifier.Node tail = nodeCoordinator.getTail();
            DelegatableNode tail2 = getTail();
            int r2 = NodeKind.m5647constructorimpl(2);
            if (tail2.getNode().isAttached()) {
                for (Modifier.Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                    if ((parent$ui_release.getKindSet$ui_release() & r2) != 0 && parent$ui_release == tail) {
                        return nodeCoordinator;
                    }
                }
                return this;
            }
            throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode3.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode3.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode3 = layoutNode3.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode3);
        }
        while (layoutNode2 != layoutNode3) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            layoutNode3 = layoutNode3.getParent$ui_release();
            if (layoutNode2 != null) {
                if (layoutNode3 == null) {
                }
            }
            throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        }
        if (layoutNode3 == getLayoutNode()) {
            return this;
        }
        return layoutNode2 == nodeCoordinator.getLayoutNode() ? nodeCoordinator : layoutNode2.getInnerCoordinator$ui_release();
    }

    /* renamed from: offsetFromEdge-MK-Hz9U  reason: not valid java name */
    private final long m5610offsetFromEdgeMKHz9U(long j) {
        float f;
        float f2;
        float r0 = Offset.m3562getXimpl(j);
        if (r0 < 0.0f) {
            f = -r0;
        } else {
            f = r0 - ((float) getMeasuredWidth());
        }
        float max = Math.max(0.0f, f);
        float r4 = Offset.m3563getYimpl(j);
        if (r4 < 0.0f) {
            f2 = -r4;
        } else {
            f2 = r4 - ((float) getMeasuredHeight());
        }
        return OffsetKt.Offset(max, Math.max(0.0f, f2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU  reason: not valid java name */
    public final long m5615calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m3631getWidthimpl(j) - ((float) getMeasuredWidth())) / 2.0f), Math.max(0.0f, (Size.m3628getHeightimpl(j) - ((float) getMeasuredHeight())) / 2.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: distanceInMinimumTouchTarget-tz77jQw  reason: not valid java name */
    public final float m5616distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (((float) getMeasuredWidth()) >= Size.m3631getWidthimpl(j2) && ((float) getMeasuredHeight()) >= Size.m3628getHeightimpl(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        long r6 = m5615calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float r0 = Size.m3631getWidthimpl(r6);
        float r62 = Size.m3628getHeightimpl(r6);
        long r4 = m5610offsetFromEdgeMKHz9U(j);
        if ((r0 > 0.0f || r62 > 0.0f) && Offset.m3562getXimpl(r4) <= r0 && Offset.m3563getYimpl(r4) <= r62) {
            return Offset.m3561getDistanceSquaredimpl(r4);
        }
        return Float.POSITIVE_INFINITY;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    public final void onMeasured() {
        Snapshot makeCurrent;
        Modifier.Node node;
        if (m5607hasNodeH91voCI(NodeKind.m5647constructorimpl(128))) {
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                int r0 = NodeKind.m5647constructorimpl(128);
                boolean r3 = NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(r0);
                if (r3) {
                    node = getTail();
                } else {
                    node = getTail().getParent$ui_release();
                    if (node == null) {
                        Unit unit = Unit.INSTANCE;
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        createNonObservableSnapshot.dispose();
                    }
                }
                Modifier.Node access$headNode = headNode(r3);
                while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r0) != 0) {
                    if ((access$headNode.getKindSet$ui_release() & r0) != 0) {
                        Modifier.Node node2 = access$headNode;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) node2).m5493onRemeasuredozmzZPI(m5404getMeasuredSizeYbymL2g());
                            } else if ((node2.getKindSet$ui_release() & r0) != 0 && (node2 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node2 = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (access$headNode == node) {
                        break;
                    }
                    access$headNode = access$headNode.getChild$ui_release();
                }
                Unit unit2 = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
            } catch (Throwable th) {
                createNonObservableSnapshot.dispose();
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        Modifier.Node r6 = m5622headH91voCI(NodeKind.m5647constructorimpl(4));
        if (r6 == null) {
            performDraw(canvas);
            return;
        }
        getLayoutNode().getMDrawScope$ui_release().m5515drawx_KDEd0$ui_release(canvas, IntSizeKt.m6800toSizeozmzZPI(m5621getSizeYbymL2g()), this, r6);
    }

    public final void onPlaced() {
        int r0 = NodeKind.m5647constructorimpl(128);
        boolean r1 = NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(r0);
        Modifier.Node tail = getTail();
        if (r1 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r1);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r0) != 0) {
                if ((access$headNode.getKindSet$ui_release() & r0) != 0) {
                    Modifier.Node node = access$headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof LayoutAwareModifierNode) {
                            ((LayoutAwareModifierNode) node).onPlaced(this);
                        } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node headNode = headNode(NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(NodeKind.m5647constructorimpl(16)));
        if (headNode != null && headNode.isAttached()) {
            DelegatableNode delegatableNode = headNode;
            int r3 = NodeKind.m5647constructorimpl(16);
            if (delegatableNode.getNode().isAttached()) {
                Modifier.Node node = delegatableNode.getNode();
                if ((node.getAggregateChildKindSet$ui_release() & r3) != 0) {
                    for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                        if ((child$ui_release.getKindSet$ui_release() & r3) != 0) {
                            Modifier.Node node2 = child$ui_release;
                            MutableVector mutableVector = null;
                            while (node2 != null) {
                                if (node2 instanceof PointerInputModifierNode) {
                                    if (((PointerInputModifierNode) node2).sharePointerInputWithSiblings()) {
                                        return true;
                                    }
                                } else if ((node2.getKindSet$ui_release() & r3) != 0 && (node2 instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r3) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node2 = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                    }
                }
            } else {
                throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
            }
        }
        return false;
    }
}
